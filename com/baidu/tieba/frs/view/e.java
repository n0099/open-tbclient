package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class e {
    private GoodGridView aHP;
    private ImageView aHQ;
    private View mParent;

    public e(Context context) {
        this.mParent = null;
        this.aHP = null;
        this.aHQ = null;
        this.mParent = com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.dialog_good, null);
        this.aHP = (GoodGridView) this.mParent.findViewById(com.baidu.tieba.w.good_gridview);
        this.aHQ = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.divider_line);
    }

    public void a(bi biVar) {
        this.aHP.setAdapter((ListAdapter) biVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.aHP.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.mParent;
    }

    public void changeSkinType(int i) {
        bc.j(this.aHP, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.aHQ, com.baidu.tieba.t.frs_goodheader_line_end);
    }
}
