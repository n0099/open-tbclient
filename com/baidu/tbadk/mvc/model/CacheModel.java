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
    private MessageListener<CustomResponsedMessage<?>> dBU;
    private MessageListener<CustomResponsedMessage<?>> dBV;
    private a<T> dBW;
    private boolean dBX;
    private boolean dBY;
    private boolean dBZ;
    private boolean dCa;
    private boolean dCb;
    private boolean ze;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String aQf();

    public abstract Class<T> aQw();

    public abstract int aQx();

    public abstract int aQy();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.dBX = false;
        this.dBY = false;
        this.dBZ = false;
        this.dCa = false;
        this.ze = false;
        this.dCb = false;
    }

    protected boolean aQp() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aQq() {
        this.ze = true;
        aQs();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQx());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aQp());
        a(readCacheMessage);
        aQu();
        sendMessage(readCacheMessage);
        this.ze = true;
    }

    public final void a(e eVar) {
        this.ze = true;
        aQs();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQx());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aQp());
        a(readCacheMessage);
        aQu();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.dCb = true;
        aQt();
        aQr();
    }

    private final void aQr() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQy());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aQv();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQy());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aQv();
        sendMessage(writeCacheMessage);
    }

    private void aQs() {
        if (!this.dBZ) {
            if (this.dBU == null) {
                this.dBU = new CustomMessageListener(aQx()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.dBW != null) {
                                CacheModel.this.dBW.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.dBU.setSelfListener(true);
                this.dBU.setTag(this.unique_id);
            }
            registerListener(this.dBU);
            this.dBZ = true;
        }
    }

    private void aQt() {
        if (!this.dCa) {
            if (this.dBV == null) {
                this.dBV = new CustomMessageListener(aQy()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.dCb = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dBW != null) {
                                CacheModel.this.dBW.a(writeCacheRespMsg, writeCacheMessage);
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

    private void aQu() {
        if (!this.dBX && MessageManager.getInstance().findTask(aQx()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQx(), new c(aQx(), aQf(), aQw())));
            this.dBX = true;
        }
    }

    private void aQv() {
        if (!this.dBY && MessageManager.getInstance().findTask(aQy()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQy(), new com.baidu.tbadk.mvc.e.d(aQy(), aQf(), aQw())));
            this.dBY = true;
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
        this.dBW = aVar;
    }
}
