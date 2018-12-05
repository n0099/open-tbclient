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
    View.OnClickListener aSY;
    TextWatcher cwe;
    TextView eSA;
    View eSB;
    TextView eSC;
    Button eSD;
    Button eSE;
    int eSF;
    int eSG;
    String eSH;
    View eSx;
    EditText eSy;
    TextView eSz;
    String groupID;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.c eHa = new com.baidu.adp.framework.listener.c(103110) { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.3
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
                    ApplyJoinGroupActivity.this.eSC.setEnabled(true);
                    ApplyJoinGroupActivity.this.showToast(errorString);
                    return;
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = ApplyJoinGroupActivity.this.getPageContext().getString(e.j.group_apply_succ);
                }
                ApplyJoinGroupActivity.this.showToast(errorString, false);
                if (error == 0) {
                    com.baidu.tieba.im.settingcache.b.aUi().b(TbadkApplication.getCurrentAccount(), ApplyJoinGroupActivity.this.groupID, true, null);
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
        aSe();
    }

    private void aSe() {
        aSf();
    }

    private void aSf() {
        if (this.eSG == 0 && this.eSF == 0) {
            this.eSA.setText("");
            return;
        }
        String string = getPageContext().getString(e.j.group_join_limit_str1);
        String valueOf = String.valueOf(this.eSF);
        String string2 = getPageContext().getString(e.j.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.eSG);
        String string3 = getPageContext().getString(e.j.group_join_limit_str5);
        int i = e.d.common_color_10047;
        int i2 = e.d.common_color_10106;
        SpannableString aw = aw(valueOf, al.getColor(i));
        SpannableString aw2 = aw(valueOf2, al.getColor(i));
        al.c(this.eSA, i2, 1);
        this.eSA.setText("");
        this.eSA.append(string);
        this.eSA.append(aw);
        this.eSA.append(string2);
        this.eSA.append(aw2);
        this.eSA.append(string3);
        this.eSA.setVisibility(0);
    }

    public static SpannableString aw(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eHa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.eHa);
        if (TextUtils.isEmpty(this.eSy.getText())) {
            this.eSC.setEnabled(false);
        } else {
            this.eSC.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eSy != null) {
            this.eSy.removeTextChangedListener(this.cwe);
        }
    }

    private void initView() {
        this.eSx = View.inflate(getPageContext().getPageActivity(), e.h.group_apply_activity, null);
        setContentView(this.eSx);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.group_apply_join);
        this.eSB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.send_msg));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSC.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.eSC.setLayoutParams(layoutParams);
        this.eSB.setOnClickListener(this.aSY);
        this.eSz = (TextView) this.eSx.findViewById(e.g.tv_word_count);
        int length = 30 - this.eSH.length();
        if (length < 0) {
            length = 0;
        }
        this.eSz.setText(length + "/30");
        this.eSy = (EditText) this.eSx.findViewById(e.g.et_content);
        this.eSy.addTextChangedListener(this.cwe);
        this.eSy.setText(this.eSH);
        this.eSA = (TextView) this.eSx.findViewById(e.g.tv_add_limit);
        this.eSA.setVisibility(8);
        this.eSC.setOnClickListener(this.aSY);
        this.eSD = (Button) this.eSx.findViewById(e.g.btn_agree);
        this.eSD.setOnClickListener(this.aSY);
        this.eSE = (Button) this.eSx.findViewById(e.g.btn_disagree);
        this.eSE.setOnClickListener(this.aSY);
        this.eSD.setVisibility(8);
        this.eSE.setVisibility(8);
        ShowSoftKeyPadDelay(this.eSy, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eSx);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.eSC, e.f.s_navbar_button_bg);
        al.c(this.eSC, e.d.navbar_btn_color, 1);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.groupID = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.eSF = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.eSG = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.eSH = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.eSH == null) {
            this.eSH = "";
        }
    }

    private void initListener() {
        this.cwe = new TextWatcher() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int selectionStart = ApplyJoinGroupActivity.this.eSy.getSelectionStart();
                    int selectionEnd = ApplyJoinGroupActivity.this.eSy.getSelectionEnd();
                    int length = editable.length();
                    if (30 < length) {
                        ApplyJoinGroupActivity.this.eSC.setEnabled(false);
                        editable.delete(selectionStart - 1, selectionEnd);
                        ApplyJoinGroupActivity.this.eSy.setText(editable);
                        length = 30;
                    } else {
                        ApplyJoinGroupActivity.this.eSz.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10106));
                        if (editable.length() > 0) {
                            ApplyJoinGroupActivity.this.eSC.setEnabled(true);
                        } else {
                            ApplyJoinGroupActivity.this.eSC.setEnabled(false);
                        }
                    }
                    if (30 == length) {
                        ApplyJoinGroupActivity.this.eSz.setTextColor(ApplyJoinGroupActivity.this.getResources().getColor(e.d.common_color_10047));
                    }
                    ApplyJoinGroupActivity.this.eSy.setSelection(editable.length());
                    ApplyJoinGroupActivity.this.eSz.setText(length + "/30");
                }
            }
        };
        this.aSY = new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.ApplyJoinGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.equals(ApplyJoinGroupActivity.this.eSC)) {
                        if (!j.kV()) {
                            ApplyJoinGroupActivity.this.showToast(e.j.neterror);
                            return;
                        }
                        RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                        requestJoinGroupMessage.setGroupId(com.baidu.adp.lib.g.b.d(ApplyJoinGroupActivity.this.groupID, 0L));
                        requestJoinGroupMessage.setUserMsg(ApplyJoinGroupActivity.this.eSy.getText().toString());
                        requestJoinGroupMessage.setJoinType(ApplyJoinGroupActivity.this.joinType);
                        requestJoinGroupMessage.setInviteUserId(ApplyJoinGroupActivity.this.inviteUserId);
                        ApplyJoinGroupActivity.this.eSC.setEnabled(false);
                        ApplyJoinGroupActivity.this.sendMessage(requestJoinGroupMessage);
                    } else if (view.equals(ApplyJoinGroupActivity.this.eSB)) {
                        ApplyJoinGroupActivity.this.finish();
                    }
                }
            }
        };
    }
}
