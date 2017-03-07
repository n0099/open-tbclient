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
    private static boolean azH = false;
    private int Lk;
    private j Ll;
    private DragHorizonScrollView azI;
    private TextView azJ;
    private DragLayer azK;
    private WriteImagesInfo azL;
    private com.baidu.tbadk.img.b azM;
    private b azN;
    private String azO;
    private int azP;
    private int azQ;
    private boolean azR;
    private String azS;
    private a azT;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.azO = null;
        this.azP = 13;
        this.azQ = 10;
        this.azR = false;
        this.azT = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azO = null;
        this.azP = 13;
        this.azQ = 10;
        this.azR = false;
        this.azT = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.azI = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.azJ = (TextView) findViewById(w.h.muti_image_tips);
        this.azK = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.azO = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.azM = bVar;
    }

    public int getImageNum() {
        return this.azL.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azL = writeImagesInfo;
        this.azN = new b(getContext(), this.azM, this, this.azT, this.azQ == 10);
        this.azN.a(this.azL);
        this.azI.a(this.azN, z);
        int maxItemNum = this.azI.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.azO)) {
            this.azJ.setText(this.azO);
        } else if (!azH && size > 1) {
            this.azJ.setText(w.l.editor_mutiiamge_drag_tip);
            azH = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.azJ.setText(getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.azN != null) {
                        this.azN.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.azQ, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azE, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azF);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Ll = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void ml() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.azL != null && this.azL.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.azL.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.azI;
    }

    public TextView getMutiImageTips() {
        return this.azJ;
    }

    public DragLayer getDragLayer() {
        return this.azK;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b azM;
        private WriteImagesInfo azV = null;
        private y azW;
        private a azX;
        private boolean azY;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.azY = true;
            this.mContext = context;
            this.azM = bVar;
            this.azW = yVar;
            this.azX = aVar;
            this.azY = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.azV = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.azV == null) {
                return 0;
            }
            return this.azV.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.azV.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.azV.getChosedFiles(), i);
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
                if (this.azM.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.azY) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(w.h.delete);
            aq.c(imageView, w.g.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(w.l.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.azP = i;
    }

    public void setTargetToolId(int i) {
        this.azQ = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.azR = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.azS = " ";
        } else {
            this.azS = str;
        }
    }
}
