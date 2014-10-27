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
    View.OnClickListener Nw;
    View aGI;
    EditText aZR;
    TextView aZS;
    TextView aZT;
    View aZU;
    TextView aZV;
    Button aZW;
    Button aZX;
    TextWatcher aZY;
    String aZZ;
    int baa;
    int bab;
    String bac;
    long inviteUserId;
    int joinType;
    private NavigationBar mNavigationBar = null;
    private com.baidu.adp.framework.listener.e ayJ = new a(this, 103110);

    static {
        Kj();
    }

    private static void Kj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008014, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xb();
        HJ();
        nu();
        Oy();
    }

    private void Oy() {
        Oz();
    }

    private void Oz() {
        if (this.bab == 0 && this.baa == 0) {
            this.aZT.setText("");
            return;
        }
        String string = getString(com.baidu.tieba.y.group_join_limit_str1);
        String valueOf = String.valueOf(this.baa);
        String string2 = getString(com.baidu.tieba.y.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.bab);
        String string3 = getString(com.baidu.tieba.y.group_join_limit_str5);
        int i = com.baidu.tieba.s.edit_exceed;
        int i2 = com.baidu.tieba.s.edit_normal;
        SpannableString A = A(valueOf, aw.getColor(i));
        SpannableString A2 = A(valueOf2, aw.getColor(i));
        aw.b(this.aZT, i2, 1);
        this.aZT.setText("");
        this.aZT.append(string);
        this.aZT.append(A);
        this.aZT.append(string2);
        this.aZT.append(A2);
        this.aZT.append(string3);
        this.aZT.setVisibility(0);
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
        MessageManager.getInstance().unRegisterListener(this.ayJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.ayJ);
        if (TextUtils.isEmpty(this.aZR.getText())) {
            this.aZV.setEnabled(false);
        } else {
            this.aZV.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aZR != null) {
            this.aZR.removeTextChangedListener(this.aZY);
        }
    }

    void nu() {
        this.aGI = View.inflate(this, com.baidu.tieba.w.group_apply_activity, null);
        setContentView(this.aGI);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.group_apply_join);
        this.aZU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.group_apply_send));
        this.aZU.setOnClickListener(this.Nw);
        this.aZR = (EditText) this.aGI.findViewById(com.baidu.tieba.v.et_content);
        this.aZR.setText(this.bac);
        this.aZR.setSelection(this.bac.length());
        this.aZS = (TextView) this.aGI.findViewById(com.baidu.tieba.v.tv_word_count);
        int length = 30 - this.bac.length();
        if (length < 0) {
            length = 0;
        }
        this.aZS.setText(String.valueOf(length) + "/30");
        this.aZT = (TextView) this.aGI.findViewById(com.baidu.tieba.v.tv_add_limit);
        this.aZT.setVisibility(8);
        this.aZV.setOnClickListener(this.Nw);
        this.aZW = (Button) this.aGI.findViewById(com.baidu.tieba.v.btn_agree);
        this.aZW.setOnClickListener(this.Nw);
        this.aZX = (Button) this.aGI.findViewById(com.baidu.tieba.v.btn_disagree);
        this.aZX.setOnClickListener(this.Nw);
        this.aZW.setVisibility(8);
        this.aZX.setVisibility(8);
        this.aZR.addTextChangedListener(this.aZY);
        ShowSoftKeyPadDelay(this.aZR, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.aGI);
        this.mNavigationBar.onChangeSkinType(i);
        aw.h((View) this.aZV, com.baidu.tieba.u.title_comm_hilite);
        aw.b(this.aZV, com.baidu.tieba.s.btn_agree_text_color, 1);
    }

    void xb() {
        Intent intent = getIntent();
        if (intent != null) {
            this.aZZ = intent.getStringExtra(ApplyJoinGroupActivityConfig.GROUP_ID);
            this.baa = intent.getIntExtra(ApplyJoinGroupActivityConfig.ALREADY_JOIN_COUNT, 0);
            this.bab = intent.getIntExtra(ApplyJoinGroupActivityConfig.CAN_JOIN_COUNT, 0);
            this.inviteUserId = intent.getLongExtra(ApplyJoinGroupActivityConfig.INVITE_USER_ID, 0L);
            this.bac = intent.getStringExtra(ApplyJoinGroupActivityConfig.DEFAULT_USER_MSG);
            this.joinType = intent.getIntExtra(ApplyJoinGroupActivityConfig.JOIN_TYPE, ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT);
        }
        if (this.bac == null) {
            this.bac = "";
        }
    }

    void HJ() {
        this.aZY = new c(this);
        this.Nw = new d(this);
    }
}
