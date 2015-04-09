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
    private MessageListener<CustomResponsedMessage<?>> amJ;
    private MessageListener<CustomResponsedMessage<?>> amK;
    private d<T> amL;
    private boolean amM;
    private boolean amN;
    private boolean amO;
    private boolean amP;
    private boolean amQ;

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.amM = false;
        this.amN = false;
        this.amO = false;
        this.amP = false;
        this.Eq = false;
        this.amQ = false;
    }

    protected boolean AP() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean AQ() {
        return this.Eq;
    }

    public final void AR() {
        this.Eq = true;
        AU();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(zV());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(AP());
        a(readCacheMessage);
        AW();
        sendMessage(readCacheMessage);
        this.Eq = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Eq = true;
        AU();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(zV());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(AP());
        a(readCacheMessage);
        AW();
        sendMessage(readCacheMessage);
    }

    public final void AS() {
        this.amQ = true;
        AV();
        AT();
    }

    private final void AT() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(zW());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        AX();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(zW());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        AX();
        sendMessage(writeCacheMessage);
    }

    private void AU() {
        if (!this.amO) {
            if (this.amJ == null) {
                this.amJ = new b(this, zV());
                this.amJ.setSelfListener(true);
                this.amJ.setTag(this.unique_id);
            }
            registerListener(this.amJ);
            this.amO = true;
        }
    }

    private void AV() {
        if (!this.amP) {
            if (this.amK == null) {
                this.amK = new c(this, zW());
                this.amK.setSelfListener(true);
                this.amK.setTag(this.unique_id);
            }
            registerListener(this.amK);
            this.amP = true;
        }
    }

    private void AW() {
        if (!this.amM && MessageManager.getInstance().findTask(zV()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(zV(), new com.baidu.tbadk.mvc.f.c(zV(), zX(), zU())));
            this.amM = true;
        }
    }

    private void AX() {
        if (!this.amN && MessageManager.getInstance().findTask(zW()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(zW(), new com.baidu.tbadk.mvc.f.d(zW(), zX(), zU())));
            this.amN = true;
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
        this.amL = dVar;
    }
}
