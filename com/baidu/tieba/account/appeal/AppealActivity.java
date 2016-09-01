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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aSC;
    private TextView aSD;
    private TextView aSE;
    private TextView aSF;
    private String aSG;
    private String aSH;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher aSp = new a(this);
    private final View.OnClickListener aSI = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.appeal_submit_btn), this.aSI);
        this.aSC = (TextView) findViewById(t.g.forbid_id);
        this.aSD = (TextView) findViewById(t.g.forbid_reason);
        this.aSE = (TextView) findViewById(t.g.appeal_reason);
        this.aSF = (TextView) findViewById(t.g.remain_text_count);
        this.aSF.setText(String.valueOf(150));
        this.aSE.setFocusable(true);
        this.aSE.setFocusableInTouchMode(true);
        this.aSE.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aSE);
        this.aSE.addTextChangedListener(this.aSp);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aSG = intent.getStringExtra("forum_id");
        this.aSH = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        g.a(this.aSG, this.aSH, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cB(str);
        aVar.a(getPageContext().getString(t.j.anti_no_chance_pos), new e(this, z));
        aVar.b(getPageContext());
        aVar.sX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(findViewById(t.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aSE.setHintTextColor(av.getColor(t.d.common_color_10005));
    }
}
