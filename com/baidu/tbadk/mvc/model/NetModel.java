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
    private static /* synthetic */ int[] azS;
    private TbPageContext<ActivityType> GM;
    private c<T, D> azG;
    private d<T, D> azH;
    protected T azI;
    private final NetModelType azJ;
    private a<T, D, ActivityType> azK;
    private boolean azL;
    private boolean azM;
    private boolean azN;
    private boolean azO;
    private int azP;
    private boolean azQ;
    private Runnable azR;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (azV) with 'values()' method */
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

    static /* synthetic */ int[] Fh() {
        int[] iArr = azS;
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
            azS = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.azK = null;
        this.isNeedCache = false;
        this.azL = false;
        this.azM = false;
        this.azN = false;
        this.azO = false;
        this.azP = -1;
        this.azQ = true;
        this.GM = tbPageContext;
        this.azI = t;
        this.azJ = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable EZ() {
        if (this.azR == null) {
            this.azR = new e(this);
        }
        return this.azR;
    }

    public boolean Fa() {
        if (this.azH == null && this.azG == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.azQ = com.baidu.adp.lib.util.k.gD();
        if (this.azP >= 10) {
            com.baidu.adp.lib.h.h.eG().postDelayed(EZ(), this.azP * 1000);
        }
        switch (Fh()[this.azJ.ordinal()]) {
            case 1:
                if (!this.azQ) {
                    com.baidu.adp.lib.h.h.eG().post(new g(this));
                    return false;
                }
                this.azO = true;
                Fe();
                Fb();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.azI, lT());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> lY = this.azI.lY();
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
                if (!this.azQ) {
                    com.baidu.adp.lib.h.h.eG().post(new h(this));
                    return false;
                }
                this.azO = true;
                Ff();
                Fb();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.azI, lV());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.azQ) {
                    com.baidu.adp.lib.h.h.eG().post(new f(this));
                    return false;
                }
                this.azO = true;
                Fd();
                Ff();
                Fb();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.azI, lT(), lV());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.azQ) {
                    com.baidu.adp.lib.h.h.eG().post(new i(this));
                    return false;
                } else if (this.azK == null) {
                    this.azK = new a<>(this);
                    this.azK.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Fb() {
        if (!this.azN) {
            switch (Fh()[this.azJ.ordinal()]) {
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
            this.azN = true;
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

    public boolean wG() {
        return this.azO;
    }

    private void Fd() {
        if (!this.azL && MessageManager.getInstance().findTask(lT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lT(), String.valueOf(TbConfig.SERVER_ADDRESS) + lU() + "?cmd=" + lV());
            tbHttpMessageTask.setResponsedClass(lX());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.azL = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fe() {
        if (!this.azL && MessageManager.getInstance().findTask(lT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lT(), String.valueOf(TbConfig.SERVER_ADDRESS) + lU());
            tbHttpMessageTask.setResponsedClass(Fc());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.azL = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Ff() {
        if (!this.azM && MessageManager.getInstance().findTask(lV()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(lV());
            bVar.setResponsedClass(lW());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(lV());
            MessageManager.getInstance().registerTask(bVar);
            this.azM = true;
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
        this.azO = false;
        MessageManager.getInstance().removeMessage(lV(), this.unique_id);
        MessageManager.getInstance().removeMessage(lT(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.azI, lT(), lV());
        if (this.azH != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lV()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.azH.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.azG != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(lT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.azG.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.azG != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.azI, lT());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(lT());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.azG.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.azI, lV());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lV()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.azH.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fg() {
        this.azK = null;
    }

    public void a(b<T, D> bVar) {
        this.azG = bVar;
        this.azH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> azT;
        private com.baidu.tbadk.core.util.a.a azU;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.azT = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.azT).azO = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.azT.lU());
            for (Map.Entry<String, Object> entry : this.azT.azI.lY().entrySet()) {
                abVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uu = abVar.uu();
            this.azU = abVar.uS();
            D t = t(this.azT.getResponseDataClass());
            if (uu != null) {
                try {
                    t.i(new JSONObject(uu));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.azT.isNeedCache() && this.azU != null && this.azU.vO() != null && this.azU.vO().oF() && t != null && (this.azT.azI instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.azT.azI;
                String cacheKey = eVar.getCacheKey();
                String EI = eVar.EI();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EI) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.b.a.ti().N(EI, currentAccount);
                if (N == null) {
                    return t;
                }
                N.k(cacheKey, uu);
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
                ((NetModel) this.azT).azO = false;
                if (((NetModel) this.azT).azR != null) {
                    com.baidu.adp.lib.h.h.eG().removeCallbacks(((NetModel) this.azT).azR);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.azT.azI, this.azT.lT());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.azT.lT());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.azU != null && this.azU.vO() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.azU.vO().oE, this.azU.vO().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.azU.vO().acD);
                    mvcJsonHttpResponsedMessage.setErrorString(this.azU.vO().mErrorString);
                    if (this.azU.vO().acE != null) {
                        BdLog.e(this.azU.vO().acE);
                    }
                }
                this.azT.Fg();
                if (((NetModel) this.azT).azG != null) {
                    ((NetModel) this.azT).azG.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
