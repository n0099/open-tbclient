package com.baidu.tieba.faceshop;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class v extends Dialog {
    int a;
    private Context b;
    private LayoutInflater c;
    private View d;
    private SpannableString e;
    private TextView f;
    private TextView g;

    public v(Context context, int i) {
        super(context, i);
        this.b = context;
        this.c = LayoutInflater.from(getContext());
    }

    public void a() {
        this.d = this.c.inflate(com.baidu.tieba.v.face_buy_loading, (ViewGroup) null);
        this.a = TbadkApplication.m252getInst().getSkinType();
        setContentView(this.d, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_height)));
        setCancelable(false);
        c();
    }

    public void b() {
        ForegroundColorSpan foregroundColorSpan;
        this.d = this.c.inflate(com.baidu.tieba.v.face_buy_fail, (ViewGroup) null);
        this.a = TbadkApplication.m252getInst().getSkinType();
        String string = getContext().getResources().getString(com.baidu.tieba.x.query_buy_fail_tel);
        this.e = new SpannableString(string);
        if (this.a == 1) {
            foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(com.baidu.tieba.r.faceshop_package_price_text_1));
        } else {
            foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(com.baidu.tieba.r.faceshop_package_price_text));
        }
        this.e.setSpan(foregroundColorSpan, 5, string.length(), 33);
        setContentView(this.d, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_fail_height)));
        this.f = (TextView) findViewById(com.baidu.tieba.u.telphone);
        this.f.setText(this.e);
        this.g = (TextView) findViewById(com.baidu.tieba.u.confirm);
        this.g.setOnClickListener(new w(this));
        setCancelable(true);
        c();
    }

    private void c() {
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).getLayoutMode().a(this.a == 1);
            ((BaseActivity) this.b).getLayoutMode().a(this.d);
        }
    }
}
