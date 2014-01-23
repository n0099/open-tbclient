package com.baidu.tieba.group;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.at;
import com.baidu.tieba.j;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupTabWidget extends RelativeLayout {
    boolean a;
    int b;
    int c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private int[] g;

    public GroupTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context) {
        super(context);
        this.g = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
    }

    public TextView getTextView() {
        return this.e;
    }

    public ImageView getRightIcon() {
        return this.f;
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.group_tab_widget, this);
        this.d = (ImageView) findViewById(R.id.left_icon);
        this.e = (TextView) findViewById(R.id.text);
        this.f = (ImageView) findViewById(R.id.right_arraw);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, at.groupTabWidget);
        this.e.setText(obtainStyledAttributes.getString(1));
        this.d.setImageDrawable(obtainStyledAttributes.getDrawable(0));
        this.g[0] = obtainStyledAttributes.getResourceId(0, 0);
        if (this.g[0] != 0) {
            this.g[1] = com.baidu.tieba.e.a(getResources(), this.g[0]);
        } else {
            this.g[1] = this.g[0];
        }
        obtainStyledAttributes.recycle();
    }

    public void setLeftIconRes(int i) {
        this.g[0] = i;
        if (this.g[0] != 0) {
            this.g[1] = com.baidu.tieba.e.a(getResources(), this.g[0]);
        } else {
            this.g[1] = this.g[0];
        }
        if (1 == TiebaApplication.h().al()) {
            this.d.setImageResource(this.g[1]);
        } else {
            this.d.setImageResource(this.g[0]);
        }
    }

    public void setText(String str) {
        this.a = false;
        this.b = 0;
        this.c = 0;
        this.e.setText(str);
    }

    public void a(String str, int i, int i2) {
        boolean z;
        this.a = true;
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
            this.d.setImageResource(this.g[1]);
        } else {
            this.d.setImageResource(this.g[0]);
        }
        Context context = getContext();
        if (context instanceof j) {
            ((j) context).getLayoutMode().a((View) this);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) getContext()).a().a((View) this);
        }
        if (this.a) {
            a(this.e.getText().toString(), this.b, this.c);
        }
    }
}
