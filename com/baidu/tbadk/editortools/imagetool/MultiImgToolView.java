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
    private static boolean aqB = false;
    private int BU;
    private l BV;
    private DragHorizonScrollView aqC;
    private TextView aqD;
    private DragLayer aqE;
    private WriteImagesInfo aqF;
    private com.baidu.tbadk.img.b aqG;
    private b aqH;
    private String aqI;
    private int aqJ;
    private int aqK;
    private boolean aqL;
    private String aqM;
    private a aqN;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void J(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aqI = null;
        this.aqJ = 13;
        this.aqK = 10;
        this.aqL = false;
        this.aqN = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqI = null;
        this.aqJ = 13;
        this.aqK = 10;
        this.aqL = false;
        this.aqN = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aqC = (DragHorizonScrollView) findViewById(t.g.muti_image_upload_dragscrollview);
        this.aqD = (TextView) findViewById(t.g.muti_image_tips);
        this.aqE = (DragLayer) findViewById(t.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aqI = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aqG = bVar;
    }

    public int getImageNum() {
        return this.aqF.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aqF = writeImagesInfo;
        this.aqH = new b(getContext(), this.aqG, this, this.aqN, this.aqK == 10);
        this.aqH.a(this.aqF);
        this.aqC.a(this.aqH, z);
        int maxItemNum = this.aqC.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aqI)) {
            this.aqD.setText(this.aqI);
        } else if (!aqB && size > 1) {
            this.aqD.setText(t.j.editor_mutiiamge_drag_tip);
            aqB = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aqD.setText(getResources().getString(t.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aqH != null) {
                        this.aqH.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aqK, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aqy, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aqz);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aqy, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aqz);
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
        this.BV = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void B(int i, int i2) {
        if (i != i2 && this.aqF != null && this.aqF.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aqF.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aqC;
    }

    public TextView getMutiImageTips() {
        return this.aqD;
    }

    public DragLayer getDragLayer() {
        return this.aqE;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aqG;
        private WriteImagesInfo aqP = null;
        private ab aqQ;
        private a aqR;
        private boolean aqS;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.aqS = true;
            this.mContext = context;
            this.aqG = bVar;
            this.aqQ = abVar;
            this.aqR = aVar;
            this.aqS = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aqP = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aqP == null) {
                return 0;
            }
            return this.aqP.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aqP.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(t.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.c(this.aqP.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
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
                if (this.aqG.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aqS) {
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
        this.aqJ = i;
    }

    public void setTargetToolId(int i) {
        this.aqK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        at.l(this, t.d.editor_background);
    }

    public void setNeedQuit(boolean z) {
        this.aqL = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aqM = " ";
        } else {
            this.aqM = str;
        }
    }
}
