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
/* loaded from: classes9.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a gZo;
    private ImageView hfJ;
    private TbImageView hfK;
    private PagerSlidingTabStrip hfL;
    private LinearLayout hfM;
    private View hfN;
    private int hfO;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hfO = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hfO = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hfO = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.hfJ = (ImageView) findViewById(R.id.home_page_search_icon);
        this.hfJ.setClickable(false);
        this.hfL = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.hfL.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.hfL.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.hfM = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.hfN = findViewById(R.id.home_page_shadow);
        this.hfK = (TbImageView) findViewById(R.id.home_page_get_money);
        this.hfK.setClickable(false);
        this.hfJ.setOnClickListener(this);
        this.hfK.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && MissionEntranceSwitch.isOn()) {
            this.hfK.setVisibility(0);
            this.rightMargin = this.tbds264;
            mO(true);
            mN(true);
            bNy();
            return;
        }
        this.rightMargin = this.tbds150;
        this.hfK.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.hfK;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.gZo = aVar;
    }

    private void bNy() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.hfK.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.hfK.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.gr().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.hfK.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.hfK.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.hfK.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.hfK.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.hfJ) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).X("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.hfK) {
            Object tag = this.hfK.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bNz();
                    if (this.gZo != null) {
                        this.gZo.Cf(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hfL.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hfL != null) {
            this.hfL.setShowConcernRedTip(z);
        }
    }

    public boolean bNF() {
        if (this.hfL != null) {
            return this.hfL.bNF();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.hfL.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.hfL.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.hfL.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.aGC().a(this.hfJ, R.drawable.icon_pure_topbar_search44_svg, this.hfO, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hfL.onChangeSkinType();
            am.setBackgroundResource(this.hfN, R.drawable.home_page_tab_shadow);
        }
    }

    public View vh(int i) {
        return this.hfL.vh(i);
    }

    public void onResume() {
        SvgManager.aGC().a(this.hfJ, R.drawable.icon_pure_topbar_search44_svg, this.hfO, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.hfL.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.hfL.setOnTabItemClickListener(aVar);
    }

    public void ay(float f) {
        if (f <= 1.0f && f >= 0.0f && this.hfJ != null && this.hfM != null && this.hfL != null && this.hfM.getAlpha() != f) {
            this.hfM.setAlpha(f);
            if (f == 1.0f) {
                this.hfJ.setAlpha(1.0f);
                this.hfJ.setClickable(true);
                if (this.hfK != null) {
                    this.hfK.setAlpha(1.0f);
                    this.hfK.setClickable(true);
                }
                mO(true);
                mN(true);
                return;
            }
            this.hfJ.setAlpha(0.0f);
            this.hfJ.setClickable(false);
            if (this.hfK != null) {
                this.hfK.setAlpha(0.0f);
                this.hfK.setClickable(false);
            }
            mO(false);
            mN(false);
        }
    }

    private void mN(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfN.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hfN.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hfN.setLayoutParams(layoutParams);
            }
        }
    }

    private void mO(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfL.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hfL.setLayoutParams(layoutParams);
                    this.hfL.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View vh = HomeTabBarView.this.hfL.vh(HomeTabBarView.this.hfL.getCurrentTabIndex());
                            if (vh != null && vh.getRight() > HomeTabBarView.this.hfL.getRight()) {
                                HomeTabBarView.this.hfL.scrollTo(vh.getWidth() + HomeTabBarView.this.hfL.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hfL.setLayoutParams(layoutParams);
            }
        }
    }

    private void bNz() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 2);
        anVar.X("obj_locate", 1);
        anVar.X(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bNS() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 1);
        anVar.X("obj_locate", 1);
        anVar.X(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
