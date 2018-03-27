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
    private com.baidu.tieba.d.b dFN;
    private ImageView elh;
    private PagerSlidingTabStrip eli;
    private final CustomMessageListener elj;
    private int mSkinType;

    public HomeTabBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.elj = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
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
                        HomeTabBarView.this.dFN.j(z, i);
                    }
                    HomeTabBarView.this.dFN.j(z, i);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.elj = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
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
                        HomeTabBarView.this.dFN.j(z, i);
                    }
                    HomeTabBarView.this.dFN.j(z, i);
                }
            }
        };
        init(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.elj = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.homepage.personalize.view.HomeTabBarView.1
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
                        HomeTabBarView.this.dFN.j(z, i2);
                    }
                    HomeTabBarView.this.dFN.j(z, i2);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.home_tab_bar_view_layout, (ViewGroup) this, true);
        this.elh = (ImageView) findViewById(d.g.home_page_search_icon);
        this.eli = (PagerSlidingTabStrip) findViewById(d.g.home_page_tabstrip);
        this.eli.g(l.t(context, d.e.ds34), l.t(context, d.e.ds4), false);
        this.elh.setOnClickListener(this);
        this.dFN = new com.baidu.tieba.d.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        addView(this.dFN.getView(), layoutParams);
        this.dFN.getView().setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setMessageListener(BdUniqueId bdUniqueId) {
        if (this.elj != null) {
            this.elj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.elj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.elh) {
            TiebaStatic.log(new ak("c10378").s("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
        } else if (view == this.dFN.getView() && ay.ba(getContext())) {
            TiebaStatic.log(new ak("c12044").s("obj_locate", 1));
            TiebaStatic.log(new ak("c12924").s("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eli.setOnPageChangeListener(onPageChangeListener);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.eli != null) {
            this.eli.setShowConcernRedTip(z);
        }
    }

    public boolean aCD() {
        if (this.eli != null) {
            return this.eli.aCD();
        }
        return false;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eli.setViewPager(viewPager);
    }

    public void setTabItemClicked(boolean z) {
        this.eli.setTabItemClicked(z);
    }

    public void notifyDataSetChanged() {
        this.eli.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.t(this, d.C0141d.cp_bg_line_d);
            an.Dd().c(this.elh, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            this.dFN.onChangeSkinType(skinType);
            this.eli.onChangeSkinType();
        }
    }
}
