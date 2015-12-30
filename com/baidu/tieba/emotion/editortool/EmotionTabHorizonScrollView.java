package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.k Li;
    private h aSR;
    private EmotionTabWidgetView.a aSS;
    private LinearLayout aST;
    private ImageView aSU;
    private boolean aSV;
    private TbImageView aSW;
    private boolean aSX;
    private int ahf;
    private int auZ;
    private LinearLayout.LayoutParams avb;
    private int avc;
    private int avd;
    private TextView ave;
    private View avf;
    private int from;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auZ = -1;
        this.aSV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auZ = -1;
        this.aSV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.auZ = -1;
        this.aSV = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aSR = new h(getContext());
        this.aSR.setOrientation(0);
        this.aSR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aSR.setBaselineAligned(false);
        addView(this.aSR);
        this.avc = getResources().getDimensionPixelSize(n.e.face_tab_widget_tb_padding);
        this.avd = getResources().getDimensionPixelSize(n.e.face_tab_widget_lr_padding);
        this.avb = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.e.ds122), -1);
        this.aSR.setPadding(0, 0, 0, 0);
        JA();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aSX = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        as.c(linearLayout, n.f.bg_emotion_tab_horizonscrollview, this.ahf);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aSX) {
            tbImageView.setForegroundColor(as.getColor(n.d.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(n.d.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.aSZ = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.avd, this.avc, this.avd, this.avc);
        View view = new View(getContext());
        cVar2.aTa = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.ds2);
        if (!this.aSX) {
            view.setBackgroundColor(as.getColor(n.d.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(n.d.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.aSR.addView(linearLayout, this.aSR.getChildCount() - 1, this.avb);
        EmotionGroupType BC = cVar.BC();
        if (BC == EmotionGroupType.LOCAL) {
            if (cVar.BD() != null) {
                cVar.BD().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.aSR.getChildCount() - 3, null));
        } else if (BC == EmotionGroupType.PROMOTION) {
            if (cVar.BE() != null) {
                cVar.BE().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
        } else if (BC == EmotionGroupType.BIG_EMOTION) {
            if (this.aSV) {
                if (cVar.BD() != null) {
                    cVar.BD().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.aSR.getChildCount() - 3, null));
            } else {
                if (cVar.BE() != null) {
                    cVar.BE().a(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
        }
        if (this.aSW == null) {
            this.aSW = tbImageView;
            this.aSW.setForegroundColor(as.getColor(n.d.transparent));
        }
        return tbImageView;
    }

    public void JA() {
        this.aSU = new ImageView(getContext());
        this.aSU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aSU.setPadding(this.avd, this.avc, this.avd, this.avc);
        this.aST = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aSU.setLayoutParams(layoutParams);
        as.b(this.aSU, n.f.icon_store, this.ahf);
        this.aST.addView(this.aSU);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        as.d(view, n.d.emotion_tab_div_line_color, this.ahf);
        this.aST.addView(view);
        this.ave = new TextView(getContext());
        this.ave.setGravity(17);
        this.ave.setTextSize(10.0f);
        this.ave.setText("N");
        this.ave.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aSR.addView(this.aST, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.e.face_tab_widget_width), -1));
        this.aSR.setNewView(this.ave);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aSR.setNewViewVisible(true);
        } else {
            this.aSR.setNewViewVisible(false);
        }
        this.aST.setOnClickListener(new n(this));
        this.avf = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.avf.setLayoutParams(layoutParams3);
        this.aSR.addView(this.avf);
        if (!appResponseToCmd) {
            this.aST.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void h(int i, boolean z) {
        this.aSV = z;
        int i2 = i + 1;
        int childCount = this.aSR.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && cVar.BC() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aSR.getChildAt(i2)).getChildAt(0);
            if (!this.aSV) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.BE() != null) {
                    cVar.BE().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.BD() != null) {
                cVar.BD().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.auZ) {
            if (this.auZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aSR.getChildAt(this.auZ + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ahf == 0) {
                        color = getResources().getColor(n.d.emotion_tab_widget_foreground_color);
                    } else {
                        color = as.getColor(n.d.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.auZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aSR.getChildAt(this.auZ + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(n.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.mDatas.get(this.auZ);
            if (cVar.BD() != null) {
                cVar.BD().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(as.getColor(n.d.transparent));
                this.aSW = tbImageView2;
            }
        }
    }

    public void reset() {
        this.auZ = -1;
        this.aSR.removeAllViews();
        JA();
        cR(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cR(int i) {
        int color;
        this.ahf = i;
        if (this.aSU != null) {
            as.b(this.aSU, n.f.icon_store, i);
        }
        if (this.aST != null) {
            as.c(this.aST, n.f.bg_emotion_tab_horizonscrollview, i);
            if (this.aST.getChildCount() > 0) {
                as.d(this.aST.getChildAt(1), n.d.emotion_tab_div_line_color, i);
            }
        }
        if (this.avf != null) {
            as.c(this.avf, n.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.ave != null) {
            as.c(this.ave, n.f.icon_news_head_prompt_one, i);
            as.a(this.ave, n.d.cp_cont_i, 1, i);
        }
        int childCount = this.aSR.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aSR.getChildAt(i2);
            if (childAt != null) {
                as.c(childAt, n.f.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aSZ != null) {
                        if (i == 0) {
                            color = getResources().getColor(n.d.emotion_tab_widget_foreground_color);
                        } else {
                            color = as.getColor(n.d.emotion_tab_widget_foreground_color);
                        }
                        cVar.aSZ.setForegroundColor(color);
                    }
                    if (cVar.aTa != null) {
                        as.d(cVar.aTa, n.d.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aSW != null) {
            this.aSW.setForegroundColor(as.getColor(n.d.transparent));
            if (this.aSW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aSW.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aSS = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aan;

        private a(int i) {
            this.aan = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aSW) {
                ((TbImageView) view).setForegroundColor(as.getColor(n.d.transparent));
                if (EmotionTabHorizonScrollView.this.aSW != null) {
                    if (!EmotionTabHorizonScrollView.this.aSX) {
                        EmotionTabHorizonScrollView.this.aSW.setForegroundColor(as.getColor(n.d.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aSW.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(n.d.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aSW = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aan);
            EmotionTabHorizonScrollView.this.aSS.eq(this.aan);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final String mGroupId;

        private b(String str) {
            this.mGroupId = str;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, b bVar) {
            this(str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            switch (EmotionTabHorizonScrollView.this.from) {
                case 1:
                    str = "faceshop_from_write_promotion";
                    break;
                case 2:
                    str = "faceshop_from_pchat_promotion";
                    break;
                case 3:
                    str = "faceshop_from_gchat_promotion";
                    break;
                default:
                    str = "";
                    break;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        TbImageView aSZ;
        View aTa;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
