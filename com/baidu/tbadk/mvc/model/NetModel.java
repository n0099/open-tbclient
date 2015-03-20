package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Map;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> extends com.baidu.adp.base.f<ActivityType> {
    private static /* synthetic */ int[] amW;
    private r<T, D> amK;
    private s<T, D> amL;
    protected T amM;
    private final NetModelType amN;
    private p<T, D, ActivityType> amO;
    private boolean amP;
    private boolean amQ;
    private boolean amR;
    private boolean amS;
    private boolean amT;
    private boolean amU;
    private Runnable amV;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (ana) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetModelType[] valuesCustom() {
            NetModelType[] valuesCustom = values();
            int length = valuesCustom.length;
            NetModelType[] netModelTypeArr = new NetModelType[length];
            System.arraycopy(valuesCustom, 0, netModelTypeArr, 0, length);
            return netModelTypeArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Class<D> getResponseDataClass();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int ox();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String oy();

    protected abstract int oz();

    static /* synthetic */ int[] Bb() {
        int[] iArr = amW;
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
            amW = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.amO = null;
        this.isNeedCache = false;
        this.amP = false;
        this.amQ = false;
        this.amR = false;
        this.amS = false;
        this.amT = false;
        this.timeout = -1;
        this.amU = true;
        this.mPageContext = tbPageContext;
        this.amM = t;
        this.amN = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable AS() {
        if (this.amV == null) {
            this.amV = new f(this);
        }
        return this.amV;
    }

    public boolean AT() {
        if (this.amL == null && this.amK == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.amU) {
            this.amU = com.baidu.adp.lib.util.n.isNetOk();
        }
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.i.hI().postDelayed(AS(), this.timeout * 1000);
        }
        switch (Bb()[this.amN.ordinal()]) {
            case 1:
                AU();
                if (!this.amU) {
                    com.baidu.adp.lib.g.i.hI().post(new i(this));
                    return false;
                }
                this.amT = true;
                AY();
                AV();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.amM, ox());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.amM.oC().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                AU();
                if (!this.amU) {
                    com.baidu.adp.lib.g.i.hI().post(new j(this));
                    return false;
                }
                this.amT = true;
                AZ();
                AV();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.amM, oz());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                AU();
                if (!this.amU) {
                    com.baidu.adp.lib.g.i.hI().post(new h(this));
                    return false;
                }
                this.amT = true;
                AX();
                AZ();
                AV();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.amM, ox(), oz());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                AU();
                if (!this.amU) {
                    com.baidu.adp.lib.g.i.hI().post(new k(this));
                    return false;
                } else if (this.amO == null) {
                    this.amO = new p<>(this);
                    this.amO.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void AU() {
        if (!this.amS) {
            l lVar = new l(this, 2001121);
            lVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.i.hI().post(new m(this, lVar));
            this.amS = true;
        }
    }

    private void AV() {
        if (!this.amR) {
            switch (Bb()[this.amN.ordinal()]) {
                case 1:
                    o oVar = new o(this, ox(), true);
                    oVar.setTag(getUniqueId());
                    registerListener(oVar);
                    break;
                case 2:
                    g gVar = new g(this, oz(), true);
                    gVar.setTag(getUniqueId());
                    registerListener(gVar);
                    break;
                case 3:
                    n nVar = new n(this, ox(), oz());
                    nVar.eO().setSelfListener(true);
                    nVar.eP().setSelfListener(true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
            }
            this.amR = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oB() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> AW() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oA() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.amT;
    }

    private void AX() {
        if (!this.amP && MessageManager.getInstance().findTask(ox()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ox(), String.valueOf(TbConfig.SERVER_ADDRESS) + oy() + "?cmd=" + oz());
            tbHttpMessageTask.setResponsedClass(oB());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ox());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.amP = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void AY() {
        if (!this.amP && MessageManager.getInstance().findTask(ox()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ox(), String.valueOf(TbConfig.SERVER_ADDRESS) + oy());
            tbHttpMessageTask.setResponsedClass(AW());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ox());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.amP = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void AZ() {
        if (!this.amQ && MessageManager.getInstance().findTask(oz()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oz());
            bVar.setResponsedClass(oA());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oz());
            MessageManager.getInstance().registerTask(bVar);
            this.amQ = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.adp.base.f
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        this.amT = false;
        MessageManager.getInstance().removeMessage(oz(), this.unique_id);
        MessageManager.getInstance().removeMessage(ox(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.amM, ox(), oz());
        if (this.amL != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.amL.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.amK != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(ox()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.amK.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        if (this.amK != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.amM, ox());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(ox());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.amK.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.amM, oz());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.amL.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        this.amO = null;
    }

    public void a(q<T, D> qVar) {
        this.amK = qVar;
        this.amL = qVar;
    }

    public void a(r<T, D> rVar) {
        this.amK = rVar;
    }

    public void a(s<T, D> sVar) {
        this.amL = sVar;
    }
}
