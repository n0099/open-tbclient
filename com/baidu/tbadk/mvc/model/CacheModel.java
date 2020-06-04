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
    private boolean SA;
    private boolean eqA;
    private boolean eqB;
    private boolean eqC;
    private boolean eqD;
    private boolean eqE;
    private MessageListener<CustomResponsedMessage<?>> eqx;
    private MessageListener<CustomResponsedMessage<?>> eqy;
    private a<T> eqz;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String beM();

    public abstract Class<T> bfd();

    public abstract int bfe();

    public abstract int bff();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.eqA = false;
        this.eqB = false;
        this.eqC = false;
        this.eqD = false;
        this.SA = false;
        this.eqE = false;
    }

    protected boolean beW() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void beX() {
        this.SA = true;
        beZ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bfe());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(beW());
        a(readCacheMessage);
        bfb();
        sendMessage(readCacheMessage);
        this.SA = true;
    }

    public final void a(e eVar) {
        this.SA = true;
        beZ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bfe());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(beW());
        a(readCacheMessage);
        bfb();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.eqE = true;
        bfa();
        beY();
    }

    private final void beY() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bff());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bfc();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bff());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bfc();
        sendMessage(writeCacheMessage);
    }

    private void beZ() {
        if (!this.eqC) {
            if (this.eqx == null) {
                this.eqx = new CustomMessageListener(bfe()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.SA = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eqz != null) {
                                CacheModel.this.eqz.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.eqx.setSelfListener(true);
                this.eqx.setTag(this.unique_id);
            }
            registerListener(this.eqx);
            this.eqC = true;
        }
    }

    private void bfa() {
        if (!this.eqD) {
            if (this.eqy == null) {
                this.eqy = new CustomMessageListener(bff()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.eqE = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eqz != null) {
                                CacheModel.this.eqz.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.eqy.setSelfListener(true);
                this.eqy.setTag(this.unique_id);
            }
            registerListener(this.eqy);
            this.eqD = true;
        }
    }

    private void bfb() {
        if (!this.eqA && MessageManager.getInstance().findTask(bfe()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bfe(), new c(bfe(), beM(), bfd())));
            this.eqA = true;
        }
    }

    private void bfc() {
        if (!this.eqB && MessageManager.getInstance().findTask(bff()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bff(), new com.baidu.tbadk.mvc.e.d(bff(), beM(), bfd())));
            this.eqB = true;
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
        this.eqz = aVar;
    }
}
