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
    private boolean EY;
    private MessageListener<CustomResponsedMessage<?>> ayA;
    private InterfaceC0055a<T> ayB;
    private boolean ayC;
    private boolean ayD;
    private boolean ayE;
    private boolean ayF;
    private boolean ayG;
    private MessageListener<CustomResponsedMessage<?>> ayz;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String EB();

    public abstract Class<T> EP();

    public abstract int EQ();

    public abstract int ER();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ayC = false;
        this.ayD = false;
        this.ayE = false;
        this.ayF = false;
        this.EY = false;
        this.ayG = false;
    }

    protected boolean EI() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void EJ() {
        this.EY = true;
        EL();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EQ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EI());
        a(readCacheMessage);
        EN();
        sendMessage(readCacheMessage);
        this.EY = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.EY = true;
        EL();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EQ());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EI());
        a(readCacheMessage);
        EN();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ayG = true;
        EM();
        EK();
    }

    private final void EK() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(ER());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EO();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(ER());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EO();
        sendMessage(writeCacheMessage);
    }

    private void EL() {
        if (!this.ayE) {
            if (this.ayz == null) {
                this.ayz = new b(this, EQ());
                this.ayz.setSelfListener(true);
                this.ayz.setTag(this.unique_id);
            }
            registerListener(this.ayz);
            this.ayE = true;
        }
    }

    private void EM() {
        if (!this.ayF) {
            if (this.ayA == null) {
                this.ayA = new c(this, ER());
                this.ayA.setSelfListener(true);
                this.ayA.setTag(this.unique_id);
            }
            registerListener(this.ayA);
            this.ayF = true;
        }
    }

    private void EN() {
        if (!this.ayC && MessageManager.getInstance().findTask(EQ()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EQ(), new com.baidu.tbadk.mvc.e.c(EQ(), EB(), EP())));
            this.ayC = true;
        }
    }

    private void EO() {
        if (!this.ayD && MessageManager.getInstance().findTask(ER()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(ER(), new com.baidu.tbadk.mvc.e.d(ER(), EB(), EP())));
            this.ayD = true;
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
        this.ayB = interfaceC0055a;
    }
}
