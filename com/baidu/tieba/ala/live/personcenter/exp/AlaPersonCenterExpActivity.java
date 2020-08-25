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
/* loaded from: classes7.dex */
public class AlaPersonCenterExpActivity extends BaseActivity<AlaPersonCenterExpActivity> {
    private BdListView ggN;
    private a ggO;
    private d ggP;
    private c ggQ;
    private int ggU;
    private int ggV;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private long ggR = -1;
    private int ggS = -1;
    private boolean isHost = true;
    private boolean ggT = true;
    private d.a ggW = new d.a() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void b(AlaLivePersonData alaLivePersonData) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaLiveUserInfoData alaLiveUserInfoData = alaLivePersonData.mUserData;
            if (alaLiveUserInfoData == null) {
                AlaPersonCenterExpActivity.this.ggR = 0L;
                AlaPersonCenterExpActivity.this.ggS = 1;
            } else {
                AlaPersonCenterExpActivity.this.ggR = alaLiveUserInfoData.levelExp;
                AlaPersonCenterExpActivity.this.ggS = alaLiveUserInfoData.levelId;
            }
            AlaPersonCenterExpActivity.this.bindDataToView();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void onFail(int i, String str) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaPersonCenterExpActivity.this.ggR = 0L;
            AlaPersonCenterExpActivity.this.ggS = 1;
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
            this.ggR = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP, -1L);
            this.ggS = getIntent().getExtras().getInt("current_level", -1);
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    private void initUI() {
        this.mRootView = findViewById(a.g.ala_person_center_exp_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_xp);
        this.ggN = (BdListView) findViewById(a.g.ala_person_center_exp_list);
        this.ggQ = new c(getPageContext().getPageActivity());
        this.ggO = new a(this);
        this.ggN.setAdapter((ListAdapter) this.ggO);
        if (this.ggR == -1 || this.ggS == -1) {
            this.mRootView.setVisibility(8);
            this.ggP = new d(getPageContext(), this.ggW);
            this.ggP.LW();
            return;
        }
        bindDataToView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDataToView() {
        if (this.ggS < 1) {
            this.ggS = 1;
        } else if (this.ggS > 40) {
            this.ggS = 40;
        }
        this.ggU = (int) getResources().getDimension(a.e.sdk_ds364);
        this.ggV = (int) getResources().getDimension(a.e.sdk_ds168);
        bLu();
        this.ggQ.j(this.ggR, this.ggS);
    }

    public void bLu() {
        bLv();
        bLw();
    }

    private void bLv() {
        if (this.isHost) {
            this.ggN.addHeaderView(this.ggQ.bLz());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.ggN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.bLx();
                    AlaPersonCenterExpActivity.this.bLy();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void bLw() {
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            b bVar = new b();
            bVar.level = i + 1;
            bVar.ghc = com.baidu.tieba.ala.live.personcenter.a.tv(i);
            arrayList.add(bVar);
        }
        this.ggO.ad(arrayList);
        this.ggO.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLx() {
        if (Build.VERSION.SDK_INT >= 11 && this.ggQ != null) {
            int i = this.ggU - (-this.ggQ.bLz().getTop());
            if (i < this.ggV) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.ggV && i <= this.ggV * 2) {
                float f = 1.0f - (((i - this.ggV) * 1.0f) / this.ggV);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.ggV * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.ggN.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.ggT) {
                this.ggT = true;
            }
        } else if (this.ggT) {
            this.ggT = false;
        }
        a(alpha, this.ggT ? false : true);
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
        if (this.ggQ != null) {
            this.ggQ.b(this, i);
        }
        if (this.ggO != null) {
            this.ggO.notifyDataSetChanged();
            this.ggO.tw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ggP != null) {
            this.ggP.onDestroy();
        }
    }
}
