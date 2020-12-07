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
    private MessageListener<CustomResponsedMessage<?>> fAE;
    private MessageListener<CustomResponsedMessage<?>> fAF;
    private boolean fAG;
    private boolean fAH;
    private boolean fAI;
    private boolean fAJ;
    private boolean fAK;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> bEE();

    public abstract int bEF();

    public abstract int bEG();

    public abstract String bEn();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fAG = false;
        this.fAH = false;
        this.fAI = false;
        this.fAJ = false;
        this.isReading = false;
        this.fAK = false;
    }

    protected boolean bEx() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bEy() {
        this.isReading = true;
        bEA();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bEF());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bEx());
        a(readCacheMessage);
        bEC();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bEA();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bEF());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bEx());
        a(readCacheMessage);
        bEC();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fAK = true;
        bEB();
        bEz();
    }

    private final void bEz() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bEG());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bED();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bEG());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bED();
        sendMessage(writeCacheMessage);
    }

    private void bEA() {
        if (!this.fAI) {
            if (this.fAE == null) {
                this.fAE = new CustomMessageListener(bEF()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                this.fAE.setSelfListener(true);
                this.fAE.setTag(this.unique_id);
            }
            registerListener(this.fAE);
            this.fAI = true;
        }
    }

    private void bEB() {
        if (!this.fAJ) {
            if (this.fAF == null) {
                this.fAF = new CustomMessageListener(bEG()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fAK = false;
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
                this.fAF.setSelfListener(true);
                this.fAF.setTag(this.unique_id);
            }
            registerListener(this.fAF);
            this.fAJ = true;
        }
    }

    private void bEC() {
        if (!this.fAG && MessageManager.getInstance().findTask(bEF()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bEF(), new c(bEF(), bEn(), bEE())));
            this.fAG = true;
        }
    }

    private void bED() {
        if (!this.fAH && MessageManager.getInstance().findTask(bEG()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bEG(), new com.baidu.tbadk.mvc.e.d(bEG(), bEn(), bEE())));
            this.fAH = true;
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
