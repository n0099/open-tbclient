package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
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
    private static /* synthetic */ int[] ayT;
    private TbPageContext<ActivityType> Nw;
    private c<T, D> ayI;
    private d<T, D> ayJ;
    protected T ayK;
    private final NetModelType ayL;
    private a<T, D, ActivityType> ayM;
    private boolean ayN;
    private boolean ayO;
    private boolean ayP;
    private boolean ayQ;
    private boolean ayR;
    private Runnable ayS;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (ayW) with 'values()' method */
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

    static /* synthetic */ int[] Fa() {
        int[] iArr = ayT;
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
            ayT = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.ayM = null;
        this.isNeedCache = false;
        this.ayN = false;
        this.ayO = false;
        this.ayP = false;
        this.ayQ = false;
        this.timeout = -1;
        this.ayR = true;
        this.Nw = tbPageContext;
        this.ayK = t;
        this.ayL = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable ES() {
        if (this.ayS == null) {
            this.ayS = new e(this);
        }
        return this.ayS;
    }

    public boolean ET() {
        if (this.ayJ == null && this.ayI == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.ayR = com.baidu.adp.lib.util.k.jq();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.h.h.hr().postDelayed(ES(), this.timeout * 1000);
        }
        switch (Fa()[this.ayL.ordinal()]) {
            case 1:
                if (!this.ayR) {
                    com.baidu.adp.lib.h.h.hr().post(new g(this));
                    return false;
                }
                this.ayQ = true;
                EX();
                EU();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.ayK, oS());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oX = this.ayK.oX();
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
                if (!this.ayR) {
                    com.baidu.adp.lib.h.h.hr().post(new h(this));
                    return false;
                }
                this.ayQ = true;
                EY();
                EU();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.ayK, oU());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.ayR) {
                    com.baidu.adp.lib.h.h.hr().post(new f(this));
                    return false;
                }
                this.ayQ = true;
                EW();
                EY();
                EU();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.ayK, oS(), oU());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.ayR) {
                    com.baidu.adp.lib.h.h.hr().post(new i(this));
                    return false;
                } else if (this.ayM == null) {
                    this.ayM = new a<>(this);
                    this.ayM.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EU() {
        if (!this.ayP) {
            switch (Fa()[this.ayL.ordinal()]) {
                case 1:
                    k kVar = new k(this, oS(), true);
                    kVar.setTag(getUniqueId());
                    registerListener(kVar);
                    break;
                case 2:
                    l lVar = new l(this, oU(), true);
                    lVar.setTag(getUniqueId());
                    registerListener(lVar);
                    break;
                case 3:
                    j jVar = new j(this, oS(), oU());
                    jVar.eV().setSelfListener(true);
                    jVar.eW().setSelfListener(true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
            }
            this.ayP = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oW() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> EV() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oV() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.ayQ;
    }

    private void EW() {
        if (!this.ayN && MessageManager.getInstance().findTask(oS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oS(), String.valueOf(TbConfig.SERVER_ADDRESS) + oT() + "?cmd=" + oU());
            tbHttpMessageTask.setResponsedClass(oW());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.ayN = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EX() {
        if (!this.ayN && MessageManager.getInstance().findTask(oS()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oS(), String.valueOf(TbConfig.SERVER_ADDRESS) + oT());
            tbHttpMessageTask.setResponsedClass(EV());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oS());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.ayN = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EY() {
        if (!this.ayO && MessageManager.getInstance().findTask(oU()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oU());
            bVar.setResponsedClass(oV());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oU());
            MessageManager.getInstance().registerTask(bVar);
            this.ayO = true;
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
        this.ayQ = false;
        MessageManager.getInstance().removeMessage(oU(), this.unique_id);
        MessageManager.getInstance().removeMessage(oS(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.ayK, oS(), oU());
        if (this.ayJ != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.ayJ.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.ayI != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oS()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.ayI.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        if (this.ayI != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.ayK, oS());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oS());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.ayI.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.ayK, oU());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.ayJ.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ() {
        this.ayM = null;
    }

    public void a(b<T, D> bVar) {
        this.ayI = bVar;
        this.ayJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> ayU;
        private com.baidu.tbadk.core.util.a.a ayV;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.ayU = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.ayU).ayQ = true;
            aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ayU.oT());
            for (Map.Entry<String, Object> entry : this.ayU.ayK.oX().entrySet()) {
                aaVar.p(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uZ = aaVar.uZ();
            this.ayV = aaVar.vB();
            D j = j(this.ayU.getResponseDataClass());
            if (uZ != null) {
                try {
                    j.g(new JSONObject(uZ));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(j);
            if (this.ayU.isNeedCache() && this.ayV != null && this.ayV.ww() != null && this.ayV.ww().rl() && j != null && (this.ayU.ayK instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.ayU.ayK;
                String cacheKey = eVar.getCacheKey();
                String EB = eVar.EB();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EB) || j == null) {
                    return j;
                }
                o<String> Q = com.baidu.tbadk.core.b.a.ug().Q(EB, currentAccount);
                if (Q == null) {
                    return j;
                }
                Q.f(cacheKey, uZ);
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
                ((NetModel) this.ayU).ayQ = false;
                if (((NetModel) this.ayU).ayS != null) {
                    com.baidu.adp.lib.h.h.hr().removeCallbacks(((NetModel) this.ayU).ayS);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.ayU.ayK, this.ayU.oS());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.ayU.oS());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.ayV != null && this.ayV.ww() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.ayV.ww().vv, this.ayV.ww().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.ayV.ww().adP);
                    mvcJsonHttpResponsedMessage.setErrorString(this.ayV.ww().mErrorString);
                    if (this.ayV.ww().adQ != null) {
                        BdLog.e(this.ayV.ww().adQ);
                    }
                }
                this.ayU.EZ();
                if (((NetModel) this.ayU).ayI != null) {
                    ((NetModel) this.ayU).ayI.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
