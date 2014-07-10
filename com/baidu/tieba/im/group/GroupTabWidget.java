package com.baidu.tieba.im.group;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.aa;
import com.baidu.tieba.v;
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
        LayoutInflater.from(getContext()).inflate(w.group_tab_widget, this);
        this.d = findViewById(v.blank);
        this.e = (ImageView) findViewById(v.left_icon);
        this.f = (TextView) findViewById(v.text);
        this.g = (ImageView) findViewById(v.right_arraw);
        this.h = (ImageView) findViewById(v.diver_top);
        this.i = (ImageView) findViewById(v.diver_top_px);
        this.j = (ImageView) findViewById(v.diver_bottom_px);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, aa.groupTabWidget);
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
}
