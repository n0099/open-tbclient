package com.baidu.tieba.ala.live.personcenter.exp;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.tieba.ala.live.personcenter.exp.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaPersonCenterExpActivity extends BaseActivity<AlaPersonCenterExpActivity> {
    private BdListView gkc;
    private a gkd;
    private d gke;
    private c gkf;
    private int gkj;
    private int gkk;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private long gkg = -1;
    private int gkh = -1;
    private boolean isHost = true;
    private boolean gki = true;
    private d.a gkl = new d.a() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void b(AlaLivePersonData alaLivePersonData) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaLiveUserInfoData alaLiveUserInfoData = alaLivePersonData.mUserData;
            if (alaLiveUserInfoData == null) {
                AlaPersonCenterExpActivity.this.gkg = 0L;
                AlaPersonCenterExpActivity.this.gkh = 1;
            } else {
                AlaPersonCenterExpActivity.this.gkg = alaLiveUserInfoData.levelExp;
                AlaPersonCenterExpActivity.this.gkh = alaLiveUserInfoData.levelId;
            }
            AlaPersonCenterExpActivity.this.bindDataToView();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void onFail(int i, String str) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaPersonCenterExpActivity.this.gkg = 0L;
            AlaPersonCenterExpActivity.this.gkh = 1;
            AlaPersonCenterExpActivity.this.bindDataToView();
        }
    };

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.h.sdk_prc_person_center_exp_layout);
            initData();
            initUI();
        }
    }

    private void initData() {
        if (getIntent().getExtras() != null) {
            this.gkg = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP, -1L);
            this.gkh = getIntent().getExtras().getInt("current_level", -1);
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    private void initUI() {
        this.mRootView = findViewById(a.g.ala_person_center_exp_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_xp);
        this.gkc = (BdListView) findViewById(a.g.ala_person_center_exp_list);
        this.gkf = new c(getPageContext().getPageActivity());
        this.gkd = new a(this);
        this.gkc.setAdapter((ListAdapter) this.gkd);
        if (this.gkg == -1 || this.gkh == -1) {
            this.mRootView.setVisibility(8);
            this.gke = new d(getPageContext(), this.gkl);
            this.gke.Mz();
            return;
        }
        bindDataToView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDataToView() {
        if (this.gkh < 1) {
            this.gkh = 1;
        } else if (this.gkh > 40) {
            this.gkh = 40;
        }
        this.gkj = (int) getResources().getDimension(a.e.sdk_ds364);
        this.gkk = (int) getResources().getDimension(a.e.sdk_ds168);
        bMF();
        this.gkf.n(this.gkg, this.gkh);
    }

    public void bMF() {
        bMG();
        bMH();
    }

    private void bMG() {
        if (this.isHost) {
            this.gkc.addHeaderView(this.gkf.bMK());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.gkc.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.bMI();
                    AlaPersonCenterExpActivity.this.bMJ();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void bMH() {
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            b bVar = new b();
            bVar.level = i + 1;
            bVar.gkr = com.baidu.tieba.ala.live.personcenter.a.tO(i);
            arrayList.add(bVar);
        }
        this.gkd.ad(arrayList);
        this.gkd.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMI() {
        if (Build.VERSION.SDK_INT >= 11 && this.gkf != null) {
            int i = this.gkj - (-this.gkf.bMK().getTop());
            if (i < this.gkk) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.gkk && i <= this.gkk * 2) {
                float f = 1.0f - (((i - this.gkk) * 1.0f) / this.gkk);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.gkk * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.gkc.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMJ() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.gki) {
                this.gki = true;
            }
        } else if (this.gki) {
            this.gki = false;
        }
        a(alpha, this.gki ? false : true);
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
        if (this.gkf != null) {
            this.gkf.b(this, i);
        }
        if (this.gkd != null) {
            this.gkd.notifyDataSetChanged();
            this.gkd.tP(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gke != null) {
            this.gke.onDestroy();
        }
    }
}
