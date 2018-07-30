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
    TextWatcher cdK;
    int evA;
    String evB;
    View evr;
    EditText evs;
    TextView evt;
    TextView evu;
    View evv;
    TextView evw;
    Button evx;
    Button evy;
    int evz;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c ejL = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.evw.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aNt().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aLo();
    }

    private void aLo() {
        aLp();
    }

    private void aLp() {
        if (this.evA == 0 && this.evz == 0) {
            this.evu.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.evz);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.evA);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0140d.common_color_10047;
        int i2 = d.C0140d.common_color_10106;
        SpannableString am = am(valueOf, am.getColor(i));
        SpannableString am2 = am(valueOf2, am.getColor(i));
        am.c(this.evu, i2, 1);
        this.evu.setText("");
        this.evu.append(string);
        this.evu.append(am);
        this.evu.append(string2);
        this.evu.append(am2);
        this.evu.append(string3);
        this.evu.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.ejL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.ejL);
        if (TextUtils.isEmpty(this.evs.getText())) {
            this.evw.setEnabled(false);
        } else {
            this.evw.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.evs != null) {
            this.evs.removeTextChangedListener(this.cdK);
        }
    }

    private void initView() {
        this.evr = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.evr);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.evv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evw.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds16);
        this.evw.setLayoutParams(layoutParams);
        this.evv.setOnClickListener(this.aGU);
        this.evt = (TextView) this.evr.findViewById(d.g.tv_word_count);
        int length = 30 - this.evB.length();
        if (length < 0) {
            length = 0;
        }
        this.evt.setText(length + "/30");
        this.evs = (EditText) this.evr.findViewById(d.g.et_content);
        this.evs.addTextChangedListener(this.cdK);
        this.evs.setText(this.evB);
        this.evu = (TextView) this.evr.findViewById(d.g.tv_add_limit);
        this.evu.setVisibility(8);
        this.evw.setOnClickListener(this.aGU);
        this.evx = (Button) this.evr.findViewById(d.g.btn_agree);
        this.evx.setOnClickListener(this.aGU);
        this.evy = (Button) this.evr.findViewById(d.g.btn_disagree);
        this.evy.setOnClickListener(this.aGU);
        this.evx.setVisibility(8);
        this.evy.setVisibility(8);
        ShowSoftKeyPadDelay(this.evs, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.evr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.i(this.evw, d.f.s_navbar_button_bg);
        am.c(this.evw, d.C0140d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.evz = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.evA = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.evB = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.evB == null) {
            this.evB = "";
        }
    }

    private void initListener() {
        this.cdK = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.evs.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.evs.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.evw.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.evs.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.evt.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0140d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.evw.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.evw.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.evt.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0140d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.evs.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.evt.setText(length + "/30");
                }
            }
        };
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.evw)) {
                        if (!j.jE()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.evs.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.evw.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.evv)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
