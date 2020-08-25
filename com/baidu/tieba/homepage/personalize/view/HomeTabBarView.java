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
/* loaded from: classes16.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a iIK;
    private ImageView iRk;
    private TbImageView iRl;
    private PagerSlidingTabStrip iRm;
    private LinearLayout iRn;
    private View iRo;
    private int iRp;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iRp = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iRp = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iRp = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.iRk = (ImageView) findViewById(R.id.home_page_search_icon);
        this.iRk.setClickable(false);
        this.iRm = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.iRm.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.iRm.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.iRn = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.iRo = findViewById(R.id.home_page_shadow);
        this.iRl = (TbImageView) findViewById(R.id.home_page_get_money);
        this.iRl.setClickable(false);
        this.iRk.setOnClickListener(this);
        this.iRl.setOnClickListener(this);
        setOnClickListener(this);
        aq(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.iRl.setVisibility(0);
            this.rightMargin = this.tbds264;
            pP(true);
            pO(true);
            cwu();
            return;
        }
        this.rightMargin = this.tbds150;
        this.iRl.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.iRl;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.iIK = aVar;
    }

    private void cwu() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iRl.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iRl.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mM().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.iRl.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.iRl.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.iRl.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.iRl.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.iRk) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).ai("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.iRl) {
            Object tag = this.iRl.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cwv();
                    if (this.iIK != null) {
                        this.iIK.JC(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iRm.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iRm != null) {
            this.iRm.setShowConcernRedTip(z);
        }
    }

    public boolean cwC() {
        if (this.iRm != null) {
            return this.iRm.cwC();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.iRm != null) {
            this.iRm.setShowHotTopicRedTip(z);
        }
    }

    public boolean cwD() {
        if (this.iRm != null) {
            return this.iRm.cwD();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iRm.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.iRm.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.iRm.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.bjq().a(this.iRk, R.drawable.icon_pure_topbar_search44_svg, this.iRp, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iRm.onChangeSkinType();
            ap.setBackgroundResource(this.iRo, R.drawable.home_page_tab_shadow);
        }
    }

    public View zM(int i) {
        return this.iRm.zM(i);
    }

    public void onResume() {
        SvgManager.bjq().a(this.iRk, R.drawable.icon_pure_topbar_search44_svg, this.iRp, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.iRm.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.iRm.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.iRm.setOnTabItemClickListener(aVar);
    }

    public void aq(float f) {
        if (f <= 1.0f && f >= 0.0f && this.iRk != null && this.iRn != null && this.iRm != null && this.iRn.getAlpha() != f) {
            this.iRn.setAlpha(f);
            if (f == 1.0f) {
                this.iRk.setAlpha(1.0f);
                this.iRk.setClickable(true);
                if (this.iRl != null) {
                    this.iRl.setAlpha(1.0f);
                    this.iRl.setClickable(true);
                }
                pP(true);
                pO(true);
                return;
            }
            this.iRk.setAlpha(0.0f);
            this.iRk.setClickable(false);
            if (this.iRl != null) {
                this.iRl.setAlpha(0.0f);
                this.iRl.setClickable(false);
            }
            pP(false);
            pO(false);
        }
    }

    private void pO(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iRo.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iRo.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iRo.setLayoutParams(layoutParams);
            }
        }
    }

    private void pP(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iRm.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iRm.setLayoutParams(layoutParams);
                    this.iRm.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View zM = HomeTabBarView.this.iRm.zM(HomeTabBarView.this.iRm.getCurrentTabIndex());
                            if (zM != null && zM.getRight() > HomeTabBarView.this.iRm.getRight()) {
                                HomeTabBarView.this.iRm.scrollTo(zM.getWidth() + HomeTabBarView.this.iRm.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iRm.setLayoutParams(layoutParams);
            }
        }
    }

    private void cwv() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 2);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dD("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cwS() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 1);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dD("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
