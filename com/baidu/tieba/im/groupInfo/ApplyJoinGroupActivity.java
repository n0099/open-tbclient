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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class ApplyJoinGroupActivity extends BaseActivity<ApplyJoinGroupActivity> {
    View fDE;
    View.OnClickListener foP;
    String groupID;
    long inviteUserId;
    int joinType;
    TextView kwA;
    View kwB;
    TextView kwC;
    Button kwD;
    Button kwE;
    TextWatcher kwF;
    int kwG;
    int kwH;
    String kwI;
    EditText kwy;
    TextView kwz;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c kjh = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_JOIN_GROUP) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.kwC.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(R.string.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.cZX().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        cXV();
    }

    private void cXV() {
        cXW();
    }

    private void cXW() {
        if (this.kwH == 0 && this.kwG == 0) {
            this.kwA.setText("");
            return;
        }
        String string = getPageContext().getString(R.string.group_join_limit_str1);
        String valueOf = String.valueOf(this.kwG);
        String string2 = getPageContext().getString(R.string.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.kwH);
        String string3 = getPageContext().getString(R.string.group_join_limit_str5);
        int i = R.color.common_color_10047;
        int i2 = R.color.common_color_10106;
        SpannableString bk = bk(valueOf, ap.getColor(i));
        SpannableString bk2 = bk(valueOf2, ap.getColor(i));
        ap.setViewTextColor(this.kwA, i2, 1);
        this.kwA.setText("");
        this.kwA.append(string);
        this.kwA.append(bk);
        this.kwA.append(string2);
        this.kwA.append(bk2);
        this.kwA.append(string3);
        this.kwA.setVisibility(0);
    }

    public static SpannableString bk(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.kjh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.kjh);
        if (TextUtils.isEmpty(this.kwy.getText())) {
            this.kwC.setEnabled(false);
        } else {
            this.kwC.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kwy != null) {
            this.kwy.removeTextChangedListener(this.kwF);
        }
    }

    private void initView() {
        this.fDE = View.inflate(getPageContext().getPageActivity(), R.layout.group_apply_activity, null);
        setContentView(this.fDE);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.group_apply_join);
        this.kwB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kwC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kwC.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.kwC.setLayoutParams(layoutParams);
        this.kwB.setOnClickListener(this.foP);
        this.kwz = (TextView) this.fDE.findViewById(R.id.tv_word_count);
        int length = 30 - this.kwI.length();
        if (length < 0) {
            length = 0;
        }
        this.kwz.setText(length + "/30");
        this.kwy = (EditText) this.fDE.findViewById(R.id.et_content);
        this.kwy.addTextChangedListener(this.kwF);
        this.kwy.setText(this.kwI);
        this.kwA = (TextView) this.fDE.findViewById(R.id.tv_add_limit);
        this.kwA.setVisibility(8);
        this.kwC.setOnClickListener(this.foP);
        this.kwD = (Button) this.fDE.findViewById(R.id.btn_agree);
        this.kwD.setOnClickListener(this.foP);
        this.kwE = (Button) this.fDE.findViewById(R.id.btn_disagree);
        this.kwE.setOnClickListener(this.foP);
        this.kwD.setVisibility(8);
        this.kwE.setVisibility(8);
        ShowSoftKeyPadDelay(this.kwy, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fDE);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.kwC, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.kwC, R.color.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.kwG = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.kwH = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.kwI = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.kwI == null) {
            this.kwI = "";
        }
    }

    private void initListener() {
        this.kwF = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.kwy.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.kwy.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.kwC.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.kwy.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.kwz.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.kwC.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.kwC.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.kwz.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(R.color.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.kwy.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.kwz.setText(length + "/30");
                }
            }
        };
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.kwC)) {
                        if (!j.isNetWorkAvailable()) {
                            ApplyJoinGroupActivity.this.showToast(R.string.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.kwy.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.kwC.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.kwB)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
