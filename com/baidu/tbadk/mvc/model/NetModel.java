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
    private static /* synthetic */ int[] ane;
    private r<T, D> amS;
    private s<T, D> amT;
    protected T amU;
    private final NetModelType amV;
    private p<T, D, ActivityType> amW;
    private boolean amX;
    private boolean amY;
    private boolean amZ;
    private boolean ana;
    private boolean anb;
    private boolean anc;
    private Runnable and;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (ani) with 'values()' method */
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

    static /* synthetic */ int[] Bh() {
        int[] iArr = ane;
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
            ane = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.amW = null;
        this.isNeedCache = false;
        this.amX = false;
        this.amY = false;
        this.amZ = false;
        this.ana = false;
        this.anb = false;
        this.timeout = -1;
        this.anc = true;
        this.mPageContext = tbPageContext;
        this.amU = t;
        this.amV = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable AY() {
        if (this.and == null) {
            this.and = new f(this);
        }
        return this.and;
    }

    public boolean AZ() {
        if (this.amT == null && this.amS == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.anc) {
            this.anc = com.baidu.adp.lib.util.n.isNetOk();
        }
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.i.hI().postDelayed(AY(), this.timeout * 1000);
        }
        switch (Bh()[this.amV.ordinal()]) {
            case 1:
                Ba();
                if (!this.anc) {
                    com.baidu.adp.lib.g.i.hI().post(new i(this));
                    return false;
                }
                this.anb = true;
                Be();
                Bb();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.amU, ox());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.amU.oC().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                Ba();
                if (!this.anc) {
                    com.baidu.adp.lib.g.i.hI().post(new j(this));
                    return false;
                }
                this.anb = true;
                Bf();
                Bb();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.amU, oz());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                Ba();
                if (!this.anc) {
                    com.baidu.adp.lib.g.i.hI().post(new h(this));
                    return false;
                }
                this.anb = true;
                Bd();
                Bf();
                Bb();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.amU, ox(), oz());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                Ba();
                if (!this.anc) {
                    com.baidu.adp.lib.g.i.hI().post(new k(this));
                    return false;
                } else if (this.amW == null) {
                    this.amW = new p<>(this);
                    this.amW.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void Ba() {
        if (!this.ana) {
            l lVar = new l(this, 2001121);
            lVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.i.hI().post(new m(this, lVar));
            this.ana = true;
        }
    }

    private void Bb() {
        if (!this.amZ) {
            switch (Bh()[this.amV.ordinal()]) {
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
            this.amZ = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oB() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> Bc() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oA() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.anb;
    }

    private void Bd() {
        if (!this.amX && MessageManager.getInstance().findTask(ox()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ox(), String.valueOf(TbConfig.SERVER_ADDRESS) + oy() + "?cmd=" + oz());
            tbHttpMessageTask.setResponsedClass(oB());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ox());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.amX = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Be() {
        if (!this.amX && MessageManager.getInstance().findTask(ox()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(ox(), String.valueOf(TbConfig.SERVER_ADDRESS) + oy());
            tbHttpMessageTask.setResponsedClass(Bc());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(ox());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.amX = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void Bf() {
        if (!this.amY && MessageManager.getInstance().findTask(oz()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oz());
            bVar.setResponsedClass(oA());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oz());
            MessageManager.getInstance().registerTask(bVar);
            this.amY = true;
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
        this.anb = false;
        MessageManager.getInstance().removeMessage(oz(), this.unique_id);
        MessageManager.getInstance().removeMessage(ox(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.amU, ox(), oz());
        if (this.amT != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.amT.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.amS != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(ox()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.amS.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        if (this.amS != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.amU, ox());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(ox());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.amS.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.amU, oz());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oz()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.amT.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg() {
        this.amW = null;
    }

    public void a(q<T, D> qVar) {
        this.amS = qVar;
        this.amT = qVar;
    }

    public void a(r<T, D> rVar) {
        this.amS = rVar;
    }

    public void a(s<T, D> sVar) {
        this.amT = sVar;
    }
}
