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
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.personcenter.exp.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaPersonCenterExpActivity extends BaseActivity<AlaPersonCenterExpActivity> {
    private BdListView eLJ;
    private a eLK;
    private d eLL;
    private c eLM;
    private int eLQ;
    private int eLR;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private long eLN = -1;
    private int eLO = -1;
    private boolean isHost = true;
    private boolean eLP = true;
    private d.a eLS = new d.a() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void b(AlaLivePersonData alaLivePersonData) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaLiveUserInfoData alaLiveUserInfoData = alaLivePersonData.mUserData;
            if (alaLiveUserInfoData == null) {
                AlaPersonCenterExpActivity.this.eLN = 0L;
                AlaPersonCenterExpActivity.this.eLO = 1;
            } else {
                AlaPersonCenterExpActivity.this.eLN = alaLiveUserInfoData.levelExp;
                AlaPersonCenterExpActivity.this.eLO = alaLiveUserInfoData.levelId;
            }
            AlaPersonCenterExpActivity.this.bindDataToView();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.exp.d.a
        public void onFail(int i, String str) {
            AlaPersonCenterExpActivity.this.mRootView.setVisibility(0);
            AlaPersonCenterExpActivity.this.eLN = 0L;
            AlaPersonCenterExpActivity.this.eLO = 1;
            AlaPersonCenterExpActivity.this.bindDataToView();
        }
    };

    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        setContentView(a.h.sdk_prc_person_center_exp_layout);
        initData();
        initUI();
    }

    private void initData() {
        if (getIntent().getExtras() != null) {
            this.eLN = getIntent().getExtras().getLong(AlaPersonCenterExpActivityConfig.CURRENT_EXP, -1L);
            this.eLO = getIntent().getExtras().getInt("current_level", -1);
            this.isHost = getIntent().getExtras().getBoolean(AlaPersonCenterExpActivityConfig.IS_HOST);
        }
    }

    private void initUI() {
        this.mRootView = findViewById(a.g.ala_person_center_exp_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_center_exp_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_xp);
        this.eLJ = (BdListView) findViewById(a.g.ala_person_center_exp_list);
        this.eLM = new c(getPageContext().getPageActivity());
        this.eLK = new a(this);
        this.eLJ.setAdapter((ListAdapter) this.eLK);
        if (this.eLN == -1 || this.eLO == -1) {
            this.mRootView.setVisibility(8);
            this.eLL = new d(getPageContext(), this.eLS);
            this.eLL.bgN();
            return;
        }
        bindDataToView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDataToView() {
        if (this.eLO < 1) {
            this.eLO = 1;
        } else if (this.eLO > 40) {
            this.eLO = 40;
        }
        this.eLQ = (int) getResources().getDimension(a.e.sdk_ds364);
        this.eLR = (int) getResources().getDimension(a.e.sdk_ds168);
        bgG();
        this.eLM.i(this.eLN, this.eLO);
    }

    public void bgG() {
        bgH();
        bgI();
    }

    private void bgH() {
        if (this.isHost) {
            this.eLJ.addHeaderView(this.eLM.bgL());
            this.mNavigationBar.showBottomLine(false);
            setUseStyleImmersiveSticky(true);
            this.eLJ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.exp.AlaPersonCenterExpActivity.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    AlaPersonCenterExpActivity.this.bgJ();
                    AlaPersonCenterExpActivity.this.bgK();
                }
            });
            return;
        }
        this.mNavigationBar.showBottomLine(true);
        setUseStyleImmersiveSticky(false);
    }

    private void bgI() {
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            b bVar = new b();
            bVar.level = i + 1;
            bVar.eLZ = com.baidu.tieba.ala.live.personcenter.a.px(i);
            arrayList.add(bVar);
        }
        this.eLK.V(arrayList);
        this.eLK.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.eLM != null) {
            int i = this.eLQ - (-this.eLM.bgL().getTop());
            if (i < this.eLR) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.eLR && i <= this.eLR * 2) {
                float f = 1.0f - (((i - this.eLR) * 1.0f) / this.eLR);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.eLR * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.eLJ.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgK() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.eLP) {
                this.eLP = true;
            }
        } else if (this.eLP) {
            this.eLP = false;
        }
        a(alpha, this.eLP ? false : true);
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
        if (this.eLM != null) {
            this.eLM.b(this, i);
        }
        if (this.eLK != null) {
            this.eLK.notifyDataSetChanged();
            this.eLK.pz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eLL != null) {
            this.eLL.onDestroy();
        }
    }
}
