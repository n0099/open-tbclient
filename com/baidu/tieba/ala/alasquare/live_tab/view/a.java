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
    private boolean gjE;
    private ViewGroup gmN;
    private LinearLayout gmO;
    private FrameLayout gmP;
    private g gmQ;
    private ScrollHorizontalTabView gmR;
    private NestedNoScrollViewPager gmS;
    private C0631a gmT;
    private int gmU;
    private FragmentManager gmV;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean gkk = false;
    private int mIndex = -1;
    private CustomMessageListener gkm = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.gkk = false;
            }
        }
    };
    private CustomMessageListener eyc = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gmT != null) {
                        a.this.gmT.bPg();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.gjE = z;
        this.mContext = tbPageContext.getPageActivity();
        this.gmV = fragmentManager;
        initView();
    }

    public void init() {
        this.eyc.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.eyc);
        MessageManager.getInstance().registerListener(this.gkm);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.Yh.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.gmU) {
                    if (i - a.this.gmU <= -4 && !a.this.gkk) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.gkk = true;
                    }
                    a.this.gmU = i;
                }
            }
        });
        this.gmN = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.gmO = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.gmP = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.gmR = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.gmQ = new g(this.mPageContext);
        this.gmS = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        lK(com.baidu.tbadk.core.sharedPref.b.bqh().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.gmQ.getView() != null && this.gmQ.getView().getParent() == null) {
            this.gmP.addView(this.gmQ.getView(), layoutParams);
            this.gmO.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.gmN.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void lK(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_show_ala_friend_tab", 0) == 1;
        int i = z ? 2 : 1;
        if (z2) {
            i++;
        }
        this.gmS.setOffscreenPageLimit(i);
        this.gmT = new C0631a(this.gmV, z, z2);
        this.gmS.setAdapter(this.gmT);
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
        this.gmR.setViewPager(this.gmS);
        this.gmR.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
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
        this.gmR.setData(I(z, z2));
    }

    public ViewGroup bPv() {
        return this.mRootView;
    }

    public void lL(boolean z) {
        this.gmN.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.gkc = hVar;
        this.gmQ.a(iVar);
        this.gmO.setVisibility(0);
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
        this.gmT.loadData();
    }

    public void bPw() {
        this.gmT.tY(this.gmS.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gmQ.onChangeSkinType(this.mPageContext, skinType);
        this.gmR.onChangeSkinType(skinType);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.gmR, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eyc);
        MessageManager.getInstance().unRegisterListener(this.gkm);
    }

    public void setCurrentTab(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (this.gmT != null && i >= this.gmT.getCount()) {
            i = 0;
        }
        if (this.gmS != null) {
            this.gmS.setCurrentItem(i);
        }
    }

    public void bQ(boolean z) {
        if (z && this.mIndex != -1) {
            setCurrentTab(this.mIndex);
            this.mIndex = -1;
        }
    }

    public void lM(boolean z) {
        if (this.gmQ != null) {
            this.gmQ.lM(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0631a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0631a(FragmentManager fragmentManager, boolean z, boolean z2) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.lG(a.this.gjE));
            this.mFragments.add(LiveTabYanzhiSubFragment.lH(a.this.gjE));
            if (z2) {
                this.mFragments.add(LiveTabFriendSubFragment.lE(a.this.gjE));
            }
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.lF(a.this.gjE));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return tX(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment tX(int i) {
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

        public void bPg() {
            if (!y.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bPg();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void tY(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).TL();
            }
        }
    }
}
