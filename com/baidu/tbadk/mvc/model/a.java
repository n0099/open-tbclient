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
    private boolean Ed;
    private MessageListener<CustomResponsedMessage<?>> awK;
    private MessageListener<CustomResponsedMessage<?>> awL;
    private InterfaceC0052a<T> awM;
    private boolean awN;
    private boolean awO;
    private boolean awP;
    private boolean awQ;
    private boolean awR;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String CN();

    public abstract Class<T> Db();

    public abstract int Dc();

    public abstract int Dd();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.awN = false;
        this.awO = false;
        this.awP = false;
        this.awQ = false;
        this.Ed = false;
        this.awR = false;
    }

    protected boolean CU() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void CV() {
        this.Ed = true;
        CX();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Dc());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(CU());
        a(readCacheMessage);
        CZ();
        sendMessage(readCacheMessage);
        this.Ed = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Ed = true;
        CX();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Dc());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(CU());
        a(readCacheMessage);
        CZ();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.awR = true;
        CY();
        CW();
    }

    private final void CW() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Dd());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Da();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Dd());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Da();
        sendMessage(writeCacheMessage);
    }

    private void CX() {
        if (!this.awP) {
            if (this.awK == null) {
                this.awK = new b(this, Dc());
                this.awK.setSelfListener(true);
                this.awK.setTag(this.unique_id);
            }
            registerListener(this.awK);
            this.awP = true;
        }
    }

    private void CY() {
        if (!this.awQ) {
            if (this.awL == null) {
                this.awL = new c(this, Dd());
                this.awL.setSelfListener(true);
                this.awL.setTag(this.unique_id);
            }
            registerListener(this.awL);
            this.awQ = true;
        }
    }

    private void CZ() {
        if (!this.awN && MessageManager.getInstance().findTask(Dc()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Dc(), new com.baidu.tbadk.mvc.e.c(Dc(), CN(), Db())));
            this.awN = true;
        }
    }

    private void Da() {
        if (!this.awO && MessageManager.getInstance().findTask(Dd()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Dd(), new com.baidu.tbadk.mvc.e.d(Dd(), CN(), Db())));
            this.awO = true;
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
        this.awM = interfaceC0052a;
    }
}
