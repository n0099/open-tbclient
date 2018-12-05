package com.baidu.tbadk.mvc.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.d;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public abstract class CacheModel<T extends d, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean LI;
    private MessageListener<CustomResponsedMessage<?>> bel;
    private MessageListener<CustomResponsedMessage<?>> bem;
    private a<T> ben;
    private boolean beo;
    private boolean bep;
    private boolean beq;
    private boolean ber;
    private boolean bes;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String NY();

    public abstract Class<T> On();

    public abstract int Oo();

    public abstract int Op();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.beo = false;
        this.bep = false;
        this.beq = false;
        this.ber = false;
        this.LI = false;
        this.bes = false;
    }

    protected boolean Og() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Oh() {
        this.LI = true;
        Oj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Oo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Og());
        a(readCacheMessage);
        Ol();
        sendMessage(readCacheMessage);
        this.LI = true;
    }

    public final void a(e eVar) {
        this.LI = true;
        Oj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Oo());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Og());
        a(readCacheMessage);
        Ol();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bes = true;
        Ok();
        Oi();
    }

    private final void Oi() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Op());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Om();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Op());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Om();
        sendMessage(writeCacheMessage);
    }

    private void Oj() {
        if (!this.beq) {
            if (this.bel == null) {
                this.bel = new CustomMessageListener(Oo()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.LI = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ben != null) {
                                CacheModel.this.ben.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.bel.setSelfListener(true);
                this.bel.setTag(this.unique_id);
            }
            registerListener(this.bel);
            this.beq = true;
        }
    }

    private void Ok() {
        if (!this.ber) {
            if (this.bem == null) {
                this.bem = new CustomMessageListener(Op()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bes = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ben != null) {
                                CacheModel.this.ben.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.bem.setSelfListener(true);
                this.bem.setTag(this.unique_id);
            }
            registerListener(this.bem);
            this.ber = true;
        }
    }

    private void Ol() {
        if (!this.beo && MessageManager.getInstance().findTask(Oo()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Oo(), new c(Oo(), NY(), On())));
            this.beo = true;
        }
    }

    private void Om() {
        if (!this.bep && MessageManager.getInstance().findTask(Op()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Op(), new com.baidu.tbadk.mvc.e.d(Op(), NY(), On())));
            this.bep = true;
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
        this.ben = aVar;
    }
}
