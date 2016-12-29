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
    private MessageListener<CustomResponsedMessage<?>> azM;
    private MessageListener<CustomResponsedMessage<?>> azN;
    private InterfaceC0047a<T> azO;
    private boolean azP;
    private boolean azQ;
    private boolean azR;
    private boolean azS;
    private boolean azT;
    private boolean yk;

    /* renamed from: com.baidu.tbadk.mvc.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> EJ();

    public abstract int EK();

    public abstract int EL();

    public abstract String Ev();

    public a(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.azP = false;
        this.azQ = false;
        this.azR = false;
        this.azS = false;
        this.yk = false;
        this.azT = false;
    }

    protected boolean EC() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void ED() {
        this.yk = true;
        EF();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EK());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(EC());
        a(readCacheMessage);
        EH();
        sendMessage(readCacheMessage);
        this.yk = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.yk = true;
        EF();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EK());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(EC());
        a(readCacheMessage);
        EH();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.azT = true;
        EG();
        EE();
    }

    private final void EE() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EL());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EI();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EL());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EI();
        sendMessage(writeCacheMessage);
    }

    private void EF() {
        if (!this.azR) {
            if (this.azM == null) {
                this.azM = new b(this, EK());
                this.azM.setSelfListener(true);
                this.azM.setTag(this.unique_id);
            }
            registerListener(this.azM);
            this.azR = true;
        }
    }

    private void EG() {
        if (!this.azS) {
            if (this.azN == null) {
                this.azN = new c(this, EL());
                this.azN.setSelfListener(true);
                this.azN.setTag(this.unique_id);
            }
            registerListener(this.azN);
            this.azS = true;
        }
    }

    private void EH() {
        if (!this.azP && MessageManager.getInstance().findTask(EK()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EK(), new com.baidu.tbadk.mvc.e.c(EK(), Ev(), EJ())));
            this.azP = true;
        }
    }

    private void EI() {
        if (!this.azQ && MessageManager.getInstance().findTask(EL()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EL(), new com.baidu.tbadk.mvc.e.d(EL(), Ev(), EJ())));
            this.azQ = true;
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
        this.azO = interfaceC0047a;
    }
}
