package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aFa;
    private TextView aFb;
    private TextView aFc;
    private TextView aFd;
    private String aFe;
    private String aFf;
    private String aiq;
    private NavigationBar mNavigationBar;
    private final TextWatcher aEP = new a(this);
    private final View.OnClickListener aFg = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.appeal_submit_btn), this.aFg);
        this.aFa = (TextView) findViewById(i.f.forbid_id);
        this.aFb = (TextView) findViewById(i.f.forbid_reason);
        this.aFc = (TextView) findViewById(i.f.appeal_reason);
        this.aFd = (TextView) findViewById(i.f.remain_text_count);
        this.aFd.setText(String.valueOf((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED));
        this.aFc.setFocusable(true);
        this.aFc.setFocusableInTouchMode(true);
        this.aFc.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aFc);
        this.aFc.addTextChangedListener(this.aEP);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aFe = intent.getStringExtra("forum_id");
        this.aFf = intent.getStringExtra("user_id");
        this.aiq = intent.getStringExtra("user_name");
        g.a(this.aFe, this.aFf, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ct(str);
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
        this.aFc.setHintTextColor(am.getColor(i.c.appeal_hint));
    }
}
