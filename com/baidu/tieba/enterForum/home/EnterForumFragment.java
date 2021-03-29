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
import d.b.b.e.p.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class EnterForumFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i0.h.a f15399e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.i0.h.c f15400f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f15401g;

    /* renamed from: h  reason: collision with root package name */
    public PluginErrorTipView f15402h;
    public RelativeLayout i;
    public ObservedChangeLinearLayout j;
    public RelativeLayout k;
    public CustomMessageListener l = new a(2001629);
    public CustomMessageListener m = new b(2001631);
    public final CustomMessageListener n = new d(2001371);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof BdUniqueId) || ((BdUniqueId) customResponsedMessage.getData()) == null || !EnterForumFragment.this.isVisible() || TbadkCoreApplication.getInst().getCurrentActivity() != EnterForumFragment.this.getActivity() || EnterForumFragment.this.f15399e == null) {
                return;
            }
            EnterForumFragment.this.f15399e.y();
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()) != null && EnterForumFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == EnterForumFragment.this.getActivity()) {
                if (EnterForumFragment.this.f15399e != null) {
                    EnterForumFragment.this.f15399e.N(true);
                }
                if (EnterForumFragment.this.f15400f != null) {
                    EnterForumFragment.this.f15400f.q();
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
            EnterForumFragment.this.f15399e.N(z);
            if (EnterForumFragment.this.I0() != null) {
                EnterForumFragment.this.I0().Q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && d.b.i0.i0.j.b.b()) {
                d.b.i0.i0.j.b.a();
            }
        }
    }

    static {
        new ArrayList();
    }

    public RelativeLayout G0() {
        return this.i;
    }

    public ObservedChangeLinearLayout H0() {
        return this.j;
    }

    public d.b.i0.i0.h.c I0() {
        return this.f15400f;
    }

    public final void J0(View view) {
        this.i = (RelativeLayout) view.findViewById(R.id.enter_root_layout);
        this.f15401g = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.f15402h = (PluginErrorTipView) view.findViewById(R.id.view_plugin_error_tip);
        this.j = (ObservedChangeLinearLayout) view.findViewById(R.id.tab_layout);
        d.b.i0.i0.h.a aVar = new d.b.i0.i0.h.a(this);
        this.f15399e = aVar;
        aVar.S(getUniqueId());
        this.f15401g.a(new c());
        this.i.addView(this.f15399e.A(), 0);
        this.f15399e.C();
        View findViewById = this.i.findViewById(R.id.enter_forum_ad);
        if (findViewById != null) {
            this.i.removeView(findViewById);
            this.i.addView(findViewById, 0);
        }
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f15399e.H();
    }

    public boolean K0() {
        d.b.i0.i0.h.a aVar = this.f15399e;
        if (aVar == null || aVar.z() == null) {
            return true;
        }
        return this.f15399e.z().U();
    }

    public void L0(d.b.i0.i0.d.c cVar) {
        this.f15400f.S(cVar);
    }

    public final void M0() {
        d.b.i0.i0.h.a aVar = this.f15399e;
        if (aVar != null) {
            aVar.w(true);
        }
    }

    public void N0(d.b.i0.i0.h.c cVar) {
        this.f15400f = cVar;
    }

    public void O0() {
        M0();
        d.b.i0.i0.h.a aVar = this.f15399e;
        if (aVar != null) {
            aVar.H();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
        d.b.i0.i0.h.a aVar = this.f15399e;
        if (aVar != null) {
            aVar.I(i);
        }
        NoNetworkView noNetworkView = this.f15401g;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i);
        }
        PluginErrorTipView pluginErrorTipView = this.f15402h;
        if (pluginErrorTipView != null) {
            pluginErrorTipView.e(getPageContext(), i);
        }
        if (this.k != null) {
            d.b.h0.s0.a.a(getPageContext(), this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n.setPriority(101);
        registerListener(this.n);
        registerListener(this.l);
        registerListener(this.m);
        d.b.i0.b3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_forum, viewGroup, false);
        J0(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        d.b.i0.b3.c.g().i(getUniqueId());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.i0.i0.h.a aVar = this.f15399e;
        if (aVar != null) {
            aVar.J();
        }
        this.f15400f = null;
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().unRegisterListener(this.n);
        d.b.i0.b3.c.g().k(getUniqueId());
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        d.b.i0.b3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.b.i0.i0.h.a aVar = this.f15399e;
        if (aVar != null) {
            aVar.K();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            O0();
            d.b.i0.i0.h.a aVar = this.f15399e;
            if (aVar != null) {
                refreshImage(aVar.A());
            }
            d.b.i0.b3.c.g().h(getUniqueId(), false);
        }
        d.b.i0.i0.h.a aVar2 = this.f15399e;
        if (aVar2 != null) {
            aVar2.L();
        }
        if (I0() != null) {
            I0().Q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        NoNetworkView noNetworkView = this.f15401g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && j.z()) {
            this.f15401g.e(false);
        }
    }
}
