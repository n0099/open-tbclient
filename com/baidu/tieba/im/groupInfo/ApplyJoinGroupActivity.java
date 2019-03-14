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
/* loaded from: classes5.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener ccA;
    View crF;
    TextWatcher dML;
    EditText gmj;
    TextView gmk;
    TextView gml;
    View gmm;
    TextView gmn;
    Button gmo;
    Button gmp;
    int gmq;
    int gmr;
    String gms;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c gaF = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.gmn.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.bwa().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        btW();
    }

    private void btW() {
        btX();
    }

    private void btX() {
        if (this.gmr == 0 && this.gmq == 0) {
            this.gml.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.gmq);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.gmr);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0277d.common_color_10047;
        int i2 = d.C0277d.common_color_10106;
        SpannableString aS = aS(valueOf, al.getColor(i));
        SpannableString aS2 = aS(valueOf2, al.getColor(i));
        al.d(this.gml, i2, 1);
        this.gml.setText("");
        this.gml.append(string);
        this.gml.append(aS);
        this.gml.append(string2);
        this.gml.append(aS2);
        this.gml.append(string3);
        this.gml.setVisibility(0);
    }

    public static SpannableString aS(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.gaF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.gaF);
        if (TextUtils.isEmpty(this.gmj.getText())) {
            this.gmn.setEnabled(false);
        } else {
            this.gmn.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gmj != null) {
            this.gmj.removeTextChangedListener(this.dML);
        }
    }

    private void initView() {
        this.crF = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.crF);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.gmm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gmn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmn.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.gmn.setLayoutParams(layoutParams);
        this.gmm.setOnClickListener(this.ccA);
        this.gmk = (TextView) this.crF.findViewById(d.g.tv_word_count);
        int length = 30 - this.gms.length();
        if (length < 0) {
            length = 0;
        }
        this.gmk.setText(length + "/30");
        this.gmj = (EditText) this.crF.findViewById(d.g.et_content);
        this.gmj.addTextChangedListener(this.dML);
        this.gmj.setText(this.gms);
        this.gml = (TextView) this.crF.findViewById(d.g.tv_add_limit);
        this.gml.setVisibility(8);
        this.gmn.setOnClickListener(this.ccA);
        this.gmo = (Button) this.crF.findViewById(d.g.btn_agree);
        this.gmo.setOnClickListener(this.ccA);
        this.gmp = (Button) this.crF.findViewById(d.g.btn_disagree);
        this.gmp.setOnClickListener(this.ccA);
        this.gmo.setVisibility(8);
        this.gmp.setVisibility(8);
        ShowSoftKeyPadDelay(this.gmj, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.crF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.gmn, d.f.s_navbar_button_bg);
        al.d(this.gmn, d.C0277d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.gmq = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.gmr = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.gms = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.gms == null) {
            this.gms = "";
        }
    }

    private void initListener() {
        this.dML = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.gmj.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.gmj.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.gmn.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.gmj.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.gmk.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0277d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.gmn.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.gmn.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.gmk.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0277d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.gmj.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.gmk.setText(length + "/30");
                }
            }
        };
        this.ccA = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.gmn)) {
                        if (!j.kY()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.gmj.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.gmn.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.gmm)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
