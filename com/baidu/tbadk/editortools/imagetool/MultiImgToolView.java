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
    private static boolean azJ = false;
    private int JT;
    private j JU;
    private DragHorizonScrollView azK;
    private TextView azL;
    private DragLayer azM;
    private WriteImagesInfo azN;
    private com.baidu.tbadk.img.b azO;
    private b azP;
    private String azQ;
    private int azR;
    private int azS;
    private boolean azT;
    private String azU;
    private a azV;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.azQ = null;
        this.azR = 13;
        this.azS = 10;
        this.azT = false;
        this.azV = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azQ = null;
        this.azR = 13;
        this.azS = 10;
        this.azT = false;
        this.azV = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.azK = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.azL = (TextView) findViewById(w.h.muti_image_tips);
        this.azM = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.azQ = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.azO = bVar;
    }

    public int getImageNum() {
        return this.azN.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azN = writeImagesInfo;
        this.azP = new b(getContext(), this.azO, this, this.azV, this.azS == 10);
        this.azP.a(this.azN);
        this.azK.a(this.azP, z);
        int maxItemNum = this.azK.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.azQ)) {
            this.azL.setText(this.azQ);
        } else if (!azJ && size > 1) {
            this.azL.setText(w.l.editor_mutiiamge_drag_tip);
            azJ = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.azL.setText(getResources().getString(w.l.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.azP != null) {
                        this.azP.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.azS, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azH);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JU = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.azN != null && this.azN.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.azN.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.azK;
    }

    public TextView getMutiImageTips() {
        return this.azL;
    }

    public DragLayer getDragLayer() {
        return this.azM;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private boolean aAa;
        private com.baidu.tbadk.img.b azO;
        private WriteImagesInfo azX = null;
        private y azY;
        private a azZ;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aAa = true;
            this.mContext = context;
            this.azO = bVar;
            this.azY = yVar;
            this.azZ = aVar;
            this.aAa = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.azX = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.azX == null) {
                return 0;
            }
            return this.azX.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.azX.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.azX.getChosedFiles(), i);
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
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.L(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.azO.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aAa) {
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
        this.azR = i;
    }

    public void setTargetToolId(int i) {
        this.azS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.azT = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.azU = " ";
        } else {
            this.azU = str;
        }
    }
}
