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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View bMm;
    View.OnClickListener blQ;
    TextWatcher cAV;
    String eGA;
    EditText eGr;
    TextView eGs;
    TextView eGt;
    View eGu;
    TextView eGv;
    Button eGw;
    Button eGx;
    int eGy;
    int eGz;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c euP = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                int error = responseJoinGroupMessage.getError();
                String errorString = responseJoinGroupMessage.getErrorString();
                if (responseJoinGroupMessage.getError() != 0) {
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.j.group_apply_fail);
                    }
                    ApplyJoinGroupActivity.this.eGv.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aLT().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aJP();
    }

    private void aJP() {
        aJQ();
    }

    private void aJQ() {
        if (this.eGz == 0 && this.eGy == 0) {
            this.eGt.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eGy);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eGz);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0141d.common_color_10047;
        int i2 = d.C0141d.common_color_10106;
        SpannableString am = am(valueOf, aj.getColor(i));
        SpannableString am2 = am(valueOf2, aj.getColor(i));
        aj.e(this.eGt, i2, 1);
        this.eGt.setText("");
        this.eGt.append(string);
        this.eGt.append(am);
        this.eGt.append(string2);
        this.eGt.append(am2);
        this.eGt.append(string3);
        this.eGt.setVisibility(0);
    }

    public static SpannableString am(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.euP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.euP);
        if (TextUtils.isEmpty(this.eGr.getText())) {
            this.eGv.setEnabled(false);
        } else {
            this.eGv.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eGr != null) {
            this.eGr.removeTextChangedListener(this.cAV);
        }
    }

    private void initView() {
        this.bMm = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.bMm);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.eGu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGv.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.eGv.setLayoutParams(layoutParams);
        this.eGu.setOnClickListener(this.blQ);
        this.eGs = (TextView) this.bMm.findViewById(d.g.tv_word_count);
        int length = 30 - this.eGA.length();
        if (length < 0) {
            length = 0;
        }
        this.eGs.setText(length + "/30");
        this.eGr = (EditText) this.bMm.findViewById(d.g.et_content);
        this.eGr.addTextChangedListener(this.cAV);
        this.eGr.setText(this.eGA);
        this.eGt = (TextView) this.bMm.findViewById(d.g.tv_add_limit);
        this.eGt.setVisibility(8);
        this.eGv.setOnClickListener(this.blQ);
        this.eGw = (Button) this.bMm.findViewById(d.g.btn_agree);
        this.eGw.setOnClickListener(this.blQ);
        this.eGx = (Button) this.bMm.findViewById(d.g.btn_disagree);
        this.eGx.setOnClickListener(this.blQ);
        this.eGw.setVisibility(8);
        this.eGx.setVisibility(8);
        ShowSoftKeyPadDelay(this.eGr, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.bMm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.s(this.eGv, d.f.s_navbar_button_bg);
        aj.e(this.eGv, d.C0141d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eGy = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eGz = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eGA = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eGA == null) {
            this.eGA = "";
        }
    }

    private void initListener() {
        this.cAV = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eGr.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eGr.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eGv.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eGr.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eGs.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0141d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eGv.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eGv.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eGs.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0141d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eGr.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eGs.setText(length + "/30");
                }
            }
        };
        this.blQ = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eGv)) {
                        if (!j.oJ()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.h(ApplyJoinGroupActivity.this.groupID, 0));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eGr.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eGv.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eGu)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
