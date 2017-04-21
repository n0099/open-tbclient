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
    private static /* synthetic */ int[] aEL;
    private c<T, D> aEB;
    private d<T, D> aEC;
    protected T aED;
    private final NetModelType aEE;
    private a<T, D, ActivityType> aEF;
    private boolean aEG;
    private boolean aEH;
    private boolean aEI;
    private boolean aEJ;
    private Runnable aEK;
    private TbPageContext<ActivityType> ajU;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aEO) with 'values()' method */
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

    protected abstract String FA();

    protected abstract int Fy();

    protected abstract int Fz();

    protected abstract Class<D> getResponseDataClass();

    static /* synthetic */ int[] FL() {
        int[] iArr = aEL;
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
            aEL = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aEF = null;
        this.isNeedCache = false;
        this.aEG = false;
        this.aEH = false;
        this.aEI = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aEJ = true;
        this.ajU = tbPageContext;
        this.aED = t;
        this.aEE = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable FB() {
        if (this.aEK == null) {
            this.aEK = new com.baidu.tbadk.mvc.model.c(this);
        }
        return this.aEK;
    }

    public boolean FC() {
        if (this.aEC == null && this.aEB == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aEJ = k.hB();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.h.fS().postDelayed(FB(), this.timeout * 1000);
        }
        switch (FL()[this.aEE.ordinal()]) {
            case 1:
                if (!this.aEJ) {
                    com.baidu.adp.lib.g.h.fS().post(new e(this));
                    return false;
                }
                this.isLoading = true;
                FI();
                FD();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aED, Fy());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Fj = this.aED.Fj();
                if (Fj != null) {
                    for (Map.Entry<String, Object> entry : Fj.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aEJ) {
                    com.baidu.adp.lib.g.h.fS().post(new f(this));
                    return false;
                }
                this.isLoading = true;
                FJ();
                FD();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aED, Fz());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aEJ) {
                    com.baidu.adp.lib.g.h.fS().post(new com.baidu.tbadk.mvc.model.d(this));
                    return false;
                }
                this.isLoading = true;
                FH();
                FJ();
                FD();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aED, Fy(), Fz());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aEJ) {
                    com.baidu.adp.lib.g.h.fS().post(new g(this));
                    return false;
                } else if (this.aEF == null) {
                    this.aEF = new a<>(this);
                    this.aEF.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void FD() {
        if (!this.aEI) {
            switch (FL()[this.aEE.ordinal()]) {
                case 1:
                    i iVar = new i(this, Fy(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                    break;
                case 2:
                    j jVar = new j(this, Fz(), true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
                case 3:
                    h hVar = new h(this, Fy(), Fz());
                    hVar.getHttpMessageListener().setSelfListener(true);
                    hVar.getSocketMessageListener().setSelfListener(true);
                    hVar.setTag(getUniqueId());
                    registerListener(hVar);
                    break;
            }
            this.aEI = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> FE() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> FF() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> FG() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean xj() {
        return this.isLoading;
    }

    private void FH() {
        if (!this.aEG && MessageManager.getInstance().findTask(Fy()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fy(), String.valueOf(TbConfig.SERVER_ADDRESS) + FA() + "?cmd=" + Fz());
            tbHttpMessageTask.setResponsedClass(FE());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fy());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEG = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FI() {
        if (!this.aEG && MessageManager.getInstance().findTask(Fy()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Fy(), String.valueOf(TbConfig.SERVER_ADDRESS) + FA());
            tbHttpMessageTask.setResponsedClass(FF());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Fy());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEG = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FJ() {
        if (!this.aEH && MessageManager.getInstance().findTask(Fz()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Fz());
            bVar.setResponsedClass(FG());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Fz());
            MessageManager.getInstance().registerTask(bVar);
            this.aEH = true;
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
        MessageManager.getInstance().removeMessage(Fz(), this.unique_id);
        MessageManager.getInstance().removeMessage(Fy(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aED, Fy(), Fz());
        if (this.aEC != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aEC.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aEB != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Fy()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aEB.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.aEB != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aED, Fy());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Fy());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aEB.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aED, Fz());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Fz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aEC.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK() {
        this.aEF = null;
    }

    public void a(b<T, D> bVar) {
        this.aEB = bVar;
        this.aEC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aEM;
        private com.baidu.tbadk.core.util.a.a aEN;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aEM = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aEM).isLoading = true;
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aEM.FA());
            for (Map.Entry<String, Object> entry : this.aEM.aED.Fj().entrySet()) {
                zVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uY = zVar.uY();
            this.aEN = zVar.vw();
            D l = l(this.aEM.getResponseDataClass());
            if (uY != null) {
                try {
                    l.m(new JSONObject(uY));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aEM.isNeedCache() && this.aEN != null && this.aEN.wq() != null && this.aEN.wq().isRequestSuccess() && l != null && (this.aEM.aED instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aEM.aED;
                String cacheKey = eVar.getCacheKey();
                String Fg = eVar.Fg();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Fg) || l == null) {
                    return l;
                }
                o<String> M = com.baidu.tbadk.core.c.a.tM().M(Fg, currentAccount);
                if (M == null) {
                    return l;
                }
                M.k(cacheKey, uY);
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
                ((NetModel) this.aEM).isLoading = false;
                if (((NetModel) this.aEM).aEK != null) {
                    com.baidu.adp.lib.g.h.fS().removeCallbacks(((NetModel) this.aEM).aEK);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aEM.aED, this.aEM.Fy());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aEM.Fy());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aEN != null && this.aEN.wq() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aEN.wq().vQ, this.aEN.wq().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aEN.wq().ahl);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aEN.wq().mErrorString);
                    if (this.aEN.wq().ahm != null) {
                        BdLog.e(this.aEN.wq().ahm);
                    }
                }
                this.aEM.FK();
                if (((NetModel) this.aEM).aEB != null) {
                    ((NetModel) this.aEM).aEB.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
