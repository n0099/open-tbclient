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
import com.baidu.tbadk.core.util.y;
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
    protected T aRA;
    private final NetModelType aRB;
    private a<T, D, ActivityType> aRC;
    private boolean aRD;
    private boolean aRE;
    private boolean aRF;
    private boolean aRG;
    private c<T, D> aRy;
    private d<T, D> aRz;
    private Runnable alD;
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

    protected abstract int JA();

    protected abstract int JB();

    protected abstract String JC();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aRC = null;
        this.isNeedCache = false;
        this.aRD = false;
        this.aRE = false;
        this.aRF = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aRG = true;
        this.mPageContext = tbPageContext;
        this.aRA = t;
        this.aRB = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable JD() {
        if (this.alD == null) {
            this.alD = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.aRH[NetModel.this.aRB.ordinal()]) {
                        case 1:
                            NetModel.this.l(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                            return;
                        case 2:
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.alD;
    }

    public boolean JE() {
        if (this.aRz == null && this.aRy == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aRG = l.jU();
        if (this.timeout >= 10) {
            e.im().postDelayed(JD(), this.timeout * 1000);
        }
        switch (this.aRB) {
            case TYPE_AUTO:
                if (!this.aRG) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.l(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                JH();
                JJ();
                JF();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aRA, JA(), JB());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.aRG) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                JJ();
                JF();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aRA, JB());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.aRG) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                JI();
                JF();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aRA, JA());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Jj = this.aRA.Jj();
                if (Jj != null) {
                    for (Map.Entry<String, Object> entry : Jj.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.aRG) {
                    e.im().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.m(-1, NetModel.this.mPageContext.getString(d.k.neterror));
                        }
                    });
                    return false;
                } else if (this.aRC == null) {
                    this.aRC = new a<>(this);
                    this.aRC.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void JF() {
        if (!this.aRF) {
            switch (this.aRB) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(JA(), JB()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.alD != null) {
                                e.im().removeCallbacks(NetModel.this.alD);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aRy != null) {
                                    NetModel.this.aRy.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aRz != null) {
                                    NetModel.this.aRz.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(JB(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.alD != null) {
                                e.im().removeCallbacks(NetModel.this.alD);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.aRz != null) {
                                        NetModel.this.aRz.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(JA(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.alD != null) {
                                e.im().removeCallbacks(NetModel.this.alD);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.aRy != null) {
                                        NetModel.this.aRy.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.aRF = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Jy() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> JG() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Jz() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean Ax() {
        return this.isLoading;
    }

    private void JH() {
        if (!this.aRD && MessageManager.getInstance().findTask(JA()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(JA(), TbConfig.SERVER_ADDRESS + JC() + "?cmd=" + JB());
            tbHttpMessageTask.setResponsedClass(Jy());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(JA());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aRD = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void JI() {
        if (!this.aRD && MessageManager.getInstance().findTask(JA()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(JA(), TbConfig.SERVER_ADDRESS + JC());
            tbHttpMessageTask.setResponsedClass(JG());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(JA());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aRD = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void JJ() {
        if (!this.aRE && MessageManager.getInstance().findTask(JB()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(JB());
            bVar.setResponsedClass(Jz());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(JB());
            MessageManager.getInstance().registerTask(bVar);
            this.aRE = true;
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
        MessageManager.getInstance().removeMessage(JB(), this.unique_id);
        MessageManager.getInstance().removeMessage(JA(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aRA, JA(), JB());
        if (this.aRz != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(JB()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aRz.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aRy != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(JA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aRy.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        if (this.aRy != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aRA, JA());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(JA());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aRy.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aRA, JB());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(JB()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aRz.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK() {
        this.aRC = null;
    }

    public void a(b<T, D> bVar) {
        this.aRy = bVar;
        this.aRz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aRI;
        private com.baidu.tbadk.core.util.a.a aRJ;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aRI = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aRI).isLoading = true;
            y yVar = new y(TbConfig.SERVER_ADDRESS + this.aRI.JC());
            for (Map.Entry<String, Object> entry : this.aRI.aRA.Jj().entrySet()) {
                yVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String yl = yVar.yl();
            this.aRJ = yVar.yJ();
            D l = l(this.aRI.getResponseDataClass());
            if (yl != null) {
                try {
                    l.v(new JSONObject(yl));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aRI.isNeedCache() && this.aRJ != null && this.aRJ.zJ() != null && this.aRJ.zJ().isRequestSuccess() && l != null && (this.aRI.aRA instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aRI.aRA;
                String cacheKey = eVar.getCacheKey();
                String Jg = eVar.Jg();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Jg) || l == null) {
                    return l;
                }
                com.baidu.adp.lib.cache.l<String> R = com.baidu.tbadk.core.c.a.wW().R(Jg, currentAccount);
                if (R == null) {
                    return l;
                }
                R.e(cacheKey, yl);
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
                ((NetModel) this.aRI).isLoading = false;
                if (((NetModel) this.aRI).alD != null) {
                    e.im().removeCallbacks(((NetModel) this.aRI).alD);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aRI.aRA, this.aRI.JA());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aRI.JA());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aRJ != null && this.aRJ.zJ() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aRJ.zJ().Ab, this.aRJ.zJ().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aRJ.zJ().arO);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aRJ.zJ().mErrorString);
                    if (this.aRJ.zJ().arP != null) {
                        BdLog.e(this.aRJ.zJ().arP);
                    }
                }
                this.aRI.JK();
                if (((NetModel) this.aRI).aRy != null) {
                    ((NetModel) this.aRI).aRy.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
