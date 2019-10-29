package com.baidu.tieba.ala.live.personcenter.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.ala.live.personcenter.admin.c.a;
/* loaded from: classes6.dex */
public class AlaAdminListActivity extends BaseFragmentActivity {
    private NoNetworkView dQO;
    private a dQP;
    private NavigationBar mNavigationBar;
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(a.h.sdk_prc_person_adminlist_layout);
        Intent intent = getIntent();
        if (intent == null) {
            str = null;
        } else {
            str = intent.getStringExtra(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID);
        }
        this.rootView = findViewById(a.g.ala_person_adminlist_rootview);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_person_adminlist_navigation_bar);
        this.dQO = (NoNetworkView) findViewById(a.g.ala_person_adminlist_no_network_view);
        this.dQP = new com.baidu.tieba.ala.live.personcenter.admin.c.a(getPageContext(), this.rootView, str);
        this.dQP.onCreate(bundle);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getString(a.i.sdk_prc_person_live_admin));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        SkinManager.setNavbarTitleColor(this.mNavigationBar.mTextTitle, a.d.sdk_cp_cont_b, a.d.sdk_s_navbar_title_color);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        SkinManager.setBackgroundResource(this.mNavigationBar, a.d.sdk_cp_bg_line_d);
        SkinManager.setBackgroundResource(this.rootView, a.d.sdk_cp_bg_line_d);
        if (this.dQO != null) {
            this.dQO.onChangeSkinType(getPageContext(), i);
        }
        if (this.dQP != null) {
            this.dQP.onChangeSkinType(i);
        }
    }
}
