package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private PagerSlidingTabStrip dVZ;
    private ImageView dzk;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.dzk = (ImageView) findViewById(d.g.home_page_search_icon);
        this.dVZ = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.dVZ.d(l.e(context, d.e.ds34), l.e(context, d.e.ds4), false);
        this.dzk.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dzk) {
            TiebaStatic.log(new an("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dVZ.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dVZ != null) {
            this.dVZ.setShowConcernRedTip(z);
        }
    }

    public boolean aCY() {
        if (this.dVZ != null) {
            return this.dVZ.aCY();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dVZ.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.dVZ.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.dVZ.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.j(this, d.C0142d.cp_bg_line_d);
            aq.zE().c(this.dzk, d.f.icon_topbar_search_n_svg, d.C0142d.select_topbar_icon_color_tint);
            this.dVZ.onChangeSkinType();
        }
    }

    public View my(int i) {
        return this.dVZ.my(i);
    }

    public void onResume() {
        aq.zE().c(this.dzk, d.f.icon_topbar_search_n_svg, d.C0142d.select_topbar_icon_color_tint);
    }
}
