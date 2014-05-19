package com.baidu.tieba.im.group;

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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class GroupTabWidget extends RelativeLayout {
    boolean a;
    int b;
    int c;
    private View d;
    private ImageView e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private int[] k;

    public GroupTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context) {
        super(context);
        this.k = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
    }

    public TextView getTextView() {
        return this.f;
    }

    public ImageView getRightIcon() {
        return this.g;
    }

    public void setBlankVisibility(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    public void setLineTopVisibility(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }

    public void setLineTopPxVisibility(boolean z) {
        this.i.setVisibility(z ? 0 : 8);
    }

    public void setLineBottomPxVisibility(boolean z) {
        this.j.setVisibility(z ? 0 : 8);
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(s.group_tab_widget, this);
        this.d = findViewById(r.blank);
        this.e = (ImageView) findViewById(r.left_icon);
        this.f = (TextView) findViewById(r.text);
        this.g = (ImageView) findViewById(r.right_arraw);
        this.h = (ImageView) findViewById(r.diver_top);
        this.i = (ImageView) findViewById(r.diver_top_px);
        this.j = (ImageView) findViewById(r.diver_bottom_px);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.groupTabWidget);
        this.f.setText(obtainStyledAttributes.getString(1));
        this.e.setImageDrawable(obtainStyledAttributes.getDrawable(0));
        this.k[0] = obtainStyledAttributes.getResourceId(0, 0);
        if (this.k[0] != 0) {
            this.k[1] = com.baidu.tbadk.core.c.a(getResources(), this.k[0]);
        } else {
            this.k[1] = this.k[0];
        }
        obtainStyledAttributes.recycle();
    }

    public void setLeftIconRes(int i) {
        this.k[0] = i;
        if (this.k[0] != 0) {
            this.k[1] = com.baidu.tbadk.core.c.a(getResources(), this.k[0]);
        } else {
            this.k[1] = this.k[0];
        }
        if (1 == TbadkApplication.m252getInst().getSkinType()) {
            this.e.setImageResource(this.k[1]);
        } else {
            this.e.setImageResource(this.k[0]);
        }
    }

    public void setText(String str) {
        this.a = false;
        this.b = 0;
        this.c = 0;
        this.f.setText(str);
    }

    public void a(String str, int i, int i2) {
        boolean z;
        this.a = true;
        this.b = i;
        this.c = i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str.length() > i) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                z = ((BaseActivity) context).getLayoutMode().a();
            } else if (!(context instanceof com.baidu.tbadk.core.e)) {
                z = false;
            } else {
                z = ((com.baidu.tbadk.core.e) getContext()).a().a();
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(z ? getResources().getColor(com.baidu.tieba.o.im_near_group_count_1) : getResources().getColor(com.baidu.tieba.o.im_near_group_count)), i, i2, 33);
        }
        this.f.setText(spannableStringBuilder);
    }

    public void a(int i) {
        if (1 == i) {
            this.e.setImageResource(this.k[1]);
            this.h.setImageResource(com.baidu.tieba.o.cp_bg_line_b_1);
            this.i.setImageResource(com.baidu.tieba.o.cp_bg_line_b_1);
            this.j.setImageResource(com.baidu.tieba.o.cp_bg_line_b_1);
        } else {
            this.e.setImageResource(this.k[0]);
            this.h.setImageResource(com.baidu.tieba.o.cp_bg_line_b);
            this.i.setImageResource(com.baidu.tieba.o.cp_bg_line_b);
            this.j.setImageResource(com.baidu.tieba.o.cp_bg_line_b);
        }
        Context context = getContext();
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).getLayoutMode().a((View) this);
        } else if (context instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) getContext()).a().a((View) this);
        }
        if (this.a) {
            a(this.f.getText().toString(), this.b, this.c);
        }
    }
}
