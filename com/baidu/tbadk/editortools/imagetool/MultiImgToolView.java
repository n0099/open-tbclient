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
    private static boolean btp = false;
    private i axH;
    private int axI;
    private String btA;
    private a btB;
    private DragHorizonScrollView btq;
    private TextView btr;
    private DragLayer bts;
    private WriteImagesInfo btt;
    private com.baidu.tbadk.img.b btu;
    private b btv;
    private String btw;
    private int btx;
    private int bty;
    private boolean btz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bi(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.btw = null;
        this.btx = 13;
        this.bty = 10;
        this.btz = false;
        this.btB = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.btq.bxx()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.btq.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.btt.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.btt.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.btq.getMaxItemNum();
                        int size = MultiImgToolView.this.btt.size();
                        MultiImgToolView.this.btr.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.btt.getChosedFiles().size();
                        if (MultiImgToolView.this.axH != null) {
                            MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.btx, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bty, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bty, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.btz) {
                                    MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.btt, true);
                                MultiImgToolView.this.btr.setText(MultiImgToolView.this.btA);
                                MultiImgToolView.this.axH.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btw = null;
        this.btx = 13;
        this.bty = 10;
        this.btz = false;
        this.btB = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.btq.bxx()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.btq.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.btt.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.btt.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.btq.getMaxItemNum();
                        int size = MultiImgToolView.this.btt.size();
                        MultiImgToolView.this.btr.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.btt.getChosedFiles().size();
                        if (MultiImgToolView.this.axH != null) {
                            MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.btx, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bty, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bty, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.btz) {
                                    MultiImgToolView.this.axH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.btt, true);
                                MultiImgToolView.this.btr.setText(MultiImgToolView.this.btA);
                                MultiImgToolView.this.axH.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.btq = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.btr = (TextView) findViewById(d.g.muti_image_tips);
        this.bts = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.btw = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.btu = bVar;
    }

    public int getImageNum() {
        return this.btt.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.btt = writeImagesInfo;
        this.btv = new b(getContext(), this.btu, this, this.btB, this.bty == 10);
        this.btv.a(this.btt);
        this.btq.a(this.btv, z);
        int maxItemNum = this.btq.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.btw)) {
            this.btr.setText(this.btw);
        } else if (!btp && size > 1) {
            this.btr.setText(d.j.editor_mutiiamge_drag_tip);
            btp = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.btr.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.btv != null) {
                        this.btv.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.bty, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).btl, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).btm);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
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
        if (i != i2 && this.btt != null && this.btt.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.btt.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.btq;
    }

    public TextView getMutiImageTips() {
        return this.btr;
    }

    public DragLayer getDragLayer() {
        return this.bts;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo btD = null;
        private s btE;
        private a btF;
        private boolean btG;
        private com.baidu.tbadk.img.b btu;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.btG = true;
            this.mContext = context;
            this.btu = bVar;
            this.btE = sVar;
            this.btF = aVar;
            this.btG = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.btD = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.btD == null) {
                return 0;
            }
            return this.btD.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.btD.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.btD.getChosedFiles(), i);
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
                if (this.btu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.btG) {
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
                                l.s(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.btE != null) {
                                b.this.btE.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.btF != null) {
                        b.this.btF.bi(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.btx = i;
    }

    public void setTargetToolId(int i) {
        this.bty = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.t(this, d.C0141d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.btz = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.btA = " ";
        } else {
            this.btA = str;
        }
    }
}
