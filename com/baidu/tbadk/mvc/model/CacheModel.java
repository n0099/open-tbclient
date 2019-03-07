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
    private boolean Mb;
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

    public abstract String anW();

    public abstract Class<T> aom();

    public abstract int aon();

    public abstract int aoo();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.coM = false;
        this.coN = false;
        this.coO = false;
        this.coP = false;
        this.Mb = false;
        this.coQ = false;
    }

    protected boolean aof() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aog() {
        this.Mb = true;
        aoi();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aon());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aof());
        a(readCacheMessage);
        aok();
        sendMessage(readCacheMessage);
        this.Mb = true;
    }

    public final void a(e eVar) {
        this.Mb = true;
        aoi();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aon());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aof());
        a(readCacheMessage);
        aok();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.coQ = true;
        aoj();
        aoh();
    }

    private final void aoh() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aoo());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aol();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aoo());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aol();
        sendMessage(writeCacheMessage);
    }

    private void aoi() {
        if (!this.coO) {
            if (this.coJ == null) {
                this.coJ = new CustomMessageListener(aon()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Mb = false;
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

    private void aoj() {
        if (!this.coP) {
            if (this.coK == null) {
                this.coK = new CustomMessageListener(aoo()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
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

    private void aok() {
        if (!this.coM && MessageManager.getInstance().findTask(aon()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aon(), new c(aon(), anW(), aom())));
            this.coM = true;
        }
    }

    private void aol() {
        if (!this.coN && MessageManager.getInstance().findTask(aoo()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aoo(), new com.baidu.tbadk.mvc.e.d(aoo(), anW(), aom())));
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
