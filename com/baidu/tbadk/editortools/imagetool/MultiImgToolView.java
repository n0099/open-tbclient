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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements y, DragHorizonScrollView.a {
    private static boolean aum = false;
    private int DW;
    private j DX;
    private DragHorizonScrollView aun;
    private TextView auo;
    private DragLayer aup;
    private WriteImagesInfo auq;
    private com.baidu.tbadk.img.b aur;
    private b aus;
    private String aut;
    private int auu;
    private int auv;
    private boolean auw;
    private String aux;
    private a auy;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void I(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.aut = null;
        this.auu = 13;
        this.auv = 10;
        this.auw = false;
        this.auy = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aut = null;
        this.auu = 13;
        this.auv = 10;
        this.auw = false;
        this.auy = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aun = (DragHorizonScrollView) findViewById(r.h.muti_image_upload_dragscrollview);
        this.auo = (TextView) findViewById(r.h.muti_image_tips);
        this.aup = (DragLayer) findViewById(r.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.aut = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aur = bVar;
    }

    public int getImageNum() {
        return this.auq.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.auq = writeImagesInfo;
        this.aus = new b(getContext(), this.aur, this, this.auy, this.auv == 10);
        this.aus.a(this.auq);
        this.aun.a(this.aus, z);
        int maxItemNum = this.aun.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.aut)) {
            this.auo.setText(this.aut);
        } else if (!aum && size > 1) {
            this.auo.setText(r.l.editor_mutiiamge_drag_tip);
            aum = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.auo.setText(getResources().getString(r.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.aus != null) {
                        this.aus.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.auv, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auj, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).auk);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.DX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lr() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void E(int i, int i2) {
        if (i != i2 && this.auq != null && this.auq.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.auq.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aun;
    }

    public TextView getMutiImageTips() {
        return this.auo;
    }

    public DragLayer getDragLayer() {
        return this.aup;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo auA = null;
        private y auB;
        private a auC;
        private boolean auD;
        private com.baidu.tbadk.img.b aur;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.auD = true;
            this.mContext = context;
            this.aur = bVar;
            this.auB = yVar;
            this.auC = aVar;
            this.auD = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.auA = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.auA == null) {
                return 0;
            }
            return this.auA.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.auA.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(r.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) w.c(this.auA.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(r.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(r.f.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(r.h.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(r.h.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(r.h.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                ap.j(frameLayout3, r.g.bg_add_photo);
                frameLayout3.setForeground(ap.getDrawable(r.g.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aur.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.auD) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(r.h.delete);
            ap.c(imageView, r.g.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(r.l.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.auu = i;
    }

    public void setTargetToolId(int i) {
        this.auv = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        ap.k(this, r.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.auw = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.aux = " ";
        } else {
            this.aux = str;
        }
    }
}
