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
    private static /* synthetic */ int[] ayc;
    private c<T, D> axP;
    private d<T, D> axQ;
    protected T axR;
    private final NetModelType axS;
    private a<T, D, ActivityType> axT;
    private boolean axU;
    private boolean axV;
    private boolean axW;
    private boolean axX;
    private boolean axY;
    private int axZ;
    private boolean aya;
    private Runnable ayb;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (ayg) with 'values()' method */
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

    protected abstract int ox();

    protected abstract String oy();

    protected abstract int oz();

    static /* synthetic */ int[] DG() {
        int[] iArr = ayc;
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
            ayc = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.axT = null;
        this.isNeedCache = false;
        this.axU = false;
        this.axV = false;
        this.axW = false;
        this.axX = false;
        this.axY = false;
        this.axZ = -1;
        this.aya = true;
        this.mPageContext = tbPageContext;
        this.axR = t;
        this.axS = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Dx() {
        if (this.ayb == null) {
            this.ayb = new e(this);
        }
        return this.ayb;
    }

    public boolean Dy() {
        if (this.axQ == null && this.axP == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aya) {
            this.aya = com.baidu.adp.lib.util.k.jh();
        }
        if (this.axZ >= 10) {
            com.baidu.adp.lib.h.h.hj().postDelayed(Dx(), this.axZ * 1000);
        }
        switch (DG()[this.axS.ordinal()]) {
            case 1:
                Dz();
                if (!this.aya) {
                    com.baidu.adp.lib.h.h.hj().post(new h(this));
                    return false;
                }
                this.axY = true;
                DD();
                DA();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.axR, ox());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oC = this.axR.oC();
                if (oC != null) {
                    for (Map.Entry<String, Object> entry : oC.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                Dz();
                if (!this.aya) {
                    com.baidu.adp.lib.h.h.hj().post(new i(this));
                    return false;
                }
                this.axY = true;
                DE();
                DA();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.axR, oz());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                Dz();
                if (!this.aya) {
                    com.baidu.adp.lib.h.h.hj().post(new g(this));
                    return false;
                }
                this.axY = true;
                DC();
                DE();
                DA();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.axR, ox(), oz());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                Dz();
                if (!this.aya) {
                    com.baidu.adp.lib.h.h.hj().post(new j(this));
                    return false;
                } else if (this.axT == null) {
                    this.axT = new a<>(this);
                    this.axT.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Dz() {
        if (!this.axX) {
            k kVar = new k(this, 2000994);
            kVar.setTag(getUniqueId());
            com.baidu.adp.lib.h.h.hj().post(new l(this, kVar));
            this.axX = true;
        }
    }

    private void DA() {
        if (!this.axW) {
            switch (DG()[this.axS.ordinal()]) {
                case 1:
                    n nVar = new n(this, ox(), true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
                case 2:
                    f fVar = new f(this, oz(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 3:
                    m mVar = new m(this, ox(), oz());
                    mVar.getHttpMessageListener().setSelfListener(true);
                    mVar.getSocketMessageListener().setSelfListener(true);
                    mVar.setTag(getUniqueId());
                    registerListener(mVar);
                    break;
            }
            this.axW = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oB() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> DB() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oA() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.axY;
    }

    private void DC() {
        if (!this.axU && MessageManager.getInstance().findTask(ox()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ox(), String.valueOf(TbConfig.SERVER_ADDRESS) + oy() + "?cmd=" + oz());
            tbHttpMessageTask.setResponsedClass(oB());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ox());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.axU = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DD() {
        if (!this.axU && MessageManager.getInstance().findTask(ox()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ox(), String.valueOf(TbConfig.SERVER_ADDRESS) + oy());
            tbHttpMessageTask.setResponsedClass(DB());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ox());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.axU = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void DE() {
        if (!this.axV && MessageManager.getInstance().findTask(oz()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oz());
            bVar.setResponsedClass(oA());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oz());
            MessageManager.getInstance().registerTask(bVar);
            this.axV = true;
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
        this.axY = false;
        MessageManager.getInstance().removeMessage(oz(), this.unique_id);
        MessageManager.getInstance().removeMessage(ox(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.axR, ox(), oz());
        if (this.axQ != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.axQ.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.axP != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(ox()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.axP.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, String str) {
        if (this.axP != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.axR, ox());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(ox());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.axP.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.axR, oz());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.axQ.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF() {
        this.axT = null;
    }

    public void a(b<T, D> bVar) {
        this.axP = bVar;
        this.axQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> aye;
        private com.baidu.tbadk.core.util.a.a ayf;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.aye = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.aye).axY = true;
            ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aye.oy());
            for (Map.Entry<String, Object> entry : this.aye.axR.oC().entrySet()) {
                abVar.o(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String tV = abVar.tV();
            this.ayf = abVar.uw();
            D j = j(this.aye.getResponseDataClass());
            if (tV != null) {
                try {
                    j.g(new JSONObject(tV));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(j);
            if (this.aye.isNeedCache() && this.ayf != null && this.ayf.vq() != null && this.ayf.vq().qO() && j != null && (this.aye.axR instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aye.axR;
                String cacheKey = eVar.getCacheKey();
                String Dg = eVar.Dg();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(Dg) || j == null) {
                    return j;
                }
                o<String> Q = com.baidu.tbadk.core.b.a.tc().Q(Dg, currentAccount);
                if (Q == null) {
                    return j;
                }
                Q.f(cacheKey, tV);
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
                ((NetModel) this.aye).axY = false;
                if (((NetModel) this.aye).ayb != null) {
                    com.baidu.adp.lib.h.h.hj().removeCallbacks(((NetModel) this.aye).ayb);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aye.axR, this.aye.ox());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aye.ox());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.ayf != null && this.ayf.vq() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.ayf.vq().adt, this.ayf.vq().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.ayf.vq().adu);
                    mvcJsonHttpResponsedMessage.setErrorString(this.ayf.vq().mErrorString);
                    if (this.ayf.vq().adv != null) {
                        BdLog.e(this.ayf.vq().adv);
                    }
                }
                this.aye.DF();
                if (((NetModel) this.aye).axP != null) {
                    ((NetModel) this.aye).axP.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
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
