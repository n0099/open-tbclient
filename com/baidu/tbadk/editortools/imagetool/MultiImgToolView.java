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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements y, DragHorizonScrollView.a {
    private static boolean avh = false;
    private int EL;
    private j EM;
    private DragHorizonScrollView avi;
    private TextView avj;
    private DragLayer avk;
    private WriteImagesInfo avl;
    private com.baidu.tbadk.img.b avm;
    private b avn;
    private String avo;
    private int avp;
    private int avq;
    private boolean avr;
    private String avs;
    private a avt;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void K(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.avo = null;
        this.avp = 13;
        this.avq = 10;
        this.avr = false;
        this.avt = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avo = null;
        this.avp = 13;
        this.avq = 10;
        this.avr = false;
        this.avt = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.avi = (DragHorizonScrollView) findViewById(r.g.muti_image_upload_dragscrollview);
        this.avj = (TextView) findViewById(r.g.muti_image_tips);
        this.avk = (DragLayer) findViewById(r.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.avo = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.avm = bVar;
    }

    public int getImageNum() {
        return this.avl.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.avl = writeImagesInfo;
        this.avn = new b(getContext(), this.avm, this, this.avt, this.avq == 10);
        this.avn.a(this.avl);
        this.avi.a(this.avn, z);
        int maxItemNum = this.avi.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.avo)) {
            this.avj.setText(this.avo);
        } else if (!avh && size > 1) {
            this.avj.setText(r.j.editor_mutiiamge_drag_tip);
            avh = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.avj.setText(getResources().getString(r.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.avn != null) {
                        this.avn.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.avq, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ave, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avf);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.EM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void D(int i, int i2) {
        if (i != i2 && this.avl != null && this.avl.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.avl.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.avi;
    }

    public TextView getMutiImageTips() {
        return this.avj;
    }

    public DragLayer getDragLayer() {
        return this.avk;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b avm;
        private WriteImagesInfo avv = null;
        private y avw;
        private a avx;
        private boolean avy;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.avy = true;
            this.mContext = context;
            this.avm = bVar;
            this.avw = yVar;
            this.avx = aVar;
            this.avy = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.avv = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avv == null) {
                return 0;
            }
            return this.avv.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.avv.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(r.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.avv.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(r.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(r.e.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(r.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(r.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(r.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                ar.k(frameLayout3, r.f.bg_add_photo);
                frameLayout3.setForeground(ar.getDrawable(r.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.avm.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.avy) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(r.g.delete);
            ar.c(imageView, r.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(r.j.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.avp = i;
    }

    public void setTargetToolId(int i) {
        this.avq = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        ar.l(this, r.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.avr = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.avs = " ";
        } else {
            this.avs = str;
        }
    }
}
