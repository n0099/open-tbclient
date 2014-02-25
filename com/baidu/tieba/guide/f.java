package com.baidu.tieba.guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f {
    final /* synthetic */ d a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private LinearLayout h;

    public View a() {
        return this.b;
    }

    public f(d dVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.a = dVar;
        context = dVar.a;
        this.b = LayoutInflater.from(context).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
        this.b.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(d dVar, View view) {
        this.a = dVar;
        this.b = view;
        b();
    }

    public void b() {
        this.c = (TextView) this.b.findViewById(R.id.tv_fname);
        this.d = (TextView) this.b.findViewById(R.id.tv_cdesc);
        this.f = (ImageView) this.b.findViewById(R.id.iv_like);
        this.e = (TextView) this.b.findViewById(R.id.tv_slogan);
        this.g = (ImageView) this.b.findViewById(R.id.img);
        this.h = (LinearLayout) this.b.findViewById(R.id.ll_like);
    }

    public void a(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.f;
            context2 = this.a.a;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.f;
        context = this.a.a;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        b();
        this.h.setOnClickListener(onClickListener);
        this.h.setTag(card);
        this.c.setText(card.getFname());
        this.d.setText(card.getCdesc());
        this.e.setText(card.getSlogan());
        this.g.setTag(card.getAvatar());
        a(card.getIs_like() != 0);
    }
}
