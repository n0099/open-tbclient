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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements ab, DragHorizonScrollView.a {
    private static boolean auQ = false;
    private int EI;
    private l EJ;
    private DragHorizonScrollView auR;
    private TextView auS;
    private DragLayer auT;
    private WriteImagesInfo auU;
    private com.baidu.tbadk.img.b auV;
    private b auW;
    private String auX;
    private int auY;
    private int auZ;
    private boolean ava;
    private String avb;
    private a avc;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void J(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.auX = null;
        this.auY = 13;
        this.auZ = 10;
        this.ava = false;
        this.avc = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auX = null;
        this.auY = 13;
        this.auZ = 10;
        this.ava = false;
        this.avc = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.auR = (DragHorizonScrollView) findViewById(r.g.muti_image_upload_dragscrollview);
        this.auS = (TextView) findViewById(r.g.muti_image_tips);
        this.auT = (DragLayer) findViewById(r.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.auX = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.auV = bVar;
    }

    public int getImageNum() {
        return this.auU.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.auU = writeImagesInfo;
        this.auW = new b(getContext(), this.auV, this, this.avc, this.auZ == 10);
        this.auW.a(this.auU);
        this.auR.a(this.auW, z);
        int maxItemNum = this.auR.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.auX)) {
            this.auS.setText(this.auX);
        } else if (!auQ && size > 1) {
            this.auS.setText(r.j.editor_mutiiamge_drag_tip);
            auQ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.auS.setText(getResources().getString(r.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.auW != null) {
                        this.auW.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.auZ, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auN, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auO);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auN, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auO);
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
        if (i != i2 && this.auU != null && this.auU.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.auU.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.auR;
    }

    public TextView getMutiImageTips() {
        return this.auS;
    }

    public DragLayer getDragLayer() {
        return this.auT;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b auV;
        private WriteImagesInfo ave = null;
        private ab avf;
        private a avg;
        private boolean avh;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.avh = true;
            this.mContext = context;
            this.auV = bVar;
            this.avf = abVar;
            this.avg = aVar;
            this.avh = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.ave = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ave == null) {
                return 0;
            }
            return this.ave.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.ave.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(r.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.c(this.ave.getChosedFiles(), i);
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
                av.k(frameLayout3, r.f.bg_add_photo);
                frameLayout3.setForeground(av.getDrawable(r.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.auV.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.avh) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(r.g.delete);
            av.c(imageView, r.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(r.j.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.auY = i;
    }

    public void setTargetToolId(int i) {
        this.auZ = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        av.l(this, r.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.ava = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.avb = " ";
        } else {
            this.avb = str;
        }
    }
}
