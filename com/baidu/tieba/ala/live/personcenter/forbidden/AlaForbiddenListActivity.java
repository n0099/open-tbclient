package com.baidu.tieba.ala.live.personcenter.forbidden;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.a;
/* loaded from: classes4.dex */
public class AlaForbiddenListActivity extends BaseFragmentActivity {
    private NoNetworkView gPz;
    private a gQT;
    private NavigationBar mNavigationBar;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.g.sdk_prc_person_forbiddenlist_layout);
            this.rootView = findViewById(a.f.ala_person_forbiddenlist_rootview);
            this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_person_forbiddenlist_navigation_bar);
            this.gPz = (NoNetworkView) findViewById(a.f.ala_person_forbiddenlist_no_network_view);
            this.gQT = new com.baidu.tieba.ala.live.personcenter.forbidden.c.a(getPageContext(), this.rootView);
            this.gQT.onCreate(bundle);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getString(a.h.sdk_prc_person_forbiddenlist_title));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gQT != null) {
            this.gQT.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gQT != null) {
            this.gQT.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gQT != null) {
            this.gQT.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gQT != null) {
            this.gQT.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQT != null) {
            this.gQT.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        SkinManager.setNavbarTitleColor(this.mNavigationBar.mTextTitle, a.c.sdk_cp_cont_b, a.c.sdk_s_navbar_title_color);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        SkinManager.setBackgroundResource(this.mNavigationBar, a.c.sdk_cp_bg_line_d);
        SkinManager.setBackgroundResource(this.rootView, a.c.sdk_cp_bg_line_d);
        if (this.gPz != null) {
            this.gPz.onChangeSkinType(getPageContext(), i);
        }
        if (this.gQT != null) {
            this.gQT.onChangeSkinType(i);
        }
    }
}
