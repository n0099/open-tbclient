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
    private MessageListener<CustomResponsedMessage<?>> XA;
    private MessageListener<CustomResponsedMessage<?>> XB;
    private d<T> XC;
    private boolean XD;
    private boolean XE;
    private boolean XF;
    private boolean XG;
    private boolean XH;
    private boolean XI;

    public a(Context context) {
        super(context);
        this.XD = false;
        this.XE = false;
        this.XF = false;
        this.XG = false;
        this.XH = false;
        this.XI = false;
    }

    protected boolean tz() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public boolean tA() {
        return this.XH;
    }

    public final void tB() {
        this.XH = true;
        tE();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(sU());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(tz());
        a(readCacheMessage);
        tG();
        sendMessage(readCacheMessage);
        this.XH = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.d dVar) {
        this.XH = true;
        tE();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(sU());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(dVar);
        readCacheMessage.setNeedUid(tz());
        a(readCacheMessage);
        tG();
        sendMessage(readCacheMessage);
    }

    public final void tC() {
        this.XI = true;
        tF();
        tD();
    }

    private final void tD() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(sV());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        tH();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(sV());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        tH();
        sendMessage(writeCacheMessage);
    }

    private void tE() {
        if (!this.XF) {
            if (this.XA == null) {
                this.XA = new b(this, sU());
                this.XA.setSelfListener(true);
                this.XA.setTag(this.unique_id);
            }
            registerListener(this.XA);
            this.XF = true;
        }
    }

    private void tF() {
        if (!this.XG) {
            if (this.XB == null) {
                this.XB = new c(this, sV());
                this.XB.setSelfListener(true);
                this.XB.setTag(this.unique_id);
            }
            registerListener(this.XB);
            this.XG = true;
        }
    }

    private void tG() {
        if (!this.XD && MessageManager.getInstance().findTask(sU()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(sU(), new com.baidu.tbadk.mvc.f.c(sU(), sW(), sT())));
            this.XD = true;
        }
    }

    private void tH() {
        if (!this.XE && MessageManager.getInstance().findTask(sV()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(sV(), new com.baidu.tbadk.mvc.f.d(sV(), sW(), sT())));
            this.XE = true;
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
        this.XC = dVar;
    }
}
