package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends h, D extends j, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean aSA;
    private boolean aSB;
    private boolean aSC;
    private c<T, D> aSu;
    private d<T, D> aSv;
    protected T aSw;
    private final NetModelType aSx;
    private a<T, D, ActivityType> aSy;
    private boolean aSz;
    private Runnable amd;
    private boolean isLoading;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK
    }

    /* loaded from: classes.dex */
    public interface b<T extends h, D extends j> extends c<T, D>, d<T, D> {
    }

    /* loaded from: classes.dex */
    public interface c<T extends h, D extends j> {
        void a(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes.dex */
    public interface d<T extends h, D extends j> {
        void a(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    protected abstract int JS();

    protected abstract int JT();

    protected abstract String JU();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aSy = null;
        this.isNeedCache = false;
        this.aSz = false;
        this.aSA = false;
        this.aSB = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aSC = true;
        this.mPageContext = tbPageContext;
        this.aSw = t;
        this.aSx = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable JV() {
        if (this.amd == null) {
            this.amd = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.aSD[NetModel.this.aSx.ordinal()]) {
                        case 1:
                            NetModel.this.l(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                            return;
                        case 2:
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.amd;
    }

    public boolean JW() {
        if (this.aSv == null && this.aSu == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aSC = l.jU();
        if (this.timeout >= 10) {
            e.im().postDelayed(JV(), this.timeout * 1000);
        }
        switch (this.aSx) {
            case TYPE_AUTO:
                if (!this.aSC) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.l(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                JZ();
                Kb();
                JX();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aSw, JS(), JT());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.aSC) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Kb();
                JX();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aSw, JT());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.aSC) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Ka();
                JX();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aSw, JS());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> JB = this.aSw.JB();
                if (JB != null) {
                    for (Map.Entry<String, Object> entry : JB.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.aSC) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                } else if (this.aSy == null) {
                    this.aSy = new a<>(this);
                    this.aSy.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void JX() {
        if (!this.aSB) {
            switch (this.aSx) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(JS(), JT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.amd != null) {
                                e.im().removeCallbacks(NetModel.this.amd);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aSu != null) {
                                    NetModel.this.aSu.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aSv != null) {
                                    NetModel.this.aSv.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                            }
                        }
                    };
                    aVar.getHttpMessageListener().setSelfListener(true);
                    aVar.getSocketMessageListener().setSelfListener(true);
                    aVar.setTag(getUniqueId());
                    registerListener(aVar);
                    break;
                case TYPE_SOCKET:
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(JT(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.amd != null) {
                                e.im().removeCallbacks(NetModel.this.amd);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.aSv != null) {
                                        NetModel.this.aSv.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(JS(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.amd != null) {
                                e.im().removeCallbacks(NetModel.this.amd);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.aSu != null) {
                                        NetModel.this.aSu.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
                    registerListener(httpMessageListener);
                    break;
            }
            this.aSB = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> JQ() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> JY() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> JR() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean AO() {
        return this.isLoading;
    }

    private void JZ() {
        if (!this.aSz && MessageManager.getInstance().findTask(JS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(JS(), TbConfig.SERVER_ADDRESS + JU() + "?cmd=" + JT());
            tbHttpMessageTask.setResponsedClass(JQ());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(JS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aSz = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Ka() {
        if (!this.aSz && MessageManager.getInstance().findTask(JS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(JS(), TbConfig.SERVER_ADDRESS + JU());
            tbHttpMessageTask.setResponsedClass(JY());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(JS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aSz = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Kb() {
        if (!this.aSA && MessageManager.getInstance().findTask(JT()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(JT());
            bVar.setResponsedClass(JR());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(JT());
            MessageManager.getInstance().registerTask(bVar);
            this.aSA = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(JT(), this.unique_id);
        MessageManager.getInstance().removeMessage(JS(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aSw, JS(), JT());
        if (this.aSv != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(JT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aSv.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aSu != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(JS()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aSu.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        if (this.aSu != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aSw, JS());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(JS());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aSu.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aSw, JT());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(JT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aSv.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc() {
        this.aSy = null;
    }

    public void a(b<T, D> bVar) {
        this.aSu = bVar;
        this.aSv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aSE;
        private com.baidu.tbadk.core.util.a.a aSF;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aSE = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aSE).isLoading = true;
            y yVar = new y(TbConfig.SERVER_ADDRESS + this.aSE.JU());
            for (Map.Entry<String, Object> entry : this.aSE.aSw.JB().entrySet()) {
                yVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String yz = yVar.yz();
            this.aSF = yVar.yX();
            D l = l(this.aSE.getResponseDataClass());
            if (yz != null) {
                try {
                    l.v(new JSONObject(yz));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aSE.isNeedCache() && this.aSF != null && this.aSF.zY() != null && this.aSF.zY().isRequestSuccess() && l != null && (this.aSE.aSw instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aSE.aSw;
                String cacheKey = eVar.getCacheKey();
                String Jy = eVar.Jy();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Jy) || l == null) {
                    return l;
                }
                com.baidu.adp.lib.cache.l<String> R = com.baidu.tbadk.core.c.a.xj().R(Jy, currentAccount);
                if (R == null) {
                    return l;
                }
                R.e(cacheKey, yz);
            }
            return l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.aSE).isLoading = false;
                if (((NetModel) this.aSE).amd != null) {
                    e.im().removeCallbacks(((NetModel) this.aSE).amd);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aSE.aSw, this.aSE.JS());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aSE.JS());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aSF != null && this.aSF.zY() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aSF.zY().zZ, this.aSF.zY().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aSF.zY().asr);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aSF.zY().mErrorString);
                    if (this.aSF.zY().ass != null) {
                        BdLog.e(this.aSF.zY().ass);
                    }
                }
                this.aSE.Kc();
                if (((NetModel) this.aSE).aSu != null) {
                    ((NetModel) this.aSE).aSu.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D l(Class<D> cls) {
            try {
                return cls.newInstance();
            } catch (ExceptionInInitializerError e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
    }
}
