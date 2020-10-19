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
    private static boolean faj = false;
    private EditorTools abj;
    private int abk;
    private DragHorizonScrollView fak;
    private TextView fal;
    private DragLayer fam;
    private WriteImagesInfo fan;
    private com.baidu.tbadk.img.b fao;
    private b fap;
    private String faq;
    private int far;
    private int fas;
    private boolean fat;
    private String fau;
    private a fav;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void bw(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.faq = null;
        this.far = 13;
        this.fas = 10;
        this.fat = false;
        this.fav = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bw(View view) {
                if (!MultiImgToolView.this.fak.dEP()) {
                    MultiImgToolView.this.dz(view);
                    int dA = MultiImgToolView.this.fak.dA(view);
                    if (dA >= 0 && dA < MultiImgToolView.this.fan.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fan.getChosedFiles().remove(dA);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fak.getMaxItemNum();
                        int size = MultiImgToolView.this.fan.size();
                        MultiImgToolView.this.fal.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fan.getChosedFiles().size();
                        if (MultiImgToolView.this.abj != null) {
                            MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.far, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fas, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fas, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fat) {
                                    MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fan, true);
                                MultiImgToolView.this.fal.setText(MultiImgToolView.this.fau);
                                MultiImgToolView.this.abj.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.faq = null;
        this.far = 13;
        this.fas = 10;
        this.fat = false;
        this.fav = new a() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.1
            @Override // com.baidu.tbadk.editortools.imagetool.MultiImgToolView.a
            public void bw(View view) {
                if (!MultiImgToolView.this.fak.dEP()) {
                    MultiImgToolView.this.dz(view);
                    int dA = MultiImgToolView.this.fak.dA(view);
                    if (dA >= 0 && dA < MultiImgToolView.this.fan.getChosedFiles().size()) {
                        ImageFileInfo remove = MultiImgToolView.this.fan.getChosedFiles().remove(dA);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = MultiImgToolView.this.fak.getMaxItemNum();
                        int size = MultiImgToolView.this.fan.size();
                        MultiImgToolView.this.fal.setText(MultiImgToolView.this.getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
                        int size2 = MultiImgToolView.this.fan.getChosedFiles().size();
                        if (MultiImgToolView.this.abj != null) {
                            MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(MultiImgToolView.this.far, -1, null));
                            if (size2 > 0) {
                                MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fas, String.valueOf(size2)));
                            } else {
                                MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(2, MultiImgToolView.this.fas, null));
                            }
                            if (maxItemNum == 1 && size2 == 0) {
                                if (MultiImgToolView.this.fat) {
                                    MultiImgToolView.this.abj.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                    return;
                                }
                                MultiImgToolView.this.a(MultiImgToolView.this.fan, true);
                                MultiImgToolView.this.fal.setText(MultiImgToolView.this.fau);
                                MultiImgToolView.this.abj.invalidate();
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.fak = (DragHorizonScrollView) findViewById(R.id.muti_image_upload_dragscrollview);
        this.fal = (TextView) findViewById(R.id.muti_image_tips);
        this.fam = (DragLayer) findViewById(R.id.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.faq = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.fao = bVar;
    }

    public int getImageNum() {
        return this.fan.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.fan = writeImagesInfo;
        this.fap = new b(getContext(), this.fao, this, this.fav, this.fas == 10);
        this.fap.a(this.fan);
        this.fak.setAdapter(this.fap, z);
        int maxItemNum = this.fak.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.faq)) {
            this.fal.setText(this.faq);
        } else if (!faj && size > 1) {
            this.fal.setText(R.string.editor_mutiiamge_drag_tip);
            faj = true;
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOW_MUTIIMAGE_TIP, true);
        } else {
            this.fal.setText(getResources().getString(R.string.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.fap != null) {
                        this.fap.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.fas, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fag, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).fah);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abk;
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
    public void be(int i, int i2) {
        if (i != i2 && this.fan != null && this.fan.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.fan.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.fak;
    }

    public TextView getMutiImageTips() {
        return this.fal;
    }

    public DragLayer getDragLayer() {
        return this.fam;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private boolean faA;
        private com.baidu.tbadk.img.b fao;
        private WriteImagesInfo fax = null;
        private n fay;
        private a faz;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar, boolean z) {
            this.faA = true;
            this.mContext = context;
            this.fao = bVar;
            this.fay = nVar;
            this.faz = aVar;
            this.faA = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.fax = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fax == null) {
                return 0;
            }
            return this.fax.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.fax.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.fax.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bf(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.fao.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.editortools.imagetool.MultiImgToolView.b.1
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
            if (this.faA) {
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
                            } else if (b.this.fay != null) {
                                b.this.fay.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.faz != null) {
                        b.this.faz.bw(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(R.string.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.far = i;
    }

    public void setTargetToolId(int i) {
        this.fas = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.fat = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.fau = " ";
        } else {
            this.fau = str;
        }
    }
}
