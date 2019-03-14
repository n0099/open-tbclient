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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private PagerSlidingTabStrip fOc;
    private ImageView fpp;
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
        LayoutInflater.from(context).inflate(d.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.fpp = (ImageView) findViewById(d.g.home_page_search_icon);
        this.fOc = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.fOc.d(l.h(context, d.e.tbds44), l.h(context, d.e.tbds68), l.h(context, d.e.tbds32), true);
        this.fpp.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fpp) {
            TiebaStatic.log(new am("c10378").T("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fOc.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.fOc != null) {
            this.fOc.setShowConcernRedTip(z);
        }
    }

    public boolean bmc() {
        if (this.fOc != null) {
            return this.fOc.bmc();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fOc.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.fOc.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.fOc.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_d);
            aq.ado().d(this.fpp, d.f.icon_common_top_search, d.C0277d.select_topbar_icon_color_tint);
            this.fOc.onChangeSkinType();
        }
    }

    public View sx(int i) {
        return this.fOc.sx(i);
    }

    public void onResume() {
        aq.ado().d(this.fpp, d.f.icon_common_top_search, d.C0277d.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.fOc.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.fOc.setOnTabItemClickListener(aVar);
    }
}
