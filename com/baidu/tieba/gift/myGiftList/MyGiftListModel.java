package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.b.a.f;
import d.b.h0.r.q.j0;
import d.b.i0.t0.c.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16927e;

    /* renamed from: f  reason: collision with root package name */
    public int f16928f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16929g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16930h;
    public boolean i;
    public long j;
    public String k;
    public d.b.i0.t0.c.a l;
    public b m;
    public int mUserType;
    public d.b.b.c.g.a n;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
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
                    MyGiftListModel.this.m.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.i, MyGiftListModel.this.l);
                }
                MyGiftListModel.this.i = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, boolean z, d.b.i0.t0.c.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.f16929g = false;
        this.i = true;
        this.j = 0L;
        a aVar = new a(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.n = aVar;
        this.f16930h = true;
        this.k = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
        d.b.i0.c3.d0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public boolean A() {
        return this.f16927e;
    }

    public final void B(d.b.i0.t0.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.b.i0.t0.c.a();
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
        d.b.i0.t0.c.a aVar2 = this.l;
        aVar2.f61030f = aVar.f61030f;
        if (aVar.f61031g != null) {
            aVar2.f61031g = new j0();
            j0 j0Var = this.l.f61031g;
            j0 j0Var2 = aVar.f61031g;
            j0Var.f50821a = j0Var2.f50821a;
            j0Var.f50822b = j0Var2.f50822b;
        }
        if (this.l.c() != null) {
            this.f16928f = this.l.c().f61040a;
            this.f16927e = this.l.c().f61041b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f16929g) {
            ArrayList<a.C1582a> a2 = aVar.a();
            int size = this.l.a().size() + 1;
            for (int i = 0; i < a2.size(); i++) {
                a.C1582a c1582a = a2.get(i);
                if (c1582a != null) {
                    c1582a.j = size;
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
        this.f16929g = z;
    }

    public void F(boolean z) {
        this.f16930h = z;
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

    public final GetPersonalGiftListRequest x(int i, long j) {
        GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
        if (i < 1) {
            i = 1;
        }
        getPersonalGiftListRequest.setPageNumber(i);
        getPersonalGiftListRequest.setUserId(j);
        getPersonalGiftListRequest.setType(this.k);
        getPersonalGiftListRequest.userType = this.mUserType;
        this.f16928f = i;
        return getPersonalGiftListRequest;
    }

    public boolean y() {
        return this.f16930h;
    }

    public final void z() {
        GetPersonalGiftListRequest x;
        if (!this.f16929g) {
            x = x(1, this.j);
        } else {
            x = x(this.f16928f + 1, this.j);
        }
        sendMessage(x);
    }
}
