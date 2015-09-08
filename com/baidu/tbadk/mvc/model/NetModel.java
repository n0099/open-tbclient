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
    private static /* synthetic */ int[] axg;
    private c<T, D> awT;
    private d<T, D> awU;
    protected T awV;
    private final NetModelType awW;
    private a<T, D, ActivityType> awX;
    private boolean awY;
    private boolean awZ;
    private boolean axa;
    private boolean axb;
    private boolean axc;
    private int axd;
    private boolean axe;
    private Runnable axf;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (axk) with 'values()' method */
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

    protected abstract int oR();

    protected abstract String oS();

    protected abstract int oT();

    static /* synthetic */ int[] Dn() {
        int[] iArr = axg;
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
            axg = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.awX = null;
        this.isNeedCache = false;
        this.awY = false;
        this.awZ = false;
        this.axa = false;
        this.axb = false;
        this.axc = false;
        this.axd = -1;
        this.axe = true;
        this.mPageContext = tbPageContext;
        this.awV = t;
        this.awW = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable De() {
        if (this.axf == null) {
            this.axf = new e(this);
        }
        return this.axf;
    }

    public boolean Df() {
        if (this.awU == null && this.awT == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.axe) {
            this.axe = com.baidu.adp.lib.util.k.jc();
        }
        if (this.axd >= 10) {
            com.baidu.adp.lib.g.h.hf().postDelayed(De(), this.axd * 1000);
        }
        switch (Dn()[this.awW.ordinal()]) {
            case 1:
                Dg();
                if (!this.axe) {
                    com.baidu.adp.lib.g.h.hf().post(new h(this));
                    return false;
                }
                this.axc = true;
                Dk();
                Dh();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.awV, oR());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oW = this.awV.oW();
                if (oW != null) {
                    for (Map.Entry<String, Object> entry : oW.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                Dg();
                if (!this.axe) {
                    com.baidu.adp.lib.g.h.hf().post(new i(this));
                    return false;
                }
                this.axc = true;
                Dl();
                Dh();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.awV, oT());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                Dg();
                if (!this.axe) {
                    com.baidu.adp.lib.g.h.hf().post(new g(this));
                    return false;
                }
                this.axc = true;
                Dj();
                Dl();
                Dh();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.awV, oR(), oT());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                Dg();
                if (!this.axe) {
                    com.baidu.adp.lib.g.h.hf().post(new j(this));
                    return false;
                } else if (this.awX == null) {
                    this.awX = new a<>(this);
                    this.awX.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Dg() {
        if (!this.axb) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.h.hf().post(new l(this, kVar));
            this.axb = true;
        }
    }

    private void Dh() {
        if (!this.axa) {
            switch (Dn()[this.awW.ordinal()]) {
                case 1:
                    n nVar = new n(this, oR(), true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
                case 2:
                    f fVar = new f(this, oT(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 3:
                    m mVar = new m(this, oR(), oT());
                    mVar.getHttpMessageListener().setSelfListener(true);
                    mVar.getSocketMessageListener().setSelfListener(true);
                    mVar.setTag(getUniqueId());
                    registerListener(mVar);
                    break;
            }
            this.axa = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oV() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Di() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oU() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.axc;
    }

    private void Dj() {
        if (!this.awY && MessageManager.getInstance().findTask(oR()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oR(), String.valueOf(TbConfig.SERVER_ADDRESS) + oS() + "?cmd=" + oT());
            tbHttpMessageTask.setResponsedClass(oV());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oR());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.awY = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Dk() {
        if (!this.awY && MessageManager.getInstance().findTask(oR()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oR(), String.valueOf(TbConfig.SERVER_ADDRESS) + oS());
            tbHttpMessageTask.setResponsedClass(Di());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oR());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.awY = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Dl() {
        if (!this.awZ && MessageManager.getInstance().findTask(oT()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oT());
            bVar.setResponsedClass(oU());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oT());
            MessageManager.getInstance().registerTask(bVar);
            this.awZ = true;
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
        this.axc = false;
        MessageManager.getInstance().removeMessage(oT(), this.unique_id);
        MessageManager.getInstance().removeMessage(oR(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.awV, oR(), oT());
        if (this.awU != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.awU.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.awT != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oR()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.awT.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        if (this.awT != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.awV, oR());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oR());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.awT.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.awV, oT());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.awU.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm() {
        this.awX = null;
    }

    public void a(b<T, D> bVar) {
        this.awT = bVar;
        this.awU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> axi;
        private com.baidu.tbadk.core.util.a.a axj;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.axi = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.axi).axc = true;
            v vVar = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + this.axi.oS());
            for (Map.Entry<String, Object> entry : this.axi.awV.oW().entrySet()) {
                vVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String tI = vVar.tI();
            this.axj = vVar.uj();
            D j = j(this.axi.getResponseDataClass());
            try {
                j.g(new JSONObject(tI));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            publishProgress(j);
            if (this.axi.isNeedCache() && this.axj != null && this.axj.va() != null && this.axj.va().qZ() && j != null && (this.axi.awV instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.axi.awV;
                String cacheKey = eVar.getCacheKey();
                String CN = eVar.CN();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(CN) || j == null) {
                    return j;
                }
                o<String> V = com.baidu.tbadk.core.b.a.sR().V(CN, currentAccount);
                if (V == null) {
                    return j;
                }
                V.f(cacheKey, tI);
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
                ((NetModel) this.axi).axc = false;
                if (((NetModel) this.axi).axf != null) {
                    com.baidu.adp.lib.g.h.hf().removeCallbacks(((NetModel) this.axi).axf);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.axi.awV, this.axi.oR());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.axi.oR());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.axj != null && this.axj.va() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.axj.va().abP, this.axj.va().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.axj.va().abQ);
                    mvcJsonHttpResponsedMessage.setErrorString(this.axj.va().mErrorString);
                    if (this.axj.va().abR != null) {
                        BdLog.e(this.axj.va().abR);
                    }
                }
                this.axi.Dm();
                if (((NetModel) this.axi).awT != null) {
                    ((NetModel) this.axi).awT.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
