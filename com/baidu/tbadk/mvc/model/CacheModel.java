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
    private MessageListener<CustomResponsedMessage<?>> ftI;
    private MessageListener<CustomResponsedMessage<?>> ftJ;
    private a<T> ftK;
    private boolean ftL;
    private boolean ftM;
    private boolean ftN;
    private boolean ftO;
    private boolean ftP;
    private boolean isReading;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> bBM();

    public abstract int bBN();

    public abstract int bBO();

    public abstract String bBv();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ftL = false;
        this.ftM = false;
        this.ftN = false;
        this.ftO = false;
        this.isReading = false;
        this.ftP = false;
    }

    protected boolean bBF() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bBG() {
        this.isReading = true;
        bBI();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bBN());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bBF());
        a(readCacheMessage);
        bBK();
        sendMessage(readCacheMessage);
        this.isReading = true;
    }

    public final void a(e eVar) {
        this.isReading = true;
        bBI();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bBN());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bBF());
        a(readCacheMessage);
        bBK();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ftP = true;
        bBJ();
        bBH();
    }

    private final void bBH() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bBO());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bBL();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bBO());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bBL();
        sendMessage(writeCacheMessage);
    }

    private void bBI() {
        if (!this.ftN) {
            if (this.ftI == null) {
                this.ftI = new CustomMessageListener(bBN()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.ftK != null) {
                                CacheModel.this.ftK.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.ftI.setSelfListener(true);
                this.ftI.setTag(this.unique_id);
            }
            registerListener(this.ftI);
            this.ftN = true;
        }
    }

    private void bBJ() {
        if (!this.ftO) {
            if (this.ftJ == null) {
                this.ftJ = new CustomMessageListener(bBO()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ftP = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ftK != null) {
                                CacheModel.this.ftK.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.ftJ.setSelfListener(true);
                this.ftJ.setTag(this.unique_id);
            }
            registerListener(this.ftJ);
            this.ftO = true;
        }
    }

    private void bBK() {
        if (!this.ftL && MessageManager.getInstance().findTask(bBN()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bBN(), new c(bBN(), bBv(), bBM())));
            this.ftL = true;
        }
    }

    private void bBL() {
        if (!this.ftM && MessageManager.getInstance().findTask(bBO()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bBO(), new com.baidu.tbadk.mvc.e.d(bBO(), bBv(), bBM())));
            this.ftM = true;
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
        this.ftK = aVar;
    }
}
