package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class OfficialBarInfoActivity extends com.baidu.tbadk.a implements View.OnClickListener, com.baidu.adp.widget.BdSwitchView.c {
    an a;
    ao b;
    private int c = 0;
    private String d = null;
    private com.baidu.tbadk.editortool.aa e;
    private ap f;

    public static void a(Context context, int i, String str) {
        Intent intent = new Intent(context, OfficialBarInfoActivity.class);
        intent.putExtra("forum_id", i);
        intent.putExtra("forum_name", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new an(this);
        this.b = new ao(this);
        com.baidu.adp.framework.c.a().a(this.a);
        com.baidu.adp.framework.c.a().a(this.b);
        this.f = new ap(this);
        this.f.a((View.OnClickListener) this);
        this.f.a((com.baidu.adp.widget.BdSwitchView.c) this);
        showProgressBar();
        this.c = getIntent().getIntExtra("forum_id", 0);
        this.d = getIntent().getStringExtra("forum_name");
        if (this.d == null || com.baidu.tieba.im.f.r.a(this.d) <= 16) {
            this.f.b(this.d);
        } else {
            this.f.b(String.valueOf(com.baidu.tieba.im.f.r.a(this.d, 0, 16)) + "……");
        }
        bb.a().a(TbadkApplication.E(), String.valueOf(this.c), new aj(this));
        this.e = new com.baidu.tbadk.editortool.aa(this);
        sendMessage(new be(this.c, this.d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().b(this.a);
        com.baidu.adp.framework.c.a().b(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f.a()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.im.j.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.im.j.officical_bar_info_clean_alert).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, new ak(this)).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new al(this)).create().show();
        } else if (view == this.f.d()) {
            OfficialBarHistoryActivity.a(this, this.c);
        } else if (view == this.f.e()) {
            com.baidu.tbadk.core.b.l lVar = new com.baidu.tbadk.core.b.l(this);
            lVar.a(this.d, "official_bar");
            sendMessage(new com.baidu.adp.framework.message.a(2003000, lVar));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        new am(this, switchState).execute(new Void[0]);
    }
}
