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
import com.baidu.tbadk.core.util.w;
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
    private static boolean aMl = false;
    private EditorTools Qh;
    private int Qi;
    private DragHorizonScrollView aMm;
    private TextView aMn;
    private DragLayer aMo;
    private WriteImagesInfo aMp;
    private com.baidu.tbadk.img.b aMq;
    private b aMr;
    private String aMs;
    private int aMt;
    private int aMu;
    private boolean aMv;
    private String aMw;
    private a aMx;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void N(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aMs = null;
        this.aMt = 13;
        this.aMu = 10;
        this.aMv = false;
        this.aMx = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view) {
                if (!MultiImgToolView.this.aMm.bxA()) {
                    MultiImgToolView.this.by(view);
                    int bz = MultiImgToolView.this.aMm.bz(view);
                    if (bz >= 0 && bz < MultiImgToolView.this.aMp.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aMp.getChosedFiles().remove(bz);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gf().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aMm.getMaxItemNum();
                        int size = MultiImgToolView.this.aMp.size();
                        MultiImgToolView.this.aMn.setText(MultiImgToolView.this.getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aMp.getChosedFiles().size();
                        if (MultiImgToolView.this.Qh != null) {
                            MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aMt, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aMu, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aMu, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aMv) {
                                    MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aMp, true);
                                MultiImgToolView.this.aMn.setText(MultiImgToolView.this.aMw);
                                MultiImgToolView.this.Qh.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMs = null;
        this.aMt = 13;
        this.aMu = 10;
        this.aMv = false;
        this.aMx = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void N(View view) {
                if (!MultiImgToolView.this.aMm.bxA()) {
                    MultiImgToolView.this.by(view);
                    int bz = MultiImgToolView.this.aMm.bz(view);
                    if (bz >= 0 && bz < MultiImgToolView.this.aMp.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aMp.getChosedFiles().remove(bz);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gf().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aMm.getMaxItemNum();
                        int size = MultiImgToolView.this.aMp.size();
                        MultiImgToolView.this.aMn.setText(MultiImgToolView.this.getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aMp.getChosedFiles().size();
                        if (MultiImgToolView.this.Qh != null) {
                            MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aMt, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aMu, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aMu, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aMv) {
                                    MultiImgToolView.this.Qh.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aMp, true);
                                MultiImgToolView.this.aMn.setText(MultiImgToolView.this.aMw);
                                MultiImgToolView.this.Qh.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aMm = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aMn = (TextView) findViewById(d.g.muti_image_tips);
        this.aMo = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aMs = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aMq = bVar;
    }

    public int getImageNum() {
        return this.aMp.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aMp = writeImagesInfo;
        this.aMr = new b(getContext(), this.aMq, this, this.aMx, this.aMu == 10);
        this.aMr.a(this.aMp);
        this.aMm.setAdapter(this.aMr, z);
        int maxItemNum = this.aMm.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aMs)) {
            this.aMn.setText(this.aMs);
        } else if (!aMl && size > 1) {
            this.aMn.setText(d.k.editor_mutiiamge_drag_tip);
            aMl = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aMn.setText(getResources().getString(d.k.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aMr != null) {
                        this.aMr.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aMu, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aMi, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aMj);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void F(int i, int i2) {
        if (i != i2 && this.aMp != null && this.aMp.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aMp.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aMm;
    }

    public TextView getMutiImageTips() {
        return this.aMn;
    }

    public DragLayer getDragLayer() {
        return this.aMo;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private l aMA;
        private a aMB;
        private boolean aMC;
        private com.baidu.tbadk.img.b aMq;
        private WriteImagesInfo aMz = null;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aMC = true;
            this.mContext = context;
            this.aMq = bVar;
            this.aMA = lVar;
            this.aMB = aVar;
            this.aMC = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aMz = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aMz == null) {
                return 0;
            }
            return this.aMz.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aMz.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.i.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) w.c(this.aMz.getChosedFiles(), i);
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
                al.i(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.H(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aMq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aMC) {
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
                                com.baidu.adp.lib.util.l.showLongToast(b.this.mContext, d.k.editor_mutiiamge_image_error);
                            } else if (b.this.aMA != null) {
                                b.this.aMA.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.g.delete);
            al.c(imageView, d.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.aMB != null) {
                        b.this.aMB.N(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.k.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aMt = i;
    }

    public void setTargetToolId(int i) {
        this.aMu = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.j(this, d.C0141d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aMv = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aMw = " ";
        } else {
            this.aMw = str;
        }
    }
}
