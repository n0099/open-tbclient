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
    private c<T, D> aGV;
    private d<T, D> aGW;
    protected T aGX;
    private final NetModelType aGY;
    private a<T, D, ActivityType> aGZ;
    private boolean aHa;
    private boolean aHb;
    private boolean aHc;
    private boolean aHd;
    private Runnable aHe;
    private boolean isLoading;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mH;
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

    protected abstract int EP();

    protected abstract int EQ();

    protected abstract String ER();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aGZ = null;
        this.isNeedCache = false;
        this.aHa = false;
        this.aHb = false;
        this.aHc = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aHd = true;
        this.mH = tbPageContext;
        this.aGX = t;
        this.aGY = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable ES() {
        if (this.aHe == null) {
            this.aHe = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.aHf[NetModel.this.aGY.ordinal()]) {
                        case 1:
                            NetModel.this.n(-1, NetModel.this.mH.getString(d.l.neterror));
                            return;
                        case 2:
                            NetModel.this.p(-1, NetModel.this.mH.getString(d.l.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.o(-1, NetModel.this.mH.getString(d.l.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.aHe;
    }

    public boolean ET() {
        if (this.aGW == null && this.aGV == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aHd = l.hy();
        if (this.timeout >= 10) {
            e.fP().postDelayed(ES(), this.timeout * 1000);
        }
        switch (this.aGY) {
            case TYPE_AUTO:
                if (!this.aHd) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mH.getString(d.l.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                EY();
                Fa();
                EU();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aGX, EP(), EQ());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.aHd) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.p(-1, NetModel.this.mH.getString(d.l.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Fa();
                EU();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aGX, EQ());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.aHd) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mH.getString(d.l.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                EZ();
                EU();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aGX, EP());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> EA = this.aGX.EA();
                if (EA != null) {
                    for (Map.Entry<String, Object> entry : EA.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.aHd) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mH.getString(d.l.neterror));
                        }
                    });
                    return false;
                } else if (this.aGZ == null) {
                    this.aGZ = new a<>(this);
                    this.aGZ.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EU() {
        if (!this.aHc) {
            switch (this.aGY) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(EP(), EQ()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aHe != null) {
                                e.fP().removeCallbacks(NetModel.this.aHe);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aGV != null) {
                                    NetModel.this.aGV.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aGW != null) {
                                    NetModel.this.aGW.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(EQ(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aHe != null) {
                                e.fP().removeCallbacks(NetModel.this.aHe);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.aGW != null) {
                                        NetModel.this.aGW.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(EP(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aHe != null) {
                                e.fP().removeCallbacks(NetModel.this.aHe);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.aGV != null) {
                                        NetModel.this.aGV.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.aHc = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> EV() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> EW() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> EX() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean ws() {
        return this.isLoading;
    }

    private void EY() {
        if (!this.aHa && MessageManager.getInstance().findTask(EP()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(EP(), TbConfig.SERVER_ADDRESS + ER() + "?cmd=" + EQ());
            tbHttpMessageTask.setResponsedClass(EV());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(EP());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aHa = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EZ() {
        if (!this.aHa && MessageManager.getInstance().findTask(EP()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(EP(), TbConfig.SERVER_ADDRESS + ER());
            tbHttpMessageTask.setResponsedClass(EW());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(EP());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aHa = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fa() {
        if (!this.aHb && MessageManager.getInstance().findTask(EQ()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(EQ());
            bVar.setResponsedClass(EX());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(EQ());
            MessageManager.getInstance().registerTask(bVar);
            this.aHb = true;
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
        MessageManager.getInstance().removeMessage(EQ(), this.unique_id);
        MessageManager.getInstance().removeMessage(EP(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aGX, EP(), EQ());
        if (this.aGW != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(EQ()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aGW.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aGV != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(EP()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aGV.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.aGV != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aGX, EP());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(EP());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aGV.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aGX, EQ());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(EQ()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aGW.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fb() {
        this.aGZ = null;
    }

    public void a(b<T, D> bVar) {
        this.aGV = bVar;
        this.aGW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aHg;
        private com.baidu.tbadk.core.util.a.a aHh;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aHg = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aHg).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.aHg.ER());
            for (Map.Entry<String, Object> entry : this.aHg.aGX.EA().entrySet()) {
                xVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ui = xVar.ui();
            this.aHh = xVar.uG();
            D l = l(this.aHg.getResponseDataClass());
            if (ui != null) {
                try {
                    l.k(new JSONObject(ui));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aHg.isNeedCache() && this.aHh != null && this.aHh.vD() != null && this.aHh.vD().isRequestSuccess() && l != null && (this.aHg.aGX instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aHg.aGX;
                String cacheKey = eVar.getCacheKey();
                String Ex = eVar.Ex();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Ex) || l == null) {
                    return l;
                }
                com.baidu.adp.lib.cache.l<String> N = com.baidu.tbadk.core.c.a.sX().N(Ex, currentAccount);
                if (N == null) {
                    return l;
                }
                N.e(cacheKey, ui);
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
                ((NetModel) this.aHg).isLoading = false;
                if (((NetModel) this.aHg).aHe != null) {
                    e.fP().removeCallbacks(((NetModel) this.aHg).aHe);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aHg.aGX, this.aHg.EP());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aHg.EP());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aHh != null && this.aHh.vD() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aHh.vD().vp, this.aHh.vD().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aHh.vD().ahC);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aHh.vD().mErrorString);
                    if (this.aHh.vD().ahD != null) {
                        BdLog.e(this.aHh.vD().ahD);
                    }
                }
                this.aHg.Fb();
                if (((NetModel) this.aHg).aGV != null) {
                    ((NetModel) this.aHg).aGV.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
