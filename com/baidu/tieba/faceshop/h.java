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
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class h extends Dialog {
    int a;
    private Context b;
    private LayoutInflater c;
    private View d;
    private SpannableString e;
    private TextView f;
    private TextView g;

    public h(Context context, int i) {
        super(context, i);
        this.b = context;
        this.c = LayoutInflater.from(getContext());
    }

    public void a() {
        this.d = this.c.inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.a = TiebaApplication.g().an();
        setContentView(this.d, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(R.dimen.faceshop_buy_dialog_height)));
        setCancelable(false);
        c();
    }

    public void b() {
        ForegroundColorSpan foregroundColorSpan;
        this.d = this.c.inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.a = TiebaApplication.g().an();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.e = new SpannableString(string);
        if (this.a == 1) {
            foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.faceshop_package_price_text_1));
        } else {
            foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.faceshop_package_price_text));
        }
        this.e.setSpan(foregroundColorSpan, 5, string.length(), 33);
        setContentView(this.d, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(R.dimen.faceshop_buy_dialog_fail_height)));
        this.f = (TextView) findViewById(R.id.telphone);
        this.f.setText(this.e);
        this.g = (TextView) findViewById(R.id.confirm);
        this.g.setOnClickListener(new i(this));
        setCancelable(true);
        c();
    }

    private void c() {
        if (this.b instanceof com.baidu.tieba.j) {
            ((com.baidu.tieba.j) this.b).getLayoutMode().a(this.a == 1);
            ((com.baidu.tieba.j) this.b).getLayoutMode().a(this.d);
        }
    }
}
