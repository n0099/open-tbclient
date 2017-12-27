package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private c bsM;
    private int bsN;
    private CommonTabWidgetView.a bsO;
    private LinearLayout.LayoutParams bsP;
    private int bsQ;
    private int bsR;
    private TextView bsS;
    private View bsT;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsN = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsN = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bsN = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bsM = new c(getContext());
        this.bsM.setOrientation(0);
        this.bsM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bsM.setBaselineAligned(false);
        addView(this.bsM);
        this.bsQ = getResources().getDimensionPixelSize(d.e.ds8);
        this.bsR = getResources().getDimensionPixelSize(d.e.ds10);
        this.bsM.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bsP = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.bsT = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bsT.setLayoutParams(layoutParams);
        aj.s(this.bsT, d.f.bg_expression_bar_n);
        this.bsM.addView(this.bsT);
    }

    public void setDatas(List<com.baidu.tbadk.editortools.view.a> list) {
        this.mDatas = list;
    }

    private TbImageView b(a.b bVar) {
        if (bVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        aj.s(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.bsR, this.bsQ, this.bsR, this.bsQ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.bsL);
        linearLayout.setOnClickListener(new a(this.bsM.getChildCount() - 1));
        this.bsM.addView(linearLayout, this.bsM.getChildCount() - 1, this.bsP);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bsN) {
            if (this.bsN != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bsM.getChildAt(this.bsN);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bsN).LG().bsL);
                } else {
                    return;
                }
            }
            this.bsN = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bsM.getChildAt(this.bsN);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bsN).LG().bsK);
            }
        }
    }

    public void reset() {
        this.bsN = -1;
        this.bsM.removeAllViews();
    }

    public void gC(int i) {
        if (this.bsS != null) {
            aj.s(this.bsS, d.f.icon_news_head_prompt_one);
            this.bsS.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bsM.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bsM.getChildAt(i2);
            if (childAt != null) {
                aj.s(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bsN) {
                            aj.c(tbImageView, this.mDatas.get(i2).LG().bsK);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).LG().bsL);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bsO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aTl;

        private a(int i) {
            this.aTl = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bsO.hZ(this.aTl);
        }
    }
}
