package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class b {
    private View a;
    private GoodGridView b;
    private ImageView c;

    public b(Activity activity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = LayoutInflater.from(activity).inflate(s.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.a.findViewById(r.good_gridview);
        this.c = (ImageView) this.a.findViewById(r.divider_line);
    }

    public void a(br brVar) {
        this.b.setAdapter((ListAdapter) brVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        if (i == 1) {
            this.b.setBackgroundResource(com.baidu.tieba.o.frs_goodheader_bg_1);
            this.c.setBackgroundResource(com.baidu.tieba.o.frs_goodheader_line_end_1);
            return;
        }
        this.b.setBackgroundDrawable(null);
        this.b.setBackgroundColor(-1);
        this.c.setBackgroundResource(com.baidu.tieba.o.frs_goodheader_line_end);
    }
}
