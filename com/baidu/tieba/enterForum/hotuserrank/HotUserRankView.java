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
    private CustomViewPager ewX;
    private TbTabLayout fBy;
    private String hSO;
    private BaseFragmentActivity hSW;
    private View hSX;
    private View hSY;
    private FragmentAdapter hSZ;
    private b hTa;
    private View hTb;
    private TextView hTc;
    private View hTd;
    private TextView hTe;
    private View hTf;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> fRN = new ArrayList();
    private Runnable hTg = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.ewX.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.hTb) {
                HotUserRankView.this.hSW.finish();
            } else if (view == HotUserRankView.this.hTc) {
                if (TextUtils.isEmpty(HotUserRankView.this.hSO)) {
                    HotUserRankView.this.hSW.showToast(R.string.load_error_retry);
                    return;
                }
                be.bmY().b(HotUserRankView.this.hSW.getPageContext(), new String[]{HotUserRankView.this.hSO});
                if (HotUserRankView.this.fBy.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.aj("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13669");
                aqVar2.aj("obj_locate", 1);
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
            if (HotUserRankView.this.fRN.get(i) != null && ((a) HotUserRankView.this.fRN.get(i)).hTj != null && ((a) HotUserRankView.this.fRN.get(i)).hTj.cmG() != null) {
                HotUserRankView.this.hTa.b(((a) HotUserRankView.this.fRN.get(i)).hTj.cmG().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dK("resource_id", ((a) HotUserRankView.this.fRN.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener hTh = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.hSW.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.hTP != null) {
                    HotUserRankView.this.hTa.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.hSW = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.hSW).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hTb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hTb.setOnClickListener(this.mOnClickListener);
        this.hTc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hSW.getString(R.string.hot_user_rank_rule));
        this.hTc.setOnClickListener(this.mOnClickListener);
        this.fBy = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fBy.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.hSX = this.mRootView.findViewById(R.id.tab_cover_left);
        this.hSY = this.mRootView.findViewById(R.id.tab_cover_right);
        this.ewX = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.ewX.addOnPageChangeListener(this.mOnPageChangeListener);
        this.ewX.setViewPagerScroll(0);
        this.hSZ = new FragmentAdapter(this.hSW.getSupportFragmentManager());
        this.ewX.setAdapter(this.hSZ);
        this.fBy.setupWithViewPager(this.ewX);
        this.hTa = new b(this.hSW.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.hSW.registerListener(this.hTh);
        this.hTd = this.mRootView.findViewById(R.id.update_tip);
        this.hTe = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.hTf = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.hSO = str;
        if (!y.isEmpty(list) || j > 0) {
            this.fRN.clear();
            if (y.isEmpty(list)) {
                this.fBy.setVisibility(8);
                a aVar = new a();
                aVar.hTj = new HotUserRankFragment();
                aVar.hTj.setForumId(j);
                this.fRN.add(aVar);
                this.hSZ.setData(this.fRN);
                this.hTa.xi(1);
                return;
            }
            for (d dVar : list) {
                this.fBy.a(this.fBy.rj());
                a aVar2 = new a();
                aVar2.hTj = new HotUserRankFragment();
                aVar2.hTj.setCategory(dVar.category);
                aVar2.hTj.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.fRN.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.hSW.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.hSW.getString(R.string.all_hot_user_rank));
            }
            this.hSZ.setData(this.fRN);
            this.hTa.xi(2);
            if (i != 0) {
                this.ewX.setCurrentItem(i);
            }
            e.mY().postDelayed(this.hTg, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes22.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fRN;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fRN = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fRN.clear();
            if (!y.isEmpty(list)) {
                this.fRN.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fRN.get(i);
            if (aVar != null) {
                return aVar.hTj;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fRN.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fRN.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public HotUserRankFragment hTj;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hSW.getPageContext(), i);
        this.fBy.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fBy.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundColor(this.fBy, R.color.cp_bg_line_h);
        ap.e(this.hTc, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.hTa.onChangeSkinType(i);
        Drawable a2 = SvgManager.bmU().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.hSW, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.hSW, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.hTe.setCompoundDrawablePadding(l.getDimens(this.hSW, R.dimen.tbds9));
        this.hTe.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_btn_a).pa(R.color.cp_shadow_a_alpha16).oY(4369).pb(l.getDimens(this.hSW, R.dimen.tbds21)).pc(0).pd(0).bf(this.hTd);
        ap.setBackgroundResource(this.hSX, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.hSY, R.drawable.hot_user_rank_tab_cover_right);
        this.hTf.setVisibility(i != 0 ? 8 : 0);
    }

    public void xh(int i) {
        this.hTd.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.hTg);
    }
}
