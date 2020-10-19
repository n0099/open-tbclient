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
    private EditorTools abj;
    private int ajp;
    private LinearLayout.LayoutParams dRo;
    private int fcF;
    private int fcG;
    private TextView fcH;
    private View fcI;
    private int from;
    private LinearLayout hOA;
    private ImageView hOB;
    private boolean hOC;
    private TbImageView hOD;
    private boolean hOE;
    private EmotionLinearLayout hOx;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hOy;
    private EmotionTabWidgetView.a hOz;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.hOC = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.hOC = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.hOC = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.hOx = new EmotionLinearLayout(getContext());
        this.hOx.setOrientation(0);
        this.hOx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.hOx.setBaselineAligned(false);
        addView(this.hOx);
        this.fcF = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fcG = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dRo = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.hOx.setPadding(0, 0, 0, 0);
        ckP();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.hOE = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hOy = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.hOI = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.hOG = tbImageView;
        if (cVar.bvz() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fcG, this.fcF, this.fcG, this.fcF);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.hOH = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.hOx.addView(relativeLayout, this.hOx.getChildCount() - 1, this.dRo);
            if (cVar.bvB() != null) {
                cVar.bvB().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.hOE && (this.ajp == 1 || this.ajp == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hOD == null) {
                this.hOD = tbImageView;
                this.hOD.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajp);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fcG, this.fcF, this.fcG, this.fcF);
            View view2 = new View(getContext());
            aVar.hOH = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.hOx.addView(linearLayout, this.hOx.getChildCount() - 1, this.dRo);
            EmotionGroupType bvz = cVar.bvz();
            if (bvz == EmotionGroupType.LOCAL) {
                if (cVar.bvA() != null) {
                    cVar.bvA().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hOx.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bvz == EmotionGroupType.PROMOTION) {
                if (cVar.bvB() != null) {
                    cVar.bvB().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bvz == EmotionGroupType.BIG_EMOTION) {
                if (this.hOC) {
                    if (cVar.bvA() != null) {
                        cVar.bvA().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.hOx.getChildCount() - 3));
                } else {
                    if (cVar.bvB() != null) {
                        cVar.bvB().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bkP();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bvz == EmotionGroupType.USER_COLLECT) {
                if (cVar.bvB() != null) {
                    cVar.bvB().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hOx.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bvz == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bvB() != null) {
                    cVar.bvB().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.hOE && (this.ajp == 1 || this.ajp == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hOD == null) {
                this.hOD = tbImageView;
                this.hOD.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajp);
        }
        return tbImageView;
    }

    public void ckP() {
        this.hOB = new ImageView(getContext());
        this.hOB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hOB.setPadding(this.fcG, this.fcF, this.fcG, this.fcF);
        this.hOA = new LinearLayout(getContext());
        this.hOA.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.hOB.setLayoutParams(layoutParams);
        ap.setImageResource(this.hOB, R.drawable.face_store, this.ajp);
        this.hOA.addView(this.hOB);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.ajp);
        this.hOA.addView(view);
        this.fcH = new TextView(getContext());
        this.fcH.setGravity(17);
        this.fcH.setTextSize(10.0f);
        this.fcH.setText("N");
        this.fcH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.hOx.addView(this.hOA, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.hOx.setNewView(this.fcH);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.hOx.setNewViewVisible(true);
        } else {
            this.hOx.setNewViewVisible(false);
        }
        this.hOA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fcH != null) {
                    EmotionTabHorizonScrollView.this.hOx.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.abj != null) {
                    EmotionTabHorizonScrollView.this.abj.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fcI = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fcI.setLayoutParams(layoutParams3);
        this.hOx.addView(this.fcI);
        if (!appResponseToIntentClass) {
            this.hOA.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hOC = z;
        int i2 = i + 1;
        int childCount = this.hOx.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.hOy.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bvz() == EmotionGroupType.BIG_EMOTION || cVar.bvz() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.hOx.getChildAt(i2)).getChildAt(0);
                if (!this.hOC) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bkP();
                        }
                    });
                    if (cVar.bvB() != null) {
                        cVar.bvB().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bvA() != null) {
                    cVar.bvA().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.hOx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hOx.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).hOI;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.hOA.setVisibility(8);
        } else {
            this.hOA.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bvz() == EmotionGroupType.BIG_EMOTION || cVar.bvz() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.hOx.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ajp == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.hOx.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hOy.get(this.mCurrentIndex);
            if (cVar.bvA() != null) {
                cVar.bvA().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.hOD = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hOx.removeAllViews();
        ckP();
        onChangeSkin(this.ajp);
    }

    public void onChangeSkin(int i) {
        int color;
        this.ajp = i;
        if (this.hOB != null) {
            ap.setImageResource(this.hOB, R.drawable.face_store, i);
        }
        if (this.hOA != null) {
            ap.setBackgroundResource(this.hOA, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.hOA.getChildCount() > 0) {
                ap.setBackgroundColor(this.hOA.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fcI != null) {
            ap.setBackgroundResource(this.fcI, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fcH != null) {
            ap.setBackgroundResource(this.fcH, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.fcH, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.hOx.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.hOx.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.hOG != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.hOG.setForegroundColor(color);
                    }
                    if (aVar.hOH != null) {
                        ap.setBackgroundColor(aVar.hOH, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.hOD != null) {
            this.hOD.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.hOD.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hOD.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.hOz = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
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
            if (!EmotionTabHorizonScrollView.this.abj.qP(5).bvv() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.hOy.get(this.mTabIndex)).bvz() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.hOy.get(this.mTabIndex)).bvz() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.hOD) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.hOD != null) {
                    if (!EmotionTabHorizonScrollView.this.hOE) {
                        EmotionTabHorizonScrollView.this.hOD.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.hOD.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.hOD = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.hOz.rd(this.mTabIndex);
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
        TbImageView hOG;
        View hOH;
        com.baidu.tbadk.editortools.emotiontool.c hOI;

        private a() {
        }
    }
}
