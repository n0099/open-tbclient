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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private AppBarLayout CD;
    private boolean elw;
    private ViewGroup eoA;
    private LinearLayout eoB;
    private FrameLayout eoC;
    private g eoD;
    private ScrollHorizontalTabView eoE;
    private NestedNoScrollViewPager eoF;
    private C0424a eoG;
    private int eoH;
    private FragmentManager eoI;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean elZ = false;
    private CustomMessageListener emc = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.elZ = false;
            }
        }
    };
    private CustomMessageListener cMk = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eoG != null) {
                        a.this.eoG.bcA();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.elw = z;
        this.mContext = tbPageContext.getPageActivity();
        this.eoI = fragmentManager;
        initView();
    }

    public void init() {
        this.cMk.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.cMk);
        MessageManager.getInstance().registerListener(this.emc);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.CD.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.eoH) {
                    if (i - a.this.eoH <= -4 && !a.this.elZ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.elZ = true;
                    }
                    a.this.eoH = i;
                }
            }
        });
        this.eoA = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.eoB = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.eoC = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.eoE = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.eoD = new g(this.mPageContext);
        this.eoF = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        hY((com.baidu.tbadk.core.sharedPref.b.aFB().getInt("chushou_game_tab", 1) == 1) && TbadkCoreApplication.isChushouInit);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.eoD.getView() != null && this.eoD.getView().getParent() == null) {
            this.eoC.addView(this.eoD.getView(), layoutParams);
            this.eoB.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.eoA.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void hY(boolean z) {
        this.eoF.setOffscreenPageLimit(z ? 2 : 1);
        this.eoG = new C0424a(this.eoI, z);
        this.eoF.setAdapter(this.eoG);
        this.eoF.setCurrentItem(0);
        this.eoE.setViewPager(this.eoF);
        this.eoE.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
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
        this.eoE.setData(ia(z));
    }

    public ViewGroup bcP() {
        return this.mRootView;
    }

    public void hZ(boolean z) {
        this.eoA.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.elS = hVar;
        this.eoD.a(iVar);
        this.eoB.setVisibility(0);
    }

    private List<TabData> ia(boolean z) {
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
        this.eoG.loadData();
    }

    public void bcQ() {
        this.eoG.oH(this.eoF.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eoD.onChangeSkinType(this.mPageContext, skinType);
        this.eoE.onChangeSkinType(skinType);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.eoE, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.cMk);
        MessageManager.getInstance().unRegisterListener(this.emc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0424a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0424a(FragmentManager fragmentManager, boolean z) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.hU(a.this.elw));
            this.mFragments.add(LiveTabYanzhiSubFragment.hV(a.this.elw));
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.hT(a.this.elw));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return oG(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment oG(int i) {
            if (i < this.mFragments.size()) {
                return this.mFragments.get(i);
            }
            return null;
        }

        public void loadData() {
            if (!v.isEmpty(this.mFragments)) {
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

        public void bcA() {
            if (!v.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bcA();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void oH(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).AA();
            }
        }
    }
}
