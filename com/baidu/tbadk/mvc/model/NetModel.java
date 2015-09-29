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
    private static /* synthetic */ int[] avF;
    private boolean avA;
    private boolean avB;
    private int avC;
    private boolean avD;
    private Runnable avE;
    private c<T, D> avs;
    private d<T, D> avt;
    protected T avu;
    private final NetModelType avv;
    private a<T, D, ActivityType> avw;
    private boolean avx;
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

        /* JADX DEBUG: Replace access to removed values field (avJ) with 'values()' method */
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

    static /* synthetic */ int[] Da() {
        int[] iArr = avF;
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
            avF = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.avw = null;
        this.isNeedCache = false;
        this.avx = false;
        this.avy = false;
        this.avz = false;
        this.avA = false;
        this.avB = false;
        this.avC = -1;
        this.avD = true;
        this.mPageContext = tbPageContext;
        this.avu = t;
        this.avv = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable CR() {
        if (this.avE == null) {
            this.avE = new e(this);
        }
        return this.avE;
    }

    public boolean CS() {
        if (this.avt == null && this.avs == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.avD) {
            this.avD = com.baidu.adp.lib.util.k.jd();
        }
        if (this.avC >= 10) {
            com.baidu.adp.lib.g.h.hg().postDelayed(CR(), this.avC * 1000);
        }
        switch (Da()[this.avv.ordinal()]) {
            case 1:
                CT();
                if (!this.avD) {
                    com.baidu.adp.lib.g.h.hg().post(new h(this));
                    return false;
                }
                this.avB = true;
                CX();
                CU();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.avu, oS());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oX = this.avu.oX();
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
                CT();
                if (!this.avD) {
                    com.baidu.adp.lib.g.h.hg().post(new i(this));
                    return false;
                }
                this.avB = true;
                CY();
                CU();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.avu, oU());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                CT();
                if (!this.avD) {
                    com.baidu.adp.lib.g.h.hg().post(new g(this));
                    return false;
                }
                this.avB = true;
                CW();
                CY();
                CU();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.avu, oS(), oU());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                CT();
                if (!this.avD) {
                    com.baidu.adp.lib.g.h.hg().post(new j(this));
                    return false;
                } else if (this.avw == null) {
                    this.avw = new a<>(this);
                    this.avw.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void CT() {
        if (!this.avA) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.h.hg().post(new l(this, kVar));
            this.avA = true;
        }
    }

    private void CU() {
        if (!this.avz) {
            switch (Da()[this.avv.ordinal()]) {
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
            this.avz = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oW() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> CV() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oV() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.avB;
    }

    private void CW() {
        if (!this.avx && MessageManager.getInstance().findTask(oS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oS(), String.valueOf(TbConfig.SERVER_ADDRESS) + oT() + "?cmd=" + oU());
            tbHttpMessageTask.setResponsedClass(oW());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avx = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void CX() {
        if (!this.avx && MessageManager.getInstance().findTask(oS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oS(), String.valueOf(TbConfig.SERVER_ADDRESS) + oT());
            tbHttpMessageTask.setResponsedClass(CV());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avx = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void CY() {
        if (!this.avy && MessageManager.getInstance().findTask(oU()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oU());
            bVar.setResponsedClass(oV());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oU());
            MessageManager.getInstance().registerTask(bVar);
            this.avy = true;
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
        this.avB = false;
        MessageManager.getInstance().removeMessage(oU(), this.unique_id);
        MessageManager.getInstance().removeMessage(oS(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.avu, oS(), oU());
        if (this.avt != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.avt.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.avs != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oS()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.avs.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        if (this.avs != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avu, oS());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oS());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.avs.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.avu, oU());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.avt.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CZ() {
        this.avw = null;
    }

    public void a(b<T, D> bVar) {
        this.avs = bVar;
        this.avt = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> avH;
        private com.baidu.tbadk.core.util.a.a avI;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.avH = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.avH).avB = true;
            w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.avH.oT());
            for (Map.Entry<String, Object> entry : this.avH.avu.oX().entrySet()) {
                wVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String tG = wVar.tG();
            this.avI = wVar.uh();
            D j = j(this.avH.getResponseDataClass());
            try {
                j.g(new JSONObject(tG));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            publishProgress(j);
            if (this.avH.isNeedCache() && this.avI != null && this.avI.uY() != null && this.avI.uY().qV() && j != null && (this.avH.avu instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.avH.avu;
                String cacheKey = eVar.getCacheKey();
                String CA = eVar.CA();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(CA) || j == null) {
                    return j;
                }
                o<String> U = com.baidu.tbadk.core.b.a.sO().U(CA, currentAccount);
                if (U == null) {
                    return j;
                }
                U.f(cacheKey, tG);
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
                ((NetModel) this.avH).avB = false;
                if (((NetModel) this.avH).avE != null) {
                    com.baidu.adp.lib.g.h.hg().removeCallbacks(((NetModel) this.avH).avE);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avH.avu, this.avH.oS());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.avH.oS());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.avI != null && this.avI.uY() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.avI.uY().abO, this.avI.uY().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.avI.uY().abP);
                    mvcJsonHttpResponsedMessage.setErrorString(this.avI.uY().mErrorString);
                    if (this.avI.uY().abQ != null) {
                        BdLog.e(this.avI.uY().abQ);
                    }
                }
                this.avH.CZ();
                if (((NetModel) this.avH).avs != null) {
                    ((NetModel) this.avH).avs.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
