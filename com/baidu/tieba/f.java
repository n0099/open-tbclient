package com.baidu.tieba;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class f implements View.OnClickListener, TbTabLayout.b, com.baidu.tbadk.suspended.a {
    private String fXB = "key_select_forum_tab_index";
    private ImageView fXC;
    private TbTabLayout fXD;
    private SelectForumPagerAdapter fXE;
    private Intent fXF;
    private boolean fXG;
    private BdBaseViewPager fhx;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.fXB += currentAccount;
        }
        bFP();
        ZG();
        bLG();
        initViewPager();
    }

    private void bFP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.fXC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXC.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fXC.setLayoutParams(layoutParams);
        this.fXC.setOnClickListener(this);
        this.fXC.setVisibility(8);
    }

    private void ZG() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.fXD = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.fhx = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bLG() {
        this.fXD.setSelectedTabTextBlod(true);
        this.fXD.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b = this.fXD.rl().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b2 = this.fXD.rl().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.fXD.a(b, false);
        this.fXD.a(b2, false);
    }

    private void initViewPager() {
        this.fXE = new SelectForumPagerAdapter(this.mPageContext);
        this.fhx.setAdapter(this.fXE);
        this.fXD.setupWithViewPager(this.fhx);
        ui(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(this.fXB, 0));
        this.fXD.setOnTabSelectedListener(this);
        this.fhx.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.fXG = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXC) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new ar("c13994").al("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(this.fXB, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean ui(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aY = this.fXD.aY(i);
        if (aY == null || aY.isSelected()) {
            return true;
        }
        aY.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
        SvgManager.btW().a(this.fXC, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fXD.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.fXE.bLE();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXF;
    }
}
