package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private float bem;
    private int fYU;
    private ImageView ghj;
    private NestedScrollHeader.a kao;
    private TbImageView kiV;
    private PagerSlidingTabStrip kiW;
    private LinearLayout kiX;
    private View kiY;
    private int kiZ;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fYU = 0;
        this.kiZ = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fYU = 0;
        this.kiZ = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fYU = 0;
        this.kiZ = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.fYU = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.ghj = (ImageView) findViewById(R.id.home_page_search_icon);
        this.ghj.setClickable(false);
        this.kiW = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.kiW.c(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.kiW.setExpandedTabLayoutParams(layoutParams);
        this.kiX = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.kiY = findViewById(R.id.home_page_shadow);
        this.kiV = (TbImageView) findViewById(R.id.home_page_get_money);
        this.kiV.setClickable(false);
        this.ghj.setOnClickListener(this);
        this.kiV.setOnClickListener(this);
        setOnClickListener(this);
        aK(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.kiV.setVisibility(0);
            this.fYU = this.tbds264;
            si(true);
            sh(true);
            cRp();
            return;
        }
        this.fYU = this.tbds150;
        this.kiV.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.kiV;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.kao = aVar;
    }

    private void cRp() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.kiV.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.kiV.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.d.mx().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.kiV.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.kiV.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.kiV.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.kiV.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghj) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).an("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.kiV) {
            Object tag = this.kiV.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cRq();
                    if (this.kao != null) {
                        this.kao.Mq(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kiW.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kiW != null) {
            this.kiW.setShowConcernRedTip(z);
        }
    }

    public boolean cRB() {
        if (this.kiW != null) {
            return this.kiW.cRB();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.kiW != null) {
            this.kiW.setShowHotTopicRedTip(z);
        }
    }

    public boolean cRC() {
        if (this.kiW != null) {
            return this.kiW.cRC();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kiW.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.kiW.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.kiW.notifyDataSetChanged();
    }

    public void cTK() {
        this.kiW.OH();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.a(this, R.color.CAM_X0208, this.bem, this.mSkinType);
            this.ghj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(this.kiZ), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.kiW.onChangeSkinType();
            ao.setBackgroundResource(this.kiY, R.drawable.home_page_tab_shadow);
        }
    }

    public View Da(int i) {
        return this.kiW.Da(i);
    }

    public void onResume() {
        this.ghj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(this.kiZ), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.kiW.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.kiW.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.kiW.setOnTabItemClickListener(aVar);
    }

    public void aK(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.bem = f;
            ao.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.ghj != null && this.kiX != null && this.kiW != null && this.kiY != null && this.kiX.getAlpha() != f) {
                this.kiX.setAlpha(f);
                this.kiY.setAlpha(f);
                if (f == 1.0f) {
                    this.ghj.setClickable(true);
                    if (this.kiV != null) {
                        this.kiV.setClickable(true);
                    }
                    si(true);
                    sh(true);
                    return;
                }
                this.ghj.setClickable(false);
                if (this.kiV != null) {
                    this.kiV.setClickable(false);
                }
                si(false);
                sh(false);
            }
        }
    }

    public float getBackgroundAlpha() {
        return this.bem;
    }

    private void sh(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kiY.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.fYU) {
                    layoutParams.rightMargin = this.fYU;
                    this.kiY.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kiY.setLayoutParams(layoutParams);
            }
        }
    }

    private void si(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kiW.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.fYU) {
                    layoutParams.rightMargin = this.fYU;
                    this.kiW.setLayoutParams(layoutParams);
                    this.kiW.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View Da = HomeTabBarView.this.kiW.Da(HomeTabBarView.this.kiW.getCurrentTabIndex());
                            if (Da != null && Da.getRight() > HomeTabBarView.this.kiW.getRight()) {
                                HomeTabBarView.this.kiW.scrollTo(Da.getWidth() + HomeTabBarView.this.kiW.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kiW.setLayoutParams(layoutParams);
            }
        }
    }

    private void cRq() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 2);
        aqVar.an("obj_locate", 1);
        aqVar.an("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dX("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cRS() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 1);
        aqVar.an("obj_locate", 1);
        aqVar.an("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dX("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
