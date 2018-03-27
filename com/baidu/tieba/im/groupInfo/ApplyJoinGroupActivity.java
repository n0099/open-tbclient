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
    View bMp;
    View.OnClickListener blT;
    TextWatcher cAY;
    EditText eGH;
    TextView eGI;
    TextView eGJ;
    View eGK;
    TextView eGL;
    Button eGM;
    Button eGN;
    int eGO;
    int eGP;
    String eGQ;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c evf = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.eGL.setEnabled(true);
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
        if (this.eGP == 0 && this.eGO == 0) {
            this.eGJ.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eGO);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eGP);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0141d.common_color_10047;
        int i2 = d.C0141d.common_color_10106;
        SpannableString am = am(valueOf, aj.getColor(i));
        SpannableString am2 = am(valueOf2, aj.getColor(i));
        aj.e(this.eGJ, i2, 1);
        this.eGJ.setText("");
        this.eGJ.append(string);
        this.eGJ.append(am);
        this.eGJ.append(string2);
        this.eGJ.append(am2);
        this.eGJ.append(string3);
        this.eGJ.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.evf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.evf);
        if (TextUtils.isEmpty(this.eGH.getText())) {
            this.eGL.setEnabled(false);
        } else {
            this.eGL.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eGH != null) {
            this.eGH.removeTextChangedListener(this.cAY);
        }
    }

    private void initView() {
        this.bMp = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.bMp);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.eGK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGL.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.eGL.setLayoutParams(layoutParams);
        this.eGK.setOnClickListener(this.blT);
        this.eGI = (TextView) this.bMp.findViewById(d.g.tv_word_count);
        int length = 30 - this.eGQ.length();
        if (length < 0) {
            length = 0;
        }
        this.eGI.setText(length + "/30");
        this.eGH = (EditText) this.bMp.findViewById(d.g.et_content);
        this.eGH.addTextChangedListener(this.cAY);
        this.eGH.setText(this.eGQ);
        this.eGJ = (TextView) this.bMp.findViewById(d.g.tv_add_limit);
        this.eGJ.setVisibility(8);
        this.eGL.setOnClickListener(this.blT);
        this.eGM = (Button) this.bMp.findViewById(d.g.btn_agree);
        this.eGM.setOnClickListener(this.blT);
        this.eGN = (Button) this.bMp.findViewById(d.g.btn_disagree);
        this.eGN.setOnClickListener(this.blT);
        this.eGM.setVisibility(8);
        this.eGN.setVisibility(8);
        ShowSoftKeyPadDelay(this.eGH, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.bMp);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.s(this.eGL, d.f.s_navbar_button_bg);
        aj.e(this.eGL, d.C0141d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eGO = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eGP = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eGQ = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eGQ == null) {
            this.eGQ = "";
        }
    }

    private void initListener() {
        this.cAY = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eGH.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eGH.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eGL.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eGH.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eGI.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0141d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eGL.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eGL.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eGI.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0141d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eGH.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eGI.setText(length + "/30");
                }
            }
        };
        this.blT = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eGL)) {
                        if (!j.oJ()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.h(ApplyJoinGroupActivity.this.groupID, 0));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eGH.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eGL.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eGK)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
