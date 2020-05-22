package com.baidu.tieba.ala.live.personcenter.forbidden;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.a;
/* loaded from: classes3.dex */
public class AlaForbiddenListActivity extends BaseFragmentActivity {
    private NoNetworkView fDF;
    private a fFb;
    private NavigationBar mNavigationBar;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.h.sdk_prc_person_forbiddenlist_layout);
            this.rootView = findViewById(a.g.ala_person_forbiddenlist_rootview);
            this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_forbiddenlist_navigation_bar);
            this.fDF = (NoNetworkView) findViewById(a.g.ala_person_forbiddenlist_no_network_view);
            this.fFb = new com.baidu.tieba.ala.live.personcenter.forbidden.c.a(getPageContext(), this.rootView);
            this.fFb.onCreate(bundle);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getString(a.i.sdk_prc_person_forbiddenlist_title));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fFb != null) {
            this.fFb.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fFb != null) {
            this.fFb.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fFb != null) {
            this.fFb.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fFb != null) {
            this.fFb.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fFb != null) {
            this.fFb.onDestroy();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        SkinManager.setNavbarTitleColor(this.mNavigationBar.mTextTitle, a.d.sdk_cp_cont_b, a.d.sdk_s_navbar_title_color);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        SkinManager.setBackgroundResource(this.mNavigationBar, a.d.sdk_cp_bg_line_d);
        SkinManager.setBackgroundResource(this.rootView, a.d.sdk_cp_bg_line_d);
        if (this.fDF != null) {
            this.fDF.onChangeSkinType(getPageContext(), i);
        }
        if (this.fFb != null) {
            this.fFb.onChangeSkinType(i);
        }
    }
}
