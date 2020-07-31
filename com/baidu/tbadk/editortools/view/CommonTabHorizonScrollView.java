package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams dti;
    private DeskLinearLayout eDb;
    private CommonTabWidgetView.a eDc;
    private int eDd;
    private int eDe;
    private TextView eDf;
    private View eDg;
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
        this.eDb = new DeskLinearLayout(getContext());
        this.eDb.setOrientation(0);
        this.eDb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eDb.setBaselineAligned(false);
        addView(this.eDb);
        this.eDd = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.eDe = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eDb.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.dti = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.eDg = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eDg.setLayoutParams(layoutParams);
        ao.setBackgroundResource(this.eDg, R.drawable.bg_expression_bar_n);
        this.eDb.addView(this.eDg);
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
        ao.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.eDe, this.eDd, this.eDe, this.eDd);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ao.setImageResource(tbImageView, bVar.eDa);
        linearLayout.setOnClickListener(new a(this.eDb.getChildCount() - 1));
        this.eDb.addView(linearLayout, this.eDb.getChildCount() - 1, this.dti);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eDb.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).bjS().eDa);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eDb.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ao.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).bjS().eCZ);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.eDb.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.eDf != null) {
            ao.setBackgroundResource(this.eDf, R.drawable.icon_news_head_prompt_one);
            this.eDf.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.eDb.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.eDb.getChildAt(i2);
            if (childAt != null) {
                ao.setBackgroundResource(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            ao.setImageResource(tbImageView, this.mDatas.get(i2).bjS().eCZ);
                        } else {
                            ao.setImageResource(tbImageView, this.mDatas.get(i2).bjS().eDa);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.eDc = aVar;
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
            CommonTabHorizonScrollView.this.eDc.od(this.mTabIndex);
        }
    }
}
