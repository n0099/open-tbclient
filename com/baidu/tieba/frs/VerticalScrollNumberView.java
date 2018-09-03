package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class VerticalScrollNumberView extends LinearLayout {
    private int dqa;
    private int dqb;
    private int dqc;
    private int dqd;
    private Context mContext;

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
        this.dqa = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds30);
        this.dqb = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds40);
        this.dqc = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds2);
        this.dqd = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds8);
    }

    public void setData(int i) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int i2 = i < 0 ? 0 : i;
        String valueOf = String.valueOf(i2 <= 999999999 ? i2 : 999999999);
        for (int i3 = 0; i3 != valueOf.length(); i3++) {
            my(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i3))));
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
            if (getChildAt(childCount) instanceof ScrollTextView) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i4 == 2) {
                    layoutParams.setMargins(this.dqd, 0, 0, 0);
                    i4 = 0;
                } else {
                    layoutParams.setMargins(this.dqc, 0, 0, 0);
                    i4++;
                }
                getChildAt(childCount).setLayoutParams(layoutParams);
            }
        }
    }

    private void my(String str) {
        ScrollTextView scrollTextView = new ScrollTextView(this.mContext);
        scrollTextView.setText(str);
        scrollTextView.setGravity(17);
        com.baidu.tbadk.core.util.am.i(scrollTextView, f.C0146f.lottery_number_bg);
        com.baidu.tbadk.core.util.am.h(scrollTextView, f.d.cp_cont_g);
        scrollTextView.setTextSize(0, getResources().getDimension(f.e.ds28));
        scrollTextView.setTypeface(null, 1);
        scrollTextView.setMinLines(1);
        scrollTextView.setMaxLines(1);
        scrollTextView.setContinuousScrolling(false);
        scrollTextView.setSpeed((float) ((Math.random() * 5.0d) + 10.0d));
        scrollTextView.setWidth(this.dqa);
        scrollTextView.setHeight(this.dqb);
        addView(scrollTextView);
    }
}
