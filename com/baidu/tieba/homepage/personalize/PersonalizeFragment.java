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
import d.a.m0.z0.b0;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements o0, VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public PersonalizePageView f16368e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f16369f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.c.b f16370g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16371h = false;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16372i = new a(2921029);
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
            if (customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || PersonalizeFragment.this.f16368e == null) {
                return;
            }
            PersonalizeFragment.this.f16368e.V(l);
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
            PersonalizeFragment.this.f16368e.s0();
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

    @Override // d.a.n0.r0.o0
    public void G() {
    }

    public final void G0() {
        PersonalizePageView personalizePageView;
        if (!d.a.n0.b1.g.c.a(getBaseFragmentActivity()) || (personalizePageView = this.f16368e) == null) {
            return;
        }
        personalizePageView.r0();
    }

    @Override // d.a.n0.r0.o0
    public void H() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void H0() {
        this.f16368e.U();
    }

    public void I0() {
        this.f16368e.W();
    }

    public void J0() {
        this.f16368e.h0();
    }

    public void K0(d.a.n0.b1.c.b bVar) {
        this.f16370g = bVar;
        this.f16368e.setCallback(bVar);
    }

    public void L0(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizePageView personalizePageView = this.f16368e;
        if (personalizePageView != null) {
            personalizePageView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void M0() {
        if (!TbadkCoreApplication.getInst().isFirstTimeMotivate() || d.a.m0.r.d0.b.j().g("show_recommend_label", false)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
    }

    public final void N0() {
        d.a.m0.a.c.y().N(d.a.m0.a.b.Y);
    }

    public void O0() {
        this.f16368e.x0();
    }

    public void P0(DataRes dataRes, boolean z, boolean z2) {
        this.f16368e.y0(dataRes, z, z2);
    }

    public void Q0(String str, int i2) {
        this.f16368e.z0(str, i2);
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
        if (this.f16369f == null) {
            this.f16369f = VoiceManager.instance();
        }
        return this.f16369f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f16369f = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        this.f16372i.setTag(getUniqueId());
        registerListener(this.f16372i);
        registerListener(this.j);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.f16368e.j0(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.d3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16368e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16368e.getParent()).removeView(this.f16368e);
            d.a.n0.b1.c.b bVar = this.f16370g;
            if (bVar != null) {
                this.f16368e.setCallback(bVar);
            }
        }
        this.f16368e.setPageUniqueId(getUniqueId());
        if (this.f16371h) {
            this.f16368e.b0();
            this.f16371h = false;
        }
        return this.f16368e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.f16369f;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.n0.d3.c.g().k(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.f16372i);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16369f = null;
        this.f16368e.k0();
        this.f16371h = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PersonalizePageView personalizePageView = this.f16368e;
        if (personalizePageView != null) {
            personalizePageView.o0();
            this.f16368e.l0();
            this.f16368e.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.k);
        VoiceManager voiceManager = this.f16369f;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        d.a.m0.a.c.y().E();
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
            this.f16368e.setViewForeground();
            G0();
            M0();
            d.a.n0.o.d.c().e("page_recommend");
            return;
        }
        this.f16368e.o0();
        d.a.n0.o.d.c().d("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.m0.r.n.b.i().n(true);
        VoiceManager voiceManager = this.f16369f;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        this.f16368e.m0();
        this.f16368e.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.k);
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.f16369f;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.a.n0.d3.c.g().h(getUniqueId(), false);
        VoiceManager voiceManager = this.f16369f;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.a.n0.r0.o0
    public void p() {
        this.f16368e.q0();
    }

    @Override // d.a.n0.r0.o0
    public void s() {
        PersonalizePageView personalizePageView = this.f16368e;
        if (personalizePageView != null) {
            personalizePageView.t0();
        }
    }

    public void t() {
        this.f16368e.setViewForeground(true);
    }

    @Override // d.a.n0.r0.o0
    public void u() {
    }

    @Override // d.a.n0.r0.o0
    public void y(b0 b0Var) {
        PersonalizePageView personalizePageView = this.f16368e;
        if (personalizePageView != null) {
            personalizePageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
        }
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        PersonalizePageView personalizePageView = new PersonalizePageView(context);
        this.f16368e = personalizePageView;
        personalizePageView.b0();
    }
}
