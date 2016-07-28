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
    private static boolean asg = false;
    private int Cv;
    private l Cw;
    private DragHorizonScrollView ash;
    private TextView asi;
    private DragLayer asj;
    private WriteImagesInfo ask;
    private com.baidu.tbadk.img.b asl;
    private b asm;
    private String asn;
    private int aso;
    private int asp;
    private boolean asq;
    private String asr;
    private a ass;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void I(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.asn = null;
        this.aso = 13;
        this.asp = 10;
        this.asq = false;
        this.ass = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asn = null;
        this.aso = 13;
        this.asp = 10;
        this.asq = false;
        this.ass = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.ash = (DragHorizonScrollView) findViewById(u.g.muti_image_upload_dragscrollview);
        this.asi = (TextView) findViewById(u.g.muti_image_tips);
        this.asj = (DragLayer) findViewById(u.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.asn = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.asl = bVar;
    }

    public int getImageNum() {
        return this.ask.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.ask = writeImagesInfo;
        this.asm = new b(getContext(), this.asl, this, this.ass, this.asp == 10);
        this.asm.a(this.ask);
        this.ash.a(this.asm, z);
        int maxItemNum = this.ash.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.asn)) {
            this.asi.setText(this.asn);
        } else if (!asg && size > 1) {
            this.asi.setText(u.j.editor_mutiiamge_drag_tip);
            asg = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.asi.setText(getResources().getString(u.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.asm != null) {
                        this.asm.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.asp, null));
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).asd, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ase);
                        return;
                    }
                    return;
                case 22:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).asd, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ase);
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
        this.Cw = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kB() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void B(int i, int i2) {
        if (i != i2 && this.ask != null && this.ask.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.ask.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.ash;
    }

    public TextView getMutiImageTips() {
        return this.asi;
    }

    public DragLayer getDragLayer() {
        return this.asj;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b asl;
        private WriteImagesInfo asu = null;
        private ab asv;
        private a asw;
        private boolean asx;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, ab abVar, a aVar, boolean z) {
            this.asx = true;
            this.mContext = context;
            this.asl = bVar;
            this.asv = abVar;
            this.asw = aVar;
            this.asx = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.asu = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.asu == null) {
                return 0;
            }
            return this.asu.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.asu.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(u.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) y.c(this.asu.getChosedFiles(), i);
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
                if (this.asl.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.asx) {
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
        this.aso = i;
    }

    public void setTargetToolId(int i) {
        this.asp = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        av.l(this, u.d.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.asq = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.asr = " ";
        } else {
            this.asr = str;
        }
    }
}
