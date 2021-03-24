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
import d.b.h0.k0.d;
import d.b.h0.k0.e;
import d.b.h0.r.g;
/* loaded from: classes4.dex */
public class EnterForumTabFragment extends BaseFragment implements g {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i0.h.c f15406e;

    /* renamed from: f  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip.c f15407f = new a();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f15408g = new b(2001384);

    /* loaded from: classes4.dex */
    public class a implements NewPagerSlidingTabBaseStrip.c {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view, int i) {
            if (view == null || !EnterForumTabFragment.this.isPrimary() || EnterForumTabFragment.this.f15406e == null) {
                return;
            }
            if (EnterForumTabFragment.this.f15406e.v() == i) {
                EnterForumTabFragment.this.f15406e.L(i);
            } else if (i == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            } else if (i > 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, EnterForumTabFragment.this.f15406e.x(i)));
            }
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer) || ((Integer) customResponsedMessage.getData()).intValue() != 1 || EnterForumTabFragment.this.f15406e == null) {
                return;
            }
            if (EnterForumTabFragment.this.isPrimary()) {
                EnterForumTabFragment.this.f15406e.L(EnterForumTabFragment.this.f15406e.v());
                return;
            }
            int v = EnterForumTabFragment.this.f15406e.v();
            if (v == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            } else if (v > 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, EnterForumTabFragment.this.f15406e.x(v)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.h0.k0.b {
        public c() {
        }

        @Override // d.b.h0.k0.b
        public boolean canStat(d dVar) {
            return false;
        }

        @Override // d.b.h0.k0.b
        public int getMaxCost() {
            return e.b().c();
        }

        @Override // d.b.h0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    public final void F0(Intent intent, Bundle bundle) {
        if (this.f15406e == null || intent == null || intent.getExtras() == null) {
            return;
        }
        if (intent.getBooleanExtra("is_from_scheme", false)) {
            String stringExtra = intent.getStringExtra("sub_locate_type");
            int s = this.f15406e.s(stringExtra);
            if (this.f15406e.F()) {
                if (this.f15406e.R(s != -1 ? s : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                    return;
                }
                return;
            }
            this.f15406e.V(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.f15406e != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        d.b.i0.i0.h.c cVar = this.f15406e;
        if (cVar != null) {
            return cVar.u();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public d.b.h0.k0.b getPageStayFilter() {
        return new c();
    }

    @Override // d.b.h0.r.g
    public void o0(Intent intent) {
        if (intent == null || this.f15406e == null) {
            return;
        }
        int s = this.f15406e.s(intent.getStringExtra("sub_locate_type"));
        if (s == -1) {
            s = 0;
        }
        if (this.f15406e.R(s)) {
            intent.removeExtra("sub_locate_type");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f15406e.I();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        d.b.i0.i0.h.c cVar = this.f15406e;
        if (cVar != null) {
            cVar.J(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.i0.h.c cVar = this.f15406e;
        if (cVar != null) {
            cVar.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15406e = new d.b.i0.i0.h.c(this);
        registerListener(this.f15408g);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.f15406e.B(inflate, bundle);
        F0(getActivity().getIntent(), bundle);
        this.f15406e.o(this.f15407f);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.d1.h.e.m().c();
        MessageManager.getInstance().unRegisterListener(this.f15408g);
        d.b.i0.i0.h.c cVar = this.f15406e;
        if (cVar != null) {
            cVar.K();
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
        d.b.i0.i0.h.c cVar = this.f15406e;
        if (cVar != null) {
            cVar.U(isPrimary());
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
        d.b.i0.i0.h.c cVar = this.f15406e;
        if (cVar != null) {
            cVar.U(z);
        }
    }
}
