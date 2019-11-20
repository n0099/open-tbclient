package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int apz;
    private LinearLayout.LayoutParams bIH;
    private DeskLinearLayout cHp;
    private CommonTabWidgetView.a cHq;
    private int cHr;
    private int cHs;
    private TextView cHt;
    private View cHu;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apz = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apz = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.apz = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cHp = new DeskLinearLayout(getContext());
        this.cHp.setOrientation(0);
        this.cHp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cHp.setBaselineAligned(false);
        addView(this.cHp);
        this.cHr = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cHs = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cHp.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.bIH = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.cHu = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cHu.setLayoutParams(layoutParams);
        am.setBackgroundResource(this.cHu, R.drawable.bg_expression_bar_n);
        this.cHp.addView(this.cHu);
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
        am.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.cHs, this.cHr, this.cHs, this.cHr);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.setImageResource(tbImageView, bVar.cHo);
        linearLayout.setOnClickListener(new a(this.cHp.getChildCount() - 1));
        this.cHp.addView(linearLayout, this.cHp.getChildCount() - 1, this.bIH);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.apz) {
            if (this.apz != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cHp.getChildAt(this.apz);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.apz).auY().cHo);
                } else {
                    return;
                }
            }
            this.apz = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cHp.getChildAt(this.apz);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.apz).auY().cHn);
            }
        }
    }

    public void reset() {
        this.apz = -1;
        this.cHp.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.cHt != null) {
            am.setBackgroundResource(this.cHt, R.drawable.icon_news_head_prompt_one);
            this.cHt.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.cHp.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cHp.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.apz) {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).auY().cHn);
                        } else {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).auY().cHo);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.cHq = aVar;
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
            CommonTabHorizonScrollView.this.cHq.jV(this.mTabIndex);
        }
    }
}
