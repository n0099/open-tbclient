package com.baidu.tbadk.mvc.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public abstract class CacheModel<T extends d, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean Eq;
    private MessageListener<CustomResponsedMessage<?>> aGZ;
    private MessageListener<CustomResponsedMessage<?>> aHa;
    private a<T> aHb;
    private boolean aHc;
    private boolean aHd;
    private boolean aHe;
    private boolean aHf;
    private boolean aHg;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String ED();

    public abstract Class<T> ES();

    public abstract int ET();

    public abstract int EU();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aHc = false;
        this.aHd = false;
        this.aHe = false;
        this.aHf = false;
        this.Eq = false;
        this.aHg = false;
    }

    protected boolean EL() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void EM() {
        this.Eq = true;
        EO();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(ET());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EL());
        a(readCacheMessage);
        EQ();
        sendMessage(readCacheMessage);
        this.Eq = true;
    }

    public final void a(e eVar) {
        this.Eq = true;
        EO();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(ET());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EL());
        a(readCacheMessage);
        EQ();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aHg = true;
        EP();
        EN();
    }

    private final void EN() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EU());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        ER();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EU());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        ER();
        sendMessage(writeCacheMessage);
    }

    private void EO() {
        if (!this.aHe) {
            if (this.aGZ == null) {
                this.aGZ = new CustomMessageListener(ET()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Eq = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHb != null) {
                                CacheModel.this.aHb.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aGZ.setSelfListener(true);
                this.aGZ.setTag(this.unique_id);
            }
            registerListener(this.aGZ);
            this.aHe = true;
        }
    }

    private void EP() {
        if (!this.aHf) {
            if (this.aHa == null) {
                this.aHa = new CustomMessageListener(EU()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aHg = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHb != null) {
                                CacheModel.this.aHb.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aHa.setSelfListener(true);
                this.aHa.setTag(this.unique_id);
            }
            registerListener(this.aHa);
            this.aHf = true;
        }
    }

    private void EQ() {
        if (!this.aHc && MessageManager.getInstance().findTask(ET()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(ET(), new c(ET(), ED(), ES())));
            this.aHc = true;
        }
    }

    private void ER() {
        if (!this.aHd && MessageManager.getInstance().findTask(EU()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EU(), new com.baidu.tbadk.mvc.e.d(EU(), ED(), ES())));
            this.aHd = true;
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
        this.aHb = aVar;
    }
}
