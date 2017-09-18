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
    private boolean Eo;
    private a<T> aHA;
    private boolean aHB;
    private boolean aHC;
    private boolean aHD;
    private boolean aHE;
    private boolean aHF;
    private MessageListener<CustomResponsedMessage<?>> aHy;
    private MessageListener<CustomResponsedMessage<?>> aHz;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EY();

    public abstract Class<T> Fn();

    public abstract int Fo();

    public abstract int Fp();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aHB = false;
        this.aHC = false;
        this.aHD = false;
        this.aHE = false;
        this.Eo = false;
        this.aHF = false;
    }

    protected boolean Fg() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fh() {
        this.Eo = true;
        Fj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fg());
        a(readCacheMessage);
        Fl();
        sendMessage(readCacheMessage);
        this.Eo = true;
    }

    public final void a(e eVar) {
        this.Eo = true;
        Fj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fg());
        a(readCacheMessage);
        Fl();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aHF = true;
        Fk();
        Fi();
    }

    private final void Fi() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fp());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fm();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fp());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fm();
        sendMessage(writeCacheMessage);
    }

    private void Fj() {
        if (!this.aHD) {
            if (this.aHy == null) {
                this.aHy = new CustomMessageListener(Fo()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Eo = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHA != null) {
                                CacheModel.this.aHA.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aHy.setSelfListener(true);
                this.aHy.setTag(this.unique_id);
            }
            registerListener(this.aHy);
            this.aHD = true;
        }
    }

    private void Fk() {
        if (!this.aHE) {
            if (this.aHz == null) {
                this.aHz = new CustomMessageListener(Fp()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aHF = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHA != null) {
                                CacheModel.this.aHA.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aHz.setSelfListener(true);
                this.aHz.setTag(this.unique_id);
            }
            registerListener(this.aHz);
            this.aHE = true;
        }
    }

    private void Fl() {
        if (!this.aHB && MessageManager.getInstance().findTask(Fo()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fo(), new c(Fo(), EY(), Fn())));
            this.aHB = true;
        }
    }

    private void Fm() {
        if (!this.aHC && MessageManager.getInstance().findTask(Fp()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fp(), new com.baidu.tbadk.mvc.e.d(Fp(), EY(), Fn())));
            this.aHC = true;
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
        this.aHA = aVar;
    }
}
