package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.EmotionImageActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class cz extends com.baidu.tieba.f implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.r, com.baidu.adp.widget.ListView.t, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.voice.af {
    private VoiceManager a;
    private dg b;
    protected int i;
    protected Handler c = new Handler();
    protected a d = null;
    protected MsglistModel e = null;
    protected LocalPicModel f = null;
    protected com.baidu.adp.a.g g = null;
    protected cq h = null;
    protected com.baidu.tieba.img.b<com.baidu.tieba.im.message.b> j = null;
    private long l = -1;
    com.baidu.adp.a.g k = new da(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.g = new db(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.lib.util.f.d("----onCreate start-----");
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.l = System.currentTimeMillis();
        }
        this.j = new dc(this);
        j();
        o();
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
            int a = com.baidu.tieba.im.g.a(this);
            String string = getString(R.string.send_msg);
            String string2 = getString(R.string.cancel);
            if (i == 12002) {
                if (intent != null && intent.getData() != null) {
                    WriteImageActivity.a(this, 12002, 12009, intent.getData(), null, null, null, a, string, string2);
                }
            } else if (i == 12001) {
                WriteImageActivity.a(this, 12001, 12010, null, null, null, null, a, string, string2);
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tieba.write.bz.a(this);
            } else if (i == 12009) {
                com.baidu.tieba.write.bz.b(this);
            }
        }
    }

    @Override // com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.b a;
        switch (i) {
            case 2:
                if ((this.e.k() == 0 || this.e.k() == 2) && (a = this.e.a(i2)) != null && a.g() != null && a.g().getUserName() != null) {
                    this.d.a(a.g().getUserName());
                    return;
                }
                return;
            case 3:
                this.d.a(i2);
                return;
            case 4:
                this.d.b(i2);
                return;
            case 5:
                this.d.c(i2);
                return;
            case 6:
            case 7:
            default:
                return;
            case 8:
                this.d.d(i2);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.l = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.l = System.currentTimeMillis();
        }
        j();
        o();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.a != null) {
            this.a.b((Activity) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.a != null) {
            this.a.d(this);
        }
        if (this.e != null) {
            p();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager h() {
        return this.a;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        if (this.d == null || this.d.i() == null) {
            return null;
        }
        View findViewWithTag = this.d.i().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tieba.voice.ad)) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    private void j() {
        this.a = new VoiceManager();
        this.a.a((Activity) this);
        boolean ai = TiebaApplication.g().ai();
        com.baidu.adp.lib.util.f.e("isUseHeadSet:" + ai);
        this.a.c(!ai);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView c() {
        if (this.d == null) {
            return null;
        }
        return this.d.i();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> f() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> g() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> c_() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<LinearLayout> i() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        com.baidu.tieba.im.util.q.b(context, str);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void c(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void d(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void e(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.d != null) {
                n();
            }
            if (this.d != null && this.d.t()) {
                this.d.u();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n() {
        return this.e.b(this.d.M());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.c(this);
            boolean ai = TiebaApplication.g().ai();
            com.baidu.adp.lib.util.f.e("isUseHeadSet:" + ai);
            this.a.c(!ai);
        }
    }

    private void k() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public boolean o() {
        if (com.baidu.tieba.util.af.a()) {
            return true;
        }
        showToast(R.string.voice_error_sdcard);
        return false;
    }

    private void l() {
        String g = this.d.g();
        if (TextUtils.isEmpty(g)) {
            com.baidu.adp.lib.util.f.b("content == null");
            return;
        }
        this.d.h();
        this.c.postDelayed(new dd(this, g), 100L);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        k();
        if (view == this.d.v()) {
            n();
            finish();
        } else if (view == this.d.y()) {
            if (o()) {
                com.baidu.tieba.write.bz.a(this);
            }
        } else if (view == this.d.z()) {
            if (o()) {
                com.baidu.tieba.write.bz.b(this);
            }
        } else if (view == this.d.w()) {
            l();
        } else if (view == this.d.G()) {
            this.d.b(this.e.c());
            this.d.p();
        } else {
            com.baidu.adp.lib.util.f.b("default");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.a != null) {
            this.a.e(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.d.B()) {
            if (motionEvent.getAction() == 0) {
                if (this.a == null || !this.a.i()) {
                    return true;
                }
                this.a.a(this.d, -1);
                this.d.o();
                this.d.a(true);
                this.d.j();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < BdUtilHelper.a((Context) this, 5.0f) * (-1)) {
                    if (this.a != null) {
                        this.a.d();
                    }
                    this.d.o();
                } else {
                    if (this.a != null) {
                        this.a.f();
                    }
                    this.d.k();
                }
                this.d.a(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < BdUtilHelper.a((Context) this, 5.0f) * (-1)) {
                    this.d.n();
                    this.d.k();
                    return true;
                }
                this.d.o();
                this.d.j();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tieba.editortool.w wVar) {
        this.e.a(wVar);
    }

    @Override // com.baidu.adp.widget.ListView.t
    public void b() {
        q();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        this.d.p();
    }

    private void q() {
        this.e.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.g(this);
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.f != null) {
            this.f.cancelLoadData();
            this.f = null;
        }
        if (this.e != null) {
            this.e.e();
        }
        if (this.d != null) {
            this.d.N();
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public void p() {
        if (this.b == null) {
            this.b = new dg(this, null);
        }
        this.e.a(this.b);
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.d.C()) {
            int intValue = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a = this.e.a(intValue);
            if (a != null) {
                com.baidu.adp.lib.util.f.e("----------recordId" + a.j() + "msgID" + a.l());
            }
            if (this.e.k() == 1 && i >= 1) {
                i++;
            }
            switch (i) {
                case 0:
                    if (a != null && a.o() != null) {
                        try {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                            clipboardManager.setText(a.k());
                            if (clipboardManager.getText() != null) {
                                com.baidu.adp.lib.util.f.a(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.b(e.getMessage());
                            return;
                        }
                    }
                    return;
                case 1:
                    if (a != null && a.g() != null && a.g().getUserName() != null) {
                        this.d.a(a.g().getUserName());
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.D()) {
            int intValue2 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a2 = this.e.a(intValue2);
            if (this.e.k() == 1 && i >= 0) {
                i++;
            }
            switch (i) {
                case 0:
                    if (a2 != null && a2.g() != null && a2.g().getUserName() != null) {
                        this.d.a(a2.g().getUserName());
                        return;
                    }
                    return;
                case 1:
                    String a3 = com.baidu.tieba.im.util.l.a(a2.k(), true);
                    if (a3 != null) {
                        this.h = new cq(a3, this);
                        this.h.a();
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue2);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.E()) {
            int intValue3 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a4 = this.e.a(intValue3);
            if (this.e.k() == 1 && i >= 1) {
                i++;
            }
            switch (i) {
                case 0:
                    if (TiebaApplication.g().ai()) {
                        TiebaApplication.g().s(false);
                        this.a.c(true);
                        this.d.I();
                    } else {
                        TiebaApplication.g().s(true);
                        this.a.c(false);
                        this.d.J();
                    }
                    if (this.e.a() != null) {
                        String name = this.e.a().getName();
                        if (!TextUtils.isEmpty(name)) {
                            this.d.a(name, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (a4 != null && a4.g() != null && a4.g().getUserName() != null) {
                        this.d.a(a4.g().getUserName());
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue3);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.F()) {
            int intValue4 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a5 = this.e.a(intValue4);
            if (a5 != null) {
                com.baidu.adp.lib.util.f.e("----------recordId" + a5.j() + "msgID" + a5.l());
            }
            this.e.c(intValue4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    @Override // com.baidu.adp.lib.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.b a;
        String k;
        com.baidu.tieba.im.message.b a2;
        String k2;
        JSONObject jSONObject;
        JSONArray jSONArray;
        com.baidu.tieba.im.message.b a3;
        com.baidu.tieba.im.message.b a4;
        String a5;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.operation));
                builder.setPositiveButton(getString(R.string.msg_resend), new de(this, i2));
                builder.setNegativeButton(getString(R.string.delete), new df(this, i2));
                builder.create().show();
                return;
            case 2:
                com.baidu.tieba.im.message.b a6 = this.e.a(i2);
                if (a6 != null && a6.g() != null) {
                    com.baidu.tieba.person.cm.a(this, a6.g().getUserId(), a6.g().getUserName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (o() && (a4 = this.e.a(i2)) != null && com.baidu.tieba.im.util.l.a(a4) && (a5 = com.baidu.tieba.im.util.l.a(a4.k(), true)) != null) {
                    if ((this.e.k() == 0 || this.e.k() == 2) && this.e.a() != null) {
                        MsgImageActivity.a(this, a5, this.e.a().getGroupId(), false);
                        return;
                    } else if (this.e.b() != null) {
                        MsgImageActivity.a(this, a5, this.e.b().getUserIdLong());
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 5:
                if (!o() || (a3 = this.e.a(i2)) == null || !com.baidu.tieba.im.util.l.c(a3)) {
                }
                return;
            case 6:
                com.baidu.tieba.person.cm.a(this, TiebaApplication.A(), TiebaApplication.F());
                return;
            case 7:
                if (o() && this.e != null && (a2 = this.e.a(i2)) != null) {
                    if (!a2.s()) {
                        a2.b(true);
                        cs.a((Context) this, (GifView) view, a2, this.d.O(), false);
                        return;
                    } else if (com.baidu.tieba.im.util.l.b(a2) && (k2 = a2.k()) != null) {
                        try {
                            jSONArray = new JSONArray(k2);
                        } catch (Exception e) {
                            try {
                                jSONObject = new JSONObject(k2);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject = jSONArray.getJSONObject(0);
                            if (jSONObject == null) {
                                String optString = jSONObject.optString("url_d");
                                String optString2 = jSONObject.optString("url_s");
                                String optString3 = jSONObject.optString("face_name");
                                String optString4 = jSONObject.optString("pid");
                                String optString5 = jSONObject.optString("packet_name");
                                String optString6 = jSONObject.optString("icon");
                                int optInt = jSONObject.optInt("size_width");
                                int optInt2 = jSONObject.optInt("size_height");
                                if (this.i == 0 || this.i == 2) {
                                    EmotionImageActivity.a(this, optString4, optString5, optString6, optString2, optString, optString3, 3, optInt, optInt2);
                                    return;
                                } else {
                                    EmotionImageActivity.a(this, optString4, optString5, optString6, optString2, optString, optString3, 2, optInt, optInt2);
                                    return;
                                }
                            }
                            return;
                        }
                        jSONObject = null;
                        if (jSONObject == null) {
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                break;
            case 8:
                com.baidu.tieba.im.message.b a7 = this.e.a(i2);
                if (a7 != null && com.baidu.tieba.im.util.l.e(a7) && (a = this.e.a(i2)) != null && (k = a.k()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(k).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.f.b.a(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.f.b.a(optJSONObject.optString("groupId"), 0L), 2);
                            return;
                        }
                        return;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.e.a(i, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.e.b(i);
    }
}
