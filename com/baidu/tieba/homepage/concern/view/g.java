package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class g extends LinearLayout implements View.OnClickListener {
    private ImageView ebs;
    private TextView ebt;
    private TextView ebu;
    private Context mContext;

    public g(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.ebs = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.ebt = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.ebu = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.ebu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.tv_concern_login_and_see_more) {
            ax.be(this.mContext);
            HomePageStatic.dZD = true;
        }
    }

    public void onChangeSkinType(int i) {
        aj.c(this.ebs, d.f.pic_jinba_login);
        aj.r(this.ebt, d.C0108d.cp_cont_b);
        aj.r(this.ebu, d.C0108d.cp_cont_i);
        aj.s(this.ebu, d.f.btn_all_blue);
    }
}
