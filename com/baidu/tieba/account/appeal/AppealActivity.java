package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.account.appeal.a;
import com.baidu.tieba.account.appeal.b;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aYJ;
    private TextView aYK;
    private TextView aYL;
    private TextView aYM;
    private String aYN;
    private String aYO;
    private NavigationBar mNavigationBar;
    private String mUserName;
    private final TextWatcher mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.account.appeal.AppealActivity.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = 150 - AppealActivity.this.aYL.getText().toString().length();
            AppealActivity.this.aYM.setText(String.valueOf(length));
            if (length < 0) {
                AppealActivity.this.aYM.setTextColor(AppealActivity.this.getResources().getColor(d.e.common_color_10253));
            } else {
                aj.c(AppealActivity.this.aYM, d.e.common_color_10005, 1);
            }
        }
    };
    private final View.OnClickListener aYP = new View.OnClickListener() { // from class: com.baidu.tieba.account.appeal.AppealActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String charSequence = AppealActivity.this.aYL.getText().toString();
            if (charSequence.length() < 20) {
                AppealActivity.this.showToast(d.l.appeal_min_size);
            } else if (charSequence.length() <= 150) {
                a.a(AppealActivity.this.aYN, AppealActivity.this.aYO, AppealActivity.this.mUserName, charSequence, new a.b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.3.1
                    @Override // com.baidu.tieba.account.appeal.a.b
                    public void a(AppealData appealData) {
                        AppealActivity.this.t(AppealActivity.this.getPageContext().getString(d.l.appeal_post_success), true);
                    }

                    @Override // com.baidu.tieba.account.appeal.a.b
                    public void b(AppealData appealData) {
                        AppealActivity.this.t(!am.isEmpty(appealData.errMsg) ? appealData.errMsg : AppealActivity.this.getPageContext().getString(d.l.appeal_post_failure), false);
                    }
                });
            } else {
                AppealActivity.this.showToast(d.l.appeal_max_size);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.l.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.push_commit), this.aYP);
        this.aYJ = (TextView) findViewById(d.h.forbid_id);
        this.aYK = (TextView) findViewById(d.h.forbid_reason);
        this.aYL = (TextView) findViewById(d.h.appeal_reason);
        this.aYM = (TextView) findViewById(d.h.remain_text_count);
        this.aYM.setText(String.valueOf((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY));
        this.aYL.setFocusable(true);
        this.aYL.setFocusableInTouchMode(true);
        this.aYL.requestFocus();
        l.b(getPageContext().getPageActivity(), this.aYL);
        this.aYL.addTextChangedListener(this.mTextWatcher);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aYN = intent.getStringExtra("forum_id");
        this.aYO = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        b.a(this.aYN, this.aYO, new b.InterfaceC0073b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.2
            @Override // com.baidu.tieba.account.appeal.b.InterfaceC0073b
            public void a(ForbidReasonData forbidReasonData) {
                AppealActivity.this.aYJ.setText(AppealActivity.this.mUserName);
                AppealActivity.this.aYK.setText(!am.isEmpty(forbidReasonData.reason) ? forbidReasonData.reason : AppealActivity.this.getPageContext().getString(d.l.default_forbid_reason));
            }

            @Override // com.baidu.tieba.account.appeal.b.InterfaceC0073b
            public void b(ForbidReasonData forbidReasonData) {
                AppealActivity.this.showToast(forbidReasonData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, final boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cL(str);
        aVar.a(getPageContext().getString(d.l.confirm), new a.b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (z) {
                    AppealActivity.this.finish();
                }
            }
        });
        aVar.b(getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(d.h.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aYL.setHintTextColor(aj.getColor(d.e.common_color_10005));
    }
}
