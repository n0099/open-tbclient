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
    private boolean JX;
    private MessageListener<CustomResponsedMessage<?>> cyq;
    private MessageListener<CustomResponsedMessage<?>> cyr;
    private a<T> cys;
    private boolean cyt;
    private boolean cyu;
    private boolean cyv;
    private boolean cyw;
    private boolean cyx;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String auf();

    public abstract Class<T> auw();

    public abstract int aux();

    public abstract int auy();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.cyt = false;
        this.cyu = false;
        this.cyv = false;
        this.cyw = false;
        this.JX = false;
        this.cyx = false;
    }

    protected boolean aup() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void auq() {
        this.JX = true;
        aus();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aux());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aup());
        a(readCacheMessage);
        auu();
        sendMessage(readCacheMessage);
        this.JX = true;
    }

    public final void a(e eVar) {
        this.JX = true;
        aus();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aux());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aup());
        a(readCacheMessage);
        auu();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.cyx = true;
        aut();
        aur();
    }

    private final void aur() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(auy());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        auv();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(auy());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        auv();
        sendMessage(writeCacheMessage);
    }

    private void aus() {
        if (!this.cyv) {
            if (this.cyq == null) {
                this.cyq = new CustomMessageListener(aux()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.JX = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cys != null) {
                                CacheModel.this.cys.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.cyq.setSelfListener(true);
                this.cyq.setTag(this.unique_id);
            }
            registerListener(this.cyq);
            this.cyv = true;
        }
    }

    private void aut() {
        if (!this.cyw) {
            if (this.cyr == null) {
                this.cyr = new CustomMessageListener(auy()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.cyx = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cys != null) {
                                CacheModel.this.cys.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.cyr.setSelfListener(true);
                this.cyr.setTag(this.unique_id);
            }
            registerListener(this.cyr);
            this.cyw = true;
        }
    }

    private void auu() {
        if (!this.cyt && MessageManager.getInstance().findTask(aux()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aux(), new c(aux(), auf(), auw())));
            this.cyt = true;
        }
    }

    private void auv() {
        if (!this.cyu && MessageManager.getInstance().findTask(auy()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(auy(), new com.baidu.tbadk.mvc.e.d(auy(), auf(), auw())));
            this.cyu = true;
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
        this.cys = aVar;
    }
}
