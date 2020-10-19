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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes22.dex */
public class f implements View.OnClickListener, TbTabLayout.b, com.baidu.tbadk.suspended.a {
    private BdBaseViewPager eMH;
    private Intent fBA;
    private boolean fBB;
    private String fBw = "key_select_forum_tab_index";
    private ImageView fBx;
    private TbTabLayout fBy;
    private SelectForumPagerAdapter fBz;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.fBw += currentAccount;
        }
        byD();
        Yn();
        bEl();
        initViewPager();
    }

    private void byD() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.fBx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBx.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fBx.setLayoutParams(layoutParams);
        this.fBx.setOnClickListener(this);
        this.fBx.setVisibility(8);
    }

    private void Yn() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.fBy = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.eMH = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bEl() {
        this.fBy.setSelectedTabTextBlod(true);
        this.fBy.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b = this.fBy.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b2 = this.fBy.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.fBy.a(b, false);
        this.fBy.a(b2, false);
    }

    private void initViewPager() {
        this.fBz = new SelectForumPagerAdapter(this.mPageContext);
        this.eMH.setAdapter(this.fBz);
        this.fBy.setupWithViewPager(this.eMH);
        sL(com.baidu.tbadk.core.sharedPref.b.blO().getInt(this.fBw, 0));
        this.fBy.setOnTabSelectedListener(this);
        this.eMH.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.fBB = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBx) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new aq("c13994").aj("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.blO().putInt(this.fBw, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean sL(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aU = this.fBy.aU(i);
        if (aU == null || aU.isSelected()) {
            return true;
        }
        aU.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byz() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byA() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rt(int i) {
        SvgManager.bmU().a(this.fBx, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fBy.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fBz.bEj();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent byB() {
        return this.fBA;
    }
}
