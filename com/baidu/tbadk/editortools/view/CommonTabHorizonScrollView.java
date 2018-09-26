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
    private DeskLinearLayout aSm;
    private int aSn;
    private CommonTabWidgetView.a aSo;
    private LinearLayout.LayoutParams aSp;
    private int aSq;
    private int aSr;
    private TextView aSs;
    private View aSt;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSn = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSn = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aSn = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aSm = new DeskLinearLayout(getContext());
        this.aSm.setOrientation(0);
        this.aSm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aSm.setBaselineAligned(false);
        addView(this.aSm);
        this.aSq = getResources().getDimensionPixelSize(e.C0141e.ds8);
        this.aSr = getResources().getDimensionPixelSize(e.C0141e.ds10);
        this.aSm.setPadding(0, getResources().getDimensionPixelSize(e.C0141e.ds10), 0, 0);
        this.aSp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0141e.ds106), -1);
        this.aSt = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aSt.setLayoutParams(layoutParams);
        al.i(this.aSt, e.f.bg_expression_bar_n);
        this.aSm.addView(this.aSt);
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
        tbImageView.setPadding(this.aSr, this.aSq, this.aSr, this.aSq);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.aSl);
        linearLayout.setOnClickListener(new a(this.aSm.getChildCount() - 1));
        this.aSm.addView(linearLayout, this.aSm.getChildCount() - 1, this.aSp);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aSn) {
            if (this.aSn != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aSm.getChildAt(this.aSn);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aSn).JK().aSl);
                } else {
                    return;
                }
            }
            this.aSn = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aSm.getChildAt(this.aSn);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aSn).JK().aSk);
            }
        }
    }

    public void reset() {
        this.aSn = -1;
        this.aSm.removeAllViews();
    }

    public void dQ(int i) {
        if (this.aSs != null) {
            al.i(this.aSs, e.f.icon_news_head_prompt_one);
            this.aSs.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aSm.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aSm.getChildAt(i2);
            if (childAt != null) {
                al.i(childAt, e.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aSn) {
                            al.c(tbImageView, this.mDatas.get(i2).JK().aSk);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).JK().aSl);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aSo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aqP;

        private a(int i) {
            this.aqP = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aSo.fk(this.aqP);
        }
    }
}
