package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class g extends LinearLayout implements View.OnClickListener {
    private ImageView egX;
    private TextView egY;
    private TextView egZ;
    private Context mContext;

    public g(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.egX = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.egY = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.egZ = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.egZ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.tv_concern_login_and_see_more) {
            ay.ba(this.mContext);
            HomePageStatic.efj = true;
        }
    }

    public void onChangeSkinType(int i) {
        aj.c(this.egX, d.f.pic_jinba_login);
        aj.r(this.egY, d.C0141d.cp_cont_b);
        aj.r(this.egZ, d.C0141d.cp_cont_i);
        aj.s(this.egZ, d.f.btn_all_blue);
    }
}
