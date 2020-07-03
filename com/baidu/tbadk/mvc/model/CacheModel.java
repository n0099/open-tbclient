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
    private boolean Tg;
    private MessageListener<CustomResponsedMessage<?>> ezp;
    private MessageListener<CustomResponsedMessage<?>> ezq;
    private a<T> ezr;
    private boolean ezs;
    private boolean ezt;
    private boolean ezu;
    private boolean ezv;
    private boolean ezw;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String bgR();

    public abstract Class<T> bhi();

    public abstract int bhj();

    public abstract int bhk();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ezs = false;
        this.ezt = false;
        this.ezu = false;
        this.ezv = false;
        this.Tg = false;
        this.ezw = false;
    }

    protected boolean bhb() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void bhc() {
        this.Tg = true;
        bhe();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bhj());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(bhb());
        a(readCacheMessage);
        bhg();
        sendMessage(readCacheMessage);
        this.Tg = true;
    }

    public final void a(e eVar) {
        this.Tg = true;
        bhe();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(bhj());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(bhb());
        a(readCacheMessage);
        bhg();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ezw = true;
        bhf();
        bhd();
    }

    private final void bhd() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bhk());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        bhh();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(bhk());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        bhh();
        sendMessage(writeCacheMessage);
    }

    private void bhe() {
        if (!this.ezu) {
            if (this.ezp == null) {
                this.ezp = new CustomMessageListener(bhj()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.Tg = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ezr != null) {
                                CacheModel.this.ezr.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.ezp.setSelfListener(true);
                this.ezp.setTag(this.unique_id);
            }
            registerListener(this.ezp);
            this.ezu = true;
        }
    }

    private void bhf() {
        if (!this.ezv) {
            if (this.ezq == null) {
                this.ezq = new CustomMessageListener(bhk()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.ezw = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.ezr != null) {
                                CacheModel.this.ezr.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.ezq.setSelfListener(true);
                this.ezq.setTag(this.unique_id);
            }
            registerListener(this.ezq);
            this.ezv = true;
        }
    }

    private void bhg() {
        if (!this.ezs && MessageManager.getInstance().findTask(bhj()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bhj(), new c(bhj(), bgR(), bhi())));
            this.ezs = true;
        }
    }

    private void bhh() {
        if (!this.ezt && MessageManager.getInstance().findTask(bhk()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(bhk(), new com.baidu.tbadk.mvc.e.d(bhk(), bgR(), bhi())));
            this.ezt = true;
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
        this.ezr = aVar;
    }
}
