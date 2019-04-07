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
    private PagerSlidingTabStrip fNQ;
    private ImageView fpb;
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
        this.fpb = (ImageView) findViewById(d.g.home_page_search_icon);
        this.fNQ = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.fNQ.d(l.h(context, d.e.tbds44), l.h(context, d.e.tbds68), l.h(context, d.e.tbds32), true);
        this.fpb.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fpb) {
            TiebaStatic.log(new am("c10378").T("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fNQ.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.fNQ != null) {
            this.fNQ.setShowConcernRedTip(z);
        }
    }

    public boolean blZ() {
        if (this.fNQ != null) {
            return this.fNQ.blZ();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fNQ.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.fNQ.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.fNQ.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_d);
            aq.adl().d(this.fpb, d.f.icon_common_top_search, d.C0277d.select_topbar_icon_color_tint);
            this.fNQ.onChangeSkinType();
        }
    }

    public View st(int i) {
        return this.fNQ.st(i);
    }

    public void onResume() {
        aq.adl().d(this.fpb, d.f.icon_common_top_search, d.C0277d.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.fNQ.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.fNQ.setOnTabItemClickListener(aVar);
    }
}
