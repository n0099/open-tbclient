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
    private static boolean cjA = false;
    private EditorTools VO;
    private int VP;
    private DragHorizonScrollView cjB;
    private TextView cjC;
    private DragLayer cjD;
    private WriteImagesInfo cjE;
    private com.baidu.tbadk.img.b cjF;
    private b cjG;
    private String cjH;
    private int cjI;
    private int cjJ;
    private boolean cjK;
    private String cjL;
    private a cjM;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void aW(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.cjH = null;
        this.cjI = 13;
        this.cjJ = 10;
        this.cjK = false;
        this.cjM = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void aW(View view) {
                if (!MultiImgToolView.this.cjB.ceP()) {
                    MultiImgToolView.this.cG(view);
                    int cH = MultiImgToolView.this.cjB.cH(view);
                    if (cH >= 0 && cH < MultiImgToolView.this.cjE.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cjE.getChosedFiles().remove(cH);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cjB.getMaxItemNum();
                        int size = MultiImgToolView.this.cjE.size();
                        MultiImgToolView.this.cjC.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cjE.getChosedFiles().size();
                        if (MultiImgToolView.this.VO != null) {
                            MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cjI, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjJ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjJ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cjK) {
                                    MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cjE, true);
                                MultiImgToolView.this.cjC.setText(MultiImgToolView.this.cjL);
                                MultiImgToolView.this.VO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjH = null;
        this.cjI = 13;
        this.cjJ = 10;
        this.cjK = false;
        this.cjM = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void aW(View view) {
                if (!MultiImgToolView.this.cjB.ceP()) {
                    MultiImgToolView.this.cG(view);
                    int cH = MultiImgToolView.this.cjB.cH(view);
                    if (cH >= 0 && cH < MultiImgToolView.this.cjE.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cjE.getChosedFiles().remove(cH);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cjB.getMaxItemNum();
                        int size = MultiImgToolView.this.cjE.size();
                        MultiImgToolView.this.cjC.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cjE.getChosedFiles().size();
                        if (MultiImgToolView.this.VO != null) {
                            MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cjI, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjJ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjJ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cjK) {
                                    MultiImgToolView.this.VO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cjE, true);
                                MultiImgToolView.this.cjC.setText(MultiImgToolView.this.cjL);
                                MultiImgToolView.this.VO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cjB = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.cjC = (TextView) findViewById(d.g.muti_image_tips);
        this.cjD = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.cjH = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.cjF = bVar;
    }

    public int getImageNum() {
        return this.cjE.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.cjE = writeImagesInfo;
        this.cjG = new b(getContext(), this.cjF, this, this.cjM, this.cjJ == 10);
        this.cjG.a(this.cjE);
        this.cjB.setAdapter(this.cjG, z);
        int maxItemNum = this.cjB.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.cjH)) {
            this.cjC.setText(this.cjH);
        } else if (!cjA && size > 1) {
            this.cjC.setText(d.j.editor_mutiiamge_drag_tip);
            cjA = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.cjC.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.cjG != null) {
                        this.cjG.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.cjJ, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cjx, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cjy);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
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
        if (i != i2 && this.cjE != null && this.cjE.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cjE.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.cjB;
    }

    public TextView getMutiImageTips() {
        return this.cjC;
    }

    public DragLayer getDragLayer() {
        return this.cjD;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b cjF;
        private WriteImagesInfo cjO = null;
        private l cjP;
        private a cjQ;
        private boolean cjR;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.cjR = true;
            this.mContext = context;
            this.cjF = bVar;
            this.cjP = lVar;
            this.cjQ = aVar;
            this.cjR = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.cjO = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cjO == null) {
                return 0;
            }
            return this.cjO.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.cjO.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.cjO.getChosedFiles(), i);
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
                if (this.cjF.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.cjR) {
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
                            } else if (b.this.cjP != null) {
                                b.this.cjP.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.cjQ != null) {
                        b.this.cjQ.aW(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.cjI = i;
    }

    public void setTargetToolId(int i) {
        this.cjJ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.l(this, d.C0277d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.cjK = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.cjL = " ";
        } else {
            this.cjL = str;
        }
    }
}
