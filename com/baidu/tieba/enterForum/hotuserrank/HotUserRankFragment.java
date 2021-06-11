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
import d.a.c.e.p.k;
import d.a.n0.j0.i.c.c;
import d.a.n0.j0.i.d.a;
/* loaded from: classes4.dex */
public class HotUserRankFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f14494e;

    /* renamed from: f  reason: collision with root package name */
    public RankListViewController f14495f;

    /* renamed from: g  reason: collision with root package name */
    public String f14496g;

    /* renamed from: h  reason: collision with root package name */
    public long f14497h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14498i;
    public d.a.n0.j0.i.d.a j;
    public BdListView.p k = new a();
    public a.b l = new b();

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (HotUserRankFragment.this.j.j()) {
                HotUserRankFragment.this.R0();
                HotUserRankFragment.this.f14495f.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.n0.j0.i.d.a.b
        public void a(c cVar) {
            if (HotUserRankFragment.this.isLoadingViewAttached()) {
                HotUserRankFragment hotUserRankFragment = HotUserRankFragment.this;
                hotUserRankFragment.hideLoadingView(hotUserRankFragment.f14494e);
            }
            if (cVar != null) {
                if (HotUserRankFragment.this.j.f() == 2) {
                    if (HotUserRankFragment.this.f14497h <= 0 && !TextUtils.isEmpty(HotUserRankFragment.this.f14496g)) {
                        if (cVar.f59662a != null) {
                            if (HotUserRankFragment.this.f14498i) {
                                cVar.f59662a.f59648a = String.format(HotUserRankFragment.this.getResources().getString(R.string.god_rank_category_name), HotUserRankFragment.this.f14496g);
                            } else {
                                cVar.f59662a.f59648a = String.format(HotUserRankFragment.this.getResources().getString(R.string.hot_user_rank_category_name), HotUserRankFragment.this.f14496g);
                            }
                        }
                    } else {
                        cVar.f59662a.f59648a = HotUserRankFragment.this.getResources().getString(R.string.forum_hot_user_rank);
                    }
                    HotUserRankFragment.this.f14495f.f(cVar.f59662a, !k.isEmpty(HotUserRankFragment.this.f14496g));
                    if (HotUserRankFragment.this.isResumed() || HotUserRankFragment.this.getBaseFragmentActivity() != null) {
                        CustomMessage customMessage = new CustomMessage(2921447);
                        customMessage.setTag(HotUserRankFragment.this.getBaseFragmentActivity().getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921447, cVar);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                if (HotUserRankFragment.this.j.g() != null) {
                    HotUserRankFragment.this.f14495f.h(HotUserRankFragment.this.j.g().f59663b);
                }
                if (HotUserRankFragment.this.j.j()) {
                    return;
                }
                HotUserRankFragment.this.f14495f.j(HotUserRankFragment.this.f14496g);
            }
        }

        @Override // d.a.n0.j0.i.d.a.b
        public void onError(int i2, String str) {
            HotUserRankFragment hotUserRankFragment = HotUserRankFragment.this;
            hotUserRankFragment.hideLoadingView(hotUserRankFragment.f14494e);
            HotUserRankFragment hotUserRankFragment2 = HotUserRankFragment.this;
            hotUserRankFragment2.showNetRefreshView(hotUserRankFragment2.f14494e, str, false);
        }
    }

    public d.a.n0.j0.i.d.a Q0() {
        return this.j;
    }

    public final void R0() {
        if (!TextUtils.isEmpty(this.f14496g)) {
            this.j.i(this.f14496g);
            return;
        }
        long j = this.f14497h;
        if (j > 0) {
            this.j.h(j);
        }
    }

    public void S0(String str) {
        this.f14496g = str;
    }

    public void T0(long j) {
        this.f14497h = j;
    }

    public void U0(boolean z) {
        this.f14498i = z;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.f14495f.e(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.j0.i.d.a aVar = new d.a.n0.j0.i.d.a(getUniqueId());
        this.j = aVar;
        aVar.n(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f14494e == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_hot_user_rank, (ViewGroup) null);
            this.f14494e = inflate;
            RankListViewController rankListViewController = new RankListViewController(inflate.findViewById(R.id.rank_list), this.f14496g, this.f14497h);
            this.f14495f = rankListViewController;
            rankListViewController.g(this.k);
        }
        if (this.j.g() == null || ListUtils.isEmpty(this.j.g().f59663b)) {
            R0();
            showLoadingView(this.f14494e);
        }
        return this.f14494e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.j.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f14494e);
        R0();
        showLoadingView(this.f14494e);
    }
}
