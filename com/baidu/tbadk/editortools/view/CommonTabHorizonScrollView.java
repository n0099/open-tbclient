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
    private c aDs;
    private int aDt;
    private CommonTabWidgetView.a aDu;
    private LinearLayout.LayoutParams aDv;
    private int aDw;
    private int aDx;
    private TextView aDy;
    private View aDz;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDt = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDt = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aDt = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aDs = new c(getContext());
        this.aDs.setOrientation(0);
        this.aDs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aDs.setBaselineAligned(false);
        addView(this.aDs);
        this.aDw = getResources().getDimensionPixelSize(d.f.ds8);
        this.aDx = getResources().getDimensionPixelSize(d.f.ds10);
        this.aDs.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aDv = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aDz = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aDz.setLayoutParams(layoutParams);
        aj.j(this.aDz, d.g.bg_expression_bar_n);
        this.aDs.addView(this.aDz);
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
        aj.j(linearLayout, d.g.bg_expression_bar);
        tbImageView.setPadding(this.aDx, this.aDw, this.aDx, this.aDw);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aDr);
        linearLayout.setOnClickListener(new a(this.aDs.getChildCount() - 1));
        this.aDs.addView(linearLayout, this.aDs.getChildCount() - 1, this.aDv);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aDt) {
            if (this.aDt != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aDs.getChildAt(this.aDt);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aDt).Dv().aDr);
                } else {
                    return;
                }
            }
            this.aDt = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aDs.getChildAt(this.aDt);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aDt).Dv().aDq);
            }
        }
    }

    public void reset() {
        this.aDt = -1;
        this.aDs.removeAllViews();
    }

    public void dD(int i) {
        if (this.aDy != null) {
            aj.j(this.aDy, d.g.icon_news_head_prompt_one);
            this.aDy.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aDs.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aDs.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aDt) {
                            aj.c(tbImageView, this.mDatas.get(i2).Dv().aDq);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Dv().aDr);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aDu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aem;

        private a(int i) {
            this.aem = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aDu.fc(this.aem);
        }
    }
}
