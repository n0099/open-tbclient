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
    private boolean cyA;
    private Runnable cyB;
    private c<T, D> cys;
    private d<T, D> cyt;
    protected T cyu;
    private final NetModelType cyv;
    private a<T, D, ActivityType> cyw;
    private boolean cyx;
    private boolean cyy;
    private boolean cyz;
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

    protected abstract int auA();

    protected abstract String auB();

    protected abstract int auz();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.cyw = null;
        this.isNeedCache = false;
        this.cyx = false;
        this.cyy = false;
        this.cyz = false;
        this.isLoading = false;
        this.timeout = -1;
        this.cyA = true;
        this.mPageContext = tbPageContext;
        this.cyu = t;
        this.cyv = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable auC() {
        if (this.cyB == null) {
            this.cyB = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.cyC[NetModel.this.cyv.ordinal()]) {
                        case 1:
                            NetModel.this.H(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 2:
                            NetModel.this.J(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.I(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.cyB;
    }

    public boolean auD() {
        if (this.cyt == null && this.cys == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cyA = l.kt();
        if (this.timeout >= 10) {
            e.iK().postDelayed(auC(), this.timeout * 1000);
        }
        switch (this.cyv) {
            case TYPE_AUTO:
                if (!this.cyA) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.H(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                auG();
                auI();
                auE();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.cyu, auz(), auA());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> auh = this.cyu.auh();
                if (auh != null) {
                    for (Map.Entry<String, String> entry : auh.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.cyA) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.J(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                auI();
                auE();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.cyu, auA());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.cyA) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.I(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                auH();
                auE();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.cyu, auz());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> aug = this.cyu.aug();
                if (aug != null) {
                    for (Map.Entry<String, Object> entry2 : aug.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> auh2 = this.cyu.auh();
                if (auh2 != null) {
                    for (Map.Entry<String, String> entry3 : auh2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.cyA) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.I(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.cyw == null) {
                    this.cyw = new a<>(this);
                    this.cyw.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void auE() {
        if (!this.cyz) {
            switch (this.cyv) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(auz(), auA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cyB != null) {
                                e.iK().removeCallbacks(NetModel.this.cyB);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.cys != null) {
                                    NetModel.this.cys.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.cyt != null) {
                                    NetModel.this.cyt.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(auA(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cyB != null) {
                                e.iK().removeCallbacks(NetModel.this.cyB);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.cyt != null) {
                                        NetModel.this.cyt.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(auz(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cyB != null) {
                                e.iK().removeCallbacks(NetModel.this.cyB);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.cys != null) {
                                        NetModel.this.cys.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.cyz = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aux() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> auF() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> auy() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean pP() {
        return this.isLoading;
    }

    private void auG() {
        if (!this.cyx && MessageManager.getInstance().findTask(auz()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(auz(), TbConfig.SERVER_ADDRESS + auB() + "?cmd=" + auA());
            tbHttpMessageTask.setResponsedClass(aux());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(auz());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cyx = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void auH() {
        if (!this.cyx && MessageManager.getInstance().findTask(auz()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(auz(), TbConfig.SERVER_ADDRESS + auB());
            tbHttpMessageTask.setResponsedClass(auF());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(auz());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.cyx = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void auI() {
        if (!this.cyy && MessageManager.getInstance().findTask(auA()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(auA());
            bVar.setResponsedClass(auy());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(auA());
            MessageManager.getInstance().registerTask(bVar);
            this.cyy = true;
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
        MessageManager.getInstance().removeMessage(auA(), this.unique_id);
        MessageManager.getInstance().removeMessage(auz(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.cyu, auz(), auA());
        if (this.cyt != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(auA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.cyt.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.cys != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(auz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.cys.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.cys != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.cyu, auz());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(auz());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.cys.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.cyu, auA());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(auA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.cyt.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auJ() {
        this.cyw = null;
    }

    public void a(b<T, D> bVar) {
        this.cys = bVar;
        this.cyt = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> cyD;
        private com.baidu.tbadk.core.util.a.a cyE;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.cyD = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.cyD).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.cyD.auB());
            for (Map.Entry<String, Object> entry : this.cyD.cyu.aug().entrySet()) {
                xVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String aig = xVar.aig();
            this.cyE = xVar.aiE();
            D q = q(this.cyD.getResponseDataClass());
            if (aig != null) {
                try {
                    q.initByJson(new JSONObject(aig));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(q);
            if (this.cyD.isNeedCache() && this.cyE != null && this.cyE.ajF() != null && this.cyE.ajF().isRequestSuccess() && q != null && (this.cyD.cyu instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.cyD.cyu;
                String cacheKey = eVar.getCacheKey();
                String aud = eVar.aud();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(aud) || q == null) {
                    return q;
                }
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agF().bE(aud, currentAccount);
                if (bE == null) {
                    return q;
                }
                bE.f(cacheKey, aig);
            }
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.cyD).isLoading = false;
                if (((NetModel) this.cyD).cyB != null) {
                    e.iK().removeCallbacks(((NetModel) this.cyD).cyB);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.cyD.cyu, this.cyD.auz());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.cyD.auz());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.cyE != null && this.cyE.ajF() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.cyE.ajF().AR, this.cyE.ajF().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.cyE.ajF().bUI);
                    mvcJsonHttpResponsedMessage.setErrorString(this.cyE.ajF().mErrorString);
                    if (this.cyE.ajF().bUJ != null) {
                        BdLog.e(this.cyE.ajF().bUJ);
                    }
                }
                this.cyD.auJ();
                if (((NetModel) this.cyD).cys != null) {
                    ((NetModel) this.cyD).cys.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D q(Class<D> cls) {
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
