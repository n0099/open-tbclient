package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private String aec;
    private TextView axT;
    private TextView axU;
    private TextView axV;
    private TextView axW;
    private String axX;
    private String axY;
    private NavigationBar mNavigationBar;
    private final TextWatcher awT = new a(this);
    private final View.OnClickListener axZ = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.appeal_submit_btn), this.axZ);
        this.axT = (TextView) findViewById(q.forbid_id);
        this.axU = (TextView) findViewById(q.forbid_reason);
        this.axV = (TextView) findViewById(q.appeal_reason);
        this.axW = (TextView) findViewById(q.remain_text_count);
        this.axW.setText(String.valueOf(150));
        this.axV.setFocusable(true);
        this.axV.setFocusableInTouchMode(true);
        this.axV.requestFocus();
        n.d(getPageContext().getPageActivity(), this.axV);
        this.axV.addTextChangedListener(this.awT);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.axX = intent.getStringExtra("forum_id");
        this.axY = intent.getStringExtra("user_id");
        this.aec = intent.getStringExtra("user_name");
        j.a(this.axX, this.axY, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cn(str);
        aVar.a(getPageContext().getString(t.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.rL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(findViewById(q.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.axV.setHintTextColor(ay.getColor(com.baidu.tieba.n.appeal_hint));
    }
}
