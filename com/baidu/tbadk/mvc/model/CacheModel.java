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
    private boolean LI;
    private MessageListener<CustomResponsedMessage<?>> baN;
    private MessageListener<CustomResponsedMessage<?>> baO;
    private a<T> baP;
    private boolean baQ;
    private boolean baR;
    private boolean baS;
    private boolean baT;
    private boolean baU;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String MU();

    public abstract Class<T> Nj();

    public abstract int Nk();

    public abstract int Nl();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.baQ = false;
        this.baR = false;
        this.baS = false;
        this.baT = false;
        this.LI = false;
        this.baU = false;
    }

    protected boolean Nc() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Nd() {
        this.LI = true;
        Nf();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Nk());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Nc());
        a(readCacheMessage);
        Nh();
        sendMessage(readCacheMessage);
        this.LI = true;
    }

    public final void a(e eVar) {
        this.LI = true;
        Nf();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Nk());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Nc());
        a(readCacheMessage);
        Nh();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.baU = true;
        Ng();
        Ne();
    }

    private final void Ne() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Nl());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Ni();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Nl());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Ni();
        sendMessage(writeCacheMessage);
    }

    private void Nf() {
        if (!this.baS) {
            if (this.baN == null) {
                this.baN = new CustomMessageListener(Nk()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.LI = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.baP != null) {
                                CacheModel.this.baP.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.baN.setSelfListener(true);
                this.baN.setTag(this.unique_id);
            }
            registerListener(this.baN);
            this.baS = true;
        }
    }

    private void Ng() {
        if (!this.baT) {
            if (this.baO == null) {
                this.baO = new CustomMessageListener(Nl()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.baU = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.baP != null) {
                                CacheModel.this.baP.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.baO.setSelfListener(true);
                this.baO.setTag(this.unique_id);
            }
            registerListener(this.baO);
            this.baT = true;
        }
    }

    private void Nh() {
        if (!this.baQ && MessageManager.getInstance().findTask(Nk()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Nk(), new c(Nk(), MU(), Nj())));
            this.baQ = true;
        }
    }

    private void Ni() {
        if (!this.baR && MessageManager.getInstance().findTask(Nl()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Nl(), new com.baidu.tbadk.mvc.e.d(Nl(), MU(), Nj())));
            this.baR = true;
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
        this.baP = aVar;
    }
}
