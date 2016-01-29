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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.k Lx;
    private h aUV;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aUW;
    private EmotionTabWidgetView.a aUX;
    private LinearLayout aUY;
    private ImageView aUZ;
    private boolean aVa;
    private TbImageView aVb;
    private boolean aVc;
    private int ahU;
    private int avR;
    private LinearLayout.LayoutParams avT;
    private int avU;
    private int avV;
    private TextView avW;
    private View avX;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avR = -1;
        this.aVa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avR = -1;
        this.aVa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.avR = -1;
        this.aVa = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aUV = new h(getContext());
        this.aUV.setOrientation(0);
        this.aUV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aUV.setBaselineAligned(false);
        addView(this.aUV);
        this.avU = getResources().getDimensionPixelSize(t.e.face_tab_widget_tb_padding);
        this.avV = getResources().getDimensionPixelSize(t.e.face_tab_widget_lr_padding);
        this.avT = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds122), -1);
        this.aUV.setPadding(0, 0, 0, 0);
        Lo();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aVc = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aUW = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ar.c(linearLayout, t.f.bg_emotion_tab_horizonscrollview, this.ahU);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aVc) {
            tbImageView.setForegroundColor(ar.getColor(t.d.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(t.d.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.aVf = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.avV, this.avU, this.avV, this.avU);
        View view = new View(getContext());
        cVar2.aVg = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds2);
        if (!this.aVc) {
            view.setBackgroundColor(ar.getColor(t.d.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(t.d.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.aUV.addView(linearLayout, this.aUV.getChildCount() - 1, this.avT);
        EmotionGroupType CT = cVar.CT();
        if (CT == EmotionGroupType.LOCAL) {
            if (cVar.CU() != null) {
                cVar.CU().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.aUV.getChildCount() - 3, null));
        } else if (CT == EmotionGroupType.PROMOTION) {
            if (cVar.CV() != null) {
                cVar.CV().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
        } else if (CT == EmotionGroupType.BIG_EMOTION) {
            if (this.aVa) {
                if (cVar.CU() != null) {
                    cVar.CU().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.aUV.getChildCount() - 3, null));
            } else {
                if (cVar.CV() != null) {
                    cVar.CV().a(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
        }
        if (this.aVb == null) {
            this.aVb = tbImageView;
            this.aVb.setForegroundColor(ar.getColor(t.d.transparent));
        }
        return tbImageView;
    }

    public void Lo() {
        this.aUZ = new ImageView(getContext());
        this.aUZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aUZ.setPadding(this.avV, this.avU, this.avV, this.avU);
        this.aUY = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aUZ.setLayoutParams(layoutParams);
        ar.b(this.aUZ, t.f.icon_store, this.ahU);
        this.aUY.addView(this.aUZ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ar.d(view, t.d.emotion_tab_div_line_color, this.ahU);
        this.aUY.addView(view);
        this.avW = new TextView(getContext());
        this.avW.setGravity(17);
        this.avW.setTextSize(10.0f);
        this.avW.setText("N");
        this.avW.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aUV.addView(this.aUY, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.face_tab_widget_width), -1));
        this.aUV.setNewView(this.avW);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aUV.setNewViewVisible(true);
        } else {
            this.aUV.setNewViewVisible(false);
        }
        this.aUY.setOnClickListener(new n(this));
        this.avX = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.avX.setLayoutParams(layoutParams3);
        this.aUV.addView(this.avX);
        if (!appResponseToCmd) {
            this.aUY.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void h(int i, boolean z) {
        this.aVa = z;
        int i2 = i + 1;
        int childCount = this.aUV.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.aUW.get(i2 - 1);
        if (i2 < childCount && cVar.CT() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aUV.getChildAt(i2)).getChildAt(0);
            if (!this.aVa) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.CV() != null) {
                    cVar.CV().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.CU() != null) {
                cVar.CU().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.avR) {
            if (this.avR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aUV.getChildAt(this.avR + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ahU == 0) {
                        color = getResources().getColor(t.d.emotion_tab_widget_foreground_color);
                    } else {
                        color = ar.getColor(t.d.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.avR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aUV.getChildAt(this.avR + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(t.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aUW.get(this.avR);
            if (cVar.CU() != null) {
                cVar.CU().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ar.getColor(t.d.transparent));
                this.aVb = tbImageView2;
            }
        }
    }

    public void reset() {
        this.avR = -1;
        this.aUV.removeAllViews();
        Lo();
        dk(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dk(int i) {
        int color;
        this.ahU = i;
        if (this.aUZ != null) {
            ar.b(this.aUZ, t.f.icon_store, i);
        }
        if (this.aUY != null) {
            ar.c(this.aUY, t.f.bg_emotion_tab_horizonscrollview, i);
            if (this.aUY.getChildCount() > 0) {
                ar.d(this.aUY.getChildAt(1), t.d.emotion_tab_div_line_color, i);
            }
        }
        if (this.avX != null) {
            ar.c(this.avX, t.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.avW != null) {
            ar.c(this.avW, t.f.icon_news_head_prompt_one, i);
            ar.a(this.avW, t.d.cp_cont_i, 1, i);
        }
        int childCount = this.aUV.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aUV.getChildAt(i2);
            if (childAt != null) {
                ar.c(childAt, t.f.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aVf != null) {
                        if (i == 0) {
                            color = getResources().getColor(t.d.emotion_tab_widget_foreground_color);
                        } else {
                            color = ar.getColor(t.d.emotion_tab_widget_foreground_color);
                        }
                        cVar.aVf.setForegroundColor(color);
                    }
                    if (cVar.aVg != null) {
                        ar.d(cVar.aVg, t.d.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aVb != null) {
            this.aVb.setForegroundColor(ar.getColor(t.d.transparent));
            if (this.aVb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aVb.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aUX = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aaL;

        private a(int i) {
            this.aaL = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aVb) {
                ((TbImageView) view).setForegroundColor(ar.getColor(t.d.transparent));
                if (EmotionTabHorizonScrollView.this.aVb != null) {
                    if (!EmotionTabHorizonScrollView.this.aVc) {
                        EmotionTabHorizonScrollView.this.aVb.setForegroundColor(ar.getColor(t.d.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aVb.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(t.d.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aVb = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aaL);
            EmotionTabHorizonScrollView.this.aUX.eK(this.aaL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final String aVe;

        private b(String str) {
            this.aVe = str;
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.aVe, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        TbImageView aVf;
        View aVg;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
