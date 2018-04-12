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
    private boolean CD;
    private MessageListener<CustomResponsedMessage<?>> aIN;
    private MessageListener<CustomResponsedMessage<?>> aIO;
    private a<T> aIP;
    private boolean aIQ;
    private boolean aIR;
    private boolean aIS;
    private boolean aIT;
    private boolean aIU;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String FA();

    public abstract Class<T> FP();

    public abstract int FQ();

    public abstract int FR();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aIQ = false;
        this.aIR = false;
        this.aIS = false;
        this.aIT = false;
        this.CD = false;
        this.aIU = false;
    }

    protected boolean FI() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void FJ() {
        this.CD = true;
        FL();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(FQ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(FI());
        a(readCacheMessage);
        FN();
        sendMessage(readCacheMessage);
        this.CD = true;
    }

    public final void a(e eVar) {
        this.CD = true;
        FL();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(FQ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(FI());
        a(readCacheMessage);
        FN();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aIU = true;
        FM();
        FK();
    }

    private final void FK() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(FR());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        FO();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(FR());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        FO();
        sendMessage(writeCacheMessage);
    }

    private void FL() {
        if (!this.aIS) {
            if (this.aIN == null) {
                this.aIN = new CustomMessageListener(FQ()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.CD = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIP != null) {
                                CacheModel.this.aIP.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aIN.setSelfListener(true);
                this.aIN.setTag(this.unique_id);
            }
            registerListener(this.aIN);
            this.aIS = true;
        }
    }

    private void FM() {
        if (!this.aIT) {
            if (this.aIO == null) {
                this.aIO = new CustomMessageListener(FR()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aIU = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIP != null) {
                                CacheModel.this.aIP.a(writeCacheRespMsg, writeCacheMessage);
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

    private void FN() {
        if (!this.aIQ && MessageManager.getInstance().findTask(FQ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(FQ(), new c(FQ(), FA(), FP())));
            this.aIQ = true;
        }
    }

    private void FO() {
        if (!this.aIR && MessageManager.getInstance().findTask(FR()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(FR(), new com.baidu.tbadk.mvc.e.d(FR(), FA(), FP())));
            this.aIR = true;
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
        this.aIP = aVar;
    }
}
