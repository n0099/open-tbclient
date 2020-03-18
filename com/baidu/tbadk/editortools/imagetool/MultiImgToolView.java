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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    private static boolean dyd = false;
    private EditorTools FO;
    private int FP;
    private DragHorizonScrollView dye;
    private TextView dyf;
    private DragLayer dyg;
    private WriteImagesInfo dyh;
    private com.baidu.tbadk.img.b dyi;
    private b dyj;
    private String dyk;
    private int dyl;
    private int dym;
    private boolean dyn;
    private String dyo;
    private a dyp;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.dyk = null;
        this.dyl = 13;
        this.dym = 10;
        this.dyn = false;
        this.dyp = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dye.cLW()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dye.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dyh.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dyh.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dye.getMaxItemNum();
                        int size = MultiImgToolView.this.dyh.size();
                        MultiImgToolView.this.dyf.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dyh.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dyl, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dym, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dym, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dyn) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dyh, true);
                                MultiImgToolView.this.dyf.setText(MultiImgToolView.this.dyo);
                                MultiImgToolView.this.FO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyk = null;
        this.dyl = 13;
        this.dym = 10;
        this.dyn = false;
        this.dyp = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bf(View view) {
                if (!MultiImgToolView.this.dye.cLW()) {
                    MultiImgToolView.this.cS(view);
                    int cT = MultiImgToolView.this.dye.cT(view);
                    if (cT >= 0 && cT < MultiImgToolView.this.dyh.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.dyh.getChosedFiles().remove(cT);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.fk().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.dye.getMaxItemNum();
                        int size = MultiImgToolView.this.dyh.size();
                        MultiImgToolView.this.dyf.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.dyh.getChosedFiles().size();
                        if (MultiImgToolView.this.FO != null) {
                            MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.dyl, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dym, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.dym, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.dyn) {
                                    MultiImgToolView.this.FO.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.dyh, true);
                                MultiImgToolView.this.dyf.setText(MultiImgToolView.this.dyo);
                                MultiImgToolView.this.FO.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.dye = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.dyf = (TextView) findViewById(R.id.muti_image_tips);
        this.dyg = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.dyk = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.dyi = bVar;
    }

    public int getImageNum() {
        return this.dyh.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.dyh = writeImagesInfo;
        this.dyj = new b(getContext(), this.dyi, this, this.dyp, this.dym == 10);
        this.dyj.a(this.dyh);
        this.dye.setAdapter(this.dyj, z);
        int maxItemNum = this.dye.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.dyk)) {
            this.dyf.setText(this.dyk);
        } else if (!dyd && size > 1) {
            this.dyf.setText(R.string.editor_mutiiamge_drag_tip);
            dyd = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.dyf.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.dyj != null) {
                        this.dyj.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.dym, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dya, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).dyb);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
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
    public void aJ(int i, int i2) {
        if (i != i2 && this.dyh != null && this.dyh.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.dyh.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.dye;
    }

    public TextView getMutiImageTips() {
        return this.dyf;
    }

    public DragLayer getDragLayer() {
        return this.dyg;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b dyi;
        private WriteImagesInfo dyr = null;
        private m dys;
        private a dyt;
        private boolean dyu;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, m mVar, a aVar, boolean z) {
            this.dyu = true;
            this.mContext = context;
            this.dyi = bVar;
            this.dys = mVar;
            this.dyt = aVar;
            this.dyu = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.dyr = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dyr == null) {
                return 0;
            }
            return this.dyr.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.dyr.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.dyr.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aK(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.dyi.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.dyu) {
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
                            } else if (b.this.dys != null) {
                                b.this.dys.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.dyt != null) {
                        b.this.dyt.bf(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + HanziToPinyin.Token.SEPARATOR + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.dyl = i;
    }

    public void setTargetToolId(int i) {
        this.dym = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.dyn = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.dyo = HanziToPinyin.Token.SEPARATOR;
        } else {
            this.dyo = str;
        }
    }
}
