package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VerticalScrollNumberView extends LinearLayout {
    private int cBD;
    private int cBE;
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
        this.mTextWidth = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds30);
        this.mTextHeight = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds40);
        this.cBD = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds2);
        this.cBE = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds8);
    }

    public void setData(int i) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int i2 = i < 0 ? 0 : i;
        String valueOf = String.valueOf(i2 <= 999999999 ? i2 : 999999999);
        for (int i3 = 0; i3 != valueOf.length(); i3++) {
            kV(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i3))));
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
            if (getChildAt(childCount) instanceof ScrollTextView) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i4 == 2) {
                    layoutParams.setMargins(this.cBE, 0, 0, 0);
                    i4 = 0;
                } else {
                    layoutParams.setMargins(this.cBD, 0, 0, 0);
                    i4++;
                }
                getChildAt(childCount).setLayoutParams(layoutParams);
            }
        }
    }

    private void kV(String str) {
        ScrollTextView scrollTextView = new ScrollTextView(this.mContext);
        scrollTextView.setText(str);
        scrollTextView.setGravity(17);
        com.baidu.tbadk.core.util.aj.j(scrollTextView, d.f.lottery_number_bg);
        com.baidu.tbadk.core.util.aj.i(scrollTextView, d.C0080d.cp_cont_g);
        scrollTextView.setTextSize(0, getResources().getDimension(d.e.ds28));
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
