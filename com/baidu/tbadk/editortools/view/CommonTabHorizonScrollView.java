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
    private DeskLinearLayout cuU;
    private CommonTabWidgetView.a cuV;
    private int cuW;
    private int cuX;
    private TextView cuY;
    private View cuZ;
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
        this.cuU = new DeskLinearLayout(getContext());
        this.cuU.setOrientation(0);
        this.cuU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cuU.setBaselineAligned(false);
        addView(this.cuU);
        this.cuW = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cuX = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cuU.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.bqp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.cuZ = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cuZ.setLayoutParams(layoutParams);
        am.k(this.cuZ, R.drawable.bg_expression_bar_n);
        this.cuU.addView(this.cuZ);
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
        tbImageView.setPadding(this.cuX, this.cuW, this.cuX, this.cuW);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.cuT);
        linearLayout.setOnClickListener(new a(this.cuU.getChildCount() - 1));
        this.cuU.addView(linearLayout, this.cuU.getChildCount() - 1, this.bqp);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bpM) {
            if (this.bpM != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cuU.getChildAt(this.bpM);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bpM).ata().cuT);
                } else {
                    return;
                }
            }
            this.bpM = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cuU.getChildAt(this.bpM);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bpM).ata().cuS);
            }
        }
    }

    public void reset() {
        this.bpM = -1;
        this.cuU.removeAllViews();
    }

    public void jc(int i) {
        if (this.cuY != null) {
            am.k(this.cuY, R.drawable.icon_news_head_prompt_one);
            this.cuY.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.cuU.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cuU.getChildAt(i2);
            if (childAt != null) {
                am.k(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bpM) {
                            am.c(tbImageView, this.mDatas.get(i2).ata().cuS);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).ata().cuT);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.cuV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bRf;

        private a(int i) {
            this.bRf = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.cuV.kA(this.bRf);
        }
    }
}
