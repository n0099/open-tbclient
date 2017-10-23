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
    private ImageView cWH;
    private TextView cWI;
    private TextView cWJ;
    private Context mContext;

    public g(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_not_login_layout, (ViewGroup) this, true);
        this.mContext = context;
        this.cWH = (ImageView) inflate.findViewById(d.h.iv_concern_not_login_emotion_pic);
        this.cWI = (TextView) inflate.findViewById(d.h.tv_concern_you_not_login);
        this.cWJ = (TextView) inflate.findViewById(d.h.tv_concern_login_and_see_more);
        this.cWJ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.tv_concern_login_and_see_more) {
            ax.aT(this.mContext);
            HomePageStatic.cUu = true;
        }
    }

    public void onChangeSkinType(int i) {
        aj.c(this.cWH, d.g.pic_jinba_login);
        aj.i(this.cWI, d.e.cp_cont_b);
        aj.i(this.cWJ, d.e.cp_cont_i);
        aj.j(this.cWJ, d.g.btn_all_blue);
    }
}
