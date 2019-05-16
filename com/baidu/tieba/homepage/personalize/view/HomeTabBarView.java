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
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView gfa;
    private PagerSlidingTabStrip gfb;
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
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.gfa = (ImageView) findViewById(R.id.home_page_search_icon);
        this.gfa.setClickable(false);
        this.gfb = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.gfb.d(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds68), l.g(context, R.dimen.tbds32), true);
        this.gfa.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gfa) {
            TiebaStatic.log(new am("c10378").P("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gfb.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gfb != null) {
            this.gfb.setShowConcernRedTip(z);
        }
    }

    public boolean btw() {
        if (this.gfb != null) {
            return this.gfb.btw();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.gfb.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.gfb.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.gfb.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.cp_bg_line_d);
            aq.aik().d(this.gfa, R.drawable.icon_common_top_search, R.color.select_topbar_icon_color_tint);
            this.gfb.onChangeSkinType();
        }
    }

    public View tA(int i) {
        return this.gfb.tA(i);
    }

    public void onResume() {
        aq.aik().d(this.gfa, R.drawable.icon_common_top_search, R.color.select_topbar_icon_color_tint);
    }

    public void setConcernTabIndex(int i) {
        this.gfb.setConcernTabIndex(i);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.a aVar) {
        this.gfb.setOnTabItemClickListener(aVar);
    }

    public void aF(float f) {
        if (f <= 1.0f && f >= 0.0f && this.gfa != null && this.gfa.getAlpha() != f) {
            this.gfa.setAlpha(f);
            if (f == 0.0f) {
                this.gfa.setClickable(false);
            } else {
                this.gfa.setClickable(true);
            }
        }
    }
}
