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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View dFr;
    View.OnClickListener drJ;
    String groupID;
    EditText hEJ;
    TextView hEK;
    TextView hEL;
    View hEM;
    TextView hEN;
    Button hEO;
    Button hEP;
    TextWatcher hEQ;
    int hER;
    int hES;
    String hET;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c htm = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_JOIN_GROUP) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                int error = responseJoinGroupMessage.getError();
                String errorString = responseJoinGroupMessage.getErrorString();
                if (responseJoinGroupMessage.getError() != 0) {
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_fail);
                    }
                    ApplyJoinGroupActivity.this.hEN.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.bYs().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        bWt();
    }

    private void bWt() {
        bWu();
    }

    private void bWu() {
        if (this.hES == 0 && this.hER == 0) {
            this.hEL.setText("");
            return;
        }
        String string = getPageContext().getString(R.string.group_join_limit_str1);
        String valueOf = String.valueOf(this.hER);
        String string2 = getPageContext().getString(R.string.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.hES);
        String string3 = getPageContext().getString(R.string.group_join_limit_str5);
        SpannableString aU = aU(valueOf, am.getColor(R.color.common_color_10047));
        SpannableString aU2 = aU(valueOf2, am.getColor(R.color.common_color_10047));
        am.setViewTextColor(this.hEL, R.color.common_color_10106, 1);
        this.hEL.setText("");
        this.hEL.append(string);
        this.hEL.append(aU);
        this.hEL.append(string2);
        this.hEL.append(aU2);
        this.hEL.append(string3);
        this.hEL.setVisibility(0);
    }

    public static SpannableString aU(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.htm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.htm);
        if (TextUtils.isEmpty(this.hEJ.getText())) {
            this.hEN.setEnabled(false);
        } else {
            this.hEN.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hEJ != null) {
            this.hEJ.removeTextChangedListener(this.hEQ);
        }
    }

    private void initView() {
        this.dFr = View.inflate(getPageContext().getPageActivity(), R.layout.group_apply_activity, null);
        setContentView(this.dFr);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_apply_join);
        this.hEM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hEN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hEN.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.hEN.setLayoutParams(layoutParams);
        this.hEM.setOnClickListener(this.drJ);
        this.hEK = (TextView) this.dFr.findViewById(R.id.tv_word_count);
        int length = 30 - this.hET.length();
        if (length < 0) {
            length = 0;
        }
        this.hEK.setText(length + "/30");
        this.hEJ = (EditText) this.dFr.findViewById(R.id.et_content);
        this.hEJ.addTextChangedListener(this.hEQ);
        this.hEJ.setText(this.hET);
        this.hEL = (TextView) this.dFr.findViewById(R.id.tv_add_limit);
        this.hEL.setVisibility(8);
        this.hEN.setOnClickListener(this.drJ);
        this.hEO = (Button) this.dFr.findViewById(R.id.btn_agree);
        this.hEO.setOnClickListener(this.drJ);
        this.hEP = (Button) this.dFr.findViewById(R.id.btn_disagree);
        this.hEP.setOnClickListener(this.drJ);
        this.hEO.setVisibility(8);
        this.hEP.setVisibility(8);
        ShowSoftKeyPadDelay(this.hEJ, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dFr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setBackgroundResource(this.hEN, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.hEN, R.color.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.hER = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.hES = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.hET = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.hET == null) {
            this.hET = "";
        }
    }

    private void initListener() {
        this.hEQ = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.hEJ.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.hEJ.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.hEN.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.hEJ.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.hEK.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.hEN.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.hEN.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.hEK.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.hEJ.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.hEK.setText(length + "/30");
                }
            }
        };
        this.drJ = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.hEN)) {
                        if (!j.isNetWorkAvailable()) {
                            ApplyJoinGroupActivity.this.showToast(R.string.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.hEJ.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.hEN.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.hEM)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
