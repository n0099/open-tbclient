package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class l {
    private View MW;
    private GoodGridView bwv;
    private ImageView bww;

    public l(Context context) {
        this.MW = null;
        this.bwv = null;
        this.bww = null;
        this.MW = LayoutInflater.from(context).inflate(t.h.dialog_good, (ViewGroup) null);
        this.bwv = (GoodGridView) this.MW.findViewById(t.g.good_gridview);
        this.bww = (ImageView) this.MW.findViewById(t.g.divider_line);
    }

    public void a(cm cmVar) {
        this.bwv.setAdapter((ListAdapter) cmVar);
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        this.bwv.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.MW;
    }

    public void changeSkinType(int i) {
        at.l(this.bwv, t.d.cp_bg_line_d);
        at.k(this.bww, t.d.frs_goodheader_line_end);
    }
}
