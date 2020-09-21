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
/* loaded from: classes21.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView fpj;
    private NestedScrollHeader.a iRq;
    private TbImageView iZX;
    private PagerSlidingTabStrip iZY;
    private LinearLayout iZZ;
    private View jaa;
    private int jab;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jab = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jab = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jab = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fpj = (ImageView) findViewById(R.id.home_page_search_icon);
        this.fpj.setClickable(false);
        this.iZY = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.iZY.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.iZY.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.iZZ = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.jaa = findViewById(R.id.home_page_shadow);
        this.iZX = (TbImageView) findViewById(R.id.home_page_get_money);
        this.iZX.setClickable(false);
        this.fpj.setOnClickListener(this);
        this.iZX.setOnClickListener(this);
        setOnClickListener(this);
        aq(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.iZX.setVisibility(0);
            this.rightMargin = this.tbds264;
            pZ(true);
            pY(true);
            cAb();
            return;
        }
        this.rightMargin = this.tbds150;
        this.iZX.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.iZX;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.iRq = aVar;
    }

    private void cAb() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iZX.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iZX.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mR().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.iZX.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.iZX.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.iZX.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.iZX.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.fpj) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).ai("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.iZX) {
            Object tag = this.iZX.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cAc();
                    if (this.iRq != null) {
                        this.iRq.Kf(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iZY.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iZY != null) {
            this.iZY.setShowConcernRedTip(z);
        }
    }

    public boolean cAk() {
        if (this.iZY != null) {
            return this.iZY.cAk();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.iZY != null) {
            this.iZY.setShowHotTopicRedTip(z);
        }
    }

    public boolean cAl() {
        if (this.iZY != null) {
            return this.iZY.cAl();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iZY.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.iZY.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.iZY.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.bkl().a(this.fpj, R.drawable.icon_pure_topbar_search44_svg, this.jab, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iZY.onChangeSkinType();
            ap.setBackgroundResource(this.jaa, R.drawable.home_page_tab_shadow);
        }
    }

    public View An(int i) {
        return this.iZY.An(i);
    }

    public void onResume() {
        SvgManager.bkl().a(this.fpj, R.drawable.icon_pure_topbar_search44_svg, this.jab, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.iZY.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.iZY.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.iZY.setOnTabItemClickListener(aVar);
    }

    public void aq(float f) {
        if (f <= 1.0f && f >= 0.0f && this.fpj != null && this.iZZ != null && this.iZY != null && this.iZZ.getAlpha() != f) {
            this.iZZ.setAlpha(f);
            if (f == 1.0f) {
                this.fpj.setAlpha(1.0f);
                this.fpj.setClickable(true);
                if (this.iZX != null) {
                    this.iZX.setAlpha(1.0f);
                    this.iZX.setClickable(true);
                }
                pZ(true);
                pY(true);
                return;
            }
            this.fpj.setAlpha(0.0f);
            this.fpj.setClickable(false);
            if (this.iZX != null) {
                this.iZX.setAlpha(0.0f);
                this.iZX.setClickable(false);
            }
            pZ(false);
            pY(false);
        }
    }

    private void pY(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jaa.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jaa.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jaa.setLayoutParams(layoutParams);
            }
        }
    }

    private void pZ(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZY.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iZY.setLayoutParams(layoutParams);
                    this.iZY.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View An = HomeTabBarView.this.iZY.An(HomeTabBarView.this.iZY.getCurrentTabIndex());
                            if (An != null && An.getRight() > HomeTabBarView.this.iZY.getRight()) {
                                HomeTabBarView.this.iZY.scrollTo(An.getWidth() + HomeTabBarView.this.iZY.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iZY.setLayoutParams(layoutParams);
            }
        }
    }

    private void cAc() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 2);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dF("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cAB() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 1);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dF("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
