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
    private aa r;
    private com.baidu.tieba.img.e s;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.k = false;
        this.l = null;
        this.m = true;
        this.a = context;
        o();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = null;
        this.m = true;
        this.a = context;
        o();
    }

    private void o() {
        this.p = LayoutInflater.from(this.a);
        this.p.inflate(R.layout.editor_tool_container, (ViewGroup) this, true);
        this.b = (ToolMoreView) findViewById(R.id.tool_view);
        this.c = (EmotionTabHost) findViewById(R.id.face_view);
        this.d = (RecordVoiceBnt) findViewById(R.id.record_voice_view);
        this.l = new AlertDialog.Builder(this.a);
        this.l.setTitle(R.string.editor_dialog_title);
        this.l.setNegativeButton(R.string.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.f = (ImageView) findViewById(R.id.pb_foot_down_shadow);
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
        DragHorizonScrollView dragHorizonScrollView = this.i;
        int ae = TiebaApplication.g().ae();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(ae == 1 ? R.drawable.btn_add_photo_selector_1 : R.drawable.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int a = BdUtilHelper.a(this.a, 3.0f);
        imageView.setPadding(a, BdUtilHelper.a(this.a, 1.0f) + getResources().getDimensionPixelSize(R.dimen.default_gap_20) + a, this.o + a, a);
        imageView.setOnClickListener(new f(this));
        dragHorizonScrollView.setAddView(imageView);
        this.i.setOnSwapDataListener(this);
        this.i.setMaxItemNum(10);
        this.s = new com.baidu.tieba.img.e(this.a);
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    public final void a(View view) {
        if (view != null) {
            BdUtilHelper.b(this.a, view);
            this.k = true;
        }
    }

    public final void b(View view) {
        if (view != null) {
            BdUtilHelper.a(this.a, view);
            this.k = false;
        }
    }

    public final boolean a() {
        return this.b.getVisibility() == 0 || this.d.getVisibility() == 0 || this.c.getVisibility() == 0 || this.g.getVisibility() == 0;
    }

    public final void b() {
        c();
        b(this.e);
    }

    public final void c() {
        this.f.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.g.setVisibility(8);
    }

    public final void d() {
        b();
        this.f.setVisibility(0);
        this.b.setVisibility(0);
    }

    public final void e() {
        b();
        this.f.setVisibility(0);
        this.c.setVisibility(0);
    }

    public final void f() {
        b();
        this.f.setVisibility(0);
        this.d.setVisibility(0);
    }

    public final void g() {
        b();
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    public final void c(View view) {
        if (!this.k) {
            b();
            this.e = view;
            a(view);
        }
    }

    public final boolean h() {
        BaseAdapter adapter = this.i.getAdapter();
        return adapter != null && adapter.getCount() > 0;
    }

    public final boolean i() {
        VoiceManager.VoiceModel voiceModel = this.d.getVoiceModel();
        return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceManager.VoiceModel getAudioData() {
        return this.d.getVoiceModel();
    }

    public final void j() {
        this.d.a();
        setImage(null);
    }

    public final void k() {
        this.d.b();
    }

    public final void l() {
        this.d.b();
    }

    public void setOnActionListener(aa aaVar) {
        this.r = aaVar;
        this.l.setPositiveButton(R.string.editor_dialog_yes, new b(this, aaVar));
        this.b.setOnClickListener(new c(this, aaVar));
        this.c.setOnDataSelected(new d(this, aaVar));
        this.d.setCallback(new e(this, aaVar));
    }

    public final boolean m() {
        return this.k;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.b.setmImagetype(0);
        }
        this.b.setImage(bitmap);
    }

    public final void a(boolean z) {
        this.b.a(z);
        this.c.setShowBigEmotion(!z);
    }

    public final void a(int i) {
        this.c.b(i);
        this.b.a(i);
    }

    public final void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.q = writeImagesInfo;
        this.i.a(new g(this, writeImagesInfo), z);
        int maxItemNum = this.i.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!TiebaApplication.g().bl() && size > 1) {
            this.j.setText(R.string.editor_mutiiamge_drag_tip);
            TiebaApplication.g().A(true);
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

    public final void n() {
        this.i.f();
    }

    @Override // com.baidu.tieba.img.view.d
    public final void a(int i, int i2) {
        if (i != i2 && this.q != null && this.q.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.q.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }
}
