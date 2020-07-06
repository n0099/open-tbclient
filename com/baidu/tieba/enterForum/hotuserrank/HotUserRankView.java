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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class HotUserRankView {
    private CustomViewPager dSy;
    private String heh;
    private BaseFragmentActivity hep;
    private TbTabLayout heq;
    private View her;
    private View hes;
    private FragmentAdapter het;
    private b heu;
    private View hev;
    private TextView hew;
    private View hex;
    private TextView hey;
    private View hez;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> flK = new ArrayList();
    private Runnable heA = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.dSy.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.hev) {
                HotUserRankView.this.hep.finish();
            } else if (view == HotUserRankView.this.hew) {
                if (TextUtils.isEmpty(HotUserRankView.this.heh)) {
                    HotUserRankView.this.hep.showToast(R.string.load_error_retry);
                    return;
                }
                bc.aWU().b(HotUserRankView.this.hep.getPageContext(), new String[]{HotUserRankView.this.heh});
                if (HotUserRankView.this.heq.getVisibility() == 0) {
                    ao aoVar = new ao("c13658");
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.ag("obj_locate", 1);
                    TiebaStatic.log(aoVar);
                    return;
                }
                ao aoVar2 = new ao("c13669");
                aoVar2.ag("obj_locate", 1);
                TiebaStatic.log(aoVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            HotUserRankView.this.heu.b(((a) HotUserRankView.this.flK.get(i)).heD.bSo().getPageData());
            ao aoVar = new ao("c13657");
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            aoVar.dk("resource_id", ((a) HotUserRankView.this.flK.get(i)).title);
            TiebaStatic.log(aoVar);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener heB = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.hep.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.hfk != null) {
                    HotUserRankView.this.heu.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.hep = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.hep).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hev = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hev.setOnClickListener(this.mOnClickListener);
        this.hew = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hep.getString(R.string.hot_user_rank_rule));
        this.hew.setOnClickListener(this.mOnClickListener);
        this.heq = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.heq.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.her = this.mRootView.findViewById(R.id.tab_cover_left);
        this.hes = this.mRootView.findViewById(R.id.tab_cover_right);
        this.dSy = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.dSy.addOnPageChangeListener(this.mOnPageChangeListener);
        this.dSy.setViewPagerScroll(0);
        this.het = new FragmentAdapter(this.hep.getSupportFragmentManager());
        this.dSy.setAdapter(this.het);
        this.heq.setupWithViewPager(this.dSy);
        this.heu = new b(this.hep.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.hep.registerListener(this.heB);
        this.hex = this.mRootView.findViewById(R.id.update_tip);
        this.hey = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.hez = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.heh = str;
        if (!w.isEmpty(list) || j > 0) {
            this.flK.clear();
            if (w.isEmpty(list)) {
                this.heq.setVisibility(8);
                a aVar = new a();
                aVar.heD = new HotUserRankFragment();
                aVar.heD.setForumId(j);
                this.flK.add(aVar);
                this.het.setData(this.flK);
                this.heu.tw(1);
                return;
            }
            for (d dVar : list) {
                this.heq.a(this.heq.pE());
                a aVar2 = new a();
                aVar2.heD = new HotUserRankFragment();
                aVar2.heD.setCategory(dVar.category);
                aVar2.title = dVar.name;
                this.flK.add(aVar2);
            }
            this.mNavigationBar.setCenterTextTitle(this.hep.getString(R.string.all_hot_user_rank));
            this.het.setData(this.flK);
            this.heu.tw(2);
            if (i != 0) {
                this.dSy.setCurrentItem(i);
            }
            e.lt().postDelayed(this.heA, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes9.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> flK;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.flK = new ArrayList();
        }

        public void setData(List<a> list) {
            this.flK.clear();
            if (!w.isEmpty(list)) {
                this.flK.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.flK.get(i);
            if (aVar != null) {
                return aVar.heD;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.flK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.flK.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public HotUserRankFragment heD;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hep.getPageContext(), i);
        this.heq.setTabTextColors(an.getColor(R.color.cp_cont_c), an.getColor(R.color.cp_cont_b));
        this.heq.setSelectedTabIndicatorColor(an.getColor(R.color.cp_link_tip_a));
        an.setBackgroundColor(this.heq, R.color.cp_bg_line_h);
        an.d(this.hew, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.heu.onChangeSkinType(i);
        Drawable a2 = SvgManager.aWQ().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.hep, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.hep, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.hey.setCompoundDrawablePadding(l.getDimens(this.hep, R.dimen.tbds9));
        this.hey.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.aXp().lW(R.color.cp_btn_a).lS(R.color.cp_shadow_a_alpha16).lQ(4369).lT(l.getDimens(this.hep, R.dimen.tbds21)).lU(0).lV(0).aR(this.hex);
        an.setBackgroundResource(this.her, R.drawable.hot_user_rank_tab_cover_left);
        an.setBackgroundResource(this.hes, R.drawable.hot_user_rank_tab_cover_right);
        this.hez.setVisibility(i != 0 ? 8 : 0);
    }

    public void tv(int i) {
        this.hex.setVisibility(i);
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.heA);
    }
}
