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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
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
public class MultiImgToolView extends DragContainer implements m, DragHorizonScrollView.a {
    private static boolean elY = false;
    private EditorTools Zt;
    private int Zu;
    private DragHorizonScrollView elZ;
    private TextView ema;
    private DragLayer emb;
    private WriteImagesInfo emc;
    private com.baidu.tbadk.img.b emd;
    private b eme;
    private String emf;
    private int emg;
    private int emh;
    private boolean emi;
    private String emj;
    private a emk;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bh(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.emf = null;
        this.emg = 13;
        this.emh = 10;
        this.emi = false;
        this.emk = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bh(View view) {
                if (!MultiImgToolView.this.elZ.dem()) {
                    MultiImgToolView.this.db(view);
                    int dc = MultiImgToolView.this.elZ.dc(view);
                    if (dc >= 0 && dc < MultiImgToolView.this.emc.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.emc.getChosedFiles().remove(dc);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.jR().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.elZ.getMaxItemNum();
                        int size = MultiImgToolView.this.emc.size();
                        MultiImgToolView.this.ema.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.emc.getChosedFiles().size();
                        if (MultiImgToolView.this.Zt != null) {
                            MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.emg, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.emh, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.emh, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.emi) {
                                    MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.emc, true);
                                MultiImgToolView.this.ema.setText(MultiImgToolView.this.emj);
                                MultiImgToolView.this.Zt.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emf = null;
        this.emg = 13;
        this.emh = 10;
        this.emi = false;
        this.emk = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bh(View view) {
                if (!MultiImgToolView.this.elZ.dem()) {
                    MultiImgToolView.this.db(view);
                    int dc = MultiImgToolView.this.elZ.dc(view);
                    if (dc >= 0 && dc < MultiImgToolView.this.emc.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.emc.getChosedFiles().remove(dc);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.jR().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.elZ.getMaxItemNum();
                        int size = MultiImgToolView.this.emc.size();
                        MultiImgToolView.this.ema.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.emc.getChosedFiles().size();
                        if (MultiImgToolView.this.Zt != null) {
                            MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.emg, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.emh, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.emh, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.emi) {
                                    MultiImgToolView.this.Zt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.emc, true);
                                MultiImgToolView.this.ema.setText(MultiImgToolView.this.emj);
                                MultiImgToolView.this.Zt.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.elZ = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.ema = (TextView) findViewById(R.id.muti_image_tips);
        this.emb = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.emf = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.emd = bVar;
    }

    public int getImageNum() {
        return this.emc.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.emc = writeImagesInfo;
        this.eme = new b(getContext(), this.emd, this, this.emk, this.emh == 10);
        this.eme.a(this.emc);
        this.elZ.setAdapter(this.eme, z);
        int maxItemNum = this.elZ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.emf)) {
            this.ema.setText(this.emf);
        } else if (!elY && size > 1) {
            this.ema.setText(R.string.editor_mutiiamge_drag_tip);
            elY = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.ema.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.eme != null) {
                        this.eme.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.emh, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).elV, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).elW);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void aR(int i, int i2) {
        if (i != i2 && this.emc != null && this.emc.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.emc.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.elZ;
    }

    public TextView getMutiImageTips() {
        return this.ema;
    }

    public DragLayer getDragLayer() {
        return this.emb;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b emd;
        private WriteImagesInfo emm = null;
        private m emn;
        private a emo;
        private boolean emp;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.emp = true;
            this.mContext = context;
            this.emd = bVar;
            this.emn = mVar;
            this.emo = aVar;
            this.emp = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.emm = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.emm == null) {
                return 0;
            }
            return this.emm.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.emm.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.emm.getChosedFiles(), i);
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
                am.setBackgroundResource(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(am.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aS(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.emd.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.emp) {
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
                                l.showLongToast(b.this.mContext, (int) R.string.editor_mutiiamge_image_error);
                            } else if (b.this.emn != null) {
                                b.this.emn.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            am.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.emo != null) {
                        b.this.emo.bh(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.emg = i;
    }

    public void setTargetToolId(int i) {
        this.emh = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.emi = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.emj = " ";
        } else {
            this.emj = str;
        }
    }
}
