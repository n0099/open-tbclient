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
/* loaded from: classes7.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools ael;
    private int aln;
    private int bMV;
    private LinearLayout.LayoutParams esU;
    private int fGt;
    private int fGu;
    private TextView fGv;
    private View fGw;
    private int from;
    private EmotionLinearLayout iHR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iHS;
    private EmotionTabWidgetView.a iHT;
    private LinearLayout iHU;
    private ImageView iHV;
    private boolean iHW;
    private TbImageView iHX;
    private boolean iHY;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMV = -1;
        this.iHW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMV = -1;
        this.iHW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bMV = -1;
        this.iHW = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.iHR = new EmotionLinearLayout(getContext());
        this.iHR.setOrientation(0);
        this.iHR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iHR.setBaselineAligned(false);
        addView(this.iHR);
        this.fGt = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fGu = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.esU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.iHR.setPadding(0, 0, 0, 0);
        cuQ();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.iHY = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iHS = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.iIc = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.iIa = tbImageView;
        if (cVar.bBE() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fGu, this.fGt, this.fGu, this.fGt);
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
            this.iHR.addView(relativeLayout, this.iHR.getChildCount() - 1, this.esU);
            if (cVar.bBG() != null) {
                cVar.bBG().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.iHY && (this.aln == 1 || this.aln == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iHX == null) {
                this.iHX = tbImageView;
                this.iHX.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aln);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fGu, this.fGt, this.fGu, this.fGt);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.iHR.addView(linearLayout, this.iHR.getChildCount() - 1, this.esU);
            EmotionGroupType bBE = cVar.bBE();
            if (bBE == EmotionGroupType.LOCAL) {
                if (cVar.bBF() != null) {
                    cVar.bBF().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iHR.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bBE == EmotionGroupType.PROMOTION) {
                if (cVar.bBG() != null) {
                    cVar.bBG().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bBE == EmotionGroupType.BIG_EMOTION) {
                if (this.iHW) {
                    if (cVar.bBF() != null) {
                        cVar.bBF().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.iHR.getChildCount() - 3));
                } else {
                    if (cVar.bBG() != null) {
                        cVar.bBG().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bqF();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bBE == EmotionGroupType.USER_COLLECT) {
                if (cVar.bBG() != null) {
                    cVar.bBG().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iHR.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bBE == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bBG() != null) {
                    cVar.bBG().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.iHY && (this.aln == 1 || this.aln == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iHX == null) {
                this.iHX = tbImageView;
                this.iHX.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.aln);
        }
        return tbImageView;
    }

    public void cuQ() {
        this.iHV = new ImageView(getContext());
        this.iHV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iHV.setPadding(this.fGu, this.fGt, this.fGu, this.fGt);
        this.iHU = new LinearLayout(getContext());
        this.iHU.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.iHV.setLayoutParams(layoutParams);
        ap.setImageResource(this.iHV, R.drawable.face_store, this.aln);
        this.iHU.addView(this.iHV);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.aln);
        this.fGv = new TextView(getContext());
        this.fGv.setGravity(17);
        this.fGv.setTextSize(10.0f);
        this.fGv.setText("N");
        this.fGv.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.iHR.addView(this.iHU, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.iHR.setNewView(this.fGv);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.iHR.setNewViewVisible(true);
        } else {
            this.iHR.setNewViewVisible(false);
        }
        this.iHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fGv != null) {
                    EmotionTabHorizonScrollView.this.iHR.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.ael != null) {
                    EmotionTabHorizonScrollView.this.ael.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fGw = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fGw.setLayoutParams(layoutParams3);
        this.iHR.addView(this.fGw);
        if (!appResponseToIntentClass) {
            this.iHU.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iHW = z;
        int i2 = i + 1;
        int childCount = this.iHR.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.iHS.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bBE() == EmotionGroupType.BIG_EMOTION || cVar.bBE() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.iHR.getChildAt(i2)).getChildAt(0);
                if (!this.iHW) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bqF();
                        }
                    });
                    if (cVar.bBG() != null) {
                        cVar.bBG().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bBF() != null) {
                    cVar.bBF().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.iHR.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iHR.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).iIc;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.iHU.setVisibility(8);
        } else {
            this.iHU.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bBE() == EmotionGroupType.BIG_EMOTION || cVar.bBE() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bMV) {
            if (this.bMV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.iHR.getChildAt(this.bMV + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aln == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bMV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.iHR.getChildAt(this.bMV + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iHS.get(this.bMV);
            if (cVar.bBF() != null) {
                cVar.bBF().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.iHX = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bMV = -1;
        this.iHR.removeAllViews();
        cuQ();
        onChangeSkin(this.aln);
    }

    public void onChangeSkin(int i) {
        int color;
        this.aln = i;
        if (this.iHV != null) {
            ap.setImageResource(this.iHV, R.drawable.face_store, i);
        }
        if (this.iHU != null) {
            ap.setBackgroundResource(this.iHU, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.iHU.getChildCount() > 0) {
                ap.setBackgroundColor(this.iHU.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fGw != null) {
            ap.setBackgroundResource(this.fGw, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fGv != null) {
            ap.setBackgroundResource(this.fGv, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.fGv, R.color.CAM_X0101, 1, i);
        }
        int childCount = this.iHR.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.iHR.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.iIa != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.iIa.setForegroundColor(color);
                    }
                    if (aVar.iIb != null) {
                        ap.setBackgroundColor(aVar.iIb, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.iHX != null) {
            this.iHX.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.iHX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iHX.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.iHT = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!EmotionTabHorizonScrollView.this.ael.qV(5).bBA() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iHS.get(this.mTabIndex)).bBE() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iHS.get(this.mTabIndex)).bBE() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.iHX) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.iHX != null) {
                    if (!EmotionTabHorizonScrollView.this.iHY) {
                        EmotionTabHorizonScrollView.this.iHX.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.iHX.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.iHX = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.iHT.rj(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static class a {
        TbImageView iIa;
        View iIb;
        com.baidu.tbadk.editortools.emotiontool.c iIc;

        private a() {
        }
    }
}
