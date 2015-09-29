package com.baidu.tbadk.mvc.model;

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
public abstract class a<T extends com.baidu.tbadk.mvc.b.d, ActivityType> extends com.baidu.adp.base.e<ActivityType> {
    private boolean Ee;
    private MessageListener<CustomResponsedMessage<?>> avj;
    private MessageListener<CustomResponsedMessage<?>> avk;
    private InterfaceC0052a<T> avl;
    private boolean avm;
    private boolean avn;
    private boolean avo;
    private boolean avp;
    private boolean avq;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String CA();

    public abstract Class<T> CO();

    public abstract int CP();

    public abstract int CQ();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.avm = false;
        this.avn = false;
        this.avo = false;
        this.avp = false;
        this.Ee = false;
        this.avq = false;
    }

    protected boolean CH() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void CI() {
        this.Ee = true;
        CK();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CP());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(CH());
        a(readCacheMessage);
        CM();
        sendMessage(readCacheMessage);
        this.Ee = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Ee = true;
        CK();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CP());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(CH());
        a(readCacheMessage);
        CM();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.avq = true;
        CL();
        CJ();
    }

    private final void CJ() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CQ());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        CN();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CQ());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        CN();
        sendMessage(writeCacheMessage);
    }

    private void CK() {
        if (!this.avo) {
            if (this.avj == null) {
                this.avj = new b(this, CP());
                this.avj.setSelfListener(true);
                this.avj.setTag(this.unique_id);
            }
            registerListener(this.avj);
            this.avo = true;
        }
    }

    private void CL() {
        if (!this.avp) {
            if (this.avk == null) {
                this.avk = new c(this, CQ());
                this.avk.setSelfListener(true);
                this.avk.setTag(this.unique_id);
            }
            registerListener(this.avk);
            this.avp = true;
        }
    }

    private void CM() {
        if (!this.avm && MessageManager.getInstance().findTask(CP()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CP(), new com.baidu.tbadk.mvc.e.c(CP(), CA(), CO())));
            this.avm = true;
        }
    }

    private void CN() {
        if (!this.avn && MessageManager.getInstance().findTask(CQ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CQ(), new com.baidu.tbadk.mvc.e.d(CQ(), CA(), CO())));
            this.avn = true;
        }
    }

    @Override // com.baidu.adp.base.e
    @Deprecated
    protected final boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeCustomMessage(getUniqueId());
        return true;
    }

    public void a(InterfaceC0052a<T> interfaceC0052a) {
        this.avl = interfaceC0052a;
    }
}
