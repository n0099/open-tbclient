package com.baidu.tieba.game.classify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c {
    TbClipImageView aJq;
    TextView aJr;
    TextView aJs;
    ImageView aJt;
    View aJu;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(c cVar) {
        this();
    }

    public void HZ() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        aw.a(this.aJt, u.icon_dredge_arrow_r_n, skinType);
        aw.b(this.aJr, s.cp_cont_b, 1);
        aw.b(this.aJs, s.cp_cont_d, 1);
        aw.d(this.aJu, s.cp_bg_line_b, skinType);
    }
}
