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
import d.a.c.j.e.q;
import d.a.j0.z0.b0;
import d.a.k0.q0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements o0, VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public PersonalizePageView f16463e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f16464f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.a1.c.b f16465g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16466h = false;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16467i = new a(2921029);
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
                PersonalizeFragment.this.M0();
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
            if (customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || PersonalizeFragment.this.f16463e == null) {
                return;
            }
            PersonalizeFragment.this.f16463e.V(l);
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
            PersonalizeFragment.this.f16463e.s0();
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
                PersonalizeFragment.this.N0();
            }
        }
    }

    public PersonalizeFragment() {
    }

    @Override // d.a.k0.q0.o0
    public void G() {
    }

    public final void G0() {
        PersonalizePageView personalizePageView;
        if (!d.a.k0.a1.g.c.a(getBaseFragmentActivity()) || (personalizePageView = this.f16463e) == null) {
            return;
        }
        personalizePageView.r0();
    }

    @Override // d.a.k0.q0.o0
    public void H() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void H0() {
        this.f16463e.U();
    }

    public void I0() {
        this.f16463e.W();
    }

    public void J0() {
        this.f16463e.h0();
    }

    public void K0(d.a.k0.a1.c.b bVar) {
        this.f16465g = bVar;
        this.f16463e.setCallback(bVar);
    }

    public void L0(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizePageView personalizePageView = this.f16463e;
        if (personalizePageView != null) {
            personalizePageView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void M0() {
        if (!TbadkCoreApplication.getInst().isFirstTimeMotivate() || d.a.j0.r.d0.b.j().g("show_recommend_label", false)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
    }

    public final void N0() {
        d.a.j0.a.c.y().N(d.a.j0.a.b.Y);
    }

    public void O0() {
        this.f16463e.x0();
    }

    public void P0(DataRes dataRes, boolean z, boolean z2) {
        this.f16463e.y0(dataRes, z, z2);
    }

    public void Q0(String str, int i2) {
        this.f16463e.z0(str, i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a002";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
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
    public d.a.j0.k0.d getPageStayDurationItem() {
        d.a.j0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
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
        if (this.f16464f == null) {
            this.f16464f = VoiceManager.instance();
        }
        return this.f16464f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f16464f = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        this.f16467i.setTag(getUniqueId());
        registerListener(this.f16467i);
        registerListener(this.j);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.f16463e.j0(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.k0.c3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16463e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16463e.getParent()).removeView(this.f16463e);
            d.a.k0.a1.c.b bVar = this.f16465g;
            if (bVar != null) {
                this.f16463e.setCallback(bVar);
            }
        }
        this.f16463e.setPageUniqueId(getUniqueId());
        if (this.f16466h) {
            this.f16463e.b0();
            this.f16466h = false;
        }
        return this.f16463e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.f16464f;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.k0.c3.c.g().k(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.f16467i);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16464f = null;
        this.f16463e.k0();
        this.f16466h = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PersonalizePageView personalizePageView = this.f16463e;
        if (personalizePageView != null) {
            personalizePageView.o0();
            this.f16463e.l0();
            this.f16463e.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.k);
        VoiceManager voiceManager = this.f16464f;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        d.a.j0.a.c.y().E();
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
            this.f16463e.setViewForeground();
            G0();
            M0();
            d.a.k0.m.d.c().e("page_recommend");
            return;
        }
        this.f16463e.o0();
        d.a.k0.m.d.c().d("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.j0.r.n.b.i().n(true);
        VoiceManager voiceManager = this.f16464f;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        this.f16463e.m0();
        this.f16463e.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.k);
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.f16464f;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.a.k0.c3.c.g().h(getUniqueId(), false);
        VoiceManager voiceManager = this.f16464f;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.a.k0.q0.o0
    public void p() {
        this.f16463e.q0();
    }

    @Override // d.a.k0.q0.o0
    public void s() {
        PersonalizePageView personalizePageView = this.f16463e;
        if (personalizePageView != null) {
            personalizePageView.t0();
        }
    }

    public void t() {
        this.f16463e.setViewForeground(true);
    }

    @Override // d.a.k0.q0.o0
    public void u() {
    }

    @Override // d.a.k0.q0.o0
    public void y(b0 b0Var) {
        PersonalizePageView personalizePageView = this.f16463e;
        if (personalizePageView != null) {
            personalizePageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
        }
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        PersonalizePageView personalizePageView = new PersonalizePageView(context);
        this.f16463e = personalizePageView;
        personalizePageView.b0();
    }
}
