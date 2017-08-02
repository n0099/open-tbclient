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
    private i JT;
    private int aDH;
    private LinearLayout.LayoutParams aDJ;
    private int aDK;
    private int aDL;
    private TextView aDM;
    private View aDN;
    private int aoR;
    private com.baidu.tieba.emotion.editortool.a bVJ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bVK;
    private EmotionTabWidgetView.a bVL;
    private LinearLayout bVM;
    private ImageView bVN;
    private boolean bVO;
    private TbImageView bVP;
    private boolean bVQ;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDH = -1;
        this.bVO = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDH = -1;
        this.bVO = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aDH = -1;
        this.bVO = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bVJ = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.bVJ.setOrientation(0);
        this.bVJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bVJ.setBaselineAligned(false);
        addView(this.bVJ);
        this.aDK = getResources().getDimensionPixelSize(d.f.ds8);
        this.aDL = getResources().getDimensionPixelSize(d.f.ds10);
        this.aDJ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.bVJ.setPadding(0, 0, 0, 0);
        aaN();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bVQ = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bVK = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a();
        aVar.bVU = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bVS = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aDL, this.aDK, this.aDL, this.aDK);
        View view = new View(getContext());
        aVar.bVT = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bVJ.addView(linearLayout, this.bVJ.getChildCount() - 1, this.aDJ);
        EmotionGroupType Dh = cVar.Dh();
        if (Dh == EmotionGroupType.LOCAL) {
            if (cVar.Di() != null) {
                cVar.Di().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this.bVJ.getChildCount() - 3));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
        } else if (Dh == EmotionGroupType.PROMOTION) {
            if (cVar.Dj() != null) {
                cVar.Dj().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
        } else if (Dh == EmotionGroupType.BIG_EMOTION) {
            if (this.bVO) {
                if (cVar.Di() != null) {
                    cVar.Di().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.bVJ.getChildCount() - 3));
            } else {
                if (cVar.Dj() != null) {
                    cVar.Dj().e(tbImageView);
                }
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tp();
                    }
                });
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        } else if (Dh == EmotionGroupType.USER_COLLECT) {
            if (cVar.Dj() != null) {
                cVar.Dj().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this.bVJ.getChildCount() - 3));
            tbImageView.setContentDescription("");
        }
        if (!this.bVQ && this.aoR == 1) {
            view.setBackgroundColor(ai.getColor(d.e.common_color_10288));
            tbImageView.setForegroundColor(ai.getColor(d.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
        }
        if (this.bVP == null) {
            this.bVP = tbImageView;
            this.bVP.setForegroundColor(ai.getColor(d.e.common_color_10022));
        }
        ai.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.aoR);
        return tbImageView;
    }

    public void aaN() {
        this.bVN = new ImageView(getContext());
        this.bVN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVN.setPadding(this.aDL, this.aDK, this.aDL, this.aDK);
        this.bVM = new LinearLayout(getContext());
        this.bVM.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bVN.setLayoutParams(layoutParams);
        ai.c(this.bVN, d.g.face_store, this.aoR);
        this.bVM.addView(this.bVN);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ai.e(view, d.e.common_color_10288, this.aoR);
        this.bVM.addView(view);
        this.aDM = new TextView(getContext());
        this.aDM.setGravity(17);
        this.aDM.setTextSize(10.0f);
        this.aDM.setText("N");
        this.aDM.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bVJ.addView(this.bVM, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.bVJ.setNewView(this.aDM);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bVJ.setNewViewVisible(true);
        } else {
            this.bVJ.setNewViewVisible(false);
        }
        this.bVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aDM != null) {
                    EmotionTabHorizonScrollView.this.bVJ.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.JT != null) {
                    EmotionTabHorizonScrollView.this.JT.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(EmotionTabHorizonScrollView.this.getContext(), "")));
            }
        });
        this.aDN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aDN.setLayoutParams(layoutParams3);
        this.bVJ.addView(this.aDN);
        if (!appResponseToIntentClass) {
            this.bVM.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void n(int i, boolean z) {
        this.bVO = z;
        int i2 = i + 1;
        int childCount = this.bVJ.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bVK.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Dh() == EmotionGroupType.BIG_EMOTION || cVar.Dh() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bVJ.getChildAt(i2)).getChildAt(0);
                if (!this.bVO) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tp();
                        }
                    });
                    if (cVar.Dj() != null) {
                        cVar.Dj().e(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Di() != null) {
                    cVar.Di().e(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bVJ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bVJ.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bVU;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bVM.setVisibility(8);
        } else {
            this.bVM.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Dh() == EmotionGroupType.BIG_EMOTION || cVar.Dh() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aDH) {
            if (this.aDH != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bVJ.getChildAt(this.aDH + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aoR == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = ai.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aDH = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bVJ.getChildAt(this.aDH + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bVK.get(this.aDH);
            if (cVar.Di() != null) {
                cVar.Di().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ai.getColor(d.e.common_color_10022));
                this.bVP = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aDH = -1;
        this.bVJ.removeAllViews();
        aaN();
        dr(this.aoR);
    }

    public void dr(int i) {
        int color;
        this.aoR = i;
        if (this.bVN != null) {
            ai.c(this.bVN, d.g.face_store, i);
        }
        if (this.bVM != null) {
            ai.d(this.bVM, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bVM.getChildCount() > 0) {
                ai.e(this.bVM.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aDN != null) {
            ai.d(this.aDN, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aDM != null) {
            ai.d(this.aDM, d.g.icon_news_head_prompt_one, i);
            ai.b(this.aDM, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.bVJ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bVJ.getChildAt(i2);
            if (childAt != null) {
                ai.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bVS != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = ai.getColor(d.e.common_color_10287);
                        }
                        aVar.bVS.setForegroundColor(color);
                    }
                    if (aVar.bVT != null) {
                        ai.e(aVar.bVT, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bVP != null) {
            this.bVP.setForegroundColor(ai.getColor(d.e.common_color_10022));
            if (this.bVP.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bVP.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bVL = aVar;
    }

    public void setEditorTools(i iVar) {
        this.JT = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aev;

        private b(int i) {
            this.aev = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bVP) {
                ((TbImageView) view).setForegroundColor(ai.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bVP != null) {
                    if (!EmotionTabHorizonScrollView.this.bVQ) {
                        EmotionTabHorizonScrollView.this.bVP.setForegroundColor(ai.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bVP.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bVP = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aev);
            EmotionTabHorizonScrollView.this.bVL.eR(this.aev);
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
        TbImageView bVS;
        View bVT;
        com.baidu.tbadk.editortools.emotiontool.c bVU;

        private a() {
        }
    }
}
