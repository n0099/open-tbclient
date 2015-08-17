package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class j {
    private View LR;
    private GoodGridView bcS;
    private ImageView bcT;

    public j(Context context) {
        this.LR = null;
        this.bcS = null;
        this.bcT = null;
        this.LR = LayoutInflater.from(context).inflate(i.g.dialog_good, (ViewGroup) null);
        this.bcS = (GoodGridView) this.LR.findViewById(i.f.good_gridview);
        this.bcT = (ImageView) this.LR.findViewById(i.f.divider_line);
    }

    public void a(be beVar) {
        this.bcS.setAdapter((ListAdapter) beVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bcS.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LR;
    }

    public void changeSkinType(int i) {
        al.j(this.bcS, i.c.cp_bg_line_d);
        al.i(this.bcT, i.c.frs_goodheader_line_end);
    }
}
