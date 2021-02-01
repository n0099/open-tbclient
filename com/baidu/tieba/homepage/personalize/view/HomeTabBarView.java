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
    private ImageView geQ;
    private NestedScrollHeader.a kdk;
    private View kmA;
    private int kmB;
    private TbImageView kmx;
    private PagerSlidingTabStrip kmy;
    private LinearLayout kmz;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.kmB = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.kmB = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.kmB = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.geQ = (ImageView) findViewById(R.id.home_page_search_icon);
        this.geQ.setClickable(false);
        this.kmy = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.kmy.c(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.kmy.setExpandedTabLayoutParams(layoutParams);
        this.kmz = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.kmA = findViewById(R.id.home_page_shadow);
        this.kmx = (TbImageView) findViewById(R.id.home_page_get_money);
        this.kmx.setClickable(false);
        this.geQ.setOnClickListener(this);
        this.kmx.setOnClickListener(this);
        setOnClickListener(this);
        aN(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.kmx.setVisibility(0);
            this.rightMargin = this.tbds264;
            sr(true);
            sq(true);
            cPt();
            return;
        }
        this.rightMargin = this.tbds150;
        this.kmx.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.kmx;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.kdk = aVar;
    }

    private void cPt() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.kmx.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.kmx.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.d.mw().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.kmx.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.kmx.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.kmx.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.kmx.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.geQ) {
            TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).ap("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.kmx) {
            Object tag = this.kmx.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cPu();
                    if (this.kdk != null) {
                        this.kdk.LT(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kmy.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kmy != null) {
            this.kmy.setShowConcernRedTip(z);
        }
    }

    public boolean cPG() {
        if (this.kmy != null) {
            return this.kmy.cPG();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.kmy != null) {
            this.kmy.setShowHotTopicRedTip(z);
        }
    }

    public boolean cPH() {
        if (this.kmy != null) {
            return this.kmy.cPH();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kmy.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.kmy.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.kmy.notifyDataSetChanged();
    }

    public void cRR() {
        this.kmy.Mk();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.a(this, R.color.CAM_X0208, this.alpha, this.mSkinType);
            this.geQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.kmB), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.kmy.onChangeSkinType();
            ap.setBackgroundResource(this.kmA, R.drawable.home_page_tab_shadow);
        }
    }

    public View BJ(int i) {
        return this.kmy.BJ(i);
    }

    public void onResume() {
        this.geQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.kmB), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.kmy.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.kmy.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.kmy.setOnTabItemClickListener(aVar);
    }

    public void aN(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.alpha = f;
            ap.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.geQ != null && this.kmz != null && this.kmy != null && this.kmA != null && this.kmz.getAlpha() != f) {
                this.kmz.setAlpha(f);
                this.kmA.setAlpha(f);
                if (f == 1.0f) {
                    this.geQ.setClickable(true);
                    if (this.kmx != null) {
                        this.kmx.setClickable(true);
                    }
                    sr(true);
                    sq(true);
                    return;
                }
                this.geQ.setClickable(false);
                if (this.kmx != null) {
                    this.kmx.setClickable(false);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kmA.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.kmA.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kmA.setLayoutParams(layoutParams);
            }
        }
    }

    private void sr(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kmy.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.kmy.setLayoutParams(layoutParams);
                    this.kmy.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View BJ = HomeTabBarView.this.kmy.BJ(HomeTabBarView.this.kmy.getCurrentTabIndex());
                            if (BJ != null && BJ.getRight() > HomeTabBarView.this.kmy.getRight()) {
                                HomeTabBarView.this.kmy.scrollTo(BJ.getWidth() + HomeTabBarView.this.kmy.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.kmy.setLayoutParams(layoutParams);
            }
        }
    }

    private void cPu() {
        ar arVar = new ar("c13422");
        arVar.ap("obj_type", 2);
        arVar.ap("obj_locate", 1);
        arVar.ap("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void cPX() {
        ar arVar = new ar("c13422");
        arVar.ap("obj_type", 1);
        arVar.ap("obj_locate", 1);
        arVar.ap("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
