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
    private boolean Gu;
    private MessageListener<CustomResponsedMessage<?>> aHX;
    private MessageListener<CustomResponsedMessage<?>> aHY;
    private a<T> aHZ;
    private boolean aIa;
    private boolean aIb;
    private boolean aIc;
    private boolean aId;
    private boolean aIe;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Fa();

    public abstract Class<T> Fp();

    public abstract int Fq();

    public abstract int Fr();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aIa = false;
        this.aIb = false;
        this.aIc = false;
        this.aId = false;
        this.Gu = false;
        this.aIe = false;
    }

    protected boolean Fi() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fj() {
        this.Gu = true;
        Fl();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fq());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fi());
        a(readCacheMessage);
        Fn();
        sendMessage(readCacheMessage);
        this.Gu = true;
    }

    public final void a(e eVar) {
        this.Gu = true;
        Fl();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fq());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fi());
        a(readCacheMessage);
        Fn();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aIe = true;
        Fm();
        Fk();
    }

    private final void Fk() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fr());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fo();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fr());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fo();
        sendMessage(writeCacheMessage);
    }

    private void Fl() {
        if (!this.aIc) {
            if (this.aHX == null) {
                this.aHX = new CustomMessageListener(Fq()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Gu = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHZ != null) {
                                CacheModel.this.aHZ.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aHX.setSelfListener(true);
                this.aHX.setTag(this.unique_id);
            }
            registerListener(this.aHX);
            this.aIc = true;
        }
    }

    private void Fm() {
        if (!this.aId) {
            if (this.aHY == null) {
                this.aHY = new CustomMessageListener(Fr()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aIe = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHZ != null) {
                                CacheModel.this.aHZ.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aHY.setSelfListener(true);
                this.aHY.setTag(this.unique_id);
            }
            registerListener(this.aHY);
            this.aId = true;
        }
    }

    private void Fn() {
        if (!this.aIa && MessageManager.getInstance().findTask(Fq()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fq(), new c(Fq(), Fa(), Fp())));
            this.aIa = true;
        }
    }

    private void Fo() {
        if (!this.aIb && MessageManager.getInstance().findTask(Fr()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fr(), new com.baidu.tbadk.mvc.e.d(Fr(), Fa(), Fp())));
            this.aIb = true;
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
        this.aHZ = aVar;
    }
}
