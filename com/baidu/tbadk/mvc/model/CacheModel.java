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
    private boolean LE;
    private MessageListener<CustomResponsedMessage<?>> aZZ;
    private MessageListener<CustomResponsedMessage<?>> baa;
    private a<T> bab;
    private boolean bac;
    private boolean bad;
    private boolean bae;
    private boolean baf;
    private boolean bag;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String ML();

    public abstract Class<T> Na();

    public abstract int Nb();

    public abstract int Nc();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.bac = false;
        this.bad = false;
        this.bae = false;
        this.baf = false;
        this.LE = false;
        this.bag = false;
    }

    protected boolean MT() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void MU() {
        this.LE = true;
        MW();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Nb());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(MT());
        a(readCacheMessage);
        MY();
        sendMessage(readCacheMessage);
        this.LE = true;
    }

    public final void a(e eVar) {
        this.LE = true;
        MW();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Nb());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(MT());
        a(readCacheMessage);
        MY();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bag = true;
        MX();
        MV();
    }

    private final void MV() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Nc());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        MZ();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Nc());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        MZ();
        sendMessage(writeCacheMessage);
    }

    private void MW() {
        if (!this.bae) {
            if (this.aZZ == null) {
                this.aZZ = new CustomMessageListener(Nb()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.LE = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bab != null) {
                                CacheModel.this.bab.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aZZ.setSelfListener(true);
                this.aZZ.setTag(this.unique_id);
            }
            registerListener(this.aZZ);
            this.bae = true;
        }
    }

    private void MX() {
        if (!this.baf) {
            if (this.baa == null) {
                this.baa = new CustomMessageListener(Nc()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bag = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bab != null) {
                                CacheModel.this.bab.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.baa.setSelfListener(true);
                this.baa.setTag(this.unique_id);
            }
            registerListener(this.baa);
            this.baf = true;
        }
    }

    private void MY() {
        if (!this.bac && MessageManager.getInstance().findTask(Nb()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Nb(), new c(Nb(), ML(), Na())));
            this.bac = true;
        }
    }

    private void MZ() {
        if (!this.bad && MessageManager.getInstance().findTask(Nc()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Nc(), new com.baidu.tbadk.mvc.e.d(Nc(), ML(), Na())));
            this.bad = true;
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
        this.bab = aVar;
    }
}
