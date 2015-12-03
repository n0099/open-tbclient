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
    private static /* synthetic */ int[] awy;
    private c<T, D> awl;
    private d<T, D> awm;
    protected T awn;
    private final NetModelType awo;
    private a<T, D, ActivityType> awp;
    private boolean awq;
    private boolean awr;
    private boolean aws;
    private boolean awt;
    private boolean awu;
    private int awv;
    private boolean aww;
    private Runnable awx;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (awC) with 'values()' method */
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

    protected abstract int oZ();

    protected abstract String pa();

    protected abstract int pb();

    static /* synthetic */ int[] DR() {
        int[] iArr = awy;
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
            awy = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.awp = null;
        this.isNeedCache = false;
        this.awq = false;
        this.awr = false;
        this.aws = false;
        this.awt = false;
        this.awu = false;
        this.awv = -1;
        this.aww = true;
        this.mPageContext = tbPageContext;
        this.awn = t;
        this.awo = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable DI() {
        if (this.awx == null) {
            this.awx = new e(this);
        }
        return this.awx;
    }

    public boolean DJ() {
        if (this.awm == null && this.awl == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aww) {
            this.aww = com.baidu.adp.lib.util.k.jg();
        }
        if (this.awv >= 10) {
            com.baidu.adp.lib.h.h.hj().postDelayed(DI(), this.awv * 1000);
        }
        switch (DR()[this.awo.ordinal()]) {
            case 1:
                DK();
                if (!this.aww) {
                    com.baidu.adp.lib.h.h.hj().post(new h(this));
                    return false;
                }
                this.awu = true;
                DO();
                DL();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.awn, oZ());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> pe = this.awn.pe();
                if (pe != null) {
                    for (Map.Entry<String, Object> entry : pe.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                DK();
                if (!this.aww) {
                    com.baidu.adp.lib.h.h.hj().post(new i(this));
                    return false;
                }
                this.awu = true;
                DP();
                DL();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.awn, pb());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                DK();
                if (!this.aww) {
                    com.baidu.adp.lib.h.h.hj().post(new g(this));
                    return false;
                }
                this.awu = true;
                DN();
                DP();
                DL();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.awn, oZ(), pb());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                DK();
                if (!this.aww) {
                    com.baidu.adp.lib.h.h.hj().post(new j(this));
                    return false;
                } else if (this.awp == null) {
                    this.awp = new a<>(this);
                    this.awp.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void DK() {
        if (!this.awt) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.h.h.hj().post(new l(this, kVar));
            this.awt = true;
        }
    }

    private void DL() {
        if (!this.aws) {
            switch (DR()[this.awo.ordinal()]) {
                case 1:
                    n nVar = new n(this, oZ(), true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
                case 2:
                    f fVar = new f(this, pb(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 3:
                    m mVar = new m(this, oZ(), pb());
                    mVar.getHttpMessageListener().setSelfListener(true);
                    mVar.getSocketMessageListener().setSelfListener(true);
                    mVar.setTag(getUniqueId());
                    registerListener(mVar);
                    break;
            }
            this.aws = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> pd() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> DM() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> pc() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.awu;
    }

    private void DN() {
        if (!this.awq && MessageManager.getInstance().findTask(oZ()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oZ(), String.valueOf(TbConfig.SERVER_ADDRESS) + pa() + "?cmd=" + pb());
            tbHttpMessageTask.setResponsedClass(pd());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oZ());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.awq = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DO() {
        if (!this.awq && MessageManager.getInstance().findTask(oZ()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oZ(), String.valueOf(TbConfig.SERVER_ADDRESS) + pa());
            tbHttpMessageTask.setResponsedClass(DM());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oZ());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.awq = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DP() {
        if (!this.awr && MessageManager.getInstance().findTask(pb()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(pb());
            bVar.setResponsedClass(pc());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(pb());
            MessageManager.getInstance().registerTask(bVar);
            this.awr = true;
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
        this.awu = false;
        MessageManager.getInstance().removeMessage(pb(), this.unique_id);
        MessageManager.getInstance().removeMessage(oZ(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.awn, oZ(), pb());
        if (this.awm != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(pb()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.awm.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.awl != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oZ()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.awl.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        if (this.awl != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.awn, oZ());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oZ());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.awl.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.awn, pb());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(pb()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.awm.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DQ() {
        this.awp = null;
    }

    public void a(b<T, D> bVar) {
        this.awl = bVar;
        this.awm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> awA;
        private com.baidu.tbadk.core.util.a.a awB;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.awA = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.awA).awu = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.awA.pa());
            for (Map.Entry<String, Object> entry : this.awA.awn.pe().entrySet()) {
                abVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ul = abVar.ul();
            this.awB = abVar.uM();
            D k = k(this.awA.getResponseDataClass());
            if (ul != null) {
                try {
                    k.g(new JSONObject(ul));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(k);
            if (this.awA.isNeedCache() && this.awB != null && this.awB.vG() != null && this.awB.vG().rf() && k != null && (this.awA.awn instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.awA.awn;
                String cacheKey = eVar.getCacheKey();
                String Dr = eVar.Dr();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Dr) || k == null) {
                    return k;
                }
                o<String> R = com.baidu.tbadk.core.b.a.ts().R(Dr, currentAccount);
                if (R == null) {
                    return k;
                }
                R.f(cacheKey, ul);
            }
            return k;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.awA).awu = false;
                if (((NetModel) this.awA).awx != null) {
                    com.baidu.adp.lib.h.h.hj().removeCallbacks(((NetModel) this.awA).awx);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.awA.awn, this.awA.oZ());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.awA.oZ());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.awB != null && this.awB.vG() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.awB.vG().acO, this.awB.vG().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.awB.vG().acP);
                    mvcJsonHttpResponsedMessage.setErrorString(this.awB.vG().mErrorString);
                    if (this.awB.vG().acQ != null) {
                        BdLog.e(this.awB.vG().acQ);
                    }
                }
                this.awA.DQ();
                if (((NetModel) this.awA).awl != null) {
                    ((NetModel) this.awA).awl.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D k(Class<D> cls) {
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
