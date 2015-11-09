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
    private boolean Eg;
    private MessageListener<CustomResponsedMessage<?>> atY;
    private MessageListener<CustomResponsedMessage<?>> atZ;
    private InterfaceC0052a<T> aua;
    private boolean aub;
    private boolean auc;
    private boolean aud;
    private boolean aue;
    private boolean auf;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> CE();

    public abstract int CF();

    public abstract int CG();

    public abstract String Cq();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aub = false;
        this.auc = false;
        this.aud = false;
        this.aue = false;
        this.Eg = false;
        this.auf = false;
    }

    protected boolean Cx() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Cy() {
        this.Eg = true;
        CA();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CF());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Cx());
        a(readCacheMessage);
        CC();
        sendMessage(readCacheMessage);
        this.Eg = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Eg = true;
        CA();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CF());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Cx());
        a(readCacheMessage);
        CC();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.auf = true;
        CB();
        Cz();
    }

    private final void Cz() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CG());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        CD();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CG());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        CD();
        sendMessage(writeCacheMessage);
    }

    private void CA() {
        if (!this.aud) {
            if (this.atY == null) {
                this.atY = new b(this, CF());
                this.atY.setSelfListener(true);
                this.atY.setTag(this.unique_id);
            }
            registerListener(this.atY);
            this.aud = true;
        }
    }

    private void CB() {
        if (!this.aue) {
            if (this.atZ == null) {
                this.atZ = new c(this, CG());
                this.atZ.setSelfListener(true);
                this.atZ.setTag(this.unique_id);
            }
            registerListener(this.atZ);
            this.aue = true;
        }
    }

    private void CC() {
        if (!this.aub && MessageManager.getInstance().findTask(CF()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CF(), new com.baidu.tbadk.mvc.e.c(CF(), Cq(), CE())));
            this.aub = true;
        }
    }

    private void CD() {
        if (!this.auc && MessageManager.getInstance().findTask(CG()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CG(), new com.baidu.tbadk.mvc.e.d(CG(), Cq(), CE())));
            this.auc = true;
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

    public void a(InterfaceC0052a<T> interfaceC0052a) {
        this.aua = interfaceC0052a;
    }
}
