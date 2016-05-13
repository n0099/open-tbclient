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
    private static /* synthetic */ int[] avD;
    private TbPageContext<ActivityType> DV;
    private int avA;
    private boolean avB;
    private Runnable avC;
    private c<T, D> avr;
    private d<T, D> avs;
    protected T avt;
    private final NetModelType avu;
    private a<T, D, ActivityType> avv;
    private boolean avw;
    private boolean avx;
    private boolean avy;
    private boolean avz;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (avG) with 'values()' method */
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

    static /* synthetic */ int[] DG() {
        int[] iArr = avD;
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
            avD = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.avv = null;
        this.isNeedCache = false;
        this.avw = false;
        this.avx = false;
        this.avy = false;
        this.avz = false;
        this.avA = -1;
        this.avB = true;
        this.DV = tbPageContext;
        this.avt = t;
        this.avu = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Dy() {
        if (this.avC == null) {
            this.avC = new e(this);
        }
        return this.avC;
    }

    public boolean Dz() {
        if (this.avs == null && this.avr == null && TbadkCoreApplication.m11getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.avB = com.baidu.adp.lib.util.k.fH();
        if (this.avA >= 10) {
            com.baidu.adp.lib.h.h.dL().postDelayed(Dy(), this.avA * 1000);
        }
        switch (DG()[this.avu.ordinal()]) {
            case 1:
                if (!this.avB) {
                    com.baidu.adp.lib.h.h.dL().post(new g(this));
                    return false;
                }
                this.avz = true;
                DD();
                DA();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.avt, kY());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> ld = this.avt.ld();
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
                if (!this.avB) {
                    com.baidu.adp.lib.h.h.dL().post(new h(this));
                    return false;
                }
                this.avz = true;
                DE();
                DA();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.avt, la());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.avB) {
                    com.baidu.adp.lib.h.h.dL().post(new f(this));
                    return false;
                }
                this.avz = true;
                DC();
                DE();
                DA();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.avt, kY(), la());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.avB) {
                    com.baidu.adp.lib.h.h.dL().post(new i(this));
                    return false;
                } else if (this.avv == null) {
                    this.avv = new a<>(this);
                    this.avv.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void DA() {
        if (!this.avy) {
            switch (DG()[this.avu.ordinal()]) {
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
            this.avy = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> lc() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> DB() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lb() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.avz;
    }

    private void DC() {
        if (!this.avw && MessageManager.getInstance().findTask(kY()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kY(), String.valueOf(TbConfig.SERVER_ADDRESS) + kZ() + "?cmd=" + la());
            tbHttpMessageTask.setResponsedClass(lc());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kY());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avw = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DD() {
        if (!this.avw && MessageManager.getInstance().findTask(kY()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kY(), String.valueOf(TbConfig.SERVER_ADDRESS) + kZ());
            tbHttpMessageTask.setResponsedClass(DB());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kY());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.avw = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DE() {
        if (!this.avx && MessageManager.getInstance().findTask(la()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(la());
            bVar.setResponsedClass(lb());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(la());
            MessageManager.getInstance().registerTask(bVar);
            this.avx = true;
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
        this.avz = false;
        MessageManager.getInstance().removeMessage(la(), this.unique_id);
        MessageManager.getInstance().removeMessage(kY(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.avt, kY(), la());
        if (this.avs != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(la()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.avs.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.avr != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(kY()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.avr.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.avr != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avt, kY());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(kY());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.avr.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.avt, la());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(la()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.avs.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF() {
        this.avv = null;
    }

    public void a(b<T, D> bVar) {
        this.avr = bVar;
        this.avs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> avE;
        private com.baidu.tbadk.core.util.a.a avF;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.avE = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.avE).avz = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.avE.kZ());
            for (Map.Entry<String, Object> entry : this.avE.avt.ld().entrySet()) {
                abVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String td = abVar.td();
            this.avF = abVar.tB();
            D l = l(this.avE.getResponseDataClass());
            if (td != null) {
                try {
                    l.g(new JSONObject(td));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.avE.isNeedCache() && this.avF != null && this.avF.uw() != null && this.avF.uw().nZ() && l != null && (this.avE.avt instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.avE.avt;
                String cacheKey = eVar.getCacheKey();
                String Dh = eVar.Dh();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Dh) || l == null) {
                    return l;
                }
                o<String> O = com.baidu.tbadk.core.b.a.rS().O(Dh, currentAccount);
                if (O == null) {
                    return l;
                }
                O.e(cacheKey, td);
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
                ((NetModel) this.avE).avz = false;
                if (((NetModel) this.avE).avC != null) {
                    com.baidu.adp.lib.h.h.dL().removeCallbacks(((NetModel) this.avE).avC);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.avE.avt, this.avE.kY());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.avE.kY());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.avF != null && this.avF.uw() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.avF.uw().lE, this.avF.uw().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.avF.uw().YD);
                    mvcJsonHttpResponsedMessage.setErrorString(this.avF.uw().mErrorString);
                    if (this.avF.uw().YE != null) {
                        BdLog.e(this.avF.uw().YE);
                    }
                }
                this.avE.DF();
                if (((NetModel) this.avE).avr != null) {
                    ((NetModel) this.avE).avr.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
