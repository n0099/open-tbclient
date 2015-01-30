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
    private MessageListener<CustomResponsedMessage<?>> aek;
    private MessageListener<CustomResponsedMessage<?>> ael;
    private d<T> aem;
    private boolean aen;
    private boolean aeo;
    private boolean aep;
    private boolean aeq;
    private boolean aer;
    private boolean tz;

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aen = false;
        this.aeo = false;
        this.aep = false;
        this.aeq = false;
        this.tz = false;
        this.aer = false;
    }

    protected boolean xB() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean xC() {
        return this.tz;
    }

    public final void xD() {
        this.tz = true;
        xG();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(lo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(xB());
        a(readCacheMessage);
        xI();
        sendMessage(readCacheMessage);
        this.tz = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.tz = true;
        xG();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(lo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(xB());
        a(readCacheMessage);
        xI();
        sendMessage(readCacheMessage);
    }

    public final void xE() {
        this.aer = true;
        xH();
        xF();
    }

    private final void xF() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(lp());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        xJ();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(lp());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        xJ();
        sendMessage(writeCacheMessage);
    }

    private void xG() {
        if (!this.aep) {
            if (this.aek == null) {
                this.aek = new b(this, lo());
                this.aek.setSelfListener(true);
                this.aek.setTag(this.unique_id);
            }
            registerListener(this.aek);
            this.aep = true;
        }
    }

    private void xH() {
        if (!this.aeq) {
            if (this.ael == null) {
                this.ael = new c(this, lp());
                this.ael.setSelfListener(true);
                this.ael.setTag(this.unique_id);
            }
            registerListener(this.ael);
            this.aeq = true;
        }
    }

    private void xI() {
        if (!this.aen && MessageManager.getInstance().findTask(lo()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(lo(), new com.baidu.tbadk.mvc.f.c(lo(), lq(), ln())));
            this.aen = true;
        }
    }

    private void xJ() {
        if (!this.aeo && MessageManager.getInstance().findTask(lp()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(lp(), new com.baidu.tbadk.mvc.f.d(lp(), lq(), ln())));
            this.aeo = true;
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
        this.aem = dVar;
    }
}
