package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f aCH;
    private int aCI;
    private CommonTabWidgetView.a aCJ;
    private LinearLayout.LayoutParams aCK;
    private int aCL;
    private int aCM;
    private TextView aCN;
    private View aCO;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCI = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCI = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aCI = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aCH = new f(getContext());
        this.aCH.setOrientation(0);
        this.aCH.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aCH.setBaselineAligned(false);
        addView(this.aCH);
        this.aCL = getResources().getDimensionPixelSize(w.f.ds8);
        this.aCM = getResources().getDimensionPixelSize(w.f.ds10);
        this.aCH.setPadding(0, getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
        this.aCK = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1);
        this.aCO = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aCO.setLayoutParams(layoutParams);
        as.j(this.aCO, w.g.bg_expression_bar_n);
        this.aCH.addView(this.aCO);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0046b c0046b) {
        if (c0046b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        as.j(linearLayout, w.g.bg_expression_bar);
        tbImageView.setPadding(this.aCM, this.aCL, this.aCM, this.aCL);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        as.c(tbImageView, c0046b.aCG);
        linearLayout.setOnClickListener(new a(this, this.aCH.getChildCount() - 1, null));
        this.aCH.addView(linearLayout, this.aCH.getChildCount() - 1, this.aCK);
        return tbImageView;
    }

    public void c(b.C0046b c0046b) {
        b(c0046b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aCI) {
            if (this.aCI != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aCH.getChildAt(this.aCI);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aCI).DG().aCG);
                } else {
                    return;
                }
            }
            this.aCI = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aCH.getChildAt(this.aCI);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                as.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aCI).DG().aCF);
            }
        }
    }

    public void reset() {
        this.aCI = -1;
        this.aCH.removeAllViews();
    }

    public void dp(int i) {
        if (this.aCN != null) {
            as.j(this.aCN, w.g.icon_news_head_prompt_one);
            this.aCN.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aCH.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aCH.getChildAt(i2);
            if (childAt != null) {
                as.j(childAt, w.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aCI) {
                            as.c(tbImageView, this.mDatas.get(i2).DG().aCF);
                        } else {
                            as.c(tbImageView, this.mDatas.get(i2).DG().aCG);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aCJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int adZ;

        private a(int i) {
            this.adZ = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aCJ.eP(this.adZ);
        }
    }
}
