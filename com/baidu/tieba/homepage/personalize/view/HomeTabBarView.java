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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView dIJ;
    private PagerSlidingTabStrip ehk;
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
        LayoutInflater.from(context).inflate(e.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.dIJ = (ImageView) findViewById(e.g.home_page_search_icon);
        this.ehk = (PagerSlidingTabStrip) findViewById(e.g.home_page_tabstrip);
        this.ehk.d(l.h(context, e.C0141e.ds34), l.h(context, e.C0141e.ds4), false);
        this.dIJ.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dIJ) {
            TiebaStatic.log(new am("c10378").w("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ehk.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ehk != null) {
            this.ehk.setShowConcernRedTip(z);
        }
    }

    public boolean aGg() {
        if (this.ehk != null) {
            return this.ehk.aGg();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ehk.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.ehk.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.ehk.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.cp_bg_line_d);
            ap.Ay().c(this.dIJ, e.f.icon_topbar_search_n_svg, e.d.select_topbar_icon_color_tint);
            this.ehk.onChangeSkinType();
        }
    }

    public View nq(int i) {
        return this.ehk.nq(i);
    }

    public void onResume() {
        ap.Ay().c(this.dIJ, e.f.icon_topbar_search_n_svg, e.d.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.ehk.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.ehk.setOnTabItemClickListener(aVar);
    }
}
