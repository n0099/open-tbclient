package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aMH;
    private TextView aMI;
    private TextView aMJ;
    private TextView aMK;
    private String aML;
    private String aMM;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aMu = new a(this);
    private final View.OnClickListener aMN = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.appeal_submit_btn), this.aMN);
        this.aMH = (TextView) findViewById(t.g.forbid_id);
        this.aMI = (TextView) findViewById(t.g.forbid_reason);
        this.aMJ = (TextView) findViewById(t.g.appeal_reason);
        this.aMK = (TextView) findViewById(t.g.remain_text_count);
        this.aMK.setText(String.valueOf(150));
        this.aMJ.setFocusable(true);
        this.aMJ.setFocusableInTouchMode(true);
        this.aMJ.requestFocus();
        k.d(getPageContext().getPageActivity(), this.aMJ);
        this.aMJ.addTextChangedListener(this.aMu);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aML = intent.getStringExtra("forum_id");
        this.aMM = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aML, this.aMM, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cC(str);
        aVar.a(getPageContext().getString(t.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.up();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(findViewById(t.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aMJ.setHintTextColor(at.getColor(t.d.appeal_hint));
    }
}
