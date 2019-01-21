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
    private Runnable axQ;
    private c<T, D> bfk;
    private d<T, D> bfl;
    protected T bfm;
    private final NetModelType bfn;
    private a<T, D, ActivityType> bfo;
    private boolean bfp;
    private boolean bfq;
    private boolean bfr;
    private boolean bfs;
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

    protected abstract int OL();

    protected abstract int OM();

    protected abstract String ON();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.bfo = null;
        this.isNeedCache = false;
        this.bfp = false;
        this.bfq = false;
        this.bfr = false;
        this.isLoading = false;
        this.timeout = -1;
        this.bfs = true;
        this.mPageContext = tbPageContext;
        this.bfm = t;
        this.bfn = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable OO() {
        if (this.axQ == null) {
            this.axQ = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.bft[NetModel.this.bfn.ordinal()]) {
                        case 1:
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                            return;
                        case 2:
                            NetModel.this.q(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.p(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.axQ;
    }

    public boolean OP() {
        if (this.bfl == null && this.bfk == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bfs = l.ll();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.e.jG().postDelayed(OO(), this.timeout * 1000);
        }
        switch (this.bfn) {
            case TYPE_AUTO:
                if (!this.bfs) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OS();
                OU();
                OQ();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.bfm, OL(), OM());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> Ou = this.bfm.Ou();
                if (Ou != null) {
                    for (Map.Entry<String, String> entry : Ou.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.bfs) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.q(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OU();
                OQ();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.bfm, OM());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.bfs) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.p(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                OT();
                OQ();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.bfm, OL());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Ot = this.bfm.Ot();
                if (Ot != null) {
                    for (Map.Entry<String, Object> entry2 : Ot.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> Ou2 = this.bfm.Ou();
                if (Ou2 != null) {
                    for (Map.Entry<String, String> entry3 : Ou2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.bfs) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.p(-1, NetModel.this.mPageContext.getString(e.j.neterror));
                        }
                    });
                    return false;
                } else if (this.bfo == null) {
                    this.bfo = new a<>(this);
                    this.bfo.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void OQ() {
        if (!this.bfr) {
            switch (this.bfn) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(OL(), OM()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axQ != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axQ);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.bfk != null) {
                                    NetModel.this.bfk.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.bfl != null) {
                                    NetModel.this.bfl.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(OM(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axQ != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axQ);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.bfl != null) {
                                        NetModel.this.bfl.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(OL(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.axQ != null) {
                                com.baidu.adp.lib.g.e.jG().removeCallbacks(NetModel.this.axQ);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.bfk != null) {
                                        NetModel.this.bfk.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.bfr = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> OJ() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> OR() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> OK() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean Fv() {
        return this.isLoading;
    }

    private void OS() {
        if (!this.bfp && MessageManager.getInstance().findTask(OL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(OL(), TbConfig.SERVER_ADDRESS + ON() + "?cmd=" + OM());
            tbHttpMessageTask.setResponsedClass(OJ());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(OL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bfp = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void OT() {
        if (!this.bfp && MessageManager.getInstance().findTask(OL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(OL(), TbConfig.SERVER_ADDRESS + ON());
            tbHttpMessageTask.setResponsedClass(OR());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(OL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bfp = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void OU() {
        if (!this.bfq && MessageManager.getInstance().findTask(OM()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(OM());
            bVar.setResponsedClass(OK());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(OM());
            MessageManager.getInstance().registerTask(bVar);
            this.bfq = true;
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
        MessageManager.getInstance().removeMessage(OM(), this.unique_id);
        MessageManager.getInstance().removeMessage(OL(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.bfm, OL(), OM());
        if (this.bfl != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(OM()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.bfl.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.bfk != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(OL()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.bfk.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        if (this.bfk != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.bfm, OL());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(OL());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.bfk.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.bfm, OM());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(OM()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.bfl.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        this.bfo = null;
    }

    public void a(b<T, D> bVar) {
        this.bfk = bVar;
        this.bfl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> bfu;
        private com.baidu.tbadk.core.util.a.a bfv;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.bfu = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.bfu).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.bfu.ON());
            for (Map.Entry<String, Object> entry : this.bfu.bfm.Ot().entrySet()) {
                xVar.x(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String CY = xVar.CY();
            this.bfv = xVar.Dw();
            D o = o(this.bfu.getResponseDataClass());
            if (CY != null) {
                try {
                    o.I(new JSONObject(CY));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(o);
            if (this.bfu.isNeedCache() && this.bfv != null && this.bfv.Ev() != null && this.bfv.Ev().isRequestSuccess() && o != null && (this.bfu.bfm instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.bfu.bfm;
                String cacheKey = eVar.getCacheKey();
                String Oq = eVar.Oq();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Oq) || o == null) {
                    return o;
                }
                com.baidu.adp.lib.cache.l<String> ao = com.baidu.tbadk.core.c.a.BO().ao(Oq, currentAccount);
                if (ao == null) {
                    return o;
                }
                ao.e(cacheKey, CY);
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
                ((NetModel) this.bfu).isLoading = false;
                if (((NetModel) this.bfu).axQ != null) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(((NetModel) this.bfu).axQ);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.bfu.bfm, this.bfu.OL());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.bfu.OL());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.bfv != null && this.bfv.Ev() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.bfv.Ev().De, this.bfv.Ev().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.bfv.Ev().aDX);
                    mvcJsonHttpResponsedMessage.setErrorString(this.bfv.Ev().mErrorString);
                    if (this.bfv.Ev().aDY != null) {
                        BdLog.e(this.bfv.Ev().aDY);
                    }
                }
                this.bfu.OV();
                if (((NetModel) this.bfu).bfk != null) {
                    ((NetModel) this.bfu).bfk.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
