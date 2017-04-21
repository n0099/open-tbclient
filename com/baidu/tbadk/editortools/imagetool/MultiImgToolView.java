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
    private static boolean azZ = false;
    private int KN;
    private j KO;
    private DragHorizonScrollView aAa;
    private TextView aAb;
    private DragLayer aAc;
    private WriteImagesInfo aAd;
    private com.baidu.tbadk.img.b aAe;
    private b aAf;
    private String aAg;
    private int aAh;
    private int aAi;
    private boolean aAj;
    private String aAk;
    private a aAl;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aAg = null;
        this.aAh = 13;
        this.aAi = 10;
        this.aAj = false;
        this.aAl = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAg = null;
        this.aAh = 13;
        this.aAi = 10;
        this.aAj = false;
        this.aAl = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aAa = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.aAb = (TextView) findViewById(w.h.muti_image_tips);
        this.aAc = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aAg = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aAe = bVar;
    }

    public int getImageNum() {
        return this.aAd.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aAd = writeImagesInfo;
        this.aAf = new b(getContext(), this.aAe, this, this.aAl, this.aAi == 10);
        this.aAf.a(this.aAd);
        this.aAa.a(this.aAf, z);
        int maxItemNum = this.aAa.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aAg)) {
            this.aAb.setText(this.aAg);
        } else if (!azZ && size > 1) {
            this.aAb.setText(w.l.editor_mutiiamge_drag_tip);
            azZ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.aAb.setText(getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aAf != null) {
                        this.aAf.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aAi, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azW, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azX);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.KO = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.aAd != null && this.aAd.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aAd.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aAa;
    }

    public TextView getMutiImageTips() {
        return this.aAb;
    }

    public DragLayer getDragLayer() {
        return this.aAc;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aAe;
        private WriteImagesInfo aAn = null;
        private y aAo;
        private a aAp;
        private boolean aAq;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aAq = true;
            this.mContext = context;
            this.aAe = bVar;
            this.aAo = yVar;
            this.aAp = aVar;
            this.aAq = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aAn = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aAn == null) {
                return 0;
            }
            return this.aAn.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aAn.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.aAn.getChosedFiles(), i);
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
                if (this.aAe.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aAq) {
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
        this.aAh = i;
    }

    public void setTargetToolId(int i) {
        this.aAi = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aAj = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aAk = " ";
        } else {
            this.aAk = str;
        }
    }
}
