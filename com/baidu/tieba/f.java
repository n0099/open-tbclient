package com.baidu.tieba;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class f implements View.OnClickListener, TbTabLayout.b, com.baidu.tbadk.suspended.a {
    private BdBaseViewPager fri;
    private String ghi = "key_select_forum_tab_index";
    private ImageView ghj;
    private TbTabLayout ghk;
    private SelectForumPagerAdapter ghl;
    private Intent ghm;
    private boolean ghn;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.ghi += currentAccount;
        }
        bIk();
        abn();
        bNY();
        initViewPager();
    }

    private void bIk() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.ghj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghj.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.ghj.setLayoutParams(layoutParams);
        this.ghj.setOnClickListener(this);
        this.ghj.setVisibility(8);
    }

    private void abn() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.ghk = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.fri = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bNY() {
        this.ghk.setSelectedTabTextBlod(true);
        this.ghk.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b2 = this.ghk.qN().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b3 = this.ghk.qN().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.ghk.a(b2, false);
        this.ghk.a(b3, false);
    }

    private void initViewPager() {
        this.ghl = new SelectForumPagerAdapter(this.mPageContext);
        this.fri.setAdapter(this.ghl);
        this.ghk.setupWithViewPager(this.fri);
        uu(com.baidu.tbadk.core.sharedPref.b.bvq().getInt(this.ghi, 0));
        this.ghk.setOnTabSelectedListener(this);
        this.fri.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.ghn = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghj) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new aq("c13994").an("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt(this.ghi, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean uu(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aZ = this.ghk.aZ(i);
        if (aZ == null || aZ.isSelected()) {
            return true;
        }
        aZ.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIg() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIh() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
        SvgManager.bwq().a(this.ghj, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ghk.setTabTextColors(ao.getColor(R.color.CAM_X0108), ao.getColor(R.color.CAM_X0105));
        this.ghl.bNW();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIi() {
        return this.ghm;
    }

    public void onDestroy() {
        if (this.ghl != null) {
            this.ghl.onDestroy();
        }
    }
}
