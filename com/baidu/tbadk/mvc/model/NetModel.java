package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends h, D extends j, ActivityType> extends BdBaseModel<ActivityType> {
    private Runnable atM;
    private c<T, D> baW;
    private d<T, D> baX;
    protected T baY;
    private final NetModelType baZ;
    private a<T, D, ActivityType> bba;
    private boolean bbb;
    private boolean bbc;
    private boolean bbd;
    private boolean bbe;
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

    protected abstract int No();

    protected abstract int Np();

    protected abstract String Nq();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.bba = null;
        this.isNeedCache = false;
        this.bbb = false;
        this.bbc = false;
        this.bbd = false;
        this.isLoading = false;
        this.timeout = -1;
        this.bbe = true;
        this.mPageContext = tbPageContext;
        this.baY = t;
        this.baZ = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Nr() {
        if (this.atM == null) {
            this.atM = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.bbf[NetModel.this.baZ.ordinal()]) {
                        case 1:
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                            return;
                        case 2:
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.atM;
    }

    public boolean Ns() {
        if (this.baX == null && this.baW == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bbe = l.lm();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.e.jG().postDelayed(Nr(), this.timeout * 1000);
        }
        switch (this.baZ) {
            case TYPE_AUTO:
                if (!this.bbe) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Nv();
                Nx();
                Nt();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.baY, No(), Np());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.bbe) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Nx();
                Nt();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.baY, Np());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.bbe) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Nw();
                Nt();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.baY, No());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> MX = this.baY.MX();
                if (MX != null) {
                    for (Map.Entry<String, Object> entry : MX.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.bbe) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                } else if (this.bba == null) {
                    this.bba = new a<>(this);
                    this.bba.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Nt() {
        if (!this.bbd) {
            switch (this.baZ) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(No(), Np()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.atM != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.atM);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.baW != null) {
                                    NetModel.this.baW.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.baX != null) {
                                    NetModel.this.baX.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(Np(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.atM != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.atM);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.baX != null) {
                                        NetModel.this.baX.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(No(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.atM != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.atM);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.baW != null) {
                                        NetModel.this.baW.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.bbd = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Nm() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Nu() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Nn() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean Ee() {
        return this.isLoading;
    }

    private void Nv() {
        if (!this.bbb && MessageManager.getInstance().findTask(No()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(No(), TbConfig.SERVER_ADDRESS + Nq() + "?cmd=" + Np());
            tbHttpMessageTask.setResponsedClass(Nm());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(No());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bbb = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Nw() {
        if (!this.bbb && MessageManager.getInstance().findTask(No()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(No(), TbConfig.SERVER_ADDRESS + Nq());
            tbHttpMessageTask.setResponsedClass(Nu());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(No());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bbb = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Nx() {
        if (!this.bbc && MessageManager.getInstance().findTask(Np()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Np());
            bVar.setResponsedClass(Nn());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Np());
            MessageManager.getInstance().registerTask(bVar);
            this.bbc = true;
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
        MessageManager.getInstance().removeMessage(Np(), this.unique_id);
        MessageManager.getInstance().removeMessage(No(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.baY, No(), Np());
        if (this.baX != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Np()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.baX.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.baW != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(No()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.baW.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (this.baW != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.baY, No());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(No());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.baW.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.baY, Np());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Np()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.baX.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        this.bba = null;
    }

    public void a(b<T, D> bVar) {
        this.baW = bVar;
        this.baX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> bbg;
        private com.baidu.tbadk.core.util.a.a bbh;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.bbg = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.bbg).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.bbg.Nq());
            for (Map.Entry<String, Object> entry : this.bbg.baY.MX().entrySet()) {
                xVar.x(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String BH = xVar.BH();
            this.bbh = xVar.Cf();
            D o = o(this.bbg.getResponseDataClass());
            if (BH != null) {
                try {
                    o.H(new JSONObject(BH));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(o);
            if (this.bbg.isNeedCache() && this.bbh != null && this.bbh.De() != null && this.bbh.De().isRequestSuccess() && o != null && (this.bbg.baY instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.bbg.baY;
                String cacheKey = eVar.getCacheKey();
                String MU = eVar.MU();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(MU) || o == null) {
                    return o;
                }
                com.baidu.adp.lib.cache.l<String> ak = com.baidu.tbadk.core.c.a.Ax().ak(MU, currentAccount);
                if (ak == null) {
                    return o;
                }
                ak.e(cacheKey, BH);
            }
            return o;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.bbg).isLoading = false;
                if (((NetModel) this.bbg).atM != null) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(((NetModel) this.bbg).atM);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.bbg.baY, this.bbg.No());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.bbg.No());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.bbh != null && this.bbh.De() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.bbh.De().De, this.bbh.De().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.bbh.De().azT);
                    mvcJsonHttpResponsedMessage.setErrorString(this.bbh.De().mErrorString);
                    if (this.bbh.De().azU != null) {
                        BdLog.e(this.bbh.De().azU);
                    }
                }
                this.bbg.Ny();
                if (((NetModel) this.bbg).baW != null) {
                    ((NetModel) this.bbg).baW.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D o(Class<D> cls) {
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
