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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView diP;
    private ImageView diQ;
    private ImageView diR;
    private PagerSlidingTabStrip diS;
    private final CustomMessageListener diT;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.diT = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.diR.setVisibility(0);
                } else {
                    HomeTabBarView.this.diR.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.diT = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.diR.setVisibility(0);
                } else {
                    HomeTabBarView.this.diR.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.diT = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.diR.setVisibility(0);
                } else {
                    HomeTabBarView.this.diR.setVisibility(8);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.diP = (ImageView) findViewById(d.g.home_page_search_icon);
        this.diQ = (ImageView) findViewById(d.g.enter_message);
        this.diR = (ImageView) findViewById(d.g.home_red_tip);
        this.diS = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.diS.d(l.f(context, d.e.ds34), l.f(context, d.e.ds4), false);
        this.diP.setOnClickListener(this);
        this.diQ.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.diT != null) {
            this.diT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.diT);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.diP) {
            TiebaStatic.log(new ak("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.diQ && ax.aT(getContext())) {
            TiebaStatic.log(new ak("c12044").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getContext())));
            this.diR.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.diS.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.diS != null) {
            this.diS.setShowConcernRedTip(z);
        }
    }

    public boolean arX() {
        if (this.diS != null) {
            return this.diS.arX();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.diS.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.diS.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.diS.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.k(this, d.C0080d.cp_bg_line_d);
            aj.c(this.diP, d.f.icon_search_selector);
            aj.c(this.diQ, d.f.icon_topbar_remind);
            aj.c(this.diR, d.f.icon_news_down_bar_one);
            this.diS.onChangeSkinType();
        }
    }
}
