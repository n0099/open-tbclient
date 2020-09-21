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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes13.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools aaS;
    private int aiX;
    private LinearLayout.LayoutParams dFn;
    private View eQA;
    private int eQx;
    private int eQy;
    private TextView eQz;
    private int from;
    private EmotionLinearLayout hzC;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hzD;
    private EmotionTabWidgetView.a hzE;
    private LinearLayout hzF;
    private ImageView hzG;
    private boolean hzH;
    private TbImageView hzI;
    private boolean hzJ;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.hzH = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.hzH = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.hzH = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.hzC = new EmotionLinearLayout(getContext());
        this.hzC.setOrientation(0);
        this.hzC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.hzC.setBaselineAligned(false);
        addView(this.hzC);
        this.eQx = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.eQy = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dFn = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.hzC.setPadding(0, 0, 0, 0);
        cht();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.hzJ = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hzD = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.hzN = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.hzL = tbImageView;
        if (cVar.bsP() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.eQy, this.eQx, this.eQy, this.eQx);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.hzM = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.hzC.addView(relativeLayout, this.hzC.getChildCount() - 1, this.dFn);
            if (cVar.bsR() != null) {
                cVar.bsR().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.hzJ && (this.aiX == 1 || this.aiX == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hzI == null) {
                this.hzI = tbImageView;
                this.hzI.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aiX);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.eQy, this.eQx, this.eQy, this.eQx);
            View view2 = new View(getContext());
            aVar.hzM = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.hzC.addView(linearLayout, this.hzC.getChildCount() - 1, this.dFn);
            EmotionGroupType bsP = cVar.bsP();
            if (bsP == EmotionGroupType.LOCAL) {
                if (cVar.bsQ() != null) {
                    cVar.bsQ().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hzC.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bsP == EmotionGroupType.PROMOTION) {
                if (cVar.bsR() != null) {
                    cVar.bsR().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bsP == EmotionGroupType.BIG_EMOTION) {
                if (this.hzH) {
                    if (cVar.bsQ() != null) {
                        cVar.bsQ().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.hzC.getChildCount() - 3));
                } else {
                    if (cVar.bsR() != null) {
                        cVar.bsR().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).big();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bsP == EmotionGroupType.USER_COLLECT) {
                if (cVar.bsR() != null) {
                    cVar.bsR().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hzC.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bsP == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bsR() != null) {
                    cVar.bsR().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.hzJ && (this.aiX == 1 || this.aiX == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hzI == null) {
                this.hzI = tbImageView;
                this.hzI.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aiX);
        }
        return tbImageView;
    }

    public void cht() {
        this.hzG = new ImageView(getContext());
        this.hzG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hzG.setPadding(this.eQy, this.eQx, this.eQy, this.eQx);
        this.hzF = new LinearLayout(getContext());
        this.hzF.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.hzG.setLayoutParams(layoutParams);
        ap.setImageResource(this.hzG, R.drawable.face_store, this.aiX);
        this.hzF.addView(this.hzG);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.aiX);
        this.hzF.addView(view);
        this.eQz = new TextView(getContext());
        this.eQz.setGravity(17);
        this.eQz.setTextSize(10.0f);
        this.eQz.setText("N");
        this.eQz.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.hzC.addView(this.hzF, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.hzC.setNewView(this.eQz);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.hzC.setNewViewVisible(true);
        } else {
            this.hzC.setNewViewVisible(false);
        }
        this.hzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.eQz != null) {
                    EmotionTabHorizonScrollView.this.hzC.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.aaS != null) {
                    EmotionTabHorizonScrollView.this.aaS.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.eQA = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.eQA.setLayoutParams(layoutParams3);
        this.hzC.addView(this.eQA);
        if (!appResponseToIntentClass) {
            this.hzF.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hzH = z;
        int i2 = i + 1;
        int childCount = this.hzC.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.hzD.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bsP() == EmotionGroupType.BIG_EMOTION || cVar.bsP() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.hzC.getChildAt(i2)).getChildAt(0);
                if (!this.hzH) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).big();
                        }
                    });
                    if (cVar.bsR() != null) {
                        cVar.bsR().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bsQ() != null) {
                    cVar.bsQ().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.hzC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hzC.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).hzN;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.hzF.setVisibility(8);
        } else {
            this.hzF.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bsP() == EmotionGroupType.BIG_EMOTION || cVar.bsP() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.hzC.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aiX == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.hzC.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hzD.get(this.mCurrentIndex);
            if (cVar.bsQ() != null) {
                cVar.bsQ().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.hzI = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hzC.removeAllViews();
        cht();
        onChangeSkin(this.aiX);
    }

    public void onChangeSkin(int i) {
        int color;
        this.aiX = i;
        if (this.hzG != null) {
            ap.setImageResource(this.hzG, R.drawable.face_store, i);
        }
        if (this.hzF != null) {
            ap.setBackgroundResource(this.hzF, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.hzF.getChildCount() > 0) {
                ap.setBackgroundColor(this.hzF.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.eQA != null) {
            ap.setBackgroundResource(this.eQA, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.eQz != null) {
            ap.setBackgroundResource(this.eQz, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.eQz, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.hzC.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.hzC.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.hzL != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.hzL.setForegroundColor(color);
                    }
                    if (aVar.hzM != null) {
                        ap.setBackgroundColor(aVar.hzM, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.hzI != null) {
            this.hzI.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.hzI.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hzI.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.hzE = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!EmotionTabHorizonScrollView.this.aaS.qr(5).bsL() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.hzD.get(this.mTabIndex)).bsP() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.hzD.get(this.mTabIndex)).bsP() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.hzI) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.hzI != null) {
                    if (!EmotionTabHorizonScrollView.this.hzJ) {
                        EmotionTabHorizonScrollView.this.hzI.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.hzI.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.hzI = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.hzE.qF(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
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
    /* loaded from: classes13.dex */
    public static class a {
        TbImageView hzL;
        View hzM;
        com.baidu.tbadk.editortools.emotiontool.c hzN;

        private a() {
        }
    }
}
