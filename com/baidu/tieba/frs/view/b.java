package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private View a;
    private GoodGridView b;
    private ImageView c;

    public b(Activity activity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = LayoutInflater.from(activity).inflate(w.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.a.findViewById(v.good_gridview);
        this.c = (ImageView) this.a.findViewById(v.divider_line);
    }

    public void a(bs bsVar) {
        this.b.setAdapter((ListAdapter) bsVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        if (i == 1) {
            this.b.setBackgroundResource(s.frs_goodheader_bg_1);
            this.c.setBackgroundResource(s.frs_goodheader_line_end_1);
            return;
        }
        this.b.setBackgroundDrawable(null);
        this.b.setBackgroundColor(-1);
        this.c.setBackgroundResource(s.frs_goodheader_line_end);
    }
}
