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
    private ImageView fJS;
    private int jBA;
    private TbImageView jBw;
    private PagerSlidingTabStrip jBx;
    private LinearLayout jBy;
    private View jBz;
    private NestedScrollHeader.a jsI;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jBA = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jBA = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jBA = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fJS = (ImageView) findViewById(R.id.home_page_search_icon);
        this.fJS.setClickable(false);
        this.jBx = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.jBx.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.jBx.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.jBy = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.jBz = findViewById(R.id.home_page_shadow);
        this.jBw = (TbImageView) findViewById(R.id.home_page_get_money);
        this.jBw.setClickable(false);
        this.fJS.setOnClickListener(this);
        this.jBw.setOnClickListener(this);
        setOnClickListener(this);
        ay(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.jBw.setVisibility(0);
            this.rightMargin = this.tbds264;
            qX(true);
            qW(true);
            cGM();
            return;
        }
        this.rightMargin = this.tbds150;
        this.jBw.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.jBw;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.jsI = aVar;
    }

    private void cGM() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.jBw.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.jBw.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.jBw.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.jBw.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.jBw.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.jBw.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.fJS) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).aj("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.jBw) {
            Object tag = this.jBw.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cGN();
                    if (this.jsI != null) {
                        this.jsI.Ls(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jBx.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jBx != null) {
            this.jBx.setShowConcernRedTip(z);
        }
    }

    public boolean cGY() {
        if (this.jBx != null) {
            return this.jBx.cGY();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.jBx != null) {
            this.jBx.setShowHotTopicRedTip(z);
        }
    }

    public boolean cGZ() {
        if (this.jBx != null) {
            return this.jBx.cGZ();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jBx.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.jBx.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.jBx.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.boN().a(this.fJS, R.drawable.icon_pure_topbar_search44_svg, this.jBA, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jBx.onChangeSkinType();
            ap.setBackgroundResource(this.jBz, R.drawable.home_page_tab_shadow);
        }
    }

    public View Bm(int i) {
        return this.jBx.Bm(i);
    }

    public void onResume() {
        SvgManager.boN().a(this.fJS, R.drawable.icon_pure_topbar_search44_svg, this.jBA, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.jBx.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.jBx.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.jBx.setOnTabItemClickListener(aVar);
    }

    public void ay(float f) {
        if (f <= 1.0f && f >= 0.0f && this.fJS != null && this.jBy != null && this.jBx != null && this.jBy.getAlpha() != f) {
            this.jBy.setAlpha(f);
            if (f == 1.0f) {
                this.fJS.setAlpha(1.0f);
                this.fJS.setClickable(true);
                if (this.jBw != null) {
                    this.jBw.setAlpha(1.0f);
                    this.jBw.setClickable(true);
                }
                qX(true);
                qW(true);
                return;
            }
            this.fJS.setAlpha(0.0f);
            this.fJS.setClickable(false);
            if (this.jBw != null) {
                this.jBw.setAlpha(0.0f);
                this.jBw.setClickable(false);
            }
            qX(false);
            qW(false);
        }
    }

    private void qW(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jBz.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jBz.setLayoutParams(layoutParams);
            }
        }
    }

    private void qX(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBx.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jBx.setLayoutParams(layoutParams);
                    this.jBx.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View Bm = HomeTabBarView.this.jBx.Bm(HomeTabBarView.this.jBx.getCurrentTabIndex());
                            if (Bm != null && Bm.getRight() > HomeTabBarView.this.jBx.getRight()) {
                                HomeTabBarView.this.jBx.scrollTo(Bm.getWidth() + HomeTabBarView.this.jBx.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jBx.setLayoutParams(layoutParams);
            }
        }
    }

    private void cGN() {
        aq aqVar = new aq("c13422");
        aqVar.aj("obj_type", 2);
        aqVar.aj("obj_locate", 1);
        aqVar.aj("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cHp() {
        aq aqVar = new aq("c13422");
        aqVar.aj("obj_type", 1);
        aqVar.aj("obj_locate", 1);
        aqVar.aj("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
