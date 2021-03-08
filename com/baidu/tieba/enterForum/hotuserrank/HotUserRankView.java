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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotUserRankView {
    private CustomViewPager faC;
    private TbTabLayout ggz;
    private String iMi;
    private BaseFragmentActivity iMq;
    private View iMr;
    private View iMs;
    private FragmentAdapter iMt;
    private b iMu;
    private View iMv;
    private TextView iMw;
    private View iMx;
    private TextView iMy;
    private View iMz;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gzV = new ArrayList();
    private Runnable iMA = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.faC.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.iMv) {
                HotUserRankView.this.iMq.finish();
            } else if (view == HotUserRankView.this.iMw) {
                if (TextUtils.isEmpty(HotUserRankView.this.iMi)) {
                    HotUserRankView.this.iMq.showToast(R.string.load_error_retry);
                    return;
                }
                bf.bsY().b(HotUserRankView.this.iMq.getPageContext(), new String[]{HotUserRankView.this.iMi});
                if (HotUserRankView.this.ggz.getVisibility() == 0) {
                    ar arVar = new ar("c13658");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.aq("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13669");
                arVar2.aq("obj_locate", 1);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.gzV.get(i) != null && ((a) HotUserRankView.this.gzV.get(i)).iMD != null && ((a) HotUserRankView.this.gzV.get(i)).iMD.cwI() != null) {
                HotUserRankView.this.iMu.b(((a) HotUserRankView.this.gzV.get(i)).iMD.cwI().getPageData());
                ar arVar = new ar("c13657");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("resource_id", ((a) HotUserRankView.this.gzV.get(i)).title);
                TiebaStatic.log(arVar);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener iMB = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.iMq.getUniqueId())) {
                c cVar = (c) customResponsedMessage.getData();
                if (cVar.iNi != null) {
                    HotUserRankView.this.iMu.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.iMq = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.iMq).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iMv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMv.setOnClickListener(this.mOnClickListener);
        this.iMw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iMq.getString(R.string.hot_user_rank_rule));
        this.iMw.setOnClickListener(this.mOnClickListener);
        this.ggz = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.ggz.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.iMr = this.mRootView.findViewById(R.id.tab_cover_left);
        this.iMs = this.mRootView.findViewById(R.id.tab_cover_right);
        this.faC = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.faC.addOnPageChangeListener(this.mOnPageChangeListener);
        this.faC.setViewPagerScroll(0);
        this.iMt = new FragmentAdapter(this.iMq.getSupportFragmentManager());
        this.faC.setAdapter(this.iMt);
        this.ggz.setupWithViewPager(this.faC);
        this.iMu = new b(this.iMq.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.iMq.registerListener(this.iMB);
        this.iMx = this.mRootView.findViewById(R.id.update_tip);
        this.iMy = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.iMz = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iMi = str;
        if (!y.isEmpty(list) || j > 0) {
            this.gzV.clear();
            if (y.isEmpty(list)) {
                this.ggz.setVisibility(8);
                a aVar = new a();
                aVar.iMD = new HotUserRankFragment();
                aVar.iMD.setForumId(j);
                this.gzV.add(aVar);
                this.iMt.setData(this.gzV);
                this.iMu.xJ(1);
                return;
            }
            for (d dVar : list) {
                this.ggz.a(this.ggz.qL());
                a aVar2 = new a();
                aVar2.iMD = new HotUserRankFragment();
                aVar2.iMD.setCategory(dVar.category);
                aVar2.iMD.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gzV.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.iMq.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.iMq.getString(R.string.all_hot_user_rank));
            }
            this.iMt.setData(this.gzV);
            this.iMu.xJ(2);
            if (i != 0) {
                this.faC.setCurrentItem(i);
            }
            e.mA().postDelayed(this.iMA, 100L);
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
            if (!y.isEmpty(list)) {
                this.gzV.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gzV.get(i);
            if (aVar != null) {
                return aVar.iMD;
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
        public HotUserRankFragment iMD;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.iMq.getPageContext(), i);
        this.ggz.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.ggz.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundColor(this.ggz, R.color.CAM_X0207);
        ap.k(this.iMw, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.iMu.onChangeSkinType(i);
        Drawable a2 = SvgManager.bsU().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.iMq, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.iMq, R.dimen.tbds2);
        if (a2 != null) {
            a2.setBounds(0, dimens2, dimens, dimens + dimens2);
            this.iMy.setCompoundDrawables(a2, null, null, null);
        }
        this.iMy.setCompoundDrawablePadding(l.getDimens(this.iMq, R.dimen.tbds9));
        com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0901).pd(R.color.CAM_X0804).pb(4369).pe(l.getDimens(this.iMq, R.dimen.tbds21)).pf(0).pg(0).bv(this.iMx);
        ap.setBackgroundResource(this.iMr, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.iMs, R.drawable.hot_user_rank_tab_cover_right);
        this.iMz.setVisibility(i != 0 ? 8 : 0);
    }

    public void xI(int i) {
        this.iMx.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.iMA);
    }
}
