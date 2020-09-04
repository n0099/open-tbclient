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
/* loaded from: classes16.dex */
public class HotUserRankView {
    private CustomViewPager eiA;
    private String hwO;
    private BaseFragmentActivity hwW;
    private TbTabLayout hwX;
    private View hwY;
    private View hwZ;
    private FragmentAdapter hxa;
    private b hxb;
    private View hxc;
    private TextView hxd;
    private View hxe;
    private TextView hxf;
    private View hxg;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> fCs = new ArrayList();
    private Runnable hxh = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eiA.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.hxc) {
                HotUserRankView.this.hwW.finish();
            } else if (view == HotUserRankView.this.hxd) {
                if (TextUtils.isEmpty(HotUserRankView.this.hwO)) {
                    HotUserRankView.this.hwW.showToast(R.string.load_error_retry);
                    return;
                }
                be.bju().b(HotUserRankView.this.hwW.getPageContext(), new String[]{HotUserRankView.this.hwO});
                if (HotUserRankView.this.hwX.getVisibility() == 0) {
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
            if (HotUserRankView.this.fCs.get(i) != null && ((a) HotUserRankView.this.fCs.get(i)).hxk != null && ((a) HotUserRankView.this.fCs.get(i)).hxk.cfT() != null) {
                HotUserRankView.this.hxb.b(((a) HotUserRankView.this.fCs.get(i)).hxk.cfT().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dD("resource_id", ((a) HotUserRankView.this.fCs.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener hxi = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.hwW.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.hxR != null) {
                    HotUserRankView.this.hxb.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.hwW = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.hwW).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hxc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hxc.setOnClickListener(this.mOnClickListener);
        this.hxd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hwW.getString(R.string.hot_user_rank_rule));
        this.hxd.setOnClickListener(this.mOnClickListener);
        this.hwX = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.hwX.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.hwY = this.mRootView.findViewById(R.id.tab_cover_left);
        this.hwZ = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eiA = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eiA.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eiA.setViewPagerScroll(0);
        this.hxa = new FragmentAdapter(this.hwW.getSupportFragmentManager());
        this.eiA.setAdapter(this.hxa);
        this.hwX.setupWithViewPager(this.eiA);
        this.hxb = new b(this.hwW.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.hwW.registerListener(this.hxi);
        this.hxe = this.mRootView.findViewById(R.id.update_tip);
        this.hxf = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.hxg = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.hwO = str;
        if (!y.isEmpty(list) || j > 0) {
            this.fCs.clear();
            if (y.isEmpty(list)) {
                this.hwX.setVisibility(8);
                a aVar = new a();
                aVar.hxk = new HotUserRankFragment();
                aVar.hxk.setForumId(j);
                this.fCs.add(aVar);
                this.hxa.setData(this.fCs);
                this.hxb.wd(1);
                return;
            }
            for (d dVar : list) {
                this.hwX.a(this.hwX.re());
                a aVar2 = new a();
                aVar2.hxk = new HotUserRankFragment();
                aVar2.hxk.setCategory(dVar.category);
                aVar2.hxk.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.fCs.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.hwW.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.hwW.getString(R.string.all_hot_user_rank));
            }
            this.hxa.setData(this.fCs);
            this.hxb.wd(2);
            if (i != 0) {
                this.eiA.setCurrentItem(i);
            }
            e.mS().postDelayed(this.hxh, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes16.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fCs;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fCs = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fCs.clear();
            if (!y.isEmpty(list)) {
                this.fCs.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fCs.get(i);
            if (aVar != null) {
                return aVar.hxk;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fCs.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fCs.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public HotUserRankFragment hxk;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hwW.getPageContext(), i);
        this.hwX.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.hwX.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundColor(this.hwX, R.color.cp_bg_line_h);
        ap.e(this.hxd, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.hxb.onChangeSkinType(i);
        Drawable a2 = SvgManager.bjq().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.hwW, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.hwW, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.hxf.setCompoundDrawablePadding(l.getDimens(this.hwW, R.dimen.tbds9));
        this.hxf.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.hwW, R.dimen.tbds21)).os(0).ot(0).aZ(this.hxe);
        ap.setBackgroundResource(this.hwY, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.hwZ, R.drawable.hot_user_rank_tab_cover_right);
        this.hxg.setVisibility(i != 0 ? 8 : 0);
    }

    public void wc(int i) {
        this.hxe.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mS().removeCallbacks(this.hxh);
    }
}
