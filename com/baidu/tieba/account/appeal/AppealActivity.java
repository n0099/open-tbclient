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
    private TextView bQs;
    private TextView bQt;
    private TextView bQu;
    private TextView bQv;
    private String bQw;
    private String bQx;
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
            int length = 150 - AppealActivity.this.bQu.getText().toString().length();
            AppealActivity.this.bQv.setText(String.valueOf(length));
            if (length < 0) {
                AppealActivity.this.bQv.setTextColor(AppealActivity.this.getResources().getColor(d.C0107d.common_color_10253));
            } else {
                aj.e(AppealActivity.this.bQv, d.C0107d.common_color_10005, 1);
            }
        }
    };
    private final View.OnClickListener bQy = new View.OnClickListener() { // from class: com.baidu.tieba.account.appeal.AppealActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String charSequence = AppealActivity.this.bQu.getText().toString();
            if (charSequence.length() < 20) {
                AppealActivity.this.showToast(d.j.appeal_min_size);
            } else if (charSequence.length() <= 150) {
                a.a(AppealActivity.this.bQw, AppealActivity.this.bQx, AppealActivity.this.mUserName, charSequence, new a.b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.3.1
                    @Override // com.baidu.tieba.account.appeal.a.b
                    public void a(AppealData appealData) {
                        AppealActivity.this.s(AppealActivity.this.getPageContext().getString(d.j.appeal_post_success), true);
                    }

                    @Override // com.baidu.tieba.account.appeal.a.b
                    public void b(AppealData appealData) {
                        AppealActivity.this.s(!am.isEmpty(appealData.errMsg) ? appealData.errMsg : AppealActivity.this.getPageContext().getString(d.j.appeal_post_failure), false);
                    }
                });
            } else {
                AppealActivity.this.showToast(d.j.appeal_max_size);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.account_appeal_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.appeal_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.push_commit), this.bQy);
        this.bQs = (TextView) findViewById(d.g.forbid_id);
        this.bQt = (TextView) findViewById(d.g.forbid_reason);
        this.bQu = (TextView) findViewById(d.g.appeal_reason);
        this.bQv = (TextView) findViewById(d.g.remain_text_count);
        this.bQv.setText(String.valueOf((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY));
        this.bQu.setFocusable(true);
        this.bQu.setFocusableInTouchMode(true);
        this.bQu.requestFocus();
        l.b(getPageContext().getPageActivity(), this.bQu);
        this.bQu.addTextChangedListener(this.mTextWatcher);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        this.bQw = intent.getStringExtra("forum_id");
        this.bQx = intent.getStringExtra("user_id");
        this.mUserName = intent.getStringExtra("user_name");
        b.a(this.bQw, this.bQx, new b.InterfaceC0099b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.2
            @Override // com.baidu.tieba.account.appeal.b.InterfaceC0099b
            public void a(ForbidReasonData forbidReasonData) {
                AppealActivity.this.bQs.setText(AppealActivity.this.mUserName);
                AppealActivity.this.bQt.setText(!am.isEmpty(forbidReasonData.reason) ? forbidReasonData.reason : AppealActivity.this.getPageContext().getString(d.j.default_forbid_reason));
            }

            @Override // com.baidu.tieba.account.appeal.b.InterfaceC0099b
            public void b(ForbidReasonData forbidReasonData) {
                AppealActivity.this.showToast(forbidReasonData.error.errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, final boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(str);
        aVar.a(getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.account.appeal.AppealActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                if (z) {
                    AppealActivity.this.finish();
                }
            }
        });
        aVar.b(getPageContext());
        aVar.AA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(findViewById(d.g.root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bQu.setHintTextColor(aj.getColor(d.C0107d.common_color_10005));
    }
}
