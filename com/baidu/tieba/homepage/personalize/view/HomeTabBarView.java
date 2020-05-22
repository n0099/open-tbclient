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
/* loaded from: classes9.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a hZd;
    private ImageView ifV;
    private TbImageView ifW;
    private PagerSlidingTabStrip ifX;
    private LinearLayout ifY;
    private View ifZ;
    private int iga;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iga = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iga = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iga = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.ifV = (ImageView) findViewById(R.id.home_page_search_icon);
        this.ifV.setClickable(false);
        this.ifX = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.ifX.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.ifX.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.ifY = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.ifZ = findViewById(R.id.home_page_shadow);
        this.ifW = (TbImageView) findViewById(R.id.home_page_get_money);
        this.ifW.setClickable(false);
        this.ifV.setOnClickListener(this);
        this.ifW.setOnClickListener(this);
        setOnClickListener(this);
        if (com.baidu.tbadk.a.d.aMs()) {
            this.ifV.setVisibility(8);
        } else {
            ag(0.0f);
        }
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && MissionEntranceSwitch.isOn()) {
            this.ifW.setVisibility(0);
            this.rightMargin = this.tbds264;
            ou(true);
            ot(true);
            ceI();
            return;
        }
        this.rightMargin = this.tbds150;
        this.ifW.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.ifW;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.hZd = aVar;
    }

    private void ceI() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.ifW.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.ifW.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.kX().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.ifW.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.ifW.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.ifW.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.ifW.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.ifV) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).ag("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.ifW) {
            Object tag = this.ifW.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    ceJ();
                    if (this.hZd != null) {
                        this.hZd.FA(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ifX.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ifX != null) {
            this.ifX.setShowConcernRedTip(z);
        }
    }

    public boolean ceP() {
        if (this.ifX != null) {
            return this.ifX.ceP();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ifX.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.ifX.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.ifX.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.aUV().a(this.ifV, R.drawable.icon_pure_topbar_search44_svg, this.iga, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.ifX.onChangeSkinType();
            am.setBackgroundResource(this.ifZ, R.drawable.home_page_tab_shadow);
        }
    }

    public View ws(int i) {
        return this.ifX.ws(i);
    }

    public void onResume() {
        SvgManager.aUV().a(this.ifV, R.drawable.icon_pure_topbar_search44_svg, this.iga, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.ifX.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.ifX.setOnTabItemClickListener(aVar);
    }

    public void ag(float f) {
        if (f <= 1.0f && f >= 0.0f && this.ifV != null && this.ifY != null && this.ifX != null && this.ifY.getAlpha() != f) {
            this.ifY.setAlpha(f);
            if (f == 1.0f) {
                this.ifV.setAlpha(1.0f);
                this.ifV.setClickable(true);
                if (this.ifW != null) {
                    this.ifW.setAlpha(1.0f);
                    this.ifW.setClickable(true);
                }
                ou(true);
                ot(true);
                return;
            }
            this.ifV.setAlpha(0.0f);
            this.ifV.setClickable(false);
            if (this.ifW != null) {
                this.ifW.setAlpha(0.0f);
                this.ifW.setClickable(false);
            }
            ou(false);
            ot(false);
        }
    }

    private void ot(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifZ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.ifZ.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.ifZ.setLayoutParams(layoutParams);
            }
        }
    }

    private void ou(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.ifX.setLayoutParams(layoutParams);
                    this.ifX.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View ws = HomeTabBarView.this.ifX.ws(HomeTabBarView.this.ifX.getCurrentTabIndex());
                            if (ws != null && ws.getRight() > HomeTabBarView.this.ifX.getRight()) {
                                HomeTabBarView.this.ifX.scrollTo(ws.getWidth() + HomeTabBarView.this.ifX.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.ifX.setLayoutParams(layoutParams);
            }
        }
    }

    private void ceJ() {
        an anVar = new an("c13422");
        anVar.ag("obj_type", 2);
        anVar.ag("obj_locate", 1);
        anVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void cfc() {
        an anVar = new an("c13422");
        anVar.ag("obj_type", 1);
        anVar.ag("obj_locate", 1);
        anVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
