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
    private boolean JX;
    private MessageListener<CustomResponsedMessage<?>> czm;
    private MessageListener<CustomResponsedMessage<?>> czn;
    private a<T> czo;
    private boolean czp;
    private boolean czq;
    private boolean czr;
    private boolean czs;
    private boolean czt;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> auI();

    public abstract int auJ();

    public abstract int auK();

    public abstract String aur();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.czp = false;
        this.czq = false;
        this.czr = false;
        this.czs = false;
        this.JX = false;
        this.czt = false;
    }

    protected boolean auB() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void auC() {
        this.JX = true;
        auE();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(auJ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(auB());
        a(readCacheMessage);
        auG();
        sendMessage(readCacheMessage);
        this.JX = true;
    }

    public final void a(e eVar) {
        this.JX = true;
        auE();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(auJ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(auB());
        a(readCacheMessage);
        auG();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.czt = true;
        auF();
        auD();
    }

    private final void auD() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(auK());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        auH();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(auK());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        auH();
        sendMessage(writeCacheMessage);
    }

    private void auE() {
        if (!this.czr) {
            if (this.czm == null) {
                this.czm = new CustomMessageListener(auJ()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.JX = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.czo != null) {
                                CacheModel.this.czo.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.czm.setSelfListener(true);
                this.czm.setTag(this.unique_id);
            }
            registerListener(this.czm);
            this.czr = true;
        }
    }

    private void auF() {
        if (!this.czs) {
            if (this.czn == null) {
                this.czn = new CustomMessageListener(auK()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.czt = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.czo != null) {
                                CacheModel.this.czo.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.czn.setSelfListener(true);
                this.czn.setTag(this.unique_id);
            }
            registerListener(this.czn);
            this.czs = true;
        }
    }

    private void auG() {
        if (!this.czp && MessageManager.getInstance().findTask(auJ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(auJ(), new c(auJ(), aur(), auI())));
            this.czp = true;
        }
    }

    private void auH() {
        if (!this.czq && MessageManager.getInstance().findTask(auK()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(auK(), new com.baidu.tbadk.mvc.e.d(auK(), aur(), auI())));
            this.czq = true;
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
        this.czo = aVar;
    }
}
