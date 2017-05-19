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
    private boolean aEA;
    private boolean aEB;
    private boolean aEC;
    private boolean aED;
    private boolean aEE;
    private MessageListener<CustomResponsedMessage<?>> aEx;
    private MessageListener<CustomResponsedMessage<?>> aEy;
    private a<T> aEz;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract int EA();

    public abstract int EB();

    public abstract String Ek();

    public abstract Class<T> Ez();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aEA = false;
        this.aEB = false;
        this.aEC = false;
        this.aED = false;
        this.ET = false;
        this.aEE = false;
    }

    protected boolean Es() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Et() {
        this.ET = true;
        Ev();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EA());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Es());
        a(readCacheMessage);
        Ex();
        sendMessage(readCacheMessage);
        this.ET = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.ET = true;
        Ev();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EA());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Es());
        a(readCacheMessage);
        Ex();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aEE = true;
        Ew();
        Eu();
    }

    private final void Eu() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EB());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Ey();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EB());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Ey();
        sendMessage(writeCacheMessage);
    }

    private void Ev() {
        if (!this.aEC) {
            if (this.aEx == null) {
                this.aEx = new com.baidu.tbadk.mvc.model.a(this, EA());
                this.aEx.setSelfListener(true);
                this.aEx.setTag(this.unique_id);
            }
            registerListener(this.aEx);
            this.aEC = true;
        }
    }

    private void Ew() {
        if (!this.aED) {
            if (this.aEy == null) {
                this.aEy = new b(this, EB());
                this.aEy.setSelfListener(true);
                this.aEy.setTag(this.unique_id);
            }
            registerListener(this.aEy);
            this.aED = true;
        }
    }

    private void Ex() {
        if (!this.aEA && MessageManager.getInstance().findTask(EA()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EA(), new com.baidu.tbadk.mvc.e.c(EA(), Ek(), Ez())));
            this.aEA = true;
        }
    }

    private void Ey() {
        if (!this.aEB && MessageManager.getInstance().findTask(EB()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EB(), new com.baidu.tbadk.mvc.e.d(EB(), Ek(), Ez())));
            this.aEB = true;
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
        this.aEz = aVar;
    }
}
