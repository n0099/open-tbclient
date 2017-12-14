package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private i IR;
    private int aES;
    private LinearLayout.LayoutParams aEU;
    private int aEV;
    private int aEW;
    private TextView aEX;
    private View aEY;
    private int apD;
    private com.baidu.tieba.emotion.editortool.a crN;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> crO;
    private EmotionTabWidgetView.a crP;
    private LinearLayout crQ;
    private ImageView crR;
    private boolean crS;
    private TbImageView crT;
    private boolean crU;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aES = -1;
        this.crS = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aES = -1;
        this.crS = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aES = -1;
        this.crS = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.crN = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.crN.setOrientation(0);
        this.crN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.crN.setBaselineAligned(false);
        addView(this.crN);
        this.aEV = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEW = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.crN.setPadding(0, 0, 0, 0);
        agw();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.crU = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.crO = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.crY = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.crW = tbImageView;
        if (cVar.Dt() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEW, this.aEV, this.aEW, this.aEV);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.e.ds12), l.f(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.crX = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.crN.addView(relativeLayout, this.crN.getChildCount() - 1, this.aEU);
            if (cVar.Dv() != null) {
                cVar.Dv().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.crU && this.apD == 1) {
                view.setBackgroundColor(aj.getColor(d.C0096d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0096d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0096d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0096d.common_color_10287));
            }
            if (this.crT == null) {
                this.crT = tbImageView;
                this.crT.setForegroundColor(aj.getColor(d.C0096d.common_color_10022));
            }
            aj.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.apD);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEW, this.aEV, this.aEW, this.aEV);
            View view2 = new View(getContext());
            aVar.crX = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.crN.addView(linearLayout, this.crN.getChildCount() - 1, this.aEU);
            EmotionGroupType Dt = cVar.Dt();
            if (Dt == EmotionGroupType.LOCAL) {
                if (cVar.Du() != null) {
                    cVar.Du().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.crN.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (Dt == EmotionGroupType.PROMOTION) {
                if (cVar.Dv() != null) {
                    cVar.Dv().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Dt == EmotionGroupType.BIG_EMOTION) {
                if (this.crS) {
                    if (cVar.Du() != null) {
                        cVar.Du().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.crN.getChildCount() - 3));
                } else {
                    if (cVar.Dv() != null) {
                        cVar.Dv().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tq();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Dt == EmotionGroupType.USER_COLLECT) {
                if (cVar.Dv() != null) {
                    cVar.Dv().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.crN.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Dt == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Dv() != null) {
                    cVar.Dv().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.crU && this.apD == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0096d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0096d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0096d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0096d.common_color_10287));
            }
            if (this.crT == null) {
                this.crT = tbImageView;
                this.crT.setForegroundColor(aj.getColor(d.C0096d.common_color_10022));
            }
            aj.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.apD);
        }
        return tbImageView;
    }

    public void agw() {
        this.crR = new ImageView(getContext());
        this.crR.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.crR.setPadding(this.aEW, this.aEV, this.aEW, this.aEV);
        this.crQ = new LinearLayout(getContext());
        this.crQ.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.crR.setLayoutParams(layoutParams);
        aj.b(this.crR, d.f.face_store, this.apD);
        this.crQ.addView(this.crR);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.C0096d.common_color_10288, this.apD);
        this.crQ.addView(view);
        this.aEX = new TextView(getContext());
        this.aEX.setGravity(17);
        this.aEX.setTextSize(10.0f);
        this.aEX.setText("N");
        this.aEX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.crN.addView(this.crQ, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.crN.setNewView(this.aEX);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.crN.setNewViewVisible(true);
        } else {
            this.crN.setNewViewVisible(false);
        }
        this.crQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aEX != null) {
                    EmotionTabHorizonScrollView.this.crN.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.IR != null) {
                    EmotionTabHorizonScrollView.this.IR.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.hh()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.aEY = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aEY.setLayoutParams(layoutParams3);
        this.crN.addView(this.aEY);
        if (!appResponseToIntentClass) {
            this.crQ.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.crS = z;
        int i2 = i + 1;
        int childCount = this.crN.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.crO.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Dt() == EmotionGroupType.BIG_EMOTION || cVar.Dt() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.crN.getChildAt(i2)).getChildAt(0);
                if (!this.crS) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tq();
                        }
                    });
                    if (cVar.Dv() != null) {
                        cVar.Dv().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Du() != null) {
                    cVar.Du().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.crN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.crN.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).crY;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.crQ.setVisibility(8);
        } else {
            this.crQ.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Dt() == EmotionGroupType.BIG_EMOTION || cVar.Dt() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aES) {
            if (this.aES != -1) {
                LinearLayout linearLayout = (LinearLayout) this.crN.getChildAt(this.aES + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apD == 0) {
                        color = getResources().getColor(d.C0096d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0096d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aES = i;
            LinearLayout linearLayout2 = (LinearLayout) this.crN.getChildAt(this.aES + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.crO.get(this.aES);
            if (cVar.Du() != null) {
                cVar.Du().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0096d.common_color_10022));
                this.crT = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aES = -1;
        this.crN.removeAllViews();
        agw();
        dE(this.apD);
    }

    public void dE(int i) {
        int color;
        this.apD = i;
        if (this.crR != null) {
            aj.b(this.crR, d.f.face_store, i);
        }
        if (this.crQ != null) {
            aj.d(this.crQ, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.crQ.getChildCount() > 0) {
                aj.e(this.crQ.getChildAt(1), d.C0096d.common_color_10288, i);
            }
        }
        if (this.aEY != null) {
            aj.d(this.aEY, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aEX != null) {
            aj.d(this.aEX, d.f.icon_news_head_prompt_one, i);
            aj.b(this.aEX, d.C0096d.cp_cont_i, 1, i);
        }
        int childCount = this.crN.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.crN.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.crW != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0096d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0096d.common_color_10287);
                        }
                        aVar.crW.setForegroundColor(color);
                    }
                    if (aVar.crX != null) {
                        aj.e(aVar.crX, d.C0096d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.crT != null) {
            this.crT.setForegroundColor(aj.getColor(d.C0096d.common_color_10022));
            if (this.crT.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.crT.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.crP = aVar;
    }

    public void setEditorTools(i iVar) {
        this.IR = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aeX;

        private b(int i) {
            this.aeX = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.crT) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0096d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.crT != null) {
                    if (!EmotionTabHorizonScrollView.this.crU) {
                        EmotionTabHorizonScrollView.this.crT.setForegroundColor(aj.getColor(d.C0096d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.crT.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0096d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.crT = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aeX);
            EmotionTabHorizonScrollView.this.crP.fb(this.aeX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.g(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView crW;
        View crX;
        com.baidu.tbadk.editortools.emotiontool.c crY;

        private a() {
        }
    }
}
