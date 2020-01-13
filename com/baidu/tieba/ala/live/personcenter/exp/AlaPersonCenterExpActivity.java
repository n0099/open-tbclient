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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.tieba.ala.live.personcenter.exp.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaPersonCenterExpActivity extends BaseActivity<AlaPersonCenterExpActivity> {
    private BdListView eHf;
    private a eHg;
    private d eHh;
    private c eHi;
    private int eHm;
    private int eHn;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private long eHj = -1;
    private int eHk = -1;
    private boolean isHost = true;
    private boolean eHl = true;
    private d.a eHo = new d.a() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void a(AlaLivePersonData alaLivePersonData) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaLiveUserInfoData alaLiveUserInfoData = alaLivePersonData.mUserData;
            if (alaLiveUserInfoData == null) {
                AlaPersonCenterExpActivity.this.eHj = 0L;
                AlaPersonCenterExpActivity.this.eHk = 1;
            } else {
                AlaPersonCenterExpActivity.this.eHj = alaLiveUserInfoData.levelExp;
                AlaPersonCenterExpActivity.this.eHk = alaLiveUserInfoData.levelId;
            }
            AlaPersonCenterExpActivity.this.bindDataToView();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void onFail(int i, String str) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaPersonCenterExpActivity.this.eHj = 0L;
            AlaPersonCenterExpActivity.this.eHk = 1;
            AlaPersonCenterExpActivity.this.bindDataToView();
        }
    };

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.sdk_prc_person_center_exp_layout);
        initData();
        initUI();
    }

    private void initData() {
        if (getIntent().getExtras() != null) {
            this.eHj = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP, -1L);
            this.eHk = getIntent().getExtras().getInt("current_level", -1);
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    private void initUI() {
        this.mRootView = findViewById(a.g.ala_person_center_exp_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_xp);
        this.eHf = (BdListView) findViewById(a.g.ala_person_center_exp_list);
        this.eHi = new c(getPageContext().getPageActivity());
        this.eHg = new a(this);
        this.eHf.setAdapter((ListAdapter) this.eHg);
        if (this.eHj == -1 || this.eHk == -1) {
            this.mRootView.setVisibility(8);
            this.eHh = new d(getPageContext(), this.eHo);
            this.eHh.bev();
            return;
        }
        bindDataToView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDataToView() {
        if (this.eHk < 1) {
            this.eHk = 1;
        } else if (this.eHk > 40) {
            this.eHk = 40;
        }
        this.eHm = (int) getResources().getDimension(a.e.sdk_ds364);
        this.eHn = (int) getResources().getDimension(a.e.sdk_ds168);
        beo();
        this.eHi.i(this.eHj, this.eHk);
    }

    public void beo() {
        bep();
        beq();
    }

    private void bep() {
        if (this.isHost) {
            this.eHf.addHeaderView(this.eHi.bet());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.eHf.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.ber();
                    AlaPersonCenterExpActivity.this.bes();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void beq() {
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            b bVar = new b();
            bVar.level = i + 1;
            bVar.eHv = com.baidu.tieba.ala.live.personcenter.a.pj(i);
            arrayList.add(bVar);
        }
        this.eHg.T(arrayList);
        this.eHg.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ber() {
        if (Build.VERSION.SDK_INT >= 11 && this.eHi != null) {
            int i = this.eHm - (-this.eHi.bet().getTop());
            if (i < this.eHn) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.eHn && i <= this.eHn * 2) {
                float f = 1.0f - (((i - this.eHn) * 1.0f) / this.eHn);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.eHn * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.eHf.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bes() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.eHl) {
                this.eHl = true;
            }
        } else if (this.eHl) {
            this.eHl = false;
        }
        a(alpha, this.eHl ? false : true);
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
        if (this.eHi != null) {
            this.eHi.b(this, i);
        }
        if (this.eHg != null) {
            this.eHg.notifyDataSetChanged();
            this.eHg.pl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eHh != null) {
            this.eHh.onDestroy();
        }
    }
}
