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
import com.baidu.tbadk.TbConfig;
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
    protected DragContainer j;
    protected DragLayer k;
    protected DragHorizonScrollView l;
    protected TextView m;
    protected PrivilegeTabHost n;
    protected boolean o;
    private AlertDialog.Builder p;
    private final boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private LayoutInflater v;
    private WriteImagesInfo w;
    private WriteImagesInfo x;
    private com.baidu.tbadk.editortool.w y;
    private com.baidu.tbadk.img.e z;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.o = false;
        this.p = null;
        this.q = true;
        this.s = false;
        this.a = context;
        a();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = false;
        this.p = null;
        this.q = true;
        this.s = false;
        this.a = context;
        a();
    }

    protected void a() {
        this.v = LayoutInflater.from(this.a);
        this.v.inflate(com.baidu.tieba.v.editor_tool_container, (ViewGroup) this, true);
        this.b = (ToolMoreView) findViewById(com.baidu.tieba.u.tool_view);
        this.c = (EmotionTabHost) findViewById(com.baidu.tieba.u.face_view);
        this.d = (RecordVoiceBnt) findViewById(com.baidu.tieba.u.record_voice_view);
        this.n = (PrivilegeTabHost) findViewById(com.baidu.tieba.u.privilege_view);
        this.p = new AlertDialog.Builder(this.a);
        this.p.setTitle(com.baidu.tieba.x.editor_dialog_title);
        this.p.setNegativeButton(com.baidu.tieba.x.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.f = (ImageView) findViewById(com.baidu.tieba.u.pb_foot_down_shadow);
        H();
        I();
        if (com.baidu.tieba.e.a.b() && this.b.getBaobao() != null && this.b.getBaobao().isShown()) {
            this.b.c("N");
        }
    }

    private void H() {
        this.g = (DragContainer) findViewById(com.baidu.tieba.u.muti_image_upload);
        this.h = (DragLayer) findViewById(com.baidu.tieba.u.muti_image_upload_draglayer);
        this.i = (DragHorizonScrollView) findViewById(com.baidu.tieba.u.muti_image_upload_dragscrollview);
        com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
        aVar.a(this.h);
        aVar.a((com.baidu.tieba.img.view.g) this.i);
        aVar.a((com.baidu.tieba.img.view.f) this.i);
        this.m = (TextView) findViewById(com.baidu.tieba.u.muti_image_tips);
        this.t = getResources().getDimensionPixelSize(com.baidu.tieba.s.editor_muti_image_upload_scrollview_paddingleft);
        this.u = getResources().getDimensionPixelSize(com.baidu.tieba.s.default_gap_24);
        this.i.setAddView(b(7));
        this.i.setOnSwapDataListener(this);
        this.i.setMaxItemNum(10);
        this.z = new com.baidu.tbadk.img.e(this.a);
    }

    private void I() {
        this.j = (DragContainer) findViewById(com.baidu.tieba.u.baobao_image_upload);
        this.k = (DragLayer) findViewById(com.baidu.tieba.u.baobao_image_upload_draglayer);
        this.l = (DragHorizonScrollView) findViewById(com.baidu.tieba.u.baobao_image_upload_dragscrollview);
        com.baidu.tieba.img.view.a aVar = new com.baidu.tieba.img.view.a(getContext());
        aVar.a(this.k);
        aVar.a((com.baidu.tieba.img.view.g) this.l);
        aVar.a((com.baidu.tieba.img.view.f) this.l);
        this.l.setAddView(b(48));
        this.l.setOnSwapDataListener(this);
        this.l.setMaxItemNum(1);
        this.l.setCenterStart(true);
    }

    public void setHideBaobao(boolean z) {
        this.s = z;
        if (this.b != null) {
            this.b.setHideBaobao(z);
            if (z && com.baidu.tieba.e.a.b()) {
                this.b.e();
            }
        }
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

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.b.e();
    }

    public void k() {
        this.f.setVisibility(0);
        this.j.setVisibility(0);
    }

    protected void l() {
        this.b.setVisibility(8);
    }

    protected void m() {
        this.n.setVisibility(0);
    }

    protected void n() {
        this.n.setVisibility(8);
    }

    public void a(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.j.b(this.a, view);
            this.o = true;
        }
    }

    public void b(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.j.a(this.a, view);
            this.o = false;
        }
    }

    public boolean o() {
        return this.b.getVisibility() == 0 || this.d.getVisibility() == 0 || this.c.getVisibility() == 0 || this.g.getVisibility() == 0 || this.n.getVisibility() == 0 || this.j.getVisibility() == 0;
    }

    public void p() {
        q();
        b(this.e);
    }

    public void q() {
        this.f.setVisibility(8);
        l();
        e();
        c();
        g();
        n();
        i();
    }

    public void r() {
        p();
        f();
    }

    public void s() {
        p();
        b();
    }

    public void t() {
        p();
        d();
    }

    public void u() {
        p();
        h();
    }

    public void v() {
        p();
        m();
    }

    public void w() {
        p();
        k();
    }

    public void c(View view) {
        if (!this.o) {
            p();
            this.e = view;
            a(view);
        }
    }

    public boolean x() {
        BaseAdapter adapter = this.i.getAdapter();
        return adapter != null && adapter.getCount() > 0;
    }

    public boolean y() {
        BaseAdapter adapter = this.l.getAdapter();
        return adapter != null && adapter.getCount() > 0;
    }

    public boolean z() {
        VoiceData.VoiceModel voiceModel = this.d.getVoiceModel();
        return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.d.getVoiceModel();
    }

    public void A() {
        this.d.d();
    }

    public void B() {
        this.d.c();
        setImage(null);
        this.b.e();
    }

    public void C() {
        this.d.b();
    }

    public void D() {
        C();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.y = new j(this, wVar);
        this.p.setPositiveButton(com.baidu.tieba.x.editor_dialog_yes, new k(this));
        this.b.setOnClickListener(new l(this));
        this.c.setOnDataSelected(new m(this));
        this.d.setCallback(new n(this));
        this.n.setOnDataSelected(new o(this));
    }

    public boolean E() {
        return this.o;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.b.setmImagetype(0);
        }
        this.b.setImage(bitmap);
    }

    public void a(boolean z) {
        this.r = z;
        this.b.b(z);
        this.c.setShowBigEmotion(!z);
    }

    public void a(int i) {
        this.c.b(i);
        this.b.a(i);
        this.n.b(i);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.w = writeImagesInfo;
        this.i.a(new q(this, writeImagesInfo), z);
        int maxItemNum = this.i.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.ai.c().O() && size > 1) {
            this.m.setText(com.baidu.tieba.x.editor_mutiiamge_drag_tip);
            com.baidu.tieba.ai.c().s(true);
        } else {
            this.m.setText(getResources().getString(com.baidu.tieba.x.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.b.a(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.b.a();
        }
        this.y.a(13, null);
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        this.x = writeImagesInfo;
        this.l.a((BaseAdapter) new q(this, this.x), false);
        this.y.a(51, null);
        if (this.x.size() > 0) {
            this.b.c(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        } else {
            this.b.e();
        }
        this.y.a(51, null);
    }

    private View b(int i) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(skinType == 1 ? com.baidu.tieba.t.btn_add_photo_selector_1 : com.baidu.tieba.t.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int a = com.baidu.adp.lib.util.j.a(this.a, 3.0f);
        imageView.setPadding(a, com.baidu.adp.lib.util.j.a(this.a, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.s.default_gap_20) + a, this.u + a, a);
        imageView.setOnClickListener(new p(this, i));
        return imageView;
    }

    public void F() {
        this.i.f();
        this.l.f();
    }

    @Override // com.baidu.tieba.img.view.d
    public void a(int i, int i2) {
        if (i != i2 && this.w != null && this.w.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.w.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void G() {
        if (this.r) {
            this.b.d();
        } else if (TextUtils.isEmpty(TbadkApplication.m252getInst().getDefaultBubble()) && !this.r) {
            this.b.d();
        } else {
            this.b.c();
        }
    }
}
