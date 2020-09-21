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
    private MessageListener<CustomResponsedMessage<?>> eTg;
    private MessageListener<CustomResponsedMessage<?>> eTh;
    private a<T> eTi;
    private boolean eTj;
    private boolean eTk;
    private boolean eTl;
    private boolean eTm;
    private boolean eTn;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> buK();

    public abstract int buL();

    public abstract int buM();

    public abstract String but();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.eTj = false;
        this.eTk = false;
        this.eTl = false;
        this.eTm = false;
        this.isReading = false;
        this.eTn = false;
    }

    protected boolean buD() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void buE() {
        this.isReading = true;
        buG();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(buL());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(buD());
        a(readCacheMessage);
        buI();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        buG();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(buL());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(buD());
        a(readCacheMessage);
        buI();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.eTn = true;
        buH();
        buF();
    }

    private final void buF() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(buM());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        buJ();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(buM());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        buJ();
        sendMessage(writeCacheMessage);
    }

    private void buG() {
        if (!this.eTl) {
            if (this.eTg == null) {
                this.eTg = new CustomMessageListener(buL()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.eTi != null) {
                                CacheModel.this.eTi.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.eTg.setSelfListener(true);
                this.eTg.setTag(this.unique_id);
            }
            registerListener(this.eTg);
            this.eTl = true;
        }
    }

    private void buH() {
        if (!this.eTm) {
            if (this.eTh == null) {
                this.eTh = new CustomMessageListener(buM()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.eTn = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eTi != null) {
                                CacheModel.this.eTi.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.eTh.setSelfListener(true);
                this.eTh.setTag(this.unique_id);
            }
            registerListener(this.eTh);
            this.eTm = true;
        }
    }

    private void buI() {
        if (!this.eTj && MessageManager.getInstance().findTask(buL()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(buL(), new c(buL(), but(), buK())));
            this.eTj = true;
        }
    }

    private void buJ() {
        if (!this.eTk && MessageManager.getInstance().findTask(buM()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(buM(), new com.baidu.tbadk.mvc.e.d(buM(), but(), buK())));
            this.eTk = true;
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
        this.eTi = aVar;
    }
}
