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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean cjz = false;
    private EditorTools VN;
    private int VO;
    private DragHorizonScrollView cjA;
    private TextView cjB;
    private DragLayer cjC;
    private WriteImagesInfo cjD;
    private com.baidu.tbadk.img.b cjE;
    private b cjF;
    private String cjG;
    private int cjH;
    private int cjI;
    private boolean cjJ;
    private String cjK;
    private a cjL;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void aW(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.cjG = null;
        this.cjH = 13;
        this.cjI = 10;
        this.cjJ = false;
        this.cjL = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void aW(View view) {
                if (!MultiImgToolView.this.cjA.ceP()) {
                    MultiImgToolView.this.cG(view);
                    int cH = MultiImgToolView.this.cjA.cH(view);
                    if (cH >= 0 && cH < MultiImgToolView.this.cjD.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cjD.getChosedFiles().remove(cH);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cjA.getMaxItemNum();
                        int size = MultiImgToolView.this.cjD.size();
                        MultiImgToolView.this.cjB.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cjD.getChosedFiles().size();
                        if (MultiImgToolView.this.VN != null) {
                            MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cjH, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjI, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjI, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cjJ) {
                                    MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cjD, true);
                                MultiImgToolView.this.cjB.setText(MultiImgToolView.this.cjK);
                                MultiImgToolView.this.VN.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjG = null;
        this.cjH = 13;
        this.cjI = 10;
        this.cjJ = false;
        this.cjL = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void aW(View view) {
                if (!MultiImgToolView.this.cjA.ceP()) {
                    MultiImgToolView.this.cG(view);
                    int cH = MultiImgToolView.this.cjA.cH(view);
                    if (cH >= 0 && cH < MultiImgToolView.this.cjD.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cjD.getChosedFiles().remove(cH);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cjA.getMaxItemNum();
                        int size = MultiImgToolView.this.cjD.size();
                        MultiImgToolView.this.cjB.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cjD.getChosedFiles().size();
                        if (MultiImgToolView.this.VN != null) {
                            MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cjH, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjI, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjI, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cjJ) {
                                    MultiImgToolView.this.VN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cjD, true);
                                MultiImgToolView.this.cjB.setText(MultiImgToolView.this.cjK);
                                MultiImgToolView.this.VN.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cjA = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.cjB = (TextView) findViewById(d.g.muti_image_tips);
        this.cjC = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.cjG = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.cjE = bVar;
    }

    public int getImageNum() {
        return this.cjD.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.cjD = writeImagesInfo;
        this.cjF = new b(getContext(), this.cjE, this, this.cjL, this.cjI == 10);
        this.cjF.a(this.cjD);
        this.cjA.setAdapter(this.cjF, z);
        int maxItemNum = this.cjA.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.cjG)) {
            this.cjB.setText(this.cjG);
        } else if (!cjz && size > 1) {
            this.cjB.setText(d.j.editor_mutiiamge_drag_tip);
            cjz = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.cjB.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.cjF != null) {
                        this.cjF.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.cjI, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cjw, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cjx);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void ag(int i, int i2) {
        if (i != i2 && this.cjD != null && this.cjD.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cjD.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.cjA;
    }

    public TextView getMutiImageTips() {
        return this.cjB;
    }

    public DragLayer getDragLayer() {
        return this.cjC;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b cjE;
        private WriteImagesInfo cjN = null;
        private l cjO;
        private a cjP;
        private boolean cjQ;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.cjQ = true;
            this.mContext = context;
            this.cjE = bVar;
            this.cjO = lVar;
            this.cjP = aVar;
            this.cjQ = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.cjN = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cjN == null) {
                return 0;
            }
            return this.cjN.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.cjN.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.cjN.getChosedFiles(), i);
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
                al.k(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.ai(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.cjE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.cjQ) {
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
                                com.baidu.adp.lib.util.l.g(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.cjO != null) {
                                b.this.cjO.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.g.delete);
            al.c(imageView, d.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.cjP != null) {
                        b.this.cjP.aW(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.cjH = i;
    }

    public void setTargetToolId(int i) {
        this.cjI = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.l(this, d.C0277d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.cjJ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.cjK = " ";
        } else {
            this.cjK = str;
        }
    }
}
