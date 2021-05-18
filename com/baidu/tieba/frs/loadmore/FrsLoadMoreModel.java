package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.j.e.n;
import d.a.j0.m0.h;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.j0.z0.c0;
import d.a.k0.d3.h0.f;
import d.a.k0.q0.e2.c;
import d.a.k0.q0.e2.k;
import d.a.k0.s2.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.k0.q0.d2.a f15728e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15729f;

    /* renamed from: g  reason: collision with root package name */
    public long f15730g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<n> f15731h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<String> f15732i;
    public boolean isLoading;
    public final ArrayList<n> j;
    public int k;
    public int l;
    public int loadIndex;
    public boolean loadingDone;
    public int m;
    public boolean n;
    public long o;
    public int p;
    public k q;
    public c.b r;
    public d.a.k0.s0.a s;
    public final d.a.c.c.g.a t;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (FrsLoadMoreModel.this.f15728e == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = FrsLoadMoreModel.this;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.f15728e.onFailed(FrsLoadMoreModel.this.f15728e.getPageContext().getString(R.string.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    FrsLoadMoreModel.this.f15728e.onFailed(responsedMessage.getErrorString());
                } else {
                    FrsLoadMoreModel.this.f15728e.onFailed(FrsLoadMoreModel.this.f15728e.getPageContext().getString(R.string.neterror));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData g0 = FrsLoadMoreModel.this.f15728e.g0();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (g0 != null) {
                        g0.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    FrsLoadMoreModel.this.f15728e.a(loadMoreHttpResponseMessage.getThreadList());
                    if (FrsLoadMoreModel.this.f15728e instanceof FrsFragment) {
                        ((FrsFragment) FrsLoadMoreModel.this.f15728e).H = System.currentTimeMillis() - currentTimeMillis;
                        FrsLoadMoreModel.this.C(true, responsedMessage);
                    }
                    FrsLoadMoreModel.this.B(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (g0 != null) {
                        g0.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    FrsLoadMoreModel.this.f15728e.a(loadMoreResponseSocketMessage.getThreadList());
                    if (FrsLoadMoreModel.this.f15728e instanceof FrsFragment) {
                        ((FrsFragment) FrsLoadMoreModel.this.f15728e).H = System.currentTimeMillis() - currentTimeMillis;
                        FrsLoadMoreModel.this.C(false, responsedMessage);
                    }
                    FrsLoadMoreModel.this.D(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(FrsLoadMoreModel.this.f15728e.g()) && x.p().b() != null) {
                    x.p().b().g(FrsLoadMoreModel.this.f15728e.g(), 2, false);
                }
                FrsLoadMoreModel.this.loadIndex++;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(d.a.k0.q0.d2.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.f15729f = false;
        this.f15730g = 0L;
        this.f15731h = new ArrayList<>();
        this.f15732i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.l = 1;
        this.m = -1;
        this.n = false;
        this.p = 1;
        this.t = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.f15728e = aVar;
        setUniqueId(aVar.getUniqueId());
        this.q = kVar;
        this.t.getHttpMessageListener().setSelfListener(true);
        this.t.getSocketMessageListener().setSelfListener(true);
        registerListener(this.t);
    }

    public int A() {
        return this.m;
    }

    public final void B(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        if (this.f15729f) {
            return;
        }
        this.f15729f = true;
        if (d.a.j0.m0.k.d().g()) {
            new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f15730g).c();
        }
    }

    public void C(boolean z, ResponsedMessage<?> responsedMessage) {
        if (d.a.j0.m0.k.d().g() && (this.f15728e instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f15730g;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.f15728e).H, false, 0L, 0L, currentTimeMillis);
            hVar.B = currentTimeMillis;
            hVar.e(true);
        }
    }

    public final void D(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        if (this.f15729f) {
            return;
        }
        this.f15729f = true;
        if (d.a.j0.m0.k.d().g()) {
            new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f15730g).c();
        }
    }

    public void E(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f15731h)) {
            F(this.f15731h, str);
        }
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        F(this.j, str);
    }

    public final void F(ArrayList<n> arrayList, String str) {
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.k0.e.c) {
                d.a.k0.e.c cVar = (d.a.k0.e.c) next;
                if ((cVar.c() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.c()).F3)) {
                    it.remove();
                }
            }
        }
    }

    public void G(n nVar) {
        if (nVar == null) {
            return;
        }
        ArrayList<n> arrayList = this.f15731h;
        if (arrayList != null) {
            arrayList.remove(nVar);
        }
        ArrayList<n> arrayList2 = this.j;
        if (arrayList2 != null) {
            arrayList2.remove(nVar);
        }
    }

    public ArrayList<n> H() {
        int i2;
        int size = this.j.size() + 30;
        int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
        if (size > a2 && this.j.size() > (i2 = size - a2)) {
            for (int i3 = 0; i3 < i2; i3++) {
                this.j.remove(0);
            }
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.f15731h);
        arrayList.addAll(this.j);
        return arrayList;
    }

    public void I(long j, List<Long> list, String str, int i2, boolean z, String str2) {
        if (j != 0 && !ListUtils.isEmpty(list)) {
            String z2 = z(list);
            if (TextUtils.isEmpty(z2)) {
                return;
            }
            this.o = j;
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(z2);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i2);
            loadMoreRequestMessage.setLastClickTid(d.a.c.e.m.b.f(c0.a(), 0L));
            loadMoreRequestMessage.setSortType(this.k);
            loadMoreRequestMessage.setPageType(this.p);
            loadMoreRequestMessage.setAdFloorInfo(str2);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                v(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.f15730g = System.currentTimeMillis();
            return;
        }
        this.loadingDone = true;
    }

    public void J() {
        this.loadIndex = 0;
        this.loadingDone = false;
        this.f15731h.clear();
        this.f15732i.clear();
        this.j.clear();
        this.m = -1;
        this.l = 1;
    }

    public void K(d.a.k0.s0.a aVar) {
        this.s = aVar;
    }

    public void L(boolean z) {
        this.n = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(int i2) {
        this.m = i2;
    }

    public void N(c.b bVar) {
        this.r = bVar;
    }

    public void O(int i2) {
        this.p = i2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public int getPn() {
        return this.l;
    }

    public void registerListener() {
        registerListener(this.t);
    }

    public void setPn(int i2) {
        this.l = i2;
    }

    public void setSortType(int i2) {
        this.k = i2;
    }

    public final void v(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (x.p().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(x.p().b().e(str, false) + 1);
    }

    public boolean w(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public void x() {
        int i2;
        int size = this.j.size() + 30;
        int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
        int count = ListUtils.getCount(this.f15731h);
        if (size <= a2 || this.j.size() <= (i2 = size - a2)) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.add(this.j.remove(0));
            ArrayList<n> arrayList2 = null;
            d.a.k0.q0.d2.a aVar = this.f15728e;
            if (aVar != null && aVar.g0() != null) {
                arrayList2 = this.f15728e.g0().switchThreadDataToThreadCardInfo(arrayList);
            }
            if (arrayList2 != null) {
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    c.b bVar = this.r;
                    if (bVar != null) {
                        bVar.removeItem(count + i4);
                    }
                }
            }
        }
    }

    public ArrayList<n> y(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, f fVar) {
        if (z3) {
            this.f15731h.clear();
            this.f15732i.clear();
            this.j.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<n> it = this.f15731h.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                if (a2Var.x1() != null) {
                    hashSet.add(a2Var.x1());
                }
            } else if (next instanceof a2) {
                a2 a2Var2 = (a2) next;
                if (a2Var2.x1() != null) {
                    hashSet.add(a2Var2.x1());
                }
            }
        }
        ArrayList<n> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<n> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof z1) {
                    z1 z1Var = (z1) next2;
                    a2 a2Var3 = z1Var.w;
                    a2Var3.A3(this.f15728e.g());
                    d.a.k0.q0.d2.a aVar = this.f15728e;
                    if (aVar != null && aVar.g0() != null && this.f15728e.g0().getForum() != null) {
                        if (!StringUtils.isNull(this.f15728e.g0().getForum().getFirst_class())) {
                            a2Var3.x3(this.f15728e.g0().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.f15728e.g0().getForum().getSecond_class())) {
                            a2Var3.f4(this.f15728e.g0().getForum().getSecond_class());
                        }
                    }
                    if (a2Var3.n2()) {
                        if (!hashSet.contains(a2Var3.x1())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(z1Var.w.A)) {
                                arrayList3.add(z1Var.w.A);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(z1Var.w.A)) {
                            arrayList3.add(z1Var.w.A);
                        }
                    }
                } else if (next2 instanceof a2) {
                    a2 a2Var4 = (a2) next2;
                    a2Var4.A3(this.f15728e.g());
                    d.a.k0.q0.d2.a aVar2 = this.f15728e;
                    if (aVar2 != null && aVar2.g0() != null && this.f15728e.g0().getForum() != null) {
                        if (!StringUtils.isNull(this.f15728e.g0().getForum().getFirst_class())) {
                            a2Var4.x3(this.f15728e.g0().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.f15728e.g0().getForum().getSecond_class())) {
                            a2Var4.f4(this.f15728e.g0().getForum().getSecond_class());
                        }
                    }
                    if (a2Var4.n2()) {
                        if (!hashSet.contains(a2Var4.x1())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(a2Var4.A)) {
                                arrayList3.add(a2Var4.A);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(a2Var4.A)) {
                            arrayList3.add(a2Var4.A);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.q != null) {
            this.q.a(this.k, z2, arrayList2.size(), z, arrayList2, false);
        }
        if (d.a.k0.s0.a.d()) {
            d.a.k0.s0.a aVar3 = this.s;
            if (aVar3 != null) {
                aVar3.b(arrayList2, z3, String.valueOf(this.o));
            }
        } else {
            d.a.k0.q0.d2.a aVar4 = this.f15728e;
            if (aVar4 != null) {
                FrsViewData g0 = aVar4.g0();
                if (this.n && g0 != null && (this.f15728e instanceof d.a.k0.e.e.b)) {
                    ArrayList<n> arrayList4 = new ArrayList<>(this.f15731h);
                    arrayList4.addAll(this.j);
                    g0.addRecommendAppToThreadList((d.a.k0.e.e.b) this.f15728e, true, arrayList2, arrayList4, z2);
                }
            }
        }
        int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.f15731h.size();
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < b2) {
                this.f15731h.add(arrayList2.get(i2));
            } else {
                this.j.add(arrayList2.get(i2));
            }
        }
        ArrayList<n> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.f15731h);
        arrayList5.addAll(this.j);
        d.a.k0.q0.d2.a aVar5 = this.f15728e;
        if (aVar5 instanceof d.a.k0.e.e.b) {
            d.a.k0.q0.n2.a.b((d.a.k0.e.e.b) aVar5, aVar5.g0(), arrayList2, getPn());
            d.a.k0.q0.n2.a.c(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public final String z(List<Long> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            int i2 = 0;
            int i3 = this.loadIndex;
            if (i3 == 0) {
                size = 30;
            } else if (i3 != 1) {
                return "";
            } else {
                i2 = 30;
            }
            if (size > list.size()) {
                size = list.size();
            }
            if (i2 >= list.size()) {
                this.loadingDone = true;
                return "";
            }
            while (i2 < size) {
                if (i2 == list.size() - 1) {
                    this.loadingDone = true;
                }
                Long l = list.get(i2);
                if (l != null) {
                    if (i2 == size - 1) {
                        sb.append(l);
                    } else {
                        sb.append(l);
                        sb.append(",");
                    }
                }
                i2++;
            }
            return sb.toString();
        }
        this.loadingDone = true;
        return "";
    }
}
