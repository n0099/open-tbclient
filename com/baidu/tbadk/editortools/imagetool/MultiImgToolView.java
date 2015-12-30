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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgToolView extends DragContainer implements z, DragHorizonScrollView.a {
    private static boolean atk = false;
    private int Lh;
    private k Li;
    private DragHorizonScrollView atl;
    private TextView atm;
    private DragLayer atn;
    private WriteImagesInfo ato;
    private com.baidu.tbadk.img.b atp;
    private b atq;
    private String atr;
    private int ats;
    private int att;
    private boolean atu;
    private String atv;
    private a atw;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void t(View view);
    }

    public MultiImgToolView(Context context) {
        super(context);
        this.atr = null;
        this.ats = 13;
        this.att = 10;
        this.atu = false;
        this.atw = new e(this);
    }

    public MultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atr = null;
        this.ats = 13;
        this.att = 10;
        this.atu = false;
        this.atw = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.atl = (DragHorizonScrollView) findViewById(n.g.muti_image_upload_dragscrollview);
        this.atm = (TextView) findViewById(n.g.muti_image_tips);
        this.atn = (DragLayer) findViewById(n.g.muti_image_upload_draglayer);
    }

    public void setDefaultTip(String str) {
        this.atr = str;
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.atp = bVar;
    }

    public int getImageNum() {
        return this.ato.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.ato = writeImagesInfo;
        this.atq = new b(getContext(), this.atp, this, this.atw, this.att == 10);
        this.atq.a(this.ato);
        this.atl.a(this.atq, z);
        int maxItemNum = this.atl.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (size == 1 && !TextUtils.isEmpty(this.atr)) {
            this.atm.setText(this.atr);
        } else if (!atk && size > 1) {
            this.atm.setText(n.j.editor_mutiiamge_drag_tip);
            atk = true;
            TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", true);
        } else {
            this.atm.setText(getResources().getString(n.j.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
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
                    if (this.atq != null) {
                        this.atq.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.att, null));
                    return;
                case 10:
                case 11:
                default:
                    return;
                case 12:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ath, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).ati);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Li = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lh = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lh;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.ato != null && this.ato.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.ato.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.atl;
    }

    public TextView getMutiImageTips() {
        return this.atm;
    }

    public DragLayer getDragLayer() {
        return this.atn;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private a atA;
        private boolean atB;
        private com.baidu.tbadk.img.b atp;
        private WriteImagesInfo aty = null;
        private z atz;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, z zVar, a aVar, boolean z) {
            this.atB = true;
            this.mContext = context;
            this.atp = bVar;
            this.atz = zVar;
            this.atA = aVar;
            this.atB = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aty = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aty == null) {
                return 0;
            }
            return this.aty.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aty.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(n.h.editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = this.aty.getChosedFiles().get(i);
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(n.e.editor_muti_image_upload_scrollview_paddingleft) * 2)) + this.mContext.getResources().getDimensionPixelSize(n.e.default_gap_24);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(n.g.iv_container);
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(n.g.shadow_container);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(n.g.iv);
            if (measuredWidth > 0) {
                int paddingRight = (measuredWidth / 3) - linearLayout.getPaddingRight();
                int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
                as.i(frameLayout3, n.f.bg_add_photo);
                frameLayout3.setForeground(as.getDrawable(n.f.bg_add_photo_foregroundselector));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(paddingRight, measuredHeight));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.atp.a(imageFileInfo, new f(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.atB) {
                frameLayout2.setOnClickListener(new g(this, viewGroup));
            }
            ImageView imageView = (ImageView) frameLayout2.findViewById(n.g.delete);
            as.c(imageView, n.f.btn_add_photo_close);
            imageView.setOnClickListener(new h(this, frameLayout2));
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.ats = i;
    }

    public void setTargetToolId(int i) {
        this.att = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        as.j(this, n.d.editor_background);
    }

    public void setNeedQuit(boolean z) {
        this.atu = z;
    }

    public void setNoPicTips(String str) {
        if (StringUtils.isNULL(str)) {
            this.atv = " ";
        } else {
            this.atv = str;
        }
    }
}
