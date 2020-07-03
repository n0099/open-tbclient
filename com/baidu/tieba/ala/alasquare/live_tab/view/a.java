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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private AppBarLayout WW;
    private boolean fnI;
    private ViewGroup fqM;
    private LinearLayout fqN;
    private FrameLayout fqO;
    private g fqP;
    private ScrollHorizontalTabView fqQ;
    private NestedNoScrollViewPager fqR;
    private C0533a fqS;
    private int fqT;
    private FragmentManager fqU;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private boolean fon = false;
    private int mIndex = -1;
    private CustomMessageListener fop = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.fon = false;
            }
        }
    };
    private CustomMessageListener dGa = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fqS != null) {
                        a.this.fqS.btT();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.mPageContext = tbPageContext;
        this.fnI = z;
        this.mContext = tbPageContext.getPageActivity();
        this.fqU = fragmentManager;
        initView();
    }

    public void init() {
        this.dGa.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.dGa);
        MessageManager.getInstance().registerListener(this.fop);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.WW = (AppBarLayout) this.mRootView.findViewById(R.id.live_tab_appbar_layout);
        this.WW.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i != 0 && i != a.this.fqT) {
                    if (i - a.this.fqT <= -4 && !a.this.fon) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
                        a.this.fon = true;
                    }
                    a.this.fqT = i;
                }
            }
        });
        this.fqM = (ViewGroup) this.mRootView.findViewById(R.id.live_tab_root_container);
        this.fqN = (LinearLayout) this.mRootView.findViewById(R.id.live_tab_base_container);
        this.fqO = (FrameLayout) this.mRootView.findViewById(R.id.super_entrance_container);
        this.fqQ = (ScrollHorizontalTabView) this.mRootView.findViewById(R.id.live_tab_top_tab_layout);
        this.fqP = new g(this.mPageContext);
        this.fqR = (NestedNoScrollViewPager) this.mRootView.findViewById(R.id.live_tab_view_pager);
        jE(com.baidu.tbadk.core.sharedPref.b.aVP().getInt("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.fqP.getView() != null && this.fqP.getView().getParent() == null) {
            this.fqO.addView(this.fqP.getView(), layoutParams);
            this.fqN.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.fqM.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        onChangeSkinType();
    }

    public void jE(boolean z) {
        this.fqR.setOffscreenPageLimit(z ? 2 : 1);
        this.fqS = new C0533a(this.fqU, z);
        this.fqR.setAdapter(this.fqS);
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
        this.fqQ.setViewPager(this.fqR);
        this.fqQ.setScrollTabPageListener(new ScrollHorizontalTabView.ScrollTabPageListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.3
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
        this.fqQ.setData(jG(z));
    }

    public ViewGroup buh() {
        return this.mRootView;
    }

    public void jF(boolean z) {
        this.fqM.setVisibility(z ? 0 : 8);
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.h hVar) {
        com.baidu.tieba.ala.alasquare.live_tab.b.i iVar = new com.baidu.tieba.ala.alasquare.live_tab.b.i();
        iVar.fog = hVar;
        this.fqP.a(iVar);
        this.fqN.setVisibility(0);
    }

    private List<TabData> jG(boolean z) {
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
        this.fqS.loadData();
    }

    public void bui() {
        this.fqS.qe(this.fqR.getCurrentItem());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fqP.onChangeSkinType(this.mPageContext, skinType);
        this.fqQ.onChangeSkinType(skinType);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.fqQ, R.color.cp_bg_line_d);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dGa);
        MessageManager.getInstance().unRegisterListener(this.fop);
    }

    public void setCurrentTab(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (this.fqS != null && i >= this.fqS.getCount()) {
            i = 0;
        }
        if (this.fqR != null) {
            this.fqR.setCurrentItem(i);
        }
    }

    public void bB(boolean z) {
        if (z && this.mIndex != -1) {
            setCurrentTab(this.mIndex);
            this.mIndex = -1;
        }
    }

    public void jH(boolean z) {
        if (this.fqP != null) {
            this.fqP.jH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0533a extends FragmentPagerAdapter {
        private List<LiveTabBaseSubFragment> mFragments;

        public C0533a(FragmentManager fragmentManager, boolean z) {
            super(fragmentManager);
            this.mFragments = new ArrayList();
            this.mFragments.add(LiveTabRecomSubFragment.jA(a.this.fnI));
            this.mFragments.add(LiveTabYanzhiSubFragment.jB(a.this.fnI));
            if (z) {
                this.mFragments.add(LiveTabGameSubFragment.jz(a.this.fnI));
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return qd(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        private LiveTabBaseSubFragment qd(int i) {
            if (i < this.mFragments.size()) {
                return this.mFragments.get(i);
            }
            return null;
        }

        public void loadData() {
            if (!w.isEmpty(this.mFragments)) {
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

        public void btT() {
            if (!w.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        LiveTabBaseSubFragment liveTabBaseSubFragment = this.mFragments.get(i2);
                        if (liveTabBaseSubFragment != null) {
                            liveTabBaseSubFragment.btT();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void qe(int i) {
            if (i >= 0 && i < this.mFragments.size()) {
                this.mFragments.get(i).IB();
            }
        }
    }
}
