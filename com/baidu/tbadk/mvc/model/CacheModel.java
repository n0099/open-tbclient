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
    private boolean Mc;
    private MessageListener<CustomResponsedMessage<?>> coL;
    private MessageListener<CustomResponsedMessage<?>> coM;
    private a<T> coN;
    private boolean coO;
    private boolean coP;
    private boolean coQ;
    private boolean coR;
    private boolean coS;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String anS();

    public abstract Class<T> aoi();

    public abstract int aoj();

    public abstract int aok();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.coO = false;
        this.coP = false;
        this.coQ = false;
        this.coR = false;
        this.Mc = false;
        this.coS = false;
    }

    protected boolean aob() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aoc() {
        this.Mc = true;
        aoe();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aoj());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aob());
        a(readCacheMessage);
        aog();
        sendMessage(readCacheMessage);
        this.Mc = true;
    }

    public final void a(e eVar) {
        this.Mc = true;
        aoe();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aoj());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aob());
        a(readCacheMessage);
        aog();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.coS = true;
        aof();
        aod();
    }

    private final void aod() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aok());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aoh();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aok());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aoh();
        sendMessage(writeCacheMessage);
    }

    private void aoe() {
        if (!this.coQ) {
            if (this.coL == null) {
                this.coL = new CustomMessageListener(aoj()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Mc = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.coN != null) {
                                CacheModel.this.coN.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.coL.setSelfListener(true);
                this.coL.setTag(this.unique_id);
            }
            registerListener(this.coL);
            this.coQ = true;
        }
    }

    private void aof() {
        if (!this.coR) {
            if (this.coM == null) {
                this.coM = new CustomMessageListener(aok()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.coS = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.coN != null) {
                                CacheModel.this.coN.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.coM.setSelfListener(true);
                this.coM.setTag(this.unique_id);
            }
            registerListener(this.coM);
            this.coR = true;
        }
    }

    private void aog() {
        if (!this.coO && MessageManager.getInstance().findTask(aoj()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aoj(), new c(aoj(), anS(), aoi())));
            this.coO = true;
        }
    }

    private void aoh() {
        if (!this.coP && MessageManager.getInstance().findTask(aok()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aok(), new com.baidu.tbadk.mvc.e.d(aok(), anS(), aoi())));
            this.coP = true;
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
        this.coN = aVar;
    }
}
