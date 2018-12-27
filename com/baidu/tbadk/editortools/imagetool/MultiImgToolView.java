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
    private static boolean aZn = false;
    private EditorTools Ta;
    private int Tb;
    private DragHorizonScrollView aZo;
    private TextView aZp;
    private DragLayer aZq;
    private WriteImagesInfo aZr;
    private com.baidu.tbadk.img.b aZs;
    private b aZt;
    private String aZu;
    private int aZv;
    private int aZw;
    private boolean aZx;
    private String aZy;
    private a aZz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void ab(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aZu = null;
        this.aZv = 13;
        this.aZw = 10;
        this.aZx = false;
        this.aZz = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aZo.bEI()) {
                    MultiImgToolView.this.bT(view);
                    int bU = MultiImgToolView.this.aZo.bU(view);
                    if (bU >= 0 && bU < MultiImgToolView.this.aZr.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aZr.getChosedFiles().remove(bU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aZo.getMaxItemNum();
                        int size = MultiImgToolView.this.aZr.size();
                        MultiImgToolView.this.aZp.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aZr.getChosedFiles().size();
                        if (MultiImgToolView.this.Ta != null) {
                            MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aZv, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZw, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZw, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aZx) {
                                    MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aZr, true);
                                MultiImgToolView.this.aZp.setText(MultiImgToolView.this.aZy);
                                MultiImgToolView.this.Ta.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZu = null;
        this.aZv = 13;
        this.aZw = 10;
        this.aZx = false;
        this.aZz = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aZo.bEI()) {
                    MultiImgToolView.this.bT(view);
                    int bU = MultiImgToolView.this.aZo.bU(view);
                    if (bU >= 0 && bU < MultiImgToolView.this.aZr.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aZr.getChosedFiles().remove(bU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aZo.getMaxItemNum();
                        int size = MultiImgToolView.this.aZr.size();
                        MultiImgToolView.this.aZp.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aZr.getChosedFiles().size();
                        if (MultiImgToolView.this.Ta != null) {
                            MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aZv, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZw, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZw, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aZx) {
                                    MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aZr, true);
                                MultiImgToolView.this.aZp.setText(MultiImgToolView.this.aZy);
                                MultiImgToolView.this.Ta.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aZo = (DragHorizonScrollView) findViewById(e.g.muti_image_upload_dragscrollview);
        this.aZp = (TextView) findViewById(e.g.muti_image_tips);
        this.aZq = (DragLayer) findViewById(e.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aZu = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aZs = bVar;
    }

    public int getImageNum() {
        return this.aZr.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aZr = writeImagesInfo;
        this.aZt = new b(getContext(), this.aZs, this, this.aZz, this.aZw == 10);
        this.aZt.a(this.aZr);
        this.aZo.setAdapter(this.aZt, z);
        int maxItemNum = this.aZo.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aZu)) {
            this.aZp.setText(this.aZu);
        } else if (!aZn && size > 1) {
            this.aZp.setText(e.j.editor_mutiiamge_drag_tip);
            aZn = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aZp.setText(getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aZt != null) {
                        this.aZt.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aZw, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aZk, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aZl);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.aZr != null && this.aZr.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aZr.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aZo;
    }

    public TextView getMutiImageTips() {
        return this.aZp;
    }

    public DragLayer getDragLayer() {
        return this.aZq;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo aZB = null;
        private l aZC;
        private a aZD;
        private boolean aZE;
        private com.baidu.tbadk.img.b aZs;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aZE = true;
            this.mContext = context;
            this.aZs = bVar;
            this.aZC = lVar;
            this.aZD = aVar;
            this.aZE = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aZB = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aZB == null) {
                return 0;
            }
            return this.aZB.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aZB.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(e.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.aZB.getChosedFiles(), i);
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
                if (this.aZs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aZE) {
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
                            } else if (b.this.aZC != null) {
                                b.this.aZC.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aZD != null) {
                        b.this.aZD.ab(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(e.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aZv = i;
    }

    public void setTargetToolId(int i) {
        this.aZw = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aZx = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aZy = " ";
        } else {
            this.aZy = str;
        }
    }
}
