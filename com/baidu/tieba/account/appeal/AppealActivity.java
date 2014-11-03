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
    private TextView afU;
    private TextView afV;
    private TextView afW;
    private TextView afX;
    private String afY;
    private String afZ;
    private TextWatcher afe = new a(this);
    private View.OnClickListener aga = new b(this);
    private NavigationBar mNavigationBar;
    private String mUserName;

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
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(y.appeal_submit_btn), this.aga);
        this.afU = (TextView) findViewById(v.forbid_id);
        this.afV = (TextView) findViewById(v.forbid_reason);
        this.afW = (TextView) findViewById(v.appeal_reason);
        this.afX = (TextView) findViewById(v.remain_text_count);
        this.afX.setText(String.valueOf(150));
        this.afW.setFocusable(true);
        this.afW.setFocusableInTouchMode(true);
        this.afW.requestFocus();
        m.c(this, this.afW);
        this.afW.addTextChangedListener(this.afe);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.afY = intent.getStringExtra("forum_id");
        this.afZ = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
        this.mUserName = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        j.a(this.afY, this.afZ, new d(this));
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
        this.afW.setHintTextColor(aw.getColor(s.appeal_hint));
    }
}
