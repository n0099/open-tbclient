package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aTT;
    private TextView aTU;
    private TextView aTV;
    private TextView aTW;
    private String aTX;
    private String aTY;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher mTextWatcher = new a(this);
    private final View.OnClickListener aTZ = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(w.l.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.push_commit), this.aTZ);
        this.aTT = (TextView) findViewById(w.h.forbid_id);
        this.aTU = (TextView) findViewById(w.h.forbid_reason);
        this.aTV = (TextView) findViewById(w.h.appeal_reason);
        this.aTW = (TextView) findViewById(w.h.remain_text_count);
        this.aTW.setText(String.valueOf((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY));
        this.aTV.setFocusable(true);
        this.aTV.setFocusableInTouchMode(true);
        this.aTV.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aTV);
        this.aTV.addTextChangedListener(this.mTextWatcher);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aTX = intent.getStringExtra("forum_id");
        this.aTY = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aTX, this.aTY, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cB(str);
        aVar.a(getPageContext().getString(w.l.confirm), new e(this, z));
        aVar.b(getPageContext());
        aVar.tc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(w.h.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aTV.setHintTextColor(aq.getColor(w.e.common_color_10005));
    }
}
