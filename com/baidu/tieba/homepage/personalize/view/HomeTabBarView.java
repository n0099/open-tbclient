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
/* loaded from: classes21.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private float alpha;
    private ImageView fPr;
    private TbImageView jIe;
    private PagerSlidingTabStrip jIf;
    private LinearLayout jIg;
    private View jIh;
    private int jIi;
    private NestedScrollHeader.a jzw;
    private int mSkinType;
    private int rightMargin;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jIi = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jIi = R.color.CAM_X0105;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.rightMargin = 0;
        this.jIi = R.color.CAM_X0105;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.rightMargin = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fPr = (ImageView) findViewById(R.id.home_page_search_icon);
        this.fPr.setClickable(false);
        this.jIf = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.jIf.b(l.getDimens(context, R.dimen.T_X06), l.getDimens(context, R.dimen.T_X04), l.getDimens(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.jIf.setExpandedTabLayoutParams(layoutParams);
        this.jIg = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.jIh = findViewById(R.id.home_page_shadow);
        this.jIe = (TbImageView) findViewById(R.id.home_page_get_money);
        this.jIe.setClickable(false);
        this.fPr.setOnClickListener(this);
        this.jIe.setOnClickListener(this);
        setOnClickListener(this);
        aH(0.0f);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.jIe.setVisibility(0);
            this.rightMargin = this.tbds264;
            rj(true);
            ri(true);
            cIS();
            return;
        }
        this.rightMargin = this.tbds150;
        this.jIe.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.jIe;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.jzw = aVar;
    }

    private void cIS() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.jIe.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.jIe.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.e.c.mS().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    HomeTabBarView.this.jIe.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.jIe.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.jIe.setImageBitmap(aVar.getRawBitmap());
                HomeTabBarView.this.jIe.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.fPr) {
            TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).ak("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.jIe) {
            Object tag = this.jIe.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    cIT();
                    if (this.jzw != null) {
                        this.jzw.Lk(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jIf.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jIf != null) {
            this.jIf.setShowConcernRedTip(z);
        }
    }

    public boolean cJe() {
        if (this.jIf != null) {
            return this.jIf.cJe();
        }
        return false;
    }

    public void setShowHotTopicRedTip(boolean z) {
        if (this.jIf != null) {
            this.jIf.setShowHotTopicRedTip(z);
        }
    }

    public boolean cJf() {
        if (this.jIf != null) {
            return this.jIf.cJf();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jIf.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.jIf.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.jIf.notifyDataSetChanged();
    }

    public void cLo() {
        this.jIf.bgA();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.a(this, R.color.CAM_X0208, this.alpha, this.mSkinType);
            this.fPr.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.jIi), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jIf.onChangeSkinType();
            ap.setBackgroundResource(this.jIh, R.drawable.home_page_tab_shadow);
        }
    }

    public View BX(int i) {
        return this.jIf.BX(i);
    }

    public void onResume() {
        this.fPr.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(this.jIi), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setConcernTabIndex(int i) {
        this.jIf.setConcernTabIndex(i);
    }

    public void setHotTopicTabIndex(int i) {
        this.jIf.setHotTopicIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.jIf.setOnTabItemClickListener(aVar);
    }

    public void aH(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.alpha = f;
            ap.a(this, R.color.CAM_X0208, f, this.mSkinType);
            if (this.fPr != null && this.jIg != null && this.jIf != null && this.jIh != null && this.jIg.getAlpha() != f) {
                this.jIg.setAlpha(f);
                this.jIh.setAlpha(f);
                if (f == 1.0f) {
                    this.fPr.setClickable(true);
                    if (this.jIe != null) {
                        this.jIe.setClickable(true);
                    }
                    rj(true);
                    ri(true);
                    return;
                }
                this.fPr.setClickable(false);
                if (this.jIe != null) {
                    this.jIe.setClickable(false);
                }
                rj(false);
                ri(false);
            }
        }
    }

    public float getBackgroundAlpha() {
        return this.alpha;
    }

    private void ri(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jIh.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jIh.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jIh.setLayoutParams(layoutParams);
            }
        }
    }

    private void rj(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jIf.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.rightMargin) {
                    layoutParams.rightMargin = this.rightMargin;
                    this.jIf.setLayoutParams(layoutParams);
                    this.jIf.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View BX = HomeTabBarView.this.jIf.BX(HomeTabBarView.this.jIf.getCurrentTabIndex());
                            if (BX != null && BX.getRight() > HomeTabBarView.this.jIf.getRight()) {
                                HomeTabBarView.this.jIf.scrollTo(BX.getWidth() + HomeTabBarView.this.jIf.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.jIf.setLayoutParams(layoutParams);
            }
        }
    }

    private void cIT() {
        ar arVar = new ar("c13422");
        arVar.ak("obj_type", 2);
        arVar.ak("obj_locate", 1);
        arVar.ak("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void cJv() {
        ar arVar = new ar("c13422");
        arVar.ak("obj_type", 1);
        arVar.ak("obj_locate", 1);
        arVar.ak("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }
}
