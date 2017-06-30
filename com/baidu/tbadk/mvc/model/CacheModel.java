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
    private boolean ET;
    private a<T> aFA;
    private boolean aFB;
    private boolean aFC;
    private boolean aFD;
    private boolean aFE;
    private boolean aFF;
    private MessageListener<CustomResponsedMessage<?>> aFy;
    private MessageListener<CustomResponsedMessage<?>> aFz;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EB();

    public abstract Class<T> EQ();

    public abstract int ER();

    public abstract int ES();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aFB = false;
        this.aFC = false;
        this.aFD = false;
        this.aFE = false;
        this.ET = false;
        this.aFF = false;
    }

    protected boolean EJ() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void EK() {
        this.ET = true;
        EM();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(ER());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EJ());
        a(readCacheMessage);
        EO();
        sendMessage(readCacheMessage);
        this.ET = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.ET = true;
        EM();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(ER());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EJ());
        a(readCacheMessage);
        EO();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aFF = true;
        EN();
        EL();
    }

    private final void EL() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(ES());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EP();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(ES());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EP();
        sendMessage(writeCacheMessage);
    }

    private void EM() {
        if (!this.aFD) {
            if (this.aFy == null) {
                this.aFy = new com.baidu.tbadk.mvc.model.a(this, ER());
                this.aFy.setSelfListener(true);
                this.aFy.setTag(this.unique_id);
            }
            registerListener(this.aFy);
            this.aFD = true;
        }
    }

    private void EN() {
        if (!this.aFE) {
            if (this.aFz == null) {
                this.aFz = new b(this, ES());
                this.aFz.setSelfListener(true);
                this.aFz.setTag(this.unique_id);
            }
            registerListener(this.aFz);
            this.aFE = true;
        }
    }

    private void EO() {
        if (!this.aFB && MessageManager.getInstance().findTask(ER()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(ER(), new com.baidu.tbadk.mvc.e.c(ER(), EB(), EQ())));
            this.aFB = true;
        }
    }

    private void EP() {
        if (!this.aFC && MessageManager.getInstance().findTask(ES()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(ES(), new com.baidu.tbadk.mvc.e.d(ES(), EB(), EQ())));
            this.aFC = true;
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
        this.aFA = aVar;
    }
}
