package com.baidu.tieba.flutter.plugin.networkService;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin;
import d.a.c.c.g.a;
import d.a.c.c.g.c;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.m0.g0.b.g;
import d.a.m0.g0.b.h;
import d.a.m0.v0.b;
import java.util.HashMap;
import java.util.Map;
import protobuf.Error;
/* loaded from: classes4.dex */
public class FlutterNetModelAuto<T extends g, D extends h> implements NetworkServicePlugin.NetModel {
    public static final int TIMOUT_MIN = 10;
    public T data;
    public NetModelHttpCallback<T, D> httpCallback;
    public String identifier;
    public int mHttpCmd;
    public String mHttpUrl;
    public int mSocketCmd;
    public Class<T> requestDataClass;
    public Class<D> responseDataClass;
    public NetModelSocketCallback<T, D> socketCallback;
    public TbSocketMessage socketMsg;
    public Runnable timeoutRunnable;
    public final NetModelType type;
    public boolean mNeedCompress = false;
    public boolean isNeedParallel = false;
    public BdUniqueId unique_id = null;
    public boolean isNeedCache = false;
    public boolean hadCheckHttpTask = false;
    public boolean hadCheckSocketTask = false;
    public boolean hadCheckListener = false;
    public boolean isLoading = false;
    public int timeout = -1;
    public boolean isNetOk = true;

    /* renamed from: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto$11  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType;

        static {
            int[] iArr = new int[NetModelType.values().length];
            $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType = iArr;
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[NetModelType.TYPE_HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface NetModelCallback<T extends g, D extends h> extends NetModelHttpCallback<T, D>, NetModelSocketCallback<T, D> {
    }

    /* loaded from: classes4.dex */
    public interface NetModelHttpCallback<T extends g, D extends h> {
        void onHttpResponseMessage(String str, HashMap<String, String> hashMap, MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes4.dex */
    public interface NetModelSocketCallback<T extends g, D extends h> {
        void onSocketResponseMessage(String str, HashMap<String, String> hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage);
    }

    /* loaded from: classes4.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO
    }

    public FlutterNetModelAuto(String str, NetModelType netModelType) {
        this.identifier = str;
        this.type = netModelType;
    }

    private void checkHttpJsonTask() {
        if (this.hadCheckHttpTask || MessageManager.getInstance().findTask(getHttpCmd()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(getHttpCmd(), getHttpUrl());
        tbHttpMessageTask.setResponsedClass(getHttpJsonTaskMessageClass());
        onRegisterHttpJsonTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(getHttpCmd());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hadCheckHttpTask = true;
    }

    private void checkHttpProtobufTask() {
        if (this.hadCheckHttpTask || MessageManager.getInstance().findTask(getHttpCmd()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(getHttpCmd(), getHttpUrl() + "?cmd=" + getSocketCmd());
        tbHttpMessageTask.setResponsedClass(getHttpProtobufTaskMessageClass());
        onRegisterHttpProtobufTask(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(getHttpCmd());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hadCheckHttpTask = true;
    }

    private void checkListener() {
        if (this.hadCheckListener) {
            return;
        }
        int i2 = AnonymousClass11.$SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[this.type.ordinal()];
        if (i2 == 1) {
            a aVar = new a(getHttpCmd(), getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.5
                @Override // d.a.c.c.g.a
                public void onMessage(ResponsedMessage<?> responsedMessage) {
                    FlutterNetModelAuto.this.isLoading = false;
                    if (FlutterNetModelAuto.this.timeoutRunnable != null) {
                        e.a().removeCallbacks(FlutterNetModelAuto.this.timeoutRunnable);
                    }
                    if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                        MvcNetMessage<T, D> mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                        if (FlutterNetModelAuto.this.httpCallback != null) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("server", FlutterNetModelAuto.this.getHttpUrl());
                            hashMap.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.getHttpCmd() + "");
                            hashMap.put("state", responsedMessage.getError() + "_" + responsedMessage.getErrorString());
                            FlutterNetModelAuto.this.httpCallback.onHttpResponseMessage(FlutterNetModelAuto.this.identifier, hashMap, (MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                        }
                    } else if (responsedMessage instanceof SocketResponsedMessage) {
                        MvcNetMessage<T, D> mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                        if (FlutterNetModelAuto.this.socketCallback != null) {
                            HashMap<String, String> hashMap2 = new HashMap<>();
                            hashMap2.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.getSocketCmd() + "");
                            hashMap2.put("state", responsedMessage.getError() + "_" + responsedMessage.getErrorString());
                            FlutterNetModelAuto.this.socketCallback.onSocketResponseMessage(FlutterNetModelAuto.this.identifier, hashMap2, (SocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                        }
                    } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                        throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                    }
                }
            };
            aVar.getHttpMessageListener().setSelfListener(true);
            aVar.getSocketMessageListener().setSelfListener(true);
            aVar.setTag(getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        } else if (i2 == 2) {
            c cVar = new c(getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                    FlutterNetModelAuto.this.isLoading = false;
                    if (FlutterNetModelAuto.this.timeoutRunnable != null) {
                        e.a().removeCallbacks(FlutterNetModelAuto.this.timeoutRunnable);
                    }
                    if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                        if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                            if (FlutterNetModelAuto.this.socketCallback != null) {
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.getSocketCmd() + "");
                                hashMap.put("state", socketResponsedMessage.getError() + "_" + socketResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.socketCallback.onSocketResponseMessage(FlutterNetModelAuto.this.identifier, hashMap, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                            }
                        } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                            throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                        }
                    } else if (!(socketResponsedMessage instanceof SocketResponsedMessage) || FlutterNetModelAuto.this.socketCallback == null) {
                    } else {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.getSocketCmd() + "");
                        hashMap2.put("state", socketResponsedMessage.getError() + "_" + socketResponsedMessage.getErrorString());
                        FlutterNetModelAuto.this.socketCallback.onSocketResponseMessage(FlutterNetModelAuto.this.identifier, hashMap2, socketResponsedMessage, (SocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                    }
                }
            };
            cVar.setTag(getUniqueId());
            MessageManager.getInstance().registerListener(cVar);
        } else if (i2 == 3) {
            HttpMessageListener httpMessageListener = new HttpMessageListener(getHttpCmd(), true) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    FlutterNetModelAuto.this.isLoading = false;
                    if (FlutterNetModelAuto.this.timeoutRunnable != null) {
                        e.a().removeCallbacks(FlutterNetModelAuto.this.timeoutRunnable);
                    }
                    if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                        if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                            if (FlutterNetModelAuto.this.httpCallback != null) {
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("server", FlutterNetModelAuto.this.getHttpUrl());
                                hashMap.put(RetrieveTaskManager.KEY, FlutterNetModelAuto.this.getHttpCmd() + "");
                                hashMap.put("state", httpResponsedMessage.getError() + "_" + httpResponsedMessage.getErrorString());
                                FlutterNetModelAuto.this.httpCallback.onHttpResponseMessage(FlutterNetModelAuto.this.identifier, hashMap, (MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                            }
                        } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                            throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                        }
                    } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                        throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
                    }
                }
            };
            httpMessageListener.setTag(getUniqueId());
            MessageManager.getInstance().registerListener(httpMessageListener);
        }
        this.hadCheckListener = true;
    }

    private void checkSocketTask() {
        if (this.hadCheckSocketTask || MessageManager.getInstance().findTask(getSocketCmd()) != null) {
            return;
        }
        b bVar = new b(getSocketCmd());
        bVar.setResponsedClass(getSocketTaskMessageClass());
        bVar.h(getNeedCompress());
        if (getNeedParallel()) {
            bVar.setParallel(TiebaIMConfig.getParallel());
        }
        onRegisterSocketTask(bVar);
        MessageManager.getInstance().unRegisterTask(getSocketCmd());
        MessageManager.getInstance().registerTask(bVar);
        this.hadCheckSocketTask = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHttpCallback(int i2, String str) {
        if (this.httpCallback != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.data, getHttpCmd());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(getHttpCmd());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i2);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(RetrieveTaskManager.KEY, getHttpCmd() + "");
            this.httpCallback.onHttpResponseMessage(this.identifier, hashMap, mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNetCallback(int i2, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.data, getHttpCmd(), getSocketCmd());
        if (this.socketCallback != null) {
            MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.8
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                public Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i2);
            mvcSocketResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(RetrieveTaskManager.KEY, getSocketCmd() + "");
            this.socketCallback.onSocketResponseMessage(this.identifier, hashMap, mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.httpCallback != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(getHttpCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.9
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                public Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i2);
            mvcHttpResponsedMessage.setErrorString(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(RetrieveTaskManager.KEY, getHttpCmd() + "");
            this.httpCallback.onHttpResponseMessage(this.identifier, hashMap2, mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySocketCallback(int i2, String str) {
        MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.data, getSocketCmd());
        MvcSocketResponsedMessage mvcSocketResponsedMessage = new MvcSocketResponsedMessage(getSocketCmd()) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.10
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            public Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i2);
        mvcSocketResponsedMessage.setErrorString(str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(RetrieveTaskManager.KEY, getSocketCmd() + "");
        this.socketCallback.onSocketResponseMessage(this.identifier, hashMap, mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.NetModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(getSocketCmd(), this.unique_id);
        MessageManager.getInstance().removeMessage(getHttpCmd(), this.unique_id);
        return true;
    }

    public int getHttpCmd() {
        return this.mHttpCmd;
    }

    public Class<? extends MvcJsonHttpResponsedMessage> getHttpJsonTaskMessageClass() {
        return MvcJsonHttpResponsedMessage.class;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> getHttpProtobufTaskMessageClass() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    public String getHttpUrl() {
        return this.mHttpUrl;
    }

    public boolean getNeedCompress() {
        return this.mNeedCompress;
    }

    public boolean getNeedParallel() {
        return this.isNeedParallel;
    }

    public T getRequestData() {
        return this.data;
    }

    public Class<T> getRequestDataClass() {
        return this.requestDataClass;
    }

    public Class<D> getResponseDataClass() {
        return this.responseDataClass;
    }

    public int getSocketCmd() {
        return this.mSocketCmd;
    }

    public TbSocketMessage getSocketRequestMsg() {
        return this.socketMsg;
    }

    public Class<? extends MvcSocketResponsedMessage> getSocketTaskMessageClass() {
        return MvcSocketResponsedMessage.class;
    }

    public Runnable getTimeoutRunnable() {
        if (this.timeoutRunnable == null) {
            this.timeoutRunnable = new Runnable() { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.1
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = AnonymousClass11.$SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[FlutterNetModelAuto.this.type.ordinal()];
                    if (i2 == 1) {
                        FlutterNetModelAuto.this.notifyNetCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    } else if (i2 == 2) {
                        FlutterNetModelAuto.this.notifySocketCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    } else if (i2 != 3) {
                    } else {
                        FlutterNetModelAuto.this.notifyHttpCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                }
            };
        }
        return this.timeoutRunnable;
    }

    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public boolean loadData() {
        if (this.socketCallback == null && this.httpCallback == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.isNetOk = l.D();
        if (this.timeout >= 10) {
            e.a().postDelayed(getTimeoutRunnable(), this.timeout * 1000);
        }
        int i2 = AnonymousClass11.$SwitchMap$com$baidu$tieba$flutter$plugin$networkService$FlutterNetModelAuto$NetModelType[this.type.ordinal()];
        if (i2 == 1) {
            if (!this.isNetOk) {
                e.a().post(new Runnable() { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FlutterNetModelAuto.this.notifyNetCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                });
                return false;
            }
            this.isLoading = true;
            checkHttpProtobufTask();
            checkSocketTask();
            checkListener();
            MvcNetMessage mvcNetMessage = new MvcNetMessage(this.data, getHttpCmd(), getSocketCmd());
            mvcNetMessage.setNeedCache(isNeedCache());
            mvcNetMessage.setResponseDataClass(getResponseDataClass());
            mvcNetMessage.setTag(this.unique_id);
            HashMap<String, String> q = this.data.q();
            if (q != null) {
                for (Map.Entry<String, String> entry : q.entrySet()) {
                    mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                }
            }
            MessageManager.getInstance().sendMessage(mvcNetMessage);
            return true;
        } else if (i2 == 2) {
            if (!this.isNetOk) {
                e.a().post(new Runnable() { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FlutterNetModelAuto.this.notifySocketCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                });
                return false;
            }
            this.isLoading = true;
            checkSocketTask();
            checkListener();
            if (this.data != null) {
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.data, getSocketCmd());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                MessageManager.getInstance().sendMessage(mvcSocketMessage);
            }
            if (this.socketMsg != null) {
                MessageManager.getInstance().sendMessage(this.socketMsg);
            }
            return true;
        } else if (i2 != 3) {
            return false;
        } else {
            if (!this.isNetOk) {
                e.a().post(new Runnable() { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FlutterNetModelAuto.this.notifyHttpCallback(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                });
                return false;
            }
            this.isLoading = true;
            checkHttpJsonTask();
            checkListener();
            MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.data, getHttpCmd());
            mvcHttpMessage.setResponseDataClass(getResponseDataClass());
            HashMap<String, Object> o = this.data.o();
            if (o != null) {
                for (Map.Entry<String, Object> entry2 : o.entrySet()) {
                    mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                }
            }
            HashMap<String, String> q2 = this.data.q();
            if (q2 != null) {
                for (Map.Entry<String, String> entry3 : q2.entrySet()) {
                    mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                }
            }
            mvcHttpMessage.setNeedCache(isNeedCache());
            mvcHttpMessage.setTag(this.unique_id);
            MessageManager.getInstance().sendMessage(mvcHttpMessage);
            return true;
        }
    }

    @Deprecated
    public boolean loadNextPageData() {
        return false;
    }

    @Deprecated
    public boolean loadPrevPageData() {
        return false;
    }

    public void onRegisterHttpJsonTask(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void onRegisterHttpProtobufTask(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void onRegisterSocketTask(b bVar) {
    }

    public void setCallback(NetModelCallback<T, D> netModelCallback) {
        this.httpCallback = netModelCallback;
        this.socketCallback = netModelCallback;
    }

    public void setHttpCallback(NetModelHttpCallback<T, D> netModelHttpCallback) {
        this.httpCallback = netModelHttpCallback;
    }

    public void setHttpCmd(int i2) {
        this.mHttpCmd = i2;
    }

    public void setHttpUrl(String str) {
        this.mHttpUrl = str;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public void setNeedCompress(boolean z) {
        this.mNeedCompress = z;
    }

    public void setNeedParallel(boolean z) {
        this.isNeedParallel = z;
    }

    public void setRequestData(T t) {
        this.data = t;
    }

    public void setRequestDataClass(Class<T> cls) {
        this.requestDataClass = cls;
    }

    public void setResponseDataClass(Class<D> cls) {
        this.responseDataClass = cls;
    }

    public void setSocketCallback(NetModelSocketCallback<T, D> netModelSocketCallback) {
        this.socketCallback = netModelSocketCallback;
    }

    public void setSocketCmd(int i2) {
        this.mSocketCmd = i2;
    }

    public void setSocketRequestMsg(TbSocketMessage tbSocketMessage) {
        this.socketMsg = tbSocketMessage;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }
}
