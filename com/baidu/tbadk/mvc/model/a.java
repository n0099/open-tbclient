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
    private MessageListener<CustomResponsedMessage<?>> awN;
    private MessageListener<CustomResponsedMessage<?>> awO;
    private InterfaceC0047a<T> awP;
    private boolean awQ;
    private boolean awR;
    private boolean awS;
    private boolean awT;
    private boolean awU;
    private boolean vY;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> DC();

    public abstract int DD();

    public abstract int DE();

    public abstract String Do();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.awQ = false;
        this.awR = false;
        this.awS = false;
        this.awT = false;
        this.vY = false;
        this.awU = false;
    }

    protected boolean Dv() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Dw() {
        this.vY = true;
        Dy();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(DD());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Dv());
        a(readCacheMessage);
        DA();
        sendMessage(readCacheMessage);
        this.vY = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.vY = true;
        Dy();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(DD());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Dv());
        a(readCacheMessage);
        DA();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.awU = true;
        Dz();
        Dx();
    }

    private final void Dx() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(DE());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        DB();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(DE());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        DB();
        sendMessage(writeCacheMessage);
    }

    private void Dy() {
        if (!this.awS) {
            if (this.awN == null) {
                this.awN = new b(this, DD());
                this.awN.setSelfListener(true);
                this.awN.setTag(this.unique_id);
            }
            registerListener(this.awN);
            this.awS = true;
        }
    }

    private void Dz() {
        if (!this.awT) {
            if (this.awO == null) {
                this.awO = new c(this, DE());
                this.awO.setSelfListener(true);
                this.awO.setTag(this.unique_id);
            }
            registerListener(this.awO);
            this.awT = true;
        }
    }

    private void DA() {
        if (!this.awQ && MessageManager.getInstance().findTask(DD()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(DD(), new com.baidu.tbadk.mvc.e.c(DD(), Do(), DC())));
            this.awQ = true;
        }
    }

    private void DB() {
        if (!this.awR && MessageManager.getInstance().findTask(DE()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(DE(), new com.baidu.tbadk.mvc.e.d(DE(), Do(), DC())));
            this.awR = true;
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

    public void a(InterfaceC0047a<T> interfaceC0047a) {
        this.awP = interfaceC0047a;
    }
}
