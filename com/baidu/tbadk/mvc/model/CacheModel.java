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
    private boolean IP;
    private MessageListener<CustomResponsedMessage<?>> aSl;
    private MessageListener<CustomResponsedMessage<?>> aSm;
    private a<T> aSn;
    private boolean aSo;
    private boolean aSp;
    private boolean aSq;
    private boolean aSr;
    private boolean aSs;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> JN();

    public abstract int JO();

    public abstract int JP();

    public abstract String Jy();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.aSo = false;
        this.aSp = false;
        this.aSq = false;
        this.aSr = false;
        this.IP = false;
        this.aSs = false;
    }

    protected boolean JG() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void JH() {
        this.IP = true;
        JJ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(JO());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(JG());
        a(readCacheMessage);
        JL();
        sendMessage(readCacheMessage);
        this.IP = true;
    }

    public final void a(e eVar) {
        this.IP = true;
        JJ();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(JO());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(JG());
        a(readCacheMessage);
        JL();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.aSs = true;
        JK();
        JI();
    }

    private final void JI() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(JP());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        JM();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(JP());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        JM();
        sendMessage(writeCacheMessage);
    }

    private void JJ() {
        if (!this.aSq) {
            if (this.aSl == null) {
                this.aSl = new CustomMessageListener(JO()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.IP = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aSn != null) {
                                CacheModel.this.aSn.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.aSl.setSelfListener(true);
                this.aSl.setTag(this.unique_id);
            }
            registerListener(this.aSl);
            this.aSq = true;
        }
    }

    private void JK() {
        if (!this.aSr) {
            if (this.aSm == null) {
                this.aSm = new CustomMessageListener(JP()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.aSs = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.aSn != null) {
                                CacheModel.this.aSn.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.aSm.setSelfListener(true);
                this.aSm.setTag(this.unique_id);
            }
            registerListener(this.aSm);
            this.aSr = true;
        }
    }

    private void JL() {
        if (!this.aSo && MessageManager.getInstance().findTask(JO()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(JO(), new c(JO(), Jy(), JN())));
            this.aSo = true;
        }
    }

    private void JM() {
        if (!this.aSp && MessageManager.getInstance().findTask(JP()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(JP(), new com.baidu.tbadk.mvc.e.d(JP(), Jy(), JN())));
            this.aSp = true;
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
        this.aSn = aVar;
    }
}
