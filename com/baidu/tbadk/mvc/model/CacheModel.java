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
    private MessageListener<CustomResponsedMessage<?>> fnN;
    private MessageListener<CustomResponsedMessage<?>> fnO;
    private a<T> fnP;
    private boolean fnQ;
    private boolean fnR;
    private boolean fnS;
    private boolean fnT;
    private boolean fnU;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String byW();

    public abstract Class<T> bzn();

    public abstract int bzo();

    public abstract int bzp();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fnQ = false;
        this.fnR = false;
        this.fnS = false;
        this.fnT = false;
        this.isReading = false;
        this.fnU = false;
    }

    protected boolean bzg() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bzh() {
        this.isReading = true;
        bzj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bzo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bzg());
        a(readCacheMessage);
        bzl();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bzj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bzo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bzg());
        a(readCacheMessage);
        bzl();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fnU = true;
        bzk();
        bzi();
    }

    private final void bzi() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bzp());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bzm();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bzp());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bzm();
        sendMessage(writeCacheMessage);
    }

    private void bzj() {
        if (!this.fnS) {
            if (this.fnN == null) {
                this.fnN = new CustomMessageListener(bzo()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.isReading = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.fnP != null) {
                                CacheModel.this.fnP.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.fnN.setSelfListener(true);
                this.fnN.setTag(this.unique_id);
            }
            registerListener(this.fnN);
            this.fnS = true;
        }
    }

    private void bzk() {
        if (!this.fnT) {
            if (this.fnO == null) {
                this.fnO = new CustomMessageListener(bzp()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fnU = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.fnP != null) {
                                CacheModel.this.fnP.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.fnO.setSelfListener(true);
                this.fnO.setTag(this.unique_id);
            }
            registerListener(this.fnO);
            this.fnT = true;
        }
    }

    private void bzl() {
        if (!this.fnQ && MessageManager.getInstance().findTask(bzo()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bzo(), new c(bzo(), byW(), bzn())));
            this.fnQ = true;
        }
    }

    private void bzm() {
        if (!this.fnR && MessageManager.getInstance().findTask(bzp()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bzp(), new com.baidu.tbadk.mvc.e.d(bzp(), byW(), bzn())));
            this.fnR = true;
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
        this.fnP = aVar;
    }
}
