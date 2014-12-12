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
    private MessageListener<CustomResponsedMessage<?>> adN;
    private MessageListener<CustomResponsedMessage<?>> adO;
    private d<T> adP;
    private boolean adQ;
    private boolean adR;
    private boolean adS;
    private boolean adT;
    private boolean adU;
    private boolean tq;

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.adQ = false;
        this.adR = false;
        this.adS = false;
        this.adT = false;
        this.tq = false;
        this.adU = false;
    }

    protected boolean xl() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean xm() {
        return this.tq;
    }

    public final void xn() {
        this.tq = true;
        xq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(lo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(xl());
        a(readCacheMessage);
        xs();
        sendMessage(readCacheMessage);
        this.tq = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.tq = true;
        xq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(lo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(xl());
        a(readCacheMessage);
        xs();
        sendMessage(readCacheMessage);
    }

    public final void xo() {
        this.adU = true;
        xr();
        xp();
    }

    private final void xp() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(lp());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        xt();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(lp());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        xt();
        sendMessage(writeCacheMessage);
    }

    private void xq() {
        if (!this.adS) {
            if (this.adN == null) {
                this.adN = new b(this, lo());
                this.adN.setSelfListener(true);
                this.adN.setTag(this.unique_id);
            }
            registerListener(this.adN);
            this.adS = true;
        }
    }

    private void xr() {
        if (!this.adT) {
            if (this.adO == null) {
                this.adO = new c(this, lp());
                this.adO.setSelfListener(true);
                this.adO.setTag(this.unique_id);
            }
            registerListener(this.adO);
            this.adT = true;
        }
    }

    private void xs() {
        if (!this.adQ && MessageManager.getInstance().findTask(lo()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(lo(), new com.baidu.tbadk.mvc.f.c(lo(), lq(), ln())));
            this.adQ = true;
        }
    }

    private void xt() {
        if (!this.adR && MessageManager.getInstance().findTask(lp()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(lp(), new com.baidu.tbadk.mvc.f.d(lp(), lq(), ln())));
            this.adR = true;
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
        this.adP = dVar;
    }
}
