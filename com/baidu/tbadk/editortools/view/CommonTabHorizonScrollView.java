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
    private c bvr;
    private int bvs;
    private CommonTabWidgetView.a bvt;
    private LinearLayout.LayoutParams bvu;
    private int bvv;
    private int bvw;
    private TextView bvx;
    private View bvy;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvs = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvs = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bvs = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bvr = new c(getContext());
        this.bvr.setOrientation(0);
        this.bvr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bvr.setBaselineAligned(false);
        addView(this.bvr);
        this.bvv = getResources().getDimensionPixelSize(d.e.ds8);
        this.bvw = getResources().getDimensionPixelSize(d.e.ds10);
        this.bvr.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bvu = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.bvy = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bvy.setLayoutParams(layoutParams);
        aj.s(this.bvy, d.f.bg_expression_bar_n);
        this.bvr.addView(this.bvy);
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
        tbImageView.setPadding(this.bvw, this.bvv, this.bvw, this.bvv);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.bvq);
        linearLayout.setOnClickListener(new a(this.bvr.getChildCount() - 1));
        this.bvr.addView(linearLayout, this.bvr.getChildCount() - 1, this.bvu);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bvs) {
            if (this.bvs != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bvr.getChildAt(this.bvs);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bvs).Mc().bvq);
                } else {
                    return;
                }
            }
            this.bvs = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bvr.getChildAt(this.bvs);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bvs).Mc().bvp);
            }
        }
    }

    public void reset() {
        this.bvs = -1;
        this.bvr.removeAllViews();
    }

    public void gB(int i) {
        if (this.bvx != null) {
            aj.s(this.bvx, d.f.icon_news_head_prompt_one);
            this.bvx.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bvr.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bvr.getChildAt(i2);
            if (childAt != null) {
                aj.s(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bvs) {
                            aj.c(tbImageView, this.mDatas.get(i2).Mc().bvp);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Mc().bvq);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bvt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aUS;

        private a(int i) {
            this.aUS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bvt.hT(this.aUS);
        }
    }
}
