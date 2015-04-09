package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class h {
    private View LO;
    private GoodGridView aPi;
    private ImageView aPj;

    public h(Context context) {
        this.LO = null;
        this.aPi = null;
        this.aPj = null;
        this.LO = com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.dialog_good, null);
        this.aPi = (GoodGridView) this.LO.findViewById(com.baidu.tieba.v.good_gridview);
        this.aPj = (ImageView) this.LO.findViewById(com.baidu.tieba.v.divider_line);
    }

    public void a(aw awVar) {
        this.aPi.setAdapter((ListAdapter) awVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.aPi.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LO;
    }

    public void changeSkinType(int i) {
        ba.j(this.aPi, com.baidu.tieba.s.cp_bg_line_d);
        ba.i(this.aPj, com.baidu.tieba.s.frs_goodheader_line_end);
    }
}
