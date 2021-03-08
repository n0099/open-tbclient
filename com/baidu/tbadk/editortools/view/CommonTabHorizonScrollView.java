package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int bMV;
    private LinearLayout.LayoutParams esU;
    private DeskLinearLayout fGr;
    private CommonTabWidgetView.a fGs;
    private int fGt;
    private int fGu;
    private TextView fGv;
    private View fGw;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bMV = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fGr = new DeskLinearLayout(getContext());
        this.fGr.setOrientation(0);
        this.fGr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fGr.setBaselineAligned(false);
        addView(this.fGr);
        this.fGt = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fGu = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fGr.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.esU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.fGw = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fGw.setLayoutParams(layoutParams);
        ap.setBackgroundResource(this.fGw, R.drawable.bg_expression_bar_n);
        this.fGr.addView(this.fGw);
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
        ap.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.fGu, this.fGt, this.fGu, this.fGt);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ap.setImageResource(tbImageView, bVar.fGq);
        linearLayout.setOnClickListener(new a(this.fGr.getChildCount() - 1));
        this.fGr.addView(linearLayout, this.fGr.getChildCount() - 1, this.esU);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bMV) {
            if (this.bMV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fGr.getChildAt(this.bMV);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bMV).bCz().fGq);
                } else {
                    return;
                }
            }
            this.bMV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fGr.getChildAt(this.bMV);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ap.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bMV).bCz().fGp);
            }
        }
    }

    public void reset() {
        this.bMV = -1;
        this.fGr.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.fGv != null) {
            ap.setBackgroundResource(this.fGv, R.drawable.icon_news_head_prompt_one, i);
            this.fGv.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.fGr.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.fGr.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bMV) {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bCz().fGp, i);
                        } else {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bCz().fGq, i);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.fGs = aVar;
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
            CommonTabHorizonScrollView.this.fGs.rj(this.mTabIndex);
        }
    }
}
