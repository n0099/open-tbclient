package com.baidu.tieba.im.group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
final class p {
    private View a = LayoutInflater.from(TbadkApplication.j().b().getApplicationContext()).inflate(com.baidu.tieba.im.i.title_view_of_tab_group, (ViewGroup) null);
    private TextView b = (TextView) this.a.findViewById(com.baidu.tieba.im.h.title_view_of_tab_group_text);
    private ImageView c = (ImageView) this.a.findViewById(com.baidu.tieba.im.h.diver_top);
    private ImageView d = (ImageView) this.a.findViewById(com.baidu.tieba.im.h.diver_bottom);

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

    public final View a() {
        return this.a;
    }

    public final void a(int i) {
        this.b.setText(i);
    }

    public final void a(boolean z, boolean z2) {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public final void b() {
        ba.a(this.b, com.baidu.tieba.im.e.cp_cont_c, 1);
    }
}
