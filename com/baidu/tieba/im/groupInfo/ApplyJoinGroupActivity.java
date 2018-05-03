package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener axG;
    TextWatcher bRb;
    View ebj;
    EditText ebk;
    TextView ebl;
    TextView ebm;
    View ebn;
    TextView ebo;
    Button ebp;
    Button ebq;
    int ebr;
    int ebs;
    String ebt;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c dPI = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                int error = responseJoinGroupMessage.getError();
                String errorString = responseJoinGroupMessage.getErrorString();
                if (responseJoinGroupMessage.getError() != 0) {
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.k.group_apply_fail);
                    }
                    ApplyJoinGroupActivity.this.ebo.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.k.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aGU().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
                    ApplyJoinGroupActivity.this.finish();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initListener();
        initView();
        aEN();
    }

    private void aEN() {
        aEO();
    }

    private void aEO() {
        if (this.ebs == 0 && this.ebr == 0) {
            this.ebm.setText("");
            return;
        }
        String string = getPageContext().getString(d.k.group_join_limit_str1);
        String valueOf = String.valueOf(this.ebr);
        String string2 = getPageContext().getString(d.k.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.ebs);
        String string3 = getPageContext().getString(d.k.group_join_limit_str5);
        int i = d.C0126d.common_color_10047;
        int i2 = d.C0126d.common_color_10106;
        SpannableString ao = ao(valueOf, ak.getColor(i));
        SpannableString ao2 = ao(valueOf2, ak.getColor(i));
        ak.c(this.ebm, i2, 1);
        this.ebm.setText("");
        this.ebm.append(string);
        this.ebm.append(ao);
        this.ebm.append(string2);
        this.ebm.append(ao2);
        this.ebm.append(string3);
        this.ebm.setVisibility(0);
    }

    public static SpannableString ao(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.dPI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.dPI);
        if (TextUtils.isEmpty(this.ebk.getText())) {
            this.ebo.setEnabled(false);
        } else {
            this.ebo.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ebk != null) {
            this.ebk.removeTextChangedListener(this.bRb);
        }
    }

    private void initView() {
        this.ebj = View.inflate(getPageContext().getPageActivity(), d.i.group_apply_activity, null);
        setContentView(this.ebj);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_apply_join);
        this.ebn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ebo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebo.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.ebo.setLayoutParams(layoutParams);
        this.ebn.setOnClickListener(this.axG);
        this.ebl = (TextView) this.ebj.findViewById(d.g.tv_word_count);
        int length = 30 - this.ebt.length();
        if (length < 0) {
            length = 0;
        }
        this.ebl.setText(length + "/30");
        this.ebk = (EditText) this.ebj.findViewById(d.g.et_content);
        this.ebk.addTextChangedListener(this.bRb);
        this.ebk.setText(this.ebt);
        this.ebm = (TextView) this.ebj.findViewById(d.g.tv_add_limit);
        this.ebm.setVisibility(8);
        this.ebo.setOnClickListener(this.axG);
        this.ebp = (Button) this.ebj.findViewById(d.g.btn_agree);
        this.ebp.setOnClickListener(this.axG);
        this.ebq = (Button) this.ebj.findViewById(d.g.btn_disagree);
        this.ebq.setOnClickListener(this.axG);
        this.ebp.setVisibility(8);
        this.ebq.setVisibility(8);
        ShowSoftKeyPadDelay(this.ebk, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.ebj);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.i(this.ebo, d.f.s_navbar_button_bg);
        ak.c(this.ebo, d.C0126d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.ebr = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.ebs = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.ebt = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.ebt == null) {
            this.ebt = "";
        }
    }

    private void initListener() {
        this.bRb = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.ebk.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.ebk.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.ebo.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.ebk.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.ebl.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0126d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.ebo.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.ebo.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.ebl.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0126d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.ebk.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.ebl.setText(length + "/30");
                }
            }
        };
        this.axG = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    if (view2.equals(ApplyJoinGroupActivity.this.ebo)) {
                        if (!j.gP()) {
                            ApplyJoinGroupActivity.this.showToast(d.k.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.ebk.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.ebo.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view2.equals(ApplyJoinGroupActivity.this.ebn)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
