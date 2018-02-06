package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Pair;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes2.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tieba.d.b dFV;
    private ImageView eld;
    private PagerSlidingTabStrip ele;
    private final CustomMessageListener elf;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.elf = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                boolean z;
                Pair pair;
                int intValue;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                    try {
                        pair = (Pair) customResponsedMessage.getData();
                        intValue = ((Integer) pair.first).intValue();
                    } catch (Exception e) {
                        i = 0;
                    }
                    try {
                        z = ((Boolean) pair.second).booleanValue();
                        i = intValue;
                    } catch (Exception e2) {
                        i = intValue;
                        z = false;
                        HomeTabBarView.this.dFV.j(z, i);
                    }
                    HomeTabBarView.this.dFV.j(z, i);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.elf = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                boolean z;
                Pair pair;
                int intValue;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                    try {
                        pair = (Pair) customResponsedMessage.getData();
                        intValue = ((Integer) pair.first).intValue();
                    } catch (Exception e) {
                        i = 0;
                    }
                    try {
                        z = ((Boolean) pair.second).booleanValue();
                        i = intValue;
                    } catch (Exception e2) {
                        i = intValue;
                        z = false;
                        HomeTabBarView.this.dFV.j(z, i);
                    }
                    HomeTabBarView.this.dFV.j(z, i);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.elf = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i2;
                boolean z;
                Pair pair;
                int intValue;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                    try {
                        pair = (Pair) customResponsedMessage.getData();
                        intValue = ((Integer) pair.first).intValue();
                    } catch (Exception e) {
                        i2 = 0;
                    }
                    try {
                        z = ((Boolean) pair.second).booleanValue();
                        i2 = intValue;
                    } catch (Exception e2) {
                        i2 = intValue;
                        z = false;
                        HomeTabBarView.this.dFV.j(z, i2);
                    }
                    HomeTabBarView.this.dFV.j(z, i2);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.eld = (ImageView) findViewById(d.g.home_page_search_icon);
        this.ele = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.ele.g(l.t(context, d.e.ds34), l.t(context, d.e.ds4), false);
        this.eld.setOnClickListener(this);
        this.dFV = new com.baidu.tieba.d.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        addView(this.dFV.getView(), layoutParams);
        this.dFV.getView().setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.elf != null) {
            this.elf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.elf);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eld) {
            TiebaStatic.log(new ak("c10378").s("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.dFV.getView() && ay.ba(getContext())) {
            TiebaStatic.log(new ak("c12044").s("obj_locate", 1));
            TiebaStatic.log(new ak("c12924").s("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ele.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ele != null) {
            this.ele.setShowConcernRedTip(z);
        }
    }

    public boolean aCD() {
        if (this.ele != null) {
            return this.ele.aCD();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ele.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.ele.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.ele.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.t(this, d.C0140d.cp_bg_line_d);
            an.Dd().c(this.eld, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            this.dFV.onChangeSkinType(skinType);
            this.ele.onChangeSkinType();
        }
    }
}
