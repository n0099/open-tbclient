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
    private boolean arZ;
    private MessageListener<CustomResponsedMessage<?>> byn;
    private MessageListener<CustomResponsedMessage<?>> byo;
    private a<T> byp;
    private boolean byq;
    private boolean byr;
    private boolean bys;
    private boolean byt;
    private boolean byu;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String MX();

    public abstract Class<T> Nm();

    public abstract int Nn();

    public abstract int No();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.byq = false;
        this.byr = false;
        this.bys = false;
        this.byt = false;
        this.arZ = false;
        this.byu = false;
    }

    protected boolean Nf() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Ng() {
        this.arZ = true;
        Ni();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Nn());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Nf());
        a(readCacheMessage);
        Nk();
        sendMessage(readCacheMessage);
        this.arZ = true;
    }

    public final void a(e eVar) {
        this.arZ = true;
        Ni();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(Nn());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Nf());
        a(readCacheMessage);
        Nk();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.byu = true;
        Nj();
        Nh();
    }

    private final void Nh() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(No());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        Nl();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(No());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        Nl();
        sendMessage(writeCacheMessage);
    }

    private void Ni() {
        if (!this.bys) {
            if (this.byn == null) {
                this.byn = new CustomMessageListener(Nn()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.arZ = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.byp != null) {
                                CacheModel.this.byp.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.byn.setSelfListener(true);
                this.byn.setTag(this.unique_id);
            }
            registerListener(this.byn);
            this.bys = true;
        }
    }

    private void Nj() {
        if (!this.byt) {
            if (this.byo == null) {
                this.byo = new CustomMessageListener(No()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.byu = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.byp != null) {
                                CacheModel.this.byp.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.byo.setSelfListener(true);
                this.byo.setTag(this.unique_id);
            }
            registerListener(this.byo);
            this.byt = true;
        }
    }

    private void Nk() {
        if (!this.byq && MessageManager.getInstance().findTask(Nn()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(Nn(), new c(Nn(), MX(), Nm())));
            this.byq = true;
        }
    }

    private void Nl() {
        if (!this.byr && MessageManager.getInstance().findTask(No()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(No(), new com.baidu.tbadk.mvc.e.d(No(), MX(), Nm())));
            this.byr = true;
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
        this.byp = aVar;
    }
}
