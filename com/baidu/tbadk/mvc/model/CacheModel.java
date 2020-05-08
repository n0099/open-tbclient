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
    private boolean Sq;
    private MessageListener<CustomResponsedMessage<?>> ecl;
    private MessageListener<CustomResponsedMessage<?>> ecm;
    private a<T> ecn;
    private boolean eco;
    private boolean ecp;
    private boolean ecq;
    private boolean ecr;
    private boolean ecs;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String aYB();

    public abstract Class<T> aYS();

    public abstract int aYT();

    public abstract int aYU();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.eco = false;
        this.ecp = false;
        this.ecq = false;
        this.ecr = false;
        this.Sq = false;
        this.ecs = false;
    }

    protected boolean aYL() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aYM() {
        this.Sq = true;
        aYO();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aYT());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aYL());
        a(readCacheMessage);
        aYQ();
        sendMessage(readCacheMessage);
        this.Sq = true;
    }

    public final void a(e eVar) {
        this.Sq = true;
        aYO();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aYT());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aYL());
        a(readCacheMessage);
        aYQ();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ecs = true;
        aYP();
        aYN();
    }

    private final void aYN() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aYU());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aYR();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aYU());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aYR();
        sendMessage(writeCacheMessage);
    }

    private void aYO() {
        if (!this.ecq) {
            if (this.ecl == null) {
                this.ecl = new CustomMessageListener(aYT()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Sq = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ecn != null) {
                                CacheModel.this.ecn.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.ecl.setSelfListener(true);
                this.ecl.setTag(this.unique_id);
            }
            registerListener(this.ecl);
            this.ecq = true;
        }
    }

    private void aYP() {
        if (!this.ecr) {
            if (this.ecm == null) {
                this.ecm = new CustomMessageListener(aYU()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ecs = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ecn != null) {
                                CacheModel.this.ecn.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.ecm.setSelfListener(true);
                this.ecm.setTag(this.unique_id);
            }
            registerListener(this.ecm);
            this.ecr = true;
        }
    }

    private void aYQ() {
        if (!this.eco && MessageManager.getInstance().findTask(aYT()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aYT(), new c(aYT(), aYB(), aYS())));
            this.eco = true;
        }
    }

    private void aYR() {
        if (!this.ecp && MessageManager.getInstance().findTask(aYU()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aYU(), new com.baidu.tbadk.mvc.e.d(aYU(), aYB(), aYS())));
            this.ecp = true;
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
        this.ecn = aVar;
    }
}
