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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class HotUserRankView {
    private CustomViewPager dYQ;
    private String hjR;
    private BaseFragmentActivity hjZ;
    private TbTabLayout hka;
    private View hkb;
    private View hkc;
    private FragmentAdapter hkd;
    private b hke;
    private View hkf;
    private TextView hkg;
    private View hkh;
    private TextView hki;
    private View hkj;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> fqS = new ArrayList();
    private Runnable hkk = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.dYQ.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.hkf) {
                HotUserRankView.this.hjZ.finish();
            } else if (view == HotUserRankView.this.hkg) {
                if (TextUtils.isEmpty(HotUserRankView.this.hjR)) {
                    HotUserRankView.this.hjZ.showToast(R.string.load_error_retry);
                    return;
                }
                bd.baV().b(HotUserRankView.this.hjZ.getPageContext(), new String[]{HotUserRankView.this.hjR});
                if (HotUserRankView.this.hka.getVisibility() == 0) {
                    ap apVar = new ap("c13658");
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    apVar.ah("obj_locate", 1);
                    TiebaStatic.log(apVar);
                    return;
                }
                ap apVar2 = new ap("c13669");
                apVar2.ah("obj_locate", 1);
                TiebaStatic.log(apVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            HotUserRankView.this.hke.b(((a) HotUserRankView.this.fqS.get(i)).hkn.bVF().getPageData());
            ap apVar = new ap("c13657");
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            apVar.dn("resource_id", ((a) HotUserRankView.this.fqS.get(i)).title);
            TiebaStatic.log(apVar);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener hkl = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.hjZ.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.hkU != null) {
                    HotUserRankView.this.hke.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.hjZ = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.hjZ).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hkf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hkf.setOnClickListener(this.mOnClickListener);
        this.hkg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hjZ.getString(R.string.hot_user_rank_rule));
        this.hkg.setOnClickListener(this.mOnClickListener);
        this.hka = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.hka.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.hkb = this.mRootView.findViewById(R.id.tab_cover_left);
        this.hkc = this.mRootView.findViewById(R.id.tab_cover_right);
        this.dYQ = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.dYQ.addOnPageChangeListener(this.mOnPageChangeListener);
        this.dYQ.setViewPagerScroll(0);
        this.hkd = new FragmentAdapter(this.hjZ.getSupportFragmentManager());
        this.dYQ.setAdapter(this.hkd);
        this.hka.setupWithViewPager(this.dYQ);
        this.hke = new b(this.hjZ.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.hjZ.registerListener(this.hkl);
        this.hkh = this.mRootView.findViewById(R.id.update_tip);
        this.hki = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.hkj = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.hjR = str;
        if (!x.isEmpty(list) || j > 0) {
            this.fqS.clear();
            if (x.isEmpty(list)) {
                this.hka.setVisibility(8);
                a aVar = new a();
                aVar.hkn = new HotUserRankFragment();
                aVar.hkn.setForumId(j);
                this.fqS.add(aVar);
                this.hkd.setData(this.fqS);
                this.hke.tO(1);
                return;
            }
            for (d dVar : list) {
                this.hka.a(this.hka.pF());
                a aVar2 = new a();
                aVar2.hkn = new HotUserRankFragment();
                aVar2.hkn.setCategory(dVar.category);
                aVar2.title = dVar.name;
                this.fqS.add(aVar2);
            }
            this.mNavigationBar.setCenterTextTitle(this.hjZ.getString(R.string.all_hot_user_rank));
            this.hkd.setData(this.fqS);
            this.hke.tO(2);
            if (i != 0) {
                this.dYQ.setCurrentItem(i);
            }
            e.lt().postDelayed(this.hkk, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes16.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fqS;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fqS = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fqS.clear();
            if (!x.isEmpty(list)) {
                this.fqS.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fqS.get(i);
            if (aVar != null) {
                return aVar.hkn;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fqS.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fqS.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public HotUserRankFragment hkn;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hjZ.getPageContext(), i);
        this.hka.setTabTextColors(ao.getColor(R.color.cp_cont_c), ao.getColor(R.color.cp_cont_b));
        this.hka.setSelectedTabIndicatorColor(ao.getColor(R.color.cp_link_tip_a));
        ao.setBackgroundColor(this.hka, R.color.cp_bg_line_h);
        ao.f(this.hkg, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.hke.onChangeSkinType(i);
        Drawable a2 = SvgManager.baR().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.hjZ, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.hjZ, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.hki.setCompoundDrawablePadding(l.getDimens(this.hjZ, R.dimen.tbds9));
        this.hki.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_btn_a).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.hjZ, R.dimen.tbds21)).mo(0).mp(0).aX(this.hkh);
        ao.setBackgroundResource(this.hkb, R.drawable.hot_user_rank_tab_cover_left);
        ao.setBackgroundResource(this.hkc, R.drawable.hot_user_rank_tab_cover_right);
        this.hkj.setVisibility(i != 0 ? 8 : 0);
    }

    public void tN(int i) {
        this.hkh.setVisibility(i);
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.hkk);
    }
}
