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
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements s, DragHorizonScrollView.a {
    private static boolean bqT = false;
    private i axO;
    private int axP;
    private DragHorizonScrollView bqU;
    private TextView bqV;
    private DragLayer bqW;
    private WriteImagesInfo bqX;
    private com.baidu.tbadk.img.b bqY;
    private b bqZ;
    private String bra;
    private int brb;
    private int brc;
    private boolean brd;
    private String bre;
    private a brf;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bg(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.bra = null;
        this.brb = 13;
        this.brc = 10;
        this.brd = false;
        this.brf = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bg(View view) {
                if (!MultiImgToolView.this.bqU.bCM()) {
                    MultiImgToolView.this.cT(view);
                    int cU = MultiImgToolView.this.bqU.cU(view);
                    if (cU >= 0 && cU < MultiImgToolView.this.bqX.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.bqX.getChosedFiles().remove(cU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.bqU.getMaxItemNum();
                        int size = MultiImgToolView.this.bqX.size();
                        MultiImgToolView.this.bqV.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.bqX.getChosedFiles().size();
                        if (MultiImgToolView.this.axO != null) {
                            MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.brb, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.brc, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.brc, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.brd) {
                                    MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.bqX, true);
                                MultiImgToolView.this.bqV.setText(MultiImgToolView.this.bre);
                                MultiImgToolView.this.axO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bra = null;
        this.brb = 13;
        this.brc = 10;
        this.brd = false;
        this.brf = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bg(View view) {
                if (!MultiImgToolView.this.bqU.bCM()) {
                    MultiImgToolView.this.cT(view);
                    int cU = MultiImgToolView.this.bqU.cU(view);
                    if (cU >= 0 && cU < MultiImgToolView.this.bqX.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.bqX.getChosedFiles().remove(cU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.bqU.getMaxItemNum();
                        int size = MultiImgToolView.this.bqX.size();
                        MultiImgToolView.this.bqV.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.bqX.getChosedFiles().size();
                        if (MultiImgToolView.this.axO != null) {
                            MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.brb, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.brc, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.brc, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.brd) {
                                    MultiImgToolView.this.axO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.bqX, true);
                                MultiImgToolView.this.bqV.setText(MultiImgToolView.this.bre);
                                MultiImgToolView.this.axO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.bqU = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.bqV = (TextView) findViewById(d.g.muti_image_tips);
        this.bqW = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.bra = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.bqY = bVar;
    }

    public int getImageNum() {
        return this.bqX.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.bqX = writeImagesInfo;
        this.bqZ = new b(getContext(), this.bqY, this, this.brf, this.brc == 10);
        this.bqZ.a(this.bqX);
        this.bqU.a(this.bqZ, z);
        int maxItemNum = this.bqU.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.bra)) {
            this.bqV.setText(this.bra);
        } else if (!bqT && size > 1) {
            this.bqV.setText(d.j.editor_mutiiamge_drag_tip);
            bqT = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.bqV.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.bqZ != null) {
                        this.bqZ.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.brc, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).bqQ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).bqR);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axP;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aG(int i, int i2) {
        if (i != i2 && this.bqX != null && this.bqX.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.bqX.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.bqU;
    }

    public TextView getMutiImageTips() {
        return this.bqV;
    }

    public DragLayer getDragLayer() {
        return this.bqW;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b bqY;
        private WriteImagesInfo brh = null;
        private s bri;
        private a brj;
        private boolean brk;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.brk = true;
            this.mContext = context;
            this.bqY = bVar;
            this.bri = sVar;
            this.brj = aVar;
            this.brk = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.brh = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.brh == null) {
                return 0;
            }
            return this.brh.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.brh.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.brh.getChosedFiles(), i);
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
                aj.s(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(aj.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aI(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.bqY.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
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
            if (this.brk) {
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
                                l.r(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.bri != null) {
                                b.this.bri.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.g.delete);
            aj.c(imageView, d.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.brj != null) {
                        b.this.brj.bg(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.brb = i;
    }

    public void setTargetToolId(int i) {
        this.brc = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.t(this, d.C0108d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.brd = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.bre = " ";
        } else {
            this.bre = str;
        }
    }
}
