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
    private MessageListener<CustomResponsedMessage<?>> dxR;
    private MessageListener<CustomResponsedMessage<?>> dxS;
    private a<T> dxT;
    private boolean dxU;
    private boolean dxV;
    private boolean dxW;
    private boolean dxX;
    private boolean dxY;
    private boolean yM;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String aNL();

    public abstract Class<T> aOc();

    public abstract int aOd();

    public abstract int aOe();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.dxU = false;
        this.dxV = false;
        this.dxW = false;
        this.dxX = false;
        this.yM = false;
        this.dxY = false;
    }

    protected boolean aNV() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aNW() {
        this.yM = true;
        aNY();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aOd());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aNV());
        a(readCacheMessage);
        aOa();
        sendMessage(readCacheMessage);
        this.yM = true;
    }

    public final void a(e eVar) {
        this.yM = true;
        aNY();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aOd());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aNV());
        a(readCacheMessage);
        aOa();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.dxY = true;
        aNZ();
        aNX();
    }

    private final void aNX() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aOe());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aOb();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aOe());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aOb();
        sendMessage(writeCacheMessage);
    }

    private void aNY() {
        if (!this.dxW) {
            if (this.dxR == null) {
                this.dxR = new CustomMessageListener(aOd()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.yM = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dxT != null) {
                                CacheModel.this.dxT.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.dxR.setSelfListener(true);
                this.dxR.setTag(this.unique_id);
            }
            registerListener(this.dxR);
            this.dxW = true;
        }
    }

    private void aNZ() {
        if (!this.dxX) {
            if (this.dxS == null) {
                this.dxS = new CustomMessageListener(aOe()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.dxY = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.dxT != null) {
                                CacheModel.this.dxT.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.dxS.setSelfListener(true);
                this.dxS.setTag(this.unique_id);
            }
            registerListener(this.dxS);
            this.dxX = true;
        }
    }

    private void aOa() {
        if (!this.dxU && MessageManager.getInstance().findTask(aOd()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aOd(), new c(aOd(), aNL(), aOc())));
            this.dxU = true;
        }
    }

    private void aOb() {
        if (!this.dxV && MessageManager.getInstance().findTask(aOe()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aOe(), new com.baidu.tbadk.mvc.e.d(aOe(), aNL(), aOc())));
            this.dxV = true;
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
        this.dxT = aVar;
    }
}
