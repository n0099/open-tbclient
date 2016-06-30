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
    private MessageListener<CustomResponsedMessage<?>> avY;
    private MessageListener<CustomResponsedMessage<?>> avZ;
    private InterfaceC0046a<T> awa;
    private boolean awb;
    private boolean awc;
    private boolean awd;
    private boolean awe;
    private boolean awf;
    private boolean vx;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> DD();

    public abstract int DE();

    public abstract int DF();

    public abstract String Dp();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.awb = false;
        this.awc = false;
        this.awd = false;
        this.awe = false;
        this.vx = false;
        this.awf = false;
    }

    protected boolean Dw() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Dx() {
        this.vx = true;
        Dz();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(DE());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Dw());
        a(readCacheMessage);
        DB();
        sendMessage(readCacheMessage);
        this.vx = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.vx = true;
        Dz();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(DE());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Dw());
        a(readCacheMessage);
        DB();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.awf = true;
        DA();
        Dy();
    }

    private final void Dy() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(DF());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        DC();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(DF());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        DC();
        sendMessage(writeCacheMessage);
    }

    private void Dz() {
        if (!this.awd) {
            if (this.avY == null) {
                this.avY = new b(this, DE());
                this.avY.setSelfListener(true);
                this.avY.setTag(this.unique_id);
            }
            registerListener(this.avY);
            this.awd = true;
        }
    }

    private void DA() {
        if (!this.awe) {
            if (this.avZ == null) {
                this.avZ = new c(this, DF());
                this.avZ.setSelfListener(true);
                this.avZ.setTag(this.unique_id);
            }
            registerListener(this.avZ);
            this.awe = true;
        }
    }

    private void DB() {
        if (!this.awb && MessageManager.getInstance().findTask(DE()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(DE(), new com.baidu.tbadk.mvc.e.c(DE(), Dp(), DD())));
            this.awb = true;
        }
    }

    private void DC() {
        if (!this.awc && MessageManager.getInstance().findTask(DF()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(DF(), new com.baidu.tbadk.mvc.e.d(DF(), Dp(), DD())));
            this.awc = true;
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
        this.awa = interfaceC0046a;
    }
}
