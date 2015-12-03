package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aHe;
    private TextView aHf;
    private TextView aHg;
    private TextView aHh;
    private String aHi;
    private String aHj;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aGT = new a(this);
    private final View.OnClickListener aHk = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.i.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.i.appeal_submit_btn), this.aHk);
        this.aHe = (TextView) findViewById(n.f.forbid_id);
        this.aHf = (TextView) findViewById(n.f.forbid_reason);
        this.aHg = (TextView) findViewById(n.f.appeal_reason);
        this.aHh = (TextView) findViewById(n.f.remain_text_count);
        this.aHh.setText(String.valueOf(150));
        this.aHg.setFocusable(true);
        this.aHg.setFocusableInTouchMode(true);
        this.aHg.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aHg);
        this.aHg.addTextChangedListener(this.aGT);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aHi = intent.getStringExtra("forum_id");
        this.aHj = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aHi, this.aHj, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cC(str);
        aVar.a(getPageContext().getString(n.i.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.tv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(findViewById(n.f.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aHg.setHintTextColor(as.getColor(n.c.appeal_hint));
    }
}
