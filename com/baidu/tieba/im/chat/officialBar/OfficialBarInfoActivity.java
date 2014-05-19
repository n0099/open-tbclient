package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class OfficialBarInfoActivity extends BaseActivity implements View.OnClickListener, com.baidu.adp.widget.BdSwitchView.c {
    al a;
    am b;
    private int c = 0;
    private String d = null;
    private com.baidu.tbadk.editortool.ab e;
    private an f;

    public static void a(Context context, int i, String str) {
        Intent intent = new Intent(context, OfficialBarInfoActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, i);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        a();
        b();
    }

    private void a() {
        this.f = new an(this);
        this.f.a((View.OnClickListener) this);
        this.f.a((com.baidu.adp.widget.BdSwitchView.c) this);
        showProgressBar();
    }

    private void b() {
        this.c = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, 0);
        this.d = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        if (this.d != null && com.baidu.tieba.im.f.t.a(this.d) > 16) {
            this.f.b(String.valueOf(com.baidu.tieba.im.f.t.a(this.d, 0, 16)) + "……");
        } else {
            this.f.b(this.d);
        }
        az.a().a(TbadkApplication.getCurrentAccount(), String.valueOf(this.c), new ah(this));
        this.e = new com.baidu.tbadk.editortool.ab(this);
        sendMessage(new RequestOfficialBarInfoMessage(this.c, this.d));
    }

    private void c() {
        this.a = new al(this);
        this.b = new am(this);
        MessageManager.getInstance().registerListener(this.a);
        MessageManager.getInstance().registerListener(this.b);
    }

    private void d() {
        MessageManager.getInstance().unRegisterListener(this.a);
        MessageManager.getInstance().unRegisterListener(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f.a()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.u.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.officical_bar_info_clean_alert).setPositiveButton(com.baidu.tieba.u.alert_yes_button, new ai(this)).setNegativeButton(com.baidu.tieba.u.alert_no_button, new aj(this)).create().show();
        } else if (view == this.f.b()) {
            OfficialBarHistoryActivity.a(this, this.c);
        } else if (view == this.f.c()) {
            com.baidu.tbadk.core.atomData.m mVar = new com.baidu.tbadk.core.atomData.m(this);
            mVar.a(this.d, "official_bar");
            sendMessage(new CustomMessage(2005000, mVar));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        new ak(this, switchState).execute(new Void[0]);
    }
}
