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
import com.baidu.tbadk.core.util.am;
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
    private static boolean arf = false;
    private int Ky;
    private j Kz;
    private DragHorizonScrollView arg;
    private TextView arh;
    private DragLayer ari;
    private WriteImagesInfo arj;
    private com.baidu.tbadk.img.b ark;
    private b arl;
    private String arm;
    private int arn;
    private int aro;
    private a arp;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void t(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.arm = null;
        this.arn = 13;
        this.aro = 10;
        this.arp = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arm = null;
        this.arn = 13;
        this.aro = 10;
        this.arp = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.arg = (DragHorizonScrollView) findViewById(i.f.muti_image_upload_dragscrollview);
        this.arh = (TextView) findViewById(i.f.muti_image_tips);
        this.ari = (DragLayer) findViewById(i.f.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.arm = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.ark = bVar;
    }

    public int getImageNum() {
        return this.arj.getChosedFiles().size();
    }

    private void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.arj = writeImagesInfo;
        this.arl = new b(getContext(), this.ark, this, this.arp, this.aro == 10);
        this.arl.a(this.arj);
        this.arg.a(this.arl, z);
        int maxItemNum = this.arg.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.arm)) {
            this.arh.setText(this.arm);
        } else if (!arf && size > 1) {
            this.arh.setText(i.h.editor_mutiiamge_drag_tip);
            arf = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.arh.setText(getResources().getString(i.h.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.arl != null) {
                        this.arl.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aro, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).arc, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ard);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
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
        if (i != i2 && this.arj != null && this.arj.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.arj.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.arg;
    }

    public TextView getMutiImageTips() {
        return this.arh;
    }

    public DragLayer getDragLayer() {
        return this.ari;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b ark;
        private WriteImagesInfo arr = null;
        private w ars;
        private a art;
        private boolean aru;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, w wVar, a aVar, boolean z) {
            this.aru = true;
            this.mContext = context;
            this.ark = bVar;
            this.ars = wVar;
            this.art = aVar;
            this.aru = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.arr = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.arr == null) {
                return 0;
            }
            return this.arr.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.arr.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(i.g.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.arr.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(i.d.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(i.f.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(i.f.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(i.f.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                am.i(frameLayout3, i.e.bg_add_photo);
                frameLayout3.setForeground(am.getDrawable(i.e.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.ark.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aru) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(i.f.delete);
            am.c(imageView, i.e.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.arn = i;
    }

    public void setTargetToolId(int i) {
        this.aro = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        am.j(this, i.c.editor_background);
    }
}
