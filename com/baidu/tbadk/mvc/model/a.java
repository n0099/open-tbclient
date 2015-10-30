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
    private boolean Ef;
    private MessageListener<CustomResponsedMessage<?>> avk;
    private MessageListener<CustomResponsedMessage<?>> avl;
    private InterfaceC0052a<T> avm;
    private boolean avn;
    private boolean avo;
    private boolean avp;
    private boolean avq;
    private boolean avr;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> CL();

    public abstract int CM();

    public abstract int CN();

    public abstract String Cx();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.avn = false;
        this.avo = false;
        this.avp = false;
        this.avq = false;
        this.Ef = false;
        this.avr = false;
    }

    protected boolean CE() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void CF() {
        this.Ef = true;
        CH();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CM());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(CE());
        a(readCacheMessage);
        CJ();
        sendMessage(readCacheMessage);
        this.Ef = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Ef = true;
        CH();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CM());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(CE());
        a(readCacheMessage);
        CJ();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.avr = true;
        CI();
        CG();
    }

    private final void CG() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CN());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        CK();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CN());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        CK();
        sendMessage(writeCacheMessage);
    }

    private void CH() {
        if (!this.avp) {
            if (this.avk == null) {
                this.avk = new b(this, CM());
                this.avk.setSelfListener(true);
                this.avk.setTag(this.unique_id);
            }
            registerListener(this.avk);
            this.avp = true;
        }
    }

    private void CI() {
        if (!this.avq) {
            if (this.avl == null) {
                this.avl = new c(this, CN());
                this.avl.setSelfListener(true);
                this.avl.setTag(this.unique_id);
            }
            registerListener(this.avl);
            this.avq = true;
        }
    }

    private void CJ() {
        if (!this.avn && MessageManager.getInstance().findTask(CM()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CM(), new com.baidu.tbadk.mvc.e.c(CM(), Cx(), CL())));
            this.avn = true;
        }
    }

    private void CK() {
        if (!this.avo && MessageManager.getInstance().findTask(CN()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CN(), new com.baidu.tbadk.mvc.e.d(CN(), Cx(), CL())));
            this.avo = true;
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
        this.avm = interfaceC0052a;
    }
}
