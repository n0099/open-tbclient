package com.baidu.tbadk.mvc.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mvc.b.c;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tbadk.mvc.b.c> extends com.baidu.adp.base.e implements com.baidu.tbadk.mvc.a.b<T> {
    private MessageListener<CustomResponsedMessage<?>> XE;
    private MessageListener<CustomResponsedMessage<?>> XF;
    private d<T> XG;
    private boolean XH;
    private boolean XI;
    private boolean XJ;
    private boolean XK;
    private boolean XL;
    private boolean XM;

    public a(Context context) {
        super(context);
        this.XH = false;
        this.XI = false;
        this.XJ = false;
        this.XK = false;
        this.XL = false;
        this.XM = false;
    }

    protected boolean tB() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean tC() {
        return this.XL;
    }

    public final void tD() {
        this.XL = true;
        tG();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(sW());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(tB());
        a(readCacheMessage);
        tI();
        sendMessage(readCacheMessage);
        this.XL = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.d dVar) {
        this.XL = true;
        tG();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(sW());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(dVar);
        readCacheMessage.setNeedUid(tB());
        a(readCacheMessage);
        tI();
        sendMessage(readCacheMessage);
    }

    public final void tE() {
        this.XM = true;
        tH();
        tF();
    }

    private final void tF() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(sX());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        tJ();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(sX());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        tJ();
        sendMessage(writeCacheMessage);
    }

    private void tG() {
        if (!this.XJ) {
            if (this.XE == null) {
                this.XE = new b(this, sW());
                this.XE.setSelfListener(true);
                this.XE.setTag(this.unique_id);
            }
            registerListener(this.XE);
            this.XJ = true;
        }
    }

    private void tH() {
        if (!this.XK) {
            if (this.XF == null) {
                this.XF = new c(this, sX());
                this.XF.setSelfListener(true);
                this.XF.setTag(this.unique_id);
            }
            registerListener(this.XF);
            this.XK = true;
        }
    }

    private void tI() {
        if (!this.XH && MessageManager.getInstance().findTask(sW()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(sW(), new com.baidu.tbadk.mvc.f.c(sW(), sY(), sV())));
            this.XH = true;
        }
    }

    private void tJ() {
        if (!this.XI && MessageManager.getInstance().findTask(sX()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(sX(), new com.baidu.tbadk.mvc.f.d(sX(), sY(), sV())));
            this.XI = true;
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

    public void a(d<T> dVar) {
        this.XG = dVar;
    }
}
