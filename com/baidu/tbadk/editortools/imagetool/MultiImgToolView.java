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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements l, DragHorizonScrollView.a {
    private static boolean ctd = false;
    private EditorTools TU;
    private int TV;
    private DragHorizonScrollView cte;
    private TextView ctf;
    private DragLayer ctg;
    private WriteImagesInfo cth;
    private com.baidu.tbadk.img.b cti;
    private b ctj;
    private String ctk;
    private int ctl;
    private int ctm;
    private boolean ctn;
    private String cto;
    private a ctp;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void be(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.ctk = null;
        this.ctl = 13;
        this.ctm = 10;
        this.ctn = false;
        this.ctp = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void be(View view) {
                if (!MultiImgToolView.this.cte.cqm()) {
                    MultiImgToolView.this.cT(view);
                    int cU = MultiImgToolView.this.cte.cU(view);
                    if (cU >= 0 && cU < MultiImgToolView.this.cth.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cth.getChosedFiles().remove(cU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cte.getMaxItemNum();
                        int size = MultiImgToolView.this.cth.size();
                        MultiImgToolView.this.ctf.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cth.getChosedFiles().size();
                        if (MultiImgToolView.this.TU != null) {
                            MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.ctl, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.ctm, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.ctm, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.ctn) {
                                    MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cth, true);
                                MultiImgToolView.this.ctf.setText(MultiImgToolView.this.cto);
                                MultiImgToolView.this.TU.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctk = null;
        this.ctl = 13;
        this.ctm = 10;
        this.ctn = false;
        this.ctp = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void be(View view) {
                if (!MultiImgToolView.this.cte.cqm()) {
                    MultiImgToolView.this.cT(view);
                    int cU = MultiImgToolView.this.cte.cU(view);
                    if (cU >= 0 && cU < MultiImgToolView.this.cth.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cth.getChosedFiles().remove(cU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cte.getMaxItemNum();
                        int size = MultiImgToolView.this.cth.size();
                        MultiImgToolView.this.ctf.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cth.getChosedFiles().size();
                        if (MultiImgToolView.this.TU != null) {
                            MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.ctl, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.ctm, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.ctm, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.ctn) {
                                    MultiImgToolView.this.TU.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cth, true);
                                MultiImgToolView.this.ctf.setText(MultiImgToolView.this.cto);
                                MultiImgToolView.this.TU.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cte = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.ctf = (TextView) findViewById(R.id.muti_image_tips);
        this.ctg = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.ctk = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.cti = bVar;
    }

    public int getImageNum() {
        return this.cth.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.cth = writeImagesInfo;
        this.ctj = new b(getContext(), this.cti, this, this.ctp, this.ctm == 10);
        this.ctj.a(this.cth);
        this.cte.setAdapter(this.ctj, z);
        int maxItemNum = this.cte.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.ctk)) {
            this.ctf.setText(this.ctk);
        } else if (!ctd && size > 1) {
            this.ctf.setText(R.string.editor_mutiiamge_drag_tip);
            ctd = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.ctf.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.ctj != null) {
                        this.ctj.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.ctm, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cta, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ctb);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aj(int i, int i2) {
        if (i != i2 && this.cth != null && this.cth.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cth.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.cte;
    }

    public TextView getMutiImageTips() {
        return this.ctf;
    }

    public DragLayer getDragLayer() {
        return this.ctg;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b cti;
        private WriteImagesInfo ctr = null;
        private l cts;
        private a ctt;
        private boolean ctu;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.ctu = true;
            this.mContext = context;
            this.cti = bVar;
            this.cts = lVar;
            this.ctt = aVar;
            this.ctu = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.ctr = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ctr == null) {
                return 0;
            }
            return this.ctr.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.ctr.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.ctr.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(R.dimen.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(R.dimen.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(R.id.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(R.id.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(R.id.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                am.k(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(am.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.al(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.cti.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.ctu) {
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
                                com.baidu.adp.lib.util.l.f(b.this.mContext, R.string.editor_mutiiamge_image_error);
                            } else if (b.this.cts != null) {
                                b.this.cts.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            am.c(imageView, (int) R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ctt != null) {
                        b.this.ctt.be(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.ctl = i;
    }

    public void setTargetToolId(int i) {
        this.ctm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.l(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.ctn = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.cto = " ";
        } else {
            this.cto = str;
        }
    }
}
