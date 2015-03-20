package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tbadk.mvc.b.d, ActivityType> extends com.baidu.adp.base.f<ActivityType> implements com.baidu.tbadk.mvc.a.b<T> {
    private boolean Eq;
    private MessageListener<CustomResponsedMessage<?>> amB;
    private MessageListener<CustomResponsedMessage<?>> amC;
    private d<T> amD;
    private boolean amE;
    private boolean amF;
    private boolean amG;
    private boolean amH;
    private boolean amI;

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.amE = false;
        this.amF = false;
        this.amG = false;
        this.amH = false;
        this.Eq = false;
        this.amI = false;
    }

    protected boolean AJ() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean AK() {
        return this.Eq;
    }

    public final void AL() {
        this.Eq = true;
        AO();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(zP());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(AJ());
        a(readCacheMessage);
        AQ();
        sendMessage(readCacheMessage);
        this.Eq = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Eq = true;
        AO();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(zP());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(AJ());
        a(readCacheMessage);
        AQ();
        sendMessage(readCacheMessage);
    }

    public final void AM() {
        this.amI = true;
        AP();
        AN();
    }

    private final void AN() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(zQ());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        AR();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(zQ());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        AR();
        sendMessage(writeCacheMessage);
    }

    private void AO() {
        if (!this.amG) {
            if (this.amB == null) {
                this.amB = new b(this, zP());
                this.amB.setSelfListener(true);
                this.amB.setTag(this.unique_id);
            }
            registerListener(this.amB);
            this.amG = true;
        }
    }

    private void AP() {
        if (!this.amH) {
            if (this.amC == null) {
                this.amC = new c(this, zQ());
                this.amC.setSelfListener(true);
                this.amC.setTag(this.unique_id);
            }
            registerListener(this.amC);
            this.amH = true;
        }
    }

    private void AQ() {
        if (!this.amE && MessageManager.getInstance().findTask(zP()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(zP(), new com.baidu.tbadk.mvc.f.c(zP(), zR(), zO())));
            this.amE = true;
        }
    }

    private void AR() {
        if (!this.amF && MessageManager.getInstance().findTask(zQ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(zQ(), new com.baidu.tbadk.mvc.f.d(zQ(), zR(), zO())));
            this.amF = true;
        }
    }

    @Override // com.baidu.adp.base.f
    @Deprecated
    protected final boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeCustomMessage(getUniqueId());
        return true;
    }

    public void a(d<T> dVar) {
        this.amD = dVar;
    }
}
