package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.ck;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class k {
    private View MQ;
    private GoodGridView brn;
    private ImageView bro;

    public k(Context context) {
        this.MQ = null;
        this.brn = null;
        this.bro = null;
        this.MQ = LayoutInflater.from(context).inflate(t.h.dialog_good, (ViewGroup) null);
        this.brn = (GoodGridView) this.MQ.findViewById(t.g.good_gridview);
        this.bro = (ImageView) this.MQ.findViewById(t.g.divider_line);
    }

    public void a(ck ckVar) {
        this.brn.setAdapter((ListAdapter) ckVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.brn.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.MQ;
    }

    public void changeSkinType(int i) {
        ar.l(this.brn, t.d.cp_bg_line_d);
        ar.k(this.bro, t.d.frs_goodheader_line_end);
    }
}
