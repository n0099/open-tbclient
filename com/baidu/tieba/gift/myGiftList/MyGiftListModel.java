package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.m0.r.q.j0;
import d.a.n0.v0.c.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f16136e;

    /* renamed from: f  reason: collision with root package name */
    public int f16137f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16138g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16139h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16140i;
    public long j;
    public String k;
    public d.a.n0.v0.c.a l;
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
                    MyGiftListModel.this.m.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.f16140i, MyGiftListModel.this.l);
                }
                MyGiftListModel.this.f16140i = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, boolean z, d.a.n0.v0.c.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.f16138g = false;
        this.f16140i = true;
        this.j = 0L;
        a aVar = new a(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.n = aVar;
        this.f16139h = true;
        this.k = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
        d.a.n0.e3.d0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
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
        this.f16137f = i2;
        return getPersonalGiftListRequest;
    }

    public boolean C() {
        return this.f16139h;
    }

    public final void D() {
        GetPersonalGiftListRequest B;
        if (!this.f16138g) {
            B = B(1, this.j);
        } else {
            B = B(this.f16137f + 1, this.j);
        }
        sendMessage(B);
    }

    public boolean E() {
        return this.f16136e;
    }

    public final void F(d.a.n0.v0.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.n0.v0.c.a();
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
        d.a.n0.v0.c.a aVar2 = this.l;
        aVar2.f65949h = aVar.f65949h;
        aVar2.f65947f = aVar.f65947f;
        if (aVar.f65948g != null) {
            aVar2.f65948g = new j0();
            j0 j0Var = this.l.f65948g;
            j0 j0Var2 = aVar.f65948g;
            j0Var.f53732a = j0Var2.f53732a;
            j0Var.f53733b = j0Var2.f53733b;
        }
        if (this.l.c() != null) {
            this.f16137f = this.l.c().f65959a;
            this.f16136e = this.l.c().f65960b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f16138g) {
            ArrayList<a.C1740a> a2 = aVar.a();
            int size = this.l.a().size() + 1;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a.C1740a c1740a = a2.get(i2);
                if (c1740a != null) {
                    c1740a.j = size;
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
        this.f16138g = z;
    }

    public void J(boolean z) {
        this.f16139h = z;
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
