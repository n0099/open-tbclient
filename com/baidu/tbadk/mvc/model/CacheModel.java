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
    private MessageListener<CustomResponsedMessage<?>> dBV;
    private MessageListener<CustomResponsedMessage<?>> dBW;
    private a<T> dBX;
    private boolean dBY;
    private boolean dBZ;
    private boolean dCa;
    private boolean dCb;
    private boolean dCc;
    private boolean ze;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract int aQA();

    public abstract String aQh();

    public abstract Class<T> aQy();

    public abstract int aQz();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.dBY = false;
        this.dBZ = false;
        this.dCa = false;
        this.dCb = false;
        this.ze = false;
        this.dCc = false;
    }

    protected boolean aQr() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aQs() {
        this.ze = true;
        aQu();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQz());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aQr());
        a(readCacheMessage);
        aQw();
        sendMessage(readCacheMessage);
        this.ze = true;
    }

    public final void a(e eVar) {
        this.ze = true;
        aQu();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQz());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aQr());
        a(readCacheMessage);
        aQw();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.dCc = true;
        aQv();
        aQt();
    }

    private final void aQt() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQA());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aQx();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQA());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aQx();
        sendMessage(writeCacheMessage);
    }

    private void aQu() {
        if (!this.dCa) {
            if (this.dBV == null) {
                this.dBV = new CustomMessageListener(aQz()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.dBX != null) {
                                CacheModel.this.dBX.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.dBV.setSelfListener(true);
                this.dBV.setTag(this.unique_id);
            }
            registerListener(this.dBV);
            this.dCa = true;
        }
    }

    private void aQv() {
        if (!this.dCb) {
            if (this.dBW == null) {
                this.dBW = new CustomMessageListener(aQA()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.dCc = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dBX != null) {
                                CacheModel.this.dBX.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.dBW.setSelfListener(true);
                this.dBW.setTag(this.unique_id);
            }
            registerListener(this.dBW);
            this.dCb = true;
        }
    }

    private void aQw() {
        if (!this.dBY && MessageManager.getInstance().findTask(aQz()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQz(), new c(aQz(), aQh(), aQy())));
            this.dBY = true;
        }
    }

    private void aQx() {
        if (!this.dBZ && MessageManager.getInstance().findTask(aQA()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQA(), new com.baidu.tbadk.mvc.e.d(aQA(), aQh(), aQy())));
            this.dBZ = true;
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
        this.dBX = aVar;
    }
}
