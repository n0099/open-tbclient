package com.baidu.tieba.enterForum.hotuserrank;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.i0.i0.i.c.c;
import d.b.i0.i0.i.d.a;
/* loaded from: classes4.dex */
public class HotUserRankFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f15087e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f15088f;

    /* renamed from: g  reason: collision with root package name */
    public String f15089g;

    /* renamed from: h  reason: collision with root package name */
    public long f15090h;
    public boolean i;
    public d.b.i0.i0.i.d.a j;
    public BdListView.p k = new a();
    public a.b l = new b();

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.j.j()) {
                HotUserRankFragment.this.P0();
                HotUserRankFragment.this.f15088f.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i0.i0.i.d.a.b
        public void a(c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment hotUserRankFragment = HotUserRankFragment.this;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f15087e);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.j.f() == 2) {
                    if (HotUserRankFragment.this.f15090h <= 0 && !TextUtils.isEmpty(HotUserRankFragment.this.f15089g)) {
                        if (cVar.f56731a != null) {
                            if (HotUserRankFragment.this.i) {
                                cVar.f56731a.f56717a = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.f15089g);
                            } else {
                                cVar.f56731a.f56717a = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.f15089g);
                            }
                        }
                    } else {
                        cVar.f56731a.f56717a = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    }
                    HotUserRankFragment.this.f15088f.f(cVar.f56731a, !k.isEmpty(HotUserRankFragment.this.f15089g));
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.j.g() != null) {
                    HotUserRankFragment.this.f15088f.h(HotUserRankFragment.this.j.g().f56732b);
                }
                if (HotUserRankFragment.this.j.j()) {
                    return;
                }
                HotUserRankFragment.this.f15088f.j(HotUserRankFragment.this.f15089g);
            }
        }

        @Override // d.b.i0.i0.i.d.a.b
        public void onError(int i, String str) {
            HotUserRankFragment hotUserRankFragment = HotUserRankFragment.this;
            hotUserRankFragment.hideLoadingView(hotUserRankFragment.f15087e);
            HotUserRankFragment hotUserRankFragment2 = HotUserRankFragment.this;
            hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f15087e, str, false);
        }
    }

    public d.b.i0.i0.i.d.a O0() {
        return this.j;
    }

    public final void P0() {
        if (!TextUtils.isEmpty(this.f15089g)) {
            this.j.i(this.f15089g);
            return;
        }
        long j = this.f15090h;
        if (j > 0) {
            this.j.h(j);
        }
    }

    public void Q0(String str) {
        this.f15089g = str;
    }

    public void R0(long j) {
        this.f15090h = j;
    }

    public void S0(boolean z) {
        this.i = z;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f15088f.e(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.i0.i0.i.d.a aVar = new d.b.i0.i0.i.d.a(getUniqueId());
        this.j = aVar;
        aVar.n(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f15087e == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.f15087e = inflate;
            RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f15089g, this.f15090h);
            this.f15088f = rankListViewController;
            rankListViewController.g(this.k);
        }
        if (this.j.g() == null || ListUtils.isEmpty(this.j.g().f56732b)) {
            P0();
            showLoadingView(this.f15087e);
        }
        return this.f15087e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.j.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f15087e);
        P0();
        showLoadingView(this.f15087e);
    }
}
