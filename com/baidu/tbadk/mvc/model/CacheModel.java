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
    private boolean JX;
    private MessageListener<CustomResponsedMessage<?>> cyj;
    private MessageListener<CustomResponsedMessage<?>> cyk;
    private a<T> cyl;
    private boolean cym;
    private boolean cyn;
    private boolean cyo;
    private boolean cyp;
    private boolean cyq;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String aud();

    public abstract Class<T> auu();

    public abstract int auv();

    public abstract int auw();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.cym = false;
        this.cyn = false;
        this.cyo = false;
        this.cyp = false;
        this.JX = false;
        this.cyq = false;
    }

    protected boolean aun() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void auo() {
        this.JX = true;
        auq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(auv());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(aun());
        a(readCacheMessage);
        aus();
        sendMessage(readCacheMessage);
        this.JX = true;
    }

    public final void a(e eVar) {
        this.JX = true;
        auq();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(auv());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(aun());
        a(readCacheMessage);
        aus();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.cyq = true;
        aur();
        aup();
    }

    private final void aup() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(auw());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        aut();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(auw());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        aut();
        sendMessage(writeCacheMessage);
    }

    private void auq() {
        if (!this.cyo) {
            if (this.cyj == null) {
                this.cyj = new CustomMessageListener(auv()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.JX = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cyl != null) {
                                CacheModel.this.cyl.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.cyj.setSelfListener(true);
                this.cyj.setTag(this.unique_id);
            }
            registerListener(this.cyj);
            this.cyo = true;
        }
    }

    private void aur() {
        if (!this.cyp) {
            if (this.cyk == null) {
                this.cyk = new CustomMessageListener(auw()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.cyq = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cyl != null) {
                                CacheModel.this.cyl.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.cyk.setSelfListener(true);
                this.cyk.setTag(this.unique_id);
            }
            registerListener(this.cyk);
            this.cyp = true;
        }
    }

    private void aus() {
        if (!this.cym && MessageManager.getInstance().findTask(auv()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(auv(), new c(auv(), aud(), auu())));
            this.cym = true;
        }
    }

    private void aut() {
        if (!this.cyn && MessageManager.getInstance().findTask(auw()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(auw(), new com.baidu.tbadk.mvc.e.d(auw(), aud(), auu())));
            this.cyn = true;
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
        this.cyl = aVar;
    }
}
