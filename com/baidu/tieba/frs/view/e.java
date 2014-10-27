package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.bn;
/* loaded from: classes.dex */
public class e {
    private GoodGridView aEO;
    private ImageView aEP;
    private View agA;

    public e(Activity activity) {
        this.agA = null;
        this.aEO = null;
        this.aEP = null;
        this.agA = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.dialog_good, null);
        this.aEO = (GoodGridView) this.agA.findViewById(com.baidu.tieba.v.good_gridview);
        this.aEP = (ImageView) this.agA.findViewById(com.baidu.tieba.v.divider_line);
    }

    public void a(bn bnVar) {
        this.aEO.setAdapter((ListAdapter) bnVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.aEO.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.agA;
    }

    public void changeSkinType(int i) {
        aw.i(this.aEO, com.baidu.tieba.s.frs_goodheader_bg);
        aw.h(this.aEP, com.baidu.tieba.s.frs_goodheader_line_end);
    }
}
