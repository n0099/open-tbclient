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
    private boolean IM;
    private MessageListener<CustomResponsedMessage<?>> aRp;
    private MessageListener<CustomResponsedMessage<?>> aRq;
    private a<T> aRr;
    private boolean aRs;
    private boolean aRt;
    private boolean aRu;
    private boolean aRv;
    private boolean aRw;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Jg();

    public abstract Class<T> Jv();

    public abstract int Jw();

    public abstract int Jx();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aRs = false;
        this.aRt = false;
        this.aRu = false;
        this.aRv = false;
        this.IM = false;
        this.aRw = false;
    }

    protected boolean Jo() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Jp() {
        this.IM = true;
        Jr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Jw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Jo());
        a(readCacheMessage);
        Jt();
        sendMessage(readCacheMessage);
        this.IM = true;
    }

    public final void a(e eVar) {
        this.IM = true;
        Jr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Jw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Jo());
        a(readCacheMessage);
        Jt();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aRw = true;
        Js();
        Jq();
    }

    private final void Jq() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Jx());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Ju();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Jx());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Ju();
        sendMessage(writeCacheMessage);
    }

    private void Jr() {
        if (!this.aRu) {
            if (this.aRp == null) {
                this.aRp = new CustomMessageListener(Jw()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.IM = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aRr != null) {
                                CacheModel.this.aRr.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aRp.setSelfListener(true);
                this.aRp.setTag(this.unique_id);
            }
            registerListener(this.aRp);
            this.aRu = true;
        }
    }

    private void Js() {
        if (!this.aRv) {
            if (this.aRq == null) {
                this.aRq = new CustomMessageListener(Jx()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aRw = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aRr != null) {
                                CacheModel.this.aRr.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aRq.setSelfListener(true);
                this.aRq.setTag(this.unique_id);
            }
            registerListener(this.aRq);
            this.aRv = true;
        }
    }

    private void Jt() {
        if (!this.aRs && MessageManager.getInstance().findTask(Jw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Jw(), new c(Jw(), Jg(), Jv())));
            this.aRs = true;
        }
    }

    private void Ju() {
        if (!this.aRt && MessageManager.getInstance().findTask(Jx()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Jx(), new com.baidu.tbadk.mvc.e.d(Jx(), Jg(), Jv())));
            this.aRt = true;
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
        this.aRr = aVar;
    }
}
