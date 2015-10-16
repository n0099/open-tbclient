package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class j {
    private View LS;
    private GoodGridView bdr;
    private ImageView bds;

    public j(Context context) {
        this.LS = null;
        this.bdr = null;
        this.bds = null;
        this.LS = LayoutInflater.from(context).inflate(i.g.dialog_good, (ViewGroup) null);
        this.bdr = (GoodGridView) this.LS.findViewById(i.f.good_gridview);
        this.bds = (ImageView) this.LS.findViewById(i.f.divider_line);
    }

    public void a(bp bpVar) {
        this.bdr.setAdapter((ListAdapter) bpVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bdr.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LS;
    }

    public void changeSkinType(int i) {
        an.j(this.bdr, i.c.cp_bg_line_d);
        an.i(this.bds, i.c.frs_goodheader_line_end);
    }
}
