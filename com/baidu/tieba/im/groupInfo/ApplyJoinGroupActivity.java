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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener aTI;
    TextWatcher cxU;
    View eWb;
    EditText eWc;
    TextView eWd;
    TextView eWe;
    View eWf;
    TextView eWg;
    Button eWh;
    Button eWi;
    int eWj;
    int eWk;
    String eWl;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c eKD = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                int error = responseJoinGroupMessage.getError();
                String errorString = responseJoinGroupMessage.getErrorString();
                if (responseJoinGroupMessage.getError() != 0) {
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = ApplyJoinGroupActivity.this.getPageContext().getString(e.j.group_apply_fail);
                    }
                    ApplyJoinGroupActivity.this.eWg.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(e.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aVv().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aTr();
    }

    private void aTr() {
        aTs();
    }

    private void aTs() {
        if (this.eWk == 0 && this.eWj == 0) {
            this.eWe.setText("");
            return;
        }
        String string = getPageContext().getString(e.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eWj);
        String string2 = getPageContext().getString(e.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eWk);
        String string3 = getPageContext().getString(e.j.group_join_limit_str5);
        int i = e.d.common_color_10047;
        int i2 = e.d.common_color_10106;
        SpannableString ax = ax(valueOf, al.getColor(i));
        SpannableString ax2 = ax(valueOf2, al.getColor(i));
        al.c(this.eWe, i2, 1);
        this.eWe.setText("");
        this.eWe.append(string);
        this.eWe.append(ax);
        this.eWe.append(string2);
        this.eWe.append(ax2);
        this.eWe.append(string3);
        this.eWe.setVisibility(0);
    }

    public static SpannableString ax(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eKD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.eKD);
        if (TextUtils.isEmpty(this.eWc.getText())) {
            this.eWg.setEnabled(false);
        } else {
            this.eWg.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWc != null) {
            this.eWc.removeTextChangedListener(this.cxU);
        }
    }

    private void initView() {
        this.eWb = View.inflate(getPageContext().getPageActivity(), e.h.group_apply_activity, null);
        setContentView(this.eWb);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_apply_join);
        this.eWf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWg.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.eWg.setLayoutParams(layoutParams);
        this.eWf.setOnClickListener(this.aTI);
        this.eWd = (TextView) this.eWb.findViewById(e.g.tv_word_count);
        int length = 30 - this.eWl.length();
        if (length < 0) {
            length = 0;
        }
        this.eWd.setText(length + "/30");
        this.eWc = (EditText) this.eWb.findViewById(e.g.et_content);
        this.eWc.addTextChangedListener(this.cxU);
        this.eWc.setText(this.eWl);
        this.eWe = (TextView) this.eWb.findViewById(e.g.tv_add_limit);
        this.eWe.setVisibility(8);
        this.eWg.setOnClickListener(this.aTI);
        this.eWh = (Button) this.eWb.findViewById(e.g.btn_agree);
        this.eWh.setOnClickListener(this.aTI);
        this.eWi = (Button) this.eWb.findViewById(e.g.btn_disagree);
        this.eWi.setOnClickListener(this.aTI);
        this.eWh.setVisibility(8);
        this.eWi.setVisibility(8);
        ShowSoftKeyPadDelay(this.eWc, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eWb);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.eWg, e.f.s_navbar_button_bg);
        al.c(this.eWg, e.d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eWj = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eWk = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eWl = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eWl == null) {
            this.eWl = "";
        }
    }

    private void initListener() {
        this.cxU = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eWc.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eWc.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eWg.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eWc.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eWd.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eWg.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eWg.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eWd.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eWc.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eWd.setText(length + "/30");
                }
            }
        };
        this.aTI = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eWg)) {
                        if (!j.kV()) {
                            ApplyJoinGroupActivity.this.showToast(e.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eWc.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eWg.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eWf)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
