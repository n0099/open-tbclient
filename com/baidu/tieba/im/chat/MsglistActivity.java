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
public class MsglistActivity extends com.baidu.tieba.j implements SensorEventListener, View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.r, com.baidu.adp.widget.ListView.s, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.im.pushNotify.m, com.baidu.tieba.voice.af {
    private VoiceManager j;
    private Context l;
    private bc m;
    private static final String e = MsglistActivity.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1493a = false;
    public static String b = "";
    private bg f = null;
    private MsglistModel g = null;
    private LocalPicModel h = null;
    private com.baidu.adp.a.g i = null;
    Handler c = new Handler();
    private bd k = null;
    private final int n = 0;
    com.baidu.adp.a.g d = new at(this);

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
        com.baidu.tieba.im.m.a(new as(i), new au(activity, groupData));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.l = this;
            com.baidu.adp.lib.h.d.c("----onCreate start-----");
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
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.b(e, "onCreate", e2.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            this.l = this;
            com.baidu.adp.lib.h.d.c("----onNewIntent start-----");
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
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.b(e, "onNewIntent", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.f(i);
    }

    private void l() {
        this.i = new av(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.j != null) {
            this.j.e(this);
        }
        bundle.putSerializable("group", this.g.a());
        bundle.putBoolean("is_join", this.g.c());
        bundle.putBoolean("is_accept_notify", this.g.d());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.j != null) {
            this.j.b((Activity) this);
        }
        f1493a = true;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        f1493a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.j != null) {
            this.j.d(this);
        }
        f1493a = false;
        if (this.g != null) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.j != null) {
            this.j.c(this);
            boolean am = TiebaApplication.g().am();
            com.baidu.adp.lib.h.d.d("isUseHeadSet:" + am);
            this.j.c(!am);
        }
        if (this.f != null) {
            m();
        }
        f1493a = true;
        com.baidu.tieba.mention.t.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.model.f.b(b);
        }
        this.f.f(TiebaApplication.g().ap());
    }

    private void m() {
        if (TiebaApplication.g().am()) {
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
        com.baidu.tieba.im.m.a(new aw(this), new ax(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.j != null) {
            this.j.f(this);
        }
        f1493a = false;
    }

    private boolean a(Bundle bundle) {
        try {
            this.g = new MsglistModel(this);
            this.g.setLoadDataCallBack(this.d);
            if (bundle != null) {
                b(bundle);
            } else {
                n();
            }
            return o();
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.b(e, "initData", e2.getMessage());
            return false;
        }
    }

    private void n() {
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

    private boolean o() {
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

    private void p() {
        this.f = new bg(this, this.g.c(), this.g.d());
        this.f.a((InputMethodManager) getSystemService("input_method"));
        this.f.a(this.g.b(), this.g.a());
        this.f.a(new ay(this));
    }

    private void q() {
        this.j = new VoiceManager();
        this.j.a((Activity) this);
        boolean am = TiebaApplication.g().am();
        com.baidu.adp.lib.h.d.d("isUseHeadSet:" + am);
        this.j.c(!am);
    }

    private boolean r() {
        return this.g.f();
    }

    private boolean s() {
        return this.g.h();
    }

    private boolean t() {
        return this.g.b(this.f.J());
    }

    public boolean i() {
        if (com.baidu.tieba.util.af.a()) {
            return true;
        }
        this.f.a(0, getString(R.string.voice_error_sdcard));
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        w();
        if (view == this.f.s()) {
            if (this.f != null) {
                t();
            }
            finish();
        } else if (view == this.f.u()) {
            if (i()) {
                com.baidu.tieba.write.bc.a(this);
            }
        } else if (view == this.f.v()) {
            if (i()) {
                com.baidu.tieba.write.bc.b(this);
            }
        } else if (view == this.f.t()) {
            u();
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
                        this.k = new bd(this, a2);
                        this.k.a();
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
                    if (TiebaApplication.g().am()) {
                        TiebaApplication.g().s(false);
                        this.j.c(true);
                        this.f.F();
                    } else {
                        TiebaApplication.g().s(true);
                        this.j.c(false);
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
                if (this.h != null) {
                    this.h.cancelLoadData();
                    this.h = null;
                }
                this.h = new LocalPicModel(str, stringExtra, null, "tieba_resized_image_display");
                this.h.setLoadDataCallBack(this.i);
                this.h.getData();
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
                com.baidu.tieba.write.bc.a(this);
            } else if (i == 12009) {
                com.baidu.tieba.write.bc.b(this);
            }
        }
    }

    private void u() {
        String a2 = this.f.a();
        if (TextUtils.isEmpty(a2)) {
            com.baidu.adp.lib.h.d.a("content == null");
            return;
        }
        this.f.e();
        this.c.postDelayed(new az(this, a2), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.g.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.g.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.h.d.d("----ondestroy---");
        super.onDestroy();
        if (this.k != null) {
            this.k.b();
            this.k = null;
        }
        if (this.h != null) {
            this.h.cancelLoadData();
            this.h = null;
        }
        if (this.g != null) {
            this.g.e();
        }
        if (this.j != null) {
            this.j.g(this);
        }
        if (this.f != null) {
            this.f.K();
        }
        if (this.m != null) {
            this.m = null;
        }
        y();
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
                builder.setPositiveButton(getString(R.string.msg_resend), new ba(this, i2));
                builder.setNegativeButton(getString(R.string.delete), new bb(this, i2));
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
                if (i() && (b3 = this.g.b(i2)) != null && com.baidu.tieba.im.d.c.a(b3) && (a2 = com.baidu.tieba.im.d.c.a(b3.getContent(), true)) != null && this.g != null && this.g.a() != null) {
                    MsgImageActivity.a(this, a2, this.g.a().getGroupId());
                    return;
                }
                return;
            case 5:
                if (!i() || (b2 = this.g.b(i2)) == null || !com.baidu.tieba.im.d.c.b(b2)) {
                }
                return;
            case 6:
                PersonInfoActivity.a(this, TiebaApplication.A(), TiebaApplication.F());
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
    public void b() {
        v();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        this.f.m();
    }

    private void v() {
        this.g.g();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.f.x()) {
            if (motionEvent.getAction() == 0) {
                if (this.j == null || !this.j.i()) {
                    return true;
                }
                this.j.a(this.f, -1);
                this.f.l();
                this.f.a(true);
                this.f.g();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < UtilHelper.a((Context) this, 5.0f) * (-1)) {
                    if (this.j != null) {
                        this.j.d();
                    }
                    this.f.l();
                } else {
                    if (this.j != null) {
                        this.j.f();
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

    private void w() {
        if (this.j != null) {
            this.j.g();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager g() {
        return this.j;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        if (this.f == null || this.f.f() == null) {
            return null;
        }
        View findViewWithTag = this.f.f().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tieba.voice.ad)) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    private void x() {
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this);
    }

    private void y() {
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
                t();
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

    public void j() {
        if (this.m == null) {
            this.m = new bc(this, null);
        }
        this.g.a(this.m);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView c() {
        return null;
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
    public com.baidu.adp.lib.d.b<View> e_() {
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
        com.baidu.tieba.im.d.g.a(context, str);
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
}
