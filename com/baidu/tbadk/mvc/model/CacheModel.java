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
    private MessageListener<CustomResponsedMessage<?>> cJN;
    private MessageListener<CustomResponsedMessage<?>> cJO;
    private a<T> cJP;
    private boolean cJQ;
    private boolean cJR;
    private boolean cJS;
    private boolean cJT;
    private boolean cJU;
    private boolean wh;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String avI();

    public abstract Class<T> avZ();

    public abstract int awa();

    public abstract int awb();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.cJQ = false;
        this.cJR = false;
        this.cJS = false;
        this.cJT = false;
        this.wh = false;
        this.cJU = false;
    }

    protected boolean avS() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void avT() {
        this.wh = true;
        avV();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(awa());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(avS());
        a(readCacheMessage);
        avX();
        sendMessage(readCacheMessage);
        this.wh = true;
    }

    public final void a(e eVar) {
        this.wh = true;
        avV();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(awa());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(avS());
        a(readCacheMessage);
        avX();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.cJU = true;
        avW();
        avU();
    }

    private final void avU() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(awb());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        avY();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(awb());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        avY();
        sendMessage(writeCacheMessage);
    }

    private void avV() {
        if (!this.cJS) {
            if (this.cJN == null) {
                this.cJN = new CustomMessageListener(awa()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.wh = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cJP != null) {
                                CacheModel.this.cJP.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.cJN.setSelfListener(true);
                this.cJN.setTag(this.unique_id);
            }
            registerListener(this.cJN);
            this.cJS = true;
        }
    }

    private void avW() {
        if (!this.cJT) {
            if (this.cJO == null) {
                this.cJO = new CustomMessageListener(awb()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.cJU = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cJP != null) {
                                CacheModel.this.cJP.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.cJO.setSelfListener(true);
                this.cJO.setTag(this.unique_id);
            }
            registerListener(this.cJO);
            this.cJT = true;
        }
    }

    private void avX() {
        if (!this.cJQ && MessageManager.getInstance().findTask(awa()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(awa(), new c(awa(), avI(), avZ())));
            this.cJQ = true;
        }
    }

    private void avY() {
        if (!this.cJR && MessageManager.getInstance().findTask(awb()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(awb(), new com.baidu.tbadk.mvc.e.d(awb(), avI(), avZ())));
            this.cJR = true;
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
        this.cJP = aVar;
    }
}
