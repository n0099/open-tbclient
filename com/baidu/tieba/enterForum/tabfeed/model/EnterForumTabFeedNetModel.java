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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.j1;
import d.a.n0.r.q.u1;
import d.a.n0.r.q.z1;
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
    public boolean f14692e;

    /* renamed from: f  reason: collision with root package name */
    public int f14693f;

    /* renamed from: g  reason: collision with root package name */
    public String f14694g;

    /* renamed from: h  reason: collision with root package name */
    public String f14695h;

    /* renamed from: i  reason: collision with root package name */
    public int f14696i;
    public boolean j;
    public d.a.o0.j0.l.b k;
    public int l;
    public HashMap<String, Integer> m;
    public d.a.o0.j0.l.d.b n;
    public d.a.o0.j0.l.d.a o;
    public a2 p;
    public d.a.c.c.g.a q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final d.a.c.c.g.a u;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.o0.j0.l.d.a aVar;
            EnterForumTabFeedNetModel.this.f14692e = false;
            if (responsedMessage == null || EnterForumTabFeedNetModel.this.n == null || EnterForumTabFeedNetModel.this.n.f59889b == null) {
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
                if (EnterForumTabFeedNetModel.this.m != null && EnterForumTabFeedNetModel.this.m.containsKey(EnterForumTabFeedNetModel.this.p.z1())) {
                    EnterForumTabFeedNetModel.this.m.remove(EnterForumTabFeedNetModel.this.p.z1());
                }
                EnterForumTabFeedNetModel.this.p = null;
            }
            EnterForumTabFeedNetModel.this.R(aVar, true);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EnterForumTabFeedNetModel.this.N(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EnterForumTabFeedNetModel.this.N(customResponsedMessage);
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
            int i2 = u1Var.f53918g;
            int i3 = u1Var2.f53918g;
            if (i2 == i3) {
                return 0;
            }
            return i2 > i3 ? 1 : -1;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof j1)) {
                return;
            }
            j1 j1Var = (j1) customResponsedMessage.getData();
            if (j1Var.f53841a == 2 && (str = j1Var.f53842b) != null && str.equals(EnterForumTabFeedNetModel.this.f14694g)) {
                int k = l.k(TbadkCoreApplication.getInst());
                int i2 = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(EnterForumTabFeedNetModel.this.getUniqueId());
                requestGetMyPostNetMessage.setParams(d.a.c.e.m.b.f(j1Var.f53843c, 0L), 0L, 0L, k, i2, f2, i3);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.c.c.g.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
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
            a2Var.V2(responseData.data.thread_info);
            EnterForumTabFeedNetModel.this.p = a2Var;
            if (EnterForumTabFeedNetModel.this.o != null) {
                EnterForumTabFeedNetModel.this.refresh();
            }
        }
    }

    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, d.a.o0.j0.l.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.f14692e = false;
        this.f14693f = 1;
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
        this.n = new d.a.o0.j0.l.d.b();
        this.k = bVar;
        this.f14696i = d.a.n0.r.d0.b.j().k("home_page_max_thread_count", 300);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public final int M() {
        int i2;
        a2 a2Var;
        d.a.o0.j0.l.d.b bVar = this.n;
        if (bVar != null && bVar.f59889b != null) {
            int i3 = this.j ? this.l - 60 : 30;
            int i4 = i3 + 30;
            if (i3 >= 0 && i3 <= (i2 = this.l) && i4 >= 0 && i4 <= i2 && i4 >= i3) {
                int i5 = -1;
                int i6 = 0;
                int i7 = -1;
                while (true) {
                    if (i6 >= this.n.f59889b.size()) {
                        break;
                    }
                    n nVar = this.n.f59889b.get(i6);
                    if (nVar instanceof z1) {
                        if (i7 == -1 && ((z1) nVar).position > i3) {
                            i7 = i6;
                        } else if (((z1) nVar).position > i4) {
                            i5 = i6;
                            break;
                        }
                        if (i7 > 0 && (a2Var = ((z1) nVar).w) != null) {
                            this.m.remove(a2Var.z1());
                        }
                    }
                    i6++;
                }
                if (i7 < i5 && i5 >= 0 && i7 >= 0) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    arrayList.addAll(this.n.f59889b.subList(0, i7));
                    ArrayList<n> arrayList2 = this.n.f59889b;
                    arrayList.addAll(arrayList2.subList(i5, arrayList2.size()));
                    this.n.f59889b = arrayList;
                    return i5 - i7;
                }
            }
        }
        return 0;
    }

    public final void N(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.o0.j0.l.d.b bVar;
        z1 z1Var;
        a2 a2Var;
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.l <= 0 || (bVar = this.n) == null || ListUtils.isEmpty(bVar.f59889b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.m.containsKey(optString)) {
            return;
        }
        Iterator<n> it = this.n.f59889b.iterator();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof z1) && (a2Var = (z1Var = (z1) next).w) != null) {
                if (i3 >= 0) {
                    if (z1Var.position != i3) {
                        break;
                    }
                    it.remove();
                    i5 = i2;
                } else if (StringHelper.equals(optString, a2Var.z1())) {
                    i3 = z1Var.position;
                    it.remove();
                    i4 = i2;
                }
            }
            i2++;
        }
        if (i4 < i5) {
            this.k.X(i4, i5);
        }
    }

    public final ArrayList<n> O(ArrayList<n> arrayList) {
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

    public final void P(ArrayList<n> arrayList, ArrayList<u1> arrayList2) {
        T();
        if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
            return;
        }
        Collections.sort(arrayList2, new d(this));
        int i2 = 0;
        Iterator<u1> it = arrayList2.iterator();
        while (it.hasNext()) {
            u1 next = it.next();
            int i3 = next.f53918g + i2;
            if (TextUtils.isEmpty(next.f53916e) || TextUtils.isEmpty(next.f53917f) || next.f53918g == 0 || i3 > arrayList.size()) {
                return;
            }
            arrayList.add(i3, next);
            i2++;
        }
    }

    public final void Q(int i2) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i2;
        tabFeedListRequestMessage.tabCode = this.f14695h;
        tabFeedListRequestMessage.tabName = this.f14694g;
        if (i2 == 2) {
            tabFeedListRequestMessage.pn = this.f14693f + 1;
        } else if (i2 != 1) {
            return;
        } else {
            tabFeedListRequestMessage.pn = 1;
        }
        this.f14692e = true;
        sendMessage(tabFeedListRequestMessage);
    }

    public final void R(d.a.o0.j0.l.d.a aVar, boolean z) {
        if (aVar == null || this.n == null) {
            return;
        }
        ArrayList<n> e2 = aVar.e();
        d.a.o0.j0.l.d.b bVar = this.n;
        boolean z2 = this.j;
        bVar.f59895h = z2;
        if (!z2) {
            this.f14693f++;
        } else {
            bVar.f59893f = z ? ListUtils.getCount(e2) : -1;
            P(e2, aVar.d());
        }
        if (this.l + ListUtils.getCount(e2) > this.f14696i) {
            this.n.f59892e = M();
        }
        ArrayList<n> V = V(e2);
        O(V);
        if (this.j) {
            this.n.f59889b.addAll(0, V);
            this.n.f59892e = 0;
        } else {
            this.n.f59889b.addAll(V);
            this.n.f59890c = !ListUtils.isEmpty(e2);
        }
        this.n.f59891d = aVar.f();
        this.n.f59894g = aVar.b();
        this.n.f59888a = aVar.c();
        d.a.o0.j0.l.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.v0(this.n);
        }
    }

    public void S() {
        registerListener(this.t);
    }

    public final void T() {
        if (ListUtils.isEmpty(this.n.f59889b)) {
            return;
        }
        int i2 = 0;
        Iterator<n> it = this.n.f59889b.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof u1) {
                it.remove();
            }
            i2++;
            if (i2 > 93) {
                return;
            }
        }
    }

    public void U(String str, String str2) {
        this.f14695h = str;
        this.f14694g = str2;
    }

    public final ArrayList<n> V(ArrayList<n> arrayList) {
        int i2 = this.l;
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof u1) {
                arrayList2.add(next);
            } else if (next instanceof a2) {
                a2 a2Var = (a2) next;
                if (!this.m.containsKey(a2Var.z1())) {
                    this.m.put(a2Var.z1(), 0);
                    a2Var.a2 = true;
                    int[] p0 = a2Var.p0();
                    if (a2Var.getType() == a2.M2) {
                        z1 z1Var = new z1();
                        z1Var.w = a2Var;
                        z1Var.position = i2;
                        z1Var.f53980e = true;
                        arrayList2.add(z1Var);
                        z1 z1Var2 = new z1();
                        z1Var2.w = a2Var;
                        z1Var2.position = i2;
                        if (a2Var.S1()) {
                            z1Var2.j = true;
                        } else if (a2Var.a3() == 1) {
                            z1Var2.f53983h = true;
                            z1Var2.x = p0[0];
                            z1Var2.y = p0[1];
                        } else if (a2Var.a3() >= 2) {
                            z1Var2.f53984i = true;
                        } else {
                            z1Var2.f53981f = true;
                        }
                        arrayList2.add(z1Var2);
                        if (a2Var.z0() != null) {
                            z1 z1Var3 = new z1();
                            z1Var3.r = true;
                            z1Var3.w = a2Var;
                            z1Var3.position = i2;
                            arrayList2.add(z1Var3);
                        }
                        if (!ListUtils.isEmpty(a2Var.H0()) || !ListUtils.isEmpty(a2Var.l0())) {
                            z1 z1Var4 = new z1();
                            z1Var4.w = a2Var;
                            z1Var4.position = i2;
                            if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                                z1Var4.t = true;
                            } else if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                                z1Var4.u = true;
                            }
                            arrayList2.add(z1Var4);
                        }
                        z1 z1Var5 = new z1();
                        z1Var5.q = true;
                        z1Var5.w = a2Var;
                        z1Var5.position = i2;
                        arrayList2.add(z1Var5);
                        z1 z1Var6 = new z1();
                        z1Var6.k = true;
                        z1Var6.w = a2Var;
                        z1Var6.position = i2;
                        arrayList2.add(z1Var6);
                    } else if (a2Var.getType() == a2.j3) {
                        z1 z1Var7 = new z1();
                        z1Var7.w = a2Var;
                        z1Var7.position = i2;
                        z1Var7.f53980e = true;
                        arrayList2.add(z1Var7);
                        z1 z1Var8 = new z1();
                        z1Var8.w = a2Var;
                        z1Var8.position = i2;
                        z1Var8.m = true;
                        arrayList2.add(z1Var8);
                        if (a2Var.z0() != null) {
                            z1 z1Var9 = new z1();
                            z1Var9.r = true;
                            z1Var9.w = a2Var;
                            z1Var9.position = i2;
                            arrayList2.add(z1Var9);
                        }
                        if (!ListUtils.isEmpty(a2Var.H0()) || !ListUtils.isEmpty(a2Var.l0())) {
                            z1 z1Var10 = new z1();
                            z1Var10.w = a2Var;
                            z1Var10.position = i2;
                            if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                                z1Var10.t = true;
                            } else if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                                z1Var10.u = true;
                            }
                            arrayList2.add(z1Var10);
                        }
                        z1 z1Var11 = new z1();
                        z1Var11.q = true;
                        z1Var11.w = a2Var;
                        z1Var11.position = i2;
                        arrayList2.add(z1Var11);
                        z1 z1Var12 = new z1();
                        z1Var12.k = true;
                        z1Var12.w = a2Var;
                        z1Var12.position = i2;
                        arrayList2.add(z1Var12);
                    } else if (a2Var.getType() == a2.b3 && a2Var.R1()) {
                        a2Var.position = i2;
                        arrayList2.add(a2Var);
                    } else {
                        z1 z1Var13 = new z1();
                        z1Var13.w = a2Var;
                        z1Var13.position = i2;
                        arrayList2.add(z1Var13);
                    }
                    i2++;
                }
            }
        }
        this.l = i2;
        d.a.n0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    public boolean b() {
        d.a.o0.j0.l.d.b bVar = this.n;
        if (bVar == null) {
            return false;
        }
        return !ListUtils.isEmpty(bVar.f59889b);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f14692e = false;
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.q);
    }

    public void loadMore() {
        if (this.f14692e) {
            return;
        }
        this.j = false;
        Q(2);
    }

    public void refresh() {
        if (this.f14692e) {
            return;
        }
        this.j = true;
        Q(1);
    }
}
