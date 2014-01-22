package com.baidu.tieba.editortool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EditorToolComponetContainer extends RelativeLayout {
    protected Context a;
    protected ToolMoreView b;
    protected EmotionTabHost c;
    protected RecordVoiceBnt d;
    protected ImageUploadView e;
    protected View f;
    protected ImageView g;
    protected boolean h;
    private AlertDialog.Builder i;
    private boolean j;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.h = false;
        this.i = null;
        this.j = true;
        this.a = context;
        a();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = null;
        this.j = true;
        this.a = context;
        a();
    }

    protected void a() {
        LayoutInflater.from(this.a).inflate(R.layout.editor_tool_container, (ViewGroup) this, true);
        this.b = (ToolMoreView) findViewById(R.id.tool_view);
        this.c = (EmotionTabHost) findViewById(R.id.face_view);
        this.d = (RecordVoiceBnt) findViewById(R.id.record_voice_view);
        this.e = (ImageUploadView) findViewById(R.id.image_upload_view);
        this.i = new AlertDialog.Builder(this.a);
        this.i.setTitle(R.string.editor_dialog_title);
        this.i.setNegativeButton(R.string.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.g = (ImageView) findViewById(R.id.pb_foot_down_shadow);
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    protected void b() {
        this.g.setVisibility(0);
        this.c.setVisibility(0);
    }

    protected void c() {
        this.c.setVisibility(8);
    }

    protected void d() {
        this.g.setVisibility(0);
        this.d.setVisibility(0);
    }

    protected void e() {
        this.d.setVisibility(8);
    }

    protected void f() {
        this.g.setVisibility(0);
        this.e.setVisibility(0);
    }

    protected void g() {
        this.e.setVisibility(8);
    }

    protected void h() {
        this.g.setVisibility(0);
        this.b.setVisibility(0);
    }

    protected void i() {
        this.b.setVisibility(8);
    }

    public void a(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.b(this.a, view);
            this.h = true;
        }
    }

    public void b(View view) {
        if (view != null) {
            com.baidu.adp.lib.g.g.a(this.a, view);
            this.h = false;
        }
    }

    public boolean j() {
        return this.b.getVisibility() == 0 || this.d.getVisibility() == 0 || this.c.getVisibility() == 0 || this.e.getVisibility() == 0;
    }

    public void k() {
        this.g.setVisibility(8);
        i();
        e();
        c();
        g();
        b(this.f);
    }

    public void l() {
        k();
        h();
    }

    public void m() {
        k();
        b();
    }

    public void n() {
        k();
        d();
    }

    public void o() {
        k();
        f();
    }

    public void c(View view) {
        if (!this.h) {
            k();
            this.f = view;
            a(view);
        }
    }

    public boolean p() {
        return this.e.a();
    }

    public boolean q() {
        VoiceManager.VoiceModel voiceModel = this.d.getVoiceModel();
        return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.d.getVoiceModel();
    }

    public void r() {
        this.d.a();
        setImage(null);
    }

    public void s() {
        this.d.F();
    }

    public void t() {
        s();
    }

    public void setOnActionListener(t tVar) {
        this.i.setPositiveButton(R.string.editor_dialog_yes, new b(this, tVar));
        this.b.setOnClickListener(new c(this, tVar));
        this.e.setOnClickListener(new d(this, tVar));
        this.c.setOnDataSelected(new e(this, tVar));
        this.d.setCallback(new f(this, tVar));
    }

    public boolean u() {
        return this.h;
    }

    public boolean v() {
        return this.b.a();
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.b.setmImagetype(0);
        }
        this.b.setImage(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.j = true;
        this.i.setMessage(R.string.editor_dialog_camera_to_image_content);
        this.i.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.j = false;
        this.i.setMessage(R.string.editor_dialog_image_to_camera_content);
        this.i.show();
    }

    public void a(boolean z) {
        this.b.a(z);
        this.c.setShowBigEmotion(!z);
    }

    public void a(int i) {
        this.c.b(i);
    }
}
