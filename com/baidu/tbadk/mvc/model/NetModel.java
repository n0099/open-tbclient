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
    private Runnable axm;
    private boolean beA;
    private boolean beB;
    private boolean beC;
    private boolean beD;
    private c<T, D> bev;
    private d<T, D> bew;
    protected T bex;
    private final NetModelType bey;
    private a<T, D, ActivityType> bez;
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

    protected abstract int Os();

    protected abstract int Ot();

    protected abstract String Ou();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.bez = null;
        this.isNeedCache = false;
        this.beA = false;
        this.beB = false;
        this.beC = false;
        this.isLoading = false;
        this.timeout = -1;
        this.beD = true;
        this.mPageContext = tbPageContext;
        this.bex = t;
        this.bey = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Ov() {
        if (this.axm == null) {
            this.axm = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.beE[NetModel.this.bey.ordinal()]) {
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
        return this.axm;
    }

    public boolean Ow() {
        if (this.bew == null && this.bev == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.beD = l.ll();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.e.jG().postDelayed(Ov(), this.timeout * 1000);
        }
        switch (this.bey) {
            case TYPE_AUTO:
                if (!this.beD) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Oz();
                OB();
                Ox();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.bex, Os(), Ot());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.beD) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OB();
                Ox();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.bex, Ot());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.beD) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OA();
                Ox();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.bex, Os());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Ob = this.bex.Ob();
                if (Ob != null) {
                    for (Map.Entry<String, Object> entry : Ob.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.beD) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                } else if (this.bez == null) {
                    this.bez = new a<>(this);
                    this.bez.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Ox() {
        if (!this.beC) {
            switch (this.bey) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(Os(), Ot()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axm != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axm);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.bev != null) {
                                    NetModel.this.bev.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.bew != null) {
                                    NetModel.this.bew.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(Ot(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axm != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axm);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.bew != null) {
                                        NetModel.this.bew.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(Os(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axm != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axm);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.bev != null) {
                                        NetModel.this.bev.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.beC = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Oq() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Oy() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Or() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean Fi() {
        return this.isLoading;
    }

    private void Oz() {
        if (!this.beA && MessageManager.getInstance().findTask(Os()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Os(), TbConfig.SERVER_ADDRESS + Ou() + "?cmd=" + Ot());
            tbHttpMessageTask.setResponsedClass(Oq());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Os());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.beA = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void OA() {
        if (!this.beA && MessageManager.getInstance().findTask(Os()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Os(), TbConfig.SERVER_ADDRESS + Ou());
            tbHttpMessageTask.setResponsedClass(Oy());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Os());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.beA = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void OB() {
        if (!this.beB && MessageManager.getInstance().findTask(Ot()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Ot());
            bVar.setResponsedClass(Or());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Ot());
            MessageManager.getInstance().registerTask(bVar);
            this.beB = true;
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
        MessageManager.getInstance().removeMessage(Ot(), this.unique_id);
        MessageManager.getInstance().removeMessage(Os(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.bex, Os(), Ot());
        if (this.bew != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ot()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.bew.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.bev != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Os()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.bev.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (this.bev != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.bex, Os());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Os());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.bev.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.bex, Ot());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ot()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.bew.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        this.bez = null;
    }

    public void a(b<T, D> bVar) {
        this.bev = bVar;
        this.bew = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> beF;
        private com.baidu.tbadk.core.util.a.a beG;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.beF = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.beF).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.beF.Ou());
            for (Map.Entry<String, Object> entry : this.beF.bex.Ob().entrySet()) {
                xVar.x(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String CL = xVar.CL();
            this.beG = xVar.Dj();
            D o = o(this.beF.getResponseDataClass());
            if (CL != null) {
                try {
                    o.I(new JSONObject(CL));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(o);
            if (this.beF.isNeedCache() && this.beG != null && this.beG.Ei() != null && this.beG.Ei().isRequestSuccess() && o != null && (this.beF.bex instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.beF.bex;
                String cacheKey = eVar.getCacheKey();
                String NY = eVar.NY();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(NY) || o == null) {
                    return o;
                }
                com.baidu.adp.lib.cache.l<String> an = com.baidu.tbadk.core.c.a.BB().an(NY, currentAccount);
                if (an == null) {
                    return o;
                }
                an.e(cacheKey, CL);
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
                ((NetModel) this.beF).isLoading = false;
                if (((NetModel) this.beF).axm != null) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(((NetModel) this.beF).axm);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.beF.bex, this.beF.Os());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.beF.Os());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.beG != null && this.beG.Ei() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.beG.Ei().De, this.beG.Ei().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.beG.Ei().aDt);
                    mvcJsonHttpResponsedMessage.setErrorString(this.beG.Ei().mErrorString);
                    if (this.beG.Ei().aDu != null) {
                        BdLog.e(this.beG.Ei().aDu);
                    }
                }
                this.beF.OC();
                if (((NetModel) this.beF).bev != null) {
                    ((NetModel) this.beF).bev.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
