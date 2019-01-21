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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes6.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView eAW;
    private PagerSlidingTabStrip eAX;
    private ImageView ebK;
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
        this.ebK = (ImageView) findViewById(e.g.home_page_search_icon);
        this.eAW = (ImageView) findViewById(e.g.home_page_live_icon);
        this.eAX = (PagerSlidingTabStrip) findViewById(e.g.home_page_tabstrip);
        this.eAX.e(l.h(context, e.C0210e.ds34), l.h(context, e.C0210e.ds4), false);
        this.ebK.setOnClickListener(this);
        this.eAW.setOnClickListener(this);
        if (b.getInstance().getBoolean("key_live_forum_enter_switch", false)) {
            this.eAW.setVisibility(0);
        } else {
            this.eAW.setVisibility(8);
        }
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ebK) {
            TiebaStatic.log(new am("c10378").y("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.eAW) {
            TiebaStatic.log("c13393");
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                ay.Es().a((TbPageContext) i.aK(getContext()), new String[]{(String) runTask.getData()}, true);
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eAX.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.eAX != null) {
            this.eAX.setShowConcernRedTip(z);
        }
    }

    public boolean aMa() {
        if (this.eAX != null) {
            return this.eAX.aMa();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eAX.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.eAX.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.eAX.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.cp_bg_line_d);
            ap.Ed().c(this.ebK, e.f.icon_topbar_search_n_svg, e.d.select_topbar_icon_color_tint);
            al.c(this.eAW, e.f.icon_live_entry_selector);
            this.eAX.onChangeSkinType();
        }
    }

    public View oO(int i) {
        return this.eAX.oO(i);
    }

    public void onResume() {
        ap.Ed().c(this.ebK, e.f.icon_topbar_search_n_svg, e.d.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.eAX.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.eAX.setOnTabItemClickListener(aVar);
    }

    public boolean aMh() {
        return this.eAW.getVisibility() == 0;
    }
}
