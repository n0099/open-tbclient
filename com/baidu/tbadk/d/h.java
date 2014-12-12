package com.baidu.tbadk.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class h extends a {
    private ImageView abJ;
    private TextView abK;
    private TextView abL;
    private TextView abM;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, x.net_refresh_view_layout, null));
        this.abJ = (ImageView) this.abD.findViewById(w.net_refresh_image);
        this.abK = (TextView) this.abD.findViewById(w.net_refresh_desc);
        this.abL = (TextView) this.abD.findViewById(w.net_refresh_title);
        this.abM = (TextView) this.abD.findViewById(w.net_refresh_button);
        this.abM.setOnClickListener(onClickListener);
        wc();
    }

    public void es(String str) {
        this.abK.setText(str);
    }

    public void wc() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        ax.c(this.abJ, v.net_refresh_emotion);
        ax.a(this.abK, t.cp_cont_d, 1, skinType);
        ax.a(this.abL, t.cp_cont_b, 1, skinType);
        ax.a(this.abM, t.cp_cont_g, 1, skinType);
        ax.c(this.abM, v.btn_appdownload, skinType);
        ax.j(this.abD, t.cp_bg_line_d);
    }
}
