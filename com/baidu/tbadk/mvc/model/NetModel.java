package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
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
    private static /* synthetic */ int[] avG;
    private boolean avA;
    private boolean avB;
    private boolean avC;
    private int avD;
    private boolean avE;
    private Runnable avF;
    private c<T, D> avt;
    private d<T, D> avu;
    protected T avv;
    private final NetModelType avw;
    private a<T, D, ActivityType> avx;
    private boolean avy;
    private boolean avz;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (avK) with 'values()' method */
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

    protected abstract int oS();

    protected abstract String oT();

    protected abstract int oU();

    static /* synthetic */ int[] CX() {
        int[] iArr = avG;
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
            avG = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.avx = null;
        this.isNeedCache = false;
        this.avy = false;
        this.avz = false;
        this.avA = false;
        this.avB = false;
        this.avC = false;
        this.avD = -1;
        this.avE = true;
        this.mPageContext = tbPageContext;
        this.avv = t;
        this.avw = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable CO() {
        if (this.avF == null) {
            this.avF = new e(this);
        }
        return this.avF;
    }

    public boolean CP() {
        if (this.avu == null && this.avt == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.avE) {
            this.avE = com.baidu.adp.lib.util.k.jd();
        }
        if (this.avD >= 10) {
            com.baidu.adp.lib.g.h.hg().postDelayed(CO(), this.avD * 1000);
        }
        switch (CX()[this.avw.ordinal()]) {
            case 1:
                CQ();
                if (!this.avE) {
                    com.baidu.adp.lib.g.h.hg().post(new h(this));
                    return false;
                }
                this.avC = true;
                CU();
                CR();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.avv, oS());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oX = this.avv.oX();
                if (oX != null) {
                    for (Map.Entry<String, Object> entry : oX.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                CQ();
                if (!this.avE) {
                    com.baidu.adp.lib.g.h.hg().post(new i(this));
                    return false;
                }
                this.avC = true;
                CV();
                CR();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.avv, oU());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                CQ();
                if (!this.avE) {
                    com.baidu.adp.lib.g.h.hg().post(new g(this));
                    return false;
                }
                this.avC = true;
                CT();
                CV();
                CR();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.avv, oS(), oU());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                CQ();
                if (!this.avE) {
                    com.baidu.adp.lib.g.h.hg().post(new j(this));
                    return false;
                } else if (this.avx == null) {
                    this.avx = new a<>(this);
                    this.avx.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void CQ() {
        if (!this.avB) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.h.hg().post(new l(this, kVar));
            this.avB = true;
        }
    }

    private void CR() {
        if (!this.avA) {
            switch (CX()[this.avw.ordinal()]) {
                case 1:
                    n nVar = new n(this, oS(), true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
                case 2:
                    f fVar = new f(this, oU(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 3:
                    m mVar = new m(this, oS(), oU());
                    mVar.getHttpMessageListener().setSelfListener(true);
                    mVar.getSocketMessageListener().setSelfListener(true);
                    mVar.setTag(getUniqueId());
                    registerListener(mVar);
                    break;
            }
            this.avA = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oW() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> CS() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oV() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.avC;
    }

    private void CT() {
        if (!this.avy && MessageManager.getInstance().findTask(oS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oS(), String.valueOf(TbConfig.SERVER_ADDRESS) + oT() + "?cmd=" + oU());
            tbHttpMessageTask.setResponsedClass(oW());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avy = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void CU() {
        if (!this.avy && MessageManager.getInstance().findTask(oS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oS(), String.valueOf(TbConfig.SERVER_ADDRESS) + oT());
            tbHttpMessageTask.setResponsedClass(CS());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avy = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void CV() {
        if (!this.avz && MessageManager.getInstance().findTask(oU()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oU());
            bVar.setResponsedClass(oV());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oU());
            MessageManager.getInstance().registerTask(bVar);
            this.avz = true;
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
        this.avC = false;
        MessageManager.getInstance().removeMessage(oU(), this.unique_id);
        MessageManager.getInstance().removeMessage(oS(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.avv, oS(), oU());
        if (this.avu != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.avu.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.avt != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oS()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.avt.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        if (this.avt != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avv, oS());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oS());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.avt.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.avv, oU());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.avu.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CW() {
        this.avx = null;
    }

    public void a(b<T, D> bVar) {
        this.avt = bVar;
        this.avu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> avI;
        private com.baidu.tbadk.core.util.a.a avJ;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.avI = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.avI).avC = true;
            w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.avI.oT());
            for (Map.Entry<String, Object> entry : this.avI.avv.oX().entrySet()) {
                wVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String tD = wVar.tD();
            this.avJ = wVar.ue();
            D j = j(this.avI.getResponseDataClass());
            try {
                j.g(new JSONObject(tD));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            publishProgress(j);
            if (this.avI.isNeedCache() && this.avJ != null && this.avJ.uW() != null && this.avJ.uW().qS() && j != null && (this.avI.avv instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.avI.avv;
                String cacheKey = eVar.getCacheKey();
                String Cx = eVar.Cx();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Cx) || j == null) {
                    return j;
                }
                o<String> U = com.baidu.tbadk.core.b.a.sL().U(Cx, currentAccount);
                if (U == null) {
                    return j;
                }
                U.f(cacheKey, tD);
            }
            return j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.avI).avC = false;
                if (((NetModel) this.avI).avF != null) {
                    com.baidu.adp.lib.g.h.hg().removeCallbacks(((NetModel) this.avI).avF);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avI.avv, this.avI.oS());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.avI.oS());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.avJ != null && this.avJ.uW() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.avJ.uW().abR, this.avJ.uW().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.avJ.uW().abS);
                    mvcJsonHttpResponsedMessage.setErrorString(this.avJ.uW().mErrorString);
                    if (this.avJ.uW().abT != null) {
                        BdLog.e(this.avJ.uW().abT);
                    }
                }
                this.avI.CW();
                if (((NetModel) this.avI).avt != null) {
                    ((NetModel) this.avI).avt.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D j(Class<D> cls) {
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
