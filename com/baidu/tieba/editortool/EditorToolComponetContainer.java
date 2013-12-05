package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tieba.view.ap;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EditorToolComponetContainer extends RelativeLayout implements ap {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1269a;
    protected FaceView b;
    protected RecordVoiceBnt c;
    protected ImageUploadView d;
    protected View e;
    protected boolean f;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.f = false;
        this.f1269a = context;
        a();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.f1269a = context;
        a();
    }

    protected void a() {
        LayoutInflater.from(this.f1269a).inflate(R.layout.editor_tool_container, (ViewGroup) this, true);
        this.b = (FaceView) findViewById(R.id.face_view);
        this.c = (RecordVoiceBnt) findViewById(R.id.record_voice_view);
        this.d = (ImageUploadView) findViewById(R.id.image_upload_view);
    }

    protected void b() {
        this.b.setVisibility(0);
    }

    protected void c() {
        this.b.setVisibility(8);
    }

    protected void d() {
        this.c.setVisibility(0);
    }

    protected void e() {
        this.c.setVisibility(8);
    }

    protected void f() {
        this.d.setVisibility(0);
    }

    protected void g() {
        this.d.setVisibility(8);
    }

    public void a(View view) {
        if (view != null) {
            com.baidu.adp.lib.h.g.b(this.f1269a, view);
            this.f = true;
        }
    }

    public void b(View view) {
        if (view != null) {
            com.baidu.adp.lib.h.g.a(this.f1269a, view);
            this.f = false;
        }
    }

    public boolean h() {
        return this.c.getVisibility() == 0 || this.b.getVisibility() == 0 || this.d.getVisibility() == 0;
    }

    public void i() {
        e();
        c();
        g();
        b(this.e);
    }

    public void j() {
        i();
        b();
    }

    public void k() {
        i();
        d();
    }

    public void l() {
        i();
        f();
    }

    public void c(View view) {
        if (!this.f) {
            i();
            this.e = view;
            a(view);
        }
    }

    public boolean m() {
        return this.d.a();
    }

    public boolean n() {
        VoiceManager.VoiceModel voiceModel = this.c.getVoiceModel();
        return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.c.getVoiceModel();
    }

    public void o() {
        this.c.a();
    }

    public void p() {
        this.c.C();
    }

    public void q() {
        p();
    }

    public void setOnActionListener(h hVar) {
        this.d.setOnClickListener(new b(this, hVar));
        this.b.setOnDataSelected(new c(this, hVar));
        this.c.setCallback(new d(this, hVar));
    }

    public boolean r() {
        return this.f;
    }

    @Override // com.baidu.tieba.view.ap
    public void a(int i) {
        if (i == 1) {
            this.f = false;
        } else if (i == 0) {
            this.f = true;
        }
    }
}
