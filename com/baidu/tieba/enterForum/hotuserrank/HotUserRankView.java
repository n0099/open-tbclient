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
    private CustomViewPager dxC;
    private String gCE;
    private BaseFragmentActivity gCM;
    private TbTabLayout gCN;
    private View gCO;
    private View gCP;
    private FragmentAdapter gCQ;
    private b gCS;
    private View gCT;
    private TextView gCU;
    private View gCV;
    private TextView gCW;
    private View gCX;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gCR = new ArrayList();
    private Runnable gCY = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.dxC.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.gCT) {
                HotUserRankView.this.gCM.finish();
            } else if (view == HotUserRankView.this.gCU) {
                if (TextUtils.isEmpty(HotUserRankView.this.gCE)) {
                    HotUserRankView.this.gCM.showToast(R.string.load_error_retry);
                    return;
                }
                ba.aOV().b(HotUserRankView.this.gCM.getPageContext(), new String[]{HotUserRankView.this.gCE});
                if (HotUserRankView.this.gCN.getVisibility() == 0) {
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
            com.baidu.tieba.enterForum.hotuserrank.a.c pageData = ((a) HotUserRankView.this.gCR.get(i)).gDb.bIO().getPageData();
            HotUserRankView.this.gCS.b(pageData);
            if (pageData != null && pageData.gDF != null) {
                an anVar = new an("c13657");
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cI("resource_id", pageData.gDF.gDu);
                TiebaStatic.log(anVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gCZ = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.gCM.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.gDH != null) {
                    HotUserRankView.this.gCS.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.gCM = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.gCM).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gCT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCT.setOnClickListener(this.mOnClickListener);
        this.gCU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCM.getString(R.string.hot_user_rank_rule));
        this.gCU.setOnClickListener(this.mOnClickListener);
        this.gCN = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.gCN.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.gCO = this.mRootView.findViewById(R.id.tab_cover_left);
        this.gCP = this.mRootView.findViewById(R.id.tab_cover_right);
        this.dxC = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.dxC.addOnPageChangeListener(this.mOnPageChangeListener);
        this.dxC.setViewPagerScroll(0);
        this.gCQ = new FragmentAdapter(this.gCM.getSupportFragmentManager());
        this.dxC.setAdapter(this.gCQ);
        this.gCN.setupWithViewPager(this.dxC);
        this.gCS = new b(this.gCM.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.gCM.registerListener(this.gCZ);
        this.gCV = this.mRootView.findViewById(R.id.update_tip);
        this.gCW = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.gCX = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.gCE = str;
        if (!v.isEmpty(list) || j > 0) {
            this.gCR.clear();
            if (v.isEmpty(list)) {
                this.gCN.setVisibility(8);
                a aVar = new a();
                aVar.gDb = new HotUserRankFragment();
                aVar.gDb.setForumId(j);
                this.gCR.add(aVar);
                this.gCQ.setData(this.gCR);
                this.gCS.so(1);
                return;
            }
            for (d dVar : list) {
                this.gCN.a(this.gCN.ph());
                a aVar2 = new a();
                aVar2.gDb = new HotUserRankFragment();
                aVar2.gDb.setCategory(dVar.category);
                aVar2.title = dVar.name;
                this.gCR.add(aVar2);
            }
            this.mNavigationBar.setCenterTextTitle(this.gCM.getString(R.string.all_hot_user_rank));
            this.gCQ.setData(this.gCR);
            this.gCS.so(2);
            if (i != 0) {
                this.dxC.setCurrentItem(i);
            }
            e.lb().postDelayed(this.gCY, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes9.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gCR;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gCR = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gCR.clear();
            if (!v.isEmpty(list)) {
                this.gCR.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gCR.get(i);
            if (aVar != null) {
                return aVar.gDb;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gCR.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gCR.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public HotUserRankFragment gDb;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gCM.getPageContext(), i);
        this.gCN.setTabTextColors(am.getColor(R.color.cp_cont_c), am.getColor(R.color.cp_cont_b));
        this.gCN.setSelectedTabIndicatorColor(am.getColor(R.color.cp_link_tip_a));
        am.setBackgroundColor(this.gCN, R.color.cp_bg_line_h);
        am.b(this.gCU, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.gCS.onChangeSkinType(i);
        Drawable a2 = SvgManager.aOR().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.gCM, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.gCM, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.gCW.setCompoundDrawablePadding(l.getDimens(this.gCM, R.dimen.tbds9));
        this.gCW.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.aPq().lb(R.color.cp_btn_a).kX(R.color.cp_shadow_a_alpha16).kV(4369).kY(l.getDimens(this.gCM, R.dimen.tbds21)).kZ(0).la(0).aR(this.gCV);
        am.setBackgroundResource(this.gCO, R.drawable.hot_user_rank_tab_cover_left);
        am.setBackgroundResource(this.gCP, R.drawable.hot_user_rank_tab_cover_right);
        this.gCX.setVisibility(i != 0 ? 8 : 0);
    }

    public void sn(int i) {
        this.gCV.setVisibility(i);
    }

    public void onDestroy() {
        e.lb().removeCallbacks(this.gCY);
    }
}
