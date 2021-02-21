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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private float alpha;
    private ImageView geV;
    private NestedScrollHeader.a kdy;
    private TbImageView kmL;
    private PagerSlidingTabStrip kmM;
    private LinearLayout kmN;
    private View kmO;
    private int kmP;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.kmP = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.kmP = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.kmP = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.geV = (ImageView) findViewById(R.id.home_page_search_icon);
        this.geV.setClickable(false);
        this.kmM = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.kmM.c(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.kmM.setExpandedTabLayoutParams(layoutParams);
        this.kmN = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.kmO = findViewById(R.id.home_page_shadow);
        this.kmL = (TbImageView) findViewById(R.id.home_page_get_money);
        this.kmL.setClickable(false);
        this.geV.setOnClickListener(this);
        this.kmL.setOnClickListener(this);
        setOnClickListener(this);
        aN(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.kmL.setVisibility(0);
            this.rightMargin = this.tbds264;
            sr(true);
            sq(true);
            cPA();
            return;
        }
        this.rightMargin = this.tbds150;
        this.kmL.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.kmL;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.kdy = aVar;
    }

    private void cPA() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.kmL.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.kmL.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.d.mw().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.kmL.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.kmL.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.kmL.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.kmL.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.geV) {
            TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).ap("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.kmL) {
            Object tag = this.kmL.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cPB();
                    if (this.kdy != null) {
                        this.kdy.LU(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kmM.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kmM != null) {
            this.kmM.setShowConcernRedTip(z);
        }
    }

    public boolean cPN() {
        if (this.kmM != null) {
            return this.kmM.cPN();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.kmM != null) {
            this.kmM.setShowHotTopicRedTip(z);
        }
    }

    public boolean cPO() {
        if (this.kmM != null) {
            return this.kmM.cPO();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kmM.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.kmM.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.kmM.notifyDataSetChanged();
    }

    public void cRY() {
        this.kmM.Mk();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.a(this, R.color.CAM_X0208, this.alpha, this.mSkinType);
            this.geV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.kmP), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.kmM.onChangeSkinType();
            ap.setBackgroundResource(this.kmO, R.drawable.home_page_tab_shadow);
        }
    }

    public View BJ(int i) {
        return this.kmM.BJ(i);
    }

    public void onResume() {
        this.geV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.kmP), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.kmM.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.kmM.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.kmM.setOnTabItemClickListener(aVar);
    }

    public void aN(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.alpha = f;
            ap.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.geV != null && this.kmN != null && this.kmM != null && this.kmO != null && this.kmN.getAlpha() != f) {
                this.kmN.setAlpha(f);
                this.kmO.setAlpha(f);
                if (f == 1.0f) {
                    this.geV.setClickable(true);
                    if (this.kmL != null) {
                        this.kmL.setClickable(true);
                    }
                    sr(true);
                    sq(true);
                    return;
                }
                this.geV.setClickable(false);
                if (this.kmL != null) {
                    this.kmL.setClickable(false);
                }
                sr(false);
                sq(false);
            }
        }
    }

    public float getBackgroundAlpha() {
        return this.alpha;
    }

    private void sq(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kmO.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.kmO.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kmO.setLayoutParams(layoutParams);
            }
        }
    }

    private void sr(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kmM.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.kmM.setLayoutParams(layoutParams);
                    this.kmM.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View BJ = HomeTabBarView.this.kmM.BJ(HomeTabBarView.this.kmM.getCurrentTabIndex());
                            if (BJ != null && BJ.getRight() > HomeTabBarView.this.kmM.getRight()) {
                                HomeTabBarView.this.kmM.scrollTo(BJ.getWidth() + HomeTabBarView.this.kmM.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kmM.setLayoutParams(layoutParams);
            }
        }
    }

    private void cPB() {
        ar arVar = new ar("c13422");
        arVar.ap("obj_type", 2);
        arVar.ap("obj_locate", 1);
        arVar.ap("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void cQe() {
        ar arVar = new ar("c13422");
        arVar.ap("obj_type", 1);
        arVar.ap("obj_locate", 1);
        arVar.ap("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
