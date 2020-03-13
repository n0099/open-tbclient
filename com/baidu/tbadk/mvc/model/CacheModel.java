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
    private MessageListener<CustomResponsedMessage<?>> dCi;
    private MessageListener<CustomResponsedMessage<?>> dCj;
    private a<T> dCk;
    private boolean dCl;
    private boolean dCm;
    private boolean dCn;
    private boolean dCo;
    private boolean dCp;
    private boolean ze;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract int aQA();

    public abstract int aQB();

    public abstract String aQi();

    public abstract Class<T> aQz();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.dCl = false;
        this.dCm = false;
        this.dCn = false;
        this.dCo = false;
        this.ze = false;
        this.dCp = false;
    }

    protected boolean aQs() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aQt() {
        this.ze = true;
        aQv();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQA());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aQs());
        a(readCacheMessage);
        aQx();
        sendMessage(readCacheMessage);
        this.ze = true;
    }

    public final void a(e eVar) {
        this.ze = true;
        aQv();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aQA());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aQs());
        a(readCacheMessage);
        aQx();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.dCp = true;
        aQw();
        aQu();
    }

    private final void aQu() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQB());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aQy();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aQB());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aQy();
        sendMessage(writeCacheMessage);
    }

    private void aQv() {
        if (!this.dCn) {
            if (this.dCi == null) {
                this.dCi = new CustomMessageListener(aQA()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.dCk != null) {
                                CacheModel.this.dCk.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.dCi.setSelfListener(true);
                this.dCi.setTag(this.unique_id);
            }
            registerListener(this.dCi);
            this.dCn = true;
        }
    }

    private void aQw() {
        if (!this.dCo) {
            if (this.dCj == null) {
                this.dCj = new CustomMessageListener(aQB()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.dCp = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dCk != null) {
                                CacheModel.this.dCk.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.dCj.setSelfListener(true);
                this.dCj.setTag(this.unique_id);
            }
            registerListener(this.dCj);
            this.dCo = true;
        }
    }

    private void aQx() {
        if (!this.dCl && MessageManager.getInstance().findTask(aQA()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQA(), new c(aQA(), aQi(), aQz())));
            this.dCl = true;
        }
    }

    private void aQy() {
        if (!this.dCm && MessageManager.getInstance().findTask(aQB()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aQB(), new com.baidu.tbadk.mvc.e.d(aQB(), aQi(), aQz())));
            this.dCm = true;
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
        this.dCk = aVar;
    }
}
