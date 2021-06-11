package com.baidu.tbadk.mvc.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import d.a.m0.g0.b.c;
import d.a.m0.g0.e.d;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class CacheModel<T extends d.a.m0.g0.b.c, ActivityType> extends BdBaseModel<ActivityType> {

    /* renamed from: e  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f12938e;

    /* renamed from: f  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f12939f;

    /* renamed from: g  reason: collision with root package name */
    public c<T> f12940g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12941h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12942i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            CacheModel.this.l = false;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ReadCacheRespMsg)) {
                return;
            }
            ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
            ReadCacheMessage readCacheMessage = null;
            if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
            }
            if (CacheModel.this.f12940g != null) {
                CacheModel.this.f12940g.onCacheDataGet(readCacheRespMsg, readCacheMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            CacheModel.this.m = false;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof WriteCacheRespMsg)) {
                return;
            }
            WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
            WriteCacheMessage writeCacheMessage = null;
            if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
            }
            if (CacheModel.this.f12940g != null) {
                CacheModel.this.f12940g.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        this.f12941h = false;
        this.f12942i = false;
        this.j = false;
        this.k = false;
    }

    public final void A(T t) {
        z(t);
    }

    public final void B() {
        if (this.j) {
            return;
        }
        if (this.f12938e == null) {
            a aVar = new a(I());
            this.f12938e = aVar;
            aVar.setSelfListener(true);
            this.f12938e.setTag(this.unique_id);
        }
        registerListener(this.f12938e);
        this.j = true;
    }

    public final void C() {
        if (this.f12941h || MessageManager.getInstance().findTask(I()) != null) {
            return;
        }
        MessageManager.getInstance().registerTask(new d.a.m0.v0.a(I(), new d.a.m0.g0.e.c(I(), v(), H())));
        this.f12941h = true;
    }

    public final void D() {
        if (this.k) {
            return;
        }
        if (this.f12939f == null) {
            b bVar = new b(J());
            this.f12939f = bVar;
            bVar.setSelfListener(true);
            this.f12939f.setTag(this.unique_id);
        }
        registerListener(this.f12939f);
        this.k = true;
    }

    public final void E() {
        if (this.f12942i || MessageManager.getInstance().findTask(J()) != null) {
            return;
        }
        MessageManager.getInstance().registerTask(new d.a.m0.v0.a(J(), new d(J(), v(), H())));
        this.f12942i = true;
    }

    public final void F() {
        D();
        G();
    }

    public final void G() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(J());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        E();
        sendMessage(writeCacheMessage);
    }

    public abstract Class<T> H();

    public abstract int I();

    public abstract int J();

    public boolean K() {
        return true;
    }

    public final void L() {
        B();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(I());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(K());
        N(readCacheMessage);
        C();
        sendMessage(readCacheMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public final boolean LoadData() {
        return true;
    }

    public final void M(d.a.m0.g0.b.d dVar) {
        B();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(I());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(dVar);
        readCacheMessage.setNeedUid(K());
        N(readCacheMessage);
        C();
        sendMessage(readCacheMessage);
    }

    public void N(ReadCacheMessage<T> readCacheMessage) {
    }

    public void O(c<T> cVar) {
        this.f12940g = cVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeCustomMessage(getUniqueId());
        return true;
    }

    public abstract String v();

    public final void z(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(J());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        E();
        sendMessage(writeCacheMessage);
    }
}
