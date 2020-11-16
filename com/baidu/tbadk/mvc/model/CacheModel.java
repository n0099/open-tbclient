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
    private MessageListener<CustomResponsedMessage<?>> fsR;
    private MessageListener<CustomResponsedMessage<?>> fsS;
    private boolean fsT;
    private boolean fsU;
    private boolean fsV;
    private boolean fsW;
    private boolean fsX;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String bAL();

    public abstract Class<T> bBc();

    public abstract int bBd();

    public abstract int bBe();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fsT = false;
        this.fsU = false;
        this.fsV = false;
        this.fsW = false;
        this.isReading = false;
        this.fsX = false;
    }

    protected boolean bAV() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bAW() {
        this.isReading = true;
        bAY();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bBd());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bAV());
        a(readCacheMessage);
        bBa();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bAY();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bBd());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bAV());
        a(readCacheMessage);
        bBa();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fsX = true;
        bAZ();
        bAX();
    }

    private final void bAX() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bBe());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bBb();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bBe());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bBb();
        sendMessage(writeCacheMessage);
    }

    private void bAY() {
        if (!this.fsV) {
            if (this.fsR == null) {
                this.fsR = new CustomMessageListener(bBd()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                this.fsR.setSelfListener(true);
                this.fsR.setTag(this.unique_id);
            }
            registerListener(this.fsR);
            this.fsV = true;
        }
    }

    private void bAZ() {
        if (!this.fsW) {
            if (this.fsS == null) {
                this.fsS = new CustomMessageListener(bBe()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fsX = false;
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
                this.fsS.setSelfListener(true);
                this.fsS.setTag(this.unique_id);
            }
            registerListener(this.fsS);
            this.fsW = true;
        }
    }

    private void bBa() {
        if (!this.fsT && MessageManager.getInstance().findTask(bBd()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bBd(), new c(bBd(), bAL(), bBc())));
            this.fsT = true;
        }
    }

    private void bBb() {
        if (!this.fsU && MessageManager.getInstance().findTask(bBe()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bBe(), new com.baidu.tbadk.mvc.e.d(bBe(), bAL(), bBc())));
            this.fsU = true;
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
