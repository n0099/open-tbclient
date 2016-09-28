package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class VerticalScrollNumberView extends LinearLayout {
    private int bUi;
    private int bUj;
    private Context mContext;
    private int mTextHeight;
    private int mTextWidth;

    public VerticalScrollNumberView(Context context) {
        super(context);
        this.mContext = null;
        init(context);
    }

    public VerticalScrollNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        init(context);
    }

    public VerticalScrollNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mTextWidth = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30);
        this.mTextHeight = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40);
        this.bUi = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2);
        this.bUj = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
    }

    public void setData(int i) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int i2 = i < 0 ? 0 : i;
        String valueOf = String.valueOf(i2 <= 999999999 ? i2 : 999999999);
        for (int i3 = 0; i3 != valueOf.length(); i3++) {
            jU(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i3))));
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
            if (getChildAt(childCount) instanceof ScrollTextView) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i4 == 2) {
                    layoutParams.setMargins(this.bUj, 0, 0, 0);
                    i4 = 0;
                } else {
                    layoutParams.setMargins(this.bUi, 0, 0, 0);
                    i4++;
                }
                getChildAt(childCount).setLayoutParams(layoutParams);
            }
        }
    }

    private void jU(String str) {
        ScrollTextView scrollTextView = new ScrollTextView(this.mContext);
        scrollTextView.setText(str);
        scrollTextView.setGravity(17);
        com.baidu.tbadk.core.util.av.k(scrollTextView, r.f.lottery_number_bg);
        com.baidu.tbadk.core.util.av.j((View) scrollTextView, r.d.cp_cont_g);
        scrollTextView.setTextSize(0, getResources().getDimension(r.e.ds28));
        scrollTextView.setTypeface(null, 1);
        scrollTextView.setMinLines(1);
        scrollTextView.setMaxLines(1);
        scrollTextView.setContinuousScrolling(false);
        scrollTextView.setSpeed((float) ((Math.random() * 5.0d) + 10.0d));
        scrollTextView.setWidth(this.mTextWidth);
        scrollTextView.setHeight(this.mTextHeight);
        addView(scrollTextView);
    }
}
