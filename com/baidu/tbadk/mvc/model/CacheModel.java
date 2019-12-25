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
    private MessageListener<CustomResponsedMessage<?>> dxJ;
    private MessageListener<CustomResponsedMessage<?>> dxK;
    private a<T> dxL;
    private boolean dxM;
    private boolean dxN;
    private boolean dxO;
    private boolean dxP;
    private boolean dxQ;
    private boolean yI;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> aNJ();

    public abstract int aNK();

    public abstract int aNL();

    public abstract String aNs();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.dxM = false;
        this.dxN = false;
        this.dxO = false;
        this.dxP = false;
        this.yI = false;
        this.dxQ = false;
    }

    protected boolean aNC() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aND() {
        this.yI = true;
        aNF();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aNK());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aNC());
        a(readCacheMessage);
        aNH();
        sendMessage(readCacheMessage);
        this.yI = true;
    }

    public final void a(e eVar) {
        this.yI = true;
        aNF();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aNK());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aNC());
        a(readCacheMessage);
        aNH();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.dxQ = true;
        aNG();
        aNE();
    }

    private final void aNE() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aNL());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aNI();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aNL());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aNI();
        sendMessage(writeCacheMessage);
    }

    private void aNF() {
        if (!this.dxO) {
            if (this.dxJ == null) {
                this.dxJ = new CustomMessageListener(aNK()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.yI = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dxL != null) {
                                CacheModel.this.dxL.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.dxJ.setSelfListener(true);
                this.dxJ.setTag(this.unique_id);
            }
            registerListener(this.dxJ);
            this.dxO = true;
        }
    }

    private void aNG() {
        if (!this.dxP) {
            if (this.dxK == null) {
                this.dxK = new CustomMessageListener(aNL()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.dxQ = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dxL != null) {
                                CacheModel.this.dxL.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.dxK.setSelfListener(true);
                this.dxK.setTag(this.unique_id);
            }
            registerListener(this.dxK);
            this.dxP = true;
        }
    }

    private void aNH() {
        if (!this.dxM && MessageManager.getInstance().findTask(aNK()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aNK(), new c(aNK(), aNs(), aNJ())));
            this.dxM = true;
        }
    }

    private void aNI() {
        if (!this.dxN && MessageManager.getInstance().findTask(aNL()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aNL(), new com.baidu.tbadk.mvc.e.d(aNL(), aNs(), aNJ())));
            this.dxN = true;
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
        this.dxL = aVar;
    }
}
