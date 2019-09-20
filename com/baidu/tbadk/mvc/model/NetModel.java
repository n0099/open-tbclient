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
    private boolean czA;
    private boolean czB;
    private boolean czC;
    private boolean czD;
    private Runnable czE;
    private c<T, D> czv;
    private d<T, D> czw;
    protected T czx;
    private final NetModelType czy;
    private a<T, D, ActivityType> czz;
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

    protected abstract int auN();

    protected abstract int auO();

    protected abstract String auP();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.czz = null;
        this.isNeedCache = false;
        this.czA = false;
        this.czB = false;
        this.czC = false;
        this.isLoading = false;
        this.timeout = -1;
        this.czD = true;
        this.mPageContext = tbPageContext;
        this.czx = t;
        this.czy = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable auQ() {
        if (this.czE == null) {
            this.czE = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.czF[NetModel.this.czy.ordinal()]) {
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
        return this.czE;
    }

    public boolean auR() {
        if (this.czw == null && this.czv == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.czD = l.kt();
        if (this.timeout >= 10) {
            e.iK().postDelayed(auQ(), this.timeout * 1000);
        }
        switch (this.czy) {
            case TYPE_AUTO:
                if (!this.czD) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.H(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                auU();
                auW();
                auS();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.czx, auN(), auO());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> auv = this.czx.auv();
                if (auv != null) {
                    for (Map.Entry<String, String> entry : auv.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.czD) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.J(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                auW();
                auS();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.czx, auO());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.czD) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.I(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                auV();
                auS();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.czx, auN());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> auu = this.czx.auu();
                if (auu != null) {
                    for (Map.Entry<String, Object> entry2 : auu.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> auv2 = this.czx.auv();
                if (auv2 != null) {
                    for (Map.Entry<String, String> entry3 : auv2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.czD) {
                    e.iK().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.I(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.czz == null) {
                    this.czz = new a<>(this);
                    this.czz.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void auS() {
        if (!this.czC) {
            switch (this.czy) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(auN(), auO()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.czE != null) {
                                e.iK().removeCallbacks(NetModel.this.czE);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.czv != null) {
                                    NetModel.this.czv.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.czw != null) {
                                    NetModel.this.czw.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(auO(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.czE != null) {
                                e.iK().removeCallbacks(NetModel.this.czE);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.czw != null) {
                                        NetModel.this.czw.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(auN(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.czE != null) {
                                e.iK().removeCallbacks(NetModel.this.czE);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.czv != null) {
                                        NetModel.this.czv.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.czC = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> auL() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> auT() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> auM() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean pQ() {
        return this.isLoading;
    }

    private void auU() {
        if (!this.czA && MessageManager.getInstance().findTask(auN()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(auN(), TbConfig.SERVER_ADDRESS + auP() + "?cmd=" + auO());
            tbHttpMessageTask.setResponsedClass(auL());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(auN());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.czA = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void auV() {
        if (!this.czA && MessageManager.getInstance().findTask(auN()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(auN(), TbConfig.SERVER_ADDRESS + auP());
            tbHttpMessageTask.setResponsedClass(auT());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(auN());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.czA = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void auW() {
        if (!this.czB && MessageManager.getInstance().findTask(auO()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(auO());
            bVar.setResponsedClass(auM());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(auO());
            MessageManager.getInstance().registerTask(bVar);
            this.czB = true;
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
        MessageManager.getInstance().removeMessage(auO(), this.unique_id);
        MessageManager.getInstance().removeMessage(auN(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.czx, auN(), auO());
        if (this.czw != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(auO()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.czw.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.czv != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(auN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.czv.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.czv != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.czx, auN());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(auN());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.czv.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.czx, auO());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(auO()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.czw.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        this.czz = null;
    }

    public void a(b<T, D> bVar) {
        this.czv = bVar;
        this.czw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> czG;
        private com.baidu.tbadk.core.util.a.a czH;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.czG = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.czG).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.czG.auP());
            for (Map.Entry<String, Object> entry : this.czG.czx.auu().entrySet()) {
                xVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String aim = xVar.aim();
            this.czH = xVar.aiK();
            D q = q(this.czG.getResponseDataClass());
            if (aim != null) {
                try {
                    q.initByJson(new JSONObject(aim));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(q);
            if (this.czG.isNeedCache() && this.czH != null && this.czH.ajN() != null && this.czH.ajN().isRequestSuccess() && q != null && (this.czG.czx instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.czG.czx;
                String cacheKey = eVar.getCacheKey();
                String aur = eVar.aur();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(aur) || q == null) {
                    return q;
                }
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agL().bE(aur, currentAccount);
                if (bE == null) {
                    return q;
                }
                bE.f(cacheKey, aim);
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
                ((NetModel) this.czG).isLoading = false;
                if (((NetModel) this.czG).czE != null) {
                    e.iK().removeCallbacks(((NetModel) this.czG).czE);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.czG.czx, this.czG.auN());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.czG.auN());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.czH != null && this.czH.ajN() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.czH.ajN().AR, this.czH.ajN().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.czH.ajN().bVr);
                    mvcJsonHttpResponsedMessage.setErrorString(this.czH.ajN().mErrorString);
                    if (this.czH.ajN().bVs != null) {
                        BdLog.e(this.czH.ajN().bVs);
                    }
                }
                this.czG.auX();
                if (((NetModel) this.czG).czv != null) {
                    ((NetModel) this.czG).czv.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
