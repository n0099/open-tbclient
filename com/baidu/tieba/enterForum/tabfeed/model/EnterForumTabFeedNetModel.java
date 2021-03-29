package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.j1;
import d.b.h0.r.q.u1;
import d.b.h0.r.q.z1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes4.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f15530e;

    /* renamed from: f  reason: collision with root package name */
    public int f15531f;

    /* renamed from: g  reason: collision with root package name */
    public String f15532g;

    /* renamed from: h  reason: collision with root package name */
    public String f15533h;
    public int i;
    public boolean j;
    public d.b.i0.i0.l.b k;
    public int l;
    public HashMap<String, Integer> m;
    public d.b.i0.i0.l.d.b n;
    public d.b.i0.i0.l.d.a o;
    public a2 p;
    public d.b.b.c.g.a q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final d.b.b.c.g.a u;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.i0.l.d.a aVar;
            EnterForumTabFeedNetModel.this.f15530e = false;
            if (responsedMessage == null || EnterForumTabFeedNetModel.this.n == null || EnterForumTabFeedNetModel.this.n.f55708b == null) {
                return;
            }
            if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
            } else {
                aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
            }
            EnterForumTabFeedNetModel.this.o = aVar;
            EnterForumTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
            EnterForumTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(EnterForumTabFeedNetModel.this.mErrorCode);
            errorData.setError_msg(EnterForumTabFeedNetModel.this.mErrorString);
            if (EnterForumTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                EnterForumTabFeedNetModel.this.k.onServerError(errorData);
                return;
            }
            if (aVar != null && EnterForumTabFeedNetModel.this.p != null) {
                aVar.e().add(0, EnterForumTabFeedNetModel.this.p);
                if (EnterForumTabFeedNetModel.this.m != null && EnterForumTabFeedNetModel.this.m.containsKey(EnterForumTabFeedNetModel.this.p.w1())) {
                    EnterForumTabFeedNetModel.this.m.remove(EnterForumTabFeedNetModel.this.p.w1());
                }
                EnterForumTabFeedNetModel.this.p = null;
            }
            EnterForumTabFeedNetModel.this.P(aVar, true);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EnterForumTabFeedNetModel.this.J(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EnterForumTabFeedNetModel.this.J(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Comparator<u1> {
        public d(EnterForumTabFeedNetModel enterForumTabFeedNetModel) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(u1 u1Var, u1 u1Var2) {
            int i = u1Var.f50896g;
            int i2 = u1Var2.f50896g;
            if (i == i2) {
                return 0;
            }
            return i > i2 ? 1 : -1;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof j1)) {
                return;
            }
            j1 j1Var = (j1) customResponsedMessage.getData();
            if (j1Var.f50823a == 2 && (str = j1Var.f50824b) != null && str.equals(EnterForumTabFeedNetModel.this.f15532g)) {
                int k = l.k(TbadkCoreApplication.getInst());
                int i = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                requestGetMyPostNetMessage.setParams(d.b.b.e.m.b.f(j1Var.f50825c, 0L), 0L, 0L, k, i, f2, i2);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.b.b.c.g.a {
        public f(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            DataRes dataRes;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responseData == null || (dataRes = responseData.data) == null || dataRes.thread_info == null) {
                return;
            }
            a2 a2Var = new a2();
            a2Var.Q2(responseData.data.thread_info);
            EnterForumTabFeedNetModel.this.p = a2Var;
            if (EnterForumTabFeedNetModel.this.o != null) {
                EnterForumTabFeedNetModel.this.Q();
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, d.b.i0.i0.l.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.f15530e = false;
        this.f15531f = 1;
        this.j = true;
        this.q = new a(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651);
        this.r = new b(2016488);
        this.s = new c(2016553);
        this.t = new e(2921453);
        this.u = new f(CmdConfigHttp.CMD_GET_MY_POST, 303111);
        setUniqueId(bdUniqueId);
        this.q.getHttpMessageListener().setSelfListener(true);
        this.q.getSocketMessageListener().setSelfListener(true);
        registerListener(this.q);
        this.m = new HashMap<>();
        this.n = new d.b.i0.i0.l.d.b();
        this.k = bVar;
        this.i = d.b.h0.r.d0.b.i().j("home_page_max_thread_count", 300);
        registerListener(this.r);
        registerListener(this.s);
        this.u.setTag(getUniqueId());
        if (this.u.getHttpMessageListener() != null) {
            this.u.getHttpMessageListener().setSelfListener(true);
        }
        if (this.u.getSocketMessageListener() != null) {
            this.u.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.u);
    }

    public final int I() {
        int i;
        a2 a2Var;
        d.b.i0.i0.l.d.b bVar = this.n;
        if (bVar != null && bVar.f55708b != null) {
            int i2 = this.j ? this.l - 60 : 30;
            int i3 = i2 + 30;
            if (i2 >= 0 && i2 <= (i = this.l) && i3 >= 0 && i3 <= i && i3 >= i2) {
                int i4 = -1;
                int i5 = 0;
                int i6 = -1;
                while (true) {
                    if (i5 >= this.n.f55708b.size()) {
                        break;
                    }
                    n nVar = this.n.f55708b.get(i5);
                    if (nVar instanceof z1) {
                        if (i6 == -1 && ((z1) nVar).position > i2) {
                            i6 = i5;
                        } else if (((z1) nVar).position > i3) {
                            i4 = i5;
                            break;
                        }
                        if (i6 > 0 && (a2Var = ((z1) nVar).w) != null) {
                            this.m.remove(a2Var.w1());
                        }
                    }
                    i5++;
                }
                if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    arrayList.addAll(this.n.f55708b.subList(0, i6));
                    ArrayList<n> arrayList2 = this.n.f55708b;
                    arrayList.addAll(arrayList2.subList(i4, arrayList2.size()));
                    this.n.f55708b = arrayList;
                    return i4 - i6;
                }
            }
        }
        return 0;
    }

    public final void J(CustomResponsedMessage<?> customResponsedMessage) {
        d.b.i0.i0.l.d.b bVar;
        z1 z1Var;
        a2 a2Var;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.l <= 0 || (bVar = this.n) == null || ListUtils.isEmpty(bVar.f55708b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.m.containsKey(optString)) {
            return;
        }
        Iterator<n> it = this.n.f55708b.iterator();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof z1) && (a2Var = (z1Var = (z1) next).w) != null) {
                if (i2 >= 0) {
                    if (z1Var.position != i2) {
                        break;
                    }
                    it.remove();
                    i4 = i;
                } else if (StringHelper.equals(optString, a2Var.w1())) {
                    i2 = z1Var.position;
                    it.remove();
                    i3 = i;
                }
            }
            i++;
        }
        if (i3 < i4) {
            this.k.p(i3, i4);
        }
    }

    public final ArrayList<n> K(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            boolean z = true;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof u1)) {
                    z = false;
                }
            }
            if (z) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    public boolean L() {
        d.b.i0.i0.l.d.b bVar = this.n;
        if (bVar == null) {
            return false;
        }
        return !ListUtils.isEmpty(bVar.f55708b);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public final void M(ArrayList<n> arrayList, ArrayList<u1> arrayList2) {
        S();
        if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
            return;
        }
        Collections.sort(arrayList2, new d(this));
        int i = 0;
        Iterator<u1> it = arrayList2.iterator();
        while (it.hasNext()) {
            u1 next = it.next();
            int i2 = next.f50896g + i;
            if (TextUtils.isEmpty(next.f50894e) || TextUtils.isEmpty(next.f50895f) || next.f50896g == 0 || i2 > arrayList.size()) {
                return;
            }
            arrayList.add(i2, next);
            i++;
        }
    }

    public final void N(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.f15533h;
        tabFeedListRequestMessage.tabName = this.f15532g;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.f15531f + 1;
        } else if (i != 1) {
            return;
        } else {
            tabFeedListRequestMessage.pn = 1;
        }
        this.f15530e = true;
        sendMessage(tabFeedListRequestMessage);
    }

    public void O() {
        if (this.f15530e) {
            return;
        }
        this.j = false;
        N(2);
    }

    public final void P(d.b.i0.i0.l.d.a aVar, boolean z) {
        if (aVar == null || this.n == null) {
            return;
        }
        ArrayList<n> e2 = aVar.e();
        d.b.i0.i0.l.d.b bVar = this.n;
        boolean z2 = this.j;
        bVar.f55714h = z2;
        if (!z2) {
            this.f15531f++;
        } else {
            bVar.f55712f = z ? ListUtils.getCount(e2) : -1;
            M(e2, aVar.d());
        }
        if (this.l + ListUtils.getCount(e2) > this.i) {
            this.n.f55711e = I();
        }
        ArrayList<n> U = U(e2);
        K(U);
        if (this.j) {
            this.n.f55708b.addAll(0, U);
            this.n.f55711e = 0;
        } else {
            this.n.f55708b.addAll(U);
            this.n.f55709c = !ListUtils.isEmpty(e2);
        }
        this.n.f55710d = aVar.f();
        this.n.f55713g = aVar.b();
        this.n.f55707a = aVar.c();
        d.b.i0.i0.l.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.l0(this.n);
        }
    }

    public void Q() {
        if (this.f15530e) {
            return;
        }
        this.j = true;
        N(1);
    }

    public void R() {
        registerListener(this.t);
    }

    public final void S() {
        if (ListUtils.isEmpty(this.n.f55708b)) {
            return;
        }
        int i = 0;
        Iterator<n> it = this.n.f55708b.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof u1) {
                it.remove();
            }
            i++;
            if (i > 93) {
                return;
            }
        }
    }

    public void T(String str, String str2) {
        this.f15533h = str;
        this.f15532g = str2;
    }

    public final ArrayList<n> U(ArrayList<n> arrayList) {
        int i = this.l;
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof u1) {
                arrayList2.add(next);
            } else if (next instanceof a2) {
                a2 a2Var = (a2) next;
                if (!this.m.containsKey(a2Var.w1())) {
                    this.m.put(a2Var.w1(), 0);
                    a2Var.X1 = true;
                    int[] p0 = a2Var.p0();
                    if (a2Var.getType() == a2.H2) {
                        z1 z1Var = new z1();
                        z1Var.w = a2Var;
                        z1Var.position = i;
                        z1Var.f50954e = true;
                        arrayList2.add(z1Var);
                        z1 z1Var2 = new z1();
                        z1Var2.w = a2Var;
                        z1Var2.position = i;
                        if (a2Var.P1()) {
                            z1Var2.j = true;
                        } else if (a2Var.V2() == 1) {
                            z1Var2.f50957h = true;
                            z1Var2.x = p0[0];
                            z1Var2.y = p0[1];
                        } else if (a2Var.V2() >= 2) {
                            z1Var2.i = true;
                        } else {
                            z1Var2.f50955f = true;
                        }
                        arrayList2.add(z1Var2);
                        if (a2Var.y0() != null) {
                            z1 z1Var3 = new z1();
                            z1Var3.r = true;
                            z1Var3.w = a2Var;
                            z1Var3.position = i;
                            arrayList2.add(z1Var3);
                        }
                        if (!ListUtils.isEmpty(a2Var.G0()) || !ListUtils.isEmpty(a2Var.l0())) {
                            z1 z1Var4 = new z1();
                            z1Var4.w = a2Var;
                            z1Var4.position = i;
                            if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                                z1Var4.t = true;
                            } else if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                                z1Var4.u = true;
                            }
                            arrayList2.add(z1Var4);
                        }
                        z1 z1Var5 = new z1();
                        z1Var5.q = true;
                        z1Var5.w = a2Var;
                        z1Var5.position = i;
                        arrayList2.add(z1Var5);
                        z1 z1Var6 = new z1();
                        z1Var6.k = true;
                        z1Var6.w = a2Var;
                        z1Var6.position = i;
                        arrayList2.add(z1Var6);
                    } else if (a2Var.getType() == a2.e3) {
                        z1 z1Var7 = new z1();
                        z1Var7.w = a2Var;
                        z1Var7.position = i;
                        z1Var7.f50954e = true;
                        arrayList2.add(z1Var7);
                        z1 z1Var8 = new z1();
                        z1Var8.w = a2Var;
                        z1Var8.position = i;
                        z1Var8.m = true;
                        arrayList2.add(z1Var8);
                        if (a2Var.y0() != null) {
                            z1 z1Var9 = new z1();
                            z1Var9.r = true;
                            z1Var9.w = a2Var;
                            z1Var9.position = i;
                            arrayList2.add(z1Var9);
                        }
                        if (!ListUtils.isEmpty(a2Var.G0()) || !ListUtils.isEmpty(a2Var.l0())) {
                            z1 z1Var10 = new z1();
                            z1Var10.w = a2Var;
                            z1Var10.position = i;
                            if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                                z1Var10.t = true;
                            } else if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                                z1Var10.u = true;
                            }
                            arrayList2.add(z1Var10);
                        }
                        z1 z1Var11 = new z1();
                        z1Var11.q = true;
                        z1Var11.w = a2Var;
                        z1Var11.position = i;
                        arrayList2.add(z1Var11);
                        z1 z1Var12 = new z1();
                        z1Var12.k = true;
                        z1Var12.w = a2Var;
                        z1Var12.position = i;
                        arrayList2.add(z1Var12);
                    } else if (a2Var.getType() == a2.W2 && a2Var.O1()) {
                        a2Var.position = i;
                        arrayList2.add(a2Var);
                    } else {
                        z1 z1Var13 = new z1();
                        z1Var13.w = a2Var;
                        z1Var13.position = i;
                        arrayList2.add(z1Var13);
                    }
                    i++;
                }
            }
        }
        this.l = i;
        d.b.h0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f15530e = false;
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.q);
    }
}
