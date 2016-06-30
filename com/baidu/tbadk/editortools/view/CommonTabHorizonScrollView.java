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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f ato;
    private int atp;
    private CommonTabWidgetView.a atq;
    private LinearLayout.LayoutParams atr;
    private int ats;
    private int att;
    private TextView atu;
    private View atv;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atp = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atp = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.atp = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ato = new f(getContext());
        this.ato.setOrientation(0);
        this.ato.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ato.setBaselineAligned(false);
        addView(this.ato);
        this.ats = getResources().getDimensionPixelSize(u.e.ds8);
        this.att = getResources().getDimensionPixelSize(u.e.ds10);
        this.ato.setPadding(0, getResources().getDimensionPixelSize(u.e.ds10), 0, 0);
        this.atr = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds106), -1);
        this.atv = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.atv.setLayoutParams(layoutParams);
        av.k(this.atv, u.f.bg_expression_bar_n);
        this.ato.addView(this.atv);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0041b c0041b) {
        if (c0041b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        av.k(linearLayout, u.f.bg_expression_bar);
        tbImageView.setPadding(this.att, this.ats, this.att, this.ats);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        av.c(tbImageView, c0041b.atn);
        linearLayout.setOnClickListener(new a(this, this.ato.getChildCount() - 1, null));
        this.ato.addView(linearLayout, this.ato.getChildCount() - 1, this.atr);
        return tbImageView;
    }

    public void c(b.C0041b c0041b) {
        b(c0041b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.atp) {
            if (this.atp != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ato.getChildAt(this.atp);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.atp).Cv().atn);
                } else {
                    return;
                }
            }
            this.atp = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ato.getChildAt(this.atp);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                av.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.atp).Cv().atm);
            }
        }
    }

    public void reset() {
        this.atp = -1;
        this.ato.removeAllViews();
    }

    public void cX(int i) {
        if (this.atu != null) {
            av.k(this.atu, u.f.icon_news_head_prompt_one);
            this.atu.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.ato.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ato.getChildAt(i2);
            if (childAt != null) {
                av.k(childAt, u.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.atp) {
                            av.c(tbImageView, this.mDatas.get(i2).Cv().atm);
                        } else {
                            av.c(tbImageView, this.mDatas.get(i2).Cv().atn);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.atq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int VM;

        private a(int i) {
            this.VM = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.atq.eA(this.VM);
        }
    }
}
