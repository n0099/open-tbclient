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
    private EditorTools acn;
    private int aku;
    private LinearLayout.LayoutParams ekV;
    private int from;
    private int fxI;
    private int fxJ;
    private TextView fxK;
    private View fxL;
    private EmotionLinearLayout isE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> isF;
    private EmotionTabWidgetView.a isG;
    private LinearLayout isH;
    private ImageView isI;
    private boolean isJ;
    private TbImageView isK;
    private boolean isL;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.isJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.isJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.isJ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.isE = new EmotionLinearLayout(getContext());
        this.isE.setOrientation(0);
        this.isE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.isE.setBaselineAligned(false);
        addView(this.isE);
        this.fxI = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fxJ = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ekV = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.isE.setPadding(0, 0, 0, 0);
        cup();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.isL = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.isF = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.isP = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.isN = tbImageView;
        if (cVar.bCH() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fxJ, this.fxI, this.fxJ, this.fxI);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1).addRule(11);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.isE.addView(relativeLayout, this.isE.getChildCount() - 1, this.ekV);
            if (cVar.bCJ() != null) {
                cVar.bCJ().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.isL && (this.aku == 1 || this.aku == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.isK == null) {
                this.isK = tbImageView;
                this.isK.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aku);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fxJ, this.fxI, this.fxJ, this.fxI);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.isE.addView(linearLayout, this.isE.getChildCount() - 1, this.ekV);
            EmotionGroupType bCH = cVar.bCH();
            if (bCH == EmotionGroupType.LOCAL) {
                if (cVar.bCI() != null) {
                    cVar.bCI().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.isE.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bCH == EmotionGroupType.PROMOTION) {
                if (cVar.bCJ() != null) {
                    cVar.bCJ().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bCH == EmotionGroupType.BIG_EMOTION) {
                if (this.isJ) {
                    if (cVar.bCI() != null) {
                        cVar.bCI().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.isE.getChildCount() - 3));
                } else {
                    if (cVar.bCJ() != null) {
                        cVar.bCJ().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).brB();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bCH == EmotionGroupType.USER_COLLECT) {
                if (cVar.bCJ() != null) {
                    cVar.bCJ().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.isE.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bCH == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bCJ() != null) {
                    cVar.bCJ().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.isL && (this.aku == 1 || this.aku == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.isK == null) {
                this.isK = tbImageView;
                this.isK.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aku);
        }
        return tbImageView;
    }

    public void cup() {
        this.isI = new ImageView(getContext());
        this.isI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.isI.setPadding(this.fxJ, this.fxI, this.fxJ, this.fxI);
        this.isH = new LinearLayout(getContext());
        this.isH.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.isI.setLayoutParams(layoutParams);
        ap.setImageResource(this.isI, R.drawable.face_store, this.aku);
        this.isH.addView(this.isI);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.aku);
        this.fxK = new TextView(getContext());
        this.fxK.setGravity(17);
        this.fxK.setTextSize(10.0f);
        this.fxK.setText("N");
        this.fxK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.isE.addView(this.isH, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.isE.setNewView(this.fxK);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.isE.setNewViewVisible(true);
        } else {
            this.isE.setNewViewVisible(false);
        }
        this.isH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fxK != null) {
                    EmotionTabHorizonScrollView.this.isE.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.acn != null) {
                    EmotionTabHorizonScrollView.this.acn.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fxL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fxL.setLayoutParams(layoutParams3);
        this.isE.addView(this.fxL);
        if (!appResponseToIntentClass) {
            this.isH.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.isJ = z;
        int i2 = i + 1;
        int childCount = this.isE.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.isF.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bCH() == EmotionGroupType.BIG_EMOTION || cVar.bCH() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.isE.getChildAt(i2)).getChildAt(0);
                if (!this.isJ) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).brB();
                        }
                    });
                    if (cVar.bCJ() != null) {
                        cVar.bCJ().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bCI() != null) {
                    cVar.bCI().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.isE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.isE.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).isP;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.isH.setVisibility(8);
        } else {
            this.isH.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bCH() == EmotionGroupType.BIG_EMOTION || cVar.bCH() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.isE.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aku == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.isE.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.isF.get(this.mCurrentIndex);
            if (cVar.bCI() != null) {
                cVar.bCI().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.isK = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.isE.removeAllViews();
        cup();
        onChangeSkin(this.aku);
    }

    public void onChangeSkin(int i) {
        int color;
        this.aku = i;
        if (this.isI != null) {
            ap.setImageResource(this.isI, R.drawable.face_store, i);
        }
        if (this.isH != null) {
            ap.setBackgroundResource(this.isH, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.isH.getChildCount() > 0) {
                ap.setBackgroundColor(this.isH.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fxL != null) {
            ap.setBackgroundResource(this.fxL, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fxK != null) {
            ap.setBackgroundResource(this.fxK, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.fxK, R.color.CAM_X0101, 1, i);
        }
        int childCount = this.isE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.isE.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.isN != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.isN.setForegroundColor(color);
                    }
                    if (aVar.isO != null) {
                        ap.setBackgroundColor(aVar.isO, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.isK != null) {
            this.isK.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.isK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.isK.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.isG = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
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
            if (!EmotionTabHorizonScrollView.this.acn.sj(5).bCD() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.isF.get(this.mTabIndex)).bCH() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.isF.get(this.mTabIndex)).bCH() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.isK) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.isK != null) {
                    if (!EmotionTabHorizonScrollView.this.isL) {
                        EmotionTabHorizonScrollView.this.isK.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.isK.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.isK = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.isG.sx(this.mTabIndex);
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
        TbImageView isN;
        View isO;
        com.baidu.tbadk.editortools.emotiontool.c isP;

        private a() {
        }
    }
}
