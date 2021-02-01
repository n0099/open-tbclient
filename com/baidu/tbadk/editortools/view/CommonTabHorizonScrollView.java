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
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int bLv;
    private LinearLayout.LayoutParams ert;
    private DeskLinearLayout fES;
    private CommonTabWidgetView.a fET;
    private int fEU;
    private int fEV;
    private TextView fEW;
    private View fEX;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLv = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLv = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bLv = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fES = new DeskLinearLayout(getContext());
        this.fES.setOrientation(0);
        this.fES.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fES.setBaselineAligned(false);
        addView(this.fES);
        this.fEU = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fEV = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fES.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.ert = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.fEX = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fEX.setLayoutParams(layoutParams);
        ap.setBackgroundResource(this.fEX, R.drawable.bg_expression_bar_n);
        this.fES.addView(this.fEX);
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
        ap.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.fEV, this.fEU, this.fEV, this.fEU);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ap.setImageResource(tbImageView, bVar.fER);
        linearLayout.setOnClickListener(new a(this.fES.getChildCount() - 1));
        this.fES.addView(linearLayout, this.fES.getChildCount() - 1, this.ert);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bLv) {
            if (this.bLv != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fES.getChildAt(this.bLv);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bLv).bCw().fER);
                } else {
                    return;
                }
            }
            this.bLv = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fES.getChildAt(this.bLv);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ap.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bLv).bCw().fEQ);
            }
        }
    }

    public void reset() {
        this.bLv = -1;
        this.fES.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.fEW != null) {
            ap.setBackgroundResource(this.fEW, R.drawable.icon_news_head_prompt_one, i);
            this.fEW.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.fES.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.fES.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bLv) {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bCw().fEQ, i);
                        } else {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bCw().fER, i);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.fET = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int mTabIndex;

        private a(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.fET.ri(this.mTabIndex);
        }
    }
}
