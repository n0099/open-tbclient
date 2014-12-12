package com.baidu.tieba.guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class s {
    final /* synthetic */ r aNN;
    private ImageView aNf;
    private LinearLayout aNh;
    TextView avk;
    TextView azp;
    View mView;

    public View getView() {
        return this.mView;
    }

    public s(r rVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.aNN = rVar;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        context = rVar.mContext;
        this.mView = ek.inflate(context, x.new_user_text_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public s(r rVar, View view) {
        this.aNN = rVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.azp = (TextView) this.mView.findViewById(com.baidu.tieba.w.tv_fname);
        this.avk = (TextView) this.mView.findViewById(com.baidu.tieba.w.tv_cdesc);
        this.aNf = (ImageView) this.mView.findViewById(com.baidu.tieba.w.iv_like);
        this.aNh = (LinearLayout) this.mView.findViewById(com.baidu.tieba.w.ll_like);
    }

    public void cg(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.aNf;
            context2 = this.aNN.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.aNf;
        context = this.aNN.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Drawable drawable;
        Context context;
        Context context2;
        initUI();
        this.aNh.setOnClickListener(onClickListener);
        this.aNh.setTag(card);
        this.azp.setText(card.getFname());
        if (card.getOrder() == 1) {
            context2 = this.aNN.mContext;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context = this.aNN.mContext;
            drawable = context.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.azp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.avk.setText(card.getCdesc());
        cg(card.getIs_like() != 0);
    }
}
