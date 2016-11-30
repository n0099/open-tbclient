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
    private MessageListener<CustomResponsedMessage<?>> aAp;
    private MessageListener<CustomResponsedMessage<?>> aAq;
    private InterfaceC0047a<T> aAr;
    private boolean aAs;
    private boolean aAt;
    private boolean aAu;
    private boolean aAv;
    private boolean aAw;
    private boolean yk;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EN();

    public abstract Class<T> Fb();

    public abstract int Fc();

    public abstract int Fd();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aAs = false;
        this.aAt = false;
        this.aAu = false;
        this.aAv = false;
        this.yk = false;
        this.aAw = false;
    }

    protected boolean EU() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void EV() {
        this.yk = true;
        EX();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fc());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EU());
        a(readCacheMessage);
        EZ();
        sendMessage(readCacheMessage);
        this.yk = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.yk = true;
        EX();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Fc());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EU());
        a(readCacheMessage);
        EZ();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aAw = true;
        EY();
        EW();
    }

    private final void EW() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fd());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Fa();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Fd());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Fa();
        sendMessage(writeCacheMessage);
    }

    private void EX() {
        if (!this.aAu) {
            if (this.aAp == null) {
                this.aAp = new b(this, Fc());
                this.aAp.setSelfListener(true);
                this.aAp.setTag(this.unique_id);
            }
            registerListener(this.aAp);
            this.aAu = true;
        }
    }

    private void EY() {
        if (!this.aAv) {
            if (this.aAq == null) {
                this.aAq = new c(this, Fd());
                this.aAq.setSelfListener(true);
                this.aAq.setTag(this.unique_id);
            }
            registerListener(this.aAq);
            this.aAv = true;
        }
    }

    private void EZ() {
        if (!this.aAs && MessageManager.getInstance().findTask(Fc()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fc(), new com.baidu.tbadk.mvc.e.c(Fc(), EN(), Fb())));
            this.aAs = true;
        }
    }

    private void Fa() {
        if (!this.aAt && MessageManager.getInstance().findTask(Fd()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Fd(), new com.baidu.tbadk.mvc.e.d(Fd(), EN(), Fb())));
            this.aAt = true;
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

    public void a(InterfaceC0047a<T> interfaceC0047a) {
        this.aAr = interfaceC0047a;
    }
}
