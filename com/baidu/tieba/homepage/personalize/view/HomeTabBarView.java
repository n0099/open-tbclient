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
import com.baidu.adp.lib.util.k;
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
    private ImageView deF;
    private ImageView deG;
    private ImageView deH;
    private PagerSlidingTabStrip deI;
    private final CustomMessageListener deJ;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.deJ = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.deH.setVisibility(0);
                } else {
                    HomeTabBarView.this.deH.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.deJ = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.deH.setVisibility(0);
                } else {
                    HomeTabBarView.this.deH.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.deJ = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.deH.setVisibility(0);
                } else {
                    HomeTabBarView.this.deH.setVisibility(8);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.deF = (ImageView) findViewById(d.h.home_page_search_icon);
        this.deG = (ImageView) findViewById(d.h.enter_message);
        this.deH = (ImageView) findViewById(d.h.home_red_tip);
        this.deI = (PagerSlidingTabStrip) findViewById(d.h.home_page_tabstrip);
        this.deI.d(k.f(context, d.f.ds32), k.f(context, d.f.ds4), false);
        this.deF.setOnClickListener(this);
        this.deG.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.deJ != null) {
            this.deJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.deJ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.deF) {
            TiebaStatic.log(new ak("c10378").r("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.deG && ax.aU(getContext())) {
            TiebaStatic.log(new ak("c12044").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getContext())));
            this.deH.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.deI.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.deI != null) {
            this.deI.setShowConcernRedTip(z);
        }
    }

    public boolean aqG() {
        if (this.deI != null) {
            return this.deI.aqG();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.deI.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.deI.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.deI.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.k(this, d.e.cp_bg_line_d);
            aj.c(this.deF, d.g.icon_search_selector);
            aj.c(this.deG, d.g.icon_topbar_remind);
            aj.c(this.deH, d.g.icon_news_down_bar_one);
            this.deI.onChangeSkinType();
        }
    }
}
