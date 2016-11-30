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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements ab, DragHorizonScrollView.a {
    private static boolean avK = false;
    private int EK;
    private l EL;
    private DragHorizonScrollView avL;
    private TextView avM;
    private DragLayer avN;
    private WriteImagesInfo avO;
    private com.baidu.tbadk.img.b avP;
    private b avQ;
    private String avR;
    private int avS;
    private int avT;
    private boolean avU;
    private String avV;
    private a avW;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void K(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.avR = null;
        this.avS = 13;
        this.avT = 10;
        this.avU = false;
        this.avW = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avR = null;
        this.avS = 13;
        this.avT = 10;
        this.avU = false;
        this.avW = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.avL = (DragHorizonScrollView) findViewById(r.g.muti_image_upload_dragscrollview);
        this.avM = (TextView) findViewById(r.g.muti_image_tips);
        this.avN = (DragLayer) findViewById(r.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.avR = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.avP = bVar;
    }

    public int getImageNum() {
        return this.avO.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.avO = writeImagesInfo;
        this.avQ = new b(getContext(), this.avP, this, this.avW, this.avT == 10);
        this.avQ.a(this.avO);
        this.avL.a(this.avQ, z);
        int maxItemNum = this.avL.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.avR)) {
            this.avM.setText(this.avR);
        } else if (!avK && size > 1) {
            this.avM.setText(r.j.editor_mutiiamge_drag_tip);
            avK = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.avM.setText(getResources().getString(r.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.avQ != null) {
                        this.avQ.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.avT, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avH, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).avI);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EL = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void D(int i, int i2) {
        if (i != i2 && this.avO != null && this.avO.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.avO.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.avL;
    }

    public TextView getMutiImageTips() {
        return this.avM;
    }

    public DragLayer getDragLayer() {
        return this.avN;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b avP;
        private WriteImagesInfo avY = null;
        private ab avZ;
        private a awa;
        private boolean awb;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.awb = true;
            this.mContext = context;
            this.avP = bVar;
            this.avZ = abVar;
            this.awa = aVar;
            this.awb = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.avY = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avY == null) {
                return 0;
            }
            return this.avY.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.avY.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(r.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.avY.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(r.e.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(r.e.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(r.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(r.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(r.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                at.k(frameLayout3, r.f.bg_add_photo);
                frameLayout3.setForeground(at.getDrawable(r.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.avP.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.awb) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(r.g.delete);
            at.c(imageView, r.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(r.j.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.avS = i;
    }

    public void setTargetToolId(int i) {
        this.avT = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        at.l(this, r.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.avU = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.avV = " ";
        } else {
            this.avV = str;
        }
    }
}
