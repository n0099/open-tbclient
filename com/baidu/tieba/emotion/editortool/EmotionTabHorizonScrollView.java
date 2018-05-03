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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools JS;
    private int aFG;
    private LinearLayout.LayoutParams aFI;
    private int aFJ;
    private int aFK;
    private TextView aFL;
    private View aFM;
    private int aqQ;
    private EmotionLinearLayout cFW;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cFX;
    private EmotionTabWidgetView.a cFY;
    private LinearLayout cFZ;
    private ImageView cGa;
    private boolean cGb;
    private TbImageView cGc;
    private boolean cGd;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFG = -1;
        this.cGb = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFG = -1;
        this.cGb = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aFG = -1;
        this.cGb = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cFW = new EmotionLinearLayout(getContext());
        this.cFW.setOrientation(0);
        this.cFW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cFW.setBaselineAligned(false);
        addView(this.cFW);
        this.aFJ = getResources().getDimensionPixelSize(d.e.ds8);
        this.aFK = getResources().getDimensionPixelSize(d.e.ds10);
        this.aFI = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.cFW.setPadding(0, 0, 0, 0);
        akb();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cGd = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cFX = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cGh = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cGf = tbImageView;
        if (cVar.DU() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aFK, this.aFJ, this.aFK, this.aFJ);
            ImageView imageView = new ImageView(getContext());
            ak.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.e(getContext(), d.e.ds12), l.e(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view2 = new View(getContext());
            aVar.cGg = view2;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view2, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cFW.addView(relativeLayout, this.cFW.getChildCount() - 1, this.aFI);
            if (cVar.DW() != null) {
                cVar.DW().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cGd && this.aqQ == 1) {
                view2.setBackgroundColor(ak.getColor(d.C0126d.common_color_10288));
                tbImageView.setForegroundColor(ak.getColor(d.C0126d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0126d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0126d.common_color_10287));
            }
            if (this.cGc == null) {
                this.cGc = tbImageView;
                this.cGc.setForegroundColor(ak.getColor(d.C0126d.common_color_10022));
            }
            ak.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.aqQ);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aFK, this.aFJ, this.aFK, this.aFJ);
            View view3 = new View(getContext());
            aVar.cGg = view3;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view3, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cFW.addView(linearLayout, this.cFW.getChildCount() - 1, this.aFI);
            EmotionGroupType DU = cVar.DU();
            if (DU == EmotionGroupType.LOCAL) {
                if (cVar.DV() != null) {
                    cVar.DV().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cFW.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.local_emotion));
            } else if (DU == EmotionGroupType.PROMOTION) {
                if (cVar.DW() != null) {
                    cVar.DW().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_promotion_emotion) + cVar.getGroupId());
            } else if (DU == EmotionGroupType.BIG_EMOTION) {
                if (this.cGb) {
                    if (cVar.DV() != null) {
                        cVar.DV().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cFW.getChildCount() - 3));
                } else {
                    if (cVar.DW() != null) {
                        cVar.DW().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view4) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.k.emotion_cant_show)).tL();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (DU == EmotionGroupType.USER_COLLECT) {
                if (cVar.DW() != null) {
                    cVar.DW().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cFW.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (DU == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.DW() != null) {
                    cVar.DW().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cGd && this.aqQ == 1) {
                view3.setBackgroundColor(ak.getColor(d.C0126d.common_color_10288));
                tbImageView.setForegroundColor(ak.getColor(d.C0126d.common_color_10287));
            } else {
                view3.setBackgroundColor(getResources().getColor(d.C0126d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0126d.common_color_10287));
            }
            if (this.cGc == null) {
                this.cGc = tbImageView;
                this.cGc.setForegroundColor(ak.getColor(d.C0126d.common_color_10022));
            }
            ak.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.aqQ);
        }
        return tbImageView;
    }

    public void akb() {
        this.cGa = new ImageView(getContext());
        this.cGa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cGa.setPadding(this.aFK, this.aFJ, this.aFK, this.aFJ);
        this.cFZ = new LinearLayout(getContext());
        this.cFZ.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.k.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cGa.setLayoutParams(layoutParams);
        ak.b(this.cGa, d.f.face_store, this.aqQ);
        this.cFZ.addView(this.cGa);
        View view2 = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view2.setLayoutParams(layoutParams2);
        ak.e(view2, d.C0126d.common_color_10288, this.aqQ);
        this.cFZ.addView(view2);
        this.aFL = new TextView(getContext());
        this.aFL.setGravity(17);
        this.aFL.setTextSize(10.0f);
        this.aFL.setText("N");
        this.aFL.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cFW.addView(this.cFZ, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.cFW.setNewView(this.aFL);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cFW.setNewViewVisible(true);
        } else {
            this.cFW.setNewViewVisible(false);
        }
        this.cFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (EmotionTabHorizonScrollView.this.aFL != null) {
                    EmotionTabHorizonScrollView.this.cFW.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.JS != null) {
                    EmotionTabHorizonScrollView.this.JS.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.gP()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.k.neterror);
                }
            }
        });
        this.aFM = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aFM.setLayoutParams(layoutParams3);
        this.cFW.addView(this.aFM);
        if (!appResponseToIntentClass) {
            this.cFZ.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cGb = z;
        int i2 = i + 1;
        int childCount = this.cFW.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cFX.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.DU() == EmotionGroupType.BIG_EMOTION || cVar.DU() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cFW.getChildAt(i2)).getChildAt(0);
                if (!this.cGb) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.k.emotion_cant_show)).tL();
                        }
                    });
                    if (cVar.DW() != null) {
                        cVar.DW().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.DV() != null) {
                    cVar.DV().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cFW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cFW.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cGh;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cFZ.setVisibility(8);
        } else {
            this.cFZ.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.DU() == EmotionGroupType.BIG_EMOTION || cVar.DU() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aFG) {
            if (this.aFG != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cFW.getChildAt(this.aFG + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aqQ == 0) {
                        color = getResources().getColor(d.C0126d.common_color_10287);
                    } else {
                        color = ak.getColor(d.C0126d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aFG = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cFW.getChildAt(this.aFG + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cFX.get(this.aFG);
            if (cVar.DV() != null) {
                cVar.DV().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ak.getColor(d.C0126d.common_color_10022));
                this.cGc = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aFG = -1;
        this.cFW.removeAllViews();
        akb();
        dz(this.aqQ);
    }

    public void dz(int i) {
        int color;
        this.aqQ = i;
        if (this.cGa != null) {
            ak.b(this.cGa, d.f.face_store, i);
        }
        if (this.cFZ != null) {
            ak.d(this.cFZ, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.cFZ.getChildCount() > 0) {
                ak.e(this.cFZ.getChildAt(1), d.C0126d.common_color_10288, i);
            }
        }
        if (this.aFM != null) {
            ak.d(this.aFM, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aFL != null) {
            ak.d(this.aFL, d.f.icon_news_head_prompt_one, i);
            ak.b(this.aFL, d.C0126d.cp_cont_i, 1, i);
        }
        int childCount = this.cFW.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cFW.getChildAt(i2);
            if (childAt != null) {
                ak.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cGf != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0126d.common_color_10287);
                        } else {
                            color = ak.getColor(d.C0126d.common_color_10287);
                        }
                        aVar.cGf.setForegroundColor(color);
                    }
                    if (aVar.cGg != null) {
                        ak.e(aVar.cGg, d.C0126d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cGc != null) {
            this.cGc.setForegroundColor(ak.getColor(d.C0126d.common_color_10022));
            if (this.cGc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cGc.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cFY = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int agb;

        private b(int i) {
            this.agb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if ((view2 instanceof TbImageView) && ((TbImageView) view2) != EmotionTabHorizonScrollView.this.cGc) {
                ((TbImageView) view2).setForegroundColor(ak.getColor(d.C0126d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cGc != null) {
                    if (!EmotionTabHorizonScrollView.this.cGd) {
                        EmotionTabHorizonScrollView.this.cGc.setForegroundColor(ak.getColor(d.C0126d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cGc.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0126d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cGc = (TbImageView) view2;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.agb);
            EmotionTabHorizonScrollView.this.cFY.eS(this.agb);
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
        public void onClick(View view2) {
            if (com.baidu.adp.lib.g.b.g(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView cGf;
        View cGg;
        com.baidu.tbadk.editortools.emotiontool.c cGh;

        private a() {
        }
    }
}
