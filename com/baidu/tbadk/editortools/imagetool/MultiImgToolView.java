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
    private static boolean eOc = false;
    private EditorTools aaS;
    private int aaT;
    private DragHorizonScrollView eOd;
    private TextView eOe;
    private DragLayer eOf;
    private WriteImagesInfo eOg;
    private com.baidu.tbadk.img.b eOh;
    private b eOi;
    private String eOj;
    private int eOk;
    private int eOl;
    private boolean eOm;
    private String eOn;
    private a eOo;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bs(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.eOj = null;
        this.eOk = 13;
        this.eOl = 10;
        this.eOm = false;
        this.eOo = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bs(View view) {
                if (!MultiImgToolView.this.eOd.dBd()) {
                    MultiImgToolView.this.dv(view);
                    int dw = MultiImgToolView.this.eOd.dw(view);
                    if (dw >= 0 && dw < MultiImgToolView.this.eOg.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eOg.getChosedFiles().remove(dw);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lK().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eOd.getMaxItemNum();
                        int size = MultiImgToolView.this.eOg.size();
                        MultiImgToolView.this.eOe.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eOg.getChosedFiles().size();
                        if (MultiImgToolView.this.aaS != null) {
                            MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eOk, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eOl, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eOl, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eOm) {
                                    MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eOg, true);
                                MultiImgToolView.this.eOe.setText(MultiImgToolView.this.eOn);
                                MultiImgToolView.this.aaS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOj = null;
        this.eOk = 13;
        this.eOl = 10;
        this.eOm = false;
        this.eOo = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bs(View view) {
                if (!MultiImgToolView.this.eOd.dBd()) {
                    MultiImgToolView.this.dv(view);
                    int dw = MultiImgToolView.this.eOd.dw(view);
                    if (dw >= 0 && dw < MultiImgToolView.this.eOg.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eOg.getChosedFiles().remove(dw);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lK().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eOd.getMaxItemNum();
                        int size = MultiImgToolView.this.eOg.size();
                        MultiImgToolView.this.eOe.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eOg.getChosedFiles().size();
                        if (MultiImgToolView.this.aaS != null) {
                            MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eOk, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eOl, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eOl, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eOm) {
                                    MultiImgToolView.this.aaS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eOg, true);
                                MultiImgToolView.this.eOe.setText(MultiImgToolView.this.eOn);
                                MultiImgToolView.this.aaS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eOd = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.eOe = (TextView) findViewById(R.id.muti_image_tips);
        this.eOf = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.eOj = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.eOh = bVar;
    }

    public int getImageNum() {
        return this.eOg.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.eOg = writeImagesInfo;
        this.eOi = new b(getContext(), this.eOh, this, this.eOo, this.eOl == 10);
        this.eOi.a(this.eOg);
        this.eOd.setAdapter(this.eOi, z);
        int maxItemNum = this.eOd.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.eOj)) {
            this.eOe.setText(this.eOj);
        } else if (!eOc && size > 1) {
            this.eOe.setText(R.string.editor_mutiiamge_drag_tip);
            eOc = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.eOe.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.eOi != null) {
                        this.eOi.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.eOl, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eNZ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eOa);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void bf(int i, int i2) {
        if (i != i2 && this.eOg != null && this.eOg.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.eOg.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.eOd;
    }

    public TextView getMutiImageTips() {
        return this.eOe;
    }

    public DragLayer getDragLayer() {
        return this.eOf;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b eOh;
        private WriteImagesInfo eOq = null;
        private n eOr;
        private a eOs;
        private boolean eOt;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.eOt = true;
            this.mContext = context;
            this.eOh = bVar;
            this.eOr = nVar;
            this.eOs = aVar;
            this.eOt = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.eOq = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eOq == null) {
                return 0;
            }
            return this.eOq.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.eOq.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.eOq.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.eOh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.eOt) {
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
                            } else if (b.this.eOr != null) {
                                b.this.eOr.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.eOs != null) {
                        b.this.eOs.bs(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.eOk = i;
    }

    public void setTargetToolId(int i) {
        this.eOl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.eOm = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.eOn = " ";
        } else {
            this.eOn = str;
        }
    }
}
