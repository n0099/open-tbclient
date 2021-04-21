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
import d.b.c.j.e.n;
import d.b.i0.m0.h;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.i0.z0.c0;
import d.b.j0.d3.h0.f;
import d.b.j0.q0.e2.c;
import d.b.j0.q0.e2.k;
import d.b.j0.s2.v;
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
    public final d.b.j0.q0.d2.a f16202e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16203f;

    /* renamed from: g  reason: collision with root package name */
    public long f16204g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<n> f16205h;
    public final ArrayList<String> i;
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
    public d.b.j0.s0.a s;
    public final d.b.c.c.g.a t;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (FrsLoadMoreModel.this.f16202e == null) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = FrsLoadMoreModel.this;
            frsLoadMoreModel.isLoading = false;
            if (responsedMessage == null) {
                frsLoadMoreModel.f16202e.onFailed(FrsLoadMoreModel.this.f16202e.getPageContext().getString(R.string.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    FrsLoadMoreModel.this.f16202e.onFailed(responsedMessage.getErrorString());
                } else {
                    FrsLoadMoreModel.this.f16202e.onFailed(FrsLoadMoreModel.this.f16202e.getPageContext().getString(R.string.neterror));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                FrsViewData S = FrsLoadMoreModel.this.f16202e.S();
                if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                    LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                    if (S != null) {
                        S.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                    }
                    FrsLoadMoreModel.this.f16202e.d(loadMoreHttpResponseMessage.getThreadList());
                    if (FrsLoadMoreModel.this.f16202e instanceof FrsFragment) {
                        ((FrsFragment) FrsLoadMoreModel.this.f16202e).H = System.currentTimeMillis() - currentTimeMillis;
                        FrsLoadMoreModel.this.C(true, responsedMessage);
                    }
                    FrsLoadMoreModel.this.B(loadMoreHttpResponseMessage);
                } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                    LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                    if (S != null) {
                        S.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                    }
                    FrsLoadMoreModel.this.f16202e.d(loadMoreResponseSocketMessage.getThreadList());
                    if (FrsLoadMoreModel.this.f16202e instanceof FrsFragment) {
                        ((FrsFragment) FrsLoadMoreModel.this.f16202e).H = System.currentTimeMillis() - currentTimeMillis;
                        FrsLoadMoreModel.this.C(false, responsedMessage);
                    }
                    FrsLoadMoreModel.this.D(loadMoreResponseSocketMessage);
                }
                if (!TextUtils.isEmpty(FrsLoadMoreModel.this.f16202e.i()) && v.p().b() != null) {
                    v.p().b().g(FrsLoadMoreModel.this.f16202e.i(), 2, false);
                }
                FrsLoadMoreModel.this.loadIndex++;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void d(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(d.b.j0.q0.d2.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.f16203f = false;
        this.f16204g = 0L;
        this.f16205h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.l = 1;
        this.m = -1;
        this.n = false;
        this.p = 1;
        this.t = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.f16202e = aVar;
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
        if (this.f16203f) {
            return;
        }
        this.f16203f = true;
        if (d.b.i0.m0.k.d().g()) {
            new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f16204g).c();
        }
    }

    public void C(boolean z, ResponsedMessage<?> responsedMessage) {
        if (d.b.i0.m0.k.d().g() && (this.f16202e instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f16204g;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.f16202e).H, false, 0L, 0L, currentTimeMillis);
            hVar.B = currentTimeMillis;
            hVar.e(true);
        }
    }

    public final void D(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        if (this.f16203f) {
            return;
        }
        this.f16203f = true;
        if (d.b.i0.m0.k.d().g()) {
            new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.f16204g).c();
        }
    }

    public void E(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f16205h)) {
            F(this.f16205h, str);
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
            if (next instanceof d.b.j0.e.c) {
                d.b.j0.e.c cVar = (d.b.j0.e.c) next;
                if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).E3)) {
                    it.remove();
                }
            }
        }
    }

    public void G(n nVar) {
        if (nVar == null) {
            return;
        }
        ArrayList<n> arrayList = this.f16205h;
        if (arrayList != null) {
            arrayList.remove(nVar);
        }
        ArrayList<n> arrayList2 = this.j;
        if (arrayList2 != null) {
            arrayList2.remove(nVar);
        }
    }

    public ArrayList<n> H() {
        int i;
        int size = this.j.size() + 30;
        int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
        if (size > a2 && this.j.size() > (i = size - a2)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.j.remove(0);
            }
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.f16205h);
        arrayList.addAll(this.j);
        return arrayList;
    }

    public void I(long j, List<Long> list, String str, int i, boolean z, String str2) {
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
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(d.b.c.e.m.b.f(c0.a(), 0L));
            loadMoreRequestMessage.setSortType(this.k);
            loadMoreRequestMessage.setPageType(this.p);
            loadMoreRequestMessage.setAdFloorInfo(str2);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                v(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.f16204g = System.currentTimeMillis();
            return;
        }
        this.loadingDone = true;
    }

    public void J() {
        this.loadIndex = 0;
        this.loadingDone = false;
        this.f16205h.clear();
        this.i.clear();
        this.j.clear();
        this.m = -1;
        this.l = 1;
    }

    public void K(d.b.j0.s0.a aVar) {
        this.s = aVar;
    }

    public void L(boolean z) {
        this.n = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(int i) {
        this.m = i;
    }

    public void N(c.b bVar) {
        this.r = bVar;
    }

    public void O(int i) {
        this.p = i;
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

    public void setPn(int i) {
        this.l = i;
    }

    public void setSortType(int i) {
        this.k = i;
    }

    public final void v(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (v.p().b() == null) {
            return;
        }
        loadMoreRequestMessage.setLoadCount(v.p().b().e(str, false) + 1);
    }

    public boolean w(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public void x() {
        int i;
        int size = this.j.size() + 30;
        int a2 = TbadkCoreApplication.getInst().getListItemRule().a() * 3;
        int count = ListUtils.getCount(this.f16205h);
        if (size <= a2 || this.j.size() <= (i = size - a2)) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList<n> arrayList = new ArrayList<>();
            arrayList.add(this.j.remove(0));
            ArrayList<n> arrayList2 = null;
            d.b.j0.q0.d2.a aVar = this.f16202e;
            if (aVar != null && aVar.S() != null) {
                arrayList2 = this.f16202e.S().switchThreadDataToThreadCardInfo(arrayList);
            }
            if (arrayList2 != null) {
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    c.b bVar = this.r;
                    if (bVar != null) {
                        bVar.removeItem(count + i3);
                    }
                }
            }
        }
    }

    public ArrayList<n> y(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, f fVar) {
        if (z3) {
            this.f16205h.clear();
            this.i.clear();
            this.j.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<n> it = this.f16205h.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                if (a2Var.w1() != null) {
                    hashSet.add(a2Var.w1());
                }
            } else if (next instanceof a2) {
                a2 a2Var2 = (a2) next;
                if (a2Var2.w1() != null) {
                    hashSet.add(a2Var2.w1());
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
                    a2Var3.y3(this.f16202e.i());
                    d.b.j0.q0.d2.a aVar = this.f16202e;
                    if (aVar != null && aVar.S() != null && this.f16202e.S().getForum() != null) {
                        if (!StringUtils.isNull(this.f16202e.S().getForum().getFirst_class())) {
                            a2Var3.v3(this.f16202e.S().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.f16202e.S().getForum().getSecond_class())) {
                            a2Var3.d4(this.f16202e.S().getForum().getSecond_class());
                        }
                    }
                    if (a2Var3.m2()) {
                        if (!hashSet.contains(a2Var3.w1())) {
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
                    a2Var4.y3(this.f16202e.i());
                    d.b.j0.q0.d2.a aVar2 = this.f16202e;
                    if (aVar2 != null && aVar2.S() != null && this.f16202e.S().getForum() != null) {
                        if (!StringUtils.isNull(this.f16202e.S().getForum().getFirst_class())) {
                            a2Var4.v3(this.f16202e.S().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.f16202e.S().getForum().getSecond_class())) {
                            a2Var4.d4(this.f16202e.S().getForum().getSecond_class());
                        }
                    }
                    if (a2Var4.m2()) {
                        if (!hashSet.contains(a2Var4.w1())) {
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
        if (d.b.j0.s0.a.d()) {
            d.b.j0.s0.a aVar3 = this.s;
            if (aVar3 != null) {
                aVar3.b(arrayList2, z3, String.valueOf(this.o));
            }
        } else {
            d.b.j0.q0.d2.a aVar4 = this.f16202e;
            if (aVar4 != null) {
                FrsViewData S = aVar4.S();
                if (this.n && S != null && (this.f16202e instanceof d.b.j0.e.e.b)) {
                    ArrayList<n> arrayList4 = new ArrayList<>(this.f16205h);
                    arrayList4.addAll(this.j);
                    S.addRecommendAppToThreadList((d.b.j0.e.e.b) this.f16202e, true, arrayList2, arrayList4, z2);
                }
            }
        }
        int b2 = TbadkCoreApplication.getInst().getListItemRule().b() - this.f16205h.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < b2) {
                this.f16205h.add(arrayList2.get(i));
            } else {
                this.j.add(arrayList2.get(i));
            }
        }
        ArrayList<n> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.f16205h);
        arrayList5.addAll(this.j);
        d.b.j0.q0.d2.a aVar5 = this.f16202e;
        if (aVar5 instanceof d.b.j0.e.e.b) {
            d.b.j0.q0.n2.a.b((d.b.j0.e.e.b) aVar5, aVar5.S(), arrayList2, getPn());
            d.b.j0.q0.n2.a.c(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public final String z(List<Long> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            int i = 0;
            int i2 = this.loadIndex;
            if (i2 == 0) {
                size = 30;
            } else if (i2 != 1) {
                return "";
            } else {
                i = 30;
            }
            if (size > list.size()) {
                size = list.size();
            }
            if (i >= list.size()) {
                this.loadingDone = true;
                return "";
            }
            while (i < size) {
                if (i == list.size() - 1) {
                    this.loadingDone = true;
                }
                Long l = list.get(i);
                if (l != null) {
                    if (i == size - 1) {
                        sb.append(l);
                    } else {
                        sb.append(l);
                        sb.append(",");
                    }
                }
                i++;
            }
            return sb.toString();
        }
        this.loadingDone = true;
        return "";
    }
}
