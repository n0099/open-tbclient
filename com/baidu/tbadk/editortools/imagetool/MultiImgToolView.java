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
    private static boolean aDd = false;
    private int Lq;
    private i Lr;
    private DragHorizonScrollView aDe;
    private TextView aDf;
    private DragLayer aDg;
    private WriteImagesInfo aDh;
    private com.baidu.tbadk.img.b aDi;
    private b aDj;
    private String aDk;
    private int aDl;
    private int aDm;
    private boolean aDn;
    private String aDo;
    private a aDp;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aDk = null;
        this.aDl = 13;
        this.aDm = 10;
        this.aDn = false;
        this.aDp = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void G(View view) {
                if (!MultiImgToolView.this.aDe.bsX()) {
                    MultiImgToolView.this.bx(view);
                    int by = MultiImgToolView.this.aDe.by(view);
                    if (by >= 0 && by < MultiImgToolView.this.aDh.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDh.getChosedFiles().remove(by);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDe.getMaxItemNum();
                        int size = MultiImgToolView.this.aDh.size();
                        MultiImgToolView.this.aDf.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDh.getChosedFiles().size();
                        if (MultiImgToolView.this.Lr != null) {
                            MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDl, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDm, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDm, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDn) {
                                    MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDh, true);
                                MultiImgToolView.this.aDf.setText(MultiImgToolView.this.aDo);
                                MultiImgToolView.this.Lr.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDk = null;
        this.aDl = 13;
        this.aDm = 10;
        this.aDn = false;
        this.aDp = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void G(View view) {
                if (!MultiImgToolView.this.aDe.bsX()) {
                    MultiImgToolView.this.bx(view);
                    int by = MultiImgToolView.this.aDe.by(view);
                    if (by >= 0 && by < MultiImgToolView.this.aDh.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDh.getChosedFiles().remove(by);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDe.getMaxItemNum();
                        int size = MultiImgToolView.this.aDh.size();
                        MultiImgToolView.this.aDf.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDh.getChosedFiles().size();
                        if (MultiImgToolView.this.Lr != null) {
                            MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDl, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDm, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDm, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDn) {
                                    MultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDh, true);
                                MultiImgToolView.this.aDf.setText(MultiImgToolView.this.aDo);
                                MultiImgToolView.this.Lr.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aDe = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aDf = (TextView) findViewById(d.h.muti_image_tips);
        this.aDg = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aDk = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDi = bVar;
    }

    public int getImageNum() {
        return this.aDh.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDh = writeImagesInfo;
        this.aDj = new b(getContext(), this.aDi, this, this.aDp, this.aDm == 10);
        this.aDj.a(this.aDh);
        this.aDe.a(this.aDj, z);
        int maxItemNum = this.aDe.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aDk)) {
            this.aDf.setText(this.aDk);
        } else if (!aDd && size > 1) {
            this.aDf.setText(d.l.editor_mutiiamge_drag_tip);
            aDd = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aDf.setText(getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aDj != null) {
                        this.aDj.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDm, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDa, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDb);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Lq;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.aDh != null && this.aDh.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDh.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aDe;
    }

    public TextView getMutiImageTips() {
        return this.aDf;
    }

    public DragLayer getDragLayer() {
        return this.aDg;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDi;
        private WriteImagesInfo aDr = null;
        private s aDs;
        private a aDt;
        private boolean aDu;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDu = true;
            this.mContext = context;
            this.aDi = bVar;
            this.aDs = sVar;
            this.aDt = aVar;
            this.aDu = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDr = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDr == null) {
                return 0;
            }
            return this.aDr.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDr.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.aDr.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aDi.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aDu) {
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
                            } else if (b.this.aDs != null) {
                                b.this.aDs.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aDt != null) {
                        b.this.aDt.G(frameLayout2);
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
        this.aDl = i;
    }

    public void setTargetToolId(int i) {
        this.aDm = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDn = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aDo = " ";
        } else {
            this.aDo = str;
        }
    }
}
