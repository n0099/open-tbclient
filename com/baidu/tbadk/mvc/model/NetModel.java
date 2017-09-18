package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
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
    private c<T, D> aHH;
    private d<T, D> aHI;
    protected T aHJ;
    private final NetModelType aHK;
    private a<T, D, ActivityType> aHL;
    private boolean aHM;
    private boolean aHN;
    private boolean aHO;
    private boolean aHP;
    private Runnable aHQ;
    private boolean isLoading;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mF;
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

    protected abstract int Fq();

    protected abstract int Fr();

    protected abstract String Fs();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aHL = null;
        this.isNeedCache = false;
        this.aHM = false;
        this.aHN = false;
        this.aHO = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aHP = true;
        this.mF = tbPageContext;
        this.aHJ = t;
        this.aHK = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Ft() {
        if (this.aHQ == null) {
            this.aHQ = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.aHR[NetModel.this.aHK.ordinal()]) {
                        case 1:
                            NetModel.this.n(-1, NetModel.this.mF.getString(d.l.neterror));
                            return;
                        case 2:
                            NetModel.this.p(-1, NetModel.this.mF.getString(d.l.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.o(-1, NetModel.this.mF.getString(d.l.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.aHQ;
    }

    public boolean Fu() {
        if (this.aHI == null && this.aHH == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aHP = k.hz();
        if (this.timeout >= 10) {
            e.fQ().postDelayed(Ft(), this.timeout * 1000);
        }
        switch (this.aHK) {
            case TYPE_AUTO:
                if (!this.aHP) {
                    e.fQ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.n(-1, NetModel.this.mF.getString(d.l.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                Fz();
                FB();
                Fv();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aHJ, Fq(), Fr());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.aHP) {
                    e.fQ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.p(-1, NetModel.this.mF.getString(d.l.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                FB();
                Fv();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aHJ, Fr());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.aHP) {
                    e.fQ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mF.getString(d.l.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                FA();
                Fv();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aHJ, Fq());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Fb = this.aHJ.Fb();
                if (Fb != null) {
                    for (Map.Entry<String, Object> entry : Fb.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.aHP) {
                    e.fQ().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.o(-1, NetModel.this.mF.getString(d.l.neterror));
                        }
                    });
                    return false;
                } else if (this.aHL == null) {
                    this.aHL = new a<>(this);
                    this.aHL.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Fv() {
        if (!this.aHO) {
            switch (this.aHK) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(Fq(), Fr()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aHQ != null) {
                                e.fQ().removeCallbacks(NetModel.this.aHQ);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aHH != null) {
                                    NetModel.this.aHH.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.aHI != null) {
                                    NetModel.this.aHI.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(Fr(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aHQ != null) {
                                e.fQ().removeCallbacks(NetModel.this.aHQ);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.aHI != null) {
                                        NetModel.this.aHI.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(Fq(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.aHQ != null) {
                                e.fQ().removeCallbacks(NetModel.this.aHQ);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.aHH != null) {
                                        NetModel.this.aHH.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.aHO = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Fw() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Fx() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Fy() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean xa() {
        return this.isLoading;
    }

    private void Fz() {
        if (!this.aHM && MessageManager.getInstance().findTask(Fq()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fq(), TbConfig.SERVER_ADDRESS + Fs() + "?cmd=" + Fr());
            tbHttpMessageTask.setResponsedClass(Fw());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fq());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aHM = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FA() {
        if (!this.aHM && MessageManager.getInstance().findTask(Fq()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fq(), TbConfig.SERVER_ADDRESS + Fs());
            tbHttpMessageTask.setResponsedClass(Fx());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fq());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aHM = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FB() {
        if (!this.aHN && MessageManager.getInstance().findTask(Fr()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Fr());
            bVar.setResponsedClass(Fy());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Fr());
            MessageManager.getInstance().registerTask(bVar);
            this.aHN = true;
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
        MessageManager.getInstance().removeMessage(Fr(), this.unique_id);
        MessageManager.getInstance().removeMessage(Fq(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aHJ, Fq(), Fr());
        if (this.aHI != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fr()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aHI.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aHH != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Fq()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aHH.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.aHH != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aHJ, Fq());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Fq());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aHH.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aHJ, Fr());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fr()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aHI.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        this.aHL = null;
    }

    public void a(b<T, D> bVar) {
        this.aHH = bVar;
        this.aHI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aHS;
        private com.baidu.tbadk.core.util.a.a aHT;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aHS = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aHS).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.aHS.Fs());
            for (Map.Entry<String, Object> entry : this.aHS.aHJ.Fb().entrySet()) {
                xVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uM = xVar.uM();
            this.aHT = xVar.vj();
            D l = l(this.aHS.getResponseDataClass());
            if (uM != null) {
                try {
                    l.i(new JSONObject(uM));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aHS.isNeedCache() && this.aHT != null && this.aHT.wg() != null && this.aHT.wg().isRequestSuccess() && l != null && (this.aHS.aHJ instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aHS.aHJ;
                String cacheKey = eVar.getCacheKey();
                String EY = eVar.EY();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EY) || l == null) {
                    return l;
                }
                l<String> O = com.baidu.tbadk.core.c.a.tk().O(EY, currentAccount);
                if (O == null) {
                    return l;
                }
                O.e(cacheKey, uM);
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
                ((NetModel) this.aHS).isLoading = false;
                if (((NetModel) this.aHS).aHQ != null) {
                    e.fQ().removeCallbacks(((NetModel) this.aHS).aHQ);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aHS.aHJ, this.aHS.Fq());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aHS.Fq());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aHT != null && this.aHT.wg() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aHT.wg().vm, this.aHT.wg().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aHT.wg().aim);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aHT.wg().mErrorString);
                    if (this.aHT.wg().ain != null) {
                        BdLog.e(this.aHT.wg().ain);
                    }
                }
                this.aHS.FC();
                if (((NetModel) this.aHS).aHH != null) {
                    ((NetModel) this.aHS).aHH.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
