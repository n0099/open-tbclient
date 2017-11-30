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
    private c aEM;
    private int aEN;
    private CommonTabWidgetView.a aEO;
    private LinearLayout.LayoutParams aEP;
    private int aEQ;
    private int aER;
    private TextView aES;
    private View aET;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEN = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEN = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEN = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEM = new c(getContext());
        this.aEM.setOrientation(0);
        this.aEM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEM.setBaselineAligned(false);
        addView(this.aEM);
        this.aEQ = getResources().getDimensionPixelSize(d.e.ds8);
        this.aER = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEM.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aEP = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aET = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aET.setLayoutParams(layoutParams);
        aj.j(this.aET, d.f.bg_expression_bar_n);
        this.aEM.addView(this.aET);
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
        aj.j(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.aER, this.aEQ, this.aER, this.aEQ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aEL);
        linearLayout.setOnClickListener(new a(this.aEM.getChildCount() - 1));
        this.aEM.addView(linearLayout, this.aEM.getChildCount() - 1, this.aEP);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEN) {
            if (this.aEN != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEM.getChildAt(this.aEN);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEN).Ee().aEL);
                } else {
                    return;
                }
            }
            this.aEN = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEM.getChildAt(this.aEN);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEN).Ee().aEK);
            }
        }
    }

    public void reset() {
        this.aEN = -1;
        this.aEM.removeAllViews();
    }

    public void dE(int i) {
        if (this.aES != null) {
            aj.j(this.aES, d.f.icon_news_head_prompt_one);
            this.aES.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEM.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEM.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEN) {
                            aj.c(tbImageView, this.mDatas.get(i2).Ee().aEK);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Ee().aEL);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int afd;

        private a(int i) {
            this.afd = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aEO.fb(this.afd);
        }
    }
}
