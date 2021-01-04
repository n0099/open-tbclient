package com.baidu.tieba.ala.live.personcenter.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.ala.live.personcenter.admin.c.a;
/* loaded from: classes11.dex */
public class AlaAdminListActivity extends BaseFragmentActivity {
    private NoNetworkView hkk;
    private a hkl;
    private NavigationBar mNavigationBar;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.g.sdk_prc_person_adminlist_layout);
            Intent intent = getIntent();
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID);
            }
            this.rootView = findViewById(a.f.ala_person_adminlist_rootview);
            this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_person_adminlist_navigation_bar);
            this.hkk = (NoNetworkView) findViewById(a.f.ala_person_adminlist_no_network_view);
            this.hkl = new com.baidu.tieba.ala.live.personcenter.admin.c.a(getPageContext(), this.rootView, str);
            this.hkl.onCreate(bundle);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getString(a.h.sdk_prc_person_live_admin));
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
        if (this.hkk != null) {
            this.hkk.onChangeSkinType(getPageContext(), i);
        }
        if (this.hkl != null) {
            this.hkl.onChangeSkinType(i);
        }
    }
}
