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
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdBaseModel<ActivityType> {
    private static /* synthetic */ int[] aFR;
    private c<T, D> aFH;
    private d<T, D> aFI;
    protected T aFJ;
    private final NetModelType aFK;
    private a<T, D, ActivityType> aFL;
    private boolean aFM;
    private boolean aFN;
    private boolean aFO;
    private boolean aFP;
    private Runnable aFQ;
    private TbPageContext<ActivityType> ajP;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aFU) with 'values()' method */
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

    protected abstract int ET();

    protected abstract int EU();

    protected abstract String EV();

    protected abstract Class<D> getResponseDataClass();

    static /* synthetic */ int[] Fg() {
        int[] iArr = aFR;
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
            aFR = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aFL = null;
        this.isNeedCache = false;
        this.aFM = false;
        this.aFN = false;
        this.aFO = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aFP = true;
        this.ajP = tbPageContext;
        this.aFJ = t;
        this.aFK = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable EW() {
        if (this.aFQ == null) {
            this.aFQ = new com.baidu.tbadk.mvc.model.c(this);
        }
        return this.aFQ;
    }

    public boolean EX() {
        if (this.aFI == null && this.aFH == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aFP = k.hA();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.h.fR().postDelayed(EW(), this.timeout * 1000);
        }
        switch (Fg()[this.aFK.ordinal()]) {
            case 1:
                if (!this.aFP) {
                    com.baidu.adp.lib.g.h.fR().post(new e(this));
                    return false;
                }
                this.isLoading = true;
                Fd();
                EY();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aFJ, ET());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> EE = this.aFJ.EE();
                if (EE != null) {
                    for (Map.Entry<String, Object> entry : EE.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aFP) {
                    com.baidu.adp.lib.g.h.fR().post(new f(this));
                    return false;
                }
                this.isLoading = true;
                Fe();
                EY();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aFJ, EU());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aFP) {
                    com.baidu.adp.lib.g.h.fR().post(new com.baidu.tbadk.mvc.model.d(this));
                    return false;
                }
                this.isLoading = true;
                Fc();
                Fe();
                EY();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aFJ, ET(), EU());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aFP) {
                    com.baidu.adp.lib.g.h.fR().post(new g(this));
                    return false;
                } else if (this.aFL == null) {
                    this.aFL = new a<>(this);
                    this.aFL.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EY() {
        if (!this.aFO) {
            switch (Fg()[this.aFK.ordinal()]) {
                case 1:
                    i iVar = new i(this, ET(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                    break;
                case 2:
                    j jVar = new j(this, EU(), true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
                case 3:
                    h hVar = new h(this, ET(), EU());
                    hVar.getHttpMessageListener().setSelfListener(true);
                    hVar.getSocketMessageListener().setSelfListener(true);
                    hVar.setTag(getUniqueId());
                    registerListener(hVar);
                    break;
            }
            this.aFO = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> EZ() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Fa() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> Fb() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wI() {
        return this.isLoading;
    }

    private void Fc() {
        if (!this.aFM && MessageManager.getInstance().findTask(ET()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ET(), String.valueOf(TbConfig.SERVER_ADDRESS) + EV() + "?cmd=" + EU());
            tbHttpMessageTask.setResponsedClass(EZ());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ET());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aFM = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fd() {
        if (!this.aFM && MessageManager.getInstance().findTask(ET()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ET(), String.valueOf(TbConfig.SERVER_ADDRESS) + EV());
            tbHttpMessageTask.setResponsedClass(Fa());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ET());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aFM = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Fe() {
        if (!this.aFN && MessageManager.getInstance().findTask(EU()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(EU());
            bVar.setResponsedClass(Fb());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(EU());
            MessageManager.getInstance().registerTask(bVar);
            this.aFN = true;
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
        MessageManager.getInstance().removeMessage(EU(), this.unique_id);
        MessageManager.getInstance().removeMessage(ET(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aFJ, ET(), EU());
        if (this.aFI != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(EU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aFI.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aFH != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(ET()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aFH.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        if (this.aFH != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aFJ, ET());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(ET());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aFH.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aFJ, EU());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(EU()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aFI.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ff() {
        this.aFL = null;
    }

    public void a(b<T, D> bVar) {
        this.aFH = bVar;
        this.aFI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aFS;
        private com.baidu.tbadk.core.util.a.a aFT;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aFS = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aFS).isLoading = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aFS.EV());
            for (Map.Entry<String, Object> entry : this.aFS.aFJ.EE().entrySet()) {
                abVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String uy = abVar.uy();
            this.aFT = abVar.uV();
            D l = l(this.aFS.getResponseDataClass());
            if (uy != null) {
                try {
                    l.n(new JSONObject(uy));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aFS.isNeedCache() && this.aFT != null && this.aFT.vS() != null && this.aFT.vS().isRequestSuccess() && l != null && (this.aFS.aFJ instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aFS.aFJ;
                String cacheKey = eVar.getCacheKey();
                String EB = eVar.EB();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(EB) || l == null) {
                    return l;
                }
                o<String> M = com.baidu.tbadk.core.c.a.sW().M(EB, currentAccount);
                if (M == null) {
                    return l;
                }
                M.k(cacheKey, uy);
            }
            return l;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.aFS).isLoading = false;
                if (((NetModel) this.aFS).aFQ != null) {
                    com.baidu.adp.lib.g.h.fR().removeCallbacks(((NetModel) this.aFS).aFQ);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aFS.aFJ, this.aFS.ET());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aFS.ET());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aFT != null && this.aFT.vS() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aFT.vS().vQ, this.aFT.vS().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aFT.vS().ahc);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aFT.vS().mErrorString);
                    if (this.aFT.vS().ahd != null) {
                        BdLog.e(this.aFT.vS().ahd);
                    }
                }
                this.aFS.Ff();
                if (((NetModel) this.aFS).aFH != null) {
                    ((NetModel) this.aFS).aFH.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D l(Class<D> cls) {
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
