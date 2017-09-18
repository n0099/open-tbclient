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
import com.baidu.adp.lib.util.k;
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
    private static boolean aCp = false;
    private int Jo;
    private i Jp;
    private String aCA;
    private a aCB;
    private DragHorizonScrollView aCq;
    private TextView aCr;
    private DragLayer aCs;
    private WriteImagesInfo aCt;
    private com.baidu.tbadk.img.b aCu;
    private b aCv;
    private String aCw;
    private int aCx;
    private int aCy;
    private boolean aCz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void L(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aCw = null;
        this.aCx = 13;
        this.aCy = 10;
        this.aCz = false;
        this.aCB = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void L(View view) {
                if (!MultiImgToolView.this.aCq.bsY()) {
                    MultiImgToolView.this.bF(view);
                    int bG = MultiImgToolView.this.aCq.bG(view);
                    if (bG >= 0 && bG < MultiImgToolView.this.aCt.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCt.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCq.getMaxItemNum();
                        int size = MultiImgToolView.this.aCt.size();
                        MultiImgToolView.this.aCr.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCt.getChosedFiles().size();
                        if (MultiImgToolView.this.Jp != null) {
                            MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aCx, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCy, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCy, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aCz) {
                                    MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCt, true);
                                MultiImgToolView.this.aCr.setText(MultiImgToolView.this.aCA);
                                MultiImgToolView.this.Jp.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCw = null;
        this.aCx = 13;
        this.aCy = 10;
        this.aCz = false;
        this.aCB = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void L(View view) {
                if (!MultiImgToolView.this.aCq.bsY()) {
                    MultiImgToolView.this.bF(view);
                    int bG = MultiImgToolView.this.aCq.bG(view);
                    if (bG >= 0 && bG < MultiImgToolView.this.aCt.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aCt.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCq.getMaxItemNum();
                        int size = MultiImgToolView.this.aCt.size();
                        MultiImgToolView.this.aCr.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aCt.getChosedFiles().size();
                        if (MultiImgToolView.this.Jp != null) {
                            MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aCx, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCy, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aCy, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aCz) {
                                    MultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aCt, true);
                                MultiImgToolView.this.aCr.setText(MultiImgToolView.this.aCA);
                                MultiImgToolView.this.Jp.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aCq = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aCr = (TextView) findViewById(d.h.muti_image_tips);
        this.aCs = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aCw = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aCu = bVar;
    }

    public int getImageNum() {
        return this.aCt.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCt = writeImagesInfo;
        this.aCv = new b(getContext(), this.aCu, this, this.aCB, this.aCy == 10);
        this.aCv.a(this.aCt);
        this.aCq.a(this.aCv, z);
        int maxItemNum = this.aCq.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aCw)) {
            this.aCr.setText(this.aCw);
        } else if (!aCp && size > 1) {
            this.aCr.setText(d.l.editor_mutiiamge_drag_tip);
            aCp = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aCr.setText(getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aCv != null) {
                        this.aCv.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aCy, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCm, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCn);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.aCt != null && this.aCt.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aCt.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aCq;
    }

    public TextView getMutiImageTips() {
        return this.aCr;
    }

    public DragLayer getDragLayer() {
        return this.aCs;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo aCD = null;
        private s aCE;
        private a aCF;
        private boolean aCG;
        private com.baidu.tbadk.img.b aCu;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aCG = true;
            this.mContext = context;
            this.aCu = bVar;
            this.aCE = sVar;
            this.aCF = aVar;
            this.aCG = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aCD = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aCD == null) {
                return 0;
            }
            return this.aCD.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aCD.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aCD.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.h.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.h.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.h.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                aj.j(frameLayout3, d.g.bg_add_photo);
                frameLayout3.setForeground(aj.getDrawable(d.g.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aCu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aCG) {
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
                                k.e(b.this.mContext, d.l.editor_mutiiamge_image_error);
                            } else if (b.this.aCE != null) {
                                b.this.aCE.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.h.delete);
            aj.c(imageView, d.g.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.aCF != null) {
                        b.this.aCF.L(frameLayout2);
                    }
                }
            });
            View findViewById = frameLayout2.findViewById(d.h.gif_icon);
            if (imageFileInfo.isGif() && !imageFileInfo.hasActionsWithoutResize()) {
                findViewById.setVisibility(0);
                aj.j(findViewById, d.g.ic_image_gif);
            } else {
                findViewById.setVisibility(8);
            }
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.l.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aCx = i;
    }

    public void setTargetToolId(int i) {
        this.aCy = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aCz = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aCA = " ";
        } else {
            this.aCA = str;
        }
    }
}
