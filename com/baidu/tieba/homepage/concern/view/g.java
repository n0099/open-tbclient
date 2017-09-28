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
    private ImageView cWT;
    private TextView cWU;
    private TextView cWV;
    private Context mContext;

    public g(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.cWT = (ImageView) inflate.findViewById(d.h.iv_concern_not_login_emotion_pic);
        this.cWU = (TextView) inflate.findViewById(d.h.tv_concern_you_not_login);
        this.cWV = (TextView) inflate.findViewById(d.h.tv_concern_login_and_see_more);
        this.cWV.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.tv_concern_login_and_see_more) {
            ax.aU(this.mContext);
            HomePageStatic.cUG = true;
        }
    }

    public void onChangeSkinType(int i) {
        aj.c(this.cWT, d.g.pic_jinba_login);
        aj.i(this.cWU, d.e.cp_cont_b);
        aj.i(this.cWV, d.e.cp_cont_i);
        aj.j(this.cWV, d.g.btn_all_blue);
    }
}
