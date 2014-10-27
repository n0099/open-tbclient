package com.baidu.tieba.account.appeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity {
    private TextView afM;
    private TextView afN;
    private TextView afO;
    private TextView afP;
    private String afQ;
    private String afR;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private TextWatcher aeW = new a(this);
    private View.OnClickListener afS = new b(this);

    public static void b(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, AppealActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID, str2);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME, str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getString(y.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(y.appeal_submit_btn), this.afS);
        this.afM = (TextView) findViewById(v.forbid_id);
        this.afN = (TextView) findViewById(v.forbid_reason);
        this.afO = (TextView) findViewById(v.appeal_reason);
        this.afP = (TextView) findViewById(v.remain_text_count);
        this.afP.setText(String.valueOf(150));
        this.afO.setFocusable(true);
        this.afO.setFocusableInTouchMode(true);
        this.afO.requestFocus();
        m.c(this, this.afO);
        this.afO.addTextChangedListener(this.aeW);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.afQ = intent.getStringExtra("forum_id");
        this.afR = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
        this.mUserName = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        j.a(this.afQ, this.afR, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(y.anti_title));
        builder.setMessage(str);
        builder.setPositiveButton(getString(y.anti_no_chance_pos), new e(this, z));
        com.baidu.adp.lib.g.j.a(builder.create(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(findViewById(v.root));
        this.mNavigationBar.onChangeSkinType(i);
        this.afO.setHintTextColor(aw.getColor(s.appeal_hint));
    }
}
