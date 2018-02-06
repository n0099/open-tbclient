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
    private MessageListener<CustomResponsedMessage<?>> byA;
    private MessageListener<CustomResponsedMessage<?>> byB;
    private a<T> byC;
    private boolean byD;
    private boolean byE;
    private boolean byF;
    private boolean byG;
    private boolean byH;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String MY();

    public abstract Class<T> Nn();

    public abstract int No();

    public abstract int Np();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.byD = false;
        this.byE = false;
        this.byF = false;
        this.byG = false;
        this.asi = false;
        this.byH = false;
    }

    protected boolean Ng() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Nh() {
        this.asi = true;
        Nj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(No());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Ng());
        a(readCacheMessage);
        Nl();
        sendMessage(readCacheMessage);
        this.asi = true;
    }

    public final void a(e eVar) {
        this.asi = true;
        Nj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(No());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Ng());
        a(readCacheMessage);
        Nl();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.byH = true;
        Nk();
        Ni();
    }

    private final void Ni() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Np());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Nm();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Np());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Nm();
        sendMessage(writeCacheMessage);
    }

    private void Nj() {
        if (!this.byF) {
            if (this.byA == null) {
                this.byA = new CustomMessageListener(No()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.byC != null) {
                                CacheModel.this.byC.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.byA.setSelfListener(true);
                this.byA.setTag(this.unique_id);
            }
            registerListener(this.byA);
            this.byF = true;
        }
    }

    private void Nk() {
        if (!this.byG) {
            if (this.byB == null) {
                this.byB = new CustomMessageListener(Np()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.byH = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.byC != null) {
                                CacheModel.this.byC.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.byB.setSelfListener(true);
                this.byB.setTag(this.unique_id);
            }
            registerListener(this.byB);
            this.byG = true;
        }
    }

    private void Nl() {
        if (!this.byD && MessageManager.getInstance().findTask(No()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(No(), new c(No(), MY(), Nn())));
            this.byD = true;
        }
    }

    private void Nm() {
        if (!this.byE && MessageManager.getInstance().findTask(Np()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Np(), new com.baidu.tbadk.mvc.e.d(Np(), MY(), Nn())));
            this.byE = true;
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
        this.byC = aVar;
    }
}
