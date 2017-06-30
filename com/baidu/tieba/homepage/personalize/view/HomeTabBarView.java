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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView cLg;
    private ImageView cLh;
    private ImageView cLi;
    private PagerSlidingTabStrip cLj;
    private final CustomMessageListener cLk;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cLk = new a(this, CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cLk = new a(this, CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cLk = new a(this, CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.cLg = (ImageView) findViewById(w.h.home_page_search_icon);
        this.cLh = (ImageView) findViewById(w.h.enter_message);
        this.cLi = (ImageView) findViewById(w.h.home_red_tip);
        this.cLj = (PagerSlidingTabStrip) findViewById(w.h.home_page_tabstrip);
        this.cLj.d(k.g(context, w.f.ds32), k.g(context, w.f.ds4), false);
        this.cLg.setOnClickListener(this);
        this.cLh.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.cLk != null) {
            this.cLk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cLk);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cLg) {
            TiebaStatic.log(new au("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.cLh && bl.aN(getContext())) {
            TiebaStatic.log(new au("c12044").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getContext())));
            this.cLi.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cLj.setOnPageChangeListener(onPageChangeListener);
    }

    public void setViewPager(ViewPager viewPager) {
        this.cLj.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.cLj.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.cLj.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            as.k(this, w.e.cp_bg_line_d);
            as.c(this.cLg, w.g.icon_search_selector);
            as.c(this.cLh, w.g.icon_topbar_remind);
            as.c(this.cLi, w.g.icon_news_down_bar_one);
            this.cLj.onChangeSkinType();
        }
    }
}
