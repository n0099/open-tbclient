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
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements s, DragHorizonScrollView.a {
    private static boolean btz = false;
    private i axP;
    private int axQ;
    private DragHorizonScrollView btA;
    private TextView btB;
    private DragLayer btC;
    private WriteImagesInfo btD;
    private com.baidu.tbadk.img.b btE;
    private b btF;
    private String btG;
    private int btH;
    private int btI;
    private boolean btJ;
    private String btK;
    private a btL;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bi(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.btG = null;
        this.btH = 13;
        this.btI = 10;
        this.btJ = false;
        this.btL = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.btA.bxt()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.btA.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.btD.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.btD.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.btA.getMaxItemNum();
                        int size = MultiImgToolView.this.btD.size();
                        MultiImgToolView.this.btB.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.btD.getChosedFiles().size();
                        if (MultiImgToolView.this.axP != null) {
                            MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.btH, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btI, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btI, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.btJ) {
                                    MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.btD, true);
                                MultiImgToolView.this.btB.setText(MultiImgToolView.this.btK);
                                MultiImgToolView.this.axP.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btG = null;
        this.btH = 13;
        this.btI = 10;
        this.btJ = false;
        this.btL = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.btA.bxt()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.btA.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.btD.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.btD.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.btA.getMaxItemNum();
                        int size = MultiImgToolView.this.btD.size();
                        MultiImgToolView.this.btB.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.btD.getChosedFiles().size();
                        if (MultiImgToolView.this.axP != null) {
                            MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.btH, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btI, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btI, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.btJ) {
                                    MultiImgToolView.this.axP.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.btD, true);
                                MultiImgToolView.this.btB.setText(MultiImgToolView.this.btK);
                                MultiImgToolView.this.axP.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.btA = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.btB = (TextView) findViewById(d.g.muti_image_tips);
        this.btC = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.btG = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.btE = bVar;
    }

    public int getImageNum() {
        return this.btD.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.btD = writeImagesInfo;
        this.btF = new b(getContext(), this.btE, this, this.btL, this.btI == 10);
        this.btF.a(this.btD);
        this.btA.a(this.btF, z);
        int maxItemNum = this.btA.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.btG)) {
            this.btB.setText(this.btG);
        } else if (!btz && size > 1) {
            this.btB.setText(d.j.editor_mutiiamge_drag_tip);
            btz = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.btB.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            String str = size + "";
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.btF != null) {
                        this.btF.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.btI, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).btw, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).btx);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aG(int i, int i2) {
        if (i != i2 && this.btD != null && this.btD.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.btD.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.btA;
    }

    public TextView getMutiImageTips() {
        return this.btB;
    }

    public DragLayer getDragLayer() {
        return this.btC;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b btE;
        private WriteImagesInfo btN = null;
        private s btO;
        private a btP;
        private boolean btQ;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.btQ = true;
            this.mContext = context;
            this.btE = bVar;
            this.btO = sVar;
            this.btP = aVar;
            this.btQ = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.btN = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.btN == null) {
                return 0;
            }
            return this.btN.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.btN.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.btN.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.e.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.g.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                aj.s(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(aj.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aI(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.btE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView2 != null && aVar != null) {
                            tbImageView2.invalidate();
                        }
                    }
                }, true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.btQ) {
                frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        boolean z;
                        int indexOfChild = viewGroup.indexOfChild(view2);
                        if (indexOfChild >= 0) {
                            ImageFileInfo imageFileInfo2 = (ImageFileInfo) b.this.getItem(indexOfChild);
                            if (imageFileInfo2 == null) {
                                z = false;
                            } else {
                                z = new File(imageFileInfo2.getFilePath()).exists();
                            }
                            if (!z) {
                                l.s(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.btO != null) {
                                b.this.btO.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.g.delete);
            aj.c(imageView, d.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.btP != null) {
                        b.this.btP.bi(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.btH = i;
    }

    public void setTargetToolId(int i) {
        this.btI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.t(this, d.C0140d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.btJ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.btK = " ";
        } else {
            this.btK = str;
        }
    }
}
