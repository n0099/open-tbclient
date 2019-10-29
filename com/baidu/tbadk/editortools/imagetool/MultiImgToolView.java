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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private static boolean cGi = false;
    private EditorTools Dl;
    private int Dm;
    private DragHorizonScrollView cGj;
    private TextView cGk;
    private DragLayer cGl;
    private WriteImagesInfo cGm;
    private com.baidu.tbadk.img.b cGn;
    private b cGo;
    private String cGp;
    private int cGq;
    private int cGr;
    private boolean cGs;
    private String cGt;
    private a cGu;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void be(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.cGp = null;
        this.cGq = 13;
        this.cGr = 10;
        this.cGs = false;
        this.cGu = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void be(View view) {
                if (!MultiImgToolView.this.cGj.coR()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.cGj.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.cGm.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cGm.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.eP().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cGj.getMaxItemNum();
                        int size = MultiImgToolView.this.cGm.size();
                        MultiImgToolView.this.cGk.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cGm.getChosedFiles().size();
                        if (MultiImgToolView.this.Dl != null) {
                            MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cGq, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cGr, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cGr, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cGs) {
                                    MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cGm, true);
                                MultiImgToolView.this.cGk.setText(MultiImgToolView.this.cGt);
                                MultiImgToolView.this.Dl.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGp = null;
        this.cGq = 13;
        this.cGr = 10;
        this.cGs = false;
        this.cGu = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void be(View view) {
                if (!MultiImgToolView.this.cGj.coR()) {
                    MultiImgToolView.this.cP(view);
                    int cQ = MultiImgToolView.this.cGj.cQ(view);
                    if (cQ >= 0 && cQ < MultiImgToolView.this.cGm.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.cGm.getChosedFiles().remove(cQ);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.eP().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.cGj.getMaxItemNum();
                        int size = MultiImgToolView.this.cGm.size();
                        MultiImgToolView.this.cGk.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.cGm.getChosedFiles().size();
                        if (MultiImgToolView.this.Dl != null) {
                            MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.cGq, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cGr, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.cGr, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.cGs) {
                                    MultiImgToolView.this.Dl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.cGm, true);
                                MultiImgToolView.this.cGk.setText(MultiImgToolView.this.cGt);
                                MultiImgToolView.this.Dl.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.cGj = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.cGk = (TextView) findViewById(R.id.muti_image_tips);
        this.cGl = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.cGp = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.cGn = bVar;
    }

    public int getImageNum() {
        return this.cGm.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.cGm = writeImagesInfo;
        this.cGo = new b(getContext(), this.cGn, this, this.cGu, this.cGr == 10);
        this.cGo.a(this.cGm);
        this.cGj.setAdapter(this.cGo, z);
        int maxItemNum = this.cGj.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.cGp)) {
            this.cGk.setText(this.cGp);
        } else if (!cGi && size > 1) {
            this.cGk.setText(R.string.editor_mutiiamge_drag_tip);
            cGi = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.cGk.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.cGo != null) {
                        this.cGo.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.cGr, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cGf, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).cGg);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void an(int i, int i2) {
        if (i != i2 && this.cGm != null && this.cGm.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cGm.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.cGj;
    }

    public TextView getMutiImageTips() {
        return this.cGk;
    }

    public DragLayer getDragLayer() {
        return this.cGl;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b cGn;
        private WriteImagesInfo cGw = null;
        private l cGx;
        private a cGy;
        private boolean cGz;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar, boolean z) {
            this.cGz = true;
            this.mContext = context;
            this.cGn = bVar;
            this.cGx = lVar;
            this.cGy = aVar;
            this.cGz = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.cGw = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.cGw == null) {
                return 0;
            }
            return this.cGw.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.cGw.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.cGw.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.ao(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.cGn.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.cGz) {
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
                                com.baidu.adp.lib.util.l.showLongToast(b.this.mContext, (int) R.string.editor_mutiiamge_image_error);
                            } else if (b.this.cGx != null) {
                                b.this.cGx.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.cGy != null) {
                        b.this.cGy.be(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + HanziToPinyin.Token.SEPARATOR + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.cGq = i;
    }

    public void setTargetToolId(int i) {
        this.cGr = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.cGs = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.cGt = HanziToPinyin.Token.SEPARATOR;
        } else {
            this.cGt = str;
        }
    }
}
