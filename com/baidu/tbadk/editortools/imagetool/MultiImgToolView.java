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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
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
public class MultiImgToolView extends DragContainer implements m, DragHorizonScrollView.a {
    private static boolean dxD = false;
    private EditorTools FO;
    private int FP;
    private DragHorizonScrollView dxE;
    private TextView dxF;
    private DragLayer dxG;
    private WriteImagesInfo dxH;
    private com.baidu.tbadk.img.b dxI;
    private b dxJ;
    private String dxK;
    private int dxL;
    private int dxM;
    private boolean dxN;
    private String dxO;
    private a dxP;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.dxK = null;
        this.dxL = 13;
        this.dxM = 10;
        this.dxN = false;
        this.dxP = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dxE.cLB()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dxE.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dxH.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dxH.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dxE.getMaxItemNum();
                        int size = MultiImgToolView.this.dxH.size();
                        MultiImgToolView.this.dxF.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dxH.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dxL, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxM, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxM, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dxN) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dxH, true);
                                MultiImgToolView.this.dxF.setText(MultiImgToolView.this.dxO);
                                MultiImgToolView.this.FO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxK = null;
        this.dxL = 13;
        this.dxM = 10;
        this.dxN = false;
        this.dxP = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dxE.cLB()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dxE.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dxH.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dxH.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dxE.getMaxItemNum();
                        int size = MultiImgToolView.this.dxH.size();
                        MultiImgToolView.this.dxF.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dxH.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dxL, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxM, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxM, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dxN) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dxH, true);
                                MultiImgToolView.this.dxF.setText(MultiImgToolView.this.dxO);
                                MultiImgToolView.this.FO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dxE = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.dxF = (TextView) findViewById(R.id.muti_image_tips);
        this.dxG = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.dxK = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.dxI = bVar;
    }

    public int getImageNum() {
        return this.dxH.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.dxH = writeImagesInfo;
        this.dxJ = new b(getContext(), this.dxI, this, this.dxP, this.dxM == 10);
        this.dxJ.a(this.dxH);
        this.dxE.setAdapter(this.dxJ, z);
        int maxItemNum = this.dxE.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.dxK)) {
            this.dxF.setText(this.dxK);
        } else if (!dxD && size > 1) {
            this.dxF.setText(R.string.editor_mutiiamge_drag_tip);
            dxD = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.dxF.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.dxJ != null) {
                        this.dxJ.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.dxM, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dxA, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dxB);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aI(int i, int i2) {
        if (i != i2 && this.dxH != null && this.dxH.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.dxH.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.dxE;
    }

    public TextView getMutiImageTips() {
        return this.dxF;
    }

    public DragLayer getDragLayer() {
        return this.dxG;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b dxI;
        private WriteImagesInfo dxR = null;
        private m dxS;
        private a dxT;
        private boolean dxU;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.dxU = true;
            this.mContext = context;
            this.dxI = bVar;
            this.dxS = mVar;
            this.dxT = aVar;
            this.dxU = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.dxR = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dxR == null) {
                return 0;
            }
            return this.dxR.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.dxR.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.dxR.getChosedFiles(), i);
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
                am.setBackgroundResource(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(am.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aJ(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.dxI.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.dxU) {
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
                                l.showLongToast(b.this.mContext, (int) R.string.editor_mutiiamge_image_error);
                            } else if (b.this.dxS != null) {
                                b.this.dxS.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            am.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.dxT != null) {
                        b.this.dxT.bf(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + HanziToPinyin.Token.SEPARATOR + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.dxL = i;
    }

    public void setTargetToolId(int i) {
        this.dxM = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.dxN = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.dxO = HanziToPinyin.Token.SEPARATOR;
        } else {
            this.dxO = str;
        }
    }
}
