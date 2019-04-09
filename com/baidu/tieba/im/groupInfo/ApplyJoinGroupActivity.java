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
    View.OnClickListener ccD;
    View crI;
    TextWatcher dMd;
    EditText glX;
    TextView glY;
    TextView glZ;
    View gma;
    TextView gmb;
    Button gmc;
    Button gmd;
    int gme;
    int gmf;
    String gmg;
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
                    ApplyJoinGroupActivity.this.gmb.setEnabled(true);
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
        if (this.gmf == 0 && this.gme == 0) {
            this.glZ.setText("");
            return;
        }
        String string = getPageContext().getString(d.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.gme);
        String string2 = getPageContext().getString(d.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.gmf);
        String string3 = getPageContext().getString(d.j.group_join_limit_str5);
        int i = d.C0277d.common_color_10047;
        int i2 = d.C0277d.common_color_10106;
        SpannableString aS = aS(valueOf, al.getColor(i));
        SpannableString aS2 = aS(valueOf2, al.getColor(i));
        al.d(this.glZ, i2, 1);
        this.glZ.setText("");
        this.glZ.append(string);
        this.glZ.append(aS);
        this.glZ.append(string2);
        this.glZ.append(aS2);
        this.glZ.append(string3);
        this.glZ.setVisibility(0);
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
        if (TextUtils.isEmpty(this.glX.getText())) {
            this.gmb.setEnabled(false);
        } else {
            this.gmb.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.glX != null) {
            this.glX.removeTextChangedListener(this.dMd);
        }
    }

    private void initView() {
        this.crI = View.inflate(getPageContext().getPageActivity(), d.h.group_apply_activity, null);
        setContentView(this.crI);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.group_apply_join);
        this.gma = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gmb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmb.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.gmb.setLayoutParams(layoutParams);
        this.gma.setOnClickListener(this.ccD);
        this.glY = (TextView) this.crI.findViewById(d.g.tv_word_count);
        int length = 30 - this.gmg.length();
        if (length < 0) {
            length = 0;
        }
        this.glY.setText(length + "/30");
        this.glX = (EditText) this.crI.findViewById(d.g.et_content);
        this.glX.addTextChangedListener(this.dMd);
        this.glX.setText(this.gmg);
        this.glZ = (TextView) this.crI.findViewById(d.g.tv_add_limit);
        this.glZ.setVisibility(8);
        this.gmb.setOnClickListener(this.ccD);
        this.gmc = (Button) this.crI.findViewById(d.g.btn_agree);
        this.gmc.setOnClickListener(this.ccD);
        this.gmd = (Button) this.crI.findViewById(d.g.btn_disagree);
        this.gmd.setOnClickListener(this.ccD);
        this.gmc.setVisibility(8);
        this.gmd.setVisibility(8);
        ShowSoftKeyPadDelay(this.glX, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.crI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.gmb, d.f.s_navbar_button_bg);
        al.d(this.gmb, d.C0277d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.gme = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.gmf = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.gmg = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.gmg == null) {
            this.gmg = "";
        }
    }

    private void initListener() {
        this.dMd = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.glX.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.glX.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.gmb.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.glX.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.glY.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0277d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.gmb.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.gmb.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.glY.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(d.C0277d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.glX.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.glY.setText(length + "/30");
                }
            }
        };
        this.ccD = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.gmb)) {
                        if (!j.kY()) {
                            ApplyJoinGroupActivity.this.showToast(d.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.glX.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.gmb.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.gma)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
