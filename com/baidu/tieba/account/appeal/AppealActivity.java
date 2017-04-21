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
    private TextView aVV;
    private TextView aVW;
    private TextView aVX;
    private TextView aVY;
    private String aVZ;
    private String aWa;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher mTextWatcher = new a(this);
    private final View.OnClickListener aWb = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(w.l.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(w.l.push_commit), this.aWb);
        this.aVV = (TextView) findViewById(w.h.forbid_id);
        this.aVW = (TextView) findViewById(w.h.forbid_reason);
        this.aVX = (TextView) findViewById(w.h.appeal_reason);
        this.aVY = (TextView) findViewById(w.h.remain_text_count);
        this.aVY.setText(String.valueOf((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY));
        this.aVX.setFocusable(true);
        this.aVX.setFocusableInTouchMode(true);
        this.aVX.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aVX);
        this.aVX.addTextChangedListener(this.mTextWatcher);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aVZ = intent.getStringExtra("forum_id");
        this.aWa = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aVZ, this.aWa, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(str);
        aVar.a(getPageContext().getString(w.l.confirm), new e(this, z));
        aVar.b(getPageContext());
        aVar.tQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(findViewById(w.h.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aVX.setHintTextColor(aq.getColor(w.e.common_color_10005));
    }
}
