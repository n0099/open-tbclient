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
/* loaded from: classes8.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools acR;
    private int ajU;
    private int bLv;
    private LinearLayout.LayoutParams ert;
    private int fEU;
    private int fEV;
    private TextView fEW;
    private View fEX;
    private int from;
    private EmotionLinearLayout iFU;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iFV;
    private EmotionTabWidgetView.a iFW;
    private LinearLayout iFX;
    private ImageView iFY;
    private boolean iFZ;
    private TbImageView iGa;
    private boolean iGb;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLv = -1;
        this.iFZ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLv = -1;
        this.iFZ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bLv = -1;
        this.iFZ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.iFU = new EmotionLinearLayout(getContext());
        this.iFU.setOrientation(0);
        this.iFU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iFU.setBaselineAligned(false);
        addView(this.iFU);
        this.fEU = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fEV = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ert = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.iFU.setPadding(0, 0, 0, 0);
        cuD();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.iGb = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iFV = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.iGf = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.iGd = tbImageView;
        if (cVar.bBB() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fEV, this.fEU, this.fEV, this.fEU);
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
            this.iFU.addView(relativeLayout, this.iFU.getChildCount() - 1, this.ert);
            if (cVar.bBD() != null) {
                cVar.bBD().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.iGb && (this.ajU == 1 || this.ajU == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iGa == null) {
                this.iGa = tbImageView;
                this.iGa.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajU);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fEV, this.fEU, this.fEV, this.fEU);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.iFU.addView(linearLayout, this.iFU.getChildCount() - 1, this.ert);
            EmotionGroupType bBB = cVar.bBB();
            if (bBB == EmotionGroupType.LOCAL) {
                if (cVar.bBC() != null) {
                    cVar.bBC().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iFU.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bBB == EmotionGroupType.PROMOTION) {
                if (cVar.bBD() != null) {
                    cVar.bBD().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bBB == EmotionGroupType.BIG_EMOTION) {
                if (this.iFZ) {
                    if (cVar.bBC() != null) {
                        cVar.bBC().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.iFU.getChildCount() - 3));
                } else {
                    if (cVar.bBD() != null) {
                        cVar.bBD().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bqD();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bBB == EmotionGroupType.USER_COLLECT) {
                if (cVar.bBD() != null) {
                    cVar.bBD().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iFU.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bBB == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bBD() != null) {
                    cVar.bBD().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.iGb && (this.ajU == 1 || this.ajU == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iGa == null) {
                this.iGa = tbImageView;
                this.iGa.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajU);
        }
        return tbImageView;
    }

    public void cuD() {
        this.iFY = new ImageView(getContext());
        this.iFY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iFY.setPadding(this.fEV, this.fEU, this.fEV, this.fEU);
        this.iFX = new LinearLayout(getContext());
        this.iFX.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.iFY.setLayoutParams(layoutParams);
        ap.setImageResource(this.iFY, R.drawable.face_store, this.ajU);
        this.iFX.addView(this.iFY);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.ajU);
        this.fEW = new TextView(getContext());
        this.fEW.setGravity(17);
        this.fEW.setTextSize(10.0f);
        this.fEW.setText("N");
        this.fEW.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.iFU.addView(this.iFX, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.iFU.setNewView(this.fEW);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.iFU.setNewViewVisible(true);
        } else {
            this.iFU.setNewViewVisible(false);
        }
        this.iFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fEW != null) {
                    EmotionTabHorizonScrollView.this.iFU.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.acR != null) {
                    EmotionTabHorizonScrollView.this.acR.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fEX = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fEX.setLayoutParams(layoutParams3);
        this.iFU.addView(this.fEX);
        if (!appResponseToIntentClass) {
            this.iFX.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iFZ = z;
        int i2 = i + 1;
        int childCount = this.iFU.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.iFV.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bBB() == EmotionGroupType.BIG_EMOTION || cVar.bBB() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.iFU.getChildAt(i2)).getChildAt(0);
                if (!this.iFZ) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bqD();
                        }
                    });
                    if (cVar.bBD() != null) {
                        cVar.bBD().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bBC() != null) {
                    cVar.bBC().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.iFU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iFU.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).iGf;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.iFX.setVisibility(8);
        } else {
            this.iFX.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bBB() == EmotionGroupType.BIG_EMOTION || cVar.bBB() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bLv) {
            if (this.bLv != -1) {
                LinearLayout linearLayout = (LinearLayout) this.iFU.getChildAt(this.bLv + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ajU == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bLv = i;
            LinearLayout linearLayout2 = (LinearLayout) this.iFU.getChildAt(this.bLv + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iFV.get(this.bLv);
            if (cVar.bBC() != null) {
                cVar.bBC().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.iGa = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bLv = -1;
        this.iFU.removeAllViews();
        cuD();
        onChangeSkin(this.ajU);
    }

    public void onChangeSkin(int i) {
        int color;
        this.ajU = i;
        if (this.iFY != null) {
            ap.setImageResource(this.iFY, R.drawable.face_store, i);
        }
        if (this.iFX != null) {
            ap.setBackgroundResource(this.iFX, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.iFX.getChildCount() > 0) {
                ap.setBackgroundColor(this.iFX.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fEX != null) {
            ap.setBackgroundResource(this.fEX, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fEW != null) {
            ap.setBackgroundResource(this.fEW, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.fEW, R.color.CAM_X0101, 1, i);
        }
        int childCount = this.iFU.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.iFU.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.iGd != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.iGd.setForegroundColor(color);
                    }
                    if (aVar.iGe != null) {
                        ap.setBackgroundColor(aVar.iGe, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.iGa != null) {
            this.iGa.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.iGa.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iGa.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.iFW = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!EmotionTabHorizonScrollView.this.acR.qU(5).bBx() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iFV.get(this.mTabIndex)).bBB() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iFV.get(this.mTabIndex)).bBB() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.iGa) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.iGa != null) {
                    if (!EmotionTabHorizonScrollView.this.iGb) {
                        EmotionTabHorizonScrollView.this.iGa.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.iGa.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.iGa = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.iFW.ri(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public static class a {
        TbImageView iGd;
        View iGe;
        com.baidu.tbadk.editortools.emotiontool.c iGf;

        private a() {
        }
    }
}
