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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
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
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.a {
    private static boolean foz = false;
    private EditorTools abk;
    private int abl;
    private DragHorizonScrollView foA;
    private TextView foB;
    private DragLayer foC;
    private WriteImagesInfo foD;
    private com.baidu.tbadk.img.b foE;
    private b foF;
    private String foG;
    private int foH;
    private int foI;
    private boolean foJ;
    private String foK;
    private a foL;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bB(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.foG = null;
        this.foH = 13;
        this.foI = 10;
        this.foJ = false;
        this.foL = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bB(View view) {
                if (!MultiImgToolView.this.foA.dKz()) {
                    MultiImgToolView.this.dI(view);
                    int dJ = MultiImgToolView.this.foA.dJ(view);
                    if (dJ >= 0 && dJ < MultiImgToolView.this.foD.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.foD.getChosedFiles().remove(dJ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.foA.getMaxItemNum();
                        int size = MultiImgToolView.this.foD.size();
                        MultiImgToolView.this.foB.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.foD.getChosedFiles().size();
                        if (MultiImgToolView.this.abk != null) {
                            MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.foH, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.foI, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.foI, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.foJ) {
                                    MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.foD, true);
                                MultiImgToolView.this.foB.setText(MultiImgToolView.this.foK);
                                MultiImgToolView.this.abk.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foG = null;
        this.foH = 13;
        this.foI = 10;
        this.foJ = false;
        this.foL = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bB(View view) {
                if (!MultiImgToolView.this.foA.dKz()) {
                    MultiImgToolView.this.dI(view);
                    int dJ = MultiImgToolView.this.foA.dJ(view);
                    if (dJ >= 0 && dJ < MultiImgToolView.this.foD.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.foD.getChosedFiles().remove(dJ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.foA.getMaxItemNum();
                        int size = MultiImgToolView.this.foD.size();
                        MultiImgToolView.this.foB.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.foD.getChosedFiles().size();
                        if (MultiImgToolView.this.abk != null) {
                            MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.foH, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.foI, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.foI, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.foJ) {
                                    MultiImgToolView.this.abk.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.foD, true);
                                MultiImgToolView.this.foB.setText(MultiImgToolView.this.foK);
                                MultiImgToolView.this.abk.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.foA = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.foB = (TextView) findViewById(R.id.muti_image_tips);
        this.foC = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.foG = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.foE = bVar;
    }

    public int getImageNum() {
        return this.foD.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.foD = writeImagesInfo;
        this.foF = new b(getContext(), this.foE, this, this.foL, this.foI == 10);
        this.foF.a(this.foD);
        this.foA.setAdapter(this.foF, z);
        int maxItemNum = this.foA.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.foG)) {
            this.foB.setText(this.foG);
        } else if (!foz && size > 1) {
            this.foB.setText(R.string.editor_mutiiamge_drag_tip);
            foz = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.foB.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.foF != null) {
                        this.foF.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.foI, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fow, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fox);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void bf(int i, int i2) {
        if (i != i2 && this.foD != null && this.foD.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.foD.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.foA;
    }

    public TextView getMutiImageTips() {
        return this.foB;
    }

    public DragLayer getDragLayer() {
        return this.foC;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b foE;
        private WriteImagesInfo foN = null;
        private n foO;
        private a foP;
        private boolean foQ;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.foQ = true;
            this.mContext = context;
            this.foE = bVar;
            this.foO = nVar;
            this.foP = aVar;
            this.foQ = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.foN = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.foN == null) {
                return 0;
            }
            return this.foN.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.foN.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.foN.getChosedFiles(), i);
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
                ap.setBackgroundResource(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(ap.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.foE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.foQ) {
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
                                l.showLongToast(b.this.mContext, R.string.editor_mutiiamge_image_error);
                            } else if (b.this.foO != null) {
                                b.this.foO.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            ap.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.foP != null) {
                        b.this.foP.bB(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.foH = i;
    }

    public void setTargetToolId(int i) {
        this.foI = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.foJ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.foK = " ";
        } else {
            this.foK = str;
        }
    }
}
