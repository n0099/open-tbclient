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
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Qg;
    private int aOV;
    private LinearLayout.LayoutParams aOX;
    private int aOY;
    private int aOZ;
    private TextView aPa;
    private View aPb;
    private int azF;
    private EmotionLinearLayout cQN;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cQO;
    private EmotionTabWidgetView.a cQP;
    private LinearLayout cQQ;
    private ImageView cQR;
    private boolean cQS;
    private TbImageView cQT;
    private boolean cQU;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOV = -1;
        this.cQS = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOV = -1;
        this.cQS = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aOV = -1;
        this.cQS = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cQN = new EmotionLinearLayout(getContext());
        this.cQN.setOrientation(0);
        this.cQN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cQN.setBaselineAligned(false);
        addView(this.cQN);
        this.aOY = getResources().getDimensionPixelSize(f.e.ds8);
        this.aOZ = getResources().getDimensionPixelSize(f.e.ds10);
        this.aOX = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(f.e.ds122), -1);
        this.cQN.setPadding(0, 0, 0, 0);
        aoa();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cQU = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cQO = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cQY = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cQW = tbImageView;
        if (cVar.HI() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aOZ, this.aOY, this.aOZ, this.aOY);
            ImageView imageView = new ImageView(getContext());
            am.c(imageView, f.C0146f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), f.e.ds12), l.f(getContext(), f.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cQX = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(f.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cQN.addView(relativeLayout, this.cQN.getChildCount() - 1, this.aOX);
            if (cVar.HK() != null) {
                cVar.HK().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(f.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cQU && this.azF == 1) {
                view.setBackgroundColor(am.getColor(f.d.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(f.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(f.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(f.d.common_color_10287));
            }
            if (this.cQT == null) {
                this.cQT = tbImageView;
                this.cQT.setForegroundColor(am.getColor(f.d.common_color_10022));
            }
            am.d(relativeLayout, f.C0146f.bg_emotion_tab_horizonscrollview, this.azF);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aOZ, this.aOY, this.aOZ, this.aOY);
            View view2 = new View(getContext());
            aVar.cQX = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(f.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cQN.addView(linearLayout, this.cQN.getChildCount() - 1, this.aOX);
            EmotionGroupType HI = cVar.HI();
            if (HI == EmotionGroupType.LOCAL) {
                if (cVar.HJ() != null) {
                    cVar.HJ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cQN.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(f.j.local_emotion));
            } else if (HI == EmotionGroupType.PROMOTION) {
                if (cVar.HK() != null) {
                    cVar.HK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(f.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (HI == EmotionGroupType.BIG_EMOTION) {
                if (this.cQS) {
                    if (cVar.HJ() != null) {
                        cVar.HJ().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cQN.getChildCount() - 3));
                } else {
                    if (cVar.HK() != null) {
                        cVar.HK().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(f.j.emotion_cant_show)).xm();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (HI == EmotionGroupType.USER_COLLECT) {
                if (cVar.HK() != null) {
                    cVar.HK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cQN.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (HI == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.HK() != null) {
                    cVar.HK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(f.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cQU && this.azF == 1) {
                view2.setBackgroundColor(am.getColor(f.d.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(f.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(f.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(f.d.common_color_10287));
            }
            if (this.cQT == null) {
                this.cQT = tbImageView;
                this.cQT.setForegroundColor(am.getColor(f.d.common_color_10022));
            }
            am.d(linearLayout, f.C0146f.bg_emotion_tab_horizonscrollview, this.azF);
        }
        return tbImageView;
    }

    public void aoa() {
        this.cQR = new ImageView(getContext());
        this.cQR.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cQR.setPadding(this.aOZ, this.aOY, this.aOZ, this.aOY);
        this.cQQ = new LinearLayout(getContext());
        this.cQQ.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(f.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cQR.setLayoutParams(layoutParams);
        am.b(this.cQR, f.C0146f.face_store, this.azF);
        this.cQQ.addView(this.cQR);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(f.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.e(view, f.d.common_color_10288, this.azF);
        this.cQQ.addView(view);
        this.aPa = new TextView(getContext());
        this.aPa.setGravity(17);
        this.aPa.setTextSize(10.0f);
        this.aPa.setText("N");
        this.aPa.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cQN.addView(this.cQQ, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(f.e.ds106), -1));
        this.cQN.setNewView(this.aPa);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cQN.setNewViewVisible(true);
        } else {
            this.cQN.setNewViewVisible(false);
        }
        this.cQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aPa != null) {
                    EmotionTabHorizonScrollView.this.cQN.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Qg != null) {
                    EmotionTabHorizonScrollView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.jE()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), f.j.neterror);
                }
            }
        });
        this.aPb = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aPb.setLayoutParams(layoutParams3);
        this.cQN.addView(this.aPb);
        if (!appResponseToIntentClass) {
            this.cQQ.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cQS = z;
        int i2 = i + 1;
        int childCount = this.cQN.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQO.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.HI() == EmotionGroupType.BIG_EMOTION || cVar.HI() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cQN.getChildAt(i2)).getChildAt(0);
                if (!this.cQS) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(f.j.emotion_cant_show)).xm();
                        }
                    });
                    if (cVar.HK() != null) {
                        cVar.HK().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.HJ() != null) {
                    cVar.HJ().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cQN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cQN.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cQY;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cQQ.setVisibility(8);
        } else {
            this.cQQ.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.HI() == EmotionGroupType.BIG_EMOTION || cVar.HI() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aOV) {
            if (this.aOV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cQN.getChildAt(this.aOV + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.azF == 0) {
                        color = getResources().getColor(f.d.common_color_10287);
                    } else {
                        color = am.getColor(f.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aOV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cQN.getChildAt(this.aOV + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(f.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQO.get(this.aOV);
            if (cVar.HJ() != null) {
                cVar.HJ().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(f.d.common_color_10022));
                this.cQT = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aOV = -1;
        this.cQN.removeAllViews();
        aoa();
        dF(this.azF);
    }

    public void dF(int i) {
        int color;
        this.azF = i;
        if (this.cQR != null) {
            am.b(this.cQR, f.C0146f.face_store, i);
        }
        if (this.cQQ != null) {
            am.d(this.cQQ, f.C0146f.bg_emotion_tab_horizonscrollview, i);
            if (this.cQQ.getChildCount() > 0) {
                am.e(this.cQQ.getChildAt(1), f.d.common_color_10288, i);
            }
        }
        if (this.aPb != null) {
            am.d(this.aPb, f.C0146f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aPa != null) {
            am.d(this.aPa, f.C0146f.icon_news_head_prompt_one, i);
            am.b(this.aPa, f.d.cp_cont_i, 1, i);
        }
        int childCount = this.cQN.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cQN.getChildAt(i2);
            if (childAt != null) {
                am.d(childAt, f.C0146f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cQW != null) {
                        if (i == 0) {
                            color = getResources().getColor(f.d.common_color_10287);
                        } else {
                            color = am.getColor(f.d.common_color_10287);
                        }
                        aVar.cQW.setForegroundColor(color);
                    }
                    if (aVar.cQX != null) {
                        am.e(aVar.cQX, f.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cQT != null) {
            this.cQT.setForegroundColor(am.getColor(f.d.common_color_10022));
            if (this.cQT.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cQT.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cQP = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aoj;

        private b(int i) {
            this.aoj = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cQT) {
                ((TbImageView) view).setForegroundColor(am.getColor(f.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cQT != null) {
                    if (!EmotionTabHorizonScrollView.this.cQU) {
                        EmotionTabHorizonScrollView.this.cQT.setForegroundColor(am.getColor(f.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cQT.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(f.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cQT = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aoj);
            EmotionTabHorizonScrollView.this.cQP.eY(this.aoj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.g(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView cQW;
        View cQX;
        com.baidu.tbadk.editortools.emotiontool.c cQY;

        private a() {
        }
    }
}
