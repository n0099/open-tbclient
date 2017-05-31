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
import com.baidu.tbadk.core.util.z;
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
    private static /* synthetic */ int[] aED;
    private boolean aEA;
    private boolean aEB;
    private Runnable aEC;
    private c<T, D> aEt;
    private d<T, D> aEu;
    protected T aEv;
    private final NetModelType aEw;
    private a<T, D, ActivityType> aEx;
    private boolean aEy;
    private boolean aEz;
    private TbPageContext<ActivityType> ajh;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aEG) with 'values()' method */
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

    protected abstract int Ew();

    protected abstract int Ex();

    protected abstract String Ey();

    protected abstract Class<D> getResponseDataClass();

    static /* synthetic */ int[] EJ() {
        int[] iArr = aED;
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
            aED = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aEx = null;
        this.isNeedCache = false;
        this.aEy = false;
        this.aEz = false;
        this.aEA = false;
        this.isLoading = false;
        this.timeout = -1;
        this.aEB = true;
        this.ajh = tbPageContext;
        this.aEv = t;
        this.aEw = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Ez() {
        if (this.aEC == null) {
            this.aEC = new com.baidu.tbadk.mvc.model.c(this);
        }
        return this.aEC;
    }

    public boolean EA() {
        if (this.aEu == null && this.aEt == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.aEB = k.hB();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.h.fS().postDelayed(Ez(), this.timeout * 1000);
        }
        switch (EJ()[this.aEw.ordinal()]) {
            case 1:
                if (!this.aEB) {
                    com.baidu.adp.lib.g.h.fS().post(new e(this));
                    return false;
                }
                this.isLoading = true;
                EG();
                EB();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aEv, Ew());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> Eh = this.aEv.Eh();
                if (Eh != null) {
                    for (Map.Entry<String, Object> entry : Eh.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.aEB) {
                    com.baidu.adp.lib.g.h.fS().post(new f(this));
                    return false;
                }
                this.isLoading = true;
                EH();
                EB();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aEv, Ex());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.aEB) {
                    com.baidu.adp.lib.g.h.fS().post(new com.baidu.tbadk.mvc.model.d(this));
                    return false;
                }
                this.isLoading = true;
                EF();
                EH();
                EB();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aEv, Ew(), Ex());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.aEB) {
                    com.baidu.adp.lib.g.h.fS().post(new g(this));
                    return false;
                } else if (this.aEx == null) {
                    this.aEx = new a<>(this);
                    this.aEx.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void EB() {
        if (!this.aEA) {
            switch (EJ()[this.aEw.ordinal()]) {
                case 1:
                    i iVar = new i(this, Ew(), true);
                    iVar.setTag(getUniqueId());
                    registerListener(iVar);
                    break;
                case 2:
                    j jVar = new j(this, Ex(), true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
                case 3:
                    h hVar = new h(this, Ew(), Ex());
                    hVar.getHttpMessageListener().setSelfListener(true);
                    hVar.getSocketMessageListener().setSelfListener(true);
                    hVar.setTag(getUniqueId());
                    registerListener(hVar);
                    break;
            }
            this.aEA = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> EC() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> ED() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> EE() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean wq() {
        return this.isLoading;
    }

    private void EF() {
        if (!this.aEy && MessageManager.getInstance().findTask(Ew()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Ew(), String.valueOf(TbConfig.SERVER_ADDRESS) + Ey() + "?cmd=" + Ex());
            tbHttpMessageTask.setResponsedClass(EC());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Ew());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEy = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EG() {
        if (!this.aEy && MessageManager.getInstance().findTask(Ew()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(Ew(), String.valueOf(TbConfig.SERVER_ADDRESS) + Ey());
            tbHttpMessageTask.setResponsedClass(ED());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(Ew());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aEy = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void EH() {
        if (!this.aEz && MessageManager.getInstance().findTask(Ex()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(Ex());
            bVar.setResponsedClass(EE());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(Ex());
            MessageManager.getInstance().registerTask(bVar);
            this.aEz = true;
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
        MessageManager.getInstance().removeMessage(Ex(), this.unique_id);
        MessageManager.getInstance().removeMessage(Ew(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aEv, Ew(), Ex());
        if (this.aEu != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ex()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aEu.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aEt != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(Ew()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aEt.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        if (this.aEt != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aEv, Ew());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(Ew());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aEt.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aEv, Ex());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(Ex()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aEu.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EI() {
        this.aEx = null;
    }

    public void a(b<T, D> bVar) {
        this.aEt = bVar;
        this.aEu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aEE;
        private com.baidu.tbadk.core.util.a.a aEF;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aEE = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aEE).isLoading = true;
            z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aEE.Ey());
            for (Map.Entry<String, Object> entry : this.aEE.aEv.Eh().entrySet()) {
                zVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ug = zVar.ug();
            this.aEF = zVar.uF();
            D l = l(this.aEE.getResponseDataClass());
            if (ug != null) {
                try {
                    l.m(new JSONObject(ug));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.aEE.isNeedCache() && this.aEF != null && this.aEF.vB() != null && this.aEF.vB().isRequestSuccess() && l != null && (this.aEE.aEv instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aEE.aEv;
                String cacheKey = eVar.getCacheKey();
                String Ee = eVar.Ee();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Ee) || l == null) {
                    return l;
                }
                o<String> M = com.baidu.tbadk.core.c.a.sY().M(Ee, currentAccount);
                if (M == null) {
                    return l;
                }
                M.k(cacheKey, ug);
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
                ((NetModel) this.aEE).isLoading = false;
                if (((NetModel) this.aEE).aEC != null) {
                    com.baidu.adp.lib.g.h.fS().removeCallbacks(((NetModel) this.aEE).aEC);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aEE.aEv, this.aEE.Ew());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aEE.Ew());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aEF != null && this.aEF.vB() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aEF.vB().vR, this.aEF.vB().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aEF.vB().agu);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aEF.vB().mErrorString);
                    if (this.aEF.vB().agv != null) {
                        BdLog.e(this.aEF.vB().agv);
                    }
                }
                this.aEE.EI();
                if (((NetModel) this.aEE).aEt != null) {
                    ((NetModel) this.aEE).aEt.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
