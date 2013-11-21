package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupSettingActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tieba.im.messageCenter.h {
    private com.baidu.tieba.im.model.x c;
    private com.baidu.tieba.im.a<Boolean> f;

    /* renamed from: a  reason: collision with root package name */
    private v f1481a = null;
    private s b = null;
    private com.baidu.tieba.im.model.v d = null;
    private r e = null;
    private final DialogInterface.OnClickListener g = new q(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1481a = new v(this);
        this.b = new s();
        this.c = new com.baidu.tieba.im.model.x();
        a();
        this.f1481a.a(this.b.a());
        this.f1481a.a(this.g);
        this.f1481a.b(a(this.b.e()));
        this.f1481a.e();
        this.f = new n(this);
        this.b.a(this.f);
        b();
    }

    private void b() {
        this.e = new r(this);
        com.baidu.tieba.im.messageCenter.f.a().a(103103, this.e);
        com.baidu.tieba.im.messageCenter.f.a().a(103102, this);
        com.baidu.tieba.im.messageCenter.f.a().a(103112, this);
    }

    public void a() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_data_group_name");
            String stringExtra2 = intent.getStringExtra("intent_data_group_id");
            int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
            if (intent.getBooleanExtra("intent_data_is_group_master", false)) {
                this.f1481a.n();
                this.f1481a.q();
                this.f1481a.a(true);
            } else {
                this.f1481a.o();
                this.f1481a.p();
                this.f1481a.a(false);
            }
            this.b.a(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1481a.a(i);
    }

    public static void a(Activity activity, int i, String str, String str2, boolean z, int i2) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, GroupSettingActivity.class);
            intent.putExtra("intent_data_group_name", str);
            intent.putExtra("intent_data_group_id", str2);
            intent.putExtra("intent_data_is_group_master", z);
            intent.putExtra("intent_data_group_flag", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i) {
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.f1481a.f())) {
                UpdateGroupActivity.a(this, 1, Integer.parseInt(this.b.c()), 1, this.b.a());
            } else if (view.equals(this.f1481a.g())) {
                this.f1481a.i();
            } else if (view.equals(this.f1481a.h())) {
                this.f1481a.k();
            } else if (view.equals(this.f1481a.a())) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("intent_data_group_flag", this.b.e());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.f1481a.h())) {
                this.f1481a.k();
            } else if (view.equals(this.f1481a.s())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.f1481a.r())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    b(a(this.b.e(), true));
                } else {
                    b(a(this.b.e(), false));
                }
            }
        }
    }

    private int a(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean a(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void b(int i) {
        if (this.c != null) {
            this.c.a(this.b.d());
            this.c.a(i);
            this.c.b(5);
            this.f1481a.m();
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message instanceof ResponsedMessage) {
            ResponsedMessage responsedMessage = (ResponsedMessage) message;
            if (message.getCmd() == 103112) {
                if (responsedMessage.hasError()) {
                    this.f1481a.l();
                    showToast(R.string.neterror);
                    return;
                }
                this.f1481a.l();
                showToast(R.string.group_quit_suc);
                com.baidu.tieba.im.m.a(new o(this), new p(this));
            } else if (message.getCmd() == 103102) {
                if (responsedMessage.hasError()) {
                    this.f1481a.l();
                    showToast(responsedMessage.getErrMsg());
                    return;
                }
                this.f1481a.l();
                showToast(R.string.group_add_group_switch_success);
                this.b.a(this.c.f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.group_report_fail);
        } else {
            showToast(str);
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null && dialogInterface == this.f1481a.j()) {
            this.f1481a.m();
            this.b.a(Long.parseLong(this.b.c()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.f.a().a(this);
        if (this.b != null) {
            this.b.b();
        }
        if (this.d != null) {
            this.d.b();
        }
        com.baidu.tieba.im.messageCenter.f.a().a(this.e);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
