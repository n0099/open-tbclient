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
    private boolean ET;
    private MessageListener<CustomResponsedMessage<?>> aGG;
    private MessageListener<CustomResponsedMessage<?>> aGH;
    private a<T> aGI;
    private boolean aGJ;
    private boolean aGK;
    private boolean aGL;
    private boolean aGM;
    private boolean aGN;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String ES();

    public abstract Class<T> Fh();

    public abstract int Fi();

    public abstract int Fj();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aGJ = false;
        this.aGK = false;
        this.aGL = false;
        this.aGM = false;
        this.ET = false;
        this.aGN = false;
    }

    protected boolean Fa() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fb() {
        this.ET = true;
        Fd();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fi());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fa());
        a(readCacheMessage);
        Ff();
        sendMessage(readCacheMessage);
        this.ET = true;
    }

    public final void a(e eVar) {
        this.ET = true;
        Fd();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fi());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fa());
        a(readCacheMessage);
        Ff();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aGN = true;
        Fe();
        Fc();
    }

    private final void Fc() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fj());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fg();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fj());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fg();
        sendMessage(writeCacheMessage);
    }

    private void Fd() {
        if (!this.aGL) {
            if (this.aGG == null) {
                this.aGG = new CustomMessageListener(Fi()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ET = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aGI != null) {
                                CacheModel.this.aGI.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aGG.setSelfListener(true);
                this.aGG.setTag(this.unique_id);
            }
            registerListener(this.aGG);
            this.aGL = true;
        }
    }

    private void Fe() {
        if (!this.aGM) {
            if (this.aGH == null) {
                this.aGH = new CustomMessageListener(Fj()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aGN = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aGI != null) {
                                CacheModel.this.aGI.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aGH.setSelfListener(true);
                this.aGH.setTag(this.unique_id);
            }
            registerListener(this.aGH);
            this.aGM = true;
        }
    }

    private void Ff() {
        if (!this.aGJ && MessageManager.getInstance().findTask(Fi()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fi(), new c(Fi(), ES(), Fh())));
            this.aGJ = true;
        }
    }

    private void Fg() {
        if (!this.aGK && MessageManager.getInstance().findTask(Fj()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fj(), new com.baidu.tbadk.mvc.e.d(Fj(), ES(), Fh())));
            this.aGK = true;
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
        this.aGI = aVar;
    }
}
