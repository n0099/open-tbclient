package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdBaseModel<ActivityType> {
    private static /* synthetic */ int[] aEt;
    private c<T, D> aEj;
    private d<T, D> aEk;
    protected T aEl;
    private final NetModelType aEm;
    private a<T, D, ActivityType> aEn;
    private boolean aEo;
    private boolean aEp;
    private boolean aEq;
    private boolean aEr;
    private Runnable aEs;
    private TbPageContext<ActivityType> ajF;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aEw) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetModelType[] valuesCustom() {
            NetModelType[] valuesCustom = values();
            int length = valuesCustom.length;
            NetModelType[] netModelTypeArr = new NetModelType[length];
            System.arraycopy(valuesCustom, 0, netModelTypeArr, 0, length);
            return netModelTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public interface b<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j> extends c<T, D>, d<T, D> {
    }

    /* loaded from: classes.dex */
    public interface c<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j> {
        void a(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes.dex */
    public interface d<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j> {
        void a(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    protected abstract int Fa();

    protected abstract int Fb();

    protected abstract String Fc();

    protected abstract Class<D> getResponseDataClass();

    static /* synthetic */ int[] Fn() {
        int[] iArr = aEt;
        if (iArr == null) {
            iArr = new int[NetModelType.valuesCustom().length];
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NetModelType.TYPE_HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NetModelType.TYPE_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            aEt = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aEn = null;
        this.isNeedCache = false;
        this.aEo = false;
        this.aEp = false;
        this.aEq = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aEr = true;
        this.ajF = tbPageContext;
        this.aEl = t;
        this.aEm = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Fd() {
        if (this.aEs == null) {
            this.aEs = new com.baidu.tbadk.mvc.model.c(this);
        }
        return this.aEs;
    }

    public boolean Fe() {
        if (this.aEk == null && this.aEj == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aEr = k.hv();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.h.fM().postDelayed(Fd(), this.timeout * 1000);
        }
        switch (Fn()[this.aEm.ordinal()]) {
            case 1:
                if (!this.aEr) {
                    com.baidu.adp.lib.g.h.fM().post(new e(this));
                    return false;
                }
                this.isLoading = true;
                Fk();
                Ff();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aEl, Fa());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> EL = this.aEl.EL();
                if (EL != null) {
                    for (Map.Entry<String, Object> entry : EL.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aEr) {
                    com.baidu.adp.lib.g.h.fM().post(new f(this));
                    return false;
                }
                this.isLoading = true;
                Fl();
                Ff();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aEl, Fb());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aEr) {
                    com.baidu.adp.lib.g.h.fM().post(new com.baidu.tbadk.mvc.model.d(this));
                    return false;
                }
                this.isLoading = true;
                Fj();
                Fl();
                Ff();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aEl, Fa(), Fb());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aEr) {
                    com.baidu.adp.lib.g.h.fM().post(new g(this));
                    return false;
                } else if (this.aEn == null) {
                    this.aEn = new a<>(this);
                    this.aEn.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Ff() {
        if (!this.aEq) {
            switch (Fn()[this.aEm.ordinal()]) {
                case 1:
                    i iVar = new i(this, Fa(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                    break;
                case 2:
                    j jVar = new j(this, Fb(), true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
                case 3:
                    h hVar = new h(this, Fa(), Fb());
                    hVar.getHttpMessageListener().setSelfListener(true);
                    hVar.getSocketMessageListener().setSelfListener(true);
                    hVar.setTag(getUniqueId());
                    registerListener(hVar);
                    break;
            }
            this.aEq = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> Fg() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Fh() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Fi() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wN() {
        return this.isLoading;
    }

    private void Fj() {
        if (!this.aEo && MessageManager.getInstance().findTask(Fa()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fa(), String.valueOf(TbConfig.SERVER_ADDRESS) + Fc() + "?cmd=" + Fb());
            tbHttpMessageTask.setResponsedClass(Fg());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fa());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEo = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fk() {
        if (!this.aEo && MessageManager.getInstance().findTask(Fa()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fa(), String.valueOf(TbConfig.SERVER_ADDRESS) + Fc());
            tbHttpMessageTask.setResponsedClass(Fh());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fa());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEo = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fl() {
        if (!this.aEp && MessageManager.getInstance().findTask(Fb()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Fb());
            bVar.setResponsedClass(Fi());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Fb());
            MessageManager.getInstance().registerTask(bVar);
            this.aEp = true;
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
        MessageManager.getInstance().removeMessage(Fb(), this.unique_id);
        MessageManager.getInstance().removeMessage(Fa(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aEl, Fa(), Fb());
        if (this.aEk != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fb()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aEk.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aEj != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Fa()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aEj.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.aEj != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aEl, Fa());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Fa());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aEj.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aEl, Fb());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fb()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aEk.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        this.aEn = null;
    }

    public void a(b<T, D> bVar) {
        this.aEj = bVar;
        this.aEk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aEu;
        private com.baidu.tbadk.core.util.a.a aEv;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aEu = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aEu).isLoading = true;
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aEu.Fc());
            for (Map.Entry<String, Object> entry : this.aEu.aEl.EL().entrySet()) {
                zVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uB = zVar.uB();
            this.aEv = zVar.uZ();
            D s = s(this.aEu.getResponseDataClass());
            if (uB != null) {
                try {
                    s.m(new JSONObject(uB));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(s);
            if (this.aEu.isNeedCache() && this.aEv != null && this.aEv.vT() != null && this.aEv.vT().isRequestSuccess() && s != null && (this.aEu.aEl instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aEu.aEl;
                String cacheKey = eVar.getCacheKey();
                String EI = eVar.EI();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EI) || s == null) {
                    return s;
                }
                o<String> L = com.baidu.tbadk.core.c.a.to().L(EI, currentAccount);
                if (L == null) {
                    return s;
                }
                L.k(cacheKey, uB);
            }
            return s;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.aEu).isLoading = false;
                if (((NetModel) this.aEu).aEs != null) {
                    com.baidu.adp.lib.g.h.fM().removeCallbacks(((NetModel) this.aEu).aEs);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aEu.aEl, this.aEu.Fa());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aEu.Fa());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aEv != null && this.aEv.vT() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aEv.vT().wj, this.aEv.vT().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aEv.vT().agW);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aEv.vT().mErrorString);
                    if (this.aEv.vT().agX != null) {
                        BdLog.e(this.aEv.vT().agX);
                    }
                }
                this.aEu.Fm();
                if (((NetModel) this.aEu).aEj != null) {
                    ((NetModel) this.aEu).aEj.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D s(Class<D> cls) {
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
