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
/* loaded from: classes6.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private int dJO;
    private NestedScrollHeader.a gTR;
    private ImageView haf;
    private TbImageView hag;
    private PagerSlidingTabStrip hah;
    private LinearLayout hai;
    private View haj;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dJO = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dJO = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dJO = 0;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.dJO = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.haf = (ImageView) findViewById(R.id.home_page_search_icon);
        this.haf.setClickable(false);
        this.hah = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.hah.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.hah.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.hai = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.haj = findViewById(R.id.home_page_shadow);
        this.hag = (TbImageView) findViewById(R.id.home_page_get_money);
        this.hag.setClickable(false);
        this.haf.setOnClickListener(this);
        this.hag.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && MissionEntranceSwitch.isOn()) {
            this.hag.setVisibility(0);
            this.dJO = this.tbds264;
            mB(true);
            mA(true);
            bKO();
            return;
        }
        this.dJO = this.tbds150;
        this.hag.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.hag;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.gTR = aVar;
    }

    private void bKO() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.hag.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.hag.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.gs().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.hag.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.hag.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.hag.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.hag.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.haf) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).Z("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.hag) {
            Object tag = this.hag.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bKP();
                    if (this.gTR != null) {
                        this.gTR.BF(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hah.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hah != null) {
            this.hah.setShowConcernRedTip(z);
        }
    }

    public boolean bKV() {
        if (this.hah != null) {
            return this.hah.bKV();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.hah.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.hah.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.hah.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.hai, R.color.cp_bg_line_h);
            SvgManager.aDW().a(this.haf, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hah.onChangeSkinType();
            am.setBackgroundResource(this.haj, R.drawable.home_page_tab_shadow);
        }
    }

    public View uW(int i) {
        return this.hah.uW(i);
    }

    public void onResume() {
        SvgManager.aDW().a(this.haf, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.hah.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.hah.setOnTabItemClickListener(aVar);
    }

    public void aA(float f) {
        if (f <= 1.0f && f >= 0.0f && this.haf != null && this.hai != null && this.hah != null && this.hai.getAlpha() != f) {
            this.hai.setAlpha(f);
            if (f == 1.0f) {
                this.haf.setAlpha(1.0f);
                this.haf.setClickable(true);
                if (this.hag != null) {
                    this.hag.setAlpha(1.0f);
                    this.hag.setClickable(true);
                }
                mB(true);
                mA(true);
                return;
            }
            this.haf.setAlpha(0.0f);
            this.haf.setClickable(false);
            if (this.hag != null) {
                this.hag.setAlpha(0.0f);
                this.hag.setClickable(false);
            }
            mB(false);
            mA(false);
        }
    }

    private void mA(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.haj.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.dJO) {
                    layoutParams.rightMargin = this.dJO;
                    this.haj.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.haj.setLayoutParams(layoutParams);
            }
        }
    }

    private void mB(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hah.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.dJO) {
                    layoutParams.rightMargin = this.dJO;
                    this.hah.setLayoutParams(layoutParams);
                    this.hah.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View uW = HomeTabBarView.this.hah.uW(HomeTabBarView.this.hah.getCurrentTabIndex());
                            if (uW != null && uW.getRight() > HomeTabBarView.this.hah.getRight()) {
                                HomeTabBarView.this.hah.scrollTo(uW.getWidth() + HomeTabBarView.this.hah.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hah.setLayoutParams(layoutParams);
            }
        }
    }

    private void bKP() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 2);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bLh() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 1);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
