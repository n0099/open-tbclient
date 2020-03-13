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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools FO;
    private int Ni;
    private LinearLayout.LayoutParams cym;
    private int dzK;
    private int dzL;
    private TextView dzM;
    private View dzN;
    private EmotionLinearLayout fSF;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fSG;
    private EmotionTabWidgetView.a fSH;
    private LinearLayout fSI;
    private ImageView fSJ;
    private boolean fSK;
    private TbImageView fSL;
    private boolean fSM;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.fSK = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.fSK = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.fSK = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fSF = new EmotionLinearLayout(getContext());
        this.fSF.setOrientation(0);
        this.fSF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fSF.setBaselineAligned(false);
        addView(this.fSF);
        this.dzK = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dzL = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cym = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.fSF.setPadding(0, 0, 0, 0);
        bxp();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.fSM = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fSG = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.fSQ = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.fSO = tbImageView;
        if (cVar.aOJ() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.dzL, this.dzK, this.dzL, this.dzK);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.fSP = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.fSF.addView(relativeLayout, this.fSF.getChildCount() - 1, this.cym);
            if (cVar.aOL() != null) {
                cVar.aOL().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.fSM && (this.Ni == 1 || this.Ni == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fSL == null) {
                this.fSL = tbImageView;
                this.fSL.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.Ni);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.dzL, this.dzK, this.dzL, this.dzK);
            View view2 = new View(getContext());
            aVar.fSP = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.fSF.addView(linearLayout, this.fSF.getChildCount() - 1, this.cym);
            EmotionGroupType aOJ = cVar.aOJ();
            if (aOJ == EmotionGroupType.LOCAL) {
                if (cVar.aOK() != null) {
                    cVar.aOK().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fSF.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aOJ == EmotionGroupType.PROMOTION) {
                if (cVar.aOL() != null) {
                    cVar.aOL().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aOJ == EmotionGroupType.BIG_EMOTION) {
                if (this.fSK) {
                    if (cVar.aOK() != null) {
                        cVar.aOK().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.fSF.getChildCount() - 3));
                } else {
                    if (cVar.aOL() != null) {
                        cVar.aOL().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aEH();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aOJ == EmotionGroupType.USER_COLLECT) {
                if (cVar.aOL() != null) {
                    cVar.aOL().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fSF.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aOJ == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aOL() != null) {
                    cVar.aOL().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.fSM && (this.Ni == 1 || this.Ni == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fSL == null) {
                this.fSL = tbImageView;
                this.fSL.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.Ni);
        }
        return tbImageView;
    }

    public void bxp() {
        this.fSJ = new ImageView(getContext());
        this.fSJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fSJ.setPadding(this.dzL, this.dzK, this.dzL, this.dzK);
        this.fSI = new LinearLayout(getContext());
        this.fSI.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fSJ.setLayoutParams(layoutParams);
        am.setImageResource(this.fSJ, R.drawable.face_store, this.Ni);
        this.fSI.addView(this.fSJ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.Ni);
        this.fSI.addView(view);
        this.dzM = new TextView(getContext());
        this.dzM.setGravity(17);
        this.dzM.setTextSize(10.0f);
        this.dzM.setText("N");
        this.dzM.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.fSF.addView(this.fSI, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.fSF.setNewView(this.dzM);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.fSF.setNewViewVisible(true);
        } else {
            this.fSF.setNewViewVisible(false);
        }
        this.fSI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.dzM != null) {
                    EmotionTabHorizonScrollView.this.fSF.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.FO != null) {
                    EmotionTabHorizonScrollView.this.FO.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.dzN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.dzN.setLayoutParams(layoutParams3);
        this.fSF.addView(this.dzN);
        if (!appResponseToIntentClass) {
            this.fSI.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fSK = z;
        int i2 = i + 1;
        int childCount = this.fSF.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSG.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aOJ() == EmotionGroupType.BIG_EMOTION || cVar.aOJ() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.fSF.getChildAt(i2)).getChildAt(0);
                if (!this.fSK) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aEH();
                        }
                    });
                    if (cVar.aOL() != null) {
                        cVar.aOL().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aOK() != null) {
                    cVar.aOK().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.fSF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fSF.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).fSQ;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.fSI.setVisibility(8);
        } else {
            this.fSI.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aOJ() == EmotionGroupType.BIG_EMOTION || cVar.aOJ() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fSF.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.Ni == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fSF.getChildAt(this.mCurrentIndex + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(R.id.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fSG.get(this.mCurrentIndex);
            if (cVar.aOK() != null) {
                cVar.aOK().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.fSL = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fSF.removeAllViews();
        bxp();
        onChangeSkin(this.Ni);
    }

    public void onChangeSkin(int i) {
        int color;
        this.Ni = i;
        if (this.fSJ != null) {
            am.setImageResource(this.fSJ, R.drawable.face_store, i);
        }
        if (this.fSI != null) {
            am.setBackgroundResource(this.fSI, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.fSI.getChildCount() > 0) {
                am.setBackgroundColor(this.fSI.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.dzN != null) {
            am.setBackgroundResource(this.dzN, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.dzM != null) {
            am.setBackgroundResource(this.dzM, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.dzM, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.fSF.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.fSF.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.fSO != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.fSO.setForegroundColor(color);
                    }
                    if (aVar.fSP != null) {
                        am.setBackgroundColor(aVar.fSP, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.fSL != null) {
            this.fSL.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.fSL.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fSL.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.fSH = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.fSL) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.fSL != null) {
                    if (!EmotionTabHorizonScrollView.this.fSM) {
                        EmotionTabHorizonScrollView.this.fSL.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.fSL.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.fSL = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.fSH.mA(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.f.b.toInt(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.f.b.toInt(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        TbImageView fSO;
        View fSP;
        com.baidu.tbadk.editortools.emotiontool.c fSQ;

        private a() {
        }
    }
}
