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
    private MessageListener<CustomResponsedMessage<?>> aEk;
    private MessageListener<CustomResponsedMessage<?>> aEl;
    private a<T> aEm;
    private boolean aEn;
    private boolean aEo;
    private boolean aEp;
    private boolean aEq;
    private boolean aEr;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String Ee();

    public abstract Class<T> Et();

    public abstract int Eu();

    public abstract int Ev();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aEn = false;
        this.aEo = false;
        this.aEp = false;
        this.aEq = false;
        this.ET = false;
        this.aEr = false;
    }

    protected boolean Em() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void En() {
        this.ET = true;
        Ep();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Eu());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Em());
        a(readCacheMessage);
        Er();
        sendMessage(readCacheMessage);
        this.ET = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.ET = true;
        Ep();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Eu());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Em());
        a(readCacheMessage);
        Er();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aEr = true;
        Eq();
        Eo();
    }

    private final void Eo() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Ev());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Es();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Ev());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Es();
        sendMessage(writeCacheMessage);
    }

    private void Ep() {
        if (!this.aEp) {
            if (this.aEk == null) {
                this.aEk = new com.baidu.tbadk.mvc.model.a(this, Eu());
                this.aEk.setSelfListener(true);
                this.aEk.setTag(this.unique_id);
            }
            registerListener(this.aEk);
            this.aEp = true;
        }
    }

    private void Eq() {
        if (!this.aEq) {
            if (this.aEl == null) {
                this.aEl = new b(this, Ev());
                this.aEl.setSelfListener(true);
                this.aEl.setTag(this.unique_id);
            }
            registerListener(this.aEl);
            this.aEq = true;
        }
    }

    private void Er() {
        if (!this.aEn && MessageManager.getInstance().findTask(Eu()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Eu(), new com.baidu.tbadk.mvc.e.c(Eu(), Ee(), Et())));
            this.aEn = true;
        }
    }

    private void Es() {
        if (!this.aEo && MessageManager.getInstance().findTask(Ev()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Ev(), new com.baidu.tbadk.mvc.e.d(Ev(), Ee(), Et())));
            this.aEo = true;
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
        this.aEm = aVar;
    }
}
