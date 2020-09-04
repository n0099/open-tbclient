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
    private MessageListener<CustomResponsedMessage<?>> eQp;
    private MessageListener<CustomResponsedMessage<?>> eQq;
    private a<T> eQr;
    private boolean eQs;
    private boolean eQt;
    private boolean eQu;
    private boolean eQv;
    private boolean eQw;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> btG();

    public abstract int btH();

    public abstract int btI();

    public abstract String btp();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.eQs = false;
        this.eQt = false;
        this.eQu = false;
        this.eQv = false;
        this.isReading = false;
        this.eQw = false;
    }

    protected boolean btz() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void btA() {
        this.isReading = true;
        btC();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(btH());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(btz());
        a(readCacheMessage);
        btE();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        btC();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(btH());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(btz());
        a(readCacheMessage);
        btE();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.eQw = true;
        btD();
        btB();
    }

    private final void btB() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(btI());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        btF();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(btI());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        btF();
        sendMessage(writeCacheMessage);
    }

    private void btC() {
        if (!this.eQu) {
            if (this.eQp == null) {
                this.eQp = new CustomMessageListener(btH()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.eQr != null) {
                                CacheModel.this.eQr.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.eQp.setSelfListener(true);
                this.eQp.setTag(this.unique_id);
            }
            registerListener(this.eQp);
            this.eQu = true;
        }
    }

    private void btD() {
        if (!this.eQv) {
            if (this.eQq == null) {
                this.eQq = new CustomMessageListener(btI()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.eQw = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eQr != null) {
                                CacheModel.this.eQr.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.eQq.setSelfListener(true);
                this.eQq.setTag(this.unique_id);
            }
            registerListener(this.eQq);
            this.eQv = true;
        }
    }

    private void btE() {
        if (!this.eQs && MessageManager.getInstance().findTask(btH()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(btH(), new c(btH(), btp(), btG())));
            this.eQs = true;
        }
    }

    private void btF() {
        if (!this.eQt && MessageManager.getInstance().findTask(btI()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(btI(), new com.baidu.tbadk.mvc.e.d(btI(), btp(), btG())));
            this.eQt = true;
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
        this.eQr = aVar;
    }
}
