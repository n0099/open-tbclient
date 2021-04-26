package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import org.apache.commons.codec.digest4util.Sha2Crypt;
/* loaded from: classes4.dex */
public class VerticalScrollNumberView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f15972e;

    /* renamed from: f  reason: collision with root package name */
    public int f15973f;

    /* renamed from: g  reason: collision with root package name */
    public int f15974g;

    /* renamed from: h  reason: collision with root package name */
    public int f15975h;

    /* renamed from: i  reason: collision with root package name */
    public int f15976i;

    public VerticalScrollNumberView(Context context) {
        super(context);
        this.f15972e = null;
        b(context);
    }

    public final void a(String str) {
        ScrollTextView scrollTextView = new ScrollTextView(this.f15972e);
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
        scrollTextView.setWidth(this.f15973f);
        scrollTextView.setHeight(this.f15974g);
        addView(scrollTextView);
    }

    public final void b(Context context) {
        this.f15972e = context;
        this.f15973f = l.g(context, R.dimen.ds30);
        this.f15974g = l.g(this.f15972e, R.dimen.ds40);
        this.f15975h = l.g(this.f15972e, R.dimen.ds2);
        this.f15976i = l.g(this.f15972e, R.dimen.ds8);
    }

    public void setData(int i2) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 999999999) {
            i2 = Sha2Crypt.ROUNDS_MAX;
        }
        String valueOf = String.valueOf(i2);
        for (int i3 = 0; i3 != valueOf.length(); i3++) {
            a(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i3))));
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
            if (getChildAt(childCount) instanceof ScrollTextView) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i4 == 2) {
                    layoutParams.setMargins(this.f15976i, 0, 0, 0);
                    i4 = 0;
                } else {
                    layoutParams.setMargins(this.f15975h, 0, 0, 0);
                    i4++;
                }
                getChildAt(childCount).setLayoutParams(layoutParams);
            }
        }
    }

    public VerticalScrollNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15972e = null;
        b(context);
    }

    public VerticalScrollNumberView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15972e = null;
        b(context);
    }
}
