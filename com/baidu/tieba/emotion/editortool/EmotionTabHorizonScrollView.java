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
    private EditorTools aaA;
    private int aiD;
    private LinearLayout.LayoutParams dDm;
    private int eNG;
    private int eNH;
    private TextView eNI;
    private View eNJ;
    private int from;
    private LinearLayout hsA;
    private ImageView hsB;
    private boolean hsC;
    private TbImageView hsD;
    private boolean hsE;
    private EmotionLinearLayout hsx;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hsy;
    private EmotionTabWidgetView.a hsz;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.hsC = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.hsC = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.hsC = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.hsx = new EmotionLinearLayout(getContext());
        this.hsx.setOrientation(0);
        this.hsx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.hsx.setBaselineAligned(false);
        addView(this.hsx);
        this.eNG = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.eNH = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dDm = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.hsx.setPadding(0, 0, 0, 0);
        cee();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.hsE = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hsy = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.hsI = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.hsG = tbImageView;
        if (cVar.brN() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.eNH, this.eNG, this.eNH, this.eNG);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.hsH = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.hsx.addView(relativeLayout, this.hsx.getChildCount() - 1, this.dDm);
            if (cVar.brP() != null) {
                cVar.brP().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.hsE && (this.aiD == 1 || this.aiD == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hsD == null) {
                this.hsD = tbImageView;
                this.hsD.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aiD);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.eNH, this.eNG, this.eNH, this.eNG);
            View view2 = new View(getContext());
            aVar.hsH = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.hsx.addView(linearLayout, this.hsx.getChildCount() - 1, this.dDm);
            EmotionGroupType brN = cVar.brN();
            if (brN == EmotionGroupType.LOCAL) {
                if (cVar.brO() != null) {
                    cVar.brO().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hsx.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (brN == EmotionGroupType.PROMOTION) {
                if (cVar.brP() != null) {
                    cVar.brP().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (brN == EmotionGroupType.BIG_EMOTION) {
                if (this.hsC) {
                    if (cVar.brO() != null) {
                        cVar.brO().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.hsx.getChildCount() - 3));
                } else {
                    if (cVar.brP() != null) {
                        cVar.brP().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bhm();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (brN == EmotionGroupType.USER_COLLECT) {
                if (cVar.brP() != null) {
                    cVar.brP().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hsx.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (brN == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.brP() != null) {
                    cVar.brP().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.hsE && (this.aiD == 1 || this.aiD == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hsD == null) {
                this.hsD = tbImageView;
                this.hsD.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aiD);
        }
        return tbImageView;
    }

    public void cee() {
        this.hsB = new ImageView(getContext());
        this.hsB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hsB.setPadding(this.eNH, this.eNG, this.eNH, this.eNG);
        this.hsA = new LinearLayout(getContext());
        this.hsA.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.hsB.setLayoutParams(layoutParams);
        ap.setImageResource(this.hsB, R.drawable.face_store, this.aiD);
        this.hsA.addView(this.hsB);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.aiD);
        this.hsA.addView(view);
        this.eNI = new TextView(getContext());
        this.eNI.setGravity(17);
        this.eNI.setTextSize(10.0f);
        this.eNI.setText("N");
        this.eNI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.hsx.addView(this.hsA, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.hsx.setNewView(this.eNI);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.hsx.setNewViewVisible(true);
        } else {
            this.hsx.setNewViewVisible(false);
        }
        this.hsA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.eNI != null) {
                    EmotionTabHorizonScrollView.this.hsx.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.aaA != null) {
                    EmotionTabHorizonScrollView.this.aaA.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.eNJ = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.eNJ.setLayoutParams(layoutParams3);
        this.hsx.addView(this.eNJ);
        if (!appResponseToIntentClass) {
            this.hsA.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hsC = z;
        int i2 = i + 1;
        int childCount = this.hsx.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.hsy.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.brN() == EmotionGroupType.BIG_EMOTION || cVar.brN() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.hsx.getChildAt(i2)).getChildAt(0);
                if (!this.hsC) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bhm();
                        }
                    });
                    if (cVar.brP() != null) {
                        cVar.brP().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.brO() != null) {
                    cVar.brO().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.hsx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hsx.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).hsI;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.hsA.setVisibility(8);
        } else {
            this.hsA.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.brN() == EmotionGroupType.BIG_EMOTION || cVar.brN() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.hsx.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aiD == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.hsx.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hsy.get(this.mCurrentIndex);
            if (cVar.brO() != null) {
                cVar.brO().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.hsD = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hsx.removeAllViews();
        cee();
        onChangeSkin(this.aiD);
    }

    public void onChangeSkin(int i) {
        int color;
        this.aiD = i;
        if (this.hsB != null) {
            ap.setImageResource(this.hsB, R.drawable.face_store, i);
        }
        if (this.hsA != null) {
            ap.setBackgroundResource(this.hsA, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.hsA.getChildCount() > 0) {
                ap.setBackgroundColor(this.hsA.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.eNJ != null) {
            ap.setBackgroundResource(this.eNJ, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.eNI != null) {
            ap.setBackgroundResource(this.eNI, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.eNI, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.hsx.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.hsx.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.hsG != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.hsG.setForegroundColor(color);
                    }
                    if (aVar.hsH != null) {
                        ap.setBackgroundColor(aVar.hsH, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.hsD != null) {
            this.hsD.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.hsD.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hsD.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.hsz = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.hsD) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.hsD != null) {
                    if (!EmotionTabHorizonScrollView.this.hsE) {
                        EmotionTabHorizonScrollView.this.hsD.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.hsD.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.hsD = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.hsz.qo(this.mTabIndex);
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
        TbImageView hsG;
        View hsH;
        com.baidu.tbadk.editortools.emotiontool.c hsI;

        private a() {
        }
    }
}
