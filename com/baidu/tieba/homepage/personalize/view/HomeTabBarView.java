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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes9.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a ior;
    private ImageView iwg;
    private TbImageView iwh;
    private PagerSlidingTabStrip iwi;
    private LinearLayout iwj;
    private View iwk;
    private int iwl;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iwl = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iwl = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iwl = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.iwg = (ImageView) findViewById(R.id.home_page_search_icon);
        this.iwg.setClickable(false);
        this.iwi = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.iwi.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.iwi.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.iwj = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.iwk = findViewById(R.id.home_page_shadow);
        this.iwh = (TbImageView) findViewById(R.id.home_page_get_money);
        this.iwh.setClickable(false);
        this.iwg.setOnClickListener(this);
        this.iwh.setOnClickListener(this);
        setOnClickListener(this);
        if (com.baidu.tbadk.a.d.aNV()) {
            this.iwg.setVisibility(8);
        } else {
            ak(0.0f);
        }
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.iwh.setVisibility(0);
            this.rightMargin = this.tbds264;
            oE(true);
            oD(true);
            cil();
            return;
        }
        this.rightMargin = this.tbds150;
        this.iwh.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.iwh;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.ior = aVar;
    }

    private void cil() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iwh.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iwh.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.ln().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.iwh.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.iwh.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.iwh.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.iwh.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.iwg) {
            TiebaStatic.log(new ao(CommonStatisticKey.SEARCH_BAR_CLICK).ag("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.iwh) {
            Object tag = this.iwh.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cim();
                    if (this.ior != null) {
                        this.ior.Ga(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iwi.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iwi != null) {
            this.iwi.setShowConcernRedTip(z);
        }
    }

    public boolean cit() {
        if (this.iwi != null) {
            return this.iwi.cit();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iwi.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.iwi.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.iwi.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.aWQ().a(this.iwg, R.drawable.icon_pure_topbar_search44_svg, this.iwl, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iwi.onChangeSkinType();
            an.setBackgroundResource(this.iwk, R.drawable.home_page_tab_shadow);
        }
    }

    public View xa(int i) {
        return this.iwi.xa(i);
    }

    public void onResume() {
        SvgManager.aWQ().a(this.iwg, R.drawable.icon_pure_topbar_search44_svg, this.iwl, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.iwi.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.iwi.setOnTabItemClickListener(aVar);
    }

    public void ak(float f) {
        if (f <= 1.0f && f >= 0.0f && this.iwg != null && this.iwj != null && this.iwi != null && this.iwj.getAlpha() != f) {
            this.iwj.setAlpha(f);
            if (f == 1.0f) {
                this.iwg.setAlpha(1.0f);
                this.iwg.setClickable(true);
                if (this.iwh != null) {
                    this.iwh.setAlpha(1.0f);
                    this.iwh.setClickable(true);
                }
                oE(true);
                oD(true);
                return;
            }
            this.iwg.setAlpha(0.0f);
            this.iwg.setClickable(false);
            if (this.iwh != null) {
                this.iwh.setAlpha(0.0f);
                this.iwh.setClickable(false);
            }
            oE(false);
            oD(false);
        }
    }

    private void oD(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iwk.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iwk.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iwk.setLayoutParams(layoutParams);
            }
        }
    }

    private void oE(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iwi.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iwi.setLayoutParams(layoutParams);
                    this.iwi.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View xa = HomeTabBarView.this.iwi.xa(HomeTabBarView.this.iwi.getCurrentTabIndex());
                            if (xa != null && xa.getRight() > HomeTabBarView.this.iwi.getRight()) {
                                HomeTabBarView.this.iwi.scrollTo(xa.getWidth() + HomeTabBarView.this.iwi.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iwi.setLayoutParams(layoutParams);
            }
        }
    }

    private void cim() {
        ao aoVar = new ao("c13422");
        aoVar.ag("obj_type", 2);
        aoVar.ag("obj_locate", 1);
        aoVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aoVar.dk("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aoVar);
    }

    public void ciH() {
        ao aoVar = new ao("c13422");
        aoVar.ag("obj_type", 1);
        aoVar.ag("obj_locate", 1);
        aoVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aoVar.dk("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aoVar);
    }
}
