package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsglistActivity extends com.baidu.tieba.j implements SensorEventListener, View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.r, com.baidu.adp.widget.ListView.s, com.baidu.tieba.im.pushNotify.m, com.baidu.tieba.voice.ag {
    private VoiceManager l;
    private Context n;
    private bd o;
    private static final String e = MsglistActivity.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1401a = false;
    public static String b = "";
    private bh f = null;
    private MsglistModel g = null;
    private LocalPicModel j = null;
    private com.baidu.adp.a.g k = null;
    Handler c = new Handler();
    private be m = null;
    private final int p = 0;
    com.baidu.adp.a.g d = new au(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, GroupData groupData, boolean z, boolean z2) {
        Intent intent = new Intent(activity, MsglistActivity.class);
        if (groupData.getGroupId() == 0) {
            com.baidu.adp.lib.h.d.d("grounid" + groupData.getGroupId());
            return;
        }
        com.baidu.adp.lib.h.d.d(" isJoin" + z);
        intent.putExtra("group", groupData);
        intent.putExtra("is_join", z);
        intent.putExtra("is_accept_notify", z2);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, int i, String str, int i2) {
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        groupData.setName(str);
        groupData.setAuthorId(i2);
        com.baidu.tieba.im.m.a(new at(i), new av(activity, groupData));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.n = this;
            com.baidu.adp.lib.h.d.c("----onCreate start-----");
            if (!a(bundle)) {
                finish();
            } else {
                q();
                r();
                c();
                f();
                if (s()) {
                    t();
                    y();
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.b(e, "onCreate", e2.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            this.n = this;
            com.baidu.adp.lib.h.d.c("----onNewIntent start-----");
            setIntent(intent);
            if (!a((Bundle) null)) {
                finish();
            } else {
                q();
                r();
                c();
                f();
                if (s()) {
                    t();
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.b(e, "onNewIntent", e2.getMessage());
        }
    }

    private void f() {
        this.k = new aw(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.l != null) {
            this.l.e(this);
        }
        bundle.putSerializable("group", this.g.a());
        bundle.putBoolean("is_join", this.g.c());
        bundle.putBoolean("is_accept_notify", this.g.d());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.l != null) {
            this.l.b((Activity) this);
        }
        f1401a = true;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        f1401a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.l != null) {
            this.l.d(this);
        }
        f1401a = false;
        if (this.g != null) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.l != null) {
            this.l.c(this);
            boolean ap = TiebaApplication.g().ap();
            com.baidu.adp.lib.h.d.d("isUseHeadSet:" + ap);
            this.l.c(!ap);
        }
        if (this.f != null) {
            n();
        }
        f1401a = true;
        com.baidu.tieba.mention.t.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.model.f.b(b);
        }
    }

    private void n() {
        if (TiebaApplication.g().ap()) {
            this.f.G();
        } else {
            this.f.F();
        }
        if (this.g != null && this.g.a() != null) {
            String name = this.g.a().getName();
            if (!TextUtils.isEmpty(name)) {
                this.f.a(name, true);
            }
        }
        com.baidu.tieba.im.m.a(new ax(this), new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.l != null) {
            this.l.f(this);
        }
        f1401a = false;
    }

    private boolean a(Bundle bundle) {
        try {
            this.g = new MsglistModel(this);
            this.g.setLoadDataCallBack(this.d);
            if (bundle != null) {
                b(bundle);
            } else {
                o();
            }
            return p();
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.b(e, "initData", e2.getMessage());
            return false;
        }
    }

    private void o() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("is_join", true);
        boolean booleanExtra2 = intent.getBooleanExtra("is_accept_notify", true);
        this.g.a((GroupData) intent.getSerializableExtra("group"));
        b = String.valueOf(this.g.a().getGroupId());
        this.g.a(booleanExtra);
        this.g.b(booleanExtra2);
    }

    private void b(Bundle bundle) {
        boolean z = bundle.getBoolean("is_join", true);
        boolean z2 = bundle.getBoolean("is_accept_notify", true);
        this.g.a((GroupData) bundle.getSerializable("group"));
        b = String.valueOf(this.g.a().getGroupId());
        this.g.a(z);
        this.g.b(z2);
    }

    private boolean p() {
        GroupData a2 = this.g.a();
        if (a2 == null) {
            com.baidu.adp.lib.h.d.b(e, "checkParam", "error:group or forum is null");
            return false;
        } else if (a2.getGroupId() == 0) {
            com.baidu.adp.lib.h.d.b(e, "checkParam", "error:gid invalid," + a2.getGroupId());
            return false;
        } else {
            return true;
        }
    }

    private void q() {
        this.f = new bh(this, this.g.c(), this.g.d());
        this.f.a((InputMethodManager) getSystemService("input_method"));
        this.f.a(this.g.b(), this.g.a());
        this.f.a(new az(this));
    }

    private void r() {
        this.l = new VoiceManager();
        this.l.a((Activity) this);
        boolean ap = TiebaApplication.g().ap();
        com.baidu.adp.lib.h.d.d("isUseHeadSet:" + ap);
        this.l.c(!ap);
    }

    private boolean s() {
        return this.g.f();
    }

    private boolean t() {
        return this.g.h();
    }

    private boolean u() {
        return this.g.b(this.f.J());
    }

    public boolean c() {
        if (com.baidu.tieba.util.w.a()) {
            return true;
        }
        this.f.a(0, getString(R.string.voice_error_sdcard));
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        x();
        if (view == this.f.s()) {
            if (this.f != null) {
                u();
            }
            finish();
        } else if (view == this.f.u()) {
            if (c()) {
                com.baidu.tieba.write.bg.a(this);
            }
        } else if (view == this.f.v()) {
            if (c()) {
                com.baidu.tieba.write.bg.b(this);
            }
        } else if (view == this.f.t()) {
            v();
        } else if (view == this.f.w()) {
            GroupInfoActivity.a(this, this.g.a().getGroupId(), 3);
        } else if (view == this.f.B()) {
            this.f.b(this.g.b());
            this.f.m();
        } else {
            com.baidu.adp.lib.h.d.b(e, "onclick", "default");
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.f.y()) {
            ChatMessage b2 = this.g.b(((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue());
            switch (i) {
                case 0:
                    if (b2 != null && b2.getCacheData() != null) {
                        try {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                            clipboardManager.setText(b2.getContent());
                            if (clipboardManager.getText() != null) {
                                com.baidu.adp.lib.h.d.a(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                                return;
                            }
                            return;
                        } catch (Exception e2) {
                            com.baidu.adp.lib.h.d.b(e, "onClick", e2.getMessage());
                            return;
                        }
                    }
                    return;
                case 1:
                    if (b2 != null && b2.getUserInfo() != null && b2.getUserInfo().getName() != null) {
                        this.f.a(b2.getUserInfo().getName());
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.f.z()) {
            ChatMessage b3 = this.g.b(((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue());
            switch (i) {
                case 0:
                    if (b3 != null && b3.getUserInfo() != null && b3.getUserInfo().getName() != null) {
                        this.f.a(b3.getUserInfo().getName());
                        return;
                    }
                    return;
                case 1:
                    String a2 = com.baidu.tieba.im.d.c.a(b3.getContent(), true);
                    if (a2 != null) {
                        this.m = new be(this, a2);
                        this.m.a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.f.A()) {
            ChatMessage b4 = this.g.b(((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue());
            switch (i) {
                case 0:
                    if (TiebaApplication.g().ap()) {
                        TiebaApplication.g().t(false);
                        this.l.c(true);
                        this.f.F();
                    } else {
                        TiebaApplication.g().t(true);
                        this.l.c(false);
                        this.f.G();
                    }
                    if (this.g != null && this.g.a() != null) {
                        String name = this.g.a().getName();
                        if (!TextUtils.isEmpty(name)) {
                            this.f.a(name, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (b4 != null && b4.getUserInfo() != null && b4.getUserInfo().getName() != null) {
                        this.f.a(b4.getUserInfo().getName());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12010 || i == 12009) {
                String stringExtra = intent.getStringExtra("file_name");
                String str = "photos";
                if (stringExtra == null) {
                    stringExtra = "tieba_resized_image";
                    str = null;
                }
                if (this.j != null) {
                    this.j.cancelLoadData();
                    this.j = null;
                }
                this.j = new LocalPicModel(str, stringExtra, null, "tieba_resized_image_display");
                this.j.setLoadDataCallBack(this.k);
                this.j.getData();
                return;
            }
            int a2 = com.baidu.tieba.im.j.a(this);
            String string = getString(R.string.send_msg);
            String string2 = getString(R.string.cancel);
            if (i == 12002) {
                if (intent != null && intent.getData() != null) {
                    WriteImageActivity.a(this, 12002, 12009, intent.getData(), null, null, null, a2, string, string2);
                }
            } else if (i == 12001) {
                WriteImageActivity.a(this, 12001, 12010, null, null, null, null, a2, string, string2);
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tieba.write.bg.a(this);
            } else if (i == 12009) {
                com.baidu.tieba.write.bg.b(this);
            }
        }
    }

    private void v() {
        String a2 = this.f.a();
        if (TextUtils.isEmpty(a2)) {
            com.baidu.adp.lib.h.d.a("content == null");
            return;
        }
        this.f.e();
        this.c.postDelayed(new ba(this, a2), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.g.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.h.d.d("----ondestroy---");
        super.onDestroy();
        if (this.m != null) {
            this.m.b();
            this.m = null;
        }
        if (this.j != null) {
            this.j.cancelLoadData();
            this.j = null;
        }
        if (this.g != null) {
            this.g.e();
        }
        if (this.l != null) {
            this.l.g(this);
        }
        if (this.f != null) {
            this.f.K();
        }
        if (this.o != null) {
            this.o = null;
        }
        z();
    }

    @Override // com.baidu.adp.lib.b.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage b2;
        ChatMessage b3;
        String a2;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.operation));
                builder.setPositiveButton(getString(R.string.msg_resend), new bb(this, i2));
                builder.setNegativeButton(getString(R.string.delete), new bc(this, i2));
                builder.create().show();
                return;
            case 2:
                ChatMessage b4 = this.g.b(i2);
                if (b4 != null && b4.getUserInfo() != null) {
                    PersonInfoActivity.a(this, b4.getUserInfo().getId(), b4.getUserInfo().getName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (c() && (b3 = this.g.b(i2)) != null && com.baidu.tieba.im.d.c.a(b3) && (a2 = com.baidu.tieba.im.d.c.a(b3.getContent(), true)) != null && this.g != null && this.g.a() != null) {
                    MsgImageActivity.a(this, a2, this.g.a().getGroupId());
                    return;
                }
                return;
            case 5:
                if (!c() || (b2 = this.g.b(i2)) == null || !com.baidu.tieba.im.d.c.b(b2)) {
                }
                return;
            case 6:
                PersonInfoActivity.a(this, TiebaApplication.C(), TiebaApplication.H());
                return;
        }
    }

    @Override // com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        switch (i) {
            case 2:
                ChatMessage b2 = this.g.b(i2);
                if (b2 != null && b2.getUserInfo() != null && b2.getUserInfo().getName() != null) {
                    this.f.a(b2.getUserInfo().getName());
                    return;
                }
                return;
            case 3:
                this.f.a(i2);
                return;
            case 4:
                this.f.b(i2);
                return;
            case 5:
                this.f.c(i2);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void b_() {
        w();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        this.f.m();
    }

    private void w() {
        this.g.g();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.f.x()) {
            if (motionEvent.getAction() == 0) {
                if (this.l == null || !this.l.i()) {
                    return true;
                }
                this.l.a(this.f, -1);
                this.f.l();
                this.f.a(true);
                this.f.g();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < UtilHelper.a((Context) this, 5.0f) * (-1)) {
                    if (this.l != null) {
                        this.l.d();
                    }
                    this.f.l();
                } else {
                    if (this.l != null) {
                        this.l.f();
                    }
                    this.f.h();
                }
                this.f.a(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < UtilHelper.a((Context) this, 5.0f) * (-1)) {
                    this.f.k();
                    this.f.h();
                    return true;
                }
                this.f.l();
                this.f.g();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
    }

    private void x() {
        if (this.l != null) {
            this.l.g();
        }
    }

    @Override // com.baidu.tieba.voice.ag
    public VoiceManager g_() {
        return this.l;
    }

    @Override // com.baidu.tieba.voice.ag
    public com.baidu.tieba.voice.ae a(VoiceManager.VoiceModel voiceModel) {
        if (this.f == null || this.f.f() == null) {
            return null;
        }
        View findViewWithTag = this.f.f().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tieba.voice.ae)) {
            return null;
        }
        return (com.baidu.tieba.voice.ae) findViewWithTag;
    }

    private void y() {
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this);
    }

    private void z() {
        com.baidu.tieba.im.pushNotify.n.a().a(this);
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_success")) {
                    b(groupNewsPojo);
                } else if (cmd.equals("kick_out")) {
                    c(groupNewsPojo);
                } else if (cmd.equals("group_name_change")) {
                    d(groupNewsPojo);
                }
            }
        }
    }

    private void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("002") && string.equals(String.valueOf(this.g.a().getGroupId()))) {
                    this.f.E();
                    com.baidu.adp.lib.h.d.d("newSystemMessageNotify suc and showBottom");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.g.a().getGroupId()))) {
                    this.f.D();
                    com.baidu.adp.lib.h.d.d("newSystemMessageNotify suc and closeBottom");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.g.a().getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.f.a(string2, true);
                        this.g.a().setName(string2);
                        com.baidu.adp.lib.h.d.d("newSystemMessageNotify suc and change name");
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.f != null) {
                u();
            }
            if (this.f != null && this.f.q()) {
                this.f.r();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void d() {
        if (this.o == null) {
            this.o = new bd(this, null);
        }
        this.g.a(this.o);
    }
}
