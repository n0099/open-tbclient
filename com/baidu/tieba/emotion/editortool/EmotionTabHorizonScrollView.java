package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
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
    private i Lt;
    private int aEZ;
    private LinearLayout.LayoutParams aFb;
    private int aFc;
    private int aFd;
    private TextView aFe;
    private View aFf;
    private int aqm;
    private com.baidu.tieba.emotion.editortool.a bXC;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXD;
    private EmotionTabWidgetView.a bXE;
    private LinearLayout bXF;
    private ImageView bXG;
    private boolean bXH;
    private TbImageView bXI;
    private boolean bXJ;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEZ = -1;
        this.bXH = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEZ = -1;
        this.bXH = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEZ = -1;
        this.bXH = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bXC = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.bXC.setOrientation(0);
        this.bXC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bXC.setBaselineAligned(false);
        addView(this.bXC);
        this.aFc = getResources().getDimensionPixelSize(d.f.ds8);
        this.aFd = getResources().getDimensionPixelSize(d.f.ds10);
        this.aFb = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.bXC.setPadding(0, 0, 0, 0);
        abk();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bXJ = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bXD = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a();
        aVar.bXN = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bXL = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aFd, this.aFc, this.aFd, this.aFc);
        View view = new View(getContext());
        aVar.bXM = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bXC.addView(linearLayout, this.bXC.getChildCount() - 1, this.aFb);
        EmotionGroupType Dp = cVar.Dp();
        if (Dp == EmotionGroupType.LOCAL) {
            if (cVar.Dq() != null) {
                cVar.Dq().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this.bXC.getChildCount() - 3));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
        } else if (Dp == EmotionGroupType.PROMOTION) {
            if (cVar.Dr() != null) {
                cVar.Dr().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
        } else if (Dp == EmotionGroupType.BIG_EMOTION) {
            if (this.bXH) {
                if (cVar.Dq() != null) {
                    cVar.Dq().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.bXC.getChildCount() - 3));
            } else {
                if (cVar.Dr() != null) {
                    cVar.Dr().e(tbImageView);
                }
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tA();
                    }
                });
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        } else if (Dp == EmotionGroupType.USER_COLLECT) {
            if (cVar.Dr() != null) {
                cVar.Dr().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this.bXC.getChildCount() - 3));
            tbImageView.setContentDescription("");
        }
        if (!this.bXJ && this.aqm == 1) {
            view.setBackgroundColor(ai.getColor(d.e.common_color_10288));
            tbImageView.setForegroundColor(ai.getColor(d.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
        }
        if (this.bXI == null) {
            this.bXI = tbImageView;
            this.bXI.setForegroundColor(ai.getColor(d.e.common_color_10022));
        }
        ai.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.aqm);
        return tbImageView;
    }

    public void abk() {
        this.bXG = new ImageView(getContext());
        this.bXG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bXG.setPadding(this.aFd, this.aFc, this.aFd, this.aFc);
        this.bXF = new LinearLayout(getContext());
        this.bXF.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bXG.setLayoutParams(layoutParams);
        ai.c(this.bXG, d.g.face_store, this.aqm);
        this.bXF.addView(this.bXG);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ai.e(view, d.e.common_color_10288, this.aqm);
        this.bXF.addView(view);
        this.aFe = new TextView(getContext());
        this.aFe.setGravity(17);
        this.aFe.setTextSize(10.0f);
        this.aFe.setText("N");
        this.aFe.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bXC.addView(this.bXF, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.bXC.setNewView(this.aFe);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bXC.setNewViewVisible(true);
        } else {
            this.bXC.setNewViewVisible(false);
        }
        this.bXF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aFe != null) {
                    EmotionTabHorizonScrollView.this.bXC.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Lt != null) {
                    EmotionTabHorizonScrollView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(EmotionTabHorizonScrollView.this.getContext(), "")));
            }
        });
        this.aFf = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aFf.setLayoutParams(layoutParams3);
        this.bXC.addView(this.aFf);
        if (!appResponseToIntentClass) {
            this.bXF.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void n(int i, boolean z) {
        this.bXH = z;
        int i2 = i + 1;
        int childCount = this.bXC.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXD.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Dp() == EmotionGroupType.BIG_EMOTION || cVar.Dp() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bXC.getChildAt(i2)).getChildAt(0);
                if (!this.bXH) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tA();
                        }
                    });
                    if (cVar.Dr() != null) {
                        cVar.Dr().e(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Dq() != null) {
                    cVar.Dq().e(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bXC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bXC.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bXN;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bXF.setVisibility(8);
        } else {
            this.bXF.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Dp() == EmotionGroupType.BIG_EMOTION || cVar.Dp() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEZ) {
            if (this.aEZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bXC.getChildAt(this.aEZ + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aqm == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = ai.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bXC.getChildAt(this.aEZ + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXD.get(this.aEZ);
            if (cVar.Dq() != null) {
                cVar.Dq().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ai.getColor(d.e.common_color_10022));
                this.bXI = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEZ = -1;
        this.bXC.removeAllViews();
        abk();
        dt(this.aqm);
    }

    public void dt(int i) {
        int color;
        this.aqm = i;
        if (this.bXG != null) {
            ai.c(this.bXG, d.g.face_store, i);
        }
        if (this.bXF != null) {
            ai.d(this.bXF, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bXF.getChildCount() > 0) {
                ai.e(this.bXF.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aFf != null) {
            ai.d(this.aFf, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aFe != null) {
            ai.d(this.aFe, d.g.icon_news_head_prompt_one, i);
            ai.b(this.aFe, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.bXC.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bXC.getChildAt(i2);
            if (childAt != null) {
                ai.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bXL != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = ai.getColor(d.e.common_color_10287);
                        }
                        aVar.bXL.setForegroundColor(color);
                    }
                    if (aVar.bXM != null) {
                        ai.e(aVar.bXM, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bXI != null) {
            this.bXI.setForegroundColor(ai.getColor(d.e.common_color_10022));
            if (this.bXI.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bXI.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bXE = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int afS;

        private b(int i) {
            this.afS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bXI) {
                ((TbImageView) view).setForegroundColor(ai.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bXI != null) {
                    if (!EmotionTabHorizonScrollView.this.bXJ) {
                        EmotionTabHorizonScrollView.this.bXI.setForegroundColor(ai.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bXI.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bXI = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.afS);
            EmotionTabHorizonScrollView.this.bXE.eT(this.afS);
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
        TbImageView bXL;
        View bXM;
        com.baidu.tbadk.editortools.emotiontool.c bXN;

        private a() {
        }
    }
}
