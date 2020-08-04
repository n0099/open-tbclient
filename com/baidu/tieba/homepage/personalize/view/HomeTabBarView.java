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
    private ImageView iCm;
    private TbImageView iCn;
    private PagerSlidingTabStrip iCo;
    private LinearLayout iCp;
    private View iCq;
    private int iCr;
    private NestedScrollHeader.a iuv;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iCr = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iCr = R.color.cp_cont_b;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.iCr = R.color.cp_cont_b;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.iCm = (ImageView) findViewById(R.id.home_page_search_icon);
        this.iCm.setClickable(false);
        this.iCo = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.iCo.b(l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds46), l.getDimens(context, R.dimen.tbds10), true);
        this.iCo.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds170), -1));
        this.iCp = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.iCq = findViewById(R.id.home_page_shadow);
        this.iCn = (TbImageView) findViewById(R.id.home_page_get_money);
        this.iCn.setClickable(false);
        this.iCm.setOnClickListener(this);
        this.iCn.setOnClickListener(this);
        setOnClickListener(this);
        if (com.baidu.tbadk.a.d.aRN()) {
            this.iCm.setVisibility(8);
        } else {
            ak(0.0f);
        }
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.iCn.setVisibility(0);
            this.rightMargin = this.tbds264;
            pj(true);
            pi(true);
            clL();
            return;
        }
        this.rightMargin = this.tbds150;
        this.iCn.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.iCn;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.iuv = aVar;
    }

    private void clL() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.iCn.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.iCn.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.ln().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.iCn.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.iCn.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.iCn.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.iCn.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.iCm) {
            TiebaStatic.log(new ap(CommonStatisticKey.SEARCH_BAR_CLICK).ah("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.iCn) {
            Object tag = this.iCn.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    clM();
                    if (this.iuv != null) {
                        this.iuv.GM(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iCo.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iCo != null) {
            this.iCo.setShowConcernRedTip(z);
        }
    }

    public boolean clT() {
        if (this.iCo != null) {
            return this.iCo.clT();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.iCo != null) {
            this.iCo.setShowHotTopicRedTip(z);
        }
    }

    public boolean clU() {
        if (this.iCo != null) {
            return this.iCo.clU();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iCo.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.iCo.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.iCo.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            SvgManager.baR().a(this.iCm, R.drawable.icon_pure_topbar_search44_svg, this.iCr, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iCo.onChangeSkinType();
            ao.setBackgroundResource(this.iCq, R.drawable.home_page_tab_shadow);
        }
    }

    public View xs(int i) {
        return this.iCo.xs(i);
    }

    public void onResume() {
        SvgManager.baR().a(this.iCm, R.drawable.icon_pure_topbar_search44_svg, this.iCr, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.iCo.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.iCo.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.iCo.setOnTabItemClickListener(aVar);
    }

    public void ak(float f) {
        if (f <= 1.0f && f >= 0.0f && this.iCm != null && this.iCp != null && this.iCo != null && this.iCp.getAlpha() != f) {
            this.iCp.setAlpha(f);
            if (f == 1.0f) {
                this.iCm.setAlpha(1.0f);
                this.iCm.setClickable(true);
                if (this.iCn != null) {
                    this.iCn.setAlpha(1.0f);
                    this.iCn.setClickable(true);
                }
                pj(true);
                pi(true);
                return;
            }
            this.iCm.setAlpha(0.0f);
            this.iCm.setClickable(false);
            if (this.iCn != null) {
                this.iCn.setAlpha(0.0f);
                this.iCn.setClickable(false);
            }
            pj(false);
            pi(false);
        }
    }

    private void pi(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCq.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iCq.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iCq.setLayoutParams(layoutParams);
            }
        }
    }

    private void pj(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCo.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.iCo.setLayoutParams(layoutParams);
                    this.iCo.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View xs = HomeTabBarView.this.iCo.xs(HomeTabBarView.this.iCo.getCurrentTabIndex());
                            if (xs != null && xs.getRight() > HomeTabBarView.this.iCo.getRight()) {
                                HomeTabBarView.this.iCo.scrollTo(xs.getWidth() + HomeTabBarView.this.iCo.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.iCo.setLayoutParams(layoutParams);
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
