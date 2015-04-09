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
    private String acU;
    private TextView awn;
    private TextView awo;
    private TextView awp;
    private TextView awq;
    private String awr;
    private String aws;
    private NavigationBar mNavigationBar;
    private final TextWatcher avs = new a(this);
    private final View.OnClickListener awt = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(y.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(y.appeal_submit_btn), this.awt);
        this.awn = (TextView) findViewById(v.forbid_id);
        this.awo = (TextView) findViewById(v.forbid_reason);
        this.awp = (TextView) findViewById(v.appeal_reason);
        this.awq = (TextView) findViewById(v.remain_text_count);
        this.awq.setText(String.valueOf(150));
        this.awp.setFocusable(true);
        this.awp.setFocusableInTouchMode(true);
        this.awp.requestFocus();
        n.d(getPageContext().getPageActivity(), this.awp);
        this.awp.addTextChangedListener(this.avs);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.awr = intent.getStringExtra("forum_id");
        this.aws = intent.getStringExtra("user_id");
        this.acU = intent.getStringExtra("user_name");
        j.a(this.awr, this.aws, new d(this));
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
        this.awp.setHintTextColor(ba.getColor(s.appeal_hint));
    }
}
