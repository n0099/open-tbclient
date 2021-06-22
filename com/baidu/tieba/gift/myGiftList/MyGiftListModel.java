package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.n0.r.q.j0;
import d.a.o0.v0.c.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16218e;

    /* renamed from: f  reason: collision with root package name */
    public int f16219f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16220g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16221h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16222i;
    public long j;
    public String k;
    public d.a.o0.v0.c.a l;
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
                        MyGiftListModel.this.F(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                    } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                        MyGiftListModel.this.F(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                    }
                }
                if (MyGiftListModel.this.m != null) {
                    MyGiftListModel.this.m.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.f16222i, MyGiftListModel.this.l);
                }
                MyGiftListModel.this.f16222i = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, boolean z, d.a.o0.v0.c.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.f16220g = false;
        this.f16222i = true;
        this.j = 0L;
        a aVar = new a(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.n = aVar;
        this.f16221h = true;
        this.k = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
        d.a.o0.e3.d0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public final GetPersonalGiftListRequest B(int i2, long j) {
        GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
        if (i2 < 1) {
            i2 = 1;
        }
        getPersonalGiftListRequest.setPageNumber(i2);
        getPersonalGiftListRequest.setUserId(j);
        getPersonalGiftListRequest.setType(this.k);
        getPersonalGiftListRequest.userType = this.mUserType;
        this.f16219f = i2;
        return getPersonalGiftListRequest;
    }

    public boolean C() {
        return this.f16221h;
    }

    public final void D() {
        GetPersonalGiftListRequest B;
        if (!this.f16220g) {
            B = B(1, this.j);
        } else {
            B = B(this.f16219f + 1, this.j);
        }
        sendMessage(B);
    }

    public boolean E() {
        return this.f16218e;
    }

    public final void F(d.a.o0.v0.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.o0.v0.c.a();
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
        d.a.o0.v0.c.a aVar2 = this.l;
        aVar2.f66074h = aVar.f66074h;
        aVar2.f66072f = aVar.f66072f;
        if (aVar.f66073g != null) {
            aVar2.f66073g = new j0();
            j0 j0Var = this.l.f66073g;
            j0 j0Var2 = aVar.f66073g;
            j0Var.f53839a = j0Var2.f53839a;
            j0Var.f53840b = j0Var2.f53840b;
        }
        if (this.l.c() != null) {
            this.f16219f = this.l.c().f66084a;
            this.f16218e = this.l.c().f66085b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f16220g) {
            ArrayList<a.C1744a> a2 = aVar.a();
            int size = this.l.a().size() + 1;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a.C1744a c1744a = a2.get(i2);
                if (c1744a != null) {
                    c1744a.j = size;
                    size++;
                }
            }
            this.l.a().addAll(a2);
            return;
        }
        this.l.a().clear();
        this.l.a().addAll(aVar.a());
    }

    public void G(b bVar) {
        this.m = bVar;
    }

    public final void H(String str) {
        if (str == null || str.length() <= 0 || str.equals("0") || str.startsWith("-")) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
            J(true);
        } else {
            J(false);
        }
    }

    public void I(boolean z) {
        this.f16220g = z;
    }

    public void J(boolean z) {
        this.f16221h = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        D();
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
        H(String.valueOf(j));
    }
}
