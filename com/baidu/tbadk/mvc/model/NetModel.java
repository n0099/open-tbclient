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
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends h, D extends j, ActivityType> extends BdBaseModel<ActivityType> {
    private c<T, D> aIo;
    private d<T, D> aIp;
    protected T aIq;
    private final NetModelType aIr;
    private a<T, D, ActivityType> aIs;
    private boolean aIt;
    private boolean aIu;
    private boolean aIv;
    private boolean aIw;
    private Runnable aIx;
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

    protected abstract int Fu();

    protected abstract int Fv();

    protected abstract String Fw();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aIs = null;
        this.isNeedCache = false;
        this.aIt = false;
        this.aIu = false;
        this.aIv = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aIw = true;
        this.mPageContext = tbPageContext;
        this.aIq = t;
        this.aIr = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Fx() {
        if (this.aIx == null) {
            this.aIx = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.aIy[NetModel.this.aIr.ordinal()]) {
                        case 1:
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                            return;
                        case 2:
                            NetModel.this.p(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.aIx;
    }

    public boolean Fy() {
        if (this.aIp == null && this.aIo == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aIw = l.hy();
        if (this.timeout >= 10) {
            e.fP().postDelayed(Fx(), this.timeout * 1000);
        }
        switch (this.aIr) {
            case TYPE_AUTO:
                if (!this.aIw) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                FD();
                FF();
                Fz();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aIq, Fu(), Fv());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.aIw) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.p(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                FF();
                Fz();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aIq, Fv());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.aIw) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                FE();
                Fz();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aIq, Fu());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Ff = this.aIq.Ff();
                if (Ff != null) {
                    for (Map.Entry<String, Object> entry : Ff.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.aIw) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                } else if (this.aIs == null) {
                    this.aIs = new a<>(this);
                    this.aIs.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Fz() {
        if (!this.aIv) {
            switch (this.aIr) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(Fu(), Fv()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aIx != null) {
                                e.fP().removeCallbacks(NetModel.this.aIx);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aIo != null) {
                                    NetModel.this.aIo.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aIp != null) {
                                    NetModel.this.aIp.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(Fv(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aIx != null) {
                                e.fP().removeCallbacks(NetModel.this.aIx);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.aIp != null) {
                                        NetModel.this.aIp.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(Fu(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aIx != null) {
                                e.fP().removeCallbacks(NetModel.this.aIx);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.aIo != null) {
                                        NetModel.this.aIo.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.aIv = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> FA() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> FB() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> FC() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wC() {
        return this.isLoading;
    }

    private void FD() {
        if (!this.aIt && MessageManager.getInstance().findTask(Fu()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fu(), TbConfig.SERVER_ADDRESS + Fw() + "?cmd=" + Fv());
            tbHttpMessageTask.setResponsedClass(FA());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fu());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aIt = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FE() {
        if (!this.aIt && MessageManager.getInstance().findTask(Fu()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fu(), TbConfig.SERVER_ADDRESS + Fw());
            tbHttpMessageTask.setResponsedClass(FB());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fu());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aIt = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FF() {
        if (!this.aIu && MessageManager.getInstance().findTask(Fv()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Fv());
            bVar.setResponsedClass(FC());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Fv());
            MessageManager.getInstance().registerTask(bVar);
            this.aIu = true;
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
        MessageManager.getInstance().removeMessage(Fv(), this.unique_id);
        MessageManager.getInstance().removeMessage(Fu(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aIq, Fu(), Fv());
        if (this.aIp != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fv()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aIp.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aIo != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Fu()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aIo.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.aIo != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aIq, Fu());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Fu());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aIo.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aIq, Fv());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fv()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aIp.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        this.aIs = null;
    }

    public void a(b<T, D> bVar) {
        this.aIo = bVar;
        this.aIp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private com.baidu.tbadk.core.util.a.a aIA;
        private NetModel<T, D, ActivityType> aIz;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aIz = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aIz).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.aIz.Fw());
            for (Map.Entry<String, Object> entry : this.aIz.aIq.Ff().entrySet()) {
                xVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String us = xVar.us();
            this.aIA = xVar.uQ();
            D l = l(this.aIz.getResponseDataClass());
            if (us != null) {
                try {
                    l.k(new JSONObject(us));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aIz.isNeedCache() && this.aIA != null && this.aIA.vO() != null && this.aIA.vO().isRequestSuccess() && l != null && (this.aIz.aIq instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aIz.aIq;
                String cacheKey = eVar.getCacheKey();
                String Fc = eVar.Fc();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Fc) || l == null) {
                    return l;
                }
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.tg().N(Fc, currentAccount);
                if (N == null) {
                    return l;
                }
                N.e(cacheKey, us);
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
                ((NetModel) this.aIz).isLoading = false;
                if (((NetModel) this.aIz).aIx != null) {
                    e.fP().removeCallbacks(((NetModel) this.aIz).aIx);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aIz.aIq, this.aIz.Fu());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aIz.Fu());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aIA != null && this.aIA.vO() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aIA.vO().vp, this.aIA.vO().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aIA.vO().aiw);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aIA.vO().mErrorString);
                    if (this.aIA.vO().aix != null) {
                        BdLog.e(this.aIA.vO().aix);
                    }
                }
                this.aIz.FG();
                if (((NetModel) this.aIz).aIo != null) {
                    ((NetModel) this.aIz).aIo.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
