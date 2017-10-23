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
    private ImageView daG;
    private ImageView daH;
    private ImageView daI;
    private PagerSlidingTabStrip daJ;
    private final CustomMessageListener daK;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.daK = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.daI.setVisibility(0);
                } else {
                    HomeTabBarView.this.daI.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.daK = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.daI.setVisibility(0);
                } else {
                    HomeTabBarView.this.daI.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.daK = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.daI.setVisibility(0);
                } else {
                    HomeTabBarView.this.daI.setVisibility(8);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.daG = (ImageView) findViewById(d.h.home_page_search_icon);
        this.daH = (ImageView) findViewById(d.h.enter_message);
        this.daI = (ImageView) findViewById(d.h.home_red_tip);
        this.daJ = (PagerSlidingTabStrip) findViewById(d.h.home_page_tabstrip);
        this.daJ.d(l.f(context, d.f.ds32), l.f(context, d.f.ds4), false);
        this.daG.setOnClickListener(this);
        this.daH.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.daK != null) {
            this.daK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.daK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.daG) {
            TiebaStatic.log(new ak("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.daH && ax.aT(getContext())) {
            TiebaStatic.log(new ak("c12044").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getContext())));
            this.daI.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.daJ.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.daJ != null) {
            this.daJ.setShowConcernRedTip(z);
        }
    }

    public boolean api() {
        if (this.daJ != null) {
            return this.daJ.api();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.daJ.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.daJ.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.daJ.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.k(this, d.e.cp_bg_line_d);
            aj.c(this.daG, d.g.icon_search_selector);
            aj.c(this.daH, d.g.icon_topbar_remind);
            aj.c(this.daI, d.g.icon_news_down_bar_one);
            this.daJ.onChangeSkinType();
        }
    }
}
