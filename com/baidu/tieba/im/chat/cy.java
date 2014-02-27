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
public abstract class cy extends com.baidu.tieba.f implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.r, com.baidu.adp.widget.ListView.t, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.voice.af {
    private VoiceManager a;
    private df b;
    protected int i;
    protected Handler c = new Handler();
    protected a d = null;
    protected MsglistModel e = null;
    protected LocalPicModel f = null;
    protected com.baidu.adp.a.g g = null;
    protected cp h = null;
    protected com.baidu.tieba.img.b<com.baidu.tieba.im.message.b> j = null;
    private long l = -1;
    com.baidu.adp.a.g k = new cz(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        this.g = new da(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.lib.util.e.d("----onCreate start-----");
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.l = System.currentTimeMillis();
        }
        this.j = new db(this);
        j();
        k();
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
            int a = com.baidu.tieba.im.f.a(this);
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
                com.baidu.tieba.write.by.a(this);
            } else if (i == 12009) {
                com.baidu.tieba.write.by.b(this);
            }
        }
    }

    @Override // com.baidu.adp.lib.b.b
    public final void a(int i, int i2) {
        com.baidu.tieba.im.message.b a;
        switch (i) {
            case 2:
                if ((this.e.j() == 0 || this.e.j() == 2) && (a = this.e.a(i2)) != null && a.g() != null && a.g().getUserName() != null) {
                    this.d.b(a.g().getUserName());
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
        k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.a != null) {
            VoiceManager voiceManager = this.a;
            VoiceManager.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.a != null) {
            this.a.c(this);
        }
        if (this.e != null) {
            if (this.b == null) {
                this.b = new df(this, (byte) 0);
            }
            this.e.a(this.b);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tieba.voice.af
    public final VoiceManager c_() {
        return this.a;
    }

    @Override // com.baidu.tieba.voice.af
    public final com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        if (this.d == null || this.d.h() == null) {
            return null;
        }
        View findViewWithTag = this.d.h().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tieba.voice.ad)) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    private void j() {
        this.a = new VoiceManager();
        this.a.a((Activity) this);
        boolean ab = TiebaApplication.g().ab();
        com.baidu.adp.lib.util.e.e("isUseHeadSet:" + ab);
        this.a.b(!ab);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final ListView c() {
        if (this.d == null) {
            return null;
        }
        return this.d.h();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<ImageView> e() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<TextView> f() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<GifView> g() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<View> h() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<LinearLayout> i() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(Context context, String str) {
        com.baidu.tieba.im.util.p.b(context, str);
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

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.d != null) {
                n();
            }
            if (this.d != null && this.d.r()) {
                this.d.s();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        return this.e.b(this.d.J());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.b(this);
            boolean ab = TiebaApplication.g().ab();
            com.baidu.adp.lib.util.e.e("isUseHeadSet:" + ab);
            this.a.b(!ab);
        }
    }

    private boolean k() {
        if (com.baidu.tieba.util.af.a()) {
            return true;
        }
        showToast(R.string.voice_error_sdcard);
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            this.a.f();
        }
        if (view == this.d.t()) {
            n();
            finish();
        } else if (view == this.d.v()) {
            if (k()) {
                com.baidu.tieba.write.by.a(this);
            }
        } else if (view == this.d.w()) {
            if (k()) {
                com.baidu.tieba.write.by.b(this);
            }
        } else if (view == this.d.u()) {
            String f = this.d.f();
            if (TextUtils.isEmpty(f)) {
                com.baidu.adp.lib.util.e.b("content == null");
                return;
            }
            this.d.g();
            this.c.postDelayed(new dc(this, f), 100L);
        } else if (view == this.d.D()) {
            this.d.b(this.e.c());
            this.d.n();
        } else {
            com.baidu.adp.lib.util.e.b("default");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.a != null) {
            VoiceManager voiceManager = this.a;
            VoiceManager.i();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.d.y()) {
            if (motionEvent.getAction() == 0) {
                if (this.a == null || !this.a.k()) {
                    return true;
                }
                this.a.a(this.d, -1);
                this.d.m();
                this.d.a(true);
                this.d.i();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < BdUtilHelper.a((Context) this, 5.0f) * (-1)) {
                    if (this.a != null) {
                        VoiceManager voiceManager = this.a;
                        VoiceManager.c();
                    }
                    this.d.m();
                } else {
                    if (this.a != null) {
                        this.a.e();
                    }
                    this.d.j();
                }
                this.d.a(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < BdUtilHelper.a((Context) this, 5.0f) * (-1)) {
                    this.d.l();
                    this.d.j();
                    return true;
                }
                this.d.m();
                this.d.i();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void a(com.baidu.tieba.editortool.x xVar) {
        this.e.a(xVar);
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void a() {
        this.e.h();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public final void b() {
        this.d.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.d(this);
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
            this.d.K();
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.d.z()) {
            int intValue = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a = this.e.a(intValue);
            if (a != null) {
                com.baidu.adp.lib.util.e.e("----------recordId" + a.j() + "msgID" + a.l());
            }
            if (this.e.j() == 1 && i > 0) {
                i++;
            }
            switch (i) {
                case 0:
                    if (a != null && a.o() != null) {
                        try {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                            clipboardManager.setText(a.k());
                            if (clipboardManager.getText() != null) {
                                com.baidu.adp.lib.util.e.a(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.e.b(e.getMessage());
                            return;
                        }
                    }
                    return;
                case 1:
                    if (a != null && a.g() != null && a.g().getUserName() != null) {
                        this.d.b(a.g().getUserName());
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.A()) {
            int intValue2 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a2 = this.e.a(intValue2);
            if (this.e.j() == 1 && i >= 0) {
                i++;
            }
            switch (i) {
                case 0:
                    if (a2 != null && a2.g() != null && a2.g().getUserName() != null) {
                        this.d.b(a2.g().getUserName());
                        return;
                    }
                    return;
                case 1:
                    String a3 = com.baidu.tieba.im.util.l.a(a2.k(), true);
                    if (a3 != null) {
                        this.h = new cp(a3, this);
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
        } else if (dialogInterface == this.d.B()) {
            int intValue3 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a4 = this.e.a(intValue3);
            if (this.e.j() == 1 && i > 0) {
                i++;
            }
            switch (i) {
                case 0:
                    if (TiebaApplication.g().ab()) {
                        TiebaApplication.g().r(false);
                        this.a.b(true);
                        this.d.F();
                    } else {
                        TiebaApplication.g().r(true);
                        this.a.b(false);
                        this.d.G();
                    }
                    if (this.e.a() != null) {
                        String name = this.e.a().getName();
                        if (!TextUtils.isEmpty(name)) {
                            this.d.a(name);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (a4 != null && a4.g() != null && a4.g().getUserName() != null) {
                        this.d.b(a4.g().getUserName());
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue3);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.C()) {
            int intValue4 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.b a5 = this.e.a(intValue4);
            if (a5 != null) {
                com.baidu.adp.lib.util.e.e("----------recordId" + a5.j() + "msgID" + a5.l());
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
    public final void a(View view, int i, int i2) {
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
                builder.setPositiveButton(getString(R.string.msg_resend), new dd(this, i2));
                builder.setNegativeButton(getString(R.string.delete), new de(this, i2));
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
                if (k() && (a4 = this.e.a(i2)) != null && com.baidu.tieba.im.util.l.a(a4) && (a5 = com.baidu.tieba.im.util.l.a(a4.k(), true)) != null) {
                    if ((this.e.j() == 0 || this.e.j() == 2) && this.e.a() != null) {
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
                if (!k() || (a3 = this.e.a(i2)) == null || !com.baidu.tieba.im.util.l.c(a3)) {
                }
                return;
            case 6:
                com.baidu.tieba.person.cm.a(this, TiebaApplication.v(), TiebaApplication.z());
                return;
            case 7:
                if (k() && this.e != null && (a2 = this.e.a(i2)) != null) {
                    if (!a2.s()) {
                        a2.b(true);
                        cr.a((Context) this, (GifView) view, a2, this.d.M(), false);
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
}
