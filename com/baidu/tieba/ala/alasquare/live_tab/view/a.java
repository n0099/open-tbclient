package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
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
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private AppBarLayout abf;
    private boolean gCv;
    private ViewGroup gFF;
    private LinearLayout gFG;
    private FrameLayout gFH;
    private d gFI;
    private ScrollHorizontalTabView gFJ;
    private NestedNoScrollViewPager gFK;
    private C0623a gFL;
    private int gFM;
    private FragmentManager gFN;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean gDb = false;
    private int mIndex = -1;
    private CustomMessageListener gDd = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.gDb = false;
            }
        }
    };
    private CustomMessageListener eMc = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gFL != null) {
                        a.this.gFL.bRN();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.gCv = z;
        this.mContext = tbPageContext.getPageActivity();
        this.gFN = fragmentManager;
        initView();
    }

    public void init() {
        this.eMc.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.eMc);
        MessageManager.getInstance().registerListener(this.gDd);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.abf = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.abf.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.gFM) {
                    if (i - a.this.gFM <= -4 && !a.this.gDb) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.gDb = true;
                    }
                    a.this.gFM = i;
                }
            }
        });
        this.gFF = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.gFG = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.gFH = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.gFJ = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.gFI = new d(this.mPageContext);
        this.gFK = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        mD(com.baidu.tbadk.core.sharedPref.b.brR().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.gFI.getView() != null && this.gFI.getView().getParent() == null) {
            this.gFH.addView(this.gFI.getView(), layoutParams);
            this.gFG.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.gFF.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void mD(boolean z) {
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_show_ala_friend_tab", 0) == 1;
        int i = z ? 2 : 1;
        if (z2) {
            i++;
        }
        this.gFK.setOffscreenPageLimit(i);
        this.gFL = new C0623a(this.gFN, z, z2);
        this.gFK.setAdapter(this.gFL);
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
        this.gFJ.setViewPager(this.gFK);
        this.gFJ.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
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
        this.gFJ.setData(K(z, z2));
    }

    public ViewGroup bSb() {
        return this.mRootView;
    }

    public void mE(boolean z) {
        this.gFF.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        i iVar = new i();
        iVar.gCT = hVar;
        this.gFI.a(iVar);
        this.gFG.setVisibility(0);
    }

    private List<TabData> K(boolean z, boolean z2) {
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
        this.gFL.loadData();
    }

    public void bSc() {
        this.gFL.tN(this.gFK.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gFI.onChangeSkinType(this.mPageContext, skinType);
        this.gFJ.onChangeSkinType(skinType);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gFJ, R.color.CAM_X0201);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eMc);
        MessageManager.getInstance().unRegisterListener(this.gDd);
    }

    public void setCurrentTab(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (this.gFL != null && i >= this.gFL.getCount()) {
            i = 0;
        }
        if (this.gFK != null) {
            this.gFK.setCurrentItem(i);
        }
    }

    public void cb(boolean z) {
        if (z && this.mIndex != -1) {
            setCurrentTab(this.mIndex);
            this.mIndex = -1;
        }
    }

    public void mF(boolean z) {
        if (this.gFI != null) {
            this.gFI.mF(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0623a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0623a(FragmentManager fragmentManager, boolean z, boolean z2) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.mz(a.this.gCv));
            this.mFragments.add(LiveTabYanzhiSubFragment.mA(a.this.gCv));
            if (z2) {
                this.mFragments.add(LiveTabFriendSubFragment.mx(a.this.gCv));
            }
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.my(a.this.gCv));
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return tM(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment tM(int i) {
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

        public void bRN() {
            if (!y.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bRN();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void tN(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).Uw();
            }
        }
    }
}
