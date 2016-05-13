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
    private MessageListener<CustomResponsedMessage<?>> avi;
    private MessageListener<CustomResponsedMessage<?>> avj;
    private InterfaceC0046a<T> avk;
    private boolean avl;
    private boolean avm;
    private boolean avn;
    private boolean avo;
    private boolean avp;
    private boolean vv;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Dh();

    public abstract Class<T> Dv();

    public abstract int Dw();

    public abstract int Dx();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.avl = false;
        this.avm = false;
        this.avn = false;
        this.avo = false;
        this.vv = false;
        this.avp = false;
    }

    protected boolean Do() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Dp() {
        this.vv = true;
        Dr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Dw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Do());
        a(readCacheMessage);
        Dt();
        sendMessage(readCacheMessage);
        this.vv = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.vv = true;
        Dr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Dw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Do());
        a(readCacheMessage);
        Dt();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.avp = true;
        Ds();
        Dq();
    }

    private final void Dq() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Dx());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Du();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Dx());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Du();
        sendMessage(writeCacheMessage);
    }

    private void Dr() {
        if (!this.avn) {
            if (this.avi == null) {
                this.avi = new b(this, Dw());
                this.avi.setSelfListener(true);
                this.avi.setTag(this.unique_id);
            }
            registerListener(this.avi);
            this.avn = true;
        }
    }

    private void Ds() {
        if (!this.avo) {
            if (this.avj == null) {
                this.avj = new c(this, Dx());
                this.avj.setSelfListener(true);
                this.avj.setTag(this.unique_id);
            }
            registerListener(this.avj);
            this.avo = true;
        }
    }

    private void Dt() {
        if (!this.avl && MessageManager.getInstance().findTask(Dw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Dw(), new com.baidu.tbadk.mvc.e.c(Dw(), Dh(), Dv())));
            this.avl = true;
        }
    }

    private void Du() {
        if (!this.avm && MessageManager.getInstance().findTask(Dx()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Dx(), new com.baidu.tbadk.mvc.e.d(Dx(), Dh(), Dv())));
            this.avm = true;
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

    public void a(InterfaceC0046a<T> interfaceC0046a) {
        this.avk = interfaceC0046a;
    }
}
