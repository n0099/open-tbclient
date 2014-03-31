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
final class v {
    View a;
    TextView b;
    TextView c;
    final /* synthetic */ u d;
    private ImageView e;
    private LinearLayout f;

    public v(u uVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        Drawable drawable;
        Context context2;
        Context context3;
        this.d = uVar;
        context = uVar.a;
        this.a = LayoutInflater.from(context).inflate(com.baidu.tieba.a.i.new_user_text_item, (ViewGroup) null);
        this.a.setTag(Integer.valueOf(card.getFid()));
        a();
        this.f.setOnClickListener(onClickListener);
        this.f.setTag(card);
        this.b.setText(card.getFname());
        if (card.getOrder() == 1) {
            context3 = this.d.a;
            drawable = context3.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context2 = this.d.a;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.c.setText(card.getCdesc());
        a(card.getIs_like() != 0);
    }

    public v(u uVar, View view) {
        this.d = uVar;
        this.a = view;
        a();
    }

    private void a() {
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.a.h.tv_fname);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.a.h.tv_cdesc);
        this.e = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.iv_like);
        this.f = (LinearLayout) this.a.findViewById(com.baidu.tieba.a.h.ll_like);
    }

    public final void a(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.e;
            context2 = this.d.a;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.e;
        context = this.d.a;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_s));
    }
}
