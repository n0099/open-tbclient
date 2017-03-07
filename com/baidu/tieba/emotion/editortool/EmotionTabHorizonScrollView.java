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
    private com.baidu.tbadk.editortools.j Ll;
    private int aBB;
    private LinearLayout.LayoutParams aBD;
    private int aBE;
    private int aBF;
    private TextView aBG;
    private View aBH;
    private int amL;
    private h bCR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bCS;
    private EmotionTabWidgetView.a bCT;
    private LinearLayout bCU;
    private ImageView bCV;
    private boolean bCW;
    private TbImageView bCX;
    private boolean bCY;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBB = -1;
        this.bCW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBB = -1;
        this.bCW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aBB = -1;
        this.bCW = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bCR = new h(getContext());
        this.bCR.setOrientation(0);
        this.bCR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bCR.setBaselineAligned(false);
        addView(this.bCR);
        this.aBE = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBF = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBD = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds122), -1);
        this.bCR.setPadding(0, 0, 0, 0);
        UI();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bCY = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bCS = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bDc = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bDa = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aBF, this.aBE, this.aBF, this.aBE);
        View view = new View(getContext());
        aVar.bDb = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bCR.addView(linearLayout, this.bCR.getChildCount() - 1, this.aBD);
        EmotionGroupType De = cVar.De();
        if (De == EmotionGroupType.LOCAL) {
            if (cVar.Df() != null) {
                cVar.Df().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bCR.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.local_emotion));
        } else if (De == EmotionGroupType.PROMOTION) {
            if (cVar.Dg() != null) {
                cVar.Dg().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(w.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (De == EmotionGroupType.BIG_EMOTION) {
            if (this.bCW) {
                if (cVar.Df() != null) {
                    cVar.Df().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bCR.getChildCount() - 3, null));
            } else {
                if (cVar.Dg() != null) {
                    cVar.Dg().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bCY) {
            view.setBackgroundColor(aq.getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(aq.getColor(w.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(w.e.common_color_10287));
        }
        if (this.bCX == null) {
            this.bCX = tbImageView;
            this.bCX.setForegroundColor(aq.getColor(w.e.common_color_10022));
        }
        aq.d(linearLayout, w.g.bg_emotion_tab_horizonscrollview, this.amL);
        return tbImageView;
    }

    public void UI() {
        this.bCV = new ImageView(getContext());
        this.bCV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bCV.setPadding(this.aBF, this.aBE, this.aBF, this.aBE);
        this.bCU = new LinearLayout(getContext());
        this.bCU.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bCV.setLayoutParams(layoutParams);
        aq.c(this.bCV, w.g.icon_store, this.amL);
        this.bCU.addView(this.bCV);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aq.e(view, w.e.common_color_10288, this.amL);
        this.bCU.addView(view);
        this.aBG = new TextView(getContext());
        this.aBG.setGravity(17);
        this.aBG.setTextSize(10.0f);
        this.aBG.setText("N");
        this.aBG.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bCR.addView(this.bCU, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1));
        this.bCR.setNewView(this.aBG);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bCR.setNewViewVisible(true);
        } else {
            this.bCR.setNewViewVisible(false);
        }
        this.bCU.setOnClickListener(new n(this));
        this.aBH = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aBH.setLayoutParams(layoutParams3);
        this.bCR.addView(this.aBH);
        if (!appResponseToIntentClass) {
            this.bCU.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void l(int i, boolean z) {
        this.bCW = z;
        int i2 = i + 1;
        int childCount = this.bCR.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bCS.get(i2 - 1);
        if (i2 < childCount && cVar.De() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bCR.getChildAt(i2)).getChildAt(0);
            if (!this.bCW) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.Dg() != null) {
                    cVar.Dg().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.Df() != null) {
                cVar.Df().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bCR.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCR.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bDc;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bCU.setVisibility(8);
        } else {
            this.bCU.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.De() == EmotionGroupType.BIG_EMOTION || cVar.De() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aBB) {
            if (this.aBB != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bCR.getChildAt(this.aBB + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.amL == 0) {
                        color = getResources().getColor(w.e.common_color_10287);
                    } else {
                        color = aq.getColor(w.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aBB = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bCR.getChildAt(this.aBB + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bCS.get(this.aBB);
            if (cVar.Df() != null) {
                cVar.Df().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aq.getColor(w.e.common_color_10022));
                this.bCX = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aBB = -1;
        this.bCR.removeAllViews();
        UI();
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dl(int i) {
        int color;
        this.amL = i;
        if (this.bCV != null) {
            aq.c(this.bCV, w.g.icon_store, i);
        }
        if (this.bCU != null) {
            aq.d(this.bCU, w.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bCU.getChildCount() > 0) {
                aq.e(this.bCU.getChildAt(1), w.e.common_color_10288, i);
            }
        }
        if (this.aBH != null) {
            aq.d(this.aBH, w.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aBG != null) {
            aq.d(this.aBG, w.g.icon_news_head_prompt_one, i);
            aq.b(this.aBG, w.e.cp_cont_i, 1, i);
        }
        int childCount = this.bCR.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bCR.getChildAt(i2);
            if (childAt != null) {
                aq.d(childAt, w.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bDa != null) {
                        if (i == 0) {
                            color = getResources().getColor(w.e.common_color_10287);
                        } else {
                            color = aq.getColor(w.e.common_color_10287);
                        }
                        aVar.bDa.setForegroundColor(color);
                    }
                    if (aVar.bDb != null) {
                        aq.e(aVar.bDb, w.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bCX != null) {
            this.bCX.setForegroundColor(aq.getColor(w.e.common_color_10022));
            if (this.bCX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bCX.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bCT = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int adR;

        private b(int i) {
            this.adR = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bCX) {
                ((TbImageView) view).setForegroundColor(aq.getColor(w.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bCX != null) {
                    if (!EmotionTabHorizonScrollView.this.bCY) {
                        EmotionTabHorizonScrollView.this.bCX.setForegroundColor(aq.getColor(w.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bCX.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(w.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bCX = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.adR);
            EmotionTabHorizonScrollView.this.bCT.eN(this.adR);
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
        TbImageView bDa;
        View bDb;
        com.baidu.tbadk.editortools.emotiontool.c bDc;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
