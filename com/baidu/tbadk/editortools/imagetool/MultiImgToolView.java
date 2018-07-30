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
import com.baidu.tbadk.core.util.am;
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
    private static boolean aNh = false;
    private EditorTools Qg;
    private int Qh;
    private DragHorizonScrollView aNi;
    private TextView aNj;
    private DragLayer aNk;
    private WriteImagesInfo aNl;
    private com.baidu.tbadk.img.b aNm;
    private b aNn;
    private String aNo;
    private int aNp;
    private int aNq;
    private boolean aNr;
    private String aNs;
    private a aNt;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void O(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aNo = null;
        this.aNp = 13;
        this.aNq = 10;
        this.aNr = false;
        this.aNt = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void O(View view) {
                if (!MultiImgToolView.this.aNi.bwG()) {
                    MultiImgToolView.this.bB(view);
                    int bC = MultiImgToolView.this.aNi.bC(view);
                    if (bC >= 0 && bC < MultiImgToolView.this.aNl.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aNl.getChosedFiles().remove(bC);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aNi.getMaxItemNum();
                        int size = MultiImgToolView.this.aNl.size();
                        MultiImgToolView.this.aNj.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aNl.getChosedFiles().size();
                        if (MultiImgToolView.this.Qg != null) {
                            MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aNp, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNq, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNq, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aNr) {
                                    MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aNl, true);
                                MultiImgToolView.this.aNj.setText(MultiImgToolView.this.aNs);
                                MultiImgToolView.this.Qg.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNo = null;
        this.aNp = 13;
        this.aNq = 10;
        this.aNr = false;
        this.aNt = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void O(View view) {
                if (!MultiImgToolView.this.aNi.bwG()) {
                    MultiImgToolView.this.bB(view);
                    int bC = MultiImgToolView.this.aNi.bC(view);
                    if (bC >= 0 && bC < MultiImgToolView.this.aNl.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aNl.getChosedFiles().remove(bC);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aNi.getMaxItemNum();
                        int size = MultiImgToolView.this.aNl.size();
                        MultiImgToolView.this.aNj.setText(MultiImgToolView.this.getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aNl.getChosedFiles().size();
                        if (MultiImgToolView.this.Qg != null) {
                            MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aNp, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNq, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNq, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aNr) {
                                    MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aNl, true);
                                MultiImgToolView.this.aNj.setText(MultiImgToolView.this.aNs);
                                MultiImgToolView.this.Qg.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aNi = (DragHorizonScrollView) findViewById(d.g.muti_image_upload_dragscrollview);
        this.aNj = (TextView) findViewById(d.g.muti_image_tips);
        this.aNk = (DragLayer) findViewById(d.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aNo = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aNm = bVar;
    }

    public int getImageNum() {
        return this.aNl.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aNl = writeImagesInfo;
        this.aNn = new b(getContext(), this.aNm, this, this.aNt, this.aNq == 10);
        this.aNn.a(this.aNl);
        this.aNi.setAdapter(this.aNn, z);
        int maxItemNum = this.aNi.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aNo)) {
            this.aNj.setText(this.aNo);
        } else if (!aNh && size > 1) {
            this.aNj.setText(d.j.editor_mutiiamge_drag_tip);
            aNh = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aNj.setText(getResources().getString(d.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aNn != null) {
                        this.aNn.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aNq, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aNe, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aNf);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void G(int i, int i2) {
        if (i != i2 && this.aNl != null && this.aNl.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aNl.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aNi;
    }

    public TextView getMutiImageTips() {
        return this.aNj;
    }

    public DragLayer getDragLayer() {
        return this.aNk;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aNm;
        private WriteImagesInfo aNv = null;
        private l aNw;
        private a aNx;
        private boolean aNy;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aNy = true;
            this.mContext = context;
            this.aNm = bVar;
            this.aNw = lVar;
            this.aNx = aVar;
            this.aNy = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aNv = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aNv == null) {
                return 0;
            }
            return this.aNv.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aNv.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(this.aNv.getChosedFiles(), i);
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
                am.i(frameLayout3, d.f.bg_add_photo);
                frameLayout3.setForeground(am.getDrawable(d.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.I(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aNm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aNy) {
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
                                com.baidu.adp.lib.util.l.e(b.this.mContext, d.j.editor_mutiiamge_image_error);
                            } else if (b.this.aNw != null) {
                                b.this.aNw.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.g.delete);
            am.c(imageView, d.f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.aNx != null) {
                        b.this.aNx.O(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aNp = i;
    }

    public void setTargetToolId(int i) {
        this.aNq = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.j(this, d.C0140d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aNr = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aNs = " ";
        } else {
            this.aNs = str;
        }
    }
}
