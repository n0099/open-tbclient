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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements w, DragHorizonScrollView.a {
    private int Ky;
    private j Kz;
    private DragHorizonScrollView asJ;
    private TextView asK;
    private DragLayer asL;
    private WriteImagesInfo asM;
    private com.baidu.tbadk.img.b asN;
    private b asO;
    private String asP;
    private int asQ;
    private int asR;
    private a asS;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void t(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.asP = null;
        this.asQ = 13;
        this.asR = 10;
        this.asS = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asP = null;
        this.asQ = 13;
        this.asR = 10;
        this.asS = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.asJ = (DragHorizonScrollView) findViewById(i.f.muti_image_upload_dragscrollview);
        this.asK = (TextView) findViewById(i.f.muti_image_tips);
        this.asL = (DragLayer) findViewById(i.f.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.asP = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.asN = bVar;
    }

    public int getImageNum() {
        return this.asM.getChosedFiles().size();
    }

    private void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.asM = writeImagesInfo;
        this.asO = new b(getContext(), this.asN, this, this.asS, this.asR == 10);
        this.asO.a(this.asM);
        this.asJ.a(this.asO, z);
        int maxItemNum = this.asJ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.asP)) {
            this.asK.setText(this.asP);
        } else if (!ah.atM().atN() && size > 1) {
            this.asK.setText(i.h.editor_mutiiamge_drag_tip);
            ah.atM().gi(true);
        } else {
            this.asK.setText(getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.asO != null) {
                        this.asO.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.asR, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).asG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).asH);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ov() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.asM != null && this.asM.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.asM.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.asJ;
    }

    public TextView getMutiImageTips() {
        return this.asK;
    }

    public DragLayer getDragLayer() {
        return this.asL;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b asN;
        private WriteImagesInfo asU = null;
        private w asV;
        private a asW;
        private boolean asX;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, w wVar, a aVar, boolean z) {
            this.asX = true;
            this.mContext = context;
            this.asN = bVar;
            this.asV = wVar;
            this.asW = aVar;
            this.asX = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.asU = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.asU == null) {
                return 0;
            }
            return this.asU.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.asU.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(i.g.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.asU.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(i.d.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(i.f.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(i.f.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(i.f.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                al.h(frameLayout3, i.e.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(i.e.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.asN.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.asX) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(i.f.delete);
            al.c(imageView, i.e.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.asQ = i;
    }

    public void setTargetToolId(int i) {
        this.asR = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        al.i(this, i.c.editor_background);
    }
}
