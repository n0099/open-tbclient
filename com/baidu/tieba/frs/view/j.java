package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class j {
    private View LR;
    private GoodGridView bdm;
    private ImageView bdn;

    public j(Context context) {
        this.LR = null;
        this.bdm = null;
        this.bdn = null;
        this.LR = LayoutInflater.from(context).inflate(i.g.dialog_good, (ViewGroup) null);
        this.bdm = (GoodGridView) this.LR.findViewById(i.f.good_gridview);
        this.bdn = (ImageView) this.LR.findViewById(i.f.divider_line);
    }

    public void a(bf bfVar) {
        this.bdm.setAdapter((ListAdapter) bfVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bdm.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LR;
    }

    public void changeSkinType(int i) {
        al.i(this.bdm, i.c.cp_bg_line_d);
        al.h(this.bdn, i.c.frs_goodheader_line_end);
    }
}
