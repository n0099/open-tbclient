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
    private static boolean fCy = false;
    private EditorTools acR;
    private int acS;
    private TextView fCA;
    private DragLayer fCB;
    private WriteImagesInfo fCC;
    private com.baidu.tbadk.img.b fCD;
    private b fCE;
    private String fCF;
    private int fCG;
    private int fCH;
    private boolean fCI;
    private String fCJ;
    private a fCK;
    private DragHorizonScrollView fCz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bM(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.fCF = null;
        this.fCG = 13;
        this.fCH = 10;
        this.fCI = false;
        this.fCK = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bM(View view) {
                if (!MultiImgToolView.this.fCz.dNX()) {
                    MultiImgToolView.this.ei(view);
                    int ej = MultiImgToolView.this.fCz.ej(view);
                    if (ej >= 0 && ej < MultiImgToolView.this.fCC.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fCC.getChosedFiles().remove(ej);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fCz.getMaxItemNum();
                        int size = MultiImgToolView.this.fCC.size();
                        MultiImgToolView.this.fCA.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fCC.getChosedFiles().size();
                        if (MultiImgToolView.this.acR != null) {
                            MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fCG, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fCH, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fCH, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fCI) {
                                    MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fCC, true);
                                MultiImgToolView.this.fCA.setText(MultiImgToolView.this.fCJ);
                                MultiImgToolView.this.acR.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCF = null;
        this.fCG = 13;
        this.fCH = 10;
        this.fCI = false;
        this.fCK = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bM(View view) {
                if (!MultiImgToolView.this.fCz.dNX()) {
                    MultiImgToolView.this.ei(view);
                    int ej = MultiImgToolView.this.fCz.ej(view);
                    if (ej >= 0 && ej < MultiImgToolView.this.fCC.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fCC.getChosedFiles().remove(ej);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fCz.getMaxItemNum();
                        int size = MultiImgToolView.this.fCC.size();
                        MultiImgToolView.this.fCA.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fCC.getChosedFiles().size();
                        if (MultiImgToolView.this.acR != null) {
                            MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fCG, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fCH, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fCH, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fCI) {
                                    MultiImgToolView.this.acR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fCC, true);
                                MultiImgToolView.this.fCA.setText(MultiImgToolView.this.fCJ);
                                MultiImgToolView.this.acR.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fCz = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.fCA = (TextView) findViewById(R.id.muti_image_tips);
        this.fCB = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.fCF = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.fCD = bVar;
    }

    public int getImageNum() {
        return this.fCC.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.fCC = writeImagesInfo;
        this.fCE = new b(getContext(), this.fCD, this, this.fCK, this.fCH == 10);
        this.fCE.a(this.fCC);
        this.fCz.setAdapter(this.fCE, z);
        int maxItemNum = this.fCz.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.fCF)) {
            this.fCA.setText(this.fCF);
        } else if (!fCy && size > 1) {
            this.fCA.setText(R.string.editor_mutiiamge_drag_tip);
            fCy = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.fCA.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.fCE != null) {
                        this.fCE.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.fCH, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fCv, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fCw);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
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
    public void bc(int i, int i2) {
        if (i != i2 && this.fCC != null && this.fCC.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.fCC.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.fCz;
    }

    public TextView getMutiImageTips() {
        return this.fCA;
    }

    public DragLayer getDragLayer() {
        return this.fCB;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b fCD;
        private WriteImagesInfo fCM = null;
        private n fCN;
        private a fCO;
        private boolean fCP;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.fCP = true;
            this.mContext = context;
            this.fCD = bVar;
            this.fCN = nVar;
            this.fCO = aVar;
            this.fCP = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.fCM = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fCM == null) {
                return 0;
            }
            return this.fCM.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.fCM.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.fCM.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bd(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.fCD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.fCP) {
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
                            } else if (b.this.fCN != null) {
                                b.this.fCN.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.fCO != null) {
                        b.this.fCO.bM(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.fCG = i;
    }

    public void setTargetToolId(int i) {
        this.fCH = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.fCI = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.fCJ = " ";
        } else {
            this.fCJ = str;
        }
    }
}
