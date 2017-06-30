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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements y, DragHorizonScrollView.a {
    private static boolean aAM = false;
    private int JS;
    private j JT;
    private DragHorizonScrollView aAN;
    private TextView aAO;
    private DragLayer aAP;
    private WriteImagesInfo aAQ;
    private com.baidu.tbadk.img.b aAR;
    private b aAS;
    private String aAT;
    private int aAU;
    private int aAV;
    private boolean aAW;
    private String aAX;
    private a aAY;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aAT = null;
        this.aAU = 13;
        this.aAV = 10;
        this.aAW = false;
        this.aAY = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAT = null;
        this.aAU = 13;
        this.aAV = 10;
        this.aAW = false;
        this.aAY = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aAN = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.aAO = (TextView) findViewById(w.h.muti_image_tips);
        this.aAP = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aAT = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aAR = bVar;
    }

    public int getImageNum() {
        return this.aAQ.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aAQ = writeImagesInfo;
        this.aAS = new b(getContext(), this.aAR, this, this.aAY, this.aAV == 10);
        this.aAS.a(this.aAQ);
        this.aAN.a(this.aAS, z);
        int maxItemNum = this.aAN.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aAT)) {
            this.aAO.setText(this.aAT);
        } else if (!aAM && size > 1) {
            this.aAO.setText(w.l.editor_mutiiamge_drag_tip);
            aAM = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aAO.setText(getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aAS != null) {
                        this.aAS.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aAV, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aAJ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aAK);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.aAQ != null && this.aAQ.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aAQ.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aAN;
    }

    public TextView getMutiImageTips() {
        return this.aAO;
    }

    public DragLayer getDragLayer() {
        return this.aAP;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aAR;
        private WriteImagesInfo aBa = null;
        private y aBb;
        private a aBc;
        private boolean aBd;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aBd = true;
            this.mContext = context;
            this.aAR = bVar;
            this.aBb = yVar;
            this.aBc = aVar;
            this.aBd = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aBa = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBa == null) {
                return 0;
            }
            return this.aBa.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aBa.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) z.c(this.aBa.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(w.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(w.f.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(w.h.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(w.h.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(w.h.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                as.j(frameLayout3, w.g.bg_add_photo);
                frameLayout3.setForeground(as.getDrawable(w.g.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.L(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aAR.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aBd) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(w.h.delete);
            as.c(imageView, w.g.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            View findViewById = frameLayout2.findViewById(w.h.gif_icon);
            if (imageFileInfo.isGif() && !imageFileInfo.hasActionsWithoutResize()) {
                findViewById.setVisibility(0);
                as.j(findViewById, w.g.ic_image_gif);
            } else {
                findViewById.setVisibility(8);
            }
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(w.l.editor_image)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aAU = i;
    }

    public void setTargetToolId(int i) {
        this.aAV = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        as.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aAW = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aAX = " ";
        } else {
            this.aAX = str;
        }
    }
}
