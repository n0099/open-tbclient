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
    private MessageListener<CustomResponsedMessage<?>> aIf;
    private MessageListener<CustomResponsedMessage<?>> aIg;
    private a<T> aIh;
    private boolean aIi;
    private boolean aIj;
    private boolean aIk;
    private boolean aIl;
    private boolean aIm;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Fc();

    public abstract Class<T> Fr();

    public abstract int Fs();

    public abstract int Ft();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aIi = false;
        this.aIj = false;
        this.aIk = false;
        this.aIl = false;
        this.Ec = false;
        this.aIm = false;
    }

    protected boolean Fk() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fl() {
        this.Ec = true;
        Fn();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fs());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fk());
        a(readCacheMessage);
        Fp();
        sendMessage(readCacheMessage);
        this.Ec = true;
    }

    public final void a(e eVar) {
        this.Ec = true;
        Fn();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fs());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fk());
        a(readCacheMessage);
        Fp();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aIm = true;
        Fo();
        Fm();
    }

    private final void Fm() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Ft());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fq();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Ft());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fq();
        sendMessage(writeCacheMessage);
    }

    private void Fn() {
        if (!this.aIk) {
            if (this.aIf == null) {
                this.aIf = new CustomMessageListener(Fs()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.aIh != null) {
                                CacheModel.this.aIh.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aIf.setSelfListener(true);
                this.aIf.setTag(this.unique_id);
            }
            registerListener(this.aIf);
            this.aIk = true;
        }
    }

    private void Fo() {
        if (!this.aIl) {
            if (this.aIg == null) {
                this.aIg = new CustomMessageListener(Ft()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aIm = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIh != null) {
                                CacheModel.this.aIh.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aIg.setSelfListener(true);
                this.aIg.setTag(this.unique_id);
            }
            registerListener(this.aIg);
            this.aIl = true;
        }
    }

    private void Fp() {
        if (!this.aIi && MessageManager.getInstance().findTask(Fs()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fs(), new c(Fs(), Fc(), Fr())));
            this.aIi = true;
        }
    }

    private void Fq() {
        if (!this.aIj && MessageManager.getInstance().findTask(Ft()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Ft(), new com.baidu.tbadk.mvc.e.d(Ft(), Fc(), Fr())));
            this.aIj = true;
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
        this.aIh = aVar;
    }
}
