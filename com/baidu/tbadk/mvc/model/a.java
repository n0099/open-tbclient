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
    private boolean azA;
    private boolean azB;
    private boolean azC;
    private boolean azD;
    private boolean azE;
    private MessageListener<CustomResponsedMessage<?>> azx;
    private MessageListener<CustomResponsedMessage<?>> azy;
    private InterfaceC0047a<T> azz;
    private boolean yk;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EI();

    public abstract Class<T> EW();

    public abstract int EX();

    public abstract int EY();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.azA = false;
        this.azB = false;
        this.azC = false;
        this.azD = false;
        this.yk = false;
        this.azE = false;
    }

    protected boolean EP() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void EQ() {
        this.yk = true;
        ES();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EX());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EP());
        a(readCacheMessage);
        EU();
        sendMessage(readCacheMessage);
        this.yk = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.yk = true;
        ES();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EX());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EP());
        a(readCacheMessage);
        EU();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.azE = true;
        ET();
        ER();
    }

    private final void ER() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EY());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EV();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EY());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EV();
        sendMessage(writeCacheMessage);
    }

    private void ES() {
        if (!this.azC) {
            if (this.azx == null) {
                this.azx = new b(this, EX());
                this.azx.setSelfListener(true);
                this.azx.setTag(this.unique_id);
            }
            registerListener(this.azx);
            this.azC = true;
        }
    }

    private void ET() {
        if (!this.azD) {
            if (this.azy == null) {
                this.azy = new c(this, EY());
                this.azy.setSelfListener(true);
                this.azy.setTag(this.unique_id);
            }
            registerListener(this.azy);
            this.azD = true;
        }
    }

    private void EU() {
        if (!this.azA && MessageManager.getInstance().findTask(EX()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EX(), new com.baidu.tbadk.mvc.e.c(EX(), EI(), EW())));
            this.azA = true;
        }
    }

    private void EV() {
        if (!this.azB && MessageManager.getInstance().findTask(EY()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EY(), new com.baidu.tbadk.mvc.e.d(EY(), EI(), EW())));
            this.azB = true;
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
        this.azz = interfaceC0047a;
    }
}
