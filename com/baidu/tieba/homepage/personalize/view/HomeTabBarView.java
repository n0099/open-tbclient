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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private float aZx;
    private int fUn;
    private ImageView gcB;
    private NestedScrollHeader.a jVJ;
    private TbImageView keo;
    private PagerSlidingTabStrip kep;
    private LinearLayout keq;
    private View ker;
    private int kes;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fUn = 0;
        this.kes = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fUn = 0;
        this.kes = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fUn = 0;
        this.kes = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.fUn = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.gcB = (ImageView) findViewById(R.id.home_page_search_icon);
        this.gcB.setClickable(false);
        this.kep = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.kep.c(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.kep.setExpandedTabLayoutParams(layoutParams);
        this.keq = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.ker = findViewById(R.id.home_page_shadow);
        this.keo = (TbImageView) findViewById(R.id.home_page_get_money);
        this.keo.setClickable(false);
        this.gcB.setOnClickListener(this);
        this.keo.setOnClickListener(this);
        setOnClickListener(this);
        aK(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.keo.setVisibility(0);
            this.fUn = this.tbds264;
            se(true);
            sd(true);
            cNx();
            return;
        }
        this.fUn = this.tbds150;
        this.keo.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.keo;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.jVJ = aVar;
    }

    private void cNx() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.keo.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.keo.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.d.mx().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.keo.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.keo.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.keo.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.keo.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.gcB) {
            TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).an("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.keo) {
            Object tag = this.keo.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cNy();
                    if (this.jVJ != null) {
                        this.jVJ.Li(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kep.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kep != null) {
            this.kep.setShowConcernRedTip(z);
        }
    }

    public boolean cNJ() {
        if (this.kep != null) {
            return this.kep.cNJ();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.kep != null) {
            this.kep.setShowHotTopicRedTip(z);
        }
    }

    public boolean cNK() {
        if (this.kep != null) {
            return this.kep.cNK();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kep.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.kep.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.kep.notifyDataSetChanged();
    }

    public void cPS() {
        this.kep.KM();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.a(this, R.color.CAM_X0208, this.aZx, this.mSkinType);
            this.gcB.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(this.kes), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.kep.onChangeSkinType();
            ao.setBackgroundResource(this.ker, R.drawable.home_page_tab_shadow);
        }
    }

    public View Bu(int i) {
        return this.kep.Bu(i);
    }

    public void onResume() {
        this.gcB.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(this.kes), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.kep.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.kep.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.kep.setOnTabItemClickListener(aVar);
    }

    public void aK(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.aZx = f;
            ao.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.gcB != null && this.keq != null && this.kep != null && this.ker != null && this.keq.getAlpha() != f) {
                this.keq.setAlpha(f);
                this.ker.setAlpha(f);
                if (f == 1.0f) {
                    this.gcB.setClickable(true);
                    if (this.keo != null) {
                        this.keo.setClickable(true);
                    }
                    se(true);
                    sd(true);
                    return;
                }
                this.gcB.setClickable(false);
                if (this.keo != null) {
                    this.keo.setClickable(false);
                }
                se(false);
                sd(false);
            }
        }
    }

    public float getBackgroundAlpha() {
        return this.aZx;
    }

    private void sd(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ker.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.fUn) {
                    layoutParams.rightMargin = this.fUn;
                    this.ker.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.ker.setLayoutParams(layoutParams);
            }
        }
    }

    private void se(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kep.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.fUn) {
                    layoutParams.rightMargin = this.fUn;
                    this.kep.setLayoutParams(layoutParams);
                    this.kep.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View Bu = HomeTabBarView.this.kep.Bu(HomeTabBarView.this.kep.getCurrentTabIndex());
                            if (Bu != null && Bu.getRight() > HomeTabBarView.this.kep.getRight()) {
                                HomeTabBarView.this.kep.scrollTo(Bu.getWidth() + HomeTabBarView.this.kep.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kep.setLayoutParams(layoutParams);
            }
        }
    }

    private void cNy() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 2);
        aqVar.an("obj_locate", 1);
        aqVar.an("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dW("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void cOa() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 1);
        aqVar.an("obj_locate", 1);
        aqVar.an("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dW("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }
}
