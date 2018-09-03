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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean aNe = false;
    private EditorTools Qg;
    private int Qh;
    private DragHorizonScrollView aNf;
    private TextView aNg;
    private DragLayer aNh;
    private WriteImagesInfo aNi;
    private com.baidu.tbadk.img.b aNj;
    private b aNk;
    private String aNl;
    private int aNm;
    private int aNn;
    private boolean aNo;
    private String aNp;
    private a aNq;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void O(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aNl = null;
        this.aNm = 13;
        this.aNn = 10;
        this.aNo = false;
        this.aNq = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void O(View view) {
                if (!MultiImgToolView.this.aNf.bwH()) {
                    MultiImgToolView.this.bB(view);
                    int bC = MultiImgToolView.this.aNf.bC(view);
                    if (bC >= 0 && bC < MultiImgToolView.this.aNi.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aNi.getChosedFiles().remove(bC);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aNf.getMaxItemNum();
                        int size = MultiImgToolView.this.aNi.size();
                        MultiImgToolView.this.aNg.setText(MultiImgToolView.this.getResources().getString(f.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aNi.getChosedFiles().size();
                        if (MultiImgToolView.this.Qg != null) {
                            MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aNm, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNn, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNn, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aNo) {
                                    MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aNi, true);
                                MultiImgToolView.this.aNg.setText(MultiImgToolView.this.aNp);
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
        this.aNl = null;
        this.aNm = 13;
        this.aNn = 10;
        this.aNo = false;
        this.aNq = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void O(View view) {
                if (!MultiImgToolView.this.aNf.bwH()) {
                    MultiImgToolView.this.bB(view);
                    int bC = MultiImgToolView.this.aNf.bC(view);
                    if (bC >= 0 && bC < MultiImgToolView.this.aNi.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.aNi.getChosedFiles().remove(bC);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.aNf.getMaxItemNum();
                        int size = MultiImgToolView.this.aNi.size();
                        MultiImgToolView.this.aNg.setText(MultiImgToolView.this.getResources().getString(f.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.aNi.getChosedFiles().size();
                        if (MultiImgToolView.this.Qg != null) {
                            MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.aNm, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNn, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.aNn, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.aNo) {
                                    MultiImgToolView.this.Qg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.aNi, true);
                                MultiImgToolView.this.aNg.setText(MultiImgToolView.this.aNp);
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
        this.aNf = (DragHorizonScrollView) findViewById(f.g.muti_image_upload_dragscrollview);
        this.aNg = (TextView) findViewById(f.g.muti_image_tips);
        this.aNh = (DragLayer) findViewById(f.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aNl = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aNj = bVar;
    }

    public int getImageNum() {
        return this.aNi.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aNi = writeImagesInfo;
        this.aNk = new b(getContext(), this.aNj, this, this.aNq, this.aNn == 10);
        this.aNk.a(this.aNi);
        this.aNf.setAdapter(this.aNk, z);
        int maxItemNum = this.aNf.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aNl)) {
            this.aNg.setText(this.aNl);
        } else if (!aNe && size > 1) {
            this.aNg.setText(f.j.editor_mutiiamge_drag_tip);
            aNe = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aNg.setText(getResources().getString(f.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aNk != null) {
                        this.aNk.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aNn, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aNb, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aNc);
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
    public void oC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void G(int i, int i2) {
        if (i != i2 && this.aNi != null && this.aNi.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aNi.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aNf;
    }

    public TextView getMutiImageTips() {
        return this.aNg;
    }

    public DragLayer getDragLayer() {
        return this.aNh;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aNj;
        private WriteImagesInfo aNs = null;
        private l aNt;
        private a aNu;
        private boolean aNv;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.aNv = true;
            this.mContext = context;
            this.aNj = bVar;
            this.aNt = lVar;
            this.aNu = aVar;
            this.aNv = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aNs = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aNs == null) {
                return 0;
            }
            return this.aNs.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aNs.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(f.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) w.d(this.aNs.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(f.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(f.e.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(f.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(f.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(f.g.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                am.i(frameLayout3, f.C0146f.bg_add_photo);
                frameLayout3.setForeground(am.getDrawable(f.C0146f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.I(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aNj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.aNv) {
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
                                com.baidu.adp.lib.util.l.e(b.this.mContext, f.j.editor_mutiiamge_image_error);
                            } else if (b.this.aNt != null) {
                                b.this.aNt.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(f.g.delete);
            am.c(imageView, f.C0146f.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.aNu != null) {
                        b.this.aNu.O(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(f.j.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aNm = i;
    }

    public void setTargetToolId(int i) {
        this.aNn = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.j(this, f.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aNo = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aNp = " ";
        } else {
            this.aNp = str;
        }
    }
}
