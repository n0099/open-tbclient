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
    private DeskLinearLayout bbb;
    private CommonTabWidgetView.a bbc;
    private int bbd;
    private int bbe;
    private TextView bbf;
    private View bbg;
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
        this.bbb = new DeskLinearLayout(getContext());
        this.bbb.setOrientation(0);
        this.bbb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bbb.setBaselineAligned(false);
        addView(this.bbb);
        this.bbd = getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.bbe = getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.bbb.setPadding(0, getResources().getDimensionPixelSize(e.C0210e.ds10), 0, 0);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds106), -1);
        this.bbg = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bbg.setLayoutParams(layoutParams);
        al.i(this.bbg, e.f.bg_expression_bar_n);
        this.bbb.addView(this.bbg);
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
        tbImageView.setPadding(this.bbe, this.bbd, this.bbe, this.bbd);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.bba);
        linearLayout.setOnClickListener(new a(this.bbb.getChildCount() - 1));
        this.bbb.addView(linearLayout, this.bbb.getChildCount() - 1, this.mParams);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bbb.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).MY().bba);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bbb.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).MY().baZ);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.bbb.removeAllViews();
    }

    public void eC(int i) {
        if (this.bbf != null) {
            al.i(this.bbf, e.f.icon_news_head_prompt_one);
            this.bbf.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bbb.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bbb.getChildAt(i2);
            if (childAt != null) {
                al.i(childAt, e.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            al.c(tbImageView, this.mDatas.get(i2).MY().baZ);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).MY().bba);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bbc = aVar;
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
            CommonTabHorizonScrollView.this.bbc.fV(this.azT);
        }
    }
}
