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
    private static boolean fnH = false;
    private EditorTools abp;
    private int abq;
    private DragHorizonScrollView fnI;
    private TextView fnJ;
    private DragLayer fnK;
    private WriteImagesInfo fnL;
    private com.baidu.tbadk.img.b fnM;
    private b fnN;
    private String fnO;
    private int fnP;
    private int fnQ;
    private boolean fnR;
    private String fnS;
    private a fnT;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bE(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.fnO = null;
        this.fnP = 13;
        this.fnQ = 10;
        this.fnR = false;
        this.fnT = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bE(View view) {
                if (!MultiImgToolView.this.fnI.dKq()) {
                    MultiImgToolView.this.dP(view);
                    int dQ = MultiImgToolView.this.fnI.dQ(view);
                    if (dQ >= 0 && dQ < MultiImgToolView.this.fnL.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fnL.getChosedFiles().remove(dQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fnI.getMaxItemNum();
                        int size = MultiImgToolView.this.fnL.size();
                        MultiImgToolView.this.fnJ.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fnL.getChosedFiles().size();
                        if (MultiImgToolView.this.abp != null) {
                            MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fnP, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fnQ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fnQ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fnR) {
                                    MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fnL, true);
                                MultiImgToolView.this.fnJ.setText(MultiImgToolView.this.fnS);
                                MultiImgToolView.this.abp.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnO = null;
        this.fnP = 13;
        this.fnQ = 10;
        this.fnR = false;
        this.fnT = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bE(View view) {
                if (!MultiImgToolView.this.fnI.dKq()) {
                    MultiImgToolView.this.dP(view);
                    int dQ = MultiImgToolView.this.fnI.dQ(view);
                    if (dQ >= 0 && dQ < MultiImgToolView.this.fnL.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fnL.getChosedFiles().remove(dQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fnI.getMaxItemNum();
                        int size = MultiImgToolView.this.fnL.size();
                        MultiImgToolView.this.fnJ.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fnL.getChosedFiles().size();
                        if (MultiImgToolView.this.abp != null) {
                            MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fnP, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fnQ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fnQ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fnR) {
                                    MultiImgToolView.this.abp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fnL, true);
                                MultiImgToolView.this.fnJ.setText(MultiImgToolView.this.fnS);
                                MultiImgToolView.this.abp.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fnI = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.fnJ = (TextView) findViewById(R.id.muti_image_tips);
        this.fnK = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.fnO = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.fnM = bVar;
    }

    public int getImageNum() {
        return this.fnL.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.fnL = writeImagesInfo;
        this.fnN = new b(getContext(), this.fnM, this, this.fnT, this.fnQ == 10);
        this.fnN.a(this.fnL);
        this.fnI.setAdapter(this.fnN, z);
        int maxItemNum = this.fnI.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.fnO)) {
            this.fnJ.setText(this.fnO);
        } else if (!fnH && size > 1) {
            this.fnJ.setText(R.string.editor_mutiiamge_drag_tip);
            fnH = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.fnJ.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.fnN != null) {
                        this.fnN.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.fnQ, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fnE, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fnF);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abq;
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
        if (i != i2 && this.fnL != null && this.fnL.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.fnL.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.fnI;
    }

    public TextView getMutiImageTips() {
        return this.fnJ;
    }

    public DragLayer getDragLayer() {
        return this.fnK;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b fnM;
        private WriteImagesInfo fnV = null;
        private n fnW;
        private a fnX;
        private boolean fnY;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.fnY = true;
            this.mContext = context;
            this.fnM = bVar;
            this.fnW = nVar;
            this.fnX = aVar;
            this.fnY = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.fnV = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fnV == null) {
                return 0;
            }
            return this.fnV.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.fnV.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.fnV.getChosedFiles(), i);
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
                if (this.fnM.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.fnY) {
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
                            } else if (b.this.fnW != null) {
                                b.this.fnW.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.fnX != null) {
                        b.this.fnX.bE(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.fnP = i;
    }

    public void setTargetToolId(int i) {
        this.fnQ = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.fnR = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.fnS = " ";
        } else {
            this.fnS = str;
        }
    }
}
