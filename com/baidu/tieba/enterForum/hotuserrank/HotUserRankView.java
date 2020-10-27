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
    private CustomViewPager eFw;
    private TbTabLayout fJT;
    private FragmentAdapter ifA;
    private b ifB;
    private View ifC;
    private TextView ifD;
    private View ifE;
    private TextView ifF;
    private View ifG;
    private String ifp;
    private BaseFragmentActivity ifx;
    private View ify;
    private View ifz;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gbQ = new ArrayList();
    private Runnable ifH = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eFw.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.ifC) {
                HotUserRankView.this.ifx.finish();
            } else if (view == HotUserRankView.this.ifD) {
                if (TextUtils.isEmpty(HotUserRankView.this.ifp)) {
                    HotUserRankView.this.ifx.showToast(R.string.load_error_retry);
                    return;
                }
                be.boR().b(HotUserRankView.this.ifx.getPageContext(), new String[]{HotUserRankView.this.ifp});
                if (HotUserRankView.this.fJT.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
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
            if (HotUserRankView.this.gbQ.get(i) != null && ((a) HotUserRankView.this.gbQ.get(i)).ifK != null && ((a) HotUserRankView.this.gbQ.get(i)).ifK.cpN() != null) {
                HotUserRankView.this.ifB.b(((a) HotUserRankView.this.gbQ.get(i)).ifK.cpN().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dR("resource_id", ((a) HotUserRankView.this.gbQ.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener ifI = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.ifx.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.igp != null) {
                    HotUserRankView.this.ifB.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.ifx = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.ifx).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ifC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ifC.setOnClickListener(this.mOnClickListener);
        this.ifD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ifx.getString(R.string.hot_user_rank_rule));
        this.ifD.setOnClickListener(this.mOnClickListener);
        this.fJT = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fJT.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.ify = this.mRootView.findViewById(R.id.tab_cover_left);
        this.ifz = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eFw = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eFw.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eFw.setViewPagerScroll(0);
        this.ifA = new FragmentAdapter(this.ifx.getSupportFragmentManager());
        this.eFw.setAdapter(this.ifA);
        this.fJT.setupWithViewPager(this.eFw);
        this.ifB = new b(this.ifx.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.ifx.registerListener(this.ifI);
        this.ifE = this.mRootView.findViewById(R.id.update_tip);
        this.ifF = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.ifG = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.ifp = str;
        if (!y.isEmpty(list) || j > 0) {
            this.gbQ.clear();
            if (y.isEmpty(list)) {
                this.fJT.setVisibility(8);
                a aVar = new a();
                aVar.ifK = new HotUserRankFragment();
                aVar.ifK.setForumId(j);
                this.gbQ.add(aVar);
                this.ifA.setData(this.gbQ);
                this.ifB.xB(1);
                return;
            }
            for (d dVar : list) {
                this.fJT.a(this.fJT.rj());
                a aVar2 = new a();
                aVar2.ifK = new HotUserRankFragment();
                aVar2.ifK.setCategory(dVar.category);
                aVar2.ifK.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gbQ.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.ifx.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.ifx.getString(R.string.all_hot_user_rank));
            }
            this.ifA.setData(this.gbQ);
            this.ifB.xB(2);
            if (i != 0) {
                this.eFw.setCurrentItem(i);
            }
            e.mY().postDelayed(this.ifH, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes22.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gbQ;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gbQ = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gbQ.clear();
            if (!y.isEmpty(list)) {
                this.gbQ.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gbQ.get(i);
            if (aVar != null) {
                return aVar.ifK;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gbQ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gbQ.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public HotUserRankFragment ifK;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.ifx.getPageContext(), i);
        this.fJT.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fJT.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundColor(this.fJT, R.color.cp_bg_line_h);
        ap.e(this.ifD, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.ifB.onChangeSkinType(i);
        Drawable a2 = SvgManager.boN().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.ifx, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.ifx, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.ifF.setCompoundDrawablePadding(l.getDimens(this.ifx, R.dimen.tbds9));
        this.ifF.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_btn_a).pl(R.color.cp_shadow_a_alpha16).pj(4369).pm(l.getDimens(this.ifx, R.dimen.tbds21)).po(0).pp(0).bg(this.ifE);
        ap.setBackgroundResource(this.ify, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.ifz, R.drawable.hot_user_rank_tab_cover_right);
        this.ifG.setVisibility(i != 0 ? 8 : 0);
    }

    public void xA(int i) {
        this.ifE.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.ifH);
    }
}
