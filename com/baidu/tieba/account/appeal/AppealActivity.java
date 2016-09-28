package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aTl;
    private TextView aTm;
    private TextView aTn;
    private TextView aTo;
    private String aTp;
    private String aTq;
    private final TextWatcher aTr = new a(this);
    private final View.OnClickListener aTs = new b(this);
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
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.appeal_submit_btn), this.aTs);
        this.aTl = (TextView) findViewById(r.g.forbid_id);
        this.aTm = (TextView) findViewById(r.g.forbid_reason);
        this.aTn = (TextView) findViewById(r.g.appeal_reason);
        this.aTo = (TextView) findViewById(r.g.remain_text_count);
        this.aTo.setText(String.valueOf(150));
        this.aTn.setFocusable(true);
        this.aTn.setFocusableInTouchMode(true);
        this.aTn.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aTn);
        this.aTn.addTextChangedListener(this.aTr);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aTp = intent.getStringExtra("forum_id");
        this.aTq = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aTp, this.aTq, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cD(str);
        aVar.a(getPageContext().getString(r.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.tm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(findViewById(r.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aTn.setHintTextColor(av.getColor(r.d.common_color_10005));
    }
}
