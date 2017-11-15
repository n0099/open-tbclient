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
    private MessageListener<CustomResponsedMessage<?>> aHE;
    private MessageListener<CustomResponsedMessage<?>> aHF;
    private a<T> aHG;
    private boolean aHH;
    private boolean aHI;
    private boolean aHJ;
    private boolean aHK;
    private boolean aHL;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EV();

    public abstract Class<T> Fk();

    public abstract int Fl();

    public abstract int Fm();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aHH = false;
        this.aHI = false;
        this.aHJ = false;
        this.aHK = false;
        this.Ec = false;
        this.aHL = false;
    }

    protected boolean Fd() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fe() {
        this.Ec = true;
        Fg();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fl());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fd());
        a(readCacheMessage);
        Fi();
        sendMessage(readCacheMessage);
        this.Ec = true;
    }

    public final void a(e eVar) {
        this.Ec = true;
        Fg();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fl());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fd());
        a(readCacheMessage);
        Fi();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aHL = true;
        Fh();
        Ff();
    }

    private final void Ff() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fm());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fj();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fm());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fj();
        sendMessage(writeCacheMessage);
    }

    private void Fg() {
        if (!this.aHJ) {
            if (this.aHE == null) {
                this.aHE = new CustomMessageListener(Fl()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.aHG != null) {
                                CacheModel.this.aHG.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aHE.setSelfListener(true);
                this.aHE.setTag(this.unique_id);
            }
            registerListener(this.aHE);
            this.aHJ = true;
        }
    }

    private void Fh() {
        if (!this.aHK) {
            if (this.aHF == null) {
                this.aHF = new CustomMessageListener(Fm()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aHL = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aHG != null) {
                                CacheModel.this.aHG.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aHF.setSelfListener(true);
                this.aHF.setTag(this.unique_id);
            }
            registerListener(this.aHF);
            this.aHK = true;
        }
    }

    private void Fi() {
        if (!this.aHH && MessageManager.getInstance().findTask(Fl()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fl(), new c(Fl(), EV(), Fk())));
            this.aHH = true;
        }
    }

    private void Fj() {
        if (!this.aHI && MessageManager.getInstance().findTask(Fm()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fm(), new com.baidu.tbadk.mvc.e.d(Fm(), EV(), Fk())));
            this.aHI = true;
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
        this.aHG = aVar;
    }
}
