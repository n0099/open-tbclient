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
/* loaded from: classes21.dex */
public class f implements View.OnClickListener, TbTabLayout.b, com.baidu.tbadk.suspended.a {
    private String fPq = "key_select_forum_tab_index";
    private ImageView fPr;
    private TbTabLayout fPs;
    private SelectForumPagerAdapter fPt;
    private Intent fPu;
    private boolean fPv;
    private BdBaseViewPager faa;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.fPq += currentAccount;
        }
        bCo();
        Xh();
        bHX();
        initViewPager();
    }

    private void bCo() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.fPr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPr.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.fPr.setLayoutParams(layoutParams);
        this.fPr.setOnClickListener(this);
        this.fPr.setVisibility(8);
    }

    private void Xh() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.fPs = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.faa = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bHX() {
        this.fPs.setSelectedTabTextBlod(true);
        this.fPs.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b = this.fPs.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b2 = this.fPs.rj().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.fPs.a(b, false);
        this.fPs.a(b2, false);
    }

    private void initViewPager() {
        this.fPt = new SelectForumPagerAdapter(this.mPageContext);
        this.faa.setAdapter(this.fPt);
        this.fPs.setupWithViewPager(this.faa);
        tE(com.baidu.tbadk.core.sharedPref.b.bpu().getInt(this.fPq, 0));
        this.fPs.setOnTabSelectedListener(this);
        this.faa.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.fPv = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPr) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new ar("c13994").ak("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt(this.fPq, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean tE(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aU = this.fPs.aU(i);
        if (aU == null || aU.isSelected()) {
            return true;
        }
        aU.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCk() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCl() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sm(int i) {
        SvgManager.bqB().a(this.fPr, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fPs.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.fPt.bHV();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCm() {
        return this.fPu;
    }
}
