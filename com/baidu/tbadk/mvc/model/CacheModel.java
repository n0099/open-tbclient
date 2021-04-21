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
import d.b.i0.g0.b.c;
import d.b.i0.g0.e.d;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class CacheModel<T extends d.b.i0.g0.b.c, ActivityType> extends BdBaseModel<ActivityType> {

    /* renamed from: e  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f13631e;

    /* renamed from: f  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f13632f;

    /* renamed from: g  reason: collision with root package name */
    public c<T> f13633g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13634h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
            if (CacheModel.this.f13633g != null) {
                CacheModel.this.f13633g.onCacheDataGet(readCacheRespMsg, readCacheMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
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
            if (CacheModel.this.f13633g != null) {
                CacheModel.this.f13633g.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
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
        this.f13634h = false;
        this.i = false;
        this.j = false;
        this.k = false;
    }

    public final void A() {
        if (this.i || MessageManager.getInstance().findTask(F()) != null) {
            return;
        }
        MessageManager.getInstance().registerTask(new d.b.i0.v0.a(F(), new d(F(), q(), D())));
        this.i = true;
    }

    public final void B() {
        z();
        C();
    }

    public final void C() {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(F());
        writeCacheMessage.setClear(true);
        writeCacheMessage.setTag(getUniqueId());
        A();
        sendMessage(writeCacheMessage);
    }

    public abstract Class<T> D();

    public abstract int E();

    public abstract int F();

    public boolean G() {
        return true;
    }

    public final void H() {
        x();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(E());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setNeedUid(G());
        J(readCacheMessage);
        y();
        sendMessage(readCacheMessage);
    }

    public final void I(d.b.i0.g0.b.d dVar) {
        x();
        ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(E());
        readCacheMessage.setTag(getUniqueId());
        readCacheMessage.setRequestData(dVar);
        readCacheMessage.setNeedUid(G());
        J(readCacheMessage);
        y();
        sendMessage(readCacheMessage);
    }

    public void J(ReadCacheMessage<T> readCacheMessage) {
    }

    public void K(c<T> cVar) {
        this.f13633g = cVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public final boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeCustomMessage(getUniqueId());
        return true;
    }

    public abstract String q();

    public final void v(T t) {
        WriteCacheMessage writeCacheMessage = new WriteCacheMessage(F());
        writeCacheMessage.setTag(getUniqueId());
        writeCacheMessage.setData(t);
        A();
        sendMessage(writeCacheMessage);
    }

    public final void w(T t) {
        v(t);
    }

    public final void x() {
        if (this.j) {
            return;
        }
        if (this.f13631e == null) {
            a aVar = new a(E());
            this.f13631e = aVar;
            aVar.setSelfListener(true);
            this.f13631e.setTag(this.unique_id);
        }
        registerListener(this.f13631e);
        this.j = true;
    }

    public final void y() {
        if (this.f13634h || MessageManager.getInstance().findTask(E()) != null) {
            return;
        }
        MessageManager.getInstance().registerTask(new d.b.i0.v0.a(E(), new d.b.i0.g0.e.c(E(), q(), D())));
        this.f13634h = true;
    }

    public final void z() {
        if (this.k) {
            return;
        }
        if (this.f13632f == null) {
            b bVar = new b(F());
            this.f13632f = bVar;
            bVar.setSelfListener(true);
            this.f13632f.setTag(this.unique_id);
        }
        registerListener(this.f13632f);
        this.k = true;
    }
}
