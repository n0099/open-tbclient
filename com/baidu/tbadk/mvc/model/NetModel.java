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
    private boolean aPw;
    private Runnable aPx;
    private c<T, D> dCe;
    private d<T, D> dCf;
    protected T dCg;
    private final NetModelType dCh;
    private a<T, D, ActivityType> dCi;
    private boolean dCj;
    private boolean dCk;
    private boolean dCl;
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

    protected abstract String Em();

    protected abstract int En();

    protected abstract int Eo();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.dCi = null;
        this.isNeedCache = false;
        this.dCj = false;
        this.dCk = false;
        this.dCl = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aPw = true;
        this.mPageContext = tbPageContext;
        this.dCg = t;
        this.dCh = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Er() {
        if (this.aPx == null) {
            this.aPx = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.dCm[NetModel.this.dCh.ordinal()]) {
                        case 1:
                            NetModel.this.V(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 2:
                            NetModel.this.W(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.r(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.aPx;
    }

    public boolean loadData() {
        if (this.dCf == null && this.dCe == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aPw = l.isNetOk();
        if (this.timeout >= 10) {
            e.gx().postDelayed(Er(), this.timeout * 1000);
        }
        switch (this.dCh) {
            case TYPE_AUTO:
                if (!this.aPw) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.V(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aQF();
                aQH();
                aQD();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.dCg, Eo(), En());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> aQl = this.dCg.aQl();
                if (aQl != null) {
                    for (Map.Entry<String, String> entry : aQl.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.aPw) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.W(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aQH();
                aQD();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.dCg, En());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.aPw) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.r(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aQG();
                aQD();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.dCg, Eo());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> aQk = this.dCg.aQk();
                if (aQk != null) {
                    for (Map.Entry<String, Object> entry2 : aQk.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> aQl2 = this.dCg.aQl();
                if (aQl2 != null) {
                    for (Map.Entry<String, String> entry3 : aQl2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.aPw) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.r(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.dCi == null) {
                    this.dCi = new a<>(this);
                    this.dCi.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void aQD() {
        if (!this.dCl) {
            switch (this.dCh) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(Eo(), En()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aPx != null) {
                                e.gx().removeCallbacks(NetModel.this.aPx);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.dCe != null) {
                                    NetModel.this.dCe.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.dCf != null) {
                                    NetModel.this.dCf.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(En(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aPx != null) {
                                e.gx().removeCallbacks(NetModel.this.aPx);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.dCf != null) {
                                        NetModel.this.dCf.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(Eo(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aPx != null) {
                                e.gx().removeCallbacks(NetModel.this.aPx);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.dCe != null) {
                                        NetModel.this.dCe.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.dCl = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aQB() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> aQE() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> aQC() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    private void aQF() {
        if (!this.dCj && MessageManager.getInstance().findTask(Eo()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Eo(), TbConfig.SERVER_ADDRESS + Em() + "?cmd=" + En());
            tbHttpMessageTask.setResponsedClass(aQB());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Eo());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.dCj = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aQG() {
        if (!this.dCj && MessageManager.getInstance().findTask(Eo()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Eo(), TbConfig.SERVER_ADDRESS + Em());
            tbHttpMessageTask.setResponsedClass(aQE());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Eo());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.dCj = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aQH() {
        if (!this.dCk && MessageManager.getInstance().findTask(En()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(En());
            bVar.setResponsedClass(aQC());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(En());
            MessageManager.getInstance().registerTask(bVar);
            this.dCk = true;
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
        MessageManager.getInstance().removeMessage(En(), this.unique_id);
        MessageManager.getInstance().removeMessage(Eo(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.dCg, Eo(), En());
        if (this.dCf != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(En()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.dCf.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.dCe != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Eo()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.dCe.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.dCe != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.dCg, Eo());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Eo());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.dCe.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.dCg, En());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(En()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.dCf.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        this.dCi = null;
    }

    public void a(b<T, D> bVar) {
        this.dCe = bVar;
        this.dCf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private com.baidu.tbadk.core.util.a.a aPC;
        private NetModel<T, D, ActivityType> dCn;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.dCn = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.dCn).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.dCn.Em());
            for (Map.Entry<String, Object> entry : this.dCn.dCg.aQk().entrySet()) {
                xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = xVar.postNetData();
            this.aPC = xVar.aGg();
            D u = u(this.dCn.getResponseDataClass());
            if (postNetData != null) {
                try {
                    u.initByJson(new JSONObject(postNetData));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(u);
            if (this.dCn.isNeedCache() && this.aPC != null && this.aPC.aGI() != null && this.aPC.aGI().isRequestSuccess() && u != null && (this.dCn.dCg instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.dCn.dCg;
                String cacheKey = eVar.getCacheKey();
                String aQh = eVar.aQh();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(aQh) || u == null) {
                    return u;
                }
                com.baidu.adp.lib.cache.l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(aQh, currentAccount);
                if (cr == null) {
                    return u;
                }
                cr.setForever(cacheKey, postNetData);
            }
            return u;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.dCn).isLoading = false;
                if (((NetModel) this.dCn).aPx != null) {
                    e.gx().removeCallbacks(((NetModel) this.dCn).aPx);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.dCn.dCg, this.dCn.Eo());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.dCn.Eo());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aPC != null && this.aPC.aGI() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aPC.aGI().mNetErrorCode, this.aPC.aGI().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aPC.aGI().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aPC.aGI().mErrorString);
                    if (this.aPC.aGI().mException != null) {
                        BdLog.e(this.aPC.aGI().mException);
                    }
                }
                this.dCn.Eq();
                if (((NetModel) this.dCn).dCe != null) {
                    ((NetModel) this.dCn).dCe.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D u(Class<D> cls) {
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
