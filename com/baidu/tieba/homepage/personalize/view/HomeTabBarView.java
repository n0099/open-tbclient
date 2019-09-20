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
    private NestedScrollHeader.a ghK;
    private ImageView gnV;
    private TbImageView gnW;
    private PagerSlidingTabStrip gnX;
    private LinearLayout gnY;
    private int gnZ;
    private View goa;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gnZ = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gnZ = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gnZ = 0;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.gnZ = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.gnV = (ImageView) findViewById(R.id.home_page_search_icon);
        this.gnV.setClickable(false);
        this.gnX = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.gnX.d(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds68), l.g(context, R.dimen.tbds32), true);
        this.gnY = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.goa = findViewById(R.id.home_page_shadow);
        this.gnW = (TbImageView) findViewById(R.id.home_page_get_money);
        this.gnW.setClickable(false);
        this.gnV.setOnClickListener(this);
        this.gnW.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && ao.iN()) {
            this.gnW.setVisibility(0);
            this.gnZ = this.tbds264;
            lA(true);
            lz(true);
            bww();
            return;
        }
        this.gnZ = this.tbds150;
        this.gnW.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.gnW;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.ghK = aVar;
    }

    private void bww() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.gnW.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.gnW.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.f.c.iE().a(missionEntranceIcon, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.nK() == null || aVar.nK().isRecycled()) {
                    HomeTabBarView.this.gnW.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.gnW.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.gnW.setImageBitmap(aVar.nK());
                HomeTabBarView.this.gnW.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.gnV) {
            TiebaStatic.log(new an("c10378").P("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.gnW) {
            Object tag = this.gnW.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bwx();
                    if (this.ghK != null) {
                        this.ghK.yD(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gnX.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gnX != null) {
            this.gnX.setShowConcernRedTip(z);
        }
    }

    public boolean bwE() {
        if (this.gnX != null) {
            return this.gnX.bwE();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.gnX.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.gnX.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.gnX.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_h);
            am.l(this.gnY, R.color.cp_bg_line_h);
            SvgManager.ajv().a(this.gnV, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.gnX.onChangeSkinType();
            am.k(this.goa, R.drawable.home_page_tab_shadow);
        }
    }

    public View tY(int i) {
        return this.gnX.tY(i);
    }

    public void onResume() {
        SvgManager.ajv().a(this.gnV, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setConcernTabIndex(int i) {
        this.gnX.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.gnX.setOnTabItemClickListener(aVar);
    }

    public void aG(float f) {
        if (f <= 1.0f && f >= 0.0f && this.gnV != null && this.gnY != null && this.gnX != null && this.gnY.getAlpha() != f) {
            this.gnY.setAlpha(f);
            if (f == 1.0f) {
                this.gnV.setAlpha(1.0f);
                this.gnV.setClickable(true);
                if (this.gnW != null) {
                    this.gnW.setAlpha(1.0f);
                    this.gnW.setClickable(true);
                }
                lA(true);
                lz(true);
                return;
            }
            this.gnV.setAlpha(0.0f);
            this.gnV.setClickable(false);
            if (this.gnW != null) {
                this.gnW.setAlpha(0.0f);
                this.gnW.setClickable(false);
            }
            lA(false);
            lz(false);
        }
    }

    private void lz(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goa.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.gnZ) {
                    layoutParams.rightMargin = this.gnZ;
                    this.goa.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.goa.setLayoutParams(layoutParams);
            }
        }
    }

    private void lA(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.gnZ) {
                    layoutParams.rightMargin = this.gnZ;
                    this.gnX.setLayoutParams(layoutParams);
                    this.gnX.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View tY = HomeTabBarView.this.gnX.tY(HomeTabBarView.this.gnX.getCurrentTabIndex());
                            if (tY != null && tY.getRight() > HomeTabBarView.this.gnX.getRight()) {
                                HomeTabBarView.this.gnX.scrollTo(tY.getWidth() + HomeTabBarView.this.gnX.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.gnX.setLayoutParams(layoutParams);
            }
        }
    }

    private void bwx() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 2);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bwQ() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 1);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
