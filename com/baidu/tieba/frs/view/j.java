package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class j {
    private View LR;
    private GoodGridView bdg;
    private ImageView bdh;

    public j(Context context) {
        this.LR = null;
        this.bdg = null;
        this.bdh = null;
        this.LR = LayoutInflater.from(context).inflate(i.g.dialog_good, (ViewGroup) null);
        this.bdg = (GoodGridView) this.LR.findViewById(i.f.good_gridview);
        this.bdh = (ImageView) this.LR.findViewById(i.f.divider_line);
    }

    public void a(bp bpVar) {
        this.bdg.setAdapter((ListAdapter) bpVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bdg.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LR;
    }

    public void changeSkinType(int i) {
        am.j(this.bdg, i.c.cp_bg_line_d);
        am.i(this.bdh, i.c.frs_goodheader_line_end);
    }
}
