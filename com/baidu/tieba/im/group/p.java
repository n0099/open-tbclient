package com.baidu.tieba.im.group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class p {
    private View a = LayoutInflater.from(TbadkApplication.m252getInst().getApp().getApplicationContext()).inflate(w.title_view_of_tab_group, (ViewGroup) null);
    private TextView b = (TextView) this.a.findViewById(v.title_view_of_tab_group_text);
    private ImageView c = (ImageView) this.a.findViewById(v.diver_top);
    private ImageView d = (ImageView) this.a.findViewById(v.diver_bottom);

    private p() {
        this.a.setTag(this);
    }

    public static p a(View view) {
        if (view == null) {
            return new p();
        }
        Object tag = view.getTag();
        if (tag != null && (tag instanceof p)) {
            return (p) tag;
        }
        return null;
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        this.b.setText(i);
    }

    public void a(boolean z, boolean z2) {
        this.c.setVisibility(z ? 0 : 8);
        this.d.setVisibility(z2 ? 0 : 8);
    }

    public void b() {
        bc.a(this.b, s.cp_cont_c, 1);
    }
}
