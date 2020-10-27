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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private AppBarLayout Yh;
    private boolean gdO;
    private ViewGroup ggZ;
    private LinearLayout gha;
    private FrameLayout ghb;
    private g ghc;
    private ScrollHorizontalTabView ghd;
    private NestedNoScrollViewPager ghe;
    private C0619a ghf;
    private int ghg;
    private FragmentManager ghh;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean gev = false;
    private int mIndex = -1;
    private CustomMessageListener gex = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.gev = false;
            }
        }
    };
    private CustomMessageListener esj = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ghf != null) {
                        a.this.ghf.bMG();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.gdO = z;
        this.mContext = tbPageContext.getPageActivity();
        this.ghh = fragmentManager;
        initView();
    }

    public void init() {
        this.esj.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.esj);
        MessageManager.getInstance().registerListener(this.gex);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.Yh.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.ghg) {
                    if (i - a.this.ghg <= -4 && !a.this.gev) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.gev = true;
                    }
                    a.this.ghg = i;
                }
            }
        });
        this.ggZ = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.gha = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.ghb = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.ghd = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.ghc = new g(this.mPageContext);
        this.ghe = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        lB(com.baidu.tbadk.core.sharedPref.b.bnH().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.ghc.getView() != null && this.ghc.getView().getParent() == null) {
            this.ghb.addView(this.ghc.getView(), layoutParams);
            this.gha.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.ggZ.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void lB(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_show_ala_friend_tab", 0) == 1;
        int i = z ? 2 : 1;
        if (z2) {
            i++;
        }
        this.ghe.setOffscreenPageLimit(i);
        this.ghf = new C0619a(this.ghh, z, z2);
        this.ghe.setAdapter(this.ghf);
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
        this.ghd.setViewPager(this.ghe);
        this.ghd.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public boolean onPrePageSelect(int i2, TabData tabData) {
                return true;
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageSelected(int i2, TabData tabData) {
            }

            @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
            public void onPageScrolled(int i2, float f, int i3) {
            }
        });
        this.ghd.setData(I(z, z2));
    }

    public ViewGroup bMV() {
        return this.mRootView;
    }

    public void lC(boolean z) {
        this.ggZ.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.gem = hVar;
        this.ghc.a(iVar);
        this.gha.setVisibility(0);
    }

    private List<TabData> I(boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        TabData tabData = new TabData();
        tabData.tabId = 100;
        tabData.tabName = this.mContext.getResources().getString(R.string.special_recommend_tab_title);
        arrayList.add(tabData);
        TabData tabData2 = new TabData();
        tabData2.tabId = 200;
        tabData2.tabName = this.mContext.getResources().getString(R.string.special_yanzhi_tab_title);
        arrayList.add(tabData2);
        if (z2) {
            TabData tabData3 = new TabData();
            tabData3.tabId = 400;
            tabData3.tabName = this.mContext.getResources().getString(R.string.special_friend_tab_title);
            arrayList.add(tabData3);
        }
        if (z) {
            TabData tabData4 = new TabData();
            tabData4.tabId = 300;
            tabData4.tabName = this.mContext.getResources().getString(R.string.special_game_tab_title);
            arrayList.add(tabData4);
        }
        return arrayList;
    }

    public void loadData() {
        this.ghf.loadData();
    }

    public void bMW() {
        this.ghf.tO(this.ghe.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ghc.onChangeSkinType(this.mPageContext, skinType);
        this.ghd.onChangeSkinType(skinType);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ghd, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.esj);
        MessageManager.getInstance().unRegisterListener(this.gex);
    }

    public void setCurrentTab(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (this.ghf != null && i >= this.ghf.getCount()) {
            i = 0;
        }
        if (this.ghe != null) {
            this.ghe.setCurrentItem(i);
        }
    }

    public void bP(boolean z) {
        if (z && this.mIndex != -1) {
            setCurrentTab(this.mIndex);
            this.mIndex = -1;
        }
    }

    public void lD(boolean z) {
        if (this.ghc != null) {
            this.ghc.lD(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0619a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0619a(FragmentManager fragmentManager, boolean z, boolean z2) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.lx(a.this.gdO));
            this.mFragments.add(LiveTabYanzhiSubFragment.ly(a.this.gdO));
            if (z2) {
                this.mFragments.add(LiveTabFriendSubFragment.lv(a.this.gdO));
            }
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.lw(a.this.gdO));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return tN(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment tN(int i) {
            if (i < this.mFragments.size()) {
                return this.mFragments.get(i);
            }
            return null;
        }

        public void loadData() {
            if (!y.isEmpty(this.mFragments)) {
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

        public void bMG() {
            if (!y.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bMG();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void tO(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).Rd();
            }
        }
    }
}
