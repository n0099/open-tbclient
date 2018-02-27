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
    private static boolean btl = false;
    private i axG;
    private int axH;
    private DragHorizonScrollView btm;
    private TextView bto;
    private DragLayer btp;
    private WriteImagesInfo btq;
    private com.baidu.tbadk.img.b btr;
    private b bts;
    private String btt;
    private int btu;
    private int btv;
    private boolean btw;
    private String btx;
    private a bty;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bi(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.btt = null;
        this.btu = 13;
        this.btv = 10;
        this.btw = false;
        this.bty = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.btm.bxs()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.btm.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.btq.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.btq.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.btm.getMaxItemNum();
                        int size = MultiImgToolView.this.btq.size();
                        MultiImgToolView.this.bto.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.btq.getChosedFiles().size();
                        if (MultiImgToolView.this.axG != null) {
                            MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.btu, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btv, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btv, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.btw) {
                                    MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.btq, true);
                                MultiImgToolView.this.bto.setText(MultiImgToolView.this.btx);
                                MultiImgToolView.this.axG.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btt = null;
        this.btu = 13;
        this.btv = 10;
        this.btw = false;
        this.bty = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.btm.bxs()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.btm.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.btq.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.btq.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.btm.getMaxItemNum();
                        int size = MultiImgToolView.this.btq.size();
                        MultiImgToolView.this.bto.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.btq.getChosedFiles().size();
                        if (MultiImgToolView.this.axG != null) {
                            MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.btu, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btv, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.btv, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.btw) {
                                    MultiImgToolView.this.axG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.btq, true);
                                MultiImgToolView.this.bto.setText(MultiImgToolView.this.btx);
                                MultiImgToolView.this.axG.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.btm = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.bto = (TextView) findViewById(d.g.muti_image_tips);
        this.btp = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.btt = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.btr = bVar;
    }

    public int getImageNum() {
        return this.btq.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.btq = writeImagesInfo;
        this.bts = new b(getContext(), this.btr, this, this.bty, this.btv == 10);
        this.bts.a(this.btq);
        this.btm.a(this.bts, z);
        int maxItemNum = this.btm.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.btt)) {
            this.bto.setText(this.btt);
        } else if (!btl && size > 1) {
            this.bto.setText(d.j.editor_mutiiamge_drag_tip);
            btl = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.bto.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.bts != null) {
                        this.bts.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.btv, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).bti, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).btj);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axH = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axH;
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
        if (i != i2 && this.btq != null && this.btq.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.btq.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.btm;
    }

    public TextView getMutiImageTips() {
        return this.bto;
    }

    public DragLayer getDragLayer() {
        return this.btp;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo btA = null;
        private s btB;
        private a btC;
        private boolean btD;
        private com.baidu.tbadk.img.b btr;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.btD = true;
            this.mContext = context;
            this.btr = bVar;
            this.btB = sVar;
            this.btC = aVar;
            this.btD = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.btA = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.btA == null) {
                return 0;
            }
            return this.btA.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.btA.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.btA.getChosedFiles(), i);
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
                if (this.btr.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.btD) {
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
                            } else if (b.this.btB != null) {
                                b.this.btB.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.btC != null) {
                        b.this.btC.bi(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.btu = i;
    }

    public void setTargetToolId(int i) {
        this.btv = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.t(this, d.C0141d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.btw = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.btx = " ";
        } else {
            this.btx = str;
        }
    }
}
