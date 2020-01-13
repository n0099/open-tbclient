package com.baidu.tieba.ala.live.personcenter.forbidden;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.a;
/* loaded from: classes2.dex */
public class AlaForbiddenListActivity extends BaseFragmentActivity {
    private NoNetworkView eGJ;
    private a eIg;
    private NavigationBar mNavigationBar;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.sdk_prc_person_forbiddenlist_layout);
        this.rootView = findViewById(a.g.ala_person_forbiddenlist_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_forbiddenlist_navigation_bar);
        this.eGJ = (NoNetworkView) findViewById(a.g.ala_person_forbiddenlist_no_network_view);
        this.eIg = new com.baidu.tieba.ala.live.personcenter.forbidden.c.a(getPageContext(), this.rootView);
        this.eIg.onCreate(bundle);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getString(a.i.sdk_prc_person_forbiddenlist_title));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.eIg != null) {
            this.eIg.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eIg != null) {
            this.eIg.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eIg != null) {
            this.eIg.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eIg != null) {
            this.eIg.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eIg != null) {
            this.eIg.onDestroy();
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
        if (this.eGJ != null) {
            this.eGJ.onChangeSkinType(getPageContext(), i);
        }
        if (this.eIg != null) {
            this.eIg.onChangeSkinType(i);
        }
    }
}
