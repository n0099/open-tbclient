package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aPU;
    private TextView aPV;
    private TextView aPW;
    private TextView aPX;
    private String aPY;
    private String aPZ;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher mTextWatcher = new a(this);
    private final View.OnClickListener aQa = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.j.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(r.l.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.l.push_commit), this.aQa);
        this.aPU = (TextView) findViewById(r.h.forbid_id);
        this.aPV = (TextView) findViewById(r.h.forbid_reason);
        this.aPW = (TextView) findViewById(r.h.appeal_reason);
        this.aPX = (TextView) findViewById(r.h.remain_text_count);
        this.aPX.setText(String.valueOf(150));
        this.aPW.setFocusable(true);
        this.aPW.setFocusableInTouchMode(true);
        this.aPW.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aPW);
        this.aPW.addTextChangedListener(this.mTextWatcher);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aPY = intent.getStringExtra("forum_id");
        this.aPZ = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aPY, this.aPZ, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(str);
        aVar.a(getPageContext().getString(r.l.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.sV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(findViewById(r.h.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aPW.setHintTextColor(ap.getColor(r.e.common_color_10005));
    }
}
