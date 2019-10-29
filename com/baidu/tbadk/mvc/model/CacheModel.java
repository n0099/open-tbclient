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
    private MessageListener<CustomResponsedMessage<?>> cKE;
    private MessageListener<CustomResponsedMessage<?>> cKF;
    private a<T> cKG;
    private boolean cKH;
    private boolean cKI;
    private boolean cKJ;
    private boolean cKK;
    private boolean cKL;
    private boolean wI;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String avK();

    public abstract Class<T> awb();

    public abstract int awc();

    public abstract int awd();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.cKH = false;
        this.cKI = false;
        this.cKJ = false;
        this.cKK = false;
        this.wI = false;
        this.cKL = false;
    }

    protected boolean avU() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void avV() {
        this.wI = true;
        avX();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(awc());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(avU());
        a(readCacheMessage);
        avZ();
        sendMessage(readCacheMessage);
        this.wI = true;
    }

    public final void a(e eVar) {
        this.wI = true;
        avX();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(awc());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(avU());
        a(readCacheMessage);
        avZ();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.cKL = true;
        avY();
        avW();
    }

    private final void avW() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(awd());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        awa();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(awd());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        awa();
        sendMessage(writeCacheMessage);
    }

    private void avX() {
        if (!this.cKJ) {
            if (this.cKE == null) {
                this.cKE = new CustomMessageListener(awc()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.wI = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cKG != null) {
                                CacheModel.this.cKG.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.cKE.setSelfListener(true);
                this.cKE.setTag(this.unique_id);
            }
            registerListener(this.cKE);
            this.cKJ = true;
        }
    }

    private void avY() {
        if (!this.cKK) {
            if (this.cKF == null) {
                this.cKF = new CustomMessageListener(awd()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.cKL = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cKG != null) {
                                CacheModel.this.cKG.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.cKF.setSelfListener(true);
                this.cKF.setTag(this.unique_id);
            }
            registerListener(this.cKF);
            this.cKK = true;
        }
    }

    private void avZ() {
        if (!this.cKH && MessageManager.getInstance().findTask(awc()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(awc(), new c(awc(), avK(), awb())));
            this.cKH = true;
        }
    }

    private void awa() {
        if (!this.cKI && MessageManager.getInstance().findTask(awd()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(awd(), new com.baidu.tbadk.mvc.e.d(awd(), avK(), awb())));
            this.cKI = true;
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
        this.cKG = aVar;
    }
}
