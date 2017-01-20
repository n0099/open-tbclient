package com.baidu.tbadk.mvc.model;

import com.baidu.adp.base.BdBaseModel;
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
public abstract class CacheModel<T extends com.baidu.tbadk.mvc.b.d, ActivityType> extends BdBaseModel<ActivityType> {
    private MessageListener<CustomResponsedMessage<?>> ayH;
    private MessageListener<CustomResponsedMessage<?>> ayI;
    private a<T> ayJ;
    private boolean ayK;
    private boolean ayL;
    private boolean ayM;
    private boolean ayN;
    private boolean ayO;
    private boolean yb;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void a(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> ED();

    public abstract int EE();

    public abstract int EF();

    public abstract String Ep();

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.ayK = false;
        this.ayL = false;
        this.ayM = false;
        this.ayN = false;
        this.yb = false;
        this.ayO = false;
    }

    protected boolean Ew() {
        return true;
    }

    protected void a(ReadCacheMessage<T> readCacheMessage) {
    }

    public final void Ex() {
        this.yb = true;
        Ez();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EE());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(Ew());
        a(readCacheMessage);
        EB();
        sendMessage(readCacheMessage);
        this.yb = true;
    }

    public final void a(com.baidu.tbadk.mvc.b.e eVar) {
        this.yb = true;
        Ez();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(EE());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(eVar);
        readCacheMessage.setNeedUid(Ew());
        a(readCacheMessage);
        EB();
        sendMessage(readCacheMessage);
    }

    public final void clearCache() {
        this.ayO = true;
        EA();
        Ey();
    }

    private final void Ey() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EF());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        EC();
        sendMessage(writeCacheMessage);
    }

    public final void a(T t) {
        b(t);
    }

    private final void b(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(EF());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        EC();
        sendMessage(writeCacheMessage);
    }

    private void Ez() {
        if (!this.ayM) {
            if (this.ayH == null) {
                this.ayH = new com.baidu.tbadk.mvc.model.a(this, EE());
                this.ayH.setSelfListener(true);
                this.ayH.setTag(this.unique_id);
            }
            registerListener(this.ayH);
            this.ayM = true;
        }
    }

    private void EA() {
        if (!this.ayN) {
            if (this.ayI == null) {
                this.ayI = new b(this, EF());
                this.ayI.setSelfListener(true);
                this.ayI.setTag(this.unique_id);
            }
            registerListener(this.ayI);
            this.ayN = true;
        }
    }

    private void EB() {
        if (!this.ayK && MessageManager.getInstance().findTask(EE()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EE(), new com.baidu.tbadk.mvc.e.c(EE(), Ep(), ED())));
            this.ayK = true;
        }
    }

    private void EC() {
        if (!this.ayL && MessageManager.getInstance().findTask(EF()) == null) {
            MessageManager.getInstance().registerTask(new com.baidu.tbadk.task.a(EF(), new com.baidu.tbadk.mvc.e.d(EF(), Ep(), ED())));
            this.ayL = true;
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
        this.ayJ = aVar;
    }
}
