package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import java.util.Map;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends com.baidu.adp.base.f<ActivityType> {
    private static /* synthetic */ int[] aeC;
    private boolean aeA;
    private Runnable aeB;
    private r<T, D> aeq;
    private s<T, D> aer;
    private T aes;
    private final NetModelType aet;
    private p<T, D, ActivityType> aeu;
    private boolean aev;
    private boolean aew;
    private boolean aex;
    private boolean aey;
    private boolean aez;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aeG) with 'values()' method */
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
    public abstract int kE();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String kF();

    protected abstract int kG();

    static /* synthetic */ int[] xN() {
        int[] iArr = aeC;
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
            aeC = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aeu = null;
        this.isNeedCache = false;
        this.aev = false;
        this.aew = false;
        this.aex = false;
        this.aey = false;
        this.aez = false;
        this.timeout = -1;
        this.aeA = true;
        this.mPageContext = tbPageContext;
        this.aes = t;
        this.aet = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable xE() {
        if (this.aeB == null) {
            this.aeB = new f(this);
        }
        return this.aeB;
    }

    public boolean xF() {
        if (this.aer == null && this.aeq == null && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aeA) {
            this.aeA = com.baidu.adp.lib.util.l.isNetOk();
        }
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.i.ej().postDelayed(xE(), this.timeout * 1000);
        }
        switch (xN()[this.aet.ordinal()]) {
            case 1:
                xG();
                if (!this.aeA) {
                    com.baidu.adp.lib.g.i.ej().post(new i(this));
                    return false;
                }
                this.aez = true;
                xK();
                xH();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aes, kE());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.aes.kJ().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                xG();
                if (!this.aeA) {
                    com.baidu.adp.lib.g.i.ej().post(new j(this));
                    return false;
                }
                this.aez = true;
                xL();
                xH();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aes, kG());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                xG();
                if (!this.aeA) {
                    com.baidu.adp.lib.g.i.ej().post(new h(this));
                    return false;
                }
                this.aez = true;
                xJ();
                xL();
                xH();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aes, kE(), kG());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                xG();
                if (!this.aeA) {
                    com.baidu.adp.lib.g.i.ej().post(new k(this));
                    return false;
                } else if (this.aeu == null) {
                    this.aeu = new p<>(this);
                    this.aeu.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void xG() {
        if (!this.aey) {
            l lVar = new l(this, 2001121);
            lVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.i.ej().post(new m(this, lVar));
            this.aey = true;
        }
    }

    private void xH() {
        if (!this.aex) {
            switch (xN()[this.aet.ordinal()]) {
                case 1:
                    o oVar = new o(this, kE(), true);
                    oVar.setTag(getUniqueId());
                    registerListener(oVar);
                    break;
                case 2:
                    g gVar = new g(this, kG(), true);
                    gVar.setTag(getUniqueId());
                    registerListener(gVar);
                    break;
                case 3:
                    n nVar = new n(this, kE(), kG());
                    nVar.br().setSelfListener(true);
                    nVar.bs().setSelfListener(true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
            }
            this.aex = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> kI() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> xI() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> kH() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.aez;
    }

    private void xJ() {
        if (!this.aev && MessageManager.getInstance().findTask(kE()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kE(), String.valueOf(TbConfig.SERVER_ADDRESS) + kF() + "?cmd=" + kG());
            tbHttpMessageTask.setResponsedClass(kI());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kE());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aev = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void xK() {
        if (!this.aev && MessageManager.getInstance().findTask(kE()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kE(), String.valueOf(TbConfig.SERVER_ADDRESS) + kF());
            tbHttpMessageTask.setResponsedClass(xI());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kE());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aev = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void xL() {
        if (!this.aew && MessageManager.getInstance().findTask(kG()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(kG());
            bVar.setResponsedClass(kH());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(kG());
            MessageManager.getInstance().registerTask(bVar);
            this.aew = true;
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
        this.aez = false;
        MessageManager.getInstance().removeMessage(kG(), this.unique_id);
        MessageManager.getInstance().removeMessage(kE(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aes, kE(), kG());
        if (this.aer != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(kG()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aer.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aeq != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(kE()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aeq.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, String str) {
        if (this.aeq != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aes, kE());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(kE());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aeq.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aes, kG());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(kG()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aer.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM() {
        this.aeu = null;
    }

    public void a(q<T, D> qVar) {
        this.aeq = qVar;
        this.aer = qVar;
    }

    public void a(r<T, D> rVar) {
        this.aeq = rVar;
    }

    public void a(s<T, D> sVar) {
        this.aer = sVar;
    }
}
