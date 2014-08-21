package com.baidu.tieba.guide;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
class f {
    final /* synthetic */ e a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private TbImageView g;
    private LinearLayout h;

    public View a() {
        return this.b;
    }

    public f(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.a = eVar;
        com.baidu.adp.lib.e.b a = com.baidu.adp.lib.e.b.a();
        context = eVar.a;
        this.b = a.a(context, com.baidu.tieba.v.new_user_rich_item, null);
        this.b.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(e eVar, View view) {
        this.a = eVar;
        this.b = view;
        b();
    }

    public void b() {
        this.c = (TextView) this.b.findViewById(com.baidu.tieba.u.tv_fname);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.u.tv_cdesc);
        this.f = (ImageView) this.b.findViewById(com.baidu.tieba.u.iv_like);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.u.tv_slogan);
        this.g = (TbImageView) this.b.findViewById(com.baidu.tieba.u.img);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.ll_like);
    }

    public void a(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.f;
            context2 = this.a.a;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.t.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.f;
        context = this.a.a;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.t.icon_startpage2_add_ba_s));
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
