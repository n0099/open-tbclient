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
import com.baidu.tbadk.t.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a ggr;
    private ImageView gmD;
    private TbImageView gmE;
    private PagerSlidingTabStrip gmF;
    private LinearLayout gmG;
    private int gmH;
    private View gmI;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gmH = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gmH = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gmH = 0;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.gmH = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.gmD = (ImageView) findViewById(R.id.home_page_search_icon);
        this.gmD.setClickable(false);
        this.gmF = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.gmF.d(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds68), l.getDimens(context, R.dimen.tbds32), true);
        this.gmG = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.gmI = findViewById(R.id.home_page_shadow);
        this.gmE = (TbImageView) findViewById(R.id.home_page_get_money);
        this.gmE.setClickable(false);
        this.gmD.setOnClickListener(this);
        this.gmE.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && ao.isOn()) {
            this.gmE.setVisibility(0);
            this.gmH = this.tbds264;
            lo(true);
            ln(true);
            btz();
            return;
        }
        this.gmH = this.tbds150;
        this.gmE.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.gmE;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.ggr = aVar;
    }

    private void btz() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.gmE.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.gmE.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.f.c.fT().a(missionEntranceIcon, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.gmE.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.gmE.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.gmE.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.gmE.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmD) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).O("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.gmE) {
            Object tag = this.gmE.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    btA();
                    if (this.ggr != null) {
                        this.ggr.wW(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gmF.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gmF != null) {
            this.gmF.setShowConcernRedTip(z);
        }
    }

    public boolean btH() {
        if (this.gmF != null) {
            return this.gmF.btH();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.gmF.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.gmF.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.gmF.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.gmG, R.color.cp_bg_line_h);
            SvgManager.amL().a(this.gmD, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.gmF.onChangeSkinType();
            am.setBackgroundResource(this.gmI, R.drawable.home_page_tab_shadow);
        }
    }

    public View sS(int i) {
        return this.gmF.sS(i);
    }

    public void onResume() {
        SvgManager.amL().a(this.gmD, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.gmF.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.gmF.setOnTabItemClickListener(aVar);
    }

    public void am(float f) {
        if (f <= 1.0f && f >= 0.0f && this.gmD != null && this.gmG != null && this.gmF != null && this.gmG.getAlpha() != f) {
            this.gmG.setAlpha(f);
            if (f == 1.0f) {
                this.gmD.setAlpha(1.0f);
                this.gmD.setClickable(true);
                if (this.gmE != null) {
                    this.gmE.setAlpha(1.0f);
                    this.gmE.setClickable(true);
                }
                lo(true);
                ln(true);
                return;
            }
            this.gmD.setAlpha(0.0f);
            this.gmD.setClickable(false);
            if (this.gmE != null) {
                this.gmE.setAlpha(0.0f);
                this.gmE.setClickable(false);
            }
            lo(false);
            ln(false);
        }
    }

    private void ln(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmI.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.gmH) {
                    layoutParams.rightMargin = this.gmH;
                    this.gmI.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.gmI.setLayoutParams(layoutParams);
            }
        }
    }

    private void lo(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmF.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.gmH) {
                    layoutParams.rightMargin = this.gmH;
                    this.gmF.setLayoutParams(layoutParams);
                    this.gmF.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View sS = HomeTabBarView.this.gmF.sS(HomeTabBarView.this.gmF.getCurrentTabIndex());
                            if (sS != null && sS.getRight() > HomeTabBarView.this.gmF.getRight()) {
                                HomeTabBarView.this.gmF.scrollTo(sS.getWidth() + HomeTabBarView.this.gmF.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.gmF.setLayoutParams(layoutParams);
            }
        }
    }

    private void btA() {
        an anVar = new an("c13422");
        anVar.O("obj_type", 2);
        anVar.O("obj_locate", 1);
        anVar.O(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void btT() {
        an anVar = new an("c13422");
        anVar.O("obj_type", 1);
        anVar.O("obj_locate", 1);
        anVar.O(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
