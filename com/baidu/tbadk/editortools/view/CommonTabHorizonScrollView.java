package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private View arA;
    private e art;
    private int aru;
    private CommonTabWidgetView.a arv;
    private LinearLayout.LayoutParams arw;
    private int arx;
    private int ary;
    private TextView arz;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aru = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aru = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aru = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.art = new e(getContext());
        this.art.setOrientation(0);
        this.art.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.art.setBaselineAligned(false);
        addView(this.art);
        this.arx = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.ary = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.art.setPadding(0, getResources().getDimensionPixelSize(i.d.default_gap_6), 0, 0);
        this.arw = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1);
        this.arA = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.arA.setLayoutParams(layoutParams);
        an.i(this.arA, i.e.bg_expression_bar_n);
        this.art.addView(this.arA);
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
        an.i(linearLayout, i.e.bg_expression_bar);
        tbImageView.setPadding(this.ary, this.arx, this.ary, this.arx);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        an.c(tbImageView, bVar.ars);
        linearLayout.setOnClickListener(new a(this, this.art.getChildCount() - 1, null));
        this.art.addView(linearLayout, this.art.getChildCount() - 1, this.arw);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aru) {
            if (this.aru != -1) {
                LinearLayout linearLayout = (LinearLayout) this.art.getChildAt(this.aru);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aru).BD().ars);
                } else {
                    return;
                }
            }
            this.aru = i;
            LinearLayout linearLayout2 = (LinearLayout) this.art.getChildAt(this.aru);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                an.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aru).BD().arr);
            }
        }
    }

    public void reset() {
        this.aru = -1;
        this.art.removeAllViews();
    }

    public void cP(int i) {
        if (this.arz != null) {
            an.i((View) this.arz, i.e.icon_news_head_prompt_one);
            this.arz.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.art.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.art.getChildAt(i2);
            if (childAt != null) {
                an.i(childAt, i.e.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aru) {
                            an.c(tbImageView, this.mDatas.get(i2).BD().arr);
                        } else {
                            an.c(tbImageView, this.mDatas.get(i2).BD().ars);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.arv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YX;

        private a(int i) {
            this.YX = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.arv.ei(this.YX);
        }
    }
}
