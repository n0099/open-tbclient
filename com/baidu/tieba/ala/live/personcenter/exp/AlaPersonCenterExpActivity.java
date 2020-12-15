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
    private BdListView gYR;
    private a gYS;
    private d gYT;
    private c gYU;
    private int gYY;
    private int gYZ;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private long gYV = -1;
    private int gYW = -1;
    private boolean isHost = true;
    private boolean gYX = true;
    private d.a gZa = new d.a() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void b(AlaLivePersonData alaLivePersonData) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaLiveUserInfoData alaLiveUserInfoData = alaLivePersonData.mUserData;
            if (alaLiveUserInfoData == null) {
                AlaPersonCenterExpActivity.this.gYV = 0L;
                AlaPersonCenterExpActivity.this.gYW = 1;
            } else {
                AlaPersonCenterExpActivity.this.gYV = alaLiveUserInfoData.levelExp;
                AlaPersonCenterExpActivity.this.gYW = alaLiveUserInfoData.levelId;
            }
            AlaPersonCenterExpActivity.this.bindDataToView();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void onFail(int i, String str) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaPersonCenterExpActivity.this.gYV = 0L;
            AlaPersonCenterExpActivity.this.gYW = 1;
            AlaPersonCenterExpActivity.this.bindDataToView();
        }
    };

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
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
            this.gYV = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP, -1L);
            this.gYW = getIntent().getExtras().getInt("current_level", -1);
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    private void initUI() {
        this.mRootView = findViewById(a.f.ala_person_center_exp_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.h.sdk_prc_xp);
        this.gYR = (BdListView) findViewById(a.f.ala_person_center_exp_list);
        this.gYU = new c(getPageContext().getPageActivity());
        this.gYS = new a(this);
        this.gYR.setAdapter((ListAdapter) this.gYS);
        if (this.gYV == -1 || this.gYW == -1) {
            this.mRootView.setVisibility(8);
            this.gYT = new d(getPageContext(), this.gZa);
            this.gYT.Ql();
            return;
        }
        bindDataToView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDataToView() {
        if (this.gYW < 1) {
            this.gYW = 1;
        } else if (this.gYW > 40) {
            this.gYW = 40;
        }
        this.gYY = (int) getResources().getDimension(a.d.sdk_ds364);
        this.gYZ = (int) getResources().getDimension(a.d.sdk_ds168);
        bYv();
        this.gYU.w(this.gYV, this.gYW);
    }

    public void bYv() {
        bYw();
        bYx();
    }

    private void bYw() {
        if (this.isHost) {
            this.gYR.addHeaderView(this.gYU.bYA());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.gYR.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.bYy();
                    AlaPersonCenterExpActivity.this.bYz();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void bYx() {
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            b bVar = new b();
            bVar.level = i + 1;
            bVar.gZg = com.baidu.tieba.ala.live.personcenter.a.wb(i);
            arrayList.add(bVar);
        }
        this.gYS.af(arrayList);
        this.gYS.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYy() {
        if (Build.VERSION.SDK_INT >= 11 && this.gYU != null) {
            int i = this.gYY - (-this.gYU.bYA().getTop());
            if (i < this.gYZ) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.gYZ && i <= this.gYZ * 2) {
                float f = 1.0f - (((i - this.gYZ) * 1.0f) / this.gYZ);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.gYZ * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.gYR.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYz() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.gYX) {
                this.gYX = true;
            }
        } else if (this.gYX) {
            this.gYX = false;
        }
        a(alpha, this.gYX ? false : true);
    }

    protected void a(float f, boolean z) {
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
        if (this.gYU != null) {
            this.gYU.b(this, i);
        }
        if (this.gYS != null) {
            this.gYS.notifyDataSetChanged();
            this.gYS.wc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gYT != null) {
            this.gYT.onDestroy();
        }
    }
}
