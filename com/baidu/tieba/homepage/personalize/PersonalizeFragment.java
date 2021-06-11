package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import d.a.c.k.e.q;
import d.a.m0.z0.b0;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements o0, VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public PersonalizePageView f16436e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f16437f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.d.b f16438g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16439h = false;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16440i = new a(2921029);
    public final CustomMessageListener j = new b(2921313);
    public final CustomMessageListener k = new c(2001371);
    public final CustomMessageListener l = new d(2921391);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.P0();
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
            Long l;
            if (customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || PersonalizeFragment.this.f16436e == null) {
                return;
            }
            PersonalizeFragment.this.f16436e.V(l);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            PersonalizeFragment.this.f16436e.s0();
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
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.Q0();
            }
        }
    }

    public PersonalizeFragment() {
    }

    @Override // d.a.n0.r0.o0
    public void H() {
    }

    @Override // d.a.n0.r0.o0
    public void I() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void J0() {
        PersonalizePageView personalizePageView;
        if (!d.a.n0.b1.h.c.a(getBaseFragmentActivity()) || (personalizePageView = this.f16436e) == null) {
            return;
        }
        personalizePageView.r0();
    }

    public void K0() {
        this.f16436e.U();
    }

    public void L0() {
        this.f16436e.W();
    }

    public void M0() {
        this.f16436e.h0();
    }

    public void N0(d.a.n0.b1.d.b bVar) {
        this.f16438g = bVar;
        this.f16436e.setCallback(bVar);
    }

    public void O0(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizePageView personalizePageView = this.f16436e;
        if (personalizePageView != null) {
            personalizePageView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void P0() {
        if (!TbadkCoreApplication.getInst().isFirstTimeMotivate() || d.a.m0.r.d0.b.j().g("show_recommend_label", false)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
    }

    public final void Q0() {
        d.a.m0.a.d.y().N(d.a.m0.a.c.Y);
    }

    public void R0() {
        this.f16436e.x0();
    }

    public void S0(DataRes dataRes, boolean z, boolean z2) {
        this.f16436e.y0(dataRes, z, z2);
    }

    public void T0(String str, int i2) {
        this.f16436e.z0(str, i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a002";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.m0.k0.d getPageStayDurationItem() {
        d.a.m0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.f16437f == null) {
            this.f16437f = VoiceManager.instance();
        }
        return this.f16437f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f16437f = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        this.f16440i.setTag(getUniqueId());
        registerListener(this.f16440i);
        registerListener(this.j);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.f16436e.j0(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.d3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16436e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16436e.getParent()).removeView(this.f16436e);
            d.a.n0.b1.d.b bVar = this.f16438g;
            if (bVar != null) {
                this.f16436e.setCallback(bVar);
            }
        }
        this.f16436e.setPageUniqueId(getUniqueId());
        if (this.f16439h) {
            this.f16436e.b0();
            this.f16439h = false;
        }
        return this.f16436e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.f16437f;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.n0.d3.c.g().k(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.f16440i);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16437f = null;
        this.f16436e.k0();
        this.f16439h = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PersonalizePageView personalizePageView = this.f16436e;
        if (personalizePageView != null) {
            personalizePageView.o0();
            this.f16436e.l0();
            this.f16436e.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.k);
        VoiceManager voiceManager = this.f16437f;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        d.a.m0.a.d.y().E();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.c.a.i
    public void onPreLoad(q qVar) {
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        super.onPreLoad(qVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16436e.setViewForeground();
            J0();
            P0();
            d.a.n0.o.d.c().e("page_recommend");
            return;
        }
        this.f16436e.o0();
        d.a.n0.o.d.c().d("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.m0.r.n.b.i().n(true);
        VoiceManager voiceManager = this.f16437f;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        this.f16436e.m0();
        this.f16436e.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.k);
        Q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.f16437f;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.a.n0.d3.c.g().h(getUniqueId(), false);
        VoiceManager voiceManager = this.f16437f;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.a.n0.r0.o0
    public void r() {
        this.f16436e.q0();
    }

    @Override // d.a.n0.r0.o0
    public void t() {
        PersonalizePageView personalizePageView = this.f16436e;
        if (personalizePageView != null) {
            personalizePageView.t0();
        }
    }

    public void u() {
        this.f16436e.setViewForeground(true);
    }

    @Override // d.a.n0.r0.o0
    public void v() {
    }

    @Override // d.a.n0.r0.o0
    public void z(b0 b0Var) {
        PersonalizePageView personalizePageView = this.f16436e;
        if (personalizePageView != null) {
            personalizePageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
        }
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        PersonalizePageView personalizePageView = new PersonalizePageView(context);
        this.f16436e = personalizePageView;
        personalizePageView.b0();
    }
}
