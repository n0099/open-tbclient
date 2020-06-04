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
    private BaseFragmentActivity gRG;
    private TbTabLayout gRH;
    private View gRI;
    private View gRJ;
    private FragmentAdapter gRK;
    private b gRL;
    private View gRM;
    private TextView gRN;
    private View gRO;
    private TextView gRP;
    private View gRQ;
    private String gRy;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> faA = new ArrayList();
    private Runnable gRR = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.dLI.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.gRM) {
                HotUserRankView.this.gRG.finish();
            } else if (view == HotUserRankView.this.gRN) {
                if (TextUtils.isEmpty(HotUserRankView.this.gRy)) {
                    HotUserRankView.this.gRG.showToast(R.string.load_error_retry);
                    return;
                }
                ba.aVa().b(HotUserRankView.this.gRG.getPageContext(), new String[]{HotUserRankView.this.gRy});
                if (HotUserRankView.this.gRH.getVisibility() == 0) {
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
            HotUserRankView.this.gRL.b(((a) HotUserRankView.this.faA.get(i)).gRU.bPk().getPageData());
            an anVar = new an("c13657");
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.dh("resource_id", ((a) HotUserRankView.this.faA.get(i)).title);
            TiebaStatic.log(anVar);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gRS = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.gRG.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.gSB != null) {
                    HotUserRankView.this.gRL.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.gRG = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.gRG).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gRM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gRM.setOnClickListener(this.mOnClickListener);
        this.gRN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gRG.getString(R.string.hot_user_rank_rule));
        this.gRN.setOnClickListener(this.mOnClickListener);
        this.gRH = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.gRH.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.gRI = this.mRootView.findViewById(R.id.tab_cover_left);
        this.gRJ = this.mRootView.findViewById(R.id.tab_cover_right);
        this.dLI = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.dLI.addOnPageChangeListener(this.mOnPageChangeListener);
        this.dLI.setViewPagerScroll(0);
        this.gRK = new FragmentAdapter(this.gRG.getSupportFragmentManager());
        this.dLI.setAdapter(this.gRK);
        this.gRH.setupWithViewPager(this.dLI);
        this.gRL = new b(this.gRG.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.gRG.registerListener(this.gRS);
        this.gRO = this.mRootView.findViewById(R.id.update_tip);
        this.gRP = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.gRQ = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.gRy = str;
        if (!v.isEmpty(list) || j > 0) {
            this.faA.clear();
            if (v.isEmpty(list)) {
                this.gRH.setVisibility(8);
                a aVar = new a();
                aVar.gRU = new HotUserRankFragment();
                aVar.gRU.setForumId(j);
                this.faA.add(aVar);
                this.gRK.setData(this.faA);
                this.gRL.sV(1);
                return;
            }
            for (d dVar : list) {
                this.gRH.a(this.gRH.pn());
                a aVar2 = new a();
                aVar2.gRU = new HotUserRankFragment();
                aVar2.gRU.setCategory(dVar.category);
                aVar2.title = dVar.name;
                this.faA.add(aVar2);
            }
            this.mNavigationBar.setCenterTextTitle(this.gRG.getString(R.string.all_hot_user_rank));
            this.gRK.setData(this.faA);
            this.gRL.sV(2);
            if (i != 0) {
                this.dLI.setCurrentItem(i);
            }
            e.ld().postDelayed(this.gRR, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes9.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> faA;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.faA = new ArrayList();
        }

        public void setData(List<a> list) {
            this.faA.clear();
            if (!v.isEmpty(list)) {
                this.faA.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.faA.get(i);
            if (aVar != null) {
                return aVar.gRU;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.faA.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.faA.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public HotUserRankFragment gRU;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gRG.getPageContext(), i);
        this.gRH.setTabTextColors(am.getColor(R.color.cp_cont_c), am.getColor(R.color.cp_cont_b));
        this.gRH.setSelectedTabIndicatorColor(am.getColor(R.color.cp_link_tip_a));
        am.setBackgroundColor(this.gRH, R.color.cp_bg_line_h);
        am.d(this.gRN, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.gRL.onChangeSkinType(i);
        Drawable a2 = SvgManager.aUW().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.gRG, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.gRG, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.gRP.setCompoundDrawablePadding(l.getDimens(this.gRG, R.dimen.tbds9));
        this.gRP.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.aVv().lF(R.color.cp_btn_a).lB(R.color.cp_shadow_a_alpha16).lz(4369).lC(l.getDimens(this.gRG, R.dimen.tbds21)).lD(0).lE(0).aR(this.gRO);
        am.setBackgroundResource(this.gRI, R.drawable.hot_user_rank_tab_cover_left);
        am.setBackgroundResource(this.gRJ, R.drawable.hot_user_rank_tab_cover_right);
        this.gRQ.setVisibility(i != 0 ? 8 : 0);
    }

    public void sU(int i) {
        this.gRO.setVisibility(i);
    }

    public void onDestroy() {
        e.ld().removeCallbacks(this.gRR);
    }
}
