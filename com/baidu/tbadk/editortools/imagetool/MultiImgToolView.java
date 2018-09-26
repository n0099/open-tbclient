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
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean aQw = false;
    private EditorTools SG;
    private int SH;
    private WriteImagesInfo aQA;
    private com.baidu.tbadk.img.b aQB;
    private b aQC;
    private String aQD;
    private int aQE;
    private int aQF;
    private boolean aQG;
    private String aQH;
    private a aQI;
    private DragHorizonScrollView aQx;
    private TextView aQy;
    private DragLayer aQz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void ab(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aQD = null;
        this.aQE = 13;
        this.aQF = 10;
        this.aQG = false;
        this.aQI = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aQx.bzl()) {
                    MultiImgToolView.this.bO(view);
                    int bP = MultiImgToolView.this.aQx.bP(view);
                    if (bP >= 0 && bP < MultiImgToolView.this.aQA.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aQA.getChosedFiles().remove(bP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hl().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aQx.getMaxItemNum();
                        int size = MultiImgToolView.this.aQA.size();
                        MultiImgToolView.this.aQy.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aQA.getChosedFiles().size();
                        if (MultiImgToolView.this.SG != null) {
                            MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aQE, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aQF, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aQF, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aQG) {
                                    MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aQA, true);
                                MultiImgToolView.this.aQy.setText(MultiImgToolView.this.aQH);
                                MultiImgToolView.this.SG.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQD = null;
        this.aQE = 13;
        this.aQF = 10;
        this.aQG = false;
        this.aQI = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aQx.bzl()) {
                    MultiImgToolView.this.bO(view);
                    int bP = MultiImgToolView.this.aQx.bP(view);
                    if (bP >= 0 && bP < MultiImgToolView.this.aQA.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aQA.getChosedFiles().remove(bP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hl().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aQx.getMaxItemNum();
                        int size = MultiImgToolView.this.aQA.size();
                        MultiImgToolView.this.aQy.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aQA.getChosedFiles().size();
                        if (MultiImgToolView.this.SG != null) {
                            MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aQE, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aQF, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aQF, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aQG) {
                                    MultiImgToolView.this.SG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aQA, true);
                                MultiImgToolView.this.aQy.setText(MultiImgToolView.this.aQH);
                                MultiImgToolView.this.SG.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aQx = (DragHorizonScrollView) findViewById(e.g.muti_image_upload_dragscrollview);
        this.aQy = (TextView) findViewById(e.g.muti_image_tips);
        this.aQz = (DragLayer) findViewById(e.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aQD = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aQB = bVar;
    }

    public int getImageNum() {
        return this.aQA.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aQA = writeImagesInfo;
        this.aQC = new b(getContext(), this.aQB, this, this.aQI, this.aQF == 10);
        this.aQC.a(this.aQA);
        this.aQx.setAdapter(this.aQC, z);
        int maxItemNum = this.aQx.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aQD)) {
            this.aQy.setText(this.aQD);
        } else if (!aQw && size > 1) {
            this.aQy.setText(e.j.editor_mutiiamge_drag_tip);
            aQw = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aQy.setText(getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aQC != null) {
                        this.aQC.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aQF, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aQt, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aQu);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.aQA != null && this.aQA.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aQA.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aQx;
    }

    public TextView getMutiImageTips() {
        return this.aQy;
    }

    public DragLayer getDragLayer() {
        return this.aQz;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aQB;
        private WriteImagesInfo aQK = null;
        private l aQL;
        private a aQM;
        private boolean aQN;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aQN = true;
            this.mContext = context;
            this.aQB = bVar;
            this.aQL = lVar;
            this.aQM = aVar;
            this.aQN = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aQK = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aQK == null) {
                return 0;
            }
            return this.aQK.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aQK.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(e.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.aQK.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(e.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(e.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(e.g.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                al.i(frameLayout3, e.f.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(e.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aQB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
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
            if (this.aQN) {
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
                                com.baidu.adp.lib.util.l.g(b.this.mContext, e.j.editor_mutiiamge_image_error);
                            } else if (b.this.aQL != null) {
                                b.this.aQL.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(e.g.delete);
            al.c(imageView, e.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.aQM != null) {
                        b.this.aQM.ab(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(e.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aQE = i;
    }

    public void setTargetToolId(int i) {
        this.aQF = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aQG = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aQH = " ";
        } else {
            this.aQH = str;
        }
    }
}
