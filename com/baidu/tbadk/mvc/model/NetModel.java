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
    private static /* synthetic */ int[] aAh;
    private TbPageContext<ActivityType> GO;
    private boolean aAa;
    private boolean aAb;
    private boolean aAc;
    private boolean aAd;
    private int aAe;
    private boolean aAf;
    private Runnable aAg;
    private c<T, D> azV;
    private d<T, D> azW;
    protected T azX;
    private final NetModelType azY;
    private a<T, D, ActivityType> azZ;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aAk) with 'values()' method */
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

    static /* synthetic */ int[] EU() {
        int[] iArr = aAh;
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
            aAh = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.azZ = null;
        this.isNeedCache = false;
        this.aAa = false;
        this.aAb = false;
        this.aAc = false;
        this.aAd = false;
        this.aAe = -1;
        this.aAf = true;
        this.GO = tbPageContext;
        this.azX = t;
        this.azY = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable EM() {
        if (this.aAg == null) {
            this.aAg = new e(this);
        }
        return this.aAg;
    }

    public boolean EN() {
        if (this.azW == null && this.azV == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aAf = com.baidu.adp.lib.util.k.gD();
        if (this.aAe >= 10) {
            com.baidu.adp.lib.h.h.eG().postDelayed(EM(), this.aAe * 1000);
        }
        switch (EU()[this.azY.ordinal()]) {
            case 1:
                if (!this.aAf) {
                    com.baidu.adp.lib.h.h.eG().post(new g(this));
                    return false;
                }
                this.aAd = true;
                ER();
                EO();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.azX, lW());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> mb = this.azX.mb();
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
                if (!this.aAf) {
                    com.baidu.adp.lib.h.h.eG().post(new h(this));
                    return false;
                }
                this.aAd = true;
                ES();
                EO();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.azX, lY());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aAf) {
                    com.baidu.adp.lib.h.h.eG().post(new f(this));
                    return false;
                }
                this.aAd = true;
                EQ();
                ES();
                EO();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.azX, lW(), lY());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aAf) {
                    com.baidu.adp.lib.h.h.eG().post(new i(this));
                    return false;
                } else if (this.azZ == null) {
                    this.azZ = new a<>(this);
                    this.azZ.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EO() {
        if (!this.aAc) {
            switch (EU()[this.azY.ordinal()]) {
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
            this.aAc = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> ma() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> EP() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lZ() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wv() {
        return this.aAd;
    }

    private void EQ() {
        if (!this.aAa && MessageManager.getInstance().findTask(lW()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lW(), String.valueOf(TbConfig.SERVER_ADDRESS) + lX() + "?cmd=" + lY());
            tbHttpMessageTask.setResponsedClass(ma());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lW());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aAa = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void ER() {
        if (!this.aAa && MessageManager.getInstance().findTask(lW()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lW(), String.valueOf(TbConfig.SERVER_ADDRESS) + lX());
            tbHttpMessageTask.setResponsedClass(EP());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lW());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aAa = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void ES() {
        if (!this.aAb && MessageManager.getInstance().findTask(lY()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(lY());
            bVar.setResponsedClass(lZ());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(lY());
            MessageManager.getInstance().registerTask(bVar);
            this.aAb = true;
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
        this.aAd = false;
        MessageManager.getInstance().removeMessage(lY(), this.unique_id);
        MessageManager.getInstance().removeMessage(lW(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.azX, lW(), lY());
        if (this.azW != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lY()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.azW.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.azV != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(lW()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.azV.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (this.azV != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.azX, lW());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(lW());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.azV.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.azX, lY());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lY()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.azW.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ET() {
        this.azZ = null;
    }

    public void a(b<T, D> bVar) {
        this.azV = bVar;
        this.azW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aAi;
        private com.baidu.tbadk.core.util.a.a aAj;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aAi = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aAi).aAd = true;
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aAi.lX());
            for (Map.Entry<String, Object> entry : this.aAi.azX.mb().entrySet()) {
                zVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uk = zVar.uk();
            this.aAj = zVar.uI();
            D t = t(this.aAi.getResponseDataClass());
            if (uk != null) {
                try {
                    t.i(new JSONObject(uk));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.aAi.isNeedCache() && this.aAj != null && this.aAj.vC() != null && this.aAj.vC().oH() && t != null && (this.aAi.azX instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aAi.azX;
                String cacheKey = eVar.getCacheKey();
                String Ev = eVar.Ev();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Ev) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.b.a.sX().N(Ev, currentAccount);
                if (N == null) {
                    return t;
                }
                N.k(cacheKey, uk);
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
                ((NetModel) this.aAi).aAd = false;
                if (((NetModel) this.aAi).aAg != null) {
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(((NetModel) this.aAi).aAg);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aAi.azX, this.aAi.lW());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aAi.lW());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aAj != null && this.aAj.vC() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aAj.vC().oF, this.aAj.vC().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aAj.vC().acu);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aAj.vC().mErrorString);
                    if (this.aAj.vC().acv != null) {
                        BdLog.e(this.aAj.vC().acv);
                    }
                }
                this.aAi.ET();
                if (((NetModel) this.aAi).azV != null) {
                    ((NetModel) this.aAi).azV.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
