package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.i0.r.f0.f;
import d.a.j0.q0.r0;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameRecommendFragment extends BaseFragment implements r0 {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q0.u1.e.a f16243e;

    /* renamed from: f  reason: collision with root package name */
    public AlaGameRecommendModel f16244f;

    /* renamed from: g  reason: collision with root package name */
    public String f16245g;

    /* renamed from: h  reason: collision with root package name */
    public String f16246h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16247i = new a(0);
    public AlaGameRecommendModel.b j = new b();
    public f.g k = new c();
    public BdListView.p l = new d();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == d.a.c.e.m.b.d(split[1], 0)) {
                FrsGameRecommendFragment.this.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaGameRecommendModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void a(boolean z, List<n> list) {
            FrsGameRecommendFragment.this.f16243e.b();
            FrsGameRecommendFragment frsGameRecommendFragment = FrsGameRecommendFragment.this;
            frsGameRecommendFragment.hideNetRefreshView(frsGameRecommendFragment.f16243e.d());
            FrsGameRecommendFragment frsGameRecommendFragment2 = FrsGameRecommendFragment.this;
            frsGameRecommendFragment2.hideLoadingView(frsGameRecommendFragment2.f16243e.d());
            FrsGameRecommendFragment.this.f16243e.k(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.b
        public void b(int i2, String str, boolean z) {
            FrsGameRecommendFragment.this.f16243e.b();
            if (z) {
                FrsGameRecommendFragment.this.showToast(R.string.card_vr_video_load_failed);
            } else {
                FrsGameRecommendFragment frsGameRecommendFragment = FrsGameRecommendFragment.this;
                frsGameRecommendFragment.showNetRefreshView(frsGameRecommendFragment.f16243e.d(), str, false);
            }
            FrsGameRecommendFragment.this.f16243e.m();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                if (FrsGameRecommendFragment.this.f16244f != null) {
                    FrsGameRecommendFragment.this.f16244f.C();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(R.string.neterror);
            FrsGameRecommendFragment.this.f16243e.b();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.f16244f != null) {
                FrsGameRecommendFragment.this.f16244f.D();
            }
        }
    }

    public static FrsGameRecommendFragment I0(String str, String str2) {
        FrsGameRecommendFragment frsGameRecommendFragment = new FrsGameRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        frsGameRecommendFragment.setArguments(bundle);
        return frsGameRecommendFragment;
    }

    @Override // d.a.j0.q0.r0
    public NavigationBar e0() {
        return this.f16243e.e();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        d.a.j0.q0.u1.e.a aVar = this.f16243e;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.f16245g = arguments.getString("forum_id");
        this.f16246h = arguments.getString("forum_name");
        d.a.j0.q0.u1.e.a aVar = new d.a.j0.q0.u1.e.a(getPageContext(), this.f16245g, this.f16246h);
        this.f16243e = aVar;
        aVar.l(this.k);
        this.f16243e.n(this.l);
        MessageManager.getInstance().registerListener(2001446, this.f16247i);
        this.f16244f = new AlaGameRecommendModel(this.f16245g, this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f16243e.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.q0.u1.e.a aVar = this.f16243e;
        if (aVar != null) {
            aVar.j();
        }
        AlaGameRecommendModel alaGameRecommendModel = this.f16244f;
        if (alaGameRecommendModel != null) {
            alaGameRecommendModel.onDestroy();
        }
        if (this.f16247i != null) {
            MessageManager.getInstance().unRegisterListener(this.f16247i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        AlaGameRecommendModel alaGameRecommendModel = this.f16244f;
        if (alaGameRecommendModel != null) {
            alaGameRecommendModel.C();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaGameRecommendModel alaGameRecommendModel;
        super.onPrimary();
        if (isAdded() && isPrimary() && (alaGameRecommendModel = this.f16244f) != null) {
            if (alaGameRecommendModel.B()) {
                t();
                return;
            }
            this.f16244f.C();
            showLoadingView(this.f16243e.d());
        }
    }

    public final void t() {
        this.f16243e.c();
    }
}
