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
    private MessageListener<CustomResponsedMessage<?>> aeh;
    private MessageListener<CustomResponsedMessage<?>> aei;
    private d<T> aej;
    private boolean aek;
    private boolean ael;
    private boolean aem;
    private boolean aen;
    private boolean aeo;
    private boolean tw;

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aek = false;
        this.ael = false;
        this.aem = false;
        this.aen = false;
        this.tw = false;
        this.aeo = false;
    }

    protected boolean xv() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean xw() {
        return this.tw;
    }

    public final void xx() {
        this.tw = true;
        xA();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(lh());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(xv());
        a(readCacheMessage);
        xC();
        sendMessage(readCacheMessage);
        this.tw = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.tw = true;
        xA();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(lh());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(xv());
        a(readCacheMessage);
        xC();
        sendMessage(readCacheMessage);
    }

    public final void xy() {
        this.aeo = true;
        xB();
        xz();
    }

    private final void xz() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(li());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        xD();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(li());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        xD();
        sendMessage(writeCacheMessage);
    }

    private void xA() {
        if (!this.aem) {
            if (this.aeh == null) {
                this.aeh = new b(this, lh());
                this.aeh.setSelfListener(true);
                this.aeh.setTag(this.unique_id);
            }
            registerListener(this.aeh);
            this.aem = true;
        }
    }

    private void xB() {
        if (!this.aen) {
            if (this.aei == null) {
                this.aei = new c(this, li());
                this.aei.setSelfListener(true);
                this.aei.setTag(this.unique_id);
            }
            registerListener(this.aei);
            this.aen = true;
        }
    }

    private void xC() {
        if (!this.aek && MessageManager.getInstance().findTask(lh()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(lh(), new com.baidu.tbadk.mvc.f.c(lh(), lj(), lg())));
            this.aek = true;
        }
    }

    private void xD() {
        if (!this.ael && MessageManager.getInstance().findTask(li()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(li(), new com.baidu.tbadk.mvc.f.d(li(), lj(), lg())));
            this.ael = true;
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
        this.aej = dVar;
    }
}
