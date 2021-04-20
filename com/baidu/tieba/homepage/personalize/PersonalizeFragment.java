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
import d.b.c.j.e.q;
import d.b.h0.z0.b0;
import d.b.i0.q0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeFragment extends BaseFragment implements o0, VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public PersonalizePageView f16872e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f16873f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.a1.c.b f16874g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16875h = false;
    public CustomMessageListener i = new a(2921029);
    public final CustomMessageListener j = new b(2921313);
    public final CustomMessageListener k = new c(2001371);
    public final CustomMessageListener l = new d(2921391);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonalizeFragment.this.isPrimary()) {
                PersonalizeFragment.this.N0();
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
            Long l;
            if (customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || PersonalizeFragment.this.f16872e == null) {
                return;
            }
            PersonalizeFragment.this.f16872e.V(l);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            PersonalizeFragment.this.f16872e.s0();
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
            if (PersonalizeFragment.this.isResumed()) {
                PersonalizeFragment.this.O0();
            }
        }
    }

    public PersonalizeFragment() {
    }

    @Override // d.b.i0.q0.o0
    public void A() {
        PersonalizePageView personalizePageView = this.f16872e;
        if (personalizePageView != null) {
            personalizePageView.t0();
        }
    }

    public void E() {
        this.f16872e.setViewForeground(true);
    }

    @Override // d.b.i0.q0.o0
    public void F() {
    }

    public final void H0() {
        PersonalizePageView personalizePageView;
        if (!d.b.i0.a1.g.c.a(getBaseFragmentActivity()) || (personalizePageView = this.f16872e) == null) {
            return;
        }
        personalizePageView.r0();
    }

    public void I0() {
        this.f16872e.U();
    }

    public void J0() {
        this.f16872e.W();
    }

    @Override // d.b.i0.q0.o0
    public void K(b0 b0Var) {
        PersonalizePageView personalizePageView = this.f16872e;
        if (personalizePageView != null) {
            personalizePageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
        }
    }

    public void K0() {
        this.f16872e.h0();
    }

    public void L0(d.b.i0.a1.c.b bVar) {
        this.f16874g = bVar;
        this.f16872e.setCallback(bVar);
    }

    public void M0(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizePageView personalizePageView = this.f16872e;
        if (personalizePageView != null) {
            personalizePageView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void N0() {
        if (!TbadkCoreApplication.getInst().isFirstTimeMotivate() || d.b.h0.r.d0.b.j().g("show_recommend_label", false)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(getPageContext().getPageActivity(), 1)));
    }

    public final void O0() {
        d.b.h0.a.c.y().N(d.b.h0.a.b.Y);
    }

    public void P0() {
        this.f16872e.x0();
    }

    public void Q0(DataRes dataRes, boolean z, boolean z2) {
        this.f16872e.y0(dataRes, z, z2);
    }

    public void R0(String str, int i) {
        this.f16872e.z0(str, i);
    }

    @Override // d.b.i0.q0.o0
    public void W() {
    }

    @Override // d.b.i0.q0.o0
    public void b0() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a002";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
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
    public d.b.h0.k0.d getPageStayDurationItem() {
        d.b.h0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
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
        if (this.f16873f == null) {
            this.f16873f = VoiceManager.instance();
        }
        return this.f16873f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f16873f = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        this.i.setTag(getUniqueId());
        registerListener(this.i);
        registerListener(this.j);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f16872e.j0(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.i0.c3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16872e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16872e.getParent()).removeView(this.f16872e);
            d.b.i0.a1.c.b bVar = this.f16874g;
            if (bVar != null) {
                this.f16872e.setCallback(bVar);
            }
        }
        this.f16872e.setPageUniqueId(getUniqueId());
        if (this.f16875h) {
            this.f16872e.b0();
            this.f16875h = false;
        }
        return this.f16872e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.f16873f;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.b.i0.c3.c.g().k(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16873f = null;
        this.f16872e.k0();
        this.f16875h = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PersonalizePageView personalizePageView = this.f16872e;
        if (personalizePageView != null) {
            personalizePageView.o0();
            this.f16872e.l0();
            this.f16872e.setTabInForeBackgroundState(true);
        }
        MessageManager.getInstance().unRegisterListener(this.k);
        VoiceManager voiceManager = this.f16873f;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        d.b.h0.a.c.y().E();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.c.a.i
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
            this.f16872e.setViewForeground();
            H0();
            N0();
            d.b.i0.m.d.c().e("page_recommend");
            return;
        }
        this.f16872e.o0();
        d.b.i0.m.d.c().d("page_recommend");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.b.h0.r.n.b.i().n(true);
        VoiceManager voiceManager = this.f16873f;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        this.f16872e.m0();
        this.f16872e.setTabInForeBackgroundState(false);
        MessageManager.getInstance().registerListener(this.k);
        O0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.f16873f;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.b.i0.c3.c.g().h(getUniqueId(), false);
        VoiceManager voiceManager = this.f16873f;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // d.b.i0.q0.o0
    public void w() {
        this.f16872e.q0();
    }

    @SuppressLint({"ValidFragment"})
    public PersonalizeFragment(Context context) {
        PersonalizePageView personalizePageView = new PersonalizePageView(context);
        this.f16872e = personalizePageView;
        personalizePageView.b0();
    }
}
