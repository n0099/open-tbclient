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
    private MessageListener<CustomResponsedMessage<?>> fKk;
    private MessageListener<CustomResponsedMessage<?>> fKl;
    private boolean fKm;
    private boolean fKn;
    private boolean fKo;
    private boolean fKp;
    private boolean fKq;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String bGH();

    public abstract Class<T> bGY();

    public abstract int bGZ();

    public abstract int bHa();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fKm = false;
        this.fKn = false;
        this.fKo = false;
        this.fKp = false;
        this.isReading = false;
        this.fKq = false;
    }

    protected boolean bGR() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bGS() {
        this.isReading = true;
        bGU();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bGZ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bGR());
        a(readCacheMessage);
        bGW();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bGU();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bGZ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bGR());
        a(readCacheMessage);
        bGW();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fKq = true;
        bGV();
        bGT();
    }

    private final void bGT() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bHa());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bGX();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bHa());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bGX();
        sendMessage(writeCacheMessage);
    }

    private void bGU() {
        if (!this.fKo) {
            if (this.fKk == null) {
                this.fKk = new CustomMessageListener(bGZ()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                this.fKk.setSelfListener(true);
                this.fKk.setTag(this.unique_id);
            }
            registerListener(this.fKk);
            this.fKo = true;
        }
    }

    private void bGV() {
        if (!this.fKp) {
            if (this.fKl == null) {
                this.fKl = new CustomMessageListener(bHa()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fKq = false;
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
                this.fKl.setSelfListener(true);
                this.fKl.setTag(this.unique_id);
            }
            registerListener(this.fKl);
            this.fKp = true;
        }
    }

    private void bGW() {
        if (!this.fKm && MessageManager.getInstance().findTask(bGZ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bGZ(), new c(bGZ(), bGH(), bGY())));
            this.fKm = true;
        }
    }

    private void bGX() {
        if (!this.fKn && MessageManager.getInstance().findTask(bHa()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bHa(), new com.baidu.tbadk.mvc.e.d(bHa(), bGH(), bGY())));
            this.fKn = true;
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
