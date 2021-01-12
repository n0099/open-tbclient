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
    private MessageListener<CustomResponsedMessage<?>> fFD;
    private MessageListener<CustomResponsedMessage<?>> fFE;
    private boolean fFF;
    private boolean fFG;
    private boolean fFH;
    private boolean fFI;
    private boolean fFJ;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String bCP();

    public abstract Class<T> bDg();

    public abstract int bDh();

    public abstract int bDi();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fFF = false;
        this.fFG = false;
        this.fFH = false;
        this.fFI = false;
        this.isReading = false;
        this.fFJ = false;
    }

    protected boolean bCZ() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bDa() {
        this.isReading = true;
        bDc();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bDh());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bCZ());
        a(readCacheMessage);
        bDe();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bDc();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bDh());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bCZ());
        a(readCacheMessage);
        bDe();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fFJ = true;
        bDd();
        bDb();
    }

    private final void bDb() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bDi());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bDf();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bDi());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bDf();
        sendMessage(writeCacheMessage);
    }

    private void bDc() {
        if (!this.fFH) {
            if (this.fFD == null) {
                this.fFD = new CustomMessageListener(bDh()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                this.fFD.setSelfListener(true);
                this.fFD.setTag(this.unique_id);
            }
            registerListener(this.fFD);
            this.fFH = true;
        }
    }

    private void bDd() {
        if (!this.fFI) {
            if (this.fFE == null) {
                this.fFE = new CustomMessageListener(bDi()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fFJ = false;
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
                this.fFE.setSelfListener(true);
                this.fFE.setTag(this.unique_id);
            }
            registerListener(this.fFE);
            this.fFI = true;
        }
    }

    private void bDe() {
        if (!this.fFF && MessageManager.getInstance().findTask(bDh()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bDh(), new c(bDh(), bCP(), bDg())));
            this.fFF = true;
        }
    }

    private void bDf() {
        if (!this.fFG && MessageManager.getInstance().findTask(bDi()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bDi(), new com.baidu.tbadk.mvc.e.d(bDi(), bCP(), bDg())));
            this.fFG = true;
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
