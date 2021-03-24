package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.frs.view.FrsForumToolDialogView;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import d.b.h0.r.s.a;
import d.b.i0.p0.j0;
import d.b.i0.p0.r0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabController implements d.b.i0.e.e.b, VoiceManager.j, FrsCommonImageLayout.e {
    public static final String a0 = FrsFragment.class.getSimpleName();
    public static final String b0 = FrsTabHostFragment.class.getSimpleName();
    public d.b.i0.b0.e C;
    public d.b.i0.p0.m2.e D;
    public Runnable E;
    public boolean F;

    /* renamed from: e  reason: collision with root package name */
    public FrsActivity f16439e;

    /* renamed from: f  reason: collision with root package name */
    public FrsFragment f16440f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabHostFragment f16441g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c3.m f16442h;
    public j0 i;
    public String l;
    public String m;
    public int p;
    public ShareSuccessReplyToServerModel q;
    public FrsBaseViewPager s;
    public FragmentAdapter t;
    public OvalActionButton u;
    public FRSRefreshButton v;
    public LinearLayout w;
    public boolean x;
    public boolean y;
    public NavigationBarCoverTip z;
    public boolean j = false;
    public final Handler k = new Handler();
    public int n = 0;
    public boolean r = false;
    public boolean A = false;
    public boolean B = false;
    public boolean G = false;
    public boolean H = false;
    public HttpMessageListener I = new a(CmdConfigHttp.CMD_FRS_RECOMMEND);
    public CustomMessageListener J = new l(2921465);
    public d.b.b.c.g.a K = new v(CmdConfigHttp.FRS_HTTP_CMD, 301001);
    public CustomMessageListener L = new w(2001615);
    public CustomMessageListener M = new x(2921342);
    public CustomMessageListener N = new y(2001627);
    public HttpMessageListener O = new z(0);
    public CustomMessageListener P = new a0(2921518);
    public Runnable Q = new b0();
    public CustomMessageListener R = new b(2005016);
    public CustomMessageListener S = new c(2921369);
    public CustomMessageListener T = new d(2921370);
    public CustomMessageListener U = new e(2001375);
    public CustomMessageListener V = new f(2921498);
    public CustomMessageListener W = new g(2001437);
    public ViewPager.OnPageChangeListener X = new h();
    public FrsBaseViewPager.a Y = new i();
    public Runnable Z = new r();
    public String o = d.b.h0.r.d0.b.m("show_game_forem_tab_hot_point");

    /* loaded from: classes4.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<BaseFragment> f16443a;

        public FragmentAdapter(FrsTabController frsTabController, FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f16443a = new ArrayList(2);
        }

        public boolean a(int i, BaseFragment baseFragment) {
            return ListUtils.add(this.f16443a, i, baseFragment);
        }

        public BaseFragment b(String str) {
            if (d.b.b.e.p.k.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.f16443a) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f16443a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        /* renamed from: i */
        public BaseFragment getItem(int i) {
            return (BaseFragment) ListUtils.getItem(this.f16443a, i);
        }

        public String j(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }

        public BaseFragment k(int i) {
            return (BaseFragment) ListUtils.remove(this.f16443a, i);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {

        /* renamed from: com.baidu.tieba.frs.gametab.FrsTabController$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0189a implements View.OnClickListener {
            public View$OnClickListenerC0189a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", FrsTabController.this.f16442h.getForum().getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.c3.h0.m(FrsTabController.this.f16439e, "RecommendHistoryPage", hashMap)));
            }
        }

        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof FrsRecommendResMsg) {
                if (httpResponsedMessage.getError() == 0) {
                    FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                    int pushStatus = frsRecommendResMsg.getPushStatus();
                    String pushMsg = frsRecommendResMsg.getPushMsg();
                    if (pushStatus == 1) {
                        ScreenTopToast screenTopToast = new ScreenTopToast(FrsTabController.this.f16439e);
                        screenTopToast.m(FrsTabController.this.f16439e.getString(R.string.frs_recommend_suc_tip_title));
                        screenTopToast.l(FrsTabController.this.f16439e.getString(R.string.frs_recommend_suc_tip_content));
                        screenTopToast.k(FrsTabController.this.f16439e.getString(R.string.dialog_confirm_see));
                        screenTopToast.j(new View$OnClickListenerC0189a());
                        screenTopToast.n((ViewGroup) FrsTabController.this.f16439e.findViewById(R.id.frs));
                        return;
                    }
                    BdTopToast bdTopToast = new BdTopToast(FrsTabController.this.f16439e);
                    bdTopToast.i(false);
                    bdTopToast.h(pushMsg);
                    bdTopToast.j((ViewGroup) FrsTabController.this.f16439e.findViewById(R.id.frs));
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(FrsTabController.this.f16439e);
                bdTopToast2.i(false);
                bdTopToast2.h(httpResponsedMessage.getErrorString());
                bdTopToast2.j((ViewGroup) FrsTabController.this.f16439e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public a0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdTopToast bdTopToast = new BdTopToast(FrsTabController.this.f16439e, 2000);
            bdTopToast.i(false);
            bdTopToast.h(FrsTabController.this.f16439e.getString(R.string.frs_top_forum_rules_click_toast));
            bdTopToast.j((ViewGroup) FrsTabController.this.f16439e.findViewById(R.id.frs));
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            FrsTabController.this.r = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.e.m.e.a().removeCallbacks(this);
            FrsTabController.this.a0();
            d.b.b.e.m.e.a().postDelayed(this, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
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
            if (customResponsedMessage == null || FrsTabController.this.s == null || FrsTabController.this.t == null || !(customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                return;
            }
            FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
            FrsTabController.this.x = aVar.a();
            FrsTabController.this.y = aVar.b();
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
            if (customResponsedMessage == null || FrsTabController.this.s == null || FrsTabController.this.t == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            FrsTabController.this.s.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FrsTabController.this.K(null);
            }
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
            if (FrsTabController.this.D == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                FrsTabController.this.K((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (FrsTabController.this.Z(longValue) && FrsTabController.this.D.a(longValue) >= 3) {
                    FrsTabController.this.D.b(longValue);
                    FrsTabController.this.G = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.q0.e)) {
                return;
            }
            d.b.i0.c3.q0.e eVar = (d.b.i0.c3.q0.e) customResponsedMessage.getData();
            if (FrsTabController.this.D == null || eVar == null || !TbadkCoreApplication.isLogin()) {
                return;
            }
            FrsTabController.this.D.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(eVar.f53593a));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ViewPager.OnPageChangeListener {
        public h() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i != 0) {
                return;
            }
            FrsTabController.this.y = false;
            FrsTabController.this.s.setForceIntercept(false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                return;
            }
            FrsTabController.this.u.setVisibility(0);
            if (FrsTabController.this.M() != null) {
                FrsTabController.this.M().l3(false);
            }
            FrsTabController.this.f16440f.J3();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements FrsBaseViewPager.a {
        public i() {
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean a() {
            if (FrsTabController.this.s.getCurrentItem() == 0) {
                if (FrsTabController.this.x && FrsTabController.this.y) {
                    FrsTabController.this.s.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.y) {
                    FrsTabController.this.s.setmDisallowSlip(true);
                }
                FrsTabController.this.s.setmDisallowSlip(true);
            } else {
                FrsTabController.this.s.setmDisallowSlip(true);
            }
            return true;
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void b() {
            if (FrsTabController.this.s == null) {
                return;
            }
            if (FrsTabController.this.s.getCurrentItem() == 0) {
                FrsTabController.this.s.setmDisallowSlip(true);
            } else {
                FrsTabController.this.s.setmDisallowSlip(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrsTabController.this.s0();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrsTabController frsTabController = FrsTabController.this;
            boolean I = frsTabController.I(frsTabController.f16442h.getGameTabInfo());
            if (I) {
                FrsTabController.this.t.notifyDataSetChanged();
                if (I && FrsTabController.this.f16441g != null) {
                    FrsTabController.this.f16441g.p1(FrsTabController.this.f16440f);
                    FrsTabController.this.f16441g.m1(FrsTabController.this.f16442h, FrsTabController.this.i);
                }
            }
            if (FrsTabController.this.f16439e.isLoadingViewAttached()) {
                FrsTabController.this.f16439e.hideLoadingView(FrsTabController.this.f16439e.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", FrsTabController.this.f16442h.getForum().getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.c3.h0.m(FrsTabController.this.f16439e, "ForumGradePage", hashMap)));
            }
        }

        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ScreenTopToast screenTopToast = new ScreenTopToast(FrsTabController.this.f16439e);
            screenTopToast.m(FrsTabController.this.f16439e.getString(R.string.frs_recommend_fail_month_tip));
            screenTopToast.k(FrsTabController.this.f16439e.getString(R.string.frs_recommend_fail_tip_btn));
            screenTopToast.j(new a());
            screenTopToast.n((ViewGroup) FrsTabController.this.f16439e.findViewById(R.id.frs));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrsTabController.this.f16440f.O = true;
            FrsTabController.this.V(FrsTabController.this.f16440f != null ? FrsTabController.this.f16440f.getArguments() : null);
            FrsTabController.this.t.notifyDataSetChanged();
            if (FrsTabController.this.f16439e.isLoadingViewAttached()) {
                FrsTabController.this.f16439e.hideLoadingView(FrsTabController.this.f16439e.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f16461e;

        public n(FrsTabController frsTabController, d.b.h0.r.s.a aVar) {
            this.f16461e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = this.f16461e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f16462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16464g;

        public o(d.b.h0.r.s.a aVar, int i, String str) {
            this.f16462e = aVar;
            this.f16463f = i;
            this.f16464g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = this.f16462e;
            if (aVar != null) {
                aVar.dismiss();
            }
            int i = this.f16463f;
            if (i == 1) {
                UrlManager.getInstance().dealOneLink(FrsTabController.this.f16439e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + FrsTabController.this.M().i() + "&fid=" + FrsTabController.this.M().h()});
            } else if (i == 2) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", FrsTabController.this.M().h());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.c3.h0.m(FrsTabController.this.f16439e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
            } else if (i != 3 || TextUtils.isEmpty(this.f16464g)) {
            } else {
                UrlManager.getInstance().dealOneLink(FrsTabController.this.f16439e.getPageContext(), new String[]{this.f16464g});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f16466e;

        public p(FrsTabController frsTabController, d.b.h0.r.s.a aVar) {
            this.f16466e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f16466e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a extends d.b.h0.e0.b {
            public a() {
            }

            @Override // d.b.h0.e0.b
            public d.b.h0.e0.c createFragmentTabStructure() {
                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", FrsTabController.this.f16440f.i());
                bundle.putString("from", FrsTabController.this.f16440f.q2());
                bundle.putString("forum_id", FrsTabController.this.f16440f.h());
                bundle.putInt("tab_id", 503);
                bundle.putBoolean("can_auto_play_video", FrsTabController.this.f16442h.isFrsVideoAutoPlay);
                bundle.putBoolean("need_log", FrsTabController.this.f16442h.needLog == 1);
                bundle.putBoolean("is_brand_forum", FrsTabController.this.f16442h.isBrandForum);
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(FrsTabController.this.f16442h);
                bundle.putSerializable("view_data", frsViewData);
                frsSportsRecommendFragment.setArguments(bundle);
                d.b.h0.e0.c cVar = new d.b.h0.e0.c();
                cVar.f50154a = frsSportsRecommendFragment;
                cVar.f50158e = 25;
                cVar.f50161h = d.b.h0.e0.c.j;
                return cVar;
            }

            @Override // d.b.h0.e0.b
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                this.mIndicator = fragmentTabIndicator;
                fragmentTabIndicator.setTextSize(2.0f);
                return this.mIndicator;
            }

            @Override // d.b.h0.e0.b
            public boolean isAvailable() {
                return true;
            }
        }

        public q(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof j0)) {
                return;
            }
            if (!d.b.h0.r.d0.b.i().g(FrsTabController.this.o, true)) {
                d.b.b.e.m.e.a().post(FrsTabController.this.Q);
            }
            ((j0) customResponsedMessage.getData()).a(new a());
            FrsTabController.this.W();
        }
    }

    /* loaded from: classes4.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                parseUri.setFlags(268435456);
                FrsTabController.this.f16439e.startActivity(parseUri);
                TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f16471e;

            public a(CustomDialogData customDialogData) {
                this.f16471e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FrsTabController.this.f16439e != null) {
                    d.b.i0.c2.j.c.a(FrsTabController.this.f16439e.getPageContext(), this.f16471e).show();
                }
            }
        }

        public s() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            d.b.b.e.m.e.a().postDelayed(new a(customDialogData), 1000L);
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new StatisticItem("c13439").eventStat();
            if (FrsTabController.this.M() == null || TextUtils.isEmpty(FrsTabController.this.M().h()) || TextUtils.isEmpty(FrsTabController.this.l) || FrsTabController.this.f16439e == null) {
                return;
            }
            if (FrsTabController.this.z != null) {
                FrsTabController.this.z.e();
            }
            int i = d.b.h0.r.d0.b.i().j("key_bawu_task_toast", 0) == -1 ? 1 : 0;
            UrlManager.getInstance().dealOneLink(FrsTabController.this.f16439e.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.M().h() + "&fn=" + FrsTabController.this.l + "&noread=" + i});
        }
    }

    /* loaded from: classes4.dex */
    public class u implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumData f16474e;

        public u(ForumData forumData) {
            this.f16474e = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrsTabController.this.D == null) {
                return;
            }
            if (FrsTabController.this.H) {
                FrsTabController.this.v0(this.f16474e.getName(), this.f16474e.getId(), this.f16474e.getImage_url(), true);
            } else {
                FrsTabController.this.G = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends d.b.b.c.g.a {
        public v(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.c3.m mVar;
            int i;
            if (FrsTabController.this.j || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                mVar = frsPageHttpResponseMessage.getResponseData();
                i = frsPageHttpResponseMessage.getUpdateType();
            } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                mVar = fRSPageSocketResponsedMessage.getResponseData();
                i = fRSPageSocketResponsedMessage.getUpdateType();
            } else {
                mVar = null;
                i = -1;
            }
            if (mVar != null) {
                FrsTabController.this.j = true;
                FrsTabController.this.m0(mVar, true, i);
                if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                    d.b.h0.r.o.b.b().l("2", mVar.getForum().getId());
                }
            }
            if (mVar == null || mVar.getUserData() == null || mVar.getUserData().getNewGodData() == null) {
                return;
            }
            if (mVar.getForum() != null) {
                d.b.h0.z0.y.g().j(mVar.getForum().getId());
            }
            d.b.h0.z0.y.g().k(2, mVar.getUserData().getNewGodData());
        }
    }

    /* loaded from: classes4.dex */
    public class w extends CustomMessageListener {
        public w(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.j && FrsTabController.this.f16442h == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.i0.c3.m)) {
                d.b.i0.c3.m mVar = (d.b.i0.c3.m) customResponsedMessage.getData();
                if (mVar.getForum() == null || FrsTabController.this.l == null || !FrsTabController.this.l.equals(mVar.getForum().getName())) {
                    return;
                }
                FrsTabController.this.m0(mVar, false, -1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {
        public x(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.H();
        }
    }

    /* loaded from: classes4.dex */
    public class y extends CustomMessageListener {
        public y(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int P;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (10001 == intValue) {
                P = FrsTabController.this.P(9);
                if (P == -1) {
                    P = FrsTabController.this.P(2);
                }
            } else {
                P = FrsTabController.this.P(intValue);
            }
            if (P == -1 || !FrsTabController.this.Y() || FrsTabController.this.f16441g == null) {
                return;
            }
            FrsTabController.this.f16441g.n1(P);
            if (FrsTabController.this.O(P) != 1) {
                FrsTabController.this.f16440f.e3(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends HttpMessageListener {
        public z(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<d.b.i0.p0.x1.a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || FrsTabController.this.f16441g == null) {
                    return;
                }
                for (d.b.i0.p0.x1.a aVar : newNotifyData) {
                    if (aVar != null) {
                        for (int i2 = 0; i2 < FrsTabController.this.i.g().size(); i2++) {
                            FragmentTabHost.b g1 = FrsTabController.this.f16441g.g1(i2);
                            if (g1 != null && (i = g1.f13310a) != 1 && i != FrsTabController.this.f16441g.Z0() && g1.f13310a == aVar.a() && aVar.b() && g1.f13311b.d(String.valueOf(g1.f13310a)) != null) {
                                g1.f13311b.d(String.valueOf(g1.f13310a)).f13955a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.f16439e = frsActivity;
    }

    public final void H() {
        if (this.p != this.n && Y()) {
            this.f16441g.n1(this.n);
            if (O(this.n) != 1) {
                this.f16440f.e3(false);
            }
            this.p = this.n;
            r0(this.f16441g.Y0(), this.n);
            return;
        }
        this.f16440f.g2();
    }

    public final boolean I(List<FrsTabInfo> list) {
        if (this.f16439e.isLoadingViewAttached()) {
            FrsActivity frsActivity = this.f16439e;
            frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
        }
        if (Y()) {
            return false;
        }
        this.f16440f.O = true;
        o0();
        if (d.b.h0.r.d0.b.i().g("frs_game_login_tip", true)) {
            d.b.h0.r.d0.b.i().s("frs_login_tip", true);
            d.b.h0.r.d0.b.i().s("frs_game_login_tip", false);
        }
        X(list);
        return true;
    }

    public final void J(ForumData forumData) {
        boolean z2 = false;
        if (v0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.E != null) {
                d.b.b.e.m.e.a().removeCallbacks(this.E);
            }
            z2 = true;
        }
        if (!this.F) {
            this.D.e().h(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
            this.F = true;
        }
        if (z2) {
            return;
        }
        Runnable runnable = this.E;
        if (runnable == null) {
            runnable = new u(forumData);
        }
        this.E = runnable;
        d.b.b.e.m.e.a().postDelayed(this.E, 60000L);
    }

    public final void K(ForumData forumData) {
        if (this.f16440f.w0() == null || this.D == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.f16442h.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.H) {
            this.G = true;
        } else if (!v0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.E == null) {
        } else {
            d.b.b.e.m.e.a().removeCallbacks(this.E);
        }
    }

    public final FragmentManager L() {
        FrsActivity frsActivity = this.f16439e;
        if (frsActivity != null) {
            return frsActivity.getSupportFragmentManager();
        }
        return null;
    }

    public FrsFragment M() {
        return this.f16440f;
    }

    public FragmentTabHost N() {
        FrsTabHostFragment frsTabHostFragment = this.f16441g;
        if (frsTabHostFragment == null) {
            return null;
        }
        return frsTabHostFragment.c1();
    }

    public final int O(int i2) {
        j0 j0Var = this.i;
        if (j0Var != null && i2 < ListUtils.getCount(j0Var.g())) {
            return this.i.g().get(i2).tab_id.intValue();
        }
        return -1;
    }

    public final int P(int i2) {
        j0 j0Var = this.i;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i3 = 0; i3 < count; i3++) {
            if (this.i.g().get(i3).tab_id.intValue() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public TbPageTag Q() {
        if (!Y()) {
            return this.f16440f.getTbPageTag();
        }
        FrsTabHostFragment frsTabHostFragment = this.f16441g;
        if (frsTabHostFragment != null) {
            if (1 == frsTabHostFragment.Z0()) {
                return this.f16440f.getTbPageTag();
            }
            Fragment Y0 = this.f16441g.Y0();
            if (Y0 instanceof BaseFragment) {
                return ((BaseFragment) Y0).getTbPageTag();
            }
        }
        return null;
    }

    public d.b.i0.c3.m R() {
        return this.f16442h;
    }

    public final boolean S(d.b.i0.c3.m mVar) {
        if (mVar != null && mVar.getUserData() != null) {
            int is_manager = mVar.getUserData().getIs_manager();
            boolean g2 = d.b.h0.r.d0.b.i().g("key_forum_tool_find_dialog_show", false);
            if (is_manager == 1 && !g2) {
                u0(1, this.f16439e.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
                d.b.h0.r.d0.b.i().s("key_forum_tool_find_dialog_show", true);
                return true;
            } else if (!g2 && is_manager == 2) {
                u0(2, this.f16439e.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
                d.b.h0.r.d0.b.i().s("key_forum_tool_find_dialog_show", true);
                return true;
            } else {
                AddBawuPopInfo addBawuPopInfo = mVar.bawuPopInfo;
                if (addBawuPopInfo != null) {
                    u0(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url);
                    return true;
                }
            }
        }
        return false;
    }

    public final void T(ForumData forumData, AntiData antiData) {
        if (forumData == null || d.b.h0.c1.b.a.g(this.f16439e.getPageContext(), antiData, R.id.frs) || w0(forumData)) {
            return;
        }
        List<TipInfo> tipInfos = forumData.getTipInfos();
        if (ListUtils.isEmpty(tipInfos)) {
            return;
        }
        d.b.h0.c1.b.a.f(this.f16439e.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.f16439e.getString(R.string.frs_risk_dialog_button_text));
    }

    public void U(Bundle bundle) {
        FrsActivity frsActivity = this.f16439e;
        if (frsActivity == null) {
            return;
        }
        frsActivity.setContentView(R.layout.frs_base_layout);
        this.s = (FrsBaseViewPager) this.f16439e.findViewById(R.id.frs_base_viewpager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.f16439e.getSupportFragmentManager());
        this.t = fragmentAdapter;
        this.s.setAdapter(fragmentAdapter);
        this.s.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.s.addOnPageChangeListener(this.X);
        this.s.setmDisallowSlip(true);
        this.s.setOnTouchEventListener(this.Y);
        OvalActionButton ovalActionButton = (OvalActionButton) this.f16439e.findViewById(R.id.frs_post_forum_button);
        this.u = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.u.setHasShadow(false);
        this.v = (FRSRefreshButton) this.f16439e.findViewById(R.id.frs_refresh_forum_button);
        this.w = (LinearLayout) this.f16439e.findViewById(R.id.frs_ll_redpack);
        this.f16439e.registerListener(this.S);
        this.f16439e.registerListener(this.T);
        this.K.getHttpMessageListener().setPriority(-1);
        this.K.getSocketMessageListener().setPriority(-1);
        this.f16439e.registerListener(this.L);
        this.N.setSelfListener(true);
        this.f16439e.registerListener(this.N);
        this.M.setSelfListener(true);
        this.f16439e.registerListener(this.M);
        this.f16439e.registerListener(this.R);
        if (bundle == null) {
            this.l = this.f16439e.getIntent().getStringExtra("name");
            this.m = this.f16439e.getIntent().getStringExtra("from");
            this.n = this.f16439e.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.l = bundle.getString("name");
            this.m = bundle.getString("from");
            this.n = bundle.getInt("default_tab_id", 0);
        }
        V(bundle);
        this.t.notifyDataSetChanged();
        this.q = new ShareSuccessReplyToServerModel();
        this.f16439e.registerListener(this.K);
        this.f16439e.registerListener(this.I);
        this.f16439e.registerListener(this.J);
        this.f16439e.registerListener(this.P);
    }

    public final void V(Bundle bundle) {
        FragmentAdapter fragmentAdapter;
        FragmentManager L = L();
        if (L == null || L.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsFragment frsFragment = (FrsFragment) fragmentAdapter.b(a0);
            if (frsFragment == null) {
                frsFragment = b0(bundle);
            }
            frsFragment.r3(this.u);
            frsFragment.t3(this.v);
            frsFragment.s3(this.w);
            if (a0.equals(this.t.j(0))) {
                return;
            }
            if (b0.equals(this.t.j(0))) {
                this.t.k(0);
            }
            this.t.a(0, frsFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void W() {
        FragmentAdapter fragmentAdapter;
        FragmentManager L = L();
        if (L == null || L.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) fragmentAdapter.b(b0);
            if (frsTabHostFragment == null) {
                frsTabHostFragment = c0();
            }
            frsTabHostFragment.r1(this.u);
            frsTabHostFragment.q1(this.v);
            if (b0.equals(this.t.j(0))) {
                return;
            }
            if (a0.equals(this.t.j(0))) {
                this.t.k(0);
            }
            this.t.a(0, frsTabHostFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void X(List<FrsTabInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        q qVar = new q(2001616);
        qVar.setPriority(Integer.MAX_VALUE);
        qVar.setSelfListener(true);
        this.f16439e.registerListener(qVar);
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = list.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    FrsTabInfo frsTabInfo = (FrsTabInfo) it2.next();
                    if (frsTabInfo != null && frsTabInfo.tab_id == next.tab_id) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
            }
        }
        this.i = new j0(this.f16439e.getActivity(), arrayList);
        if (M() != null) {
            this.i.k(M().h());
            this.i.l(M().i());
            if (M().S() != null && M().S().getForum() != null) {
                ForumData forum = M().S().getForum();
                this.i.j(forum.getForumGameLabel());
                this.i.m(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.f16440f;
        frsFragment.O = false;
        new d.b.i0.p0.x1.e(frsFragment).a(this.i);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.i);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.f16439e.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean Y() {
        FragmentAdapter fragmentAdapter = this.t;
        if (fragmentAdapter == null) {
            return false;
        }
        return fragmentAdapter.getItem(0) instanceof FrsTabHostFragment;
    }

    public boolean Z(long j2) {
        ForumData forum;
        d.b.i0.c3.m mVar = this.f16442h;
        return (mVar == null || j2 == 0 || (forum = mVar.getForum()) == null || d.b.b.e.m.b.f(forum.getId(), 0L) != j2) ? false : true;
    }

    public final void a0() {
        j0 j0Var = this.i;
        if (j0Var == null || TextUtils.isEmpty(j0Var.d())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.f16442h.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment b0(Bundle bundle) {
        if (this.f16440f == null) {
            FrsFragment frsFragment = new FrsFragment();
            this.f16440f = frsFragment;
            frsFragment.setArguments(bundle);
            this.f16440f.setBaseTag(a0);
        }
        FrsFragment frsFragment2 = this.f16440f;
        frsFragment2.O = false;
        return frsFragment2;
    }

    public final FrsTabHostFragment c0() {
        if (this.f16441g == null) {
            FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
            this.f16441g = frsTabHostFragment;
            frsTabHostFragment.setBaseTag(b0);
            this.f16441g.o1(this.n);
        }
        return this.f16441g;
    }

    public void d0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        if (!Y()) {
            this.f16440f.onActivityResult(i2, i3, intent);
        } else {
            FrsTabHostFragment frsTabHostFragment = this.f16441g;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.Z0()) {
                    this.f16440f.onActivityResult(i2, i3, intent);
                } else {
                    Fragment Y0 = this.f16441g.Y0();
                    if (Y0 != null) {
                        Y0.onActivityResult(i2, i3, intent);
                    }
                }
            }
        }
        if (i3 == -1) {
            if (i2 != 24007) {
                if (i2 == 13011) {
                    d.b.i0.q2.a.g().m(this.f16439e.getPageContext());
                    return;
                }
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                d.b.i0.q2.a.g().m(this.f16439e.getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.q) == null) {
                    return;
                }
                shareSuccessReplyToServerModel.s(str, intExtra2, new s());
            }
        }
    }

    @Override // d.b.i0.e.e.b
    public void dispatchInjectPluginMessage(d.b.i0.e.d dVar) {
        FrsFragment frsFragment = this.f16440f;
        if (frsFragment instanceof d.b.i0.e.e.b) {
            frsFragment.dispatchInjectPluginMessage(dVar);
        }
    }

    public void e0(int i2) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 1 && skinType != 4) {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.f16439e);
        } else {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f16439e);
        }
        FrsFragment frsFragment = this.f16440f;
        if (frsFragment != null) {
            frsFragment.onChangeSkinType(i2);
        }
        FrsTabHostFragment frsTabHostFragment = this.f16441g;
        if (frsTabHostFragment != null) {
            frsTabHostFragment.onChangeSkinType(i2);
        }
        n0();
    }

    public void f0() {
        d.b.i0.p0.m2.e eVar;
        MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
        this.k.removeCallbacksAndMessages(null);
        if (this.f16439e.isLoadingViewAttached()) {
            FrsActivity frsActivity = this.f16439e;
            frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
        }
        if (this.Q != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.Q);
        }
        d.b.h0.r.d0.b.i().s(this.o, false);
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.q;
        if (shareSuccessReplyToServerModel != null) {
            shareSuccessReplyToServerModel.cancelLoadData();
        }
        FrsFragment frsFragment = this.f16440f;
        if (frsFragment != null && frsFragment.M() != null) {
            this.f16440f.M().z0();
        }
        NavigationBarCoverTip navigationBarCoverTip = this.z;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.m)) {
            new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.m)) {
            d.b.h0.x.d.h().i(false);
        }
        if (this.E != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.E);
        }
        d.b.i0.c3.m mVar = this.f16442h;
        if (mVar != null && mVar.getForum() != null && (eVar = this.D) != null) {
            eVar.b(d.b.b.e.m.b.f(this.f16442h.getForum().getId(), 0L));
        }
        d.b.b.e.m.e.a().removeCallbacks(this.Z);
    }

    public boolean g0(int i2, KeyEvent keyEvent) {
        FrsTabHostFragment frsTabHostFragment;
        if (i2 != 4) {
            if (i2 == 24) {
                FrsFragment frsFragment = this.f16440f;
                if (frsFragment == null || !frsFragment.isAdded()) {
                    return false;
                }
                return this.f16440f.onKeyDown(i2, keyEvent);
            }
            return this.f16439e.onSuperKeyDown(i2, keyEvent);
        } else if (Y() && (frsTabHostFragment = this.f16441g) != null && frsTabHostFragment.j1()) {
            this.f16441g.i1();
            UtilHelper.setNavigationBarBackground(this.f16439e, this.f16441g.X0());
            return false;
        } else {
            FrsFragment frsFragment2 = this.f16440f;
            if (frsFragment2 != null && frsFragment2.isAdded()) {
                if (this.f16440f.onKeyDown(i2, keyEvent)) {
                    return true;
                }
                H();
                return false;
            }
            return this.f16439e.onSuperKeyDown(i2, keyEvent);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.b.b.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        if (!Y()) {
            FrsFragment frsFragment = this.f16440f;
            if (frsFragment instanceof FrsCommonImageLayout.e) {
                return ((FrsCommonImageLayout.e) frsFragment).getFrsCommonImageLayoutPool();
            }
        } else {
            FrsTabHostFragment frsTabHostFragment = this.f16441g;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment Y0 = frsTabHostFragment.Y0();
            if (Y0 instanceof FrsCommonImageLayout.e) {
                return ((FrsCommonImageLayout.e) Y0).getFrsCommonImageLayoutPool();
            }
        }
        return null;
    }

    @Override // d.b.i0.e.e.b
    public d.b.i0.e.e.a getInjectPlugin(int i2) {
        FrsFragment frsFragment = this.f16440f;
        if (frsFragment instanceof d.b.i0.e.e.b) {
            return frsFragment.getInjectPlugin(i2);
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (!Y()) {
            return this.f16440f.getVoiceManager();
        }
        FrsTabHostFragment frsTabHostFragment = this.f16441g;
        if (frsTabHostFragment == null) {
            return null;
        }
        Fragment Y0 = frsTabHostFragment.Y0();
        if (Y0 instanceof VoiceManager.j) {
            return ((VoiceManager.j) Y0).getVoiceManager();
        }
        return null;
    }

    public void h0(Intent intent) {
        FrsFragment frsFragment = this.f16440f;
        if (frsFragment != null) {
            frsFragment.onNewIntent(intent);
        }
    }

    public void i0() {
        this.H = false;
        d.b.i0.p0.m2.e eVar = this.D;
        if (eVar != null) {
            eVar.d();
        }
        if (!Y()) {
            this.f16440f.setPrimary(false);
        } else {
            FrsTabHostFragment frsTabHostFragment = this.f16441g;
            if (frsTabHostFragment != null) {
                Fragment Y0 = frsTabHostFragment.Y0();
                if (Y0 instanceof BaseFragment) {
                    ((BaseFragment) Y0).setPrimary(false);
                }
            }
        }
        d.b.h0.z0.y.g().i();
        if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
            d.b.b.e.m.e.a().postDelayed(this.Z, 1000L);
        }
    }

    public void j0() {
        if (!Y()) {
            this.f16440f.setPrimary(true);
        } else {
            FrsTabHostFragment frsTabHostFragment = this.f16441g;
            if (frsTabHostFragment != null) {
                Fragment Y0 = frsTabHostFragment.Y0();
                if (Y0 instanceof BaseFragment) {
                    ((BaseFragment) Y0).setPrimary(true);
                }
            }
        }
        if (this.r) {
            this.r = false;
            FrsFragment frsFragment = this.f16440f;
            if (frsFragment != null) {
                frsFragment.refresh();
            }
        }
        d.b.i0.c3.m mVar = this.f16442h;
        if (mVar != null && mVar.getUserData() != null && this.f16442h.getUserData().getNewGodData() != null) {
            if (this.f16442h.getForum() != null) {
                d.b.h0.z0.y.g().j(this.f16442h.getForum().getId());
            }
            d.b.h0.z0.y.g().k(2, this.f16442h.getUserData().getNewGodData());
        }
        this.H = true;
        if (this.G) {
            K(null);
        }
    }

    public void k0(Bundle bundle) {
        bundle.putString("name", this.l);
        bundle.putInt("default_tab_id", this.n);
        bundle.putString("from", this.m);
    }

    public void l0(String str) {
        d.b.i0.c3.m mVar = this.f16442h;
        if (mVar == null || mVar.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f16442h.getForum().getId()).param("obj_type", 2));
    }

    public final void m0(d.b.i0.c3.m mVar, boolean z2, int i2) {
        if (mVar == null || mVar.getForum() == null) {
            return;
        }
        this.f16442h = mVar;
        ForumData forum = mVar.getForum();
        if (!S(mVar)) {
            if (z2) {
                T(forum, mVar.getAnti());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
        }
        if (forum.getIsShowBawuTask() && d.b.h0.r.d0.b.i().j("key_bawu_task_toast", 0) == 0 && !this.A) {
            this.A = true;
            d.b.b.e.m.e.a().postDelayed(new j(), StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        }
        if (mVar.bazhuExam != null && !this.B && z2) {
            d.b.i0.p0.m.a(this.f16439e.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
            this.B = true;
        }
        if (ListUtils.getCount(mVar.getGameTabInfo()) > 0) {
            this.k.post(new k());
        } else if (Y()) {
            this.k.post(new m());
        }
        n0();
        t0();
        if (z2) {
            if ((!this.F || i2 == 4) && forum.isLike() == 0 && d.b.h0.b.d.P() && TbadkCoreApplication.isLogin()) {
                this.D = new d.b.i0.p0.m2.e();
                this.f16439e.registerListener(this.V);
                this.f16439e.registerListener(this.U);
                this.f16439e.registerListener(this.W);
                J(forum);
            }
        }
    }

    public final void n0() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        d.b.i0.c3.m mVar = this.f16442h;
        if (mVar == null || (themeColorInfo = mVar.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = themeColorInfo.dark;
        } else if (skinType == 1) {
            themeElement = themeColorInfo.night;
        } else {
            themeElement = themeColorInfo.day;
        }
        this.u.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
    }

    public final void o0() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f16439e.registerListener(1021074, this.O);
    }

    public void p0(int i2) {
        this.n = i2;
    }

    public void q0(int i2) {
        this.p = i2;
    }

    public final void r0(Fragment fragment, int i2) {
        d.b.i0.c3.m mVar;
        NavigationBar Q;
        if (!(fragment instanceof r0) || (mVar = this.f16442h) == null || mVar.getForum() == null || (Q = ((r0) fragment).Q()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f16442h.getForum().getName(), 5, true, true) + this.f16439e.getActivity().getString(R.string.forum));
        Q.setCenterTextTitle(sb.toString());
    }

    public final void s0() {
        FrsActivity frsActivity = this.f16439e;
        if (frsActivity == null) {
            return;
        }
        if (this.z == null) {
            this.z = (NavigationBarCoverTip) frsActivity.findViewById(R.id.navigation_cover_tip);
        }
        if (this.z == null) {
            return;
        }
        View inflate = View.inflate(this.f16439e, R.layout.write_thread_share_guide, null);
        TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
        if (TextUtils.isEmpty(this.l)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(this.l + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
        d.b.h0.r.f0.m.c cVar = new d.b.h0.r.f0.m.c();
        cVar.r();
        tBSpecificationBtn.setConfig(cVar);
        tBSpecificationBtn.k();
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.z, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new t());
        this.z.m(this.f16439e, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int j2 = d.b.h0.r.d0.b.i().j("key_bawu_task_toast", 0);
        if (j2 >= 0) {
            d.b.h0.r.d0.b.i().u("key_bawu_task_toast", j2 + 1);
        }
    }

    @Override // d.b.i0.e.e.b
    public void setInjectPlugin(int i2, d.b.i0.e.e.a aVar) {
        FrsFragment frsFragment = this.f16440f;
        if (frsFragment instanceof d.b.i0.e.e.b) {
            frsFragment.setInjectPlugin(i2, aVar);
        }
    }

    public final void t0() {
        d.b.i0.c3.m mVar = this.f16442h;
        if (mVar == null || mVar.getEntelechyTabInfo() == null || this.f16442h.getEntelechyTabInfo().tab == null) {
            return;
        }
        boolean z2 = false;
        Iterator<FrsTabInfo> it = this.f16442h.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().tab_type.intValue() == 16) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            if (this.C == null) {
                d.b.i0.b0.e eVar = new d.b.i0.b0.e(this.f16439e.getPageContext(), this.u);
                this.C = eVar;
                eVar.c0(R.drawable.pic_sign_tip_down);
                this.C.K(2);
                this.C.d0(true);
                this.C.f0(-d.b.b.e.p.l.g(this.f16439e, R.dimen.tbds20));
                this.C.g0(-d.b.b.e.p.l.g(this.f16439e, R.dimen.tbds20));
                this.C.W(R.color.CAM_X0101);
                this.C.O(R.dimen.tbds54);
                this.C.Z(d.b.b.e.p.l.g(this.f16439e, R.dimen.tbds44));
            }
            this.C.i0(this.f16439e.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
        }
    }

    public final void u0(int i2, String str, String str2, String str3) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f16439e);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.f16439e);
        frsForumToolDialogView.setStartLoadUrl(i2, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new n(this, aVar));
        frsForumToolDialogView.setConfirmButtonListener(new o(aVar, i2, str3));
        aVar.setContentView(frsForumToolDialogView);
        aVar.create(this.f16439e.getPageContext()).show();
    }

    public final boolean v0(String str, String str2, String str3, boolean z2) {
        FrsFragment frsFragment;
        if (!this.D.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f16440f) == null || frsFragment.w0() == null) {
            return false;
        }
        this.G = false;
        this.D.h(this.f16439e, str, str2, str3, this.f16440f.w0().z());
        this.D.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
        return true;
    }

    public final boolean w0(ForumData forumData) {
        if (d.b.b.e.p.k.isEmpty(forumData.getRiskTipPop()) || d.b.b.e.p.k.isEmpty(forumData.getRiskTipPopTitle())) {
            return false;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f16439e);
        aVar.setTitle(forumData.getRiskTipPopTitle());
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.setMessage(forumData.getRiskTipPop());
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new p(this, aVar));
        aVar.create(this.f16439e.getPageContext()).show();
        return true;
    }
}
