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
    private static /* synthetic */ int[] aeF;
    private boolean aeA;
    private boolean aeB;
    private boolean aeC;
    private boolean aeD;
    private Runnable aeE;
    private r<T, D> aet;
    private s<T, D> aeu;
    private T aev;
    private final NetModelType aew;
    private p<T, D, ActivityType> aex;
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

        /* JADX DEBUG: Replace access to removed values field (aeJ) with 'values()' method */
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
    public abstract int kL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String kM();

    protected abstract int kN();

    static /* synthetic */ int[] xT() {
        int[] iArr = aeF;
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
            aeF = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aex = null;
        this.isNeedCache = false;
        this.aey = false;
        this.aez = false;
        this.aeA = false;
        this.aeB = false;
        this.aeC = false;
        this.timeout = -1;
        this.aeD = true;
        this.mPageContext = tbPageContext;
        this.aev = t;
        this.aew = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable xK() {
        if (this.aeE == null) {
            this.aeE = new f(this);
        }
        return this.aeE;
    }

    public boolean xL() {
        if (this.aeu == null && this.aet == null && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aeD) {
            this.aeD = com.baidu.adp.lib.util.l.isNetOk();
        }
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.i.ej().postDelayed(xK(), this.timeout * 1000);
        }
        switch (xT()[this.aew.ordinal()]) {
            case 1:
                xM();
                if (!this.aeD) {
                    com.baidu.adp.lib.g.i.ej().post(new i(this));
                    return false;
                }
                this.aeC = true;
                xQ();
                xN();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.aev, kL());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.aev.kQ().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                xM();
                if (!this.aeD) {
                    com.baidu.adp.lib.g.i.ej().post(new j(this));
                    return false;
                }
                this.aeC = true;
                xR();
                xN();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.aev, kN());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                xM();
                if (!this.aeD) {
                    com.baidu.adp.lib.g.i.ej().post(new h(this));
                    return false;
                }
                this.aeC = true;
                xP();
                xR();
                xN();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.aev, kL(), kN());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                xM();
                if (!this.aeD) {
                    com.baidu.adp.lib.g.i.ej().post(new k(this));
                    return false;
                } else if (this.aex == null) {
                    this.aex = new p<>(this);
                    this.aex.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void xM() {
        if (!this.aeB) {
            l lVar = new l(this, 2001121);
            lVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.i.ej().post(new m(this, lVar));
            this.aeB = true;
        }
    }

    private void xN() {
        if (!this.aeA) {
            switch (xT()[this.aew.ordinal()]) {
                case 1:
                    o oVar = new o(this, kL(), true);
                    oVar.setTag(getUniqueId());
                    registerListener(oVar);
                    break;
                case 2:
                    g gVar = new g(this, kN(), true);
                    gVar.setTag(getUniqueId());
                    registerListener(gVar);
                    break;
                case 3:
                    n nVar = new n(this, kL(), kN());
                    nVar.br().setSelfListener(true);
                    nVar.bs().setSelfListener(true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
            }
            this.aeA = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> kP() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> xO() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> kO() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.aeC;
    }

    private void xP() {
        if (!this.aey && MessageManager.getInstance().findTask(kL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kL(), String.valueOf(TbConfig.SERVER_ADDRESS) + kM() + "?cmd=" + kN());
            tbHttpMessageTask.setResponsedClass(kP());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aey = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void xQ() {
        if (!this.aey && MessageManager.getInstance().findTask(kL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kL(), String.valueOf(TbConfig.SERVER_ADDRESS) + kM());
            tbHttpMessageTask.setResponsedClass(xO());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aey = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void xR() {
        if (!this.aez && MessageManager.getInstance().findTask(kN()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(kN());
            bVar.setResponsedClass(kO());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(kN());
            MessageManager.getInstance().registerTask(bVar);
            this.aez = true;
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
        this.aeC = false;
        MessageManager.getInstance().removeMessage(kN(), this.unique_id);
        MessageManager.getInstance().removeMessage(kL(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.aev, kL(), kN());
        if (this.aeu != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(kN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.aeu.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.aet != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(kL()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.aet.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, String str) {
        if (this.aet != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aev, kL());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(kL());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.aet.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.aev, kN());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(kN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.aeu.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS() {
        this.aex = null;
    }

    public void a(q<T, D> qVar) {
        this.aet = qVar;
        this.aeu = qVar;
    }

    public void a(r<T, D> rVar) {
        this.aet = rVar;
    }

    public void a(s<T, D> sVar) {
        this.aeu = sVar;
    }
}
