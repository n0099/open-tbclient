package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int bHL;
    private LinearLayout.LayoutParams epm;
    private DeskLinearLayout fCG;
    private CommonTabWidgetView.a fCH;
    private int fCI;
    private int fCJ;
    private TextView fCK;
    private View fCL;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHL = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHL = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bHL = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fCG = new DeskLinearLayout(getContext());
        this.fCG.setOrientation(0);
        this.fCG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fCG.setBaselineAligned(false);
        addView(this.fCG);
        this.fCI = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fCJ = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fCG.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.epm = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.fCL = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fCL.setLayoutParams(layoutParams);
        ao.setBackgroundResource(this.fCL, R.drawable.bg_expression_bar_n);
        this.fCG.addView(this.fCL);
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
        ao.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.fCJ, this.fCI, this.fCJ, this.fCI);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ao.setImageResource(tbImageView, bVar.fCF);
        linearLayout.setOnClickListener(new a(this.fCG.getChildCount() - 1));
        this.fCG.addView(linearLayout, this.fCG.getChildCount() - 1, this.epm);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bHL) {
            if (this.bHL != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fCG.getChildAt(this.bHL);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bHL).bCe().fCF);
                } else {
                    return;
                }
            }
            this.bHL = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fCG.getChildAt(this.bHL);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ao.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bHL).bCe().fCE);
            }
        }
    }

    public void reset() {
        this.bHL = -1;
        this.fCG.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.fCK != null) {
            ao.setBackgroundResource(this.fCK, R.drawable.icon_news_head_prompt_one, i);
            this.fCK.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.fCG.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.fCG.getChildAt(i2);
            if (childAt != null) {
                ao.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bHL) {
                            ao.setImageResource(tbImageView, this.mDatas.get(i2).bCe().fCE, i);
                        } else {
                            ao.setImageResource(tbImageView, this.mDatas.get(i2).bCe().fCF, i);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.fCH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int mTabIndex;

        private a(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.fCH.rd(this.mTabIndex);
        }
    }
}
