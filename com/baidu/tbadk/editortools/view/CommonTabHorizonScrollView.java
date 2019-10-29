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
    private int apR;
    private LinearLayout.LayoutParams bJy;
    private DeskLinearLayout cIg;
    private CommonTabWidgetView.a cIh;
    private int cIi;
    private int cIj;
    private TextView cIk;
    private View cIl;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apR = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apR = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.apR = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cIg = new DeskLinearLayout(getContext());
        this.cIg.setOrientation(0);
        this.cIg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cIg.setBaselineAligned(false);
        addView(this.cIg);
        this.cIi = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cIj = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cIg.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.bJy = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.cIl = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cIl.setLayoutParams(layoutParams);
        am.setBackgroundResource(this.cIl, R.drawable.bg_expression_bar_n);
        this.cIg.addView(this.cIl);
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
        tbImageView.setPadding(this.cIj, this.cIi, this.cIj, this.cIi);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.setImageResource(tbImageView, bVar.cIf);
        linearLayout.setOnClickListener(new a(this.cIg.getChildCount() - 1));
        this.cIg.addView(linearLayout, this.cIg.getChildCount() - 1, this.bJy);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.apR) {
            if (this.apR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cIg.getChildAt(this.apR);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.apR).ava().cIf);
                } else {
                    return;
                }
            }
            this.apR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cIg.getChildAt(this.apR);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.apR).ava().cIe);
            }
        }
    }

    public void reset() {
        this.apR = -1;
        this.cIg.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.cIk != null) {
            am.setBackgroundResource(this.cIk, R.drawable.icon_news_head_prompt_one);
            this.cIk.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.cIg.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cIg.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.apR) {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).ava().cIe);
                        } else {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).ava().cIf);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.cIh = aVar;
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
            CommonTabHorizonScrollView.this.cIh.jW(this.mTabIndex);
        }
    }
}
