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
    private TbTabLayout fXD;
    private boolean isGod;
    private String iwW;
    private BaseFragmentActivity ixe;
    private View ixf;
    private View ixg;
    private FragmentAdapter ixh;
    private b ixi;
    private View ixj;
    private TextView ixk;
    private View ixl;
    private TextView ixm;
    private View ixn;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gpy = new ArrayList();
    private Runnable ixo = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eRw.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.ixj) {
                HotUserRankView.this.ixe.finish();
            } else if (view == HotUserRankView.this.ixk) {
                if (TextUtils.isEmpty(HotUserRankView.this.iwW)) {
                    HotUserRankView.this.ixe.showToast(R.string.load_error_retry);
                    return;
                }
                bf.bua().b(HotUserRankView.this.ixe.getPageContext(), new String[]{HotUserRankView.this.iwW});
                if (HotUserRankView.this.fXD.getVisibility() == 0) {
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
            if (HotUserRankView.this.gpy.get(i) != null && ((a) HotUserRankView.this.gpy.get(i)).ixr != null && ((a) HotUserRankView.this.gpy.get(i)).ixr.cwh() != null) {
                HotUserRankView.this.ixi.b(((a) HotUserRankView.this.gpy.get(i)).ixr.cwh().getPageData());
                ar arVar = new ar("c13657");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dY("resource_id", ((a) HotUserRankView.this.gpy.get(i)).title);
                TiebaStatic.log(arVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener ixp = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.ixe.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.ixW != null) {
                    HotUserRankView.this.ixi.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.ixe = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.ixe).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ixj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ixj.setOnClickListener(this.mOnClickListener);
        this.ixk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ixe.getString(R.string.hot_user_rank_rule));
        this.ixk.setOnClickListener(this.mOnClickListener);
        this.fXD = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.fXD.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.ixf = this.mRootView.findViewById(R.id.tab_cover_left);
        this.ixg = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eRw = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eRw.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eRw.setViewPagerScroll(0);
        this.ixh = new FragmentAdapter(this.ixe.getSupportFragmentManager());
        this.eRw.setAdapter(this.ixh);
        this.fXD.setupWithViewPager(this.eRw);
        this.ixi = new b(this.ixe.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.ixe.registerListener(this.ixp);
        this.ixl = this.mRootView.findViewById(R.id.update_tip);
        this.ixm = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.ixn = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iwW = str;
        if (!y.isEmpty(list) || j > 0) {
            this.gpy.clear();
            if (y.isEmpty(list)) {
                this.fXD.setVisibility(8);
                a aVar = new a();
                aVar.ixr = new HotUserRankFragment();
                aVar.ixr.setForumId(j);
                this.gpy.add(aVar);
                this.ixh.setData(this.gpy);
                this.ixi.yR(1);
                return;
            }
            for (d dVar : list) {
                this.fXD.a(this.fXD.rl());
                a aVar2 = new a();
                aVar2.ixr = new HotUserRankFragment();
                aVar2.ixr.setCategory(dVar.category);
                aVar2.ixr.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gpy.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.ixe.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.ixe.getString(R.string.all_hot_user_rank));
            }
            this.ixh.setData(this.gpy);
            this.ixi.yR(2);
            if (i != 0) {
                this.eRw.setCurrentItem(i);
            }
            e.mY().postDelayed(this.ixo, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes22.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gpy;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gpy = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gpy.clear();
            if (!y.isEmpty(list)) {
                this.gpy.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gpy.get(i);
            if (aVar != null) {
                return aVar.ixr;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gpy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gpy.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public HotUserRankFragment ixr;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.ixe.getPageContext(), i);
        this.fXD.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.fXD.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundColor(this.fXD, R.color.CAM_X0207);
        ap.e(this.ixk, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.ixi.onChangeSkinType(i);
        Drawable a2 = SvgManager.btW().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.ixe, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.ixe, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.ixm.setCompoundDrawablePadding(l.getDimens(this.ixe, R.dimen.tbds9));
        this.ixm.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.ixe, R.dimen.tbds21)).qv(0).qw(0).bq(this.ixl);
        ap.setBackgroundResource(this.ixf, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.ixg, R.drawable.hot_user_rank_tab_cover_right);
        this.ixn.setVisibility(i != 0 ? 8 : 0);
    }

    public void yQ(int i) {
        this.ixl.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.ixo);
    }
}
