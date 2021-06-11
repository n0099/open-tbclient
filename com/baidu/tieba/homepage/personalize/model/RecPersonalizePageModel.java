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
import d.a.c.a.f;
import d.a.c.c.e.c.h;
import d.a.m0.m0.d;
import d.a.m0.m0.k;
import d.a.m0.z0.c;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f16518e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16519f;

    /* renamed from: g  reason: collision with root package name */
    public int f16520g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f16521h;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {

        /* renamed from: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0180a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f16523a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f16524b;

            public C0180a(ResponsedMessage responsedMessage, boolean z) {
                this.f16523a = responsedMessage;
                this.f16524b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                RecPersonalizePageModel.this.D(this.f16523a, this.f16524b);
                return false;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f16526a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f16527b;

            public b(ResponsedMessage responsedMessage, boolean z) {
                this.f16526a = responsedMessage;
                this.f16527b = z;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                RecPersonalizePageModel.this.B(this.f16526a, this.f16527b);
                return false;
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
            if (r0.getNeedForumlist() == 1) goto L14;
         */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2;
            if (responsedMessage == null || RecPersonalizePageModel.this.f16518e == null) {
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
                    d.a.m0.r.z.a.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
                }
                RecPersonalizePageModel.this.f16518e.a(responsedMessage.getError(), responsedMessage.getErrorString());
            } else {
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                RecPersonalizePageModel.this.f16518e.b(dataRes, z, z2);
            }
            if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                Looper.myQueue().addIdleHandler(new C0180a(responsedMessage, z));
            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                Looper.myQueue().addIdleHandler(new b(responsedMessage, z));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str);

        void b(DataRes dataRes, boolean z, boolean z2);
    }

    public RecPersonalizePageModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f16519f = false;
        this.f16520g = 1;
        this.f16521h = new a(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        setUniqueId(bdUniqueId);
        E();
        F();
        registerListener(this.f16521h);
    }

    public void A(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        if (!k.d().g() || d.a.n0.b1.d.a.d().b() <= 0) {
            return;
        }
        long f2 = d.a.n0.b1.d.a.d().f(1);
        long b2 = d.a.n0.b1.d.a.d().b();
        long c2 = d.a.n0.b1.d.a.d().c(1);
        long j = f2 + b2;
        long a2 = d.a.n0.b1.d.a.d().a(1);
        if (a2 > 0) {
            j = System.currentTimeMillis() - a2;
        }
        d dVar = new d(1005, z, responsedMessage, 0L, b2, c2, false, j);
        dVar.F = i2;
        dVar.c();
        d.a.n0.b1.d.a.d().h(0L);
    }

    public final void B(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.f16519f) {
            this.f16519f = true;
            A(1, true, responsedMessage);
        }
        C(z, true, responsedMessage);
    }

    public void C(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        if (k.d().g()) {
            long f2 = d.a.n0.b1.d.a.d().f(1);
            long b2 = d.a.n0.b1.d.a.d().b();
            d dVar = new d(1005, z2, responsedMessage, 0L, b2, d.a.n0.b1.d.a.d().c(1), false, f2 + b2);
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

    public final void D(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.f16519f) {
            this.f16519f = true;
            A(1, false, responsedMessage);
        }
        C(z, false, responsedMessage);
    }

    public final void E() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, d.a.n0.e3.d0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void F() {
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void G(b bVar) {
        this.f16518e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        int i2 = this.f16520g;
        this.f16520g = i2 + 1;
        recPersonalizeRequest.setRequestTime(i2);
        recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.3
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.o)) {
                    return false;
                }
                if (TbSingleton.getInstance().needUploadMoreLog()) {
                    d.a.m0.r.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
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

    public void z(int i2, int i3, @NonNull c cVar, int i4, int i5) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i2);
        recPersonalizeRequest.setThreadCount(i3);
        recPersonalizeRequest.setPreAdThreadCount(cVar.f54657a);
        recPersonalizeRequest.setAdFloorInfo(cVar.f54658b);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i4);
        recPersonalizeRequest.setSuggestCount(i5);
        recPersonalizeRequest.setNeedForumlist(0);
        int i6 = this.f16520g;
        this.f16520g = i6 + 1;
        recPersonalizeRequest.setRequestTime(i6);
        recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.2
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.o)) {
                    return false;
                }
                if (TbSingleton.getInstance().needUploadMoreLog()) {
                    d.a.m0.r.z.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                    return true;
                }
                return true;
            }
        });
        sendMessage(recPersonalizeRequest);
    }
}
