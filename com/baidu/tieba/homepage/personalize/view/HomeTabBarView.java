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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes22.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private float bcD;
    private int fPr;
    private ImageView fXA;
    private NestedScrollHeader.a jMY;
    private TbImageView jVH;
    private PagerSlidingTabStrip jVI;
    private LinearLayout jVJ;
    private View jVK;
    private int jVL;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fPr = 0;
        this.jVL = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fPr = 0;
        this.jVL = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fPr = 0;
        this.jVL = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.fPr = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fXA = (ImageView) findViewById(R.id.home_page_search_icon);
        this.fXA.setClickable(false);
        this.jVI = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.jVI.b(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.jVI.setExpandedTabLayoutParams(layoutParams);
        this.jVJ = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.jVK = findViewById(R.id.home_page_shadow);
        this.jVH = (TbImageView) findViewById(R.id.home_page_get_money);
        this.jVH.setClickable(false);
        this.fXA.setOnClickListener(this);
        this.jVH.setOnClickListener(this);
        setOnClickListener(this);
        aI(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.jVH.setVisibility(0);
            this.fPr = this.tbds264;
            rL(true);
            rK(true);
            cOh();
            return;
        }
        this.fPr = this.tbds150;
        this.jVH.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.jVH;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.jMY = aVar;
    }

    private void cOh() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.jVH.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.jVH.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.jVH.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.jVH.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.jVH.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.jVH.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.fXA) {
            TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).al("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.jVH) {
            Object tag = this.jVH.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cOi();
                    if (this.jMY != null) {
                        this.jMY.Mr(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jVI.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jVI != null) {
            this.jVI.setShowConcernRedTip(z);
        }
    }

    public boolean cOt() {
        if (this.jVI != null) {
            return this.jVI.cOt();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.jVI != null) {
            this.jVI.setShowHotTopicRedTip(z);
        }
    }

    public boolean cOu() {
        if (this.jVI != null) {
            return this.jVI.cOu();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jVI.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.jVI.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.jVI.notifyDataSetChanged();
    }

    public void cQC() {
        this.jVI.bjF();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.a(this, R.color.CAM_X0208, this.bcD, this.mSkinType);
            this.fXA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.jVL), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jVI.onChangeSkinType();
            ap.setBackgroundResource(this.jVK, R.drawable.home_page_tab_shadow);
        }
    }

    public View CM(int i) {
        return this.jVI.CM(i);
    }

    public void onResume() {
        this.fXA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.jVL), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.jVI.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.jVI.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.jVI.setOnTabItemClickListener(aVar);
    }

    public void aI(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.bcD = f;
            ap.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.fXA != null && this.jVJ != null && this.jVI != null && this.jVK != null && this.jVJ.getAlpha() != f) {
                this.jVJ.setAlpha(f);
                this.jVK.setAlpha(f);
                if (f == 1.0f) {
                    this.fXA.setClickable(true);
                    if (this.jVH != null) {
                        this.jVH.setClickable(true);
                    }
                    rL(true);
                    rK(true);
                    return;
                }
                this.fXA.setClickable(false);
                if (this.jVH != null) {
                    this.jVH.setClickable(false);
                }
                rL(false);
                rK(false);
            }
        }
    }

    public float getBackgroundAlpha() {
        return this.bcD;
    }

    private void rK(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jVK.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.fPr) {
                    layoutParams.rightMargin = this.fPr;
                    this.jVK.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jVK.setLayoutParams(layoutParams);
            }
        }
    }

    private void rL(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jVI.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.fPr) {
                    layoutParams.rightMargin = this.fPr;
                    this.jVI.setLayoutParams(layoutParams);
                    this.jVI.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View CM = HomeTabBarView.this.jVI.CM(HomeTabBarView.this.jVI.getCurrentTabIndex());
                            if (CM != null && CM.getRight() > HomeTabBarView.this.jVI.getRight()) {
                                HomeTabBarView.this.jVI.scrollTo(CM.getWidth() + HomeTabBarView.this.jVI.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jVI.setLayoutParams(layoutParams);
            }
        }
    }

    private void cOi() {
        ar arVar = new ar("c13422");
        arVar.al("obj_type", 2);
        arVar.al("obj_locate", 1);
        arVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dY("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void cOK() {
        ar arVar = new ar("c13422");
        arVar.al("obj_type", 1);
        arVar.al("obj_locate", 1);
        arVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dY("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
