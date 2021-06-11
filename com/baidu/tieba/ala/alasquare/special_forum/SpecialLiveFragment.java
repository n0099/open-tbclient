package com.baidu.tieba.ala.alasquare.special_forum;

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
import com.baidu.tbadk.core.util.TiebaStaticHelper;
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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.n0.e3.w;
import d.a.n0.v.d.f.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialLiveFragment extends BaseFragment {
    public static int Y = 1;
    public static HashMap<Integer, Integer> Z = new HashMap<>();
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
    public boolean N = true;
    public int O = 1;
    public boolean P = false;
    public Handler Q = new Handler();
    public Runnable R = new h();
    public CustomMessageListener S = new i(2921414);
    public CustomMessageListener T = new j(2001446);
    public CustomMessageListener U = new k(2005016);
    public final CustomMessageListener V = new l(2001266);
    public final CustomMessageListener W = new m(2001222);
    public final CustomMessageListener X = new n(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON);

    /* renamed from: e  reason: collision with root package name */
    public float f13860e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13861f;

    /* renamed from: g  reason: collision with root package name */
    public View f13862g;

    /* renamed from: h  reason: collision with root package name */
    public AppBarLayout f13863h;

    /* renamed from: i  reason: collision with root package name */
    public CollapsingToolbarLayout f13864i;
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
    public q y;
    public d.a.n0.v.d.f.f.e z;

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
                    SpecialLiveFragment.this.y.l(i2, tabData);
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
            specialLiveFragment.K1(f2 > specialLiveFragment.f13860e / 2.0f);
            float abs2 = Math.abs(f2 / SpecialLiveFragment.this.f13860e);
            SpecialLiveFragment.this.s.setAlpha(abs2);
            SpecialLiveFragment.this.u.setAlpha(abs2);
            SpecialLiveFragment.this.I1(abs, abs2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.m0.b1.j.e {
        public c() {
        }

        @Override // d.a.m0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            SpecialLiveFragment specialLiveFragment = SpecialLiveFragment.this;
            specialLiveFragment.f13860e = (specialLiveFragment.l.getMeasuredHeight() + SpecialLiveFragment.this.m.getMeasuredHeight()) - SpecialLiveFragment.this.r.getMeasuredHeight();
            SpecialLiveFragment.this.f13864i.setMinimumHeight(SpecialLiveFragment.this.r.getMeasuredHeight());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.b {
        public d() {
        }

        @Override // d.a.n0.v.d.f.d.a.b
        public void a(int i2, String str) {
            SpecialLiveFragment.this.r1(i2, str);
        }

        @Override // d.a.n0.v.d.f.d.a.b
        public void b(d.a.n0.v.d.f.c.h hVar) {
            SpecialLiveFragment specialLiveFragment = SpecialLiveFragment.this;
            specialLiveFragment.hideLoadingView(specialLiveFragment.f13862g);
            SpecialLiveFragment.this.u1(hVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public e() {
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            if (SpecialLiveFragment.this.isPrimary()) {
                SpecialLiveFragment.this.G.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
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
            boolean z;
            SignData signData;
            SpecialLiveFragment.this.p.setClickable(true);
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() != SpecialLiveFragment.this.I) {
                return;
            }
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            SignData signData2 = null;
            if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                AntiHelper.t(SpecialLiveFragment.this.f13861f, signMessage.signData.blockPopInfoData, null);
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
                    AntiHelper.u(SpecialLiveFragment.this.f13861f, signMessage.mSignErrorString);
                    return;
                } else {
                    d.a.c.e.p.l.M(SpecialLiveFragment.this.f13861f, SpecialLiveFragment.this.f13861f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData2.sign_bonus_point)));
                    return;
                }
            }
            if (signMessage.mSignErrorCode == 160002) {
                SpecialLiveFragment.this.O = 3;
                SpecialLiveFragment.this.L1(false);
            }
            d.a.c.e.p.l.M(SpecialLiveFragment.this.f13861f, signMessage.mSignErrorString);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.a.c.a.e {
        public g() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            SpecialLiveFragment.this.p.setClickable(true);
            if (SpecialLiveFragment.this.E.getErrorCode() == 22) {
                d.a.c.e.p.l.L(SpecialLiveFragment.this.f13861f, R.string.had_liked_forum);
            } else if (AntiHelper.m(SpecialLiveFragment.this.E.getErrorCode(), SpecialLiveFragment.this.E.getErrorString())) {
                AntiHelper.u(SpecialLiveFragment.this.f13861f, SpecialLiveFragment.this.E.getErrorString());
            } else if (SpecialLiveFragment.this.E.getErrorCode() != 0) {
                d.a.c.e.p.l.M(SpecialLiveFragment.this.f13861f, SpecialLiveFragment.this.E.getErrorString());
            } else {
                w wVar = (w) obj;
                if (wVar != null) {
                    TbadkCoreApplication.getInst().addLikeForum(SpecialLiveFragment.this.L);
                    wVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                    d.a.c.e.p.l.L(SpecialLiveFragment.this.f13861f, R.string.attention_success);
                    return;
                }
                d.a.c.e.p.l.L(SpecialLiveFragment.this.f13861f, R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialLiveFragment.this.z != null) {
                SpecialLiveFragment.this.z.e();
            }
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
            SpecialLiveFragment.this.Q.removeCallbacks(SpecialLiveFragment.this.R);
            SpecialLiveFragment.this.Q.postDelayed(SpecialLiveFragment.this.R, 500L);
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
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsLiveLive".equals(split[0])) {
                SpecialLiveFragment.this.G1(false);
            }
            SpecialForumTabBaseFragment i2 = SpecialLiveFragment.this.y.i(SpecialLiveFragment.this.x.getCurrentItem());
            if (i2 != null) {
                i2.u();
            }
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
            if (customResponsedMessage == null || SpecialLiveFragment.this.A == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            SpecialLiveFragment.this.G1(false);
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
            w wVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w) || (wVar = (w) customResponsedMessage.getData()) == null || !SpecialLiveFragment.this.K.equals(wVar.g())) {
                return;
            }
            if (wVar.l() == 1) {
                if (SpecialLiveFragment.this.F1()) {
                    SpecialLiveFragment.this.O = 3;
                } else {
                    SpecialLiveFragment.this.O = 2;
                }
            } else {
                SpecialLiveFragment.this.O = 1;
            }
            SpecialLiveFragment.this.L1(false);
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
            SignData signData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && SpecialLiveFragment.this.K.equals(signData.forumId) && signData.is_signed == 1) {
                SpecialLiveFragment.this.O = 3;
                SpecialLiveFragment.this.L1(false);
                d.a.c.e.p.l.M(SpecialLiveFragment.this.getPageContext().getPageActivity(), SpecialLiveFragment.this.f13861f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
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
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.z()) {
                SpecialLiveFragment.this.showToast(R.string.neterror);
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(SpecialLiveFragment.this.f13861f);
            }
            if (SpecialLiveFragment.this.O == 1) {
                SpecialLiveFragment.this.p.setClickable(false);
                SpecialLiveFragment.this.E.L(SpecialLiveFragment.this.L, SpecialLiveFragment.this.K);
                StatisticItem statisticItem = new StatisticItem("c12890");
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (SpecialLiveFragment.this.O == 2) {
                SpecialLiveFragment.this.p.setClickable(false);
                ForumData forumData = new ForumData();
                forumData.setId(SpecialLiveFragment.this.K);
                forumData.setName(SpecialLiveFragment.this.L);
                CustomMessage customMessage = new CustomMessage(2001425, forumData);
                customMessage.setTag(SpecialLiveFragment.this.I);
                MessageManager.getInstance().sendMessage(customMessage);
                StatisticItem statisticItem2 = new StatisticItem("c12892");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, SpecialLiveFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class q extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<SpecialLiveTabInfo> f13881a;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<SpecialForumTabBaseFragment> f13882b;

        public q(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f13881a = new ArrayList();
            SparseArray<SpecialForumTabBaseFragment> sparseArray = new SparseArray<>();
            this.f13882b = sparseArray;
            sparseArray.put(0, ConcernTabFragment.Z0(0));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f13881a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            SpecialForumTabBaseFragment i3 = i(i2);
            if (i3 == null) {
                if (i2 == 0) {
                    i3 = ConcernTabFragment.Z0(0);
                } else if (i2 == 1) {
                    i3 = RecommendTabFragment.Y0(1);
                } else {
                    i3 = OtherSubTabFragment.a1(i2, this.f13881a.get(i2));
                }
                this.f13882b.put(i2, i3);
            }
            return i3;
        }

        public SpecialForumTabBaseFragment i(int i2) {
            return this.f13882b.get(i2);
        }

        public void j(int i2) {
            SparseArray<SpecialForumTabBaseFragment> sparseArray = this.f13882b;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return;
            }
            int size = this.f13882b.size();
            for (int i3 = 0; i3 < size; i3++) {
                SpecialForumTabBaseFragment specialForumTabBaseFragment = this.f13882b.get(i3);
                if (specialForumTabBaseFragment != null) {
                    specialForumTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }

        public void k(List<SpecialLiveTabInfo> list) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f13881a.clear();
            this.f13881a.addAll(list);
            notifyDataSetChanged();
        }

        public void l(int i2, TabData tabData) {
            if (this.f13882b.get(i2) != null) {
                this.f13882b.get(i2).setPrimary(true);
            }
        }
    }

    public static int A1(int i2) {
        if (Z.containsKey(Integer.valueOf(i2))) {
            return Z.get(Integer.valueOf(i2)).intValue();
        }
        Z.put(Integer.valueOf(i2), 1);
        return 1;
    }

    public static SpecialLiveFragment H1(String str, String str2) {
        SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        specialLiveFragment.setArguments(bundle);
        return specialLiveFragment;
    }

    public static void o1(int i2) {
        if (Z.containsKey(Integer.valueOf(i2))) {
            Z.put(Integer.valueOf(i2), Integer.valueOf(Z.get(Integer.valueOf(i2)).intValue() + 1));
        } else {
            Z.put(Integer.valueOf(i2), 2);
        }
    }

    public final void B1() {
        LikeModel likeModel = new LikeModel(getPageContext());
        this.E = likeModel;
        likeModel.setLoadDataCallBack(new g());
    }

    public final void C1() {
        this.G = new AlaLiveUserNotifyController(getPageContext());
        this.H = new e();
        AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.H);
    }

    public final void D1() {
        this.F = new f(2001425);
    }

    public final void E1() {
        q qVar = new q(getChildFragmentManager());
        this.y = qVar;
        this.x.setAdapter(qVar);
    }

    public final boolean F1() {
        return this.B.f65450e.f65451a;
    }

    public final void G1(boolean z) {
        if (this.A.d()) {
            return;
        }
        if (z) {
            showLoadingView(this.f13862g);
        }
        this.A.e();
    }

    public final void I1(int i2, float f2) {
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

    public final void J1() {
        AlaUserInfoData alaUserInfoData;
        String str;
        d.a.n0.v.d.f.c.h hVar = this.B;
        if (hVar == null || (alaUserInfoData = hVar.f65449d) == null || this.O == 1) {
            return;
        }
        int i2 = alaUserInfoData.level_id;
        if (TextUtils.isEmpty(alaUserInfoData.level_name)) {
            str = "";
        } else {
            str = " " + this.B.f65449d.level_name;
        }
        if (i2 < 0) {
            return;
        }
        this.q.setText("LV" + i2 + str);
    }

    public final void K1(boolean z) {
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

    public final void L1(boolean z) {
        Drawable drawable;
        SkinManager.setBackgroundResource(this.p, R.drawable.frs_attention_btn_bg_selector);
        int g2 = d.a.c.e.p.l.g(this.f13861f, R.dimen.ds10);
        String string = this.f13861f.getResources().getString(R.string.attention);
        int i2 = R.drawable.frs_attention_btn_bg_selector;
        int i3 = R.color.CAM_X0101;
        int i4 = this.O;
        if (i4 == 1) {
            drawable = SkinManager.getDrawable(R.drawable.icon_add_follow_blue_s);
            this.p.setClickable(true);
            if (!z) {
                StatisticItem statisticItem = new StatisticItem("c12889");
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
        } else if (i4 == 2) {
            string = this.f13861f.getResources().getString(R.string.sign);
            drawable = SkinManager.getDrawable(R.drawable.icon_public_sign_blue_s);
            this.p.setClickable(true);
            if (!z) {
                StatisticItem statisticItem2 = new StatisticItem("c12891");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        } else {
            if (i4 == 3) {
                string = this.f13861f.getResources().getString(R.string.signed);
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
        J1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
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
        q qVar = this.y;
        if (qVar != null) {
            qVar.j(i2);
        }
        K1(false);
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
        this.f13861f = getPageContext().getPageActivity();
        this.K = arguments.getString("forum_id");
        String string = arguments.getString("forum_name");
        String string2 = this.f13861f.getResources().getString(R.string.forum);
        if (!TextUtils.isEmpty(string)) {
            this.L = string;
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(string, 5, true, true) + string2);
            this.M = sb.toString();
        } else {
            this.L = this.f13861f.getResources().getString(R.string.ala_ufan_bar_title);
            this.M = this.L + string2;
        }
        B1();
        C1();
        D1();
        MessageManager.getInstance().registerListener(this.F);
        MessageManager.getInstance().registerListener(this.V);
        MessageManager.getInstance().registerListener(this.W);
        MessageManager.getInstance().registerListener(this.X);
        MessageManager.getInstance().registerListener(this.T);
        MessageManager.getInstance().registerListener(this.U);
        MessageManager.getInstance().registerListener(this.S);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
        this.f13862g = inflate;
        this.f13863h = (AppBarLayout) inflate.findViewById(R.id.special_app_bar_layout);
        this.f13864i = (CollapsingToolbarLayout) this.f13862g.findViewById(R.id.special_collapse_layout);
        this.j = this.f13862g.findViewById(R.id.statusbar_view);
        this.l = (ObservedChangeFrameLayout) this.f13862g.findViewById(R.id.live_container);
        this.I = BdUniqueId.gen();
        this.m = (RelativeLayout) this.f13862g.findViewById(R.id.function_container);
        this.n = this.f13862g.findViewById(R.id.function_bottom_space);
        TextView textView = (TextView) this.f13862g.findViewById(R.id.function_title);
        this.o = textView;
        textView.setText(this.M);
        TextView textView2 = (TextView) this.f13862g.findViewById(R.id.function_btn);
        this.p = textView2;
        textView2.setOnClickListener(new o());
        this.q = (TextView) this.f13862g.findViewById(R.id.function_level_desc);
        this.r = (RelativeLayout) this.f13862g.findViewById(R.id.navigation_layout);
        this.t = this.f13862g.findViewById(R.id.navigation_top_space);
        this.s = this.f13862g.findViewById(R.id.navigation_bg);
        TextView textView3 = (TextView) this.f13862g.findViewById(R.id.navigation_title);
        this.u = textView3;
        textView3.setText(this.M);
        ImageView imageView = (ImageView) this.f13862g.findViewById(R.id.navigation_back_img);
        this.v = imageView;
        imageView.setOnClickListener(new p());
        this.w = (ScrollHorizontalTabView) this.f13862g.findViewById(R.id.scroll_tab_view);
        this.x = (CustomViewPager) this.f13862g.findViewById(R.id.special_view_pager);
        E1();
        this.w.setViewPager(this.x);
        this.w.setScrollTabPageListener(new a());
        this.f13863h.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
        this.k = this.f13862g.findViewById(R.id.square_main_top_divider_line);
        this.l.setOnSizeChangeListener(new c());
        p1();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.z = new d.a.n0.v.d.f.f.e(getPageContext());
        this.A = new d.a.n0.v.d.f.d.a(getPageContext(), new d());
        L1(true);
        G1(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f13862g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.v.d.f.f.e eVar = this.z;
        if (eVar != null) {
            eVar.g();
        }
        if (this.V != null) {
            MessageManager.getInstance().unRegisterListener(this.V);
        }
        if (this.F != null) {
            MessageManager.getInstance().unRegisterListener(this.F);
        }
        if (this.W != null) {
            MessageManager.getInstance().unRegisterListener(this.W);
        }
        if (this.X != null) {
            MessageManager.getInstance().unRegisterListener(this.X);
        }
        if (this.T != null) {
            MessageManager.getInstance().unRegisterListener(this.T);
        }
        if (this.U != null) {
            MessageManager.getInstance().unRegisterListener(this.U);
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
        hideLoadingView(this.f13862g);
        MessageManager.getInstance().unRegisterListener(this.S);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        hideNetRefreshView(this.f13862g);
        G1(true);
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
                G1(false);
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
        int dimensionPixelSize = this.f13861f.getResources().getDimensionPixelSize(R.dimen.ds88);
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

    public final void q1() {
        this.C.clear();
        this.D.clear();
        this.C.add(w1());
        this.C.add(y1());
        this.D.add(x1());
        this.D.add(z1());
        if (ListUtils.isEmpty(this.B.f65447b)) {
            return;
        }
        for (int i2 = 0; i2 < this.B.f65447b.size() && i2 < 10; i2++) {
            SpecialLiveTabInfo specialLiveTabInfo = this.B.f65447b.get(i2);
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

    public final void r1(int i2, String str) {
        hideLoadingView(this.f13862g);
        this.f13863h.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            showNetRefreshView(this.f13862g, this.f13861f.getResources().getString(R.string.square_load_data_failed_tip), true);
        } else {
            showNetRefreshView(this.f13862g, str, true);
        }
    }

    public final void s1() {
        if (this.B.f65448c) {
            if (F1()) {
                this.O = 3;
            } else {
                this.O = 2;
            }
        } else {
            this.O = 1;
        }
        L1(false);
    }

    public final void t1() {
        boolean c2 = this.z.c(this.B.f65446a);
        if (c2) {
            this.z.k();
            this.z.g();
        }
        this.z.b(this.B.f65446a, c2);
        if (c2) {
            this.z.a(this.l);
        }
        this.z.j();
    }

    public final void u1(d.a.n0.v.d.f.c.h hVar) {
        this.f13863h.setVisibility(0);
        this.B = hVar;
        t1();
        s1();
        if (this.P) {
            return;
        }
        v1();
        CustomViewPager customViewPager = this.x;
        if (customViewPager != null && customViewPager.getChildCount() > 1) {
            this.x.setCurrentItem(1);
        }
        if (ListUtils.isEmpty(this.B.f65447b)) {
            return;
        }
        this.P = true;
    }

    public final void v1() {
        q1();
        this.w.setData(this.C);
        this.y.k(this.D);
    }

    public final TabData w1() {
        TabData tabData = new TabData();
        tabData.tabId = -901;
        tabData.tabName = this.f13861f.getResources().getString(R.string.special_concern_tab_title);
        return tabData;
    }

    public final SpecialLiveTabInfo x1() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -901;
        specialLiveTabInfo.tabName = this.f13861f.getResources().getString(R.string.special_concern_tab_title);
        return specialLiveTabInfo;
    }

    public final TabData y1() {
        TabData tabData = new TabData();
        tabData.tabId = -903;
        tabData.tabName = this.f13861f.getResources().getString(R.string.special_recommend_tab_title);
        return tabData;
    }

    public final SpecialLiveTabInfo z1() {
        SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
        specialLiveTabInfo.tabId = -903;
        specialLiveTabInfo.tabName = this.f13861f.getResources().getString(R.string.special_recommend_tab_title);
        return specialLiveTabInfo;
    }
}
