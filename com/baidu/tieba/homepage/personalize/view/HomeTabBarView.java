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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView cwR;
    private ImageView cwS;
    private ImageView cwT;
    private PagerSlidingTabStrip cwU;
    private final CustomMessageListener cwV;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cwV = new a(this, CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cwV = new a(this, CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cwV = new a(this, CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.cwR = (ImageView) findViewById(w.h.home_page_search_icon);
        this.cwS = (ImageView) findViewById(w.h.enter_message);
        this.cwT = (ImageView) findViewById(w.h.home_red_tip);
        this.cwU = (PagerSlidingTabStrip) findViewById(w.h.home_page_tabstrip);
        this.cwU.c(k.g(context, w.f.ds32), k.g(context, w.f.ds4), false);
        this.cwR.setOnClickListener(this);
        this.cwS.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.cwV != null) {
            this.cwV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwV);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cwR) {
            TiebaStatic.log(new as("c10378").s("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.cwS) {
            TiebaStatic.log(new as("c12044").s("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getContext())));
            this.cwT.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cwU.setOnPageChangeListener(onPageChangeListener);
    }

    public void setViewPager(ViewPager viewPager) {
        this.cwU.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.cwU.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.cwU.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aq.k(this, w.e.cp_bg_line_d);
            aq.c(this.cwR, w.g.icon_search_selector);
            aq.c(this.cwS, w.g.icon_topbar_remind);
            aq.c(this.cwT, w.g.icon_news_down_bar_one);
            this.cwU.onChangeSkinType();
        }
    }
}
