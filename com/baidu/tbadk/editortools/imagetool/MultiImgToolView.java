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
    private static boolean crI = false;
    private EditorTools TB;
    private int TC;
    private DragHorizonScrollView crJ;
    private TextView crK;
    private DragLayer crL;
    private WriteImagesInfo crM;
    private com.baidu.tbadk.img.b crN;
    private b crO;
    private String crP;
    private int crQ;
    private int crR;
    private boolean crS;
    private String crT;
    private a crU;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bc(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.crP = null;
        this.crQ = 13;
        this.crR = 10;
        this.crS = false;
        this.crU = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bc(View view) {
                if (!MultiImgToolView.this.crJ.cmU()) {
                    MultiImgToolView.this.cO(view);
                    int cP = MultiImgToolView.this.crJ.cP(view);
                    if (cP >= 0 && cP < MultiImgToolView.this.crM.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.crM.getChosedFiles().remove(cP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gt().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.crJ.getMaxItemNum();
                        int size = MultiImgToolView.this.crM.size();
                        MultiImgToolView.this.crK.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.crM.getChosedFiles().size();
                        if (MultiImgToolView.this.TB != null) {
                            MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.crQ, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crR, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crR, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.crS) {
                                    MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.crM, true);
                                MultiImgToolView.this.crK.setText(MultiImgToolView.this.crT);
                                MultiImgToolView.this.TB.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crP = null;
        this.crQ = 13;
        this.crR = 10;
        this.crS = false;
        this.crU = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bc(View view) {
                if (!MultiImgToolView.this.crJ.cmU()) {
                    MultiImgToolView.this.cO(view);
                    int cP = MultiImgToolView.this.crJ.cP(view);
                    if (cP >= 0 && cP < MultiImgToolView.this.crM.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.crM.getChosedFiles().remove(cP);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gt().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.crJ.getMaxItemNum();
                        int size = MultiImgToolView.this.crM.size();
                        MultiImgToolView.this.crK.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.crM.getChosedFiles().size();
                        if (MultiImgToolView.this.TB != null) {
                            MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.crQ, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crR, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.crR, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.crS) {
                                    MultiImgToolView.this.TB.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.crM, true);
                                MultiImgToolView.this.crK.setText(MultiImgToolView.this.crT);
                                MultiImgToolView.this.TB.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.crJ = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.crK = (TextView) findViewById(R.id.muti_image_tips);
        this.crL = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.crP = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.crN = bVar;
    }

    public int getImageNum() {
        return this.crM.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.crM = writeImagesInfo;
        this.crO = new b(getContext(), this.crN, this, this.crU, this.crR == 10);
        this.crO.a(this.crM);
        this.crJ.setAdapter(this.crO, z);
        int maxItemNum = this.crJ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.crP)) {
            this.crK.setText(this.crP);
        } else if (!crI && size > 1) {
            this.crK.setText(R.string.editor_mutiiamge_drag_tip);
            crI = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.crK.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.crO != null) {
                        this.crO.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.crR, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).crF, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).crG);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
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
        if (i != i2 && this.crM != null && this.crM.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.crM.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.crJ;
    }

    public TextView getMutiImageTips() {
        return this.crK;
    }

    public DragLayer getDragLayer() {
        return this.crL;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b crN;
        private WriteImagesInfo crW = null;
        private l crX;
        private a crY;
        private boolean crZ;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.crZ = true;
            this.mContext = context;
            this.crN = bVar;
            this.crX = lVar;
            this.crY = aVar;
            this.crZ = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.crW = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.crW == null) {
                return 0;
            }
            return this.crW.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.crW.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.crW.getChosedFiles(), i);
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
                if (this.crN.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.crZ) {
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
                            } else if (b.this.crX != null) {
                                b.this.crX.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.crY != null) {
                        b.this.crY.bc(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.crQ = i;
    }

    public void setTargetToolId(int i) {
        this.crR = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.l(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.crS = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.crT = " ";
        } else {
            this.crT = str;
        }
    }
}
