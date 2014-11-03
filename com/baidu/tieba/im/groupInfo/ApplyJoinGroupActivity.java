package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ApplyJoinGroupActivity extends BaseActivity {
    View.OnClickListener NA;
    View aGS;
    EditText bae;
    TextView baf;
    TextView bag;
    View bah;
    TextView bai;
    Button baj;
    Button bak;
    TextWatcher bal;
    String bam;
    int ban;
    int bao;
    String bap;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.e ayS = new a(this, 103110);

    static {
        Kn();
    }

    private static void Kn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008014, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xd();
        HN();
        nu();
        OB();
    }

    private void OB() {
        OC();
    }

    private void OC() {
        if (this.bao == 0 && this.ban == 0) {
            this.bag.setText("");
            return;
        }
        String string = getString(com.baidu.tieba.y.group_join_limit_str1);
        String valueOf = String.valueOf(this.ban);
        String string2 = getString(com.baidu.tieba.y.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.bao);
        String string3 = getString(com.baidu.tieba.y.group_join_limit_str5);
        int i = com.baidu.tieba.s.edit_exceed;
        int i2 = com.baidu.tieba.s.edit_normal;
        SpannableString A = A(valueOf, aw.getColor(i));
        SpannableString A2 = A(valueOf2, aw.getColor(i));
        aw.b(this.bag, i2, 1);
        this.bag.setText("");
        this.bag.append(string);
        this.bag.append(A);
        this.bag.append(string2);
        this.bag.append(A2);
        this.bag.append(string3);
        this.bag.setVisibility(0);
    }

    public static SpannableString A(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.ayS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.ayS);
        if (TextUtils.isEmpty(this.bae.getText())) {
            this.bai.setEnabled(false);
        } else {
            this.bai.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bae != null) {
            this.bae.removeTextChangedListener(this.bal);
        }
    }

    void nu() {
        this.aGS = View.inflate(this, com.baidu.tieba.w.group_apply_activity, null);
        setContentView(this.aGS);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.group_apply_join);
        this.bah = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bai = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.group_apply_send));
        this.bah.setOnClickListener(this.NA);
        this.bae = (EditText) this.aGS.findViewById(com.baidu.tieba.v.et_content);
        this.bae.setText(this.bap);
        this.bae.setSelection(this.bap.length());
        this.baf = (TextView) this.aGS.findViewById(com.baidu.tieba.v.tv_word_count);
        int length = 30 - this.bap.length();
        if (length < 0) {
            length = 0;
        }
        this.baf.setText(String.valueOf(length) + "/30");
        this.bag = (TextView) this.aGS.findViewById(com.baidu.tieba.v.tv_add_limit);
        this.bag.setVisibility(8);
        this.bai.setOnClickListener(this.NA);
        this.baj = (Button) this.aGS.findViewById(com.baidu.tieba.v.btn_agree);
        this.baj.setOnClickListener(this.NA);
        this.bak = (Button) this.aGS.findViewById(com.baidu.tieba.v.btn_disagree);
        this.bak.setOnClickListener(this.NA);
        this.baj.setVisibility(8);
        this.bak.setVisibility(8);
        this.bae.addTextChangedListener(this.bal);
        ShowSoftKeyPadDelay(this.bae, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.aGS);
        this.mNavigationBar.onChangeSkinType(i);
        aw.h((View) this.bai, com.baidu.tieba.u.title_comm_hilite);
        aw.b(this.bai, com.baidu.tieba.s.btn_agree_text_color, 1);
    }

    void xd() {
        Intent intent = getIntent();
        if (intent != null) {
            this.bam = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.ban = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.bao = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.bap = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.bap == null) {
            this.bap = "";
        }
    }

    void HN() {
        this.bal = new c(this);
        this.NA = new d(this);
    }
}
