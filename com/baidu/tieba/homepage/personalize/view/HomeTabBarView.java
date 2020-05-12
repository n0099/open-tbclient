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
    private NestedScrollHeader.a hKD;
    private ImageView hRl;
    private TbImageView hRm;
    private PagerSlidingTabStrip hRn;
    private LinearLayout hRo;
    private View hRp;
    private int hRq;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hRq = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hRq = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.hRq = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.hRl = (ImageView) findViewById(R.id.home_page_search_icon);
        this.hRl.setClickable(false);
        this.hRn = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.hRn.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.hRn.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.hRo = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.hRp = findViewById(R.id.home_page_shadow);
        this.hRm = (TbImageView) findViewById(R.id.home_page_get_money);
        this.hRm.setClickable(false);
        this.hRl.setOnClickListener(this);
        this.hRm.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && MissionEntranceSwitch.isOn()) {
            this.hRm.setVisibility(0);
            this.rightMargin = this.tbds264;
            nY(true);
            nX(true);
            bYn();
            return;
        }
        this.rightMargin = this.tbds150;
        this.hRm.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.hRm;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.hKD = aVar;
    }

    private void bYn() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.hRm.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.hRm.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.kV().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.hRm.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.hRm.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.hRm.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.hRm.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.hRl) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).af("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.hRm) {
            Object tag = this.hRm.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bYo();
                    if (this.hKD != null) {
                        this.hKD.DR(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hRn.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hRn != null) {
            this.hRn.setShowConcernRedTip(z);
        }
    }

    public boolean bYu() {
        if (this.hRn != null) {
            return this.hRn.bYu();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.hRn.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.hRn.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.hRn.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.aOR().a(this.hRl, R.drawable.icon_pure_topbar_search44_svg, this.hRq, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hRn.onChangeSkinType();
            am.setBackgroundResource(this.hRp, R.drawable.home_page_tab_shadow);
        }
    }

    public View vM(int i) {
        return this.hRn.vM(i);
    }

    public void onResume() {
        SvgManager.aOR().a(this.hRl, R.drawable.icon_pure_topbar_search44_svg, this.hRq, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.hRn.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.hRn.setOnTabItemClickListener(aVar);
    }

    public void ai(float f) {
        if (f <= 1.0f && f >= 0.0f && this.hRl != null && this.hRo != null && this.hRn != null && this.hRo.getAlpha() != f) {
            this.hRo.setAlpha(f);
            if (f == 1.0f) {
                this.hRl.setAlpha(1.0f);
                this.hRl.setClickable(true);
                if (this.hRm != null) {
                    this.hRm.setAlpha(1.0f);
                    this.hRm.setClickable(true);
                }
                nY(true);
                nX(true);
                return;
            }
            this.hRl.setAlpha(0.0f);
            this.hRl.setClickable(false);
            if (this.hRm != null) {
                this.hRm.setAlpha(0.0f);
                this.hRm.setClickable(false);
            }
            nY(false);
            nX(false);
        }
    }

    private void nX(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRp.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hRp.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hRp.setLayoutParams(layoutParams);
            }
        }
    }

    private void nY(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRn.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.hRn.setLayoutParams(layoutParams);
                    this.hRn.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View vM = HomeTabBarView.this.hRn.vM(HomeTabBarView.this.hRn.getCurrentTabIndex());
                            if (vM != null && vM.getRight() > HomeTabBarView.this.hRn.getRight()) {
                                HomeTabBarView.this.hRn.scrollTo(vM.getWidth() + HomeTabBarView.this.hRn.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.hRn.setLayoutParams(layoutParams);
            }
        }
    }

    private void bYo() {
        an anVar = new an("c13422");
        anVar.af("obj_type", 2);
        anVar.af("obj_locate", 1);
        anVar.af(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bYH() {
        an anVar = new an("c13422");
        anVar.af("obj_type", 1);
        anVar.af("obj_locate", 1);
        anVar.af(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
