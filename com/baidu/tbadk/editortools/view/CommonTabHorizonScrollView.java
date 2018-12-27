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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private DeskLinearLayout bbe;
    private CommonTabWidgetView.a bbf;
    private int bbg;
    private int bbh;
    private TextView bbi;
    private View bbj;
    private int mCurrentIndex;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;
    private LinearLayout.LayoutParams mParams;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bbe = new DeskLinearLayout(getContext());
        this.bbe.setOrientation(0);
        this.bbe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bbe.setBaselineAligned(false);
        addView(this.bbe);
        this.bbg = getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.bbh = getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.bbe.setPadding(0, getResources().getDimensionPixelSize(e.C0210e.ds10), 0, 0);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds106), -1);
        this.bbj = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bbj.setLayoutParams(layoutParams);
        al.i(this.bbj, e.f.bg_expression_bar_n);
        this.bbe.addView(this.bbj);
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
        al.i(linearLayout, e.f.bg_expression_bar);
        tbImageView.setPadding(this.bbh, this.bbg, this.bbh, this.bbg);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.bbd);
        linearLayout.setOnClickListener(new a(this.bbe.getChildCount() - 1));
        this.bbe.addView(linearLayout, this.bbe.getChildCount() - 1, this.mParams);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bbe.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).MZ().bbd);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bbe.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).MZ().bbc);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.bbe.removeAllViews();
    }

    public void eD(int i) {
        if (this.bbi != null) {
            al.i(this.bbi, e.f.icon_news_head_prompt_one);
            this.bbi.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bbe.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bbe.getChildAt(i2);
            if (childAt != null) {
                al.i(childAt, e.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            al.c(tbImageView, this.mDatas.get(i2).MZ().bbc);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).MZ().bbd);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bbf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int azT;

        private a(int i) {
            this.azT = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bbf.fW(this.azT);
        }
    }
}
