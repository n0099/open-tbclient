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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener aGU;
    TextWatcher ccd;
    EditText erA;
    TextView erB;
    TextView erC;
    View erD;
    TextView erE;
    Button erF;
    Button erG;
    int erH;
    int erI;
    String erJ;
    View erz;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c efV = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.erE.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.k.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aMt().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aKn();
    }

    private void aKn() {
        aKo();
    }

    private void aKo() {
        if (this.erI == 0 && this.erH == 0) {
            this.erC.setText("");
            return;
        }
        String string = getPageContext().getString(d.k.group_join_limit_str1);
        String valueOf = String.valueOf(this.erH);
        String string2 = getPageContext().getString(d.k.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.erI);
        String string3 = getPageContext().getString(d.k.group_join_limit_str5);
        int i = d.C0142d.common_color_10047;
        int i2 = d.C0142d.common_color_10106;
        SpannableString aq = aq(valueOf, am.getColor(i));
        SpannableString aq2 = aq(valueOf2, am.getColor(i));
        am.c(this.erC, i2, 1);
        this.erC.setText("");
        this.erC.append(string);
        this.erC.append(aq);
        this.erC.append(string2);
        this.erC.append(aq2);
        this.erC.append(string3);
        this.erC.setVisibility(0);
    }

    public static SpannableString aq(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.efV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.efV);
        if (TextUtils.isEmpty(this.erA.getText())) {
            this.erE.setEnabled(false);
        } else {
            this.erE.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.erA != null) {
            this.erA.removeTextChangedListener(this.ccd);
        }
    }

    private void initView() {
        this.erz = View.inflate(getPageContext().getPageActivity(), d.i.group_apply_activity, null);
        setContentView(this.erz);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_apply_join);
        this.erD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.erE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erE.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.erE.setLayoutParams(layoutParams);
        this.erD.setOnClickListener(this.aGU);
        this.erB = (TextView) this.erz.findViewById(d.g.tv_word_count);
        int length = 30 - this.erJ.length();
        if (length < 0) {
            length = 0;
        }
        this.erB.setText(length + "/30");
        this.erA = (EditText) this.erz.findViewById(d.g.et_content);
        this.erA.addTextChangedListener(this.ccd);
        this.erA.setText(this.erJ);
        this.erC = (TextView) this.erz.findViewById(d.g.tv_add_limit);
        this.erC.setVisibility(8);
        this.erE.setOnClickListener(this.aGU);
        this.erF = (Button) this.erz.findViewById(d.g.btn_agree);
        this.erF.setOnClickListener(this.aGU);
        this.erG = (Button) this.erz.findViewById(d.g.btn_disagree);
        this.erG.setOnClickListener(this.aGU);
        this.erF.setVisibility(8);
        this.erG.setVisibility(8);
        ShowSoftKeyPadDelay(this.erA, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.erz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.i(this.erE, d.f.s_navbar_button_bg);
        am.c(this.erE, d.C0142d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.erH = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.erI = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.erJ = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.erJ == null) {
            this.erJ = "";
        }
    }

    private void initListener() {
        this.ccd = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.erA.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.erA.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.erE.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.erA.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.erB.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0142d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.erE.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.erE.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.erB.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0142d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.erA.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.erB.setText(length + "/30");
                }
            }
        };
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.erE)) {
                        if (!j.jD()) {
                            ApplyJoinGroupActivity.this.showToast(d.k.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.erA.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.erE.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.erD)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
