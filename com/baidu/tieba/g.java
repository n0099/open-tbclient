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
    private String geP = "key_select_forum_tab_index";
    private ImageView geQ;
    private TbTabLayout geR;
    private SelectForumPagerAdapter geS;
    private Intent geT;
    private boolean geU;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public g(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.geP += currentAccount;
        }
        bEL();
        Zl();
        bKB();
        initViewPager();
    }

    private void bEL() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.geQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.geQ.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.geQ.setLayoutParams(layoutParams);
        this.geQ.setOnClickListener(this);
        this.geQ.setVisibility(8);
    }

    private void Zl() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.geR = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.foQ = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bKB() {
        this.geR.setSelectedTabTextBlod(true);
        this.geR.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b2 = this.geR.qL().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b3 = this.geR.qL().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.geR.a(b2, false);
        this.geR.a(b3, false);
    }

    private void initViewPager() {
        this.geS = new SelectForumPagerAdapter(this.mPageContext);
        this.foQ.setAdapter(this.geS);
        this.geR.setupWithViewPager(this.foQ);
        sT(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(this.geP, 0));
        this.geR.setOnTabSelectedListener(this);
        this.foQ.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.g.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                g.this.geU = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.geQ) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new ar("c13994").ap("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(this.geP, eVar.getPosition());
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
        TbTabLayout.e aZ = this.geR.aZ(i);
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
        SvgManager.bsR().a(this.geQ, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.geR.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.geS.bKz();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return this.geT;
    }

    public void onDestroy() {
        if (this.geS != null) {
            this.geS.onDestroy();
        }
    }
}
