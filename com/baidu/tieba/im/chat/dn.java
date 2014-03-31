package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class dn extends com.baidu.tbadk.a implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.t, com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.voice.z, com.baidu.tbadk.widget.richText.j {
    private du a;
    protected VoiceManager h;
    protected Handler c = new Handler();
    protected h d = null;
    protected MsglistModel e = null;
    protected LocalPicModel f = null;
    protected com.baidu.adp.a.h g = null;
    protected de i = null;
    protected com.baidu.tbadk.img.b<com.baidu.tieba.im.message.a.a> j = null;
    private long b = -1;
    protected com.baidu.adp.a.h k = new Cdo(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        this.g = new dp(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.lib.util.f.d("----onCreate start-----");
        Intent intent = getIntent();
        if (intent != null) {
            this.b = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.b = System.currentTimeMillis();
        }
        this.j = new dq(this);
        c();
        s();
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
                if (this.f != null) {
                    this.f.cancelLoadData();
                    this.f = null;
                }
                this.f = new LocalPicModel(str, stringExtra, null, "tieba_resized_image_display");
                this.f.setLoadDataCallBack(this.g);
                this.f.getData();
                return;
            }
            int a = com.baidu.tbadk.coreExtra.d.x.a(this);
            String string = getString(com.baidu.tieba.im.j.send_msg);
            String string2 = getString(com.baidu.tieba.im.j.cancel);
            if (i == 12002) {
                if (intent != null && intent.getData() != null) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.aw(this, 12002, 12009, intent.getData(), null, null, a, string, string2, "")));
                }
            } else if (i == 12001) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.aw(this, 12001, 12010, null, null, null, a, string, string2, "")));
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.az.a(this);
            } else if (i == 12009) {
                com.baidu.tbadk.core.util.az.b(this);
            }
        }
    }

    public void b(View view, int i, int i2, long j) {
        switch (i) {
            case 2:
            case 6:
            case 7:
            default:
                return;
            case 3:
                this.d.a(i2);
                return;
            case 4:
                this.d.d(i2);
                return;
            case 5:
                this.d.e(i2);
                return;
            case 8:
                this.d.f(i2);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.b = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.b = System.currentTimeMillis();
        }
        c();
        s();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.h != null) {
            VoiceManager voiceManager = this.h;
            VoiceManager.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.c(this);
        }
        if (this.e != null) {
            if (this.a == null) {
                this.a = new du(this, (byte) 0);
            }
            this.e.a(this.a);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final VoiceManager d() {
        return this.h;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        if (this.d == null || this.d.j() == null) {
            return null;
        }
        View findViewWithTag = this.d.j().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tbadk.core.voice.x)) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.x) findViewWithTag;
    }

    private void c() {
        this.h = new VoiceManager();
        this.h.a((Activity) this);
        boolean V = TbadkApplication.j().V();
        com.baidu.adp.lib.util.f.e("isUseHeadSet:" + V);
        this.h.b(!V);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final ListView a() {
        if (this.d == null) {
            return null;
        }
        return this.d.j();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final int e() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<ImageView> f() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<TextView> g() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<GifView> h() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<View> i() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<LinearLayout> j() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(Context context, String str) {
        com.baidu.tbadk.core.util.bg.a().a(context, new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void b(String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void c(String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(String str, String str2) {
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.d != null) {
                r();
            }
            if (this.d != null && this.d.u()) {
                this.d.v();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean r() {
        return this.e.c(this.d.L());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.h != null) {
            this.h.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h != null) {
            this.h.b(this);
            boolean V = TbadkApplication.j().V();
            com.baidu.adp.lib.util.f.e("isUseHeadSet:" + V);
            this.h.b(!V);
        }
    }

    public final boolean s() {
        if (com.baidu.tbadk.core.util.w.a()) {
            return true;
        }
        showToast(com.baidu.tieba.im.j.voice_error_sdcard);
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h != null) {
            this.h.f();
        }
        if (view == this.d.w()) {
            r();
            finish();
        } else if (view == this.d.y()) {
            if (s()) {
                com.baidu.tbadk.core.util.az.a(this);
            }
        } else if (view == this.d.z()) {
            if (s()) {
                com.baidu.tbadk.core.util.az.b(this);
            }
        } else if (view == this.d.x()) {
            String h = this.d.h();
            if (TextUtils.isEmpty(h)) {
                com.baidu.adp.lib.util.f.b("content == null");
                return;
            }
            this.d.i();
            this.c.postDelayed(new dr(this, h), 100L);
        } else if (view == this.d.G()) {
            this.d.b(this.e.g());
            this.d.q();
        } else {
            com.baidu.adp.lib.util.f.b("default");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.h != null) {
            VoiceManager voiceManager = this.h;
            VoiceManager.i();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.d.B()) {
            if (motionEvent.getAction() == 0) {
                if (this.h == null || !this.h.k()) {
                    return true;
                }
                this.h.a(this.d, -1);
                this.d.p();
                this.d.b(true);
                this.d.l();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.i.a((Context) this, 5.0f) * (-1)) {
                    if (this.h != null) {
                        VoiceManager voiceManager = this.h;
                        VoiceManager.c();
                    }
                    this.d.p();
                } else {
                    if (this.h != null) {
                        this.h.e();
                    }
                    this.d.m();
                }
                this.d.b(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.i.a((Context) this, 5.0f) * (-1)) {
                    this.d.o();
                    this.d.m();
                    return true;
                }
                this.d.p();
                this.d.l();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        this.e.a(dVar);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public final void c_() {
        this.e.d();
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        this.d.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.d(this);
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.f != null) {
            this.f.cancelLoadData();
            this.f = null;
        }
        if (this.e != null) {
            this.e.a();
        }
        if (this.d != null) {
            this.d.M();
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.d.F()) {
            int intValue = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.a.a a = this.e.a(intValue);
            if (a != null) {
                com.baidu.adp.lib.util.f.e("----------recordId" + a.u() + "msgID" + a.w());
            }
            this.e.c(intValue);
        }
    }

    public void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.a.a a;
        String v;
        com.baidu.tieba.im.message.a.a a2;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(com.baidu.tieba.im.j.operation));
                builder.setPositiveButton(getString(com.baidu.tieba.im.j.msg_resend), new ds(this, i2));
                builder.setNegativeButton(getString(com.baidu.tieba.im.j.delete), new dt(this, i2));
                builder.create().show();
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 5:
                if (!s() || (a2 = this.e.a(i2)) == null || !com.baidu.tieba.im.f.q.c(a2)) {
                }
                return;
            case 6:
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this, TbadkApplication.E(), TbadkApplication.O())));
                return;
            case 8:
                com.baidu.tieba.im.message.a.a a3 = this.e.a(i2);
                if (a3 != null && com.baidu.tieba.im.f.q.e(a3) && (a = this.e.a(i2)) != null && (v = a.v()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(v).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.f.b.a(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.f.b.a(optJSONObject.optString("groupId"), 0L), 2);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
        }
    }
}
