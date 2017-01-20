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
import com.baidu.tbadk.core.util.y;
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
    private static /* synthetic */ int[] aza;
    private TbPageContext<ActivityType> FY;
    private c<T, D> ayQ;
    private d<T, D> ayR;
    protected T ayS;
    private final NetModelType ayT;
    private a<T, D, ActivityType> ayU;
    private boolean ayV;
    private boolean ayW;
    private boolean ayX;
    private boolean ayY;
    private Runnable ayZ;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (azd) with 'values()' method */
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

    protected abstract int lO();

    protected abstract String lP();

    protected abstract int lQ();

    static /* synthetic */ int[] EO() {
        int[] iArr = aza;
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
            aza = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.ayU = null;
        this.isNeedCache = false;
        this.ayV = false;
        this.ayW = false;
        this.ayX = false;
        this.isLoading = false;
        this.timeout = -1;
        this.ayY = true;
        this.FY = tbPageContext;
        this.ayS = t;
        this.ayT = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable EG() {
        if (this.ayZ == null) {
            this.ayZ = new com.baidu.tbadk.mvc.model.c(this);
        }
        return this.ayZ;
    }

    public boolean EH() {
        if (this.ayR == null && this.ayQ == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.ayY = k.gB();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.h.eE().postDelayed(EG(), this.timeout * 1000);
        }
        switch (EO()[this.ayT.ordinal()]) {
            case 1:
                if (!this.ayY) {
                    com.baidu.adp.lib.g.h.eE().post(new e(this));
                    return false;
                }
                this.isLoading = true;
                EL();
                EI();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.ayS, lO());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> lT = this.ayS.lT();
                if (lT != null) {
                    for (Map.Entry<String, Object> entry : lT.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.ayY) {
                    com.baidu.adp.lib.g.h.eE().post(new f(this));
                    return false;
                }
                this.isLoading = true;
                EM();
                EI();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.ayS, lQ());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.ayY) {
                    com.baidu.adp.lib.g.h.eE().post(new com.baidu.tbadk.mvc.model.d(this));
                    return false;
                }
                this.isLoading = true;
                EK();
                EM();
                EI();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.ayS, lO(), lQ());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.ayY) {
                    com.baidu.adp.lib.g.h.eE().post(new g(this));
                    return false;
                } else if (this.ayU == null) {
                    this.ayU = new a<>(this);
                    this.ayU.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EI() {
        if (!this.ayX) {
            switch (EO()[this.ayT.ordinal()]) {
                case 1:
                    i iVar = new i(this, lO(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                    break;
                case 2:
                    j jVar = new j(this, lQ(), true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
                case 3:
                    h hVar = new h(this, lO(), lQ());
                    hVar.getHttpMessageListener().setSelfListener(true);
                    hVar.getSocketMessageListener().setSelfListener(true);
                    hVar.setTag(getUniqueId());
                    registerListener(hVar);
                    break;
            }
            this.ayX = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> lS() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> EJ() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lR() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wq() {
        return this.isLoading;
    }

    private void EK() {
        if (!this.ayV && MessageManager.getInstance().findTask(lO()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lO(), String.valueOf(TbConfig.SERVER_ADDRESS) + lP() + "?cmd=" + lQ());
            tbHttpMessageTask.setResponsedClass(lS());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lO());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.ayV = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EL() {
        if (!this.ayV && MessageManager.getInstance().findTask(lO()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lO(), String.valueOf(TbConfig.SERVER_ADDRESS) + lP());
            tbHttpMessageTask.setResponsedClass(EJ());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lO());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.ayV = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EM() {
        if (!this.ayW && MessageManager.getInstance().findTask(lQ()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(lQ());
            bVar.setResponsedClass(lR());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(lQ());
            MessageManager.getInstance().registerTask(bVar);
            this.ayW = true;
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
        MessageManager.getInstance().removeMessage(lQ(), this.unique_id);
        MessageManager.getInstance().removeMessage(lO(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.ayS, lO(), lQ());
        if (this.ayR != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lQ()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.ayR.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.ayQ != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(lO()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.ayQ.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        if (this.ayQ != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.ayS, lO());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(lO());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.ayQ.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.ayS, lQ());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(lQ()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.ayR.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EN() {
        this.ayU = null;
    }

    public void a(b<T, D> bVar) {
        this.ayQ = bVar;
        this.ayR = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> azb;
        private com.baidu.tbadk.core.util.a.a azc;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.azb = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.azb).isLoading = true;
            y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + this.azb.lP());
            for (Map.Entry<String, Object> entry : this.azb.ayS.lT().entrySet()) {
                yVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ud = yVar.ud();
            this.azc = yVar.uC();
            D t = t(this.azb.getResponseDataClass());
            if (ud != null) {
                try {
                    t.i(new JSONObject(ud));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.azb.isNeedCache() && this.azc != null && this.azc.vw() != null && this.azc.vw().isRequestSuccess() && t != null && (this.azb.ayS instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.azb.ayS;
                String cacheKey = eVar.getCacheKey();
                String Ep = eVar.Ep();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Ep) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.c.a.sR().N(Ep, currentAccount);
                if (N == null) {
                    return t;
                }
                N.k(cacheKey, ud);
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
                ((NetModel) this.azb).isLoading = false;
                if (((NetModel) this.azb).ayZ != null) {
                    com.baidu.adp.lib.g.h.eE().removeCallbacks(((NetModel) this.azb).ayZ);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.azb.ayS, this.azb.lO());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.azb.lO());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.azc != null && this.azc.vw() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.azc.vw().oy, this.azc.vw().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.azc.vw().abG);
                    mvcJsonHttpResponsedMessage.setErrorString(this.azc.vw().mErrorString);
                    if (this.azc.vw().abH != null) {
                        BdLog.e(this.azc.vw().abH);
                    }
                }
                this.azb.EN();
                if (((NetModel) this.azb).ayQ != null) {
                    ((NetModel) this.azb).ayQ.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
