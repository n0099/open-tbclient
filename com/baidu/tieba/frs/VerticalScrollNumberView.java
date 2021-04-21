package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import org.apache.commons.codec.digest4util.Sha2Crypt;
/* loaded from: classes4.dex */
public class VerticalScrollNumberView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f15793e;

    /* renamed from: f  reason: collision with root package name */
    public int f15794f;

    /* renamed from: g  reason: collision with root package name */
    public int f15795g;

    /* renamed from: h  reason: collision with root package name */
    public int f15796h;
    public int i;

    public VerticalScrollNumberView(Context context) {
        super(context);
        this.f15793e = null;
        b(context);
    }

    public final void a(String str) {
        ScrollTextView scrollTextView = new ScrollTextView(this.f15793e);
        scrollTextView.setText(str);
        scrollTextView.setGravity(17);
        SkinManager.setBackgroundResource(scrollTextView, R.drawable.lottery_number_bg);
        SkinManager.setViewTextColor(scrollTextView, R.color.CAM_X0111);
        scrollTextView.setTextSize(0, getResources().getDimension(R.dimen.ds28));
        scrollTextView.setTypeface(null, 1);
        scrollTextView.setMinLines(1);
        scrollTextView.setMaxLines(1);
        scrollTextView.setContinuousScrolling(false);
        scrollTextView.setSpeed((float) ((Math.random() * 5.0d) + 10.0d));
        scrollTextView.setWidth(this.f15794f);
        scrollTextView.setHeight(this.f15795g);
        addView(scrollTextView);
    }

    public final void b(Context context) {
        this.f15793e = context;
        this.f15794f = l.g(context, R.dimen.ds30);
        this.f15795g = l.g(this.f15793e, R.dimen.ds40);
        this.f15796h = l.g(this.f15793e, R.dimen.ds2);
        this.i = l.g(this.f15793e, R.dimen.ds8);
    }

    public void setData(int i) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > 999999999) {
            i = Sha2Crypt.ROUNDS_MAX;
        }
        String valueOf = String.valueOf(i);
        for (int i2 = 0; i2 != valueOf.length(); i2++) {
            a(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i2))));
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
            if (getChildAt(childCount) instanceof ScrollTextView) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i3 == 2) {
                    layoutParams.setMargins(this.i, 0, 0, 0);
                    i3 = 0;
                } else {
                    layoutParams.setMargins(this.f15796h, 0, 0, 0);
                    i3++;
                }
                getChildAt(childCount).setLayoutParams(layoutParams);
            }
        }
    }

    public VerticalScrollNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15793e = null;
        b(context);
    }

    public VerticalScrollNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15793e = null;
        b(context);
    }
}
