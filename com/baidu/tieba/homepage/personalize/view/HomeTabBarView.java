package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes7.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a gXl;
    private ImageView hdH;
    private TbImageView hdI;
    private PagerSlidingTabStrip hdJ;
    private LinearLayout hdK;
    private View hdL;
    private int hdM;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hdM = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hdM = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hdM = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.hdH = (ImageView) findViewById(R.id.home_page_search_icon);
        this.hdH.setClickable(false);
        this.hdJ = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.hdJ.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.hdJ.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.hdK = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.hdL = findViewById(R.id.home_page_shadow);
        this.hdI = (TbImageView) findViewById(R.id.home_page_get_money);
        this.hdI.setClickable(false);
        this.hdH.setOnClickListener(this);
        this.hdI.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && MissionEntranceSwitch.isOn()) {
            this.hdI.setVisibility(0);
            this.rightMargin = this.tbds264;
            mM(true);
            mL(true);
            bLT();
            return;
        }
        this.rightMargin = this.tbds150;
        this.hdI.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.hdI;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.gXl = aVar;
    }

    private void bLT() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.hdI.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.hdI.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.gr().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.hdI.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.hdI.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.hdI.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.hdI.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hdH) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).Z("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.hdI) {
            Object tag = this.hdI.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bLU();
                    if (this.gXl != null) {
                        this.gXl.BP(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hdJ.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hdJ != null) {
            this.hdJ.setShowConcernRedTip(z);
        }
    }

    public boolean bMa() {
        if (this.hdJ != null) {
            return this.hdJ.bMa();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.hdJ.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.hdJ.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.hdJ.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.aEp().a(this.hdH, R.drawable.icon_pure_topbar_search44_svg, this.hdM, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hdJ.onChangeSkinType();
            am.setBackgroundResource(this.hdL, R.drawable.home_page_tab_shadow);
        }
    }

    public void bMb() {
        this.hdM = R.color.cp_cont_a;
        if (this.hdJ != null) {
            this.hdJ.bMb();
        }
        if (this.hdL != null) {
            this.hdL.setVisibility(8);
        }
    }

    public View vb(int i) {
        return this.hdJ.vb(i);
    }

    public void onResume() {
        SvgManager.aEp().a(this.hdH, R.drawable.icon_pure_topbar_search44_svg, this.hdM, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.hdJ.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.hdJ.setOnTabItemClickListener(aVar);
    }

    public void az(float f) {
        if (f <= 1.0f && f >= 0.0f && this.hdH != null && this.hdK != null && this.hdJ != null && this.hdK.getAlpha() != f) {
            this.hdK.setAlpha(f);
            if (f == 1.0f) {
                this.hdH.setAlpha(1.0f);
                this.hdH.setClickable(true);
                if (this.hdI != null) {
                    this.hdI.setAlpha(1.0f);
                    this.hdI.setClickable(true);
                }
                mM(true);
                mL(true);
                return;
            }
            this.hdH.setAlpha(0.0f);
            this.hdH.setClickable(false);
            if (this.hdI != null) {
                this.hdI.setAlpha(0.0f);
                this.hdI.setClickable(false);
            }
            mM(false);
            mL(false);
        }
    }

    private void mL(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hdL.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hdL.setLayoutParams(layoutParams);
            }
        }
    }

    private void mM(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdJ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hdJ.setLayoutParams(layoutParams);
                    this.hdJ.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View vb = HomeTabBarView.this.hdJ.vb(HomeTabBarView.this.hdJ.getCurrentTabIndex());
                            if (vb != null && vb.getRight() > HomeTabBarView.this.hdJ.getRight()) {
                                HomeTabBarView.this.hdJ.scrollTo(vb.getWidth() + HomeTabBarView.this.hdJ.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hdJ.setLayoutParams(layoutParams);
            }
        }
    }

    private void bLU() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 2);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bMo() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 1);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
