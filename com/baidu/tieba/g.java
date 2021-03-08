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
    private BdBaseViewPager fqq;
    private SelectForumPagerAdapter ggA;
    private Intent ggB;
    private boolean ggC;
    private String ggx = "key_select_forum_tab_index";
    private ImageView ggy;
    private TbTabLayout ggz;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;
    private TbPageContext<SelectForumActivity> mPageContext;

    public g(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.ggx += currentAccount;
        }
        bEP();
        Zo();
        bKK();
        initViewPager();
    }

    private void bEP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.activity_select_forum_title));
        this.ggy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ggy.getLayoutParams();
        layoutParams.setMargins(0, 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10), 0);
        this.ggy.setLayoutParams(layoutParams);
        this.ggy.setOnClickListener(this);
        this.ggy.setVisibility(8);
    }

    private void Zo() {
        LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.mContentView, true);
        this.ggz = (TbTabLayout) this.mContentView.findViewById(R.id.activity_select_forum_tab_layout);
        this.fqq = (BdBaseViewPager) this.mContentView.findViewById(R.id.activity_select_forum_viewpager);
    }

    private void bKK() {
        this.ggz.setSelectedTabTextBlod(true);
        this.ggz.setSelectedTabIndicatorColor(0);
        TbTabLayout.e b = this.ggz.qL().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.e b2 = this.ggz.qL().b(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.ggz.a(b, false);
        this.ggz.a(b2, false);
    }

    private void initViewPager() {
        this.ggA = new SelectForumPagerAdapter(this.mPageContext);
        this.fqq.setAdapter(this.ggA);
        this.ggz.setupWithViewPager(this.fqq);
        sV(com.baidu.tbadk.core.sharedPref.b.brR().getInt(this.ggx, 0));
        this.ggz.setOnTabSelectedListener(this);
        this.fqq.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.g.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                g.this.ggC = i == 0;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ggy) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        TiebaStatic.log(new ar("c13994").aq("obj_type", eVar.getPosition() + 1));
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(this.ggx, eVar.getPosition());
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
    }

    public boolean sV(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.e ba = this.ggz.ba(i);
        if (ba == null || ba.isSelected()) {
            return true;
        }
        ba.select();
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEL() {
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
        SvgManager.bsU().a(this.ggy, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ggz.setTabTextColors(ap.getColor(R.color.CAM_X0108), ap.getColor(R.color.CAM_X0105));
        this.ggA.bKI();
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
        return this.ggB;
    }

    public void onDestroy() {
        if (this.ggA != null) {
            this.ggA.onDestroy();
        }
    }
}
