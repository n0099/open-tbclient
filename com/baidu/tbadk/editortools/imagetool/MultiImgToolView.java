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
/* loaded from: classes2.dex */
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.a {
    private static boolean eLG = false;
    private EditorTools aay;
    private int aaz;
    private DragHorizonScrollView eLH;
    private TextView eLI;
    private DragLayer eLJ;
    private WriteImagesInfo eLK;
    private com.baidu.tbadk.img.b eLL;
    private b eLM;
    private String eLN;
    private int eLO;
    private int eLP;
    private boolean eLQ;
    private String eLR;
    private a eLS;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void bq(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.eLN = null;
        this.eLO = 13;
        this.eLP = 10;
        this.eLQ = false;
        this.eLS = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bq(View view) {
                if (!MultiImgToolView.this.eLH.dxf()) {
                    MultiImgToolView.this.dm(view);
                    int dn = MultiImgToolView.this.eLH.dn(view);
                    if (dn >= 0 && dn < MultiImgToolView.this.eLK.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eLK.getChosedFiles().remove(dn);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eLH.getMaxItemNum();
                        int size = MultiImgToolView.this.eLK.size();
                        MultiImgToolView.this.eLI.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eLK.getChosedFiles().size();
                        if (MultiImgToolView.this.aay != null) {
                            MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eLO, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLP, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLP, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eLQ) {
                                    MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eLK, true);
                                MultiImgToolView.this.eLI.setText(MultiImgToolView.this.eLR);
                                MultiImgToolView.this.aay.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLN = null;
        this.eLO = 13;
        this.eLP = 10;
        this.eLQ = false;
        this.eLS = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bq(View view) {
                if (!MultiImgToolView.this.eLH.dxf()) {
                    MultiImgToolView.this.dm(view);
                    int dn = MultiImgToolView.this.eLH.dn(view);
                    if (dn >= 0 && dn < MultiImgToolView.this.eLK.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eLK.getChosedFiles().remove(dn);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eLH.getMaxItemNum();
                        int size = MultiImgToolView.this.eLK.size();
                        MultiImgToolView.this.eLI.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eLK.getChosedFiles().size();
                        if (MultiImgToolView.this.aay != null) {
                            MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eLO, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLP, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLP, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eLQ) {
                                    MultiImgToolView.this.aay.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eLK, true);
                                MultiImgToolView.this.eLI.setText(MultiImgToolView.this.eLR);
                                MultiImgToolView.this.aay.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eLH = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.eLI = (TextView) findViewById(R.id.muti_image_tips);
        this.eLJ = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.eLN = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.eLL = bVar;
    }

    public int getImageNum() {
        return this.eLK.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.eLK = writeImagesInfo;
        this.eLM = new b(getContext(), this.eLL, this, this.eLS, this.eLP == 10);
        this.eLM.a(this.eLK);
        this.eLH.setAdapter(this.eLM, z);
        int maxItemNum = this.eLH.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.eLN)) {
            this.eLI.setText(this.eLN);
        } else if (!eLG && size > 1) {
            this.eLI.setText(R.string.editor_mutiiamge_drag_tip);
            eLG = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.eLI.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.eLM != null) {
                        this.eLM.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.eLP, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eLD, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eLE);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
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
        if (i != i2 && this.eLK != null && this.eLK.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.eLK.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.eLH;
    }

    public TextView getMutiImageTips() {
        return this.eLI;
    }

    public DragLayer getDragLayer() {
        return this.eLJ;
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b eLL;
        private WriteImagesInfo eLU = null;
        private n eLV;
        private a eLW;
        private boolean eLX;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.eLX = true;
            this.mContext = context;
            this.eLL = bVar;
            this.eLV = nVar;
            this.eLW = aVar;
            this.eLX = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.eLU = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eLU == null) {
                return 0;
            }
            return this.eLU.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.eLU.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.eLU.getChosedFiles(), i);
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
                if (this.eLL.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.eLX) {
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
                            } else if (b.this.eLV != null) {
                                b.this.eLV.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.eLW != null) {
                        b.this.eLW.bq(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.eLO = i;
    }

    public void setTargetToolId(int i) {
        this.eLP = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.eLQ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.eLR = " ";
        } else {
            this.eLR = str;
        }
    }
}
