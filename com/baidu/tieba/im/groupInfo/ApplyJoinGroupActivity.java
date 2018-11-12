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
    View.OnClickListener aPz;
    TextWatcher csl;
    View eLI;
    EditText eLJ;
    TextView eLK;
    TextView eLL;
    View eLM;
    TextView eLN;
    Button eLO;
    Button eLP;
    int eLQ;
    int eLR;
    String eLS;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c eAl = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.eLN.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(e.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aSq().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aQm();
    }

    private void aQm() {
        aQn();
    }

    private void aQn() {
        if (this.eLR == 0 && this.eLQ == 0) {
            this.eLL.setText("");
            return;
        }
        String string = getPageContext().getString(e.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eLQ);
        String string2 = getPageContext().getString(e.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eLR);
        String string3 = getPageContext().getString(e.j.group_join_limit_str5);
        int i = e.d.common_color_10047;
        int i2 = e.d.common_color_10106;
        SpannableString av = av(valueOf, al.getColor(i));
        SpannableString av2 = av(valueOf2, al.getColor(i));
        al.c(this.eLL, i2, 1);
        this.eLL.setText("");
        this.eLL.append(string);
        this.eLL.append(av);
        this.eLL.append(string2);
        this.eLL.append(av2);
        this.eLL.append(string3);
        this.eLL.setVisibility(0);
    }

    public static SpannableString av(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eAl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.eAl);
        if (TextUtils.isEmpty(this.eLJ.getText())) {
            this.eLN.setEnabled(false);
        } else {
            this.eLN.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eLJ != null) {
            this.eLJ.removeTextChangedListener(this.csl);
        }
    }

    private void initView() {
        this.eLI = View.inflate(getPageContext().getPageActivity(), e.h.group_apply_activity, null);
        setContentView(this.eLI);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_apply_join);
        this.eLM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eLN.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0200e.ds16);
        this.eLN.setLayoutParams(layoutParams);
        this.eLM.setOnClickListener(this.aPz);
        this.eLK = (TextView) this.eLI.findViewById(e.g.tv_word_count);
        int length = 30 - this.eLS.length();
        if (length < 0) {
            length = 0;
        }
        this.eLK.setText(length + "/30");
        this.eLJ = (EditText) this.eLI.findViewById(e.g.et_content);
        this.eLJ.addTextChangedListener(this.csl);
        this.eLJ.setText(this.eLS);
        this.eLL = (TextView) this.eLI.findViewById(e.g.tv_add_limit);
        this.eLL.setVisibility(8);
        this.eLN.setOnClickListener(this.aPz);
        this.eLO = (Button) this.eLI.findViewById(e.g.btn_agree);
        this.eLO.setOnClickListener(this.aPz);
        this.eLP = (Button) this.eLI.findViewById(e.g.btn_disagree);
        this.eLP.setOnClickListener(this.aPz);
        this.eLO.setVisibility(8);
        this.eLP.setVisibility(8);
        ShowSoftKeyPadDelay(this.eLJ, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eLI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.eLN, e.f.s_navbar_button_bg);
        al.c(this.eLN, e.d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eLQ = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eLR = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eLS = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eLS == null) {
            this.eLS = "";
        }
    }

    private void initListener() {
        this.csl = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eLJ.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eLJ.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eLN.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eLJ.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eLK.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eLN.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eLN.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eLK.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eLJ.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eLK.setText(length + "/30");
                }
            }
        };
        this.aPz = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eLN)) {
                        if (!j.kV()) {
                            ApplyJoinGroupActivity.this.showToast(e.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eLJ.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eLN.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eLM)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
