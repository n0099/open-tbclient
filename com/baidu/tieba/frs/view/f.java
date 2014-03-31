package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tieba.frs.bm;
/* loaded from: classes.dex */
public final class f {
    private View a;
    private GoodGridView b;
    private ImageView c;

    public f(Activity activity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = LayoutInflater.from(activity).inflate(com.baidu.tieba.a.i.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.a.findViewById(com.baidu.tieba.a.h.good_gridview);
        this.c = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.divider_line);
    }

    public final void a(bm bmVar) {
        this.b.setAdapter((ListAdapter) bmVar);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public final View a() {
        return this.a;
    }

    public final void a(int i) {
        if (i == 1) {
            this.b.setBackgroundResource(com.baidu.tieba.a.e.frs_goodheader_bg_1);
            this.c.setBackgroundResource(com.baidu.tieba.a.e.frs_goodheader_line_end_1);
            return;
        }
        this.b.setBackgroundDrawable(null);
        this.b.setBackgroundColor(-1);
        this.c.setBackgroundResource(com.baidu.tieba.a.e.frs_goodheader_line_end);
    }
}
