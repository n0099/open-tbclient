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
    private TextView aMo;
    private TextView aMp;
    private TextView aMq;
    private TextView aMr;
    private String aMs;
    private String aMt;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aMb = new a(this);
    private final View.OnClickListener aMu = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(u.j.appeal_submit_btn), this.aMu);
        this.aMo = (TextView) findViewById(u.g.forbid_id);
        this.aMp = (TextView) findViewById(u.g.forbid_reason);
        this.aMq = (TextView) findViewById(u.g.appeal_reason);
        this.aMr = (TextView) findViewById(u.g.remain_text_count);
        this.aMr.setText(String.valueOf(150));
        this.aMq.setFocusable(true);
        this.aMq.setFocusableInTouchMode(true);
        this.aMq.requestFocus();
        k.b(getPageContext().getPageActivity(), this.aMq);
        this.aMq.addTextChangedListener(this.aMb);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aMs = intent.getStringExtra("forum_id");
        this.aMt = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aMs, this.aMt, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(str);
        aVar.a(getPageContext().getString(u.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.rT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(findViewById(u.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aMq.setHintTextColor(av.getColor(u.d.common_color_10005));
    }
}
