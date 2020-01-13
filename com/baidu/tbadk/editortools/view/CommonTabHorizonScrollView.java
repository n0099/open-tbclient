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
    private LinearLayout.LayoutParams cuk;
    private DeskLinearLayout dvo;
    private CommonTabWidgetView.a dvp;
    private int dvq;
    private int dvr;
    private TextView dvs;
    private View dvt;
    private int mCurrentIndex;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dvo = new DeskLinearLayout(getContext());
        this.dvo.setOrientation(0);
        this.dvo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dvo.setBaselineAligned(false);
        addView(this.dvo);
        this.dvq = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dvr = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dvo.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.cuk = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.dvt = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dvt.setLayoutParams(layoutParams);
        am.setBackgroundResource(this.dvt, R.drawable.bg_expression_bar_n);
        this.dvo.addView(this.dvt);
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
        tbImageView.setPadding(this.dvr, this.dvq, this.dvr, this.dvq);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.setImageResource(tbImageView, bVar.dvn);
        linearLayout.setOnClickListener(new a(this.dvo.getChildCount() - 1));
        this.dvo.addView(linearLayout, this.dvo.getChildCount() - 1, this.cuk);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dvo.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).aNa().dvn);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dvo.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).aNa().dvm);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dvo.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.dvs != null) {
            am.setBackgroundResource(this.dvs, R.drawable.icon_news_head_prompt_one);
            this.dvs.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.dvo.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.dvo.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).aNa().dvm);
                        } else {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).aNa().dvn);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.dvp = aVar;
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
            CommonTabHorizonScrollView.this.dvp.mi(this.mTabIndex);
        }
    }
}
