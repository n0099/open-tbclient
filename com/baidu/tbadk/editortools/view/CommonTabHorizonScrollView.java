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
    private int bMx;
    private LinearLayout.LayoutParams eua;
    private DeskLinearLayout fHn;
    private CommonTabWidgetView.a fHo;
    private int fHp;
    private int fHq;
    private TextView fHr;
    private View fHs;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMx = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMx = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bMx = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fHn = new DeskLinearLayout(getContext());
        this.fHn.setOrientation(0);
        this.fHn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fHn.setBaselineAligned(false);
        addView(this.fHn);
        this.fHp = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fHq = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fHn.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.eua = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.fHs = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fHs.setLayoutParams(layoutParams);
        ao.setBackgroundResource(this.fHs, R.drawable.bg_expression_bar_n);
        this.fHn.addView(this.fHs);
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
        tbImageView.setPadding(this.fHq, this.fHp, this.fHq, this.fHp);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ao.setImageResource(tbImageView, bVar.fHm);
        linearLayout.setOnClickListener(new a(this.fHn.getChildCount() - 1));
        this.fHn.addView(linearLayout, this.fHn.getChildCount() - 1, this.eua);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bMx) {
            if (this.bMx != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fHn.getChildAt(this.bMx);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bMx).bFW().fHm);
                } else {
                    return;
                }
            }
            this.bMx = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fHn.getChildAt(this.bMx);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ao.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bMx).bFW().fHl);
            }
        }
    }

    public void reset() {
        this.bMx = -1;
        this.fHn.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.fHr != null) {
            ao.setBackgroundResource(this.fHr, R.drawable.icon_news_head_prompt_one, i);
            this.fHr.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.fHn.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.fHn.getChildAt(i2);
            if (childAt != null) {
                ao.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bMx) {
                            ao.setImageResource(tbImageView, this.mDatas.get(i2).bFW().fHl, i);
                        } else {
                            ao.setImageResource(tbImageView, this.mDatas.get(i2).bFW().fHm, i);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.fHo = aVar;
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
            CommonTabHorizonScrollView.this.fHo.sJ(this.mTabIndex);
        }
    }
}
