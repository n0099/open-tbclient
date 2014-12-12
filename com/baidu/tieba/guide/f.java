package com.baidu.tieba.guide;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class f {
    private ImageView aNf;
    private TbImageView aNg;
    private LinearLayout aNh;
    final /* synthetic */ e aNi;
    private TextView avk;
    private TextView azp;
    private TextView azs;
    private View mView;

    public View getView() {
        return this.mView;
    }

    public f(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
        Context context;
        this.aNi = eVar;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        context = eVar.mContext;
        this.mView = ek.inflate(context, x.new_user_rich_item, null);
        this.mView.setTag(Integer.valueOf(card.getFid()));
        a(card, onClickListener);
    }

    public f(e eVar, View view) {
        this.aNi = eVar;
        this.mView = view;
        initUI();
    }

    public void initUI() {
        this.azp = (TextView) this.mView.findViewById(com.baidu.tieba.w.tv_fname);
        this.avk = (TextView) this.mView.findViewById(com.baidu.tieba.w.tv_cdesc);
        this.aNf = (ImageView) this.mView.findViewById(com.baidu.tieba.w.iv_like);
        this.azs = (TextView) this.mView.findViewById(com.baidu.tieba.w.tv_slogan);
        this.aNg = (TbImageView) this.mView.findViewById(com.baidu.tieba.w.img);
        this.aNh = (LinearLayout) this.mView.findViewById(com.baidu.tieba.w.ll_like);
    }

    public void cg(boolean z) {
        Context context;
        Context context2;
        if (!z) {
            ImageView imageView = this.aNf;
            context2 = this.aNi.mContext;
            imageView.setBackgroundDrawable(context2.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_n));
            return;
        }
        ImageView imageView2 = this.aNf;
        context = this.aNi.mContext;
        imageView2.setBackgroundDrawable(context.getResources().getDrawable(com.baidu.tieba.v.icon_startpage2_add_ba_s));
    }

    private void a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
        initUI();
        this.aNh.setOnClickListener(onClickListener);
        this.aNh.setTag(card);
        this.azp.setText(card.getFname());
        this.avk.setText(card.getCdesc());
        this.azs.setText(card.getSlogan());
        this.aNg.setTag(card.getAvatar());
        cg(card.getIs_like() != 0);
    }
}
