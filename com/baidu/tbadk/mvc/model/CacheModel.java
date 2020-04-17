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
    private boolean Sn;
    private MessageListener<CustomResponsedMessage<?>> ecg;
    private MessageListener<CustomResponsedMessage<?>> ech;
    private a<T> eci;
    private boolean ecj;
    private boolean eck;
    private boolean ecl;
    private boolean ecm;
    private boolean ecn;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String aYD();

    public abstract Class<T> aYU();

    public abstract int aYV();

    public abstract int aYW();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ecj = false;
        this.eck = false;
        this.ecl = false;
        this.ecm = false;
        this.Sn = false;
        this.ecn = false;
    }

    protected boolean aYN() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void aYO() {
        this.Sn = true;
        aYQ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aYV());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aYN());
        a(readCacheMessage);
        aYS();
        sendMessage(readCacheMessage);
        this.Sn = true;
    }

    public final void a(e eVar) {
        this.Sn = true;
        aYQ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(aYV());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aYN());
        a(readCacheMessage);
        aYS();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ecn = true;
        aYR();
        aYP();
    }

    private final void aYP() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aYW());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aYT();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(aYW());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aYT();
        sendMessage(writeCacheMessage);
    }

    private void aYQ() {
        if (!this.ecl) {
            if (this.ecg == null) {
                this.ecg = new CustomMessageListener(aYV()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Sn = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eci != null) {
                                CacheModel.this.eci.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.ecg.setSelfListener(true);
                this.ecg.setTag(this.unique_id);
            }
            registerListener(this.ecg);
            this.ecl = true;
        }
    }

    private void aYR() {
        if (!this.ecm) {
            if (this.ech == null) {
                this.ech = new CustomMessageListener(aYW()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ecn = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.eci != null) {
                                CacheModel.this.eci.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.ech.setSelfListener(true);
                this.ech.setTag(this.unique_id);
            }
            registerListener(this.ech);
            this.ecm = true;
        }
    }

    private void aYS() {
        if (!this.ecj && MessageManager.getInstance().findTask(aYV()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aYV(), new c(aYV(), aYD(), aYU())));
            this.ecj = true;
        }
    }

    private void aYT() {
        if (!this.eck && MessageManager.getInstance().findTask(aYW()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(aYW(), new com.baidu.tbadk.mvc.e.d(aYW(), aYD(), aYU())));
            this.eck = true;
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
        this.eci = aVar;
    }
}
