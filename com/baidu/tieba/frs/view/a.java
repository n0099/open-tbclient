package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    View a;
    private View b;
    private FrameLayout c;
    private TextView d;
    private Context e;

    public a(View view, Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.e = context;
        this.a = view;
        this.b = this.a.findViewById(r.frs_header_divider_fortune);
        this.c = (FrameLayout) this.a.findViewById(r.frs_fortune_layout);
        this.d = (TextView) this.a.findViewById(r.frs_header_fortune_arrow);
        this.d.setText("");
    }

    public void a(String str) {
        this.d.setText(String.format(this.e.getResources().getString(u.frs_fu_text), str));
    }

    public void a() {
        this.b.setVisibility(0);
        this.c.setVisibility(0);
    }

    public void b() {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    public void a(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public boolean a(View view) {
        return view != null && view.equals(this.c);
    }
}
