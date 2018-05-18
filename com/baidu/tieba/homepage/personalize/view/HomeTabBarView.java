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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView dGP;
    private PagerSlidingTabStrip dGQ;
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
        this.dGP = (ImageView) findViewById(d.g.home_page_search_icon);
        this.dGQ = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.dGQ.d(l.e(context, d.e.ds34), l.e(context, d.e.ds4), false);
        this.dGP.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dGP) {
            TiebaStatic.log(new al("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dGQ.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dGQ != null) {
            this.dGQ.setShowConcernRedTip(z);
        }
    }

    public boolean axz() {
        if (this.dGQ != null) {
            return this.dGQ.axz();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dGQ.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.dGQ.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.dGQ.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ak.j(this, d.C0126d.cp_bg_line_d);
            ao.vO().c(this.dGP, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            this.dGQ.onChangeSkinType();
        }
    }
}
