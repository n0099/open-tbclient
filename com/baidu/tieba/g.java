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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes2.dex */
public class g implements View.OnClickListener, TbTabLayout.b, com.baidu.tbadk.suspended.a {
    private BdBaseViewPager foQ;
    private String geU = "key_select_forum_tab_index";
    private ImageView geV;
    private TbTabLayout geW;
    private SelectForumPagerAdapter geX;
    private Intent geY;
    private boolean geZ;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public g(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.geU += currentAccount;
        }
        bEL();
        Zl();
        bKG();
        initViewPager();
    }

    private void bEL() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.geV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.geV.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.geV.setLayoutParams(layoutParams);
        this.geV.setOnClickListener(this);
        this.geV.setVisibility(8);
    }

    private void Zl() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.geW = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.foQ = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bKG() {
        this.geW.setSelectedTabTextBlod(true);
        this.geW.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b2 = this.geW.qL().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b3 = this.geW.qL().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.geW.a(b2, false);
        this.geW.a(b3, false);
    }

    private void initViewPager() {
        this.geX = new SelectForumPagerAdapter(this.mPageContext);
        this.foQ.setAdapter(this.geX);
        this.geW.setupWithViewPager(this.foQ);
        sT(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(this.geU, 0));
        this.geW.setOnTabSelectedListener(this);
        this.foQ.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.g.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                g.this.geZ = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.geV) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new ar("c13994").ap("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(this.geU, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean sT(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e aZ = this.geW.aZ(i);
        if (aZ == null || aZ.isSelected()) {
            return true;
        }
        aZ.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEH() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
        SvgManager.bsR().a(this.geV, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.geW.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.geX.bKE();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return this.geY;
    }

    public void onDestroy() {
        if (this.geX != null) {
            this.geX.onDestroy();
        }
    }
}
