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
/* loaded from: classes2.dex */
public abstract class CacheModel<T extends d, ActivityType> extends BdBaseModel<ActivityType> {
    private MessageListener<CustomResponsedMessage<?>> eQl;
    private MessageListener<CustomResponsedMessage<?>> eQm;
    private a<T> eQn;
    private boolean eQo;
    private boolean eQp;
    private boolean eQq;
    private boolean eQr;
    private boolean eQs;
    private boolean isReading;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> btF();

    public abstract int btG();

    public abstract int btH();

    public abstract String bto();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.eQo = false;
        this.eQp = false;
        this.eQq = false;
        this.eQr = false;
        this.isReading = false;
        this.eQs = false;
    }

    protected boolean bty() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void btz() {
        this.isReading = true;
        btB();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(btG());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bty());
        a(readCacheMessage);
        btD();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        btB();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(btG());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bty());
        a(readCacheMessage);
        btD();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.eQs = true;
        btC();
        btA();
    }

    private final void btA() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(btH());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        btE();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(btH());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        btE();
        sendMessage(writeCacheMessage);
    }

    private void btB() {
        if (!this.eQq) {
            if (this.eQl == null) {
                this.eQl = new CustomMessageListener(btG()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.eQn != null) {
                                CacheModel.this.eQn.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.eQl.setSelfListener(true);
                this.eQl.setTag(this.unique_id);
            }
            registerListener(this.eQl);
            this.eQq = true;
        }
    }

    private void btC() {
        if (!this.eQr) {
            if (this.eQm == null) {
                this.eQm = new CustomMessageListener(btH()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.eQs = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eQn != null) {
                                CacheModel.this.eQn.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.eQm.setSelfListener(true);
                this.eQm.setTag(this.unique_id);
            }
            registerListener(this.eQm);
            this.eQr = true;
        }
    }

    private void btD() {
        if (!this.eQo && MessageManager.getInstance().findTask(btG()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(btG(), new c(btG(), bto(), btF())));
            this.eQo = true;
        }
    }

    private void btE() {
        if (!this.eQp && MessageManager.getInstance().findTask(btH()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(btH(), new com.baidu.tbadk.mvc.e.d(btH(), bto(), btF())));
            this.eQp = true;
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
        this.eQn = aVar;
    }
}
