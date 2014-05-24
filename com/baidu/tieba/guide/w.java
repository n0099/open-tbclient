package com.baidu.tieba.guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
class w {
    View a;
    TextView b;
    TextView c;
    final /* synthetic */ v d;
    private ImageView e;
    private LinearLayout f;

    public View a() {
        return this.a;
    }

    public w(v vVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.d = vVar;
        context = vVar.a;
        this.a = LayoutInflater.from(context).inflate(com.baidu.tieba.w.new_user_text_item, (ViewGroup) null);
        this.a.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public w(v vVar, View view) {
        this.d = vVar;
        this.a = view;
        b();
    }

    public void b() {
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.v.tv_fname);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.e = (ImageView) this.a.findViewById(com.baidu.tieba.v.iv_like);
        this.f = (LinearLayout) this.a.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void a(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.e;
            context2 = this.d.a;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.e;
        context = this.d.a;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Drawable drawable;
        Context context;
        Context context2;
        b();
        this.f.setOnClickListener(onClickListener);
        this.f.setTag(card);
        this.b.setText(card.getFname());
        if (card.getOrder() == 1) {
            context2 = this.d.a;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context = this.d.a;
            drawable = context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.c.setText(card.getCdesc());
        a(card.getIs_like() != 0);
    }
}
