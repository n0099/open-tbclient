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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements w, DragHorizonScrollView.a {
    private int Ky;
    private j Kz;
    private DragHorizonScrollView aqZ;
    private TextView ara;
    private DragLayer arb;
    private WriteImagesInfo arc;
    private com.baidu.tbadk.img.b ard;
    private b are;
    private String arf;
    private int arg;
    private int arh;
    private a ari;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void t(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.arf = null;
        this.arg = 13;
        this.arh = 10;
        this.ari = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arf = null;
        this.arg = 13;
        this.arh = 10;
        this.ari = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.aqZ = (DragHorizonScrollView) findViewById(i.f.muti_image_upload_dragscrollview);
        this.ara = (TextView) findViewById(i.f.muti_image_tips);
        this.arb = (DragLayer) findViewById(i.f.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.arf = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.ard = bVar;
    }

    public int getImageNum() {
        return this.arc.getChosedFiles().size();
    }

    private void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.arc = writeImagesInfo;
        this.are = new b(getContext(), this.ard, this, this.ari, this.arh == 10);
        this.are.a(this.arc);
        this.aqZ.a(this.are, z);
        int maxItemNum = this.aqZ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.arf)) {
            this.ara.setText(this.arf);
        } else if (!ag.apz().apA() && size > 1) {
            this.ara.setText(i.C0057i.editor_mutiiamge_drag_tip);
            ag.apz().fx(true);
        } else {
            this.ara.setText(getResources().getString(i.C0057i.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.are != null) {
                        this.are.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.arh, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aqW, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aqX);
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
    public void oy() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.arc != null && this.arc.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.arc.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aqZ;
    }

    public TextView getMutiImageTips() {
        return this.ara;
    }

    public DragLayer getDragLayer() {
        return this.arb;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b ard;
        private WriteImagesInfo ark = null;
        private w arl;
        private a arm;
        private boolean arn;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, w wVar, a aVar, boolean z) {
            this.arn = true;
            this.mContext = context;
            this.ard = bVar;
            this.arl = wVar;
            this.arm = aVar;
            this.arn = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.ark = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ark == null) {
                return 0;
            }
            return this.ark.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.ark.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(i.g.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.ark.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(i.d.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(i.f.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(i.f.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(i.f.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                al.i(frameLayout3, i.e.bg_add_photo);
                frameLayout3.setForeground(al.getDrawable(i.e.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.ard.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.arn) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(i.f.delete);
            al.c(imageView, i.e.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.arg = i;
    }

    public void setTargetToolId(int i) {
        this.arh = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        al.j(this, i.c.editor_background);
    }
}
