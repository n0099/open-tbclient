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
    private GoodGridView aRu;
    private ImageView aRv;

    public h(Context context) {
        this.LG = null;
        this.aRu = null;
        this.aRv = null;
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.dialog_good, null);
        this.aRu = (GoodGridView) this.LG.findViewById(com.baidu.tieba.q.good_gridview);
        this.aRv = (ImageView) this.LG.findViewById(com.baidu.tieba.q.divider_line);
    }

    public void a(aw awVar) {
        this.aRu.setAdapter((ListAdapter) awVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.aRu.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LG;
    }

    public void changeSkinType(int i) {
        ay.j(this.aRu, com.baidu.tieba.n.cp_bg_line_d);
        ay.i(this.aRv, com.baidu.tieba.n.frs_goodheader_line_end);
    }
}
