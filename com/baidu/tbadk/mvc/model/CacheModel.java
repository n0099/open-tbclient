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
    private boolean Ec;
    private boolean aHA;
    private boolean aHB;
    private boolean aHC;
    private boolean aHD;
    private MessageListener<CustomResponsedMessage<?>> aHw;
    private MessageListener<CustomResponsedMessage<?>> aHx;
    private a<T> aHy;
    private boolean aHz;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EJ();

    public abstract Class<T> EY();

    public abstract int EZ();

    public abstract int Fa();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aHz = false;
        this.aHA = false;
        this.aHB = false;
        this.aHC = false;
        this.Ec = false;
        this.aHD = false;
    }

    protected boolean ER() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void ES() {
        this.Ec = true;
        EU();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EZ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(ER());
        a(readCacheMessage);
        EW();
        sendMessage(readCacheMessage);
        this.Ec = true;
    }

    public final void a(e eVar) {
        this.Ec = true;
        EU();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EZ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(ER());
        a(readCacheMessage);
        EW();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aHD = true;
        EV();
        ET();
    }

    private final void ET() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fa());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EX();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fa());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EX();
        sendMessage(writeCacheMessage);
    }

    private void EU() {
        if (!this.aHB) {
            if (this.aHw == null) {
                this.aHw = new CustomMessageListener(EZ()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Ec = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHy != null) {
                                CacheModel.this.aHy.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aHw.setSelfListener(true);
                this.aHw.setTag(this.unique_id);
            }
            registerListener(this.aHw);
            this.aHB = true;
        }
    }

    private void EV() {
        if (!this.aHC) {
            if (this.aHx == null) {
                this.aHx = new CustomMessageListener(Fa()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aHD = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHy != null) {
                                CacheModel.this.aHy.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aHx.setSelfListener(true);
                this.aHx.setTag(this.unique_id);
            }
            registerListener(this.aHx);
            this.aHC = true;
        }
    }

    private void EW() {
        if (!this.aHz && MessageManager.getInstance().findTask(EZ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EZ(), new c(EZ(), EJ(), EY())));
            this.aHz = true;
        }
    }

    private void EX() {
        if (!this.aHA && MessageManager.getInstance().findTask(Fa()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fa(), new com.baidu.tbadk.mvc.e.d(Fa(), EJ(), EY())));
            this.aHA = true;
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
        this.aHy = aVar;
    }
}
