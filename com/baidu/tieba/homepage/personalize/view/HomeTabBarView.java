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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private PagerSlidingTabStrip dSf;
    private ImageView dwa;
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
        this.dwa = (ImageView) findViewById(d.g.home_page_search_icon);
        this.dSf = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.dSf.d(l.e(context, d.e.ds34), l.e(context, d.e.ds4), false);
        this.dwa.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dwa) {
            TiebaStatic.log(new am("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSf.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dSf != null) {
            this.dSf.setShowConcernRedTip(z);
        }
    }

    public boolean aCu() {
        if (this.dSf != null) {
            return this.dSf.aCu();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSf.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.dSf.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.dSf.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, d.C0141d.cp_bg_line_d);
            ap.zp().c(this.dwa, d.f.icon_topbar_search_n_svg, d.C0141d.select_topbar_icon_color_tint);
            this.dSf.onChangeSkinType();
        }
    }

    public View mr(int i) {
        return this.dSf.mr(i);
    }
}
