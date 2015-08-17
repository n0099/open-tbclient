package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
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
    private static /* synthetic */ int[] avy;
    private TbPageContext<ActivityType> Mr;
    private c<T, D> avl;
    private d<T, D> avm;
    protected T avn;
    private final NetModelType avo;
    private a<T, D, ActivityType> avp;
    private boolean avq;
    private boolean avr;
    private boolean avs;
    private boolean avt;
    private boolean avu;
    private int avv;
    private boolean avw;
    private Runnable avx;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (avC) with 'values()' method */
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

    protected abstract int oU();

    protected abstract String oV();

    protected abstract int oW();

    static /* synthetic */ int[] Dd() {
        int[] iArr = avy;
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
            avy = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.avp = null;
        this.isNeedCache = false;
        this.avq = false;
        this.avr = false;
        this.avs = false;
        this.avt = false;
        this.avu = false;
        this.avv = -1;
        this.avw = true;
        this.Mr = tbPageContext;
        this.avn = t;
        this.avo = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable CU() {
        if (this.avx == null) {
            this.avx = new e(this);
        }
        return this.avx;
    }

    public boolean CV() {
        if (this.avm == null && this.avl == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.avw) {
            this.avw = com.baidu.adp.lib.util.k.jf();
        }
        if (this.avv >= 10) {
            com.baidu.adp.lib.g.h.hi().postDelayed(CU(), this.avv * 1000);
        }
        switch (Dd()[this.avo.ordinal()]) {
            case 1:
                CW();
                if (!this.avw) {
                    com.baidu.adp.lib.g.h.hi().post(new h(this));
                    return false;
                }
                this.avu = true;
                Da();
                CX();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.avn, oU());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oZ = this.avn.oZ();
                if (oZ != null) {
                    for (Map.Entry<String, Object> entry : oZ.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                CW();
                if (!this.avw) {
                    com.baidu.adp.lib.g.h.hi().post(new i(this));
                    return false;
                }
                this.avu = true;
                Db();
                CX();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.avn, oW());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                CW();
                if (!this.avw) {
                    com.baidu.adp.lib.g.h.hi().post(new g(this));
                    return false;
                }
                this.avu = true;
                CZ();
                Db();
                CX();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.avn, oU(), oW());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                CW();
                if (!this.avw) {
                    com.baidu.adp.lib.g.h.hi().post(new j(this));
                    return false;
                } else if (this.avp == null) {
                    this.avp = new a<>(this);
                    this.avp.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void CW() {
        if (!this.avt) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.h.hi().post(new l(this, kVar));
            this.avt = true;
        }
    }

    private void CX() {
        if (!this.avs) {
            switch (Dd()[this.avo.ordinal()]) {
                case 1:
                    n nVar = new n(this, oU(), true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
                case 2:
                    f fVar = new f(this, oW(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 3:
                    m mVar = new m(this, oU(), oW());
                    mVar.eS().setSelfListener(true);
                    mVar.eT().setSelfListener(true);
                    mVar.setTag(getUniqueId());
                    registerListener(mVar);
                    break;
            }
            this.avs = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oY() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> CY() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oX() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.avu;
    }

    private void CZ() {
        if (!this.avq && MessageManager.getInstance().findTask(oU()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oU(), String.valueOf(TbConfig.SERVER_ADDRESS) + oV() + "?cmd=" + oW());
            tbHttpMessageTask.setResponsedClass(oY());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oU());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avq = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Da() {
        if (!this.avq && MessageManager.getInstance().findTask(oU()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oU(), String.valueOf(TbConfig.SERVER_ADDRESS) + oV());
            tbHttpMessageTask.setResponsedClass(CY());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oU());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avq = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Db() {
        if (!this.avr && MessageManager.getInstance().findTask(oW()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oW());
            bVar.setResponsedClass(oX());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oW());
            MessageManager.getInstance().registerTask(bVar);
            this.avr = true;
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
        this.avu = false;
        MessageManager.getInstance().removeMessage(oW(), this.unique_id);
        MessageManager.getInstance().removeMessage(oU(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.avn, oU(), oW());
        if (this.avm != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oW()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.avm.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.avl != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.avl.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        if (this.avl != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avn, oU());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oU());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.avl.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.avn, oW());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oW()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.avm.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc() {
        this.avp = null;
    }

    public void a(b<T, D> bVar) {
        this.avl = bVar;
        this.avm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> avA;
        private com.baidu.tbadk.core.util.httpNet.a avB;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.avA = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.avA).avu = true;
            v vVar = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + this.avA.oV());
            for (Map.Entry<String, Object> entry : this.avA.avn.oZ().entrySet()) {
                vVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String tD = vVar.tD();
            this.avB = vVar.ue();
            D j = j(this.avA.getResponseDataClass());
            try {
                j.g(new JSONObject(tD));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            publishProgress(j);
            if (this.avA.isNeedCache() && this.avB != null && this.avB.uW() != null && this.avB.uW().rb() && j != null && (this.avA.avn instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.avA.avn;
                String cacheKey = eVar.getCacheKey();
                String CD = eVar.CD();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(CD) || j == null) {
                    return j;
                }
                o<String> V = com.baidu.tbadk.core.b.a.sM().V(CD, currentAccount);
                if (V == null) {
                    return j;
                }
                V.f(cacheKey, tD);
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
                ((NetModel) this.avA).avu = false;
                if (((NetModel) this.avA).avx != null) {
                    com.baidu.adp.lib.g.h.hi().removeCallbacks(((NetModel) this.avA).avx);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avA.avn, this.avA.oU());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.avA.oU());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.avB != null && this.avB.uW() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.avB.uW().abH, this.avB.uW().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.avB.uW().abI);
                    mvcJsonHttpResponsedMessage.setErrorString(this.avB.uW().mErrorString);
                    if (this.avB.uW().abJ != null) {
                        BdLog.e(this.avB.uW().abJ);
                    }
                }
                this.avA.Dc();
                if (((NetModel) this.avA).avl != null) {
                    ((NetModel) this.avA).avl.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
