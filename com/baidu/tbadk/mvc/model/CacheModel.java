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
    private MessageListener<CustomResponsedMessage<?>> coJ;
    private MessageListener<CustomResponsedMessage<?>> coK;
    private a<T> coL;
    private boolean coM;
    private boolean coN;
    private boolean coO;
    private boolean coP;
    private boolean coQ;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String anV();

    public abstract Class<T> aol();

    public abstract int aom();

    public abstract int aon();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.coM = false;
        this.coN = false;
        this.coO = false;
        this.coP = false;
        this.Mc = false;
        this.coQ = false;
    }

    protected boolean aoe() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aof() {
        this.Mc = true;
        aoh();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aom());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aoe());
        a(readCacheMessage);
        aoj();
        sendMessage(readCacheMessage);
        this.Mc = true;
    }

    public final void a(e eVar) {
        this.Mc = true;
        aoh();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aom());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aoe());
        a(readCacheMessage);
        aoj();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.coQ = true;
        aoi();
        aog();
    }

    private final void aog() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aon());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aok();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aon());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aok();
        sendMessage(writeCacheMessage);
    }

    private void aoh() {
        if (!this.coO) {
            if (this.coJ == null) {
                this.coJ = new CustomMessageListener(aom()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.coL != null) {
                                CacheModel.this.coL.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.coJ.setSelfListener(true);
                this.coJ.setTag(this.unique_id);
            }
            registerListener(this.coJ);
            this.coO = true;
        }
    }

    private void aoi() {
        if (!this.coP) {
            if (this.coK == null) {
                this.coK = new CustomMessageListener(aon()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.coQ = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.coL != null) {
                                CacheModel.this.coL.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.coK.setSelfListener(true);
                this.coK.setTag(this.unique_id);
            }
            registerListener(this.coK);
            this.coP = true;
        }
    }

    private void aoj() {
        if (!this.coM && MessageManager.getInstance().findTask(aom()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aom(), new c(aom(), anV(), aol())));
            this.coM = true;
        }
    }

    private void aok() {
        if (!this.coN && MessageManager.getInstance().findTask(aon()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aon(), new com.baidu.tbadk.mvc.e.d(aon(), anV(), aol())));
            this.coN = true;
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
        this.coL = aVar;
    }
}
