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
    View.OnClickListener aTa;
    TextWatcher cxj;
    View eVo;
    EditText eVp;
    TextView eVq;
    TextView eVr;
    View eVs;
    TextView eVt;
    Button eVu;
    Button eVv;
    int eVw;
    int eVx;
    String eVy;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c eJR = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.eVt.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(e.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aUV().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aSR();
    }

    private void aSR() {
        aSS();
    }

    private void aSS() {
        if (this.eVx == 0 && this.eVw == 0) {
            this.eVr.setText("");
            return;
        }
        String string = getPageContext().getString(e.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eVw);
        String string2 = getPageContext().getString(e.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eVx);
        String string3 = getPageContext().getString(e.j.group_join_limit_str5);
        int i = e.d.common_color_10047;
        int i2 = e.d.common_color_10106;
        SpannableString ax = ax(valueOf, al.getColor(i));
        SpannableString ax2 = ax(valueOf2, al.getColor(i));
        al.c(this.eVr, i2, 1);
        this.eVr.setText("");
        this.eVr.append(string);
        this.eVr.append(ax);
        this.eVr.append(string2);
        this.eVr.append(ax2);
        this.eVr.append(string3);
        this.eVr.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.eJR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.eJR);
        if (TextUtils.isEmpty(this.eVp.getText())) {
            this.eVt.setEnabled(false);
        } else {
            this.eVt.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eVp != null) {
            this.eVp.removeTextChangedListener(this.cxj);
        }
    }

    private void initView() {
        this.eVo = View.inflate(getPageContext().getPageActivity(), e.h.group_apply_activity, null);
        setContentView(this.eVo);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_apply_join);
        this.eVs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eVt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVt.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.eVt.setLayoutParams(layoutParams);
        this.eVs.setOnClickListener(this.aTa);
        this.eVq = (TextView) this.eVo.findViewById(e.g.tv_word_count);
        int length = 30 - this.eVy.length();
        if (length < 0) {
            length = 0;
        }
        this.eVq.setText(length + "/30");
        this.eVp = (EditText) this.eVo.findViewById(e.g.et_content);
        this.eVp.addTextChangedListener(this.cxj);
        this.eVp.setText(this.eVy);
        this.eVr = (TextView) this.eVo.findViewById(e.g.tv_add_limit);
        this.eVr.setVisibility(8);
        this.eVt.setOnClickListener(this.aTa);
        this.eVu = (Button) this.eVo.findViewById(e.g.btn_agree);
        this.eVu.setOnClickListener(this.aTa);
        this.eVv = (Button) this.eVo.findViewById(e.g.btn_disagree);
        this.eVv.setOnClickListener(this.aTa);
        this.eVu.setVisibility(8);
        this.eVv.setVisibility(8);
        ShowSoftKeyPadDelay(this.eVp, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eVo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.eVt, e.f.s_navbar_button_bg);
        al.c(this.eVt, e.d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eVw = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eVx = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eVy = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eVy == null) {
            this.eVy = "";
        }
    }

    private void initListener() {
        this.cxj = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eVp.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eVp.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eVt.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eVp.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eVq.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eVt.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eVt.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eVq.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eVp.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eVq.setText(length + "/30");
                }
            }
        };
        this.aTa = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eVt)) {
                        if (!j.kV()) {
                            ApplyJoinGroupActivity.this.showToast(e.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eVp.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eVt.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eVs)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
