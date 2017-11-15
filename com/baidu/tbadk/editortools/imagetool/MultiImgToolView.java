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
    private static boolean aCn = false;
    private int Ja;
    private i Jb;
    private DragHorizonScrollView aCo;
    private TextView aCp;
    private DragLayer aCq;
    private WriteImagesInfo aCr;
    private com.baidu.tbadk.img.b aCs;
    private b aCt;
    private String aCu;
    private int aCv;
    private int aCw;
    private boolean aCx;
    private String aCy;
    private a aCz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void M(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aCu = null;
        this.aCv = 13;
        this.aCw = 10;
        this.aCx = false;
        this.aCz = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void M(View view) {
                if (!MultiImgToolView.this.aCo.bvf()) {
                    MultiImgToolView.this.bJ(view);
                    int bK = MultiImgToolView.this.aCo.bK(view);
                    if (bK >= 0 && bK < MultiImgToolView.this.aCr.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCr.getChosedFiles().remove(bK);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCo.getMaxItemNum();
                        int size = MultiImgToolView.this.aCr.size();
                        MultiImgToolView.this.aCp.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCr.getChosedFiles().size();
                        if (MultiImgToolView.this.Jb != null) {
                            MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aCv, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCw, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCw, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aCx) {
                                    MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCr, true);
                                MultiImgToolView.this.aCp.setText(MultiImgToolView.this.aCy);
                                MultiImgToolView.this.Jb.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCu = null;
        this.aCv = 13;
        this.aCw = 10;
        this.aCx = false;
        this.aCz = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void M(View view) {
                if (!MultiImgToolView.this.aCo.bvf()) {
                    MultiImgToolView.this.bJ(view);
                    int bK = MultiImgToolView.this.aCo.bK(view);
                    if (bK >= 0 && bK < MultiImgToolView.this.aCr.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCr.getChosedFiles().remove(bK);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCo.getMaxItemNum();
                        int size = MultiImgToolView.this.aCr.size();
                        MultiImgToolView.this.aCp.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCr.getChosedFiles().size();
                        if (MultiImgToolView.this.Jb != null) {
                            MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aCv, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCw, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCw, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aCx) {
                                    MultiImgToolView.this.Jb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCr, true);
                                MultiImgToolView.this.aCp.setText(MultiImgToolView.this.aCy);
                                MultiImgToolView.this.Jb.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aCo = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aCp = (TextView) findViewById(d.g.muti_image_tips);
        this.aCq = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aCu = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aCs = bVar;
    }

    public int getImageNum() {
        return this.aCr.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCr = writeImagesInfo;
        this.aCt = new b(getContext(), this.aCs, this, this.aCz, this.aCw == 10);
        this.aCt.a(this.aCr);
        this.aCo.a(this.aCt, z);
        int maxItemNum = this.aCo.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aCu)) {
            this.aCp.setText(this.aCu);
        } else if (!aCn && size > 1) {
            this.aCp.setText(d.j.editor_mutiiamge_drag_tip);
            aCn = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aCp.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aCt != null) {
                        this.aCt.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aCw, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCk, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCl);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.aCr != null && this.aCr.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aCr.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aCo;
    }

    public TextView getMutiImageTips() {
        return this.aCp;
    }

    public DragLayer getDragLayer() {
        return this.aCq;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo aCB = null;
        private s aCC;
        private a aCD;
        private boolean aCE;
        private com.baidu.tbadk.img.b aCs;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aCE = true;
            this.mContext = context;
            this.aCs = bVar;
            this.aCC = sVar;
            this.aCD = aVar;
            this.aCE = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aCB = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aCB == null) {
                return 0;
            }
            return this.aCB.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aCB.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aCB.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aCs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aCE) {
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
                            } else if (b.this.aCC != null) {
                                b.this.aCC.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aCD != null) {
                        b.this.aCD.M(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aCv = i;
    }

    public void setTargetToolId(int i) {
        this.aCw = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.C0080d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aCx = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aCy = " ";
        } else {
            this.aCy = str;
        }
    }
}
