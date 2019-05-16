package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int boZ;
    private LinearLayout.LayoutParams bpC;
    private DeskLinearLayout ctE;
    private CommonTabWidgetView.a ctF;
    private int ctG;
    private int ctH;
    private TextView ctI;
    private View ctJ;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.boZ = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ctE = new DeskLinearLayout(getContext());
        this.ctE.setOrientation(0);
        this.ctE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ctE.setBaselineAligned(false);
        addView(this.ctE);
        this.ctG = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ctH = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ctE.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.bpC = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.ctJ = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ctJ.setLayoutParams(layoutParams);
        al.k(this.ctJ, R.drawable.bg_expression_bar_n);
        this.ctE.addView(this.ctJ);
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
        al.k(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.ctH, this.ctG, this.ctH, this.ctG);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.ctD);
        linearLayout.setOnClickListener(new a(this.ctE.getChildCount() - 1));
        this.ctE.addView(linearLayout, this.ctE.getChildCount() - 1, this.bpC);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.boZ) {
            if (this.boZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ctE.getChildAt(this.boZ);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.boZ).arU().ctD);
                } else {
                    return;
                }
            }
            this.boZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ctE.getChildAt(this.boZ);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.boZ).arU().ctC);
            }
        }
    }

    public void reset() {
        this.boZ = -1;
        this.ctE.removeAllViews();
    }

    public void iW(int i) {
        if (this.ctI != null) {
            al.k(this.ctI, R.drawable.icon_news_head_prompt_one);
            this.ctI.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.ctE.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ctE.getChildAt(i2);
            if (childAt != null) {
                al.k(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.boZ) {
                            al.c(tbImageView, this.mDatas.get(i2).arU().ctC);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).arU().ctD);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.ctF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bQe;

        private a(int i) {
            this.bQe = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.ctF.ku(this.bQe);
        }
    }
}
