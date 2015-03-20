package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private int aiA;
    private LinearLayout aiB;
    private ImageView aiC;
    private TextView aiD;
    private LinearLayout.LayoutParams aiE;
    private boolean aiF;
    private View aiG;
    private TbImageView aiH;
    private boolean aiI;
    private int aiq;
    private c aiw;
    private ArrayList<ad> aix;
    private s aiy;
    private int aiz;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.aiF = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.aiF = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.aiF = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aiw = new c(getContext());
        this.aiw.setOrientation(0);
        this.aiw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aiw.setBaselineAligned(false);
        addView(this.aiw);
        this.aiz = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_tb_padding);
        this.aiA = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_lr_padding);
        this.aiE = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.ds122), -1);
        this.aiw.setPadding(0, 0, 0, 0);
        yy();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aiI = z;
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.aix = arrayList;
    }

    private TbImageView b(ad adVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ba.c(linearLayout, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, this.aiq);
        p pVar = new p(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aiI) {
            tbImageView.setForegroundColor(ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        pVar.aiK = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aiA, this.aiz, this.aiA, this.aiz);
        View view = new View(getContext());
        pVar.aiL = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.ds2);
        if (!this.aiI) {
            view.setBackgroundColor(ba.getColor(com.baidu.tieba.s.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(com.baidu.tieba.s.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(pVar);
        this.aiw.addView(linearLayout, this.aiw.getChildCount() - 1, this.aiE);
        EmotionGroupType yI = adVar.yI();
        if (yI == EmotionGroupType.LOCAL) {
            if (adVar.zd() != null) {
                adVar.zd().a(tbImageView);
            }
            tbImageView.setOnClickListener(new n(this, this.aiw.getChildCount() - 3, null));
        } else if (yI == EmotionGroupType.PROMOTION) {
            if (adVar.ze() != null) {
                adVar.ze().a(tbImageView);
            }
            tbImageView.setOnClickListener(new o(this, adVar.getGroupId(), null));
        } else if (yI == EmotionGroupType.BIG_EMOTION) {
            if (this.aiF) {
                if (adVar.zd() != null) {
                    adVar.zd().a(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this, this.aiw.getChildCount() - 3, null));
            } else {
                if (adVar.ze() != null) {
                    adVar.ze().a(tbImageView);
                }
                tbImageView.setOnClickListener(new k(this));
            }
        }
        if (this.aiH == null) {
            this.aiH = tbImageView;
            this.aiH.setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
        }
        return tbImageView;
    }

    public void yy() {
        this.aiC = new ImageView(getContext());
        this.aiC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aiC.setPadding(this.aiA, this.aiz, this.aiA, this.aiz);
        this.aiB = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aiC.setLayoutParams(layoutParams);
        ba.a(this.aiC, com.baidu.tieba.u.icon_store, this.aiq);
        this.aiB.addView(this.aiC);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ba.d(view, com.baidu.tieba.s.emotion_tab_div_line_color, this.aiq);
        this.aiB.addView(view);
        this.aiD = new TextView(getContext());
        this.aiD.setGravity(17);
        this.aiD.setTextSize(10.0f);
        this.aiD.setText("N");
        this.aiD.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aiw.addView(this.aiB, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1));
        this.aiw.setNewView(this.aiD);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2902010);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aiw.setNewViewVisible(true);
        } else {
            this.aiw.setNewViewVisible(false);
        }
        this.aiB.setOnClickListener(new l(this));
        this.aiG = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aiG.setLayoutParams(layoutParams3);
        this.aiw.addView(this.aiG);
        if (!appResponseToCmd) {
            this.aiB.setVisibility(8);
        }
    }

    public void c(ad adVar) {
        b(adVar);
    }

    public void f(int i, boolean z) {
        this.aiF = z;
        int i2 = i + 1;
        int childCount = this.aiw.getChildCount();
        ad adVar = this.aix.get(i2 - 1);
        if (i2 < childCount && adVar.yI() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aiw.getChildAt(i2)).getChildAt(0);
            if (!this.aiF) {
                tbImageView.setOnClickListener(new m(this));
                if (adVar.ze() != null) {
                    adVar.ze().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new n(this, i2 - 1, null));
            if (adVar.zd() != null) {
                adVar.zd().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aiw.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aiq == 0) {
                        color = getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    } else {
                        color = ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aiw.getChildAt(this.mCurrentIndex + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(com.baidu.tieba.v.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            ad adVar = this.aix.get(this.mCurrentIndex);
            if (adVar.zd() != null) {
                adVar.zd().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
                this.aiH = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.aiw.removeAllViews();
        yy();
    }

    public void cu(int i) {
        int color;
        this.aiq = i;
        if (this.aiC != null) {
            ba.a(this.aiC, com.baidu.tieba.u.icon_store, i);
        }
        if (this.aiB != null) {
            ba.c(this.aiB, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, i);
            if (this.aiB.getChildCount() > 0) {
                ba.d(this.aiB.getChildAt(1), com.baidu.tieba.s.emotion_tab_div_line_color, i);
            }
        }
        if (this.aiG != null) {
            ba.c(this.aiG, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aiD != null) {
            ba.c(this.aiD, com.baidu.tieba.u.icon_news_head_prompt_one, i);
            ba.a(this.aiD, com.baidu.tieba.s.cp_cont_i, 1, i);
        }
        int childCount = this.aiw.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aiw.getChildAt(i2);
            if (childAt != null) {
                ba.c(childAt, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, i);
            }
            p pVar = (p) childAt.getTag();
            if (pVar != null) {
                if (pVar.aiK != null) {
                    if (i == 0) {
                        color = getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    } else {
                        color = ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    }
                    pVar.aiK.setForegroundColor(color);
                }
                if (pVar.aiL != null) {
                    ba.d(pVar.aiL, com.baidu.tieba.s.emotion_tab_div_line_color, i);
                }
            }
        }
        if (this.aiH != null) {
            this.aiH.setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
            if (this.aiH.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aiH.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(s sVar) {
        this.aiy = sVar;
    }
}
