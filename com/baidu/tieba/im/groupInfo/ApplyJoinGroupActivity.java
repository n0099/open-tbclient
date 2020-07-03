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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View eCi;
    View.OnClickListener eoP;
    String groupID;
    EditText iVc;
    TextView iVd;
    TextView iVe;
    View iVf;
    TextView iVg;
    Button iVh;
    Button iVi;
    TextWatcher iVj;
    int iVk;
    int iVl;
    String iVm;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c iJH = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_JOIN_GROUP) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.iVg.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.ctn().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        cro();
    }

    private void cro() {
        crp();
    }

    private void crp() {
        if (this.iVl == 0 && this.iVk == 0) {
            this.iVe.setText("");
            return;
        }
        String string = getPageContext().getString(R.string.group_join_limit_str1);
        String valueOf = String.valueOf(this.iVk);
        String string2 = getPageContext().getString(R.string.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.iVl);
        String string3 = getPageContext().getString(R.string.group_join_limit_str5);
        SpannableString be = be(valueOf, an.getColor(R.color.common_color_10047));
        SpannableString be2 = be(valueOf2, an.getColor(R.color.common_color_10047));
        an.setViewTextColor(this.iVe, R.color.common_color_10106, 1);
        this.iVe.setText("");
        this.iVe.append(string);
        this.iVe.append(be);
        this.iVe.append(string2);
        this.iVe.append(be2);
        this.iVe.append(string3);
        this.iVe.setVisibility(0);
    }

    public static SpannableString be(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.iJH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.iJH);
        if (TextUtils.isEmpty(this.iVc.getText())) {
            this.iVg.setEnabled(false);
        } else {
            this.iVg.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVc != null) {
            this.iVc.removeTextChangedListener(this.iVj);
        }
    }

    private void initView() {
        this.eCi = View.inflate(getPageContext().getPageActivity(), R.layout.group_apply_activity, null);
        setContentView(this.eCi);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_apply_join);
        this.iVf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iVg.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.iVg.setLayoutParams(layoutParams);
        this.iVf.setOnClickListener(this.eoP);
        this.iVd = (TextView) this.eCi.findViewById(R.id.tv_word_count);
        int length = 30 - this.iVm.length();
        if (length < 0) {
            length = 0;
        }
        this.iVd.setText(length + "/30");
        this.iVc = (EditText) this.eCi.findViewById(R.id.et_content);
        this.iVc.addTextChangedListener(this.iVj);
        this.iVc.setText(this.iVm);
        this.iVe = (TextView) this.eCi.findViewById(R.id.tv_add_limit);
        this.iVe.setVisibility(8);
        this.iVg.setOnClickListener(this.eoP);
        this.iVh = (Button) this.eCi.findViewById(R.id.btn_agree);
        this.iVh.setOnClickListener(this.eoP);
        this.iVi = (Button) this.eCi.findViewById(R.id.btn_disagree);
        this.iVi.setOnClickListener(this.eoP);
        this.iVh.setVisibility(8);
        this.iVi.setVisibility(8);
        ShowSoftKeyPadDelay(this.iVc, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eCi);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        an.setBackgroundResource(this.iVg, R.drawable.s_navbar_button_bg);
        an.setViewTextColor(this.iVg, R.color.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.iVk = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.iVl = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.iVm = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.iVm == null) {
            this.iVm = "";
        }
    }

    private void initListener() {
        this.iVj = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.iVc.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.iVc.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.iVg.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.iVc.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.iVd.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.iVg.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.iVg.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.iVd.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.iVc.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.iVd.setText(length + "/30");
                }
            }
        };
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.iVg)) {
                        if (!j.isNetWorkAvailable()) {
                            ApplyJoinGroupActivity.this.showToast(R.string.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.iVc.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.iVg.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.iVf)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
