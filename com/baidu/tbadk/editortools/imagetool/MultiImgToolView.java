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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean crJ = false;
    private EditorTools TA;
    private int TB;
    private DragHorizonScrollView crK;
    private TextView crL;
    private DragLayer crM;
    private WriteImagesInfo crN;
    private com.baidu.tbadk.img.b crO;
    private b crP;
    private String crQ;
    private int crR;
    private int crS;
    private boolean crT;
    private String crU;
    private a crV;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bc(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.crQ = null;
        this.crR = 13;
        this.crS = 10;
        this.crT = false;
        this.crV = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bc(View view) {
                if (!MultiImgToolView.this.crK.cmX()) {
                    MultiImgToolView.this.cO(view);
                    int cP = MultiImgToolView.this.crK.cP(view);
                    if (cP >= 0 && cP < MultiImgToolView.this.crN.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.crN.getChosedFiles().remove(cP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gt().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.crK.getMaxItemNum();
                        int size = MultiImgToolView.this.crN.size();
                        MultiImgToolView.this.crL.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.crN.getChosedFiles().size();
                        if (MultiImgToolView.this.TA != null) {
                            MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.crR, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crS, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crS, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.crT) {
                                    MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.crN, true);
                                MultiImgToolView.this.crL.setText(MultiImgToolView.this.crU);
                                MultiImgToolView.this.TA.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crQ = null;
        this.crR = 13;
        this.crS = 10;
        this.crT = false;
        this.crV = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bc(View view) {
                if (!MultiImgToolView.this.crK.cmX()) {
                    MultiImgToolView.this.cO(view);
                    int cP = MultiImgToolView.this.crK.cP(view);
                    if (cP >= 0 && cP < MultiImgToolView.this.crN.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.crN.getChosedFiles().remove(cP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gt().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.crK.getMaxItemNum();
                        int size = MultiImgToolView.this.crN.size();
                        MultiImgToolView.this.crL.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.crN.getChosedFiles().size();
                        if (MultiImgToolView.this.TA != null) {
                            MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.crR, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crS, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crS, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.crT) {
                                    MultiImgToolView.this.TA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.crN, true);
                                MultiImgToolView.this.crL.setText(MultiImgToolView.this.crU);
                                MultiImgToolView.this.TA.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.crK = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.crL = (TextView) findViewById(R.id.muti_image_tips);
        this.crM = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.crQ = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.crO = bVar;
    }

    public int getImageNum() {
        return this.crN.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.crN = writeImagesInfo;
        this.crP = new b(getContext(), this.crO, this, this.crV, this.crS == 10);
        this.crP.a(this.crN);
        this.crK.setAdapter(this.crP, z);
        int maxItemNum = this.crK.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.crQ)) {
            this.crL.setText(this.crQ);
        } else if (!crJ && size > 1) {
            this.crL.setText(R.string.editor_mutiiamge_drag_tip);
            crJ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.crL.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.crP != null) {
                        this.crP.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.crS, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).crG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).crH);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void ag(int i, int i2) {
        if (i != i2 && this.crN != null && this.crN.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.crN.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.crK;
    }

    public TextView getMutiImageTips() {
        return this.crL;
    }

    public DragLayer getDragLayer() {
        return this.crM;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b crO;
        private WriteImagesInfo crX = null;
        private l crY;
        private a crZ;
        private boolean csa;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.csa = true;
            this.mContext = context;
            this.crO = bVar;
            this.crY = lVar;
            this.crZ = aVar;
            this.csa = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.crX = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.crX == null) {
                return 0;
            }
            return this.crX.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.crX.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.crX.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(R.dimen.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(R.dimen.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(R.id.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(R.id.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(R.id.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                al.k(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.ai(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.crO.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.csa) {
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
                                com.baidu.adp.lib.util.l.f(b.this.mContext, R.string.editor_mutiiamge_image_error);
                            } else if (b.this.crY != null) {
                                b.this.crY.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            al.c(imageView, (int) R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.crZ != null) {
                        b.this.crZ.bc(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.crR = i;
    }

    public void setTargetToolId(int i) {
        this.crS = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.l(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.crT = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.crU = " ";
        } else {
            this.crU = str;
        }
    }
}
