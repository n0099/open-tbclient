package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class e {
    private GoodGridView aGF;
    private ImageView aGG;
    private View mParent;

    public e(Context context) {
        this.mParent = null;
        this.aGF = null;
        this.aGG = null;
        this.mParent = com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.dialog_good, null);
        this.aGF = (GoodGridView) this.mParent.findViewById(com.baidu.tieba.w.good_gridview);
        this.aGG = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.divider_line);
    }

    public void a(bj bjVar) {
        this.aGF.setAdapter((ListAdapter) bjVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.aGF.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.mParent;
    }

    public void changeSkinType(int i) {
        ax.j(this.aGF, com.baidu.tieba.t.cp_bg_line_d);
        ax.i(this.aGG, com.baidu.tieba.t.frs_goodheader_line_end);
    }
}
