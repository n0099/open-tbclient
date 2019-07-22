package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView glo;
    private PagerSlidingTabStrip glp;
    private FrameLayout glq;
    private View glr;
    private int mSkinType;
    private int tbds150;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.tbds150 = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.tbds150 = 0;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.tbds150 = 0;
        init(context);
    }

    private void init(Context context) {
        this.tbds150 = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.glo = (ImageView) findViewById(R.id.home_page_search_icon);
        this.glo.setClickable(false);
        this.glp = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.glp.d(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds68), l.g(context, R.dimen.tbds32), true);
        this.glq = (FrameLayout) findViewById(R.id.home_page_search_icon_layout);
        this.glr = findViewById(R.id.home_page_shadow);
        this.glo.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.glo) {
            TiebaStatic.log(new an("c10378").P("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.glp.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.glp != null) {
            this.glp.setShowConcernRedTip(z);
        }
    }

    public boolean bvD() {
        if (this.glp != null) {
            return this.glp.bvD();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.glp.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.glp.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.glp.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_d);
            am.l(this.glq, R.color.cp_bg_line_d);
            ar.ajn().d(this.glo, R.drawable.icon_common_top_search, R.color.select_topbar_icon_color_tint);
            this.glp.onChangeSkinType();
            am.k(this.glr, R.drawable.home_page_tab_shadow);
        }
    }

    public View tS(int i) {
        return this.glp.tS(i);
    }

    public void onResume() {
        ar.ajn().d(this.glo, R.drawable.icon_common_top_search, R.color.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.glp.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.glp.setOnTabItemClickListener(aVar);
    }

    public void aF(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            if ((this.glo != null || this.glq != null || this.glp != null) && this.glq.getAlpha() != f) {
                this.glq.setAlpha(f);
                if (f == 1.0f) {
                    this.glo.setAlpha(1.0f);
                    this.glo.setClickable(true);
                    lx(true);
                    lw(true);
                    return;
                }
                this.glo.setAlpha(0.0f);
                this.glo.setClickable(false);
                lx(false);
                lw(false);
            }
        }
    }

    private void lw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glr.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.tbds150) {
                    layoutParams.rightMargin = this.tbds150;
                    this.glr.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.glr.setLayoutParams(layoutParams);
            }
        }
    }

    private void lx(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glp.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                if (layoutParams.rightMargin != this.tbds150) {
                    layoutParams.rightMargin = this.tbds150;
                    this.glp.setLayoutParams(layoutParams);
                    this.glp.post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View tS = HomeTabBarView.this.glp.tS(HomeTabBarView.this.glp.getCurrentTabIndex());
                            if (tS != null && tS.getRight() > HomeTabBarView.this.glp.getRight()) {
                                HomeTabBarView.this.glp.scrollTo(tS.getWidth() + HomeTabBarView.this.glp.getScrollX(), 0);
                            }
                        }
                    });
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.glp.setLayoutParams(layoutParams);
            }
        }
    }
}
