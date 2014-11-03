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
    private ImageView aLl;
    private TbImageView aLm;
    private LinearLayout aLn;
    final /* synthetic */ e aLo;
    private TextView aqa;
    private TextView awi;
    private TextView awl;
    private View mView;

    public View getView() {
        return this.mView;
    }

    public f(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.aLo = eVar;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        context = eVar.mContext;
        this.mView = ek.inflate(context, com.baidu.tieba.w.new_user_rich_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(e eVar, View view) {
        this.aLo = eVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.awi = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_fname);
        this.aqa = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_cdesc);
        this.aLl = (ImageView) this.mView.findViewById(com.baidu.tieba.v.iv_like);
        this.awl = (TextView) this.mView.findViewById(com.baidu.tieba.v.tv_slogan);
        this.aLm = (TbImageView) this.mView.findViewById(com.baidu.tieba.v.img);
        this.aLn = (LinearLayout) this.mView.findViewById(com.baidu.tieba.v.ll_like);
    }

    public void cs(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.aLl;
            context2 = this.aLo.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.aLl;
        context = this.aLo.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.u.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        initUI();
        this.aLn.setOnClickListener(onClickListener);
        this.aLn.setTag(card);
        this.awi.setText(card.getFname());
        this.aqa.setText(card.getCdesc());
        this.awl.setText(card.getSlogan());
        this.aLm.setTag(card.getAvatar());
        cs(card.getIs_like() != 0);
    }
}
