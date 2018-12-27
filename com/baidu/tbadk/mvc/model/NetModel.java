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
    private Runnable axn;
    protected T beA;
    private final NetModelType beB;
    private a<T, D, ActivityType> beC;
    private boolean beD;
    private boolean beE;
    private boolean beF;
    private boolean beG;
    private c<T, D> bey;
    private d<T, D> bez;
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

    protected abstract int Ot();

    protected abstract int Ou();

    protected abstract String Ov();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.beC = null;
        this.isNeedCache = false;
        this.beD = false;
        this.beE = false;
        this.beF = false;
        this.isLoading = false;
        this.timeout = -1;
        this.beG = true;
        this.mPageContext = tbPageContext;
        this.beA = t;
        this.beB = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Ow() {
        if (this.axn == null) {
            this.axn = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.beH[NetModel.this.beB.ordinal()]) {
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
        return this.axn;
    }

    public boolean Ox() {
        if (this.bez == null && this.bey == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.beG = l.ll();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.e.jG().postDelayed(Ow(), this.timeout * 1000);
        }
        switch (this.beB) {
            case TYPE_AUTO:
                if (!this.beG) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OA();
                OC();
                Oy();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.beA, Ot(), Ou());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.beG) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OC();
                Oy();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.beA, Ou());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.beG) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OB();
                Oy();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.beA, Ot());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Oc = this.beA.Oc();
                if (Oc != null) {
                    for (Map.Entry<String, Object> entry : Oc.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.beG) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                } else if (this.beC == null) {
                    this.beC = new a<>(this);
                    this.beC.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Oy() {
        if (!this.beF) {
            switch (this.beB) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(Ot(), Ou()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axn != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axn);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.bey != null) {
                                    NetModel.this.bey.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.bez != null) {
                                    NetModel.this.bez.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(Ou(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axn != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axn);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.bez != null) {
                                        NetModel.this.bez.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(Ot(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axn != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axn);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.bey != null) {
                                        NetModel.this.bey.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.beF = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Or() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Oz() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Os() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean Fi() {
        return this.isLoading;
    }

    private void OA() {
        if (!this.beD && MessageManager.getInstance().findTask(Ot()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Ot(), TbConfig.SERVER_ADDRESS + Ov() + "?cmd=" + Ou());
            tbHttpMessageTask.setResponsedClass(Or());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Ot());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.beD = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void OB() {
        if (!this.beD && MessageManager.getInstance().findTask(Ot()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Ot(), TbConfig.SERVER_ADDRESS + Ov());
            tbHttpMessageTask.setResponsedClass(Oz());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Ot());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.beD = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void OC() {
        if (!this.beE && MessageManager.getInstance().findTask(Ou()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Ou());
            bVar.setResponsedClass(Os());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Ou());
            MessageManager.getInstance().registerTask(bVar);
            this.beE = true;
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
        MessageManager.getInstance().removeMessage(Ou(), this.unique_id);
        MessageManager.getInstance().removeMessage(Ot(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.beA, Ot(), Ou());
        if (this.bez != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ou()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.bez.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.bey != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Ot()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.bey.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (this.bey != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.beA, Ot());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Ot());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.bey.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.beA, Ou());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ou()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.bez.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        this.beC = null;
    }

    public void a(b<T, D> bVar) {
        this.bey = bVar;
        this.bez = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> beI;
        private com.baidu.tbadk.core.util.a.a beJ;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.beI = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.beI).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.beI.Ov());
            for (Map.Entry<String, Object> entry : this.beI.beA.Oc().entrySet()) {
                xVar.x(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String CL = xVar.CL();
            this.beJ = xVar.Dj();
            D o = o(this.beI.getResponseDataClass());
            if (CL != null) {
                try {
                    o.I(new JSONObject(CL));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(o);
            if (this.beI.isNeedCache() && this.beJ != null && this.beJ.Ei() != null && this.beJ.Ei().isRequestSuccess() && o != null && (this.beI.beA instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.beI.beA;
                String cacheKey = eVar.getCacheKey();
                String NZ = eVar.NZ();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(NZ) || o == null) {
                    return o;
                }
                com.baidu.adp.lib.cache.l<String> an = com.baidu.tbadk.core.c.a.BB().an(NZ, currentAccount);
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
                ((NetModel) this.beI).isLoading = false;
                if (((NetModel) this.beI).axn != null) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(((NetModel) this.beI).axn);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.beI.beA, this.beI.Ot());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.beI.Ot());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.beJ != null && this.beJ.Ei() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.beJ.Ei().De, this.beJ.Ei().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.beJ.Ei().aDu);
                    mvcJsonHttpResponsedMessage.setErrorString(this.beJ.Ei().mErrorString);
                    if (this.beJ.Ei().aDv != null) {
                        BdLog.e(this.beJ.Ei().aDv);
                    }
                }
                this.beI.OD();
                if (((NetModel) this.beI).bey != null) {
                    ((NetModel) this.beI).bey.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
