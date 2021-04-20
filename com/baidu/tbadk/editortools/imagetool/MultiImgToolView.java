package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import d.b.c.e.a.d;
import d.b.c.e.p.l;
import d.b.h0.w.n;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.c {
    public static boolean w = false;
    public DragHorizonScrollView i;
    public TextView j;
    public DragLayer k;
    public WriteImagesInfo l;
    public d.b.h0.b0.b m;
    public c n;
    public EditorTools o;
    public int p;
    public String q;
    public int r;
    public int s;
    public boolean t;
    public String u;
    public b v;

    /* loaded from: classes3.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b
        public void a(View view) {
            if (MultiImgToolView.this.i.s()) {
                return;
            }
            MultiImgToolView.this.c(view);
            int q = MultiImgToolView.this.i.q(view);
            if (q < 0 || q >= MultiImgToolView.this.l.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = MultiImgToolView.this.l.getChosedFiles().remove(q);
            if (remove.isTempFile()) {
                d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            int maxItemNum = MultiImgToolView.this.i.getMaxItemNum();
            int size = MultiImgToolView.this.l.size();
            MultiImgToolView.this.j.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            int size2 = MultiImgToolView.this.l.getChosedFiles().size();
            if (MultiImgToolView.this.o != null) {
                MultiImgToolView.this.o.A(new d.b.h0.w.a(MultiImgToolView.this.r, -1, null));
                if (size2 > 0) {
                    MultiImgToolView.this.o.A(new d.b.h0.w.a(2, MultiImgToolView.this.s, String.valueOf(size2)));
                } else {
                    MultiImgToolView.this.o.A(new d.b.h0.w.a(2, MultiImgToolView.this.s, null));
                }
                if (maxItemNum == 1 && size2 == 0) {
                    if (MultiImgToolView.this.t) {
                        MultiImgToolView.this.o.A(new d.b.h0.w.a(1, 2, null));
                        return;
                    }
                    MultiImgToolView multiImgToolView = MultiImgToolView.this;
                    multiImgToolView.q(multiImgToolView.l, true);
                    MultiImgToolView.this.j.setText(MultiImgToolView.this.u);
                    MultiImgToolView.this.o.invalidate();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view);
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public WriteImagesInfo f13522e = null;

        /* renamed from: f  reason: collision with root package name */
        public Context f13523f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.h0.b0.b f13524g;

        /* renamed from: h  reason: collision with root package name */
        public n f13525h;
        public b i;
        public boolean j;

        /* loaded from: classes3.dex */
        public class a implements d.b.h0.a0.b {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f13526e;

            public a(c cVar, ViewGroup viewGroup) {
                this.f13526e = viewGroup;
            }

            @Override // d.b.h0.a0.b
            public void a(d.b.c.j.d.a aVar, String str, boolean z) {
                TbImageView tbImageView = (TbImageView) this.f13526e.findViewWithTag(str);
                if (tbImageView == null || aVar == null) {
                    return;
                }
                tbImageView.invalidate();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f13527e;

            public b(ViewGroup viewGroup) {
                this.f13527e = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = this.f13527e.indexOfChild(view);
                if (indexOfChild >= 0) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) c.this.getItem(indexOfChild);
                    if (!(imageFileInfo != null && new File(imageFileInfo.getFilePath()).exists())) {
                        l.H(c.this.f13523f, R.string.editor_mutiiamge_image_error);
                    } else if (c.this.f13525h != null) {
                        c.this.f13525h.d(new d.b.h0.w.a(15, 0, Integer.valueOf(indexOfChild)));
                    }
                }
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.imagetool.MultiImgToolView$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0179c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FrameLayout f13529e;

            public View$OnClickListenerC0179c(FrameLayout frameLayout) {
                this.f13529e = frameLayout;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.i != null) {
                    c.this.i.a(this.f13529e);
                }
            }
        }

        public c(Context context, d.b.h0.b0.b bVar, n nVar, b bVar2, boolean z) {
            this.j = true;
            this.f13523f = context;
            this.f13524g = bVar;
            this.f13525h = nVar;
            this.i = bVar2;
            this.j = z;
        }

        public void d(WriteImagesInfo writeImagesInfo) {
            this.f13522e = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            WriteImagesInfo writeImagesInfo = this.f13522e;
            if (writeImagesInfo == null) {
                return 0;
            }
            return writeImagesInfo.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f13522e.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = (FrameLayout) LayoutInflater.from(this.f13523f).inflate(R.layout.editor_muti_image_item, (ViewGroup) null);
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f13522e.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.f13523f.getResources().getDimensionPixelSize(R.dimen.ds66) * 2)) + this.f13523f.getResources().getDimensionPixelSize(R.dimen.ds32);
            FrameLayout frameLayout = (FrameLayout) view;
            LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.iv_container);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout.findViewById(R.id.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                SkinManager.setBackgroundResource(frameLayout2, R.drawable.bg_add_photo);
                frameLayout2.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(d.b.h0.b0.g.d.g(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.f13524g.d(imageFileInfo, new a(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.j) {
                frameLayout.setOnClickListener(new b(viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.delete);
            SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View$OnClickListenerC0179c(frameLayout));
            frameLayout.setContentDescription(frameLayout.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout;
        }
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.q = null;
        this.r = 13;
        this.s = 10;
        this.t = false;
        this.v = new a();
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.c
    public void a(int i, int i2) {
        WriteImagesInfo writeImagesInfo;
        if (i == i2 || (writeImagesInfo = this.l) == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = this.l.getChosedFiles();
        chosedFiles.add(i2, chosedFiles.remove(i));
    }

    @Override // d.b.h0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.o;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.i;
    }

    public DragLayer getDragLayer() {
        return this.k;
    }

    public int getImageNum() {
        return this.l.getChosedFiles().size();
    }

    public TextView getMutiImageTips() {
        return this.j;
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.p;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i = aVar.f51942a;
        if (i == 9) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
            d(new d.b.h0.w.a(2, this.s, null));
        } else if (i == 12 && (obj = aVar.f51944c) != null && (obj instanceof d.b.h0.w.r.a)) {
            q(((d.b.h0.w.r.a) obj).f51964a, ((d.b.h0.w.r.a) obj).f51965b);
        }
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void p() {
        this.i = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.j = (TextView) findViewById(R.id.muti_image_tips);
        this.k = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public final void q(WriteImagesInfo writeImagesInfo, boolean z) {
        this.l = writeImagesInfo;
        c cVar = new c(getContext(), this.m, this, this.v, this.s == 10);
        this.n = cVar;
        cVar.d(this.l);
        this.i.setAdapter(this.n, z);
        int maxItemNum = this.i.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.q)) {
            this.j.setText(this.q);
        } else if (!w && size > 1) {
            this.j.setText(R.string.editor_mutiiamge_drag_tip);
            w = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.j.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            String str = size + "";
        }
    }

    public void setAsyncLocalImageLoader(d.b.h0.b0.b bVar) {
        this.m = bVar;
    }

    public void setDefaultTip(String str) {
        this.q = str;
    }

    public void setDeleteAction(int i) {
        this.r = i;
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.o = editorTools;
    }

    public void setNeedQuit(boolean z) {
        this.t = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.u = " ";
        } else {
            this.u = str;
        }
    }

    public void setTargetToolId(int i) {
        this.s = i;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.p = i;
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = null;
        this.r = 13;
        this.s = 10;
        this.t = false;
        this.v = new a();
    }
}
