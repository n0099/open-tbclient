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
    private boolean asa;
    private MessageListener<CustomResponsedMessage<?>> byq;
    private MessageListener<CustomResponsedMessage<?>> byr;
    private a<T> bys;
    private boolean byt;
    private boolean byu;
    private boolean byv;
    private boolean byw;
    private boolean byx;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String MY();

    public abstract Class<T> Nn();

    public abstract int No();

    public abstract int Np();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.byt = false;
        this.byu = false;
        this.byv = false;
        this.byw = false;
        this.asa = false;
        this.byx = false;
    }

    protected boolean Ng() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Nh() {
        this.asa = true;
        Nj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(No());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Ng());
        a(readCacheMessage);
        Nl();
        sendMessage(readCacheMessage);
        this.asa = true;
    }

    public final void a(e eVar) {
        this.asa = true;
        Nj();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(No());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Ng());
        a(readCacheMessage);
        Nl();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.byx = true;
        Nk();
        Ni();
    }

    private final void Ni() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Np());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Nm();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(Np());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Nm();
        sendMessage(writeCacheMessage);
    }

    private void Nj() {
        if (!this.byv) {
            if (this.byq == null) {
                this.byq = new CustomMessageListener(No()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.asa = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bys != null) {
                                CacheModel.this.bys.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.byq.setSelfListener(true);
                this.byq.setTag(this.unique_id);
            }
            registerListener(this.byq);
            this.byv = true;
        }
    }

    private void Nk() {
        if (!this.byw) {
            if (this.byr == null) {
                this.byr = new CustomMessageListener(Np()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.byx = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.bys != null) {
                                CacheModel.this.bys.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.byr.setSelfListener(true);
                this.byr.setTag(this.unique_id);
            }
            registerListener(this.byr);
            this.byw = true;
        }
    }

    private void Nl() {
        if (!this.byt && MessageManager.getInstance().findTask(No()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(No(), new c(No(), MY(), Nn())));
            this.byt = true;
        }
    }

    private void Nm() {
        if (!this.byu && MessageManager.getInstance().findTask(Np()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Np(), new com.baidu.tbadk.mvc.e.d(Np(), MY(), Nn())));
            this.byu = true;
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
        this.bys = aVar;
    }
}
