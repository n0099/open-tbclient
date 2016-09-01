package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
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
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends com.baidu.adp.base.e<ActivityType> {
    private static /* synthetic */ int[] aAp;
    private TbPageContext<ActivityType> GM;
    private c<T, D> aAd;
    private d<T, D> aAe;
    protected T aAf;
    private final NetModelType aAg;
    private a<T, D, ActivityType> aAh;
    private boolean aAi;
    private boolean aAj;
    private boolean aAk;
    private boolean aAl;
    private int aAm;
    private boolean aAn;
    private Runnable aAo;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aAs) with 'values()' method */
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

    protected abstract Class<D> getResponseDataClass();

    protected abstract int lT();

    protected abstract String lU();

    protected abstract int lV();

    static /* synthetic */ int[] Fi() {
        int[] iArr = aAp;
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
            aAp = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aAh = null;
        this.isNeedCache = false;
        this.aAi = false;
        this.aAj = false;
        this.aAk = false;
        this.aAl = false;
        this.aAm = -1;
        this.aAn = true;
        this.GM = tbPageContext;
        this.aAf = t;
        this.aAg = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable EZ() {
        if (this.aAo == null) {
            this.aAo = new e(this);
        }
        return this.aAo;
    }

    public boolean Fa() {
        if (this.aAe == null && this.aAd == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aAn = com.baidu.adp.lib.util.k.gD();
        if (this.aAm >= 10) {
            com.baidu.adp.lib.h.h.eG().postDelayed(EZ(), this.aAm * 1000);
        }
        switch (Fi()[this.aAg.ordinal()]) {
            case 1:
                if (!this.aAn) {
                    com.baidu.adp.lib.h.h.eG().post(new g(this));
                    return false;
                }
                this.aAl = true;
                Ff();
                Fb();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aAf, lT());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> lY = this.aAf.lY();
                if (lY != null) {
                    for (Map.Entry<String, Object> entry : lY.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aAn) {
                    com.baidu.adp.lib.h.h.eG().post(new h(this));
                    return false;
                }
                this.aAl = true;
                Fg();
                Fb();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aAf, lV());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aAn) {
                    com.baidu.adp.lib.h.h.eG().post(new f(this));
                    return false;
                }
                this.aAl = true;
                Fe();
                Fg();
                Fb();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aAf, lT(), lV());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aAn) {
                    com.baidu.adp.lib.h.h.eG().post(new i(this));
                    return false;
                } else if (this.aAh == null) {
                    this.aAh = new a<>(this);
                    this.aAh.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Fb() {
        if (!this.aAk) {
            switch (Fi()[this.aAg.ordinal()]) {
                case 1:
                    k kVar = new k(this, lT(), true);
                    kVar.setTag(getUniqueId());
                    registerListener(kVar);
                    break;
                case 2:
                    l lVar = new l(this, lV(), true);
                    lVar.setTag(getUniqueId());
                    registerListener(lVar);
                    break;
                case 3:
                    j jVar = new j(this, lT(), lV());
                    jVar.ch().setSelfListener(true);
                    jVar.ci().setSelfListener(true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
            }
            this.aAk = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> lX() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Fc() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lW() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean Fd() {
        return this.aAl;
    }

    private void Fe() {
        if (!this.aAi && MessageManager.getInstance().findTask(lT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lT(), String.valueOf(TbConfig.SERVER_ADDRESS) + lU() + "?cmd=" + lV());
            tbHttpMessageTask.setResponsedClass(lX());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aAi = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Ff() {
        if (!this.aAi && MessageManager.getInstance().findTask(lT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lT(), String.valueOf(TbConfig.SERVER_ADDRESS) + lU());
            tbHttpMessageTask.setResponsedClass(Fc());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aAi = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fg() {
        if (!this.aAj && MessageManager.getInstance().findTask(lV()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(lV());
            bVar.setResponsedClass(lW());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(lV());
            MessageManager.getInstance().registerTask(bVar);
            this.aAj = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.adp.base.e
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aAl = false;
        MessageManager.getInstance().removeMessage(lV(), this.unique_id);
        MessageManager.getInstance().removeMessage(lT(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aAf, lT(), lV());
        if (this.aAe != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lV()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aAe.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aAd != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(lT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aAd.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.aAd != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aAf, lT());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(lT());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aAd.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aAf, lV());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lV()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aAe.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        this.aAh = null;
    }

    public void a(b<T, D> bVar) {
        this.aAd = bVar;
        this.aAe = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aAq;
        private com.baidu.tbadk.core.util.a.a aAr;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aAq = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aAq).aAl = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aAq.lU());
            for (Map.Entry<String, Object> entry : this.aAq.aAf.lY().entrySet()) {
                abVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ue = abVar.ue();
            this.aAr = abVar.uD();
            D t = t(this.aAq.getResponseDataClass());
            if (ue != null) {
                try {
                    t.i(new JSONObject(ue));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.aAq.isNeedCache() && this.aAr != null && this.aAr.vA() != null && this.aAr.vA().oE() && t != null && (this.aAq.aAf instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aAq.aAf;
                String cacheKey = eVar.getCacheKey();
                String EI = eVar.EI();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EI) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.b.a.sT().N(EI, currentAccount);
                if (N == null) {
                    return t;
                }
                N.k(cacheKey, ue);
            }
            return t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.aAq).aAl = false;
                if (((NetModel) this.aAq).aAo != null) {
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(((NetModel) this.aAq).aAo);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aAq.aAf, this.aAq.lT());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aAq.lT());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aAr != null && this.aAr.vA() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aAr.vA().oE, this.aAr.vA().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aAr.vA().acs);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aAr.vA().mErrorString);
                    if (this.aAr.vA().act != null) {
                        BdLog.e(this.aAr.vA().act);
                    }
                }
                this.aAq.Fh();
                if (((NetModel) this.aAq).aAd != null) {
                    ((NetModel) this.aAq).aAd.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D t(Class<D> cls) {
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
