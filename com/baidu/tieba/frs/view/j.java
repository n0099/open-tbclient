package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class j {
    private View Mk;
    private GoodGridView bkC;
    private ImageView bkD;

    public j(Context context) {
        this.Mk = null;
        this.bkC = null;
        this.bkD = null;
        this.Mk = LayoutInflater.from(context).inflate(n.g.dialog_good, (ViewGroup) null);
        this.bkC = (GoodGridView) this.Mk.findViewById(n.f.good_gridview);
        this.bkD = (ImageView) this.Mk.findViewById(n.f.divider_line);
    }

    public void a(ca caVar) {
        this.bkC.setAdapter((ListAdapter) caVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bkC.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.Mk;
    }

    public void changeSkinType(int i) {
        as.j(this.bkC, n.c.cp_bg_line_d);
        as.i(this.bkD, n.c.frs_goodheader_line_end);
    }
}
