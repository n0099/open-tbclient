package com.baidu.tieba.ala.alasquare.special_forum;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.ala.data.TabData;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.c.e.g.d;
import d.a.n0.e3.w;
import d.a.n0.v.d.f.d.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialLiveFragment extends BaseFragment {
    public d.a.n0.v.d.f.d.a A;
    public d.a.n0.v.d.f.c.h B;
    public List<TabData> C;
    public List<SpecialLiveTabInfo> D;
    public LikeModel E;
    public CustomMessageListener F;
    public AlaLiveUserNotifyController G;
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener H;
    public BdUniqueId I;
    public int J;
    public String K;
    public String L;
    public String M;
    public d.a.c.e.g.c Q;

    /* renamed from: e  reason: collision with root package name */
    public float f13795e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13796f;

    /* renamed from: g  reason: collision with root package name */
    public View f13797g;

    /* renamed from: h  reason: collision with root package name */
    public AppBarLayout f13798h;

    /* renamed from: i  reason: collision with root package name */
    public CollapsingToolbarLayout f13799i;
    public View j;
    public View k;
    public ObservedChangeFrameLayout l;
    public RelativeLayout m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public View s;
    public View t;
    public TextView u;
    public ImageView v;
    public ScrollHorizontalTabView w;
    public CustomViewPager x;
    public u y;
    public d.a.n0.v.d.f.f.e z;
    public boolean N = true;
    public int O = 1;
    public boolean P = false;
    public Handler R = new Handler();
    public Runnable S = new k();
    public CustomMessageListener T = new m(2921414);
    public CustomMessageListener U = new n(2001446);
    public CustomMessageListener V = new o(2005016);
    public final CustomMessageListener W = new p(2001266);
    public final CustomMessageListener X = new q(2001222);
    public final CustomMessageListener Y = new r(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON);

    /* loaded from: classes4.dex */
    public class a implements ScrollHorizontalTabView.ScrollTabPageListener {
        public a() {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i2, TabData tabData) {
            if (i2 != 0 || TbadkCoreApplication.isLogin()) {
                if (SpecialLiveFragment.this.y != null) {
                    SpecialLiveFragment.this.y.e(i2, tabData);
                    return;
                }
                return;
            }
            ViewHelper.skipToLoginActivity(SpecialLiveFragment.this.getPageContext().getPageActivity());
            if (SpecialLiveFragment.this.x != null) {
                SpecialLiveFragment.this.x.setCurrentItem(1);
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i2, TabData tabData) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            if (abs == 0) {
                SpecialLiveFragment.this.s.setVisibility(8);
                SpecialLiveFragment.this.u.setVisibility(8);
            } else {
                SpecialLiveFragment.this.s.setVisibility(0);
                SpecialLiveFragment.this.u.setVisibility(0);
            }
            SpecialLiveFragment specialLiveFragment = SpecialLiveFragment.this;
            float f2 = abs;
            specialLiveFragment.J1(f2 > specialLiveFragment.f13795e / 2.0f);
            float abs2 = Math.abs(f2 / SpecialLiveFragment.this.f13795e);
            SpecialLiveFragment.this.s.setAlpha(abs2);
            SpecialLiveFragment.this.u.setAlpha(abs2);
            SpecialLiveFragment.this.G1(abs, abs2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.m0.b1.j.e {
        public c() {
        }

        @Override // d.a.m0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            SpecialLiveFragment specialLiveFragment = SpecialLiveFragment.this;
            specialLiveFragment.f13795e = (specialLiveFragment.l.getMeasuredHeight() + SpecialLiveFragment.this.m.getMeasuredHeight()) - SpecialLiveFragment.this.r.getMeasuredHeight();
            SpecialLiveFragment.this.f13799i.setMinimumHeight(SpecialLiveFragment.this.r.getMeasuredHeight());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.b {
        public d() {
        }

        @Override // d.a.n0.v.d.f.d.a.b
        public void a(int i2, String str) {
            SpecialLiveFragment.this.q1(i2, str);
        }

        @Override // d.a.n0.v.d.f.d.a.b
        public void b(d.a.n0.v.d.f.c.h hVar) {
            SpecialLiveFragment specialLiveFragment = SpecialLiveFragment.this;
            specialLiveFragment.hideLoadingView(specialLiveFragment.f13797g);
            SpecialLiveFragment.this.t1(hVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialLiveFragment specialLiveFragment = SpecialLiveFragment.this;
            specialLiveFragment.I1(specialLiveFragment.getFragmentActivity());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public f() {
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            if (SpecialLiveFragment.this.isPrimary()) {
                SpecialLiveFragment.this.G.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            SignData signData;
            SpecialLiveFragment.this.p.setClickable(true);
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() != SpecialLiveFragment.this.I) {
                return;
            }
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            SignData signData2 = null;
            if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                AntiHelper.t(SpecialLiveFragment.this.f13796f, signMessage.signData.blockPopInfoData, null);
                return;
            }
            if (signMessage == null || (signData = signMessage.signData) == null) {
                z = false;
            } else {
                String str = signData.forumId;
                if (str == null || !str.equals(SpecialLiveFragment.this.K)) {
                    return;
                }
                signData2 = signData;
                z = true;
            }
            if (z) {
                TbadkCoreApplication.getInst().addSignedForum(SpecialLiveFragment.this.L, signData2.sign_bonus_point, -1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData2));
                if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    AntiHelper.u(SpecialLiveFragment.this.f13796f, signMessage.mSignErrorString);
                    return;
                } else {
                    d.a.c.e.p.l.M(SpecialLiveFragment.this.f13796f, SpecialLiveFragment.this.f13796f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData2.sign_bonus_point)));
                    return;
                }
            }
            if (signMessage.mSignErrorCode == 160002) {
                SpecialLiveFragment.this.O = 3;
                SpecialLiveFragment.this.K1(false);
            }
            d.a.c.e.p.l.M(SpecialLiveFragment.this.f13796f, signMessage.mSignErrorString);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.a.c.a.e {
        public h() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            SpecialLiveFragment.this.p.setClickable(true);
            if (SpecialLiveFragment.this.E.getErrorCode() == 22) {
                d.a.c.e.p.l.L(SpecialLiveFragment.this.f13796f, R.string.had_liked_forum);
            } else if (AntiHelper.m(SpecialLiveFragment.this.E.getErrorCode(), SpecialLiveFragment.this.E.getErrorString())) {
                AntiHelper.u(SpecialLiveFragment.this.f13796f, SpecialLiveFragment.this.E.getErrorString());
            } else if (SpecialLiveFragment.this.E.getErrorCode() != 0) {
                d.a.c.e.p.l.M(SpecialLiveFragment.this.f13796f, SpecialLiveFragment.this.E.getErrorString());
            } else {
                w wVar = (w) obj;
                if (wVar != null) {
                    TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.L);
                    wVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                    d.a.c.e.p.l.L(SpecialLiveFragment.this.f13796f, R.string.attention_success);
                    return;
                }
                d.a.c.e.p.l.L(SpecialLiveFragment.this.f13796f, R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.Q != null) {
                SpecialLiveFragment.this.Q.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f13809a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f13810b;

        public j(Handler handler, Runnable runnable) {
            this.f13809a = handler;
            this.f13810b = runnable;
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
            SpecialLiveFragment.this.Q = null;
            this.f13809a.removeCallbacks(this.f13810b);
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.z != null) {
                SpecialLiveFragment.this.z.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements d.a.c.e.g.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f13813a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, true);
                SpecialLiveFragment.this.Q.d();
            }
        }

        public l(Activity activity) {
            this.f13813a = activity;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 4;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 48;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(this.f13813a, R.layout.square_guide_tip_layout, null);
            TextView textView = (TextView) bubbleLayout.findViewById(R.id.square_guide_tv);
            textView.setText(this.f13813a.getResources().getString(R.string.square_guide_mark_manage_tip_text));
            textView.setOnClickListener(new a());
            SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
            bubbleLayout.f(SkinManager.getColor(R.color.cp_link_tip_a_alpha95));
            bubbleLayout.e(this.f13813a.getResources().getDimensionPixelSize(R.dimen.ds216));
            return bubbleLayout;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return -this.f13813a.getResources().getDimensionPixelSize(R.dimen.ds7);
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return -TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
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
            SpecialLiveFragment.this.R.removeCallbacks(SpecialLiveFragment.this.S);
            SpecialLiveFragment.this.R.postDelayed(SpecialLiveFragment.this.S, 500L);
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
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsLiveLive".equals(split[0])) {
                SpecialLiveFragment.this.E1(false);
            }
            SpecialForumTabBaseFragment b2 = SpecialLiveFragment.this.y.b(SpecialLiveFragment.this.x.getCurrentItem());
            if (b2 != null) {
                b2.t();
            }
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
            if (customResponsedMessage == null || SpecialLiveFragment.this.A == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            SpecialLiveFragment.this.E1(false);
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public p(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w) || (wVar = (w) customResponsedMessage.getData()) == null || !SpecialLiveFragment.this.K.equals(wVar.g())) {
                return;
            }
            if (wVar.l() == 1) {
                if (SpecialLiveFragment.this.D1()) {
                    SpecialLiveFragment.this.O = 3;
                } else {
                    SpecialLiveFragment.this.O = 2;
                }
            } else {
                SpecialLiveFragment.this.O = 1;
            }
            SpecialLiveFragment.this.K1(false);
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public q(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.K.equals(signData.forumId) && signData.is_signed == 1) {
                SpecialLiveFragment.this.O = 3;
                SpecialLiveFragment.this.K1(false);
                d.a.c.e.p.l.M(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.f13796f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public r(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (ListUtils.isEmpty(SpecialLiveFragment.this.C)) {
                return;
            }
            ((TabData) SpecialLiveFragment.this.C.get(0)).extra = bool;
            SpecialLiveFragment.this.w.setData(SpecialLiveFragment.this.C);
            if (bool.booleanValue()) {
                TiebaStatic.log("c12898");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.z()) {
                SpecialLiveFragment.this.showToast(R.string.neterror);
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(SpecialLiveFragment.this.f13796f);
            }
            if (SpecialLiveFragment.this.O == 1) {
                SpecialLiveFragment.this.p.setClickable(false);
                SpecialLiveFragment.this.E.H(SpecialLiveFragment.this.L, SpecialLiveFragment.this.K);
                TiebaStatic.log(new StatisticItem("c12890"));
            } else if (SpecialLiveFragment.this.O == 2) {
                SpecialLiveFragment.this.p.setClickable(false);
                ForumData forumData = new ForumData();
                forumData.setId(SpecialLiveFragment.this.K);
                forumData.setName(SpecialLiveFragment.this.L);
                CustomMessage customMessage = new CustomMessage(2001425, forumData);
                customMessage.setTag(SpecialLiveFragment.this.I);
                MessageManager.getInstance().sendMessage(customMessage);
                TiebaStatic.log(new StatisticItem("c12892"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, SpecialLiveFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class u extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<SpecialLiveTabInfo> f13824a;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<SpecialForumTabBaseFragment> f13825b;

        public u(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f13824a = new ArrayList();
            SparseArray<SpecialForumTabBaseFragment> sparseArray = new SparseArray<>();
            this.f13825b = sparseArray;
            sparseArray.put(0, ConcernTabFragment.W0(0));
        }

        public SpecialForumTabBaseFragment b(int i2) {
            return this.f13825b.get(i2);
        }

        public void c(int i2) {
            SparseArray<SpecialForumTabBaseFragment> sparseArray = this.f13825b;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return;
            }
            int size = this.f13825b.size();
            for (int i3 = 0; i3 < size; i3++) {
                SpecialForumTabBaseFragment specialForumTabBaseFragment = this.f13825b.get(i3);
                if (specialForumTabBaseFragment != null) {
                    specialForumTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }

        public void d(List<SpecialLiveTabInfo> list) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f13824a.clear();
            this.f13824a.addAll(list);
            notifyDataSetChanged();
        }

        public void e(int i2, TabData tabData) {
            if (this.f13825b.get(i2) != null) {
                this.f13825b.get(i2).setPrimary(true);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f13824a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            SpecialForumTabBaseFragment b2 = b(i2);
            if (b2 == null) {
                if (i2 == 0) {
                    b2 = ConcernTabFragment.W0(0);
                } else if (i2 == 1) {
                    b2 = RecommendTabFragment.V0(1);
                } else {
                    b2 = OtherSubTabFragment.X0(i2, this.f13824a.get(i2));
                }
                this.f13825b.put(i2, b2);
            }
            return b2;
        }
    }

    public static SpecialLiveFragment F1(String str, String str2) {
        SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        specialLiveFragment.setArguments(bundle);
        return specialLiveFragment;
    }

    public final void A1() {
        this.G = new AlaLiveUserNotifyController(getPageContext());
        this.H = new f();
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.H);
    }

    public final void B1() {
        this.F = new g(2001425);
    }

    public final void C1() {
        u uVar = new u(getChildFragmentManager());
        this.y = uVar;
        this.x.setAdapter(uVar);
    }

    public final boolean D1() {
        return this.B.f61736e.f61737a;
    }

    public final void E1(boolean z) {
        if (this.A.d()) {
            return;
        }
        if (z) {
            showLoadingView(this.f13797g);
        }
        this.A.e();
    }

    public final void G1(int i2, float f2) {
        d.a.n0.v.d.f.f.e eVar = this.z;
        if (eVar == null || f2 == 0.0f) {
            return;
        }
        if (this.J <= i2) {
            if (this.N && f2 >= 0.3f) {
                eVar.d(true);
                this.z.h();
                this.N = false;
            }
        } else if (!this.N && f2 <= 0.3f) {
            eVar.d(false);
            this.z.i();
            this.N = true;
        }
        this.J = i2;
    }

    public final void H1() {
        AlaUserInfoData alaUserInfoData;
        String str;
        d.a.n0.v.d.f.c.h hVar = this.B;
        if (hVar == null || (alaUserInfoData = hVar.f61735d) == null || this.O == 1) {
            return;
        }
        int i2 = alaUserInfoData.level_id;
        if (TextUtils.isEmpty(alaUserInfoData.level_name)) {
            str = "";
        } else {
            str = " " + this.B.f61735d.level_name;
        }
        if (i2 < 0) {
            return;
        }
        this.q.setText("LV" + i2 + str);
    }

    public final void I1(Activity activity) {
        if (activity == null || AlaSharedPrefHelper.getInstance().getBoolean(AlaSharedPrefConfig.SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW, false)) {
            return;
        }
        d.a.c.e.g.c cVar = this.Q;
        if (cVar != null) {
            cVar.d();
        }
        Handler handler = new Handler();
        i iVar = new i();
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.g(new j(handler, iVar));
        dVar.j(activity.getWindow().getDecorView().findViewById(R.id.tabcontainer));
        dVar.c(20);
        dVar.i(false);
        dVar.a(new l(activity));
        d.a.c.e.g.c b2 = dVar.b();
        this.Q = b2;
        b2.m(activity);
        handler.postDelayed(iVar, 5000L);
    }

    public final void J1(boolean z) {
        ImageView imageView = this.v;
        if (imageView == null) {
            return;
        }
        if (z) {
            int i2 = R.drawable.selector_topbar_return_black;
            SkinManager.setNavbarIconSrc(imageView, i2, i2, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        int i3 = R.drawable.selector_topbar_return_white;
        SkinManager.setNavbarIconSrc(imageView, i3, i3, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void K1(boolean z) {
        Drawable drawable;
        SkinManager.setBackgroundResource(this.p, R.drawable.frs_attention_btn_bg_selector);
        int g2 = d.a.c.e.p.l.g(this.f13796f, R.dimen.ds10);
        String string = this.f13796f.getResources().getString(R.string.attention);
        int i2 = R.drawable.frs_attention_btn_bg_selector;
        int i3 = R.color.CAM_X0101;
        int i4 = this.O;
        if (i4 == 1) {
            drawable = SkinManager.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.p.setClickable(true);
            if (!z) {
                TiebaStatic.log(new StatisticItem("c12889"));
            }
        } else if (i4 == 2) {
            string = this.f13796f.getResources().getString(R.string.sign);
            drawable = SkinManager.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.p.setClickable(true);
            if (!z) {
                TiebaStatic.log(new StatisticItem("c12891"));
            }
        } else {
            if (i4 == 3) {
                string = this.f13796f.getResources().getString(R.string.signed);
                this.p.setClickable(false);
                i2 = R.drawable.special_sign_btn_signed_bg;
                i3 = R.color.CAM_X0109;
            }
            drawable = null;
        }
        SkinManager.setBackgroundResource(this.p, i2);
        SkinManager.setViewTextColor(this.p, i3);
        this.p.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.p.setCompoundDrawablePadding(g2);
        this.p.setText(string);
        H1();
    }

    public final void o1() {
        int dimensionPixelSize = this.f13796f.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky() && this.j.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams2.height = layoutParams.height;
            this.t.setLayoutParams(layoutParams2);
            dimensionPixelSize += layoutParams.height;
        } else {
            this.j.setVisibility(8);
        }
        CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.r.getLayoutParams();
        ((FrameLayout.LayoutParams) layoutParams3).height = dimensionPixelSize;
        this.r.setLayoutParams(layoutParams3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13797g.post(new e());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.v.d.f.f.e eVar = this.z;
        if (eVar != null) {
            eVar.f(i2);
        }
        ScrollHorizontalTabView scrollHorizontalTabView = this.w;
        if (scrollHorizontalTabView != null) {
            SkinManager.setBackgroundResource(scrollHorizontalTabView, R.color.CAM_X0201);
            this.w.onChangeSkinType(i2);
        }
        u uVar = this.y;
        if (uVar != null) {
            uVar.c(i2);
        }
        J1(false);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.p, R.drawable.frs_attention_btn_bg_selector);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.f13796f = getPageContext().getPageActivity();
        this.K = arguments.getString("forum_id");
        String string = arguments.getString("forum_name");
        String string2 = this.f13796f.getResources().getString(R.string.forum);
        if (!TextUtils.isEmpty(string)) {
            this.L = string;
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(string, 5, true, true) + string2);
            this.M = sb.toString();
        } else {
            this.L = this.f13796f.getResources().getString(R.string.ala_ufan_bar_title);
            this.M = this.L + string2;
        }
        z1();
        A1();
        B1();
        MessageManager.getInstance().registerListener(this.F);
        MessageManager.getInstance().registerListener(this.W);
        MessageManager.getInstance().registerListener(this.X);
        MessageManager.getInstance().registerListener(this.Y);
        MessageManager.getInstance().registerListener(this.U);
        MessageManager.getInstance().registerListener(this.V);
        MessageManager.getInstance().registerListener(this.T);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.f13797g = inflate;
        this.f13798h = (AppBarLayout) inflate.findViewById(R.id.special_app_bar_layout);
        this.f13799i = (CollapsingToolbarLayout) this.f13797g.findViewById(R.id.special_collapse_layout);
        this.j = this.f13797g.findViewById(R.id.statusbar_view);
        this.l = (ObservedChangeFrameLayout) this.f13797g.findViewById(R.id.live_container);
        this.I = BdUniqueId.gen();
        this.m = (RelativeLayout) this.f13797g.findViewById(R.id.function_container);
        this.n = this.f13797g.findViewById(R.id.function_bottom_space);
        TextView textView = (TextView) this.f13797g.findViewById(R.id.function_title);
        this.o = textView;
        textView.setText(this.M);
        TextView textView2 = (TextView) this.f13797g.findViewById(R.id.function_btn);
        this.p = textView2;
        textView2.setOnClickListener(new s());
        this.q = (TextView) this.f13797g.findViewById(R.id.function_level_desc);
        this.r = (RelativeLayout) this.f13797g.findViewById(R.id.navigation_layout);
        this.t = this.f13797g.findViewById(R.id.navigation_top_space);
        this.s = this.f13797g.findViewById(R.id.navigation_bg);
        TextView textView3 = (TextView) this.f13797g.findViewById(R.id.navigation_title);
        this.u = textView3;
        textView3.setText(this.M);
        ImageView imageView = (ImageView) this.f13797g.findViewById(R.id.navigation_back_img);
        this.v = imageView;
        imageView.setOnClickListener(new t());
        this.w = (ScrollHorizontalTabView) this.f13797g.findViewById(R.id.scroll_tab_view);
        this.x = (CustomViewPager) this.f13797g.findViewById(R.id.special_view_pager);
        C1();
        this.w.setViewPager(this.x);
        this.w.setScrollTabPageListener(new a());
        this.f13798h.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
        this.k = this.f13797g.findViewById(R.id.square_main_top_divider_line);
        this.l.setOnSizeChangeListener(new c());
        o1();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.z = new d.a.n0.v.d.f.f.e(getPageContext());
        this.A = new d.a.n0.v.d.f.d.a(getPageContext(), new d());
        K1(true);
        E1(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f13797g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.v.d.f.f.e eVar = this.z;
        if (eVar != null) {
            eVar.g();
        }
        if (this.W != null) {
            MessageManager.getInstance().unRegisterListener(this.W);
        }
        if (this.F != null) {
            MessageManager.getInstance().unRegisterListener(this.F);
        }
        if (this.X != null) {
            MessageManager.getInstance().unRegisterListener(this.X);
        }
        if (this.Y != null) {
            MessageManager.getInstance().unRegisterListener(this.Y);
        }
        if (this.U != null) {
            MessageManager.getInstance().unRegisterListener(this.U);
        }
        if (this.V != null) {
            MessageManager.getInstance().unRegisterListener(this.V);
        }
        d.a.n0.v.d.f.d.a aVar = this.A;
        if (aVar != null) {
            aVar.f();
        }
        AlaLiveUserNotifyController alaLiveUserNotifyController = this.G;
        if (alaLiveUserNotifyController != null) {
            alaLiveUserNotifyController.onDestroy();
        }
        AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.H);
        hideLoadingView(this.f13797g);
        MessageManager.getInstance().unRegisterListener(this.T);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.f13797g);
        E1(true);
        AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.a.n0.v.d.f.f.e eVar = this.z;
        if (eVar != null) {
            eVar.d(true);
            this.z.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (isPrimary()) {
                E1(false);
                AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
            }
            if (this.z != null) {
                if (isPrimary()) {
                    this.z.d(false);
                    this.z.j();
                    return;
                }
                this.z.d(true);
                this.z.h();
            }
        }
    }

    public final void p1() {
        this.C.clear();
        this.D.clear();
        this.C.add(v1());
        this.C.add(x1());
        this.D.add(w1());
        this.D.add(y1());
        if (ListUtils.isEmpty(this.B.f61733b)) {
            return;
        }
        for (int i2 = 0; i2 < this.B.f61733b.size() && i2 < 10; i2++) {
            SpecialLiveTabInfo specialLiveTabInfo = this.B.f61733b.get(i2);
            if (specialLiveTabInfo != null && specialLiveTabInfo.tabId != 1108) {
                this.D.add(specialLiveTabInfo);
                TabData tabData = new TabData();
                tabData.tabId = specialLiveTabInfo.tabId;
                tabData.tabName = specialLiveTabInfo.tabName;
                tabData.tabType = specialLiveTabInfo.tabType;
                this.C.add(tabData);
            }
        }
    }

    public final void q1(int i2, String str) {
        hideLoadingView(this.f13797g);
        this.f13798h.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.f13797g, this.f13796f.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.f13797g, str, true);
        }
    }

    public final void r1() {
        if (this.B.f61734c) {
            if (D1()) {
                this.O = 3;
            } else {
                this.O = 2;
            }
        } else {
            this.O = 1;
        }
        K1(false);
    }

    public final void s1() {
        boolean c2 = this.z.c(this.B.f61732a);
        if (c2) {
            this.z.k();
            this.z.g();
        }
        this.z.b(this.B.f61732a, c2);
        if (c2) {
            this.z.a(this.l);
        }
        this.z.j();
    }

    public final void t1(d.a.n0.v.d.f.c.h hVar) {
        this.f13798h.setVisibility(0);
        this.B = hVar;
        s1();
        r1();
        if (this.P) {
            return;
        }
        u1();
        CustomViewPager customViewPager = this.x;
        if (customViewPager != null && customViewPager.getChildCount() > 1) {
            this.x.setCurrentItem(1);
        }
        if (ListUtils.isEmpty(this.B.f61733b)) {
            return;
        }
        this.P = true;
    }

    public final void u1() {
        p1();
        this.w.setData(this.C);
        this.y.d(this.D);
    }

    public final TabData v1() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.f13796f.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    public final SpecialLiveTabInfo w1() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.f13796f.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    public final TabData x1() {
        TabData tabData = new TabData();
        tabData.tabId = -903;
        tabData.tabName = this.f13796f.getResources().getString(R.string.special_recommend_tab_title);
        return tabData;
    }

    public final SpecialLiveTabInfo y1() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.f13796f.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }

    public final void z1() {
        LikeModel likeModel = new LikeModel(getPageContext());
        this.E = likeModel;
        likeModel.setLoadDataCallBack(new h());
    }
}
