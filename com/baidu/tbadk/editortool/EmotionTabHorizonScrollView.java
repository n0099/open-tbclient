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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private c ajE;
    private s ajF;
    private int ajG;
    private int ajH;
    private LinearLayout ajI;
    private ImageView ajJ;
    private TextView ajK;
    private LinearLayout.LayoutParams ajL;
    private boolean ajM;
    private View ajN;
    private TbImageView ajO;
    private boolean ajP;
    private int ajy;
    private int from;
    private int mCurrentIndex;
    private ArrayList<ad> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.ajM = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.ajM = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.ajM = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ajE = new c(getContext());
        this.ajE.setOrientation(0);
        this.ajE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ajE.setBaselineAligned(false);
        addView(this.ajE);
        this.ajG = getResources().getDimensionPixelSize(com.baidu.tieba.o.face_tab_widget_tb_padding);
        this.ajH = getResources().getDimensionPixelSize(com.baidu.tieba.o.face_tab_widget_lr_padding);
        this.ajL = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.o.ds122), -1);
        this.ajE.setPadding(0, 0, 0, 0);
        zs();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ajP = z;
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(ad adVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ay.c(linearLayout, com.baidu.tieba.p.bg_emotion_tab_horizonscrollview, this.ajy);
        p pVar = new p(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.ajP) {
            tbImageView.setForegroundColor(ay.getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        pVar.ajR = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.ajH, this.ajG, this.ajH, this.ajG);
        View view = new View(getContext());
        pVar.ajS = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds2);
        if (!this.ajP) {
            view.setBackgroundColor(ay.getColor(com.baidu.tieba.n.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(com.baidu.tieba.n.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(pVar);
        this.ajE.addView(linearLayout, this.ajE.getChildCount() - 1, this.ajL);
        EmotionGroupType zC = adVar.zC();
        if (zC == EmotionGroupType.LOCAL) {
            if (adVar.zX() != null) {
                adVar.zX().a(tbImageView);
            }
            tbImageView.setOnClickListener(new n(this, this.ajE.getChildCount() - 3, null));
        } else if (zC == EmotionGroupType.PROMOTION) {
            if (adVar.zY() != null) {
                adVar.zY().a(tbImageView);
            }
            tbImageView.setOnClickListener(new o(this, adVar.getGroupId(), null));
        } else if (zC == EmotionGroupType.BIG_EMOTION) {
            if (this.ajM) {
                if (adVar.zX() != null) {
                    adVar.zX().a(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this, this.ajE.getChildCount() - 3, null));
            } else {
                if (adVar.zY() != null) {
                    adVar.zY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new k(this));
            }
        }
        if (this.ajO == null) {
            this.ajO = tbImageView;
            this.ajO.setForegroundColor(ay.getColor(com.baidu.tieba.n.transparent));
        }
        return tbImageView;
    }

    public void zs() {
        this.ajJ = new ImageView(getContext());
        this.ajJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ajJ.setPadding(this.ajH, this.ajG, this.ajH, this.ajG);
        this.ajI = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ajJ.setLayoutParams(layoutParams);
        ay.a(this.ajJ, com.baidu.tieba.p.icon_store, this.ajy);
        this.ajI.addView(this.ajJ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.o.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ay.d(view, com.baidu.tieba.n.emotion_tab_div_line_color, this.ajy);
        this.ajI.addView(view);
        this.ajK = new TextView(getContext());
        this.ajK.setGravity(17);
        this.ajK.setTextSize(10.0f);
        this.ajK.setText("N");
        this.ajK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ajE.addView(this.ajI, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.o.face_tab_widget_width), -1));
        this.ajE.setNewView(this.ajK);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2902010);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.ajE.setNewViewVisible(true);
        } else {
            this.ajE.setNewViewVisible(false);
        }
        this.ajI.setOnClickListener(new l(this));
        this.ajN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.ajN.setLayoutParams(layoutParams3);
        this.ajE.addView(this.ajN);
        if (!appResponseToCmd) {
            this.ajI.setVisibility(8);
        }
    }

    public void c(ad adVar) {
        b(adVar);
    }

    public void f(int i, boolean z) {
        this.ajM = z;
        int i2 = i + 1;
        int childCount = this.ajE.getChildCount();
        ad adVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && adVar.zC() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ajE.getChildAt(i2)).getChildAt(0);
            if (!this.ajM) {
                tbImageView.setOnClickListener(new m(this));
                if (adVar.zY() != null) {
                    adVar.zY().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new n(this, i2 - 1, null));
            if (adVar.zX() != null) {
                adVar.zX().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ajE.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ajy == 0) {
                        color = getResources().getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color);
                    } else {
                        color = ay.getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ajE.getChildAt(this.mCurrentIndex + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(com.baidu.tieba.q.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            ad adVar = this.mDatas.get(this.mCurrentIndex);
            if (adVar.zX() != null) {
                adVar.zX().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ay.getColor(com.baidu.tieba.n.transparent));
                this.ajO = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ajE.removeAllViews();
        zs();
        cz(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cz(int i) {
        int color;
        this.ajy = i;
        if (this.ajJ != null) {
            ay.a(this.ajJ, com.baidu.tieba.p.icon_store, i);
        }
        if (this.ajI != null) {
            ay.c(this.ajI, com.baidu.tieba.p.bg_emotion_tab_horizonscrollview, i);
            if (this.ajI.getChildCount() > 0) {
                ay.d(this.ajI.getChildAt(1), com.baidu.tieba.n.emotion_tab_div_line_color, i);
            }
        }
        if (this.ajN != null) {
            ay.c(this.ajN, com.baidu.tieba.p.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.ajK != null) {
            ay.c(this.ajK, com.baidu.tieba.p.icon_news_head_prompt_one, i);
            ay.a(this.ajK, com.baidu.tieba.n.cp_cont_i, 1, i);
        }
        int childCount = this.ajE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ajE.getChildAt(i2);
            if (childAt != null) {
                ay.c(childAt, com.baidu.tieba.p.bg_emotion_tab_horizonscrollview, i);
            }
            p pVar = (p) childAt.getTag();
            if (pVar != null) {
                if (pVar.ajR != null) {
                    if (i == 0) {
                        color = getResources().getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color);
                    } else {
                        color = ay.getColor(com.baidu.tieba.n.emotion_tab_widget_foreground_color);
                    }
                    pVar.ajR.setForegroundColor(color);
                }
                if (pVar.ajS != null) {
                    ay.d(pVar.ajS, com.baidu.tieba.n.emotion_tab_div_line_color, i);
                }
            }
        }
        if (this.ajO != null) {
            this.ajO.setForegroundColor(ay.getColor(com.baidu.tieba.n.transparent));
            if (this.ajO.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ajO.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(s sVar) {
        this.ajF = sVar;
    }
}
