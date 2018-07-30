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
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Qg;
    private int aOY;
    private LinearLayout.LayoutParams aPa;
    private int aPb;
    private int aPc;
    private TextView aPd;
    private View aPe;
    private int azI;
    private EmotionLinearLayout cQQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cQR;
    private EmotionTabWidgetView.a cQS;
    private LinearLayout cQT;
    private ImageView cQU;
    private boolean cQV;
    private TbImageView cQW;
    private boolean cQX;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOY = -1;
        this.cQV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOY = -1;
        this.cQV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aOY = -1;
        this.cQV = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cQQ = new EmotionLinearLayout(getContext());
        this.cQQ.setOrientation(0);
        this.cQQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cQQ.setBaselineAligned(false);
        addView(this.cQQ);
        this.aPb = getResources().getDimensionPixelSize(d.e.ds8);
        this.aPc = getResources().getDimensionPixelSize(d.e.ds10);
        this.aPa = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.cQQ.setPadding(0, 0, 0, 0);
        aoa();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cQX = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cQR = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cRb = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cQZ = tbImageView;
        if (cVar.HI() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aPc, this.aPb, this.aPc, this.aPb);
            ImageView imageView = new ImageView(getContext());
            am.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.e.ds12), l.f(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cRa = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cQQ.addView(relativeLayout, this.cQQ.getChildCount() - 1, this.aPa);
            if (cVar.HK() != null) {
                cVar.HK().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cQX && this.azI == 1) {
                view.setBackgroundColor(am.getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(d.C0140d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0140d.common_color_10287));
            }
            if (this.cQW == null) {
                this.cQW = tbImageView;
                this.cQW.setForegroundColor(am.getColor(d.C0140d.common_color_10022));
            }
            am.d(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.azI);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aPc, this.aPb, this.aPc, this.aPb);
            View view2 = new View(getContext());
            aVar.cRa = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cQQ.addView(linearLayout, this.cQQ.getChildCount() - 1, this.aPa);
            EmotionGroupType HI = cVar.HI();
            if (HI == EmotionGroupType.LOCAL) {
                if (cVar.HJ() != null) {
                    cVar.HJ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cQQ.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (HI == EmotionGroupType.PROMOTION) {
                if (cVar.HK() != null) {
                    cVar.HK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (HI == EmotionGroupType.BIG_EMOTION) {
                if (this.cQV) {
                    if (cVar.HJ() != null) {
                        cVar.HJ().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cQQ.getChildCount() - 3));
                } else {
                    if (cVar.HK() != null) {
                        cVar.HK().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).xn();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (HI == EmotionGroupType.USER_COLLECT) {
                if (cVar.HK() != null) {
                    cVar.HK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cQQ.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (HI == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.HK() != null) {
                    cVar.HK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cQX && this.azI == 1) {
                view2.setBackgroundColor(am.getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(d.C0140d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0140d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0140d.common_color_10287));
            }
            if (this.cQW == null) {
                this.cQW = tbImageView;
                this.cQW.setForegroundColor(am.getColor(d.C0140d.common_color_10022));
            }
            am.d(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.azI);
        }
        return tbImageView;
    }

    public void aoa() {
        this.cQU = new ImageView(getContext());
        this.cQU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cQU.setPadding(this.aPc, this.aPb, this.aPc, this.aPb);
        this.cQT = new LinearLayout(getContext());
        this.cQT.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cQU.setLayoutParams(layoutParams);
        am.b(this.cQU, d.f.face_store, this.azI);
        this.cQT.addView(this.cQU);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.e(view, d.C0140d.common_color_10288, this.azI);
        this.cQT.addView(view);
        this.aPd = new TextView(getContext());
        this.aPd.setGravity(17);
        this.aPd.setTextSize(10.0f);
        this.aPd.setText("N");
        this.aPd.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cQQ.addView(this.cQT, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.cQQ.setNewView(this.aPd);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cQQ.setNewViewVisible(true);
        } else {
            this.cQQ.setNewViewVisible(false);
        }
        this.cQT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aPd != null) {
                    EmotionTabHorizonScrollView.this.cQQ.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Qg != null) {
                    EmotionTabHorizonScrollView.this.Qg.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.jE()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.aPe = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aPe.setLayoutParams(layoutParams3);
        this.cQQ.addView(this.aPe);
        if (!appResponseToIntentClass) {
            this.cQT.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cQV = z;
        int i2 = i + 1;
        int childCount = this.cQQ.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQR.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.HI() == EmotionGroupType.BIG_EMOTION || cVar.HI() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cQQ.getChildAt(i2)).getChildAt(0);
                if (!this.cQV) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).xn();
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
        int childCount = this.cQQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cQQ.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cRb;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cQT.setVisibility(8);
        } else {
            this.cQT.setVisibility(0);
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
        if (i != this.aOY) {
            if (this.aOY != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cQQ.getChildAt(this.aOY + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.azI == 0) {
                        color = getResources().getColor(d.C0140d.common_color_10287);
                    } else {
                        color = am.getColor(d.C0140d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aOY = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cQQ.getChildAt(this.aOY + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQR.get(this.aOY);
            if (cVar.HJ() != null) {
                cVar.HJ().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(d.C0140d.common_color_10022));
                this.cQW = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aOY = -1;
        this.cQQ.removeAllViews();
        aoa();
        dG(this.azI);
    }

    public void dG(int i) {
        int color;
        this.azI = i;
        if (this.cQU != null) {
            am.b(this.cQU, d.f.face_store, i);
        }
        if (this.cQT != null) {
            am.d(this.cQT, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.cQT.getChildCount() > 0) {
                am.e(this.cQT.getChildAt(1), d.C0140d.common_color_10288, i);
            }
        }
        if (this.aPe != null) {
            am.d(this.aPe, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aPd != null) {
            am.d(this.aPd, d.f.icon_news_head_prompt_one, i);
            am.b(this.aPd, d.C0140d.cp_cont_i, 1, i);
        }
        int childCount = this.cQQ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cQQ.getChildAt(i2);
            if (childAt != null) {
                am.d(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cQZ != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0140d.common_color_10287);
                        } else {
                            color = am.getColor(d.C0140d.common_color_10287);
                        }
                        aVar.cQZ.setForegroundColor(color);
                    }
                    if (aVar.cRa != null) {
                        am.e(aVar.cRa, d.C0140d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cQW != null) {
            this.cQW.setForegroundColor(am.getColor(d.C0140d.common_color_10022));
            if (this.cQW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cQW.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cQS = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aoi;

        private b(int i) {
            this.aoi = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cQW) {
                ((TbImageView) view).setForegroundColor(am.getColor(d.C0140d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cQW != null) {
                    if (!EmotionTabHorizonScrollView.this.cQX) {
                        EmotionTabHorizonScrollView.this.cQW.setForegroundColor(am.getColor(d.C0140d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cQW.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0140d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cQW = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aoi);
            EmotionTabHorizonScrollView.this.cQS.eZ(this.aoi);
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
        TbImageView cQZ;
        View cRa;
        com.baidu.tbadk.editortools.emotiontool.c cRb;

        private a() {
        }
    }
}
