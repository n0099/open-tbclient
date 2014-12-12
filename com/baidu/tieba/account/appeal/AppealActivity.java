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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView anl;
    private TextView anm;
    private TextView ann;
    private TextView ano;
    private String anp;
    private String anq;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private TextWatcher amu = new a(this);
    private View.OnClickListener anr = new b(this);

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
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(z.appeal_submit_btn), this.anr);
        this.anl = (TextView) findViewById(w.forbid_id);
        this.anm = (TextView) findViewById(w.forbid_reason);
        this.ann = (TextView) findViewById(w.appeal_reason);
        this.ano = (TextView) findViewById(w.remain_text_count);
        this.ano.setText(String.valueOf(150));
        this.ann.setFocusable(true);
        this.ann.setFocusableInTouchMode(true);
        this.ann.requestFocus();
        com.baidu.adp.lib.util.l.d(getPageContext().getPageActivity(), this.ann);
        this.ann.addTextChangedListener(this.amu);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.anp = intent.getStringExtra("forum_id");
        this.anq = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        j.a(this.anp, this.anq, new d(this));
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
        this.ann.setHintTextColor(ax.getColor(t.appeal_hint));
    }
}
