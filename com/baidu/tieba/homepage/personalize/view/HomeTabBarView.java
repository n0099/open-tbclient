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
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private ImageView eff;
    private ImageView efg;
    private ImageView efh;
    private PagerSlidingTabStrip efi;
    private final CustomMessageListener efj;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.efj = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.efh.setVisibility(0);
                } else {
                    HomeTabBarView.this.efh.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.efj = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.efh.setVisibility(0);
                } else {
                    HomeTabBarView.this.efh.setVisibility(8);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.efj = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
                    HomeTabBarView.this.efh.setVisibility(0);
                } else {
                    HomeTabBarView.this.efh.setVisibility(8);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.eff = (ImageView) findViewById(d.g.home_page_search_icon);
        this.efg = (ImageView) findViewById(d.g.enter_message);
        this.efh = (ImageView) findViewById(d.g.home_red_tip);
        this.efi = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.efi.g(l.s(context, d.e.ds34), l.s(context, d.e.ds4), false);
        this.eff.setOnClickListener(this);
        this.efg.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.efj != null) {
            this.efj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eff) {
            TiebaStatic.log(new ak("c10378").s("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.efg && ax.be(getContext())) {
            TiebaStatic.log(new ak("c12044").s("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getContext())));
            this.efh.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.efi.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.efi != null) {
            this.efi.setShowConcernRedTip(z);
        }
    }

    public boolean aBc() {
        if (this.efi != null) {
            return this.efi.aBc();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.efi.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.efi.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.efi.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.t(this, d.C0108d.cp_bg_line_d);
            aj.c(this.eff, d.f.icon_search_selector);
            aj.c(this.efg, d.f.icon_topbar_remind);
            aj.c(this.efh, d.f.icon_news_down_bar_one);
            this.efi.onChangeSkinType();
        }
    }
}
