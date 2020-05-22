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
    private CustomViewPager dLI;
    private b gRA;
    private View gRB;
    private TextView gRC;
    private View gRD;
    private TextView gRE;
    private View gRF;
    private String gRn;
    private BaseFragmentActivity gRv;
    private TbTabLayout gRw;
    private View gRx;
    private View gRy;
    private FragmentAdapter gRz;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> fap = new ArrayList();
    private Runnable gRG = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.dLI.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.gRB) {
                HotUserRankView.this.gRv.finish();
            } else if (view == HotUserRankView.this.gRC) {
                if (TextUtils.isEmpty(HotUserRankView.this.gRn)) {
                    HotUserRankView.this.gRv.showToast(R.string.load_error_retry);
                    return;
                }
                ba.aUZ().b(HotUserRankView.this.gRv.getPageContext(), new String[]{HotUserRankView.this.gRn});
                if (HotUserRankView.this.gRw.getVisibility() == 0) {
                    an anVar = new an("c13658");
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.ag("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13669");
                anVar2.ag("obj_locate", 1);
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
            HotUserRankView.this.gRA.b(((a) HotUserRankView.this.fap.get(i)).gRJ.bPi().getPageData());
            an anVar = new an("c13657");
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.dh("resource_id", ((a) HotUserRankView.this.fap.get(i)).title);
            TiebaStatic.log(anVar);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gRH = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.gRv.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.gSq != null) {
                    HotUserRankView.this.gRA.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.gRv = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.gRv).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gRB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gRB.setOnClickListener(this.mOnClickListener);
        this.gRC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gRv.getString(R.string.hot_user_rank_rule));
        this.gRC.setOnClickListener(this.mOnClickListener);
        this.gRw = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.gRw.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.gRx = this.mRootView.findViewById(R.id.tab_cover_left);
        this.gRy = this.mRootView.findViewById(R.id.tab_cover_right);
        this.dLI = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.dLI.addOnPageChangeListener(this.mOnPageChangeListener);
        this.dLI.setViewPagerScroll(0);
        this.gRz = new FragmentAdapter(this.gRv.getSupportFragmentManager());
        this.dLI.setAdapter(this.gRz);
        this.gRw.setupWithViewPager(this.dLI);
        this.gRA = new b(this.gRv.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.gRv.registerListener(this.gRH);
        this.gRD = this.mRootView.findViewById(R.id.update_tip);
        this.gRE = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.gRF = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.gRn = str;
        if (!v.isEmpty(list) || j > 0) {
            this.fap.clear();
            if (v.isEmpty(list)) {
                this.gRw.setVisibility(8);
                a aVar = new a();
                aVar.gRJ = new HotUserRankFragment();
                aVar.gRJ.setForumId(j);
                this.fap.add(aVar);
                this.gRz.setData(this.fap);
                this.gRA.sT(1);
                return;
            }
            for (d dVar : list) {
                this.gRw.a(this.gRw.pn());
                a aVar2 = new a();
                aVar2.gRJ = new HotUserRankFragment();
                aVar2.gRJ.setCategory(dVar.category);
                aVar2.title = dVar.name;
                this.fap.add(aVar2);
            }
            this.mNavigationBar.setCenterTextTitle(this.gRv.getString(R.string.all_hot_user_rank));
            this.gRz.setData(this.fap);
            this.gRA.sT(2);
            if (i != 0) {
                this.dLI.setCurrentItem(i);
            }
            e.ld().postDelayed(this.gRG, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes9.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fap;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fap = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fap.clear();
            if (!v.isEmpty(list)) {
                this.fap.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fap.get(i);
            if (aVar != null) {
                return aVar.gRJ;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fap.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fap.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public HotUserRankFragment gRJ;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gRv.getPageContext(), i);
        this.gRw.setTabTextColors(am.getColor(R.color.cp_cont_c), am.getColor(R.color.cp_cont_b));
        this.gRw.setSelectedTabIndicatorColor(am.getColor(R.color.cp_link_tip_a));
        am.setBackgroundColor(this.gRw, R.color.cp_bg_line_h);
        am.d(this.gRC, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.gRA.onChangeSkinType(i);
        Drawable a2 = SvgManager.aUV().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.gRv, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.gRv, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.gRE.setCompoundDrawablePadding(l.getDimens(this.gRv, R.dimen.tbds9));
        this.gRE.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.aVu().lD(R.color.cp_btn_a).lz(R.color.cp_shadow_a_alpha16).lx(4369).lA(l.getDimens(this.gRv, R.dimen.tbds21)).lB(0).lC(0).aR(this.gRD);
        am.setBackgroundResource(this.gRx, R.drawable.hot_user_rank_tab_cover_left);
        am.setBackgroundResource(this.gRy, R.drawable.hot_user_rank_tab_cover_right);
        this.gRF.setVisibility(i != 0 ? 8 : 0);
    }

    public void sS(int i) {
        this.gRD.setVisibility(i);
    }

    public void onDestroy() {
        e.ld().removeCallbacks(this.gRG);
    }
}
