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
    private boolean Eh;
    private MessageListener<CustomResponsedMessage<?>> anM;
    private MessageListener<CustomResponsedMessage<?>> anN;
    private d<T> anO;
    private boolean anP;
    private boolean anQ;
    private boolean anR;
    private boolean anS;
    private boolean anT;

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.anP = false;
        this.anQ = false;
        this.anR = false;
        this.anS = false;
        this.Eh = false;
        this.anT = false;
    }

    protected boolean BC() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean BD() {
        return this.Eh;
    }

    public final void BE() {
        this.Eh = true;
        BH();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(AI());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(BC());
        a(readCacheMessage);
        BJ();
        sendMessage(readCacheMessage);
        this.Eh = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Eh = true;
        BH();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(AI());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(BC());
        a(readCacheMessage);
        BJ();
        sendMessage(readCacheMessage);
    }

    public final void BF() {
        this.anT = true;
        BI();
        BG();
    }

    private final void BG() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(AJ());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        BK();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(AJ());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        BK();
        sendMessage(writeCacheMessage);
    }

    private void BH() {
        if (!this.anR) {
            if (this.anM == null) {
                this.anM = new b(this, AI());
                this.anM.setSelfListener(true);
                this.anM.setTag(this.unique_id);
            }
            registerListener(this.anM);
            this.anR = true;
        }
    }

    private void BI() {
        if (!this.anS) {
            if (this.anN == null) {
                this.anN = new c(this, AJ());
                this.anN.setSelfListener(true);
                this.anN.setTag(this.unique_id);
            }
            registerListener(this.anN);
            this.anS = true;
        }
    }

    private void BJ() {
        if (!this.anP && MessageManager.getInstance().findTask(AI()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(AI(), new com.baidu.tbadk.mvc.f.c(AI(), AK(), AH())));
            this.anP = true;
        }
    }

    private void BK() {
        if (!this.anQ && MessageManager.getInstance().findTask(AJ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(AJ(), new com.baidu.tbadk.mvc.f.d(AJ(), AK(), AH())));
            this.anQ = true;
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
        this.anO = dVar;
    }
}
