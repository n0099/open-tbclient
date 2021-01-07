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
    private static boolean fER = false;
    private EditorTools acZ;
    private int ada;
    private DragHorizonScrollView fES;
    private TextView fET;
    private DragLayer fEU;
    private WriteImagesInfo fEV;
    private com.baidu.tbadk.img.b fEW;
    private b fEX;
    private String fEY;
    private int fEZ;
    private int fFa;
    private boolean fFb;
    private String fFc;
    private a fFd;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bQ(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.fEY = null;
        this.fEZ = 13;
        this.fFa = 10;
        this.fFb = false;
        this.fFd = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bQ(View view) {
                if (!MultiImgToolView.this.fES.dPE()) {
                    MultiImgToolView.this.ek(view);
                    int el = MultiImgToolView.this.fES.el(view);
                    if (el >= 0 && el < MultiImgToolView.this.fEV.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fEV.getChosedFiles().remove(el);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fES.getMaxItemNum();
                        int size = MultiImgToolView.this.fEV.size();
                        MultiImgToolView.this.fET.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fEV.getChosedFiles().size();
                        if (MultiImgToolView.this.acZ != null) {
                            MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fEZ, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fFa, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fFa, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fFb) {
                                    MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fEV, true);
                                MultiImgToolView.this.fET.setText(MultiImgToolView.this.fFc);
                                MultiImgToolView.this.acZ.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEY = null;
        this.fEZ = 13;
        this.fFa = 10;
        this.fFb = false;
        this.fFd = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bQ(View view) {
                if (!MultiImgToolView.this.fES.dPE()) {
                    MultiImgToolView.this.ek(view);
                    int el = MultiImgToolView.this.fES.el(view);
                    if (el >= 0 && el < MultiImgToolView.this.fEV.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fEV.getChosedFiles().remove(el);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fES.getMaxItemNum();
                        int size = MultiImgToolView.this.fEV.size();
                        MultiImgToolView.this.fET.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fEV.getChosedFiles().size();
                        if (MultiImgToolView.this.acZ != null) {
                            MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.fEZ, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fFa, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fFa, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fFb) {
                                    MultiImgToolView.this.acZ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fEV, true);
                                MultiImgToolView.this.fET.setText(MultiImgToolView.this.fFc);
                                MultiImgToolView.this.acZ.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fES = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.fET = (TextView) findViewById(R.id.muti_image_tips);
        this.fEU = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.fEY = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.fEW = bVar;
    }

    public int getImageNum() {
        return this.fEV.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.fEV = writeImagesInfo;
        this.fEX = new b(getContext(), this.fEW, this, this.fFd, this.fFa == 10);
        this.fEX.a(this.fEV);
        this.fES.setAdapter(this.fEX, z);
        int maxItemNum = this.fES.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.fEY)) {
            this.fET.setText(this.fEY);
        } else if (!fER && size > 1) {
            this.fET.setText(R.string.editor_mutiiamge_drag_tip);
            fER = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.fET.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.fEX != null) {
                        this.fEX.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.fFa, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fEO, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fEP);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
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
        if (i != i2 && this.fEV != null && this.fEV.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.fEV.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.fES;
    }

    public TextView getMutiImageTips() {
        return this.fET;
    }

    public DragLayer getDragLayer() {
        return this.fEU;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b fEW;
        private WriteImagesInfo fFf = null;
        private n fFg;
        private a fFh;
        private boolean fFi;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.fFi = true;
            this.mContext = context;
            this.fEW = bVar;
            this.fFg = nVar;
            this.fFh = aVar;
            this.fFi = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.fFf = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fFf == null) {
                return 0;
            }
            return this.fFf.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.fFf.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.fFf.getChosedFiles(), i);
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
                if (this.fEW.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.fFi) {
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
                            } else if (b.this.fFg != null) {
                                b.this.fFg.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.fFh != null) {
                        b.this.fFh.bQ(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.fEZ = i;
    }

    public void setTargetToolId(int i) {
        this.fFa = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.fFb = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.fFc = " ";
        } else {
            this.fFc = str;
        }
    }
}
