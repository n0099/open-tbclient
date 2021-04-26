package com.baidu.tieba.enterForum.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.i0.h.a f15192e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.i0.h.c f15193f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f15194g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f15195h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f15196i;
    public ObservedChangeLinearLayout j;
    public RelativeLayout k;
    public CustomMessageListener l = new a(2001629);
    public CustomMessageListener m = new b(2001631);
    public final CustomMessageListener n = new d(2001371);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof BdUniqueId) || ((BdUniqueId) customResponsedMessage.getData()) == null || !EnterForumFragment.this.isVisible() || TbadkCoreApplication.getInst().getCurrentActivity() != EnterForumFragment.this.getActivity() || EnterForumFragment.this.f15192e == null) {
                return;
            }
            EnterForumFragment.this.f15192e.y();
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.f15192e != null) {
                    EnterForumFragment.this.f15192e.N(true);
                }
                if (EnterForumFragment.this.f15193f != null) {
                    EnterForumFragment.this.f15193f.p();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            EnterForumFragment.this.f15192e.N(z);
            if (EnterForumFragment.this.I0() != null) {
                EnterForumFragment.this.I0().O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.a.j0.i0.j.b.b()) {
                d.a.j0.i0.j.b.a();
            }
        }
    }

    static {
        new ArrayList();
    }

    public RelativeLayout G0() {
        return this.f15196i;
    }

    public ObservedChangeLinearLayout H0() {
        return this.j;
    }

    public d.a.j0.i0.h.c I0() {
        return this.f15193f;
    }

    public final void J0(View view) {
        this.f15196i = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.f15194g = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.f15195h = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.j = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        d.a.j0.i0.h.a aVar = new d.a.j0.i0.h.a(this);
        this.f15192e = aVar;
        aVar.S(getUniqueId());
        this.f15194g.a(new c());
        this.f15196i.addView(this.f15192e.A(), 0);
        this.f15192e.C();
        View findViewById = this.f15196i.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.f15196i.removeView(findViewById);
            this.f15196i.addView(findViewById, 0);
        }
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f15192e.H();
    }

    public boolean K0() {
        d.a.j0.i0.h.a aVar = this.f15192e;
        if (aVar == null || aVar.z() == null) {
            return true;
        }
        return this.f15192e.z().U();
    }

    public void L0(d.a.j0.i0.d.c cVar) {
        this.f15193f.Q(cVar);
    }

    public final void M0() {
        d.a.j0.i0.h.a aVar = this.f15192e;
        if (aVar != null) {
            aVar.w(true);
        }
    }

    public void N0(d.a.j0.i0.h.c cVar) {
        this.f15193f = cVar;
    }

    public void O0() {
        M0();
        d.a.j0.i0.h.a aVar = this.f15192e;
        if (aVar != null) {
            aVar.H();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundColor(this.f15196i, R.color.CAM_X0201);
        d.a.j0.i0.h.a aVar = this.f15192e;
        if (aVar != null) {
            aVar.I(i2);
        }
        NoNetworkView noNetworkView = this.f15194g;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i2);
        }
        PluginErrorTipView pluginErrorTipView = this.f15195h;
        if (pluginErrorTipView != null) {
            pluginErrorTipView.e(getPageContext(), i2);
        }
        if (this.k != null) {
            d.a.i0.s0.a.a(getPageContext(), this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n.setPriority(101);
        registerListener(this.n);
        registerListener(this.l);
        registerListener(this.m);
        d.a.j0.c3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        J0(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        d.a.j0.c3.c.g().i(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.j0.i0.h.a aVar = this.f15192e;
        if (aVar != null) {
            aVar.J();
        }
        this.f15193f = null;
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().unRegisterListener(this.n);
        d.a.j0.c3.c.g().k(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        d.a.j0.c3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.a.j0.i0.h.a aVar = this.f15192e;
        if (aVar != null) {
            aVar.K();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            O0();
            d.a.j0.i0.h.a aVar = this.f15192e;
            if (aVar != null) {
                refreshImage(aVar.A());
            }
            d.a.j0.c3.c.g().h(getUniqueId(), false);
        }
        d.a.j0.i0.h.a aVar2 = this.f15192e;
        if (aVar2 != null) {
            aVar2.L();
        }
        if (I0() != null) {
            I0().O();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        NoNetworkView noNetworkView = this.f15194g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && j.z()) {
            this.f15194g.e(false);
        }
    }
}
