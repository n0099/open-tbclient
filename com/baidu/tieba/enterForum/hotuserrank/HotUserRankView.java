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
    private CustomViewPager eZd;
    private TbTabLayout geR;
    private View iKA;
    private TextView iKB;
    private View iKC;
    private String iKl;
    private BaseFragmentActivity iKt;
    private View iKu;
    private View iKv;
    private FragmentAdapter iKw;
    private b iKx;
    private View iKy;
    private TextView iKz;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gxY = new ArrayList();
    private Runnable iKD = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eZd.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.iKy) {
                HotUserRankView.this.iKt.finish();
            } else if (view == HotUserRankView.this.iKz) {
                if (TextUtils.isEmpty(HotUserRankView.this.iKl)) {
                    HotUserRankView.this.iKt.showToast(R.string.load_error_retry);
                    return;
                }
                bf.bsV().b(HotUserRankView.this.iKt.getPageContext(), new String[]{HotUserRankView.this.iKl});
                if (HotUserRankView.this.geR.getVisibility() == 0) {
                    ar arVar = new ar("c13658");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.ap("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13669");
                arVar2.ap("obj_locate", 1);
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
            if (HotUserRankView.this.gxY.get(i) != null && ((a) HotUserRankView.this.gxY.get(i)).iKG != null && ((a) HotUserRankView.this.gxY.get(i)).iKG.cwv() != null) {
                HotUserRankView.this.iKx.b(((a) HotUserRankView.this.gxY.get(i)).iKG.cwv().getPageData());
                ar arVar = new ar("c13657");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("resource_id", ((a) HotUserRankView.this.gxY.get(i)).title);
                TiebaStatic.log(arVar);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener iKE = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.iKt.getUniqueId())) {
                c cVar = (c) customResponsedMessage.getData();
                if (cVar.iLl != null) {
                    HotUserRankView.this.iKx.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.iKt = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.iKt).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iKy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iKy.setOnClickListener(this.mOnClickListener);
        this.iKz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iKt.getString(R.string.hot_user_rank_rule));
        this.iKz.setOnClickListener(this.mOnClickListener);
        this.geR = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.geR.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.iKu = this.mRootView.findViewById(R.id.tab_cover_left);
        this.iKv = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eZd = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eZd.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eZd.setViewPagerScroll(0);
        this.iKw = new FragmentAdapter(this.iKt.getSupportFragmentManager());
        this.eZd.setAdapter(this.iKw);
        this.geR.setupWithViewPager(this.eZd);
        this.iKx = new b(this.iKt.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.iKt.registerListener(this.iKE);
        this.iKA = this.mRootView.findViewById(R.id.update_tip);
        this.iKB = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.iKC = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iKl = str;
        if (!y.isEmpty(list) || j > 0) {
            this.gxY.clear();
            if (y.isEmpty(list)) {
                this.geR.setVisibility(8);
                a aVar = new a();
                aVar.iKG = new HotUserRankFragment();
                aVar.iKG.setForumId(j);
                this.gxY.add(aVar);
                this.iKw.setData(this.gxY);
                this.iKx.xI(1);
                return;
            }
            for (d dVar : list) {
                this.geR.a(this.geR.qL());
                a aVar2 = new a();
                aVar2.iKG = new HotUserRankFragment();
                aVar2.iKG.setCategory(dVar.category);
                aVar2.iKG.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gxY.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.iKt.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.iKt.getString(R.string.all_hot_user_rank));
            }
            this.iKw.setData(this.gxY);
            this.iKx.xI(2);
            if (i != 0) {
                this.eZd.setCurrentItem(i);
            }
            e.mA().postDelayed(this.iKD, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes2.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gxY;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gxY = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gxY.clear();
            if (!y.isEmpty(list)) {
                this.gxY.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gxY.get(i);
            if (aVar != null) {
                return aVar.iKG;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gxY.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gxY.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public HotUserRankFragment iKG;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.iKt.getPageContext(), i);
        this.geR.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.geR.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundColor(this.geR, R.color.CAM_X0207);
        ap.k(this.iKz, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.iKx.onChangeSkinType(i);
        Drawable a2 = SvgManager.bsR().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.iKt, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.iKt, R.dimen.tbds2);
        if (a2 != null) {
            a2.setBounds(0, dimens2, dimens, dimens + dimens2);
            this.iKB.setCompoundDrawables(a2, null, null, null);
        }
        this.iKB.setCompoundDrawablePadding(l.getDimens(this.iKt, R.dimen.tbds9));
        com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.iKt, R.dimen.tbds21)).pe(0).pf(0).bv(this.iKA);
        ap.setBackgroundResource(this.iKu, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.iKv, R.drawable.hot_user_rank_tab_cover_right);
        this.iKC.setVisibility(i != 0 ? 8 : 0);
    }

    public void xH(int i) {
        this.iKA.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.iKD);
    }
}
