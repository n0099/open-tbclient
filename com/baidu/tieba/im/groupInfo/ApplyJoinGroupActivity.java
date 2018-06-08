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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener aGc;
    TextWatcher bZT;
    View enE;
    EditText enF;
    TextView enG;
    TextView enH;
    View enI;
    TextView enJ;
    Button enK;
    Button enL;
    int enM;
    int enN;
    String enO;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.enJ.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.k.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aLN().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aJG();
    }

    private void aJG() {
        aJH();
    }

    private void aJH() {
        if (this.enN == 0 && this.enM == 0) {
            this.enH.setText("");
            return;
        }
        String string = getPageContext().getString(d.k.group_join_limit_str1);
        String valueOf = String.valueOf(this.enM);
        String string2 = getPageContext().getString(d.k.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.enN);
        String string3 = getPageContext().getString(d.k.group_join_limit_str5);
        int i = d.C0141d.common_color_10047;
        int i2 = d.C0141d.common_color_10106;
        SpannableString ar = ar(valueOf, al.getColor(i));
        SpannableString ar2 = ar(valueOf2, al.getColor(i));
        al.c(this.enH, i2, 1);
        this.enH.setText("");
        this.enH.append(string);
        this.enH.append(ar);
        this.enH.append(string2);
        this.enH.append(ar2);
        this.enH.append(string3);
        this.enH.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.ecb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.ecb);
        if (TextUtils.isEmpty(this.enF.getText())) {
            this.enJ.setEnabled(false);
        } else {
            this.enJ.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.enF != null) {
            this.enF.removeTextChangedListener(this.bZT);
        }
    }

    private void initView() {
        this.enE = View.inflate(getPageContext().getPageActivity(), d.i.group_apply_activity, null);
        setContentView(this.enE);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_apply_join);
        this.enI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.enJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enJ.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.enJ.setLayoutParams(layoutParams);
        this.enI.setOnClickListener(this.aGc);
        this.enG = (TextView) this.enE.findViewById(d.g.tv_word_count);
        int length = 30 - this.enO.length();
        if (length < 0) {
            length = 0;
        }
        this.enG.setText(length + "/30");
        this.enF = (EditText) this.enE.findViewById(d.g.et_content);
        this.enF.addTextChangedListener(this.bZT);
        this.enF.setText(this.enO);
        this.enH = (TextView) this.enE.findViewById(d.g.tv_add_limit);
        this.enH.setVisibility(8);
        this.enJ.setOnClickListener(this.aGc);
        this.enK = (Button) this.enE.findViewById(d.g.btn_agree);
        this.enK.setOnClickListener(this.aGc);
        this.enL = (Button) this.enE.findViewById(d.g.btn_disagree);
        this.enL.setOnClickListener(this.aGc);
        this.enK.setVisibility(8);
        this.enL.setVisibility(8);
        ShowSoftKeyPadDelay(this.enF, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.enE);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.enJ, d.f.s_navbar_button_bg);
        al.c(this.enJ, d.C0141d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.enM = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.enN = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.enO = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.enO == null) {
            this.enO = "";
        }
    }

    private void initListener() {
        this.bZT = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.enF.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.enF.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.enJ.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.enF.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.enG.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0141d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.enJ.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.enJ.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.enG.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0141d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.enF.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.enG.setText(length + "/30");
                }
            }
        };
        this.aGc = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.enJ)) {
                        if (!j.jD()) {
                            ApplyJoinGroupActivity.this.showToast(d.k.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.enF.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.enJ.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.enI)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
