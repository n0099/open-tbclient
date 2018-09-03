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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener aGT;
    TextWatcher cdI;
    View evn;
    EditText evo;
    TextView evp;
    TextView evq;
    View evr;
    TextView evs;
    Button evt;
    Button evu;
    int evv;
    int evw;
    String evx;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c ejH = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                int error = responseJoinGroupMessage.getError();
                String errorString = responseJoinGroupMessage.getErrorString();
                if (responseJoinGroupMessage.getError() != 0) {
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = ApplyJoinGroupActivity.this.getPageContext().getString(f.j.group_apply_fail);
                    }
                    ApplyJoinGroupActivity.this.evs.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(f.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aNq().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aLl();
    }

    private void aLl() {
        aLm();
    }

    private void aLm() {
        if (this.evw == 0 && this.evv == 0) {
            this.evq.setText("");
            return;
        }
        String string = getPageContext().getString(f.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.evv);
        String string2 = getPageContext().getString(f.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.evw);
        String string3 = getPageContext().getString(f.j.group_join_limit_str5);
        int i = f.d.common_color_10047;
        int i2 = f.d.common_color_10106;
        SpannableString am = am(valueOf, am.getColor(i));
        SpannableString am2 = am(valueOf2, am.getColor(i));
        am.c(this.evq, i2, 1);
        this.evq.setText("");
        this.evq.append(string);
        this.evq.append(am);
        this.evq.append(string2);
        this.evq.append(am2);
        this.evq.append(string3);
        this.evq.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.ejH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.ejH);
        if (TextUtils.isEmpty(this.evo.getText())) {
            this.evs.setEnabled(false);
        } else {
            this.evs.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.evo != null) {
            this.evo.removeTextChangedListener(this.cdI);
        }
    }

    private void initView() {
        this.evn = View.inflate(getPageContext().getPageActivity(), f.h.group_apply_activity, null);
        setContentView(this.evn);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(f.j.group_apply_join);
        this.evr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.evs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(f.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evs.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), f.e.ds16);
        this.evs.setLayoutParams(layoutParams);
        this.evr.setOnClickListener(this.aGT);
        this.evp = (TextView) this.evn.findViewById(f.g.tv_word_count);
        int length = 30 - this.evx.length();
        if (length < 0) {
            length = 0;
        }
        this.evp.setText(length + "/30");
        this.evo = (EditText) this.evn.findViewById(f.g.et_content);
        this.evo.addTextChangedListener(this.cdI);
        this.evo.setText(this.evx);
        this.evq = (TextView) this.evn.findViewById(f.g.tv_add_limit);
        this.evq.setVisibility(8);
        this.evs.setOnClickListener(this.aGT);
        this.evt = (Button) this.evn.findViewById(f.g.btn_agree);
        this.evt.setOnClickListener(this.aGT);
        this.evu = (Button) this.evn.findViewById(f.g.btn_disagree);
        this.evu.setOnClickListener(this.aGT);
        this.evt.setVisibility(8);
        this.evu.setVisibility(8);
        ShowSoftKeyPadDelay(this.evo, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.evn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.i(this.evs, f.C0146f.s_navbar_button_bg);
        am.c(this.evs, f.d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.evv = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.evw = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.evx = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.evx == null) {
            this.evx = "";
        }
    }

    private void initListener() {
        this.cdI = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.evo.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.evo.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.evs.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.evo.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.evp.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(f.d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.evs.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.evs.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.evp.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(f.d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.evo.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.evp.setText(length + "/30");
                }
            }
        };
        this.aGT = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.evs)) {
                        if (!j.jE()) {
                            ApplyJoinGroupActivity.this.showToast(f.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.evo.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.evs.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.evr)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
