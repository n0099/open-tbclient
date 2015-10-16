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
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements w, DragHorizonScrollView.a {
    private static boolean arg = false;
    private j KA;
    private int Kz;
    private DragHorizonScrollView arh;
    private TextView ari;
    private DragLayer arj;
    private WriteImagesInfo ark;
    private com.baidu.tbadk.img.b arl;
    private b arm;
    private String arn;
    private int aro;
    private int arp;
    private a arq;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void t(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.arn = null;
        this.aro = 13;
        this.arp = 10;
        this.arq = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arn = null;
        this.aro = 13;
        this.arp = 10;
        this.arq = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.arh = (DragHorizonScrollView) findViewById(i.f.muti_image_upload_dragscrollview);
        this.ari = (TextView) findViewById(i.f.muti_image_tips);
        this.arj = (DragLayer) findViewById(i.f.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.arn = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.arl = bVar;
    }

    public int getImageNum() {
        return this.ark.getChosedFiles().size();
    }

    private void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.ark = writeImagesInfo;
        this.arm = new b(getContext(), this.arl, this, this.arq, this.arp == 10);
        this.arm.a(this.ark);
        this.arh.a(this.arm, z);
        int maxItemNum = this.arh.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.arn)) {
            this.ari.setText(this.arn);
        } else if (!arg && size > 1) {
            this.ari.setText(i.h.editor_mutiiamge_drag_tip);
            arg = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.ari.setText(getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            new StringBuilder(String.valueOf(size)).toString();
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.arm != null) {
                        this.arm.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.arp, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ard, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).are);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.KA = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KA != null) {
            this.KA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Kz = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Kz;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.ark != null && this.ark.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.ark.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.arh;
    }

    public TextView getMutiImageTips() {
        return this.ari;
    }

    public DragLayer getDragLayer() {
        return this.arj;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b arl;
        private WriteImagesInfo ars = null;
        private w art;
        private a aru;
        private boolean arv;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, w wVar, a aVar, boolean z) {
            this.arv = true;
            this.mContext = context;
            this.arl = bVar;
            this.art = wVar;
            this.aru = aVar;
            this.arv = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.ars = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ars == null) {
                return 0;
            }
            return this.ars.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.ars.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(i.g.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.ars.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(i.d.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(i.f.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(i.f.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(i.f.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                an.i(frameLayout3, i.e.bg_add_photo);
                frameLayout3.setForeground(an.getDrawable(i.e.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.arl.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.arv) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(i.f.delete);
            an.c(imageView, i.e.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aro = i;
    }

    public void setTargetToolId(int i) {
        this.arp = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        an.j(this, i.c.editor_background);
    }
}
