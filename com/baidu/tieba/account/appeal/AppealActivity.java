package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aFl;
    private TextView aFm;
    private TextView aFn;
    private TextView aFo;
    private String aFp;
    private String aFq;
    private String ajl;
    private NavigationBar mNavigationBar;
    private final TextWatcher aEl = new a(this);
    private final View.OnClickListener aFr = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.C0057i.appeal_submit_btn), this.aFr);
        this.aFl = (TextView) findViewById(i.f.forbid_id);
        this.aFm = (TextView) findViewById(i.f.forbid_reason);
        this.aFn = (TextView) findViewById(i.f.appeal_reason);
        this.aFo = (TextView) findViewById(i.f.remain_text_count);
        this.aFo.setText(String.valueOf((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED));
        this.aFn.setFocusable(true);
        this.aFn.setFocusableInTouchMode(true);
        this.aFn.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aFn);
        this.aFn.addTextChangedListener(this.aEl);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aFp = intent.getStringExtra("forum_id");
        this.aFq = intent.getStringExtra("user_id");
        this.ajl = intent.getStringExtra("user_name");
        g.a(this.aFp, this.aFq, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cn(str);
        aVar.a(getPageContext().getString(i.C0057i.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.sP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(findViewById(i.f.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aFn.setHintTextColor(al.getColor(i.c.appeal_hint));
    }
}
