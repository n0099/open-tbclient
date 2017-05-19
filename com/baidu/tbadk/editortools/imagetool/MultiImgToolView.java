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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements y, DragHorizonScrollView.a {
    private static boolean azX = false;
    private int Kf;
    private j Kg;
    private DragLayer aAa;
    private WriteImagesInfo aAb;
    private com.baidu.tbadk.img.b aAc;
    private b aAd;
    private String aAe;
    private int aAf;
    private int aAg;
    private boolean aAh;
    private String aAi;
    private a aAj;
    private DragHorizonScrollView azY;
    private TextView azZ;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aAe = null;
        this.aAf = 13;
        this.aAg = 10;
        this.aAh = false;
        this.aAj = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAe = null;
        this.aAf = 13;
        this.aAg = 10;
        this.aAh = false;
        this.aAj = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.azY = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.azZ = (TextView) findViewById(w.h.muti_image_tips);
        this.aAa = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aAe = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aAc = bVar;
    }

    public int getImageNum() {
        return this.aAb.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aAb = writeImagesInfo;
        this.aAd = new b(getContext(), this.aAc, this, this.aAj, this.aAg == 10);
        this.aAd.a(this.aAb);
        this.azY.a(this.aAd, z);
        int maxItemNum = this.azY.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aAe)) {
            this.azZ.setText(this.aAe);
        } else if (!azX && size > 1) {
            this.azZ.setText(w.l.editor_mutiiamge_drag_tip);
            azX = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.azZ.setText(getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aAd != null) {
                        this.aAd.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aAg, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azU, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azV);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.aAb != null && this.aAb.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aAb.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.azY;
    }

    public TextView getMutiImageTips() {
        return this.azZ;
    }

    public DragLayer getDragLayer() {
        return this.aAa;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aAc;
        private WriteImagesInfo aAl = null;
        private y aAm;
        private a aAn;
        private boolean aAo;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aAo = true;
            this.mContext = context;
            this.aAc = bVar;
            this.aAm = yVar;
            this.aAn = aVar;
            this.aAo = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aAl = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aAl == null) {
                return 0;
            }
            return this.aAl.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aAl.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.aAl.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(w.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(w.f.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(w.h.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(w.h.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(w.h.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                aq.j(frameLayout3, w.g.bg_add_photo);
                frameLayout3.setForeground(aq.getDrawable(w.g.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aAc.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aAo) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(w.h.delete);
            aq.c(imageView, w.g.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(w.l.editor_image)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aAf = i;
    }

    public void setTargetToolId(int i) {
        this.aAg = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aAh = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aAi = " ";
        } else {
            this.aAi = str;
        }
    }
}
