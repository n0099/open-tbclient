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
    final /* synthetic */ r aLV;
    private ImageView aLl;
    private LinearLayout aLn;
    TextView aqa;
    TextView awi;
    View mView;

    public View getView() {
        return this.mView;
    }

    public s(r rVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.aLV = rVar;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        context = rVar.mContext;
        this.mView = ek.inflate(context, com.baidu.tieba.w.new_user_text_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public s(r rVar, View view) {
        this.aLV = rVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.awi = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.aqa = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.aLl = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.aLn = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void cs(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.aLl;
            context2 = this.aLV.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.aLl;
        context = this.aLV.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Drawable drawable;
        Context context;
        Context context2;
        initUI();
        this.aLn.setOnClickListener(onClickListener);
        this.aLn.setTag(card);
        this.awi.setText(card.getFname());
        if (card.getOrder() == 1) {
            context2 = this.aLV.mContext;
            drawable = context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_rise);
        } else if (card.getOrder() == 2) {
            context = this.aLV.mContext;
            drawable = context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_decline);
        } else {
            drawable = null;
        }
        this.awi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.aqa.setText(card.getCdesc());
        cs(card.getIs_like() != 0);
    }
}
