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
    private boolean aAa;
    private boolean aAb;
    private MessageListener<CustomResponsedMessage<?>> azU;
    private MessageListener<CustomResponsedMessage<?>> azV;
    private InterfaceC0047a<T> azW;
    private boolean azX;
    private boolean azY;
    private boolean azZ;
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
        this.azX = false;
        this.azY = false;
        this.azZ = false;
        this.aAa = false;
        this.yk = false;
        this.aAb = false;
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
        this.aAb = true;
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
        if (!this.azZ) {
            if (this.azU == null) {
                this.azU = new b(this, EX());
                this.azU.setSelfListener(true);
                this.azU.setTag(this.unique_id);
            }
            registerListener(this.azU);
            this.azZ = true;
        }
    }

    private void ET() {
        if (!this.aAa) {
            if (this.azV == null) {
                this.azV = new c(this, EY());
                this.azV.setSelfListener(true);
                this.azV.setTag(this.unique_id);
            }
            registerListener(this.azV);
            this.aAa = true;
        }
    }

    private void EU() {
        if (!this.azX && MessageManager.getInstance().findTask(EX()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EX(), new com.baidu.tbadk.mvc.e.c(EX(), EI(), EW())));
            this.azX = true;
        }
    }

    private void EV() {
        if (!this.azY && MessageManager.getInstance().findTask(EY()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EY(), new com.baidu.tbadk.mvc.e.d(EY(), EI(), EW())));
            this.azY = true;
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
        this.azW = interfaceC0047a;
    }
}
