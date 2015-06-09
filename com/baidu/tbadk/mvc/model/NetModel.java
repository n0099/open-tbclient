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
import java.util.HashMap;
import java.util.Map;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> extends com.baidu.adp.base.f<ActivityType> {
    private static /* synthetic */ int[] aoh;
    private r<T, D> anV;
    private s<T, D> anW;
    protected T anX;
    private final NetModelType anY;
    private p<T, D, ActivityType> anZ;
    private boolean aoa;
    private boolean aob;
    private boolean aoc;
    private boolean aod;
    private boolean aoe;
    private boolean aof;
    private Runnable aog;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (aol) with 'values()' method */
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
    public abstract int oN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String oO();

    protected abstract int oP();

    static /* synthetic */ int[] BU() {
        int[] iArr = aoh;
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
            aoh = iArr;
        }
        return iArr;
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.anZ = null;
        this.isNeedCache = false;
        this.aoa = false;
        this.aob = false;
        this.aoc = false;
        this.aod = false;
        this.aoe = false;
        this.timeout = -1;
        this.aof = true;
        this.mPageContext = tbPageContext;
        this.anX = t;
        this.anY = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable BL() {
        if (this.aog == null) {
            this.aog = new f(this);
        }
        return this.aog;
    }

    public boolean BM() {
        if (this.anW == null && this.anV == null && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        if (this.aof) {
            this.aof = com.baidu.adp.lib.util.n.isNetOk();
        }
        if (this.timeout >= 10) {
            com.baidu.adp.lib.g.i.hs().postDelayed(BL(), this.timeout * 1000);
        }
        switch (BU()[this.anY.ordinal()]) {
            case 1:
                BN();
                if (!this.aof) {
                    com.baidu.adp.lib.g.i.hs().post(new i(this));
                    return false;
                }
                this.aoe = true;
                BR();
                BO();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.anX, oN());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> oS = this.anX.oS();
                if (oS != null) {
                    for (Map.Entry<String, Object> entry : oS.entrySet()) {
                        mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case 2:
                BN();
                if (!this.aof) {
                    com.baidu.adp.lib.g.i.hs().post(new j(this));
                    return false;
                }
                this.aoe = true;
                BS();
                BO();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.anX, oP());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case 3:
                BN();
                if (!this.aof) {
                    com.baidu.adp.lib.g.i.hs().post(new h(this));
                    return false;
                }
                this.aoe = true;
                BQ();
                BS();
                BO();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.anX, oN(), oP());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                sendMessage(mvcNetMessage);
                return true;
            case 4:
                BN();
                if (!this.aof) {
                    com.baidu.adp.lib.g.i.hs().post(new k(this));
                    return false;
                } else if (this.anZ == null) {
                    this.anZ = new p<>(this);
                    this.anZ.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void BN() {
        if (!this.aod) {
            l lVar = new l(this, 2001121);
            lVar.setTag(getUniqueId());
            com.baidu.adp.lib.g.i.hs().post(new m(this, lVar));
            this.aod = true;
        }
    }

    private void BO() {
        if (!this.aoc) {
            switch (BU()[this.anY.ordinal()]) {
                case 1:
                    o oVar = new o(this, oN(), true);
                    oVar.setTag(getUniqueId());
                    registerListener(oVar);
                    break;
                case 2:
                    g gVar = new g(this, oP(), true);
                    gVar.setTag(getUniqueId());
                    registerListener(gVar);
                    break;
                case 3:
                    n nVar = new n(this, oN(), oP());
                    nVar.eR().setSelfListener(true);
                    nVar.eS().setSelfListener(true);
                    nVar.setTag(getUniqueId());
                    registerListener(nVar);
                    break;
            }
            this.aoc = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> oR() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> BP() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> oQ() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.aoe;
    }

    private void BQ() {
        if (!this.aoa && MessageManager.getInstance().findTask(oN()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oN(), String.valueOf(TbConfig.SERVER_ADDRESS) + oO() + "?cmd=" + oP());
            tbHttpMessageTask.setResponsedClass(oR());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oN());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aoa = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void BR() {
        if (!this.aoa && MessageManager.getInstance().findTask(oN()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(oN(), String.valueOf(TbConfig.SERVER_ADDRESS) + oO());
            tbHttpMessageTask.setResponsedClass(BP());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(oN());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.aoa = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void BS() {
        if (!this.aob && MessageManager.getInstance().findTask(oP()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(oP());
            bVar.setResponsedClass(oQ());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(oP());
            MessageManager.getInstance().registerTask(bVar);
            this.aob = true;
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
        this.aoe = false;
        MessageManager.getInstance().removeMessage(oP(), this.unique_id);
        MessageManager.getInstance().removeMessage(oN(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.anX, oN(), oP());
        if (this.anW != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oP()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.anW.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.anV != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(oN()) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.anV.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.anV != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.anX, oN());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(oN());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.anV.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.anX, oP());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(oP()) { // from class: com.baidu.tbadk.mvc.model.NetModel.13
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.anW.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        this.anZ = null;
    }

    public void a(q<T, D> qVar) {
        this.anV = qVar;
        this.anW = qVar;
    }

    public void a(r<T, D> rVar) {
        this.anV = rVar;
    }

    public void a(s<T, D> sVar) {
        this.anW = sVar;
    }
}
