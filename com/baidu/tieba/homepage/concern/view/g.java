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
    private ImageView ehn;
    private TextView eho;
    private TextView ehp;
    private Context mContext;

    public g(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.ehn = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.eho = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.ehp = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.ehp.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.tv_concern_login_and_see_more) {
            ay.ba(this.mContext);
            HomePageStatic.efz = true;
        }
    }

    public void onChangeSkinType(int i) {
        aj.c(this.ehn, d.f.pic_jinba_login);
        aj.r(this.eho, d.C0141d.cp_cont_b);
        aj.r(this.ehp, d.C0141d.cp_cont_i);
        aj.s(this.ehp, d.f.btn_all_blue);
    }
}
