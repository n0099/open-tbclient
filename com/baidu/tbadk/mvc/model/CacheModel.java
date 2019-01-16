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
    private boolean LS;
    private MessageListener<CustomResponsedMessage<?>> beZ;
    private MessageListener<CustomResponsedMessage<?>> bfa;
    private a<T> bfc;
    private boolean bfd;
    private boolean bfe;
    private boolean bff;
    private boolean bfg;
    private boolean bfh;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> OG();

    public abstract int OH();

    public abstract int OI();

    public abstract String Oq();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.bfd = false;
        this.bfe = false;
        this.bff = false;
        this.bfg = false;
        this.LS = false;
        this.bfh = false;
    }

    protected boolean Oz() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void OA() {
        this.LS = true;
        OC();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(OH());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Oz());
        a(readCacheMessage);
        OE();
        sendMessage(readCacheMessage);
        this.LS = true;
    }

    public final void a(e eVar) {
        this.LS = true;
        OC();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(OH());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Oz());
        a(readCacheMessage);
        OE();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.bfh = true;
        OD();
        OB();
    }

    private final void OB() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(OI());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        OF();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(OI());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        OF();
        sendMessage(writeCacheMessage);
    }

    private void OC() {
        if (!this.bff) {
            if (this.beZ == null) {
                this.beZ = new CustomMessageListener(OH()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.LS = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bfc != null) {
                                CacheModel.this.bfc.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.beZ.setSelfListener(true);
                this.beZ.setTag(this.unique_id);
            }
            registerListener(this.beZ);
            this.bff = true;
        }
    }

    private void OD() {
        if (!this.bfg) {
            if (this.bfa == null) {
                this.bfa = new CustomMessageListener(OI()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.bfh = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bfc != null) {
                                CacheModel.this.bfc.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.bfa.setSelfListener(true);
                this.bfa.setTag(this.unique_id);
            }
            registerListener(this.bfa);
            this.bfg = true;
        }
    }

    private void OE() {
        if (!this.bfd && MessageManager.getInstance().findTask(OH()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(OH(), new c(OH(), Oq(), OG())));
            this.bfd = true;
        }
    }

    private void OF() {
        if (!this.bfe && MessageManager.getInstance().findTask(OI()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(OI(), new com.baidu.tbadk.mvc.e.d(OI(), Oq(), OG())));
            this.bfe = true;
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
        this.bfc = aVar;
    }
}
