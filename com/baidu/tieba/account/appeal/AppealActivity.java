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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aNi;
    private TextView aNj;
    private TextView aNk;
    private TextView aNl;
    private String aNm;
    private String aNn;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aMV = new a(this);
    private final View.OnClickListener aNo = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.appeal_submit_btn), this.aNo);
        this.aNi = (TextView) findViewById(u.g.forbid_id);
        this.aNj = (TextView) findViewById(u.g.forbid_reason);
        this.aNk = (TextView) findViewById(u.g.appeal_reason);
        this.aNl = (TextView) findViewById(u.g.remain_text_count);
        this.aNl.setText(String.valueOf(150));
        this.aNk.setFocusable(true);
        this.aNk.setFocusableInTouchMode(true);
        this.aNk.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aNk);
        this.aNk.addTextChangedListener(this.aMV);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aNm = intent.getStringExtra("forum_id");
        this.aNn = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aNm, this.aNn, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(str);
        aVar.a(getPageContext().getString(u.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.rS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().w(findViewById(u.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aNk.setHintTextColor(av.getColor(u.d.common_color_10005));
    }
}
