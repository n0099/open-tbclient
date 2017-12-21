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
    private MessageListener<CustomResponsedMessage<?>> aIm;
    private MessageListener<CustomResponsedMessage<?>> aIn;
    private a<T> aIo;
    private boolean aIp;
    private boolean aIq;
    private boolean aIr;
    private boolean aIs;
    private boolean aIt;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Fd();

    public abstract Class<T> Fs();

    public abstract int Ft();

    public abstract int Fu();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aIp = false;
        this.aIq = false;
        this.aIr = false;
        this.aIs = false;
        this.Ec = false;
        this.aIt = false;
    }

    protected boolean Fl() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fm() {
        this.Ec = true;
        Fo();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Ft());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fl());
        a(readCacheMessage);
        Fq();
        sendMessage(readCacheMessage);
        this.Ec = true;
    }

    public final void a(e eVar) {
        this.Ec = true;
        Fo();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Ft());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fl());
        a(readCacheMessage);
        Fq();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aIt = true;
        Fp();
        Fn();
    }

    private final void Fn() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fu());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fr();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fu());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fr();
        sendMessage(writeCacheMessage);
    }

    private void Fo() {
        if (!this.aIr) {
            if (this.aIm == null) {
                this.aIm = new CustomMessageListener(Ft()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.aIo != null) {
                                CacheModel.this.aIo.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aIm.setSelfListener(true);
                this.aIm.setTag(this.unique_id);
            }
            registerListener(this.aIm);
            this.aIr = true;
        }
    }

    private void Fp() {
        if (!this.aIs) {
            if (this.aIn == null) {
                this.aIn = new CustomMessageListener(Fu()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aIt = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIo != null) {
                                CacheModel.this.aIo.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aIn.setSelfListener(true);
                this.aIn.setTag(this.unique_id);
            }
            registerListener(this.aIn);
            this.aIs = true;
        }
    }

    private void Fq() {
        if (!this.aIp && MessageManager.getInstance().findTask(Ft()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Ft(), new c(Ft(), Fd(), Fs())));
            this.aIp = true;
        }
    }

    private void Fr() {
        if (!this.aIq && MessageManager.getInstance().findTask(Fu()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fu(), new com.baidu.tbadk.mvc.e.d(Fu(), Fd(), Fs())));
            this.aIq = true;
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
        this.aIo = aVar;
    }
}
