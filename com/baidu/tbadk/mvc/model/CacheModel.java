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
    private boolean ET;
    private MessageListener<CustomResponsedMessage<?>> aEs;
    private MessageListener<CustomResponsedMessage<?>> aEt;
    private a<T> aEu;
    private boolean aEv;
    private boolean aEw;
    private boolean aEx;
    private boolean aEy;
    private boolean aEz;

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
        this.aEv = false;
        this.aEw = false;
        this.aEx = false;
        this.aEy = false;
        this.ET = false;
        this.aEz = false;
    }

    protected boolean Fo() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fp() {
        this.ET = true;
        Fr();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fw());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fo());
        a(readCacheMessage);
        Ft();
        sendMessage(readCacheMessage);
        this.ET = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.ET = true;
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
        this.aEz = true;
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
        if (!this.aEx) {
            if (this.aEs == null) {
                this.aEs = new com.baidu.tbadk.mvc.model.a(this, Fw());
                this.aEs.setSelfListener(true);
                this.aEs.setTag(this.unique_id);
            }
            registerListener(this.aEs);
            this.aEx = true;
        }
    }

    private void Fs() {
        if (!this.aEy) {
            if (this.aEt == null) {
                this.aEt = new b(this, Fx());
                this.aEt.setSelfListener(true);
                this.aEt.setTag(this.unique_id);
            }
            registerListener(this.aEt);
            this.aEy = true;
        }
    }

    private void Ft() {
        if (!this.aEv && MessageManager.getInstance().findTask(Fw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fw(), new com.baidu.tbadk.mvc.e.c(Fw(), Fg(), Fv())));
            this.aEv = true;
        }
    }

    private void Fu() {
        if (!this.aEw && MessageManager.getInstance().findTask(Fx()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fx(), new com.baidu.tbadk.mvc.e.d(Fx(), Fg(), Fv())));
            this.aEw = true;
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
        this.aEu = aVar;
    }
}
