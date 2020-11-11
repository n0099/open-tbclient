package com.baidu.tieba.enterForum.hotuserrank;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class HotUserRankView {
    private CustomViewPager eLl;
    private TbTabLayout fPJ;
    private TextView ilA;
    private View ilB;
    private TextView ilC;
    private View ilD;
    private String ilm;
    private BaseFragmentActivity ilu;
    private View ilv;
    private View ilw;
    private FragmentAdapter ilx;
    private b ily;
    private View ilz;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> ghF = new ArrayList();
    private Runnable ilE = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eLl.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.ilz) {
                HotUserRankView.this.ilu.finish();
            } else if (view == HotUserRankView.this.ilA) {
                if (TextUtils.isEmpty(HotUserRankView.this.ilm)) {
                    HotUserRankView.this.ilu.showToast(R.string.load_error_retry);
                    return;
                }
                be.brr().b(HotUserRankView.this.ilu.getPageContext(), new String[]{HotUserRankView.this.ilm});
                if (HotUserRankView.this.fPJ.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.al("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13669");
                aqVar2.al("obj_locate", 1);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.ghF.get(i) != null && ((a) HotUserRankView.this.ghF.get(i)).ilH != null && ((a) HotUserRankView.this.ghF.get(i)).ilH.cso() != null) {
                HotUserRankView.this.ily.b(((a) HotUserRankView.this.ghF.get(i)).ilH.cso().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dR("resource_id", ((a) HotUserRankView.this.ghF.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener ilF = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.ilu.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.imn != null) {
                    HotUserRankView.this.ily.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.ilu = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.ilu).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ilz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ilz.setOnClickListener(this.mOnClickListener);
        this.ilA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ilu.getString(R.string.hot_user_rank_rule));
        this.ilA.setOnClickListener(this.mOnClickListener);
        this.fPJ = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fPJ.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.ilv = this.mRootView.findViewById(R.id.tab_cover_left);
        this.ilw = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eLl = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eLl.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eLl.setViewPagerScroll(0);
        this.ilx = new FragmentAdapter(this.ilu.getSupportFragmentManager());
        this.eLl.setAdapter(this.ilx);
        this.fPJ.setupWithViewPager(this.eLl);
        this.ily = new b(this.ilu.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.ilu.registerListener(this.ilF);
        this.ilB = this.mRootView.findViewById(R.id.update_tip);
        this.ilC = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.ilD = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.ilm = str;
        if (!y.isEmpty(list) || j > 0) {
            this.ghF.clear();
            if (y.isEmpty(list)) {
                this.fPJ.setVisibility(8);
                a aVar = new a();
                aVar.ilH = new HotUserRankFragment();
                aVar.ilH.setForumId(j);
                this.ghF.add(aVar);
                this.ilx.setData(this.ghF);
                this.ily.xO(1);
                return;
            }
            for (d dVar : list) {
                this.fPJ.a(this.fPJ.rj());
                a aVar2 = new a();
                aVar2.ilH = new HotUserRankFragment();
                aVar2.ilH.setCategory(dVar.category);
                aVar2.ilH.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.ghF.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.ilu.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.ilu.getString(R.string.all_hot_user_rank));
            }
            this.ilx.setData(this.ghF);
            this.ily.xO(2);
            if (i != 0) {
                this.eLl.setCurrentItem(i);
            }
            e.mY().postDelayed(this.ilE, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes22.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> ghF;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.ghF = new ArrayList();
        }

        public void setData(List<a> list) {
            this.ghF.clear();
            if (!y.isEmpty(list)) {
                this.ghF.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.ghF.get(i);
            if (aVar != null) {
                return aVar.ilH;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.ghF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.ghF.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public HotUserRankFragment ilH;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.ilu.getPageContext(), i);
        this.fPJ.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fPJ.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundColor(this.fPJ, R.color.cp_bg_line_h);
        ap.e(this.ilA, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.ily.onChangeSkinType(i);
        Drawable a2 = SvgManager.brn().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.ilu, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.ilu, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.ilC.setCompoundDrawablePadding(l.getDimens(this.ilu, R.dimen.tbds9));
        this.ilC.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_btn_a).pw(R.color.cp_shadow_a_alpha16).pu(4369).px(l.getDimens(this.ilu, R.dimen.tbds21)).py(0).pz(0).bk(this.ilB);
        ap.setBackgroundResource(this.ilv, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.ilw, R.drawable.hot_user_rank_tab_cover_right);
        this.ilD.setVisibility(i != 0 ? 8 : 0);
    }

    public void xN(int i) {
        this.ilB.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.ilE);
    }
}
