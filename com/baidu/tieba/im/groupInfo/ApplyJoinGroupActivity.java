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
    View.OnClickListener ccC;
    View crH;
    TextWatcher dMc;
    EditText glW;
    TextView glX;
    TextView glY;
    View glZ;
    TextView gma;
    Button gmb;
    Button gmc;
    int gmd;
    int gme;
    String gmf;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c gat = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.gma.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(d.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.bvX().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        btT();
    }

    private void btT() {
        btU();
    }

    private void btU() {
        if (this.gme == 0 && this.gmd == 0) {
            this.glY.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.gmd);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.gme);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0277d.common_color_10047;
        int i2 = d.C0277d.common_color_10106;
        SpannableString aS = aS(valueOf, al.getColor(i));
        SpannableString aS2 = aS(valueOf2, al.getColor(i));
        al.d(this.glY, i2, 1);
        this.glY.setText("");
        this.glY.append(string);
        this.glY.append(aS);
        this.glY.append(string2);
        this.glY.append(aS2);
        this.glY.append(string3);
        this.glY.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.gat);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.gat);
        if (TextUtils.isEmpty(this.glW.getText())) {
            this.gma.setEnabled(false);
        } else {
            this.gma.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.glW != null) {
            this.glW.removeTextChangedListener(this.dMc);
        }
    }

    private void initView() {
        this.crH = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.crH);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.glZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gma = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gma.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.gma.setLayoutParams(layoutParams);
        this.glZ.setOnClickListener(this.ccC);
        this.glX = (TextView) this.crH.findViewById(d.g.tv_word_count);
        int length = 30 - this.gmf.length();
        if (length < 0) {
            length = 0;
        }
        this.glX.setText(length + "/30");
        this.glW = (EditText) this.crH.findViewById(d.g.et_content);
        this.glW.addTextChangedListener(this.dMc);
        this.glW.setText(this.gmf);
        this.glY = (TextView) this.crH.findViewById(d.g.tv_add_limit);
        this.glY.setVisibility(8);
        this.gma.setOnClickListener(this.ccC);
        this.gmb = (Button) this.crH.findViewById(d.g.btn_agree);
        this.gmb.setOnClickListener(this.ccC);
        this.gmc = (Button) this.crH.findViewById(d.g.btn_disagree);
        this.gmc.setOnClickListener(this.ccC);
        this.gmb.setVisibility(8);
        this.gmc.setVisibility(8);
        ShowSoftKeyPadDelay(this.glW, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.crH);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.gma, d.f.s_navbar_button_bg);
        al.d(this.gma, d.C0277d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.gmd = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.gme = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.gmf = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.gmf == null) {
            this.gmf = "";
        }
    }

    private void initListener() {
        this.dMc = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.glW.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.glW.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.gma.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.glW.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.glX.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0277d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.gma.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.gma.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.glX.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0277d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.glW.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.glX.setText(length + "/30");
                }
            }
        };
        this.ccC = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.gma)) {
                        if (!j.kY()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.glW.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.gma.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.glZ)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
