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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class HotUserRankView {
    private CustomViewPager dxy;
    private BaseFragmentActivity gCG;
    private TbTabLayout gCH;
    private View gCI;
    private View gCJ;
    private FragmentAdapter gCK;
    private b gCM;
    private View gCN;
    private TextView gCO;
    private View gCP;
    private TextView gCQ;
    private View gCR;
    private String gCy;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gCL = new ArrayList();
    private Runnable gCS = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.dxy.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.gCN) {
                HotUserRankView.this.gCG.finish();
            } else if (view == HotUserRankView.this.gCO) {
                if (TextUtils.isEmpty(HotUserRankView.this.gCy)) {
                    HotUserRankView.this.gCG.showToast(R.string.load_error_retry);
                    return;
                }
                ba.aOY().b(HotUserRankView.this.gCG.getPageContext(), new String[]{HotUserRankView.this.gCy});
                if (HotUserRankView.this.gCH.getVisibility() == 0) {
                    an anVar = new an("c13658");
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.af("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13669");
                anVar2.af("obj_locate", 1);
                TiebaStatic.log(anVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            com.baidu.tieba.enterForum.hotuserrank.a.c pageData = ((a) HotUserRankView.this.gCL.get(i)).gCV.bIQ().getPageData();
            HotUserRankView.this.gCM.b(pageData);
            if (pageData != null && pageData.gDz != null) {
                an anVar = new an("c13657");
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cI("resource_id", pageData.gDz.gDo);
                TiebaStatic.log(anVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gCT = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.gCG.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.gDB != null) {
                    HotUserRankView.this.gCM.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.gCG = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.gCG).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gCN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCN.setOnClickListener(this.mOnClickListener);
        this.gCO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCG.getString(R.string.hot_user_rank_rule));
        this.gCO.setOnClickListener(this.mOnClickListener);
        this.gCH = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.gCH.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.gCI = this.mRootView.findViewById(R.id.tab_cover_left);
        this.gCJ = this.mRootView.findViewById(R.id.tab_cover_right);
        this.dxy = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.dxy.addOnPageChangeListener(this.mOnPageChangeListener);
        this.dxy.setViewPagerScroll(0);
        this.gCK = new FragmentAdapter(this.gCG.getSupportFragmentManager());
        this.dxy.setAdapter(this.gCK);
        this.gCH.setupWithViewPager(this.dxy);
        this.gCM = new b(this.gCG.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.gCG.registerListener(this.gCT);
        this.gCP = this.mRootView.findViewById(R.id.update_tip);
        this.gCQ = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.gCR = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.gCy = str;
        if (!v.isEmpty(list) || j > 0) {
            this.gCL.clear();
            if (v.isEmpty(list)) {
                this.gCH.setVisibility(8);
                a aVar = new a();
                aVar.gCV = new HotUserRankFragment();
                aVar.gCV.setForumId(j);
                this.gCL.add(aVar);
                this.gCK.setData(this.gCL);
                this.gCM.so(1);
                return;
            }
            for (d dVar : list) {
                this.gCH.a(this.gCH.ph());
                a aVar2 = new a();
                aVar2.gCV = new HotUserRankFragment();
                aVar2.gCV.setCategory(dVar.category);
                aVar2.title = dVar.name;
                this.gCL.add(aVar2);
            }
            this.mNavigationBar.setCenterTextTitle(this.gCG.getString(R.string.all_hot_user_rank));
            this.gCK.setData(this.gCL);
            this.gCM.so(2);
            if (i != 0) {
                this.dxy.setCurrentItem(i);
            }
            e.lb().postDelayed(this.gCS, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes9.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gCL;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gCL = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gCL.clear();
            if (!v.isEmpty(list)) {
                this.gCL.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gCL.get(i);
            if (aVar != null) {
                return aVar.gCV;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gCL.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gCL.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public HotUserRankFragment gCV;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gCG.getPageContext(), i);
        this.gCH.setTabTextColors(am.getColor(R.color.cp_cont_c), am.getColor(R.color.cp_cont_b));
        this.gCH.setSelectedTabIndicatorColor(am.getColor(R.color.cp_link_tip_a));
        am.setBackgroundColor(this.gCH, R.color.cp_bg_line_h);
        am.b(this.gCO, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.gCM.onChangeSkinType(i);
        Drawable a2 = SvgManager.aOU().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.gCG, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.gCG, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.gCQ.setCompoundDrawablePadding(l.getDimens(this.gCG, R.dimen.tbds9));
        this.gCQ.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.aPt().lb(R.color.cp_btn_a).kX(R.color.cp_shadow_a_alpha16).kV(4369).kY(l.getDimens(this.gCG, R.dimen.tbds21)).kZ(0).la(0).aR(this.gCP);
        am.setBackgroundResource(this.gCI, R.drawable.hot_user_rank_tab_cover_left);
        am.setBackgroundResource(this.gCJ, R.drawable.hot_user_rank_tab_cover_right);
        this.gCR.setVisibility(i != 0 ? 8 : 0);
    }

    public void sn(int i) {
        this.gCP.setVisibility(i);
    }

    public void onDestroy() {
        e.lb().removeCallbacks(this.gCS);
    }
}
