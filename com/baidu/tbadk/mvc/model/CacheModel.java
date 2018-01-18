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
    private boolean asf;
    private MessageListener<CustomResponsedMessage<?>> bwj;
    private MessageListener<CustomResponsedMessage<?>> bwk;
    private a<T> bwl;
    private boolean bwm;
    private boolean bwn;
    private boolean bwo;
    private boolean bwp;
    private boolean bwq;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> MF();

    public abstract int MG();

    public abstract int MH();

    public abstract String Mq();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.bwm = false;
        this.bwn = false;
        this.bwo = false;
        this.bwp = false;
        this.asf = false;
        this.bwq = false;
    }

    protected boolean My() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Mz() {
        this.asf = true;
        MB();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(MG());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(My());
        a(readCacheMessage);
        MD();
        sendMessage(readCacheMessage);
        this.asf = true;
    }

    public final void a(e eVar) {
        this.asf = true;
        MB();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(MG());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(My());
        a(readCacheMessage);
        MD();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bwq = true;
        MC();
        MA();
    }

    private final void MA() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(MH());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        ME();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(MH());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        ME();
        sendMessage(writeCacheMessage);
    }

    private void MB() {
        if (!this.bwo) {
            if (this.bwj == null) {
                this.bwj = new CustomMessageListener(MG()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.asf = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bwl != null) {
                                CacheModel.this.bwl.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.bwj.setSelfListener(true);
                this.bwj.setTag(this.unique_id);
            }
            registerListener(this.bwj);
            this.bwo = true;
        }
    }

    private void MC() {
        if (!this.bwp) {
            if (this.bwk == null) {
                this.bwk = new CustomMessageListener(MH()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bwq = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bwl != null) {
                                CacheModel.this.bwl.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.bwk.setSelfListener(true);
                this.bwk.setTag(this.unique_id);
            }
            registerListener(this.bwk);
            this.bwp = true;
        }
    }

    private void MD() {
        if (!this.bwm && MessageManager.getInstance().findTask(MG()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(MG(), new c(MG(), Mq(), MF())));
            this.bwm = true;
        }
    }

    private void ME() {
        if (!this.bwn && MessageManager.getInstance().findTask(MH()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(MH(), new com.baidu.tbadk.mvc.e.d(MH(), Mq(), MF())));
            this.bwn = true;
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
        this.bwl = aVar;
    }
}
