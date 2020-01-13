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
/* loaded from: classes8.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View dAM;
    View.OnClickListener dmY;
    String groupID;
    EditText hAW;
    TextView hAX;
    TextView hAY;
    View hAZ;
    TextView hBa;
    Button hBb;
    Button hBc;
    TextWatcher hBd;
    int hBe;
    int hBf;
    String hBg;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c hpz = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_JOIN_GROUP) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.hBa.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.bWw().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        bUx();
    }

    private void bUx() {
        bUy();
    }

    private void bUy() {
        if (this.hBf == 0 && this.hBe == 0) {
            this.hAY.setText("");
            return;
        }
        String string = getPageContext().getString(R.string.group_join_limit_str1);
        String valueOf = String.valueOf(this.hBe);
        String string2 = getPageContext().getString(R.string.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.hBf);
        String string3 = getPageContext().getString(R.string.group_join_limit_str5);
        SpannableString aW = aW(valueOf, am.getColor(R.color.common_color_10047));
        SpannableString aW2 = aW(valueOf2, am.getColor(R.color.common_color_10047));
        am.setViewTextColor(this.hAY, R.color.common_color_10106, 1);
        this.hAY.setText("");
        this.hAY.append(string);
        this.hAY.append(aW);
        this.hAY.append(string2);
        this.hAY.append(aW2);
        this.hAY.append(string3);
        this.hAY.setVisibility(0);
    }

    public static SpannableString aW(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.hpz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.hpz);
        if (TextUtils.isEmpty(this.hAW.getText())) {
            this.hBa.setEnabled(false);
        } else {
            this.hBa.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hAW != null) {
            this.hAW.removeTextChangedListener(this.hBd);
        }
    }

    private void initView() {
        this.dAM = View.inflate(getPageContext().getPageActivity(), R.layout.group_apply_activity, null);
        setContentView(this.dAM);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_apply_join);
        this.hAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hBa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hBa.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.hBa.setLayoutParams(layoutParams);
        this.hAZ.setOnClickListener(this.dmY);
        this.hAX = (TextView) this.dAM.findViewById(R.id.tv_word_count);
        int length = 30 - this.hBg.length();
        if (length < 0) {
            length = 0;
        }
        this.hAX.setText(length + "/30");
        this.hAW = (EditText) this.dAM.findViewById(R.id.et_content);
        this.hAW.addTextChangedListener(this.hBd);
        this.hAW.setText(this.hBg);
        this.hAY = (TextView) this.dAM.findViewById(R.id.tv_add_limit);
        this.hAY.setVisibility(8);
        this.hBa.setOnClickListener(this.dmY);
        this.hBb = (Button) this.dAM.findViewById(R.id.btn_agree);
        this.hBb.setOnClickListener(this.dmY);
        this.hBc = (Button) this.dAM.findViewById(R.id.btn_disagree);
        this.hBc.setOnClickListener(this.dmY);
        this.hBb.setVisibility(8);
        this.hBc.setVisibility(8);
        ShowSoftKeyPadDelay(this.hAW, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dAM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setBackgroundResource(this.hBa, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.hBa, R.color.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.hBe = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.hBf = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.hBg = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.hBg == null) {
            this.hBg = "";
        }
    }

    private void initListener() {
        this.hBd = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.hAW.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.hAW.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.hBa.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.hAW.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.hAX.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.hBa.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.hBa.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.hAX.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.hAW.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.hAX.setText(length + "/30");
                }
            }
        };
        this.dmY = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.hBa)) {
                        if (!j.isNetWorkAvailable()) {
                            ApplyJoinGroupActivity.this.showToast(R.string.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.hAW.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.hBa.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.hAZ)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
