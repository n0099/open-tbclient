package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class VerticalScrollNumberView extends LinearLayout {
    private int fzd;
    private int fze;
    private int fzf;
    private int fzg;
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
        this.fzd = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds30);
        this.fze = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds40);
        this.fzf = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2);
        this.fzg = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8);
    }

    public void setData(int i) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int i2 = i < 0 ? 0 : i;
        String valueOf = String.valueOf(i2 <= 999999999 ? i2 : 999999999);
        for (int i3 = 0; i3 != valueOf.length(); i3++) {
            vQ(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i3))));
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
            if (getChildAt(childCount) instanceof ScrollTextView) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i4 == 2) {
                    layoutParams.setMargins(this.fzg, 0, 0, 0);
                    i4 = 0;
                } else {
                    layoutParams.setMargins(this.fzf, 0, 0, 0);
                    i4++;
                }
                getChildAt(childCount).setLayoutParams(layoutParams);
            }
        }
    }

    private void vQ(String str) {
        ScrollTextView scrollTextView = new ScrollTextView(this.mContext);
        scrollTextView.setText(str);
        scrollTextView.setGravity(17);
        com.baidu.tbadk.core.util.am.setBackgroundResource(scrollTextView, R.drawable.lottery_number_bg);
        com.baidu.tbadk.core.util.am.setViewTextColor(scrollTextView, (int) R.color.cp_cont_g);
        scrollTextView.setTextSize(0, getResources().getDimension(R.dimen.ds28));
        scrollTextView.setTypeface(null, 1);
        scrollTextView.setMinLines(1);
        scrollTextView.setMaxLines(1);
        scrollTextView.setContinuousScrolling(false);
        scrollTextView.setSpeed((float) ((Math.random() * 5.0d) + 10.0d));
        scrollTextView.setWidth(this.fzd);
        scrollTextView.setHeight(this.fze);
        addView(scrollTextView);
    }
}
