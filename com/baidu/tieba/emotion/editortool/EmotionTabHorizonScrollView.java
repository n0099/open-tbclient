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
/* loaded from: classes8.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools acZ;
    private int akW;
    private int bMx;
    private LinearLayout.LayoutParams eua;
    private int fHp;
    private int fHq;
    private TextView fHr;
    private View fHs;
    private int from;
    private EmotionLinearLayout iER;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iES;
    private EmotionTabWidgetView.a iET;
    private LinearLayout iEU;
    private ImageView iEV;
    private boolean iEW;
    private TbImageView iEX;
    private boolean iEY;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMx = -1;
        this.iEW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMx = -1;
        this.iEW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bMx = -1;
        this.iEW = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.iER = new EmotionLinearLayout(getContext());
        this.iER.setOrientation(0);
        this.iER.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iER.setBaselineAligned(false);
        addView(this.iER);
        this.fHp = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fHq = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eua = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.iER.setPadding(0, 0, 0, 0);
        cxj();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.iEY = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iES = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.iFc = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.iFa = tbImageView;
        if (cVar.bFd() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fHq, this.fHp, this.fHq, this.fHp);
            ImageView imageView = new ImageView(getContext());
            ao.setImageResource(imageView, R.drawable.icon_emotion_recommend);
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
            this.iER.addView(relativeLayout, this.iER.getChildCount() - 1, this.eua);
            if (cVar.bFf() != null) {
                cVar.bFf().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.iEY && (this.akW == 1 || this.akW == 4)) {
                view.setBackgroundColor(ao.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ao.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iEX == null) {
                this.iEX = tbImageView;
                this.iEX.setForegroundColor(ao.getColor(R.color.common_color_10022));
            }
            ao.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.akW);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fHq, this.fHp, this.fHq, this.fHp);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.iER.addView(linearLayout, this.iER.getChildCount() - 1, this.eua);
            EmotionGroupType bFd = cVar.bFd();
            if (bFd == EmotionGroupType.LOCAL) {
                if (cVar.bFe() != null) {
                    cVar.bFe().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iER.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bFd == EmotionGroupType.PROMOTION) {
                if (cVar.bFf() != null) {
                    cVar.bFf().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bFd == EmotionGroupType.BIG_EMOTION) {
                if (this.iEW) {
                    if (cVar.bFe() != null) {
                        cVar.bFe().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.iER.getChildCount() - 3));
                } else {
                    if (cVar.bFf() != null) {
                        cVar.bFf().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bue();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bFd == EmotionGroupType.USER_COLLECT) {
                if (cVar.bFf() != null) {
                    cVar.bFf().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iER.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bFd == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bFf() != null) {
                    cVar.bFf().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.iEY && (this.akW == 1 || this.akW == 4)) {
                view2.setBackgroundColor(ao.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ao.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iEX == null) {
                this.iEX = tbImageView;
                this.iEX.setForegroundColor(ao.getColor(R.color.common_color_10022));
            }
            ao.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.akW);
        }
        return tbImageView;
    }

    public void cxj() {
        this.iEV = new ImageView(getContext());
        this.iEV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iEV.setPadding(this.fHq, this.fHp, this.fHq, this.fHp);
        this.iEU = new LinearLayout(getContext());
        this.iEU.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.iEV.setLayoutParams(layoutParams);
        ao.setImageResource(this.iEV, R.drawable.face_store, this.akW);
        this.iEU.addView(this.iEV);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ao.setBackgroundColor(view, R.color.common_color_10288, this.akW);
        this.fHr = new TextView(getContext());
        this.fHr.setGravity(17);
        this.fHr.setTextSize(10.0f);
        this.fHr.setText("N");
        this.fHr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.iER.addView(this.iEU, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.iER.setNewView(this.fHr);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.iER.setNewViewVisible(true);
        } else {
            this.iER.setNewViewVisible(false);
        }
        this.iEU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fHr != null) {
                    EmotionTabHorizonScrollView.this.iER.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.acZ != null) {
                    EmotionTabHorizonScrollView.this.acZ.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fHs = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fHs.setLayoutParams(layoutParams3);
        this.iER.addView(this.fHs);
        if (!appResponseToIntentClass) {
            this.iEU.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iEW = z;
        int i2 = i + 1;
        int childCount = this.iER.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.iES.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bFd() == EmotionGroupType.BIG_EMOTION || cVar.bFd() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.iER.getChildAt(i2)).getChildAt(0);
                if (!this.iEW) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bue();
                        }
                    });
                    if (cVar.bFf() != null) {
                        cVar.bFf().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bFe() != null) {
                    cVar.bFe().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.iER.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iER.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).iFc;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.iEU.setVisibility(8);
        } else {
            this.iEU.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bFd() == EmotionGroupType.BIG_EMOTION || cVar.bFd() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bMx) {
            if (this.bMx != -1) {
                LinearLayout linearLayout = (LinearLayout) this.iER.getChildAt(this.bMx + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.akW == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ao.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bMx = i;
            LinearLayout linearLayout2 = (LinearLayout) this.iER.getChildAt(this.bMx + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iES.get(this.bMx);
            if (cVar.bFe() != null) {
                cVar.bFe().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ao.getColor(R.color.common_color_10022));
                this.iEX = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bMx = -1;
        this.iER.removeAllViews();
        cxj();
        onChangeSkin(this.akW);
    }

    public void onChangeSkin(int i) {
        int color;
        this.akW = i;
        if (this.iEV != null) {
            ao.setImageResource(this.iEV, R.drawable.face_store, i);
        }
        if (this.iEU != null) {
            ao.setBackgroundResource(this.iEU, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.iEU.getChildCount() > 0) {
                ao.setBackgroundColor(this.iEU.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fHs != null) {
            ao.setBackgroundResource(this.fHs, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fHr != null) {
            ao.setBackgroundResource(this.fHr, R.drawable.icon_news_head_prompt_one, i);
            ao.setViewTextColor(this.fHr, R.color.CAM_X0101, 1, i);
        }
        int childCount = this.iER.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.iER.getChildAt(i2);
            if (childAt != null) {
                ao.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.iFa != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ao.getColor(R.color.common_color_10287);
                        }
                        aVar.iFa.setForegroundColor(color);
                    }
                    if (aVar.iFb != null) {
                        ao.setBackgroundColor(aVar.iFb, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.iEX != null) {
            this.iEX.setForegroundColor(ao.getColor(R.color.common_color_10022));
            if (this.iEX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iEX.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.iET = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
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
            if (!EmotionTabHorizonScrollView.this.acZ.sv(5).bEZ() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iES.get(this.mTabIndex)).bFd() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iES.get(this.mTabIndex)).bFd() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.iEX) {
                ((TbImageView) view).setForegroundColor(ao.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.iEX != null) {
                    if (!EmotionTabHorizonScrollView.this.iEY) {
                        EmotionTabHorizonScrollView.this.iEX.setForegroundColor(ao.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.iEX.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.iEX = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.iET.sJ(this.mTabIndex);
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
        TbImageView iFa;
        View iFb;
        com.baidu.tbadk.editortools.emotiontool.c iFc;

        private a() {
        }
    }
}
