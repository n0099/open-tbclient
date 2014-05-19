package com.baidu.tieba.editortool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.img.view.DragContainer;
import com.baidu.tieba.img.view.DragHorizonScrollView;
import com.baidu.tieba.img.view.DragLayer;
import com.baidu.tieba.voice.RecordVoiceBnt;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorToolComponetContainer extends RelativeLayout implements com.baidu.tieba.img.view.d {
    protected Context a;
    protected ToolMoreView b;
    protected EmotionTabHost c;
    protected RecordVoiceBnt d;
    protected View e;
    protected ImageView f;
    protected DragContainer g;
    protected DragLayer h;
    protected DragHorizonScrollView i;
    protected TextView j;
    protected PrivilegeTabHost k;
    protected boolean l;
    private AlertDialog.Builder m;
    private final boolean n;
    private boolean o;
    private int p;
    private int q;
    private LayoutInflater r;
    private WriteImagesInfo s;
    private com.baidu.tbadk.editortool.x t;
    private com.baidu.tbadk.img.e u;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.l = false;
        this.m = null;
        this.n = true;
        this.a = context;
        a();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.m = null;
        this.n = true;
        this.a = context;
        a();
    }

    protected void a() {
        this.r = LayoutInflater.from(this.a);
        this.r.inflate(com.baidu.tieba.s.editor_tool_container, (ViewGroup) this, true);
        this.b = (ToolMoreView) findViewById(com.baidu.tieba.r.tool_view);
        this.c = (EmotionTabHost) findViewById(com.baidu.tieba.r.face_view);
        this.d = (RecordVoiceBnt) findViewById(com.baidu.tieba.r.record_voice_view);
        this.k = (PrivilegeTabHost) findViewById(com.baidu.tieba.r.privilege_view);
        this.m = new AlertDialog.Builder(this.a);
        this.m.setTitle(com.baidu.tieba.u.editor_dialog_title);
        this.m.setNegativeButton(com.baidu.tieba.u.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.f = (ImageView) findViewById(com.baidu.tieba.r.pb_foot_down_shadow);
        C();
    }

    private void C() {
        this.g = (DragContainer) findViewById(com.baidu.tieba.r.muti_image_upload);
        this.h = (DragLayer) findViewById(com.baidu.tieba.r.muti_image_upload_draglayer);
        this.i = (DragHorizonScrollView) findViewById(com.baidu.tieba.r.muti_image_upload_dragscrollview);
        com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
        aVar.a(this.h);
        aVar.a((com.baidu.tieba.img.view.g) this.i);
        aVar.a((com.baidu.tieba.img.view.f) this.i);
        this.j = (TextView) findViewById(com.baidu.tieba.r.muti_image_tips);
        this.p = getResources().getDimensionPixelSize(com.baidu.tieba.p.editor_muti_image_upload_scrollview_paddingleft);
        this.q = getResources().getDimensionPixelSize(com.baidu.tieba.p.default_gap_24);
        this.i.setAddView(D());
        this.i.setOnSwapDataListener(this);
        this.i.setMaxItemNum(10);
        this.u = new com.baidu.tbadk.img.e(this.a);
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    protected void b() {
        this.f.setVisibility(0);
        this.c.setVisibility(0);
    }

    protected void c() {
        this.c.setVisibility(8);
    }

    protected void d() {
        this.f.setVisibility(0);
        this.d.setVisibility(0);
    }

    protected void e() {
        this.d.setVisibility(8);
    }

    protected void f() {
        this.f.setVisibility(0);
        this.b.setVisibility(0);
    }

    public void g() {
        this.g.setVisibility(8);
    }

    public void h() {
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    protected void i() {
        this.b.setVisibility(8);
    }

    protected void j() {
        this.k.setVisibility(0);
    }

    protected void k() {
        this.k.setVisibility(8);
    }

    public void a(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.h.b(this.a, view);
            this.l = true;
        }
    }

    public void b(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.h.a(this.a, view);
            this.l = false;
        }
    }

    public boolean l() {
        return this.b.getVisibility() == 0 || this.d.getVisibility() == 0 || this.c.getVisibility() == 0 || this.g.getVisibility() == 0 || this.k.getVisibility() == 0;
    }

    public void m() {
        n();
        b(this.e);
    }

    public void n() {
        this.f.setVisibility(8);
        i();
        e();
        c();
        g();
        k();
    }

    public void o() {
        m();
        f();
    }

    public void p() {
        m();
        b();
    }

    public void q() {
        m();
        d();
    }

    public void r() {
        m();
        h();
    }

    public void s() {
        m();
        j();
    }

    public void c(View view) {
        if (!this.l) {
            m();
            this.e = view;
            a(view);
        }
    }

    public boolean t() {
        BaseAdapter adapter = this.i.getAdapter();
        return adapter != null && adapter.getCount() > 0;
    }

    public boolean u() {
        VoiceData.VoiceModel voiceModel = this.d.getVoiceModel();
        return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.d.getVoiceModel();
    }

    public void v() {
        this.d.d();
    }

    public void w() {
        this.d.c();
        setImage(null);
    }

    public void x() {
        this.d.b();
    }

    public void y() {
        x();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.x xVar) {
        this.t = new h(this, xVar);
        this.m.setPositiveButton(com.baidu.tieba.u.editor_dialog_yes, new i(this));
        this.b.setOnClickListener(new j(this));
        this.c.setOnDataSelected(new k(this));
        this.d.setCallback(new l(this));
        this.k.setOnDataSelected(new m(this));
    }

    public boolean z() {
        return this.l;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.b.setmImagetype(0);
        }
        this.b.setImage(bitmap);
    }

    public void a(boolean z) {
        this.o = z;
        this.b.b(z);
        this.c.setShowBigEmotion(!z);
    }

    public void a(int i) {
        this.c.b(i);
        this.b.a(i);
        this.k.b(i);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.s = writeImagesInfo;
        this.i.a(new o(this, writeImagesInfo), z);
        int maxItemNum = this.i.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.ad.c().R() && size > 1) {
            this.j.setText(com.baidu.tieba.u.editor_mutiiamge_drag_tip);
            com.baidu.tieba.ad.c().q(true);
        } else {
            this.j.setText(getResources().getString(com.baidu.tieba.u.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.b.a(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.b.a();
        }
        this.t.a(13, null);
    }

    private View D() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(skinType == 1 ? com.baidu.tieba.q.btn_add_photo_selector_1 : com.baidu.tieba.q.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int a = com.baidu.adp.lib.util.h.a(this.a, 3.0f);
        imageView.setPadding(a, com.baidu.adp.lib.util.h.a(this.a, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.p.default_gap_20) + a, this.q + a, a);
        imageView.setOnClickListener(new n(this));
        return imageView;
    }

    public void A() {
        this.i.f();
    }

    @Override // com.baidu.tieba.img.view.d
    public void a(int i, int i2) {
        if (i != i2 && this.s != null && this.s.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.s.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void B() {
        if (this.o) {
            this.b.d();
        } else if (TextUtils.isEmpty(TbadkApplication.m252getInst().getDefaultBubble()) && !this.o) {
            this.b.d();
        } else {
            this.b.c();
        }
    }
}
