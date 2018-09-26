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
    View.OnClickListener aKh;
    TextWatcher cjy;
    View eCG;
    EditText eCH;
    TextView eCI;
    TextView eCJ;
    View eCK;
    TextView eCL;
    Button eCM;
    Button eCN;
    int eCO;
    int eCP;
    String eCQ;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c era = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.eCL.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(e.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aPF().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aNA();
    }

    private void aNA() {
        aNB();
    }

    private void aNB() {
        if (this.eCP == 0 && this.eCO == 0) {
            this.eCJ.setText("");
            return;
        }
        String string = getPageContext().getString(e.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eCO);
        String string2 = getPageContext().getString(e.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eCP);
        String string3 = getPageContext().getString(e.j.group_join_limit_str5);
        int i = e.d.common_color_10047;
        int i2 = e.d.common_color_10106;
        SpannableString ar = ar(valueOf, al.getColor(i));
        SpannableString ar2 = ar(valueOf2, al.getColor(i));
        al.c(this.eCJ, i2, 1);
        this.eCJ.setText("");
        this.eCJ.append(string);
        this.eCJ.append(ar);
        this.eCJ.append(string2);
        this.eCJ.append(ar2);
        this.eCJ.append(string3);
        this.eCJ.setVisibility(0);
    }

    public static SpannableString ar(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.era);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.era);
        if (TextUtils.isEmpty(this.eCH.getText())) {
            this.eCL.setEnabled(false);
        } else {
            this.eCL.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eCH != null) {
            this.eCH.removeTextChangedListener(this.cjy);
        }
    }

    private void initView() {
        this.eCG = View.inflate(getPageContext().getPageActivity(), e.h.group_apply_activity, null);
        setContentView(this.eCG);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_apply_join);
        this.eCK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCL.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0141e.ds16);
        this.eCL.setLayoutParams(layoutParams);
        this.eCK.setOnClickListener(this.aKh);
        this.eCI = (TextView) this.eCG.findViewById(e.g.tv_word_count);
        int length = 30 - this.eCQ.length();
        if (length < 0) {
            length = 0;
        }
        this.eCI.setText(length + "/30");
        this.eCH = (EditText) this.eCG.findViewById(e.g.et_content);
        this.eCH.addTextChangedListener(this.cjy);
        this.eCH.setText(this.eCQ);
        this.eCJ = (TextView) this.eCG.findViewById(e.g.tv_add_limit);
        this.eCJ.setVisibility(8);
        this.eCL.setOnClickListener(this.aKh);
        this.eCM = (Button) this.eCG.findViewById(e.g.btn_agree);
        this.eCM.setOnClickListener(this.aKh);
        this.eCN = (Button) this.eCG.findViewById(e.g.btn_disagree);
        this.eCN.setOnClickListener(this.aKh);
        this.eCM.setVisibility(8);
        this.eCN.setVisibility(8);
        ShowSoftKeyPadDelay(this.eCH, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eCG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.eCL, e.f.s_navbar_button_bg);
        al.c(this.eCL, e.d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eCO = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eCP = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eCQ = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eCQ == null) {
            this.eCQ = "";
        }
    }

    private void initListener() {
        this.cjy = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eCH.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eCH.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eCL.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eCH.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eCI.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eCL.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eCL.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eCI.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eCH.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eCI.setText(length + "/30");
                }
            }
        };
        this.aKh = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eCL)) {
                        if (!j.kK()) {
                            ApplyJoinGroupActivity.this.showToast(e.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eCH.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eCL.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eCK)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
