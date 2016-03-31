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
import com.baidu.tbadk.core.util.at;
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
    private static boolean auC = false;
    private int LD;
    private l LE;
    private DragHorizonScrollView auD;
    private TextView auE;
    private DragLayer auF;
    private WriteImagesInfo auG;
    private com.baidu.tbadk.img.b auH;
    private b auI;
    private String auJ;
    private int auK;
    private int auL;
    private boolean auM;
    private String auN;
    private a auO;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void I(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.auJ = null;
        this.auK = 13;
        this.auL = 10;
        this.auM = false;
        this.auO = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auJ = null;
        this.auK = 13;
        this.auL = 10;
        this.auM = false;
        this.auO = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.auD = (DragHorizonScrollView) findViewById(t.g.muti_image_upload_dragscrollview);
        this.auE = (TextView) findViewById(t.g.muti_image_tips);
        this.auF = (DragLayer) findViewById(t.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.auJ = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.auH = bVar;
    }

    public int getImageNum() {
        return this.auG.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.auG = writeImagesInfo;
        this.auI = new b(getContext(), this.auH, this, this.auO, this.auL == 10);
        this.auI.a(this.auG);
        this.auD.a(this.auI, z);
        int maxItemNum = this.auD.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.auJ)) {
            this.auE.setText(this.auJ);
        } else if (!auC && size > 1) {
            this.auE.setText(t.j.editor_mutiiamge_drag_tip);
            auC = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.auE.setText(getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.auI != null) {
                        this.auI.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.auL, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auz, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auA);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auz, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auA);
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
        this.LE = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void op() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void B(int i, int i2) {
        if (i != i2 && this.auG != null && this.auG.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.auG.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.auD;
    }

    public TextView getMutiImageTips() {
        return this.auE;
    }

    public DragLayer getDragLayer() {
        return this.auF;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b auH;
        private WriteImagesInfo auQ = null;
        private ab auR;
        private a auS;
        private boolean auT;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.auT = true;
            this.mContext = context;
            this.auH = bVar;
            this.auR = abVar;
            this.auS = aVar;
            this.auT = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.auQ = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.auQ == null) {
                return 0;
            }
            return this.auQ.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.auQ.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(t.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.auQ.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(t.e.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(t.e.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(t.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(t.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(t.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                at.k(frameLayout3, t.f.bg_add_photo);
                frameLayout3.setForeground(at.getDrawable(t.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.auH.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.auT) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(t.g.delete);
            at.c(imageView, t.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(t.j.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.auK = i;
    }

    public void setTargetToolId(int i) {
        this.auL = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        at.l(this, t.d.editor_background);
    }

    public void setNeedQuit(boolean z) {
        this.auM = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.auN = " ";
        } else {
            this.auN = str;
        }
    }
}
