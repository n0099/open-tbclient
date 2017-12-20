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
    private static boolean aCV = false;
    private i IR;
    private int IS;
    private DragHorizonScrollView aCW;
    private TextView aCX;
    private DragLayer aCY;
    private WriteImagesInfo aCZ;
    private com.baidu.tbadk.img.b aDa;
    private b aDb;
    private String aDc;
    private int aDd;
    private int aDe;
    private boolean aDf;
    private String aDg;
    private a aDh;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void N(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aDc = null;
        this.aDd = 13;
        this.aDe = 10;
        this.aDf = false;
        this.aDh = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view) {
                if (!MultiImgToolView.this.aCW.bxv()) {
                    MultiImgToolView.this.bI(view);
                    int bJ = MultiImgToolView.this.aCW.bJ(view);
                    if (bJ >= 0 && bJ < MultiImgToolView.this.aCZ.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCZ.getChosedFiles().remove(bJ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCW.getMaxItemNum();
                        int size = MultiImgToolView.this.aCZ.size();
                        MultiImgToolView.this.aCX.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCZ.getChosedFiles().size();
                        if (MultiImgToolView.this.IR != null) {
                            MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDd, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDe, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDe, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDf) {
                                    MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCZ, true);
                                MultiImgToolView.this.aCX.setText(MultiImgToolView.this.aDg);
                                MultiImgToolView.this.IR.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDc = null;
        this.aDd = 13;
        this.aDe = 10;
        this.aDf = false;
        this.aDh = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view) {
                if (!MultiImgToolView.this.aCW.bxv()) {
                    MultiImgToolView.this.bI(view);
                    int bJ = MultiImgToolView.this.aCW.bJ(view);
                    if (bJ >= 0 && bJ < MultiImgToolView.this.aCZ.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCZ.getChosedFiles().remove(bJ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCW.getMaxItemNum();
                        int size = MultiImgToolView.this.aCZ.size();
                        MultiImgToolView.this.aCX.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCZ.getChosedFiles().size();
                        if (MultiImgToolView.this.IR != null) {
                            MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDd, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDe, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDe, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDf) {
                                    MultiImgToolView.this.IR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCZ, true);
                                MultiImgToolView.this.aCX.setText(MultiImgToolView.this.aDg);
                                MultiImgToolView.this.IR.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aCW = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aCX = (TextView) findViewById(d.g.muti_image_tips);
        this.aCY = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aDc = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDa = bVar;
    }

    public int getImageNum() {
        return this.aCZ.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCZ = writeImagesInfo;
        this.aDb = new b(getContext(), this.aDa, this, this.aDh, this.aDe == 10);
        this.aDb.a(this.aCZ);
        this.aCW.a(this.aDb, z);
        int maxItemNum = this.aCW.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aDc)) {
            this.aCX.setText(this.aDc);
        } else if (!aCV && size > 1) {
            this.aCX.setText(d.j.editor_mutiiamge_drag_tip);
            aCV = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aCX.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aDb != null) {
                        this.aDb.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDe, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCS, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCT);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IR = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IS;
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
    public void H(int i, int i2) {
        if (i != i2 && this.aCZ != null && this.aCZ.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aCZ.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aCW;
    }

    public TextView getMutiImageTips() {
        return this.aCX;
    }

    public DragLayer getDragLayer() {
        return this.aCY;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDa;
        private WriteImagesInfo aDj = null;
        private s aDk;
        private a aDl;
        private boolean aDm;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDm = true;
            this.mContext = context;
            this.aDa = bVar;
            this.aDk = sVar;
            this.aDl = aVar;
            this.aDm = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDj = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDj == null) {
                return 0;
            }
            return this.aDj.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDj.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aDj.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aDa.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aDm) {
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
                            } else if (b.this.aDk != null) {
                                b.this.aDk.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aDl != null) {
                        b.this.aDl.N(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aDd = i;
    }

    public void setTargetToolId(int i) {
        this.aDe = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.C0096d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDf = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aDg = " ";
        } else {
            this.aDg = str;
        }
    }
}
