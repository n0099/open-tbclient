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
    private static /* synthetic */ int[] azA;
    private TbPageContext<ActivityType> ND;
    private c<T, D> azp;
    private d<T, D> azq;
    protected T azr;
    private final NetModelType azs;
    private a<T, D, ActivityType> azt;
    private boolean azu;
    private boolean azv;
    private boolean azw;
    private boolean azx;
    private boolean azy;
    private Runnable azz;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (azD) with 'values()' method */
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

    protected abstract int oL();

    protected abstract String oM();

    protected abstract int oN();

    static /* synthetic */ int[] FN() {
        int[] iArr = azA;
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
            azA = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.azt = null;
        this.isNeedCache = false;
        this.azu = false;
        this.azv = false;
        this.azw = false;
        this.azx = false;
        this.timeout = -1;
        this.azy = true;
        this.ND = tbPageContext;
        this.azr = t;
        this.azs = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable FF() {
        if (this.azz == null) {
            this.azz = new e(this);
        }
        return this.azz;
    }

    public boolean FG() {
        if (this.azq == null && this.azp == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.azy = com.baidu.adp.lib.util.k.jw();
        if (this.timeout >= 10) {
            com.baidu.adp.lib.h.h.hx().postDelayed(FF(), this.timeout * 1000);
        }
        switch (FN()[this.azs.ordinal()]) {
            case 1:
                if (!this.azy) {
                    com.baidu.adp.lib.h.h.hx().post(new g(this));
                    return false;
                }
                this.azx = true;
                FK();
                FH();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.azr, oL());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oQ = this.azr.oQ();
                if (oQ != null) {
                    for (Map.Entry<String, Object> entry : oQ.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.azy) {
                    com.baidu.adp.lib.h.h.hx().post(new h(this));
                    return false;
                }
                this.azx = true;
                FL();
                FH();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.azr, oN());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.azy) {
                    com.baidu.adp.lib.h.h.hx().post(new f(this));
                    return false;
                }
                this.azx = true;
                FJ();
                FL();
                FH();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.azr, oL(), oN());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.azy) {
                    com.baidu.adp.lib.h.h.hx().post(new i(this));
                    return false;
                } else if (this.azt == null) {
                    this.azt = new a<>(this);
                    this.azt.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void FH() {
        if (!this.azw) {
            switch (FN()[this.azs.ordinal()]) {
                case 1:
                    k kVar = new k(this, oL(), true);
                    kVar.setTag(getUniqueId());
                    registerListener(kVar);
                    break;
                case 2:
                    l lVar = new l(this, oN(), true);
                    lVar.setTag(getUniqueId());
                    registerListener(lVar);
                    break;
                case 3:
                    j jVar = new j(this, oL(), oN());
                    jVar.eW().setSelfListener(true);
                    jVar.eX().setSelfListener(true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
            }
            this.azw = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oP() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> FI() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oO() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.azx;
    }

    private void FJ() {
        if (!this.azu && MessageManager.getInstance().findTask(oL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oL(), String.valueOf(TbConfig.SERVER_ADDRESS) + oM() + "?cmd=" + oN());
            tbHttpMessageTask.setResponsedClass(oP());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.azu = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FK() {
        if (!this.azu && MessageManager.getInstance().findTask(oL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oL(), String.valueOf(TbConfig.SERVER_ADDRESS) + oM());
            tbHttpMessageTask.setResponsedClass(FI());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.azu = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void FL() {
        if (!this.azv && MessageManager.getInstance().findTask(oN()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oN());
            bVar.setResponsedClass(oO());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oN());
            MessageManager.getInstance().registerTask(bVar);
            this.azv = true;
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
        this.azx = false;
        MessageManager.getInstance().removeMessage(oN(), this.unique_id);
        MessageManager.getInstance().removeMessage(oL(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.azr, oL(), oN());
        if (this.azq != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.azq.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.azp != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oL()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.azp.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.azp != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.azr, oL());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oL());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.azp.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.azr, oN());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.azq.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        this.azt = null;
    }

    public void a(b<T, D> bVar) {
        this.azp = bVar;
        this.azq = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> azB;
        private com.baidu.tbadk.core.util.a.a azC;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.azB = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.azB).azx = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.azB.oM());
            for (Map.Entry<String, Object> entry : this.azB.azr.oQ().entrySet()) {
                abVar.p(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String vw = abVar.vw();
            this.azC = abVar.vU();
            D l = l(this.azB.getResponseDataClass());
            if (vw != null) {
                try {
                    l.g(new JSONObject(vw));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(l);
            if (this.azB.isNeedCache() && this.azC != null && this.azC.wP() != null && this.azC.wP().qC() && l != null && (this.azB.azr instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.azB.azr;
                String cacheKey = eVar.getCacheKey();
                String Fo = eVar.Fo();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Fo) || l == null) {
                    return l;
                }
                o<String> O = com.baidu.tbadk.core.b.a.um().O(Fo, currentAccount);
                if (O == null) {
                    return l;
                }
                O.e(cacheKey, vw);
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
                ((NetModel) this.azB).azx = false;
                if (((NetModel) this.azB).azz != null) {
                    com.baidu.adp.lib.h.h.hx().removeCallbacks(((NetModel) this.azB).azz);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.azB.azr, this.azB.oL());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.azB.oL());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.azC != null && this.azC.wP() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.azC.wP().vL, this.azC.wP().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.azC.wP().adf);
                    mvcJsonHttpResponsedMessage.setErrorString(this.azC.wP().mErrorString);
                    if (this.azC.wP().adg != null) {
                        BdLog.e(this.azC.wP().adg);
                    }
                }
                this.azB.FM();
                if (((NetModel) this.azB).azp != null) {
                    ((NetModel) this.azB).azp.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
