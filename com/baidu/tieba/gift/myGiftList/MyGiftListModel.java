package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.i0.r.q.j0;
import d.a.j0.u0.c.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16856e;

    /* renamed from: f  reason: collision with root package name */
    public int f16857f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16858g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16859h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16860i;
    public long j;
    public String k;
    public d.a.j0.u0.c.a l;
    public b m;
    public int mUserType;
    public d.a.c.c.g.a n;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetPersonalGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        MyGiftListModel.this.B(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                    } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                        MyGiftListModel.this.B(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                    }
                }
                if (MyGiftListModel.this.m != null) {
                    MyGiftListModel.this.m.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.f16860i, MyGiftListModel.this.l);
                }
                MyGiftListModel.this.f16860i = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, boolean z, d.a.j0.u0.c.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.f16858g = false;
        this.f16860i = true;
        this.j = 0L;
        a aVar = new a(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.n = aVar;
        this.f16859h = true;
        this.k = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
        d.a.j0.d3.d0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        d.a.j0.d3.d0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public boolean A() {
        return this.f16856e;
    }

    public final void B(d.a.j0.u0.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.j0.u0.c.a();
        }
        if (this.l.c() == null) {
            this.l.i(new a.b());
        }
        if (this.l.d() == null) {
            this.l.j(new a.c());
        }
        if (this.l.a() == null) {
            this.l.g(new ArrayList<>());
        }
        this.l.h(aVar.b());
        this.l.k(aVar.e());
        this.l.i(aVar.c());
        this.l.j(aVar.d());
        d.a.j0.u0.c.a aVar2 = this.l;
        aVar2.f61353h = aVar.f61353h;
        aVar2.f61351f = aVar.f61351f;
        if (aVar.f61352g != null) {
            aVar2.f61352g = new j0();
            j0 j0Var = this.l.f61352g;
            j0 j0Var2 = aVar.f61352g;
            j0Var.f49193a = j0Var2.f49193a;
            j0Var.f49194b = j0Var2.f49194b;
        }
        if (this.l.c() != null) {
            this.f16857f = this.l.c().f61363a;
            this.f16856e = this.l.c().f61364b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f16858g) {
            ArrayList<a.C1605a> a2 = aVar.a();
            int size = this.l.a().size() + 1;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a.C1605a c1605a = a2.get(i2);
                if (c1605a != null) {
                    c1605a.j = size;
                    size++;
                }
            }
            this.l.a().addAll(a2);
            return;
        }
        this.l.a().clear();
        this.l.a().addAll(aVar.a());
    }

    public void C(b bVar) {
        this.m = bVar;
    }

    public final void D(String str) {
        if (str == null || str.length() <= 0 || str.equals("0") || str.startsWith("-")) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
            F(true);
        } else {
            F(false);
        }
    }

    public void E(boolean z) {
        this.f16858g = z;
    }

    public void F(boolean z) {
        this.f16859h = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        z();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public long getUid() {
        return this.j;
    }

    public void setUid(long j) {
        this.j = j;
        D(String.valueOf(j));
    }

    public final GetPersonalGiftListRequest x(int i2, long j) {
        GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
        if (i2 < 1) {
            i2 = 1;
        }
        getPersonalGiftListRequest.setPageNumber(i2);
        getPersonalGiftListRequest.setUserId(j);
        getPersonalGiftListRequest.setType(this.k);
        getPersonalGiftListRequest.userType = this.mUserType;
        this.f16857f = i2;
        return getPersonalGiftListRequest;
    }

    public boolean y() {
        return this.f16859h;
    }

    public final void z() {
        GetPersonalGiftListRequest x;
        if (!this.f16858g) {
            x = x(1, this.j);
        } else {
            x = x(this.f16857f + 1, this.j);
        }
        sendMessage(x);
    }
}
