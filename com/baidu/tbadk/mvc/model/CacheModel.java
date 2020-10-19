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
    private MessageListener<CustomResponsedMessage<?>> ffo;
    private MessageListener<CustomResponsedMessage<?>> ffp;
    private a<T> ffq;
    private boolean ffr;
    private boolean ffs;
    private boolean fft;
    private boolean ffu;
    private boolean ffv;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String bxd();

    public abstract Class<T> bxu();

    public abstract int bxv();

    public abstract int bxw();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ffr = false;
        this.ffs = false;
        this.fft = false;
        this.ffu = false;
        this.isReading = false;
        this.ffv = false;
    }

    protected boolean bxn() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bxo() {
        this.isReading = true;
        bxq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bxv());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bxn());
        a(readCacheMessage);
        bxs();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bxq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bxv());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bxn());
        a(readCacheMessage);
        bxs();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ffv = true;
        bxr();
        bxp();
    }

    private final void bxp() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bxw());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bxt();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bxw());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bxt();
        sendMessage(writeCacheMessage);
    }

    private void bxq() {
        if (!this.fft) {
            if (this.ffo == null) {
                this.ffo = new CustomMessageListener(bxv()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.ffq != null) {
                                CacheModel.this.ffq.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.ffo.setSelfListener(true);
                this.ffo.setTag(this.unique_id);
            }
            registerListener(this.ffo);
            this.fft = true;
        }
    }

    private void bxr() {
        if (!this.ffu) {
            if (this.ffp == null) {
                this.ffp = new CustomMessageListener(bxw()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ffv = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ffq != null) {
                                CacheModel.this.ffq.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.ffp.setSelfListener(true);
                this.ffp.setTag(this.unique_id);
            }
            registerListener(this.ffp);
            this.ffu = true;
        }
    }

    private void bxs() {
        if (!this.ffr && MessageManager.getInstance().findTask(bxv()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bxv(), new c(bxv(), bxd(), bxu())));
            this.ffr = true;
        }
    }

    private void bxt() {
        if (!this.ffs && MessageManager.getInstance().findTask(bxw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bxw(), new com.baidu.tbadk.mvc.e.d(bxw(), bxd(), bxu())));
            this.ffs = true;
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
        this.ffq = aVar;
    }
}
