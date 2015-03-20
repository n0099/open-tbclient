package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private String acM;
    private TextView awf;
    private TextView awg;
    private TextView awh;
    private TextView awi;
    private String awj;
    private String awk;
    private NavigationBar mNavigationBar;
    private final TextWatcher avk = new a(this);
    private final View.OnClickListener awl = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(y.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(y.appeal_submit_btn), this.awl);
        this.awf = (TextView) findViewById(v.forbid_id);
        this.awg = (TextView) findViewById(v.forbid_reason);
        this.awh = (TextView) findViewById(v.appeal_reason);
        this.awi = (TextView) findViewById(v.remain_text_count);
        this.awi.setText(String.valueOf(150));
        this.awh.setFocusable(true);
        this.awh.setFocusableInTouchMode(true);
        this.awh.requestFocus();
        n.d(getPageContext().getPageActivity(), this.awh);
        this.awh.addTextChangedListener(this.avk);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.awj = intent.getStringExtra("forum_id");
        this.awk = intent.getStringExtra("user_id");
        this.acM = intent.getStringExtra("user_name");
        j.a(this.awj, this.awk, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(getPageContext().getString(y.anti_title));
        aVar.ca(str);
        aVar.a(getPageContext().getString(y.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.re();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(findViewById(v.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.awh.setHintTextColor(ba.getColor(s.appeal_hint));
    }
}
