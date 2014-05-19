package com.baidu.tieba.im.live.mylive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class MyLiveNoDataView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private int d;

    public MyLiveNoDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -1;
        a(context);
    }

    public MyLiveNoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        a(context);
    }

    public MyLiveNoDataView(Context context) {
        super(context);
        this.d = -1;
        a(context);
    }

    public void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(s.im_frsgroup_guide, (ViewGroup) null));
        this.a = (ImageView) findViewById(r.guide_img);
        this.b = (TextView) findViewById(r.guide_tip1);
        this.c = (TextView) findViewById(r.guide_tip2);
    }

    private void setSkinType(int i) {
        this.d = i;
    }

    private int getSkinType() {
        return this.d;
    }

    private boolean b(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void a() {
        setVisibility(8);
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void a(int i) {
        if (b(i)) {
            if (i == 1) {
                this.a.setBackgroundResource(q.pic_go_ba_1);
                this.b.setTextColor(-8815226);
                this.c.setTextColor(-8815226);
                return;
            }
            this.a.setBackgroundResource(q.pic_go_ba);
            this.b.setTextColor(-5065030);
            this.c.setTextColor(-5065030);
        }
    }

    public void c() {
        setVisibility(0);
        this.b.setText(u.mylive_mylive_nodata);
        this.c.setText("");
    }

    public void d() {
        setVisibility(0);
        this.b.setText("");
        this.c.setText(u.mylive_mymark_nodata);
    }

    public void e() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void f() {
        e();
    }

    public void g() {
        this.d = -1;
        this.a.setBackgroundDrawable(null);
    }
}
