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
    private boolean Er;
    private MessageListener<CustomResponsedMessage<?>> aGM;
    private MessageListener<CustomResponsedMessage<?>> aGN;
    private a<T> aGO;
    private boolean aGP;
    private boolean aGQ;
    private boolean aGR;
    private boolean aGS;
    private boolean aGT;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> EM();

    public abstract int EN();

    public abstract int EO();

    public abstract String Ex();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aGP = false;
        this.aGQ = false;
        this.aGR = false;
        this.aGS = false;
        this.Er = false;
        this.aGT = false;
    }

    protected boolean EF() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void EG() {
        this.Er = true;
        EI();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EN());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EF());
        a(readCacheMessage);
        EK();
        sendMessage(readCacheMessage);
        this.Er = true;
    }

    public final void a(e eVar) {
        this.Er = true;
        EI();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EN());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EF());
        a(readCacheMessage);
        EK();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aGT = true;
        EJ();
        EH();
    }

    private final void EH() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EO());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EL();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EO());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EL();
        sendMessage(writeCacheMessage);
    }

    private void EI() {
        if (!this.aGR) {
            if (this.aGM == null) {
                this.aGM = new CustomMessageListener(EN()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Er = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aGO != null) {
                                CacheModel.this.aGO.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aGM.setSelfListener(true);
                this.aGM.setTag(this.unique_id);
            }
            registerListener(this.aGM);
            this.aGR = true;
        }
    }

    private void EJ() {
        if (!this.aGS) {
            if (this.aGN == null) {
                this.aGN = new CustomMessageListener(EO()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aGT = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aGO != null) {
                                CacheModel.this.aGO.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aGN.setSelfListener(true);
                this.aGN.setTag(this.unique_id);
            }
            registerListener(this.aGN);
            this.aGS = true;
        }
    }

    private void EK() {
        if (!this.aGP && MessageManager.getInstance().findTask(EN()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EN(), new c(EN(), Ex(), EM())));
            this.aGP = true;
        }
    }

    private void EL() {
        if (!this.aGQ && MessageManager.getInstance().findTask(EO()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EO(), new com.baidu.tbadk.mvc.e.d(EO(), Ex(), EM())));
            this.aGQ = true;
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
        this.aGO = aVar;
    }
}
