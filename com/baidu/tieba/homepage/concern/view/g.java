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
/* loaded from: classes.dex */
public class g extends LinearLayout implements View.OnClickListener {
    private ImageView dpf;
    private TextView dpg;
    private TextView dph;
    private Context mContext;

    public g(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.dpf = (ImageView) inflate.findViewById(d.g.iv_concern_not_login_emotion_pic);
        this.dpg = (TextView) inflate.findViewById(d.g.tv_concern_you_not_login);
        this.dph = (TextView) inflate.findViewById(d.g.tv_concern_login_and_see_more);
        this.dph.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.tv_concern_login_and_see_more) {
            ax.aS(this.mContext);
            HomePageStatic.dnr = true;
        }
    }

    public void onChangeSkinType(int i) {
        aj.c(this.dpf, d.f.pic_jinba_login);
        aj.i(this.dpg, d.C0096d.cp_cont_b);
        aj.i(this.dph, d.C0096d.cp_cont_i);
        aj.j(this.dph, d.f.btn_all_blue);
    }
}
