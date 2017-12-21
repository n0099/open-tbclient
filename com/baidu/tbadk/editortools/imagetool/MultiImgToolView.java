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
    private static boolean aCY = false;
    private i IS;
    private int IT;
    private DragHorizonScrollView aCZ;
    private TextView aDa;
    private DragLayer aDb;
    private WriteImagesInfo aDc;
    private com.baidu.tbadk.img.b aDd;
    private b aDe;
    private String aDf;
    private int aDg;
    private int aDh;
    private boolean aDi;
    private String aDj;
    private a aDk;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void N(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aDf = null;
        this.aDg = 13;
        this.aDh = 10;
        this.aDi = false;
        this.aDk = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view) {
                if (!MultiImgToolView.this.aCZ.bxw()) {
                    MultiImgToolView.this.bI(view);
                    int bJ = MultiImgToolView.this.aCZ.bJ(view);
                    if (bJ >= 0 && bJ < MultiImgToolView.this.aDc.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDc.getChosedFiles().remove(bJ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCZ.getMaxItemNum();
                        int size = MultiImgToolView.this.aDc.size();
                        MultiImgToolView.this.aDa.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDc.getChosedFiles().size();
                        if (MultiImgToolView.this.IS != null) {
                            MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDg, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDh, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDh, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDi) {
                                    MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDc, true);
                                MultiImgToolView.this.aDa.setText(MultiImgToolView.this.aDj);
                                MultiImgToolView.this.IS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDf = null;
        this.aDg = 13;
        this.aDh = 10;
        this.aDi = false;
        this.aDk = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view) {
                if (!MultiImgToolView.this.aCZ.bxw()) {
                    MultiImgToolView.this.bI(view);
                    int bJ = MultiImgToolView.this.aCZ.bJ(view);
                    if (bJ >= 0 && bJ < MultiImgToolView.this.aDc.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aDc.getChosedFiles().remove(bJ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aCZ.getMaxItemNum();
                        int size = MultiImgToolView.this.aDc.size();
                        MultiImgToolView.this.aDa.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aDc.getChosedFiles().size();
                        if (MultiImgToolView.this.IS != null) {
                            MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aDg, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDh, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aDh, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aDi) {
                                    MultiImgToolView.this.IS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aDc, true);
                                MultiImgToolView.this.aDa.setText(MultiImgToolView.this.aDj);
                                MultiImgToolView.this.IS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aCZ = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aDa = (TextView) findViewById(d.g.muti_image_tips);
        this.aDb = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aDf = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDd = bVar;
    }

    public int getImageNum() {
        return this.aDc.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDc = writeImagesInfo;
        this.aDe = new b(getContext(), this.aDd, this, this.aDk, this.aDh == 10);
        this.aDe.a(this.aDc);
        this.aCZ.a(this.aDe, z);
        int maxItemNum = this.aCZ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aDf)) {
            this.aDa.setText(this.aDf);
        } else if (!aCY && size > 1) {
            this.aDa.setText(d.j.editor_mutiiamge_drag_tip);
            aCY = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aDa.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aDe != null) {
                        this.aDe.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDh, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCV, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCW);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IS = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.aDc != null && this.aDc.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDc.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aCZ;
    }

    public TextView getMutiImageTips() {
        return this.aDa;
    }

    public DragLayer getDragLayer() {
        return this.aDb;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDd;
        private WriteImagesInfo aDm = null;
        private s aDn;
        private a aDo;
        private boolean aDp;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDp = true;
            this.mContext = context;
            this.aDd = bVar;
            this.aDn = sVar;
            this.aDo = aVar;
            this.aDp = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDm = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDm == null) {
                return 0;
            }
            return this.aDm.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDm.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aDm.getChosedFiles(), i);
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
                aj.j(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(aj.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aDd.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aDp) {
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
                                l.e(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.aDn != null) {
                                b.this.aDn.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aDo != null) {
                        b.this.aDo.N(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aDg = i;
    }

    public void setTargetToolId(int i) {
        this.aDh = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.C0095d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDi = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aDj = " ";
        } else {
            this.aDj = str;
        }
    }
}
