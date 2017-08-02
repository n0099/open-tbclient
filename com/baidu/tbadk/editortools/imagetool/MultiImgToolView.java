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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
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
    private static boolean aBM = false;
    private int JS;
    private i JT;
    private DragHorizonScrollView aBN;
    private TextView aBO;
    private DragLayer aBP;
    private WriteImagesInfo aBQ;
    private com.baidu.tbadk.img.b aBR;
    private b aBS;
    private String aBT;
    private int aBU;
    private int aBV;
    private boolean aBW;
    private String aBX;
    private a aBY;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aBT = null;
        this.aBU = 13;
        this.aBV = 10;
        this.aBW = false;
        this.aBY = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void G(View view) {
                if (!MultiImgToolView.this.aBN.bsQ()) {
                    MultiImgToolView.this.bx(view);
                    int by = MultiImgToolView.this.aBN.by(view);
                    if (by >= 0 && by < MultiImgToolView.this.aBQ.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aBQ.getChosedFiles().remove(by);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aBN.getMaxItemNum();
                        int size = MultiImgToolView.this.aBQ.size();
                        MultiImgToolView.this.aBO.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aBQ.getChosedFiles().size();
                        if (MultiImgToolView.this.JT != null) {
                            MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aBU, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBV, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBV, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aBW) {
                                    MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aBQ, true);
                                MultiImgToolView.this.aBO.setText(MultiImgToolView.this.aBX);
                                MultiImgToolView.this.JT.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBT = null;
        this.aBU = 13;
        this.aBV = 10;
        this.aBW = false;
        this.aBY = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void G(View view) {
                if (!MultiImgToolView.this.aBN.bsQ()) {
                    MultiImgToolView.this.bx(view);
                    int by = MultiImgToolView.this.aBN.by(view);
                    if (by >= 0 && by < MultiImgToolView.this.aBQ.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aBQ.getChosedFiles().remove(by);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aBN.getMaxItemNum();
                        int size = MultiImgToolView.this.aBQ.size();
                        MultiImgToolView.this.aBO.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aBQ.getChosedFiles().size();
                        if (MultiImgToolView.this.JT != null) {
                            MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aBU, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBV, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aBV, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aBW) {
                                    MultiImgToolView.this.JT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aBQ, true);
                                MultiImgToolView.this.aBO.setText(MultiImgToolView.this.aBX);
                                MultiImgToolView.this.JT.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aBN = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aBO = (TextView) findViewById(d.h.muti_image_tips);
        this.aBP = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aBT = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aBR = bVar;
    }

    public int getImageNum() {
        return this.aBQ.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aBQ = writeImagesInfo;
        this.aBS = new b(getContext(), this.aBR, this, this.aBY, this.aBV == 10);
        this.aBS.a(this.aBQ);
        this.aBN.a(this.aBS, z);
        int maxItemNum = this.aBN.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aBT)) {
            this.aBO.setText(this.aBT);
        } else if (!aBM && size > 1) {
            this.aBO.setText(d.l.editor_mutiiamge_drag_tip);
            aBM = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aBO.setText(getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aBS != null) {
                        this.aBS.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aBV, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBJ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBK);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lJ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.aBQ != null && this.aBQ.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aBQ.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aBN;
    }

    public TextView getMutiImageTips() {
        return this.aBO;
    }

    public DragLayer getDragLayer() {
        return this.aBP;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aBR;
        private WriteImagesInfo aCa = null;
        private s aCb;
        private a aCc;
        private boolean aCd;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aCd = true;
            this.mContext = context;
            this.aBR = bVar;
            this.aCb = sVar;
            this.aCc = aVar;
            this.aCd = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aCa = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aCa == null) {
                return 0;
            }
            return this.aCa.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aCa.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.aCa.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.h.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.h.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.h.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                ai.j(frameLayout3, d.g.bg_add_photo);
                frameLayout3.setForeground(ai.getDrawable(d.g.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.L(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aBR.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aCd) {
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
                                k.f(b.this.mContext, d.l.editor_mutiiamge_image_error);
                            } else if (b.this.aCb != null) {
                                b.this.aCb.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.h.delete);
            ai.c(imageView, d.g.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.aCc != null) {
                        b.this.aCc.G(frameLayout2);
                    }
                }
            });
            View findViewById = frameLayout2.findViewById(d.h.gif_icon);
            if (imageFileInfo.isGif() && !imageFileInfo.hasActionsWithoutResize()) {
                findViewById.setVisibility(0);
                ai.j(findViewById, d.g.ic_image_gif);
            } else {
                findViewById.setVisibility(8);
            }
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.l.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aBU = i;
    }

    public void setTargetToolId(int i) {
        this.aBV = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aBW = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aBX = " ";
        } else {
            this.aBX = str;
        }
    }
}
