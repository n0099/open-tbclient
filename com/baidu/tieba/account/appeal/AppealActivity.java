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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aJL;
    private TextView aJM;
    private TextView aJN;
    private TextView aJO;
    private String aJP;
    private String aJQ;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aJy = new a(this);
    private final View.OnClickListener aJR = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.appeal_submit_btn), this.aJR);
        this.aJL = (TextView) findViewById(t.g.forbid_id);
        this.aJM = (TextView) findViewById(t.g.forbid_reason);
        this.aJN = (TextView) findViewById(t.g.appeal_reason);
        this.aJO = (TextView) findViewById(t.g.remain_text_count);
        this.aJO.setText(String.valueOf(150));
        this.aJN.setFocusable(true);
        this.aJN.setFocusableInTouchMode(true);
        this.aJN.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aJN);
        this.aJN.addTextChangedListener(this.aJy);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aJP = intent.getStringExtra("forum_id");
        this.aJQ = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aJP, this.aJQ, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(str);
        aVar.a(getPageContext().getString(t.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.uj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(findViewById(t.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aJN.setHintTextColor(ar.getColor(t.d.appeal_hint));
    }
}
