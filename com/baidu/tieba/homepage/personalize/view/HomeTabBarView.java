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
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView dBT;
    private PagerSlidingTabStrip dZO;
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
        LayoutInflater.from(context).inflate(f.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.dBT = (ImageView) findViewById(f.g.home_page_search_icon);
        this.dZO = (PagerSlidingTabStrip) findViewById(f.g.home_page_tabstrip);
        this.dZO.d(l.f(context, f.e.ds34), l.f(context, f.e.ds4), false);
        this.dBT.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dBT) {
            TiebaStatic.log(new an("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZO.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dZO != null) {
            this.dZO.setShowConcernRedTip(z);
        }
    }

    public boolean aDT() {
        if (this.dZO != null) {
            return this.dZO.aDT();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dZO.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.dZO.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.dZO.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.j(this, f.d.cp_bg_line_d);
            aq.zt().c(this.dBT, f.C0146f.icon_topbar_search_n_svg, f.d.select_topbar_icon_color_tint);
            this.dZO.onChangeSkinType();
        }
    }

    public View mM(int i) {
        return this.dZO.mM(i);
    }

    public void onResume() {
        aq.zt().c(this.dBT, f.C0146f.icon_topbar_search_n_svg, f.d.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.dZO.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.dZO.setOnTabItemClickListener(aVar);
    }
}
