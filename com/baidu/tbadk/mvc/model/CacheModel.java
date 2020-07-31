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
    private boolean Tb;
    private MessageListener<CustomResponsedMessage<?>> eFF;
    private MessageListener<CustomResponsedMessage<?>> eFG;
    private a<T> eFH;
    private boolean eFI;
    private boolean eFJ;
    private boolean eFK;
    private boolean eFL;
    private boolean eFM;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String bkC();

    public abstract Class<T> bkT();

    public abstract int bkU();

    public abstract int bkV();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.eFI = false;
        this.eFJ = false;
        this.eFK = false;
        this.eFL = false;
        this.Tb = false;
        this.eFM = false;
    }

    protected boolean bkM() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bkN() {
        this.Tb = true;
        bkP();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bkU());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bkM());
        a(readCacheMessage);
        bkR();
        sendMessage(readCacheMessage);
        this.Tb = true;
    }

    public final void a(e eVar) {
        this.Tb = true;
        bkP();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bkU());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bkM());
        a(readCacheMessage);
        bkR();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.eFM = true;
        bkQ();
        bkO();
    }

    private final void bkO() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bkV());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bkS();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bkV());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bkS();
        sendMessage(writeCacheMessage);
    }

    private void bkP() {
        if (!this.eFK) {
            if (this.eFF == null) {
                this.eFF = new CustomMessageListener(bkU()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Tb = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eFH != null) {
                                CacheModel.this.eFH.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.eFF.setSelfListener(true);
                this.eFF.setTag(this.unique_id);
            }
            registerListener(this.eFF);
            this.eFK = true;
        }
    }

    private void bkQ() {
        if (!this.eFL) {
            if (this.eFG == null) {
                this.eFG = new CustomMessageListener(bkV()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.eFM = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eFH != null) {
                                CacheModel.this.eFH.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.eFG.setSelfListener(true);
                this.eFG.setTag(this.unique_id);
            }
            registerListener(this.eFG);
            this.eFL = true;
        }
    }

    private void bkR() {
        if (!this.eFI && MessageManager.getInstance().findTask(bkU()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bkU(), new c(bkU(), bkC(), bkT())));
            this.eFI = true;
        }
    }

    private void bkS() {
        if (!this.eFJ && MessageManager.getInstance().findTask(bkV()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bkV(), new com.baidu.tbadk.mvc.e.d(bkV(), bkC(), bkT())));
            this.eFJ = true;
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
        this.eFH = aVar;
    }
}
