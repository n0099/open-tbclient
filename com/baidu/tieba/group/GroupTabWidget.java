package com.baidu.tieba.group;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.au;
import com.baidu.tieba.e;
import com.baidu.tieba.j;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupTabWidget extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    boolean f1428a;
    int b;
    int c;
    private ImageView d;
    private TextView e;
    private int[] f;

    public GroupTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new int[2];
        this.f1428a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new int[2];
        this.f1428a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context) {
        super(context);
        this.f = new int[2];
        this.f1428a = false;
        this.b = 0;
        this.c = 0;
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.group_tab_widget, this);
        this.d = (ImageView) findViewById(R.id.left_icon);
        this.e = (TextView) findViewById(R.id.text);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, au.groupTabWidget);
        this.e.setText(obtainStyledAttributes.getString(1));
        this.d.setImageDrawable(obtainStyledAttributes.getDrawable(0));
        this.f[0] = obtainStyledAttributes.getResourceId(0, 0);
        this.f[1] = e.a(getResources(), this.f[0]);
        obtainStyledAttributes.recycle();
    }

    public void setText(String str) {
        this.f1428a = false;
        this.b = 0;
        this.c = 0;
        this.e.setText(str);
    }

    public void a(String str, int i, int i2) {
        boolean z;
        this.f1428a = true;
        this.b = i;
        this.c = i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str.length() > i) {
            Context context = getContext();
            if (context instanceof j) {
                z = ((j) context).getLayoutMode().a();
            } else if (!(context instanceof BaseFragmentActivity)) {
                z = false;
            } else {
                z = ((BaseFragmentActivity) getContext()).a().a();
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(z ? getResources().getColor(R.color.im_near_group_count_1) : getResources().getColor(R.color.im_near_group_count)), i, i2, 33);
        }
        this.e.setText(spannableStringBuilder);
    }

    public void a(int i) {
        if (1 == i) {
            this.d.setImageResource(this.f[1]);
        } else {
            this.d.setImageResource(this.f[0]);
        }
        Context context = getContext();
        if (context instanceof j) {
            ((j) context).getLayoutMode().a(this);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) getContext()).a().a(this);
        }
        if (this.f1428a) {
            a(this.e.getText().toString(), this.b, this.c);
        }
    }
}
