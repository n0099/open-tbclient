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
    private boolean asg;
    private MessageListener<CustomResponsedMessage<?>> bwa;
    private MessageListener<CustomResponsedMessage<?>> bwb;
    private a<T> bwc;
    private boolean bwd;
    private boolean bwe;
    private boolean bwf;
    private boolean bwg;
    private boolean bwh;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String MC();

    public abstract Class<T> MR();

    public abstract int MS();

    public abstract int MT();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.bwd = false;
        this.bwe = false;
        this.bwf = false;
        this.bwg = false;
        this.asg = false;
        this.bwh = false;
    }

    protected boolean MK() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void ML() {
        this.asg = true;
        MN();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(MS());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(MK());
        a(readCacheMessage);
        MP();
        sendMessage(readCacheMessage);
        this.asg = true;
    }

    public final void a(e eVar) {
        this.asg = true;
        MN();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(MS());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(MK());
        a(readCacheMessage);
        MP();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bwh = true;
        MO();
        MM();
    }

    private final void MM() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(MT());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        MQ();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(MT());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        MQ();
        sendMessage(writeCacheMessage);
    }

    private void MN() {
        if (!this.bwf) {
            if (this.bwa == null) {
                this.bwa = new CustomMessageListener(MS()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.asg = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bwc != null) {
                                CacheModel.this.bwc.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.bwa.setSelfListener(true);
                this.bwa.setTag(this.unique_id);
            }
            registerListener(this.bwa);
            this.bwf = true;
        }
    }

    private void MO() {
        if (!this.bwg) {
            if (this.bwb == null) {
                this.bwb = new CustomMessageListener(MT()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bwh = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bwc != null) {
                                CacheModel.this.bwc.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.bwb.setSelfListener(true);
                this.bwb.setTag(this.unique_id);
            }
            registerListener(this.bwb);
            this.bwg = true;
        }
    }

    private void MP() {
        if (!this.bwd && MessageManager.getInstance().findTask(MS()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(MS(), new c(MS(), MC(), MR())));
            this.bwd = true;
        }
    }

    private void MQ() {
        if (!this.bwe && MessageManager.getInstance().findTask(MT()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(MT(), new com.baidu.tbadk.mvc.e.d(MT(), MC(), MR())));
            this.bwe = true;
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
        this.bwc = aVar;
    }
}
