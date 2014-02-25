package com.baidu.tieba.editortool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.baidu.tieba.img.view.DragContainer;
import com.baidu.tieba.img.view.DragHorizonScrollView;
import com.baidu.tieba.img.view.DragLayer;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
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
    protected boolean k;
    private AlertDialog.Builder l;
    private boolean m;
    private int n;
    private int o;
    private LayoutInflater p;
    private WriteImagesInfo q;
    private z r;
    private com.baidu.tieba.img.e s;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.k = false;
        this.l = null;
        this.m = true;
        this.a = context;
        a();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = null;
        this.m = true;
        this.a = context;
        a();
    }

    protected void a() {
        this.p = LayoutInflater.from(this.a);
        this.p.inflate(R.layout.editor_tool_container, (ViewGroup) this, true);
        this.b = (ToolMoreView) findViewById(R.id.tool_view);
        this.c = (EmotionTabHost) findViewById(R.id.face_view);
        this.d = (RecordVoiceBnt) findViewById(R.id.record_voice_view);
        this.l = new AlertDialog.Builder(this.a);
        this.l.setTitle(R.string.editor_dialog_title);
        this.l.setNegativeButton(R.string.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.f = (ImageView) findViewById(R.id.pb_foot_down_shadow);
        x();
    }

    private void x() {
        this.g = (DragContainer) findViewById(R.id.muti_image_upload);
        this.h = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
        this.i = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
        aVar.a(this.h);
        aVar.a((com.baidu.tieba.img.view.g) this.i);
        aVar.a((com.baidu.tieba.img.view.f) this.i);
        this.j = (TextView) findViewById(R.id.muti_image_tips);
        this.n = getResources().getDimensionPixelSize(R.dimen.editor_muti_image_upload_scrollview_paddingleft);
        this.o = getResources().getDimensionPixelSize(R.dimen.default_gap_24);
        this.i.setAddView(y());
        this.i.setOnSwapDataListener(this);
        this.i.setMaxItemNum(10);
        this.s = new com.baidu.tieba.img.e(this.a);
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

    public void a(View view) {
        if (view != null) {
            BdUtilHelper.b(this.a, view);
            this.k = true;
        }
    }

    public void b(View view) {
        if (view != null) {
            BdUtilHelper.a(this.a, view);
            this.k = false;
        }
    }

    public boolean j() {
        return this.b.getVisibility() == 0 || this.d.getVisibility() == 0 || this.c.getVisibility() == 0 || this.g.getVisibility() == 0;
    }

    public void k() {
        l();
        b(this.e);
    }

    public void l() {
        this.f.setVisibility(8);
        i();
        e();
        c();
        g();
    }

    public void m() {
        k();
        f();
    }

    public void n() {
        k();
        b();
    }

    public void o() {
        k();
        d();
    }

    public void p() {
        k();
        h();
    }

    public void c(View view) {
        if (!this.k) {
            k();
            this.e = view;
            a(view);
        }
    }

    public boolean q() {
        BaseAdapter adapter = this.i.getAdapter();
        return adapter != null && adapter.getCount() > 0;
    }

    public boolean r() {
        VoiceManager.VoiceModel voiceModel = this.d.getVoiceModel();
        return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.d.getVoiceModel();
    }

    public void s() {
        this.d.a();
        setImage(null);
    }

    public void t() {
        this.d.H();
    }

    public void u() {
        t();
    }

    public void setOnActionListener(z zVar) {
        this.r = zVar;
        this.l.setPositiveButton(R.string.editor_dialog_yes, new b(this, zVar));
        this.b.setOnClickListener(new c(this, zVar));
        this.c.setOnDataSelected(new d(this, zVar));
        this.d.setCallback(new e(this, zVar));
    }

    public boolean v() {
        return this.k;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.b.setmImagetype(0);
        }
        this.b.setImage(bitmap);
    }

    public void a(boolean z) {
        this.b.b(z);
        this.c.setShowBigEmotion(!z);
    }

    public void a(int i) {
        this.c.b(i);
        this.b.a(i);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.q = writeImagesInfo;
        this.i.a(new g(this, writeImagesInfo), z);
        int maxItemNum = this.i.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!TiebaApplication.g().bt() && size > 1) {
            this.j.setText(R.string.editor_mutiiamge_drag_tip);
            TiebaApplication.g().B(true);
        } else {
            this.j.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.b.a(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.b.a();
        }
        this.r.a(13, null);
    }

    private View y() {
        int al = TiebaApplication.g().al();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(al == 1 ? R.drawable.btn_add_photo_selector_1 : R.drawable.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int a = BdUtilHelper.a(this.a, 3.0f);
        imageView.setPadding(a, BdUtilHelper.a(this.a, 1.0f) + getResources().getDimensionPixelSize(R.dimen.default_gap_20) + a, this.o + a, a);
        imageView.setOnClickListener(new f(this));
        return imageView;
    }

    public void w() {
        this.i.f();
    }

    @Override // com.baidu.tieba.img.view.d
    public void a(int i, int i2) {
        if (i != i2 && this.q != null && this.q.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.q.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }
}
