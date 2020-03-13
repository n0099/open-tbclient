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
    private static boolean dxQ = false;
    private EditorTools FO;
    private int FP;
    private DragHorizonScrollView dxR;
    private TextView dxS;
    private DragLayer dxT;
    private WriteImagesInfo dxU;
    private com.baidu.tbadk.img.b dxV;
    private b dxW;
    private String dxX;
    private int dxY;
    private int dxZ;
    private boolean dya;
    private String dyb;
    private a dyc;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.dxX = null;
        this.dxY = 13;
        this.dxZ = 10;
        this.dya = false;
        this.dyc = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dxR.cLC()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dxR.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dxU.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dxU.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dxR.getMaxItemNum();
                        int size = MultiImgToolView.this.dxU.size();
                        MultiImgToolView.this.dxS.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dxU.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dxY, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxZ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxZ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dya) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dxU, true);
                                MultiImgToolView.this.dxS.setText(MultiImgToolView.this.dyb);
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
        this.dxX = null;
        this.dxY = 13;
        this.dxZ = 10;
        this.dya = false;
        this.dyc = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dxR.cLC()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dxR.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dxU.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dxU.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dxR.getMaxItemNum();
                        int size = MultiImgToolView.this.dxU.size();
                        MultiImgToolView.this.dxS.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dxU.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dxY, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxZ, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dxZ, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dya) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dxU, true);
                                MultiImgToolView.this.dxS.setText(MultiImgToolView.this.dyb);
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
        this.dxR = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.dxS = (TextView) findViewById(R.id.muti_image_tips);
        this.dxT = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.dxX = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.dxV = bVar;
    }

    public int getImageNum() {
        return this.dxU.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.dxU = writeImagesInfo;
        this.dxW = new b(getContext(), this.dxV, this, this.dyc, this.dxZ == 10);
        this.dxW.a(this.dxU);
        this.dxR.setAdapter(this.dxW, z);
        int maxItemNum = this.dxR.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.dxX)) {
            this.dxS.setText(this.dxX);
        } else if (!dxQ && size > 1) {
            this.dxS.setText(R.string.editor_mutiiamge_drag_tip);
            dxQ = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.dxS.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.dxW != null) {
                        this.dxW.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.dxZ, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dxN, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dxO);
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
        if (i != i2 && this.dxU != null && this.dxU.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.dxU.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.dxR;
    }

    public TextView getMutiImageTips() {
        return this.dxS;
    }

    public DragLayer getDragLayer() {
        return this.dxT;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b dxV;
        private WriteImagesInfo dye = null;
        private m dyf;
        private a dyg;
        private boolean dyh;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.dyh = true;
            this.mContext = context;
            this.dxV = bVar;
            this.dyf = mVar;
            this.dyg = aVar;
            this.dyh = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.dye = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dye == null) {
                return 0;
            }
            return this.dye.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.dye.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.dye.getChosedFiles(), i);
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
                if (this.dxV.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.dyh) {
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
                            } else if (b.this.dyf != null) {
                                b.this.dyf.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.dyg != null) {
                        b.this.dyg.bf(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + HanziToPinyin.Token.SEPARATOR + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.dxY = i;
    }

    public void setTargetToolId(int i) {
        this.dxZ = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.dya = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.dyb = HanziToPinyin.Token.SEPARATOR;
        } else {
            this.dyb = str;
        }
    }
}
