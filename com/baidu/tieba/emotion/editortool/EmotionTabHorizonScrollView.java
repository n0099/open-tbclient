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
import com.baidu.tbadk.core.util.ao;
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
    private EditorTools ZS;
    private int aho;
    private LinearLayout.LayoutParams dti;
    private int eDd;
    private int eDe;
    private TextView eDf;
    private View eDg;
    private int from;
    private EmotionTabWidgetView.a hfA;
    private LinearLayout hfB;
    private ImageView hfC;
    private boolean hfD;
    private TbImageView hfE;
    private boolean hfF;
    private EmotionLinearLayout hfy;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hfz;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.hfD = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.hfD = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.hfD = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.hfy = new EmotionLinearLayout(getContext());
        this.hfy.setOrientation(0);
        this.hfy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.hfy.setBaselineAligned(false);
        addView(this.hfy);
        this.eDd = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.eDe = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dti = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.hfy.setPadding(0, 0, 0, 0);
        bTR();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.hfF = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hfz = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.hfJ = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.hfH = tbImageView;
        if (cVar.bja() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.eDe, this.eDd, this.eDe, this.eDd);
            ImageView imageView = new ImageView(getContext());
            ao.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.hfI = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.hfy.addView(relativeLayout, this.hfy.getChildCount() - 1, this.dti);
            if (cVar.bjc() != null) {
                cVar.bjc().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.hfF && (this.aho == 1 || this.aho == 4)) {
                view.setBackgroundColor(ao.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ao.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hfE == null) {
                this.hfE = tbImageView;
                this.hfE.setForegroundColor(ao.getColor(R.color.common_color_10022));
            }
            ao.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aho);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.eDe, this.eDd, this.eDe, this.eDd);
            View view2 = new View(getContext());
            aVar.hfI = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.hfy.addView(linearLayout, this.hfy.getChildCount() - 1, this.dti);
            EmotionGroupType bja = cVar.bja();
            if (bja == EmotionGroupType.LOCAL) {
                if (cVar.bjb() != null) {
                    cVar.bjb().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hfy.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bja == EmotionGroupType.PROMOTION) {
                if (cVar.bjc() != null) {
                    cVar.bjc().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bja == EmotionGroupType.BIG_EMOTION) {
                if (this.hfD) {
                    if (cVar.bjb() != null) {
                        cVar.bjb().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.hfy.getChildCount() - 3));
                } else {
                    if (cVar.bjc() != null) {
                        cVar.bjc().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aYR();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bja == EmotionGroupType.USER_COLLECT) {
                if (cVar.bjc() != null) {
                    cVar.bjc().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hfy.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bja == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bjc() != null) {
                    cVar.bjc().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.hfF && (this.aho == 1 || this.aho == 4)) {
                view2.setBackgroundColor(ao.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ao.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hfE == null) {
                this.hfE = tbImageView;
                this.hfE.setForegroundColor(ao.getColor(R.color.common_color_10022));
            }
            ao.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aho);
        }
        return tbImageView;
    }

    public void bTR() {
        this.hfC = new ImageView(getContext());
        this.hfC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hfC.setPadding(this.eDe, this.eDd, this.eDe, this.eDd);
        this.hfB = new LinearLayout(getContext());
        this.hfB.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.hfC.setLayoutParams(layoutParams);
        ao.setImageResource(this.hfC, R.drawable.face_store, this.aho);
        this.hfB.addView(this.hfC);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ao.setBackgroundColor(view, R.color.common_color_10288, this.aho);
        this.hfB.addView(view);
        this.eDf = new TextView(getContext());
        this.eDf.setGravity(17);
        this.eDf.setTextSize(10.0f);
        this.eDf.setText("N");
        this.eDf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.hfy.addView(this.hfB, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.hfy.setNewView(this.eDf);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.hfy.setNewViewVisible(true);
        } else {
            this.hfy.setNewViewVisible(false);
        }
        this.hfB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.eDf != null) {
                    EmotionTabHorizonScrollView.this.hfy.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.ZS != null) {
                    EmotionTabHorizonScrollView.this.ZS.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.eDg = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.eDg.setLayoutParams(layoutParams3);
        this.hfy.addView(this.eDg);
        if (!appResponseToIntentClass) {
            this.hfB.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hfD = z;
        int i2 = i + 1;
        int childCount = this.hfy.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.hfz.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bja() == EmotionGroupType.BIG_EMOTION || cVar.bja() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.hfy.getChildAt(i2)).getChildAt(0);
                if (!this.hfD) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aYR();
                        }
                    });
                    if (cVar.bjc() != null) {
                        cVar.bjc().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bjb() != null) {
                    cVar.bjb().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.hfy.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hfy.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).hfJ;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.hfB.setVisibility(8);
        } else {
            this.hfB.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bja() == EmotionGroupType.BIG_EMOTION || cVar.bja() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.hfy.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aho == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ao.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.hfy.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hfz.get(this.mCurrentIndex);
            if (cVar.bjb() != null) {
                cVar.bjb().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ao.getColor(R.color.common_color_10022));
                this.hfE = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hfy.removeAllViews();
        bTR();
        onChangeSkin(this.aho);
    }

    public void onChangeSkin(int i) {
        int color;
        this.aho = i;
        if (this.hfC != null) {
            ao.setImageResource(this.hfC, R.drawable.face_store, i);
        }
        if (this.hfB != null) {
            ao.setBackgroundResource(this.hfB, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.hfB.getChildCount() > 0) {
                ao.setBackgroundColor(this.hfB.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.eDg != null) {
            ao.setBackgroundResource(this.eDg, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.eDf != null) {
            ao.setBackgroundResource(this.eDf, R.drawable.icon_news_head_prompt_one, i);
            ao.setViewTextColor(this.eDf, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.hfy.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.hfy.getChildAt(i2);
            if (childAt != null) {
                ao.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.hfH != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ao.getColor(R.color.common_color_10287);
                        }
                        aVar.hfH.setForegroundColor(color);
                    }
                    if (aVar.hfI != null) {
                        ao.setBackgroundColor(aVar.hfI, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.hfE != null) {
            this.hfE.setForegroundColor(ao.getColor(R.color.common_color_10022));
            if (this.hfE.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hfE.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.hfA = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.hfE) {
                ((TbImageView) view).setForegroundColor(ao.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.hfE != null) {
                    if (!EmotionTabHorizonScrollView.this.hfF) {
                        EmotionTabHorizonScrollView.this.hfE.setForegroundColor(ao.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.hfE.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.hfE = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.hfA.od(this.mTabIndex);
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
        TbImageView hfH;
        View hfI;
        com.baidu.tbadk.editortools.emotiontool.c hfJ;

        private a() {
        }
    }
}
