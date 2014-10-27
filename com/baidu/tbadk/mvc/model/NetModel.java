package com.baidu.tbadk.mvc.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class NetModel<T extends com.baidu.tbadk.mvc.b.g, D extends com.baidu.tbadk.mvc.b.i> extends com.baidu.adp.base.e {
    private static /* synthetic */ int[] XS;
    private j<T, D> XK;
    private k<T, D> XL;
    private T XM;
    private final NetModelType XN;
    private h<T, D> XO;
    private boolean XP;
    private boolean XQ;
    private boolean XR;
    private boolean isLoading;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (XV) with 'values()' method */
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
    public abstract int tI();

    protected abstract int tJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String tK();

    static /* synthetic */ int[] tU() {
        int[] iArr = XS;
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
            XS = iArr;
        }
        return iArr;
    }

    public NetModel(Context context, T t, NetModelType netModelType) {
        super(context);
        this.XO = null;
        this.isNeedCache = false;
        this.XP = false;
        this.XQ = false;
        this.XR = false;
        this.isLoading = false;
        this.XM = t;
        this.XN = netModelType;
    }

    protected boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public boolean tL() {
        switch (tU()[this.XN.ordinal()]) {
            case 1:
                this.isLoading = true;
                tS();
                tM();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.XM, tI());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.XM.to().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                break;
            case 2:
                this.isLoading = true;
                tT();
                tM();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.XM, tJ());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                break;
            case 3:
                this.isLoading = true;
                tR();
                tT();
                tM();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.XM, tI(), tJ());
                mvcNetMessage.setNeedCache(isNeedCache());
                sendMessage(mvcNetMessage);
                break;
            case 4:
                if (this.XO == null) {
                    this.XO = new h<>(this);
                    this.XO.execute(new Object[0]);
                    break;
                }
                break;
        }
        return false;
    }

    private void tM() {
        if (!this.XR) {
            switch (tU()[this.XN.ordinal()]) {
                case 1:
                    f fVar = new f(this, tI(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 2:
                    g gVar = new g(this, tJ(), true);
                    gVar.setTag(getUniqueId());
                    registerListener(gVar);
                    break;
                case 3:
                    e eVar = new e(this, tI(), tJ());
                    eVar.aO().setSelfListener(true);
                    eVar.aP().setSelfListener(true);
                    eVar.setTag(getUniqueId());
                    registerListener(eVar);
                    break;
            }
            this.XR = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> tN() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> tO() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> tP() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean tQ() {
        return this.isLoading;
    }

    private void tR() {
        if (!this.XP && MessageManager.getInstance().findTask(tI()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(tI(), String.valueOf(TbConfig.SERVER_ADDRESS) + tK() + "?cmd=" + tJ());
            tbHttpMessageTask.setResponsedClass(tN());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(tI());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.XP = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void tS() {
        if (!this.XP && MessageManager.getInstance().findTask(tI()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(tI(), String.valueOf(TbConfig.SERVER_ADDRESS) + tK());
            tbHttpMessageTask.setResponsedClass(tO());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(tI());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.XP = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void tT() {
        if (!this.XQ && MessageManager.getInstance().findTask(tJ()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(tJ());
            bVar.setResponsedClass(tP());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(tJ());
            MessageManager.getInstance().registerTask(bVar);
            this.XQ = true;
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
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(tJ(), this.unique_id);
        MessageManager.getInstance().removeMessage(tI(), this.unique_id);
        return true;
    }

    public void a(j<T, D> jVar) {
        this.XK = jVar;
    }

    public void a(k<T, D> kVar) {
        this.XL = kVar;
    }
}
