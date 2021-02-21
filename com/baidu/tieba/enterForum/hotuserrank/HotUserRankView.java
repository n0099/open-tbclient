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
    private TbTabLayout geW;
    private BaseFragmentActivity iKH;
    private View iKI;
    private View iKJ;
    private FragmentAdapter iKK;
    private b iKL;
    private View iKM;
    private TextView iKN;
    private View iKO;
    private TextView iKP;
    private View iKQ;
    private String iKz;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gym = new ArrayList();
    private Runnable iKR = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eZd.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.iKM) {
                HotUserRankView.this.iKH.finish();
            } else if (view == HotUserRankView.this.iKN) {
                if (TextUtils.isEmpty(HotUserRankView.this.iKz)) {
                    HotUserRankView.this.iKH.showToast(R.string.load_error_retry);
                    return;
                }
                bf.bsV().b(HotUserRankView.this.iKH.getPageContext(), new String[]{HotUserRankView.this.iKz});
                if (HotUserRankView.this.geW.getVisibility() == 0) {
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
            if (HotUserRankView.this.gym.get(i) != null && ((a) HotUserRankView.this.gym.get(i)).iKU != null && ((a) HotUserRankView.this.gym.get(i)).iKU.cwC() != null) {
                HotUserRankView.this.iKL.b(((a) HotUserRankView.this.gym.get(i)).iKU.cwC().getPageData());
                ar arVar = new ar("c13657");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("resource_id", ((a) HotUserRankView.this.gym.get(i)).title);
                TiebaStatic.log(arVar);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener iKS = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.iKH.getUniqueId())) {
                c cVar = (c) customResponsedMessage.getData();
                if (cVar.iLz != null) {
                    HotUserRankView.this.iKL.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.iKH = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.iKH).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iKM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iKM.setOnClickListener(this.mOnClickListener);
        this.iKN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iKH.getString(R.string.hot_user_rank_rule));
        this.iKN.setOnClickListener(this.mOnClickListener);
        this.geW = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.geW.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.iKI = this.mRootView.findViewById(R.id.tab_cover_left);
        this.iKJ = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eZd = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eZd.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eZd.setViewPagerScroll(0);
        this.iKK = new FragmentAdapter(this.iKH.getSupportFragmentManager());
        this.eZd.setAdapter(this.iKK);
        this.geW.setupWithViewPager(this.eZd);
        this.iKL = new b(this.iKH.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.iKH.registerListener(this.iKS);
        this.iKO = this.mRootView.findViewById(R.id.update_tip);
        this.iKP = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.iKQ = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iKz = str;
        if (!y.isEmpty(list) || j > 0) {
            this.gym.clear();
            if (y.isEmpty(list)) {
                this.geW.setVisibility(8);
                a aVar = new a();
                aVar.iKU = new HotUserRankFragment();
                aVar.iKU.setForumId(j);
                this.gym.add(aVar);
                this.iKK.setData(this.gym);
                this.iKL.xI(1);
                return;
            }
            for (d dVar : list) {
                this.geW.a(this.geW.qL());
                a aVar2 = new a();
                aVar2.iKU = new HotUserRankFragment();
                aVar2.iKU.setCategory(dVar.category);
                aVar2.iKU.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gym.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.iKH.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.iKH.getString(R.string.all_hot_user_rank));
            }
            this.iKK.setData(this.gym);
            this.iKL.xI(2);
            if (i != 0) {
                this.eZd.setCurrentItem(i);
            }
            e.mA().postDelayed(this.iKR, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes2.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gym;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gym = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gym.clear();
            if (!y.isEmpty(list)) {
                this.gym.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gym.get(i);
            if (aVar != null) {
                return aVar.iKU;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gym.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gym.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public HotUserRankFragment iKU;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.iKH.getPageContext(), i);
        this.geW.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.geW.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundColor(this.geW, R.color.CAM_X0207);
        ap.k(this.iKN, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.iKL.onChangeSkinType(i);
        Drawable a2 = SvgManager.bsR().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.iKH, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.iKH, R.dimen.tbds2);
        if (a2 != null) {
            a2.setBounds(0, dimens2, dimens, dimens + dimens2);
            this.iKP.setCompoundDrawables(a2, null, null, null);
        }
        this.iKP.setCompoundDrawablePadding(l.getDimens(this.iKH, R.dimen.tbds9));
        com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.iKH, R.dimen.tbds21)).pe(0).pf(0).bv(this.iKO);
        ap.setBackgroundResource(this.iKI, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.iKJ, R.drawable.hot_user_rank_tab_cover_right);
        this.iKQ.setVisibility(i != 0 ? 8 : 0);
    }

    public void xH(int i) {
        this.iKO.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.iKR);
    }
}
