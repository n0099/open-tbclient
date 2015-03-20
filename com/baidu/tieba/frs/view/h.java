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
    private View LM;
    private GoodGridView aOR;
    private ImageView aOS;

    public h(Context context) {
        this.LM = null;
        this.aOR = null;
        this.aOS = null;
        this.LM = com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.dialog_good, null);
        this.aOR = (GoodGridView) this.LM.findViewById(com.baidu.tieba.v.good_gridview);
        this.aOS = (ImageView) this.LM.findViewById(com.baidu.tieba.v.divider_line);
    }

    public void a(aw awVar) {
        this.aOR.setAdapter((ListAdapter) awVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.aOR.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LM;
    }

    public void changeSkinType(int i) {
        ba.j(this.aOR, com.baidu.tieba.s.cp_bg_line_d);
        ba.i(this.aOS, com.baidu.tieba.s.frs_goodheader_line_end);
    }
}
