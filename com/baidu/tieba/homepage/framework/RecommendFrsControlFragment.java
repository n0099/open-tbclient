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
import d.a.j0.a.x;
import d.a.j0.s.c.d0;
import d.a.j0.z0.y;
import d.a.k0.a1.c.c;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment implements d.a.j0.r.g {

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f16314e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.a1.c.c f16315f;
    public x j;
    public boolean t;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f16316g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16317h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16318i = false;
    public NoNetworkView.b k = new g();
    public x.b l = new h();
    public CustomMessageListener m = new i(2001378);
    public CustomMessageListener n = new j(2921323);
    public CustomMessageListener o = new k(2921445);
    public CustomMessageListener p = new l(2001371);
    public CustomMessageListener q = new m(2001384);
    public CustomMessageListener r = new n(2921308);
    public CustomMessageListener s = new o(2921392);
    public CustomMessageListener u = new a(2001011);
    public d.a.k0.a1.c.b v = new b();
    public ConcernPageView.l w = new c();
    public CustomMessageListener x = new f(2921455);

    /* loaded from: classes4.dex */
    public static class ControlModelMessage extends CustomMessage<d.a.k0.a1.c.c> {
        public ControlModelMessage(d.a.k0.a1.c.c cVar) {
            super(2001406);
            setData(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
                    RecommendFrsControlFragment.this.f16315f.b(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.k0.a1.c.b {
        public b() {
        }

        @Override // d.a.k0.a1.c.b
        public void b() {
        }

        @Override // d.a.k0.a1.c.b
        public void c(int i2, d.a.j0.z0.c cVar, int i3) {
            RecommendFrsControlFragment.this.f16315f.h(1, i2, cVar, 1, i3);
            if (d.a.c.e.p.j.A()) {
                TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
            }
        }

        @Override // d.a.k0.a1.c.b
        public void d(int i2, int i3, d.a.j0.z0.c cVar, int i4) {
            RecommendFrsControlFragment.this.f16315f.h(2, i3, cVar, i2, i4);
            if (d.a.c.e.p.j.A()) {
                TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ConcernPageView.l {
        public c() {
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void a(boolean z, boolean z2) {
            if (!z) {
                if (z2) {
                    RecommendFrsControlFragment.this.f16315f.b(false);
                    return;
                }
                return;
            }
            RecommendFrsControlFragment.this.f16314e.setShowConcernRedTip(false);
            if (RecommendFrsControlFragment.this.f16317h) {
                if (!RecommendFrsControlFragment.this.isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
            }
            RecommendFrsControlFragment.this.f16317h = false;
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void b(d.a.j0.z0.c cVar) {
            RecommendFrsControlFragment.this.f16315f.g("", cVar);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.l
        public void c(String str, d.a.j0.z0.c cVar) {
            RecommendFrsControlFragment.this.f16315f.g(str, cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.d {
        public d() {
        }

        @Override // d.a.k0.a1.c.c.d
        public void a(boolean z) {
            if (RecommendFrsControlFragment.this.f16314e == null) {
                return;
            }
            RecommendFrsControlFragment.this.f16314e.setShowConcernRedTip(z);
            if (RecommendFrsControlFragment.this.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // d.a.k0.a1.c.c.d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            RecommendFrsControlFragment.this.f16314e.X(dataRes, z, z2);
        }

        @Override // d.a.k0.a1.c.c.d
        public void c(String str, String str2, int i2, boolean z, int i3) {
            if (RecommendFrsControlFragment.this.f16314e.A()) {
                RecommendFrsControlFragment.this.f16314e.W(str2, i2, i3);
            }
        }

        @Override // d.a.k0.a1.c.c.d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            RecommendFrsControlFragment.this.f16314e.V(dataRes, z);
        }

        @Override // d.a.k0.a1.c.c.d
        public void e(boolean z, d.a.k0.a1.h.a.a aVar, boolean z2, String str, String str2, boolean z3) {
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.j0.k0.b {
        public e() {
        }

        @Override // d.a.j0.k0.b
        public boolean canStat(d.a.j0.k0.d dVar) {
            return false;
        }

        @Override // d.a.j0.k0.b
        public int getMaxCost() {
            return d.a.j0.k0.e.b().c();
        }

        @Override // d.a.j0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.f16314e == null || RecommendFrsControlFragment.this.f16314e.getCurrentTabType() != 1) {
                return;
            }
            RecommendFrsControlFragment.this.f16314e.P();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements NoNetworkView.b {
        public g() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.f16314e.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.f16314e.P();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements x.b {
        public h() {
        }

        @Override // d.a.j0.a.x.b
        public void a() {
            if (!RecommendFrsControlFragment.this.isPrimary() || RecommendFrsControlFragment.this.j == null) {
                return;
            }
            if (d.a.c.e.p.l.D()) {
                RecommendFrsControlFragment.this.j.h(true);
                RecommendFrsControlFragment.this.j.g();
                if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().a() != null) {
                    UrlManager.getInstance().dealOneLink(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().a()});
                }
                TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "1"));
                return;
            }
            d.a.c.e.p.l.L(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
            TiebaStatic.log(new StatisticItem("c13394").param("obj_type", "2"));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (RecommendFrsControlFragment.this.f16314e != null && RecommendFrsControlFragment.this.f16314e.getCurrentTabType() != 0) {
                    RecommendFrsControlFragment.this.f16314e.setCurrentTab(0);
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.j0.r.a0.b.e(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.f16314e == null || RecommendFrsControlFragment.this.f16314e.getCurrentTabType() == 0) {
                return;
            }
            RecommendFrsControlFragment.this.f16314e.setCurrentTab(0);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.f16314e == null || RecommendFrsControlFragment.this.f16314e.getCurrentTabType() == 6) {
                return;
            }
            RecommendFrsControlFragment.this.f16314e.setFakeClickCurrentTab(6);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.j != null) {
                if (!RecommendFrsControlFragment.this.O0() || RecommendFrsControlFragment.this.j.d() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.f16318i) {
                    if (!RecommendFrsControlFragment.this.O0() && RecommendFrsControlFragment.this.j.d()) {
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
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || RecommendFrsControlFragment.this.f16314e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                    if (RecommendFrsControlFragment.this.f16314e.getCurrentTabType() == 1) {
                        d.a.j0.r.n.b.i().n(true);
                    }
                    if (RecommendFrsControlFragment.this.isPrimary()) {
                        RecommendFrsControlFragment.this.f16314e.P();
                        return;
                    } else if (RecommendFrsControlFragment.this.f16314e.getCurrentTabType() == 0) {
                        boolean F = RecommendFrsControlFragment.this.f16314e.F();
                        TiebaStatic.log(new StatisticItem("c12350").param("obj_type", F ? 1 : 0));
                        if (F) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                            RecommendFrsControlFragment.this.f16314e.P();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                d.a.j0.r.n.b.i().n(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public o(int i2) {
            super(i2);
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
                    RecommendFrsControlFragment.this.f16318i = true;
                    if (RecommendFrsControlFragment.this.j == null || !RecommendFrsControlFragment.this.j.d()) {
                        return;
                    }
                    RecommendFrsControlFragment.this.j.c();
                    return;
                }
                RecommendFrsControlFragment.this.f16318i = false;
                if (RecommendFrsControlFragment.this.j == null || !RecommendFrsControlFragment.this.isResumed() || !RecommendFrsControlFragment.this.O0() || RecommendFrsControlFragment.this.j.d()) {
                    return;
                }
                RecommendFrsControlFragment.this.j.f();
            }
        }
    }

    public final void N0() {
        d.a.k0.a1.c.c cVar = new d.a.k0.a1.c.c(getPageContext(), getUniqueId());
        this.f16315f = cVar;
        cVar.j(new d());
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.f16315f));
    }

    public final boolean O0() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        d0 shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new d0();
        }
        if (shakeData.c() == Long.MAX_VALUE || shakeData.b() == 0 || StringUtils.isNull(shakeData.a())) {
            try {
                shakeData.parserJson(new JSONObject(d.a.j0.r.d0.b.j().p("shake_data", StringUtil.EMPTY_ARRAY)));
                TbSingleton.getInstance().setShakeData(shakeData);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return currentTimeMillis > shakeData.c() && currentTimeMillis < shakeData.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public String getCurrentPageKey() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
        if (scrollFragmentTabHost != null) {
            return scrollFragmentTabHost.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public d.a.j0.k0.b getPageStayFilter() {
        return new e();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N0();
        this.f16314e.C(getPageContext(), this.k);
        this.f16314e.D(getChildFragmentManager(), this.v, this.w);
        this.f16314e.setScrollShadow(false);
        this.f16314e.setPageUniqueId(getUniqueId());
        this.f16314e.U();
        this.t = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.f16314e.getCurrentTabType() != 0) {
            this.f16315f.b(System.currentTimeMillis() > d.a.j0.r.d0.b.j().l(d.a.j0.r.d0.b.n("concern_unread_tip_next_show_time"), 0L));
        }
        d.a.k0.a1.c.a.d().h(System.currentTimeMillis() - d.a.k0.a1.c.a.d().a(1));
        d.a.j0.m0.l.b().G(System.currentTimeMillis() - d.a.k0.a1.c.a.d().a(1));
        if (d.a.j0.b.d.h()) {
            this.f16314e.R();
        } else {
            this.f16314e.S();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 18003 && (stringExtra = intent.getStringExtra("tid")) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
            if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                this.f16314e.P();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
        if (scrollFragmentTabHost != null) {
            SkinManager.setBackgroundColor(scrollFragmentTabHost, R.color.CAM_X0202);
            this.f16314e.L(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.k0.a1.c.a.d().g(System.currentTimeMillis(), 1);
        d.a.j0.m0.l.b().F(System.currentTimeMillis());
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
        this.j = new x(getContext(), this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.f16314e = scrollFragmentTabHost;
        scrollFragmentTabHost.setDrawingCacheEnabled(false);
        return this.f16314e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.m);
        this.f16314e.M();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setPrimary(isPrimary());
            this.f16314e.v();
        }
        x xVar = this.j;
        if (xVar != null && xVar.d()) {
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
        if (this.f16314e == null) {
            return;
        }
        if (isPrimary()) {
            d.a.j0.a.o.b().j(true);
            this.f16314e.I();
        } else {
            d.a.j0.a.o.b().j(false);
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
            this.f16314e.setVideoThreadId(str);
            ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
            scrollFragmentTabHost.setCurrentTab(scrollFragmentTabHost.getVideoRecommendIndex(), false);
        }
        Intent intent = getActivity().getIntent();
        if (isPrimary() && intent != null) {
            if (UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC.equals(intent.getDataString())) {
                this.f16314e.setCurrentTab(5);
                intent.setData(null);
            } else {
                int intExtra2 = intent.getIntExtra("locate_type", 0);
                String stringExtra = intent.getStringExtra("sub_tab_name");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(d.a.j0.a.f.G)) {
                    intExtra2 = 16;
                }
                if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                    this.f16314e.setCurrentTab(stringExtra);
                    intent.removeExtra("locate_type");
                    intent.removeExtra("sub_tab_name");
                } else if (intExtra2 == 16) {
                    if (this.f16314e.getCurrentTabType() != 5) {
                        TiebaStatic.log(new StatisticItem("c13888"));
                    }
                    this.f16314e.setCurrentTab(5);
                    intent.putExtra("locate_type", 0);
                } else if (intExtra2 == 2) {
                    this.f16314e.setCurrentTab(1);
                    intent.putExtra("locate_type", 0);
                }
            }
        }
        if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18)) {
            this.f16314e.setCurrentTab(6);
            getActivity().getIntent().putExtra("locate_type", 0);
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", PrefetchEvent.STATE_CLICK);
        } else {
            VoiceManager a2 = d.a.k0.d3.p0.b.a(getActivity());
            if (a2 != null) {
                a2.stopPlay();
            }
        }
        this.f16314e.setPrimary(isPrimary());
        this.f16314e.O();
        if (isPrimary()) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                str3 = getActivity().getIntent().getStringExtra(d.a.j0.a.f.C);
                getActivity().getIntent().removeExtra(d.a.j0.a.f.C);
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
                String stringExtra2 = getActivity().getIntent().getStringExtra(d.a.j0.a.f.D);
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
        Boolean bool = this.f16316g;
        if (bool == null) {
            this.f16316g = Boolean.valueOf(d.a.j0.r.k.c().g());
        } else {
            r1 = bool.booleanValue() != d.a.j0.r.k.c().g();
            this.f16316g = Boolean.valueOf(d.a.j0.r.k.c().g());
        }
        if (r1) {
            this.f16314e.x();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setPrimary(isPrimary());
            this.f16314e.N();
        }
        if (this.j == null || !O0() || this.j.d() || this.f16318i) {
            return;
        }
        this.j.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.J();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (z) {
            return;
        }
        this.f16314e.v();
    }

    @Override // d.a.j0.r.g
    public void u0(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("sub_locate_type", 0);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f16314e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.setCurrentTab(intExtra);
        }
    }
}
