package com.baidu.tbadk.mvc.model;

import com.baidu.adp.base.BdBaseModel;
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
public abstract class CacheModel<T extends com.baidu.tbadk.mvc.b.d, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean Fp;
    private MessageListener<CustomResponsedMessage<?>> aEa;
    private MessageListener<CustomResponsedMessage<?>> aEb;
    private a<T> aEc;
    private boolean aEd;
    private boolean aEe;
    private boolean aEf;
    private boolean aEg;
    private boolean aEh;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EI();

    public abstract Class<T> EX();

    public abstract int EY();

    public abstract int EZ();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aEd = false;
        this.aEe = false;
        this.aEf = false;
        this.aEg = false;
        this.Fp = false;
        this.aEh = false;
    }

    protected boolean EQ() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void ER() {
        this.Fp = true;
        ET();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EY());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EQ());
        a(readCacheMessage);
        EV();
        sendMessage(readCacheMessage);
        this.Fp = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Fp = true;
        ET();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EY());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EQ());
        a(readCacheMessage);
        EV();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aEh = true;
        EU();
        ES();
    }

    private final void ES() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EZ());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EW();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EZ());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EW();
        sendMessage(writeCacheMessage);
    }

    private void ET() {
        if (!this.aEf) {
            if (this.aEa == null) {
                this.aEa = new com.baidu.tbadk.mvc.model.a(this, EY());
                this.aEa.setSelfListener(true);
                this.aEa.setTag(this.unique_id);
            }
            registerListener(this.aEa);
            this.aEf = true;
        }
    }

    private void EU() {
        if (!this.aEg) {
            if (this.aEb == null) {
                this.aEb = new b(this, EZ());
                this.aEb.setSelfListener(true);
                this.aEb.setTag(this.unique_id);
            }
            registerListener(this.aEb);
            this.aEg = true;
        }
    }

    private void EV() {
        if (!this.aEd && MessageManager.getInstance().findTask(EY()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EY(), new com.baidu.tbadk.mvc.e.c(EY(), EI(), EX())));
            this.aEd = true;
        }
    }

    private void EW() {
        if (!this.aEe && MessageManager.getInstance().findTask(EZ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EZ(), new com.baidu.tbadk.mvc.e.d(EZ(), EI(), EX())));
            this.aEe = true;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    protected final boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeCustomMessage(getUniqueId());
        return true;
    }

    public void a(a<T> aVar) {
        this.aEc = aVar;
    }
}
