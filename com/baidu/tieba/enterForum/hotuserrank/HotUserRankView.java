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
/* loaded from: classes21.dex */
public class HotUserRankView {
    private CustomViewPager ekP;
    private TbTabLayout fpk;
    private String hDS;
    private BaseFragmentActivity hEa;
    private View hEb;
    private View hEc;
    private FragmentAdapter hEd;
    private b hEe;
    private View hEf;
    private TextView hEg;
    private View hEh;
    private TextView hEi;
    private View hEj;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> fFE = new ArrayList();
    private Runnable hEk = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.ekP.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.hEf) {
                HotUserRankView.this.hEa.finish();
            } else if (view == HotUserRankView.this.hEg) {
                if (TextUtils.isEmpty(HotUserRankView.this.hDS)) {
                    HotUserRankView.this.hEa.showToast(R.string.load_error_retry);
                    return;
                }
                be.bkp().b(HotUserRankView.this.hEa.getPageContext(), new String[]{HotUserRankView.this.hDS});
                if (HotUserRankView.this.fpk.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13669");
                aqVar2.ai("obj_locate", 1);
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
            if (HotUserRankView.this.fFE.get(i) != null && ((a) HotUserRankView.this.fFE.get(i)).hEn != null && ((a) HotUserRankView.this.fFE.get(i)).hEn.cjk() != null) {
                HotUserRankView.this.hEe.b(((a) HotUserRankView.this.fFE.get(i)).hEn.cjk().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dF("resource_id", ((a) HotUserRankView.this.fFE.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener hEl = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.hEa.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.hET != null) {
                    HotUserRankView.this.hEe.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.hEa = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.hEa).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hEf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hEf.setOnClickListener(this.mOnClickListener);
        this.hEg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hEa.getString(R.string.hot_user_rank_rule));
        this.hEg.setOnClickListener(this.mOnClickListener);
        this.fpk = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fpk.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.hEb = this.mRootView.findViewById(R.id.tab_cover_left);
        this.hEc = this.mRootView.findViewById(R.id.tab_cover_right);
        this.ekP = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.ekP.addOnPageChangeListener(this.mOnPageChangeListener);
        this.ekP.setViewPagerScroll(0);
        this.hEd = new FragmentAdapter(this.hEa.getSupportFragmentManager());
        this.ekP.setAdapter(this.hEd);
        this.fpk.setupWithViewPager(this.ekP);
        this.hEe = new b(this.hEa.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.hEa.registerListener(this.hEl);
        this.hEh = this.mRootView.findViewById(R.id.update_tip);
        this.hEi = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.hEj = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.hDS = str;
        if (!y.isEmpty(list) || j > 0) {
            this.fFE.clear();
            if (y.isEmpty(list)) {
                this.fpk.setVisibility(8);
                a aVar = new a();
                aVar.hEn = new HotUserRankFragment();
                aVar.hEn.setForumId(j);
                this.fFE.add(aVar);
                this.hEd.setData(this.fFE);
                this.hEe.wC(1);
                return;
            }
            for (d dVar : list) {
                this.fpk.a(this.fpk.rj());
                a aVar2 = new a();
                aVar2.hEn = new HotUserRankFragment();
                aVar2.hEn.setCategory(dVar.category);
                aVar2.hEn.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.fFE.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.hEa.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.hEa.getString(R.string.all_hot_user_rank));
            }
            this.hEd.setData(this.fFE);
            this.hEe.wC(2);
            if (i != 0) {
                this.ekP.setCurrentItem(i);
            }
            e.mX().postDelayed(this.hEk, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes21.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fFE;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fFE = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fFE.clear();
            if (!y.isEmpty(list)) {
                this.fFE.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fFE.get(i);
            if (aVar != null) {
                return aVar.hEn;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fFE.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fFE.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes21.dex */
    public class a {
        public HotUserRankFragment hEn;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hEa.getPageContext(), i);
        this.fpk.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fpk.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundColor(this.fpk, R.color.cp_bg_line_h);
        ap.e(this.hEg, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.hEe.onChangeSkinType(i);
        Drawable a2 = SvgManager.bkl().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.hEa, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.hEa, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.hEi.setCompoundDrawablePadding(l.getDimens(this.hEa, R.dimen.tbds9));
        this.hEi.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_btn_a).oC(R.color.cp_shadow_a_alpha16).oA(4369).oD(l.getDimens(this.hEa, R.dimen.tbds21)).oE(0).oF(0).bb(this.hEh);
        ap.setBackgroundResource(this.hEb, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.hEc, R.drawable.hot_user_rank_tab_cover_right);
        this.hEj.setVisibility(i != 0 ? 8 : 0);
    }

    public void wB(int i) {
        this.hEh.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mX().removeCallbacks(this.hEk);
    }
}
