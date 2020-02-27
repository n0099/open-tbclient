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
    private static boolean dxC = false;
    private EditorTools FO;
    private int FP;
    private DragHorizonScrollView dxD;
    private TextView dxE;
    private DragLayer dxF;
    private WriteImagesInfo dxG;
    private com.baidu.tbadk.img.b dxH;
    private b dxI;
    private String dxJ;
    private int dxK;
    private int dxL;
    private boolean dxM;
    private String dxN;
    private a dxO;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.dxJ = null;
        this.dxK = 13;
        this.dxL = 10;
        this.dxM = false;
        this.dxO = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dxD.cLz()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dxD.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dxG.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dxG.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dxD.getMaxItemNum();
                        int size = MultiImgToolView.this.dxG.size();
                        MultiImgToolView.this.dxE.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dxG.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dxK, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxL, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxL, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dxM) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dxG, true);
                                MultiImgToolView.this.dxE.setText(MultiImgToolView.this.dxN);
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
        this.dxJ = null;
        this.dxK = 13;
        this.dxL = 10;
        this.dxM = false;
        this.dxO = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dxD.cLz()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dxD.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dxG.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dxG.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dxD.getMaxItemNum();
                        int size = MultiImgToolView.this.dxG.size();
                        MultiImgToolView.this.dxE.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dxG.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dxK, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxL, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxL, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dxM) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dxG, true);
                                MultiImgToolView.this.dxE.setText(MultiImgToolView.this.dxN);
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
        this.dxD = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.dxE = (TextView) findViewById(R.id.muti_image_tips);
        this.dxF = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.dxJ = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.dxH = bVar;
    }

    public int getImageNum() {
        return this.dxG.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.dxG = writeImagesInfo;
        this.dxI = new b(getContext(), this.dxH, this, this.dxO, this.dxL == 10);
        this.dxI.a(this.dxG);
        this.dxD.setAdapter(this.dxI, z);
        int maxItemNum = this.dxD.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.dxJ)) {
            this.dxE.setText(this.dxJ);
        } else if (!dxC && size > 1) {
            this.dxE.setText(R.string.editor_mutiiamge_drag_tip);
            dxC = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.dxE.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.dxI != null) {
                        this.dxI.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.dxL, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dxz, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dxA);
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
        if (i != i2 && this.dxG != null && this.dxG.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.dxG.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.dxD;
    }

    public TextView getMutiImageTips() {
        return this.dxE;
    }

    public DragLayer getDragLayer() {
        return this.dxF;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b dxH;
        private WriteImagesInfo dxQ = null;
        private m dxR;
        private a dxS;
        private boolean dxT;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.dxT = true;
            this.mContext = context;
            this.dxH = bVar;
            this.dxR = mVar;
            this.dxS = aVar;
            this.dxT = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.dxQ = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dxQ == null) {
                return 0;
            }
            return this.dxQ.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.dxQ.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.dxQ.getChosedFiles(), i);
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
                if (this.dxH.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.dxT) {
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
                            } else if (b.this.dxR != null) {
                                b.this.dxR.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.dxS != null) {
                        b.this.dxS.bf(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + HanziToPinyin.Token.SEPARATOR + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.dxK = i;
    }

    public void setTargetToolId(int i) {
        this.dxL = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.dxM = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.dxN = HanziToPinyin.Token.SEPARATOR;
        } else {
            this.dxN = str;
        }
    }
}
