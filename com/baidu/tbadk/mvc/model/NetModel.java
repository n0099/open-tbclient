package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
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
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends com.baidu.adp.base.e<ActivityType> {
    private static /* synthetic */ int[] aAK;
    private TbPageContext<ActivityType> GO;
    protected T aAA;
    private final NetModelType aAB;
    private a<T, D, ActivityType> aAC;
    private boolean aAD;
    private boolean aAE;
    private boolean aAF;
    private boolean aAG;
    private int aAH;
    private boolean aAI;
    private Runnable aAJ;
    private c<T, D> aAy;
    private d<T, D> aAz;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aAN) with 'values()' method */
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

    protected abstract int lW();

    protected abstract String lX();

    protected abstract int lY();

    static /* synthetic */ int[] Fm() {
        int[] iArr = aAK;
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
            aAK = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aAC = null;
        this.isNeedCache = false;
        this.aAD = false;
        this.aAE = false;
        this.aAF = false;
        this.aAG = false;
        this.aAH = -1;
        this.aAI = true;
        this.GO = tbPageContext;
        this.aAA = t;
        this.aAB = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Fe() {
        if (this.aAJ == null) {
            this.aAJ = new e(this);
        }
        return this.aAJ;
    }

    public boolean Ff() {
        if (this.aAz == null && this.aAy == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aAI = com.baidu.adp.lib.util.k.gD();
        if (this.aAH >= 10) {
            com.baidu.adp.lib.h.h.eG().postDelayed(Fe(), this.aAH * 1000);
        }
        switch (Fm()[this.aAB.ordinal()]) {
            case 1:
                if (!this.aAI) {
                    com.baidu.adp.lib.h.h.eG().post(new g(this));
                    return false;
                }
                this.aAG = true;
                Fj();
                Fg();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aAA, lW());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> mb = this.aAA.mb();
                if (mb != null) {
                    for (Map.Entry<String, Object> entry : mb.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aAI) {
                    com.baidu.adp.lib.h.h.eG().post(new h(this));
                    return false;
                }
                this.aAG = true;
                Fk();
                Fg();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aAA, lY());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aAI) {
                    com.baidu.adp.lib.h.h.eG().post(new f(this));
                    return false;
                }
                this.aAG = true;
                Fi();
                Fk();
                Fg();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aAA, lW(), lY());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aAI) {
                    com.baidu.adp.lib.h.h.eG().post(new i(this));
                    return false;
                } else if (this.aAC == null) {
                    this.aAC = new a<>(this);
                    this.aAC.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Fg() {
        if (!this.aAF) {
            switch (Fm()[this.aAB.ordinal()]) {
                case 1:
                    k kVar = new k(this, lW(), true);
                    kVar.setTag(getUniqueId());
                    registerListener(kVar);
                    break;
                case 2:
                    l lVar = new l(this, lY(), true);
                    lVar.setTag(getUniqueId());
                    registerListener(lVar);
                    break;
                case 3:
                    j jVar = new j(this, lW(), lY());
                    jVar.ch().setSelfListener(true);
                    jVar.ci().setSelfListener(true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
            }
            this.aAF = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> ma() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Fh() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lZ() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wL() {
        return this.aAG;
    }

    private void Fi() {
        if (!this.aAD && MessageManager.getInstance().findTask(lW()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lW(), String.valueOf(TbConfig.SERVER_ADDRESS) + lX() + "?cmd=" + lY());
            tbHttpMessageTask.setResponsedClass(ma());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lW());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aAD = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fj() {
        if (!this.aAD && MessageManager.getInstance().findTask(lW()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lW(), String.valueOf(TbConfig.SERVER_ADDRESS) + lX());
            tbHttpMessageTask.setResponsedClass(Fh());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lW());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aAD = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fk() {
        if (!this.aAE && MessageManager.getInstance().findTask(lY()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(lY());
            bVar.setResponsedClass(lZ());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(lY());
            MessageManager.getInstance().registerTask(bVar);
            this.aAE = true;
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
        this.aAG = false;
        MessageManager.getInstance().removeMessage(lY(), this.unique_id);
        MessageManager.getInstance().removeMessage(lW(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aAA, lW(), lY());
        if (this.aAz != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lY()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aAz.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aAy != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(lW()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aAy.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (this.aAy != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aAA, lW());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(lW());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aAy.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aAA, lY());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lY()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aAz.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fl() {
        this.aAC = null;
    }

    public void a(b<T, D> bVar) {
        this.aAy = bVar;
        this.aAz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aAL;
        private com.baidu.tbadk.core.util.a.a aAM;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aAL = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aAL).aAG = true;
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aAL.lX());
            for (Map.Entry<String, Object> entry : this.aAL.aAA.mb().entrySet()) {
                zVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uy = zVar.uy();
            this.aAM = zVar.uW();
            D t = t(this.aAL.getResponseDataClass());
            if (uy != null) {
                try {
                    t.i(new JSONObject(uy));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.aAL.isNeedCache() && this.aAM != null && this.aAM.vS() != null && this.aAM.vS().oH() && t != null && (this.aAL.aAA instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aAL.aAA;
                String cacheKey = eVar.getCacheKey();
                String EN = eVar.EN();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EN) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.b.a.tm().N(EN, currentAccount);
                if (N == null) {
                    return t;
                }
                N.k(cacheKey, uy);
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
                ((NetModel) this.aAL).aAG = false;
                if (((NetModel) this.aAL).aAJ != null) {
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(((NetModel) this.aAL).aAJ);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aAL.aAA, this.aAL.lW());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aAL.lW());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aAM != null && this.aAM.vS() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aAM.vS().oF, this.aAM.vS().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aAM.vS().adb);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aAM.vS().mErrorString);
                    if (this.aAM.vS().adc != null) {
                        BdLog.e(this.aAM.vS().adc);
                    }
                }
                this.aAL.Fl();
                if (((NetModel) this.aAL).aAy != null) {
                    ((NetModel) this.aAL).aAy.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
