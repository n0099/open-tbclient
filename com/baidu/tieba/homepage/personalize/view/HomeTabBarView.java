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
    private ImageView ggy;
    private NestedScrollHeader.a kfB;
    private TbImageView koN;
    private PagerSlidingTabStrip koO;
    private LinearLayout koP;
    private View koQ;
    private int koR;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.koR = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.koR = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.koR = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.ggy = (ImageView) findViewById(R.id.home_page_search_icon);
        this.ggy.setClickable(false);
        this.koO = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.koO.c(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.koO.setExpandedTabLayoutParams(layoutParams);
        this.koP = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.koQ = findViewById(R.id.home_page_shadow);
        this.koN = (TbImageView) findViewById(R.id.home_page_get_money);
        this.koN.setClickable(false);
        this.ggy.setOnClickListener(this);
        this.koN.setOnClickListener(this);
        setOnClickListener(this);
        aR(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.koN.setVisibility(0);
            this.rightMargin = this.tbds264;
            sr(true);
            sq(true);
            cPH();
            return;
        }
        this.rightMargin = this.tbds150;
        this.koN.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.koN;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.kfB = aVar;
    }

    private void cPH() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.koN.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.koN.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.d.mw().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.koN.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.koN.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.koN.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.koN.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.ggy) {
            TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).aq("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.koN) {
            Object tag = this.koN.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cPI();
                    if (this.kfB != null) {
                        this.kfB.Ma(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.koO.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.koO != null) {
            this.koO.setShowConcernRedTip(z);
        }
    }

    public boolean cPU() {
        if (this.koO != null) {
            return this.koO.cPU();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.koO != null) {
            this.koO.setShowHotTopicRedTip(z);
        }
    }

    public boolean cPV() {
        if (this.koO != null) {
            return this.koO.cPV();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.koO.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.koO.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.koO.notifyDataSetChanged();
    }

    public void cSf() {
        this.koO.Mn();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.a(this, R.color.CAM_X0208, this.alpha, this.mSkinType);
            this.ggy.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.koR), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.koO.onChangeSkinType();
            ap.setBackgroundResource(this.koQ, R.drawable.home_page_tab_shadow);
        }
    }

    public View BM(int i) {
        return this.koO.BM(i);
    }

    public void onResume() {
        this.ggy.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.koR), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.koO.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.koO.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.koO.setOnTabItemClickListener(aVar);
    }

    public void aR(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.alpha = f;
            ap.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.ggy != null && this.koP != null && this.koO != null && this.koQ != null && this.koP.getAlpha() != f) {
                this.koP.setAlpha(f);
                this.koQ.setAlpha(f);
                if (f == 1.0f) {
                    this.ggy.setClickable(true);
                    if (this.koN != null) {
                        this.koN.setClickable(true);
                    }
                    sr(true);
                    sq(true);
                    return;
                }
                this.ggy.setClickable(false);
                if (this.koN != null) {
                    this.koN.setClickable(false);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.koQ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.koQ.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.koQ.setLayoutParams(layoutParams);
            }
        }
    }

    private void sr(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.koO.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.koO.setLayoutParams(layoutParams);
                    this.koO.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View BM = HomeTabBarView.this.koO.BM(HomeTabBarView.this.koO.getCurrentTabIndex());
                            if (BM != null && BM.getRight() > HomeTabBarView.this.koO.getRight()) {
                                HomeTabBarView.this.koO.scrollTo(BM.getWidth() + HomeTabBarView.this.koO.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.koO.setLayoutParams(layoutParams);
            }
        }
    }

    private void cPI() {
        ar arVar = new ar("c13422");
        arVar.aq("obj_type", 2);
        arVar.aq("obj_locate", 1);
        arVar.aq("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void cQl() {
        ar arVar = new ar("c13422");
        arVar.aq("obj_type", 1);
        arVar.aq("obj_locate", 1);
        arVar.aq("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
