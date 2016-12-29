package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f axb;
    private int axc;
    private CommonTabWidgetView.a axd;
    private LinearLayout.LayoutParams axe;
    private int axf;
    private int axg;
    private TextView axh;
    private View axi;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axc = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axc = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.axc = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.axb = new f(getContext());
        this.axb.setOrientation(0);
        this.axb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.axb.setBaselineAligned(false);
        addView(this.axb);
        this.axf = getResources().getDimensionPixelSize(r.e.ds8);
        this.axg = getResources().getDimensionPixelSize(r.e.ds10);
        this.axb.setPadding(0, getResources().getDimensionPixelSize(r.e.ds10), 0, 0);
        this.axe = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds106), -1);
        this.axi = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.axi.setLayoutParams(layoutParams);
        ar.k(this.axi, r.f.bg_expression_bar_n);
        this.axb.addView(this.axi);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0042b c0042b) {
        if (c0042b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        ar.k(linearLayout, r.f.bg_expression_bar);
        tbImageView.setPadding(this.axg, this.axf, this.axg, this.axf);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ar.c(tbImageView, c0042b.axa);
        linearLayout.setOnClickListener(new a(this, this.axb.getChildCount() - 1, null));
        this.axb.addView(linearLayout, this.axb.getChildCount() - 1, this.axe);
        return tbImageView;
    }

    public void c(b.C0042b c0042b) {
        b(c0042b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.axc) {
            if (this.axc != -1) {
                LinearLayout linearLayout = (LinearLayout) this.axb.getChildAt(this.axc);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.axc).DC().axa);
                } else {
                    return;
                }
            }
            this.axc = i;
            LinearLayout linearLayout2 = (LinearLayout) this.axb.getChildAt(this.axc);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ar.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.axc).DC().awZ);
            }
        }
    }

    public void reset() {
        this.axc = -1;
        this.axb.removeAllViews();
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(int i) {
        if (this.axh != null) {
            ar.k(this.axh, r.f.icon_news_head_prompt_one);
            this.axh.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.axb.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.axb.getChildAt(i2);
            if (childAt != null) {
                ar.k(childAt, r.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.axc) {
                            ar.c(tbImageView, this.mDatas.get(i2).DC().awZ);
                        } else {
                            ar.c(tbImageView, this.mDatas.get(i2).DC().axa);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.axd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Zo;

        private a(int i) {
            this.Zo = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.axd.eR(this.Zo);
        }
    }
}
