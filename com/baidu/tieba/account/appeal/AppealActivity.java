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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aVm;
    private TextView aVn;
    private TextView aVo;
    private TextView aVp;
    private String aVq;
    private String aVr;
    private final TextWatcher aVs = new a(this);
    private final View.OnClickListener aVt = new b(this);
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
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(r.j.appeal_submit_btn), this.aVt);
        this.aVm = (TextView) findViewById(r.g.forbid_id);
        this.aVn = (TextView) findViewById(r.g.forbid_reason);
        this.aVo = (TextView) findViewById(r.g.appeal_reason);
        this.aVp = (TextView) findViewById(r.g.remain_text_count);
        this.aVp.setText(String.valueOf(150));
        this.aVo.setFocusable(true);
        this.aVo.setFocusableInTouchMode(true);
        this.aVo.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aVo);
        this.aVo.addTextChangedListener(this.aVs);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aVq = intent.getStringExtra("forum_id");
        this.aVr = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aVq, this.aVr, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cF(str);
        aVar.a(getPageContext().getString(r.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.tq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(findViewById(r.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aVo.setHintTextColor(at.getColor(r.d.common_color_10005));
    }
}
