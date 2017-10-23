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
    private static boolean aBw = false;
    private int JG;
    private i JH;
    private WriteImagesInfo aBA;
    private com.baidu.tbadk.img.b aBB;
    private b aBC;
    private String aBD;
    private int aBE;
    private int aBF;
    private boolean aBG;
    private String aBH;
    private a aBI;
    private DragHorizonScrollView aBx;
    private TextView aBy;
    private DragLayer aBz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void M(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aBD = null;
        this.aBE = 13;
        this.aBF = 10;
        this.aBG = false;
        this.aBI = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void M(View view) {
                if (!MultiImgToolView.this.aBx.brP()) {
                    MultiImgToolView.this.bF(view);
                    int bG = MultiImgToolView.this.aBx.bG(view);
                    if (bG >= 0 && bG < MultiImgToolView.this.aBA.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aBA.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aBx.getMaxItemNum();
                        int size = MultiImgToolView.this.aBA.size();
                        MultiImgToolView.this.aBy.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aBA.getChosedFiles().size();
                        if (MultiImgToolView.this.JH != null) {
                            MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aBE, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBF, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBF, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aBG) {
                                    MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aBA, true);
                                MultiImgToolView.this.aBy.setText(MultiImgToolView.this.aBH);
                                MultiImgToolView.this.JH.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBD = null;
        this.aBE = 13;
        this.aBF = 10;
        this.aBG = false;
        this.aBI = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void M(View view) {
                if (!MultiImgToolView.this.aBx.brP()) {
                    MultiImgToolView.this.bF(view);
                    int bG = MultiImgToolView.this.aBx.bG(view);
                    if (bG >= 0 && bG < MultiImgToolView.this.aBA.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aBA.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aBx.getMaxItemNum();
                        int size = MultiImgToolView.this.aBA.size();
                        MultiImgToolView.this.aBy.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aBA.getChosedFiles().size();
                        if (MultiImgToolView.this.JH != null) {
                            MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aBE, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBF, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBF, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aBG) {
                                    MultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aBA, true);
                                MultiImgToolView.this.aBy.setText(MultiImgToolView.this.aBH);
                                MultiImgToolView.this.JH.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aBx = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aBy = (TextView) findViewById(d.h.muti_image_tips);
        this.aBz = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aBD = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aBB = bVar;
    }

    public int getImageNum() {
        return this.aBA.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aBA = writeImagesInfo;
        this.aBC = new b(getContext(), this.aBB, this, this.aBI, this.aBF == 10);
        this.aBC.a(this.aBA);
        this.aBx.a(this.aBC, z);
        int maxItemNum = this.aBx.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aBD)) {
            this.aBy.setText(this.aBD);
        } else if (!aBw && size > 1) {
            this.aBy.setText(d.l.editor_mutiiamge_drag_tip);
            aBw = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aBy.setText(getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aBC != null) {
                        this.aBC.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aBF, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBt, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBu);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JG;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.aBA != null && this.aBA.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aBA.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aBx;
    }

    public TextView getMutiImageTips() {
        return this.aBy;
    }

    public DragLayer getDragLayer() {
        return this.aBz;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aBB;
        private WriteImagesInfo aBK = null;
        private s aBL;
        private a aBM;
        private boolean aBN;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aBN = true;
            this.mContext = context;
            this.aBB = bVar;
            this.aBL = sVar;
            this.aBM = aVar;
            this.aBN = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aBK = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBK == null) {
                return 0;
            }
            return this.aBK.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aBK.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aBK.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.h.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.h.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.h.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                aj.j(frameLayout3, d.g.bg_add_photo);
                frameLayout3.setForeground(aj.getDrawable(d.g.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aBB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aBN) {
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
                                l.e(b.this.mContext, d.l.editor_mutiiamge_image_error);
                            } else if (b.this.aBL != null) {
                                b.this.aBL.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aBM != null) {
                        b.this.aBM.M(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.l.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aBE = i;
    }

    public void setTargetToolId(int i) {
        this.aBF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aBG = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aBH = " ";
        } else {
            this.aBH = str;
        }
    }
}
