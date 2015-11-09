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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements x, DragHorizonScrollView.a {
    private static boolean apJ = false;
    private int KA;
    private j KB;
    private DragHorizonScrollView apK;
    private TextView apL;
    private DragLayer apM;
    private WriteImagesInfo apN;
    private com.baidu.tbadk.img.b apO;
    private b apP;
    private String apQ;
    private int apR;
    private int apS;
    private boolean apT;
    private String apU;
    private a apV;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void t(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.apQ = null;
        this.apR = 13;
        this.apS = 10;
        this.apT = false;
        this.apV = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apQ = null;
        this.apR = 13;
        this.apS = 10;
        this.apT = false;
        this.apV = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.apK = (DragHorizonScrollView) findViewById(i.f.muti_image_upload_dragscrollview);
        this.apL = (TextView) findViewById(i.f.muti_image_tips);
        this.apM = (DragLayer) findViewById(i.f.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.apQ = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.apO = bVar;
    }

    public int getImageNum() {
        return this.apN.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.apN = writeImagesInfo;
        this.apP = new b(getContext(), this.apO, this, this.apV, this.apS == 10);
        this.apP.a(this.apN);
        this.apK.a(this.apP, z);
        int maxItemNum = this.apK.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.apQ)) {
            this.apL.setText(this.apQ);
        } else if (!apJ && size > 1) {
            this.apL.setText(i.h.editor_mutiiamge_drag_tip);
            apJ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.apL.setText(getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.apP != null) {
                        this.apP.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.apS, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).apG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).apH);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(j jVar) {
        this.KB = jVar;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.KA = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.KA;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.apN != null && this.apN.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.apN.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.apK;
    }

    public TextView getMutiImageTips() {
        return this.apL;
    }

    public DragLayer getDragLayer() {
        return this.apM;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b apO;
        private WriteImagesInfo apX = null;
        private x apY;
        private a apZ;
        private boolean aqa;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, x xVar, a aVar, boolean z) {
            this.aqa = true;
            this.mContext = context;
            this.apO = bVar;
            this.apY = xVar;
            this.apZ = aVar;
            this.aqa = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.apX = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.apX == null) {
                return 0;
            }
            return this.apX.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.apX.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(i.g.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.apX.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(i.d.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(i.f.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(i.f.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(i.f.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                an.i(frameLayout3, i.e.bg_add_photo);
                frameLayout3.setForeground(an.getDrawable(i.e.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.apO.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aqa) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(i.f.delete);
            an.c(imageView, i.e.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.apR = i;
    }

    public void setTargetToolId(int i) {
        this.apS = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        an.j(this, i.c.editor_background);
    }

    public void setNeedQuit(boolean z) {
        this.apT = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.apU = " ";
        } else {
            this.apU = str;
        }
    }
}
