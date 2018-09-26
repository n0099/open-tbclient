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
    private boolean Lg;
    private MessageListener<CustomResponsedMessage<?>> aVA;
    private MessageListener<CustomResponsedMessage<?>> aVB;
    private a<T> aVC;
    private boolean aVD;
    private boolean aVE;
    private boolean aVF;
    private boolean aVG;
    private boolean aVH;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String KN();

    public abstract Class<T> Lc();

    public abstract int Ld();

    public abstract int Le();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aVD = false;
        this.aVE = false;
        this.aVF = false;
        this.aVG = false;
        this.Lg = false;
        this.aVH = false;
    }

    protected boolean KV() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void KW() {
        this.Lg = true;
        KY();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Ld());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(KV());
        a(readCacheMessage);
        La();
        sendMessage(readCacheMessage);
        this.Lg = true;
    }

    public final void a(e eVar) {
        this.Lg = true;
        KY();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Ld());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(KV());
        a(readCacheMessage);
        La();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aVH = true;
        KZ();
        KX();
    }

    private final void KX() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Le());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Lb();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Le());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Lb();
        sendMessage(writeCacheMessage);
    }

    private void KY() {
        if (!this.aVF) {
            if (this.aVA == null) {
                this.aVA = new CustomMessageListener(Ld()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Lg = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aVC != null) {
                                CacheModel.this.aVC.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aVA.setSelfListener(true);
                this.aVA.setTag(this.unique_id);
            }
            registerListener(this.aVA);
            this.aVF = true;
        }
    }

    private void KZ() {
        if (!this.aVG) {
            if (this.aVB == null) {
                this.aVB = new CustomMessageListener(Le()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aVH = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aVC != null) {
                                CacheModel.this.aVC.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aVB.setSelfListener(true);
                this.aVB.setTag(this.unique_id);
            }
            registerListener(this.aVB);
            this.aVG = true;
        }
    }

    private void La() {
        if (!this.aVD && MessageManager.getInstance().findTask(Ld()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Ld(), new c(Ld(), KN(), Lc())));
            this.aVD = true;
        }
    }

    private void Lb() {
        if (!this.aVE && MessageManager.getInstance().findTask(Le()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Le(), new com.baidu.tbadk.mvc.e.d(Le(), KN(), Lc())));
            this.aVE = true;
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
        this.aVC = aVar;
    }
}
