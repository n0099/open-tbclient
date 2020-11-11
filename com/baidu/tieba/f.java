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
    private String fPH = "key_select_forum_tab_index";
    private ImageView fPI;
    private TbTabLayout fPJ;
    private SelectForumPagerAdapter fPK;
    private Intent fPL;
    private boolean fPM;
    private BdBaseViewPager faS;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.fPH += currentAccount;
        }
        bCV();
        XQ();
        bID();
        initViewPager();
    }

    private void bCV() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.fPI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPI.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fPI.setLayoutParams(layoutParams);
        this.fPI.setOnClickListener(this);
        this.fPI.setVisibility(8);
    }

    private void XQ() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.fPJ = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.faS = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bID() {
        this.fPJ.setSelectedTabTextBlod(true);
        this.fPJ.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b = this.fPJ.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b2 = this.fPJ.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.fPJ.a(b, false);
        this.fPJ.a(b2, false);
    }

    private void initViewPager() {
        this.fPK = new SelectForumPagerAdapter(this.mPageContext);
        this.faS.setAdapter(this.fPK);
        this.fPJ.setupWithViewPager(this.faS);
        tg(com.baidu.tbadk.core.sharedPref.b.bqh().getInt(this.fPH, 0));
        this.fPJ.setOnTabSelectedListener(this);
        this.faS.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.fPM = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPI) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new aq("c13994").al("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(this.fPH, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean tg(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aU = this.fPJ.aU(i);
        if (aU == null || aU.isSelected()) {
            return true;
        }
        aU.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCR() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCS() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rO(int i) {
        SvgManager.brn().a(this.fPI, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fPJ.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.fPK.bIB();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCT() {
        return this.fPL;
    }
}
