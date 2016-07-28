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
    private f aud;
    private int aue;
    private CommonTabWidgetView.a auf;
    private LinearLayout.LayoutParams aug;
    private int auh;
    private int aui;
    private TextView auj;
    private View auk;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aue = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aue = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aue = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aud = new f(getContext());
        this.aud.setOrientation(0);
        this.aud.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aud.setBaselineAligned(false);
        addView(this.aud);
        this.auh = getResources().getDimensionPixelSize(u.e.ds8);
        this.aui = getResources().getDimensionPixelSize(u.e.ds10);
        this.aud.setPadding(0, getResources().getDimensionPixelSize(u.e.ds10), 0, 0);
        this.aug = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds106), -1);
        this.auk = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.auk.setLayoutParams(layoutParams);
        av.k(this.auk, u.f.bg_expression_bar_n);
        this.aud.addView(this.auk);
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
        av.k(linearLayout, u.f.bg_expression_bar);
        tbImageView.setPadding(this.aui, this.auh, this.aui, this.auh);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        av.c(tbImageView, c0042b.auc);
        linearLayout.setOnClickListener(new a(this, this.aud.getChildCount() - 1, null));
        this.aud.addView(linearLayout, this.aud.getChildCount() - 1, this.aug);
        return tbImageView;
    }

    public void c(b.C0042b c0042b) {
        b(c0042b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aue) {
            if (this.aue != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aud.getChildAt(this.aue);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aue).Cu().auc);
                } else {
                    return;
                }
            }
            this.aue = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aud.getChildAt(this.aue);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                av.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aue).Cu().aub);
            }
        }
    }

    public void reset() {
        this.aue = -1;
        this.aud.removeAllViews();
    }

    public void cX(int i) {
        if (this.auj != null) {
            av.k(this.auj, u.f.icon_news_head_prompt_one);
            this.auj.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aud.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aud.getChildAt(i2);
            if (childAt != null) {
                av.k(childAt, u.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aue) {
                            av.c(tbImageView, this.mDatas.get(i2).Cu().aub);
                        } else {
                            av.c(tbImageView, this.mDatas.get(i2).Cu().auc);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.auf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Wv;

        private a(int i) {
            this.Wv = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.auf.eA(this.Wv);
        }
    }
}
