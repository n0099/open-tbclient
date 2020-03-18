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
    private boolean dCA;
    private boolean dCB;
    private boolean dCC;
    private MessageListener<CustomResponsedMessage<?>> dCv;
    private MessageListener<CustomResponsedMessage<?>> dCw;
    private a<T> dCx;
    private boolean dCy;
    private boolean dCz;
    private boolean ze;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> aQD();

    public abstract int aQE();

    public abstract int aQF();

    public abstract String aQm();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.dCy = false;
        this.dCz = false;
        this.dCA = false;
        this.dCB = false;
        this.ze = false;
        this.dCC = false;
    }

    protected boolean aQw() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aQx() {
        this.ze = true;
        aQz();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQE());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aQw());
        a(readCacheMessage);
        aQB();
        sendMessage(readCacheMessage);
        this.ze = true;
    }

    public final void a(e eVar) {
        this.ze = true;
        aQz();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQE());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aQw());
        a(readCacheMessage);
        aQB();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.dCC = true;
        aQA();
        aQy();
    }

    private final void aQy() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQF());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aQC();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQF());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aQC();
        sendMessage(writeCacheMessage);
    }

    private void aQz() {
        if (!this.dCA) {
            if (this.dCv == null) {
                this.dCv = new CustomMessageListener(aQE()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ze = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dCx != null) {
                                CacheModel.this.dCx.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.dCv.setSelfListener(true);
                this.dCv.setTag(this.unique_id);
            }
            registerListener(this.dCv);
            this.dCA = true;
        }
    }

    private void aQA() {
        if (!this.dCB) {
            if (this.dCw == null) {
                this.dCw = new CustomMessageListener(aQF()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.dCC = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dCx != null) {
                                CacheModel.this.dCx.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.dCw.setSelfListener(true);
                this.dCw.setTag(this.unique_id);
            }
            registerListener(this.dCw);
            this.dCB = true;
        }
    }

    private void aQB() {
        if (!this.dCy && MessageManager.getInstance().findTask(aQE()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQE(), new c(aQE(), aQm(), aQD())));
            this.dCy = true;
        }
    }

    private void aQC() {
        if (!this.dCz && MessageManager.getInstance().findTask(aQF()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQF(), new com.baidu.tbadk.mvc.e.d(aQF(), aQm(), aQD())));
            this.dCz = true;
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
        this.dCx = aVar;
    }
}
