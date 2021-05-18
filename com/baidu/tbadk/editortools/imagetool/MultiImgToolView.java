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
import d.a.c.e.a.d;
import d.a.c.e.p.l;
import d.a.j0.w.n;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.c {
    public static boolean w = false;

    /* renamed from: i  reason: collision with root package name */
    public DragHorizonScrollView f12854i;
    public TextView j;
    public DragLayer k;
    public WriteImagesInfo l;
    public d.a.j0.b0.b m;
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
            if (MultiImgToolView.this.f12854i.s()) {
                return;
            }
            MultiImgToolView.this.c(view);
            int q = MultiImgToolView.this.f12854i.q(view);
            if (q < 0 || q >= MultiImgToolView.this.l.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = MultiImgToolView.this.l.getChosedFiles().remove(q);
            if (remove.isTempFile()) {
                d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            int maxItemNum = MultiImgToolView.this.f12854i.getMaxItemNum();
            int size = MultiImgToolView.this.l.size();
            MultiImgToolView.this.j.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
            int size2 = MultiImgToolView.this.l.getChosedFiles().size();
            if (MultiImgToolView.this.o != null) {
                MultiImgToolView.this.o.A(new d.a.j0.w.a(MultiImgToolView.this.r, -1, null));
                if (size2 > 0) {
                    MultiImgToolView.this.o.A(new d.a.j0.w.a(2, MultiImgToolView.this.s, String.valueOf(size2)));
                } else {
                    MultiImgToolView.this.o.A(new d.a.j0.w.a(2, MultiImgToolView.this.s, null));
                }
                if (maxItemNum == 1 && size2 == 0) {
                    if (MultiImgToolView.this.t) {
                        MultiImgToolView.this.o.A(new d.a.j0.w.a(1, 2, null));
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
        public WriteImagesInfo f12856e = null;

        /* renamed from: f  reason: collision with root package name */
        public Context f12857f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.j0.b0.b f12858g;

        /* renamed from: h  reason: collision with root package name */
        public n f12859h;

        /* renamed from: i  reason: collision with root package name */
        public b f12860i;
        public boolean j;

        /* loaded from: classes3.dex */
        public class a implements d.a.j0.a0.b {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f12861e;

            public a(c cVar, ViewGroup viewGroup) {
                this.f12861e = viewGroup;
            }

            @Override // d.a.j0.a0.b
            public void a(d.a.c.j.d.a aVar, String str, boolean z) {
                TbImageView tbImageView = (TbImageView) this.f12861e.findViewWithTag(str);
                if (tbImageView == null || aVar == null) {
                    return;
                }
                tbImageView.invalidate();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f12862e;

            public b(ViewGroup viewGroup) {
                this.f12862e = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = this.f12862e.indexOfChild(view);
                if (indexOfChild >= 0) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) c.this.getItem(indexOfChild);
                    if (!(imageFileInfo != null && new File(imageFileInfo.getFilePath()).exists())) {
                        l.I(c.this.f12857f, R.string.editor_mutiiamge_image_error);
                    } else if (c.this.f12859h != null) {
                        c.this.f12859h.d(new d.a.j0.w.a(15, 0, Integer.valueOf(indexOfChild)));
                    }
                }
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.imagetool.MultiImgToolView$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0163c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FrameLayout f12864e;

            public View$OnClickListenerC0163c(FrameLayout frameLayout) {
                this.f12864e = frameLayout;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f12860i != null) {
                    c.this.f12860i.a(this.f12864e);
                }
            }
        }

        public c(Context context, d.a.j0.b0.b bVar, n nVar, b bVar2, boolean z) {
            this.j = true;
            this.f12857f = context;
            this.f12858g = bVar;
            this.f12859h = nVar;
            this.f12860i = bVar2;
            this.j = z;
        }

        public void d(WriteImagesInfo writeImagesInfo) {
            this.f12856e = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            WriteImagesInfo writeImagesInfo = this.f12856e;
            if (writeImagesInfo == null) {
                return 0;
            }
            return writeImagesInfo.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f12856e.getChosedFiles().get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = (FrameLayout) LayoutInflater.from(this.f12857f).inflate(R.layout.editor_muti_image_item, (ViewGroup) null);
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f12856e.getChosedFiles(), i2);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.f12857f.getResources().getDimensionPixelSize(R.dimen.ds66) * 2)) + this.f12857f.getResources().getDimensionPixelSize(R.dimen.ds32);
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
                imageFileInfo.addPageAction(d.a.j0.b0.g.d.g(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.f12858g.d(imageFileInfo, new a(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.j) {
                frameLayout.setOnClickListener(new b(viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.delete);
            SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View$OnClickListenerC0163c(frameLayout));
            frameLayout.setContentDescription(frameLayout.getResources().getString(R.string.editor_image) + (i2 + 1) + " " + imageFileInfo.getModifyTime());
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
    public void a(int i2, int i3) {
        WriteImagesInfo writeImagesInfo;
        if (i2 == i3 || (writeImagesInfo = this.l) == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = this.l.getChosedFiles();
        chosedFiles.add(i3, chosedFiles.remove(i2));
    }

    @Override // d.a.j0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.j0.w.n
    public void d(d.a.j0.w.a aVar) {
        EditorTools editorTools = this.o;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.f12854i;
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

    @Override // d.a.j0.w.n
    public int getToolId() {
        return this.p;
    }

    @Override // d.a.j0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.j0.w.n
    public void init() {
    }

    @Override // d.a.j0.w.b
    public void onAction(d.a.j0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f50768a;
        if (i2 == 9) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
            d(new d.a.j0.w.a(2, this.s, null));
        } else if (i2 == 12 && (obj = aVar.f50770c) != null && (obj instanceof d.a.j0.w.r.a)) {
            q(((d.a.j0.w.r.a) obj).f50791a, ((d.a.j0.w.r.a) obj).f50792b);
        }
    }

    @Override // d.a.j0.w.n
    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void p() {
        this.f12854i = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.j = (TextView) findViewById(R.id.muti_image_tips);
        this.k = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public final void q(WriteImagesInfo writeImagesInfo, boolean z) {
        this.l = writeImagesInfo;
        c cVar = new c(getContext(), this.m, this, this.v, this.s == 10);
        this.n = cVar;
        cVar.d(this.l);
        this.f12854i.setAdapter(this.n, z);
        int maxItemNum = this.f12854i.getMaxItemNum();
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

    public void setAsyncLocalImageLoader(d.a.j0.b0.b bVar) {
        this.m = bVar;
    }

    public void setDefaultTip(String str) {
        this.q = str;
    }

    public void setDeleteAction(int i2) {
        this.r = i2;
    }

    @Override // d.a.j0.w.n
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

    public void setTargetToolId(int i2) {
        this.s = i2;
    }

    @Override // d.a.j0.w.n
    public void setToolId(int i2) {
        this.p = i2;
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
