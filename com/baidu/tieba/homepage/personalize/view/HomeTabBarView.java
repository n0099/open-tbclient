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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.t.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private NestedScrollHeader.a gfT;
    private ImageView gme;
    private TbImageView gmf;
    private PagerSlidingTabStrip gmg;
    private LinearLayout gmh;
    private int gmi;
    private View gmj;
    private int mSkinType;
    private int tbds150;
    private int tbds264;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gmi = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gmi = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gmi = 0;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.tbds264 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.gmi = this.tbds150;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.gme = (ImageView) findViewById(R.id.home_page_search_icon);
        this.gme.setClickable(false);
        this.gmg = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.gmg.d(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds68), l.g(context, R.dimen.tbds32), true);
        this.gmh = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.gmj = findViewById(R.id.home_page_shadow);
        this.gmf = (TbImageView) findViewById(R.id.home_page_get_money);
        this.gmf.setClickable(false);
        this.gme.setOnClickListener(this);
        this.gmf.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z && ao.iN()) {
            this.gmf.setVisibility(0);
            this.gmi = this.tbds264;
            lx(true);
            lw(true);
            bvI();
            return;
        }
        this.gmi = this.tbds150;
        this.gmf.setVisibility(8);
    }

    public ImageView getTaskView() {
        return this.gmf;
    }

    public void setEntranceJumpListener(NestedScrollHeader.a aVar) {
        this.gfT = aVar;
    }

    private void bvI() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.gmf.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.gmf.setImageResource(R.drawable.icon_use_gold_n);
            return;
        }
        com.baidu.adp.lib.f.c.iE().a(missionEntranceIcon, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.nK() == null || aVar.nK().isRecycled()) {
                    HomeTabBarView.this.gmf.setImageResource(R.drawable.icon_use_gold_n);
                    HomeTabBarView.this.gmf.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                HomeTabBarView.this.gmf.setImageBitmap(aVar.nK());
                HomeTabBarView.this.gmf.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        if (view == this.gme) {
            TiebaStatic.log(new an("c10378").P("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.gmf) {
            Object tag = this.gmf.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    bvJ();
                    if (this.gfT != null) {
                        this.gfT.ye(str);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gmg.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gmg != null) {
            this.gmg.setShowConcernRedTip(z);
        }
    }

    public boolean bvQ() {
        if (this.gmg != null) {
            return this.gmg.bvQ();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.gmg.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.gmg.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.gmg.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_d);
            am.l(this.gmh, R.color.cp_bg_line_d);
            ar.ajp().d(this.gme, R.drawable.icon_common_top_search, R.color.select_topbar_icon_color_tint);
            this.gmg.onChangeSkinType();
            am.k(this.gmj, R.drawable.home_page_tab_shadow);
        }
    }

    public View tU(int i) {
        return this.gmg.tU(i);
    }

    public void onResume() {
        ar.ajp().d(this.gme, R.drawable.icon_common_top_search, R.color.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.gmg.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.gmg.setOnTabItemClickListener(aVar);
    }

    public void aF(float f) {
        if (f <= 1.0f && f >= 0.0f && this.gme != null && this.gmh != null && this.gmg != null && this.gmh.getAlpha() != f) {
            this.gmh.setAlpha(f);
            if (f == 1.0f) {
                this.gme.setAlpha(1.0f);
                this.gme.setClickable(true);
                if (this.gmf != null) {
                    this.gmf.setAlpha(1.0f);
                    this.gmf.setClickable(true);
                }
                lx(true);
                lw(true);
                return;
            }
            this.gme.setAlpha(0.0f);
            this.gme.setClickable(false);
            if (this.gmf != null) {
                this.gmf.setAlpha(0.0f);
                this.gmf.setClickable(false);
            }
            lx(false);
            lw(false);
        }
    }

    private void lw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmj.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.gmi) {
                    layoutParams.rightMargin = this.gmi;
                    this.gmj.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.gmj.setLayoutParams(layoutParams);
            }
        }
    }

    private void lx(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmg.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.gmi) {
                    layoutParams.rightMargin = this.gmi;
                    this.gmg.setLayoutParams(layoutParams);
                    this.gmg.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            View tU = HomeTabBarView.this.gmg.tU(HomeTabBarView.this.gmg.getCurrentTabIndex());
                            if (tU != null && tU.getRight() > HomeTabBarView.this.gmg.getRight()) {
                                HomeTabBarView.this.gmg.scrollTo(tU.getWidth() + HomeTabBarView.this.gmg.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.gmg.setLayoutParams(layoutParams);
            }
        }
    }

    private void bvJ() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 2);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void bwc() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 1);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
