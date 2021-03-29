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
import d.b.b.e.p.k;
import d.b.i0.i0.i.c.c;
import d.b.i0.i0.i.d.a;
/* loaded from: classes4.dex */
public class HotUserRankFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f15424e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f15425f;

    /* renamed from: g  reason: collision with root package name */
    public String f15426g;

    /* renamed from: h  reason: collision with root package name */
    public long f15427h;
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
                HotUserRankFragment.this.f15425f.i();
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
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f15424e);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.j.f() == 2) {
                    if (HotUserRankFragment.this.f15427h <= 0 && !TextUtils.isEmpty(HotUserRankFragment.this.f15426g)) {
                        if (cVar.f55608a != null) {
                            if (HotUserRankFragment.this.i) {
                                cVar.f55608a.f55594a = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.f15426g);
                            } else {
                                cVar.f55608a.f55594a = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.f15426g);
                            }
                        }
                    } else {
                        cVar.f55608a.f55594a = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    }
                    HotUserRankFragment.this.f15425f.f(cVar.f55608a, !k.isEmpty(HotUserRankFragment.this.f15426g));
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.j.g() != null) {
                    HotUserRankFragment.this.f15425f.h(HotUserRankFragment.this.j.g().f55609b);
                }
                if (HotUserRankFragment.this.j.j()) {
                    return;
                }
                HotUserRankFragment.this.f15425f.j(HotUserRankFragment.this.f15426g);
            }
        }

        @Override // d.b.i0.i0.i.d.a.b
        public void onError(int i, String str) {
            HotUserRankFragment hotUserRankFragment = HotUserRankFragment.this;
            hotUserRankFragment.hideLoadingView(hotUserRankFragment.f15424e);
            HotUserRankFragment hotUserRankFragment2 = HotUserRankFragment.this;
            hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f15424e, str, false);
        }
    }

    public d.b.i0.i0.i.d.a O0() {
        return this.j;
    }

    public final void P0() {
        if (!TextUtils.isEmpty(this.f15426g)) {
            this.j.i(this.f15426g);
            return;
        }
        long j = this.f15427h;
        if (j > 0) {
            this.j.h(j);
        }
    }

    public void Q0(String str) {
        this.f15426g = str;
    }

    public void R0(long j) {
        this.f15427h = j;
    }

    public void S0(boolean z) {
        this.i = z;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f15425f.e(i);
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
        if (this.f15424e == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.f15424e = inflate;
            RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f15426g, this.f15427h);
            this.f15425f = rankListViewController;
            rankListViewController.g(this.k);
        }
        if (this.j.g() == null || ListUtils.isEmpty(this.j.g().f55609b)) {
            P0();
            showLoadingView(this.f15424e);
        }
        return this.f15424e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.j.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f15424e);
        P0();
        showLoadingView(this.f15424e);
    }
}
