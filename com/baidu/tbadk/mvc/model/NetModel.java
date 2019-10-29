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
import com.baidu.tbadk.core.util.x;
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
    private c<T, D> cKN;
    private d<T, D> cKO;
    protected T cKP;
    private final NetModelType cKQ;
    private a<T, D, ActivityType> cKR;
    private boolean cKS;
    private boolean cKT;
    private boolean cKU;
    private int cKV;
    private boolean cKW;
    private Runnable cKX;
    private boolean isLoading;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;

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

    protected abstract int awg();

    protected abstract int awh();

    protected abstract String awi();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.cKR = null;
        this.isNeedCache = false;
        this.cKS = false;
        this.cKT = false;
        this.cKU = false;
        this.isLoading = false;
        this.cKV = -1;
        this.cKW = true;
        this.mPageContext = tbPageContext;
        this.cKP = t;
        this.cKQ = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable awj() {
        if (this.cKX == null) {
            this.cKX = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.cKY[NetModel.this.cKQ.ordinal()]) {
                        case 1:
                            NetModel.this.K(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 2:
                            NetModel.this.M(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.L(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.cKX;
    }

    public boolean loadData() {
        if (this.cKO == null && this.cKN == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cKW = l.isNetOk();
        if (this.cKV >= 10) {
            e.fZ().postDelayed(awj(), this.cKV * 1000);
        }
        switch (this.cKQ) {
            case TYPE_AUTO:
                if (!this.cKW) {
                    e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.K(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                awm();
                awo();
                awk();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.cKP, awg(), awh());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> avO = this.cKP.avO();
                if (avO != null) {
                    for (Map.Entry<String, String> entry : avO.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.cKW) {
                    e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.M(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                awo();
                awk();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.cKP, awh());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.cKW) {
                    e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.L(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                awn();
                awk();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.cKP, awg());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> avN = this.cKP.avN();
                if (avN != null) {
                    for (Map.Entry<String, Object> entry2 : avN.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> avO2 = this.cKP.avO();
                if (avO2 != null) {
                    for (Map.Entry<String, String> entry3 : avO2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.cKW) {
                    e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.L(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.cKR == null) {
                    this.cKR = new a<>(this);
                    this.cKR.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void awk() {
        if (!this.cKU) {
            switch (this.cKQ) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(awg(), awh()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cKX != null) {
                                e.fZ().removeCallbacks(NetModel.this.cKX);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.cKN != null) {
                                    NetModel.this.cKN.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.cKO != null) {
                                    NetModel.this.cKO.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(awh(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cKX != null) {
                                e.fZ().removeCallbacks(NetModel.this.cKX);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.cKO != null) {
                                        NetModel.this.cKO.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(awg(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cKX != null) {
                                e.fZ().removeCallbacks(NetModel.this.cKX);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.cKN != null) {
                                        NetModel.this.cKN.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.cKU = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> awe() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> awl() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> awf() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    private void awm() {
        if (!this.cKS && MessageManager.getInstance().findTask(awg()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(awg(), TbConfig.SERVER_ADDRESS + awi() + "?cmd=" + awh());
            tbHttpMessageTask.setResponsedClass(awe());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(awg());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cKS = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void awn() {
        if (!this.cKS && MessageManager.getInstance().findTask(awg()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(awg(), TbConfig.SERVER_ADDRESS + awi());
            tbHttpMessageTask.setResponsedClass(awl());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(awg());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cKS = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void awo() {
        if (!this.cKT && MessageManager.getInstance().findTask(awh()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(awh());
            bVar.setResponsedClass(awf());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(awh());
            MessageManager.getInstance().registerTask(bVar);
            this.cKT = true;
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
        MessageManager.getInstance().removeMessage(awh(), this.unique_id);
        MessageManager.getInstance().removeMessage(awg(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.cKP, awg(), awh());
        if (this.cKO != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(awh()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.cKO.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.cKN != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(awg()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.cKN.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        if (this.cKN != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.cKP, awg());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(awg());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.cKN.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.cKP, awh());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(awh()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.cKO.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awp() {
        this.cKR = null;
    }

    public void a(b<T, D> bVar) {
        this.cKN = bVar;
        this.cKO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> cKZ;
        private com.baidu.tbadk.core.util.a.a cLa;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.cKZ = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.cKZ).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.cKZ.awi());
            for (Map.Entry<String, Object> entry : this.cKZ.cKP.avN().entrySet()) {
                xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = xVar.postNetData();
            this.cLa = xVar.amr();
            D n = n(this.cKZ.getResponseDataClass());
            if (postNetData != null) {
                try {
                    n.initByJson(new JSONObject(postNetData));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(n);
            if (this.cKZ.isNeedCache() && this.cLa != null && this.cLa.amS() != null && this.cLa.amS().isRequestSuccess() && n != null && (this.cKZ.cKP instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.cKZ.cKP;
                String cacheKey = eVar.getCacheKey();
                String avK = eVar.avK();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(avK) || n == null) {
                    return n;
                }
                com.baidu.adp.lib.cache.l<String> bK = com.baidu.tbadk.core.d.a.akN().bK(avK, currentAccount);
                if (bK == null) {
                    return n;
                }
                bK.setForever(cacheKey, postNetData);
            }
            return n;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.cKZ).isLoading = false;
                if (((NetModel) this.cKZ).cKX != null) {
                    e.fZ().removeCallbacks(((NetModel) this.cKZ).cKX);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.cKZ.cKP, this.cKZ.awg());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.cKZ.awg());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.cLa != null && this.cLa.amS() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.cLa.amS().mNetErrorCode, this.cLa.amS().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.cLa.amS().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.cLa.amS().mErrorString);
                    if (this.cLa.amS().mException != null) {
                        BdLog.e(this.cLa.amS().mException);
                    }
                }
                this.cKZ.awp();
                if (((NetModel) this.cKZ).cKN != null) {
                    ((NetModel) this.cKZ).cKN.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D n(Class<D> cls) {
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
