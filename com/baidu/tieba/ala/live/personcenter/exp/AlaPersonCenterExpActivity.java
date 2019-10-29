package com.baidu.tieba.ala.live.personcenter.exp;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AlaPersonCenterExpActivity extends BaseActivity<AlaPersonCenterExpActivity> {
    private BdListView dRk;
    private b dRl;
    private d dRm;
    private int dRq;
    private int dRr;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private TextView mTitleView;
    private long dRn = 0;
    private int dRo = 1;
    private boolean isHost = true;
    private boolean dRp = true;

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.sdk_prc_person_center_exp_layout);
        initData();
        initUI();
        aMs();
    }

    private void initData() {
        if (getIntent().getExtras() != null) {
            this.dRn = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP);
            this.dRo = getIntent().getExtras().getInt("current_level");
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
        if (this.dRo < 1) {
            this.dRo = 1;
        } else if (this.dRo > 40) {
            this.dRo = 40;
        }
        this.dRq = (int) getResources().getDimension(a.e.sdk_ds364);
        this.dRr = (int) getResources().getDimension(a.e.sdk_ds168);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_xp);
        this.dRk = (BdListView) findViewById(a.g.ala_person_center_exp_list);
        this.dRm = new d(getPageContext().getPageActivity());
        this.dRm.i(this.dRn, this.dRo);
        this.dRl = new b(this);
        this.dRk.setAdapter((ListAdapter) this.dRl);
    }

    public void aMs() {
        aMt();
        aMu();
    }

    private void aMt() {
        if (this.isHost) {
            this.dRk.addHeaderView(this.dRm.aMx());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.dRk.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.aMv();
                    AlaPersonCenterExpActivity.this.aMw();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void aMu() {
        ArrayList<c> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            c cVar = new c();
            cVar.level = i + 1;
            cVar.dRy = com.baidu.tieba.ala.live.personcenter.a.mT(i);
            arrayList.add(cVar);
        }
        this.dRl.N(arrayList);
        this.dRl.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMv() {
        if (Build.VERSION.SDK_INT >= 11 && this.dRm != null) {
            int i = this.dRq - (-this.dRm.aMx().getTop());
            if (i < this.dRr) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.dRr && i <= this.dRr * 2) {
                float f = 1.0f - (((i - this.dRr) * 1.0f) / this.dRr);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.dRr * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.dRk.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMw() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.dRp) {
                this.dRp = true;
            }
        } else if (this.dRp) {
            this.dRp = false;
        }
        a(alpha, this.dRp ? false : true);
    }

    protected void a(float f, boolean z) {
        if (z) {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.d.sdk_cp_cont_b, a.d.sdk_s_navbar_title_color);
        } else {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.f.sdk_prc_btn_sml_back_selector_s, a.f.sdk_prc_btn_sml_back_selector_s);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        }
        this.mTitleView.setAlpha(f);
        this.mBackImageView.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(getResources(), SkinManager.getBitmapLowQuality(a.f.sdk_s_navbar_bg)));
        if (this.dRm != null) {
            this.dRm.a(this, i);
        }
        if (this.dRl != null) {
            this.dRl.notifyDataSetChanged();
            this.dRl.mV(i);
        }
    }
}
