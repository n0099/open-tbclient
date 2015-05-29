package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class h {
    private View LG;
    private GoodGridView aRt;
    private ImageView aRu;

    public h(Context context) {
        this.LG = null;
        this.aRt = null;
        this.aRu = null;
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.dialog_good, null);
        this.aRt = (GoodGridView) this.LG.findViewById(com.baidu.tieba.q.good_gridview);
        this.aRu = (ImageView) this.LG.findViewById(com.baidu.tieba.q.divider_line);
    }

    public void a(aw awVar) {
        this.aRt.setAdapter((ListAdapter) awVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.aRt.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LG;
    }

    public void changeSkinType(int i) {
        ay.j(this.aRt, com.baidu.tieba.n.cp_bg_line_d);
        ay.i(this.aRu, com.baidu.tieba.n.frs_goodheader_line_end);
    }
}
