package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupSettingActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tieba.im.messageCenter.g {
    private com.baidu.tieba.im.model.ao c;
    private com.baidu.tieba.im.a<Boolean> f;
    private az a = null;
    private aw b = null;
    private com.baidu.tieba.im.model.al d = null;
    private av e = null;
    private final DialogInterface.OnClickListener g = new ap(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new az(this);
        this.b = new aw();
        this.c = new com.baidu.tieba.im.model.ao();
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_data_group_name");
            String stringExtra2 = intent.getStringExtra("intent_data_group_id");
            int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
            if (intent.getBooleanExtra("intent_data_is_group_master", false)) {
                this.a.m();
                this.a.r();
                this.a.a(true);
                this.a.p();
            } else {
                this.a.o();
                this.a.q();
                this.a.a(false);
                this.a.n();
            }
            aw awVar = this.b;
            awVar.b(stringExtra2);
            awVar.a(stringExtra);
            awVar.b(intExtra);
        }
        this.a.a(this.b.a());
        this.a.a(this.g);
        this.a.b(((this.b.e() & 2) >> 1) != 1);
        this.a.d();
        this.f = new aq(this);
        com.baidu.tieba.im.i.a(new ay(this.b), this.f);
        this.e = new av(this);
        com.baidu.tieba.im.messageCenter.d.a().a(103103, this.e);
        com.baidu.tieba.im.messageCenter.d.a().a(103102, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103112, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103104, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-141, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    public static void a(Activity activity, int i, String str, String str2, boolean z, int i2) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, GroupSettingActivity.class);
            intent.putExtra("intent_data_group_name", str);
            intent.putExtra("intent_data_group_id", str2);
            intent.putExtra("intent_data_is_group_master", z);
            intent.putExtra("intent_data_group_flag", i2);
            activity.startActivityForResult(intent, 4);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.e())) {
                UpdateGroupActivity.a(this, 1, Integer.parseInt(this.b.c()), 1, this.b.a());
            } else if (view.equals(this.a.f())) {
                this.a.j();
            } else if (view.equals(this.a.h())) {
                this.a.l();
            } else if (view.equals(this.a.a())) {
                finish();
            } else if (view.equals(this.a.i())) {
                new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_clear_cache_group).setPositiveButton(R.string.alert_yes_button, new ar(this)).setNegativeButton(R.string.alert_no_button, new au(this)).create().show();
            } else if (view == this.a.g()) {
                this.a.u();
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
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.a.h())) {
                this.a.l();
            } else if (view.equals(this.a.t())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.a.s())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    a(a(this.b.e(), true));
                } else {
                    a(a(this.b.e(), false));
                }
            }
        }
    }

    private static int a(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private void a(int i) {
        if (this.c != null) {
            this.c.a(this.b.d());
            this.c.b(i);
            this.c.c(5);
            showProgressBar();
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        GroupNewsPojo a;
        if (sVar != null && (sVar instanceof com.baidu.tieba.im.message.da)) {
            com.baidu.tieba.im.message.da daVar = (com.baidu.tieba.im.message.da) sVar;
            if (sVar.w() == 103112) {
                if (daVar.l()) {
                    hideProgressBar();
                    showToast(R.string.neterror);
                    return;
                }
                hideProgressBar();
                showToast(R.string.group_quit_suc);
                com.baidu.tieba.im.util.d.a(this.b.c());
                com.baidu.tieba.im.c.a.d().b(false, null);
                finish();
            } else if (sVar.w() == 103102) {
                if (daVar.l()) {
                    hideProgressBar();
                    showToast(daVar.n());
                    return;
                }
                hideProgressBar();
                showToast(R.string.group_add_group_switch_success);
                this.b.b(this.c.c());
            } else if (sVar.w() == 103104) {
                hideProgressBar();
                if (daVar.l()) {
                    a(daVar.n(), daVar.m());
                    return;
                }
                com.baidu.tieba.ai.a(this, "dismiss_group_success");
                com.baidu.tieba.im.util.d.a(this.b.c());
                showToast(R.string.group_dismiss_success, false);
                finish();
            } else if (sVar.w() != -141 || !(sVar instanceof com.baidu.tieba.im.message.aa) || (a = ((com.baidu.tieba.im.message.aa) sVar).a()) == null || a == null) {
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(a.getContent());
                    String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                    if (!jSONObject.getString("eventId").equals("107") || !string.equals(this.b.c())) {
                        return;
                    }
                    finish();
                    com.baidu.adp.lib.util.e.e("dismiss suc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
        if (dialogInterface != null) {
            if (dialogInterface == this.a.k()) {
                showProgressBar();
                this.b.a(Long.parseLong(this.b.c()));
            }
            if (dialogInterface == this.a.v()) {
                showProgressBar();
                this.b.a(this.b.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this);
        if (this.b != null) {
            this.b.b();
        }
        if (this.d != null) {
            this.d.b();
        }
        com.baidu.tieba.im.messageCenter.d.a().a(this.e);
        if (this.a != null) {
            this.a.w();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
