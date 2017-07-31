package com.baidu.tieba.account.appeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.account.appeal.a;
import com.baidu.tieba.account.appeal.b;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AppealActivity extends BaseActivity<AppealActivity> {
    private TextView aXA;
    private TextView aXB;
    private String aXC;
    private String aXD;
    private TextView aXy;
    private TextView aXz;
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
            int length = 150 - AppealActivity.this.aXA.getText().toString().length();
            AppealActivity.this.aXB.setText(String.valueOf(length));
            if (length < 0) {
                AppealActivity.this.aXB.setTextColor(AppealActivity.this.getResources().getColor(d.e.common_color_10253));
            } else {
                ai.c(AppealActivity.this.aXB, d.e.common_color_10005, 1);
            }
        }
    };
    private final View.OnClickListener aXE = new View.OnClickListener() { // from class: com.baidu.tieba.account.appeal.AppealActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String charSequence = AppealActivity.this.aXA.getText().toString();
            if (charSequence.length() < 20) {
                AppealActivity.this.showToast(d.l.appeal_min_size);
            } else if (charSequence.length() <= 150) {
                a.a(AppealActivity.this.aXC, AppealActivity.this.aXD, AppealActivity.this.mUserName, charSequence, new a.b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.3.1
                    @Override // com.baidu.tieba.account.appeal.a.b
                    public void a(AppealData appealData) {
                        AppealActivity.this.u(AppealActivity.this.getPageContext().getString(d.l.appeal_post_success), true);
                    }

                    @Override // com.baidu.tieba.account.appeal.a.b
                    public void b(AppealData appealData) {
                        AppealActivity.this.u(!al.isEmpty(appealData.errMsg) ? appealData.errMsg : AppealActivity.this.getPageContext().getString(d.l.appeal_post_failure), false);
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
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.push_commit), this.aXE);
        this.aXy = (TextView) findViewById(d.h.forbid_id);
        this.aXz = (TextView) findViewById(d.h.forbid_reason);
        this.aXA = (TextView) findViewById(d.h.appeal_reason);
        this.aXB = (TextView) findViewById(d.h.remain_text_count);
        this.aXB.setText(String.valueOf((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY));
        this.aXA.setFocusable(true);
        this.aXA.setFocusableInTouchMode(true);
        this.aXA.requestFocus();
        k.c(getPageContext().getPageActivity(), this.aXA);
        this.aXA.addTextChangedListener(this.mTextWatcher);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.aXC = intent.getStringExtra("forum_id");
        this.aXD = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        b.a(this.aXC, this.aXD, new b.InterfaceC0070b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.2
            @Override // com.baidu.tieba.account.appeal.b.InterfaceC0070b
            public void a(ForbidReasonData forbidReasonData) {
                AppealActivity.this.aXy.setText(AppealActivity.this.mUserName);
                AppealActivity.this.aXz.setText(!al.isEmpty(forbidReasonData.reason) ? forbidReasonData.reason : AppealActivity.this.getPageContext().getString(d.l.default_forbid_reason));
            }

            @Override // com.baidu.tieba.account.appeal.b.InterfaceC0070b
            public void b(ForbidReasonData forbidReasonData) {
                AppealActivity.this.showToast(forbidReasonData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, final boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cT(str);
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
        aVar.tr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(d.h.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aXA.setHintTextColor(ai.getColor(d.e.common_color_10005));
    }
}
