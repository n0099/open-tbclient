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
    private static boolean ctZ = false;
    private EditorTools TT;
    private int TU;
    private DragHorizonScrollView cua;
    private TextView cub;
    private DragLayer cuc;
    private WriteImagesInfo cud;
    private com.baidu.tbadk.img.b cue;
    private b cuf;
    private String cug;
    private int cuh;
    private int cui;
    private boolean cuj;
    private String cuk;
    private a cul;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void be(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.cug = null;
        this.cuh = 13;
        this.cui = 10;
        this.cuj = false;
        this.cul = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void be(View view) {
                if (!MultiImgToolView.this.cua.cra()) {
                    MultiImgToolView.this.cT(view);
                    int cU = MultiImgToolView.this.cua.cU(view);
                    if (cU >= 0 && cU < MultiImgToolView.this.cud.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cud.getChosedFiles().remove(cU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cua.getMaxItemNum();
                        int size = MultiImgToolView.this.cud.size();
                        MultiImgToolView.this.cub.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cud.getChosedFiles().size();
                        if (MultiImgToolView.this.TT != null) {
                            MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cuh, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cui, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cui, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cuj) {
                                    MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cud, true);
                                MultiImgToolView.this.cub.setText(MultiImgToolView.this.cuk);
                                MultiImgToolView.this.TT.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cug = null;
        this.cuh = 13;
        this.cui = 10;
        this.cuj = false;
        this.cul = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void be(View view) {
                if (!MultiImgToolView.this.cua.cra()) {
                    MultiImgToolView.this.cT(view);
                    int cU = MultiImgToolView.this.cua.cU(view);
                    if (cU >= 0 && cU < MultiImgToolView.this.cud.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cud.getChosedFiles().remove(cU);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cua.getMaxItemNum();
                        int size = MultiImgToolView.this.cud.size();
                        MultiImgToolView.this.cub.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cud.getChosedFiles().size();
                        if (MultiImgToolView.this.TT != null) {
                            MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cuh, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cui, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cui, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cuj) {
                                    MultiImgToolView.this.TT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cud, true);
                                MultiImgToolView.this.cub.setText(MultiImgToolView.this.cuk);
                                MultiImgToolView.this.TT.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cua = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.cub = (TextView) findViewById(R.id.muti_image_tips);
        this.cuc = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.cug = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.cue = bVar;
    }

    public int getImageNum() {
        return this.cud.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.cud = writeImagesInfo;
        this.cuf = new b(getContext(), this.cue, this, this.cul, this.cui == 10);
        this.cuf.a(this.cud);
        this.cua.setAdapter(this.cuf, z);
        int maxItemNum = this.cua.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.cug)) {
            this.cub.setText(this.cug);
        } else if (!ctZ && size > 1) {
            this.cub.setText(R.string.editor_mutiiamge_drag_tip);
            ctZ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.cub.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.cuf != null) {
                        this.cuf.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.cui, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ctW, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ctX);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aj(int i, int i2) {
        if (i != i2 && this.cud != null && this.cud.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cud.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.cua;
    }

    public TextView getMutiImageTips() {
        return this.cub;
    }

    public DragLayer getDragLayer() {
        return this.cuc;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b cue;
        private WriteImagesInfo cun = null;
        private l cuo;
        private a cup;
        private boolean cuq;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.cuq = true;
            this.mContext = context;
            this.cue = bVar;
            this.cuo = lVar;
            this.cup = aVar;
            this.cuq = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.cun = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cun == null) {
                return 0;
            }
            return this.cun.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.cun.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.cun.getChosedFiles(), i);
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
                if (this.cue.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.cuq) {
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
                            } else if (b.this.cuo != null) {
                                b.this.cuo.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.cup != null) {
                        b.this.cup.be(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.cuh = i;
    }

    public void setTargetToolId(int i) {
        this.cui = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.l(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.cuj = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.cuk = " ";
        } else {
            this.cuk = str;
        }
    }
}
