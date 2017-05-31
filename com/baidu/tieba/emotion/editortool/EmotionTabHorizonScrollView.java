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
    private com.baidu.tbadk.editortools.j JU;
    private int aBF;
    private LinearLayout.LayoutParams aBH;
    private int aBI;
    private int aBJ;
    private TextView aBK;
    private View aBL;
    private int ana;
    private i bKX;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bKY;
    private EmotionTabWidgetView.a bKZ;
    private LinearLayout bLa;
    private ImageView bLb;
    private boolean bLc;
    private TbImageView bLd;
    private boolean bLe;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBF = -1;
        this.bLc = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBF = -1;
        this.bLc = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aBF = -1;
        this.bLc = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bKX = new i(getContext());
        this.bKX.setOrientation(0);
        this.bKX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bKX.setBaselineAligned(false);
        addView(this.bKX);
        this.aBI = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBJ = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBH = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds122), -1);
        this.bKX.setPadding(0, 0, 0, 0);
        WF();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bLe = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bKY = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bLi = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bLg = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aBJ, this.aBI, this.aBJ, this.aBI);
        View view = new View(getContext());
        aVar.bLh = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bKX.addView(linearLayout, this.bKX.getChildCount() - 1, this.aBH);
        EmotionGroupType CA = cVar.CA();
        if (CA == EmotionGroupType.LOCAL) {
            if (cVar.CB() != null) {
                cVar.CB().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bKX.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.local_emotion));
        } else if (CA == EmotionGroupType.PROMOTION) {
            if (cVar.CC() != null) {
                cVar.CC().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(w.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (CA == EmotionGroupType.BIG_EMOTION) {
            if (this.bLc) {
                if (cVar.CB() != null) {
                    cVar.CB().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bKX.getChildCount() - 3, null));
            } else {
                if (cVar.CC() != null) {
                    cVar.CC().e(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bLe && this.ana == 1) {
            view.setBackgroundColor(aq.getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(aq.getColor(w.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(w.e.common_color_10287));
        }
        if (this.bLd == null) {
            this.bLd = tbImageView;
            this.bLd.setForegroundColor(aq.getColor(w.e.common_color_10022));
        }
        aq.d(linearLayout, w.g.bg_emotion_tab_horizonscrollview, this.ana);
        return tbImageView;
    }

    public void WF() {
        this.bLb = new ImageView(getContext());
        this.bLb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bLb.setPadding(this.aBJ, this.aBI, this.aBJ, this.aBI);
        this.bLa = new LinearLayout(getContext());
        this.bLa.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bLb.setLayoutParams(layoutParams);
        aq.c(this.bLb, w.g.icon_store, this.ana);
        this.bLa.addView(this.bLb);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aq.e(view, w.e.common_color_10288, this.ana);
        this.bLa.addView(view);
        this.aBK = new TextView(getContext());
        this.aBK.setGravity(17);
        this.aBK.setTextSize(10.0f);
        this.aBK.setText("N");
        this.aBK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bKX.addView(this.bLa, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1));
        this.bKX.setNewView(this.aBK);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bKX.setNewViewVisible(true);
        } else {
            this.bKX.setNewViewVisible(false);
        }
        this.bLa.setOnClickListener(new o(this));
        this.aBL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aBL.setLayoutParams(layoutParams3);
        this.bKX.addView(this.aBL);
        if (!appResponseToIntentClass) {
            this.bLa.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.bLc = z;
        int i2 = i + 1;
        int childCount = this.bKX.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bKY.get(i2 - 1);
        if (i2 < childCount && cVar.CA() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bKX.getChildAt(i2)).getChildAt(0);
            if (!this.bLc) {
                tbImageView.setOnClickListener(new p(this));
                if (cVar.CC() != null) {
                    cVar.CC().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.CB() != null) {
                cVar.CB().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bKX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bKX.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bLi;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bLa.setVisibility(8);
        } else {
            this.bLa.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CA() == EmotionGroupType.BIG_EMOTION || cVar.CA() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aBF) {
            if (this.aBF != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bKX.getChildAt(this.aBF + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ana == 0) {
                        color = getResources().getColor(w.e.common_color_10287);
                    } else {
                        color = aq.getColor(w.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aBF = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bKX.getChildAt(this.aBF + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bKY.get(this.aBF);
            if (cVar.CB() != null) {
                cVar.CB().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aq.getColor(w.e.common_color_10022));
                this.bLd = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aBF = -1;
        this.bKX.removeAllViews();
        WF();
        dn(this.ana);
    }

    public void dn(int i) {
        int color;
        this.ana = i;
        if (this.bLb != null) {
            aq.c(this.bLb, w.g.icon_store, i);
        }
        if (this.bLa != null) {
            aq.d(this.bLa, w.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bLa.getChildCount() > 0) {
                aq.e(this.bLa.getChildAt(1), w.e.common_color_10288, i);
            }
        }
        if (this.aBL != null) {
            aq.d(this.aBL, w.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aBK != null) {
            aq.d(this.aBK, w.g.icon_news_head_prompt_one, i);
            aq.b(this.aBK, w.e.cp_cont_i, 1, i);
        }
        int childCount = this.bKX.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bKX.getChildAt(i2);
            if (childAt != null) {
                aq.d(childAt, w.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bLg != null) {
                        if (i == 0) {
                            color = getResources().getColor(w.e.common_color_10287);
                        } else {
                            color = aq.getColor(w.e.common_color_10287);
                        }
                        aVar.bLg.setForegroundColor(color);
                    }
                    if (aVar.bLh != null) {
                        aq.e(aVar.bLh, w.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bLd != null) {
            this.bLd.setForegroundColor(aq.getColor(w.e.common_color_10022));
            if (this.bLd.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bLd.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bKZ = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int adq;

        private b(int i) {
            this.adq = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bLd) {
                ((TbImageView) view).setForegroundColor(aq.getColor(w.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bLd != null) {
                    if (!EmotionTabHorizonScrollView.this.bLe) {
                        EmotionTabHorizonScrollView.this.bLd.setForegroundColor(aq.getColor(w.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bLd.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(w.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bLd = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.adq);
            EmotionTabHorizonScrollView.this.bKZ.eN(this.adq);
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
        TbImageView bLg;
        View bLh;
        com.baidu.tbadk.editortools.emotiontool.c bLi;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
