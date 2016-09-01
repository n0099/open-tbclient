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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements ab, DragHorizonScrollView.a {
    private static boolean avn = false;
    private int EI;
    private l EJ;
    private DragHorizonScrollView avo;
    private TextView avp;
    private DragLayer avq;
    private WriteImagesInfo avr;
    private com.baidu.tbadk.img.b avs;
    private b avt;
    private String avu;
    private int avv;
    private int avw;
    private boolean avx;
    private String avy;
    private a avz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void J(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.avu = null;
        this.avv = 13;
        this.avw = 10;
        this.avx = false;
        this.avz = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avu = null;
        this.avv = 13;
        this.avw = 10;
        this.avx = false;
        this.avz = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.avo = (DragHorizonScrollView) findViewById(t.g.muti_image_upload_dragscrollview);
        this.avp = (TextView) findViewById(t.g.muti_image_tips);
        this.avq = (DragLayer) findViewById(t.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.avu = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.avs = bVar;
    }

    public int getImageNum() {
        return this.avr.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.avr = writeImagesInfo;
        this.avt = new b(getContext(), this.avs, this, this.avz, this.avw == 10);
        this.avt.a(this.avr);
        this.avo.a(this.avt, z);
        int maxItemNum = this.avo.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.avu)) {
            this.avp.setText(this.avu);
        } else if (!avn && size > 1) {
            this.avp.setText(t.j.editor_mutiiamge_drag_tip);
            avn = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.avp.setText(getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.avt != null) {
                        this.avt.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.avw, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avk, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avl);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avk, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avl);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EJ = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void D(int i, int i2) {
        if (i != i2 && this.avr != null && this.avr.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.avr.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.avo;
    }

    public TextView getMutiImageTips() {
        return this.avp;
    }

    public DragLayer getDragLayer() {
        return this.avq;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo avB = null;
        private ab avC;
        private a avD;
        private boolean avE;
        private com.baidu.tbadk.img.b avs;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.avE = true;
            this.mContext = context;
            this.avs = bVar;
            this.avC = abVar;
            this.avD = aVar;
            this.avE = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.avB = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avB == null) {
                return 0;
            }
            return this.avB.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.avB.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(t.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.c(this.avB.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(t.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(t.e.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(t.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(t.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(t.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                av.k(frameLayout3, t.f.bg_add_photo);
                frameLayout3.setForeground(av.getDrawable(t.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.avs.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.avE) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(t.g.delete);
            av.c(imageView, t.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(t.j.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.avv = i;
    }

    public void setTargetToolId(int i) {
        this.avw = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        av.l(this, t.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.avx = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.avy = " ";
        } else {
            this.avy = str;
        }
    }
}
