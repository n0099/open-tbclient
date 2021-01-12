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
    private BdBaseViewPager fmy;
    private String gcA = "key_select_forum_tab_index";
    private ImageView gcB;
    private TbTabLayout gcC;
    private SelectForumPagerAdapter gcD;
    private Intent gcE;
    private boolean gcF;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public f(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.gcA += currentAccount;
        }
        bEt();
        Xv();
        bKh();
        initViewPager();
    }

    private void bEt() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.gcB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcB.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.gcB.setLayoutParams(layoutParams);
        this.gcB.setOnClickListener(this);
        this.gcB.setVisibility(8);
    }

    private void Xv() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.gcC = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.fmy = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bKh() {
        this.gcC.setSelectedTabTextBlod(true);
        this.gcC.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b2 = this.gcC.qN().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b3 = this.gcC.qN().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.gcC.a(b2, false);
        this.gcC.a(b3, false);
    }

    private void initViewPager() {
        this.gcD = new SelectForumPagerAdapter(this.mPageContext);
        this.fmy.setAdapter(this.gcD);
        this.gcC.setupWithViewPager(this.fmy);
        sO(com.baidu.tbadk.core.sharedPref.b.brx().getInt(this.gcA, 0));
        this.gcC.setOnTabSelectedListener(this);
        this.fmy.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.f.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                f.this.gcF = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gcB) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new aq("c13994").an("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(this.gcA, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean sO(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aZ = this.gcC.aZ(i);
        if (aZ == null || aZ.isSelected()) {
            return true;
        }
        aZ.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEp() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEq() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rs(int i) {
        SvgManager.bsx().a(this.gcB, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.gcC.setTabTextColors(ao.getColor(R.color.CAM_X0108), ao.getColor(R.color.CAM_X0105));
        this.gcD.bKf();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEr() {
        return this.gcE;
    }

    public void onDestroy() {
        if (this.gcD != null) {
            this.gcD.onDestroy();
        }
    }
}
