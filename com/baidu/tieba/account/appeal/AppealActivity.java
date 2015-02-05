package com.baidu.tieba.account.appeal;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aod;
    private TextView aoe;
    private TextView aof;
    private TextView aog;
    private String aoh;
    private String aoi;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private TextWatcher anl = new a(this);
    private View.OnClickListener aoj = new b(this);

    static {
        TbadkApplication.getInst().RegisterIntent(AppealActivityConfig.class, AppealActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(z.appeal_submit_btn), this.aoj);
        this.aod = (TextView) findViewById(w.forbid_id);
        this.aoe = (TextView) findViewById(w.forbid_reason);
        this.aof = (TextView) findViewById(w.appeal_reason);
        this.aog = (TextView) findViewById(w.remain_text_count);
        this.aog.setText(String.valueOf(150));
        this.aof.setFocusable(true);
        this.aof.setFocusableInTouchMode(true);
        this.aof.requestFocus();
        com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), this.aof);
        this.aof.addTextChangedListener(this.anl);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aoh = intent.getStringExtra("forum_id");
        this.aoi = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        j.a(this.aoh, this.aoi, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setTitle(getPageContext().getString(z.anti_title));
        builder.setMessage(str);
        builder.setPositiveButton(getPageContext().getString(z.anti_no_chance_pos), new e(this, z));
        com.baidu.adp.lib.g.k.a(builder.create(), getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(findViewById(w.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aof.setHintTextColor(bc.getColor(t.appeal_hint));
    }
}
