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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener axH;
    TextWatcher bRR;
    String ecA;
    View ecq;
    EditText ecr;
    TextView ecs;
    TextView ect;
    View ecu;
    TextView ecv;
    Button ecw;
    Button ecx;
    int ecy;
    int ecz;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c dQP = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.ecv.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.k.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aGS().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aEL();
    }

    private void aEL() {
        aEM();
    }

    private void aEM() {
        if (this.ecz == 0 && this.ecy == 0) {
            this.ect.setText("");
            return;
        }
        String string = getPageContext().getString(d.k.group_join_limit_str1);
        String valueOf = String.valueOf(this.ecy);
        String string2 = getPageContext().getString(d.k.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.ecz);
        String string3 = getPageContext().getString(d.k.group_join_limit_str5);
        int i = d.C0126d.common_color_10047;
        int i2 = d.C0126d.common_color_10106;
        SpannableString ao = ao(valueOf, ak.getColor(i));
        SpannableString ao2 = ao(valueOf2, ak.getColor(i));
        ak.c(this.ect, i2, 1);
        this.ect.setText("");
        this.ect.append(string);
        this.ect.append(ao);
        this.ect.append(string2);
        this.ect.append(ao2);
        this.ect.append(string3);
        this.ect.setVisibility(0);
    }

    public static SpannableString ao(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.dQP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.dQP);
        if (TextUtils.isEmpty(this.ecr.getText())) {
            this.ecv.setEnabled(false);
        } else {
            this.ecv.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ecr != null) {
            this.ecr.removeTextChangedListener(this.bRR);
        }
    }

    private void initView() {
        this.ecq = View.inflate(getPageContext().getPageActivity(), d.i.group_apply_activity, null);
        setContentView(this.ecq);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.group_apply_join);
        this.ecu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ecv.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.ecv.setLayoutParams(layoutParams);
        this.ecu.setOnClickListener(this.axH);
        this.ecs = (TextView) this.ecq.findViewById(d.g.tv_word_count);
        int length = 30 - this.ecA.length();
        if (length < 0) {
            length = 0;
        }
        this.ecs.setText(length + "/30");
        this.ecr = (EditText) this.ecq.findViewById(d.g.et_content);
        this.ecr.addTextChangedListener(this.bRR);
        this.ecr.setText(this.ecA);
        this.ect = (TextView) this.ecq.findViewById(d.g.tv_add_limit);
        this.ect.setVisibility(8);
        this.ecv.setOnClickListener(this.axH);
        this.ecw = (Button) this.ecq.findViewById(d.g.btn_agree);
        this.ecw.setOnClickListener(this.axH);
        this.ecx = (Button) this.ecq.findViewById(d.g.btn_disagree);
        this.ecx.setOnClickListener(this.axH);
        this.ecw.setVisibility(8);
        this.ecx.setVisibility(8);
        ShowSoftKeyPadDelay(this.ecr, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.ecq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.i(this.ecv, d.f.s_navbar_button_bg);
        ak.c(this.ecv, d.C0126d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.ecy = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.ecz = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.ecA = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.ecA == null) {
            this.ecA = "";
        }
    }

    private void initListener() {
        this.bRR = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.ecr.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.ecr.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.ecv.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.ecr.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.ecs.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0126d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.ecv.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.ecv.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.ecs.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0126d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.ecr.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.ecs.setText(length + "/30");
                }
            }
        };
        this.axH = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    if (view2.equals(ApplyJoinGroupActivity.this.ecv)) {
                        if (!j.gP()) {
                            ApplyJoinGroupActivity.this.showToast(d.k.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.ecr.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.ecv.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view2.equals(ApplyJoinGroupActivity.this.ecu)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
