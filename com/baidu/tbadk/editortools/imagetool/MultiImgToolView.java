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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private static boolean euO = false;
    private EditorTools ZX;
    private int ZY;
    private DragHorizonScrollView euP;
    private TextView euQ;
    private DragLayer euR;
    private WriteImagesInfo euS;
    private com.baidu.tbadk.img.b euT;
    private b euU;
    private String euV;
    private int euW;
    private int euX;
    private boolean euY;
    private String euZ;
    private a eva;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bi(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.euV = null;
        this.euW = 13;
        this.euX = 10;
        this.euY = false;
        this.eva = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.euP.diy()) {
                    MultiImgToolView.this.dc(view);
                    int dd = MultiImgToolView.this.euP.dd(view);
                    if (dd >= 0 && dd < MultiImgToolView.this.euS.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.euS.getChosedFiles().remove(dd);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.euP.getMaxItemNum();
                        int size = MultiImgToolView.this.euS.size();
                        MultiImgToolView.this.euQ.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.euS.getChosedFiles().size();
                        if (MultiImgToolView.this.ZX != null) {
                            MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.euW, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.euX, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.euX, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.euY) {
                                    MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.euS, true);
                                MultiImgToolView.this.euQ.setText(MultiImgToolView.this.euZ);
                                MultiImgToolView.this.ZX.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euV = null;
        this.euW = 13;
        this.euX = 10;
        this.euY = false;
        this.eva = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bi(View view) {
                if (!MultiImgToolView.this.euP.diy()) {
                    MultiImgToolView.this.dc(view);
                    int dd = MultiImgToolView.this.euP.dd(view);
                    if (dd >= 0 && dd < MultiImgToolView.this.euS.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.euS.getChosedFiles().remove(dd);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.euP.getMaxItemNum();
                        int size = MultiImgToolView.this.euS.size();
                        MultiImgToolView.this.euQ.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.euS.getChosedFiles().size();
                        if (MultiImgToolView.this.ZX != null) {
                            MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.euW, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.euX, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.euX, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.euY) {
                                    MultiImgToolView.this.ZX.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.euS, true);
                                MultiImgToolView.this.euQ.setText(MultiImgToolView.this.euZ);
                                MultiImgToolView.this.ZX.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.euP = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.euQ = (TextView) findViewById(R.id.muti_image_tips);
        this.euR = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.euV = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.euT = bVar;
    }

    public int getImageNum() {
        return this.euS.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.euS = writeImagesInfo;
        this.euU = new b(getContext(), this.euT, this, this.eva, this.euX == 10);
        this.euU.a(this.euS);
        this.euP.setAdapter(this.euU, z);
        int maxItemNum = this.euP.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.euV)) {
            this.euQ.setText(this.euV);
        } else if (!euO && size > 1) {
            this.euQ.setText(R.string.editor_mutiiamge_drag_tip);
            euO = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.euQ.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.euU != null) {
                        this.euU.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.euX, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).euL, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).euM);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
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
    public void aV(int i, int i2) {
        if (i != i2 && this.euS != null && this.euS.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.euS.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.euP;
    }

    public TextView getMutiImageTips() {
        return this.euQ;
    }

    public DragLayer getDragLayer() {
        return this.euR;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b euT;
        private WriteImagesInfo evc = null;
        private m evd;
        private a eve;
        private boolean evf;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.evf = true;
            this.mContext = context;
            this.euT = bVar;
            this.evd = mVar;
            this.eve = aVar;
            this.evf = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.evc = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.evc == null) {
                return 0;
            }
            return this.evc.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.evc.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) w.getItem(this.evc.getChosedFiles(), i);
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
                an.setBackgroundResource(frameLayout3, R.drawable.bg_add_photo);
                frameLayout3.setForeground(an.getDrawable(R.drawable.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aW(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.euT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.evf) {
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
                            } else if (b.this.evd != null) {
                                b.this.evd.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.delete);
            an.setImageResource(imageView, R.drawable.btn_add_photo_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eve != null) {
                        b.this.eve.bi(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.euW = i;
    }

    public void setTargetToolId(int i) {
        this.euX = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.euY = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.euZ = " ";
        } else {
            this.euZ = str;
        }
    }
}
