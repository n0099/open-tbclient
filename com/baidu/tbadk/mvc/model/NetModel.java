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
    private static /* synthetic */ int[] awt;
    private TbPageContext<ActivityType> Ea;
    private c<T, D> awh;
    private d<T, D> awi;
    protected T awj;
    private final NetModelType awk;
    private a<T, D, ActivityType> awl;
    private boolean awm;
    private boolean awn;
    private boolean awo;
    private boolean awp;
    private int awq;
    private boolean awr;
    private Runnable aws;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aww) with 'values()' method */
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

    protected abstract int lc();

    protected abstract String ld();

    protected abstract int le();

    static /* synthetic */ int[] DP() {
        int[] iArr = awt;
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
            awt = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.awl = null;
        this.isNeedCache = false;
        this.awm = false;
        this.awn = false;
        this.awo = false;
        this.awp = false;
        this.awq = -1;
        this.awr = true;
        this.Ea = tbPageContext;
        this.awj = t;
        this.awk = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable DG() {
        if (this.aws == null) {
            this.aws = new e(this);
        }
        return this.aws;
    }

    public boolean DH() {
        if (this.awi == null && this.awh == null && TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.awr = com.baidu.adp.lib.util.k.fI();
        if (this.awq >= 10) {
            com.baidu.adp.lib.h.h.dM().postDelayed(DG(), this.awq * 1000);
        }
        switch (DP()[this.awk.ordinal()]) {
            case 1:
                if (!this.awr) {
                    com.baidu.adp.lib.h.h.dM().post(new g(this));
                    return false;
                }
                this.awp = true;
                DM();
                DI();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.awj, lc());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> lh = this.awj.lh();
                if (lh != null) {
                    for (Map.Entry<String, Object> entry : lh.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                if (!this.awr) {
                    com.baidu.adp.lib.h.h.dM().post(new h(this));
                    return false;
                }
                this.awp = true;
                DN();
                DI();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.awj, le());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                if (!this.awr) {
                    com.baidu.adp.lib.h.h.dM().post(new f(this));
                    return false;
                }
                this.awp = true;
                DL();
                DN();
                DI();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.awj, lc(), le());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                if (!this.awr) {
                    com.baidu.adp.lib.h.h.dM().post(new i(this));
                    return false;
                } else if (this.awl == null) {
                    this.awl = new a<>(this);
                    this.awl.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void DI() {
        if (!this.awo) {
            switch (DP()[this.awk.ordinal()]) {
                case 1:
                    k kVar = new k(this, lc(), true);
                    kVar.setTag(getUniqueId());
                    registerListener(kVar);
                    break;
                case 2:
                    l lVar = new l(this, le(), true);
                    lVar.setTag(getUniqueId());
                    registerListener(lVar);
                    break;
                case 3:
                    j jVar = new j(this, lc(), le());
                    jVar.bn().setSelfListener(true);
                    jVar.bo().setSelfListener(true);
                    jVar.setTag(getUniqueId());
                    registerListener(jVar);
                    break;
            }
            this.awo = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> lg() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> DJ() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> lf() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean DK() {
        return this.awp;
    }

    private void DL() {
        if (!this.awm && MessageManager.getInstance().findTask(lc()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lc(), String.valueOf(TbConfig.SERVER_ADDRESS) + ld() + "?cmd=" + le());
            tbHttpMessageTask.setResponsedClass(lg());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lc());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.awm = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DM() {
        if (!this.awm && MessageManager.getInstance().findTask(lc()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(lc(), String.valueOf(TbConfig.SERVER_ADDRESS) + ld());
            tbHttpMessageTask.setResponsedClass(DJ());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(lc());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.awm = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DN() {
        if (!this.awn && MessageManager.getInstance().findTask(le()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(le());
            bVar.setResponsedClass(lf());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(le());
            MessageManager.getInstance().registerTask(bVar);
            this.awn = true;
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
        this.awp = false;
        MessageManager.getInstance().removeMessage(le(), this.unique_id);
        MessageManager.getInstance().removeMessage(lc(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.awj, lc(), le());
        if (this.awi != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(le()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.awi.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.awh != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(lc()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.awh.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str) {
        if (this.awh != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.awj, lc());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(lc());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.awh.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.awj, le());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(le()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.awi.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO() {
        this.awl = null;
    }

    public void a(b<T, D> bVar) {
        this.awh = bVar;
        this.awi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> awu;
        private com.baidu.tbadk.core.util.a.a awv;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.awu = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.awu).awp = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.awu.ld());
            for (Map.Entry<String, Object> entry : this.awu.awj.lh().entrySet()) {
                abVar.n(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String ta = abVar.ta();
            this.awv = abVar.ty();
            D t = t(this.awu.getResponseDataClass());
            if (ta != null) {
                try {
                    t.g(new JSONObject(ta));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(t);
            if (this.awu.isNeedCache() && this.awv != null && this.awv.uv() != null && this.awv.uv().nU() && t != null && (this.awu.awj instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.awu.awj;
                String cacheKey = eVar.getCacheKey();
                String Dp = eVar.Dp();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Dp) || t == null) {
                    return t;
                }
                o<String> N = com.baidu.tbadk.core.b.a.rP().N(Dp, currentAccount);
                if (N == null) {
                    return t;
                }
                N.e(cacheKey, ta);
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
                ((NetModel) this.awu).awp = false;
                if (((NetModel) this.awu).aws != null) {
                    com.baidu.adp.lib.h.h.dM().removeCallbacks(((NetModel) this.awu).aws);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.awu.awj, this.awu.lc());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.awu.lc());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.awv != null && this.awv.uv() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.awv.uv().lE, this.awv.uv().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.awv.uv().YU);
                    mvcJsonHttpResponsedMessage.setErrorString(this.awv.uv().mErrorString);
                    if (this.awv.uv().YV != null) {
                        BdLog.e(this.awv.uv().YV);
                    }
                }
                this.awu.DO();
                if (((NetModel) this.awu).awh != null) {
                    ((NetModel) this.awu).awh.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
