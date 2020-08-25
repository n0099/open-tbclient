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
    private EditorTools aay;
    private int aiB;
    private LinearLayout.LayoutParams dDi;
    private int eNC;
    private int eND;
    private TextView eNE;
    private View eNF;
    private int from;
    private EmotionLinearLayout hsr;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hss;
    private EmotionTabWidgetView.a hst;
    private LinearLayout hsu;
    private ImageView hsv;
    private boolean hsw;
    private TbImageView hsx;
    private boolean hsy;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.hsw = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.hsw = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.hsw = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.hsr = new EmotionLinearLayout(getContext());
        this.hsr.setOrientation(0);
        this.hsr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.hsr.setBaselineAligned(false);
        addView(this.hsr);
        this.eNC = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.eND = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dDi = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.hsr.setPadding(0, 0, 0, 0);
        ced();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.hsy = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hss = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.hsC = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.hsA = tbImageView;
        if (cVar.brM() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.eND, this.eNC, this.eND, this.eNC);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.hsB = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.hsr.addView(relativeLayout, this.hsr.getChildCount() - 1, this.dDi);
            if (cVar.brO() != null) {
                cVar.brO().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.hsy && (this.aiB == 1 || this.aiB == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hsx == null) {
                this.hsx = tbImageView;
                this.hsx.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aiB);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.eND, this.eNC, this.eND, this.eNC);
            View view2 = new View(getContext());
            aVar.hsB = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.hsr.addView(linearLayout, this.hsr.getChildCount() - 1, this.dDi);
            EmotionGroupType brM = cVar.brM();
            if (brM == EmotionGroupType.LOCAL) {
                if (cVar.brN() != null) {
                    cVar.brN().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hsr.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (brM == EmotionGroupType.PROMOTION) {
                if (cVar.brO() != null) {
                    cVar.brO().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (brM == EmotionGroupType.BIG_EMOTION) {
                if (this.hsw) {
                    if (cVar.brN() != null) {
                        cVar.brN().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.hsr.getChildCount() - 3));
                } else {
                    if (cVar.brO() != null) {
                        cVar.brO().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bhm();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (brM == EmotionGroupType.USER_COLLECT) {
                if (cVar.brO() != null) {
                    cVar.brO().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.hsr.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (brM == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.brO() != null) {
                    cVar.brO().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.hsy && (this.aiB == 1 || this.aiB == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.hsx == null) {
                this.hsx = tbImageView;
                this.hsx.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aiB);
        }
        return tbImageView;
    }

    public void ced() {
        this.hsv = new ImageView(getContext());
        this.hsv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.hsv.setPadding(this.eND, this.eNC, this.eND, this.eNC);
        this.hsu = new LinearLayout(getContext());
        this.hsu.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.hsv.setLayoutParams(layoutParams);
        ap.setImageResource(this.hsv, R.drawable.face_store, this.aiB);
        this.hsu.addView(this.hsv);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.aiB);
        this.hsu.addView(view);
        this.eNE = new TextView(getContext());
        this.eNE.setGravity(17);
        this.eNE.setTextSize(10.0f);
        this.eNE.setText("N");
        this.eNE.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.hsr.addView(this.hsu, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.hsr.setNewView(this.eNE);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.hsr.setNewViewVisible(true);
        } else {
            this.hsr.setNewViewVisible(false);
        }
        this.hsu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.eNE != null) {
                    EmotionTabHorizonScrollView.this.hsr.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.aay != null) {
                    EmotionTabHorizonScrollView.this.aay.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.eNF = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.eNF.setLayoutParams(layoutParams3);
        this.hsr.addView(this.eNF);
        if (!appResponseToIntentClass) {
            this.hsu.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hsw = z;
        int i2 = i + 1;
        int childCount = this.hsr.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.hss.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.brM() == EmotionGroupType.BIG_EMOTION || cVar.brM() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.hsr.getChildAt(i2)).getChildAt(0);
                if (!this.hsw) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bhm();
                        }
                    });
                    if (cVar.brO() != null) {
                        cVar.brO().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.brN() != null) {
                    cVar.brN().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.hsr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hsr.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).hsC;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.hsu.setVisibility(8);
        } else {
            this.hsu.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.brM() == EmotionGroupType.BIG_EMOTION || cVar.brM() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.hsr.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aiB == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.hsr.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hss.get(this.mCurrentIndex);
            if (cVar.brN() != null) {
                cVar.brN().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.hsx = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hsr.removeAllViews();
        ced();
        onChangeSkin(this.aiB);
    }

    public void onChangeSkin(int i) {
        int color;
        this.aiB = i;
        if (this.hsv != null) {
            ap.setImageResource(this.hsv, R.drawable.face_store, i);
        }
        if (this.hsu != null) {
            ap.setBackgroundResource(this.hsu, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.hsu.getChildCount() > 0) {
                ap.setBackgroundColor(this.hsu.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.eNF != null) {
            ap.setBackgroundResource(this.eNF, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.eNE != null) {
            ap.setBackgroundResource(this.eNE, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.eNE, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.hsr.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.hsr.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.hsA != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.hsA.setForegroundColor(color);
                    }
                    if (aVar.hsB != null) {
                        ap.setBackgroundColor(aVar.hsB, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.hsx != null) {
            this.hsx.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.hsx.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hsx.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.hst = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.hsx) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.hsx != null) {
                    if (!EmotionTabHorizonScrollView.this.hsy) {
                        EmotionTabHorizonScrollView.this.hsx.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.hsx.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.hsx = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.hst.qo(this.mTabIndex);
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
        TbImageView hsA;
        View hsB;
        com.baidu.tbadk.editortools.emotiontool.c hsC;

        private a() {
        }
    }
}
