package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aEf;
    private TextView aEg;
    private TextView aEh;
    private TextView aEi;
    private String aEj;
    private String aEk;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aDU = new a(this);
    private final View.OnClickListener aEl = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.appeal_submit_btn), this.aEl);
        this.aEf = (TextView) findViewById(i.f.forbid_id);
        this.aEg = (TextView) findViewById(i.f.forbid_reason);
        this.aEh = (TextView) findViewById(i.f.appeal_reason);
        this.aEi = (TextView) findViewById(i.f.remain_text_count);
        this.aEi.setText(String.valueOf((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED));
        this.aEh.setFocusable(true);
        this.aEh.setFocusableInTouchMode(true);
        this.aEh.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aEh);
        this.aEh.addTextChangedListener(this.aDU);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aEj = intent.getStringExtra("forum_id");
        this.aEk = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aEj, this.aEk, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cu(str);
        aVar.a(getPageContext().getString(i.h.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.sR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(findViewById(i.f.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aEh.setHintTextColor(an.getColor(i.c.appeal_hint));
    }
}
