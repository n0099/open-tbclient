package com.baidu.tieba.guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
final class f {
    final /* synthetic */ d a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private LinearLayout h;

    public final View a() {
        return this.b;
    }

    public f(d dVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.a = dVar;
        context = dVar.a;
        this.b = LayoutInflater.from(context).inflate(com.baidu.tieba.a.i.new_user_rich_item, (ViewGroup) null);
        this.b.setTag(Integer.valueOf(card.getFid()));
        b();
        this.h.setOnClickListener(onClickListener);
        this.h.setTag(card);
        this.c.setText(card.getFname());
        this.d.setText(card.getCdesc());
        this.e.setText(card.getSlogan());
        this.g.setTag(card.getAvatar());
        a(card.getIs_like() != 0);
    }

    public f(d dVar, View view) {
        this.a = dVar;
        this.b = view;
        b();
    }

    private void b() {
        this.c = (TextView) this.b.findViewById(com.baidu.tieba.a.h.tv_fname);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.a.h.tv_cdesc);
        this.f = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.iv_like);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.a.h.tv_slogan);
        this.g = (ImageView) this.b.findViewById(com.baidu.tieba.a.h.img);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.ll_like);
    }

    public final void a(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.f;
            context2 = this.a.a;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.f;
        context = this.a.a;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.a.g.icon_startpage2_add_ba_s));
    }
}
