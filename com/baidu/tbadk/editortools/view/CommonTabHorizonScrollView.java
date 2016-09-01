package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f axk;
    private int axl;
    private CommonTabWidgetView.a axm;
    private LinearLayout.LayoutParams axn;
    private int axo;
    private int axp;
    private TextView axq;
    private View axr;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axl = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axl = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.axl = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.axk = new f(getContext());
        this.axk.setOrientation(0);
        this.axk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.axk.setBaselineAligned(false);
        addView(this.axk);
        this.axo = getResources().getDimensionPixelSize(t.e.ds8);
        this.axp = getResources().getDimensionPixelSize(t.e.ds10);
        this.axk.setPadding(0, getResources().getDimensionPixelSize(t.e.ds10), 0, 0);
        this.axn = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds106), -1);
        this.axr = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.axr.setLayoutParams(layoutParams);
        av.k(this.axr, t.f.bg_expression_bar_n);
        this.axk.addView(this.axr);
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
        av.k(linearLayout, t.f.bg_expression_bar);
        tbImageView.setPadding(this.axp, this.axo, this.axp, this.axo);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        av.c(tbImageView, c0042b.axj);
        linearLayout.setOnClickListener(new a(this, this.axk.getChildCount() - 1, null));
        this.axk.addView(linearLayout, this.axk.getChildCount() - 1, this.axn);
        return tbImageView;
    }

    public void c(b.C0042b c0042b) {
        b(c0042b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.axl) {
            if (this.axl != -1) {
                LinearLayout linearLayout = (LinearLayout) this.axk.getChildAt(this.axl);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.axl).DP().axj);
                } else {
                    return;
                }
            }
            this.axl = i;
            LinearLayout linearLayout2 = (LinearLayout) this.axk.getChildAt(this.axl);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                av.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.axl).DP().axi);
            }
        }
    }

    public void reset() {
        this.axl = -1;
        this.axk.removeAllViews();
    }

    public void dl(int i) {
        if (this.axq != null) {
            av.k(this.axq, t.f.icon_news_head_prompt_one);
            this.axq.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.axk.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.axk.getChildAt(i2);
            if (childAt != null) {
                av.k(childAt, t.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.axl) {
                            av.c(tbImageView, this.mDatas.get(i2).DP().axi);
                        } else {
                            av.c(tbImageView, this.mDatas.get(i2).DP().axj);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.axm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Zj;

        private a(int i) {
            this.Zj = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.axm.eO(this.Zj);
        }
    }
}
