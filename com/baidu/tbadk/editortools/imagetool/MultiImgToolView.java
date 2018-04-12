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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean aDO = false;
    private EditorTools JS;
    private int JT;
    private DragHorizonScrollView aDP;
    private TextView aDQ;
    private DragLayer aDR;
    private WriteImagesInfo aDS;
    private com.baidu.tbadk.img.b aDT;
    private b aDU;
    private String aDV;
    private int aDW;
    private int aDX;
    private boolean aDY;
    private String aDZ;
    private a aEa;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void N(View view2);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aDV = null;
        this.aDW = 13;
        this.aDX = 10;
        this.aDY = false;
        this.aEa = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view2) {
                if (!MultiImgToolView.this.aDP.bsx()) {
                    MultiImgToolView.this.bv(view2);
                    int bw = MultiImgToolView.this.aDP.bw(view2);
                    if (bw >= 0 && bw < MultiImgToolView.this.aDS.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDS.getChosedFiles().remove(bw);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDP.getMaxItemNum();
                        int size = MultiImgToolView.this.aDS.size();
                        MultiImgToolView.this.aDQ.setText(MultiImgToolView.this.getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDS.getChosedFiles().size();
                        if (MultiImgToolView.this.JS != null) {
                            MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDW, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDX, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDX, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDY) {
                                    MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDS, true);
                                MultiImgToolView.this.aDQ.setText(MultiImgToolView.this.aDZ);
                                MultiImgToolView.this.JS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDV = null;
        this.aDW = 13;
        this.aDX = 10;
        this.aDY = false;
        this.aEa = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view2) {
                if (!MultiImgToolView.this.aDP.bsx()) {
                    MultiImgToolView.this.bv(view2);
                    int bw = MultiImgToolView.this.aDP.bw(view2);
                    if (bw >= 0 && bw < MultiImgToolView.this.aDS.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDS.getChosedFiles().remove(bw);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDP.getMaxItemNum();
                        int size = MultiImgToolView.this.aDS.size();
                        MultiImgToolView.this.aDQ.setText(MultiImgToolView.this.getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDS.getChosedFiles().size();
                        if (MultiImgToolView.this.JS != null) {
                            MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDW, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDX, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDX, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDY) {
                                    MultiImgToolView.this.JS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDS, true);
                                MultiImgToolView.this.aDQ.setText(MultiImgToolView.this.aDZ);
                                MultiImgToolView.this.JS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aDP = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aDQ = (TextView) findViewById(d.g.muti_image_tips);
        this.aDR = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aDV = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDT = bVar;
    }

    public int getImageNum() {
        return this.aDS.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDS = writeImagesInfo;
        this.aDU = new b(getContext(), this.aDT, this, this.aEa, this.aDX == 10);
        this.aDU.a(this.aDS);
        this.aDP.setAdapter(this.aDU, z);
        int maxItemNum = this.aDP.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aDV)) {
            this.aDQ.setText(this.aDV);
        } else if (!aDO && size > 1) {
            this.aDQ.setText(d.k.editor_mutiiamge_drag_tip);
            aDO = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aDQ.setText(getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aDU != null) {
                        this.aDU.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDX, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDL, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDM);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void E(int i, int i2) {
        if (i != i2 && this.aDS != null && this.aDS.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDS.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aDP;
    }

    public TextView getMutiImageTips() {
        return this.aDQ;
    }

    public DragLayer getDragLayer() {
        return this.aDR;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDT;
        private WriteImagesInfo aEc = null;
        private l aEd;
        private a aEe;
        private boolean aEf;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aEf = true;
            this.mContext = context;
            this.aDT = bVar;
            this.aEd = lVar;
            this.aEe = aVar;
            this.aEf = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aEc = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aEc == null) {
                return 0;
            }
            return this.aEc.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aEc.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view2 == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.i.editor_muti_image_item, (ViewGroup) null) : view2;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aEc.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.e.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.g.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                ak.i(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(ak.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aDT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aEf) {
                frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        boolean z;
                        int indexOfChild = viewGroup.indexOfChild(view3);
                        if (indexOfChild >= 0) {
                            ImageFileInfo imageFileInfo2 = (ImageFileInfo) b.this.getItem(indexOfChild);
                            if (imageFileInfo2 == null) {
                                z = false;
                            } else {
                                z = new File(imageFileInfo2.getFilePath()).exists();
                            }
                            if (!z) {
                                com.baidu.adp.lib.util.l.showLongToast(b.this.mContext, d.k.editor_mutiiamge_image_error);
                            } else if (b.this.aEd != null) {
                                b.this.aEd.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.g.delete);
            ak.c(imageView, d.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (b.this.aEe != null) {
                        b.this.aEe.N(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.k.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aDW = i;
    }

    public void setTargetToolId(int i) {
        this.aDX = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDY = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aDZ = " ";
        } else {
            this.aDZ = str;
        }
    }
}
