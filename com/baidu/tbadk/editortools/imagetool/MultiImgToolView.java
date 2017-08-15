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
    private static boolean aDe = false;
    private int Ls;
    private i Lt;
    private DragHorizonScrollView aDf;
    private TextView aDg;
    private DragLayer aDh;
    private WriteImagesInfo aDi;
    private com.baidu.tbadk.img.b aDj;
    private b aDk;
    private String aDl;
    private int aDm;
    private int aDn;
    private boolean aDo;
    private String aDp;
    private a aDq;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aDl = null;
        this.aDm = 13;
        this.aDn = 10;
        this.aDo = false;
        this.aDq = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void G(View view) {
                if (!MultiImgToolView.this.aDf.btF()) {
                    MultiImgToolView.this.bz(view);
                    int bA = MultiImgToolView.this.aDf.bA(view);
                    if (bA >= 0 && bA < MultiImgToolView.this.aDi.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDi.getChosedFiles().remove(bA);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDf.getMaxItemNum();
                        int size = MultiImgToolView.this.aDi.size();
                        MultiImgToolView.this.aDg.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDi.getChosedFiles().size();
                        if (MultiImgToolView.this.Lt != null) {
                            MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDm, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDn, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDn, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDo) {
                                    MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDi, true);
                                MultiImgToolView.this.aDg.setText(MultiImgToolView.this.aDp);
                                MultiImgToolView.this.Lt.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDl = null;
        this.aDm = 13;
        this.aDn = 10;
        this.aDo = false;
        this.aDq = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void G(View view) {
                if (!MultiImgToolView.this.aDf.btF()) {
                    MultiImgToolView.this.bz(view);
                    int bA = MultiImgToolView.this.aDf.bA(view);
                    if (bA >= 0 && bA < MultiImgToolView.this.aDi.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDi.getChosedFiles().remove(bA);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aDf.getMaxItemNum();
                        int size = MultiImgToolView.this.aDi.size();
                        MultiImgToolView.this.aDg.setText(MultiImgToolView.this.getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDi.getChosedFiles().size();
                        if (MultiImgToolView.this.Lt != null) {
                            MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDm, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDn, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDn, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDo) {
                                    MultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDi, true);
                                MultiImgToolView.this.aDg.setText(MultiImgToolView.this.aDp);
                                MultiImgToolView.this.Lt.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aDf = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aDg = (TextView) findViewById(d.h.muti_image_tips);
        this.aDh = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aDl = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDj = bVar;
    }

    public int getImageNum() {
        return this.aDi.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDi = writeImagesInfo;
        this.aDk = new b(getContext(), this.aDj, this, this.aDq, this.aDn == 10);
        this.aDk.a(this.aDi);
        this.aDf.a(this.aDk, z);
        int maxItemNum = this.aDf.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aDl)) {
            this.aDg.setText(this.aDl);
        } else if (!aDe && size > 1) {
            this.aDg.setText(d.l.editor_mutiiamge_drag_tip);
            aDe = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aDg.setText(getResources().getString(d.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aDk != null) {
                        this.aDk.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDn, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDb, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDc);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
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
        if (i != i2 && this.aDi != null && this.aDi.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDi.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aDf;
    }

    public TextView getMutiImageTips() {
        return this.aDg;
    }

    public DragLayer getDragLayer() {
        return this.aDh;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDj;
        private WriteImagesInfo aDs = null;
        private s aDt;
        private a aDu;
        private boolean aDv;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDv = true;
            this.mContext = context;
            this.aDj = bVar;
            this.aDt = sVar;
            this.aDu = aVar;
            this.aDv = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDs = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDs == null) {
                return 0;
            }
            return this.aDs.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDs.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.aDs.getChosedFiles(), i);
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
                if (this.aDj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aDv) {
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
                            } else if (b.this.aDt != null) {
                                b.this.aDt.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aDu != null) {
                        b.this.aDu.G(frameLayout2);
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
        this.aDm = i;
    }

    public void setTargetToolId(int i) {
        this.aDn = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDo = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aDp = " ";
        } else {
            this.aDp = str;
        }
    }
}
