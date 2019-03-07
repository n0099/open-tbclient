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
    private c<T, D> coS;
    private d<T, D> coT;
    protected T coU;
    private final NetModelType coV;
    private a<T, D, ActivityType> coW;
    private boolean coX;
    private boolean coY;
    private boolean coZ;
    private boolean cpa;
    private Runnable cpb;
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

    protected abstract int aor();

    protected abstract int aos();

    protected abstract String aot();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.coW = null;
        this.isNeedCache = false;
        this.coX = false;
        this.coY = false;
        this.coZ = false;
        this.isLoading = false;
        this.timeout = -1;
        this.cpa = true;
        this.mPageContext = tbPageContext;
        this.coU = t;
        this.coV = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable aou() {
        if (this.cpb == null) {
            this.cpb = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.cpc[NetModel.this.coV.ordinal()]) {
                        case 1:
                            NetModel.this.E(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                            return;
                        case 2:
                            NetModel.this.G(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.F(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.cpb;
    }

    public boolean aov() {
        if (this.coT == null && this.coS == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.cpa = l.lo();
        if (this.timeout >= 10) {
            e.jH().postDelayed(aou(), this.timeout * 1000);
        }
        switch (this.coV) {
            case TYPE_AUTO:
                if (!this.cpa) {
                    e.jH().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.E(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aoy();
                aoA();
                aow();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.coU, aor(), aos());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> aoa = this.coU.aoa();
                if (aoa != null) {
                    for (Map.Entry<String, String> entry : aoa.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.cpa) {
                    e.jH().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.G(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aoA();
                aow();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.coU, aos());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.cpa) {
                    e.jH().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.F(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aoz();
                aow();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.coU, aor());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> anZ = this.coU.anZ();
                if (anZ != null) {
                    for (Map.Entry<String, Object> entry2 : anZ.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> aoa2 = this.coU.aoa();
                if (aoa2 != null) {
                    for (Map.Entry<String, String> entry3 : aoa2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.cpa) {
                    e.jH().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.F(-1, NetModel.this.mPageContext.getString(d.j.neterror));
                        }
                    });
                    return false;
                } else if (this.coW == null) {
                    this.coW = new a<>(this);
                    this.coW.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void aow() {
        if (!this.coZ) {
            switch (this.coV) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(aor(), aos()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cpb != null) {
                                e.jH().removeCallbacks(NetModel.this.cpb);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.coS != null) {
                                    NetModel.this.coS.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.coT != null) {
                                    NetModel.this.coT.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(aos(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cpb != null) {
                                e.jH().removeCallbacks(NetModel.this.cpb);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.coT != null) {
                                        NetModel.this.coT.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(aor(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.cpb != null) {
                                e.jH().removeCallbacks(NetModel.this.cpb);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.coS != null) {
                                        NetModel.this.coS.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.coZ = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aop() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> aox() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> aoq() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean qz() {
        return this.isLoading;
    }

    private void aoy() {
        if (!this.coX && MessageManager.getInstance().findTask(aor()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aor(), TbConfig.SERVER_ADDRESS + aot() + "?cmd=" + aos());
            tbHttpMessageTask.setResponsedClass(aop());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aor());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.coX = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aoz() {
        if (!this.coX && MessageManager.getInstance().findTask(aor()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aor(), TbConfig.SERVER_ADDRESS + aot());
            tbHttpMessageTask.setResponsedClass(aox());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aor());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.coX = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aoA() {
        if (!this.coY && MessageManager.getInstance().findTask(aos()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(aos());
            bVar.setResponsedClass(aoq());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(aos());
            MessageManager.getInstance().registerTask(bVar);
            this.coY = true;
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
        MessageManager.getInstance().removeMessage(aos(), this.unique_id);
        MessageManager.getInstance().removeMessage(aor(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.coU, aor(), aos());
        if (this.coT != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aos()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.coT.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.coS != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(aor()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.coS.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, String str) {
        if (this.coS != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.coU, aor());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(aor());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.coS.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.coU, aos());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aos()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.coT.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoB() {
        this.coW = null;
    }

    public void a(b<T, D> bVar) {
        this.coS = bVar;
        this.coT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> cpd;
        private com.baidu.tbadk.core.util.a.a cpe;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.cpd = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.cpd).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.cpd.aot());
            for (Map.Entry<String, Object> entry : this.cpd.coU.anZ().entrySet()) {
                xVar.x(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String acj = xVar.acj();
            this.cpe = xVar.acH();
            D r = r(this.cpd.getResponseDataClass());
            if (acj != null) {
                try {
                    r.initByJson(new JSONObject(acj));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(r);
            if (this.cpd.isNeedCache() && this.cpe != null && this.cpe.adG() != null && this.cpe.adG().isRequestSuccess() && r != null && (this.cpd.coU instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.cpd.coU;
                String cacheKey = eVar.getCacheKey();
                String anW = eVar.anW();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(anW) || r == null) {
                    return r;
                }
                com.baidu.adp.lib.cache.l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv(anW, currentAccount);
                if (bv == null) {
                    return r;
                }
                bv.e(cacheKey, acj);
            }
            return r;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.cpd).isLoading = false;
                if (((NetModel) this.cpd).cpb != null) {
                    e.jH().removeCallbacks(((NetModel) this.cpd).cpb);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.cpd.coU, this.cpd.aor());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.cpd.aor());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.cpe != null && this.cpe.adG() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.cpe.adG().Dd, this.cpe.adG().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.cpe.adG().bLR);
                    mvcJsonHttpResponsedMessage.setErrorString(this.cpe.adG().mErrorString);
                    if (this.cpe.adG().bLS != null) {
                        BdLog.e(this.cpe.adG().bLS);
                    }
                }
                this.cpd.aoB();
                if (((NetModel) this.cpd).coS != null) {
                    ((NetModel) this.cpd).coS.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D r(Class<D> cls) {
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
