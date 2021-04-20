package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import d.b.c.a.f;
import d.b.c.c.e.c.h;
import d.b.h0.m0.d;
import d.b.h0.m0.k;
import d.b.h0.z0.c;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f16950e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16951f;

    /* renamed from: g  reason: collision with root package name */
    public int f16952g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f16953h;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0195a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f16955a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f16956b;

            public C0195a(ResponsedMessage responsedMessage, boolean z) {
                this.f16955a = responsedMessage;
                this.f16956b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                RecPersonalizePageModel.this.z(this.f16955a, this.f16956b);
                return false;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f16958a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f16959b;

            public b(ResponsedMessage responsedMessage, boolean z) {
                this.f16958a = responsedMessage;
                this.f16959b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                RecPersonalizePageModel.this.x(this.f16958a, this.f16959b);
                return false;
            }
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
            if (r0.getNeedForumlist() == 1) goto L14;
         */
        @Override // d.b.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            if (responsedMessage == null || RecPersonalizePageModel.this.f16950e == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RecPersonalizeRequest) {
                    RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                    z2 = true;
                    z = recPersonalizeRequest.getLoadType() == 1;
                }
            }
            z = false;
            z2 = false;
            if (responsedMessage.getError() != 0) {
                if (TbSingleton.getInstance().needUploadMoreLog()) {
                    d.b.h0.r.z.a.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
                }
                RecPersonalizePageModel.this.f16950e.a(responsedMessage.getError(), responsedMessage.getErrorString());
            } else {
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                RecPersonalizePageModel.this.f16950e.b(dataRes, z, z2);
            }
            if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                Looper.myQueue().addIdleHandler(new C0195a(responsedMessage, z));
            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                Looper.myQueue().addIdleHandler(new b(responsedMessage, z));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str);

        void b(DataRes dataRes, boolean z, boolean z2);
    }

    public RecPersonalizePageModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f16951f = false;
        this.f16952g = 1;
        this.f16953h = new a(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        setUniqueId(bdUniqueId);
        A();
        B();
        registerListener(this.f16953h);
    }

    public final void A() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, d.b.i0.d3.d0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void B() {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void C(b bVar) {
        this.f16950e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        int i = this.f16952g;
        this.f16952g = i + 1;
        recPersonalizeRequest.setRequestTime(i);
        recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.3
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.o)) {
                    return false;
                }
                if (TbSingleton.getInstance().needUploadMoreLog()) {
                    d.b.h0.r.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                    return true;
                }
                return true;
            }
        });
        sendMessage(recPersonalizeRequest);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void v(int i, int i2, @NonNull c cVar, int i3, int i4) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i);
        recPersonalizeRequest.setThreadCount(i2);
        recPersonalizeRequest.setPreAdThreadCount(cVar.f52075a);
        recPersonalizeRequest.setAdFloorInfo(cVar.f52076b);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i3);
        recPersonalizeRequest.setSuggestCount(i4);
        recPersonalizeRequest.setNeedForumlist(0);
        int i5 = this.f16952g;
        this.f16952g = i5 + 1;
        recPersonalizeRequest.setRequestTime(i5);
        recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.2
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.o)) {
                    return false;
                }
                if (TbSingleton.getInstance().needUploadMoreLog()) {
                    d.b.h0.r.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                    return true;
                }
                return true;
            }
        });
        sendMessage(recPersonalizeRequest);
    }

    public void w(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (!k.d().g() || d.b.i0.a1.c.a.d().b() <= 0) {
            return;
        }
        long f2 = d.b.i0.a1.c.a.d().f(1);
        long b2 = d.b.i0.a1.c.a.d().b();
        long c2 = d.b.i0.a1.c.a.d().c(1);
        long j = f2 + b2;
        long a2 = d.b.i0.a1.c.a.d().a(1);
        if (a2 > 0) {
            j = System.currentTimeMillis() - a2;
        }
        d dVar = new d(1005, z, responsedMessage, 0L, b2, c2, false, j);
        dVar.F = i;
        dVar.c();
        d.b.i0.a1.c.a.d().h(0L);
    }

    public final void x(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.f16951f) {
            this.f16951f = true;
            w(1, true, responsedMessage);
        }
        y(z, true, responsedMessage);
    }

    public void y(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        if (k.d().g()) {
            long f2 = d.b.i0.a1.c.a.d().f(1);
            long b2 = d.b.i0.a1.c.a.d().b();
            d dVar = new d(1005, z2, responsedMessage, 0L, b2, d.b.i0.a1.c.a.d().c(1), false, f2 + b2);
            dVar.F = 1;
            if (z) {
                dVar.C = f2;
                dVar.e(false);
                return;
            }
            dVar.B = f2;
            dVar.e(true);
        }
    }

    public final void z(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.f16951f) {
            this.f16951f = true;
            w(1, false, responsedMessage);
        }
        y(z, false, responsedMessage);
    }
}
