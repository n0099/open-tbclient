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
    private static boolean aDP = false;
    private EditorTools JO;
    private int JP;
    private DragHorizonScrollView aDQ;
    private TextView aDR;
    private DragLayer aDS;
    private WriteImagesInfo aDT;
    private com.baidu.tbadk.img.b aDU;
    private b aDV;
    private String aDW;
    private int aDX;
    private int aDY;
    private boolean aDZ;
    private String aEa;
    private a aEb;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void N(View view2);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aDW = null;
        this.aDX = 13;
        this.aDY = 10;
        this.aDZ = false;
        this.aEb = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view2) {
                if (!MultiImgToolView.this.aDQ.bsv()) {
                    MultiImgToolView.this.bv(view2);
                    int bw = MultiImgToolView.this.aDQ.bw(view2);
                    if (bw >= 0 && bw < MultiImgToolView.this.aDT.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDT.getChosedFiles().remove(bw);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDQ.getMaxItemNum();
                        int size = MultiImgToolView.this.aDT.size();
                        MultiImgToolView.this.aDR.setText(MultiImgToolView.this.getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDT.getChosedFiles().size();
                        if (MultiImgToolView.this.JO != null) {
                            MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDX, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDY, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDY, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDZ) {
                                    MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDT, true);
                                MultiImgToolView.this.aDR.setText(MultiImgToolView.this.aEa);
                                MultiImgToolView.this.JO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDW = null;
        this.aDX = 13;
        this.aDY = 10;
        this.aDZ = false;
        this.aEb = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view2) {
                if (!MultiImgToolView.this.aDQ.bsv()) {
                    MultiImgToolView.this.bv(view2);
                    int bw = MultiImgToolView.this.aDQ.bw(view2);
                    if (bw >= 0 && bw < MultiImgToolView.this.aDT.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDT.getChosedFiles().remove(bw);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDQ.getMaxItemNum();
                        int size = MultiImgToolView.this.aDT.size();
                        MultiImgToolView.this.aDR.setText(MultiImgToolView.this.getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDT.getChosedFiles().size();
                        if (MultiImgToolView.this.JO != null) {
                            MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDX, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDY, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDY, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDZ) {
                                    MultiImgToolView.this.JO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDT, true);
                                MultiImgToolView.this.aDR.setText(MultiImgToolView.this.aEa);
                                MultiImgToolView.this.JO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aDQ = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aDR = (TextView) findViewById(d.g.muti_image_tips);
        this.aDS = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aDW = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDU = bVar;
    }

    public int getImageNum() {
        return this.aDT.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDT = writeImagesInfo;
        this.aDV = new b(getContext(), this.aDU, this, this.aEb, this.aDY == 10);
        this.aDV.a(this.aDT);
        this.aDQ.setAdapter(this.aDV, z);
        int maxItemNum = this.aDQ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aDW)) {
            this.aDR.setText(this.aDW);
        } else if (!aDP && size > 1) {
            this.aDR.setText(d.k.editor_mutiiamge_drag_tip);
            aDP = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aDR.setText(getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aDV != null) {
                        this.aDV.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDY, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDM, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDN);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void E(int i, int i2) {
        if (i != i2 && this.aDT != null && this.aDT.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDT.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aDQ;
    }

    public TextView getMutiImageTips() {
        return this.aDR;
    }

    public DragLayer getDragLayer() {
        return this.aDS;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDU;
        private WriteImagesInfo aEd = null;
        private l aEe;
        private a aEf;
        private boolean aEg;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aEg = true;
            this.mContext = context;
            this.aDU = bVar;
            this.aEe = lVar;
            this.aEf = aVar;
            this.aEg = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aEd = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aEd == null) {
                return 0;
            }
            return this.aEd.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aEd.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view2 == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.i.editor_muti_image_item, (ViewGroup) null) : view2;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aEd.getChosedFiles(), i);
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
                if (this.aDU.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aEg) {
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
                            } else if (b.this.aEe != null) {
                                b.this.aEe.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aEf != null) {
                        b.this.aEf.N(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.k.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aDX = i;
    }

    public void setTargetToolId(int i) {
        this.aDY = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDZ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aEa = " ";
        } else {
            this.aEa = str;
        }
    }
}
