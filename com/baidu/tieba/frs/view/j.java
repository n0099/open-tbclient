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
    private View LT;
    private GoodGridView bdW;
    private ImageView bdX;

    public j(Context context) {
        this.LT = null;
        this.bdW = null;
        this.bdX = null;
        this.LT = LayoutInflater.from(context).inflate(i.g.dialog_good, (ViewGroup) null);
        this.bdW = (GoodGridView) this.LT.findViewById(i.f.good_gridview);
        this.bdX = (ImageView) this.LT.findViewById(i.f.divider_line);
    }

    public void a(bp bpVar) {
        this.bdW.setAdapter((ListAdapter) bpVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bdW.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.LT;
    }

    public void changeSkinType(int i) {
        an.j(this.bdW, i.c.cp_bg_line_d);
        an.i(this.bdX, i.c.frs_goodheader_line_end);
    }
}
