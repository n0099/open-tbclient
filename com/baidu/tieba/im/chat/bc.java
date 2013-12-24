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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class bc extends com.baidu.tieba.j implements SensorEventListener, View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.r, com.baidu.adp.widget.ListView.t, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.im.c.l, com.baidu.tieba.im.messageCenter.g, com.baidu.tieba.voice.af {
    private static final String a = bc.class.getName();
    @Deprecated
    public static boolean b = false;
    public static String c = "";
    public static String d = "";
    private VoiceManager k;
    private Context m;
    private bq o;
    private bu g = null;
    private MsglistModel h = null;
    private LocalPicModel i = null;
    private com.baidu.adp.a.g j = null;
    Handler e = new Handler();
    private br l = null;
    private com.baidu.tieba.im.model.ai n = null;
    private final int p = 0;
    com.baidu.adp.a.g f = new bh(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.m = this;
            com.baidu.adp.lib.h.e.c("----onCreate start-----");
            this.n = new bd(this);
            if (!a(bundle)) {
                finish();
            } else {
                p();
                q();
                i();
                l();
                if (r()) {
                    s();
                    x();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(a, "onCreate", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            this.m = this;
            com.baidu.adp.lib.h.e.c("----onNewIntent start-----");
            setIntent(intent);
            if (!a((Bundle) null)) {
                finish();
            } else {
                p();
                q();
                i();
                l();
                if (r()) {
                    s();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(a, "onNewIntent", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.f(i);
    }

    private void l() {
        this.j = new bi(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.k != null) {
            this.k.e(this);
        }
        bundle.putInt("chat_mode", this.h.k());
        bundle.putBoolean("is_accept_notify", this.h.d());
        if (this.h.k() == 0) {
            bundle.putSerializable("group", this.h.a());
        } else {
            bundle.putSerializable("user", this.h.b());
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.k != null) {
            this.k.b((Activity) this);
        }
        b = true;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        b = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.k != null) {
            this.k.d(this);
        }
        b = false;
        if (this.h != null) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.k != null) {
            this.k.c(this);
            boolean ak = TiebaApplication.h().ak();
            com.baidu.adp.lib.h.e.d("isUseHeadSet:" + ak);
            this.k.c(!ak);
        }
        if (this.g != null) {
            this.g.f(TiebaApplication.h().an());
            m();
        }
        b = true;
        com.baidu.tieba.mention.t.a().a(c);
        if (!TextUtils.isEmpty(c)) {
            com.baidu.tieba.model.i.a(c);
        }
        com.baidu.tieba.mention.t.a().a(d);
        if (!TextUtils.isEmpty(d)) {
            com.baidu.tieba.model.i.a(d);
        }
    }

    private void m() {
        if (TiebaApplication.h().ak()) {
            this.g.F();
        } else {
            this.g.E();
        }
        if (this.h.k() == 0) {
            if (this.h.a() != null) {
                String name = this.h.a().getName();
                if (!TextUtils.isEmpty(name)) {
                    this.g.a(name, true);
                }
            }
            com.baidu.tieba.im.m.a(new bj(this), new bk(this));
            return;
        }
        com.baidu.tieba.im.m.a(new bl(this), new bm(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.k != null) {
            this.k.f(this);
        }
        b = false;
    }

    private boolean a(Bundle bundle) {
        try {
            this.h = new MsglistModel(this);
            this.h.setLoadDataCallBack(this.f);
            if (bundle != null) {
                b(bundle);
            } else {
                n();
            }
            return o();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(a, "initData", e.getMessage());
            return false;
        }
    }

    private void n() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("chat_mode", 0);
        boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
        if (this.h == null) {
            com.baidu.tieba.util.be.a("mListModel is null");
            return;
        }
        this.h.a(booleanExtra);
        this.h.d(intExtra);
        if (intExtra == 0) {
            this.h.a((GroupData) intent.getSerializableExtra("group"));
            this.h.a((UserData) null);
            c = String.valueOf(this.h.a().getGroupId());
            return;
        }
        UserData userData = (UserData) intent.getSerializableExtra("user");
        d = String.valueOf(userData.getUserId());
        a(userData);
        this.h.a(userData);
        this.h.a((GroupData) null);
    }

    private void a(UserData userData) {
        com.baidu.tieba.im.m.a(new bn(this, userData), null);
    }

    private void b(Bundle bundle) {
        int i = bundle.getInt("chat_mode");
        this.h.a(bundle.getBoolean("is_accept_notify", true));
        this.h.d(i);
        if (i == 0) {
            this.h.a((GroupData) bundle.getSerializable("group"));
            c = String.valueOf(this.h.a().getGroupId());
            this.h.a((UserData) null);
            return;
        }
        UserData userData = (UserData) bundle.getSerializable("user");
        d = String.valueOf(userData.getUserId());
        a(userData);
        this.h.a(userData);
        this.h.a((GroupData) null);
    }

    private boolean o() {
        if (this.h.k() == 0) {
            GroupData a2 = this.h.a();
            if (a2 == null) {
                com.baidu.adp.lib.h.e.b(a, "checkParam", "error:group or forum is null");
                return false;
            } else if (a2.getGroupId() == 0) {
                com.baidu.adp.lib.h.e.b(a, "checkParam", "error:gid invalid," + a2.getGroupId());
                return false;
            }
        } else {
            UserData b2 = this.h.b();
            if (b2 == null) {
                com.baidu.adp.lib.h.e.b(a, "checkParam", "error:user or forum is null");
                return false;
            } else if (b2.getUserId() == 0) {
                com.baidu.adp.lib.h.e.b(a, "checkParam", "error:uid invalid," + b2.getUserId());
                return false;
            }
        }
        return true;
    }

    private void p() {
        int i;
        this.g = new bu(this, this.h.d(), this.h.k());
        this.g.a((InputMethodManager) getSystemService("input_method"));
        int i2 = a.a;
        if (this.h.k() == 0 && this.h.a() != null) {
            i = this.h.a().getGroupId();
            this.g.a(this.h.a().getName(), true);
        } else {
            i = a.a;
            this.g.a(this.h.b().getUserName(), false);
        }
        this.g.a(this.h.c(), i);
        this.g.a(new bo(this));
    }

    private void q() {
        this.k = new VoiceManager();
        this.k.a((Activity) this);
        boolean ak = TiebaApplication.h().ak();
        com.baidu.adp.lib.h.e.d("isUseHeadSet:" + ak);
        this.k.c(!ak);
    }

    private boolean r() {
        if (this.h.k() == 1) {
            this.h.g();
        }
        return this.h.f();
    }

    private boolean s() {
        return this.h.i();
    }

    private boolean t() {
        return this.h.b(this.g.I());
    }

    public boolean i() {
        if (com.baidu.tieba.util.y.a()) {
            return true;
        }
        this.g.a(0, getString(R.string.voice_error_sdcard));
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        w();
        if (view == this.g.t()) {
            t();
            finish();
        } else if (view == this.g.v()) {
            if (i()) {
                com.baidu.tieba.write.bd.a(this);
            }
        } else if (view == this.g.w()) {
            if (i()) {
                com.baidu.tieba.write.bd.b(this);
            }
        } else if (view == this.g.u()) {
            u();
        } else if (view == this.g.x()) {
            if (this.h.k() == 0) {
                GroupInfoActivity.a(this, this.h.a().getGroupId(), 3);
            } else if (1 == this.h.k()) {
                com.baidu.tieba.ao.a(this, "personal_chat_page_morebutton");
                PersonalTalkSettingActivity.a(this.h.b().getUserId());
            }
        } else if (view == this.g.C()) {
            this.g.b(this.h.c());
            this.g.n();
        } else {
            com.baidu.adp.lib.h.e.b(a, "onclick", "default");
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.g.z()) {
            int intValue = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a2 = this.h.a(intValue);
            if (a2 != null) {
                com.baidu.adp.lib.h.e.d("----------recordId" + a2.i() + "msgID" + a2.k());
            }
            if (this.h.k() == 1 && i >= 1) {
                i++;
            }
            switch (i) {
                case 0:
                    if (a2 != null && a2.n() != null) {
                        try {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                            clipboardManager.setText(a2.j());
                            if (clipboardManager.getText() != null) {
                                com.baidu.adp.lib.h.e.a(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            com.baidu.adp.lib.h.e.b(a, "onClick", e.getMessage());
                            return;
                        }
                    }
                    return;
                case 1:
                    if (a2 != null && a2.f() != null && a2.f().getName() != null) {
                        this.g.a(a2.f().getName());
                        return;
                    }
                    return;
                case 2:
                    this.h.c(intValue);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.g.A()) {
            int intValue2 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a3 = this.h.a(intValue2);
            if (this.h.k() == 1 && i >= 0) {
                i++;
            }
            switch (i) {
                case 0:
                    if (a3 != null && a3.f() != null && a3.f().getName() != null) {
                        this.g.a(a3.f().getName());
                        return;
                    }
                    return;
                case 1:
                    String a4 = com.baidu.tieba.im.d.d.a(a3.j(), true);
                    if (a4 != null) {
                        this.l = new br(this, a4);
                        this.l.a();
                        return;
                    }
                    return;
                case 2:
                    this.h.c(intValue2);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.g.B()) {
            int intValue3 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a5 = this.h.a(intValue3);
            if (this.h.k() == 1 && i >= 1) {
                i++;
            }
            switch (i) {
                case 0:
                    if (TiebaApplication.h().ak()) {
                        TiebaApplication.h().s(false);
                        this.k.c(true);
                        this.g.E();
                    } else {
                        TiebaApplication.h().s(true);
                        this.k.c(false);
                        this.g.F();
                    }
                    if (this.h.a() != null) {
                        String name = this.h.a().getName();
                        if (!TextUtils.isEmpty(name)) {
                            this.g.a(name, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (a5 != null && a5.f() != null && a5.f().getName() != null) {
                        this.g.a(a5.f().getName());
                        return;
                    }
                    return;
                case 2:
                    this.h.c(intValue3);
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
                if (this.i != null) {
                    this.i.cancelLoadData();
                    this.i = null;
                }
                this.i = new LocalPicModel(str, stringExtra, null, "tieba_resized_image_display");
                this.i.setLoadDataCallBack(this.j);
                this.i.getData();
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
                com.baidu.tieba.write.bd.a(this);
            } else if (i == 12009) {
                com.baidu.tieba.write.bd.b(this);
            }
        }
    }

    private void u() {
        String e = this.g.e();
        if (TextUtils.isEmpty(e)) {
            com.baidu.adp.lib.h.e.a("content == null");
            return;
        }
        this.g.f();
        this.e.postDelayed(new bp(this, e), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.h.a(i, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.h.b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.h.e.d("----ondestroy---");
        super.onDestroy();
        if (this.l != null) {
            this.l.b();
            this.l = null;
        }
        if (this.i != null) {
            this.i.cancelLoadData();
            this.i = null;
        }
        if (this.h != null) {
            this.h.e();
        }
        if (this.k != null) {
            this.k.g(this);
        }
        if (this.g != null) {
            this.g.J();
        }
        if (this.o != null) {
            this.o = null;
        }
        y();
    }

    @Override // com.baidu.adp.lib.b.a
    public void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.b a2;
        com.baidu.tieba.im.message.b a3;
        String a4;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.operation));
                builder.setPositiveButton(getString(R.string.msg_resend), new bf(this, i2));
                builder.setNegativeButton(getString(R.string.delete), new bg(this, i2));
                builder.create().show();
                return;
            case 2:
                com.baidu.tieba.im.message.b a5 = this.h.a(i2);
                if (a5 != null && a5.f() != null) {
                    PersonInfoActivity.a(this, a5.f().getId(), a5.f().getName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (i() && (a3 = this.h.a(i2)) != null && com.baidu.tieba.im.d.d.a(a3) && (a4 = com.baidu.tieba.im.d.d.a(a3.j(), true)) != null) {
                    if (this.h.k() == 0 && this.h.a() != null) {
                        MsgImageActivity.a(this, a4, this.h.a().getGroupId());
                        return;
                    } else if (this.h.b() != null) {
                        MsgImageActivity.b(this, a4, this.h.b().getUserId());
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 5:
                if (!i() || (a2 = this.h.a(i2)) == null || !com.baidu.tieba.im.d.d.b(a2)) {
                }
                return;
            case 6:
                PersonInfoActivity.a(this, TiebaApplication.B(), TiebaApplication.G());
                return;
        }
    }

    @Override // com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.b a2;
        switch (i) {
            case 2:
                if (this.h.k() == 0 && (a2 = this.h.a(i2)) != null && a2.f() != null && a2.f().getName() != null) {
                    this.g.a(a2.f().getName());
                    return;
                }
                return;
            case 3:
                this.g.a(i2);
                return;
            case 4:
                this.g.b(i2);
                return;
            case 5:
                this.g.c(i2);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.widget.ListView.t
    public void b() {
        v();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        this.g.n();
    }

    private void v() {
        this.h.h();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.g.y()) {
            if (motionEvent.getAction() == 0) {
                if (this.k == null || !this.k.i()) {
                    return true;
                }
                this.k.a(this.g, -1);
                this.g.m();
                this.g.a(true);
                this.g.h();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.h.g.a((Context) this, 5.0f) * (-1)) {
                    if (this.k != null) {
                        this.k.d();
                    }
                    this.g.m();
                } else {
                    if (this.k != null) {
                        this.k.f();
                    }
                    this.g.i();
                }
                this.g.a(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.h.g.a((Context) this, 5.0f) * (-1)) {
                    this.g.l();
                    this.g.i();
                    return true;
                }
                this.g.m();
                this.g.h();
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

    private void w() {
        if (this.k != null) {
            this.k.g();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager d_() {
        return this.k;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        if (this.g == null || this.g.g() == null) {
            return null;
        }
        View findViewWithTag = this.g.g().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tieba.voice.ad)) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    private void x() {
        com.baidu.tieba.im.messageCenter.e.a().a(103110, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-109, this);
        com.baidu.tieba.im.c.m.a().a("apply_join_success", this);
        com.baidu.tieba.im.c.m.a().a("kick_out", this);
        com.baidu.tieba.im.c.m.a().a("group_intro_change", this);
        com.baidu.tieba.im.c.m.a().a("group_name_change", this);
        com.baidu.tieba.im.c.m.a().a("group_level_up", this);
        com.baidu.tieba.im.c.m.a().a("group_head_change", this);
        com.baidu.tieba.im.c.m.a().a("dismiss_group", this);
    }

    private void y() {
        com.baidu.tieba.im.c.m.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                this.g.a();
                if (!cmd.equals("apply_join_success")) {
                    if (cmd.equals("kick_out")) {
                        b(groupNewsPojo);
                    } else if (cmd.equals("group_name_change")) {
                        c(groupNewsPojo);
                    } else if (cmd.equals("dismiss_group")) {
                        d(groupNewsPojo);
                    }
                }
            }
        }
    }

    private void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.h != null && this.h.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.h.a().getGroupId()))) {
                    showToast(R.string.group_is_kicked, false);
                    finish();
                    com.baidu.adp.lib.h.e.d("newSystemMessageNotify suc and closeBottom");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        finish();
    }

    private void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.h != null && this.h.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.h.a().getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.g.a(string2, true);
                        this.h.a().setName(string2);
                        com.baidu.adp.lib.h.e.d("newSystemMessageNotify suc and change name");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.h != null && this.h.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.h.a().getGroupId()))) {
                    showToast(R.string.group_is_dismiss, false);
                    finish();
                    com.baidu.adp.lib.h.e.d("dismiss suc");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.g != null) {
                t();
            }
            if (this.g != null && this.g.r()) {
                this.g.s();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void j() {
        if (this.o == null) {
            this.o = new bq(this, null);
        }
        this.h.a(this.o);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView c() {
        return this.g.g();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> f() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> g() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> h() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void b(Context context, String str) {
        com.baidu.tieba.im.d.h.a(context, str);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void c(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void d(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void e(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str, String str2) {
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null) {
            switch (nVar.t()) {
                case -109:
                case 103101:
                case 103110:
                case 103112:
                    this.g.a();
                    return;
                case 103104:
                    if (nVar instanceof com.baidu.tieba.im.message.bb) {
                        com.baidu.tieba.im.message.bb bbVar = (com.baidu.tieba.im.message.bb) nVar;
                        if (!bbVar.i() && this.h.a().getGroupId() == bbVar.a()) {
                            finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
