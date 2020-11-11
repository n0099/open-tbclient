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
    private ImageView fPI;
    private TbImageView jHt;
    private PagerSlidingTabStrip jHu;
    private LinearLayout jHv;
    private View jHw;
    private int jHx;
    private NestedScrollHeader.a jyF;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jHx = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jHx = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jHx = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fPI = (ImageView) findViewById(R.id.home_page_search_icon);
        this.fPI.setClickable(false);
        this.jHu = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.jHu.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.jHu.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.jHv = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.jHw = findViewById(R.id.home_page_shadow);
        this.jHt = (TbImageView) findViewById(R.id.home_page_get_money);
        this.jHt.setClickable(false);
        this.fPI.setOnClickListener(this);
        this.jHt.setOnClickListener(this);
        setOnClickListener(this);
        aA(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.jHt.setVisibility(0);
            this.rightMargin = this.tbds264;
            rg(true);
            rf(true);
            cJn();
            return;
        }
        this.rightMargin = this.tbds150;
        this.jHt.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.jHt;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.jyF = aVar;
    }

    private void cJn() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.jHt.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.jHt.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.jHt.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.jHt.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.jHt.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.jHt.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.fPI) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).al("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.jHt) {
            Object tag = this.jHt.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cJo();
                    if (this.jyF != null) {
                        this.jyF.LJ(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jHu.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jHu != null) {
            this.jHu.setShowConcernRedTip(z);
        }
    }

    public boolean cJz() {
        if (this.jHu != null) {
            return this.jHu.cJz();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.jHu != null) {
            this.jHu.setShowHotTopicRedTip(z);
        }
    }

    public boolean cJA() {
        if (this.jHu != null) {
            return this.jHu.cJA();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jHu.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.jHu.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.jHu.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.brn().a(this.fPI, R.drawable.icon_pure_topbar_search44_svg, this.jHx, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jHu.onChangeSkinType();
            ap.setBackgroundResource(this.jHw, R.drawable.home_page_tab_shadow);
        }
    }

    public View Bz(int i) {
        return this.jHu.Bz(i);
    }

    public void onResume() {
        SvgManager.brn().a(this.fPI, R.drawable.icon_pure_topbar_search44_svg, this.jHx, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.jHu.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.jHu.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.jHu.setOnTabItemClickListener(aVar);
    }

    public void aA(float f) {
        if (f <= 1.0f && f >= 0.0f && this.fPI != null && this.jHv != null && this.jHu != null && this.jHv.getAlpha() != f) {
            this.jHv.setAlpha(f);
            if (f == 1.0f) {
                this.fPI.setAlpha(1.0f);
                this.fPI.setClickable(true);
                if (this.jHt != null) {
                    this.jHt.setAlpha(1.0f);
                    this.jHt.setClickable(true);
                }
                rg(true);
                rf(true);
                return;
            }
            this.fPI.setAlpha(0.0f);
            this.fPI.setClickable(false);
            if (this.jHt != null) {
                this.jHt.setAlpha(0.0f);
                this.jHt.setClickable(false);
            }
            rg(false);
            rf(false);
        }
    }

    private void rf(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHw.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jHw.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jHw.setLayoutParams(layoutParams);
            }
        }
    }

    private void rg(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHu.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jHu.setLayoutParams(layoutParams);
                    this.jHu.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View Bz = HomeTabBarView.this.jHu.Bz(HomeTabBarView.this.jHu.getCurrentTabIndex());
                            if (Bz != null && Bz.getRight() > HomeTabBarView.this.jHu.getRight()) {
                                HomeTabBarView.this.jHu.scrollTo(Bz.getWidth() + HomeTabBarView.this.jHu.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jHu.setLayoutParams(layoutParams);
            }
        }
    }

    private void cJo() {
        aq aqVar = new aq("c13422");
        aqVar.al("obj_type", 2);
        aqVar.al("obj_locate", 1);
        aqVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cJQ() {
        aq aqVar = new aq("c13422");
        aqVar.al("obj_type", 1);
        aqVar.al("obj_locate", 1);
        aqVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
