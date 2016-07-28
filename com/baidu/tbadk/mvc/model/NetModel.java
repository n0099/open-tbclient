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
    private static /* synthetic */ int[] axi;
    private TbPageContext<ActivityType> EA;
    private c<T, D> awW;
    private d<T, D> awX;
    protected T awY;
    private final NetModelType awZ;
    private a<T, D, ActivityType> axa;
    private boolean axb;
    private boolean axc;
    private boolean axd;
    private boolean axe;
    private int axf;
    private boolean axg;
    private Runnable axh;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (axl) with 'values()' method */
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

    protected abstract int kY();

    protected abstract String kZ();

    protected abstract int la();

    static /* synthetic */ int[] DO() {
        int[] iArr = axi;
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
            axi = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.axa = null;
        this.isNeedCache = false;
        this.axb = false;
        this.axc = false;
        this.axd = false;
        this.axe = false;
        this.axf = -1;
        this.axg = true;
        this.EA = tbPageContext;
        this.awY = t;
        this.awZ = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable DF() {
        if (this.axh == null) {
            this.axh = new e(this);
        }
        return this.axh;
    }

    public boolean DG() {
        if (this.awX == null && this.awW == null && TbadkCoreApplication.m10getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.axg = com.baidu.adp.lib.util.k.fH();
        if (this.axf >= 10) {
            com.baidu.adp.lib.h.h.dL().postDelayed(DF(), this.axf * 1000);
        }
        switch (DO()[this.awZ.ordinal()]) {
            case 1:
                if (!this.axg) {
                    com.baidu.adp.lib.h.h.dL().post(new g(this));
                    return false;
                }
                this.axe = true;
                DL();
                DH();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.awY, kY());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> ld = this.awY.ld();
                if (ld != null) {
                    for (Map.Entry<String, Object> entry : ld.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.axg) {
                    com.baidu.adp.lib.h.h.dL().post(new h(this));
                    return false;
                }
                this.axe = true;
                DM();
                DH();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.awY, la());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.axg) {
                    com.baidu.adp.lib.h.h.dL().post(new f(this));
                    return false;
                }
                this.axe = true;
                DK();
                DM();
                DH();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.awY, kY(), la());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.axg) {
                    com.baidu.adp.lib.h.h.dL().post(new i(this));
                    return false;
                } else if (this.axa == null) {
                    this.axa = new a<>(this);
                    this.axa.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void DH() {
        if (!this.axd) {
            switch (DO()[this.awZ.ordinal()]) {
                case 1:
                    k kVar = new k(this, kY(), true);
                    kVar.setTag(getUniqueId());
                    registerListener(kVar);
                    break;
                case 2:
                    l lVar = new l(this, la(), true);
                    lVar.setTag(getUniqueId());
                    registerListener(lVar);
                    break;
                case 3:
                    j jVar = new j(this, kY(), la());
                    jVar.bm().setSelfListener(true);
                    jVar.bn().setSelfListener(true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
            }
            this.axd = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> lc() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> DI() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lb() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean DJ() {
        return this.axe;
    }

    private void DK() {
        if (!this.axb && MessageManager.getInstance().findTask(kY()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kY(), String.valueOf(TbConfig.SERVER_ADDRESS) + kZ() + "?cmd=" + la());
            tbHttpMessageTask.setResponsedClass(lc());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kY());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.axb = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DL() {
        if (!this.axb && MessageManager.getInstance().findTask(kY()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kY(), String.valueOf(TbConfig.SERVER_ADDRESS) + kZ());
            tbHttpMessageTask.setResponsedClass(DI());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kY());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.axb = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DM() {
        if (!this.axc && MessageManager.getInstance().findTask(la()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(la());
            bVar.setResponsedClass(lb());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(la());
            MessageManager.getInstance().registerTask(bVar);
            this.axc = true;
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
        this.axe = false;
        MessageManager.getInstance().removeMessage(la(), this.unique_id);
        MessageManager.getInstance().removeMessage(kY(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.awY, kY(), la());
        if (this.awX != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(la()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.awX.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.awW != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(kY()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.awW.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.awW != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.awY, kY());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(kY());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.awW.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.awY, la());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(la()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.awX.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN() {
        this.axa = null;
    }

    public void a(b<T, D> bVar) {
        this.awW = bVar;
        this.awX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> axj;
        private com.baidu.tbadk.core.util.a.a axk;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.axj = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.axj).axe = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.axj.kZ());
            for (Map.Entry<String, Object> entry : this.axj.awY.ld().entrySet()) {
                abVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String sZ = abVar.sZ();
            this.axk = abVar.tx();
            D t = t(this.axj.getResponseDataClass());
            if (sZ != null) {
                try {
                    t.i(new JSONObject(sZ));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.axj.isNeedCache() && this.axk != null && this.axk.uv() != null && this.axk.uv().nJ() && t != null && (this.axj.awY instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.axj.awY;
                String cacheKey = eVar.getCacheKey();
                String Do = eVar.Do();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Do) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.b.a.rO().N(Do, currentAccount);
                if (N == null) {
                    return t;
                }
                N.k(cacheKey, sZ);
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
                ((NetModel) this.axj).axe = false;
                if (((NetModel) this.axj).axh != null) {
                    com.baidu.adp.lib.h.h.dL().removeCallbacks(((NetModel) this.axj).axh);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.axj.awY, this.axj.kY());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.axj.kY());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.axk != null && this.axk.uv() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.axk.uv().mi, this.axk.uv().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.axk.uv().ZD);
                    mvcJsonHttpResponsedMessage.setErrorString(this.axk.uv().mErrorString);
                    if (this.axk.uv().ZE != null) {
                        BdLog.e(this.axk.uv().ZE);
                    }
                }
                this.axj.DN();
                if (((NetModel) this.axj).awW != null) {
                    ((NetModel) this.axj).awW.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
