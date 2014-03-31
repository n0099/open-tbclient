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
import com.baidu.tbadk.TbadkApplication;
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
    private int[] j;

    public GroupTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new int[2];
        this.a = false;
        this.b = 0;
        this.c = 0;
        a(attributeSet);
    }

    public GroupTabWidget(Context context) {
        super(context);
        this.j = new int[2];
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

    public void setLineBottomVisibility(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }

    public void setLineBottomPxVisibility(boolean z) {
        this.i.setVisibility(z ? 0 : 8);
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(com.baidu.tieba.im.i.group_tab_widget, this);
        this.d = findViewById(com.baidu.tieba.im.h.blank);
        this.e = (ImageView) findViewById(com.baidu.tieba.im.h.left_icon);
        this.f = (TextView) findViewById(com.baidu.tieba.im.h.text);
        this.g = (ImageView) findViewById(com.baidu.tieba.im.h.right_arraw);
        this.h = (ImageView) findViewById(com.baidu.tieba.im.h.diver_bottom);
        this.i = (ImageView) findViewById(com.baidu.tieba.im.h.diver_bottom_px);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.baidu.tieba.im.l.groupTabWidget);
        this.f.setText(obtainStyledAttributes.getString(1));
        this.e.setImageDrawable(obtainStyledAttributes.getDrawable(0));
        this.j[0] = obtainStyledAttributes.getResourceId(0, 0);
        if (this.j[0] != 0) {
            this.j[1] = com.baidu.tbadk.core.c.a(getResources(), this.j[0]);
        } else {
            this.j[1] = this.j[0];
        }
        obtainStyledAttributes.recycle();
    }

    public void setLeftIconRes(int i) {
        this.j[0] = i;
        if (this.j[0] != 0) {
            this.j[1] = com.baidu.tbadk.core.c.a(getResources(), this.j[0]);
        } else {
            this.j[1] = this.j[0];
        }
        if (1 == TbadkApplication.j().l()) {
            this.e.setImageResource(this.j[1]);
        } else {
            this.e.setImageResource(this.j[0]);
        }
    }

    public void setText(String str) {
        this.a = false;
        this.b = 0;
        this.c = 0;
        this.f.setText(str);
    }

    public final void a(String str, int i, int i2) {
        boolean z;
        this.a = true;
        this.b = i;
        this.c = i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str.length() > i) {
            Context context = getContext();
            if (context instanceof com.baidu.tbadk.a) {
                z = ((com.baidu.tbadk.a) context).getLayoutMode().a();
            } else if (!(context instanceof com.baidu.tbadk.core.e)) {
                z = false;
            } else {
                z = ((com.baidu.tbadk.core.e) getContext()).b().a();
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(z ? getResources().getColor(com.baidu.tieba.im.e.im_near_group_count_1) : getResources().getColor(com.baidu.tieba.im.e.im_near_group_count)), i, i2, 33);
        }
        this.f.setText(spannableStringBuilder);
    }

    public final void a(int i) {
        if (1 == i) {
            this.e.setImageResource(this.j[1]);
            this.h.setImageResource(com.baidu.tieba.im.e.cp_bg_line_b_1);
            this.i.setImageResource(com.baidu.tieba.im.e.cp_bg_line_b_1);
        } else {
            this.e.setImageResource(this.j[0]);
            this.h.setImageResource(com.baidu.tieba.im.e.cp_bg_line_b);
            this.i.setImageResource(com.baidu.tieba.im.e.cp_bg_line_b);
        }
        Context context = getContext();
        if (context instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) context).getLayoutMode().a(this);
        } else if (context instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) getContext()).b().a(this);
        }
        if (this.a) {
            a(this.f.getText().toString(), this.b, this.c);
        }
    }
}
