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
    private static boolean aUX = false;
    private EditorTools SY;
    private int SZ;
    private DragHorizonScrollView aUY;
    private TextView aUZ;
    private DragLayer aVa;
    private WriteImagesInfo aVb;
    private com.baidu.tbadk.img.b aVc;
    private b aVd;
    private String aVe;
    private int aVf;
    private int aVg;
    private boolean aVh;
    private String aVi;
    private a aVj;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void ab(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aVe = null;
        this.aVf = 13;
        this.aVg = 10;
        this.aVh = false;
        this.aVj = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aUY.bCA()) {
                    MultiImgToolView.this.bO(view);
                    int bP = MultiImgToolView.this.aUY.bP(view);
                    if (bP >= 0 && bP < MultiImgToolView.this.aVb.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aVb.getChosedFiles().remove(bP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aUY.getMaxItemNum();
                        int size = MultiImgToolView.this.aVb.size();
                        MultiImgToolView.this.aUZ.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aVb.getChosedFiles().size();
                        if (MultiImgToolView.this.SY != null) {
                            MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aVf, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aVg, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aVg, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aVh) {
                                    MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aVb, true);
                                MultiImgToolView.this.aUZ.setText(MultiImgToolView.this.aVi);
                                MultiImgToolView.this.SY.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVe = null;
        this.aVf = 13;
        this.aVg = 10;
        this.aVh = false;
        this.aVj = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aUY.bCA()) {
                    MultiImgToolView.this.bO(view);
                    int bP = MultiImgToolView.this.aUY.bP(view);
                    if (bP >= 0 && bP < MultiImgToolView.this.aVb.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aVb.getChosedFiles().remove(bP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aUY.getMaxItemNum();
                        int size = MultiImgToolView.this.aVb.size();
                        MultiImgToolView.this.aUZ.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aVb.getChosedFiles().size();
                        if (MultiImgToolView.this.SY != null) {
                            MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aVf, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aVg, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aVg, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aVh) {
                                    MultiImgToolView.this.SY.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aVb, true);
                                MultiImgToolView.this.aUZ.setText(MultiImgToolView.this.aVi);
                                MultiImgToolView.this.SY.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aUY = (DragHorizonScrollView) findViewById(e.g.muti_image_upload_dragscrollview);
        this.aUZ = (TextView) findViewById(e.g.muti_image_tips);
        this.aVa = (DragLayer) findViewById(e.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aVe = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aVc = bVar;
    }

    public int getImageNum() {
        return this.aVb.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aVb = writeImagesInfo;
        this.aVd = new b(getContext(), this.aVc, this, this.aVj, this.aVg == 10);
        this.aVd.a(this.aVb);
        this.aUY.setAdapter(this.aVd, z);
        int maxItemNum = this.aUY.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aVe)) {
            this.aUZ.setText(this.aVe);
        } else if (!aUX && size > 1) {
            this.aUZ.setText(e.j.editor_mutiiamge_drag_tip);
            aUX = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aUZ.setText(getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aVd != null) {
                        this.aVd.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aVg, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aUU, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aUV);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.aVb != null && this.aVb.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aVb.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aUY;
    }

    public TextView getMutiImageTips() {
        return this.aUZ;
    }

    public DragLayer getDragLayer() {
        return this.aVa;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aVc;
        private WriteImagesInfo aVl = null;
        private l aVm;
        private a aVn;
        private boolean aVo;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aVo = true;
            this.mContext = context;
            this.aVc = bVar;
            this.aVm = lVar;
            this.aVn = aVar;
            this.aVo = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aVl = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aVl == null) {
                return 0;
            }
            return this.aVl.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aVl.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(e.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.aVl.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds32);
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
                if (this.aVc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aVo) {
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
                            } else if (b.this.aVm != null) {
                                b.this.aVm.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aVn != null) {
                        b.this.aVn.ab(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(e.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aVf = i;
    }

    public void setTargetToolId(int i) {
        this.aVg = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aVh = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aVi = " ";
        } else {
            this.aVi = str;
        }
    }
}
