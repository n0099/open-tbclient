package com.baidu.tbadk.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class h extends a {
    private ImageView acd;
    private TextView ace;
    private TextView acf;
    private TextView acg;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, x.net_refresh_view_layout, null));
        this.acd = (ImageView) this.abX.findViewById(w.net_refresh_image);
        this.ace = (TextView) this.abX.findViewById(w.net_refresh_desc);
        this.acf = (TextView) this.abX.findViewById(w.net_refresh_title);
        this.acg = (TextView) this.abX.findViewById(w.net_refresh_button);
        this.acg.setOnClickListener(onClickListener);
        wo();
    }

    public void ep(String str) {
        this.ace.setText(str);
    }

    public void wo() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        bc.c(this.acd, v.net_refresh_emotion);
        bc.a(this.ace, t.cp_cont_d, 1, skinType);
        bc.a(this.acf, t.cp_cont_b, 1, skinType);
        bc.a(this.acg, t.cp_cont_g, 1, skinType);
        bc.c(this.acg, v.btn_appdownload, skinType);
        bc.j(this.abX, t.cp_bg_line_d);
    }
}
