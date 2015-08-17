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
    private MessageListener<CustomResponsedMessage<?>> avc;
    private MessageListener<CustomResponsedMessage<?>> avd;
    private InterfaceC0052a<T> ave;
    private boolean avf;
    private boolean avg;
    private boolean avh;
    private boolean avi;
    private boolean avj;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String CD();

    public abstract Class<T> CR();

    public abstract int CS();

    public abstract int CT();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.avf = false;
        this.avg = false;
        this.avh = false;
        this.avi = false;
        this.Ed = false;
        this.avj = false;
    }

    protected boolean CK() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void CL() {
        this.Ed = true;
        CN();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CS());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(CK());
        a(readCacheMessage);
        CP();
        sendMessage(readCacheMessage);
        this.Ed = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.Ed = true;
        CN();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(CS());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(CK());
        a(readCacheMessage);
        CP();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.avj = true;
        CO();
        CM();
    }

    private final void CM() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CT());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        CQ();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(CT());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        CQ();
        sendMessage(writeCacheMessage);
    }

    private void CN() {
        if (!this.avh) {
            if (this.avc == null) {
                this.avc = new b(this, CS());
                this.avc.setSelfListener(true);
                this.avc.setTag(this.unique_id);
            }
            registerListener(this.avc);
            this.avh = true;
        }
    }

    private void CO() {
        if (!this.avi) {
            if (this.avd == null) {
                this.avd = new c(this, CT());
                this.avd.setSelfListener(true);
                this.avd.setTag(this.unique_id);
            }
            registerListener(this.avd);
            this.avi = true;
        }
    }

    private void CP() {
        if (!this.avf && MessageManager.getInstance().findTask(CS()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CS(), new com.baidu.tbadk.mvc.e.c(CS(), CD(), CR())));
            this.avf = true;
        }
    }

    private void CQ() {
        if (!this.avg && MessageManager.getInstance().findTask(CT()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(CT(), new com.baidu.tbadk.mvc.e.d(CT(), CD(), CR())));
            this.avg = true;
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
        this.ave = interfaceC0052a;
    }
}
