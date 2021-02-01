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
    private a<T> callback;
    private MessageListener<CustomResponsedMessage<?>> fHP;
    private MessageListener<CustomResponsedMessage<?>> fHQ;
    private boolean fHR;
    private boolean fHS;
    private boolean fHT;
    private boolean fHU;
    private boolean fHV;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract int bDA();

    public abstract String bDh();

    public abstract Class<T> bDy();

    public abstract int bDz();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fHR = false;
        this.fHS = false;
        this.fHT = false;
        this.fHU = false;
        this.isReading = false;
        this.fHV = false;
    }

    protected boolean bDr() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bDs() {
        this.isReading = true;
        bDu();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bDz());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bDr());
        a(readCacheMessage);
        bDw();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bDu();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bDz());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bDr());
        a(readCacheMessage);
        bDw();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fHV = true;
        bDv();
        bDt();
    }

    private final void bDt() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bDA());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bDx();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bDA());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bDx();
        sendMessage(writeCacheMessage);
    }

    private void bDu() {
        if (!this.fHT) {
            if (this.fHP == null) {
                this.fHP = new CustomMessageListener(bDz()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.isReading = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.callback != null) {
                                CacheModel.this.callback.onCacheDataGet(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.fHP.setSelfListener(true);
                this.fHP.setTag(this.unique_id);
            }
            registerListener(this.fHP);
            this.fHT = true;
        }
    }

    private void bDv() {
        if (!this.fHU) {
            if (this.fHQ == null) {
                this.fHQ = new CustomMessageListener(bDA()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fHV = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.callback != null) {
                                CacheModel.this.callback.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.fHQ.setSelfListener(true);
                this.fHQ.setTag(this.unique_id);
            }
            registerListener(this.fHQ);
            this.fHU = true;
        }
    }

    private void bDw() {
        if (!this.fHR && MessageManager.getInstance().findTask(bDz()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bDz(), new c(bDz(), bDh(), bDy())));
            this.fHR = true;
        }
    }

    private void bDx() {
        if (!this.fHS && MessageManager.getInstance().findTask(bDA()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bDA(), new com.baidu.tbadk.mvc.e.d(bDA(), bDh(), bDy())));
            this.fHS = true;
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
        this.callback = aVar;
    }
}
