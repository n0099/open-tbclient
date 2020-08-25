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
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private AppBarLayout Xv;
    private boolean fEl;
    private ViewGroup fHo;
    private LinearLayout fHp;
    private FrameLayout fHq;
    private g fHr;
    private ScrollHorizontalTabView fHs;
    private NestedNoScrollViewPager fHt;
    private C0590a fHu;
    private int fHv;
    private FragmentManager fHw;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean fER = false;
    private int mIndex = -1;
    private CustomMessageListener fET = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.fER = false;
            }
        }
    };
    private CustomMessageListener dVu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fHu != null) {
                        a.this.fHu.bGc();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.fEl = z;
        this.mContext = tbPageContext.getPageActivity();
        this.fHw = fragmentManager;
        initView();
    }

    public void init() {
        this.dVu.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.dVu);
        MessageManager.getInstance().registerListener(this.fET);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.Xv = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.Xv.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.fHv) {
                    if (i - a.this.fHv <= -4 && !a.this.fER) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.fER = true;
                    }
                    a.this.fHv = i;
                }
            }
        });
        this.fHo = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.fHp = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.fHq = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.fHs = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.fHr = new g(this.mPageContext);
        this.fHt = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        kG(com.baidu.tbadk.core.sharedPref.b.bik().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.fHr.getView() != null && this.fHr.getView().getParent() == null) {
            this.fHq.addView(this.fHr.getView(), layoutParams);
            this.fHp.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.fHo.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void kG(boolean z) {
        this.fHt.setOffscreenPageLimit(z ? 2 : 1);
        this.fHu = new C0590a(this.fHw, z);
        this.fHt.setAdapter(this.fHu);
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
        this.fHs.setViewPager(this.fHt);
        this.fHs.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
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
        this.fHs.setData(kI(z));
    }

    public ViewGroup bGq() {
        return this.mRootView;
    }

    public void kH(boolean z) {
        this.fHo.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.fEJ = hVar;
        this.fHr.a(iVar);
        this.fHp.setVisibility(0);
    }

    private List<TabData> kI(boolean z) {
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
        this.fHu.loadData();
    }

    public void bGr() {
        this.fHu.sF(this.fHt.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fHr.onChangeSkinType(this.mPageContext, skinType);
        this.fHs.onChangeSkinType(skinType);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fHs, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dVu);
        MessageManager.getInstance().unRegisterListener(this.fET);
    }

    public void setCurrentTab(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (this.fHu != null && i >= this.fHu.getCount()) {
            i = 0;
        }
        if (this.fHt != null) {
            this.fHt.setCurrentItem(i);
        }
    }

    public void bJ(boolean z) {
        if (z && this.mIndex != -1) {
            setCurrentTab(this.mIndex);
            this.mIndex = -1;
        }
    }

    public void kJ(boolean z) {
        if (this.fHr != null) {
            this.fHr.kJ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0590a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0590a(FragmentManager fragmentManager, boolean z) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.kC(a.this.fEl));
            this.mFragments.add(LiveTabYanzhiSubFragment.kD(a.this.fEl));
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.kB(a.this.fEl));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return sE(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment sE(int i) {
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

        public void bGc() {
            if (!y.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bGc();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void sF(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).OA();
            }
        }
    }
}
