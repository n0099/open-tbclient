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
    private boolean asi;
    private MessageListener<CustomResponsedMessage<?>> bws;
    private MessageListener<CustomResponsedMessage<?>> bwt;
    private a<T> bwu;
    private boolean bwv;
    private boolean bww;
    private boolean bwx;
    private boolean bwy;
    private boolean bwz;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> MH();

    public abstract int MI();

    public abstract int MJ();

    public abstract String Ms();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.bwv = false;
        this.bww = false;
        this.bwx = false;
        this.bwy = false;
        this.asi = false;
        this.bwz = false;
    }

    protected boolean MA() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void MB() {
        this.asi = true;
        MD();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(MI());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(MA());
        a(readCacheMessage);
        MF();
        sendMessage(readCacheMessage);
        this.asi = true;
    }

    public final void a(e eVar) {
        this.asi = true;
        MD();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(MI());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(MA());
        a(readCacheMessage);
        MF();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bwz = true;
        ME();
        MC();
    }

    private final void MC() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(MJ());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        MG();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(MJ());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        MG();
        sendMessage(writeCacheMessage);
    }

    private void MD() {
        if (!this.bwx) {
            if (this.bws == null) {
                this.bws = new CustomMessageListener(MI()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.asi = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bwu != null) {
                                CacheModel.this.bwu.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.bws.setSelfListener(true);
                this.bws.setTag(this.unique_id);
            }
            registerListener(this.bws);
            this.bwx = true;
        }
    }

    private void ME() {
        if (!this.bwy) {
            if (this.bwt == null) {
                this.bwt = new CustomMessageListener(MJ()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bwz = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bwu != null) {
                                CacheModel.this.bwu.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.bwt.setSelfListener(true);
                this.bwt.setTag(this.unique_id);
            }
            registerListener(this.bwt);
            this.bwy = true;
        }
    }

    private void MF() {
        if (!this.bwv && MessageManager.getInstance().findTask(MI()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(MI(), new c(MI(), Ms(), MH())));
            this.bwv = true;
        }
    }

    private void MG() {
        if (!this.bww && MessageManager.getInstance().findTask(MJ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(MJ(), new com.baidu.tbadk.mvc.e.d(MJ(), Ms(), MH())));
            this.bww = true;
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
        this.bwu = aVar;
    }
}
