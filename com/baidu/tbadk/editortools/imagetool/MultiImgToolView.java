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
    private static boolean eLK = false;
    private EditorTools aaA;
    private int aaB;
    private DragHorizonScrollView eLL;
    private TextView eLM;
    private DragLayer eLN;
    private WriteImagesInfo eLO;
    private com.baidu.tbadk.img.b eLP;
    private b eLQ;
    private String eLR;
    private int eLS;
    private int eLT;
    private boolean eLU;
    private String eLV;
    private a eLW;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bq(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.eLR = null;
        this.eLS = 13;
        this.eLT = 10;
        this.eLU = false;
        this.eLW = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bq(View view) {
                if (!MultiImgToolView.this.eLL.dxk()) {
                    MultiImgToolView.this.dm(view);
                    int dn = MultiImgToolView.this.eLL.dn(view);
                    if (dn >= 0 && dn < MultiImgToolView.this.eLO.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eLO.getChosedFiles().remove(dn);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eLL.getMaxItemNum();
                        int size = MultiImgToolView.this.eLO.size();
                        MultiImgToolView.this.eLM.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eLO.getChosedFiles().size();
                        if (MultiImgToolView.this.aaA != null) {
                            MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eLS, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLT, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLT, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eLU) {
                                    MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eLO, true);
                                MultiImgToolView.this.eLM.setText(MultiImgToolView.this.eLV);
                                MultiImgToolView.this.aaA.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLR = null;
        this.eLS = 13;
        this.eLT = 10;
        this.eLU = false;
        this.eLW = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bq(View view) {
                if (!MultiImgToolView.this.eLL.dxk()) {
                    MultiImgToolView.this.dm(view);
                    int dn = MultiImgToolView.this.eLL.dn(view);
                    if (dn >= 0 && dn < MultiImgToolView.this.eLO.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eLO.getChosedFiles().remove(dn);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eLL.getMaxItemNum();
                        int size = MultiImgToolView.this.eLO.size();
                        MultiImgToolView.this.eLM.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eLO.getChosedFiles().size();
                        if (MultiImgToolView.this.aaA != null) {
                            MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eLS, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLT, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eLT, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eLU) {
                                    MultiImgToolView.this.aaA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eLO, true);
                                MultiImgToolView.this.eLM.setText(MultiImgToolView.this.eLV);
                                MultiImgToolView.this.aaA.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eLL = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.eLM = (TextView) findViewById(R.id.muti_image_tips);
        this.eLN = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.eLR = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.eLP = bVar;
    }

    public int getImageNum() {
        return this.eLO.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.eLO = writeImagesInfo;
        this.eLQ = new b(getContext(), this.eLP, this, this.eLW, this.eLT == 10);
        this.eLQ.a(this.eLO);
        this.eLL.setAdapter(this.eLQ, z);
        int maxItemNum = this.eLL.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.eLR)) {
            this.eLM.setText(this.eLR);
        } else if (!eLK && size > 1) {
            this.eLM.setText(R.string.editor_mutiiamge_drag_tip);
            eLK = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.eLM.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.eLQ != null) {
                        this.eLQ.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.eLT, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eLH, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eLI);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaB;
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
        if (i != i2 && this.eLO != null && this.eLO.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.eLO.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.eLL;
    }

    public TextView getMutiImageTips() {
        return this.eLM;
    }

    public DragLayer getDragLayer() {
        return this.eLN;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b eLP;
        private WriteImagesInfo eLY = null;
        private n eLZ;
        private a eMa;
        private boolean eMb;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.eMb = true;
            this.mContext = context;
            this.eLP = bVar;
            this.eLZ = nVar;
            this.eMa = aVar;
            this.eMb = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.eLY = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eLY == null) {
                return 0;
            }
            return this.eLY.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.eLY.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.eLY.getChosedFiles(), i);
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
                if (this.eLP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.eMb) {
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
                            } else if (b.this.eLZ != null) {
                                b.this.eLZ.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.eMa != null) {
                        b.this.eMa.bq(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.eLS = i;
    }

    public void setTargetToolId(int i) {
        this.eLT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.eLU = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.eLV = " ";
        } else {
            this.eLV = str;
        }
    }
}
