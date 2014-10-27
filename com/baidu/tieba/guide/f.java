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
    private ImageView aKX;
    private TbImageView aKY;
    private LinearLayout aKZ;
    final /* synthetic */ e aLa;
    private TextView apR;
    private TextView avZ;
    private TextView awc;
    private View mView;

    public View getView() {
        return this.mView;
    }

    public f(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.aLa = eVar;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        context = eVar.mContext;
        this.mView = ek.inflate(context, com.baidu.tieba.w.new_user_rich_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(e eVar, View view) {
        this.aLa = eVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.avZ = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.apR = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.aKX = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.awc = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_slogan);
        this.aKY = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.img);
        this.aKZ = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void cs(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.aKX;
            context2 = this.aLa.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.aKX;
        context = this.aLa.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        initUI();
        this.aKZ.setOnClickListener(onClickListener);
        this.aKZ.setTag(card);
        this.avZ.setText(card.getFname());
        this.apR.setText(card.getCdesc());
        this.awc.setText(card.getSlogan());
        this.aKY.setTag(card.getAvatar());
        cs(card.getIs_like() != 0);
    }
}
