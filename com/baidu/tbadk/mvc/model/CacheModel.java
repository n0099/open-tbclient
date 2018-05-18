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
    private boolean CC;
    private MessageListener<CustomResponsedMessage<?>> aIO;
    private MessageListener<CustomResponsedMessage<?>> aIP;
    private a<T> aIQ;
    private boolean aIR;
    private boolean aIS;
    private boolean aIT;
    private boolean aIU;
    private boolean aIV;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> FN();

    public abstract int FO();

    public abstract int FP();

    public abstract String Fy();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aIR = false;
        this.aIS = false;
        this.aIT = false;
        this.aIU = false;
        this.CC = false;
        this.aIV = false;
    }

    protected boolean FG() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void FH() {
        this.CC = true;
        FJ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(FO());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(FG());
        a(readCacheMessage);
        FL();
        sendMessage(readCacheMessage);
        this.CC = true;
    }

    public final void a(e eVar) {
        this.CC = true;
        FJ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(FO());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(FG());
        a(readCacheMessage);
        FL();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aIV = true;
        FK();
        FI();
    }

    private final void FI() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(FP());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        FM();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(FP());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        FM();
        sendMessage(writeCacheMessage);
    }

    private void FJ() {
        if (!this.aIT) {
            if (this.aIO == null) {
                this.aIO = new CustomMessageListener(FO()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.CC = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIQ != null) {
                                CacheModel.this.aIQ.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aIO.setSelfListener(true);
                this.aIO.setTag(this.unique_id);
            }
            registerListener(this.aIO);
            this.aIT = true;
        }
    }

    private void FK() {
        if (!this.aIU) {
            if (this.aIP == null) {
                this.aIP = new CustomMessageListener(FP()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aIV = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIQ != null) {
                                CacheModel.this.aIQ.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aIP.setSelfListener(true);
                this.aIP.setTag(this.unique_id);
            }
            registerListener(this.aIP);
            this.aIU = true;
        }
    }

    private void FL() {
        if (!this.aIR && MessageManager.getInstance().findTask(FO()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(FO(), new c(FO(), Fy(), FN())));
            this.aIR = true;
        }
    }

    private void FM() {
        if (!this.aIS && MessageManager.getInstance().findTask(FP()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(FP(), new com.baidu.tbadk.mvc.e.d(FP(), Fy(), FN())));
            this.aIS = true;
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
        this.aIQ = aVar;
    }
}
