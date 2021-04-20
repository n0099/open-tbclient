package com.baidu.tieba.homepage.framework;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import d.b.h0.a.w;
import d.b.h0.s.c.d0;
import d.b.h0.z0.y;
import d.b.i0.a1.c.c;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment implements d.b.h0.r.g {

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f16735e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.a1.c.c f16736f;
    public w j;
    public boolean t;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f16737g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16738h = true;
    public boolean i = false;
    public NoNetworkView.b k = new g();
    public w.b l = new h();
    public CustomMessageListener m = new i(2001378);
    public CustomMessageListener n = new j(2921323);
    public CustomMessageListener o = new k(2921445);
    public CustomMessageListener p = new l(2001371);
    public CustomMessageListener q = new m(2001384);
    public CustomMessageListener r = new n(2921308);
    public CustomMessageListener s = new o(2921392);
    public CustomMessageListener u = new a(2001011);
    public d.b.i0.a1.c.b v = new b();
    public ConcernPageView.l w = new c();
    public CustomMessageListener x = new f(2921455);

    /* loaded from: classes4.dex */
    public static class ControlModelMessage extends CustomMessage<d.b.i0.a1.c.c> {
        public ControlModelMessage(d.b.i0.a1.c.c cVar) {
            super(2001406);
            setData(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.t = false;
                } else if (!TbadkCoreApplication.isLogin() || RecommendFrsControlFragment.this.t) {
                } else {
                    RecommendFrsControlFragment.this.f16736f.b(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.a1.c.b {
        public b() {
        }

        @Override // d.b.i0.a1.c.b
        public void a() {
        }

        @Override // d.b.i0.a1.c.b
        public void b(int i, int i2, d.b.h0.z0.c cVar, int i3) {
            RecommendFrsControlFragment.this.f16736f.h(2, i2, cVar, i, i3);
            if (d.b.c.e.p.j.A()) {
                TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
            }
        }

        @Override // d.b.i0.a1.c.b
        public void c(int i, d.b.h0.z0.c cVar, int i2) {
            RecommendFrsControlFragment.this.f16736f.h(1, i, cVar, 1, i2);
            if (d.b.c.e.p.j.A()) {
                TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ConcernPageView.l {
        public c() {
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void a(d.b.h0.z0.c cVar) {
            RecommendFrsControlFragment.this.f16736f.g("", cVar);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void b(boolean z, boolean z2) {
            if (!z) {
                if (z2) {
                    RecommendFrsControlFragment.this.f16736f.b(false);
                    return;
                }
                return;
            }
            RecommendFrsControlFragment.this.f16735e.setShowConcernRedTip(false);
            if (RecommendFrsControlFragment.this.f16738h) {
                if (!RecommendFrsControlFragment.this.isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
            }
            RecommendFrsControlFragment.this.f16738h = false;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void c(String str, d.b.h0.z0.c cVar) {
            RecommendFrsControlFragment.this.f16736f.g(str, cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.d {
        public d() {
        }

        @Override // d.b.i0.a1.c.c.d
        public void a(boolean z) {
            if (RecommendFrsControlFragment.this.f16735e == null) {
                return;
            }
            RecommendFrsControlFragment.this.f16735e.setShowConcernRedTip(z);
            if (RecommendFrsControlFragment.this.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // d.b.i0.a1.c.c.d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            RecommendFrsControlFragment.this.f16735e.U(dataRes, z, z2);
        }

        @Override // d.b.i0.a1.c.c.d
        public void c(String str, String str2, int i, boolean z, int i2) {
            if (RecommendFrsControlFragment.this.f16735e.x()) {
                RecommendFrsControlFragment.this.f16735e.T(str2, i, i2);
            }
        }

        @Override // d.b.i0.a1.c.c.d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            RecommendFrsControlFragment.this.f16735e.S(dataRes, z);
        }

        @Override // d.b.i0.a1.c.c.d
        public void e(boolean z, d.b.i0.a1.h.a.a aVar, boolean z2, String str, String str2, boolean z3) {
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.b.h0.k0.b {
        public e() {
        }

        @Override // d.b.h0.k0.b
        public boolean canStat(d.b.h0.k0.d dVar) {
            return false;
        }

        @Override // d.b.h0.k0.b
        public int getMaxCost() {
            return d.b.h0.k0.e.b().c();
        }

        @Override // d.b.h0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.f16735e == null || RecommendFrsControlFragment.this.f16735e.getCurrentTabType() != 1) {
                return;
            }
            RecommendFrsControlFragment.this.f16735e.M();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements NoNetworkView.b {
        public g() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.f16735e.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.f16735e.M();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements w.b {
        public h() {
        }

        @Override // d.b.h0.a.w.b
        public void a() {
            if (!RecommendFrsControlFragment.this.isPrimary() || RecommendFrsControlFragment.this.j == null) {
                return;
            }
            if (d.b.c.e.p.l.C()) {
                RecommendFrsControlFragment.this.j.h(true);
                RecommendFrsControlFragment.this.j.g();
                if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                    UrlManager.getInstance().dealOneLink(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                }
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                return;
            }
            d.b.c.e.p.l.K(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
            TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (RecommendFrsControlFragment.this.f16735e != null && RecommendFrsControlFragment.this.f16735e.getCurrentTabType() != 0) {
                    RecommendFrsControlFragment.this.f16735e.setCurrentTab(0);
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.h0.r.a0.b.e(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.f16735e == null || RecommendFrsControlFragment.this.f16735e.getCurrentTabType() == 0) {
                return;
            }
            RecommendFrsControlFragment.this.f16735e.setCurrentTab(0);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.f16735e == null || RecommendFrsControlFragment.this.f16735e.getCurrentTabType() == 6) {
                return;
            }
            RecommendFrsControlFragment.this.f16735e.setFakeClickCurrentTab(6);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.j != null) {
                if (!RecommendFrsControlFragment.this.P0() || RecommendFrsControlFragment.this.j.d() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.i) {
                    if (!RecommendFrsControlFragment.this.P0() && RecommendFrsControlFragment.this.j.d()) {
                        RecommendFrsControlFragment.this.j.c();
                    }
                } else {
                    RecommendFrsControlFragment.this.j.f();
                }
            }
            if (!RecommendFrsControlFragment.this.isPrimary() || (newGodData = TbSingleton.getInstance().getNewGodData()) == null) {
                return;
            }
            y.g().k(1, newGodData);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public m(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || RecommendFrsControlFragment.this.f16735e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (RecommendFrsControlFragment.this.f16735e.getCurrentTabType() == 1) {
                        d.b.h0.r.n.b.i().n(true);
                    }
                    if (RecommendFrsControlFragment.this.isPrimary()) {
                        RecommendFrsControlFragment.this.f16735e.M();
                        return;
                    } else if (RecommendFrsControlFragment.this.f16735e.getCurrentTabType() == 0) {
                        boolean C = RecommendFrsControlFragment.this.f16735e.C();
                        TiebaStatic.log(new StatisticItem("c12350").param("obj_type", C ? 1 : 0));
                        if (C) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                            RecommendFrsControlFragment.this.f16735e.M();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                d.b.h0.r.n.b.i().n(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public n(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public o(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                if (((Boolean) data).booleanValue()) {
                    RecommendFrsControlFragment.this.i = true;
                    if (RecommendFrsControlFragment.this.j == null || !RecommendFrsControlFragment.this.j.d()) {
                        return;
                    }
                    RecommendFrsControlFragment.this.j.c();
                    return;
                }
                RecommendFrsControlFragment.this.i = false;
                if (RecommendFrsControlFragment.this.j == null || !RecommendFrsControlFragment.this.isResumed() || !RecommendFrsControlFragment.this.P0() || RecommendFrsControlFragment.this.j.d()) {
                    return;
                }
                RecommendFrsControlFragment.this.j.f();
            }
        }
    }

    public final void O0() {
        d.b.i0.a1.c.c cVar = new d.b.i0.a1.c.c(getPageContext(), getUniqueId());
        this.f16736f = cVar;
        cVar.j(new d());
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.f16736f));
    }

    public final boolean P0() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        d0 shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new d0();
        }
        if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
            try {
                shakeData.parserJson(new JSONObject(d.b.h0.r.d0.b.j().p("shake_data", StringUtil.EMPTY_ARRAY)));
                TbSingleton.getInstance().setShakeData(shakeData);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return currentTimeMillis > shakeData.c() && currentTimeMillis < shakeData.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
        if (scrollFragmentTabHost != null) {
            return scrollFragmentTabHost.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public d.b.h0.k0.b getPageStayFilter() {
        return new e();
    }

    @Override // d.b.h0.r.g
    public void o0(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("sub_locate_type", 0);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setCurrentTab(intExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O0();
        this.f16735e.z(getPageContext(), this.k);
        this.f16735e.A(getChildFragmentManager(), this.v, this.w);
        this.f16735e.setScrollShadow(false);
        this.f16735e.setPageUniqueId(getUniqueId());
        this.f16735e.R();
        this.t = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.f16735e.getCurrentTabType() != 0) {
            this.f16736f.b(System.currentTimeMillis() > d.b.h0.r.d0.b.j().l(d.b.h0.r.d0.b.n("concern_unread_tip_next_show_time"), 0L));
        }
        d.b.i0.a1.c.a.d().h(System.currentTimeMillis() - d.b.i0.a1.c.a.d().a(1));
        d.b.h0.m0.l.b().G(System.currentTimeMillis() - d.b.i0.a1.c.a.d().a(1));
        if (d.b.h0.b.d.h()) {
            this.f16735e.O();
        } else {
            this.f16735e.P();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 18003 && (stringExtra = intent.getStringExtra("tid")) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
            if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                this.f16735e.M();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
        if (scrollFragmentTabHost != null) {
            SkinManager.setBackgroundColor(scrollFragmentTabHost, R.color.CAM_X0202);
            this.f16735e.I(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.b.i0.a1.c.a.d().g(System.currentTimeMillis(), 1);
        d.b.h0.m0.l.b().F(System.currentTimeMillis());
        super.onCreate(bundle);
        registerListener(this.q);
        registerListener(this.u);
        registerListener(this.r);
        this.m.setSelfListener(true);
        this.m.setTag(getPageContext().getUniqueId());
        registerListener(this.m);
        registerListener(this.n);
        registerListener(this.o);
        registerListener(this.p);
        registerListener(this.s);
        registerListener(this.x);
        this.j = new w(getContext(), this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.f16735e = scrollFragmentTabHost;
        scrollFragmentTabHost.setDrawingCacheEnabled(false);
        return this.f16735e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.m);
        this.f16735e.J();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setPrimary(isPrimary());
            this.f16735e.t();
        }
        w wVar = this.j;
        if (wVar != null && wVar.d()) {
            this.j.c();
        }
        y.g().i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        int intExtra;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.f16735e == null) {
            return;
        }
        if (isPrimary()) {
            d.b.h0.a.n.b().j(true);
            this.f16735e.F();
        } else {
            d.b.h0.a.n.b().j(false);
        }
        if (getActivity().getIntent() != null) {
            str = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
            str2 = getActivity().getIntent().getDataString();
        } else {
            str = null;
            str2 = null;
        }
        String str3 = "";
        if ((!StringUtils.isNull(str) && isPrimary()) || (!StringUtils.isNull(str2) && str2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_VIDEO_SQUARE))) {
            getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
            this.f16735e.setVideoThreadId(str);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
            scrollFragmentTabHost.setCurrentTab(scrollFragmentTabHost.getVideoRecommendIndex(), false);
        }
        Intent intent = getActivity().getIntent();
        if (isPrimary() && intent != null) {
            if (UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC.equals(intent.getDataString())) {
                this.f16735e.setCurrentTab(5);
                intent.setData(null);
            } else {
                int intExtra2 = intent.getIntExtra("locate_type", 0);
                String stringExtra = intent.getStringExtra("sub_tab_name");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(d.b.h0.a.f.G)) {
                    intExtra2 = 16;
                }
                if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                    this.f16735e.setCurrentTab(stringExtra);
                    intent.removeExtra("locate_type");
                    intent.removeExtra("sub_tab_name");
                } else if (intExtra2 == 16) {
                    if (this.f16735e.getCurrentTabType() != 5) {
                        TiebaStatic.log(new StatisticItem("c13888"));
                    }
                    this.f16735e.setCurrentTab(5);
                    intent.putExtra("locate_type", 0);
                } else if (intExtra2 == 2) {
                    this.f16735e.setCurrentTab(1);
                    intent.putExtra("locate_type", 0);
                }
            }
        }
        if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
            this.f16735e.setCurrentTab(6);
            getActivity().getIntent().putExtra("locate_type", 0);
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", PrefetchEvent.STATE_CLICK);
        } else {
            VoiceManager a2 = d.b.i0.d3.p0.b.a(getActivity());
            if (a2 != null) {
                a2.stopPlay();
            }
        }
        this.f16735e.setPrimary(isPrimary());
        this.f16735e.L();
        if (isPrimary()) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                str3 = getActivity().getIntent().getStringExtra(d.b.h0.a.f.C);
                getActivity().getIntent().removeExtra(d.b.h0.a.f.C);
            }
            if (!"sms".equals(str3)) {
                NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                if (newGodData != null) {
                    y.g().k(1, newGodData);
                    return;
                }
                return;
            } else if (!TbadkCoreApplication.isLogin() || getActivity() == null || getActivity().getIntent() == null) {
                return;
            } else {
                String stringExtra2 = getActivity().getIntent().getStringExtra(d.b.h0.a.f.D);
                if (StringUtils.isNull(stringExtra2)) {
                    return;
                }
                NewGodData newGodData2 = new NewGodData();
                newGodData2.setFieldId(stringExtra2);
                y.g().l(5, newGodData2, false);
                return;
            }
        }
        y.g().i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Boolean bool = this.f16737g;
        if (bool == null) {
            this.f16737g = Boolean.valueOf(d.b.h0.r.k.c().g());
        } else {
            r1 = bool.booleanValue() != d.b.h0.r.k.c().g();
            this.f16737g = Boolean.valueOf(d.b.h0.r.k.c().g());
        }
        if (r1) {
            this.f16735e.v();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setPrimary(isPrimary());
            this.f16735e.K();
        }
        if (this.j == null || !P0() || this.j.d() || this.i) {
            return;
        }
        this.j.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16735e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.G();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (z) {
            return;
        }
        this.f16735e.t();
    }
}
