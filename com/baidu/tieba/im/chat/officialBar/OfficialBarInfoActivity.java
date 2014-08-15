package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class OfficialBarInfoActivity extends BaseActivity implements View.OnClickListener, com.baidu.adp.widget.BdSwitchView.c {
    ak a;
    al b;
    private am e;
    private int c = 0;
    private String d = null;
    private boolean f = false;

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
        this.e = new am(this);
        this.e.a((View.OnClickListener) this);
        this.e.a((com.baidu.adp.widget.BdSwitchView.c) this);
        showProgressBar();
    }

    private void b() {
        this.c = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, 0);
        this.d = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        if (this.d != null && com.baidu.tieba.im.d.l.a(this.d) > 16) {
            this.e.b(String.valueOf(com.baidu.tieba.im.d.l.a(this.d, 0, 16)) + "……");
        } else {
            this.e.b(this.d);
        }
        ay.a().b(TbadkApplication.getCurrentAccount(), String.valueOf(this.c), new ag(this));
        sendMessage(new RequestOfficialBarInfoMessage(this.c, this.d));
    }

    private void c() {
        this.a = new ak(this);
        this.b = new al(this);
        registerListener(this.a);
        registerListener(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.e.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.e.a()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.x.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.officical_bar_info_clean_alert).setPositiveButton(com.baidu.tieba.x.alert_yes_button, new ah(this)).setNegativeButton(com.baidu.tieba.x.alert_no_button, new ai(this)).create().show();
        } else if (view == this.e.b()) {
            OfficialBarHistoryActivity.a(this, this.c);
        } else if (view == this.e.c()) {
            com.baidu.tbadk.core.atomData.s sVar = new com.baidu.tbadk.core.atomData.s(this);
            sVar.a(this.d, "official_bar");
            sendMessage(new CustomMessage(2003000, sVar));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        new aj(this, switchState).execute(new Void[0]);
        if (switchState == BdSwitchView.SwitchState.OFF) {
            if (this.f) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016011));
                this.f = false;
            }
        } else if (!this.f) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016011));
            this.f = true;
        }
    }
}
