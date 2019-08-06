package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int bpM;
    private LinearLayout.LayoutParams bqp;
    private DeskLinearLayout cvb;
    private CommonTabWidgetView.a cvc;
    private int cvd;
    private int cve;
    private TextView cvf;
    private View cvg;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpM = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpM = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bpM = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cvb = new DeskLinearLayout(getContext());
        this.cvb.setOrientation(0);
        this.cvb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cvb.setBaselineAligned(false);
        addView(this.cvb);
        this.cvd = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cve = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cvb.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.bqp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.cvg = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cvg.setLayoutParams(layoutParams);
        am.k(this.cvg, R.drawable.bg_expression_bar_n);
        this.cvb.addView(this.cvg);
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
        am.k(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.cve, this.cvd, this.cve, this.cvd);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.cva);
        linearLayout.setOnClickListener(new a(this.cvb.getChildCount() - 1));
        this.cvb.addView(linearLayout, this.cvb.getChildCount() - 1, this.bqp);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bpM) {
            if (this.bpM != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cvb.getChildAt(this.bpM);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bpM).atc().cva);
                } else {
                    return;
                }
            }
            this.bpM = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cvb.getChildAt(this.bpM);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bpM).atc().cuZ);
            }
        }
    }

    public void reset() {
        this.bpM = -1;
        this.cvb.removeAllViews();
    }

    public void jd(int i) {
        if (this.cvf != null) {
            am.k(this.cvf, R.drawable.icon_news_head_prompt_one);
            this.cvf.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.cvb.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cvb.getChildAt(i2);
            if (childAt != null) {
                am.k(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bpM) {
                            am.c(tbImageView, this.mDatas.get(i2).atc().cuZ);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).atc().cva);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.cvc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bRl;

        private a(int i) {
            this.bRl = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.cvc.kB(this.bRl);
        }
    }
}
