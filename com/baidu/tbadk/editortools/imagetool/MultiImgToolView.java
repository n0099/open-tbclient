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
    private static boolean aCQ = false;
    private i IT;
    private int IU;
    private DragHorizonScrollView aCR;
    private TextView aCS;
    private DragLayer aCT;
    private WriteImagesInfo aCU;
    private com.baidu.tbadk.img.b aCV;
    private b aCW;
    private String aCX;
    private int aCY;
    private int aCZ;
    private boolean aDa;
    private String aDb;
    private a aDc;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void M(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aCX = null;
        this.aCY = 13;
        this.aCZ = 10;
        this.aDa = false;
        this.aDc = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void M(View view) {
                if (!MultiImgToolView.this.aCR.bwP()) {
                    MultiImgToolView.this.bE(view);
                    int bF = MultiImgToolView.this.aCR.bF(view);
                    if (bF >= 0 && bF < MultiImgToolView.this.aCU.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCU.getChosedFiles().remove(bF);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCR.getMaxItemNum();
                        int size = MultiImgToolView.this.aCU.size();
                        MultiImgToolView.this.aCS.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCU.getChosedFiles().size();
                        if (MultiImgToolView.this.IT != null) {
                            MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aCY, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCZ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCZ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDa) {
                                    MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCU, true);
                                MultiImgToolView.this.aCS.setText(MultiImgToolView.this.aDb);
                                MultiImgToolView.this.IT.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCX = null;
        this.aCY = 13;
        this.aCZ = 10;
        this.aDa = false;
        this.aDc = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void M(View view) {
                if (!MultiImgToolView.this.aCR.bwP()) {
                    MultiImgToolView.this.bE(view);
                    int bF = MultiImgToolView.this.aCR.bF(view);
                    if (bF >= 0 && bF < MultiImgToolView.this.aCU.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCU.getChosedFiles().remove(bF);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCR.getMaxItemNum();
                        int size = MultiImgToolView.this.aCU.size();
                        MultiImgToolView.this.aCS.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCU.getChosedFiles().size();
                        if (MultiImgToolView.this.IT != null) {
                            MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aCY, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCZ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCZ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDa) {
                                    MultiImgToolView.this.IT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCU, true);
                                MultiImgToolView.this.aCS.setText(MultiImgToolView.this.aDb);
                                MultiImgToolView.this.IT.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aCR = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aCS = (TextView) findViewById(d.g.muti_image_tips);
        this.aCT = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aCX = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aCV = bVar;
    }

    public int getImageNum() {
        return this.aCU.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCU = writeImagesInfo;
        this.aCW = new b(getContext(), this.aCV, this, this.aDc, this.aCZ == 10);
        this.aCW.a(this.aCU);
        this.aCR.a(this.aCW, z);
        int maxItemNum = this.aCR.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aCX)) {
            this.aCS.setText(this.aCX);
        } else if (!aCQ && size > 1) {
            this.aCS.setText(d.j.editor_mutiiamge_drag_tip);
            aCQ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aCS.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aCW != null) {
                        this.aCW.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aCZ, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCN, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCO);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void G(int i, int i2) {
        if (i != i2 && this.aCU != null && this.aCU.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aCU.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aCR;
    }

    public TextView getMutiImageTips() {
        return this.aCS;
    }

    public DragLayer getDragLayer() {
        return this.aCT;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aCV;
        private WriteImagesInfo aDe = null;
        private s aDf;
        private a aDg;
        private boolean aDh;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDh = true;
            this.mContext = context;
            this.aCV = bVar;
            this.aDf = sVar;
            this.aDg = aVar;
            this.aDh = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDe = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDe == null) {
                return 0;
            }
            return this.aDe.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDe.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aDe.getChosedFiles(), i);
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
                aj.j(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(aj.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.I(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aCV.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aDh) {
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
                                l.e(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.aDf != null) {
                                b.this.aDf.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aDg != null) {
                        b.this.aDg.M(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aCY = i;
    }

    public void setTargetToolId(int i) {
        this.aCZ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.C0082d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDa = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aDb = " ";
        } else {
            this.aDb = str;
        }
    }
}
