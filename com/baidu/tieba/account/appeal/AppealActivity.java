package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aUD;
    private TextView aUE;
    private TextView aUF;
    private TextView aUG;
    private String aUH;
    private String aUI;
    private final TextWatcher aUJ = new a(this);
    private final View.OnClickListener aUK = new b(this);
    private NavigationBar mNavigationBar;
    private String mUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(r.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.appeal_submit_btn), this.aUK);
        this.aUD = (TextView) findViewById(r.g.forbid_id);
        this.aUE = (TextView) findViewById(r.g.forbid_reason);
        this.aUF = (TextView) findViewById(r.g.appeal_reason);
        this.aUG = (TextView) findViewById(r.g.remain_text_count);
        this.aUG.setText(String.valueOf(150));
        this.aUF.setFocusable(true);
        this.aUF.setFocusableInTouchMode(true);
        this.aUF.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aUF);
        this.aUF.addTextChangedListener(this.aUJ);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aUH = intent.getStringExtra("forum_id");
        this.aUI = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aUH, this.aUI, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cG(str);
        aVar.a(getPageContext().getString(r.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(findViewById(r.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aUF.setHintTextColor(ar.getColor(r.d.common_color_10005));
    }
}
