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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.tieba.u;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements ab, DragHorizonScrollView.a {
    private static boolean arr = false;
    private int BV;
    private l BW;
    private int arA;
    private boolean arB;
    private String arC;
    private a arD;
    private DragHorizonScrollView ars;
    private TextView art;
    private DragLayer aru;
    private WriteImagesInfo arv;
    private com.baidu.tbadk.img.b arw;
    private b arx;
    private String ary;
    private int arz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void I(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.ary = null;
        this.arz = 13;
        this.arA = 10;
        this.arB = false;
        this.arD = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ary = null;
        this.arz = 13;
        this.arA = 10;
        this.arB = false;
        this.arD = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ars = (DragHorizonScrollView) findViewById(u.g.muti_image_upload_dragscrollview);
        this.art = (TextView) findViewById(u.g.muti_image_tips);
        this.aru = (DragLayer) findViewById(u.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.ary = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.arw = bVar;
    }

    public int getImageNum() {
        return this.arv.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.arv = writeImagesInfo;
        this.arx = new b(getContext(), this.arw, this, this.arD, this.arA == 10);
        this.arx.a(this.arv);
        this.ars.a(this.arx, z);
        int maxItemNum = this.ars.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.ary)) {
            this.art.setText(this.ary);
        } else if (!arr && size > 1) {
            this.art.setText(u.j.editor_mutiiamge_drag_tip);
            arr = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.art.setText(getResources().getString(u.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.arx != null) {
                        this.arx.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.arA, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aro, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).arp);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aro, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).arp);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BW = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void B(int i, int i2) {
        if (i != i2 && this.arv != null && this.arv.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.arv.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.ars;
    }

    public TextView getMutiImageTips() {
        return this.art;
    }

    public DragLayer getDragLayer() {
        return this.aru;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo arF = null;
        private ab arG;
        private a arH;
        private boolean arI;
        private com.baidu.tbadk.img.b arw;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.arI = true;
            this.mContext = context;
            this.arw = bVar;
            this.arG = abVar;
            this.arH = aVar;
            this.arI = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.arF = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.arF == null) {
                return 0;
            }
            return this.arF.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.arF.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(u.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.c(this.arF.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(u.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(u.e.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(u.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(u.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(u.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                av.k(frameLayout3, u.f.bg_add_photo);
                frameLayout3.setForeground(av.getDrawable(u.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.arw.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.arI) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(u.g.delete);
            av.c(imageView, u.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(u.j.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.arz = i;
    }

    public void setTargetToolId(int i) {
        this.arA = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        av.l(this, u.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.arB = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.arC = " ";
        } else {
            this.arC = str;
        }
    }
}
