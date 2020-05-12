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
    private static boolean dXP = false;
    private EditorTools Zd;
    private int Ze;
    private DragHorizonScrollView dXQ;
    private TextView dXR;
    private DragLayer dXS;
    private WriteImagesInfo dXT;
    private com.baidu.tbadk.img.b dXU;
    private b dXV;
    private String dXW;
    private int dXX;
    private int dXY;
    private boolean dXZ;
    private String dYa;
    private a dYb;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bg(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.dXW = null;
        this.dXX = 13;
        this.dXY = 10;
        this.dXZ = false;
        this.dYb = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bg(View view) {
                if (!MultiImgToolView.this.dXQ.cWQ()) {
                    MultiImgToolView.this.da(view);
                    int db = MultiImgToolView.this.dXQ.db(view);
                    if (db >= 0 && db < MultiImgToolView.this.dXT.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dXT.getChosedFiles().remove(db);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.jP().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dXQ.getMaxItemNum();
                        int size = MultiImgToolView.this.dXT.size();
                        MultiImgToolView.this.dXR.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dXT.getChosedFiles().size();
                        if (MultiImgToolView.this.Zd != null) {
                            MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dXX, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dXY, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dXY, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dXZ) {
                                    MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dXT, true);
                                MultiImgToolView.this.dXR.setText(MultiImgToolView.this.dYa);
                                MultiImgToolView.this.Zd.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXW = null;
        this.dXX = 13;
        this.dXY = 10;
        this.dXZ = false;
        this.dYb = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bg(View view) {
                if (!MultiImgToolView.this.dXQ.cWQ()) {
                    MultiImgToolView.this.da(view);
                    int db = MultiImgToolView.this.dXQ.db(view);
                    if (db >= 0 && db < MultiImgToolView.this.dXT.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dXT.getChosedFiles().remove(db);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.jP().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dXQ.getMaxItemNum();
                        int size = MultiImgToolView.this.dXT.size();
                        MultiImgToolView.this.dXR.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dXT.getChosedFiles().size();
                        if (MultiImgToolView.this.Zd != null) {
                            MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dXX, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dXY, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dXY, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dXZ) {
                                    MultiImgToolView.this.Zd.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dXT, true);
                                MultiImgToolView.this.dXR.setText(MultiImgToolView.this.dYa);
                                MultiImgToolView.this.Zd.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dXQ = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.dXR = (TextView) findViewById(R.id.muti_image_tips);
        this.dXS = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.dXW = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.dXU = bVar;
    }

    public int getImageNum() {
        return this.dXT.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.dXT = writeImagesInfo;
        this.dXV = new b(getContext(), this.dXU, this, this.dYb, this.dXY == 10);
        this.dXV.a(this.dXT);
        this.dXQ.setAdapter(this.dXV, z);
        int maxItemNum = this.dXQ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.dXW)) {
            this.dXR.setText(this.dXW);
        } else if (!dXP && size > 1) {
            this.dXR.setText(R.string.editor_mutiiamge_drag_tip);
            dXP = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.dXR.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.dXV != null) {
                        this.dXV.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.dXY, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dXM, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dXN);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
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
    public void aN(int i, int i2) {
        if (i != i2 && this.dXT != null && this.dXT.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.dXT.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.dXQ;
    }

    public TextView getMutiImageTips() {
        return this.dXR;
    }

    public DragLayer getDragLayer() {
        return this.dXS;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b dXU;
        private WriteImagesInfo dYd = null;
        private m dYe;
        private a dYf;
        private boolean dYg;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.dYg = true;
            this.mContext = context;
            this.dXU = bVar;
            this.dYe = mVar;
            this.dYf = aVar;
            this.dYg = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.dYd = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dYd == null) {
                return 0;
            }
            return this.dYd.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.dYd.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.dYd.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aO(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.dXU.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.dYg) {
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
                            } else if (b.this.dYe != null) {
                                b.this.dYe.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.dYf != null) {
                        b.this.dYf.bg(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.dXX = i;
    }

    public void setTargetToolId(int i) {
        this.dXY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.dXZ = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.dYa = " ";
        } else {
            this.dYa = str;
        }
    }
}
