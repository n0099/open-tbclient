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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
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
public class MultiImgToolView extends DragContainer implements n, DragHorizonScrollView.a {
    private static boolean fvl = false;
    private EditorTools acn;
    private int aco;
    private DragHorizonScrollView fvm;
    private TextView fvn;
    private DragLayer fvo;
    private WriteImagesInfo fvp;
    private com.baidu.tbadk.img.b fvq;
    private b fvr;
    private String fvs;
    private int fvt;
    private int fvu;
    private boolean fvv;
    private String fvw;
    private a fvx;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bH(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.fvs = null;
        this.fvt = 13;
        this.fvu = 10;
        this.fvv = false;
        this.fvx = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bH(View view) {
                if (!MultiImgToolView.this.fvm.dPH()) {
                    MultiImgToolView.this.ea(view);
                    int eb = MultiImgToolView.this.fvm.eb(view);
                    if (eb >= 0 && eb < MultiImgToolView.this.fvp.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fvp.getChosedFiles().remove(eb);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fvm.getMaxItemNum();
                        int size = MultiImgToolView.this.fvp.size();
                        MultiImgToolView.this.fvn.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fvp.getChosedFiles().size();
                        if (MultiImgToolView.this.acn != null) {
                            MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fvt, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fvu, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fvu, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fvv) {
                                    MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fvp, true);
                                MultiImgToolView.this.fvn.setText(MultiImgToolView.this.fvw);
                                MultiImgToolView.this.acn.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvs = null;
        this.fvt = 13;
        this.fvu = 10;
        this.fvv = false;
        this.fvx = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bH(View view) {
                if (!MultiImgToolView.this.fvm.dPH()) {
                    MultiImgToolView.this.ea(view);
                    int eb = MultiImgToolView.this.fvm.eb(view);
                    if (eb >= 0 && eb < MultiImgToolView.this.fvp.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fvp.getChosedFiles().remove(eb);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fvm.getMaxItemNum();
                        int size = MultiImgToolView.this.fvp.size();
                        MultiImgToolView.this.fvn.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fvp.getChosedFiles().size();
                        if (MultiImgToolView.this.acn != null) {
                            MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fvt, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fvu, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fvu, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fvv) {
                                    MultiImgToolView.this.acn.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fvp, true);
                                MultiImgToolView.this.fvn.setText(MultiImgToolView.this.fvw);
                                MultiImgToolView.this.acn.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fvm = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.fvn = (TextView) findViewById(R.id.muti_image_tips);
        this.fvo = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.fvs = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.fvq = bVar;
    }

    public int getImageNum() {
        return this.fvp.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.fvp = writeImagesInfo;
        this.fvr = new b(getContext(), this.fvq, this, this.fvx, this.fvu == 10);
        this.fvr.a(this.fvp);
        this.fvm.setAdapter(this.fvr, z);
        int maxItemNum = this.fvm.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.fvs)) {
            this.fvn.setText(this.fvs);
        } else if (!fvl && size > 1) {
            this.fvn.setText(R.string.editor_mutiiamge_drag_tip);
            fvl = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.fvn.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.fvr != null) {
                        this.fvr.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.fvu, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fvi, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fvj);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void bh(int i, int i2) {
        if (i != i2 && this.fvp != null && this.fvp.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.fvp.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.fvm;
    }

    public TextView getMutiImageTips() {
        return this.fvn;
    }

    public DragLayer getDragLayer() {
        return this.fvo;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private n fvA;
        private a fvB;
        private boolean fvC;
        private com.baidu.tbadk.img.b fvq;
        private WriteImagesInfo fvz = null;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.fvC = true;
            this.mContext = context;
            this.fvq = bVar;
            this.fvA = nVar;
            this.fvB = aVar;
            this.fvC = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.fvz = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fvz == null) {
                return 0;
            }
            return this.fvz.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.fvz.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.fvz.getChosedFiles(), i);
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
                ap.setBackgroundResource(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(ap.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bi(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.fvq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.fvC) {
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
                                l.showLongToast(b.this.mContext, R.string.editor_mutiiamge_image_error);
                            } else if (b.this.fvA != null) {
                                b.this.fvA.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            ap.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fvB != null) {
                        b.this.fvB.bH(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.fvt = i;
    }

    public void setTargetToolId(int i) {
        this.fvu = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.fvv = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.fvw = " ";
        } else {
            this.fvw = str;
        }
    }
}
