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
    private c bte;
    private int btf;
    private CommonTabWidgetView.a btg;
    private LinearLayout.LayoutParams bth;
    private int bti;
    private int btj;
    private TextView btk;
    private View btl;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btf = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btf = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.btf = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bte = new c(getContext());
        this.bte.setOrientation(0);
        this.bte.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bte.setBaselineAligned(false);
        addView(this.bte);
        this.bti = getResources().getDimensionPixelSize(d.e.ds8);
        this.btj = getResources().getDimensionPixelSize(d.e.ds10);
        this.bte.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bth = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.btl = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.btl.setLayoutParams(layoutParams);
        aj.s(this.btl, d.f.bg_expression_bar_n);
        this.bte.addView(this.btl);
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
        tbImageView.setPadding(this.btj, this.bti, this.btj, this.bti);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.btd);
        linearLayout.setOnClickListener(new a(this.bte.getChildCount() - 1));
        this.bte.addView(linearLayout, this.bte.getChildCount() - 1, this.bth);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.btf) {
            if (this.btf != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bte.getChildAt(this.btf);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.btf).Lw().btd);
                } else {
                    return;
                }
            }
            this.btf = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bte.getChildAt(this.btf);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.btf).Lw().btc);
            }
        }
    }

    public void reset() {
        this.btf = -1;
        this.bte.removeAllViews();
    }

    public void gz(int i) {
        if (this.btk != null) {
            aj.s(this.btk, d.f.icon_news_head_prompt_one);
            this.btk.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bte.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bte.getChildAt(i2);
            if (childAt != null) {
                aj.s(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.btf) {
                            aj.c(tbImageView, this.mDatas.get(i2).Lw().btc);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Lw().btd);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.btg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aTn;

        private a(int i) {
            this.aTn = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.btg.hV(this.aTn);
        }
    }
}
