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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class HotUserRankView {
    private CustomViewPager eRw;
    private TbTabLayout fXB;
    private boolean isGod;
    private String iwU;
    private BaseFragmentActivity ixc;
    private View ixd;
    private View ixe;
    private FragmentAdapter ixf;
    private b ixg;
    private View ixh;
    private TextView ixi;
    private View ixj;
    private TextView ixk;
    private View ixl;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gpw = new ArrayList();
    private Runnable ixm = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eRw.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.ixh) {
                HotUserRankView.this.ixc.finish();
            } else if (view == HotUserRankView.this.ixi) {
                if (TextUtils.isEmpty(HotUserRankView.this.iwU)) {
                    HotUserRankView.this.ixc.showToast(R.string.load_error_retry);
                    return;
                }
                bf.bua().b(HotUserRankView.this.ixc.getPageContext(), new String[]{HotUserRankView.this.iwU});
                if (HotUserRankView.this.fXB.getVisibility() == 0) {
                    ar arVar = new ar("c13658");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.al("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13669");
                arVar2.al("obj_locate", 1);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.gpw.get(i) != null && ((a) HotUserRankView.this.gpw.get(i)).ixp != null && ((a) HotUserRankView.this.gpw.get(i)).ixp.cwg() != null) {
                HotUserRankView.this.ixg.b(((a) HotUserRankView.this.gpw.get(i)).ixp.cwg().getPageData());
                ar arVar = new ar("c13657");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dY("resource_id", ((a) HotUserRankView.this.gpw.get(i)).title);
                TiebaStatic.log(arVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener ixn = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.ixc.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.ixU != null) {
                    HotUserRankView.this.ixg.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.ixc = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.ixc).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ixh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ixh.setOnClickListener(this.mOnClickListener);
        this.ixi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ixc.getString(R.string.hot_user_rank_rule));
        this.ixi.setOnClickListener(this.mOnClickListener);
        this.fXB = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fXB.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.ixd = this.mRootView.findViewById(R.id.tab_cover_left);
        this.ixe = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eRw = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eRw.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eRw.setViewPagerScroll(0);
        this.ixf = new FragmentAdapter(this.ixc.getSupportFragmentManager());
        this.eRw.setAdapter(this.ixf);
        this.fXB.setupWithViewPager(this.eRw);
        this.ixg = new b(this.ixc.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.ixc.registerListener(this.ixn);
        this.ixj = this.mRootView.findViewById(R.id.update_tip);
        this.ixk = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.ixl = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iwU = str;
        if (!y.isEmpty(list) || j > 0) {
            this.gpw.clear();
            if (y.isEmpty(list)) {
                this.fXB.setVisibility(8);
                a aVar = new a();
                aVar.ixp = new HotUserRankFragment();
                aVar.ixp.setForumId(j);
                this.gpw.add(aVar);
                this.ixf.setData(this.gpw);
                this.ixg.yR(1);
                return;
            }
            for (d dVar : list) {
                this.fXB.a(this.fXB.rl());
                a aVar2 = new a();
                aVar2.ixp = new HotUserRankFragment();
                aVar2.ixp.setCategory(dVar.category);
                aVar2.ixp.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gpw.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.ixc.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.ixc.getString(R.string.all_hot_user_rank));
            }
            this.ixf.setData(this.gpw);
            this.ixg.yR(2);
            if (i != 0) {
                this.eRw.setCurrentItem(i);
            }
            e.mY().postDelayed(this.ixm, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes22.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gpw;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gpw = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gpw.clear();
            if (!y.isEmpty(list)) {
                this.gpw.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gpw.get(i);
            if (aVar != null) {
                return aVar.ixp;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gpw.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gpw.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public HotUserRankFragment ixp;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.ixc.getPageContext(), i);
        this.fXB.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.fXB.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundColor(this.fXB, R.color.CAM_X0207);
        ap.e(this.ixi, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.ixg.onChangeSkinType(i);
        Drawable a2 = SvgManager.btW().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.ixc, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.ixc, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.ixk.setCompoundDrawablePadding(l.getDimens(this.ixc, R.dimen.tbds9));
        this.ixk.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.ixc, R.dimen.tbds21)).qv(0).qw(0).bq(this.ixj);
        ap.setBackgroundResource(this.ixd, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.ixe, R.drawable.hot_user_rank_tab_cover_right);
        this.ixl.setVisibility(i != 0 ? 8 : 0);
    }

    public void yQ(int i) {
        this.ixj.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.ixm);
    }
}
