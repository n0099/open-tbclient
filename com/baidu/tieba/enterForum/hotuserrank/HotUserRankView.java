package com.baidu.tieba.enterForum.hotuserrank;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotUserRankView {
    private CustomViewPager fbv;
    private TbTabLayout ghk;
    private View iJA;
    private String iJj;
    private BaseFragmentActivity iJr;
    private View iJs;
    private View iJt;
    private FragmentAdapter iJu;
    private b iJv;
    private View iJw;
    private TextView iJx;
    private View iJy;
    private TextView iJz;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gzV = new ArrayList();
    private Runnable iJB = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.fbv.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.iJw) {
                HotUserRankView.this.iJr.finish();
            } else if (view == HotUserRankView.this.iJx) {
                if (TextUtils.isEmpty(HotUserRankView.this.iJj)) {
                    HotUserRankView.this.iJr.showToast(R.string.load_error_retry);
                    return;
                }
                be.bwu().b(HotUserRankView.this.iJr.getPageContext(), new String[]{HotUserRankView.this.iJj});
                if (HotUserRankView.this.ghk.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.an("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13669");
                aqVar2.an("obj_locate", 1);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.gzV.get(i) != null && ((a) HotUserRankView.this.gzV.get(i)).iJE != null && ((a) HotUserRankView.this.gzV.get(i)).iJE.cza() != null) {
                HotUserRankView.this.iJv.b(((a) HotUserRankView.this.gzV.get(i)).iJE.cza().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dX("resource_id", ((a) HotUserRankView.this.gzV.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener iJC = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.iJr.getUniqueId())) {
                c cVar = (c) customResponsedMessage.getData();
                if (cVar.iKj != null) {
                    HotUserRankView.this.iJv.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.iJr = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.iJr).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iJw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iJw.setOnClickListener(this.mOnClickListener);
        this.iJx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iJr.getString(R.string.hot_user_rank_rule));
        this.iJx.setOnClickListener(this.mOnClickListener);
        this.ghk = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.ghk.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.iJs = this.mRootView.findViewById(R.id.tab_cover_left);
        this.iJt = this.mRootView.findViewById(R.id.tab_cover_right);
        this.fbv = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.fbv.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fbv.setViewPagerScroll(0);
        this.iJu = new FragmentAdapter(this.iJr.getSupportFragmentManager());
        this.fbv.setAdapter(this.iJu);
        this.ghk.setupWithViewPager(this.fbv);
        this.iJv = new b(this.iJr.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.iJr.registerListener(this.iJC);
        this.iJy = this.mRootView.findViewById(R.id.update_tip);
        this.iJz = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.iJA = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iJj = str;
        if (!x.isEmpty(list) || j > 0) {
            this.gzV.clear();
            if (x.isEmpty(list)) {
                this.ghk.setVisibility(8);
                a aVar = new a();
                aVar.iJE = new HotUserRankFragment();
                aVar.iJE.setForumId(j);
                this.gzV.add(aVar);
                this.iJu.setData(this.gzV);
                this.iJv.ze(1);
                return;
            }
            for (d dVar : list) {
                this.ghk.a(this.ghk.qN());
                a aVar2 = new a();
                aVar2.iJE = new HotUserRankFragment();
                aVar2.iJE.setCategory(dVar.category);
                aVar2.iJE.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gzV.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.iJr.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.iJr.getString(R.string.all_hot_user_rank));
            }
            this.iJu.setData(this.gzV);
            this.iJv.ze(2);
            if (i != 0) {
                this.fbv.setCurrentItem(i);
            }
            e.mB().postDelayed(this.iJB, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes2.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gzV;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gzV = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gzV.clear();
            if (!x.isEmpty(list)) {
                this.gzV.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gzV.get(i);
            if (aVar != null) {
                return aVar.iJE;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gzV.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gzV.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public HotUserRankFragment iJE;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.iJr.getPageContext(), i);
        this.ghk.setTabTextColors(ao.getColor(R.color.CAM_X0108), ao.getColor(R.color.CAM_X0105));
        this.ghk.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0302));
        ao.setBackgroundColor(this.ghk, R.color.CAM_X0207);
        ao.k(this.iJx, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.iJv.onChangeSkinType(i);
        Drawable a2 = SvgManager.bwq().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.iJr, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.iJr, R.dimen.tbds2);
        if (a2 != null) {
            a2.setBounds(0, dimens2, dimens, dimens + dimens2);
            this.iJz.setCompoundDrawables(a2, null, null, null);
        }
        this.iJz.setCompoundDrawablePadding(l.getDimens(this.iJr, R.dimen.tbds9));
        com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0901).qE(R.color.CAM_X0804).qC(4369).qF(l.getDimens(this.iJr, R.dimen.tbds21)).qG(0).qH(0).bz(this.iJy);
        ao.setBackgroundResource(this.iJs, R.drawable.hot_user_rank_tab_cover_left);
        ao.setBackgroundResource(this.iJt, R.drawable.hot_user_rank_tab_cover_right);
        this.iJA.setVisibility(i != 0 ? 8 : 0);
    }

    public void zd(int i) {
        this.iJy.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.iJB);
    }
}
