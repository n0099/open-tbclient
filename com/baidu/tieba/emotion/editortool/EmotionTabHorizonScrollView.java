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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l LE;
    private h aZE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aZF;
    private EmotionTabWidgetView.a aZG;
    private LinearLayout aZH;
    private ImageView aZI;
    private boolean aZJ;
    private TbImageView aZK;
    private boolean aZL;
    private int aik;
    private LinearLayout.LayoutParams awA;
    private int awB;
    private int awC;
    private TextView awD;
    private View awE;
    private int awy;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awy = -1;
        this.aZJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awy = -1;
        this.aZJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.awy = -1;
        this.aZJ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aZE = new h(getContext());
        this.aZE.setOrientation(0);
        this.aZE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aZE.setBaselineAligned(false);
        addView(this.aZE);
        this.awB = getResources().getDimensionPixelSize(t.e.face_tab_widget_tb_padding);
        this.awC = getResources().getDimensionPixelSize(t.e.face_tab_widget_lr_padding);
        this.awA = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds122), -1);
        this.aZE.setPadding(0, 0, 0, 0);
        Nc();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aZL = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aZF = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        at.c(linearLayout, t.f.bg_emotion_tab_horizonscrollview, this.aik);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aZL) {
            tbImageView.setForegroundColor(at.getColor(t.d.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(t.d.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.aZN = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.awC, this.awB, this.awC, this.awB);
        View view = new View(getContext());
        cVar2.aZO = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds2);
        if (!this.aZL) {
            view.setBackgroundColor(at.getColor(t.d.emotion_tab_div_line_color));
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
        this.aZE.addView(linearLayout, this.aZE.getChildCount() - 1, this.awA);
        EmotionGroupType DB = cVar.DB();
        if (DB == EmotionGroupType.LOCAL) {
            if (cVar.DC() != null) {
                cVar.DC().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.aZE.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m411getInst().getResources().getString(t.j.local_emotion));
        } else if (DB == EmotionGroupType.PROMOTION) {
            if (cVar.DD() != null) {
                cVar.DD().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m411getInst().getResources().getString(t.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (DB == EmotionGroupType.BIG_EMOTION) {
            if (this.aZJ) {
                if (cVar.DC() != null) {
                    cVar.DC().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.aZE.getChildCount() - 3, null));
            } else {
                if (cVar.DD() != null) {
                    cVar.DD().a(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (this.aZK == null) {
            this.aZK = tbImageView;
            this.aZK.setForegroundColor(at.getColor(t.d.transparent));
        }
        return tbImageView;
    }

    public void Nc() {
        this.aZI = new ImageView(getContext());
        this.aZI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aZI.setPadding(this.awC, this.awB, this.awC, this.awB);
        this.aZH = new LinearLayout(getContext());
        this.aZH.setContentDescription(TbadkCoreApplication.m411getInst().getResources().getString(t.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aZI.setLayoutParams(layoutParams);
        at.b(this.aZI, t.f.icon_store, this.aik);
        this.aZH.addView(this.aZI);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        at.d(view, t.d.emotion_tab_div_line_color, this.aik);
        this.aZH.addView(view);
        this.awD = new TextView(getContext());
        this.awD.setGravity(17);
        this.awD.setTextSize(10.0f);
        this.awD.setText("N");
        this.awD.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aZE.addView(this.aZH, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.face_tab_widget_width), -1));
        this.aZE.setNewView(this.awD);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aZE.setNewViewVisible(true);
        } else {
            this.aZE.setNewViewVisible(false);
        }
        this.aZH.setOnClickListener(new n(this));
        this.awE = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.awE.setLayoutParams(layoutParams3);
        this.aZE.addView(this.awE);
        if (!appResponseToCmd) {
            this.aZH.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void h(int i, boolean z) {
        this.aZJ = z;
        int i2 = i + 1;
        int childCount = this.aZE.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.aZF.get(i2 - 1);
        if (i2 < childCount && cVar.DB() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aZE.getChildAt(i2)).getChildAt(0);
            if (!this.aZJ) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.DD() != null) {
                    cVar.DD().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.DC() != null) {
                cVar.DC().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.awy) {
            if (this.awy != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aZE.getChildAt(this.awy + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aik == 0) {
                        color = getResources().getColor(t.d.emotion_tab_widget_foreground_color);
                    } else {
                        color = at.getColor(t.d.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.awy = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aZE.getChildAt(this.awy + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aZF.get(this.awy);
            if (cVar.DC() != null) {
                cVar.DC().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(at.getColor(t.d.transparent));
                this.aZK = tbImageView2;
            }
        }
    }

    public void reset() {
        this.awy = -1;
        this.aZE.removeAllViews();
        Nc();
        dn(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dn(int i) {
        int color;
        this.aik = i;
        if (this.aZI != null) {
            at.b(this.aZI, t.f.icon_store, i);
        }
        if (this.aZH != null) {
            at.c(this.aZH, t.f.bg_emotion_tab_horizonscrollview, i);
            if (this.aZH.getChildCount() > 0) {
                at.d(this.aZH.getChildAt(1), t.d.emotion_tab_div_line_color, i);
            }
        }
        if (this.awE != null) {
            at.c(this.awE, t.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.awD != null) {
            at.c(this.awD, t.f.icon_news_head_prompt_one, i);
            at.a(this.awD, t.d.cp_cont_i, 1, i);
        }
        int childCount = this.aZE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aZE.getChildAt(i2);
            if (childAt != null) {
                at.c(childAt, t.f.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aZN != null) {
                        if (i == 0) {
                            color = getResources().getColor(t.d.emotion_tab_widget_foreground_color);
                        } else {
                            color = at.getColor(t.d.emotion_tab_widget_foreground_color);
                        }
                        cVar.aZN.setForegroundColor(color);
                    }
                    if (cVar.aZO != null) {
                        at.d(cVar.aZO, t.d.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aZK != null) {
            this.aZK.setForegroundColor(at.getColor(t.d.transparent));
            if (this.aZK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aZK.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aZG = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int ZX;

        private a(int i) {
            this.ZX = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aZK) {
                ((TbImageView) view).setForegroundColor(at.getColor(t.d.transparent));
                if (EmotionTabHorizonScrollView.this.aZK != null) {
                    if (!EmotionTabHorizonScrollView.this.aZL) {
                        EmotionTabHorizonScrollView.this.aZK.setForegroundColor(at.getColor(t.d.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aZK.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(t.d.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aZK = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.ZX);
            EmotionTabHorizonScrollView.this.aZG.eQ(this.ZX);
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
        TbImageView aZN;
        View aZO;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
