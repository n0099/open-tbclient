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
    private GoodGridView aEY;
    private ImageView aEZ;
    private View agI;

    public e(Activity activity) {
        this.agI = null;
        this.aEY = null;
        this.aEZ = null;
        this.agI = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.dialog_good, null);
        this.aEY = (GoodGridView) this.agI.findViewById(com.baidu.tieba.v.good_gridview);
        this.aEZ = (ImageView) this.agI.findViewById(com.baidu.tieba.v.divider_line);
    }

    public void a(bn bnVar) {
        this.aEY.setAdapter((ListAdapter) bnVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.aEY.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.agI;
    }

    public void changeSkinType(int i) {
        aw.i(this.aEY, com.baidu.tieba.s.frs_goodheader_bg);
        aw.h(this.aEZ, com.baidu.tieba.s.frs_goodheader_line_end);
    }
}
