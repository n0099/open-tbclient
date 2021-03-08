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
    private a<T> callback;
    private MessageListener<CustomResponsedMessage<?>> fJo;
    private MessageListener<CustomResponsedMessage<?>> fJp;
    private boolean fJq;
    private boolean fJr;
    private boolean fJs;
    private boolean fJt;
    private boolean fJu;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> bDB();

    public abstract int bDC();

    public abstract int bDD();

    public abstract String bDk();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.fJq = false;
        this.fJr = false;
        this.fJs = false;
        this.fJt = false;
        this.isReading = false;
        this.fJu = false;
    }

    protected boolean bDu() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bDv() {
        this.isReading = true;
        bDx();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bDC());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bDu());
        a(readCacheMessage);
        bDz();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bDx();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bDC());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bDu());
        a(readCacheMessage);
        bDz();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.fJu = true;
        bDy();
        bDw();
    }

    private final void bDw() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bDD());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bDA();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bDD());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bDA();
        sendMessage(writeCacheMessage);
    }

    private void bDx() {
        if (!this.fJs) {
            if (this.fJo == null) {
                this.fJo = new CustomMessageListener(bDC()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.callback != null) {
                                CacheModel.this.callback.onCacheDataGet(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.fJo.setSelfListener(true);
                this.fJo.setTag(this.unique_id);
            }
            registerListener(this.fJo);
            this.fJs = true;
        }
    }

    private void bDy() {
        if (!this.fJt) {
            if (this.fJp == null) {
                this.fJp = new CustomMessageListener(bDD()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.fJu = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.callback != null) {
                                CacheModel.this.callback.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.fJp.setSelfListener(true);
                this.fJp.setTag(this.unique_id);
            }
            registerListener(this.fJp);
            this.fJt = true;
        }
    }

    private void bDz() {
        if (!this.fJq && MessageManager.getInstance().findTask(bDC()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bDC(), new c(bDC(), bDk(), bDB())));
            this.fJq = true;
        }
    }

    private void bDA() {
        if (!this.fJr && MessageManager.getInstance().findTask(bDD()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bDD(), new com.baidu.tbadk.mvc.e.d(bDD(), bDk(), bDB())));
            this.fJr = true;
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
        this.callback = aVar;
    }
}
