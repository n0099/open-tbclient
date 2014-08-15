package com.baidu.tieba.im.live.mylive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class MyLiveNoDataView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private Button d;
    private int e;

    public MyLiveNoDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        a(context);
    }

    public MyLiveNoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        a(context);
    }

    public MyLiveNoDataView(Context context) {
        super(context);
        this.e = -1;
        a(context);
    }

    public void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(v.im_frsgroup_guide, (ViewGroup) null));
        this.a = (ImageView) findViewById(u.guide_img);
        this.b = (TextView) findViewById(u.guide_tip1);
        this.c = (TextView) findViewById(u.guide_tip2);
        this.d = (Button) findViewById(u.guide_btn);
        this.d.setVisibility(0);
        this.d.setOnClickListener(new k(this));
    }

    private void setSkinType(int i) {
        this.e = i;
    }

    private int getSkinType() {
        return this.e;
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
                this.a.setBackgroundResource(t.pic_emotion05_1);
                this.b.setTextColor(getResources().getColor(r.cp_cont_d_1));
                this.c.setTextColor(getResources().getColor(r.cp_cont_b_1));
            } else {
                this.a.setBackgroundResource(t.pic_emotion05);
                this.b.setTextColor(getResources().getColor(r.cp_cont_d));
                this.c.setTextColor(getResources().getColor(r.cp_cont_b));
            }
            if (this.e == 1) {
                this.d.setTextColor(getResources().getColor(r.cp_cont_g_1));
                this.d.setBackgroundResource(t.btn_appdownload_1);
                return;
            }
            this.d.setTextColor(getResources().getColor(r.cp_cont_g));
            this.d.setBackgroundResource(t.btn_appdownload);
        }
    }

    public void c() {
        setVisibility(0);
        this.b.setText(x.mylive_mylive_nodata);
        this.c.setText(x.mylive_toinfo_nodata);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
    }

    public void d() {
        setVisibility(0);
        this.b.setText(x.mylive_mymark_nodata);
        this.c.setText(x.mylive_toinfo_nodata);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
    }

    public void e() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void f() {
        e();
    }

    public void g() {
        this.e = -1;
        this.a.setBackgroundDrawable(null);
    }

    public int getClickBtnTop() {
        if (this.d != null) {
            return this.d.getTop();
        }
        return -1;
    }
}
