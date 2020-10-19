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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes22.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView fBx;
    private NestedScrollHeader.a jgk;
    private TbImageView joW;
    private PagerSlidingTabStrip joX;
    private LinearLayout joY;
    private View joZ;
    private int jpa;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jpa = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jpa = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jpa = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fBx = (ImageView) findViewById(R.id.home_page_search_icon);
        this.fBx.setClickable(false);
        this.joX = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.joX.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.joX.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.joY = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.joZ = findViewById(R.id.home_page_shadow);
        this.joW = (TbImageView) findViewById(R.id.home_page_get_money);
        this.joW.setClickable(false);
        this.fBx.setOnClickListener(this);
        this.joW.setOnClickListener(this);
        setOnClickListener(this);
        aw(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.joW.setVisibility(0);
            this.rightMargin = this.tbds264;
            qF(true);
            qE(true);
            cDF();
            return;
        }
        this.rightMargin = this.tbds150;
        this.joW.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.joW;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.jgk = aVar;
    }

    private void cDF() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.joW.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.joW.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.joW.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.joW.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.joW.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.joW.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.fBx) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).aj("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.joW) {
            Object tag = this.joW.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cDG();
                    if (this.jgk != null) {
                        this.jgk.KU(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.joX.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.joX != null) {
            this.joX.setShowConcernRedTip(z);
        }
    }

    public boolean cDR() {
        if (this.joX != null) {
            return this.joX.cDR();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.joX != null) {
            this.joX.setShowHotTopicRedTip(z);
        }
    }

    public boolean cDS() {
        if (this.joX != null) {
            return this.joX.cDS();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.joX.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.joX.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.joX.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.bmU().a(this.fBx, R.drawable.icon_pure_topbar_search44_svg, this.jpa, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.joX.onChangeSkinType();
            ap.setBackgroundResource(this.joZ, R.drawable.home_page_tab_shadow);
        }
    }

    public View AT(int i) {
        return this.joX.AT(i);
    }

    public void onResume() {
        SvgManager.bmU().a(this.fBx, R.drawable.icon_pure_topbar_search44_svg, this.jpa, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.joX.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.joX.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.joX.setOnTabItemClickListener(aVar);
    }

    public void aw(float f) {
        if (f <= 1.0f && f >= 0.0f && this.fBx != null && this.joY != null && this.joX != null && this.joY.getAlpha() != f) {
            this.joY.setAlpha(f);
            if (f == 1.0f) {
                this.fBx.setAlpha(1.0f);
                this.fBx.setClickable(true);
                if (this.joW != null) {
                    this.joW.setAlpha(1.0f);
                    this.joW.setClickable(true);
                }
                qF(true);
                qE(true);
                return;
            }
            this.fBx.setAlpha(0.0f);
            this.fBx.setClickable(false);
            if (this.joW != null) {
                this.joW.setAlpha(0.0f);
                this.joW.setClickable(false);
            }
            qF(false);
            qE(false);
        }
    }

    private void qE(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joZ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.joZ.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.joZ.setLayoutParams(layoutParams);
            }
        }
    }

    private void qF(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.joX.setLayoutParams(layoutParams);
                    this.joX.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View AT = HomeTabBarView.this.joX.AT(HomeTabBarView.this.joX.getCurrentTabIndex());
                            if (AT != null && AT.getRight() > HomeTabBarView.this.joX.getRight()) {
                                HomeTabBarView.this.joX.scrollTo(AT.getWidth() + HomeTabBarView.this.joX.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.joX.setLayoutParams(layoutParams);
            }
        }
    }

    private void cDG() {
        aq aqVar = new aq("c13422");
        aqVar.aj("obj_type", 2);
        aqVar.aj("obj_locate", 1);
        aqVar.aj("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dK("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cEi() {
        aq aqVar = new aq("c13422");
        aqVar.aj("obj_type", 1);
        aqVar.aj("obj_locate", 1);
        aqVar.aj("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dK("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
