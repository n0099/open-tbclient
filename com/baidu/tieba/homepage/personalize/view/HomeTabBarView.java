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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes16.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView iCk;
    private TbImageView iCl;
    private PagerSlidingTabStrip iCm;
    private LinearLayout iCn;
    private View iCo;
    private int iCp;
    private NestedScrollHeader.a iut;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iCp = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iCp = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iCp = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.iCk = (ImageView) findViewById(R.id.home_page_search_icon);
        this.iCk.setClickable(false);
        this.iCm = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.iCm.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.iCm.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.iCn = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.iCo = findViewById(R.id.home_page_shadow);
        this.iCl = (TbImageView) findViewById(R.id.home_page_get_money);
        this.iCl.setClickable(false);
        this.iCk.setOnClickListener(this);
        this.iCl.setOnClickListener(this);
        setOnClickListener(this);
        if (com.baidu.tbadk.a.d.aRN()) {
            this.iCk.setVisibility(8);
        } else {
            ak(0.0f);
        }
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.iCl.setVisibility(0);
            this.rightMargin = this.tbds264;
            pj(true);
            pi(true);
            clL();
            return;
        }
        this.rightMargin = this.tbds150;
        this.iCl.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.iCl;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.iut = aVar;
    }

    private void clL() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iCl.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iCl.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.ln().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.iCl.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.iCl.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.iCl.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.iCl.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.iCk) {
            TiebaStatic.log(new ap(CommonStatisticKey.SEARCH_BAR_CLICK).ah("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.iCl) {
            Object tag = this.iCl.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    clM();
                    if (this.iut != null) {
                        this.iut.GM(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iCm.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iCm != null) {
            this.iCm.setShowConcernRedTip(z);
        }
    }

    public boolean clT() {
        if (this.iCm != null) {
            return this.iCm.clT();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.iCm != null) {
            this.iCm.setShowHotTopicRedTip(z);
        }
    }

    public boolean clU() {
        if (this.iCm != null) {
            return this.iCm.clU();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iCm.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.iCm.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.iCm.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.baR().a(this.iCk, R.drawable.icon_pure_topbar_search44_svg, this.iCp, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iCm.onChangeSkinType();
            ao.setBackgroundResource(this.iCo, R.drawable.home_page_tab_shadow);
        }
    }

    public View xs(int i) {
        return this.iCm.xs(i);
    }

    public void onResume() {
        SvgManager.baR().a(this.iCk, R.drawable.icon_pure_topbar_search44_svg, this.iCp, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.iCm.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.iCm.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.iCm.setOnTabItemClickListener(aVar);
    }

    public void ak(float f) {
        if (f <= 1.0f && f >= 0.0f && this.iCk != null && this.iCn != null && this.iCm != null && this.iCn.getAlpha() != f) {
            this.iCn.setAlpha(f);
            if (f == 1.0f) {
                this.iCk.setAlpha(1.0f);
                this.iCk.setClickable(true);
                if (this.iCl != null) {
                    this.iCl.setAlpha(1.0f);
                    this.iCl.setClickable(true);
                }
                pj(true);
                pi(true);
                return;
            }
            this.iCk.setAlpha(0.0f);
            this.iCk.setClickable(false);
            if (this.iCl != null) {
                this.iCl.setAlpha(0.0f);
                this.iCl.setClickable(false);
            }
            pj(false);
            pi(false);
        }
    }

    private void pi(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCo.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iCo.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iCo.setLayoutParams(layoutParams);
            }
        }
    }

    private void pj(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCm.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iCm.setLayoutParams(layoutParams);
                    this.iCm.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View xs = HomeTabBarView.this.iCm.xs(HomeTabBarView.this.iCm.getCurrentTabIndex());
                            if (xs != null && xs.getRight() > HomeTabBarView.this.iCm.getRight()) {
                                HomeTabBarView.this.iCm.scrollTo(xs.getWidth() + HomeTabBarView.this.iCm.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iCm.setLayoutParams(layoutParams);
            }
        }
    }

    private void clM() {
        ap apVar = new ap("c13422");
        apVar.ah("obj_type", 2);
        apVar.ah("obj_locate", 1);
        apVar.ah("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        apVar.dn("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(apVar);
    }

    public void cmj() {
        ap apVar = new ap("c13422");
        apVar.ah("obj_type", 1);
        apVar.ah("obj_locate", 1);
        apVar.ah("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        apVar.dn("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(apVar);
    }
}
