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
/* loaded from: classes11.dex */
public class AlaPersonCenterExpActivity extends BaseActivity<AlaPersonCenterExpActivity> {
    private BdListView hkD;
    private a hkE;
    private d hkF;
    private c hkG;
    private int hkK;
    private int hkL;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private long hkH = -1;
    private int hkI = -1;
    private boolean isHost = true;
    private boolean hkJ = true;
    private d.a hkM = new d.a() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void b(AlaLivePersonData alaLivePersonData) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaLiveUserInfoData alaLiveUserInfoData = alaLivePersonData.mUserData;
            if (alaLiveUserInfoData == null) {
                AlaPersonCenterExpActivity.this.hkH = 0L;
                AlaPersonCenterExpActivity.this.hkI = 1;
            } else {
                AlaPersonCenterExpActivity.this.hkH = alaLiveUserInfoData.levelExp;
                AlaPersonCenterExpActivity.this.hkI = alaLiveUserInfoData.levelId;
            }
            AlaPersonCenterExpActivity.this.bindDataToView();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void onFail(int i, String str) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaPersonCenterExpActivity.this.hkH = 0L;
            AlaPersonCenterExpActivity.this.hkI = 1;
            AlaPersonCenterExpActivity.this.bindDataToView();
        }
    };

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.g.sdk_prc_person_center_exp_layout);
            initData();
            initUI();
        }
    }

    private void initData() {
        if (getIntent().getExtras() != null) {
            this.hkH = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP, -1L);
            this.hkI = getIntent().getExtras().getInt("current_level", -1);
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    private void initUI() {
        this.mRootView = findViewById(a.f.ala_person_center_exp_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.h.sdk_prc_xp);
        this.hkD = (BdListView) findViewById(a.f.ala_person_center_exp_list);
        this.hkG = new c(getPageContext().getPageActivity());
        this.hkE = new a(this);
        this.hkD.setAdapter((ListAdapter) this.hkE);
        if (this.hkH == -1 || this.hkI == -1) {
            this.mRootView.setVisibility(8);
            this.hkF = new d(getPageContext(), this.hkM);
            this.hkF.OT();
            return;
        }
        bindDataToView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDataToView() {
        if (this.hkI < 1) {
            this.hkI = 1;
        } else if (this.hkI > 40) {
            this.hkI = 40;
        }
        this.hkK = (int) getResources().getDimension(a.d.sdk_ds364);
        this.hkL = (int) getResources().getDimension(a.d.sdk_ds168);
        bYq();
        this.hkG.w(this.hkH, this.hkI);
    }

    public void bYq() {
        bYr();
        bYs();
    }

    private void bYr() {
        if (this.isHost) {
            this.hkD.addHeaderView(this.hkG.bYv());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.hkD.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.bYt();
                    AlaPersonCenterExpActivity.this.bYu();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void bYs() {
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            b bVar = new b();
            bVar.level = i + 1;
            bVar.hkS = com.baidu.tieba.ala.live.personcenter.a.uQ(i);
            arrayList.add(bVar);
        }
        this.hkE.Z(arrayList);
        this.hkE.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYt() {
        if (Build.VERSION.SDK_INT >= 11 && this.hkG != null) {
            int i = this.hkK - (-this.hkG.bYv().getTop());
            if (i < this.hkL) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.hkL && i <= this.hkL * 2) {
                float f = 1.0f - (((i - this.hkL) * 1.0f) / this.hkL);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.hkL * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.hkD.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.hkJ) {
                this.hkJ = true;
            }
        } else if (this.hkJ) {
            this.hkJ = false;
        }
        b(alpha, this.hkJ ? false : true);
    }

    protected void b(float f, boolean z) {
        if (z) {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.c.sdk_cp_cont_b, a.c.sdk_s_navbar_title_color);
        } else {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.e.sdk_prc_btn_sml_back_selector_s, a.e.sdk_prc_btn_sml_back_selector_s);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
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
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(getResources(), SkinManager.getBitmapLowQuality(a.e.sdk_s_navbar_bg)));
        if (this.hkG != null) {
            this.hkG.b(this, i);
        }
        if (this.hkE != null) {
            this.hkE.notifyDataSetChanged();
            this.hkE.uR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hkF != null) {
            this.hkF.onDestroy();
        }
    }
}
