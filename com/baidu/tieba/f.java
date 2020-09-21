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
/* loaded from: classes21.dex */
public class f implements View.OnClickListener, TbTabLayout.b, com.baidu.tbadk.suspended.a {
    private BdBaseViewPager eAA;
    private String fpi = "key_select_forum_tab_index";
    private ImageView fpj;
    private TbTabLayout fpk;
    private SelectForumPagerAdapter fpl;
    private Intent fpm;
    private boolean fpn;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.fpi += currentAccount;
        }
        bvT();
        Wq();
        bBz();
        initViewPager();
    }

    private void bvT() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.fpj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpj.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fpj.setLayoutParams(layoutParams);
        this.fpj.setOnClickListener(this);
        this.fpj.setVisibility(8);
    }

    private void Wq() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.fpk = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.eAA = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bBz() {
        this.fpk.setSelectedTabTextBlod(true);
        this.fpk.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b = this.fpk.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b2 = this.fpk.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.fpk.a(b, false);
        this.fpk.a(b2, false);
    }

    private void initViewPager() {
        this.fpl = new SelectForumPagerAdapter(this.mPageContext);
        this.eAA.setAdapter(this.fpl);
        this.fpk.setupWithViewPager(this.eAA);
        sn(com.baidu.tbadk.core.sharedPref.b.bjf().getInt(this.fpi, 0));
        this.fpk.setOnTabSelectedListener(this);
        this.eAA.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.fpn = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fpj) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new aq("c13994").ai("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt(this.fpi, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean sn(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aU = this.fpk.aU(i);
        if (aU == null || aU.isSelected()) {
            return true;
        }
        aU.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvP() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvQ() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qV(int i) {
        SvgManager.bkl().a(this.fpj, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fpk.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fpl.bBx();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bvR() {
        return this.fpm;
    }
}
