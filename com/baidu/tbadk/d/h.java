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
    private ImageView acg;
    private TextView ach;
    private TextView aci;
    private TextView acj;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, x.net_refresh_view_layout, null));
        this.acg = (ImageView) this.aca.findViewById(w.net_refresh_image);
        this.ach = (TextView) this.aca.findViewById(w.net_refresh_desc);
        this.aci = (TextView) this.aca.findViewById(w.net_refresh_title);
        this.acj = (TextView) this.aca.findViewById(w.net_refresh_button);
        this.acj.setOnClickListener(onClickListener);
        wu();
    }

    public void es(String str) {
        this.ach.setText(str);
    }

    public void wu() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        bc.c(this.acg, v.net_refresh_emotion);
        bc.a(this.ach, t.cp_cont_d, 1, skinType);
        bc.a(this.aci, t.cp_cont_b, 1, skinType);
        bc.a(this.acj, t.cp_cont_g, 1, skinType);
        bc.c(this.acj, v.btn_appdownload, skinType);
        bc.j(this.aca, t.cp_bg_line_d);
    }
}
