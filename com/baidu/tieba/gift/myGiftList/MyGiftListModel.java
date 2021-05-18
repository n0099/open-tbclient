package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.j0.r.q.j0;
import d.a.k0.u0.c.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16171e;

    /* renamed from: f  reason: collision with root package name */
    public int f16172f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16173g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16174h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16175i;
    public long j;
    public String k;
    public d.a.k0.u0.c.a l;
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
                    MyGiftListModel.this.m.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.f16175i, MyGiftListModel.this.l);
                }
                MyGiftListModel.this.f16175i = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, boolean z, d.a.k0.u0.c.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.f16173g = false;
        this.f16175i = true;
        this.j = 0L;
        a aVar = new a(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.n = aVar;
        this.f16174h = true;
        this.k = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
        d.a.k0.d3.d0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public boolean A() {
        return this.f16171e;
    }

    public final void B(d.a.k0.u0.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.k0.u0.c.a();
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
        d.a.k0.u0.c.a aVar2 = this.l;
        aVar2.f62077h = aVar.f62077h;
        aVar2.f62075f = aVar.f62075f;
        if (aVar.f62076g != null) {
            aVar2.f62076g = new j0();
            j0 j0Var = this.l.f62076g;
            j0 j0Var2 = aVar.f62076g;
            j0Var.f50012a = j0Var2.f50012a;
            j0Var.f50013b = j0Var2.f50013b;
        }
        if (this.l.c() != null) {
            this.f16172f = this.l.c().f62087a;
            this.f16171e = this.l.c().f62088b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f16173g) {
            ArrayList<a.C1670a> a2 = aVar.a();
            int size = this.l.a().size() + 1;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a.C1670a c1670a = a2.get(i2);
                if (c1670a != null) {
                    c1670a.j = size;
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
        this.f16173g = z;
    }

    public void F(boolean z) {
        this.f16174h = z;
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
        this.f16172f = i2;
        return getPersonalGiftListRequest;
    }

    public boolean y() {
        return this.f16174h;
    }

    public final void z() {
        GetPersonalGiftListRequest x;
        if (!this.f16173g) {
            x = x(1, this.j);
        } else {
            x = x(this.f16172f + 1, this.j);
        }
        sendMessage(x);
    }
}
