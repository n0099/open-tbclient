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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean aZX = false;
    private EditorTools Tj;
    private int Tk;
    private DragHorizonScrollView aZY;
    private TextView aZZ;
    private DragLayer baa;
    private WriteImagesInfo bab;
    private com.baidu.tbadk.img.b bac;
    private b bad;
    private String bae;
    private int baf;
    private int bag;
    private boolean bah;
    private String bai;
    private a baj;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void ab(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.bae = null;
        this.baf = 13;
        this.bag = 10;
        this.bah = false;
        this.baj = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aZY.bFr()) {
                    MultiImgToolView.this.bT(view);
                    int bU = MultiImgToolView.this.aZY.bU(view);
                    if (bU >= 0 && bU < MultiImgToolView.this.bab.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.bab.getChosedFiles().remove(bU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aZY.getMaxItemNum();
                        int size = MultiImgToolView.this.bab.size();
                        MultiImgToolView.this.aZZ.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.bab.getChosedFiles().size();
                        if (MultiImgToolView.this.Tj != null) {
                            MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.baf, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bag, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bag, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.bah) {
                                    MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.bab, true);
                                MultiImgToolView.this.aZZ.setText(MultiImgToolView.this.bai);
                                MultiImgToolView.this.Tj.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bae = null;
        this.baf = 13;
        this.bag = 10;
        this.bah = false;
        this.baj = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aZY.bFr()) {
                    MultiImgToolView.this.bT(view);
                    int bU = MultiImgToolView.this.aZY.bU(view);
                    if (bU >= 0 && bU < MultiImgToolView.this.bab.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.bab.getChosedFiles().remove(bU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aZY.getMaxItemNum();
                        int size = MultiImgToolView.this.bab.size();
                        MultiImgToolView.this.aZZ.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.bab.getChosedFiles().size();
                        if (MultiImgToolView.this.Tj != null) {
                            MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.baf, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bag, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.bag, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.bah) {
                                    MultiImgToolView.this.Tj.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.bab, true);
                                MultiImgToolView.this.aZZ.setText(MultiImgToolView.this.bai);
                                MultiImgToolView.this.Tj.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aZY = (DragHorizonScrollView) findViewById(e.g.muti_image_upload_dragscrollview);
        this.aZZ = (TextView) findViewById(e.g.muti_image_tips);
        this.baa = (DragLayer) findViewById(e.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.bae = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.bac = bVar;
    }

    public int getImageNum() {
        return this.bab.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.bab = writeImagesInfo;
        this.bad = new b(getContext(), this.bac, this, this.baj, this.bag == 10);
        this.bad.a(this.bab);
        this.aZY.setAdapter(this.bad, z);
        int maxItemNum = this.aZY.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.bae)) {
            this.aZZ.setText(this.bae);
        } else if (!aZX && size > 1) {
            this.aZZ.setText(e.j.editor_mutiiamge_drag_tip);
            aZX = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aZZ.setText(getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.bad != null) {
                        this.bad.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.bag, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aZU, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aZV);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.bab != null && this.bab.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.bab.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aZY;
    }

    public TextView getMutiImageTips() {
        return this.aZZ;
    }

    public DragLayer getDragLayer() {
        return this.baa;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b bac;
        private WriteImagesInfo bal = null;
        private l bam;
        private a ban;
        private boolean bao;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.bao = true;
            this.mContext = context;
            this.bac = bVar;
            this.bam = lVar;
            this.ban = aVar;
            this.bao = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.bal = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bal == null) {
                return 0;
            }
            return this.bal.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.bal.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(e.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.bal.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(e.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(e.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(e.g.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                al.i(frameLayout3, e.f.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(e.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.L(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.bac.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.bao) {
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
                                com.baidu.adp.lib.util.l.g(b.this.mContext, e.j.editor_mutiiamge_image_error);
                            } else if (b.this.bam != null) {
                                b.this.bam.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(e.g.delete);
            al.c(imageView, e.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ban != null) {
                        b.this.ban.ab(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(e.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.baf = i;
    }

    public void setTargetToolId(int i) {
        this.bag = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.bah = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.bai = " ";
        } else {
            this.bai = str;
        }
    }
}
