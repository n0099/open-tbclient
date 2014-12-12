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
    private static /* synthetic */ int[] aei;
    private r<T, D> adW;
    private s<T, D> adX;
    private T adY;
    private final NetModelType adZ;
    private p<T, D, ActivityType> aea;
    private boolean aeb;
    private boolean aec;
    private boolean aed;
    private boolean aee;
    private boolean aef;
    private boolean aeg;
    private Runnable aeh;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aem) with 'values()' method */
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

    static /* synthetic */ int[] xD() {
        int[] iArr = aei;
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
            aei = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.aea = null;
        this.isNeedCache = false;
        this.aeb = false;
        this.aec = false;
        this.aed = false;
        this.aee = false;
        this.aef = false;
        this.timeout = -1;
        this.aeg = true;
        this.mPageContext = tbPageContext;
        this.adY = t;
        this.adZ = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable xu() {
        if (this.aeh == null) {
            this.aeh = new f(this);
        }
        return this.aeh;
    }

    public boolean xv() {
        if (this.adX == null && this.adW == null && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aeg) {
            this.aeg = com.baidu.adp.lib.util.l.isNetOk();
        }
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.i.el().postDelayed(xu(), this.timeout * 1000);
        }
        switch (xD()[this.adZ.ordinal()]) {
            case 1:
                xw();
                if (!this.aeg) {
                    com.baidu.adp.lib.g.i.el().post(new i(this));
                    return false;
                }
                this.aef = true;
                xA();
                xx();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.adY, kL());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.adY.kQ().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                xw();
                if (!this.aeg) {
                    com.baidu.adp.lib.g.i.el().post(new j(this));
                    return false;
                }
                this.aef = true;
                xB();
                xx();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.adY, kN());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                xw();
                if (!this.aeg) {
                    com.baidu.adp.lib.g.i.el().post(new h(this));
                    return false;
                }
                this.aef = true;
                xz();
                xB();
                xx();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.adY, kL(), kN());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                xw();
                if (!this.aeg) {
                    com.baidu.adp.lib.g.i.el().post(new k(this));
                    return false;
                } else if (this.aea == null) {
                    this.aea = new p<>(this);
                    this.aea.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void xw() {
        if (!this.aee) {
            l lVar = new l(this, 2001121);
            lVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.i.el().post(new m(this, lVar));
            this.aee = true;
        }
    }

    private void xx() {
        if (!this.aed) {
            switch (xD()[this.adZ.ordinal()]) {
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
                    nVar.bp().setSelfListener(true);
                    nVar.bq().setSelfListener(true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
            }
            this.aed = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> kP() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> xy() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> kO() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.aef;
    }

    private void xz() {
        if (!this.aeb && MessageManager.getInstance().findTask(kL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kL(), String.valueOf(TbConfig.SERVER_ADDRESS) + kM() + "?cmd=" + kN());
            tbHttpMessageTask.setResponsedClass(kP());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aeb = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void xA() {
        if (!this.aeb && MessageManager.getInstance().findTask(kL()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(kL(), String.valueOf(TbConfig.SERVER_ADDRESS) + kM());
            tbHttpMessageTask.setResponsedClass(xy());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(kL());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aeb = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void xB() {
        if (!this.aec && MessageManager.getInstance().findTask(kN()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(kN());
            bVar.setResponsedClass(kO());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(kN());
            MessageManager.getInstance().registerTask(bVar);
            this.aec = true;
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
        this.aef = false;
        MessageManager.getInstance().removeMessage(kN(), this.unique_id);
        MessageManager.getInstance().removeMessage(kL(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.adY, kL(), kN());
        if (this.adX != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(kN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.adX.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.adW != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(kL()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.adW.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, String str) {
        if (this.adW != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.adY, kL());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(kL());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.adW.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.adY, kN());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(kN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.adX.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC() {
        this.aea = null;
    }

    public void a(q<T, D> qVar) {
        this.adW = qVar;
        this.adX = qVar;
    }

    public void a(r<T, D> rVar) {
        this.adW = rVar;
    }

    public void a(s<T, D> sVar) {
        this.adX = sVar;
    }
}
