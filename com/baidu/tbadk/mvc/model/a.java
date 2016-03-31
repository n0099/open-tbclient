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
    private boolean Fd;
    private MessageListener<CustomResponsedMessage<?>> azg;
    private MessageListener<CustomResponsedMessage<?>> azh;
    private InterfaceC0055a<T> azi;
    private boolean azj;
    private boolean azk;
    private boolean azl;
    private boolean azm;
    private boolean azn;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> FC();

    public abstract int FD();

    public abstract int FE();

    public abstract String Fo();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.azj = false;
        this.azk = false;
        this.azl = false;
        this.azm = false;
        this.Fd = false;
        this.azn = false;
    }

    protected boolean Fv() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Fw() {
        this.Fd = true;
        Fy();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(FD());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Fv());
        a(readCacheMessage);
        FA();
        sendMessage(readCacheMessage);
        this.Fd = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Fd = true;
        Fy();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(FD());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Fv());
        a(readCacheMessage);
        FA();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.azn = true;
        Fz();
        Fx();
    }

    private final void Fx() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(FE());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        FB();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(FE());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        FB();
        sendMessage(writeCacheMessage);
    }

    private void Fy() {
        if (!this.azl) {
            if (this.azg == null) {
                this.azg = new b(this, FD());
                this.azg.setSelfListener(true);
                this.azg.setTag(this.unique_id);
            }
            registerListener(this.azg);
            this.azl = true;
        }
    }

    private void Fz() {
        if (!this.azm) {
            if (this.azh == null) {
                this.azh = new c(this, FE());
                this.azh.setSelfListener(true);
                this.azh.setTag(this.unique_id);
            }
            registerListener(this.azh);
            this.azm = true;
        }
    }

    private void FA() {
        if (!this.azj && MessageManager.getInstance().findTask(FD()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(FD(), new com.baidu.tbadk.mvc.e.c(FD(), Fo(), FC())));
            this.azj = true;
        }
    }

    private void FB() {
        if (!this.azk && MessageManager.getInstance().findTask(FE()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(FE(), new com.baidu.tbadk.mvc.e.d(FE(), Fo(), FC())));
            this.azk = true;
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

    public void a(InterfaceC0055a<T> interfaceC0055a) {
        this.azi = interfaceC0055a;
    }
}
