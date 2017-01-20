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
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f awf;
    private int awg;
    private CommonTabWidgetView.a awh;
    private LinearLayout.LayoutParams awi;
    private int awj;
    private int awk;
    private TextView awl;
    private View awm;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awg = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awg = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.awg = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.awf = new f(getContext());
        this.awf.setOrientation(0);
        this.awf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.awf.setBaselineAligned(false);
        addView(this.awf);
        this.awj = getResources().getDimensionPixelSize(r.f.ds8);
        this.awk = getResources().getDimensionPixelSize(r.f.ds10);
        this.awf.setPadding(0, getResources().getDimensionPixelSize(r.f.ds10), 0, 0);
        this.awi = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.f.ds106), -1);
        this.awm = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.awm.setLayoutParams(layoutParams);
        ap.j(this.awm, r.g.bg_expression_bar_n);
        this.awf.addView(this.awm);
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
        ap.j(linearLayout, r.g.bg_expression_bar);
        tbImageView.setPadding(this.awk, this.awj, this.awk, this.awj);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ap.c(tbImageView, c0042b.awe);
        linearLayout.setOnClickListener(new a(this, this.awf.getChildCount() - 1, null));
        this.awf.addView(linearLayout, this.awf.getChildCount() - 1, this.awi);
        return tbImageView;
    }

    public void c(b.C0042b c0042b) {
        b(c0042b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.awg) {
            if (this.awg != -1) {
                LinearLayout linearLayout = (LinearLayout) this.awf.getChildAt(this.awg);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.awg).Dx().awe);
                } else {
                    return;
                }
            }
            this.awg = i;
            LinearLayout linearLayout2 = (LinearLayout) this.awf.getChildAt(this.awg);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ap.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.awg).Dx().awd);
            }
        }
    }

    public void reset() {
        this.awg = -1;
        this.awf.removeAllViews();
    }

    public void dp(int i) {
        if (this.awl != null) {
            ap.j((View) this.awl, r.g.icon_news_head_prompt_one);
            this.awl.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.awf.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.awf.getChildAt(i2);
            if (childAt != null) {
                ap.j(childAt, r.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.awg) {
                            ap.c(tbImageView, this.mDatas.get(i2).Dx().awd);
                        } else {
                            ap.c(tbImageView, this.mDatas.get(i2).Dx().awe);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.awh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YC;

        private a(int i) {
            this.YC = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.awh.eS(this.YC);
        }
    }
}
