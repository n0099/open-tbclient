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
    private MessageListener<CustomResponsedMessage<?>> beo;
    private MessageListener<CustomResponsedMessage<?>> bep;
    private a<T> beq;
    private boolean ber;
    private boolean bes;
    private boolean beu;
    private boolean bev;
    private boolean bew;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String NZ();

    public abstract Class<T> Oo();

    public abstract int Op();

    public abstract int Oq();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ber = false;
        this.bes = false;
        this.beu = false;
        this.bev = false;
        this.LI = false;
        this.bew = false;
    }

    protected boolean Oh() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Oi() {
        this.LI = true;
        Ok();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Op());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Oh());
        a(readCacheMessage);
        Om();
        sendMessage(readCacheMessage);
        this.LI = true;
    }

    public final void a(e eVar) {
        this.LI = true;
        Ok();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Op());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Oh());
        a(readCacheMessage);
        Om();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bew = true;
        Ol();
        Oj();
    }

    private final void Oj() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Oq());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        On();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Oq());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        On();
        sendMessage(writeCacheMessage);
    }

    private void Ok() {
        if (!this.beu) {
            if (this.beo == null) {
                this.beo = new CustomMessageListener(Op()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
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
                            if (CacheModel.this.beq != null) {
                                CacheModel.this.beq.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.beo.setSelfListener(true);
                this.beo.setTag(this.unique_id);
            }
            registerListener(this.beo);
            this.beu = true;
        }
    }

    private void Ol() {
        if (!this.bev) {
            if (this.bep == null) {
                this.bep = new CustomMessageListener(Oq()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bew = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.beq != null) {
                                CacheModel.this.beq.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.bep.setSelfListener(true);
                this.bep.setTag(this.unique_id);
            }
            registerListener(this.bep);
            this.bev = true;
        }
    }

    private void Om() {
        if (!this.ber && MessageManager.getInstance().findTask(Op()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Op(), new c(Op(), NZ(), Oo())));
            this.ber = true;
        }
    }

    private void On() {
        if (!this.bes && MessageManager.getInstance().findTask(Oq()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Oq(), new com.baidu.tbadk.mvc.e.d(Oq(), NZ(), Oo())));
            this.bes = true;
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
        this.beq = aVar;
    }
}
