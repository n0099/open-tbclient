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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private static boolean fAj = false;
    private EditorTools acX;
    private int acY;
    private DragHorizonScrollView fAk;
    private TextView fAl;
    private DragLayer fAm;
    private WriteImagesInfo fAn;
    private com.baidu.tbadk.img.b fAo;
    private b fAp;
    private String fAq;
    private int fAr;
    private int fAs;
    private boolean fAt;
    private String fAu;
    private a fAv;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bQ(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.fAq = null;
        this.fAr = 13;
        this.fAs = 10;
        this.fAt = false;
        this.fAv = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bQ(View view) {
                if (!MultiImgToolView.this.fAk.dLM()) {
                    MultiImgToolView.this.ek(view);
                    int el = MultiImgToolView.this.fAk.el(view);
                    if (el >= 0 && el < MultiImgToolView.this.fAn.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fAn.getChosedFiles().remove(el);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fAk.getMaxItemNum();
                        int size = MultiImgToolView.this.fAn.size();
                        MultiImgToolView.this.fAl.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fAn.getChosedFiles().size();
                        if (MultiImgToolView.this.acX != null) {
                            MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fAr, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fAs, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fAs, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fAt) {
                                    MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fAn, true);
                                MultiImgToolView.this.fAl.setText(MultiImgToolView.this.fAu);
                                MultiImgToolView.this.acX.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAq = null;
        this.fAr = 13;
        this.fAs = 10;
        this.fAt = false;
        this.fAv = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bQ(View view) {
                if (!MultiImgToolView.this.fAk.dLM()) {
                    MultiImgToolView.this.ek(view);
                    int el = MultiImgToolView.this.fAk.el(view);
                    if (el >= 0 && el < MultiImgToolView.this.fAn.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fAn.getChosedFiles().remove(el);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fAk.getMaxItemNum();
                        int size = MultiImgToolView.this.fAn.size();
                        MultiImgToolView.this.fAl.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fAn.getChosedFiles().size();
                        if (MultiImgToolView.this.acX != null) {
                            MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fAr, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fAs, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fAs, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fAt) {
                                    MultiImgToolView.this.acX.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fAn, true);
                                MultiImgToolView.this.fAl.setText(MultiImgToolView.this.fAu);
                                MultiImgToolView.this.acX.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fAk = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.fAl = (TextView) findViewById(R.id.muti_image_tips);
        this.fAm = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.fAq = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.fAo = bVar;
    }

    public int getImageNum() {
        return this.fAn.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.fAn = writeImagesInfo;
        this.fAp = new b(getContext(), this.fAo, this, this.fAv, this.fAs == 10);
        this.fAp.a(this.fAn);
        this.fAk.setAdapter(this.fAp, z);
        int maxItemNum = this.fAk.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.fAq)) {
            this.fAl.setText(this.fAq);
        } else if (!fAj && size > 1) {
            this.fAl.setText(R.string.editor_mutiiamge_drag_tip);
            fAj = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.fAl.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.fAp != null) {
                        this.fAp.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.fAs, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fAg, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fAh);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void bf(int i, int i2) {
        if (i != i2 && this.fAn != null && this.fAn.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.fAn.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.fAk;
    }

    public TextView getMutiImageTips() {
        return this.fAl;
    }

    public DragLayer getDragLayer() {
        return this.fAm;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private boolean fAA;
        private com.baidu.tbadk.img.b fAo;
        private WriteImagesInfo fAx = null;
        private n fAy;
        private a fAz;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.fAA = true;
            this.mContext = context;
            this.fAo = bVar;
            this.fAy = nVar;
            this.fAz = aVar;
            this.fAA = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.fAx = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fAx == null) {
                return 0;
            }
            return this.fAx.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.fAx.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.fAx.getChosedFiles(), i);
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
                ao.setBackgroundResource(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(ao.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.fAo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.fAA) {
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
                            } else if (b.this.fAy != null) {
                                b.this.fAy.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            ao.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fAz != null) {
                        b.this.fAz.bQ(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.fAr = i;
    }

    public void setTargetToolId(int i) {
        this.fAs = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.fAt = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.fAu = " ";
        } else {
            this.fAu = str;
        }
    }
}
