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
    private static /* synthetic */ int[] XW;
    private j<T, D> XO;
    private k<T, D> XP;
    private T XQ;
    private final NetModelType XR;
    private h<T, D> XS;
    private boolean XT;
    private boolean XU;
    private boolean XV;
    private boolean isLoading;
    private boolean isNeedCache;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK;

        /* JADX DEBUG: Replace access to removed values field (XZ) with 'values()' method */
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
    public abstract int tK();

    protected abstract int tL();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String tM();

    static /* synthetic */ int[] tW() {
        int[] iArr = XW;
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
            XW = iArr;
        }
        return iArr;
    }

    public NetModel(Context context, T t, NetModelType netModelType) {
        super(context);
        this.XS = null;
        this.isNeedCache = false;
        this.XT = false;
        this.XU = false;
        this.XV = false;
        this.isLoading = false;
        this.XQ = t;
        this.XR = netModelType;
    }

    protected boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public boolean tN() {
        switch (tW()[this.XR.ordinal()]) {
            case 1:
                this.isLoading = true;
                tU();
                tO();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.XQ, tK());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                for (Map.Entry<String, Object> entry : this.XQ.tq().entrySet()) {
                    mvcHttpMessage.addParam(entry.getKey(), entry.getValue());
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                break;
            case 2:
                this.isLoading = true;
                tV();
                tO();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.XQ, tL());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                break;
            case 3:
                this.isLoading = true;
                tT();
                tV();
                tO();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.XQ, tK(), tL());
                mvcNetMessage.setNeedCache(isNeedCache());
                sendMessage(mvcNetMessage);
                break;
            case 4:
                if (this.XS == null) {
                    this.XS = new h<>(this);
                    this.XS.execute(new Object[0]);
                    break;
                }
                break;
        }
        return false;
    }

    private void tO() {
        if (!this.XV) {
            switch (tW()[this.XR.ordinal()]) {
                case 1:
                    f fVar = new f(this, tK(), true);
                    fVar.setTag(getUniqueId());
                    registerListener(fVar);
                    break;
                case 2:
                    g gVar = new g(this, tL(), true);
                    gVar.setTag(getUniqueId());
                    registerListener(gVar);
                    break;
                case 3:
                    e eVar = new e(this, tK(), tL());
                    eVar.aO().setSelfListener(true);
                    eVar.aP().setSelfListener(true);
                    eVar.setTag(getUniqueId());
                    registerListener(eVar);
                    break;
            }
            this.XV = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> tP() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> tQ() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> tR() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean tS() {
        return this.isLoading;
    }

    private void tT() {
        if (!this.XT && MessageManager.getInstance().findTask(tK()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(tK(), String.valueOf(TbConfig.SERVER_ADDRESS) + tM() + "?cmd=" + tL());
            tbHttpMessageTask.setResponsedClass(tP());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(tK());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.XT = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void tU() {
        if (!this.XT && MessageManager.getInstance().findTask(tK()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(tK(), String.valueOf(TbConfig.SERVER_ADDRESS) + tM());
            tbHttpMessageTask.setResponsedClass(tQ());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(tK());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.XT = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void tV() {
        if (!this.XU && MessageManager.getInstance().findTask(tL()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(tL());
            bVar.setResponsedClass(tR());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(tL());
            MessageManager.getInstance().registerTask(bVar);
            this.XU = true;
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
        MessageManager.getInstance().removeMessage(tL(), this.unique_id);
        MessageManager.getInstance().removeMessage(tK(), this.unique_id);
        return true;
    }

    public void a(j<T, D> jVar) {
        this.XO = jVar;
    }

    public void a(k<T, D> kVar) {
        this.XP = kVar;
    }
}
