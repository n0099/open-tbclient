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
    View bMz;
    View.OnClickListener bmd;
    TextWatcher cBh;
    EditText eGD;
    TextView eGE;
    TextView eGF;
    View eGG;
    TextView eGH;
    Button eGI;
    Button eGJ;
    int eGK;
    int eGL;
    String eGM;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c evb = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.eGH.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aLU().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aJQ();
    }

    private void aJQ() {
        aJR();
    }

    private void aJR() {
        if (this.eGL == 0 && this.eGK == 0) {
            this.eGF.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eGK);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eGL);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0140d.common_color_10047;
        int i2 = d.C0140d.common_color_10106;
        SpannableString am = am(valueOf, aj.getColor(i));
        SpannableString am2 = am(valueOf2, aj.getColor(i));
        aj.e(this.eGF, i2, 1);
        this.eGF.setText("");
        this.eGF.append(string);
        this.eGF.append(am);
        this.eGF.append(string2);
        this.eGF.append(am2);
        this.eGF.append(string3);
        this.eGF.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.evb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.evb);
        if (TextUtils.isEmpty(this.eGD.getText())) {
            this.eGH.setEnabled(false);
        } else {
            this.eGH.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eGD != null) {
            this.eGD.removeTextChangedListener(this.cBh);
        }
    }

    private void initView() {
        this.bMz = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.bMz);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.eGG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGH.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.eGH.setLayoutParams(layoutParams);
        this.eGG.setOnClickListener(this.bmd);
        this.eGE = (TextView) this.bMz.findViewById(d.g.tv_word_count);
        int length = 30 - this.eGM.length();
        if (length < 0) {
            length = 0;
        }
        this.eGE.setText(length + "/30");
        this.eGD = (EditText) this.bMz.findViewById(d.g.et_content);
        this.eGD.addTextChangedListener(this.cBh);
        this.eGD.setText(this.eGM);
        this.eGF = (TextView) this.bMz.findViewById(d.g.tv_add_limit);
        this.eGF.setVisibility(8);
        this.eGH.setOnClickListener(this.bmd);
        this.eGI = (Button) this.bMz.findViewById(d.g.btn_agree);
        this.eGI.setOnClickListener(this.bmd);
        this.eGJ = (Button) this.bMz.findViewById(d.g.btn_disagree);
        this.eGJ.setOnClickListener(this.bmd);
        this.eGI.setVisibility(8);
        this.eGJ.setVisibility(8);
        ShowSoftKeyPadDelay(this.eGD, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.bMz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.s(this.eGH, d.f.s_navbar_button_bg);
        aj.e(this.eGH, d.C0140d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eGK = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eGL = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eGM = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eGM == null) {
            this.eGM = "";
        }
    }

    private void initListener() {
        this.cBh = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eGD.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eGD.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eGH.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eGD.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eGE.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0140d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eGH.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eGH.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eGE.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0140d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eGD.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eGE.setText(length + "/30");
                }
            }
        };
        this.bmd = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eGH)) {
                        if (!j.oJ()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.h(ApplyJoinGroupActivity.this.groupID, 0));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eGD.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eGH.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eGG)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
