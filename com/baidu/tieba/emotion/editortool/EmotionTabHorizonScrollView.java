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
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j KM;
    private int aBR;
    private LinearLayout.LayoutParams aBT;
    private int aBU;
    private int aBV;
    private TextView aBW;
    private View aBX;
    private int amZ;
    private i bCK;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bCL;
    private EmotionTabWidgetView.a bCM;
    private LinearLayout bCN;
    private ImageView bCO;
    private boolean bCP;
    private TbImageView bCQ;
    private boolean bCR;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBR = -1;
        this.bCP = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBR = -1;
        this.bCP = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aBR = -1;
        this.bCP = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bCK = new i(getContext());
        this.bCK.setOrientation(0);
        this.bCK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bCK.setBaselineAligned(false);
        addView(this.bCK);
        this.aBU = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBV = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBT = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds122), -1);
        this.bCK.setPadding(0, 0, 0, 0);
        Vg();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bCR = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bCL = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bCV = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bCT = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aBV, this.aBU, this.aBV, this.aBU);
        View view = new View(getContext());
        aVar.bCU = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bCK.addView(linearLayout, this.bCK.getChildCount() - 1, this.aBT);
        EmotionGroupType DC = cVar.DC();
        if (DC == EmotionGroupType.LOCAL) {
            if (cVar.DD() != null) {
                cVar.DD().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bCK.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.local_emotion));
        } else if (DC == EmotionGroupType.PROMOTION) {
            if (cVar.DE() != null) {
                cVar.DE().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(w.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (DC == EmotionGroupType.BIG_EMOTION) {
            if (this.bCP) {
                if (cVar.DD() != null) {
                    cVar.DD().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bCK.getChildCount() - 3, null));
            } else {
                if (cVar.DE() != null) {
                    cVar.DE().e(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bCR && this.amZ == 1) {
            view.setBackgroundColor(aq.getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(aq.getColor(w.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(w.e.common_color_10287));
        }
        if (this.bCQ == null) {
            this.bCQ = tbImageView;
            this.bCQ.setForegroundColor(aq.getColor(w.e.common_color_10022));
        }
        aq.d(linearLayout, w.g.bg_emotion_tab_horizonscrollview, this.amZ);
        return tbImageView;
    }

    public void Vg() {
        this.bCO = new ImageView(getContext());
        this.bCO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bCO.setPadding(this.aBV, this.aBU, this.aBV, this.aBU);
        this.bCN = new LinearLayout(getContext());
        this.bCN.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bCO.setLayoutParams(layoutParams);
        aq.c(this.bCO, w.g.icon_store, this.amZ);
        this.bCN.addView(this.bCO);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aq.e(view, w.e.common_color_10288, this.amZ);
        this.bCN.addView(view);
        this.aBW = new TextView(getContext());
        this.aBW.setGravity(17);
        this.aBW.setTextSize(10.0f);
        this.aBW.setText("N");
        this.aBW.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bCK.addView(this.bCN, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1));
        this.bCK.setNewView(this.aBW);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bCK.setNewViewVisible(true);
        } else {
            this.bCK.setNewViewVisible(false);
        }
        this.bCN.setOnClickListener(new o(this));
        this.aBX = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aBX.setLayoutParams(layoutParams3);
        this.bCK.addView(this.aBX);
        if (!appResponseToIntentClass) {
            this.bCN.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void l(int i, boolean z) {
        this.bCP = z;
        int i2 = i + 1;
        int childCount = this.bCK.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bCL.get(i2 - 1);
        if (i2 < childCount && cVar.DC() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bCK.getChildAt(i2)).getChildAt(0);
            if (!this.bCP) {
                tbImageView.setOnClickListener(new p(this));
                if (cVar.DE() != null) {
                    cVar.DE().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.DD() != null) {
                cVar.DD().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bCK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCK.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bCV;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bCN.setVisibility(8);
        } else {
            this.bCN.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.DC() == EmotionGroupType.BIG_EMOTION || cVar.DC() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aBR) {
            if (this.aBR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bCK.getChildAt(this.aBR + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.amZ == 0) {
                        color = getResources().getColor(w.e.common_color_10287);
                    } else {
                        color = aq.getColor(w.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aBR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bCK.getChildAt(this.aBR + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(w.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bCL.get(this.aBR);
            if (cVar.DD() != null) {
                cVar.DD().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aq.getColor(w.e.common_color_10022));
                this.bCQ = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aBR = -1;
        this.bCK.removeAllViews();
        Vg();
        m16do(this.amZ);
    }

    /* renamed from: do  reason: not valid java name */
    public void m16do(int i) {
        int color;
        this.amZ = i;
        if (this.bCO != null) {
            aq.c(this.bCO, w.g.icon_store, i);
        }
        if (this.bCN != null) {
            aq.d(this.bCN, w.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bCN.getChildCount() > 0) {
                aq.e(this.bCN.getChildAt(1), w.e.common_color_10288, i);
            }
        }
        if (this.aBX != null) {
            aq.d(this.aBX, w.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aBW != null) {
            aq.d(this.aBW, w.g.icon_news_head_prompt_one, i);
            aq.b(this.aBW, w.e.cp_cont_i, 1, i);
        }
        int childCount = this.bCK.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bCK.getChildAt(i2);
            if (childAt != null) {
                aq.d(childAt, w.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bCT != null) {
                        if (i == 0) {
                            color = getResources().getColor(w.e.common_color_10287);
                        } else {
                            color = aq.getColor(w.e.common_color_10287);
                        }
                        aVar.bCT.setForegroundColor(color);
                    }
                    if (aVar.bCU != null) {
                        aq.e(aVar.bCU, w.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bCQ != null) {
            this.bCQ.setForegroundColor(aq.getColor(w.e.common_color_10022));
            if (this.bCQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bCQ.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bCM = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aef;

        private b(int i) {
            this.aef = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bCQ) {
                ((TbImageView) view).setForegroundColor(aq.getColor(w.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bCQ != null) {
                    if (!EmotionTabHorizonScrollView.this.bCR) {
                        EmotionTabHorizonScrollView.this.bCQ.setForegroundColor(aq.getColor(w.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bCQ.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(w.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bCQ = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aef);
            EmotionTabHorizonScrollView.this.bCM.eQ(this.aef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        /* synthetic */ c(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, c cVar) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView bCT;
        View bCU;
        com.baidu.tbadk.editortools.emotiontool.c bCV;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
