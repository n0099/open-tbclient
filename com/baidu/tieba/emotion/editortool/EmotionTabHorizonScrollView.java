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
    private i Jb;
    private int aEe;
    private LinearLayout.LayoutParams aEg;
    private int aEh;
    private int aEi;
    private TextView aEj;
    private View aEk;
    private int api;
    private com.baidu.tieba.emotion.editortool.a ciK;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ciL;
    private EmotionTabWidgetView.a ciM;
    private LinearLayout ciN;
    private ImageView ciO;
    private boolean ciP;
    private TbImageView ciQ;
    private boolean ciR;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEe = -1;
        this.ciP = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEe = -1;
        this.ciP = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEe = -1;
        this.ciP = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ciK = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.ciK.setOrientation(0);
        this.ciK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ciK.setBaselineAligned(false);
        addView(this.ciK);
        this.aEh = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEi = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEg = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.ciK.setPadding(0, 0, 0, 0);
        aeq();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ciR = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ciL = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.ciV = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.ciT = tbImageView;
        if (cVar.CW() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEi, this.aEh, this.aEi, this.aEh);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.e.ds12), l.f(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.ciU = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.ciK.addView(relativeLayout, this.ciK.getChildCount() - 1, this.aEg);
            if (cVar.CY() != null) {
                cVar.CY().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ciR && this.api == 1) {
                view.setBackgroundColor(aj.getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0080d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0080d.common_color_10287));
            }
            if (this.ciQ == null) {
                this.ciQ = tbImageView;
                this.ciQ.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
            }
            aj.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.api);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aEi, this.aEh, this.aEi, this.aEh);
            View view2 = new View(getContext());
            aVar.ciU = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ciK.addView(linearLayout, this.ciK.getChildCount() - 1, this.aEg);
            EmotionGroupType CW = cVar.CW();
            if (CW == EmotionGroupType.LOCAL) {
                if (cVar.CX() != null) {
                    cVar.CX().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ciK.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (CW == EmotionGroupType.PROMOTION) {
                if (cVar.CY() != null) {
                    cVar.CY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (CW == EmotionGroupType.BIG_EMOTION) {
                if (this.ciP) {
                    if (cVar.CX() != null) {
                        cVar.CX().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ciK.getChildCount() - 3));
                } else {
                    if (cVar.CY() != null) {
                        cVar.CY().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tq();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (CW == EmotionGroupType.USER_COLLECT) {
                if (cVar.CY() != null) {
                    cVar.CY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ciK.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (CW == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.CY() != null) {
                    cVar.CY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ciR && this.api == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0080d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0080d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0080d.common_color_10287));
            }
            if (this.ciQ == null) {
                this.ciQ = tbImageView;
                this.ciQ.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
            }
            aj.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.api);
        }
        return tbImageView;
    }

    public void aeq() {
        this.ciO = new ImageView(getContext());
        this.ciO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ciO.setPadding(this.aEi, this.aEh, this.aEi, this.aEh);
        this.ciN = new LinearLayout(getContext());
        this.ciN.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ciO.setLayoutParams(layoutParams);
        aj.b(this.ciO, d.f.face_store, this.api);
        this.ciN.addView(this.ciO);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.C0080d.common_color_10288, this.api);
        this.ciN.addView(view);
        this.aEj = new TextView(getContext());
        this.aEj.setGravity(17);
        this.aEj.setTextSize(10.0f);
        this.aEj.setText("N");
        this.aEj.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ciK.addView(this.ciN, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.ciK.setNewView(this.aEj);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ciK.setNewViewVisible(true);
        } else {
            this.ciK.setNewViewVisible(false);
        }
        this.ciN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aEj != null) {
                    EmotionTabHorizonScrollView.this.ciK.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Jb != null) {
                    EmotionTabHorizonScrollView.this.Jb.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.hh()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.aEk = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aEk.setLayoutParams(layoutParams3);
        this.ciK.addView(this.aEk);
        if (!appResponseToIntentClass) {
            this.ciN.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void l(int i, boolean z) {
        this.ciP = z;
        int i2 = i + 1;
        int childCount = this.ciK.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ciL.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.CW() == EmotionGroupType.BIG_EMOTION || cVar.CW() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ciK.getChildAt(i2)).getChildAt(0);
                if (!this.ciP) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).tq();
                        }
                    });
                    if (cVar.CY() != null) {
                        cVar.CY().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.CX() != null) {
                    cVar.CX().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.ciK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ciK.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).ciV;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.ciN.setVisibility(8);
        } else {
            this.ciN.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CW() == EmotionGroupType.BIG_EMOTION || cVar.CW() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEe) {
            if (this.aEe != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ciK.getChildAt(this.aEe + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.api == 0) {
                        color = getResources().getColor(d.C0080d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0080d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEe = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ciK.getChildAt(this.aEe + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ciL.get(this.aEe);
            if (cVar.CX() != null) {
                cVar.CX().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
                this.ciQ = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEe = -1;
        this.ciK.removeAllViews();
        aeq();
        dE(this.api);
    }

    public void dE(int i) {
        int color;
        this.api = i;
        if (this.ciO != null) {
            aj.b(this.ciO, d.f.face_store, i);
        }
        if (this.ciN != null) {
            aj.d(this.ciN, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.ciN.getChildCount() > 0) {
                aj.e(this.ciN.getChildAt(1), d.C0080d.common_color_10288, i);
            }
        }
        if (this.aEk != null) {
            aj.d(this.aEk, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aEj != null) {
            aj.d(this.aEj, d.f.icon_news_head_prompt_one, i);
            aj.b(this.aEj, d.C0080d.cp_cont_i, 1, i);
        }
        int childCount = this.ciK.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ciK.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.ciT != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0080d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0080d.common_color_10287);
                        }
                        aVar.ciT.setForegroundColor(color);
                    }
                    if (aVar.ciU != null) {
                        aj.e(aVar.ciU, d.C0080d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ciQ != null) {
            this.ciQ.setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
            if (this.ciQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ciQ.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ciM = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aeH;

        private b(int i) {
            this.aeH = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ciQ) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0080d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ciQ != null) {
                    if (!EmotionTabHorizonScrollView.this.ciR) {
                        EmotionTabHorizonScrollView.this.ciQ.setForegroundColor(aj.getColor(d.C0080d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ciQ.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0080d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ciQ = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aeH);
            EmotionTabHorizonScrollView.this.ciM.fd(this.aeH);
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
        TbImageView ciT;
        View ciU;
        com.baidu.tbadk.editortools.emotiontool.c ciV;

        private a() {
        }
    }
}
