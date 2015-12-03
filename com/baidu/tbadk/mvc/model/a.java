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
    private boolean Eu;
    private MessageListener<CustomResponsedMessage<?>> awc;
    private MessageListener<CustomResponsedMessage<?>> awd;
    private InterfaceC0054a<T> awe;
    private boolean awf;
    private boolean awg;
    private boolean awh;
    private boolean awi;
    private boolean awj;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0054a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> DF();

    public abstract int DG();

    public abstract int DH();

    public abstract String Dr();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.awf = false;
        this.awg = false;
        this.awh = false;
        this.awi = false;
        this.Eu = false;
        this.awj = false;
    }

    protected boolean Dy() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Dz() {
        this.Eu = true;
        DB();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(DG());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Dy());
        a(readCacheMessage);
        DD();
        sendMessage(readCacheMessage);
        this.Eu = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Eu = true;
        DB();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(DG());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Dy());
        a(readCacheMessage);
        DD();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.awj = true;
        DC();
        DA();
    }

    private final void DA() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(DH());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        DE();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(DH());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        DE();
        sendMessage(writeCacheMessage);
    }

    private void DB() {
        if (!this.awh) {
            if (this.awc == null) {
                this.awc = new b(this, DG());
                this.awc.setSelfListener(true);
                this.awc.setTag(this.unique_id);
            }
            registerListener(this.awc);
            this.awh = true;
        }
    }

    private void DC() {
        if (!this.awi) {
            if (this.awd == null) {
                this.awd = new c(this, DH());
                this.awd.setSelfListener(true);
                this.awd.setTag(this.unique_id);
            }
            registerListener(this.awd);
            this.awi = true;
        }
    }

    private void DD() {
        if (!this.awf && MessageManager.getInstance().findTask(DG()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(DG(), new com.baidu.tbadk.mvc.e.c(DG(), Dr(), DF())));
            this.awf = true;
        }
    }

    private void DE() {
        if (!this.awg && MessageManager.getInstance().findTask(DH()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(DH(), new com.baidu.tbadk.mvc.e.d(DH(), Dr(), DF())));
            this.awg = true;
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

    public void a(InterfaceC0054a<T> interfaceC0054a) {
        this.awe = interfaceC0054a;
    }
}
