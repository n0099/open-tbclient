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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View.OnClickListener ckI;
    View czO;
    TextWatcher dWD;
    EditText gDn;
    TextView gDo;
    TextView gDp;
    View gDq;
    TextView gDr;
    Button gDs;
    Button gDt;
    int gDu;
    int gDv;
    String gDw;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                int error = responseJoinGroupMessage.getError();
                String errorString = responseJoinGroupMessage.getErrorString();
                if (responseJoinGroupMessage.getError() != 0) {
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_fail);
                    }
                    ApplyJoinGroupActivity.this.gDr.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.bDJ().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        bBJ();
    }

    private void bBJ() {
        bBK();
    }

    private void bBK() {
        if (this.gDv == 0 && this.gDu == 0) {
            this.gDp.setText("");
            return;
        }
        String string = getPageContext().getString(R.string.group_join_limit_str1);
        String valueOf = String.valueOf(this.gDu);
        String string2 = getPageContext().getString(R.string.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.gDv);
        String string3 = getPageContext().getString(R.string.group_join_limit_str5);
        SpannableString aO = aO(valueOf, al.getColor(R.color.common_color_10047));
        SpannableString aO2 = aO(valueOf2, al.getColor(R.color.common_color_10047));
        al.f(this.gDp, R.color.common_color_10106, 1);
        this.gDp.setText("");
        this.gDp.append(string);
        this.gDp.append(aO);
        this.gDp.append(string2);
        this.gDp.append(aO2);
        this.gDp.append(string3);
        this.gDp.setVisibility(0);
    }

    public static SpannableString aO(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.grM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.grM);
        if (TextUtils.isEmpty(this.gDn.getText())) {
            this.gDr.setEnabled(false);
        } else {
            this.gDr.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDn != null) {
            this.gDn.removeTextChangedListener(this.dWD);
        }
    }

    private void initView() {
        this.czO = View.inflate(getPageContext().getPageActivity(), R.layout.group_apply_activity, null);
        setContentView(this.czO);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_apply_join);
        this.gDq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gDr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDr.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.gDr.setLayoutParams(layoutParams);
        this.gDq.setOnClickListener(this.ckI);
        this.gDo = (TextView) this.czO.findViewById(R.id.tv_word_count);
        int length = 30 - this.gDw.length();
        if (length < 0) {
            length = 0;
        }
        this.gDo.setText(length + "/30");
        this.gDn = (EditText) this.czO.findViewById(R.id.et_content);
        this.gDn.addTextChangedListener(this.dWD);
        this.gDn.setText(this.gDw);
        this.gDp = (TextView) this.czO.findViewById(R.id.tv_add_limit);
        this.gDp.setVisibility(8);
        this.gDr.setOnClickListener(this.ckI);
        this.gDs = (Button) this.czO.findViewById(R.id.btn_agree);
        this.gDs.setOnClickListener(this.ckI);
        this.gDt = (Button) this.czO.findViewById(R.id.btn_disagree);
        this.gDt.setOnClickListener(this.ckI);
        this.gDs.setVisibility(8);
        this.gDt.setVisibility(8);
        ShowSoftKeyPadDelay(this.gDn, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.czO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.k(this.gDr, R.drawable.s_navbar_button_bg);
        al.f(this.gDr, R.color.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.gDu = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.gDv = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.gDw = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.gDw == null) {
            this.gDw = "";
        }
    }

    private void initListener() {
        this.dWD = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.gDn.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.gDn.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.gDr.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.gDn.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.gDo.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.gDr.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.gDr.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.gDo.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.gDn.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.gDo.setText(length + "/30");
                }
            }
        };
        this.ckI = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.gDr)) {
                        if (!j.jS()) {
                            ApplyJoinGroupActivity.this.showToast(R.string.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.c(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.gDn.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.gDr.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.gDq)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
