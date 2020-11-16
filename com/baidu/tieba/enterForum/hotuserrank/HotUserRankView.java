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
/* loaded from: classes21.dex */
public class HotUserRankView {
    private CustomViewPager eKk;
    private TbTabLayout fPs;
    private String ima;
    private BaseFragmentActivity imj;
    private View imk;
    private View iml;
    private FragmentAdapter imm;
    private b imn;
    private View imo;
    private TextView imp;
    private View imq;
    private TextView imr;
    private View ims;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> ghm = new ArrayList();
    private Runnable imt = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eKk.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.imo) {
                HotUserRankView.this.imj.finish();
            } else if (view == HotUserRankView.this.imp) {
                if (TextUtils.isEmpty(HotUserRankView.this.ima)) {
                    HotUserRankView.this.imj.showToast(R.string.load_error_retry);
                    return;
                }
                bf.bqF().b(HotUserRankView.this.imj.getPageContext(), new String[]{HotUserRankView.this.ima});
                if (HotUserRankView.this.fPs.getVisibility() == 0) {
                    ar arVar = new ar("c13658");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.ak("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13669");
                arVar2.ak("obj_locate", 1);
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
            if (HotUserRankView.this.ghm.get(i) != null && ((a) HotUserRankView.this.ghm.get(i)).imw != null && ((a) HotUserRankView.this.ghm.get(i)).imw.crR() != null) {
                HotUserRankView.this.imn.b(((a) HotUserRankView.this.ghm.get(i)).imw.crR().getPageData());
                ar arVar = new ar("c13657");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("resource_id", ((a) HotUserRankView.this.ghm.get(i)).title);
                TiebaStatic.log(arVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener imu = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.imj.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.inb != null) {
                    HotUserRankView.this.imn.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.imj = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.imj).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.imo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.imo.setOnClickListener(this.mOnClickListener);
        this.imp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.imj.getString(R.string.hot_user_rank_rule));
        this.imp.setOnClickListener(this.mOnClickListener);
        this.fPs = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fPs.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.imk = this.mRootView.findViewById(R.id.tab_cover_left);
        this.iml = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eKk = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eKk.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eKk.setViewPagerScroll(0);
        this.imm = new FragmentAdapter(this.imj.getSupportFragmentManager());
        this.eKk.setAdapter(this.imm);
        this.fPs.setupWithViewPager(this.eKk);
        this.imn = new b(this.imj.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.imj.registerListener(this.imu);
        this.imq = this.mRootView.findViewById(R.id.update_tip);
        this.imr = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.ims = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.ima = str;
        if (!y.isEmpty(list) || j > 0) {
            this.ghm.clear();
            if (y.isEmpty(list)) {
                this.fPs.setVisibility(8);
                a aVar = new a();
                aVar.imw = new HotUserRankFragment();
                aVar.imw.setForumId(j);
                this.ghm.add(aVar);
                this.imm.setData(this.ghm);
                this.imn.ym(1);
                return;
            }
            for (d dVar : list) {
                this.fPs.a(this.fPs.rj());
                a aVar2 = new a();
                aVar2.imw = new HotUserRankFragment();
                aVar2.imw.setCategory(dVar.category);
                aVar2.imw.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.ghm.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.imj.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.imj.getString(R.string.all_hot_user_rank));
            }
            this.imm.setData(this.ghm);
            this.imn.ym(2);
            if (i != 0) {
                this.eKk.setCurrentItem(i);
            }
            e.mY().postDelayed(this.imt, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes21.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> ghm;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.ghm = new ArrayList();
        }

        public void setData(List<a> list) {
            this.ghm.clear();
            if (!y.isEmpty(list)) {
                this.ghm.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.ghm.get(i);
            if (aVar != null) {
                return aVar.imw;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.ghm.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.ghm.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes21.dex */
    public class a {
        public HotUserRankFragment imw;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.imj.getPageContext(), i);
        this.fPs.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.fPs.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundColor(this.fPs, R.color.CAM_X0207);
        ap.f(this.imp, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.imn.onChangeSkinType(i);
        Drawable a2 = SvgManager.bqB().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.imj, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.imj, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.imr.setCompoundDrawablePadding(l.getDimens(this.imj, R.dimen.tbds9));
        this.imr.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0901).pT(R.color.CAM_X0804).pR(4369).pU(l.getDimens(this.imj, R.dimen.tbds21)).pV(0).pW(0).bn(this.imq);
        ap.setBackgroundResource(this.imk, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.iml, R.drawable.hot_user_rank_tab_cover_right);
        this.ims.setVisibility(i != 0 ? 8 : 0);
    }

    public void yl(int i) {
        this.imq.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.imt);
    }
}
