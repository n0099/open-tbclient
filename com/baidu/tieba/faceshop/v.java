package com.baidu.tieba.faceshop;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class v extends Dialog {
    int a;
    private Context b;
    private View c;
    private SpannableString d;
    private TextView e;
    private TextView f;

    public v(Context context, int i) {
        super(context, i);
        this.b = context;
    }

    public void a() {
        this.c = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.face_buy_loading, null);
        this.a = TbadkApplication.m252getInst().getSkinType();
        setContentView(this.c, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_height)));
        setCancelable(false);
        c();
    }

    public void b() {
        ForegroundColorSpan foregroundColorSpan;
        this.c = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.face_buy_fail, null);
        this.a = TbadkApplication.m252getInst().getSkinType();
        String string = getContext().getResources().getString(com.baidu.tieba.x.query_buy_fail_tel);
        this.d = new SpannableString(string);
        if (this.a == 1) {
            foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(com.baidu.tieba.r.faceshop_package_price_text_1));
        } else {
            foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(com.baidu.tieba.r.faceshop_package_price_text));
        }
        this.d.setSpan(foregroundColorSpan, 5, string.length(), 33);
        setContentView(this.c, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_buy_dialog_fail_height)));
        this.e = (TextView) findViewById(com.baidu.tieba.u.telphone);
        this.e.setText(this.d);
        this.f = (TextView) findViewById(com.baidu.tieba.u.confirm);
        this.f.setOnClickListener(new w(this));
        setCancelable(true);
        c();
    }

    private void c() {
        if (this.b instanceof BaseActivity) {
            ((BaseActivity) this.b).getLayoutMode().a(this.a == 1);
            ((BaseActivity) this.b).getLayoutMode().a(this.c);
        }
    }
}
