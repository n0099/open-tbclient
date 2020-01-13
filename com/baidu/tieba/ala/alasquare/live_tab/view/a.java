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
/* loaded from: classes2.dex */
public class a {
    private AppBarLayout Ck;
    private boolean ehq;
    private ViewGroup ekp;
    private LinearLayout ekq;
    private FrameLayout ekr;
    private f eks;
    private ScrollHorizontalTabView ekt;
    private NestedNoScrollViewPager eku;
    private C0413a ekv;
    private int ekw;
    private FragmentManager ekx;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean ehU = false;
    private CustomMessageListener ehV = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.ehU = false;
            }
        }
    };
    private CustomMessageListener cIh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ekv != null) {
                        a.this.ekv.bal();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.ehq = z;
        this.mContext = tbPageContext.getPageActivity();
        this.ekx = fragmentManager;
        initView();
    }

    public void init() {
        this.cIh.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.cIh);
        MessageManager.getInstance().registerListener(this.ehV);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.Ck = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.Ck.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.ekw) {
                    if (i - a.this.ekw <= -4 && !a.this.ehU) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.ehU = true;
                    }
                    a.this.ekw = i;
                }
            }
        });
        this.ekp = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.ekq = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.ekr = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.ekt = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.eks = new f(this.mPageContext);
        this.eku = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        hR(com.baidu.tbadk.core.sharedPref.b.aDr().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.eks.getView() != null && this.eks.getView().getParent() == null) {
            this.ekr.addView(this.eks.getView(), layoutParams);
            this.ekq.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.ekp.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void hR(boolean z) {
        this.eku.setOffscreenPageLimit(z ? 2 : 1);
        this.ekv = new C0413a(this.ekx, z);
        this.eku.setAdapter(this.ekv);
        this.eku.setCurrentItem(0);
        this.ekt.setViewPager(this.eku);
        this.ekt.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
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
        this.ekt.setData(hT(z));
    }

    public ViewGroup baA() {
        return this.mRootView;
    }

    public void hS(boolean z) {
        this.ekp.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.ehN = hVar;
        this.eks.a(iVar);
        this.ekq.setVisibility(0);
    }

    private List<TabData> hT(boolean z) {
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
        this.ekv.loadData();
    }

    public void baB() {
        this.ekv.oq(this.eku.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eks.onChangeSkinType(this.mPageContext, skinType);
        this.ekt.onChangeSkinType(skinType);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.ekt, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.cIh);
        MessageManager.getInstance().unRegisterListener(this.ehV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0413a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0413a(FragmentManager fragmentManager, boolean z) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.hN(a.this.ehq));
            this.mFragments.add(LiveTabYanzhiSubFragment.hO(a.this.ehq));
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.hM(a.this.ehq));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return op(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment op(int i) {
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

        public void bal() {
            if (!v.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.bal();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void oq(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).yj();
            }
        }
    }
}
