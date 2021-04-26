package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import d.a.i0.k0.d;
import d.a.i0.k0.e;
import d.a.i0.r.g;
/* loaded from: classes4.dex */
public class EnterForumTabFragment extends BaseFragment implements g {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.i0.h.c f15201e;

    /* renamed from: f  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip.c f15202f = new a();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f15203g = new b(2001384);

    /* loaded from: classes4.dex */
    public class a implements NewPagerSlidingTabBaseStrip.c {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view, int i2) {
            if (view == null || !EnterForumTabFragment.this.isPrimary() || EnterForumTabFragment.this.f15201e == null) {
                return;
            }
            if (EnterForumTabFragment.this.f15201e.t() == i2) {
                EnterForumTabFragment.this.f15201e.J(i2);
            } else if (i2 == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            } else if (i2 > 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, EnterForumTabFragment.this.f15201e.v(i2)));
            }
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer) || ((Integer) customResponsedMessage.getData()).intValue() != 1 || EnterForumTabFragment.this.f15201e == null) {
                return;
            }
            if (EnterForumTabFragment.this.isPrimary()) {
                EnterForumTabFragment.this.f15201e.J(EnterForumTabFragment.this.f15201e.t());
                return;
            }
            int t = EnterForumTabFragment.this.f15201e.t();
            if (t == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            } else if (t > 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, EnterForumTabFragment.this.f15201e.v(t)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.i0.k0.b {
        public c() {
        }

        @Override // d.a.i0.k0.b
        public boolean canStat(d dVar) {
            return false;
        }

        @Override // d.a.i0.k0.b
        public int getMaxCost() {
            return e.b().c();
        }

        @Override // d.a.i0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    public final void F0(Intent intent, Bundle bundle) {
        if (this.f15201e == null || intent == null || intent.getExtras() == null) {
            return;
        }
        if (intent.getBooleanExtra("is_from_scheme", false)) {
            String stringExtra = intent.getStringExtra("sub_locate_type");
            int r = this.f15201e.r(stringExtra);
            if (this.f15201e.B()) {
                if (this.f15201e.P(r != -1 ? r : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                    return;
                }
                return;
            }
            this.f15201e.T(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        if (this.f15201e != null) {
            super.changeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        d.a.j0.i0.h.c cVar = this.f15201e;
        if (cVar != null) {
            return cVar.s();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public d.a.i0.k0.b getPageStayFilter() {
        return new c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f15201e.G();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        d.a.j0.i0.h.c cVar = this.f15201e;
        if (cVar != null) {
            cVar.H(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.i0.h.c cVar = this.f15201e;
        if (cVar != null) {
            cVar.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15201e = new d.a.j0.i0.h.c(this);
        registerListener(this.f15203g);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.f15201e.z(inflate, bundle);
        F0(getActivity().getIntent(), bundle);
        this.f15201e.o(this.f15202f);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.e1.h.e.m().c();
        MessageManager.getInstance().unRegisterListener(this.f15203g);
        d.a.j0.i0.h.c cVar = this.f15201e;
        if (cVar != null) {
            cVar.I();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && getActivity() != null) {
            F0(getActivity().getIntent(), null);
        }
        d.a.j0.i0.h.c cVar = this.f15201e;
        if (cVar != null) {
            cVar.S(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        d.a.j0.i0.h.c cVar = this.f15201e;
        if (cVar != null) {
            cVar.S(z);
        }
    }

    @Override // d.a.i0.r.g
    public void v0(Intent intent) {
        if (intent == null || this.f15201e == null) {
            return;
        }
        int r = this.f15201e.r(intent.getStringExtra("sub_locate_type"));
        if (r == -1) {
            r = 0;
        }
        if (this.f15201e.P(r)) {
            intent.removeExtra("sub_locate_type");
        }
    }
}
