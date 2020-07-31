package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.data.TabData;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private AppBarLayout WP;
    private boolean fsR;
    private ViewGroup fvW;
    private LinearLayout fvX;
    private FrameLayout fvY;
    private g fvZ;
    private ScrollHorizontalTabView fwa;
    private NestedNoScrollViewPager fwb;
    private C0544a fwc;
    private int fwd;
    private FragmentManager fwe;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean fty = false;
    private int mIndex = -1;
    private CustomMessageListener ftA = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.fty = false;
            }
        }
    };
    private CustomMessageListener dMl = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fwc != null) {
                        a.this.fwc.bxd();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.fsR = z;
        this.mContext = tbPageContext.getPageActivity();
        this.fwe = fragmentManager;
        initView();
    }

    public void init() {
        this.dMl.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.dMl);
        MessageManager.getInstance().registerListener(this.ftA);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.WP = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.WP.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.fwd) {
                    if (i - a.this.fwd <= -4 && !a.this.fty) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.fty = true;
                    }
                    a.this.fwd = i;
                }
            }
        });
        this.fvW = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.fvX = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.fvY = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.fwa = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.fvZ = new g(this.mPageContext);
        this.fwb = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        ki(com.baidu.tbadk.core.sharedPref.b.aZP().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.fvZ.getView() != null && this.fvZ.getView().getParent() == null) {
            this.fvY.addView(this.fvZ.getView(), layoutParams);
            this.fvX.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.fvW.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void ki(boolean z) {
        this.fwb.setOffscreenPageLimit(z ? 2 : 1);
        this.fwc = new C0544a(this.fwe, z);
        this.fwb.setAdapter(this.fwc);
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
            int intExtra = this.mPageContext.getPageActivity().getIntent().getIntExtra("locate_type", 0);
            if (intExtra == 17) {
                this.mIndex = 0;
            } else if (intExtra == 19) {
                this.mIndex = 2;
            } else if (intExtra == 18) {
                this.mIndex = 1;
            }
        }
        this.fwa.setViewPager(this.fwb);
        this.fwa.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i, TabData tabData) {
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i, float f, int i2) {
            }
        });
        this.fwa.setData(kk(z));
    }

    public ViewGroup bxr() {
        return this.mRootView;
    }

    public void kj(boolean z) {
        this.fvW.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.ftq = hVar;
        this.fvZ.a(iVar);
        this.fvX.setVisibility(0);
    }

    private List<TabData> kk(boolean z) {
        ArrayList arrayList = new ArrayList();
        TabData tabData = new TabData();
        tabData.tabId = 100;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        arrayList.add(tabData);
        TabData tabData2 = new TabData();
        tabData2.tabId = 200;
        tabData2.tabName = this.mContext.getResources().getString(R.string.special_yanzhi_tab_title);
        arrayList.add(tabData2);
        if (z) {
            TabData tabData3 = new TabData();
            tabData3.tabId = 300;
            tabData3.tabName = this.mContext.getResources().getString(R.string.special_game_tab_title);
            arrayList.add(tabData3);
        }
        return arrayList;
    }

    public void loadData() {
        this.fwc.loadData();
    }

    public void bxs() {
        this.fwc.qt(this.fwb.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fvZ.onChangeSkinType(this.mPageContext, skinType);
        this.fwa.onChangeSkinType(skinType);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.fwa, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dMl);
        MessageManager.getInstance().unRegisterListener(this.ftA);
    }

    public void setCurrentTab(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (this.fwc != null && i >= this.fwc.getCount()) {
            i = 0;
        }
        if (this.fwb != null) {
            this.fwb.setCurrentItem(i);
        }
    }

    public void bE(boolean z) {
        if (z && this.mIndex != -1) {
            setCurrentTab(this.mIndex);
            this.mIndex = -1;
        }
    }

    public void kl(boolean z) {
        if (this.fvZ != null) {
            this.fvZ.kl(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0544a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0544a(FragmentManager fragmentManager, boolean z) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.ke(a.this.fsR));
            this.mFragments.add(LiveTabYanzhiSubFragment.kf(a.this.fsR));
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.kd(a.this.fsR));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return qs(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment qs(int i) {
            if (i < this.mFragments.size()) {
                return this.mFragments.get(i);
            }
            return null;
        }

        public void loadData() {
            if (!x.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.loadData();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void bxd() {
            if (!x.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bxd();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void qt(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).IH();
            }
        }
    }
}
