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
    TbClipImageView aJD;
    TextView aJE;
    TextView aJF;
    ImageView aJG;
    View aJH;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(c cVar) {
        this();
    }

    public void Id() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        aw.a(this.aJG, u.icon_dredge_arrow_r_n, skinType);
        aw.b(this.aJE, s.cp_cont_b, 1);
        aw.b(this.aJF, s.cp_cont_d, 1);
        aw.d(this.aJH, s.cp_bg_line_b, skinType);
    }
}
