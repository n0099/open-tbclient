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
    private static boolean cjx = false;
    private EditorTools VM;
    private int VN;
    private DragLayer cjA;
    private WriteImagesInfo cjB;
    private com.baidu.tbadk.img.b cjC;
    private b cjD;
    private String cjE;
    private int cjF;
    private int cjG;
    private boolean cjH;
    private String cjI;
    private a cjJ;
    private DragHorizonScrollView cjy;
    private TextView cjz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void aW(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.cjE = null;
        this.cjF = 13;
        this.cjG = 10;
        this.cjH = false;
        this.cjJ = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void aW(View view) {
                if (!MultiImgToolView.this.cjy.ceR()) {
                    MultiImgToolView.this.cG(view);
                    int cH = MultiImgToolView.this.cjy.cH(view);
                    if (cH >= 0 && cH < MultiImgToolView.this.cjB.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cjB.getChosedFiles().remove(cH);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cjy.getMaxItemNum();
                        int size = MultiImgToolView.this.cjB.size();
                        MultiImgToolView.this.cjz.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cjB.getChosedFiles().size();
                        if (MultiImgToolView.this.VM != null) {
                            MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cjF, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjG, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjG, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cjH) {
                                    MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cjB, true);
                                MultiImgToolView.this.cjz.setText(MultiImgToolView.this.cjI);
                                MultiImgToolView.this.VM.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjE = null;
        this.cjF = 13;
        this.cjG = 10;
        this.cjH = false;
        this.cjJ = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void aW(View view) {
                if (!MultiImgToolView.this.cjy.ceR()) {
                    MultiImgToolView.this.cG(view);
                    int cH = MultiImgToolView.this.cjy.cH(view);
                    if (cH >= 0 && cH < MultiImgToolView.this.cjB.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cjB.getChosedFiles().remove(cH);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hz().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cjy.getMaxItemNum();
                        int size = MultiImgToolView.this.cjB.size();
                        MultiImgToolView.this.cjz.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cjB.getChosedFiles().size();
                        if (MultiImgToolView.this.VM != null) {
                            MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cjF, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjG, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cjG, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cjH) {
                                    MultiImgToolView.this.VM.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cjB, true);
                                MultiImgToolView.this.cjz.setText(MultiImgToolView.this.cjI);
                                MultiImgToolView.this.VM.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cjy = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.cjz = (TextView) findViewById(d.g.muti_image_tips);
        this.cjA = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.cjE = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.cjC = bVar;
    }

    public int getImageNum() {
        return this.cjB.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.cjB = writeImagesInfo;
        this.cjD = new b(getContext(), this.cjC, this, this.cjJ, this.cjG == 10);
        this.cjD.a(this.cjB);
        this.cjy.setAdapter(this.cjD, z);
        int maxItemNum = this.cjy.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.cjE)) {
            this.cjz.setText(this.cjE);
        } else if (!cjx && size > 1) {
            this.cjz.setText(d.j.editor_mutiiamge_drag_tip);
            cjx = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.cjz.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.cjD != null) {
                        this.cjD.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.cjG, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cju, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cjv);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VM = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VM != null) {
            this.VM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VN = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VN;
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
        if (i != i2 && this.cjB != null && this.cjB.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cjB.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.cjy;
    }

    public TextView getMutiImageTips() {
        return this.cjz;
    }

    public DragLayer getDragLayer() {
        return this.cjA;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b cjC;
        private WriteImagesInfo cjL = null;
        private l cjM;
        private a cjN;
        private boolean cjO;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.cjO = true;
            this.mContext = context;
            this.cjC = bVar;
            this.cjM = lVar;
            this.cjN = aVar;
            this.cjO = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.cjL = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cjL == null) {
                return 0;
            }
            return this.cjL.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.cjL.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.cjL.getChosedFiles(), i);
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
                if (this.cjC.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.cjO) {
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
                            } else if (b.this.cjM != null) {
                                b.this.cjM.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.cjN != null) {
                        b.this.cjN.aW(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.cjF = i;
    }

    public void setTargetToolId(int i) {
        this.cjG = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.l(this, d.C0236d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.cjH = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.cjI = " ";
        } else {
            this.cjI = str;
        }
    }
}
