package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tbadk.mvc.b.d, ActivityType> extends com.baidu.adp.base.e<ActivityType> {
    private boolean EM;
    private MessageListener<CustomResponsedMessage<?>> axG;
    private MessageListener<CustomResponsedMessage<?>> axH;
    private InterfaceC0054a<T> axI;
    private boolean axJ;
    private boolean axK;
    private boolean axL;
    private boolean axM;
    private boolean axN;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0054a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Dg();

    public abstract Class<T> Du();

    public abstract int Dv();

    public abstract int Dw();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.axJ = false;
        this.axK = false;
        this.axL = false;
        this.axM = false;
        this.EM = false;
        this.axN = false;
    }

    protected boolean Dn() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Do() {
        this.EM = true;
        Dq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Dv());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Dn());
        a(readCacheMessage);
        Ds();
        sendMessage(readCacheMessage);
        this.EM = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.EM = true;
        Dq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Dv());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Dn());
        a(readCacheMessage);
        Ds();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.axN = true;
        Dr();
        Dp();
    }

    private final void Dp() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Dw());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Dt();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Dw());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Dt();
        sendMessage(writeCacheMessage);
    }

    private void Dq() {
        if (!this.axL) {
            if (this.axG == null) {
                this.axG = new b(this, Dv());
                this.axG.setSelfListener(true);
                this.axG.setTag(this.unique_id);
            }
            registerListener(this.axG);
            this.axL = true;
        }
    }

    private void Dr() {
        if (!this.axM) {
            if (this.axH == null) {
                this.axH = new c(this, Dw());
                this.axH.setSelfListener(true);
                this.axH.setTag(this.unique_id);
            }
            registerListener(this.axH);
            this.axM = true;
        }
    }

    private void Ds() {
        if (!this.axJ && MessageManager.getInstance().findTask(Dv()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Dv(), new com.baidu.tbadk.mvc.e.c(Dv(), Dg(), Du())));
            this.axJ = true;
        }
    }

    private void Dt() {
        if (!this.axK && MessageManager.getInstance().findTask(Dw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Dw(), new com.baidu.tbadk.mvc.e.d(Dw(), Dg(), Du())));
            this.axK = true;
        }
    }

    @Override // com.baidu.adp.base.e
    @Deprecated
    protected final boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeCustomMessage(getUniqueId());
        return true;
    }

    public void a(InterfaceC0054a<T> interfaceC0054a) {
        this.axI = interfaceC0054a;
    }
}
