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
    private static /* synthetic */ int[] aEQ;
    private c<T, D> aEG;
    private d<T, D> aEH;
    protected T aEI;
    private final NetModelType aEJ;
    private a<T, D, ActivityType> aEK;
    private boolean aEL;
    private boolean aEM;
    private boolean aEN;
    private boolean aEO;
    private Runnable aEP;
    private TbPageContext<ActivityType> ajr;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aET) with 'values()' method */
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

    protected abstract int EC();

    protected abstract int ED();

    protected abstract String EE();

    protected abstract Class<D> getResponseDataClass();

    static /* synthetic */ int[] EP() {
        int[] iArr = aEQ;
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
            aEQ = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aEK = null;
        this.isNeedCache = false;
        this.aEL = false;
        this.aEM = false;
        this.aEN = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aEO = true;
        this.ajr = tbPageContext;
        this.aEI = t;
        this.aEJ = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable EF() {
        if (this.aEP == null) {
            this.aEP = new com.baidu.tbadk.mvc.model.c(this);
        }
        return this.aEP;
    }

    public boolean EG() {
        if (this.aEH == null && this.aEG == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aEO = k.hB();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.h.fS().postDelayed(EF(), this.timeout * 1000);
        }
        switch (EP()[this.aEJ.ordinal()]) {
            case 1:
                if (!this.aEO) {
                    com.baidu.adp.lib.g.h.fS().post(new e(this));
                    return false;
                }
                this.isLoading = true;
                EM();
                EH();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aEI, EC());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> En = this.aEI.En();
                if (En != null) {
                    for (Map.Entry<String, Object> entry : En.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aEO) {
                    com.baidu.adp.lib.g.h.fS().post(new f(this));
                    return false;
                }
                this.isLoading = true;
                EN();
                EH();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aEI, ED());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aEO) {
                    com.baidu.adp.lib.g.h.fS().post(new com.baidu.tbadk.mvc.model.d(this));
                    return false;
                }
                this.isLoading = true;
                EL();
                EN();
                EH();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aEI, EC(), ED());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aEO) {
                    com.baidu.adp.lib.g.h.fS().post(new g(this));
                    return false;
                } else if (this.aEK == null) {
                    this.aEK = new a<>(this);
                    this.aEK.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EH() {
        if (!this.aEN) {
            switch (EP()[this.aEJ.ordinal()]) {
                case 1:
                    i iVar = new i(this, EC(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                    break;
                case 2:
                    j jVar = new j(this, ED(), true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
                case 3:
                    h hVar = new h(this, EC(), ED());
                    hVar.getHttpMessageListener().setSelfListener(true);
                    hVar.getSocketMessageListener().setSelfListener(true);
                    hVar.setTag(getUniqueId());
                    registerListener(hVar);
                    break;
            }
            this.aEN = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> EI() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> EJ() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> EK() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wu() {
        return this.isLoading;
    }

    private void EL() {
        if (!this.aEL && MessageManager.getInstance().findTask(EC()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(EC(), String.valueOf(TbConfig.SERVER_ADDRESS) + EE() + "?cmd=" + ED());
            tbHttpMessageTask.setResponsedClass(EI());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(EC());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEL = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EM() {
        if (!this.aEL && MessageManager.getInstance().findTask(EC()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(EC(), String.valueOf(TbConfig.SERVER_ADDRESS) + EE());
            tbHttpMessageTask.setResponsedClass(EJ());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(EC());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEL = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EN() {
        if (!this.aEM && MessageManager.getInstance().findTask(ED()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(ED());
            bVar.setResponsedClass(EK());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(ED());
            MessageManager.getInstance().registerTask(bVar);
            this.aEM = true;
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
        MessageManager.getInstance().removeMessage(ED(), this.unique_id);
        MessageManager.getInstance().removeMessage(EC(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aEI, EC(), ED());
        if (this.aEH != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(ED()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aEH.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aEG != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(EC()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aEG.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        if (this.aEG != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aEI, EC());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(EC());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aEG.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aEI, ED());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(ED()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aEH.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        this.aEK = null;
    }

    public void a(b<T, D> bVar) {
        this.aEG = bVar;
        this.aEH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aER;
        private com.baidu.tbadk.core.util.a.a aES;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aER = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aER).isLoading = true;
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aER.EE());
            for (Map.Entry<String, Object> entry : this.aER.aEI.En().entrySet()) {
                zVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ul = zVar.ul();
            this.aES = zVar.uJ();
            D l = l(this.aER.getResponseDataClass());
            if (ul != null) {
                try {
                    l.m(new JSONObject(ul));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aER.isNeedCache() && this.aES != null && this.aES.vE() != null && this.aES.vE().isRequestSuccess() && l != null && (this.aER.aEI instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aER.aEI;
                String cacheKey = eVar.getCacheKey();
                String Ek = eVar.Ek();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Ek) || l == null) {
                    return l;
                }
                o<String> M = com.baidu.tbadk.core.c.a.sZ().M(Ek, currentAccount);
                if (M == null) {
                    return l;
                }
                M.k(cacheKey, ul);
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
                ((NetModel) this.aER).isLoading = false;
                if (((NetModel) this.aER).aEP != null) {
                    com.baidu.adp.lib.g.h.fS().removeCallbacks(((NetModel) this.aER).aEP);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aER.aEI, this.aER.EC());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aER.EC());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aES != null && this.aES.vE() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aES.vE().vR, this.aES.vE().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aES.vE().agD);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aES.vE().mErrorString);
                    if (this.aES.vE().agE != null) {
                        BdLog.e(this.aES.vE().agE);
                    }
                }
                this.aER.EO();
                if (((NetModel) this.aER).aEG != null) {
                    ((NetModel) this.aER).aEG.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
