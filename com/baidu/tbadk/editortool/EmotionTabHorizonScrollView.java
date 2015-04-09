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
    private c aiE;
    private ArrayList<ad> aiF;
    private s aiG;
    private int aiH;
    private int aiI;
    private LinearLayout aiJ;
    private ImageView aiK;
    private TextView aiL;
    private LinearLayout.LayoutParams aiM;
    private boolean aiN;
    private View aiO;
    private TbImageView aiP;
    private boolean aiQ;
    private int aiy;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.aiN = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.aiN = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.aiN = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aiE = new c(getContext());
        this.aiE.setOrientation(0);
        this.aiE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aiE.setBaselineAligned(false);
        addView(this.aiE);
        this.aiH = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_tb_padding);
        this.aiI = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_lr_padding);
        this.aiM = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.ds122), -1);
        this.aiE.setPadding(0, 0, 0, 0);
        yE();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aiQ = z;
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.aiF = arrayList;
    }

    private TbImageView b(ad adVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ba.c(linearLayout, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, this.aiy);
        p pVar = new p(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aiQ) {
            tbImageView.setForegroundColor(ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        pVar.aiS = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aiI, this.aiH, this.aiI, this.aiH);
        View view = new View(getContext());
        pVar.aiT = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.ds2);
        if (!this.aiQ) {
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
        this.aiE.addView(linearLayout, this.aiE.getChildCount() - 1, this.aiM);
        EmotionGroupType yO = adVar.yO();
        if (yO == EmotionGroupType.LOCAL) {
            if (adVar.zj() != null) {
                adVar.zj().a(tbImageView);
            }
            tbImageView.setOnClickListener(new n(this, this.aiE.getChildCount() - 3, null));
        } else if (yO == EmotionGroupType.PROMOTION) {
            if (adVar.zk() != null) {
                adVar.zk().a(tbImageView);
            }
            tbImageView.setOnClickListener(new o(this, adVar.getGroupId(), null));
        } else if (yO == EmotionGroupType.BIG_EMOTION) {
            if (this.aiN) {
                if (adVar.zj() != null) {
                    adVar.zj().a(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this, this.aiE.getChildCount() - 3, null));
            } else {
                if (adVar.zk() != null) {
                    adVar.zk().a(tbImageView);
                }
                tbImageView.setOnClickListener(new k(this));
            }
        }
        if (this.aiP == null) {
            this.aiP = tbImageView;
            this.aiP.setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
        }
        return tbImageView;
    }

    public void yE() {
        this.aiK = new ImageView(getContext());
        this.aiK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aiK.setPadding(this.aiI, this.aiH, this.aiI, this.aiH);
        this.aiJ = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aiK.setLayoutParams(layoutParams);
        ba.a(this.aiK, com.baidu.tieba.u.icon_store, this.aiy);
        this.aiJ.addView(this.aiK);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ba.d(view, com.baidu.tieba.s.emotion_tab_div_line_color, this.aiy);
        this.aiJ.addView(view);
        this.aiL = new TextView(getContext());
        this.aiL.setGravity(17);
        this.aiL.setTextSize(10.0f);
        this.aiL.setText("N");
        this.aiL.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aiE.addView(this.aiJ, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1));
        this.aiE.setNewView(this.aiL);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2902010);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aiE.setNewViewVisible(true);
        } else {
            this.aiE.setNewViewVisible(false);
        }
        this.aiJ.setOnClickListener(new l(this));
        this.aiO = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aiO.setLayoutParams(layoutParams3);
        this.aiE.addView(this.aiO);
        if (!appResponseToCmd) {
            this.aiJ.setVisibility(8);
        }
    }

    public void c(ad adVar) {
        b(adVar);
    }

    public void f(int i, boolean z) {
        this.aiN = z;
        int i2 = i + 1;
        int childCount = this.aiE.getChildCount();
        ad adVar = this.aiF.get(i2 - 1);
        if (i2 < childCount && adVar.yO() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aiE.getChildAt(i2)).getChildAt(0);
            if (!this.aiN) {
                tbImageView.setOnClickListener(new m(this));
                if (adVar.zk() != null) {
                    adVar.zk().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new n(this, i2 - 1, null));
            if (adVar.zj() != null) {
                adVar.zj().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aiE.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aiy == 0) {
                        color = getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    } else {
                        color = ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aiE.getChildAt(this.mCurrentIndex + 1);
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
            ad adVar = this.aiF.get(this.mCurrentIndex);
            if (adVar.zj() != null) {
                adVar.zj().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
                this.aiP = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.aiE.removeAllViews();
        yE();
    }

    public void cu(int i) {
        int color;
        this.aiy = i;
        if (this.aiK != null) {
            ba.a(this.aiK, com.baidu.tieba.u.icon_store, i);
        }
        if (this.aiJ != null) {
            ba.c(this.aiJ, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, i);
            if (this.aiJ.getChildCount() > 0) {
                ba.d(this.aiJ.getChildAt(1), com.baidu.tieba.s.emotion_tab_div_line_color, i);
            }
        }
        if (this.aiO != null) {
            ba.c(this.aiO, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aiL != null) {
            ba.c(this.aiL, com.baidu.tieba.u.icon_news_head_prompt_one, i);
            ba.a(this.aiL, com.baidu.tieba.s.cp_cont_i, 1, i);
        }
        int childCount = this.aiE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aiE.getChildAt(i2);
            if (childAt != null) {
                ba.c(childAt, com.baidu.tieba.u.bg_emotion_tab_horizonscrollview, i);
            }
            p pVar = (p) childAt.getTag();
            if (pVar != null) {
                if (pVar.aiS != null) {
                    if (i == 0) {
                        color = getResources().getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    } else {
                        color = ba.getColor(com.baidu.tieba.s.emotion_tab_widget_foreground_color);
                    }
                    pVar.aiS.setForegroundColor(color);
                }
                if (pVar.aiT != null) {
                    ba.d(pVar.aiT, com.baidu.tieba.s.emotion_tab_div_line_color, i);
                }
            }
        }
        if (this.aiP != null) {
            this.aiP.setForegroundColor(ba.getColor(com.baidu.tieba.s.transparent));
            if (this.aiP.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aiP.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(s sVar) {
        this.aiG = sVar;
    }
}
