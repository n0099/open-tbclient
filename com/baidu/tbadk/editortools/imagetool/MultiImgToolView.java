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
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements z, DragHorizonScrollView.a {
    private static boolean arG = false;
    private int KR;
    private k KS;
    private DragHorizonScrollView arH;
    private TextView arI;
    private DragLayer arJ;
    private WriteImagesInfo arK;
    private com.baidu.tbadk.img.b arL;
    private b arM;
    private String arN;
    private int arO;
    private int arP;
    private boolean arQ;
    private String arR;
    private a arS;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void u(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.arN = null;
        this.arO = 13;
        this.arP = 10;
        this.arQ = false;
        this.arS = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arN = null;
        this.arO = 13;
        this.arP = 10;
        this.arQ = false;
        this.arS = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.arH = (DragHorizonScrollView) findViewById(n.f.muti_image_upload_dragscrollview);
        this.arI = (TextView) findViewById(n.f.muti_image_tips);
        this.arJ = (DragLayer) findViewById(n.f.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.arN = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.arL = bVar;
    }

    public int getImageNum() {
        return this.arK.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.arK = writeImagesInfo;
        this.arM = new b(getContext(), this.arL, this, this.arS, this.arP == 10);
        this.arM.a(this.arK);
        this.arH.a(this.arM, z);
        int maxItemNum = this.arH.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.arN)) {
            this.arI.setText(this.arN);
        } else if (!arG && size > 1) {
            this.arI.setText(n.i.editor_mutiiamge_drag_tip);
            arG = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.arI.setText(getResources().getString(n.i.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.arM != null) {
                        this.arM.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.arP, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).arD, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).arE);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.KS = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.arK != null && this.arK.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.arK.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.arH;
    }

    public TextView getMutiImageTips() {
        return this.arI;
    }

    public DragLayer getDragLayer() {
        return this.arJ;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b arL;
        private WriteImagesInfo arU = null;
        private z arV;
        private a arW;
        private boolean arX;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, z zVar, a aVar, boolean z) {
            this.arX = true;
            this.mContext = context;
            this.arL = bVar;
            this.arV = zVar;
            this.arW = aVar;
            this.arX = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.arU = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.arU == null) {
                return 0;
            }
            return this.arU.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.arU.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(n.g.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.arU.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(n.d.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(n.d.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(n.f.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(n.f.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(n.f.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                as.i(frameLayout3, n.e.bg_add_photo);
                frameLayout3.setForeground(as.getDrawable(n.e.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.arL.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.arX) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(n.f.delete);
            as.c(imageView, n.e.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.arO = i;
    }

    public void setTargetToolId(int i) {
        this.arP = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        as.j(this, n.c.editor_background);
    }

    public void setNeedQuit(boolean z) {
        this.arQ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.arR = " ";
        } else {
            this.arR = str;
        }
    }
}
