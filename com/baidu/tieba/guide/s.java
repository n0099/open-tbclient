package com.baidu.tieba.guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
class s {
    private ImageView aKX;
    private LinearLayout aKZ;
    final /* synthetic */ r aLH;
    TextView apR;
    TextView avZ;
    View mView;

    public View getView() {
        return this.mView;
    }

    public s(r rVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.aLH = rVar;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        context = rVar.mContext;
        this.mView = ek.inflate(context, com.baidu.tieba.w.new_user_text_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public s(r rVar, View view) {
        this.aLH = rVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.avZ = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.apR = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.aKX = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.aKZ = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void cs(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.aKX;
            context2 = this.aLH.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.aKX;
        context = this.aLH.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Drawable drawable;
        Context context;
        Context context2;
        initUI();
        this.aKZ.setOnClickListener(onClickListener);
        this.aKZ.setTag(card);
        this.avZ.setText(card.getFname());
        if (card.getOrder() == 1) {
            context2 = this.aLH.mContext;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context = this.aLH.mContext;
            drawable = context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.avZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.apR.setText(card.getCdesc());
        cs(card.getIs_like() != 0);
    }
}
