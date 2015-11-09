package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
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
    private static /* synthetic */ int[] auu;
    private c<T, D> auh;
    private d<T, D> aui;
    protected T auj;
    private final NetModelType auk;
    private a<T, D, ActivityType> aul;
    private boolean aum;
    private boolean aun;
    private boolean auo;
    private boolean aup;
    private boolean auq;
    private int aur;
    private boolean aus;
    private Runnable aut;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (auy) with 'values()' method */
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

    protected abstract int oT();

    protected abstract String oU();

    protected abstract int oV();

    static /* synthetic */ int[] CQ() {
        int[] iArr = auu;
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
            auu = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aul = null;
        this.isNeedCache = false;
        this.aum = false;
        this.aun = false;
        this.auo = false;
        this.aup = false;
        this.auq = false;
        this.aur = -1;
        this.aus = true;
        this.mPageContext = tbPageContext;
        this.auj = t;
        this.auk = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable CH() {
        if (this.aut == null) {
            this.aut = new e(this);
        }
        return this.aut;
    }

    public boolean CI() {
        if (this.aui == null && this.auh == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aus) {
            this.aus = com.baidu.adp.lib.util.k.je();
        }
        if (this.aur >= 10) {
            com.baidu.adp.lib.g.h.hh().postDelayed(CH(), this.aur * 1000);
        }
        switch (CQ()[this.auk.ordinal()]) {
            case 1:
                CJ();
                if (!this.aus) {
                    com.baidu.adp.lib.g.h.hh().post(new h(this));
                    return false;
                }
                this.auq = true;
                CN();
                CK();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.auj, oT());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oY = this.auj.oY();
                if (oY != null) {
                    for (Map.Entry<String, Object> entry : oY.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                CJ();
                if (!this.aus) {
                    com.baidu.adp.lib.g.h.hh().post(new i(this));
                    return false;
                }
                this.auq = true;
                CO();
                CK();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.auj, oV());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                CJ();
                if (!this.aus) {
                    com.baidu.adp.lib.g.h.hh().post(new g(this));
                    return false;
                }
                this.auq = true;
                CM();
                CO();
                CK();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.auj, oT(), oV());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                CJ();
                if (!this.aus) {
                    com.baidu.adp.lib.g.h.hh().post(new j(this));
                    return false;
                } else if (this.aul == null) {
                    this.aul = new a<>(this);
                    this.aul.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void CJ() {
        if (!this.aup) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.h.hh().post(new l(this, kVar));
            this.aup = true;
        }
    }

    private void CK() {
        if (!this.auo) {
            switch (CQ()[this.auk.ordinal()]) {
                case 1:
                    n nVar = new n(this, oT(), true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
                case 2:
                    f fVar = new f(this, oV(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 3:
                    m mVar = new m(this, oT(), oV());
                    mVar.getHttpMessageListener().setSelfListener(true);
                    mVar.getSocketMessageListener().setSelfListener(true);
                    mVar.setTag(getUniqueId());
                    registerListener(mVar);
                    break;
            }
            this.auo = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oX() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> CL() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oW() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.auq;
    }

    private void CM() {
        if (!this.aum && MessageManager.getInstance().findTask(oT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oT(), String.valueOf(TbConfig.SERVER_ADDRESS) + oU() + "?cmd=" + oV());
            tbHttpMessageTask.setResponsedClass(oX());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aum = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void CN() {
        if (!this.aum && MessageManager.getInstance().findTask(oT()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oT(), String.valueOf(TbConfig.SERVER_ADDRESS) + oU());
            tbHttpMessageTask.setResponsedClass(CL());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oT());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aum = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void CO() {
        if (!this.aun && MessageManager.getInstance().findTask(oV()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oV());
            bVar.setResponsedClass(oW());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oV());
            MessageManager.getInstance().registerTask(bVar);
            this.aun = true;
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
        this.auq = false;
        MessageManager.getInstance().removeMessage(oV(), this.unique_id);
        MessageManager.getInstance().removeMessage(oT(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.auj, oT(), oV());
        if (this.aui != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oV()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aui.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.auh != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oT()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.auh.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        if (this.auh != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.auj, oT());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oT());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.auh.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.auj, oV());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oV()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aui.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CP() {
        this.aul = null;
    }

    public void a(b<T, D> bVar) {
        this.auh = bVar;
        this.aui = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> auw;
        private com.baidu.tbadk.core.util.a.a aux;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.auw = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.auw).auq = true;
            w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.auw.oU());
            for (Map.Entry<String, Object> entry : this.auw.auj.oY().entrySet()) {
                wVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String tG = wVar.tG();
            this.aux = wVar.uh();
            D j = j(this.auw.getResponseDataClass());
            try {
                j.g(new JSONObject(tG));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            publishProgress(j);
            if (this.auw.isNeedCache() && this.aux != null && this.aux.va() != null && this.aux.va().qT() && j != null && (this.auw.auj instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.auw.auj;
                String cacheKey = eVar.getCacheKey();
                String Cq = eVar.Cq();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Cq) || j == null) {
                    return j;
                }
                o<String> U = com.baidu.tbadk.core.b.a.sO().U(Cq, currentAccount);
                if (U == null) {
                    return j;
                }
                U.f(cacheKey, tG);
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
                ((NetModel) this.auw).auq = false;
                if (((NetModel) this.auw).aut != null) {
                    com.baidu.adp.lib.g.h.hh().removeCallbacks(((NetModel) this.auw).aut);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.auw.auj, this.auw.oT());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.auw.oT());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.aux != null && this.aux.va() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.aux.va().abW, this.aux.va().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.aux.va().abX);
                    mvcJsonHttpResponsedMessage.setErrorString(this.aux.va().mErrorString);
                    if (this.aux.va().abY != null) {
                        BdLog.e(this.aux.va().abY);
                    }
                }
                this.auw.CP();
                if (((NetModel) this.auw).auh != null) {
                    ((NetModel) this.auw).auh.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
