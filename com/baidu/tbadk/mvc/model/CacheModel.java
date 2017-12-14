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
    private boolean Eb;
    private MessageListener<CustomResponsedMessage<?>> aIj;
    private MessageListener<CustomResponsedMessage<?>> aIk;
    private a<T> aIl;
    private boolean aIm;
    private boolean aIn;
    private boolean aIo;
    private boolean aIp;
    private boolean aIq;

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
        this.aIm = false;
        this.aIn = false;
        this.aIo = false;
        this.aIp = false;
        this.Eb = false;
        this.aIq = false;
    }

    protected boolean Fl() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fm() {
        this.Eb = true;
        Fo();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Ft());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fl());
        a(readCacheMessage);
        Fq();
        sendMessage(readCacheMessage);
        this.Eb = true;
    }

    public final void a(e eVar) {
        this.Eb = true;
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
        this.aIq = true;
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
        if (!this.aIo) {
            if (this.aIj == null) {
                this.aIj = new CustomMessageListener(Ft()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Eb = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIl != null) {
                                CacheModel.this.aIl.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aIj.setSelfListener(true);
                this.aIj.setTag(this.unique_id);
            }
            registerListener(this.aIj);
            this.aIo = true;
        }
    }

    private void Fp() {
        if (!this.aIp) {
            if (this.aIk == null) {
                this.aIk = new CustomMessageListener(Fu()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aIq = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aIl != null) {
                                CacheModel.this.aIl.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aIk.setSelfListener(true);
                this.aIk.setTag(this.unique_id);
            }
            registerListener(this.aIk);
            this.aIp = true;
        }
    }

    private void Fq() {
        if (!this.aIm && MessageManager.getInstance().findTask(Ft()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Ft(), new c(Ft(), Fd(), Fs())));
            this.aIm = true;
        }
    }

    private void Fr() {
        if (!this.aIn && MessageManager.getInstance().findTask(Fu()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fu(), new com.baidu.tbadk.mvc.e.d(Fu(), Fd(), Fs())));
            this.aIn = true;
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
        this.aIl = aVar;
    }
}
