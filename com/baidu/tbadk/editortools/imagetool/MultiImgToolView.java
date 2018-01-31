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
    private static boolean brl = false;
    private i axQ;
    private int axR;
    private DragHorizonScrollView brm;
    private TextView brn;
    private DragLayer bro;
    private WriteImagesInfo brp;
    private com.baidu.tbadk.img.b brq;
    private b brr;
    private String brs;
    private int brt;
    private int bru;
    private boolean brv;
    private String brw;
    private a brx;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bi(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.brs = null;
        this.brt = 13;
        this.bru = 10;
        this.brv = false;
        this.brx = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.brm.bwk()) {
                    MultiImgToolView.this.cQ(view);
                    int cR = MultiImgToolView.this.brm.cR(view);
                    if (cR >= 0 && cR < MultiImgToolView.this.brp.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.brp.getChosedFiles().remove(cR);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.brm.getMaxItemNum();
                        int size = MultiImgToolView.this.brp.size();
                        MultiImgToolView.this.brn.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.brp.getChosedFiles().size();
                        if (MultiImgToolView.this.axQ != null) {
                            MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.brt, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bru, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bru, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.brv) {
                                    MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.brp, true);
                                MultiImgToolView.this.brn.setText(MultiImgToolView.this.brw);
                                MultiImgToolView.this.axQ.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brs = null;
        this.brt = 13;
        this.bru = 10;
        this.brv = false;
        this.brx = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.brm.bwk()) {
                    MultiImgToolView.this.cQ(view);
                    int cR = MultiImgToolView.this.brm.cR(view);
                    if (cR >= 0 && cR < MultiImgToolView.this.brp.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.brp.getChosedFiles().remove(cR);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.brm.getMaxItemNum();
                        int size = MultiImgToolView.this.brp.size();
                        MultiImgToolView.this.brn.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.brp.getChosedFiles().size();
                        if (MultiImgToolView.this.axQ != null) {
                            MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.brt, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bru, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bru, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.brv) {
                                    MultiImgToolView.this.axQ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.brp, true);
                                MultiImgToolView.this.brn.setText(MultiImgToolView.this.brw);
                                MultiImgToolView.this.axQ.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.brm = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.brn = (TextView) findViewById(d.g.muti_image_tips);
        this.bro = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.brs = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.brq = bVar;
    }

    public int getImageNum() {
        return this.brp.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.brp = writeImagesInfo;
        this.brr = new b(getContext(), this.brq, this, this.brx, this.bru == 10);
        this.brr.a(this.brp);
        this.brm.a(this.brr, z);
        int maxItemNum = this.brm.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.brs)) {
            this.brn.setText(this.brs);
        } else if (!brl && size > 1) {
            this.brn.setText(d.j.editor_mutiiamge_drag_tip);
            brl = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.brn.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.brr != null) {
                        this.brr.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.bru, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).bri, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).brj);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axQ = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void ti() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aG(int i, int i2) {
        if (i != i2 && this.brp != null && this.brp.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.brp.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.brm;
    }

    public TextView getMutiImageTips() {
        return this.brn;
    }

    public DragLayer getDragLayer() {
        return this.bro;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private s brA;
        private a brB;
        private boolean brC;
        private com.baidu.tbadk.img.b brq;
        private WriteImagesInfo brz = null;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.brC = true;
            this.mContext = context;
            this.brq = bVar;
            this.brA = sVar;
            this.brB = aVar;
            this.brC = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.brz = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.brz == null) {
                return 0;
            }
            return this.brz.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.brz.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.brz.getChosedFiles(), i);
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
                if (this.brq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.brC) {
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
                            } else if (b.this.brA != null) {
                                b.this.brA.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.brB != null) {
                        b.this.brB.bi(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.brt = i;
    }

    public void setTargetToolId(int i) {
        this.bru = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.t(this, d.C0108d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.brv = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.brw = " ";
        } else {
            this.brw = str;
        }
    }
}
