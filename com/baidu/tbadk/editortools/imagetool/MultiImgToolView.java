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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements z, DragHorizonScrollView.a {
    private static boolean auc = false;
    private int Lw;
    private k Lx;
    private DragHorizonScrollView aud;
    private TextView aue;
    private DragLayer auf;
    private WriteImagesInfo aug;
    private com.baidu.tbadk.img.b auh;
    private b aui;
    private String auj;
    private int auk;
    private int aul;
    private boolean aum;
    private String aun;
    private a auo;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.auj = null;
        this.auk = 13;
        this.aul = 10;
        this.aum = false;
        this.auo = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auj = null;
        this.auk = 13;
        this.aul = 10;
        this.aum = false;
        this.auo = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aud = (DragHorizonScrollView) findViewById(t.g.muti_image_upload_dragscrollview);
        this.aue = (TextView) findViewById(t.g.muti_image_tips);
        this.auf = (DragLayer) findViewById(t.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.auj = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.auh = bVar;
    }

    public int getImageNum() {
        return this.aug.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aug = writeImagesInfo;
        this.aui = new b(getContext(), this.auh, this, this.auo, this.aul == 10);
        this.aui.a(this.aug);
        this.aud.a(this.aui, z);
        int maxItemNum = this.aud.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.auj)) {
            this.aue.setText(this.auj);
        } else if (!auc && size > 1) {
            this.aue.setText(t.j.editor_mutiiamge_drag_tip);
            auc = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aue.setText(getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            new StringBuilder(String.valueOf(size)).toString();
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.aui != null) {
                        this.aui.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aul, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).atZ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aua);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).atZ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aua);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Lx = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void E(int i, int i2) {
        if (i != i2 && this.aug != null && this.aug.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aug.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aud;
    }

    public TextView getMutiImageTips() {
        return this.aue;
    }

    public DragLayer getDragLayer() {
        return this.auf;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b auh;
        private WriteImagesInfo auq = null;
        private z aur;
        private a aus;
        private boolean aut;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, z zVar, a aVar, boolean z) {
            this.aut = true;
            this.mContext = context;
            this.auh = bVar;
            this.aur = zVar;
            this.aus = aVar;
            this.aut = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.auq = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.auq == null) {
                return 0;
            }
            return this.auq.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.auq.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(t.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.auq.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(t.e.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(t.e.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(t.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(t.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(t.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                ar.k(frameLayout3, t.f.bg_add_photo);
                frameLayout3.setForeground(ar.getDrawable(t.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.auh.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aut) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(t.g.delete);
            ar.c(imageView, t.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.auk = i;
    }

    public void setTargetToolId(int i) {
        this.aul = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        ar.l(this, t.d.editor_background);
    }

    public void setNeedQuit(boolean z) {
        this.aum = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aun = " ";
        } else {
            this.aun = str;
        }
    }
}
