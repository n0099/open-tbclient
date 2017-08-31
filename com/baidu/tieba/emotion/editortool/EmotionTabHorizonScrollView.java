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
import com.baidu.adp.lib.util.k;
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
    private i Jp;
    private int aEq;
    private LinearLayout.LayoutParams aEs;
    private int aEt;
    private int aEu;
    private TextView aEv;
    private View aEw;
    private int apS;
    private EmotionTabWidgetView.a caA;
    private LinearLayout caB;
    private ImageView caC;
    private boolean caD;
    private TbImageView caE;
    private boolean caF;
    private com.baidu.tieba.emotion.editortool.a cay;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> caz;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEq = -1;
        this.caD = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEq = -1;
        this.caD = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEq = -1;
        this.caD = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cay = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.cay.setOrientation(0);
        this.cay.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cay.setBaselineAligned(false);
        addView(this.cay);
        this.aEt = getResources().getDimensionPixelSize(d.f.ds8);
        this.aEu = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEs = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.cay.setPadding(0, 0, 0, 0);
        acn();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.caF = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.caz = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.caJ = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.caH = tbImageView;
        if (cVar.Dk() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEu, this.aEt, this.aEu, this.aEt);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.g.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, k.g(getContext(), d.f.ds12), k.g(getContext(), d.f.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.caI = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cay.addView(relativeLayout, this.cay.getChildCount() - 1, this.aEs);
            if (cVar.Dm() != null) {
                cVar.Dm().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.caF && this.apS == 1) {
                view.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.caE == null) {
                this.caE = tbImageView;
                this.caE.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(relativeLayout, d.g.bg_emotion_tab_horizonscrollview, this.apS);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEu, this.aEt, this.aEu, this.aEt);
            View view2 = new View(getContext());
            aVar.caI = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cay.addView(linearLayout, this.cay.getChildCount() - 1, this.aEs);
            EmotionGroupType Dk = cVar.Dk();
            if (Dk == EmotionGroupType.LOCAL) {
                if (cVar.Dl() != null) {
                    cVar.Dl().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cay.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
            } else if (Dk == EmotionGroupType.PROMOTION) {
                if (cVar.Dm() != null) {
                    cVar.Dm().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
            } else if (Dk == EmotionGroupType.BIG_EMOTION) {
                if (this.caD) {
                    if (cVar.Dl() != null) {
                        cVar.Dl().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cay.getChildCount() - 3));
                } else {
                    if (cVar.Dm() != null) {
                        cVar.Dm().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tw();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Dk == EmotionGroupType.USER_COLLECT) {
                if (cVar.Dm() != null) {
                    cVar.Dm().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cay.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Dk == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Dm() != null) {
                    cVar.Dm().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.caF && this.apS == 1) {
                view2.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.caE == null) {
                this.caE = tbImageView;
                this.caE.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.apS);
        }
        return tbImageView;
    }

    public void acn() {
        this.caC = new ImageView(getContext());
        this.caC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.caC.setPadding(this.aEu, this.aEt, this.aEu, this.aEt);
        this.caB = new LinearLayout(getContext());
        this.caB.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.caC.setLayoutParams(layoutParams);
        aj.b(this.caC, d.g.face_store, this.apS);
        this.caB.addView(this.caC);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.e.common_color_10288, this.apS);
        this.caB.addView(view);
        this.aEv = new TextView(getContext());
        this.aEv.setGravity(17);
        this.aEv.setTextSize(10.0f);
        this.aEv.setText("N");
        this.aEv.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cay.addView(this.caB, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.cay.setNewView(this.aEv);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cay.setNewViewVisible(true);
        } else {
            this.cay.setNewViewVisible(false);
        }
        this.caB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aEv != null) {
                    EmotionTabHorizonScrollView.this.cay.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Jp != null) {
                    EmotionTabHorizonScrollView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (com.baidu.adp.lib.util.i.hi()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    k.showToast(EmotionTabHorizonScrollView.this.getContext(), d.l.neterror);
                }
            }
        });
        this.aEw = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aEw.setLayoutParams(layoutParams3);
        this.cay.addView(this.aEw);
        if (!appResponseToIntentClass) {
            this.caB.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.caD = z;
        int i2 = i + 1;
        int childCount = this.cay.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.caz.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Dk() == EmotionGroupType.BIG_EMOTION || cVar.Dk() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cay.getChildAt(i2)).getChildAt(0);
                if (!this.caD) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tw();
                        }
                    });
                    if (cVar.Dm() != null) {
                        cVar.Dm().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Dl() != null) {
                    cVar.Dl().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cay.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cay.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).caJ;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.caB.setVisibility(8);
        } else {
            this.caB.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Dk() == EmotionGroupType.BIG_EMOTION || cVar.Dk() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEq) {
            if (this.aEq != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cay.getChildAt(this.aEq + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apS == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = aj.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEq = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cay.getChildAt(this.aEq + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.caz.get(this.aEq);
            if (cVar.Dl() != null) {
                cVar.Dl().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.e.common_color_10022));
                this.caE = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEq = -1;
        this.cay.removeAllViews();
        acn();
        du(this.apS);
    }

    public void du(int i) {
        int color;
        this.apS = i;
        if (this.caC != null) {
            aj.b(this.caC, d.g.face_store, i);
        }
        if (this.caB != null) {
            aj.d(this.caB, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.caB.getChildCount() > 0) {
                aj.e(this.caB.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aEw != null) {
            aj.d(this.aEw, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aEv != null) {
            aj.d(this.aEv, d.g.icon_news_head_prompt_one, i);
            aj.b(this.aEv, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.cay.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cay.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.caH != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = aj.getColor(d.e.common_color_10287);
                        }
                        aVar.caH.setForegroundColor(color);
                    }
                    if (aVar.caI != null) {
                        aj.e(aVar.caI, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.caE != null) {
            this.caE.setForegroundColor(aj.getColor(d.e.common_color_10022));
            if (this.caE.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.caE.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.caA = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int afb;

        private b(int i) {
            this.afb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.caE) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.caE != null) {
                    if (!EmotionTabHorizonScrollView.this.caF) {
                        EmotionTabHorizonScrollView.this.caE.setForegroundColor(aj.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.caE.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.caE = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.afb);
            EmotionTabHorizonScrollView.this.caA.eT(this.afb);
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
        TbImageView caH;
        View caI;
        com.baidu.tbadk.editortools.emotiontool.c caJ;

        private a() {
        }
    }
}
