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
    private NestedScrollHeader.a haI;
    private int hhA;
    private ImageView hhv;
    private TbImageView hhw;
    private PagerSlidingTabStrip hhx;
    private LinearLayout hhy;
    private View hhz;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hhA = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hhA = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hhA = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.hhv = (ImageView) findViewById(R.id.home_page_search_icon);
        this.hhv.setClickable(false);
        this.hhx = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.hhx.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.hhx.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.hhy = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.hhz = findViewById(R.id.home_page_shadow);
        this.hhw = (TbImageView) findViewById(R.id.home_page_get_money);
        this.hhw.setClickable(false);
        this.hhv.setOnClickListener(this);
        this.hhw.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && MissionEntranceSwitch.isOn()) {
            this.hhw.setVisibility(0);
            this.rightMargin = this.tbds264;
            mU(true);
            mT(true);
            bNN();
            return;
        }
        this.rightMargin = this.tbds150;
        this.hhw.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.hhw;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.haI = aVar;
    }

    private void bNN() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.hhw.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.hhw.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.gr().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.hhw.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.hhw.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.hhw.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.hhw.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.hhv) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).X("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.hhw) {
            Object tag = this.hhw.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bNO();
                    if (this.haI != null) {
                        this.haI.Cf(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hhx.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hhx != null) {
            this.hhx.setShowConcernRedTip(z);
        }
    }

    public boolean bNU() {
        if (this.hhx != null) {
            return this.hhx.bNU();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.hhx.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.hhx.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.hhx.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.aGG().a(this.hhv, R.drawable.icon_pure_topbar_search44_svg, this.hhA, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hhx.onChangeSkinType();
            am.setBackgroundResource(this.hhz, R.drawable.home_page_tab_shadow);
        }
    }

    public View vo(int i) {
        return this.hhx.vo(i);
    }

    public void onResume() {
        SvgManager.aGG().a(this.hhv, R.drawable.icon_pure_topbar_search44_svg, this.hhA, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.hhx.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.hhx.setOnTabItemClickListener(aVar);
    }

    public void ay(float f) {
        if (f <= 1.0f && f >= 0.0f && this.hhv != null && this.hhy != null && this.hhx != null && this.hhy.getAlpha() != f) {
            this.hhy.setAlpha(f);
            if (f == 1.0f) {
                this.hhv.setAlpha(1.0f);
                this.hhv.setClickable(true);
                if (this.hhw != null) {
                    this.hhw.setAlpha(1.0f);
                    this.hhw.setClickable(true);
                }
                mU(true);
                mT(true);
                return;
            }
            this.hhv.setAlpha(0.0f);
            this.hhv.setClickable(false);
            if (this.hhw != null) {
                this.hhw.setAlpha(0.0f);
                this.hhw.setClickable(false);
            }
            mU(false);
            mT(false);
        }
    }

    private void mT(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hhz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hhz.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hhz.setLayoutParams(layoutParams);
            }
        }
    }

    private void mU(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hhx.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hhx.setLayoutParams(layoutParams);
                    this.hhx.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View vo = HomeTabBarView.this.hhx.vo(HomeTabBarView.this.hhx.getCurrentTabIndex());
                            if (vo != null && vo.getRight() > HomeTabBarView.this.hhx.getRight()) {
                                HomeTabBarView.this.hhx.scrollTo(vo.getWidth() + HomeTabBarView.this.hhx.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hhx.setLayoutParams(layoutParams);
            }
        }
    }

    private void bNO() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 2);
        anVar.X("obj_locate", 1);
        anVar.X(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bOh() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 1);
        anVar.X("obj_locate", 1);
        anVar.X(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
