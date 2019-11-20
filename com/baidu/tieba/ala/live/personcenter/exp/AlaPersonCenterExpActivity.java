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
    private int dQA;
    private BdListView dQt;
    private b dQu;
    private d dQv;
    private int dQz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private TextView mTitleView;
    private long dQw = 0;
    private int dQx = 1;
    private boolean isHost = true;
    private boolean dQy = true;

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.sdk_prc_person_center_exp_layout);
        initData();
        initUI();
        aMq();
    }

    private void initData() {
        if (getIntent().getExtras() != null) {
            this.dQw = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP);
            this.dQx = getIntent().getExtras().getInt("current_level");
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
        if (this.dQx < 1) {
            this.dQx = 1;
        } else if (this.dQx > 40) {
            this.dQx = 40;
        }
        this.dQz = (int) getResources().getDimension(a.e.sdk_ds364);
        this.dQA = (int) getResources().getDimension(a.e.sdk_ds168);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_xp);
        this.dQt = (BdListView) findViewById(a.g.ala_person_center_exp_list);
        this.dQv = new d(getPageContext().getPageActivity());
        this.dQv.i(this.dQw, this.dQx);
        this.dQu = new b(this);
        this.dQt.setAdapter((ListAdapter) this.dQu);
    }

    public void aMq() {
        aMr();
        aMs();
    }

    private void aMr() {
        if (this.isHost) {
            this.dQt.addHeaderView(this.dQv.aMv());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.dQt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.aMt();
                    AlaPersonCenterExpActivity.this.aMu();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void aMs() {
        ArrayList<c> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            c cVar = new c();
            cVar.level = i + 1;
            cVar.dQH = com.baidu.tieba.ala.live.personcenter.a.mS(i);
            arrayList.add(cVar);
        }
        this.dQu.N(arrayList);
        this.dQu.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMt() {
        if (Build.VERSION.SDK_INT >= 11 && this.dQv != null) {
            int i = this.dQz - (-this.dQv.aMv().getTop());
            if (i < this.dQA) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.dQA && i <= this.dQA * 2) {
                float f = 1.0f - (((i - this.dQA) * 1.0f) / this.dQA);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.dQA * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.dQt.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMu() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.dQy) {
                this.dQy = true;
            }
        } else if (this.dQy) {
            this.dQy = false;
        }
        a(alpha, this.dQy ? false : true);
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
        if (this.dQv != null) {
            this.dQv.a(this, i);
        }
        if (this.dQu != null) {
            this.dQu.notifyDataSetChanged();
            this.dQu.mU(i);
        }
    }
}
