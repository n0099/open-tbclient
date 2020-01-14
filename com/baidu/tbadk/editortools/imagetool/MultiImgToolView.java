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
    private static boolean dtw = false;
    private EditorTools Fv;
    private int Fw;
    private WriteImagesInfo dtA;
    private com.baidu.tbadk.img.b dtB;
    private b dtC;
    private String dtD;
    private int dtE;
    private int dtF;
    private boolean dtG;
    private String dtH;
    private a dtI;
    private DragHorizonScrollView dtx;
    private TextView dty;
    private DragLayer dtz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.dtD = null;
        this.dtE = 13;
        this.dtF = 10;
        this.dtG = false;
        this.dtI = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dtx.cKb()) {
                    MultiImgToolView.this.cQ(view);
                    int cR = MultiImgToolView.this.dtx.cR(view);
                    if (cR >= 0 && cR < MultiImgToolView.this.dtA.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dtA.getChosedFiles().remove(cR);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dtx.getMaxItemNum();
                        int size = MultiImgToolView.this.dtA.size();
                        MultiImgToolView.this.dty.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dtA.getChosedFiles().size();
                        if (MultiImgToolView.this.Fv != null) {
                            MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dtE, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dtF, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dtF, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dtG) {
                                    MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dtA, true);
                                MultiImgToolView.this.dty.setText(MultiImgToolView.this.dtH);
                                MultiImgToolView.this.Fv.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtD = null;
        this.dtE = 13;
        this.dtF = 10;
        this.dtG = false;
        this.dtI = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dtx.cKb()) {
                    MultiImgToolView.this.cQ(view);
                    int cR = MultiImgToolView.this.dtx.cR(view);
                    if (cR >= 0 && cR < MultiImgToolView.this.dtA.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dtA.getChosedFiles().remove(cR);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fj().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dtx.getMaxItemNum();
                        int size = MultiImgToolView.this.dtA.size();
                        MultiImgToolView.this.dty.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dtA.getChosedFiles().size();
                        if (MultiImgToolView.this.Fv != null) {
                            MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dtE, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dtF, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dtF, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dtG) {
                                    MultiImgToolView.this.Fv.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dtA, true);
                                MultiImgToolView.this.dty.setText(MultiImgToolView.this.dtH);
                                MultiImgToolView.this.Fv.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dtx = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.dty = (TextView) findViewById(R.id.muti_image_tips);
        this.dtz = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.dtD = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.dtB = bVar;
    }

    public int getImageNum() {
        return this.dtA.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.dtA = writeImagesInfo;
        this.dtC = new b(getContext(), this.dtB, this, this.dtI, this.dtF == 10);
        this.dtC.a(this.dtA);
        this.dtx.setAdapter(this.dtC, z);
        int maxItemNum = this.dtx.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.dtD)) {
            this.dty.setText(this.dtD);
        } else if (!dtw && size > 1) {
            this.dty.setText(R.string.editor_mutiiamge_drag_tip);
            dtw = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.dty.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.dtC != null) {
                        this.dtC.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.dtF, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dtt, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dtu);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
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
        if (i != i2 && this.dtA != null && this.dtA.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.dtA.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.dtx;
    }

    public TextView getMutiImageTips() {
        return this.dty;
    }

    public DragLayer getDragLayer() {
        return this.dtz;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b dtB;
        private WriteImagesInfo dtK = null;
        private m dtL;
        private a dtM;
        private boolean dtN;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.dtN = true;
            this.mContext = context;
            this.dtB = bVar;
            this.dtL = mVar;
            this.dtM = aVar;
            this.dtN = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.dtK = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dtK == null) {
                return 0;
            }
            return this.dtK.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.dtK.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.dtK.getChosedFiles(), i);
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
                if (this.dtB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.dtN) {
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
                            } else if (b.this.dtL != null) {
                                b.this.dtL.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.dtM != null) {
                        b.this.dtM.bf(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + HanziToPinyin.Token.SEPARATOR + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.dtE = i;
    }

    public void setTargetToolId(int i) {
        this.dtF = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.dtG = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.dtH = HanziToPinyin.Token.SEPARATOR;
        } else {
            this.dtH = str;
        }
    }
}
