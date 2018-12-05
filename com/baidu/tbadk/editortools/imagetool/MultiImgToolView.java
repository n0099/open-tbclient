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
    private static boolean aZk = false;
    private EditorTools Ta;
    private int Tb;
    private DragHorizonScrollView aZl;
    private TextView aZm;
    private DragLayer aZn;
    private WriteImagesInfo aZo;
    private com.baidu.tbadk.img.b aZp;
    private b aZq;
    private String aZr;
    private int aZs;
    private int aZt;
    private boolean aZu;
    private String aZv;
    private a aZw;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void ab(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aZr = null;
        this.aZs = 13;
        this.aZt = 10;
        this.aZu = false;
        this.aZw = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aZl.bDR()) {
                    MultiImgToolView.this.bQ(view);
                    int bR = MultiImgToolView.this.aZl.bR(view);
                    if (bR >= 0 && bR < MultiImgToolView.this.aZo.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aZo.getChosedFiles().remove(bR);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aZl.getMaxItemNum();
                        int size = MultiImgToolView.this.aZo.size();
                        MultiImgToolView.this.aZm.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aZo.getChosedFiles().size();
                        if (MultiImgToolView.this.Ta != null) {
                            MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aZs, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZt, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZt, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aZu) {
                                    MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aZo, true);
                                MultiImgToolView.this.aZm.setText(MultiImgToolView.this.aZv);
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
        this.aZr = null;
        this.aZs = 13;
        this.aZt = 10;
        this.aZu = false;
        this.aZw = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void ab(View view) {
                if (!MultiImgToolView.this.aZl.bDR()) {
                    MultiImgToolView.this.bQ(view);
                    int bR = MultiImgToolView.this.aZl.bR(view);
                    if (bR >= 0 && bR < MultiImgToolView.this.aZo.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aZo.getChosedFiles().remove(bR);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aZl.getMaxItemNum();
                        int size = MultiImgToolView.this.aZo.size();
                        MultiImgToolView.this.aZm.setText(MultiImgToolView.this.getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aZo.getChosedFiles().size();
                        if (MultiImgToolView.this.Ta != null) {
                            MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aZs, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZt, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aZt, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aZu) {
                                    MultiImgToolView.this.Ta.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aZo, true);
                                MultiImgToolView.this.aZm.setText(MultiImgToolView.this.aZv);
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
        this.aZl = (DragHorizonScrollView) findViewById(e.g.muti_image_upload_dragscrollview);
        this.aZm = (TextView) findViewById(e.g.muti_image_tips);
        this.aZn = (DragLayer) findViewById(e.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aZr = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aZp = bVar;
    }

    public int getImageNum() {
        return this.aZo.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aZo = writeImagesInfo;
        this.aZq = new b(getContext(), this.aZp, this, this.aZw, this.aZt == 10);
        this.aZq.a(this.aZo);
        this.aZl.setAdapter(this.aZq, z);
        int maxItemNum = this.aZl.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aZr)) {
            this.aZm.setText(this.aZr);
        } else if (!aZk && size > 1) {
            this.aZm.setText(e.j.editor_mutiiamge_drag_tip);
            aZk = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aZm.setText(getResources().getString(e.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aZq != null) {
                        this.aZq.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aZt, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aZh, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aZi);
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
        if (i != i2 && this.aZo != null && this.aZo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aZo.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aZl;
    }

    public TextView getMutiImageTips() {
        return this.aZm;
    }

    public DragLayer getDragLayer() {
        return this.aZn;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private a aZA;
        private boolean aZB;
        private com.baidu.tbadk.img.b aZp;
        private WriteImagesInfo aZy = null;
        private l aZz;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aZB = true;
            this.mContext = context;
            this.aZp = bVar;
            this.aZz = lVar;
            this.aZA = aVar;
            this.aZB = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aZy = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aZy == null) {
                return 0;
            }
            return this.aZy.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aZy.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(e.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.aZy.getChosedFiles(), i);
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
                if (this.aZp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aZB) {
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
                            } else if (b.this.aZz != null) {
                                b.this.aZz.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.aZA != null) {
                        b.this.aZA.ab(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(e.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aZs = i;
    }

    public void setTargetToolId(int i) {
        this.aZt = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.j(this, e.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aZu = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aZv = " ";
        } else {
            this.aZv = str;
        }
    }
}
