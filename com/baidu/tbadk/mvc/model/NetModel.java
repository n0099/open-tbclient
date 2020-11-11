package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
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
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends h, D extends j, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean caK;
    private Runnable caL;
    protected T caX;
    private boolean cbc;
    private boolean cbd;
    private boolean cbe;
    private c<T, D> ftR;
    private d<T, D> ftS;
    private final NetModelType ftT;
    private a<T, D, ActivityType> ftU;
    private boolean isLoading;
    private boolean isNeedCache;
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

    protected abstract String aar();

    protected abstract int aax();

    protected abstract int aay();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.ftU = null;
        this.isNeedCache = false;
        this.cbc = false;
        this.cbd = false;
        this.cbe = false;
        this.isLoading = false;
        this.timeout = -1;
        this.caK = true;
        this.caX = t;
        this.ftT = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable aaw() {
        if (this.caL == null) {
            this.caL = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.ftV[NetModel.this.ftT.ordinal()]) {
                        case 1:
                            NetModel.this.aa(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            NetModel.this.ab(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.Z(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.caL;
    }

    public boolean loadData() {
        if (this.ftS == null && this.ftR == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.caK = l.isNetOk();
        if (this.timeout >= 10) {
            e.mY().postDelayed(aaw(), this.timeout * 1000);
        }
        switch (this.ftT) {
            case TYPE_AUTO:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.aa(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aaE();
                aaG();
                aaA();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.caX, aay(), aax());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> bBz = this.caX.bBz();
                if (bBz != null) {
                    for (Map.Entry<String, String> entry : bBz.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.ab(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aaG();
                aaA();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.caX, aax());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.Z(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aaF();
                aaA();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.caX, aay());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> bBy = this.caX.bBy();
                if (bBy != null) {
                    for (Map.Entry<String, Object> entry2 : bBy.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> bBz2 = this.caX.bBz();
                if (bBz2 != null) {
                    for (Map.Entry<String, String> entry3 : bBz2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.caK) {
                    e.mY().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.Z(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.ftU == null) {
                    this.ftU = new a<>(this);
                    this.ftU.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void aaA() {
        if (!this.cbe) {
            switch (this.ftT) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(aay(), aax()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.caL != null) {
                                e.mY().removeCallbacks(NetModel.this.caL);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.ftR != null) {
                                    NetModel.this.ftR.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.ftS != null) {
                                    NetModel.this.ftS.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(aax(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.caL != null) {
                                e.mY().removeCallbacks(NetModel.this.caL);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.ftS != null) {
                                        NetModel.this.ftS.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(aay(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.caL != null) {
                                e.mY().removeCallbacks(NetModel.this.caL);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.ftR != null) {
                                        NetModel.this.ftR.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.cbe = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aaB() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> aaC() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> aaD() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    private void aaE() {
        if (!this.cbc && MessageManager.getInstance().findTask(aay()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aay(), TbConfig.SERVER_ADDRESS + aar() + "?cmd=" + aax());
            tbHttpMessageTask.setResponsedClass(aaB());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aay());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cbc = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aaF() {
        if (!this.cbc && MessageManager.getInstance().findTask(aay()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aay(), TbConfig.SERVER_ADDRESS + aar());
            tbHttpMessageTask.setResponsedClass(aaC());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aay());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cbc = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aaG() {
        if (!this.cbd && MessageManager.getInstance().findTask(aax()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(aax());
            bVar.setResponsedClass(aaD());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(aax());
            MessageManager.getInstance().registerTask(bVar);
            this.cbd = true;
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
        MessageManager.getInstance().removeMessage(aax(), this.unique_id);
        MessageManager.getInstance().removeMessage(aay(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.caX, aay(), aax());
        if (this.ftS != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aax()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.ftS.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.ftR != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(aay()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.ftR.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.ftR != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.caX, aay());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(aay());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.ftR.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.caX, aax());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aax()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.ftS.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aat() {
        this.ftU = null;
    }

    public void a(b<T, D> bVar) {
        this.ftR = bVar;
        this.ftS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private com.baidu.tbadk.core.util.a.a caR;
        private NetModel<T, D, ActivityType> ftW;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.ftW = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.ftW).isLoading = true;
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + this.ftW.aar());
            for (Map.Entry<String, Object> entry : this.ftW.caX.bBy().entrySet()) {
                aaVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = aaVar.postNetData();
            this.caR = aaVar.bqN();
            D v = v(this.ftW.getResponseDataClass());
            if (postNetData != null) {
                try {
                    v.initByJson(new JSONObject(postNetData));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(v);
            if (this.ftW.isNeedCache() && this.caR != null && this.caR.bru() != null && this.caR.bru().isRequestSuccess() && v != null && (this.ftW.caX instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.ftW.caX;
                String cacheKey = eVar.getCacheKey();
                String bBv = eVar.bBv();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(bBv) || v == null) {
                    return v;
                }
                com.baidu.adp.lib.cache.l<String> dI = com.baidu.tbadk.core.c.a.boX().dI(bBv, currentAccount);
                if (dI == null) {
                    return v;
                }
                dI.setForever(cacheKey, postNetData);
            }
            return v;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.ftW).isLoading = false;
                if (((NetModel) this.ftW).caL != null) {
                    e.mY().removeCallbacks(((NetModel) this.ftW).caL);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.ftW.caX, this.ftW.aay());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.ftW.aay());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.caR != null && this.caR.bru() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.caR.bru().mNetErrorCode, this.caR.bru().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.caR.bru().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.caR.bru().mErrorString);
                    if (this.caR.bru().mException != null) {
                        BdLog.e(this.caR.bru().mException);
                    }
                }
                this.ftW.aat();
                if (((NetModel) this.ftW).ftR != null) {
                    ((NetModel) this.ftW).ftR.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D v(Class<D> cls) {
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
