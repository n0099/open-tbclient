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
    private TextView aIG;
    private TextView aIH;
    private TextView aII;
    private TextView aIJ;
    private String aIK;
    private String aIL;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aIu = new a(this);
    private final View.OnClickListener aIM = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.appeal_submit_btn), this.aIM);
        this.aIG = (TextView) findViewById(n.g.forbid_id);
        this.aIH = (TextView) findViewById(n.g.forbid_reason);
        this.aII = (TextView) findViewById(n.g.appeal_reason);
        this.aIJ = (TextView) findViewById(n.g.remain_text_count);
        this.aIJ.setText(String.valueOf(150));
        this.aII.setFocusable(true);
        this.aII.setFocusableInTouchMode(true);
        this.aII.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aII);
        this.aII.addTextChangedListener(this.aIu);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aIK = intent.getStringExtra("forum_id");
        this.aIL = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aIK, this.aIL, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cF(str);
        aVar.a(getPageContext().getString(n.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.tf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(findViewById(n.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aII.setHintTextColor(as.getColor(n.d.appeal_hint));
    }
}
