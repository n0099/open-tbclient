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
    private i IT;
    private int aEN;
    private LinearLayout.LayoutParams aEP;
    private int aEQ;
    private int aER;
    private TextView aES;
    private View aET;
    private int apA;
    private com.baidu.tieba.emotion.editortool.a crE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> crF;
    private EmotionTabWidgetView.a crG;
    private LinearLayout crH;
    private ImageView crI;
    private boolean crJ;
    private TbImageView crK;
    private boolean crL;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEN = -1;
        this.crJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEN = -1;
        this.crJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEN = -1;
        this.crJ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.crE = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.crE.setOrientation(0);
        this.crE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.crE.setBaselineAligned(false);
        addView(this.crE);
        this.aEQ = getResources().getDimensionPixelSize(d.e.ds8);
        this.aER = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEP = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.crE.setPadding(0, 0, 0, 0);
        ago();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.crL = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.crF = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.crP = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.crN = tbImageView;
        if (cVar.Ds() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aER, this.aEQ, this.aER, this.aEQ);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.e.ds12), l.f(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.crO = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.crE.addView(relativeLayout, this.crE.getChildCount() - 1, this.aEP);
            if (cVar.Du() != null) {
                cVar.Du().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.crL && this.apA == 1) {
                view.setBackgroundColor(aj.getColor(d.C0082d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0082d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0082d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0082d.common_color_10287));
            }
            if (this.crK == null) {
                this.crK = tbImageView;
                this.crK.setForegroundColor(aj.getColor(d.C0082d.common_color_10022));
            }
            aj.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.apA);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aER, this.aEQ, this.aER, this.aEQ);
            View view2 = new View(getContext());
            aVar.crO = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.crE.addView(linearLayout, this.crE.getChildCount() - 1, this.aEP);
            EmotionGroupType Ds = cVar.Ds();
            if (Ds == EmotionGroupType.LOCAL) {
                if (cVar.Dt() != null) {
                    cVar.Dt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.crE.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (Ds == EmotionGroupType.PROMOTION) {
                if (cVar.Du() != null) {
                    cVar.Du().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Ds == EmotionGroupType.BIG_EMOTION) {
                if (this.crJ) {
                    if (cVar.Dt() != null) {
                        cVar.Dt().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.crE.getChildCount() - 3));
                } else {
                    if (cVar.Du() != null) {
                        cVar.Du().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tt();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Ds == EmotionGroupType.USER_COLLECT) {
                if (cVar.Du() != null) {
                    cVar.Du().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.crE.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Ds == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Du() != null) {
                    cVar.Du().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.crL && this.apA == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0082d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0082d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0082d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0082d.common_color_10287));
            }
            if (this.crK == null) {
                this.crK = tbImageView;
                this.crK.setForegroundColor(aj.getColor(d.C0082d.common_color_10022));
            }
            aj.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.apA);
        }
        return tbImageView;
    }

    public void ago() {
        this.crI = new ImageView(getContext());
        this.crI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.crI.setPadding(this.aER, this.aEQ, this.aER, this.aEQ);
        this.crH = new LinearLayout(getContext());
        this.crH.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.crI.setLayoutParams(layoutParams);
        aj.b(this.crI, d.f.face_store, this.apA);
        this.crH.addView(this.crI);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.C0082d.common_color_10288, this.apA);
        this.crH.addView(view);
        this.aES = new TextView(getContext());
        this.aES.setGravity(17);
        this.aES.setTextSize(10.0f);
        this.aES.setText("N");
        this.aES.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.crE.addView(this.crH, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.crE.setNewView(this.aES);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.crE.setNewViewVisible(true);
        } else {
            this.crE.setNewViewVisible(false);
        }
        this.crH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aES != null) {
                    EmotionTabHorizonScrollView.this.crE.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.IT != null) {
                    EmotionTabHorizonScrollView.this.IT.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.hh()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.aET = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aET.setLayoutParams(layoutParams3);
        this.crE.addView(this.aET);
        if (!appResponseToIntentClass) {
            this.crH.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.crJ = z;
        int i2 = i + 1;
        int childCount = this.crE.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.crF.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Ds() == EmotionGroupType.BIG_EMOTION || cVar.Ds() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.crE.getChildAt(i2)).getChildAt(0);
                if (!this.crJ) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tt();
                        }
                    });
                    if (cVar.Du() != null) {
                        cVar.Du().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Dt() != null) {
                    cVar.Dt().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.crE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.crE.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).crP;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.crH.setVisibility(8);
        } else {
            this.crH.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Ds() == EmotionGroupType.BIG_EMOTION || cVar.Ds() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEN) {
            if (this.aEN != -1) {
                LinearLayout linearLayout = (LinearLayout) this.crE.getChildAt(this.aEN + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apA == 0) {
                        color = getResources().getColor(d.C0082d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0082d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEN = i;
            LinearLayout linearLayout2 = (LinearLayout) this.crE.getChildAt(this.aEN + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.crF.get(this.aEN);
            if (cVar.Dt() != null) {
                cVar.Dt().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0082d.common_color_10022));
                this.crK = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEN = -1;
        this.crE.removeAllViews();
        ago();
        dE(this.apA);
    }

    public void dE(int i) {
        int color;
        this.apA = i;
        if (this.crI != null) {
            aj.b(this.crI, d.f.face_store, i);
        }
        if (this.crH != null) {
            aj.d(this.crH, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.crH.getChildCount() > 0) {
                aj.e(this.crH.getChildAt(1), d.C0082d.common_color_10288, i);
            }
        }
        if (this.aET != null) {
            aj.d(this.aET, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aES != null) {
            aj.d(this.aES, d.f.icon_news_head_prompt_one, i);
            aj.b(this.aES, d.C0082d.cp_cont_i, 1, i);
        }
        int childCount = this.crE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.crE.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.crN != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0082d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0082d.common_color_10287);
                        }
                        aVar.crN.setForegroundColor(color);
                    }
                    if (aVar.crO != null) {
                        aj.e(aVar.crO, d.C0082d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.crK != null) {
            this.crK.setForegroundColor(aj.getColor(d.C0082d.common_color_10022));
            if (this.crK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.crK.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.crG = aVar;
    }

    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int afd;

        private b(int i) {
            this.afd = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.crK) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0082d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.crK != null) {
                    if (!EmotionTabHorizonScrollView.this.crL) {
                        EmotionTabHorizonScrollView.this.crK.setForegroundColor(aj.getColor(d.C0082d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.crK.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0082d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.crK = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.afd);
            EmotionTabHorizonScrollView.this.crG.fb(this.afd);
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
        TbImageView crN;
        View crO;
        com.baidu.tbadk.editortools.emotiontool.c crP;

        private a() {
        }
    }
}
