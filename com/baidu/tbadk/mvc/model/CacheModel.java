package com.baidu.tbadk.mvc.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public abstract class CacheModel<T extends com.baidu.tbadk.mvc.b.d, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean EQ;
    private MessageListener<CustomResponsedMessage<?>> aEq;
    private MessageListener<CustomResponsedMessage<?>> aEr;
    private a<T> aEs;
    private boolean aEt;
    private boolean aEu;
    private boolean aEv;
    private boolean aEw;
    private boolean aEx;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Fg();

    public abstract Class<T> Fv();

    public abstract int Fw();

    public abstract int Fx();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aEt = false;
        this.aEu = false;
        this.aEv = false;
        this.aEw = false;
        this.EQ = false;
        this.aEx = false;
    }

    protected boolean Fo() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fp() {
        this.EQ = true;
        Fr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fo());
        a(readCacheMessage);
        Ft();
        sendMessage(readCacheMessage);
        this.EQ = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.EQ = true;
        Fr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fo());
        a(readCacheMessage);
        Ft();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aEx = true;
        Fs();
        Fq();
    }

    private final void Fq() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fx());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fu();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fx());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fu();
        sendMessage(writeCacheMessage);
    }

    private void Fr() {
        if (!this.aEv) {
            if (this.aEq == null) {
                this.aEq = new com.baidu.tbadk.mvc.model.a(this, Fw());
                this.aEq.setSelfListener(true);
                this.aEq.setTag(this.unique_id);
            }
            registerListener(this.aEq);
            this.aEv = true;
        }
    }

    private void Fs() {
        if (!this.aEw) {
            if (this.aEr == null) {
                this.aEr = new b(this, Fx());
                this.aEr.setSelfListener(true);
                this.aEr.setTag(this.unique_id);
            }
            registerListener(this.aEr);
            this.aEw = true;
        }
    }

    private void Ft() {
        if (!this.aEt && MessageManager.getInstance().findTask(Fw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fw(), new com.baidu.tbadk.mvc.e.c(Fw(), Fg(), Fv())));
            this.aEt = true;
        }
    }

    private void Fu() {
        if (!this.aEu && MessageManager.getInstance().findTask(Fx()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fx(), new com.baidu.tbadk.mvc.e.d(Fx(), Fg(), Fv())));
            this.aEu = true;
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
        this.aEs = aVar;
    }
}
