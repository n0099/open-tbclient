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
    private static boolean eBh = false;
    private EditorTools ZS;
    private int ZT;
    private DragHorizonScrollView eBi;
    private TextView eBj;
    private DragLayer eBk;
    private WriteImagesInfo eBl;
    private com.baidu.tbadk.img.b eBm;
    private b eBn;
    private String eBo;
    private int eBp;
    private int eBq;
    private boolean eBr;
    private String eBs;
    private a eBt;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bo(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.eBo = null;
        this.eBp = 13;
        this.eBq = 10;
        this.eBr = false;
        this.eBt = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bo(View view) {
                if (!MultiImgToolView.this.eBi.dlI()) {
                    MultiImgToolView.this.di(view);
                    int dj = MultiImgToolView.this.eBi.dj(view);
                    if (dj >= 0 && dj < MultiImgToolView.this.eBl.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eBl.getChosedFiles().remove(dj);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eBi.getMaxItemNum();
                        int size = MultiImgToolView.this.eBl.size();
                        MultiImgToolView.this.eBj.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eBl.getChosedFiles().size();
                        if (MultiImgToolView.this.ZS != null) {
                            MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eBp, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eBq, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eBq, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eBr) {
                                    MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eBl, true);
                                MultiImgToolView.this.eBj.setText(MultiImgToolView.this.eBs);
                                MultiImgToolView.this.ZS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBo = null;
        this.eBp = 13;
        this.eBq = 10;
        this.eBr = false;
        this.eBt = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bo(View view) {
                if (!MultiImgToolView.this.eBi.dlI()) {
                    MultiImgToolView.this.di(view);
                    int dj = MultiImgToolView.this.eBi.dj(view);
                    if (dj >= 0 && dj < MultiImgToolView.this.eBl.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.eBl.getChosedFiles().remove(dj);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.eBi.getMaxItemNum();
                        int size = MultiImgToolView.this.eBl.size();
                        MultiImgToolView.this.eBj.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.eBl.getChosedFiles().size();
                        if (MultiImgToolView.this.ZS != null) {
                            MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.eBp, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eBq, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.eBq, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.eBr) {
                                    MultiImgToolView.this.ZS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.eBl, true);
                                MultiImgToolView.this.eBj.setText(MultiImgToolView.this.eBs);
                                MultiImgToolView.this.ZS.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.eBi = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.eBj = (TextView) findViewById(R.id.muti_image_tips);
        this.eBk = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.eBo = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.eBm = bVar;
    }

    public int getImageNum() {
        return this.eBl.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.eBl = writeImagesInfo;
        this.eBn = new b(getContext(), this.eBm, this, this.eBt, this.eBq == 10);
        this.eBn.a(this.eBl);
        this.eBi.setAdapter(this.eBn, z);
        int maxItemNum = this.eBi.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.eBo)) {
            this.eBj.setText(this.eBo);
        } else if (!eBh && size > 1) {
            this.eBj.setText(R.string.editor_mutiiamge_drag_tip);
            eBh = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.eBj.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.eBn != null) {
                        this.eBn.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.eBq, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eBe, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).eBf);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
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
    public void aW(int i, int i2) {
        if (i != i2 && this.eBl != null && this.eBl.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.eBl.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.eBi;
    }

    public TextView getMutiImageTips() {
        return this.eBj;
    }

    public DragLayer getDragLayer() {
        return this.eBk;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b eBm;
        private WriteImagesInfo eBv = null;
        private m eBw;
        private a eBx;
        private boolean eBy;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.eBy = true;
            this.mContext = context;
            this.eBm = bVar;
            this.eBw = mVar;
            this.eBx = aVar;
            this.eBy = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.eBv = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eBv == null) {
                return 0;
            }
            return this.eBv.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.eBv.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.eBv.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aX(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.eBm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.eBy) {
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
                            } else if (b.this.eBw != null) {
                                b.this.eBw.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.eBx != null) {
                        b.this.eBx.bo(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.eBp = i;
    }

    public void setTargetToolId(int i) {
        this.eBq = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.eBr = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.eBs = " ";
        } else {
            this.eBs = str;
        }
    }
}
