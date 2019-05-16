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
    private boolean JN;
    private MessageListener<CustomResponsedMessage<?>> cwT;
    private MessageListener<CustomResponsedMessage<?>> cwU;
    private a<T> cwV;
    private boolean cwW;
    private boolean cwX;
    private boolean cwY;
    private boolean cwZ;
    private boolean cxa;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract String asV();

    public abstract Class<T> atm();

    public abstract int atn();

    public abstract int ato();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.cwW = false;
        this.cwX = false;
        this.cwY = false;
        this.cwZ = false;
        this.JN = false;
        this.cxa = false;
    }

    protected boolean atf() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void atg() {
        this.JN = true;
        ati();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(atn());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(atf());
        a(readCacheMessage);
        atk();
        sendMessage(readCacheMessage);
        this.JN = true;
    }

    public final void a(e eVar) {
        this.JN = true;
        ati();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(atn());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(atf());
        a(readCacheMessage);
        atk();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.cxa = true;
        atj();
        ath();
    }

    private final void ath() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(ato());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        atl();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(ato());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        atl();
        sendMessage(writeCacheMessage);
    }

    private void ati() {
        if (!this.cwY) {
            if (this.cwT == null) {
                this.cwT = new CustomMessageListener(atn()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.JN = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                            ReadCacheMessage readCacheMessage = null;
                            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cwV != null) {
                                CacheModel.this.cwV.a(readCacheRespMsg, readCacheMessage);
                            }
                        }
                    }
                };
                this.cwT.setSelfListener(true);
                this.cwT.setTag(this.unique_id);
            }
            registerListener(this.cwT);
            this.cwY = true;
        }
    }

    private void atj() {
        if (!this.cwZ) {
            if (this.cwU == null) {
                this.cwU = new CustomMessageListener(ato()) { // from class: com.baidu.tbadk.mvc.model.CacheModel.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        CacheModel.this.cxa = false;
                        if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                            WriteCacheMessage writeCacheMessage = null;
                            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                            }
                            if (CacheModel.this.cwV != null) {
                                CacheModel.this.cwV.a(writeCacheRespMsg, writeCacheMessage);
                            }
                        }
                    }
                };
                this.cwU.setSelfListener(true);
                this.cwU.setTag(this.unique_id);
            }
            registerListener(this.cwU);
            this.cwZ = true;
        }
    }

    private void atk() {
        if (!this.cwW && MessageManager.getInstance().findTask(atn()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(atn(), new c(atn(), asV(), atm())));
            this.cwW = true;
        }
    }

    private void atl() {
        if (!this.cwX && MessageManager.getInstance().findTask(ato()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(ato(), new com.baidu.tbadk.mvc.e.d(ato(), asV(), atm())));
            this.cwX = true;
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
        this.cwV = aVar;
    }
}
